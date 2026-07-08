/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_1800
 *  net.minecraft.class_2960
 *  net.minecraft.class_5272
 *  net.minecraft.class_6395
 */
package backported.updates.foundation.common.item.fabric;

import backported_updates.mixin.foundation.access.ItemPropertiesAccessor;
import net.minecraft.class_1792;
import net.minecraft.class_1800;
import net.minecraft.class_2960;
import net.minecraft.class_5272;
import net.minecraft.class_6395;

public class ItemPropertyRegistryImpl {
    public static class_6395 registerGeneric(class_2960 name, class_6395 property) {
        return class_5272.method_27881((class_2960)name, (class_6395)property);
    }

    public static class_1800 registerGeneric(class_2960 name, class_1800 property) {
        ItemPropertiesAccessor.getGENERIC_PROPERTIES().put(name, property);
        return property;
    }

    public static void registerCustomModelData(class_1800 property) {
        class_5272.method_37106((class_1800)property);
    }

    public static void register(class_1792 item, class_2960 name, class_6395 property) {
        class_5272.method_27879((class_1792)item, (class_2960)name, (class_6395)property);
    }
}

