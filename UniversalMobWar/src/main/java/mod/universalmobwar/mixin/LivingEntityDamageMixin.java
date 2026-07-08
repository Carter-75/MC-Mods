package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.data.IMobWarDataHolder;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.system.ScalingSystem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Handles damage-triggered scaling abilities on the LivingEntity level so all mobs stay compatible
 * even when Mojang changes MobEntity's overrides.
 */
@Mixin(LivingEntity.class)
public abstract class LivingEntityDamageMixin {

    @Inject(method = "hurtServer", at = @At("TAIL"))
    private void universalmobwar$handleDamageAbilities(ServerLevel serverLevel, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        UniversalMobWarMod.runSafely("LivingEntityDamageMixin#handleDamageAbilities", () -> {
            if (!cir.getReturnValueZ()) {
                return;
            }

            if (!((Object) this instanceof Mob mobEntity)) {
                return;
            }

            MobWarData data = ((IMobWarDataHolder) mobEntity).getMobWarData();

            ScalingSystem.handleCriticalGlow(mobEntity, source);

            if (data == null) {
                return;
            }

            long currentTick = mobEntity.level().getGameTime();
            ScalingSystem.handleDamageAbilities(mobEntity, data, currentTick);
            ScalingSystem.handleHordeSummon(mobEntity, data, serverLevel, currentTick);
        });
    }
}
