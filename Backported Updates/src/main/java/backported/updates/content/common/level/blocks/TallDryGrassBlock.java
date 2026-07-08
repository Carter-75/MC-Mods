/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.DeadBushBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.level.sound.AmbientDesertBlockSoundsPlayer;
import backported.updates.content.common.api.block.SpreadableBonemealableBlock;
import backported.updates.content.common.registries.ModBlocks;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.ShapeContext;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;

public class TallDryGrassBlock
extends DeadBushBlock
implements SpreadableBonemealableBlock {
    private static final VoxelShape SHAPE = Block.createCuboidShape((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)16.0, (double)15.0);

    public TallDryGrassBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        AmbientDesertBlockSoundsPlayer.playAmbientDryGrassSounds(level, pos, random);
    }

    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state) {
        return SpreadableBonemealableBlock.hasSpreadableNeighbourPos(level, pos, ModBlocks.SHORT_DRY_GRASS.get().getDefaultState());
    }

    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        SpreadableBonemealableBlock.findSpreadableNeighbourPos((World)level, pos, ModBlocks.SHORT_DRY_GRASS.get().getDefaultState()).ifPresent(newPos -> level.setBlockState(newPos, ModBlocks.SHORT_DRY_GRASS.get().getDefaultState()));
    }
}

