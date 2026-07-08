/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.world.gen.feature.Feature
 *  net.minecraft.world.gen.feature.FeatureConfig
 *  net.minecraft.world.gen.feature.RandomFeatureConfig
 *  net.minecraft.world.gen.feature.SimpleBlockFeatureConfig
 *  net.minecraft.world.gen.feature.RandomFeatureEntry
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.world.gen.feature.RandomPatchFeatureConfig
 *  net.minecraft.world.gen.feature.TreeFeatureConfig$Builder
 *  net.minecraft.world.gen.foliage.FoliagePlacer
 *  net.minecraft.world.gen.stateprovider.BlockStateProvider
 *  net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider
 *  net.minecraft.world.gen.trunk.TrunkPlacer
 *  net.minecraft.world.gen.feature.size.FeatureSize
 *  net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize
 *  net.minecraft.world.gen.foliage.DarkOakFoliagePlacer
 *  net.minecraft.world.gen.trunk.DarkOakTrunkPlacer
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.gen.feature.VegetationPatchFeatureConfig
 *  net.minecraft.util.math.VerticalSurfaceType
 *  net.minecraft.util.collection.DataPool
 *  net.minecraft.util.math.intprovider.ConstantIntProvider
 *  net.minecraft.util.math.intprovider.IntProvider
 *  net.minecraft.util.math.intprovider.UniformIntProvider
 *  net.minecraft.world.gen.placementmodifier.PlacementModifier
 *  net.minecraft.world.gen.feature.ConfiguredFeatures
 *  net.minecraft.world.gen.feature.PlacedFeatures
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.RegistryEntryLookup
 *  net.minecraft.registry.Registerable
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.worldgen.features;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.worldgen.placements.TheGardenAwakensPlacements;
import backported.updates.content.common.worldgen.treedecorators.CreakingHeartDecorator;
import backported.updates.content.common.worldgen.treedecorators.PaleMossDecorator;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalInt;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.VegetationPatchFeatureConfig;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;

public class TheGardenAwakensFeatures {
    public static final WorldGenRegistry<ConfiguredFeature<?, ?>> FEATURES = WorldGenRegistry.of(RegistryKeys.CONFIGURED_FEATURE, "backported_updates");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_OAK = FEATURES.create("pale_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_OAK_BONEMEAL = FEATURES.create("pale_oak_tree_bonemeal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_OAK_CREAKING = FEATURES.create("pale_oak_tree_creaking");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_PALE_GARDEN = FEATURES.create("flower_pale_garden");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_GARDEN_FLOWERS = FEATURES.create("pale_garden_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_GARDEN_VEGETATION = FEATURES.create("pale_garden_vegetation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_MOSS_VEGETATION = FEATURES.create("pale_moss_vegetation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_MOSS_PATCH = FEATURES.create("pale_moss_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_MOSS_PATCH_BONEMEAL = FEATURES.create("pale_moss_patch_bonemeal");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RegistryEntryLookup features = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntryLookup placements = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        FEATURES.register(context, PALE_OAK, Feature.TREE, new TreeFeatureConfig.Builder((BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.PALE_OAK_LOG.get()), (TrunkPlacer)new DarkOakTrunkPlacer(6, 2, 1), (BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.PALE_OAK_LEAVES.get()), (FoliagePlacer)new DarkOakFoliagePlacer((IntProvider)ConstantIntProvider.create((int)0), (IntProvider)ConstantIntProvider.create((int)0)), (FeatureSize)new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).decorators(List.of(new PaleMossDecorator(0.15f, 0.4f, 0.8f))).ignoreVines().build());
        FEATURES.register(context, PALE_OAK_BONEMEAL, Feature.TREE, new TreeFeatureConfig.Builder((BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.PALE_OAK_LOG.get()), (TrunkPlacer)new DarkOakTrunkPlacer(6, 2, 1), (BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.PALE_OAK_LEAVES.get()), (FoliagePlacer)new DarkOakFoliagePlacer((IntProvider)ConstantIntProvider.create((int)0), (IntProvider)ConstantIntProvider.create((int)0)), (FeatureSize)new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build());
        FEATURES.register(context, PALE_OAK_CREAKING, Feature.TREE, new TreeFeatureConfig.Builder((BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.PALE_OAK_LOG.get()), (TrunkPlacer)new DarkOakTrunkPlacer(6, 2, 1), (BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.PALE_OAK_LEAVES.get()), (FoliagePlacer)new DarkOakFoliagePlacer((IntProvider)ConstantIntProvider.create((int)0), (IntProvider)ConstantIntProvider.create((int)0)), (FeatureSize)new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).decorators(List.of(new PaleMossDecorator(0.15f, 0.4f, 0.8f), new CreakingHeartDecorator(1.0f))).ignoreVines().build());
        FEATURES.register(context, FLOWER_PALE_GARDEN, Feature.FLOWER, new RandomPatchFeatureConfig(1, 0, 0, PlacedFeatures.createEntry((Feature)Feature.SIMPLE_BLOCK, (FeatureConfig)new SimpleBlockFeatureConfig((BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.CLOSED_EYEBLOSSOM.get())))));
        FEATURES.register(context, PALE_GARDEN_FLOWERS, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig((Feature)Feature.SIMPLE_BLOCK, (FeatureConfig)new SimpleBlockFeatureConfig((BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.CLOSED_EYEBLOSSOM.get()))));
        FEATURES.register(context, PALE_GARDEN_VEGETATION, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry((RegistryEntry)placements.getOrThrow(TheGardenAwakensPlacements.PALE_OAK_CREAKING_CHECKED), 0.1f), new RandomFeatureEntry((RegistryEntry)placements.getOrThrow(TheGardenAwakensPlacements.PALE_OAK_CHECKED), 0.9f)), (RegistryEntry)placements.getOrThrow(TheGardenAwakensPlacements.PALE_OAK_CHECKED)));
        FEATURES.register(context, PALE_MOSS_VEGETATION, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig((BlockStateProvider)new WeightedBlockStateProvider(DataPool.<net.minecraft.block.BlockState>builder().add(ModBlocks.PALE_MOSS_CARPET.get().getDefaultState(), 25).add(Blocks.SHORT_GRASS.getDefaultState(), 25).add(Blocks.TALL_GRASS.getDefaultState(), 10).build())));
        FEATURES.register(context, PALE_MOSS_PATCH, Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE, (BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.PALE_MOSS_BLOCK.get()), PlacedFeatures.createEntry((RegistryEntry)features.getOrThrow(PALE_MOSS_VEGETATION), (PlacementModifier[])new PlacementModifier[0]), VerticalSurfaceType.FLOOR, (IntProvider)ConstantIntProvider.create((int)1), 0.0f, 5, 0.3f, (IntProvider)UniformIntProvider.create((int)2, (int)4), 0.75f));
        FEATURES.register(context, PALE_MOSS_PATCH_BONEMEAL, Feature.VEGETATION_PATCH, new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE, (BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.PALE_MOSS_BLOCK.get()), PlacedFeatures.createEntry((RegistryEntry)features.getOrThrow(PALE_MOSS_VEGETATION), (PlacementModifier[])new PlacementModifier[0]), VerticalSurfaceType.FLOOR, (IntProvider)ConstantIntProvider.create((int)1), 0.0f, 5, 0.6f, (IntProvider)UniformIntProvider.create((int)1, (int)2), 0.75f));
    }
}

