/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.entity.ai.pathing.NavigationType
 *  net.minecraft.util.ItemScatterer
 *  net.minecraft.util.Hand
 *  net.minecraft.util.ActionResult
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemPlacementContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.world.World
 *  net.minecraft.block.BlockWithEntity
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.BlockMirror
 *  net.minecraft.block.BlockRenderType
 *  net.minecraft.util.BlockRotation
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.util.shape.VoxelShapes
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.state.property.EnumProperty
 *  net.minecraft.Property
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.fluid.Fluid
 *  net.minecraft.fluid.Fluids
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.block.Waterloggable
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.world.event.GameEvent$Emitter
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.util.ItemActionResult
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block.shelf;

import backported.updates.copper.ModSounds;
import backported.updates.copper.ModTags;
import backported.updates.copper.block.shelf.SelectableSlotContainer;
import backported.updates.copper.block.shelf.ShelfBlockEntity;
import backported.updates.copper.block.shelf.SideChainPart;
import backported.updates.copper.block.shelf.SideChainPartBlock;
import com.mojang.serialization.MapCodec;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.BlockMirror;
import net.minecraft.block.BlockRenderType;
import net.minecraft.util.BlockRotation;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundCategory;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.world.event.GameEvent;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.ItemActionResult;
import org.jetbrains.annotations.Nullable;

public class ShelfBlock
extends BlockWithEntity
implements SelectableSlotContainer,
SideChainPartBlock,
Waterloggable {
    public static final MapCodec<ShelfBlock> CODEC = ShelfBlock.createCodec(ShelfBlock::new);
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<SideChainPart> SIDE_CHAIN_PART = EnumProperty.of((String)"side_chain_part", SideChainPart.class);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final Map<Direction, VoxelShape> SHAPES = ShelfBlock.createShapes();

    private static Map<Direction, VoxelShape> createShapes() {
        EnumMap<Direction, VoxelShape> map = new EnumMap<Direction, VoxelShape>(Direction.class);
        VoxelShape baseShape = VoxelShapes.union((VoxelShape)Block.createCuboidShape((double)0.0, (double)12.0, (double)11.0, (double)16.0, (double)16.0, (double)13.0), (VoxelShape[])new VoxelShape[]{Block.createCuboidShape((double)0.0, (double)0.0, (double)13.0, (double)16.0, (double)16.0, (double)16.0), Block.createCuboidShape((double)0.0, (double)0.0, (double)11.0, (double)16.0, (double)4.0, (double)13.0)});
        map.put(Direction.NORTH, baseShape);
        map.put(Direction.SOUTH, ShelfBlock.rotateShape(baseShape, Direction.SOUTH));
        map.put(Direction.WEST, ShelfBlock.rotateShape(baseShape, Direction.WEST));
        map.put(Direction.EAST, ShelfBlock.rotateShape(baseShape, Direction.EAST));
        return map;
    }

    private static VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        return switch (direction) {
            case Direction.SOUTH -> VoxelShapes.union((VoxelShape)Block.createCuboidShape((double)0.0, (double)12.0, (double)3.0, (double)16.0, (double)16.0, (double)5.0), (VoxelShape[])new VoxelShape[]{Block.createCuboidShape((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)3.0), Block.createCuboidShape((double)0.0, (double)0.0, (double)3.0, (double)16.0, (double)4.0, (double)5.0)});
            case Direction.WEST -> VoxelShapes.union((VoxelShape)Block.createCuboidShape((double)11.0, (double)12.0, (double)0.0, (double)13.0, (double)16.0, (double)16.0), (VoxelShape[])new VoxelShape[]{Block.createCuboidShape((double)13.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0), Block.createCuboidShape((double)11.0, (double)0.0, (double)0.0, (double)13.0, (double)4.0, (double)16.0)});
            case Direction.EAST -> VoxelShapes.union((VoxelShape)Block.createCuboidShape((double)3.0, (double)12.0, (double)0.0, (double)5.0, (double)16.0, (double)16.0), (VoxelShape[])new VoxelShape[]{Block.createCuboidShape((double)0.0, (double)0.0, (double)0.0, (double)3.0, (double)16.0, (double)16.0), Block.createCuboidShape((double)3.0, (double)0.0, (double)0.0, (double)5.0, (double)4.0, (double)16.0)});
            default -> shape;
        };
    }

    public ShelfBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(((((this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(POWERED, Boolean.valueOf(false))).with(SIDE_CHAIN_PART, (SideChainPart.UNCONNECTED))).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, POWERED, SIDE_CHAIN_PART, WATERLOGGED});
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPES.get(state.get(FACING));
    }

    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity(pos, state);
    }

    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluidstate = context.getWorld().getFluidState(context.getBlockPos());
        return ((this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite())).with(POWERED, Boolean.valueOf(context.getWorld().isReceivingRedstonePower(context.getBlockPos())))).with(WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }

    public void neighborUpdate(BlockState state, World level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClient()) {
            boolean hasSignal = level.isReceivingRedstonePower(pos);
            if ((Boolean)state.get(POWERED) != hasSignal) {
                BlockState newState = state.with(POWERED, Boolean.valueOf(hasSignal));
                if (!hasSignal) {
                    newState = newState.with(SIDE_CHAIN_PART, (SideChainPart.UNCONNECTED));
                }
                level.setBlockState(pos, newState, 3);
                this.playSound((WorldAccess)level, pos, hasSignal ? ModSounds.SHELF_ACTIVATE.get() : ModSounds.SHELF_DEACTIVATE.get());
                level.emitGameEvent((RegistryEntry)(hasSignal ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE), pos, GameEvent.Emitter.of(newState));
            }
        }
    }

    public void onBlockAdded(BlockState state, World level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (((Boolean)state.get(POWERED)).booleanValue()) {
            this.updateSelfAndNeighborsOnPoweringUp((WorldAccess)level, pos, state, oldState);
        } else {
            this.updateNeighborsAfterPoweringDown((WorldAccess)level, pos, state);
        }
    }

    public void onStateReplaced(BlockState state, World level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof ShelfBlockEntity) {
                ShelfBlockEntity shelfEntity = (ShelfBlockEntity)blockentity;
                for (int i = 0; i < shelfEntity.size(); ++i) {
                    ItemStack itemStack = shelfEntity.getStack(i);
                    if (itemStack.isEmpty()) continue;
                    ItemScatterer.spawn((World)level, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (ItemStack)itemStack);
                }
                level.updateComparators(pos, (Block)this);
            }
            this.updateNeighborsAfterPoweringDown((WorldAccess)level, pos, state);
        }
        super.onStateReplaced(state, level, pos, newState, isMoving);
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity class_25862 = level.getBlockEntity(pos);
        if (class_25862 instanceof ShelfBlockEntity) {
            ShelfBlockEntity shelfEntity = (ShelfBlockEntity)class_25862;
            if (hand == Hand.MAIN_HAND) {
                OptionalInt slotOpt = this.getHitSlot(hit, (Direction)state.get(FACING));
                if (slotOpt.isEmpty()) {
                    return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                }
                if (level.isClient()) {
                    return ItemActionResult.SUCCESS;
                }
                PlayerInventory inventory = player.getInventory();
                ItemStack heldItem = stack;
                if (!((Boolean)state.get(POWERED)).booleanValue()) {
                    boolean swapped = ShelfBlock.swapSingleItem(heldItem, player, shelfEntity, slotOpt.getAsInt(), inventory);
                    if (swapped) {
                        this.playSound((WorldAccess)level, pos, heldItem.isEmpty() ? ModSounds.SHELF_TAKE_ITEM.get() : ModSounds.SHELF_SINGLE_SWAP.get());
                    } else {
                        if (heldItem.isEmpty()) {
                            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                        }
                        this.playSound((WorldAccess)level, pos, ModSounds.SHELF_PLACE_ITEM.get());
                    }
                    return ItemActionResult.CONSUME;
                }
                boolean swapped = this.swapHotbar(level, pos, inventory);
                if (!swapped) {
                    return ItemActionResult.CONSUME;
                }
                this.playSound((WorldAccess)level, pos, ModSounds.SHELF_MULTI_SWAP.get());
                return ItemActionResult.CONSUME;
            }
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockEntity class_25862 = level.getBlockEntity(pos);
        if (class_25862 instanceof ShelfBlockEntity) {
            ShelfBlockEntity shelfEntity = (ShelfBlockEntity)class_25862;
            OptionalInt slotOpt = this.getHitSlot(hit, (Direction)state.get(FACING));
            if (slotOpt.isEmpty()) {
                return ActionResult.PASS;
            }
            if (level.isClient()) {
                return ActionResult.SUCCESS;
            }
            PlayerInventory inventory = player.getInventory();
            if (!((Boolean)state.get(POWERED)).booleanValue()) {
                int slot = slotOpt.getAsInt();
                ItemStack shelfItem = shelfEntity.getStack(slot);
                if (!shelfItem.isEmpty()) {
                    ItemStack takenItem = shelfItem.copy();
                    shelfEntity.setStack(slot, ItemStack.EMPTY);
                    if (!player.getInventory().insertStack(takenItem)) {
                        player.dropItem(takenItem, false);
                    }
                    shelfEntity.markDirty();
                    this.playSound((WorldAccess)level, pos, ModSounds.SHELF_TAKE_ITEM.get());
                    return ActionResult.CONSUME;
                }
                return ActionResult.PASS;
            }
            boolean swapped = this.swapHotbar(level, pos, inventory);
            if (!swapped) {
                return ActionResult.CONSUME;
            }
            this.playSound((WorldAccess)level, pos, ModSounds.SHELF_MULTI_SWAP.get());
            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }

    private static boolean swapSingleItem(ItemStack heldStack, PlayerEntity player, ShelfBlockEntity shelf, int slot, PlayerInventory inventory) {
        ItemStack shelfItem = shelf.swapItemNoUpdate(slot, heldStack);
        ItemStack newHeldItem = player.getAbilities().creativeMode && shelfItem.isEmpty() ? heldStack.copy() : shelfItem;
        inventory.setStack(inventory.selectedSlot, newHeldItem);
        inventory.markDirty();
        shelf.markDirty();
        return !shelfItem.isEmpty();
    }

    private boolean swapHotbar(World level, BlockPos pos, PlayerInventory inventory) {
        List connectedBlocks = this.getAllBlocksConnectedTo((WorldAccess)level, pos);
        if (connectedBlocks.isEmpty()) {
            return false;
        }
        boolean anySwapped = false;
        for (int i = 0; i < connectedBlocks.size(); ++i) {
            ShelfBlockEntity shelfEntity = (ShelfBlockEntity)level.getBlockEntity((BlockPos)connectedBlocks.get(i));
            if (shelfEntity == null) continue;
            for (int j = 0; j < shelfEntity.size(); ++j) {
                int hotbarSlot = 9 - (connectedBlocks.size() - i) * shelfEntity.size() + j;
                if (hotbarSlot < 0 || hotbarSlot >= 9) continue;
                ItemStack hotbarItem = inventory.removeStack(hotbarSlot);
                ItemStack shelfItem = shelfEntity.swapItemNoUpdate(j, hotbarItem);
                if (hotbarItem.isEmpty() && shelfItem.isEmpty()) continue;
                inventory.setStack(hotbarSlot, shelfItem);
                anySwapped = true;
            }
            inventory.markDirty();
            shelfEntity.markDirty();
        }
        return anySwapped;
    }

    private void playSound(WorldAccess level, BlockPos pos, SoundEvent sound) {
        level.playSound(null, pos, sound, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) != false ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos currentPos, BlockPos neighborPos) {
        if (((Boolean)state.get(WATERLOGGED)).booleanValue()) {
            level.scheduleFluidTick(currentPos, (Fluid)Fluids.WATER, Fluids.WATER.getTickRate((WorldView)level));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, level, currentPos, neighborPos);
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World level, BlockPos pos) {
        if (level.isClient()) {
            return 0;
        }
        BlockEntity class_25862 = level.getBlockEntity(pos);
        if (class_25862 instanceof ShelfBlockEntity) {
            ShelfBlockEntity shelfEntity = (ShelfBlockEntity)class_25862;
            int slot0 = shelfEntity.getStack(0).isEmpty() ? 0 : 1;
            int slot1 = shelfEntity.getStack(1).isEmpty() ? 0 : 1;
            int slot2 = shelfEntity.getStack(2).isEmpty() ? 0 : 1;
            return slot0 | slot1 << 1 | slot2 << 2;
        }
        return 0;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public int getColumns() {
        return 3;
    }

    @Override
    public SideChainPart getSideChainPart(BlockState state) {
        return (SideChainPart)(state.get(SIDE_CHAIN_PART));
    }

    @Override
    public BlockState setSideChainPart(BlockState state, SideChainPart part) {
        return state.with(SIDE_CHAIN_PART, (part));
    }

    @Override
    public Direction getFacing(BlockState state) {
        return (Direction)state.get(FACING);
    }

    @Override
    public boolean isConnectable(BlockState state) {
        return state.isIn(ModTags.Blocks.WOODEN_SHELVES) && state.contains(POWERED) && (Boolean)state.get(POWERED) != false;
    }

    @Override
    public int getMaxChainLength() {
        return 3;
    }
}

