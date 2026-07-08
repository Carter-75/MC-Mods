/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1271
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 */
package net._void.civilizations.item.custom;

import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;

public class AnubisAnkhItem
extends class_1792 {
    public AnubisAnkhItem(class_1792.class_1793 settings) {
        super(settings);
    }

    public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        if (!world.method_8608()) {
            user.method_7357().method_7906((class_1792)this, 1200);
            user.method_6092(new class_1293(class_1294.field_5910, 400, 2, false, true));
        }
        return super.method_7836(world, user, hand);
    }
}

