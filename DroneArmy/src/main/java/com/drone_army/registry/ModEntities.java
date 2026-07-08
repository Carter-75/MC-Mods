package com.drone_army.registry;

import com.drone_army.DroneArmyMod;
import com.drone_army.entity.ArtilleryEntity;
import com.drone_army.entity.CombatDroneEntity;
import com.drone_army.entity.SentinelEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
        public static final EntityType<CombatDroneEntity> COMBAT_DRONE = Registry.register(
                        Registries.ENTITY_TYPE,
                        Identifier.of(DroneArmyMod.MOD_ID, "combat_drone"),
                        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CombatDroneEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.8f)) // Humanoid size
                                        .build());

        public static final EntityType<SentinelEntity> SENTINEL = Registry.register(
                        Registries.ENTITY_TYPE,
                        Identifier.of(DroneArmyMod.MOD_ID, "sentinel"),
                        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SentinelEntity::new)
                                        .dimensions(EntityDimensions.fixed(1.4f, 2.7f)) // Large/Tank
                                        .build());

        public static final EntityType<ArtilleryEntity> ARTILLERY = Registry.register(
                        Registries.ENTITY_TYPE,
                        Identifier.of(DroneArmyMod.MOD_ID, "artillery"),
                        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ArtilleryEntity::new)
                                        .dimensions(EntityDimensions.fixed(1.0f, 1.0f)) // Small/Wide
                                        .build());

        public static void registerAttributes() {
                FabricDefaultAttributeRegistry.register(COMBAT_DRONE, CombatDroneEntity.createCombatDroneAttributes());
                FabricDefaultAttributeRegistry.register(SENTINEL, SentinelEntity.createSentinelAttributes());
                FabricDefaultAttributeRegistry.register(ARTILLERY, ArtilleryEntity.createArtilleryAttributes());
        }

        public static final EntityType<com.drone_army.entity.projectile.RocketProjectile> ROCKET = Registry.register(
                        Registries.ENTITY_TYPE,
                        Identifier.of(DroneArmyMod.MOD_ID, "rocket"),
                        FabricEntityTypeBuilder.<com.drone_army.entity.projectile.RocketProjectile>create(
                                        SpawnGroup.MISC,
                                        com.drone_army.entity.projectile.RocketProjectile::new)
                                        .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                                        .trackRangeBlocks(64).trackedUpdateRate(10)
                                        .build());

        public static void registerModEntities() {
                DroneArmyMod.LOGGER.info("Registering Entities for " + DroneArmyMod.MOD_ID);
                registerAttributes();
        }
}
