/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1741
 *  net.minecraft.class_1802
 *  net.minecraft.class_1856
 *  net.minecraft.class_1935
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 */
package net._void.civilizations.item;

import java.util.function.Supplier;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1802;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_3414;
import net.minecraft.class_3417;

public enum ModArmorMaterials implements class_1741
{
    MERCURY("mercury", 25, new int[]{3, 8, 6, 3}, 19, class_3417.field_21866, 2.0f, 0.1f, () -> class_1856.method_8091((class_1935[])new class_1935[]{class_1802.field_22020}));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final class_3414 equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<class_1856> repairIngredient;
    private static final int[] BASE_DURABILITY;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, class_3414 equipSound, float toughness, float knockbackResistance, Supplier<class_1856> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    public int method_48402(class_1738.class_8051 type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    public int method_48403(class_1738.class_8051 type) {
        return this.protectionAmounts[type.ordinal()];
    }

    public int method_7699() {
        return this.enchantability;
    }

    public class_3414 method_7698() {
        return this.equipSound;
    }

    public class_1856 method_7695() {
        return this.repairIngredient.get();
    }

    public String method_7694() {
        return "civilizations:" + this.name;
    }

    public float method_7700() {
        return this.toughness;
    }

    public float method_24355() {
        return this.knockbackResistance;
    }

    static {
        BASE_DURABILITY = new int[]{11, 16, 15, 13};
    }
}

