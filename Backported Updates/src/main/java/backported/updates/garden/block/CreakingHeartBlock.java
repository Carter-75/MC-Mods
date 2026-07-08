/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraft.block.BlockWithEntity
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockRenderType
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.StateManager$Builder
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.Property
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.entity.BlockEntityTicker
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import backported.updates.garden.entity.CreakingBlockEntityTypes;
import backported.updates.garden.entity.CreakingHeartBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.entity.BlockEntityTicker;
import org.jetbrains.annotations.Nullable;

public class CreakingHeartBlock
extends BlockWithEntity {
    public static BooleanProperty ACTIVATED = BooleanProperty.of((String)"activated");

    public CreakingHeartBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(ACTIVATED, Boolean.valueOf(true)));
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CreakingHeartBlock.createCodec(CreakingHeartBlock::new);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{ACTIVATED});
    }

    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);
        this.updateActivationState(world, pos, state);
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        super.neighborUpdate(state, world, pos, block, fromPos, notify);
        this.updateActivationState(world, pos, state);
    }

    private void updateActivationState(World world, BlockPos pos, BlockState state) {
        boolean isActivated = world.getBlockState(pos.up()).isOf(Init.PALE_OAK_LOG) && world.getBlockState(pos.down()).isOf(Init.PALE_OAK_LOG);
        world.setBlockState(pos, state.with(ACTIVATED, Boolean.valueOf(isActivated)), 3);
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CreakingHeartBlockEntity(CreakingBlockEntityTypes.CREAKING_HEART_BLOCK, pos, state);
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        this.neighborUpdate(state, world, pos, this.asBlock(), pos, true);
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null) {
            CreakingHeartBlockEntity creakingHeartBlock = (CreakingHeartBlockEntity)blockEntity;
            if (creakingHeartBlock.creakingEntity != null) {
                BlockPos pos1 = creakingHeartBlock.creakingEntity.getBlockPos();
                BlockPos pos2 = pos;
                int distance = (int)Math.sqrt(Math.pow(pos1.getX() - pos2.getX(), 2.0) + Math.pow(pos1.getY() - pos2.getY(), 2.0) + Math.pow(pos1.getZ() - pos2.getZ(), 2.0));
                int powerResult = 15 - distance;
                return powerResult < 0 ? 0 : powerResult;
            }
        }
        return 0;
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return CreakingHeartBlock.validateTicker(type, CreakingBlockEntityTypes.CREAKING_HEART_BLOCK, CreakingHeartBlockEntity::tick);
    }
}

