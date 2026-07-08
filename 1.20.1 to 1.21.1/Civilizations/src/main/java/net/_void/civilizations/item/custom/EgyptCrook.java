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
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1674
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1829
 *  net.minecraft.class_1832
 *  net.minecraft.class_1834
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 */
package net._void.civilizations.item.custom;

import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1282;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1674;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_1834;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_2680;

public class EgyptCrook
extends class_1829 {
    public int shots = 0;

    public EgyptCrook(int attackDamage, float attackSpeed, class_1792.class_1793 settings) {
        super((class_1832)class_1834.field_22033, attackDamage, attackSpeed, settings);
    }

    public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        if (!world.method_8608()) {
            ++this.shots;
            class_243 vec3d = user.method_5828(1.0f);
            double f = vec3d.field_1352 * 4.0;
            double g = vec3d.field_1351 * 4.0;
            double h = vec3d.field_1350 * 4.0;
            world.method_8444((class_1657)null, 1017, user.method_24515(), 0);
            class_1674 fireballEntity = new class_1674(world, (class_1309)user, f * 4.0, g * 4.0, h * 4.0, 3);
            fireballEntity.method_5814(user.method_23317() + vec3d.field_1352 * 3.0, user.method_23323(0.5), user.method_23321() + vec3d.field_1350 * 3.0);
            world.method_8649((class_1297)fireballEntity);
            if (this.shots == 6) {
                this.shots = 0;
                user.method_7357().method_7906((class_1792)this, 100);
            } else {
                user.method_7357().method_7906((class_1792)this, 10);
            }
        }
        return super.method_7836(world, user, hand);
    }

    public boolean method_7873(class_1799 stack, class_1309 target, class_1309 attacker) {
        target.method_6092(new class_1293(class_1294.field_5920, 100));
        return super.method_7873(stack, target, attacker);
    }

    public boolean method_24357(class_1282 source) {
        return false;
    }

    public boolean method_7856(class_2680 state) {
        return false;
    }
}

