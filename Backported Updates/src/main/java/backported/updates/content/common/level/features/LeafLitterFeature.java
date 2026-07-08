/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.gen.feature.Feature
 *  net.minecraft.world.gen.feature.DefaultFeatureConfig
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.world.WorldView
 *  net.minecraft.world.StructureWorldAccess
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.world.gen.feature.util.FeatureContext
 */
package backported.updates.content.common.level.features;

import backported.updates.content.common.level.blocks.LeafLitterBlock;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.data.tags.ModBlockTags;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.world.WorldView;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class LeafLitterFeature
extends Feature<DefaultFeatureConfig> {
    public LeafLitterFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess level = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int xRange = 0; xRange < 16; ++xRange) {
            if (random.nextBoolean()) continue;
            for (int zRange = 0; zRange < 16; ++zRange) {
                if (random.nextBoolean()) continue;
                int x = origin.getX() + xRange;
                int z = origin.getZ() + zRange;
                mutable.set(x, level.getTopY(Heightmap.Type.MOTION_BLOCKING, x, z) - 1, z);
                if (!level.getBlockState((BlockPos)mutable).isIn(BlockTags.LEAVES) || !level.getBlockState((BlockPos)mutable).isIn(ModBlockTags.ALLOWS_LEAF_LITTER)) continue;
                mutable.set(x, level.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z), z);
                BlockState state = (ModBlocks.LEAF_LITTER.get().getDefaultState().with(LeafLitterBlock.AMOUNT, Integer.valueOf(random.nextBetween(1, 4)))).with(LeafLitterBlock.FACING, Direction.Type.HORIZONTAL.random(random));
                if (level.getBlockState((BlockPos)mutable).isOf(ModBlocks.LEAF_LITTER.get()) || !level.getBlockState((BlockPos)mutable).isAir() || !state.canPlaceAt((WorldView)level, (BlockPos)mutable)) continue;
                level.setBlockState((BlockPos)mutable, state, 1);
            }
        }
        return true;
    }
}

