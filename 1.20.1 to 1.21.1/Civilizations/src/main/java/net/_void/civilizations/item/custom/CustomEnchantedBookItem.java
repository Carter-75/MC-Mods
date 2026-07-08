/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1772
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1889
 *  net.minecraft.class_1893
 *  net.minecraft.class_1937
 *  net.minecraft.class_2561
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.item.custom;

import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1772;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1889;
import net.minecraft.class_1893;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import org.jetbrains.annotations.Nullable;

public class CustomEnchantedBookItem
extends class_1792 {
    private String type = "";

    public CustomEnchantedBookItem(String type, class_1792.class_1793 settings) {
        super(settings);
        this.type = type;
    }

    public boolean method_7886(class_1799 stack) {
        return true;
    }

    public boolean method_7870(class_1799 stack) {
        return false;
    }

    public void method_7888(class_1799 stack, class_1937 world, class_1297 entity, int slot, boolean selected) {
        class_1799 newStack = null;
        switch (this.type) {
            case "sharpness": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9118, 4));
                break;
            }
            case "power": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9103, 3));
                break;
            }
            case "fire_aspect": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9124, 2));
                break;
            }
            case "unbreaking": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9119, 3));
                break;
            }
            case "protection": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9111, 3));
                break;
            }
            case "feather_falling": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9129, 3));
                break;
            }
            case "thorns": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9097, 2));
                break;
            }
            case "frost_walker": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9122, 2));
                break;
            }
            case "depth_strider": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9128, 3));
                break;
            }
            case "efficiency": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9131, 4));
                break;
            }
            case "fortune": {
                newStack = class_1772.method_7808((class_1889)new class_1889(class_1893.field_9130, 2));
            }
        }
        stack.method_7934(1);
        if (entity instanceof class_1657) {
            class_1657 player = (class_1657)entity;
            player.method_31548().method_5447(slot, newStack);
        }
        super.method_7888(stack, world, entity, slot, selected);
    }

    public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
        switch (this.type) {
            case "sharpness": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.sharpness_book"));
                break;
            }
            case "power": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.power_book"));
                break;
            }
            case "fire_aspect": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.fire_aspect_book"));
                break;
            }
            case "unbreaking": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.unbreaking_book"));
                break;
            }
            case "protection": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.protection_book"));
                break;
            }
            case "feather_falling": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.feather_falling_book"));
                break;
            }
            case "thorns": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.thorns_book"));
                break;
            }
            case "frost_walker": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.frost_walker_book"));
                break;
            }
            case "depth_strider": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.depth_strider_book"));
                break;
            }
            case "efficiency": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.efficiency_book"));
                break;
            }
            case "fortune": {
                tooltip.add((class_2561)class_2561.method_43471((String)"tooltip.civilizations.fortune_book"));
            }
        }
        super.method_7851(stack, world, tooltip, context);
    }
}

