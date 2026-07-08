/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_5712
 *  net.minecraft.class_6880
 */
package backported.updates.content.common.level.items;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_5712;
import net.minecraft.class_6880;

public class HarnessItem
extends class_1792 {
    public HarnessItem(class_1792.class_1793 properties) {
        super(properties);
    }

    public class_1269 method_7847(class_1799 stack, class_1657 player, class_1309 target, class_1268 usedHand) {
        if (target instanceof HappyGhast) {
            HappyGhast ghast = (HappyGhast)target;
            if (target.method_5805() && !ghast.isHarnessed() && ghast.canBeHarnessed()) {
                if (!player.method_37908().field_9236) {
                    ghast.equipHarness();
                    ghast.method_5673(class_1304.field_6174, new class_1799((class_1935)this));
                    target.method_37908().method_43275((class_1297)target, (class_6880)class_5712.field_28739, target.method_19538());
                    stack.method_7934(1);
                }
                return class_1269.method_29236((boolean)player.method_37908().field_9236);
            }
        }
        return class_1269.field_5811;
    }
}

