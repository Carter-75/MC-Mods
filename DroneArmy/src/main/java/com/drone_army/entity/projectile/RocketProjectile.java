package com.drone_army.entity.projectile;

import com.drone_army.registry.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

public class RocketProjectile extends PersistentProjectileEntity {

    public RocketProjectile(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public RocketProjectile(World world, LivingEntity owner) {
        super(ModEntities.ROCKET, owner, world, new ItemStack(net.minecraft.item.Items.ARROW), null); // Fallback to
                                                                                                      // arrow if
                                                                                                      // needed, or null
        // 1.21 usually requires ItemStack for projectile
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(Items.FIREWORK_ROCKET);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.FIREWORK_ROCKET); // Placeholder visual
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            this.getWorld().addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 0, -0.1, 0);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        explode();
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            explode();
        }
    }

    private void explode() {
        this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0F,
                World.ExplosionSourceType.MOB);
        this.discard();
    }
}
