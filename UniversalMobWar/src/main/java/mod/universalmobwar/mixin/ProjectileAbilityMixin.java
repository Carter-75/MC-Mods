package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.data.IMobWarDataHolder;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.system.ScalingSystem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.hurtingprojectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.throwableitem.ThrowableItemProjectile;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Applies scaling-system ranged abilities (multishot + extra_shot follow-up cycles)
 * to any projectile fired by a mob.
 */
@Mixin(Projectile.class)
public abstract class ProjectileAbilityMixin {

    @Unique
    private boolean universalmobwar$abilitiesApplied;

    @Inject(method = "tick", at = @At("HEAD"))
    private void universalmobwar$applyProjectileAbilities(CallbackInfo ci) {
        UniversalMobWarMod.runSafely("ProjectileAbilityMixin#applyProjectileAbilities", () -> {
            Projectile self = (Projectile) (Object) this;
            Level world = self.level();
            if (world.isClientSide() || universalmobwar$abilitiesApplied) {
                return;
            }

            universalmobwar$abilitiesApplied = true;

            if (self.getTags().contains(ScalingSystem.MULTISHOT_CHILD_TAG)
                || self.getTags().contains(ScalingSystem.EXTRA_SHOT_CHILD_TAG)) {
                return;
            }

            Entity owner = self.getOwner();
            if (!(owner instanceof Mob mob)) {
                return;
            }

            MobWarData data = universalmobwar$getData(mob);
            if (data == null) {
                return;
            }

            if (!(world instanceof ServerLevel serverWorld)) {
                return;
            }

            LivingEntity target = mob.getTarget();

            // Extra-shot follow-up cycles (scheduled between natural cycles).
            long serverTick = serverWorld.getServer().getTickCount();
            ScalingSystem.onMobFiredProjectileForExtraShot(mob, data, self, serverWorld, serverTick);

            // Multishot extra projectiles (immediate duplicates).
            int extraProjectiles = ScalingSystem.handleRangedAbilities(mob, data, target, serverTick);
            if (extraProjectiles <= 0) {
                return;
            }

            universalmobwar$spawnMultishotProjectiles(serverWorld, mob, data, self, extraProjectiles);
        });
    }

    @Unique
    private void universalmobwar$spawnMultishotProjectiles(ServerLevel world, Mob mob, MobWarData data, Projectile original, int extraProjectiles) {
        UniversalMobWarMod.runSafely("ProjectileAbilityMixin#spawnMultishotProjectiles", () -> {
            final boolean isExplosive = original instanceof AbstractHurtingProjectile;

            double baseSpeed;
            Vec3 baseDir;

            if (isExplosive) {
                double accel = 0.1;
                try {
                    accel = ((ExplosiveProjectileEntityAccessor) (Object) original).universalmobwar$getAccelerationPower();
                } catch (Throwable ignored) {
                }
                baseSpeed = Math.max(0.05, accel);
                Vec3 v = original.getDeltaMovement();
                baseDir = v.lengthSqr() > 1.0E-6 ? v.normalize() : mob.getViewVector(1.0F);
            } else {
                Vec3 v = original.getDeltaMovement();
                baseSpeed = Math.max(0.05, v.length());
                baseDir = v.lengthSqr() > 1.0E-6 ? v.normalize() : mob.getViewVector(1.0F);
            }

            // Use small variance: ~5-10% speed and small angle jitter.
            // This keeps it basically the same shot with slight imperfection.
            final float maxAngleDeg = 4.0f;
            final double minSpeedMul = 0.90;
            final double maxSpeedMul = 1.10;

            int piercingLevel = Math.max(0, ScalingSystem.getPiercingLevel(mob, data));

            for (int i = 0; i < extraProjectiles; i++) {
                Entity duplicate = original.getType().create(world);
                if (!(duplicate instanceof Projectile projectile)) {
                    continue;
                }

                projectile.setOwner(mob);
                projectile.setPos(original.getX(), original.getY(), original.getZ());
                projectile.addTag(ScalingSystem.MULTISHOT_CHILD_TAG);

                if (original instanceof ThrowableItemProjectile thrown && projectile instanceof ThrowableItemProjectile thrownCopy) {
                    thrownCopy.setItem(thrown.getItem().copy());
                }

                Vec3 dirJittered = universalmobwar$jitterDirection(baseDir, mob.getRandom().nextFloat() * 2f - 1f, mob.getRandom().nextFloat() * 2f - 1f, maxAngleDeg);
                double speedMul = minSpeedMul + mob.getRandom().nextDouble() * (maxSpeedMul - minSpeedMul);
                double speed = baseSpeed * speedMul;
                Vec3 velocity = dirJittered.scale(speed);
                projectile.setDeltaMovement(velocity);

                if (projectile instanceof AbstractHurtingProjectile explosiveCopy) {
                    try {
                        ((ExplosiveProjectileEntityAccessor) (Object) explosiveCopy).universalmobwar$setAccelerationPower(speed);
                    } catch (Throwable ignored) {
                    }
                }

                if (projectile instanceof AbstractArrow persistentCopy) {
                    persistentCopy.pickup = AbstractArrow.Pickup.DISALLOWED;
                    if (piercingLevel > 0) {
                        ((PersistentProjectileEntityAccessor) (Object) persistentCopy).invokeSetPierceLevel((byte) Math.min(127, piercingLevel));
                    }
                }

                world.addFreshEntity(projectile);
            }
        });
    }

    @Unique
    private static Vec3 universalmobwar$jitterDirection(Vec3 baseDir, float yawRand, float pitchRand, float maxAngleDeg) {
        // Convert small yaw/pitch offsets (degrees) into a perturbed direction.
        double yaw = Math.toRadians(yawRand * maxAngleDeg);
        double pitch = Math.toRadians(pitchRand * maxAngleDeg);

        // Apply yaw around Y axis.
        double cosYaw = Math.cos(yaw);
        double sinYaw = Math.sin(yaw);
        Vec3 yawed = new Vec3(
            baseDir.x * cosYaw - baseDir.z * sinYaw,
            baseDir.y,
            baseDir.x * sinYaw + baseDir.z * cosYaw
        );

        // Apply pitch around X axis.
        double cosPitch = Math.cos(pitch);
        double sinPitch = Math.sin(pitch);
        Vec3 pitched = new Vec3(
            yawed.x,
            yawed.y * cosPitch - yawed.z * sinPitch,
            yawed.y * sinPitch + yawed.z * cosPitch
        );

        return pitched.lengthSqr() > 1.0E-6 ? pitched.normalize() : baseDir;
    }

    @Unique
    private MobWarData universalmobwar$getData(Mob mob) {
        if (mob instanceof IMobWarDataHolder holder) {
            return holder.getMobWarData();
        }
        return MobWarData.get(mob);
    }
}
