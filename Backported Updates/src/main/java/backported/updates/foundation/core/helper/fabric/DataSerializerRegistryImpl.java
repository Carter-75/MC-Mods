/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.Registry
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.registry.RegistryKey
 */
package backported.updates.foundation.core.helper.fabric;

import backported.updates.foundation.core.CoreRegistry;
import backported.updates.foundation.core.RegistryBuilder;
import backported.updates.foundation.core.helper.DataSerializerRegistry;
import java.util.function.Supplier;
import net.minecraft.registry.Registry;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.registry.RegistryKey;

public class DataSerializerRegistryImpl
extends DataSerializerRegistry {
    private static final RegistryBuilder BUILDER = RegistryBuilder.create("platform");
    private static final RegistryKey<Registry<TrackedDataHandler<?>>> REGISTRY_KEY = BUILDER.resource("entity_data_serializers");
    private static final Supplier<Registry<TrackedDataHandler<?>>> REGISTRY = BUILDER.registry(REGISTRY_KEY);
    private final CoreRegistry<TrackedDataHandler<?>> registry;
    private static final int VANILLA_SERIALIZER_LIMIT = 256;

    public DataSerializerRegistryImpl(String modId) {
        this.registry = CoreRegistry.create(REGISTRY_KEY, modId);
    }

    public static DataSerializerRegistry create(String modId) {
        return new DataSerializerRegistryImpl(modId);
    }

    @Override
    public <T> Supplier<TrackedDataHandler<T>> register(String name, Supplier<TrackedDataHandler<T>> serializer) {
        return this.registry.register(name, serializer);
    }

    @Override
    public void register() {
        this.registry.register();
    }

    public static TrackedDataHandler<?> getSerializer(int id) {
        return (TrackedDataHandler)REGISTRY.get().get(id - 256);
    }

    public static int getSerializedId(TrackedDataHandler<?> serializer, int vanilla) {
        int id = REGISTRY.get().getRawId(serializer);
        if (id >= 0) {
            return id + 256;
        }
        return vanilla;
    }
}

