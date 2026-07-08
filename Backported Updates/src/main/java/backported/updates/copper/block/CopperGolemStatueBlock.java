/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemPlacementContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 *  net.minecraft.block.BlockWithEntity
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockRenderType
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.state.property.DirectionProperty
 *  net.minecraft.state.property.EnumProperty
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.StringIdentifiable
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.fluid.Fluids
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.block.Waterloggable
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.util.ItemActionResult
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block;

import backported.updates.copper.ModSounds;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.entity.CopperGolemEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.world.event.GameEvent;
import net.minecraft.block.Oxidizable;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.ItemActionResult;
import org.jetbrains.annotations.Nullable;

public class CopperGolemStatueBlock
extends BlockWithEntity
implements Waterloggable {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<Pose> POSE = EnumProperty.of((String)"pose", Pose.class);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final VoxelShape SHAPE = Block.createCuboidShape((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)14.0, (double)13.0);
    private final Oxidizable.OxidationLevel weatheringState;

    public CopperGolemStatueBlock(Oxidizable.OxidationLevel weatheringState, AbstractBlock.Settings properties) {
        super(properties);
        this.weatheringState = weatheringState;
        this.setDefaultState(((this.getDefaultState().with(FACING, Direction.NORTH)).with(POSE, (Pose.STANDING))).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    public Oxidizable.OxidationLevel getWeatheringState() {
        return this.weatheringState;
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CopperGolemStatueBlock.createCodec(props -> new CopperGolemStatueBlock(this.weatheringState, (AbstractBlock.Settings)props));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, POSE, WATERLOGGED});
    }

    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluidstate = context.getWorld().getFluidState(context.getBlockPos());
        return (this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite())).with(WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER));
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (stack.isEmpty()) {
            if (!level.isClient()) {
                Pose currentPose = (Pose)(state.get(POSE));
                Pose nextPose = currentPose.getNextPose();
                level.setBlockState(pos, state.with(POSE, (nextPose)), 3);
                level.playSound(null, pos, ModSounds.COPPER_STATUE_HIT.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
                level.emitGameEvent((Entity)player, (RegistryEntry)GameEvent.BLOCK_CHANGE, pos);
                level.updateComparators(pos, (Block)this);
            }
            return ItemActionResult.SUCCESS;
        }
        if (stack.isIn(ItemTags.AXES) && !level.isClient()) {
            CopperGolemStatueBlockEntity statueEntity;
            CopperGolemEntity golem;
            ServerWorld serverLevel = (ServerWorld)level;
            BlockEntity class_25862 = level.getBlockEntity(pos);
            if (class_25862 instanceof CopperGolemStatueBlockEntity && (golem = (statueEntity = (CopperGolemStatueBlockEntity)class_25862).removeStatue(state, serverLevel)) != null) {
                level.removeBlock(pos, false);
                serverLevel.spawnEntity((Entity)golem);
                level.playSound(null, pos, ModSounds.COPPER_STATUE_BREAK.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
                level.syncWorldEvent(null, 3005, pos, 0);
                level.emitGameEvent((Entity)player, (RegistryEntry)GameEvent.BLOCK_DESTROY, pos);
                stack.damage(1, (LivingEntity)player, player.getPreferredEquipmentSlot(stack));
                return ItemActionResult.SUCCESS;
            }
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CopperGolemStatueBlockEntity(pos, state);
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) != false ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected int getComparatorOutput(BlockState state, World level, BlockPos pos) {
        return ((Pose)(state.get(POSE))).ordinal() + 1;
    }

    public static enum Pose implements StringIdentifiable
    {
        STANDING("standing"),
        RUNNING("running"),
        SITTING("sitting"),
        STAR("star");

        private final String name;

        private Pose(String name) {
            this.name = name;
        }

        public String asString() {
            return this.name;
        }

        public Pose getNextPose() {
            Pose[] poses = Pose.values();
            return poses[(this.ordinal() + 1) % poses.length];
        }
    }
}

