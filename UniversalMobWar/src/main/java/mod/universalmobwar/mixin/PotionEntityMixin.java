package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.data.IMobWarDataHolder;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.system.ScalingSystem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.throwableitem.ThrownPotion;
import net.minecraft.world.entity.projectile.throwableitem.ThrowableItemProjectile;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;

import java.util.List;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Applies ranged potion mastery effects when custom potion projectiles land.
 */
@Mixin(ThrownPotion.class)
public abstract class PotionEntityMixin extends ThrowableItemProjectile {

    protected PotionEntityMixin(EntityType<? extends ThrowableItemProjectile> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "onHit", at = @At("TAIL"))
    private void universalmobwar$applyRangedPotionEffects(HitResult hitResult, CallbackInfo ci) {
        UniversalMobWarMod.runSafely("PotionEntityMixin#applyRangedPotionEffects", () -> {
            if (this.level().isClientSide()) {
                return;
            }

            if (!(hitResult instanceof EntityHitResult entityHitResult)) {
                return;
            }

            Entity owner = this.getOwner();
            if (!(owner instanceof Mob mobOwner)) {
                return;
            }

            Entity hit = entityHitResult.getEntity();
            if (!(hit instanceof LivingEntity livingTarget)) {
                return;
            }

            MobWarData data;
            if (mobOwner instanceof IMobWarDataHolder holder) {
                data = holder.getMobWarData();
            } else {
                data = MobWarData.get(mobOwner);
            }

            if (data == null) {
                return;
            }

            ScalingSystem.applyRangedPotionEffects(mobOwner, data, livingTarget);

            int piercing = ScalingSystem.getPiercingLevel(mobOwner, data);
            if (piercing <= 0) {
                return;
            }

            Level world = this.level();
            List<LivingEntity> nearby = world.getEntitiesOfClass(LivingEntity.class,
                hit.getBoundingBox().inflate(2.5),
                entity -> entity != livingTarget && entity != mobOwner && entity.isAlive());

            int applied = 0;
            for (LivingEntity extraTarget : nearby) {
                ScalingSystem.applyRangedPotionEffects(mobOwner, data, extraTarget);
                applied++;
                if (applied >= piercing) {
                    break;
                }
            }
        });
    }
}
