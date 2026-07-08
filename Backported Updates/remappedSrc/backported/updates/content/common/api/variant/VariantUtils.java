/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2487
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_5425
 */
package backported.updates.content.common.api.variant;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported.updates.content.common.api.variant.VariantSpawner;
import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import java.util.Optional;
import net.minecraft.class_2487;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_5425;

public class VariantUtils {
    public static final String VARIANT_KEY = "variant";

    public static <T> Optional<T> getOrDefault(BuiltInCoreRegistry<T> registry, String id) {
        T variant = registry.get(class_2960.method_12829((String)id));
        return variant == null ? Optional.empty() : Optional.of(variant);
    }

    public static <T> T getDefault(BuiltInCoreRegistry<T> registry, class_5321<T> key) {
        return registry.getOrThrow(key);
    }

    public static <T> T getVariant(BuiltInCoreRegistry<T> registry, String id) {
        return registry.get(class_2960.method_12829((String)id));
    }

    public static <T> String getID(BuiltInCoreRegistry<T> registry, T value) {
        return registry.getKey(value).toString();
    }

    public static <T> String getDefaultID(BuiltInCoreRegistry<T> registry, class_5321<T> value) {
        return VariantUtils.getID(registry, VariantUtils.getDefault(registry, value));
    }

    public static <T> boolean matches(BuiltInCoreRegistry<T> registry, T variant, class_5321<T> value) {
        return variant == registry.get(value);
    }

    public static <T> void addVariantSaveData(VariantDataHolder<T> entity, class_2487 tag, BuiltInCoreRegistry<T> registry) {
        entity.getVariantData().ifPresent(variant -> {
            class_2960 key = registry.getKey(variant);
            if (key != null) {
                tag.method_10582(VARIANT_KEY, key.toString());
            }
        });
    }

    public static <T> void readVariantSaveData(VariantDataHolder<T> entity, class_2487 tag, BuiltInCoreRegistry<T> registry) {
        T variant;
        if (tag.method_10545(VARIANT_KEY) && (variant = registry.get(class_2960.method_12829((String)tag.method_10558(VARIANT_KEY)))) != null) {
            entity.setVariantData(variant);
        }
    }

    public static <T extends PriorityProvider<SpawnContext, ?>> Optional<T> selectVariantToSpawn(SpawnContext context, BuiltInCoreRegistry<T> registry, VariantSpawner spawner) {
        if (!spawner.apply()) {
            return Optional.empty();
        }
        class_5425 level = context.level();
        return PriorityProvider.pick(registry.values().stream(), entry -> entry, level.method_8409(), context);
    }

    public static <T extends PriorityProvider<SpawnContext, ?>> Optional<T> selectVariantToSpawn(SpawnContext context, BuiltInCoreRegistry<T> registry) {
        return VariantUtils.selectVariantToSpawn(context, registry, VariantSpawner.DEFAULT);
    }
}

