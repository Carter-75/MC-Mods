/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.PlantBlock
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

import backported.updates.content.common.api.block.SpreadableBonemealableBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.ShapeContext;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;

public class ActualBushBlock
extends PlantBlock
implements SpreadableBonemealableBlock {
    public static final MapCodec<ActualBushBlock> CODEC = ActualBushBlock.createCodec(ActualBushBlock::new);
    private static final VoxelShape SHAPE = Block.createCuboidShape((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)13.0, (double)16.0);

    public ActualBushBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    protected MapCodec<? extends PlantBlock> getCodec() {
        return CODEC;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state) {
        return SpreadableBonemealableBlock.hasSpreadableNeighbourPos(level, pos, state);
    }

    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        SpreadableBonemealableBlock.findSpreadableNeighbourPos((World)level, pos, state).ifPresent(newPos -> level.setBlockState(newPos, this.getDefaultState()));
    }
}

