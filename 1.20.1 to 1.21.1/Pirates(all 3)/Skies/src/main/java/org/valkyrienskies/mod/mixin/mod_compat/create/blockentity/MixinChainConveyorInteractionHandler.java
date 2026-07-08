/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorInteractionHandler
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorInteractionHandler;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ChainConveyorInteractionHandler.class})
public abstract class MixinChainConveyorInteractionHandler {
    @Shadow
    public static class_2338 selectedLift;

    @WrapOperation(method={"clientTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;subtract(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 wrapRelativePos(class_243 instance, class_243 liftVec, Operation<class_243> original) {
        ClientShip ship = VSClientGameUtils.getClientShip(liftVec.field_1352, liftVec.field_1351, liftVec.field_1350);
        if (ship != null) {
            Vector3d shipInstance = VectorConversionsMCKt.toJOML(instance);
            shipInstance = ship.getTransform().getWorldToShip().transformPosition(shipInstance);
            return (class_243)original.call(new Object[]{VectorConversionsMCKt.toMinecraft(shipInstance), liftVec});
        }
        return (class_243)original.call(new Object[]{instance, liftVec});
    }

    @WrapOperation(method={"clientTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D")})
    private static double wrapDistanceSqr(class_243 instance, class_243 from, Operation<Double> original) {
        return VSGameUtilsKt.squaredDistanceBetweenInclShips((class_1937)class_310.method_1551().field_1687, instance, from, original);
    }

    @WrapOperation(method={"drawCustomBlockSelection"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V")})
    private static void wrapOutlineTranslation(class_4587 instance, double x, double y, double z, Operation<Void> original, class_4587 ms, class_4597 buffer, class_243 camera) {
        ClientShip ship = VSClientGameUtils.getClientShip(selectedLift.method_10263(), selectedLift.method_10264(), selectedLift.method_10260());
        if (ship != null) {
            Vector3d liftShipPos = ship.getRenderTransform().getShipToWorld().transformPosition(selectedLift.method_10263(), selectedLift.method_10264(), selectedLift.method_10260(), new Vector3d());
            original.call(new Object[]{instance, liftShipPos.x - camera.field_1352, liftShipPos.y - camera.field_1351, liftShipPos.z - camera.field_1350});
            instance.method_23760().method_23761().rotate(ship.getRenderTransform().getShipToWorldRotation().get(new Quaternionf()));
        } else {
            original.call(new Object[]{instance, x, y, z});
        }
    }
}

