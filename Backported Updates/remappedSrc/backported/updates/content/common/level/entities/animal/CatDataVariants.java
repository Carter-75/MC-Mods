/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.common.api.variant.ClientAsset;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import backported.updates.content.common.level.entities.animal.CatDataVariant;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.class_2960;
import net.minecraft.class_5321;

public class CatDataVariants {
    public static final BuiltInCoreRegistry<CatDataVariant> REGISTRY = ModBuiltinRegistries.CAT_VARIANTS;

    private static class_5321<CatDataVariant> register(String key) {
        return CatDataVariants.register(key, SpawnPrioritySelectors.fallback(0));
    }

    private static class_5321<CatDataVariant> register(String key, SpawnPrioritySelectors selectors) {
        class_2960 texture = class_2960.method_60656((String)("entity/cat/" + key));
        return REGISTRY.resource(key, new CatDataVariant(new ClientAsset(texture), selectors));
    }
}

