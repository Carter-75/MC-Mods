/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.property.EnumProperty
 *  net.minecraft.state.property.IntProperty
 *  net.minecraft.Property
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.world.gen.feature.Feature
 *  net.minecraft.world.gen.feature.FeatureConfig
 *  net.minecraft.world.gen.feature.SimpleBlockFeatureConfig
 *  net.minecraft.world.gen.feature.RandomPatchFeatureConfig
 *  net.minecraft.world.gen.stateprovider.BlockStateProvider
 *  net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.util.collection.DataPool
 *  net.minecraft.util.collection.DataPool$Builder
 *  net.minecraft.util.math.intprovider.IntProvider
 *  net.minecraft.util.math.intprovider.UniformIntProvider
 *  net.minecraft.BlockPredicate
 *  net.minecraft.world.gen.feature.ConfiguredFeatures
 *  net.minecraft.world.gen.feature.PlacedFeatures
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registerable
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.block.FlowerbedBlock
 */
package backported.updates.content.common.worldgen.features;

import backported.updates.content.common.level.features.FallenTreeConfiguration;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModFeatures;
import backported.updates.content.common.worldgen.treedecorators.AttachedToLogsDecorator;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import com.google.common.collect.ImmutableList;
import java.util.List;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.block.FlowerbedBlock;

public class SpringToLifeFeatures {
    public static final WorldGenRegistry<ConfiguredFeature<?, ?>> FEATURES = WorldGenRegistry.of(RegistryKeys.CONFIGURED_FEATURE, "minecraft");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_BUSH = FEATURES.create("patch_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_FIREFLY_BUSH = FEATURES.create("patch_firefly_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILDFLOWERS_BIRCH_FOREST = FEATURES.create("wildflowers_birch_forest");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILDFLOWERS_MEADOW = FEATURES.create("wildflowers_meadow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_DRY_GRASS = FEATURES.create("patch_dry_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_LEAF_LITTER = FEATURES.create("patch_leaf_litter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEAF_LITTER = FEATURES.create("leaf_litter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CACTUS_FLOWER = FEATURES.create("cactus_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = FEATURES.create("fallen_oak_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_BIRCH_TREE = FEATURES.create("fallen_birch_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SUPER_BIRCH_TREE = FEATURES.create("fallen_super_birch_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_JUNGLE_TREE = FEATURES.create("fallen_jungle_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SPRUCE_TREE = FEATURES.create("fallen_spruce_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        FEATURES.register(context, PATCH_BUSH, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(25, 5, 3, PlacedFeatures.createEntry((Feature)Feature.SIMPLE_BLOCK, (FeatureConfig)new SimpleBlockFeatureConfig((BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.BUSH.get())))));
        FEATURES.register(context, PATCH_FIREFLY_BUSH, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(20, 4, 3, PlacedFeatures.createEntry((Feature)Feature.SIMPLE_BLOCK, (FeatureConfig)new SimpleBlockFeatureConfig((BlockStateProvider)BlockStateProvider.of((Block)ModBlocks.FIREFLY_BUSH.get())))));
        FEATURES.register(context, WILDFLOWERS_BIRCH_FOREST, Feature.FLOWER, new RandomPatchFeatureConfig(64, 6, 2, PlacedFeatures.createEntry((Feature)Feature.SIMPLE_BLOCK, (FeatureConfig)new SimpleBlockFeatureConfig((BlockStateProvider)new WeightedBlockStateProvider(SpringToLifeFeatures.flowerBedPatchBuilder(ModBlocks.WILDFLOWERS.get()).build())))));
        FEATURES.register(context, WILDFLOWERS_MEADOW, Feature.FLOWER, new RandomPatchFeatureConfig(8, 6, 2, PlacedFeatures.createEntry((Feature)Feature.SIMPLE_BLOCK, (FeatureConfig)new SimpleBlockFeatureConfig((BlockStateProvider)new WeightedBlockStateProvider(SpringToLifeFeatures.flowerBedPatchBuilder(ModBlocks.WILDFLOWERS.get()).build())))));
        FEATURES.register(context, PATCH_DRY_GRASS, Feature.RANDOM_PATCH, SpringToLifeFeatures.grassPatch((BlockStateProvider)new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.SHORT_DRY_GRASS.get().getDefaultState(), 1).add(ModBlocks.TALL_DRY_GRASS.get().getDefaultState(), 1).build()), 64));
        FEATURES.register(context, PATCH_LEAF_LITTER, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig((int)32, (RegistryEntry)PlacedFeatures.createEntry((Feature)Feature.SIMPLE_BLOCK, (FeatureConfig)new SimpleBlockFeatureConfig((BlockStateProvider)new WeightedBlockStateProvider(SpringToLifeFeatures.leafLitterPatchBuilder(1, 3).build())), (BlockPredicate)BlockPredicate.bothOf((BlockPredicate)BlockPredicate.IS_AIR, (BlockPredicate)BlockPredicate.matchingBlocks((Vec3i)Direction.DOWN.getVector(), (Block[])new Block[]{Blocks.GRASS_BLOCK})))));
        FEATURES.register(context, FALLEN_OAK_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenOak().build());
        FEATURES.register(context, FALLEN_BIRCH_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenBirch(8).build());
        FEATURES.register(context, FALLEN_SUPER_BIRCH_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenBirch(15).build());
        FEATURES.register(context, FALLEN_JUNGLE_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenJungle().build());
        FEATURES.register(context, FALLEN_SPRUCE_TREE, ModFeatures.FALLEN_TREE.get(), SpringToLifeFeatures.createFallenSpruce().build());
        FEATURES.register(context, LEAF_LITTER, ModFeatures.LEAF_LITTER.get(), FeatureConfig.DEFAULT);
        FEATURES.register(context, CACTUS_FLOWER, ModFeatures.CACTUS_FLOWER.get(), FeatureConfig.DEFAULT);
    }

    private static RandomPatchFeatureConfig grassPatch(BlockStateProvider provider, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig((int)tries, (RegistryEntry)PlacedFeatures.createEntry((Feature)Feature.SIMPLE_BLOCK, (FeatureConfig)new SimpleBlockFeatureConfig(provider)));
    }

    private static DataPool.Builder<BlockState> flowerBedPatchBuilder(Block block) {
        return SpringToLifeFeatures.segmentedBlockPatchBuilder(block, 1, 4, FlowerbedBlock.FLOWER_AMOUNT, (EnumProperty<Direction>)FlowerbedBlock.FACING);
    }

    private static DataPool.Builder<BlockState> leafLitterPatchBuilder(int min, int max) {
        return SpringToLifeFeatures.segmentedBlockPatchBuilder(ModBlocks.LEAF_LITTER.get(), min, max, FlowerbedBlock.FLOWER_AMOUNT, (EnumProperty<Direction>)FlowerbedBlock.FACING);
    }

    private static DataPool.Builder<BlockState> segmentedBlockPatchBuilder(Block block, int min, int max, IntProperty amount, EnumProperty<Direction> facing) {
        DataPool.Builder<BlockState> builder = DataPool.builder();
        for (int i = min; i <= max; ++i) {
            for (Direction direction : Direction.Type.HORIZONTAL) {
                builder.add(((block.getDefaultState().with(amount, Integer.valueOf(i))).with(facing, direction)), 1);
            }
        }
        return builder;
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenOak() {
        return SpringToLifeFeatures.createFallenTrees(Blocks.OAK_LOG, 4, 7).stumpDecorators(List.of(TrunkVineTreeDecorator.INSTANCE));
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenBirch(int i) {
        return SpringToLifeFeatures.createFallenTrees(Blocks.BIRCH_LOG, 5, i);
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenJungle() {
        return SpringToLifeFeatures.createFallenTrees(Blocks.JUNGLE_LOG, 4, 11).stumpDecorators(List.of(TrunkVineTreeDecorator.INSTANCE));
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenSpruce() {
        return SpringToLifeFeatures.createFallenTrees(Blocks.SPRUCE_LOG, 6, 10);
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenTrees(Block block, int minLength, int maxLength) {
        return new FallenTreeConfiguration.FallenTreeConfigurationBuilder((BlockStateProvider)BlockStateProvider.of((Block)block), (IntProvider)UniformIntProvider.create((int)minLength, (int)maxLength)).logDecorators(List.of(new AttachedToLogsDecorator(0.1f, (BlockStateProvider)new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 2).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1).build()), List.of(Direction.UP))));
    }
}

