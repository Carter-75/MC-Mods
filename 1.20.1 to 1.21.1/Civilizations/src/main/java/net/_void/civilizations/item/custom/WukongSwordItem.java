/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1271
 *  net.minecraft.class_1282
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1829
 *  net.minecraft.class_1832
 *  net.minecraft.class_1834
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 */
package net._void.civilizations.item.custom;

import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1282;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_1834;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2680;

public class WukongSwordItem
extends class_1829 {
    public WukongSwordItem(int attackDamage, float attackSpeed, class_1792.class_1793 settings) {
        super((class_1832)class_1834.field_22033, attackDamage, attackSpeed, settings);
    }

    public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        user.method_7357().method_7906((class_1792)this, 1800);
        world.method_8444((class_1657)null, 1502, user.method_24515(), 0);
        for (double i = -7.0; i <= 7.0; i += 1.0) {
            for (double j = -7.0; j <= 7.0; j += 1.0) {
                if (!(Math.pow(i, 2.0) + Math.pow(j, 2.0) >= Math.pow(4.0, 2.0)) || !(Math.pow(i, 2.0) + Math.pow(j, 2.0) <= Math.pow(6.0, 2.0))) continue;
                int y = (int)user.method_23318();
                boolean done = false;
                int limit = 0;
                while (!done && limit <= 7) {
                    if (world.method_8320(new class_2338((int)user.method_23317() + (int)i, y - 1, (int)user.method_23321() + (int)j)) != class_2246.field_10124.method_9564() && world.method_8320(new class_2338((int)user.method_23317() + (int)i, y, (int)user.method_23321() + (int)j)).equals(class_2246.field_10124.method_9564())) {
                        world.method_8501(new class_2338((int)user.method_23317() + (int)i, y, (int)user.method_23321() + (int)j), class_2246.field_10036.method_9564());
                        done = true;
                        continue;
                    }
                    if (world.method_8320(new class_2338((int)user.method_23317() + (int)i, y, (int)user.method_23321() + (int)j)) != class_2246.field_10124.method_9564()) {
                        ++y;
                        ++limit;
                        continue;
                    }
                    if (!world.method_8320(new class_2338((int)user.method_23317() + (int)i, y, (int)user.method_23321() + (int)j)).equals(class_2246.field_10124.method_9564())) continue;
                    --y;
                    ++limit;
                }
            }
        }
        return super.method_7836(world, user, hand);
    }

    public void method_7888(class_1799 stack, class_1937 world, class_1297 entity, int slot, boolean selected) {
        class_1657 player;
        if (entity instanceof class_1657 && (player = (class_1657)entity).method_6047().method_7909().equals(this.method_7854().method_7909()) && player.method_5809()) {
            player.method_6092(new class_1293(class_1294.field_5910, 100, 1));
        }
        super.method_7888(stack, world, entity, slot, selected);
    }

    public boolean method_24357(class_1282 source) {
        return false;
    }

    public boolean method_7856(class_2680 state) {
        return false;
    }
}

