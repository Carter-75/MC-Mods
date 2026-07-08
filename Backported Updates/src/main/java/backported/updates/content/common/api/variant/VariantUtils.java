/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.ServerWorldAccess
 */
package backported.updates.content.common.api.variant;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported.updates.content.common.api.variant.VariantSpawner;
import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import java.util.Optional;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.ServerWorldAccess;

public class VariantUtils {
    public static final String VARIANT_KEY = "variant";

    public static <T> Optional<T> getOrDefault(BuiltInCoreRegistry<T> registry, String id) {
        T variant = registry.get(Identifier.tryParse((String)id));
        return variant == null ? Optional.empty() : Optional.of(variant);
    }

    public static <T> T getDefault(BuiltInCoreRegistry<T> registry, RegistryKey<T> key) {
        return registry.getOrThrow(key);
    }

    public static <T> T getVariant(BuiltInCoreRegistry<T> registry, String id) {
        return registry.get(Identifier.tryParse((String)id));
    }

    public static <T> String getID(BuiltInCoreRegistry<T> registry, T value) {
        return registry.getKey(value).toString();
    }

    public static <T> String getDefaultID(BuiltInCoreRegistry<T> registry, RegistryKey<T> value) {
        return VariantUtils.getID(registry, VariantUtils.getDefault(registry, value));
    }

    public static <T> boolean matches(BuiltInCoreRegistry<T> registry, T variant, RegistryKey<T> value) {
        return variant == registry.get(value);
    }

    public static <T> void addVariantSaveData(VariantDataHolder<T> entity, NbtCompound tag, BuiltInCoreRegistry<T> registry) {
        entity.getVariantData().ifPresent(variant -> {
            Identifier key = registry.getKey(variant);
            if (key != null) {
                tag.putString(VARIANT_KEY, key.toString());
            }
        });
    }

    public static <T> void readVariantSaveData(VariantDataHolder<T> entity, NbtCompound tag, BuiltInCoreRegistry<T> registry) {
        T variant;
        if (tag.contains(VARIANT_KEY) && (variant = registry.get(Identifier.tryParse((String)tag.getString(VARIANT_KEY)))) != null) {
            entity.setVariantData(variant);
        }
    }

    public static <T extends PriorityProvider<SpawnContext, ?>> Optional<T> selectVariantToSpawn(SpawnContext context, BuiltInCoreRegistry<T> registry, VariantSpawner spawner) {
        if (!spawner.apply()) {
            return Optional.empty();
        }
        ServerWorldAccess level = context.level();
        return PriorityProvider.pick(registry.values().stream(), entry -> entry, level.getRandom(), context);
    }

    public static <T extends PriorityProvider<SpawnContext, ?>> Optional<T> selectVariantToSpawn(SpawnContext context, BuiltInCoreRegistry<T> registry) {
        return VariantUtils.selectVariantToSpawn(context, registry, VariantSpawner.DEFAULT);
    }
}

