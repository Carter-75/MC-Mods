package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.config.ModConfig;
import mod.universalmobwar.data.IMobWarDataHolder;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.system.ScalingSystem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Core mixin that handles MobWarData persistence for ALL mobs.
 *
 * SCALING SYSTEM INTEGRATION:
 * This mixin calls ScalingSystem.processMobTick() which:
 *   1. Loads upgrade config from mob_configs/[mobname].json
 *   2. Calculates points from world age (daily_scaling)
 *   3. Spends points on upgrades (80% buy / 20% save)
 *   4. Applies effects (potions, equipment, abilities)
 *
 * To add scaling for a new mob:
 *   Just create mob_configs/[mobname].json - no mixin needed!
 *
 * NBT NOTE (26.2): the old writeCustomDataToNbt/readCustomDataFromNbt(NbtCompound)
 * were replaced by addAdditionalSaveData(ValueOutput)/readAdditionalSaveData(ValueInput).
 * We bridge by serializing MobWarData into a CompoundTag and storing it via CompoundTag.CODEC.
 */
@Mixin(Mob.class)
public abstract class MobDataMixin extends LivingEntity implements IMobWarDataHolder {

    @Unique
    private static final String UMW_NBT_KEY = "UniversalMobWarData";

    @Unique
    private MobWarData universalMobWarData = new MobWarData();

    protected MobDataMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public MobWarData getMobWarData() {
        return universalMobWarData;
    }

    @Override
    public void setMobWarData(MobWarData data) {
        this.universalMobWarData = data;
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void onWriteNbt(ValueOutput output, CallbackInfo ci) {
        UniversalMobWarMod.runSafely("MobDataMixin#addAdditionalSaveData", () -> {
            if (universalMobWarData != null) {
                output.store(UMW_NBT_KEY, CompoundTag.CODEC, universalMobWarData.writeNbt());
            }
        });
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void onReadNbt(ValueInput input, CallbackInfo ci) {
        UniversalMobWarMod.runSafely("MobDataMixin#readAdditionalSaveData", () -> {
            input.read(UMW_NBT_KEY, CompoundTag.CODEC).ifPresent(tag -> {
                universalMobWarData = new MobWarData();
                universalMobWarData.readNbt(tag);
            });
        });
    }

    /**
     * SCALING SYSTEM HOOK - Called every tick for ALL mobs.
     * ScalingSystem handles everything:
     *   - Checks if mob has JSON config
     *   - Calculates points from world age
     *   - Spends points on upgrades
     *   - Applies effects
     *
     * Mobs without a JSON config fall back to auto-detected potion scaling so passive/neutral/hostile
     * behaviour still lines up with the targeting system.
     */
    @Inject(method = "customServerAiStep", at = @At("HEAD"))
    private void universalmobwar$onMobTick(ServerLevel serverLevel, CallbackInfo ci) {
        UniversalMobWarMod.runSafely("MobDataMixin#onMobTick", () -> {
            if (!ModConfig.getInstance().modEnabled) {
                return;
            }
            Mob self = (Mob) (Object) this;
            ScalingSystem.monitorEquipmentState(self, universalMobWarData);
            ScalingSystem.processMobTick(self, self.level(), universalMobWarData);
        });
    }

    @Inject(
        method = "doHurtTarget(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/Entity;)Z",
        at = @At("TAIL")
    )
    private void universalmobwar$handleMeleeAbilities(ServerLevel serverLevel, Entity target, CallbackInfoReturnable<Boolean> cir) {
        UniversalMobWarMod.runSafely("MobDataMixin#handleMeleeAbilities", () -> {
            if (!cir.getReturnValueZ() || !(target instanceof LivingEntity livingTarget)) {
                return;
            }

            Mob self = (Mob) (Object) this;
            if (universalMobWarData == null) {
                return;
            }

            ScalingSystem.handleMeleeAttackAbilities(self, universalMobWarData, livingTarget, self.level().getGameTime());
        });
    }

    // Strip ALL equipment from every mob immediately on spawn (AFTER vanilla equipment).
    // Using @At("RETURN") ensures we strip equipment AFTER Minecraft adds it in finalizeSpawn().
    @Inject(method = "finalizeSpawn", at = @At("RETURN"))
    private void universalmobwar$stripAllEquipmentOnSpawn(
        ServerLevelAccessor world,
        DifficultyInstance difficulty,
        EntitySpawnReason spawnReason,
        SpawnGroupData entityData,
        CallbackInfoReturnable<SpawnGroupData> cir
    ) {
        UniversalMobWarMod.runSafely("MobDataMixin#stripAllEquipmentOnSpawn", () -> {
            if (!ModConfig.getInstance().modEnabled) {
                return; // Leave vanilla gear untouched when mod is disabled
            }
            Mob self = (Mob) (Object) this;

            // Tag spawn eggs so they aren't blocked by natural spawn blocker
            // (26.2: spawn eggs report SPAWN_ITEM_USE, the old SPAWN_EGG reason)
            if (spawnReason == EntitySpawnReason.SPAWN_ITEM_USE) {
                self.addTag("umw_player_spawned");
            }

            // Tag spawner spawns so they're excluded from natural spawn caps.
            if (spawnReason == EntitySpawnReason.SPAWNER) {
                self.addTag("umw_spawner_spawned");
            }

            // Tag natural spawns so we can apply a cap only to natural spawning.
            if (spawnReason == EntitySpawnReason.NATURAL) {
                self.addTag("umw_natural_spawned");
            }

            // Remove armor (head, chest, legs, boots)
            self.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
            self.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
            self.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
            self.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
            // Remove weapons/tools
            self.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
            self.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);

            ScalingSystem.handleSpawnBootstrap(self, spawnReason, universalMobWarData);
        });
    }
}
