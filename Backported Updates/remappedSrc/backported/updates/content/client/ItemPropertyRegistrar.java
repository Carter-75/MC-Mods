/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1799
 *  net.minecraft.class_2960
 *  net.minecraft.class_5537
 *  net.minecraft.class_638
 */
package backported.updates.content.client;

import backported.updates.content.common.registries.ModItems;
import backported.updates.foundation.common.item.ItemPropertyRegistry;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_2960;
import net.minecraft.class_5537;
import net.minecraft.class_638;

public class ItemPropertyRegistrar {
    public static void bootstrap() {
        ItemPropertyRegistry.register(ModItems.BLACK_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.WHITE_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.GRAY_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.LIGHT_GRAY_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.LIGHT_BLUE_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.BLUE_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.CYAN_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.YELLOW_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.RED_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.PURPLE_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.MAGENTA_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.PINK_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.GREEN_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.LIME_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.BROWN_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
        ItemPropertyRegistry.register(ModItems.ORANGE_BUNDLE.get(), class_2960.method_60656((String)"filled"), ItemPropertyRegistrar::bundleDisplay);
    }

    private static float bundleDisplay(class_1799 stack, class_638 level, class_1309 entity, int i) {
        return class_5537.method_31561((class_1799)stack);
    }
}

