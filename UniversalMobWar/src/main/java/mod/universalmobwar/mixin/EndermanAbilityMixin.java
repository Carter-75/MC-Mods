package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.data.IMobWarDataHolder;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.system.ScalingSystem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Wires Enderman-specific scaling abilities (shadow_step + void_grasp).
 */
@Mixin(EnderMan.class)
public abstract class EndermanAbilityMixin extends Monster {

    @Unique
    private BlockPos universalmobwar$lastTeleportFrom = BlockPos.ZERO;

    protected EndermanAbilityMixin(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "teleportTo(DDD)Z", at = @At("HEAD"))
    private void universalmobwar$rememberTeleportOrigin(double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        UniversalMobWarMod.runSafely("EndermanAbilityMixin#rememberTeleportOrigin", () -> {
            this.universalmobwar$lastTeleportFrom = this.blockPosition();
        });
    }

    @Inject(method = "teleportTo(DDD)Z", at = @At("RETURN"))
    private void universalmobwar$triggerShadowStep(double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        UniversalMobWarMod.runSafely("EndermanAbilityMixin#triggerShadowStep", () -> {
            if (!cir.getReturnValueZ()) {
                return;
            }
            if (!(this.level() instanceof ServerLevel serverWorld)) {
                return;
            }
            MobWarData data = universalmobwar$getData();
            if (data == null) {
                return;
            }
            ScalingSystem.handleShadowStep((Mob) (Object) this, data, serverWorld, universalmobwar$lastTeleportFrom, serverWorld.getGameTime());
        });
    }

    @Inject(method = "customServerAiStep", at = @At("TAIL"))
    private void universalmobwar$handleVoidGrasp(ServerLevel serverLevel, CallbackInfo ci) {
        UniversalMobWarMod.runSafely("EndermanAbilityMixin#handleVoidGrasp", () -> {
            // Run roughly every 10 ticks per Enderman to avoid constant scanning.
            if ((serverLevel.getGameTime() + this.getId()) % 10 != 0) {
                return;
            }
            MobWarData data = universalmobwar$getData();
            if (data == null) {
                return;
            }
            ScalingSystem.handleVoidGrasp((Mob) (Object) this, data, serverLevel, serverLevel.getGameTime());
        });
    }

    private MobWarData universalmobwar$getData() {
        if (this instanceof IMobWarDataHolder holder) {
            return holder.getMobWarData();
        }
        return MobWarData.get((Mob) (Object) this);
    }
}
