/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.WeepingVinesBlock
 *  net.minecraft.block.AbstractPlantStemBlock
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.world.WorldView;
import net.minecraft.block.WeepingVinesBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;

public class PaleHangingMossBlock
extends AbstractPlantStemBlock {
    public static final MapCodec<WeepingVinesBlock> CODEC = PaleHangingMossBlock.createCodec(WeepingVinesBlock::new);
    protected static final VoxelShape SHAPE = Block.createCuboidShape((double)4.0, (double)9.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0);

    public PaleHangingMossBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false, 0.1);
    }

    protected Block getPlant() {
        return Init.PALE_HANGING_MOSS_PLANT;
    }

    protected MapCodec<? extends AbstractPlantStemBlock> getCodec() {
        return CODEC;
    }

    protected int getGrowthLength(Random random) {
        return 0;
    }

    protected boolean chooseStemState(BlockState state) {
        return false;
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Block block = world.getBlockState(pos.up()).getBlock();
        return block == Init.PALE_OAK_LEAVES || block == Init.PALE_HANGING_MOSS_PLANT || super.canPlaceAt(state, world, pos);
    }
}

