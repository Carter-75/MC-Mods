/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.equipment.clipboard.ClipboardScreen
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client.gui.menu;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.equipment.clipboard.ClipboardScreen;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ClipboardScreen.class})
public class MixinClipboardScreen {
    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerThan(Lnet/minecraft/core/Vec3i;D)Z")})
    private static boolean injectCloserThan(class_2338 instance, class_2382 vec3i, double v, Operation<Boolean> original) {
        class_638 level = class_310.method_1551().field_1687;
        Ship ship = VSGameUtilsKt.getShipManagingPos((class_1937)level, new class_2338(vec3i));
        if (ship != null) {
            Vector3d playerPosVec = VectorConversionsMCKt.toJOML(instance.method_46558());
            ship.getTransform().getWorldToShip().transformPosition(playerPosVec);
            return playerPosVec.distanceSquared(new Vector3d(VectorConversionsMCKt.toJOML(vec3i))) < class_3532.method_33723((double)v);
        }
        return (Boolean)original.call(new Object[]{instance, vec3i, v});
    }
}

