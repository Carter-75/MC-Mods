package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.config.ModConfig;
import mod.universalmobwar.data.MobWarData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Tracks mob deaths for the Universal Mob War system.
 * Individual mob progression is handled by each mob's dedicated mixin.
 * This mixin provides a hook point for future kill-based features.
 */
@Mixin(LivingEntity.class)
public abstract class MobDeathTrackerMixin {
    
    @Inject(method = "die", at = @At("HEAD"))
    private void universalmobwar$trackKill(DamageSource damageSource, CallbackInfo ci) {
        UniversalMobWarMod.runSafely("MobDeathTrackerMixin#trackKill", () -> {
            LivingEntity victim = (LivingEntity)(Object)this;

            if (victim.level().isClientSide()) return;
            if (!(victim instanceof Mob)) return;

            // Check if any progression system is enabled
            boolean scalingEnabled = ModConfig.getInstance().isScalingActive();

            if (!scalingEnabled) return;

            // Kill tracking hook - individual mob mixins handle their own progression
            // This provides a central point for future kill-based features
            if (!(damageSource.getEntity() instanceof Mob killer)) {
                return;
            }

            // Count kills for player targets and mob targets alike
            boolean countsTowardKills = victim instanceof Player || victim instanceof Mob;
            if (!countsTowardKills || killer == victim) {
                return;
            }

            MobWarData killerData = MobWarData.get(killer);
            killerData.addKill();
            MobWarData.save(killer, killerData);
        });
    }
}
