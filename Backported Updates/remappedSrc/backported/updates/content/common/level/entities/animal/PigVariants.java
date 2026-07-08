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

import backported.updates.content.common.api.variant.ModelAndTexture;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import backported.updates.content.common.api.variant.spawn.check.raw.RawBiomeCheck;
import backported.updates.content.common.level.entities.animal.PigVariant;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.class_1959;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;

public class PigVariants {
    public static final BuiltInCoreRegistry<PigVariant> REGISTRY = ModBuiltinRegistries.PIG_VARIANTS;
    public static final class_5321<PigVariant> TEMPERATE = PigVariants.register("temperate", PigVariant.ModelType.NORMAL, "pig", SpawnPrioritySelectors.fallback(0));
    public static final class_5321<PigVariant> WARM = PigVariants.register("warm", PigVariant.ModelType.NORMAL, "warm_pig", ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS);
    public static final class_5321<PigVariant> COLD = PigVariants.register("cold", PigVariant.ModelType.COLD, "cold_pig", ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);

    private static class_5321<PigVariant> register(String key, PigVariant.ModelType type, String assetId, class_6862<class_1959> biome) {
        return PigVariants.register(key, type, assetId, SpawnPrioritySelectors.single(new RawBiomeCheck(biome), 1));
    }

    private static class_5321<PigVariant> register(String key, PigVariant.ModelType type, String assetId, SpawnPrioritySelectors selectors) {
        class_2960 path = class_2960.method_60656((String)("entity/pig/" + assetId));
        return REGISTRY.resource(key, new PigVariant(new ModelAndTexture<PigVariant.ModelType>(type, path), selectors));
    }
}

