package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.config.ModConfig;
import mod.universalmobwar.system.NaturalSpawnLimiter;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Prevents all natural mob spawns if disableNaturalMobSpawns is true in config.
 */
@Mixin(ServerLevel.class)
public abstract class NaturalMobSpawnBlockerMixin {
    /**
     * This mixin blocks ALL natural mob spawns (hostile AND peaceful):
     * - Only blocks mobs that are not spawned by players, eggs, or commands.
     * - Does NOT block mobs spawned by spawn eggs, mod code, or commands.
     */
    @Inject(method = "addFreshEntity", at = @At("HEAD"), cancellable = true)
    private void onSpawnEntity(net.minecraft.world.entity.Entity entity, CallbackInfoReturnable<Boolean> cir) {
        UniversalMobWarMod.runSafely("NaturalMobSpawnBlockerMixin#onSpawnEntity", () -> {
            ModConfig config = ModConfig.getInstance();
            if (!(entity instanceof Mob)) return;
            
            // Check if mob has special tags indicating it was spawned by player/mod/command
            Mob mob = (Mob) entity;

            // Hard block mode (existing behavior)
            if (config.disableNaturalMobSpawns) {
                if (mob.getTags().contains("umw_player_spawned")) return;
                if (mob.getTags().contains("umw_spawner_spawned")) return;
                if (mob.getTags().contains("umw_horde_reinforcement")) return;
                if (mob.getTags().contains("umw_summoned")) return;
                if (entity.hasCustomName()) return;
                cir.setReturnValue(false);
                return;
            }

            // Soft cap mode: only applies to NATURAL spawns (not spawners, eggs, commands, etc.)
            if (!config.limitNaturalMobSpawns) return;
            if (!mob.getTags().contains("umw_natural_spawned")) return;

            // Safety allowlist
            if (mob.getTags().contains("umw_player_spawned")) return;
            if (mob.getTags().contains("umw_spawner_spawned")) return;
            if (mob.getTags().contains("umw_horde_reinforcement")) return;
            if (mob.getTags().contains("umw_summoned")) return;
            if (entity.hasCustomName()) return;

            if (!(((Object) this) instanceof ServerLevel world)) return;
            MinecraftServer server = world.getServer();
            if (server == null) return;

            int simulationDistance = getSimulationDistance(server);
            int cap = Math.max(0, config.naturalSpawnCapPerSimulationDistance) * Math.max(0, simulationDistance);
            if (cap <= 0) {
                return;
            }

            int currentNatural = NaturalSpawnLimiter.getNaturalMobCount(world);
            if (currentNatural >= cap) {
                cir.setReturnValue(false);
            }
        });
    }

    private static int getSimulationDistance(MinecraftServer server) {
        try {
            return server.getPlayerManager().getSimulationDistance();
        } catch (Throwable ignored) {
            return server.getPlayerManager().getViewDistance();
        }
    }
}
