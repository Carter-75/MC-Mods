/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.tag.TagKey
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.common.api.variant.ModelAndTexture;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import backported.updates.content.common.api.variant.spawn.check.raw.RawBiomeCheck;
import backported.updates.content.common.level.entities.animal.PigVariant;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;

public class PigVariants {
    public static final BuiltInCoreRegistry<PigVariant> REGISTRY = ModBuiltinRegistries.PIG_VARIANTS;
    public static final RegistryKey<PigVariant> TEMPERATE = PigVariants.register("temperate", PigVariant.ModelType.NORMAL, "pig", SpawnPrioritySelectors.fallback(0));
    public static final RegistryKey<PigVariant> WARM = PigVariants.register("warm", PigVariant.ModelType.NORMAL, "warm_pig", ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS);
    public static final RegistryKey<PigVariant> COLD = PigVariants.register("cold", PigVariant.ModelType.COLD, "cold_pig", ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);

    private static RegistryKey<PigVariant> register(String key, PigVariant.ModelType type, String assetId, TagKey<Biome> biome) {
        return PigVariants.register(key, type, assetId, SpawnPrioritySelectors.single(new RawBiomeCheck(biome), 1));
    }

    private static RegistryKey<PigVariant> register(String key, PigVariant.ModelType type, String assetId, SpawnPrioritySelectors selectors) {
        Identifier path = Identifier.ofVanilla((String)("entity/pig/" + assetId));
        return REGISTRY.resource(key, new PigVariant(new ModelAndTexture<PigVariant.ModelType>(type, path), selectors));
    }
}

