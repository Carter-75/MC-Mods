/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2465
 *  net.minecraft.class_2498
 *  net.minecraft.class_2586
 *  net.minecraft.class_2766
 *  net.minecraft.class_2769
 *  net.minecraft.class_3620
 *  net.minecraft.class_4970$class_2251
 */
package backported.updates.garden;

import backported.updates.garden.entity.CreakingHeartBlockEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2465;
import net.minecraft.class_2498;
import net.minecraft.class_2586;
import net.minecraft.class_2766;
import net.minecraft.class_2769;
import net.minecraft.class_3620;
import net.minecraft.class_4970;

public class Util {
    public static class_2248 createLogBlock(class_3620 topMapColor, class_3620 sideMapColor) {
        return new class_2465(class_4970.class_2251.method_9637().method_51520(state -> state.method_11654((class_2769)class_2465.field_11459) == class_2350.class_2351.field_11052 ? topMapColor : sideMapColor).method_51368(class_2766.field_12651).method_9632(2.0f).method_9626(class_2498.field_11547).method_50013());
    }

    public static boolean isHeartNear(class_1297 entity, class_1937 world, int radius) {
        class_2338 entityBlockPos = entity.method_24515();
        for (int x = -radius; x <= radius; ++x) {
            for (int y = world.method_31607(); y <= world.method_31600(); ++y) {
                for (int z = -radius; z <= radius; ++z) {
                    class_2338 currentPos = entityBlockPos.method_10069(x, y, z);
                    class_2586 blockEntity = world.method_8321(currentPos);
                    if (!(blockEntity instanceof CreakingHeartBlockEntity)) continue;
                    return true;
                }
            }
        }
        return false;
    }
}

