/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.Property
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.fluid.Fluid
 *  net.minecraft.fluid.Fluids
 *  net.minecraft.block.Waterloggable
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.MultifaceGrowthBlock
 *  net.minecraft.block.LichenGrower
 *  net.minecraft.block.LichenGrower$GrowChecker
 *  net.minecraft.block.LichenGrower$GrowPos
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.Waterloggable;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.block.LichenGrower;
import org.jetbrains.annotations.Nullable;

public class ResinClumpBlock
extends MultifaceGrowthBlock
implements Waterloggable {
    public static final MapCodec<ResinClumpBlock> CODEC = ResinClumpBlock.createCodec(ResinClumpBlock::new);
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    protected MapCodec<? extends MultifaceGrowthBlock> getCodec() {
        return CODEC;
    }

    public ResinClumpBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{WATERLOGGED});
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos pos, BlockPos neighborPos) {
        if (((Boolean)state.get(WATERLOGGED)).booleanValue()) {
            level.scheduleFluidTick(pos, (Fluid)Fluids.WATER, Fluids.WATER.getTickRate((WorldView)level));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, level, pos, neighborPos);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) != false ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public LichenGrower getGrower() {
        return new LichenGrower((LichenGrower.GrowChecker)new NoOpSpreadConfig());
    }

    private static class NoOpSpreadConfig
    implements LichenGrower.GrowChecker {
        private NoOpSpreadConfig() {
        }

        @Nullable
        public BlockState getStateWithDirection(BlockState currentState, BlockView level, BlockPos pos, Direction lookingDirection) {
            return null;
        }

        public boolean canGrow(BlockView level, BlockPos pos, LichenGrower.GrowPos spreadPos) {
            return false;
        }
    }
}

