/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.world.BlockView
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.block.PlantBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.SideShapeType
 */
package backported.updates.content.common.level.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.BlockView;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SideShapeType;

public class CactusFlowerBlock
extends PlantBlock {
    public static final MapCodec<CactusFlowerBlock> CODEC = CactusFlowerBlock.createCodec(CactusFlowerBlock::new);
    private static final VoxelShape SHAPE = Block.createCuboidShape((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)12.0, (double)15.0);

    public CactusFlowerBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    protected MapCodec<? extends PlantBlock> getCodec() {
        return CODEC;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected boolean canPlantOnTop(BlockState state, BlockView level, BlockPos pos) {
        BlockState below = level.getBlockState(pos);
        return below.isOf(Blocks.CACTUS) || below.isOf(Blocks.FARMLAND) || below.isSideSolid(level, pos, Direction.UP, SideShapeType.CENTER);
    }
}

