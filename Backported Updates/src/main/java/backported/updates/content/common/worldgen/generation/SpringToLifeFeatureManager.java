/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.SpawnGroup
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.biome.SpawnSettings$SpawnEntry
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.world.gen.feature.VegetationPlacedFeatures
 */
package backported.updates.content.common.worldgen.generation;

import backported.updates.content.common.registries.ModBiomes;
import backported.updates.content.common.worldgen.generation.FeatureManager;
import backported.updates.content.common.worldgen.placements.SpringToLifePlacements;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported.updates.foundation.common.worldgen.modifier.BiomeContext;
import backported.updates.foundation.common.worldgen.modifier.BiomeWriter;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class SpringToLifeFeatureManager
extends FeatureManager {
    public SpringToLifeFeatureManager(BiomeContext context, BiomeWriter writer) {
        super(context, writer);
    }

    @Override
    public void bootstrap() {
        this.addIf(VanillaBackport.COMMON_CONFIG.hasCamelSpawns.get(), (BiomeContext context, BiomeWriter writer) -> this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_CAMELS).add(() -> writer.addSpawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CAMEL, 1, 1, 1))));
        this.addIf(VanillaBackport.COMMON_CONFIG.hasBushes.get(), (BiomeContext context, BiomeWriter writer) -> this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_BUSHES).add(() -> this.addVegetation(SpringToLifePlacements.PATCH_BUSH)));
        this.addIf(VanillaBackport.COMMON_CONFIG.hasFireflyBushes.get(), (BiomeContext context, BiomeWriter writer) -> {
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_FIREFLY_BUSHES).add(() -> this.addVegetation(SpringToLifePlacements.PATCH_FIREFLY_BUSH_NEAR_WATER));
            this.getOrCreateBiomeBuilder(context.is(ModBiomeTags.SPAWNS_FIREFLY_BUSHES_SWAMP) && !context.is(ModBiomeTags.SPAWNS_FIREFLY_BUSHES)).add(() -> this.addVegetation(SpringToLifePlacements.PATCH_FIREFLY_BUSH_SWAMP)).add(() -> this.addVegetation(SpringToLifePlacements.PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP));
        });
        this.addIf(VanillaBackport.COMMON_CONFIG.hasWildflowers.get(), (BiomeContext context, BiomeWriter writer) -> {
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_NOISE_BASED_WILDFLOWERS).add(() -> this.addVegetation(SpringToLifePlacements.WILDFLOWERS_MEADOW));
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_WILDFLOWERS).add(() -> this.addVegetation(SpringToLifePlacements.WILDFLOWERS_BIRCH_FOREST));
        });
        this.addIf(VanillaBackport.COMMON_CONFIG.hasDryGrass.get(), (BiomeContext context, BiomeWriter writer) -> {
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_DRY_GRASS).add(() -> this.addVegetation(SpringToLifePlacements.PATCH_DRY_GRASS_DESERT));
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_DRY_GRASS_RARELY).add(() -> this.addVegetation(SpringToLifePlacements.PATCH_DRY_GRASS_BADLANDS));
        });
        this.addIf(VanillaBackport.COMMON_CONFIG.hasFallenTrees.get(), (BiomeContext context, BiomeWriter writer) -> {
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_FALLEN_OAK_TREES).add(() -> this.addVegetation(SpringToLifePlacements.PLACED_FALLEN_OAK_TREE));
            this.getOrCreateBiomeBuilder((BiomeContext ctx) -> ctx.is(ModBiomeTags.SPAWNS_FALLEN_BIRCH_TREES_RARELY) && !ctx.is(ModBiomes.PALE_GARDEN)).add(() -> this.addVegetation(SpringToLifePlacements.PLACED_RARE_FALLEN_BIRCH_TREE));
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_FALLEN_BIRCH_TREES).add(() -> this.addVegetation(SpringToLifePlacements.PLACED_FALLEN_BIRCH_TREE));
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_FALLEN_SUPER_BIRCH_TREES).add(() -> this.addVegetation(SpringToLifePlacements.PLACED_FALLEN_SUPER_BIRCH_TREE));
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_FALLEN_JUNGLE_TREES).add(() -> this.addVegetation(SpringToLifePlacements.PLACED_FALLEN_JUNGLE_TREE));
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_FALLEN_SPRUCE_TREES).add(() -> this.addVegetation(SpringToLifePlacements.PLACED_FALLEN_SPRUCE_TREE));
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_FALLEN_SPRUCE_TREES_RARELY).add(() -> this.addVegetation(SpringToLifePlacements.PLACED_RARE_FALLEN_SPRUCE_TREE));
        });
        this.addIf(VanillaBackport.COMMON_CONFIG.hasLeafLitter.get(), (BiomeContext context, BiomeWriter writer) -> {
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_LEAF_LITTER_PATCHES).add(() -> this.addVegetation(SpringToLifePlacements.PATCH_LEAF_LITTER));
            this.getOrCreateBiomeBuilder(ModBiomeTags.SPAWNS_LEAF_LITTER).add(() -> this.addVegetation(SpringToLifePlacements.LEAF_LITTER));
        });
        this.addIf(VanillaBackport.COMMON_CONFIG.hasCactusFlowers.get(), (BiomeContext context, BiomeWriter writer) -> {
            if (context.hasFeature((RegistryKey<PlacedFeature>)VegetationPlacedFeatures.PATCH_CACTUS_DECORATED) || context.hasFeature((RegistryKey<PlacedFeature>)VegetationPlacedFeatures.PATCH_CACTUS_DESERT)) {
                this.addVegetation(SpringToLifePlacements.CACTUS_FLOWER);
            }
        });
    }
}

