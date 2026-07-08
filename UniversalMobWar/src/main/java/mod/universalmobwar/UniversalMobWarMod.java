package mod.universalmobwar;

import mod.universalmobwar.command.KitCommand;
import mod.universalmobwar.command.MobWarCommand;
import mod.universalmobwar.config.ModConfig;
import mod.universalmobwar.entity.MobWarlordEntity;
import mod.universalmobwar.goal.StalemateBreakerGoal;
import mod.universalmobwar.goal.UniversalTargetGoal;
import mod.universalmobwar.mixin.MobEntityAccessor;
import mod.universalmobwar.net.UmwRequiredClientPayload;
import mod.universalmobwar.net.UmwServerEnchantCompat;
import mod.universalmobwar.system.AllianceSystem;
import mod.universalmobwar.system.NaturalSpawnLimiter;
import mod.universalmobwar.system.EntityCleanupSystem;
import mod.universalmobwar.system.ScalingSystem;
import mod.universalmobwar.util.TargetingUtil;
import mod.universalmobwar.util.OperationScheduler;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.ChatFormatting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import java.util.function.Supplier;

/**
 * Universal Mob War - main initializer (MC 26.2, official mappings).
 *
 * NOTE: Custom gamerules were removed in the 26.2 port. GameRules became a
 * registry-driven system with no runtime change-callbacks, and the two rules we
 * had (ignoreSameSpecies / neutralMobsAggressive) only mirrored ModConfig values.
 * ModConfig is now the single source of truth and is fully live-editable in-game.
 */
public class UniversalMobWarMod implements ModInitializer {

	public static final String MODID = "universalmobwar";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	// Safety-net payload: an empty C2S payload so we can register a global receiver
	// that swallows unknown/malformed payloads instead of hard-disconnecting.
	public static final CustomPacketPayload.Type<UmwSafetyNetPayload> UMW_SAFETYNET_ID =
		new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath(MODID, "umw_safetynet"));

	public record UmwSafetyNetPayload() implements CustomPacketPayload {
		public static final StreamCodec<RegistryFriendlyByteBuf, UmwSafetyNetPayload> CODEC =
			StreamCodec.unit(new UmwSafetyNetPayload());

		@Override
		public Type<? extends CustomPacketPayload> type() {
			return UMW_SAFETYNET_ID;
		}
	}

	// Mob Warlord boss entity type.
	private static final ResourceKey<EntityType<?>> MOB_WARLORD_KEY = ResourceKey.create(
		Registries.ENTITY_TYPE,
		Identifier.fromNamespaceAndPath(MODID, "mob_warlord")
	);

	public static final EntityType<MobWarlordEntity> MOB_WARLORD = Registry.register(
		BuiltInRegistries.ENTITY_TYPE,
		MOB_WARLORD_KEY,
		EntityType.Builder.of(MobWarlordEntity::new, MobCategory.MONSTER)
			.sized(1.2f, 3.6f) // Large boss: 1.2m wide x 3.6m tall
			.clientTrackingRange(64)
			.build(MOB_WARLORD_KEY)
	);

	// Vanilla "Spawn Eggs" creative tab key (constant holders were removed in 26.2).
	private static final ResourceKey<CreativeModeTab> SPAWN_EGGS_TAB = ResourceKey.create(
		Registries.CREATIVE_MODE_TAB,
		Identifier.withDefaultNamespace("spawn_eggs")
	);

	// Mob Warlord spawn egg (26.2: SpawnEggItem no longer takes tint colors; tint is data/model driven).
	public static final Item MOB_WARLORD_SPAWN_EGG = Registry.register(
		BuiltInRegistries.ITEM,
		Identifier.fromNamespaceAndPath(MODID, "mob_warlord_spawn_egg"),
		new SpawnEggItem(new Item.Properties()
			.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "mob_warlord_spawn_egg"))))
	);

	@Override
	public void onInitialize() {
		// Register the S2C "required client" payload so the server can verify the client has this mod.
		try {
			PayloadTypeRegistry.playS2C().register(UmwRequiredClientPayload.ID, UmwRequiredClientPayload.CODEC);
		} catch (IllegalArgumentException alreadyRegistered) {
			// Tolerate double-init in dev / hot reload.
		}

		// Register the C2S safety-net payload.
		try {
			PayloadTypeRegistry.playC2S().register(UMW_SAFETYNET_ID, UmwSafetyNetPayload.CODEC);
		} catch (IllegalArgumentException alreadyRegistered) {
			// Tolerate double-init.
		}

		// Global receiver to swallow unknown/malformed payloads and avoid disconnects.
		ServerPlayNetworking.registerGlobalReceiver(UMW_SAFETYNET_ID, (payload, context) ->
			runSafely("SAFETY_NET_PAYLOAD", () ->
				LOGGER.warn("[UMW] Ignored unknown or malformed network payload from {}.",
					context.player().getName().getString())));

		// Register and load config.
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
		ModConfig.getInstance();

		UmwServerEnchantCompat.init();

		// Register Mob Warlord attributes.
		FabricDefaultAttributeRegistry.register(MOB_WARLORD, MobWarlordEntity.createMobWarlordAttributes());

		// Add spawn egg to the vanilla "Spawn Eggs" creative tab.
		CreativeModeTabEvents.modifyOutputEvent(SPAWN_EGGS_TAB).register(output ->
			output.accept(MOB_WARLORD_SPAWN_EGG));

		// Register commands.
		CommandRegistrationCallback.EVENT.register(MobWarCommand::register);
		CommandRegistrationCallback.EVENT.register(KitCommand::register);

		// Welcome message + required-mod gate on join.
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) ->
			runSafely("JOIN welcome message", () -> {
				if (!ServerPlayNetworking.canSend(handler.player, UmwRequiredClientPayload.ID)) {
					handler.disconnect(Component.literal("Universal Mob War is required to join this server."));
					return;
				}
				handler.player.sendSystemMessage(Component.literal(""));
				handler.player.sendSystemMessage(
					Component.literal("\u2550".repeat(51))
						.withStyle(style -> style.withColor(ChatFormatting.GOLD).withBold(true)));
				handler.player.sendSystemMessage(
					Component.literal("    UNIVERSAL MOB WAR")
						.withStyle(style -> style.withColor(ChatFormatting.RED).withBold(true)));
				handler.player.sendSystemMessage(
					Component.literal("\u2550".repeat(51))
						.withStyle(style -> style.withColor(ChatFormatting.GOLD).withBold(true)));
			}));

		// Attach targeting goal to every Mob loaded into a server world.
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) ->
			runSafely("ENTITY_LOAD for " + entity.getType().getDescriptionId(), () -> {
				if (world instanceof ServerLevel serverWorld && entity instanceof Mob mob) {
					NaturalSpawnLimiter.onMobLoaded(serverWorld, mob.getTags().contains("umw_natural_spawned"));
				}

				if (!(entity instanceof Mob mob)) return;
				if (!ModConfig.getInstance().isTargetingActive()) return;

				String mobId = mob.getType().getDescriptionId();
				if (ModConfig.getInstance().isMobExcluded(mobId)) return;

				GoalSelector targetSelector = ((MobEntityAccessor) mob).getTargetSelector();
				GoalSelector goalSelector = ((MobEntityAccessor) mob).getGoalSelector();

				boolean alreadyHasGoal = targetSelector.getAvailableGoals().stream()
					.anyMatch(goal -> goal.getGoal() instanceof UniversalTargetGoal);

				if (!alreadyHasGoal) {
					Supplier<ModConfig> configSupplier = ModConfig::getInstance;
					targetSelector.addGoal(2, new UniversalTargetGoal(
						mob,
						() -> configSupplier.get().isTargetingActive(),
						() -> configSupplier.get().ignoreSameSpecies,
						() -> configSupplier.get().targetPlayers,
						() -> configSupplier.get().isAllianceActive(),
						() -> configSupplier.get().getRangeMultiplier()
					));
					goalSelector.addGoal(0, new StalemateBreakerGoal(mob));
				}
			}));

		ServerEntityEvents.ENTITY_UNLOAD.register((entity, world) ->
			runSafely("ENTITY_UNLOAD for " + entity.getType().getDescriptionId(), () -> {
				if (world instanceof ServerLevel serverWorld && entity instanceof Mob mob) {
					NaturalSpawnLimiter.onMobUnloaded(serverWorld, mob.getTags().contains("umw_natural_spawned"));
				}
			}));

		// Per-tick maintenance.
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			runSafely("END_SERVER_TICK extra shot queue", () -> ScalingSystem.processExtraShotQueue(server));

			if (server.getTickCount() % 100 == 0) { // Every 5 seconds
				runSafely("END_SERVER_TICK cache cleanup", () -> {
					TargetingUtil.cleanupCache();
					OperationScheduler.cleanup();
				});
			}

			int intervalSeconds = Math.max(5, ModConfig.getInstance().cleanupNonPlayerGroundProjectilesIntervalSeconds);
			int intervalTicks = intervalSeconds * 20;
			if (server.getTickCount() % intervalTicks == 0) {
				runSafely("END_SERVER_TICK projectile cleanup",
					() -> EntityCleanupSystem.cleanupNonPlayerGroundProjectiles(server));
			}

			if (server.getTickCount() % 1200 == 0) {
				runSafely("END_SERVER_TICK alliance cleanup", () -> {
					for (ServerLevel world : server.getAllLevels()) {
						AllianceSystem.cleanupDeadMobs(world);
					}
				});
			}
		});

		LOGGER.info("Universal Mob War initialized successfully!");
	}

	public static void runSafely(String context, Runnable action) {
		if (action == null) return;
		try {
			action.run();
		} catch (Throwable t) {
			LOGGER.error("[UMW] {} failed", context == null ? "Unknown" : context, t);
		}
	}
}
