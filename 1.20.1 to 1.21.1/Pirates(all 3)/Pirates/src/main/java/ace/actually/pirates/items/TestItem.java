/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1271
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 */
package ace.actually.pirates.items;

import ace.actually.pirates.blocks.entity.CrewSpawnerBlockEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_3218;

public class TestItem
extends class_1792 {
    public TestItem(class_1792.class_1793 settings) {
        super(settings);
    }

    public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        if (world instanceof class_3218) {
            class_3218 sw = (class_3218)world;
            if (hand == class_1268.field_5808) {
                class_1297 e = CrewSpawnerBlockEntity.makeCustomCrew(world, 0);
                sw.method_8649(e);
            }
        }
        return super.method_7836(world, user, hand);
    }
}

