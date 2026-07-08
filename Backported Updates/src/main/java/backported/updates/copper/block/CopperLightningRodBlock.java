/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.item.ItemPlacementContext
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.RodBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleTypes
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.Property
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.fluid.Fluid
 *  net.minecraft.fluid.Fluids
 *  net.minecraft.block.Waterloggable
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.particle.ParticleUtil
 *  net.minecraft.util.math.intprovider.UniformIntProvider
 */
package backported.updates.copper.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.RodBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.world.Heightmap;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.Waterloggable;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class CopperLightningRodBlock
extends RodBlock
implements Waterloggable {
    public static final MapCodec<CopperLightningRodBlock> CODEC = CopperLightningRodBlock.createCodec(CopperLightningRodBlock::new);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty POWERED = Properties.POWERED;
    private static final int ACTIVATION_TICKS = 8;
    public static final int RANGE = 128;
    private static final int SPARK_CYCLE = 200;

    public MapCodec<? extends CopperLightningRodBlock> getCodec() {
        return CODEC;
    }

    public CopperLightningRodBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState((((this.stateManager.getDefaultState()).with(FACING, Direction.UP)).with(WATERLOGGED, Boolean.valueOf(false))).with(POWERED, Boolean.valueOf(false)));
    }

    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluidstate = context.getWorld().getFluidState(context.getBlockPos());
        boolean flag = fluidstate.getFluid() == Fluids.WATER;
        return (this.getDefaultState().with(FACING, context.getSide())).with(WATERLOGGED, Boolean.valueOf(flag));
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos pos, BlockPos neighborPos) {
        if (((Boolean)state.get(WATERLOGGED)).booleanValue()) {
            level.scheduleFluidTick(pos, (Fluid)Fluids.WATER, Fluids.WATER.getTickRate((WorldView)level));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, level, pos, neighborPos);
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) != false ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected int getWeakRedstonePower(BlockState state, BlockView level, BlockPos pos, Direction direction) {
        return (Boolean)state.get(POWERED) != false ? 15 : 0;
    }

    protected int getStrongRedstonePower(BlockState state, BlockView level, BlockPos pos, Direction direction) {
        return (Boolean)state.get(POWERED) != false && state.get(FACING) == direction ? 15 : 0;
    }

    public void onLightningStrike(BlockState state, World level, BlockPos pos) {
        level.setBlockState(pos, state.with(POWERED, Boolean.valueOf(true)), 3);
        this.updateNeighbours(state, level, pos);
        level.scheduleBlockTick(pos, (Block)this, 8);
        level.syncWorldEvent(3002, pos, ((Direction)state.get(FACING)).getAxis().ordinal());
    }

    private void updateNeighbours(BlockState state, World level, BlockPos pos) {
        level.updateNeighborsAlways(pos.offset(((Direction)state.get(FACING)).getOpposite()), (Block)this);
    }

    protected void scheduledTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        level.setBlockState(pos, state.with(POWERED, Boolean.valueOf(false)), 3);
        this.updateNeighbours(state, (World)level, pos);
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        if (level.isThundering() && (long)level.random.nextInt(200) <= level.getTime() % 200L && pos.getY() == level.getTopY(Heightmap.Type.WORLD_SURFACE, pos.getX(), pos.getZ()) - 1) {
            ParticleUtil.spawnParticle((Direction.Axis)((Direction)state.get(FACING)).getAxis(), (World)level, (BlockPos)pos, (double)0.125, (ParticleEffect)ParticleTypes.ELECTRIC_SPARK, (UniformIntProvider)UniformIntProvider.create((int)1, (int)2));
        }
    }

    protected void onStateReplaced(BlockState state, World level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!state.isOf(newState.getBlock())) {
            if (((Boolean)state.get(POWERED)).booleanValue()) {
                this.updateNeighbours(state, level, pos);
            }
            super.onStateReplaced(state, level, pos, newState, movedByPiston);
        }
    }

    protected void onBlockAdded(BlockState state, World level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!state.isOf(oldState.getBlock()) && ((Boolean)state.get(POWERED)).booleanValue() && !level.getBlockTickScheduler().isQueued(pos, this)) {
            level.setBlockState(pos, state.with(POWERED, Boolean.valueOf(false)), 18);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, POWERED, WATERLOGGED});
    }

    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }
}

