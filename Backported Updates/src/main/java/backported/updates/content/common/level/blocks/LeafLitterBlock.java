/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.util.Util
 *  net.minecraft.item.ItemPlacementContext
 *  net.minecraft.world.BlockView
 *  net.minecraft.block.Block
 *  net.minecraft.block.PlantBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.BlockMirror
 *  net.minecraft.util.BlockRotation
 *  net.minecraft.util.shape.VoxelShapes
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.DirectionProperty
 *  net.minecraft.state.property.IntProperty
 *  net.minecraft.Property
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 */
package backported.updates.content.common.level.blocks;

import com.mojang.serialization.MapCodec;
import java.util.function.BiFunction;
import net.minecraft.util.Util;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.world.BlockView;
import net.minecraft.block.Block;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.block.ShapeContext;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;

public class LeafLitterBlock
extends PlantBlock {
    public static final MapCodec<LeafLitterBlock> CODEC = LeafLitterBlock.createCodec(LeafLitterBlock::new);
    public static final int MIN_SEGMENT = 1;
    public static final int MAX_SEGMENT = 4;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty AMOUNT = Properties.FLOWER_AMOUNT;
    private static final BiFunction<Direction, Integer, VoxelShape> SHAPE_BY_PROPERTIES = Util.memoize((direction, value) -> {
        VoxelShape shape = VoxelShapes.empty();
        VoxelShape[] shapes = new VoxelShape[]{Block.createCuboidShape((double)8.0, (double)0.0, (double)8.0, (double)16.0, (double)3.0, (double)16.0), Block.createCuboidShape((double)8.0, (double)0.0, (double)0.0, (double)16.0, (double)3.0, (double)8.0), Block.createCuboidShape((double)0.0, (double)0.0, (double)0.0, (double)8.0, (double)3.0, (double)8.0), Block.createCuboidShape((double)0.0, (double)0.0, (double)8.0, (double)8.0, (double)3.0, (double)16.0)};
        for (int index = 0; index < value; ++index) {
            int i = Math.floorMod(index - direction.getHorizontal(), 4);
            shape = VoxelShapes.union((VoxelShape)shape, (VoxelShape)shapes[i]);
        }
        return shape.asCuboid();
    });

    public MapCodec<LeafLitterBlock> getCodec() {
        return CODEC;
    }

    public LeafLitterBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(((this.getStateManager().getDefaultState()).with(FACING, Direction.NORTH)).with(AMOUNT, Integer.valueOf(1)));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }

    public boolean canReplace(BlockState state, ItemPlacementContext useContext) {
        return !useContext.shouldCancelInteraction() && useContext.getStack().isOf(this.asItem()) && (Integer)state.get(AMOUNT) < 4 || super.canReplace(state, useContext);
    }

    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        BlockPos below = pos.down();
        return level.getBlockState(below).isSideSolidFullSquare((BlockView)level, below, Direction.UP);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_PROPERTIES.apply((Direction)state.get(FACING), (Integer)state.get(AMOUNT));
    }

    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        return state.isOf((Block)this) ? state.with(AMOUNT, Integer.valueOf(Math.min(4, (Integer)state.get(AMOUNT) + 1))) : this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, AMOUNT});
    }
}

