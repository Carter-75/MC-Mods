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
import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.class_1959;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;

public class ChickenVariants {
    public static final BuiltInCoreRegistry<ChickenVariant> REGISTRY = ModBuiltinRegistries.CHICKEN_VARIANTS;
    public static final class_5321<ChickenVariant> TEMPERATE = ChickenVariants.register("temperate", ChickenVariant.ModelType.NORMAL, class_2960.method_60656((String)"entity/chicken"), SpawnPrioritySelectors.fallback(0));
    public static final class_5321<ChickenVariant> WARM = ChickenVariants.register("warm", ChickenVariant.ModelType.NORMAL, "warm_chicken", ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS);
    public static final class_5321<ChickenVariant> COLD = ChickenVariants.register("cold", ChickenVariant.ModelType.COLD, "cold_chicken", ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);

    private static class_5321<ChickenVariant> register(String key, ChickenVariant.ModelType type, String assetId, class_6862<class_1959> biome) {
        class_2960 path = class_2960.method_60656((String)("entity/chicken/" + assetId));
        return ChickenVariants.register(key, type, path, SpawnPrioritySelectors.single(new RawBiomeCheck(biome), 1));
    }

    private static class_5321<ChickenVariant> register(String key, ChickenVariant.ModelType type, class_2960 assetId, SpawnPrioritySelectors selectors) {
        return REGISTRY.resource(key, new ChickenVariant(new ModelAndTexture<ChickenVariant.ModelType>(type, assetId), selectors));
    }
}

