package com.drone_army.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.world.World;

public class CombatDroneEntity extends RobotEntity {
    public CombatDroneEntity(EntityType<? extends RobotEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createCombatDroneAttributes() {
        return createRobotAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35) // Fast
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0);
    }
}
