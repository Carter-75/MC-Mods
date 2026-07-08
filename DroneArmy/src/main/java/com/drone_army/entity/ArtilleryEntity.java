package com.drone_army.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.world.World;

public class ArtilleryEntity extends RobotEntity implements RangedAttackMob {

    public ArtilleryEntity(EntityType<? extends RobotEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createArtilleryAttributes() {
        return RobotEntity.createRobotAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0) // Backup melee
                .add(EntityAttributes.GENERIC_ARMOR, 0.0);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        // Remove Melee logic inherited from RobotEntity to prefer Ranged
        this.goalSelector.getGoals()
                .removeIf(goal -> goal.getGoal() instanceof net.minecraft.entity.ai.goal.MeleeAttackGoal);

        // Add Ranged Attack Goal: Speed 1.0, MinInterval 40, MaxInterval 60, Range
        // 20.0F
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0, 40, 60, 20.0F));
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        com.drone_army.entity.projectile.RocketProjectile rocket = new com.drone_army.entity.projectile.RocketProjectile(
                this.getWorld(), this);
        double d = target.getX() - this.getX();
        double e = target.getBodyY(0.5D) - this.getBodyY(0.5D);
        double f = target.getZ() - this.getZ();

        rocket.setVelocity(d, e, f, 1.5F, 1.0F); // Custom velocity logic might be needed for persistent projectile

        // PersistentProjectile uses setVelocity(x,y,z, speed, divergence)
        // We need to set position first
        rocket.setPos(this.getX(), this.getBodyY(0.5D) + 0.5D, this.getZ());

        this.getWorld().spawnEntity(rocket);

        this.playSound(com.drone_army.registry.ModSounds.ARTILLERY_FIRE, 1.0F, 1.0F);
    }
}
