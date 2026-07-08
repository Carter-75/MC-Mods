/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.ai.pathing.NavigationType
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemPlacementContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.shape.VoxelShapes
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.Property
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.fluid.Fluid
 *  net.minecraft.fluid.Fluids
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.block.Waterloggable
 *  net.minecraft.block.LanternBlock
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.util.ItemActionResult
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block;

import backported.updates.copper.registry.ModBlocks;
import java.util.Optional;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.util.Hand;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.LanternBlock;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;
import org.jetbrains.annotations.Nullable;

public class CopperLanternBlock
extends LanternBlock
implements Waterloggable {
    public static final BooleanProperty HANGING = Properties.HANGING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape AABB = VoxelShapes.union((VoxelShape)Block.createCuboidShape((double)5.0, (double)0.0, (double)5.0, (double)11.0, (double)7.0, (double)11.0), (VoxelShape)Block.createCuboidShape((double)6.0, (double)7.0, (double)6.0, (double)10.0, (double)9.0, (double)10.0));
    protected static final VoxelShape HANGING_AABB = VoxelShapes.union((VoxelShape)Block.createCuboidShape((double)5.0, (double)1.0, (double)5.0, (double)11.0, (double)8.0, (double)11.0), (VoxelShape)Block.createCuboidShape((double)6.0, (double)8.0, (double)6.0, (double)10.0, (double)10.0, (double)10.0));
    private final Oxidizable.OxidationLevel weatheringState;

    public CopperLanternBlock(Oxidizable.OxidationLevel weatheringState, AbstractBlock.Settings properties) {
        super(properties);
        this.weatheringState = weatheringState;
        this.setDefaultState(((this.stateManager.getDefaultState()).with(HANGING, Boolean.valueOf(false))).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    public Oxidizable.OxidationLevel getWeatheringState() {
        return this.weatheringState;
    }

    public static Optional<Block> getUnwaxedBlock(Block block) {
        if (block == ModBlocks.WAXED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.OXIDIZED_COPPER_LANTERN.get());
        }
        return Optional.empty();
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Optional<Block> unwaxedBlock;
        if (stack.isIn(ItemTags.AXES) && (unwaxedBlock = CopperLanternBlock.getUnwaxedBlock(state.getBlock())).isPresent()) {
            level.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3004, pos, 0);
            if (!level.isClient) {
                BlockState newState = unwaxedBlock.get().getStateWithProperties(state);
                level.setBlockState(pos, newState);
                stack.damage(1, (LivingEntity)player, hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluidstate = context.getWorld().getFluidState(context.getBlockPos());
        for (Direction direction : context.getPlacementDirections()) {
            BlockState blockstate;
            if (direction.getAxis() != Direction.Axis.Y || !(blockstate = this.getDefaultState().with(HANGING, Boolean.valueOf(direction == Direction.UP))).canPlaceAt((WorldView)context.getWorld(), context.getBlockPos())) continue;
            return blockstate.with(WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER));
        }
        return null;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return (Boolean)state.get(HANGING) != false ? HANGING_AABB : AABB;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{HANGING, WATERLOGGED});
    }

    protected boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        Direction direction = CopperLanternBlock.getConnectedDirection(state).getOpposite();
        return Block.sideCoversSmallSquare((WorldView)level, (BlockPos)pos.offset(direction), (Direction)direction.getOpposite());
    }

    protected static Direction getConnectedDirection(BlockState state) {
        return (Boolean)state.get(HANGING) != false ? Direction.DOWN : Direction.UP;
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos pos, BlockPos neighborPos) {
        if (((Boolean)state.get(WATERLOGGED)).booleanValue()) {
            level.scheduleFluidTick(pos, (Fluid)Fluids.WATER, Fluids.WATER.getTickRate((WorldView)level));
        }
        return CopperLanternBlock.getConnectedDirection(state).getOpposite() == direction && !state.canPlaceAt((WorldView)level, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, level, pos, neighborPos);
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) != false ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}

