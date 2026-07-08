/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_1300
 *  net.minecraft.class_4140
 *  net.minecraft.class_4148
 *  net.minecraft.class_4149
 *  net.minecraft.class_4168
 *  net.minecraft.class_7923
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import backported_updates.mixin.foundation.access.ActivityAccessor;
import backported_updates.mixin.foundation.access.SensorTypeAccessor;
import com.mojang.serialization.Codec;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_4140;
import net.minecraft.class_4148;
import net.minecraft.class_4149;
import net.minecraft.class_4168;
import net.minecraft.class_7923;

public class EntityRegistry {
    private final CoreRegistry<class_1299<?>> entities;
    private final CoreRegistry<class_4168> activities;
    private final CoreRegistry<class_4149<?>> sensors;
    private final CoreRegistry<class_4140<?>> memories;

    public static EntityRegistry create(String modId) {
        return new EntityRegistry(modId);
    }

    private EntityRegistry(String modId) {
        this.entities = CoreRegistry.create(class_7923.field_41177, modId);
        this.activities = CoreRegistry.create(class_7923.field_41132, modId);
        this.sensors = CoreRegistry.create(class_7923.field_41130, modId);
        this.memories = CoreRegistry.create(class_7923.field_41129, modId);
    }

    public <T extends class_1297> Supplier<class_1299<T>> entity(String name, class_1299.class_1300<T> entity) {
        return this.entities.register(name, () -> entity.method_5905(name));
    }

    public Supplier<class_4168> activity(String name) {
        return this.activities.register(name, () -> ActivityAccessor.createActivity(name));
    }

    public <T extends class_4148<?>> Supplier<class_4149<T>> sensor(String name, Supplier<T> supplier) {
        return this.sensors.register(name, () -> SensorTypeAccessor.createSensorType(supplier));
    }

    public <T> Supplier<class_4140<T>> memory(String name, Codec<T> codec) {
        return this.memories.register(name, () -> new class_4140(Optional.of(codec)));
    }

    public <T> Supplier<class_4140<T>> memory(String name) {
        return this.memories.register(name, () -> new class_4140(Optional.empty()));
    }

    public void register() {
        this.entities.register();
        this.activities.register();
        this.sensors.register();
        this.memories.register();
    }

    public CoreRegistry<class_1299<?>> entities() {
        return this.entities;
    }

    public CoreRegistry<class_4168> activities() {
        return this.activities;
    }

    public CoreRegistry<class_4149<?>> sensors() {
        return this.sensors;
    }

    public CoreRegistry<class_4140<?>> memories() {
        return this.memories;
    }
}

