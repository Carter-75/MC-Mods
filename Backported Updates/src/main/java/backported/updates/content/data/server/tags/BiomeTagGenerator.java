/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.BiomeKeys
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.tag.BiomeTags
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModBiomes;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported.updates.content.core.data.tags.fabric.FabricBiomeTags;
import backported.updates.content.core.data.tags.forge.ForgeBiomeTags;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;

public class BiomeTagGenerator
extends FabricTagProvider<Biome> {
    public BiomeTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookupProvider) {
        super(output, RegistryKeys.BIOME, lookupProvider);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider) {
        this.addEntityPlacementTags(provider);
        this.addFeaturePlacementTags(provider);
        this.getOrCreateTagBuilder(BiomeTags.IS_FOREST).add(ModBiomes.PALE_GARDEN);
        this.getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD).add(ModBiomes.PALE_GARDEN);
        this.getOrCreateTagBuilder(BiomeTags.WOODLAND_MANSION_HAS_STRUCTURE).add(ModBiomes.PALE_GARDEN);
        this.getOrCreateTagBuilder(BiomeTags.STRONGHOLD_BIASED_TO).add(ModBiomes.PALE_GARDEN);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS).add(BiomeKeys.SNOWY_PLAINS).add(BiomeKeys.ICE_SPIKES).add(BiomeKeys.FROZEN_PEAKS).add(BiomeKeys.JAGGED_PEAKS).add(BiomeKeys.SNOWY_SLOPES).add(BiomeKeys.FROZEN_OCEAN).add(BiomeKeys.DEEP_FROZEN_OCEAN).add(BiomeKeys.GROVE).add(BiomeKeys.DEEP_DARK).add(BiomeKeys.FROZEN_RIVER).add(BiomeKeys.SNOWY_TAIGA).add(BiomeKeys.SNOWY_BEACH).add(BiomeKeys.COLD_OCEAN).add(BiomeKeys.DEEP_COLD_OCEAN).add(BiomeKeys.OLD_GROWTH_PINE_TAIGA).add(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA).add(BiomeKeys.TAIGA).add(BiomeKeys.WINDSWEPT_FOREST).add(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS).add(BiomeKeys.STONY_PEAKS).forceAddTag(BiomeTags.IS_END).addOptionalTag(ForgeBiomeTags.IS_COLD).addOptionalTag(ForgeBiomeTags.IS_SNOWY).addOptionalTag(FabricBiomeTags.CLIMATE_COLD).addOptionalTag(FabricBiomeTags.SNOWY).addOptionalTag(FabricBiomeTags.ICY);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS).add(BiomeKeys.DESERT).add(BiomeKeys.WARM_OCEAN).add(BiomeKeys.MANGROVE_SWAMP).add(BiomeKeys.DEEP_LUKEWARM_OCEAN).add(BiomeKeys.LUKEWARM_OCEAN).forceAddTag(BiomeTags.IS_NETHER).forceAddTag(BiomeTags.IS_SAVANNA).forceAddTag(BiomeTags.IS_JUNGLE).forceAddTag(BiomeTags.IS_BADLANDS).addOptionalTag(ForgeBiomeTags.IS_HOT).addOptionalTag(FabricBiomeTags.CLIMATE_HOT);
    }

    protected void addEntityPlacementTags(RegistryWrapper.WrapperLookup provider) {
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_CAMELS).addOptionalTag(FabricBiomeTags.DESERT).addOptionalTag(ForgeBiomeTags.IS_DESERT);
    }

    protected void addFeaturePlacementTags(RegistryWrapper.WrapperLookup provider) {
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_BUSHES).forceAddTag(BiomeTags.IS_HILL).forceAddTag(BiomeTags.IS_RIVER).add(BiomeKeys.FOREST).add(BiomeKeys.BIRCH_FOREST).add(BiomeKeys.OLD_GROWTH_BIRCH_FOREST).addOptionalTag(ForgeBiomeTags.IS_PLAINS).addOptionalTag(FabricBiomeTags.PLAINS);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FIREFLY_BUSHES).forceAddTag(BiomeTags.IS_BEACH).forceAddTag(BiomeTags.IS_RIVER).forceAddTag(BiomeTags.IS_TAIGA).forceAddTag(BiomeTags.IS_FOREST).forceAddTag(BiomeTags.IS_OCEAN).forceAddTag(BiomeTags.IS_SAVANNA).forceAddTag(BiomeTags.IS_HILL).forceAddTag(BiomeTags.IS_JUNGLE).forceAddTag(BiomeTags.IS_BADLANDS).addOptionalTag(ForgeBiomeTags.IS_PLAINS).addOptionalTag(FabricBiomeTags.PLAINS).addOptionalTag(ForgeBiomeTags.IS_MUSHROOM).addOptionalTag(FabricBiomeTags.MUSHROOM).add(BiomeKeys.MANGROVE_SWAMP);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FIREFLY_BUSHES_SWAMP).addOptionalTag(ForgeBiomeTags.IS_SWAMP).addOptionalTag(FabricBiomeTags.SWAMP);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_WILDFLOWERS).add(BiomeKeys.BIRCH_FOREST).add(BiomeKeys.OLD_GROWTH_BIRCH_FOREST).addOptionalTag(FabricBiomeTags.BIRCH_FOREST);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_NOISE_BASED_WILDFLOWERS).add(BiomeKeys.MEADOW);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_DRY_GRASS).addOptionalTag(FabricBiomeTags.DESERT).addOptionalTag(ForgeBiomeTags.IS_DESERT);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_DRY_GRASS_RARELY).forceAddTag(BiomeTags.IS_BADLANDS);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_OAK_TREES).add(BiomeKeys.DARK_FOREST).forceAddTag(BiomeTags.IS_BADLANDS).forceAddTag(BiomeTags.IS_SAVANNA).forceAddTag(BiomeTags.IS_HILL).add(BiomeKeys.FOREST).add(BiomeKeys.FLOWER_FOREST).addOptionalTag(FabricBiomeTags.PLAINS).addOptionalTag(ForgeBiomeTags.IS_PLAINS);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_BIRCH_TREES_RARELY).forceAddTag(BiomeTags.IS_FOREST);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_BIRCH_TREES).add(BiomeKeys.BIRCH_FOREST).add(BiomeKeys.OLD_GROWTH_BIRCH_FOREST).addOptionalTag(FabricBiomeTags.BIRCH_FOREST);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_SUPER_BIRCH_TREES).add(BiomeKeys.OLD_GROWTH_BIRCH_FOREST);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_JUNGLE_TREES).forceAddTag(BiomeTags.IS_JUNGLE);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_SPRUCE_TREES).forceAddTag(BiomeTags.IS_TAIGA);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_SPRUCE_TREES_RARELY).forceAddTag(BiomeTags.IS_HILL);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_LEAF_LITTER_PATCHES).add(BiomeKeys.DARK_FOREST);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_LEAF_LITTER).add(new RegistryKey[]{BiomeKeys.FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.WOODED_BADLANDS});
        this.getOrCreateTagBuilder(ModBiomeTags.HAS_DARK_LEAF_LITTER).add(new RegistryKey[]{BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP});
        this.getOrCreateTagBuilder(ModBiomeTags.HAS_PALE_LEAF_LITTER).add(ModBiomes.PALE_GARDEN);
    }
}

