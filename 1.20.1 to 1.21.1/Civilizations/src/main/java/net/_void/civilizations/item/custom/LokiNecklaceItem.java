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

public class LokiNecklaceItem
extends class_1792 {
    public LokiNecklaceItem(class_1792.class_1793 settings) {
        super(settings);
    }

    public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        if (!world.method_8608()) {
            user.method_7357().method_7906((class_1792)this, 400);
            user.method_6092(new class_1293(class_1294.field_5905, 200, 0, false, true));
            user.method_6092(new class_1293(class_1294.field_5904, 200, 1, false, true));
            user.method_6092(new class_1293(class_1294.field_5913, 200, 4, false, true));
            user.method_6092(new class_1293(class_1294.field_5906, 200, 0, false, true));
            user.method_6092(new class_1293(class_1294.field_5925, 200, 0, false, true));
        }
        return super.method_7836(world, user, hand);
    }
}

