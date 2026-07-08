/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_2960
 *  net.minecraft.class_5272
 */
package net._void.civilizations.util;

import net._void.civilizations.item.ModItems;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import net.minecraft.class_5272;

public class ModModelPredicates {
    public static void registerModModels() {
        ModModelPredicates.registerCustomBow(ModItems.ARTEMIS_BOW);
    }

    private static void registerCustomBow(class_1792 item) {
        class_5272.method_27879((class_1792)item, (class_2960)new class_2960("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            return entity.method_6030() != stack ? 0.0f : (float)(stack.method_7935() - entity.method_6014()) / 20.0f;
        });
        class_5272.method_27879((class_1792)item, (class_2960)new class_2960("pulling"), (stack, world, entity, seed) -> entity != null && entity.method_6115() && entity.method_6030() == stack ? 1.0f : 0.0f);
    }
}

