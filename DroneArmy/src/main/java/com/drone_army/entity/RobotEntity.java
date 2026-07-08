package com.drone_army.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;

public abstract class RobotEntity extends PathAwareEntity {

    protected RobotEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createRobotAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_ARMOR, 5.0);
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        // Robots managed by controller should not despawn naturally if they are
        // "Active"
        // But the mixin handles `isControlled` persistence.
        // We return false to be safe.
        return false;
    }

    @Override
    protected net.minecraft.sound.SoundEvent getDeathSound() {
        return com.drone_army.registry.ModSounds.ROBOT_DEATH;
    }

    @Override
    public boolean damage(net.minecraft.entity.damage.DamageSource source, float amount) {
        if (this.getWorld().isClient)
            return super.damage(source, amount);

        // Friendly Fire Check
        if (source.getAttacker() instanceof net.minecraft.entity.player.PlayerEntity player) {
            if (this instanceof com.drone_army.entity.ControlledMob controlled && controlled.isControlled()) {
                if (player.getUuid().equals(controlled.getOwnerUuid())) {
                    if (!com.drone_army.config.ModConfig.get().allowFriendlyFire) {
                        return false;
                    }
                }
            }
        }
        return super.damage(source, amount);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new net.minecraft.entity.ai.goal.SwimGoal(this));
        this.goalSelector.add(1, new com.drone_army.entity.ai.DroneFollowGoal(this, 1.25, 4.0F, 10.0F));
        this.goalSelector.add(2, new net.minecraft.entity.ai.goal.MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(3, new com.drone_army.entity.ai.DroneWanderGoal(this, 1.0));
        this.goalSelector.add(4, new net.minecraft.entity.ai.goal.LookAtEntityGoal(this,
                net.minecraft.entity.player.PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new net.minecraft.entity.ai.goal.LookAroundGoal(this));

        this.targetSelector.add(1, new net.minecraft.entity.ai.goal.RevengeGoal(this));

        // Custom Target Goal needs to efficiently filter.
        // We target Hostile Mobs or everything?
        // "Aggressive: Hunt enemies".
        // We can add multiple targets.
        this.targetSelector.add(2, new com.drone_army.entity.ai.DroneTargetGoal<>(this,
                net.minecraft.entity.mob.HostileEntity.class, true));

        // Attack Players if NOT controlled (Wild Robot behavior)
        this.targetSelector.add(3, new net.minecraft.entity.ai.goal.ActiveTargetGoal<>(this,
                net.minecraft.entity.player.PlayerEntity.class, 10, true, false,
                (p) -> !((com.drone_army.entity.ControlledMob) this).isControlled()));
    }
}
