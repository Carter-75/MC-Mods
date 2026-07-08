/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.Maps
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.Util
 *  net.minecraft.item.ItemPlacementContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.block.Fertilizable
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.util.BlockMirror
 *  net.minecraft.util.BlockRotation
 *  net.minecraft.util.shape.VoxelShapes
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.state.property.EnumProperty
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.enums.WallShape
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.MultifaceGrowthBlock
 *  net.minecraft.util.math.random.Random
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.common.registries.ModBlocks;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Util;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.Fertilizable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.ShapeContext;
import net.minecraft.world.WorldView;
import net.minecraft.block.enums.WallShape;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public class MossyCarpetBlock
extends Block
implements Fertilizable {
    public static final MapCodec<MossyCarpetBlock> CODEC = MossyCarpetBlock.createCodec(MossyCarpetBlock::new);
    public static final BooleanProperty BASE = Properties.BOTTOM;
    private static final EnumProperty<WallShape> NORTH = Properties.NORTH_WALL_SHAPE;
    private static final EnumProperty<WallShape> EAST = Properties.EAST_WALL_SHAPE;
    private static final EnumProperty<WallShape> SOUTH = Properties.SOUTH_WALL_SHAPE;
    private static final EnumProperty<WallShape> WEST = Properties.WEST_WALL_SHAPE;
    private static final Map<Direction, EnumProperty<WallShape>> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf((Util.make(Maps.newEnumMap(Direction.class), enumMap -> {
        enumMap.put(Direction.NORTH, NORTH);
        enumMap.put(Direction.EAST, EAST);
        enumMap.put(Direction.SOUTH, SOUTH);
        enumMap.put(Direction.WEST, WEST);
    })));
    private static final VoxelShape DOWN_AABB = Block.createCuboidShape((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)1.0, (double)16.0);
    private static final VoxelShape WEST_AABB = Block.createCuboidShape((double)0.0, (double)0.0, (double)0.0, (double)1.0, (double)16.0, (double)16.0);
    private static final VoxelShape EAST_AABB = Block.createCuboidShape((double)15.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
    private static final VoxelShape NORTH_AABB = Block.createCuboidShape((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)1.0);
    private static final VoxelShape SOUTH_AABB = Block.createCuboidShape((double)0.0, (double)0.0, (double)15.0, (double)16.0, (double)16.0, (double)16.0);
    private static final VoxelShape WEST_SHORT_AABB = Block.createCuboidShape((double)0.0, (double)0.0, (double)0.0, (double)1.0, (double)10.0, (double)16.0);
    private static final VoxelShape EAST_SHORT_AABB = Block.createCuboidShape((double)15.0, (double)0.0, (double)0.0, (double)16.0, (double)10.0, (double)16.0);
    private static final VoxelShape NORTH_SHORT_AABB = Block.createCuboidShape((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)10.0, (double)1.0);
    private static final VoxelShape SOUTH_SHORT_AABB = Block.createCuboidShape((double)0.0, (double)0.0, (double)15.0, (double)16.0, (double)10.0, (double)16.0);
    private final Map<BlockState, VoxelShape> shapesCache;

    public MapCodec<MossyCarpetBlock> getCodec() {
        return CODEC;
    }

    public MossyCarpetBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState((((((this.getStateManager().getDefaultState()).with(BASE, Boolean.valueOf(true))).with(NORTH, WallShape.NONE)).with(EAST, WallShape.NONE)).with(SOUTH, WallShape.NONE)).with(WEST, WallShape.NONE));
        this.shapesCache = ImmutableMap.copyOf(this.getStateManager().getStates().stream().collect(Collectors.toMap(Function.identity(), MossyCarpetBlock::calculateShape)));
    }

    public VoxelShape getCullingShape(BlockState state, BlockView level, BlockPos pos) {
        return VoxelShapes.empty();
    }

    private static VoxelShape calculateShape(BlockState state) {
        VoxelShape shape = VoxelShapes.empty();
        if (((Boolean)state.get(BASE)).booleanValue()) {
            shape = DOWN_AABB;
        }
        shape = switch ((WallShape)state.get(NORTH)) {
            default -> throw new MatchException(null, null);
            case WallShape.NONE -> shape;
            case WallShape.LOW -> VoxelShapes.union((VoxelShape)shape, (VoxelShape)NORTH_SHORT_AABB);
            case WallShape.TALL -> VoxelShapes.union((VoxelShape)shape, (VoxelShape)NORTH_AABB);
        };
        shape = switch ((WallShape)state.get(SOUTH)) {
            default -> throw new MatchException(null, null);
            case WallShape.NONE -> shape;
            case WallShape.LOW -> VoxelShapes.union((VoxelShape)shape, (VoxelShape)SOUTH_SHORT_AABB);
            case WallShape.TALL -> VoxelShapes.union((VoxelShape)shape, (VoxelShape)SOUTH_AABB);
        };
        shape = switch ((WallShape)state.get(EAST)) {
            default -> throw new MatchException(null, null);
            case WallShape.NONE -> shape;
            case WallShape.LOW -> VoxelShapes.union((VoxelShape)shape, (VoxelShape)EAST_SHORT_AABB);
            case WallShape.TALL -> VoxelShapes.union((VoxelShape)shape, (VoxelShape)EAST_AABB);
        };
        shape = switch ((WallShape)state.get(WEST)) {
            default -> throw new MatchException(null, null);
            case WallShape.NONE -> shape;
            case WallShape.LOW -> VoxelShapes.union((VoxelShape)shape, (VoxelShape)WEST_SHORT_AABB);
            case WallShape.TALL -> VoxelShapes.union((VoxelShape)shape, (VoxelShape)WEST_AABB);
        };
        return shape.isEmpty() ? VoxelShapes.fullCube() : shape;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return this.shapesCache.get(state);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return (Boolean)state.get(BASE) != false ? DOWN_AABB : VoxelShapes.empty();
    }

    public boolean isTransparent(BlockState state, BlockView level, BlockPos pos) {
        return true;
    }

    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        BlockState floorState = level.getBlockState(pos.down());
        return ((Boolean)state.get(BASE)).booleanValue() ? !floorState.isAir() : floorState.isOf((Block)this) && (Boolean)floorState.get(BASE) != false;
    }

    private static boolean hasFaces(BlockState state) {
        if (((Boolean)state.get(BASE)).booleanValue()) {
            return true;
        }
        return PROPERTY_BY_DIRECTION.values().stream().anyMatch(property -> state.get(property) != WallShape.NONE);
    }

    private static boolean canSupportAtFace(BlockView level, BlockPos pos, Direction direction) {
        BlockPos adjacent = pos.offset(direction);
        BlockState adjacentState = level.getBlockState(adjacent);
        return direction != Direction.UP && MultifaceGrowthBlock.canGrowOn((BlockView)level, (Direction)direction, (BlockPos)adjacent, adjacentState);
    }

    private static BlockState getUpdatedState(BlockState state, BlockView level, BlockPos pos, boolean flag) {
        BlockState aboveState = null;
        BlockState belowState = null;
        flag |= ((Boolean)state.get(BASE)).booleanValue();
        for (Direction direction : Direction.Type.HORIZONTAL) {
            EnumProperty<WallShape> property = MossyCarpetBlock.getPropertyForFace(direction);
            WallShape wallSide = MossyCarpetBlock.canSupportAtFace(level, pos, direction) ? (flag ? WallShape.LOW : (WallShape)state.get(property)) : WallShape.NONE;
            if (wallSide == WallShape.LOW) {
                if (aboveState == null) {
                    aboveState = level.getBlockState(pos.up());
                }
                if (aboveState.isOf(ModBlocks.PALE_MOSS_CARPET.get()) && aboveState.get(property) != WallShape.NONE && !((Boolean)aboveState.get(BASE)).booleanValue()) {
                    wallSide = WallShape.TALL;
                }
                if (!((Boolean)state.get(BASE)).booleanValue()) {
                    if (belowState == null) {
                        belowState = level.getBlockState(pos.down());
                    }
                    if (belowState.isOf(ModBlocks.PALE_MOSS_CARPET.get()) && belowState.get(property) == WallShape.NONE) {
                        wallSide = WallShape.NONE;
                    }
                }
            }
            state = state.with(property, wallSide);
        }
        return state;
    }

    public static void placeAt(WorldAccess level, BlockPos pos, Random random, int flag) {
        BlockState base = ModBlocks.PALE_MOSS_CARPET.get().getDefaultState();
        BlockState updatedState = MossyCarpetBlock.getUpdatedState(base, (BlockView)level, pos, true);
        level.setBlockState(pos, updatedState, flag);
        BlockState topperState = MossyCarpetBlock.createTopperWithSideChance((BlockView)level, pos, () -> (random).nextBoolean());
        if (!topperState.isAir()) {
            level.setBlockState(pos.up(), topperState, flag);
            BlockState reUpdatedState = MossyCarpetBlock.getUpdatedState(updatedState, (BlockView)level, pos, true);
            level.setBlockState(pos, reUpdatedState, flag);
        }
    }

    public void onPlaced(World level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (!level.isClient) {
            Random random = level.getRandom();
            BlockState topperState = MossyCarpetBlock.createTopperWithSideChance((BlockView)level, pos, () -> (random).nextBoolean());
            if (!topperState.isAir()) {
                level.setBlockState(pos.up(), topperState, 3);
            }
        }
    }

    private static BlockState createTopperWithSideChance(BlockView level, BlockPos pos, BooleanSupplier flag) {
        BlockPos above = pos.up();
        BlockState aboveState = level.getBlockState(above);
        boolean isCarpet = aboveState.isOf(ModBlocks.PALE_MOSS_CARPET.get());
        if (!(isCarpet && ((Boolean)aboveState.get(BASE)).booleanValue() || !isCarpet && !aboveState.isReplaceable())) {
            BlockState baselessCarpet = ModBlocks.PALE_MOSS_CARPET.get().getDefaultState().with(BASE, Boolean.valueOf(false));
            BlockState updatedState = MossyCarpetBlock.getUpdatedState(baselessCarpet, level, pos.up(), true);
            for (Direction direction : Direction.Type.HORIZONTAL) {
                EnumProperty<WallShape> property = MossyCarpetBlock.getPropertyForFace(direction);
                if (updatedState.get(property) == WallShape.NONE || flag.getAsBoolean()) continue;
                updatedState = updatedState.with(property, WallShape.NONE);
            }
            return MossyCarpetBlock.hasFaces(updatedState) && updatedState != aboveState ? updatedState : Blocks.AIR.getDefaultState();
        }
        return Blocks.AIR.getDefaultState();
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        return MossyCarpetBlock.getUpdatedState(this.getDefaultState(), (BlockView)context.getWorld(), context.getBlockPos(), true);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt((WorldView)level, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        BlockState updatedState = MossyCarpetBlock.getUpdatedState(state, (BlockView)level, pos, false);
        return !MossyCarpetBlock.hasFaces(updatedState) ? Blocks.AIR.getDefaultState() : updatedState;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BASE, NORTH, EAST, SOUTH, WEST});
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return switch (rotation) {
            case BlockRotation.CLOCKWISE_180 -> (((state.with(NORTH, ((WallShape)state.get(SOUTH)))).with(EAST, ((WallShape)state.get(WEST)))).with(SOUTH, ((WallShape)state.get(NORTH)))).with(WEST, ((WallShape)state.get(EAST)));
            case BlockRotation.COUNTERCLOCKWISE_90 -> (((state.with(NORTH, ((WallShape)state.get(EAST)))).with(EAST, ((WallShape)state.get(SOUTH)))).with(SOUTH, ((WallShape)state.get(WEST)))).with(WEST, ((WallShape)state.get(NORTH)));
            case BlockRotation.CLOCKWISE_90 -> (((state.with(NORTH, ((WallShape)state.get(WEST)))).with(EAST, ((WallShape)state.get(NORTH)))).with(SOUTH, ((WallShape)state.get(EAST)))).with(WEST, ((WallShape)state.get(SOUTH)));
            default -> state;
        };
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return switch (mirror) {
            case BlockMirror.LEFT_RIGHT -> (state.with(NORTH, ((WallShape)state.get(SOUTH)))).with(SOUTH, ((WallShape)state.get(NORTH)));
            case BlockMirror.FRONT_BACK -> (state.with(EAST, ((WallShape)state.get(WEST)))).with(WEST, ((WallShape)state.get(EAST)));
            default -> super.mirror(state, mirror);
        };
    }

    @Nullable
    public static EnumProperty<WallShape> getPropertyForFace(Direction direction) {
        return PROPERTY_BY_DIRECTION.get(direction);
    }

    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state) {
        return (Boolean)state.get(BASE) != false && !MossyCarpetBlock.createTopperWithSideChance((BlockView)level, pos, () -> true).isAir();
    }

    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        BlockState topperState = MossyCarpetBlock.createTopperWithSideChance((BlockView)level, pos, () -> true);
        if (!topperState.isAir()) {
            level.setBlockState(pos.up(), topperState, 3);
        }
    }
}

