/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.entity.ai.pathing.NavigationType
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemPlacementContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.block.HorizontalFacingBlock
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleTypes
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.state.property.IntProperty
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.FluidTags
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.fluid.Fluid
 *  net.minecraft.fluid.Fluids
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.block.Waterloggable
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.world.event.GameEvent$Emitter
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.entry.RegistryEntry
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import backported.updates.content.common.registries.ModBlockStateProperties;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.core.data.tags.ModBlockTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.world.event.GameEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.entry.RegistryEntry;
import org.jetbrains.annotations.Nullable;

public class DriedGhastBlock
extends HorizontalFacingBlock
implements Waterloggable {
    public static final MapCodec<DriedGhastBlock> CODEC = DriedGhastBlock.createCodec(DriedGhastBlock::new);
    public static final int MAX_HYDRATION_LEVEL = 3;
    public static final IntProperty HYDRATION_LEVEL = ModBlockStateProperties.HYDRATION_LEVEL;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final int HYDRATION_TICK_DELAY = 5000;
    private static final VoxelShape SHAPE = Block.createCuboidShape((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)10.0, (double)13.0);

    public MapCodec<DriedGhastBlock> getCodec() {
        return CODEC;
    }

    public DriedGhastBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState((((this.getStateManager().getDefaultState()).with(FACING, Direction.NORTH)).with(HYDRATION_LEVEL, Integer.valueOf(0))).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, HYDRATION_LEVEL, WATERLOGGED});
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos pos, BlockPos neighborPos) {
        if (((Boolean)state.get(WATERLOGGED)).booleanValue()) {
            level.scheduleFluidTick(pos, (Fluid)Fluids.WATER, Fluids.WATER.getTickRate((WorldView)level));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, level, pos, neighborPos);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public int getHydrationLevel(BlockState state) {
        return (Integer)state.get(HYDRATION_LEVEL);
    }

    private boolean isReadyToSpawn(BlockState state) {
        return this.getHydrationLevel(state) == 3;
    }

    public void scheduledTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (((Boolean)state.get(WATERLOGGED)).booleanValue()) {
            this.tickWaterlogged(state, level, pos, random);
        } else {
            int hydrationLevel = this.getHydrationLevel(state);
            if (hydrationLevel > 0) {
                level.setBlockState(pos, state.with(HYDRATION_LEVEL, Integer.valueOf(hydrationLevel - 1)), 2);
                level.emitGameEvent((RegistryEntry)GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
            }
        }
    }

    private void tickWaterlogged(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (!this.isReadyToSpawn(state)) {
            level.playSound(null, pos, ModSoundEvents.DRIED_GHAST_TRANSITION.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.setBlockState(pos, state.with(HYDRATION_LEVEL, Integer.valueOf(this.getHydrationLevel(state) + 1)), 2);
            level.emitGameEvent((RegistryEntry)GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
        } else {
            this.spawnGhastling(level, pos, state);
        }
    }

    private void spawnGhastling(ServerWorld level, BlockPos pos, BlockState state) {
        level.removeBlock(pos, false);
        HappyGhast ghast = (HappyGhast)ModEntities.HAPPY_GHAST.get().create((World)level);
        if (ghast != null) {
            Vec3d center = Vec3d.ofBottomCenter((Vec3i)pos);
            ghast.setBaby(true);
            float yRot = DriedGhastBlock.getYRot((Direction)state.get(FACING));
            ghast.setHeadYaw(yRot);
            ghast.setPos(center.getX(), center.getY(), center.getZ());
            ghast.setYaw(yRot);
            ghast.setPitch(0.0f);
            ghast.resetPosition();
            ghast.setPosition(ghast.getPos().getX(), ghast.getPos().getY(), ghast.getPos().getZ());
            level.spawnEntity((Entity)ghast);
            level.playSoundFromEntity(null, (Entity)ghast, ModSoundEvents.GHASTLING_SPAWN.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }

    public static float getYRot(Direction direction) {
        return switch (direction) {
            case Direction.NORTH -> 180.0f;
            case Direction.SOUTH -> 0.0f;
            case Direction.WEST -> 90.0f;
            case Direction.EAST -> -90.0f;
            default -> throw new IllegalStateException("No y-Rot for vertical axis: " + String.valueOf(direction));
        };
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        double x = (double)pos.getX() + 0.5;
        double y = (double)pos.getY() + 0.5;
        double z = (double)pos.getZ() + 0.5;
        if (!((Boolean)state.get(WATERLOGGED)).booleanValue()) {
            if (random.nextInt(40) == 0 && level.getBlockState(pos.down()).isIn(ModBlockTags.TRIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS)) {
                level.playSound(x, y, z, ModSoundEvents.DRIED_GHAST_AMBIENT.get(), SoundCategory.AMBIENT, 1.0f, 1.0f, false);
            }
            if (random.nextInt(6) == 0) {
                level.addParticle((ParticleEffect)ParticleTypes.SMOKE, x, y, z, 0.0, 0.02, 0.0);
            }
        } else {
            if (random.nextInt(40) == 0) {
                level.playSound(x, y, z, ModSoundEvents.DRIED_GHAST_AMBIENT_WATER.get(), SoundCategory.AMBIENT, 1.0f, 1.0f, false);
            }
            if (random.nextInt(6) == 0) {
                level.addParticle((ParticleEffect)ParticleTypes.HAPPY_VILLAGER, x + (double)((random.nextFloat() * 2.0f - 1.0f) / 3.0f), y + 0.4, z + (double)((random.nextFloat() * 2.0f - 1.0f) / 3.0f), 0.0, (double)random.nextFloat(), 0.0);
            }
        }
    }

    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if ((((Boolean)state.get(WATERLOGGED)).booleanValue() || (Integer)state.get(HYDRATION_LEVEL) > 0) && !level.getBlockTickScheduler().isQueued(pos, this)) {
            level.scheduleBlockTick(pos, (Block)this, 5000);
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState state = context.getWorld().getFluidState(context.getBlockPos());
        boolean isWaterlogged = state.isIn(FluidTags.WATER) && state.getLevel() == 8;
        return (super.getPlacementState(context).with(WATERLOGGED, Boolean.valueOf(isWaterlogged))).with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) != false ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public boolean tryFillWithFluid(WorldAccess level, BlockPos pos, BlockState state, FluidState fluidState) {
        if (((Boolean)state.get(Properties.WATERLOGGED)).booleanValue() || fluidState.getFluid() != Fluids.WATER) {
            return false;
        }
        if (!level.isClient()) {
            level.setBlockState(pos, state.with(Properties.WATERLOGGED, Boolean.valueOf(true)), 3);
            level.scheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate((WorldView)level));
            level.playSound(null, pos, ModSoundEvents.DRIED_GHAST_PLACE_IN_WATER.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        return true;
    }

    public void onPlaced(World level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onPlaced(level, pos, state, placer, stack);
        level.playSound(null, pos, (Boolean)state.get(WATERLOGGED) != false ? ModSoundEvents.DRIED_GHAST_PLACE_IN_WATER.get() : ModSoundEvents.DRIED_GHAST_PLACE.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType pathComputationType) {
        return false;
    }
}

