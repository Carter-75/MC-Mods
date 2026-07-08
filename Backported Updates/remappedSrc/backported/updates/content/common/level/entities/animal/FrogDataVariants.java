/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1959
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.common.api.variant.ClientAsset;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import backported.updates.content.common.api.variant.spawn.check.raw.RawBiomeCheck;
import backported.updates.content.common.level.entities.animal.FrogDataVariant;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.class_1959;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;

public class FrogDataVariants {
    public static final BuiltInCoreRegistry<FrogDataVariant> REGISTRY = ModBuiltinRegistries.FROG_VARIANTS;

    private static class_5321<FrogDataVariant> register(String key, class_6862<class_1959> biome) {
        return FrogDataVariants.register(key, SpawnPrioritySelectors.single(new RawBiomeCheck(biome), 1));
    }

    private static class_5321<FrogDataVariant> register(String key, SpawnPrioritySelectors selectors) {
        class_2960 texture = class_2960.method_60656((String)("entity/frog/" + key + "_frog"));
        return REGISTRY.resource(key, new FrogDataVariant(new ClientAsset(texture), selectors));
    }
}

