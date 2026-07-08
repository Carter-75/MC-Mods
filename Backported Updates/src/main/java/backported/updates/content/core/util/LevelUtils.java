/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 */
package backported.updates.content.core.util;

import net.minecraft.world.World;

public class LevelUtils {
    public static boolean isMoonVisible(World level) {
        if (!level.getDimension().natural()) {
            return false;
        }
        int ticks = (int)(level.getTimeOfDay() % 24000L);
        return ticks >= 12600 && ticks <= 23400;
    }
}

