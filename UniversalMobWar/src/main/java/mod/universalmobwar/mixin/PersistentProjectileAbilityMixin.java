package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.bridge.ProjectileAbilityBridge;
import mod.universalmobwar.data.IMobWarDataHolder;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.system.ScalingSystem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Applies scaling-system ranged abilities (piercing, multishot, potion mastery)
 * to every persistent projectile fired by a mob.
 */
@Mixin(AbstractArrow.class)
public abstract class PersistentProjectileAbilityMixin extends Projectile implements ProjectileAbilityBridge {
    @Unique
    private boolean universalmobwar$abilitiesApplied;

    protected PersistentProjectileAbilityMixin(EntityType<? extends AbstractArrow> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public void universalmobwar$setAbilitiesApplied(boolean applied) {
        this.universalmobwar$abilitiesApplied = applied;
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void universalmobwar$applyProjectileAbilities(CallbackInfo ci) {
        UniversalMobWarMod.runSafely("PersistentProjectileAbilityMixin#applyProjectileAbilities", () -> {
            if (this.level().isClientSide() || universalmobwar$abilitiesApplied) {
                return;
            }

            Entity owner = this.getOwner();
            if (!(owner instanceof Mob mob)) {
                universalmobwar$abilitiesApplied = true;
                return;
            }

            MobWarData data = universalmobwar$getData(mob);
            if (data == null) {
                universalmobwar$abilitiesApplied = true;
                return;
            }

            universalmobwar$abilitiesApplied = true;

            int piercingLevel = Math.max(0, ScalingSystem.getPiercingLevel(mob, data));
            if (piercingLevel > 0) {
                ((PersistentProjectileEntityAccessor) (Object) this).invokeSetPierceLevel((byte) Math.min(127, piercingLevel));
            }

            // Multishot + extra_shot are handled in ProjectileAbilityMixin for all projectile types.
        });
    }

    @Inject(method = "onHitEntity", at = @At("TAIL"))
    private void universalmobwar$applyPotionMastery(EntityHitResult hitResult, CallbackInfo ci) {
        UniversalMobWarMod.runSafely("PersistentProjectileAbilityMixin#applyPotionMastery", () -> {
            if (this.level().isClientSide()) {
                return;
            }

            Entity owner = this.getOwner();
            if (!(owner instanceof Mob mob)) {
                return;
            }

            Entity hit = hitResult.getEntity();
            if (!(hit instanceof LivingEntity livingTarget)) {
                return;
            }

            MobWarData data = universalmobwar$getData(mob);
            if (data == null) {
                return;
            }

            ScalingSystem.applyRangedPotionEffects(mob, data, livingTarget);
        });
    }

    private MobWarData universalmobwar$getData(Mob mob) {
        if (mob instanceof IMobWarDataHolder holder) {
            return holder.getMobWarData();
        }
        return MobWarData.get(mob);
    }
}
