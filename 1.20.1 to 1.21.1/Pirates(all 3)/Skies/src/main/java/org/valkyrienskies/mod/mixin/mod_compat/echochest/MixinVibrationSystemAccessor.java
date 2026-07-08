/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_8514$class_8516
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package org.valkyrienskies.mod.mixin.mod_compat.echochest;

import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_8514;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_8514.class_8516.class})
public interface MixinVibrationSystemAccessor {
    @Invoker(value="isOccluded")
    public static boolean isOccluded(class_1937 level, class_243 pos1, class_243 pos2) {
        return false;
    }
}

