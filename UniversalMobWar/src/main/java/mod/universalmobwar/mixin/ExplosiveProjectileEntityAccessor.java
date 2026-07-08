package mod.universalmobwar.mixin;

import net.minecraft.world.entity.projectile.hurtingprojectile.AbstractHurtingProjectile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractHurtingProjectile.class)
public interface ExplosiveProjectileEntityAccessor {
    @Accessor("accelerationPower")
    double universalmobwar$getAccelerationPower();

    @Accessor("accelerationPower")
    void universalmobwar$setAccelerationPower(double value);
}
