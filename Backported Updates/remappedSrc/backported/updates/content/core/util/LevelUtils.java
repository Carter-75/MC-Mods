/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 */
package backported.updates.content.core.util;

import net.minecraft.class_1937;

public class LevelUtils {
    public static boolean isMoonVisible(class_1937 level) {
        if (!level.method_8597().comp_645()) {
            return false;
        }
        int ticks = (int)(level.method_8532() % 24000L);
        return ticks >= 12600 && ticks <= 23400;
    }
}

