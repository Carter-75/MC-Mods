/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity$ConnectionStats
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorRidingHandler
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorRidingHandler;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ChainConveyorRidingHandler.class})
public abstract class MixinChainConveyorRidingHandler {
    @Shadow
    public static class_2338 ridingChainConveyor;
    @Unique
    private static ClientShip vs$ridingShip;

    @Inject(method={"embark"}, at={@At(value="HEAD")})
    private static void preEmbark(class_2338 lift, float position, class_2338 connection, CallbackInfo ci) {
        vs$ridingShip = VSClientGameUtils.getClientShip(lift.method_10263(), lift.method_10264(), lift.method_10260());
        class_746 player = class_310.method_1551().field_1724;
        if (player != null && vs$ridingShip != null) {
            ((IEntityDraggingInformationProvider)player).getDraggingInformation().setLastShipStoodOn(vs$ridingShip.getId());
        }
    }

    @Inject(method={"stopRiding"}, at={@At(value="HEAD")}, remap=false)
    private static void preStopRiding(CallbackInfo ci) {
        vs$ridingShip = null;
    }

    @Inject(method={"clientTick"}, at={@At(value="HEAD")}, remap=false)
    private static void preTick(CallbackInfo ci) {
        class_746 player;
        if (ridingChainConveyor == null) {
            vs$ridingShip = null;
        } else if (vs$ridingShip != null && (player = class_310.method_1551().field_1724) != null) {
            ((IEntityDraggingInformationProvider)player).getDraggingInformation().setLastShipStoodOn(vs$ridingShip.getId());
        }
    }

    @WrapOperation(method={"clientTick"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/chainConveyor/ChainConveyorBlockEntity$ConnectionStats;start()Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 wrapStart(ChainConveyorBlockEntity.ConnectionStats instance, Operation<class_243> original) {
        class_243 origPos = (class_243)original.call(new Object[]{instance});
        if (vs$ridingShip != null) {
            Vector3d newPos = vs$ridingShip.getRenderTransform().getShipToWorld().transformPosition(origPos.field_1352, origPos.field_1351, origPos.field_1350, new Vector3d());
            return VectorConversionsMCKt.toMinecraft(newPos);
        }
        return origPos;
    }

    @WrapOperation(method={"clientTick"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/chainConveyor/ChainConveyorBlockEntity$ConnectionStats;end()Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 wrapEnd(ChainConveyorBlockEntity.ConnectionStats instance, Operation<class_243> original) {
        class_243 origPos = (class_243)original.call(new Object[]{instance});
        if (vs$ridingShip != null) {
            Vector3d newPos = vs$ridingShip.getRenderTransform().getShipToWorld().transformPosition(origPos.field_1352, origPos.field_1351, origPos.field_1350, new Vector3d());
            return VectorConversionsMCKt.toMinecraft(newPos);
        }
        return origPos;
    }

    @WrapOperation(method={"clientTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;atBottomCenterOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;", remap=true)})
    private static class_243 wrapBottomCenterOfConveyor(class_2382 vec3i, Operation<class_243> original) {
        class_243 origPos = (class_243)original.call(new Object[]{vec3i});
        if (vs$ridingShip != null) {
            Vector3d newPos = vs$ridingShip.getRenderTransform().getShipToWorld().transformPosition(origPos.field_1352, origPos.field_1351, origPos.field_1350, new Vector3d());
            return VectorConversionsMCKt.toMinecraft(newPos);
        }
        return origPos;
    }

    @WrapOperation(method={"clientTick"}, at={@At(value="INVOKE", target="Lnet/createmod/catnip/math/VecHelper;rotate(Lnet/minecraft/world/phys/Vec3;DLnet/minecraft/core/Direction$Axis;)Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 wrapConveyorAngle(class_243 vec, double deg, class_2350.class_2351 axis, Operation<class_243> original) {
        class_243 result2 = (class_243)original.call(new Object[]{vec, deg, axis});
        if (vs$ridingShip != null) {
            Vector3d resultD = VectorConversionsMCKt.toJOML(result2);
            vs$ridingShip.getRenderTransform().getShipToWorld().transformDirection(resultD);
            return VectorConversionsMCKt.toMinecraft(resultD);
        }
        return result2;
    }

    @WrapOperation(method={"updateTargetPosition"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getLookAngle()Lnet/minecraft/world/phys/Vec3;", remap=true)})
    private static class_243 wrapLookVectorToShip(class_746 player, Operation<class_243> original) {
        if (vs$ridingShip != null) {
            Vector3d lookVectorWorld = VectorConversionsMCKt.toJOML((class_243)original.call(new Object[]{player}));
            vs$ridingShip.getRenderTransform().getWorldToShip().transformDirection(lookVectorWorld);
            return VectorConversionsMCKt.toMinecraft(lookVectorWorld);
        }
        return (class_243)original.call(new Object[]{player});
    }
}

