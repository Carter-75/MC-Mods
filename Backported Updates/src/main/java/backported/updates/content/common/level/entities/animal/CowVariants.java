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
import backported.updates.content.common.level.entities.animal.CowVariant;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;

public class CowVariants {
    public static final BuiltInCoreRegistry<CowVariant> REGISTRY = ModBuiltinRegistries.COW_VARIANTS;
    public static final RegistryKey<CowVariant> TEMPERATE = CowVariants.register("temperate", CowVariant.ModelType.NORMAL, "cow", SpawnPrioritySelectors.fallback(0));
    public static final RegistryKey<CowVariant> WARM = CowVariants.register("warm", CowVariant.ModelType.WARM, "warm_cow", ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS);
    public static final RegistryKey<CowVariant> COLD = CowVariants.register("cold", CowVariant.ModelType.COLD, "cold_cow", ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);

    private static RegistryKey<CowVariant> register(String key, CowVariant.ModelType type, String assetId, TagKey<Biome> biome) {
        return CowVariants.register(key, type, assetId, SpawnPrioritySelectors.single(new RawBiomeCheck(biome), 1));
    }

    private static RegistryKey<CowVariant> register(String key, CowVariant.ModelType type, String assetId, SpawnPrioritySelectors selectors) {
        Identifier path = Identifier.ofVanilla((String)("entity/cow/" + assetId));
        return REGISTRY.resource(key, new CowVariant(new ModelAndTexture<CowVariant.ModelType>(type, path), selectors));
    }
}

