package com.uncraftable.block.entity;

import com.uncraftable.Uncraftable;
import com.uncraftable.component.UncraftableItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Collections;
import java.util.List;

public class UncraftableCrateBlockEntity extends BlockEntity {

    public UncraftableCrateBlockEntity(BlockPos pos, BlockState state) {
        super(Uncraftable.UNCRAFTABLE_CRATE_BLOCK_ENTITY, pos, state);
    }

    public List<ItemStack> getItems() {
        UncraftableItems data = this.components().get(Uncraftable.UNCRAFTABLE_ITEMS);
        return data != null ? data.items() : Collections.emptyList();
    }
}
