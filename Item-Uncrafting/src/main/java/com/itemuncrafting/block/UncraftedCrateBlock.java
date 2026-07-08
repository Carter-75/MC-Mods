package com.itemuncrafting.block;

import com.itemuncrafting.ItemUncrafting;
import com.itemuncrafting.block.entity.UncraftedCrateBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import java.util.ArrayList;

public class UncraftedCrateBlock extends BaseEntityBlock {
    public static final com.mojang.serialization.MapCodec<UncraftedCrateBlock> CODEC = simpleCodec(UncraftedCrateBlock::new);

    public UncraftedCrateBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected com.mojang.serialization.MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new UncraftedCrateBlockEntity(pos, state);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(world, pos, state, placer, stack);
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof UncraftedCrateBlockEntity) {
            be.applyComponentsFromItemStack(stack);
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!world.isClientSide()) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof UncraftedCrateBlockEntity crateBe) {
                List<ItemStack> items = crateBe.getItems();
                for (ItemStack stack : items) {
                    popResource(world, pos, stack.copy());
                }
            }
            // Play tool breaking sound when opened
            world.playSound(null, pos, net.minecraft.sounds.SoundEvents.ITEM_BREAK.value(), net.minecraft.sounds.SoundSource.BLOCKS, 1.0f, 1.0f);
            world.destroyBlock(pos, false, player);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        BlockEntity be = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (be instanceof UncraftedCrateBlockEntity crateBe) {
            ItemStack crateStack = new ItemStack(ItemUncrafting.UNCRAFTED_CRATE_ITEM);
            crateStack.applyComponents(crateBe.collectComponents());
            drops.add(crateStack);
        } else {
            drops.add(new ItemStack(ItemUncrafting.UNCRAFTED_CRATE_ITEM));
        }
        return drops;
    }
}
