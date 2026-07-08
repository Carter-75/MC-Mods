/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_5712
 *  net.minecraft.class_5712$class_7397
 *  net.minecraft.class_8514$class_8515
 *  net.minecraft.class_8514$class_8516
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.feature.sculk;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_5712;
import net.minecraft.class_8514;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_8514.class_8516.class})
public abstract class MixinVibrationSystem {
    @WrapMethod(method={"scheduleVibration"})
    private void scheduleVibration(class_3218 level, class_8514.class_8515 data, class_5712 gameEvent, class_5712.class_7397 context, class_243 pos, class_243 sensorPos, Operation<Void> original) {
        original.call(new Object[]{level, data, gameEvent, context, VectorConversionsMCKt.toMinecraft(VSGameUtilsKt.getWorldCoordinates((class_1937)level, class_2338.method_49638((class_2374)pos), VectorConversionsMCKt.toJOML(pos))), VectorConversionsMCKt.toMinecraft(VSGameUtilsKt.getWorldCoordinates((class_1937)level, class_2338.method_49638((class_2374)sensorPos), VectorConversionsMCKt.toJOML(sensorPos)))});
    }

    @WrapMethod(method={"isOccluded"})
    private static boolean adjustOcclusionForWorldPosition(class_1937 level, class_243 pos1, class_243 pos2, Operation<Boolean> original) {
        Ship ship2;
        Ship ship1 = VSGameUtilsKt.getShipManagingPos(level, (class_2374)pos1);
        if (ship1 == (ship2 = VSGameUtilsKt.getShipManagingPos(level, (class_2374)pos2))) {
            return (Boolean)original.call(new Object[]{level, pos1, pos2});
        }
        class_243 pos1InWorld = VectorConversionsMCKt.toMinecraft(VSGameUtilsKt.getWorldCoordinates(level, class_2338.method_49638((class_2374)pos1), VectorConversionsMCKt.toJOML(pos1)));
        class_243 pos2InWorld = VectorConversionsMCKt.toMinecraft(VSGameUtilsKt.getWorldCoordinates(level, class_2338.method_49638((class_2374)pos2), VectorConversionsMCKt.toJOML(pos2)));
        if (((Boolean)original.call(new Object[]{level, pos1InWorld, pos2InWorld})).booleanValue()) {
            return true;
        }
        boolean result2 = false;
        if (ship2 != null) {
            class_243 pos1InShip2 = VectorConversionsMCKt.toMinecraft(ship2.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(pos1InWorld)));
            result2 |= ((Boolean)original.call(new Object[]{level, pos1InShip2, pos2})).booleanValue();
        }
        if (ship1 != null) {
            class_243 pos2InShip1 = VectorConversionsMCKt.toMinecraft(ship1.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(pos2InWorld)));
            result2 |= ((Boolean)original.call(new Object[]{level, pos1, pos2InShip1})).booleanValue();
        }
        return result2;
    }
}

