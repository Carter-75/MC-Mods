/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3959
 *  net.minecraft.class_3965
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.feature.clip_replace;

import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.world.RaycastUtilsKt;

@Mixin(value={class_1937.class})
public abstract class MixinLevel
implements class_1922 {
    public class_3965 method_17742(class_3959 clipContext) {
        if (VSGameUtilsKt.getShipManagingPos((class_1937)class_1937.class.cast(this), (class_2374)clipContext.method_17747()) != VSGameUtilsKt.getShipManagingPos((class_1937)class_1937.class.cast(this), (class_2374)clipContext.method_17750())) {
            LogManager.getLogger().warn("Trying to clip from " + String.valueOf(clipContext.method_17750()) + " to " + String.valueOf(clipContext.method_17747()) + " wich one of them is in a shipyard wich is ... sus!!");
            class_243 vec3 = clipContext.method_17750().method_1020(clipContext.method_17747());
            return class_3965.method_17778((class_243)clipContext.method_17747(), (class_2350)class_2350.method_10142((double)vec3.field_1352, (double)vec3.field_1351, (double)vec3.field_1350), (class_2338)class_2338.method_49638((class_2374)clipContext.method_17747()));
        }
        return RaycastUtilsKt.clipIncludeShips((class_1937)class_1937.class.cast(this), clipContext);
    }
}

