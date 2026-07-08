/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1738
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1741
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 */
package net._void.civilizations.item.custom;

import net._void.civilizations.item.ModArmorMaterials;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;

public class MercuryBoots
extends class_1738 {
    private int timer = 0;

    public MercuryBoots(class_1741 material, class_1738.class_8051 type, class_1792.class_1793 settings) {
        super(material, type, settings);
    }

    public void method_7888(class_1799 stack, class_1937 world, class_1297 entity, int slot, boolean selected) {
        if (!world.method_8608() && entity instanceof class_1657) {
            class_1657 player = (class_1657)entity;
            if (this.hasCorrectBootsOn(ModArmorMaterials.MERCURY, player) && stack.method_7919() <= 480) {
                player.method_31549().field_7478 = true;
                player.method_31549().method_7248(0.03f);
                player.method_7355();
            } else {
                player.method_31549().method_7248(0.05f);
                if (!player.method_7337() && !player.method_7325()) {
                    player.method_31549().field_7478 = false;
                    player.method_31549().field_7479 = false;
                }
                player.method_7355();
            }
            if (player.method_31549().field_7479) {
                ++this.timer;
            }
            if (this.timer == 360) {
                this.timer = 0;
                player.method_31548().method_7372(0).method_7956(1, (class_1309)player, playerEntity -> playerEntity.method_20235(class_1304.field_6166));
            }
        }
        super.method_7888(stack, world, entity, slot, selected);
    }

    private boolean hasCorrectBootsOn(class_1741 material, class_1657 player) {
        if (!(player.method_31548().method_7372(0).method_7909() instanceof class_1738)) {
            return false;
        }
        return !player.method_31548().method_7372(0).method_7960() && ((class_1738)player.method_31548().method_7372(0).method_7909()).method_7686() == material;
    }
}

