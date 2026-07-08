package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.config.ModConfig;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Makes neutral mobs (those with NeutralMob interface) always aggressive when the config option is enabled.
 * Affects: Enderman, Zombie Piglin, Wolves, Pandas, Polar Bears, Bees, etc.
 */
@Mixin(Mob.class)
public abstract class NeutralMobBehaviorMixin {
    
    /**
     * Keeps neutral mobs aggressive by maintaining their anger when the config is on.
     */
    @Inject(method = "tick", at = @At("HEAD"))
    private void universalmobwar$forceAggressive(CallbackInfo ci) {
        UniversalMobWarMod.runSafely("NeutralMobBehaviorMixin#forceAggressive", () -> {
            Mob self = (Mob)(Object)this;
            
            if (self.level().isClientSide()) return;
            if (!(self.level() instanceof ServerLevel serverWorld)) return;
            
            // Only affect mobs with anger system (neutral mobs)
            if (!(self instanceof NeutralMob neutralMob)) return;
            
            boolean neutralAggressive = ModConfig.getInstance().neutralMobsAlwaysAggressive;
            if (!neutralAggressive) return;
            
            // Keep anger high when they have a target
            if (neutralMob.getPersistentAngerTarget() == null && self.getTarget() != null) {
                // Set anger target to current target
                neutralMob.setPersistentAngerTarget(self.getTarget().getUUID());
                neutralMob.setRemainingPersistentAngerTime(600); // 30 seconds
            }
        });
    }
}
