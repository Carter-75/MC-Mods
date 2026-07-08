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
import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;

public class ChickenVariants {
    public static final BuiltInCoreRegistry<ChickenVariant> REGISTRY = ModBuiltinRegistries.CHICKEN_VARIANTS;
    public static final RegistryKey<ChickenVariant> TEMPERATE = ChickenVariants.register("temperate", ChickenVariant.ModelType.NORMAL, Identifier.ofVanilla((String)"entity/chicken"), SpawnPrioritySelectors.fallback(0));
    public static final RegistryKey<ChickenVariant> WARM = ChickenVariants.register("warm", ChickenVariant.ModelType.NORMAL, "warm_chicken", ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS);
    public static final RegistryKey<ChickenVariant> COLD = ChickenVariants.register("cold", ChickenVariant.ModelType.COLD, "cold_chicken", ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);

    private static RegistryKey<ChickenVariant> register(String key, ChickenVariant.ModelType type, String assetId, TagKey<Biome> biome) {
        Identifier path = Identifier.ofVanilla((String)("entity/chicken/" + assetId));
        return ChickenVariants.register(key, type, path, SpawnPrioritySelectors.single(new RawBiomeCheck(biome), 1));
    }

    private static RegistryKey<ChickenVariant> register(String key, ChickenVariant.ModelType type, Identifier assetId, SpawnPrioritySelectors selectors) {
        return REGISTRY.resource(key, new ChickenVariant(new ModelAndTexture<ChickenVariant.ModelType>(type, assetId), selectors));
    }
}

