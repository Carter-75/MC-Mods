/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemPlacementContext
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.world.World
 *  net.minecraft.block.BlockWithEntity
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.block.BlockRenderType
 *  net.minecraft.block.PillarBlock
 *  net.minecraft.util.BlockRotation
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.state.property.EnumProperty
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.entity.BlockEntityTicker
 *  net.minecraft.util.math.random.Random
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.blockentities.CreakingHeartBlockEntity;
import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import backported.updates.content.common.registries.ModBlockEntities;
import backported.updates.content.common.registries.ModBlockStateProperties;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.core.util.LevelUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.BlockRotation;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public class CreakingHeartBlock
extends BlockWithEntity {
    public static final MapCodec<CreakingHeartBlock> CODEC = CreakingHeartBlock.createCodec(CreakingHeartBlock::new);
    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;
    public static final EnumProperty<CreakingHeartState> STATE = ModBlockStateProperties.CREAKING_HEART_STATE;
    public static final BooleanProperty NATURAL = ModBlockStateProperties.NATURAL;

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public CreakingHeartBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(((this.getDefaultState().with(AXIS, Direction.Axis.Y)).with(STATE, (CreakingHeartState.UPROOTED))).with(NATURAL, Boolean.valueOf(false)));
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CreakingHeartBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClient()) {
            return null;
        }
        return state.get(STATE) != CreakingHeartState.UPROOTED ? CreakingHeartBlock.validateTicker(blockEntityType, ModBlockEntities.CREAKING_HEART.get(), CreakingHeartBlockEntity::serverTick) : null;
    }

    public static boolean isNaturalNight(World level) {
        return LevelUtils.isMoonVisible(level);
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        if (CreakingHeartBlock.isNaturalNight(level) && state.get(STATE) != CreakingHeartState.UPROOTED && random.nextInt(16) == 0 && CreakingHeartBlock.isSurroundedByLogs((WorldAccess)level, pos)) {
            level.playSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), ModSoundEvents.CREAKING_HEART_IDLE.get(), SoundCategory.BLOCKS, 1.0f, 1.0f, false);
        }
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos pos, BlockPos neighborPos) {
        level.scheduleBlockTick(pos, (Block)this, 1);
        return super.getStateForNeighborUpdate(state, direction, neighborState, level, pos, neighborPos);
    }

    public void scheduledTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        BlockState updatedState = CreakingHeartBlock.updateState(state, (World)level, pos);
        if (updatedState != state) {
            level.setBlockState(pos, updatedState, 3);
        }
    }

    private static BlockState updateState(BlockState state, World level, BlockPos pos) {
        boolean isUprooted;
        boolean hasRequiredLogs = CreakingHeartBlock.hasRequiredLogs(state, (WorldView)level, pos);
        boolean bl = isUprooted = state.get(STATE) == CreakingHeartState.UPROOTED;
        return hasRequiredLogs && isUprooted ? state.with(STATE, ((CreakingHeartBlock.isNaturalNight(level) ? CreakingHeartState.AWAKE : CreakingHeartState.DORMANT))) : state;
    }

    public static boolean hasRequiredLogs(BlockState state, WorldView level, BlockPos pos) {
        Direction.Axis axis = (Direction.Axis)state.get(AXIS);
        for (Direction direction : CreakingHeartBlock.directions(axis)) {
            BlockPos neighborPos = pos.offset(direction);
            BlockState neighborState = level.getBlockState(neighborPos);
            if (!neighborState.isIn(ModBlockTags.CREAKING_HEART_HOLDERS)) {
                return false;
            }
            if (!neighborState.contains(AXIS) || neighborState.get(AXIS) == axis) continue;
            return false;
        }
        return true;
    }

    private static Direction[] directions(Direction.Axis axis) {
        Direction[] class_2350Array;
        switch (axis) {
            default: {
                throw new MatchException(null, null);
            }
            case X: {
                Direction[] class_2350Array2 = new Direction[2];
                class_2350Array2[0] = Direction.NORTH;
                class_2350Array = class_2350Array2;
                class_2350Array2[1] = Direction.SOUTH;
                break;
            }
            case Y: {
                Direction[] class_2350Array3 = new Direction[2];
                class_2350Array3[0] = Direction.UP;
                class_2350Array = class_2350Array3;
                class_2350Array3[1] = Direction.DOWN;
                break;
            }
            case Z: {
                Direction[] class_2350Array4 = new Direction[2];
                class_2350Array4[0] = Direction.EAST;
                class_2350Array = class_2350Array4;
                class_2350Array4[1] = Direction.WEST;
            }
        }
        return class_2350Array;
    }

    private static boolean isSurroundedByLogs(WorldAccess level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.offset(direction);
            BlockState neighborState = level.getBlockState(neighborPos);
            if (neighborState.isIn(ModBlockTags.CREAKING_HEART_HOLDERS)) continue;
            return false;
        }
        return true;
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        return CreakingHeartBlock.updateState(this.getDefaultState().with(AXIS, context.getSide().getAxis()), context.getWorld(), context.getBlockPos());
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return PillarBlock.changeRotation(state, (BlockRotation)rotation);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AXIS, STATE, NATURAL});
    }

    public BlockState onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockEntity class_25862 = level.getBlockEntity(pos);
        if (class_25862 instanceof CreakingHeartBlockEntity) {
            CreakingHeartBlockEntity heart = (CreakingHeartBlockEntity)class_25862;
            heart.removeProtector(player.getDamageSources().playerAttack(player));
            this.tryAwardExperience(player, state, level, pos);
        }
        return super.onBreak(level, pos, state, player);
    }

    private void tryAwardExperience(PlayerEntity player, BlockState state, World level, BlockPos pos) {
        if (!player.getAbilities().creativeMode && !player.isSpectator() && ((Boolean)state.get(NATURAL)).booleanValue() && level instanceof ServerWorld) {
            ServerWorld server = (ServerWorld)level;
            this.dropExperience(server, pos, level.random.nextBetween(20, 24));
        }
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World level, BlockPos pos) {
        int n;
        if (state.get(STATE) == CreakingHeartState.UPROOTED) {
            return 0;
        }
        BlockEntity class_25862 = level.getBlockEntity(pos);
        if (class_25862 instanceof CreakingHeartBlockEntity) {
            CreakingHeartBlockEntity heart = (CreakingHeartBlockEntity)class_25862;
            n = heart.getAnalogOutputSignal();
        } else {
            n = 0;
        }
        return n;
    }
}

