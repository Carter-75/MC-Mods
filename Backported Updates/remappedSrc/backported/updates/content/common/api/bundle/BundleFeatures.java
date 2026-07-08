/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_1767
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_3417
 *  net.minecraft.class_9276
 *  net.minecraft.class_9276$class_9277
 *  net.minecraft.class_9334
 */
package backported.updates.content.common.api.bundle;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.api.bundle.IBundle;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.ModChecker;
import backported.updates.content.core.VanillaBackport;
import java.util.Optional;
import net.minecraft.class_1263;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_1767;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_3417;
import net.minecraft.class_9276;
import net.minecraft.class_9334;

public class BundleFeatures {
    public static boolean onBundleUpdate() {
        return VanillaBackport.COMMON_CONFIG.hasUpdatedBundles.get() != false && !ModChecker.BEST_BUNDLES_LOADED;
    }

    public static boolean canItemBeInBundle(class_1799 stack) {
        return !stack.method_7960() && stack.method_7909().method_31568();
    }

    public static void toggleSelectedItem(class_1799 stack, int index) {
        class_9276 contents = (class_9276)stack.method_57824(class_9334.field_49650);
        if (contents != null) {
            class_9276.class_9277 mutable = new class_9276.class_9277(contents);
            ((IBundle.Mutable)mutable).toggleSelectedItem(index);
            stack.method_57379(class_9334.field_49650, (Object)mutable.method_57435());
        }
    }

    public static int getSelectedItem(class_1799 stack) {
        class_9276 contents = (class_9276)stack.method_57825(class_9334.field_49650, (Object)class_9276.field_49289);
        return ((IBundle)contents).getSelectedItem();
    }

    public static class_1799 getSelectedItemStack(class_1799 stack) {
        class_9276 contents = (class_9276)stack.method_57824(class_9334.field_49650);
        IBundle ibundle = (IBundle)contents;
        return contents != null && ibundle.getSelectedItem() != -1 ? contents.method_57422(ibundle.getSelectedItem()) : class_1799.field_8037;
    }

    public static int getNumberOfItemsToShow(class_1799 stack) {
        class_9276 contents = (class_9276)stack.method_57825(class_9334.field_49650, (Object)class_9276.field_49289);
        return ((IBundle)contents).getNumberOfItemsToShow();
    }

    public static Optional<class_1799> removeOneItemFromBundle(class_1799 stack, class_1657 player, class_9276 contents) {
        class_9276.class_9277 mutable = new class_9276.class_9277(contents);
        class_1799 itemStack = mutable.method_57430();
        if (itemStack != null) {
            BundleFeatures.playRemoveOneSound((class_1297)player);
            stack.method_57379(class_9334.field_49650, (Object)mutable.method_57435());
            return Optional.of(itemStack);
        }
        return Optional.empty();
    }

    public static class_1792 getByColor(class_1767 dyeColor) {
        return switch (dyeColor) {
            case class_1767.field_7952 -> ModItems.WHITE_BUNDLE.get();
            case class_1767.field_7946 -> ModItems.ORANGE_BUNDLE.get();
            case class_1767.field_7958 -> ModItems.MAGENTA_BUNDLE.get();
            case class_1767.field_7951 -> ModItems.LIGHT_BLUE_BUNDLE.get();
            case class_1767.field_7947 -> ModItems.YELLOW_BUNDLE.get();
            case class_1767.field_7961 -> ModItems.LIME_BUNDLE.get();
            case class_1767.field_7954 -> ModItems.PINK_BUNDLE.get();
            case class_1767.field_7944 -> ModItems.GRAY_BUNDLE.get();
            case class_1767.field_7967 -> ModItems.LIGHT_GRAY_BUNDLE.get();
            case class_1767.field_7955 -> ModItems.CYAN_BUNDLE.get();
            case class_1767.field_7966 -> ModItems.BLUE_BUNDLE.get();
            case class_1767.field_7957 -> ModItems.BROWN_BUNDLE.get();
            case class_1767.field_7942 -> ModItems.GREEN_BUNDLE.get();
            case class_1767.field_7964 -> ModItems.RED_BUNDLE.get();
            case class_1767.field_7963 -> ModItems.BLACK_BUNDLE.get();
            case class_1767.field_7945 -> ModItems.PURPLE_BUNDLE.get();
            default -> class_1802.field_27023;
        };
    }

    public static void playRemoveOneSound(class_1297 entity) {
        entity.method_5783(class_3417.field_34377, 0.8f, 0.8f + entity.method_37908().method_8409().method_43057() * 0.4f);
    }

    public static void playInsertFailSound(class_1297 entity) {
        entity.method_5783(ModSoundEvents.BUNDLE_INSERT_FAIL.get(), 1.0f, 1.0f);
    }

    public static void broadcastChangesOnContainerMenu(class_1657 player) {
        class_1703 menu = player.field_7512;
        if (menu.method_7597(player)) {
            menu.method_7609((class_1263)player.method_31548());
        }
    }
}

