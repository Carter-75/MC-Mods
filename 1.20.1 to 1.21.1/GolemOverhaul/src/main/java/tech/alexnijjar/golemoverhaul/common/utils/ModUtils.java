/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_174
 *  net.minecraft.class_1937
 *  net.minecraft.class_2276
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2700$class_2702
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 */
package tech.alexnijjar.golemoverhaul.common.utils;

import net.minecraft.class_1297;
import net.minecraft.class_174;
import net.minecraft.class_1937;
import net.minecraft.class_2276;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2700;
import net.minecraft.class_3218;
import net.minecraft.class_3222;

public class ModUtils {
    public static <T extends class_2394> void sendParticles(class_3218 level, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        for (class_3222 player : level.method_18456()) {
            level.method_14166(player, particle, true, x, y, z, count, deltaX, deltaY, deltaZ, speed);
        }
    }

    public static void spawnGolemInWorld(class_1937 level, class_2700.class_2702 pattern, class_1297 golem, class_2338 pos) {
        class_2276.method_45454((class_1937)level, (class_2700.class_2702)pattern);
        golem.method_5808((double)pos.method_10263() + 0.5, (double)pos.method_10264() + 0.05, (double)pos.method_10260() + 0.5, 0.0f, 0.0f);
        level.method_8649(golem);
        for (class_3222 serverPlayer : level.method_18467(class_3222.class, golem.method_5829().method_1014(5.0))) {
            class_174.field_1182.method_9124(serverPlayer, golem);
        }
        class_2276.method_45456((class_1937)level, (class_2700.class_2702)pattern);
    }
}

