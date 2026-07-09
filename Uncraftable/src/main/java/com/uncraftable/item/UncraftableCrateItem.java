package com.uncraftable.item;

import com.uncraftable.Uncraftable;
import com.uncraftable.component.UncraftableItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
// import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class UncraftableCrateItem extends BlockItem {

    public UncraftableCrateItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null && player.isSecondaryUseActive()) {
            if (!context.getLevel().isClientSide()) {
                openCrate(context.getItemInHand(), player);
            }
            return InteractionResult.SUCCESS;
        }
        return super.useOn(context);
    }

    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.isSecondaryUseActive()) {
            if (!world.isClientSide()) {
                openCrate(stack, player);
            }
            return InteractionResult.SUCCESS;
        }
        return super.use(world, player, hand);
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction action, Player player) {
        if (action == ClickAction.SECONDARY && slot.allowModification(player)) {
            if (!player.level().isClientSide()) {
                openCrate(stack, player);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack other, Slot slot, ClickAction action, Player player, SlotAccess slotAccess) {
        if (action == ClickAction.SECONDARY && slot.allowModification(player)) {
            if (other.isEmpty()) {
                if (!player.level().isClientSide()) {
                    openCrate(stack, player);
                }
                return true;
            }
        }
        return false;
    }

    private void openCrate(ItemStack crateStack, Player player) {
        UncraftableItems data = crateStack.get(Uncraftable.UNCRAFTABLE_ITEMS);
        if (data != null && !data.items().isEmpty()) {
            Level world = player.level();
            // Pop items to player's inventory
            for (ItemStack stack : data.items()) {
                if (!stack.isEmpty()) {
                    if (!player.getInventory().add(stack.copy())) {
                        player.drop(stack.copy(), false);
                    }
                }
            }
            // Play tool break sound at player location
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                net.minecraft.sounds.SoundEvents.ITEM_BREAK.value(),
                net.minecraft.sounds.SoundSource.PLAYERS, 1.0f, 1.0f);
            // Decrement crate stack
            crateStack.shrink(1);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> consumer, TooltipFlag type) {
        super.appendHoverText(stack, context, display, consumer, type);
        UncraftableItems data = stack.get(Uncraftable.UNCRAFTABLE_ITEMS);
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
