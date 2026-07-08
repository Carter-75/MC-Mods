/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.logistics.factoryBoard.FactoryPanelConnectionHandler
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelConnectionHandler;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_310;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={FactoryPanelConnectionHandler.class})
public class MixinFactoryPanelConnectionHandler {
    @WrapOperation(method={"clientTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerThan(Lnet/minecraft/core/Vec3i;D)Z")})
    private static boolean valkyrien_logistics$stupidDistanceCheck(class_2338 instance, class_2382 vec3i, double v, Operation<Boolean> original, @Local class_310 mc) {
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos(mc.field_1687, (class_2382)instance);
        Vector3d jomlInstance = VectorConversionsMCKt.toJOML(instance.method_46558());
        if (ship != null) {
            ship.getTransform().getShipToWorld().transformPosition(jomlInstance);
        }
        ship = VSGameUtilsKt.getLoadedShipManagingPos(mc.field_1687, vec3i);
        Vector3d jomlVec3i = VectorConversionsMCKt.toJOMLD(vec3i);
        if (ship != null) {
            ship.getTransform().getShipToWorld().transformPosition(jomlVec3i);
        }
        return (Boolean)original.call(new Object[]{class_2338.method_49638((class_2374)VectorConversionsMCKt.toMinecraft(jomlInstance)), class_2338.method_49637((double)jomlVec3i.x, (double)jomlVec3i.y, (double)jomlVec3i.z), v});
    }
}

