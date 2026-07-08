/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1271
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3468
 */
package tech.alexnijjar.golemoverhaul.common.items;

import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3468;
import tech.alexnijjar.golemoverhaul.common.entities.projectiles.HoneyBlobProjectile;

public class HoneyBlobItem
extends class_1792 {
    public HoneyBlobItem(class_1792.class_1793 properties) {
        super(properties);
    }

    public class_1271<class_1799> method_7836(class_1937 level, class_1657 player, class_1268 usedHand) {
        class_1799 stack = player.method_5998(usedHand);
        level.method_43128(null, player.method_23317(), player.method_23318(), player.method_23321(), class_3417.field_14863, class_3419.field_15254, 0.5f, 0.4f / (level.method_8409().method_43057() * 0.4f + 0.8f));
        if (!level.field_9236) {
            HoneyBlobProjectile projectile = new HoneyBlobProjectile(level, (class_1309)player);
            class_243 lookAngle = player.method_5720();
            projectile.method_5814(player.method_23317() + lookAngle.field_1352, player.method_23320() + lookAngle.field_1351, player.method_23321() + lookAngle.field_1350);
            projectile.method_7438(10.0);
            projectile.method_24919((class_1297)player, player.method_36455(), player.method_36454(), 0.0f, 1.25f, 2.0f);
            level.method_8649((class_1297)projectile);
        }
        player.method_7259(class_3468.field_15372.method_14956((Object)this));
        if (!player.method_31549().field_7477) {
            stack.method_7934(1);
        }
        return class_1271.method_29237((Object)stack, (boolean)level.method_8608());
    }
}

