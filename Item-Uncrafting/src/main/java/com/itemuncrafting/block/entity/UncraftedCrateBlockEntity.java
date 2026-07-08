package com.itemuncrafting.block.entity;

import com.itemuncrafting.ItemUncrafting;
import com.itemuncrafting.component.UncraftedItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Collections;
import java.util.List;

public class UncraftedCrateBlockEntity extends BlockEntity {

    public UncraftedCrateBlockEntity(BlockPos pos, BlockState state) {
        super(ItemUncrafting.UNCRAFTED_CRATE_BLOCK_ENTITY, pos, state);
    }

    public List<ItemStack> getItems() {
        UncraftedItems data = this.components().get(ItemUncrafting.UNCRAFTED_ITEMS);
        return data != null ? data.items() : Collections.emptyList();
    }
}
