/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2383
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2769
 *  net.minecraft.class_3726
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.block.custom;

import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2383;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_4970;
import org.jetbrains.annotations.Nullable;

public class RomeChest
extends class_2383 {
    private static final class_265 SHAPE = class_2248.method_9541((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)14.0, (double)15.0);

    public RomeChest(class_4970.class_2251 settings) {
        super(settings);
    }

    public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
        return SHAPE;
    }

    @Nullable
    public class_2680 method_9605(class_1750 ctx) {
        return (class_2680)this.method_9564().method_11657((class_2769)field_11177, (Comparable)ctx.method_8042().method_10153());
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{field_11177});
    }
}

