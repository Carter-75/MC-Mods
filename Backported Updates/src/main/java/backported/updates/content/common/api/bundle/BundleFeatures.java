/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.util.DyeColor
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.component.type.BundleContentsComponent
 *  net.minecraft.component.type.BundleContentsComponent$Builder
 *  net.minecraft.component.DataComponentTypes
 */
package backported.updates.content.common.api.bundle;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.api.bundle.IBundle;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.ModChecker;
import backported.updates.content.core.VanillaBackport;
import java.util.Optional;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.component.DataComponentTypes;

public class BundleFeatures {
    public static boolean onBundleUpdate() {
        return VanillaBackport.COMMON_CONFIG.hasUpdatedBundles.get() != false && !ModChecker.BEST_BUNDLES_LOADED;
    }

    public static boolean canItemBeInBundle(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem().canBeNested();
    }

    public static void toggleSelectedItem(ItemStack stack, int index) {
        BundleContentsComponent contents = (BundleContentsComponent)stack.get(DataComponentTypes.BUNDLE_CONTENTS);
        if (contents != null) {
            BundleContentsComponent.Builder mutable = new BundleContentsComponent.Builder(contents);
            ((IBundle.Mutable)mutable).toggleSelectedItem(index);
            stack.set(DataComponentTypes.BUNDLE_CONTENTS, mutable.build());
        }
    }

    public static int getSelectedItem(ItemStack stack) {
        BundleContentsComponent contents = (BundleContentsComponent)stack.getOrDefault(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT);
        return ((IBundle)(Object)contents).getSelectedItem();
    }

    public static ItemStack getSelectedItemStack(ItemStack stack) {
        BundleContentsComponent contents = (BundleContentsComponent)stack.get(DataComponentTypes.BUNDLE_CONTENTS);
        IBundle ibundle = (IBundle)(Object)contents;
        return contents != null && ibundle.getSelectedItem() != -1 ? contents.get(ibundle.getSelectedItem()) : ItemStack.EMPTY;
    }

    public static int getNumberOfItemsToShow(ItemStack stack) {
        BundleContentsComponent contents = (BundleContentsComponent)stack.getOrDefault(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT);
        return ((IBundle)(Object)contents).getNumberOfItemsToShow();
    }

    public static Optional<ItemStack> removeOneItemFromBundle(ItemStack stack, PlayerEntity player, BundleContentsComponent contents) {
        BundleContentsComponent.Builder mutable = new BundleContentsComponent.Builder(contents);
        ItemStack itemStack = mutable.removeFirst();
        if (itemStack != null) {
            BundleFeatures.playRemoveOneSound((Entity)player);
            stack.set(DataComponentTypes.BUNDLE_CONTENTS, mutable.build());
            return Optional.of(itemStack);
        }
        return Optional.empty();
    }

    public static Item getByColor(DyeColor dyeColor) {
        return switch (dyeColor) {
            case DyeColor.WHITE -> ModItems.WHITE_BUNDLE.get();
            case DyeColor.ORANGE -> ModItems.ORANGE_BUNDLE.get();
            case DyeColor.MAGENTA -> ModItems.MAGENTA_BUNDLE.get();
            case DyeColor.LIGHT_BLUE -> ModItems.LIGHT_BLUE_BUNDLE.get();
            case DyeColor.YELLOW -> ModItems.YELLOW_BUNDLE.get();
            case DyeColor.LIME -> ModItems.LIME_BUNDLE.get();
            case DyeColor.PINK -> ModItems.PINK_BUNDLE.get();
            case DyeColor.GRAY -> ModItems.GRAY_BUNDLE.get();
            case DyeColor.LIGHT_GRAY -> ModItems.LIGHT_GRAY_BUNDLE.get();
            case DyeColor.CYAN -> ModItems.CYAN_BUNDLE.get();
            case DyeColor.BLUE -> ModItems.BLUE_BUNDLE.get();
            case DyeColor.BROWN -> ModItems.BROWN_BUNDLE.get();
            case DyeColor.GREEN -> ModItems.GREEN_BUNDLE.get();
            case DyeColor.RED -> ModItems.RED_BUNDLE.get();
            case DyeColor.BLACK -> ModItems.BLACK_BUNDLE.get();
            case DyeColor.PURPLE -> ModItems.PURPLE_BUNDLE.get();
            default -> Items.BUNDLE;
        };
    }

    public static void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_REMOVE_ONE, 0.8f, 0.8f + entity.getWorld().getRandom().nextFloat() * 0.4f);
    }

    public static void playInsertFailSound(Entity entity) {
        entity.playSound(ModSoundEvents.BUNDLE_INSERT_FAIL.get(), 1.0f, 1.0f);
    }

    public static void broadcastChangesOnContainerMenu(PlayerEntity player) {
        ScreenHandler menu = player.currentScreenHandler;
        if (menu.canUse(player)) {
            menu.onContentChanged((Inventory)player.getInventory());
        }
    }
}

