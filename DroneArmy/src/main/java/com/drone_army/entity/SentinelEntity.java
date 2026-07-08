package com.drone_army.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.world.World;

public class SentinelEntity extends RobotEntity {
    public SentinelEntity(EntityType<? extends RobotEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createSentinelAttributes() {
        return createRobotAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0) // Tank
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2) // Slow
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.8);
    }
}
