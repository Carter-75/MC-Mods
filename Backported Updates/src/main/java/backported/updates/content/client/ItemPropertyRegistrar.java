/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Identifier
 *  net.minecraft.item.BundleItem
 *  net.minecraft.client.world.ClientWorld
 */
package backported.updates.content.client;

import backported.updates.content.common.registries.ModItems;
import backported.updates.foundation.common.item.ItemPropertyRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.item.BundleItem;
import net.minecraft.client.world.ClientWorld;

public class ItemPropertyRegistrar {
    public static void bootstrap() {
        ItemPropertyRegistry.register(ModItems.BLACK_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.WHITE_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.GRAY_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.LIGHT_GRAY_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.LIGHT_BLUE_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.BLUE_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.CYAN_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.YELLOW_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.RED_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.PURPLE_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.MAGENTA_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.PINK_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.GREEN_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.LIME_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.BROWN_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.ORANGE_BUNDLE.get(), Identifier.ofVanilla((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
    }

    private static float bundleDisplay(ItemStack stack, ClientWorld level, LivingEntity entity, int i) {
        return BundleItem.getAmountFilled((ItemStack)stack);
    }
}

