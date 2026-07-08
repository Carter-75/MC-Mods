/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.world.gen.placementmodifier.NoiseThresholdCountPlacementModifier
 *  net.minecraft.fluid.Fluid
 *  net.minecraft.fluid.Fluids
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.gen.placementmodifier.SquarePlacementModifier
 *  net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier
 *  net.minecraft.BlockPredicate
 *  net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier
 *  net.minecraft.world.gen.placementmodifier.BiomePlacementModifier
 *  net.minecraft.world.gen.placementmodifier.CountPlacementModifier
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.world.gen.placementmodifier.PlacementModifier
 *  net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier
 *  net.minecraft.world.gen.feature.PlacedFeatures
 *  net.minecraft.world.gen.feature.VegetationPlacedFeatures
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.entry.RegistryEntry$Reference
 *  net.minecraft.registry.RegistryEntryLookup
 *  net.minecraft.registry.Registerable
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.worldgen.placements;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.worldgen.features.SpringToLifeFeatures;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.BlockState;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.placementmodifier.NoiseThresholdCountPlacementModifier;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;

public class SpringToLifePlacements {
    public static final WorldGenRegistry<PlacedFeature> FEATURES = WorldGenRegistry.of(RegistryKeys.PLACED_FEATURE, "minecraft");
    public static final RegistryKey<PlacedFeature> PATCH_BUSH = FEATURES.create("patch_bush");
    public static final RegistryKey<PlacedFeature> PATCH_FIREFLY_BUSH_NEAR_WATER = FEATURES.create("patch_firefly_bush_near_water");
    public static final RegistryKey<PlacedFeature> PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP = FEATURES.create("patch_firefly_bush_near_water_swamp");
    public static final RegistryKey<PlacedFeature> PATCH_FIREFLY_BUSH_SWAMP = FEATURES.create("patch_firefly_bush_swamp");
    public static final RegistryKey<PlacedFeature> WILDFLOWERS_BIRCH_FOREST = FEATURES.create("wildflowers_birch_forest");
    public static final RegistryKey<PlacedFeature> WILDFLOWERS_MEADOW = FEATURES.create("wildflowers_meadow");
    public static final RegistryKey<PlacedFeature> PATCH_DRY_GRASS_BADLANDS = FEATURES.create("patch_dry_grass_badlands");
    public static final RegistryKey<PlacedFeature> PATCH_DRY_GRASS_DESERT = FEATURES.create("patch_dry_grass_desert");
    public static final RegistryKey<PlacedFeature> PATCH_LEAF_LITTER = FEATURES.create("patch_leaf_litter");
    public static final RegistryKey<PlacedFeature> LEAF_LITTER = FEATURES.create("leaf_litter");
    public static final RegistryKey<PlacedFeature> CACTUS_FLOWER = FEATURES.create("cactus_flower");
    public static final RegistryKey<PlacedFeature> FALLEN_OAK_TREE = FEATURES.create("fallen_oak_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_BIRCH_TREE = FEATURES.create("fallen_birch_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_SUPER_BIRCH_TREE = FEATURES.create("fallen_super_birch_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_JUNGLE_TREE = FEATURES.create("fallen_jungle_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_SPRUCE_TREE = FEATURES.create("fallen_spruce_tree");
    public static final RegistryKey<PlacedFeature> PLACED_FALLEN_OAK_TREE = FEATURES.create("placed_fallen_oak_tree");
    public static final RegistryKey<PlacedFeature> PLACED_RARE_FALLEN_BIRCH_TREE = FEATURES.create("placed_rare_fallen_birch_tree");
    public static final RegistryKey<PlacedFeature> PLACED_FALLEN_BIRCH_TREE = FEATURES.create("placed_fallen_birch_tree");
    public static final RegistryKey<PlacedFeature> PLACED_FALLEN_SUPER_BIRCH_TREE = FEATURES.create("placed_fallen_super_birch_tree");
    public static final RegistryKey<PlacedFeature> PLACED_FALLEN_JUNGLE_TREE = FEATURES.create("placed_fallen_jungle_tree");
    public static final RegistryKey<PlacedFeature> PLACED_FALLEN_SPRUCE_TREE = FEATURES.create("placed_fallen_spruce_tree");
    public static final RegistryKey<PlacedFeature> PLACED_RARE_FALLEN_SPRUCE_TREE = FEATURES.create("placed_rare_fallen_spruce_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup features = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry.Reference patch = features.getOrThrow(SpringToLifeFeatures.PATCH_FIREFLY_BUSH);
        FEATURES.register(context, PATCH_BUSH, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.PATCH_BUSH), new PlacementModifier[]{RarityFilterPlacementModifier.of((int)4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        FEATURES.register(context, PATCH_FIREFLY_BUSH_NEAR_WATER, (RegistryEntry<ConfiguredFeature<?, ?>>)patch, new PlacementModifier[]{CountPlacementModifier.of((int)2), SquarePlacementModifier.of(), HeightmapPlacementModifier.of((Heightmap.Type)Heightmap.Type.MOTION_BLOCKING_NO_LEAVES), BiomePlacementModifier.of(), SpringToLifePlacements.nearWaterPredicate(ModBlocks.FIREFLY_BUSH.get())});
        FEATURES.register(context, PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP, (RegistryEntry<ConfiguredFeature<?, ?>>)patch, new PlacementModifier[]{CountPlacementModifier.of((int)3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of(), SpringToLifePlacements.nearWaterPredicate(ModBlocks.FIREFLY_BUSH.get())});
        FEATURES.register(context, PATCH_FIREFLY_BUSH_SWAMP, (RegistryEntry<ConfiguredFeature<?, ?>>)patch, new PlacementModifier[]{RarityFilterPlacementModifier.of((int)8), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        FEATURES.register(context, WILDFLOWERS_BIRCH_FOREST, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.WILDFLOWERS_BIRCH_FOREST), new PlacementModifier[]{CountPlacementModifier.of((int)3), RarityFilterPlacementModifier.of((int)2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        FEATURES.register(context, WILDFLOWERS_MEADOW, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.WILDFLOWERS_MEADOW), new PlacementModifier[]{NoiseThresholdCountPlacementModifier.of((double)-0.8, (int)5, (int)10), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        FEATURES.register(context, PATCH_DRY_GRASS_BADLANDS, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.PATCH_DRY_GRASS), new PlacementModifier[]{RarityFilterPlacementModifier.of((int)6), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        FEATURES.register(context, PATCH_DRY_GRASS_DESERT, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.PATCH_DRY_GRASS), new PlacementModifier[]{RarityFilterPlacementModifier.of((int)3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        FEATURES.register(context, PATCH_LEAF_LITTER, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.PATCH_LEAF_LITTER), VegetationPlacedFeatures.modifiers((int)2));
        FEATURES.register(context, FALLEN_OAK_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_OAK_TREE), new PlacementModifier[]{PlacedFeatures.wouldSurvive((Block)Blocks.OAK_SAPLING)});
        FEATURES.register(context, FALLEN_BIRCH_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_BIRCH_TREE), new PlacementModifier[]{PlacedFeatures.wouldSurvive((Block)Blocks.BIRCH_SAPLING)});
        FEATURES.register(context, FALLEN_SUPER_BIRCH_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_SUPER_BIRCH_TREE), new PlacementModifier[]{PlacedFeatures.wouldSurvive((Block)Blocks.BIRCH_SAPLING)});
        FEATURES.register(context, FALLEN_SPRUCE_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_SPRUCE_TREE), new PlacementModifier[]{PlacedFeatures.wouldSurvive((Block)Blocks.SPRUCE_SAPLING)});
        FEATURES.register(context, FALLEN_JUNGLE_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_JUNGLE_TREE), new PlacementModifier[]{PlacedFeatures.wouldSurvive((Block)Blocks.JUNGLE_SAPLING)});
        FEATURES.register(context, LEAF_LITTER, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.LEAF_LITTER), VegetationPlacedFeatures.treeModifiers((PlacementModifier)PlacedFeatures.createCountExtraModifier((int)16, (float)0.1f, (int)1)));
        FEATURES.register(context, CACTUS_FLOWER, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.CACTUS_FLOWER), VegetationPlacedFeatures.treeModifiers((PlacementModifier)PlacedFeatures.createCountExtraModifier((int)16, (float)0.1f, (int)1)));
        FEATURES.register(context, PLACED_FALLEN_OAK_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_OAK_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive((PlacementModifier)RarityFilterPlacementModifier.of((int)80), (Block)Blocks.OAK_SAPLING));
        FEATURES.register(context, PLACED_RARE_FALLEN_BIRCH_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_BIRCH_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive((PlacementModifier)RarityFilterPlacementModifier.of((int)400), (Block)Blocks.BIRCH_SAPLING));
        FEATURES.register(context, PLACED_FALLEN_BIRCH_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_BIRCH_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive((PlacementModifier)RarityFilterPlacementModifier.of((int)80), (Block)Blocks.BIRCH_SAPLING));
        FEATURES.register(context, PLACED_FALLEN_SUPER_BIRCH_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_SUPER_BIRCH_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive((PlacementModifier)RarityFilterPlacementModifier.of((int)160), (Block)Blocks.BIRCH_SAPLING));
        FEATURES.register(context, PLACED_FALLEN_JUNGLE_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_JUNGLE_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive((PlacementModifier)RarityFilterPlacementModifier.of((int)80), (Block)Blocks.JUNGLE_SAPLING));
        FEATURES.register(context, PLACED_FALLEN_SPRUCE_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_SPRUCE_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive((PlacementModifier)RarityFilterPlacementModifier.of((int)80), (Block)Blocks.SPRUCE_SAPLING));
        FEATURES.register(context, PLACED_RARE_FALLEN_SPRUCE_TREE, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(SpringToLifeFeatures.FALLEN_SPRUCE_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive((PlacementModifier)RarityFilterPlacementModifier.of((int)120), (Block)Blocks.SPRUCE_SAPLING));
    }

    public static BlockFilterPlacementModifier nearWaterPredicate(Block block) {
        return BlockFilterPlacementModifier.of((BlockPredicate)BlockPredicate.allOf((BlockPredicate[])new BlockPredicate[]{BlockPredicate.IS_AIR, BlockPredicate.wouldSurvive(block.getDefaultState(), (Vec3i)BlockPos.ORIGIN), BlockPredicate.anyOf((BlockPredicate[])new BlockPredicate[]{BlockPredicate.matchingFluids((Vec3i)new BlockPos(1, -1, 0), (Fluid[])new Fluid[]{Fluids.WATER, Fluids.FLOWING_WATER}), BlockPredicate.matchingFluids((Vec3i)new BlockPos(-1, -1, 0), (Fluid[])new Fluid[]{Fluids.WATER, Fluids.FLOWING_WATER}), BlockPredicate.matchingFluids((Vec3i)new BlockPos(0, -1, 1), (Fluid[])new Fluid[]{Fluids.WATER, Fluids.FLOWING_WATER}), BlockPredicate.matchingFluids((Vec3i)new BlockPos(0, -1, -1), (Fluid[])new Fluid[]{Fluids.WATER, Fluids.FLOWING_WATER})})}));
    }
}

