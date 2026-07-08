/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2378
 *  net.minecraft.class_2941
 *  net.minecraft.class_5321
 */
package backported.updates.foundation.core.helper.fabric;

import backported.updates.foundation.core.CoreRegistry;
import backported.updates.foundation.core.RegistryBuilder;
import backported.updates.foundation.core.helper.DataSerializerRegistry;
import java.util.function.Supplier;
import net.minecraft.class_2378;
import net.minecraft.class_2941;
import net.minecraft.class_5321;

public class DataSerializerRegistryImpl
extends DataSerializerRegistry {
    private static final RegistryBuilder BUILDER = RegistryBuilder.create("platform");
    private static final class_5321<class_2378<class_2941<?>>> REGISTRY_KEY = BUILDER.resource("entity_data_serializers");
    private static final Supplier<class_2378<class_2941<?>>> REGISTRY = BUILDER.registry(REGISTRY_KEY);
    private final CoreRegistry<class_2941<?>> registry;
    private static final int VANILLA_SERIALIZER_LIMIT = 256;

    public DataSerializerRegistryImpl(String modId) {
        this.registry = CoreRegistry.create(REGISTRY_KEY, modId);
    }

    public static DataSerializerRegistry create(String modId) {
        return new DataSerializerRegistryImpl(modId);
    }

    @Override
    public <T> Supplier<class_2941<T>> register(String name, Supplier<class_2941<T>> serializer) {
        return this.registry.register(name, serializer);
    }

    @Override
    public void register() {
        this.registry.register();
    }

    public static class_2941<?> getSerializer(int id) {
        return (class_2941)REGISTRY.get().method_10200(id - 256);
    }

    public static int getSerializedId(class_2941<?> serializer, int vanilla) {
        int id = REGISTRY.get().method_10206(serializer);
        if (id >= 0) {
            return id + 256;
        }
        return vanilla;
    }
}

