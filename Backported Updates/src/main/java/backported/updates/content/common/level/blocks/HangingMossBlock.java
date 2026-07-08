/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.Fertilizable
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.MultifaceGrowthBlock
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.registries.ModBlockStateProperties;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.data.tags.ModBlockTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.Fertilizable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.block.ShapeContext;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.util.math.random.Random;

public class HangingMossBlock
extends Block
implements Fertilizable {
    public static final MapCodec<HangingMossBlock> CODEC = HangingMossBlock.createCodec(HangingMossBlock::new);
    private static final VoxelShape TIP_SHAPE = Block.createCuboidShape((double)1.0, (double)2.0, (double)1.0, (double)15.0, (double)16.0, (double)15.0);
    private static final VoxelShape BASE_SHAPE = Block.createCuboidShape((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)16.0, (double)15.0);
    public static final BooleanProperty TIP = ModBlockStateProperties.TIP;

    public MapCodec<HangingMossBlock> getCodec() {
        return CODEC;
    }

    public HangingMossBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState((this.getStateManager().getDefaultState()).with(TIP, Boolean.valueOf(true)));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return (Boolean)state.get(TIP) != false ? TIP_SHAPE : BASE_SHAPE;
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        BlockState aboveState;
        if (random.nextInt(500) == 0 && ((aboveState = level.getBlockState(pos.up())).isIn(ModBlockTags.PALE_OAK_LOGS) || aboveState.isOf(ModBlocks.PALE_OAK_LEAVES.get()))) {
            level.playSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), ModSoundEvents.PALE_HANGING_MOSS_IDLE.get(), SoundCategory.BLOCKS, 1.0f, 1.0f, false);
        }
    }

    public boolean isTransparent(BlockState state, BlockView level, BlockPos pos) {
        return true;
    }

    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        return this.canStayAtPosition((BlockView)level, pos);
    }

    private boolean canStayAtPosition(BlockView level, BlockPos pos) {
        BlockState aboveState;
        BlockPos above = pos.up();
        return MultifaceGrowthBlock.canGrowOn((BlockView)level, (Direction)Direction.UP, (BlockPos)above, (aboveState = level.getBlockState(above))) || aboveState.isOf(ModBlocks.PALE_HANGING_MOSS.get());
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos pos, BlockPos neighborPos) {
        if (!this.canStayAtPosition((BlockView)level, pos)) {
            level.scheduleBlockTick(pos, (Block)this, 1);
        }
        return state.with(TIP, Boolean.valueOf(!level.getBlockState(pos.down()).isOf((Block)this)));
    }

    public void scheduledTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (!this.canStayAtPosition((BlockView)level, pos)) {
            level.breakBlock(pos, true);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TIP});
    }

    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state) {
        return this.canGrowInto(level.getBlockState(this.getTip((BlockView)level, pos).down()));
    }

    private boolean canGrowInto(BlockState state) {
        return state.isAir();
    }

    public BlockPos getTip(BlockView level, BlockPos pos) {
        BlockState state;
        BlockPos.Mutable position = pos.mutableCopy();
        do {
            position.move(Direction.DOWN);
        } while ((state = level.getBlockState((BlockPos)position)).isOf((Block)this));
        return position.offset(Direction.UP).toImmutable();
    }

    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        BlockPos tipPos = this.getTip((BlockView)level, pos).down();
        if (this.canGrowInto(level.getBlockState(tipPos))) {
            level.setBlockState(tipPos, state.with(TIP, Boolean.valueOf(true)));
        }
    }
}

