/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.EntityType$Builder
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.entity.ai.brain.sensor.Sensor
 *  net.minecraft.entity.ai.brain.sensor.SensorType
 *  net.minecraft.entity.ai.brain.Activity
 *  net.minecraft.registry.Registries
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import backported_updates.mixin.foundation.access.ActivityAccessor;
import backported_updates.mixin.foundation.access.SensorTypeAccessor;
import com.mojang.serialization.Codec;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.registry.Registries;

public class EntityRegistry {
    private final CoreRegistry<EntityType<?>> entities;
    private final CoreRegistry<Activity> activities;
    private final CoreRegistry<SensorType<?>> sensors;
    private final CoreRegistry<MemoryModuleType<?>> memories;

    public static EntityRegistry create(String modId) {
        return new EntityRegistry(modId);
    }

    private EntityRegistry(String modId) {
        this.entities = CoreRegistry.create(Registries.ENTITY_TYPE, modId);
        this.activities = CoreRegistry.create(Registries.ACTIVITY, modId);
        this.sensors = CoreRegistry.create(Registries.SENSOR_TYPE, modId);
        this.memories = CoreRegistry.create(Registries.MEMORY_MODULE_TYPE, modId);
    }

    public <T extends Entity> Supplier<EntityType<T>> entity(String name, EntityType.Builder<T> entity) {
        return this.entities.register(name, () -> entity.build(name));
    }

    public Supplier<Activity> activity(String name) {
        return this.activities.register(name, () -> ActivityAccessor.createActivity(name));
    }

    public <T extends Sensor<?>> Supplier<SensorType<T>> sensor(String name, Supplier<T> supplier) {
        return this.sensors.register(name, () -> SensorTypeAccessor.createSensorType(supplier));
    }

    public <T> Supplier<MemoryModuleType<T>> memory(String name, Codec<T> codec) {
        return this.memories.register(name, () -> new MemoryModuleType(Optional.of(codec)));
    }

    public <T> Supplier<MemoryModuleType<T>> memory(String name) {
        return this.memories.register(name, () -> new MemoryModuleType(Optional.empty()));
    }

    public void register() {
        this.entities.register();
        this.activities.register();
        this.sensors.register();
        this.memories.register();
    }

    public CoreRegistry<EntityType<?>> entities() {
        return this.entities;
    }

    public CoreRegistry<Activity> activities() {
        return this.activities;
    }

    public CoreRegistry<SensorType<?>> sensors() {
        return this.sensors;
    }

    public CoreRegistry<MemoryModuleType<?>> memories() {
        return this.memories;
    }
}

