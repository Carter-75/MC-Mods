package com.itemuncrafting.item;

import com.itemuncrafting.ItemUncrafting;
import com.itemuncrafting.component.UncraftedItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class UncraftedCrateItem extends BlockItem {

    public UncraftedCrateItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> consumer, TooltipFlag type) {
        super.appendHoverText(stack, context, display, consumer, type);
        UncraftedItems data = stack.get(ItemUncrafting.UNCRAFTED_ITEMS);
        if (data != null && !data.items().isEmpty()) {
            consumer.accept(Component.literal("Contains:").withStyle(ChatFormatting.GRAY));
            
            // Group items to display nicely
            Map<Item, Integer> counts = new LinkedHashMap<>();
            for (ItemStack itemStack : data.items()) {
                if (!itemStack.isEmpty()) {
                    counts.put(itemStack.getItem(), counts.getOrDefault(itemStack.getItem(), 0) + itemStack.getCount());
                }
            }
            
            for (Map.Entry<Item, Integer> entry : counts.entrySet()) {
                consumer.accept(Component.literal(" - " + entry.getValue() + "x ")
                    .append(new ItemStack(entry.getKey()).getHoverName())
                    .withStyle(ChatFormatting.GREEN));
            }
        } else {
            consumer.accept(Component.literal("Empty").withStyle(ChatFormatting.DARK_GRAY));
        }
    }
}
