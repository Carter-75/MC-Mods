/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1800
 *  net.minecraft.class_1935
 *  net.minecraft.class_2960
 *  net.minecraft.class_5272
 *  net.minecraft.class_6395
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.common.item;

import backported.updates.foundation.common.item.fabric.ItemPropertyRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1800;
import net.minecraft.class_1935;
import net.minecraft.class_2960;
import net.minecraft.class_5272;
import net.minecraft.class_6395;
import org.jetbrains.annotations.Nullable;

public class ItemPropertyRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static class_6395 registerGeneric(class_2960 name, class_6395 property) {
        return ItemPropertyRegistryImpl.registerGeneric(name, property);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static class_1800 registerGeneric(class_2960 name, class_1800 property) {
        return ItemPropertyRegistryImpl.registerGeneric(name, property);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerCustomModelData(class_1800 property) {
        ItemPropertyRegistryImpl.registerCustomModelData(property);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void register(class_1792 item, class_2960 name, class_6395 property) {
        ItemPropertyRegistryImpl.register(item, name, property);
    }

    @Nullable
    public static class_1800 getProperty(class_1792 item, class_2960 name) {
        return class_5272.method_27878((class_1799)new class_1799((class_1935)item), (class_2960)name);
    }
}

