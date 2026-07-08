/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.trains.track.TrackTargetingClient
 *  dev.engine_room.flywheel.lib.transform.PoseTransformStack
 *  dev.engine_room.flywheel.lib.transform.Translate
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.trains.track.TrackTargetingClient;
import dev.engine_room.flywheel.lib.transform.PoseTransformStack;
import dev.engine_room.flywheel.lib.transform.Translate;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={TrackTargetingClient.class})
public class MixinTrackTargetingClient {
    @Shadow
    static class_2338 lastHovered;

    @WrapOperation(method={"render"}, at={@At(value="INVOKE", target="Ldev/engine_room/flywheel/lib/transform/PoseTransformStack;translate(Lnet/minecraft/world/phys/Vec3;)Ldev/engine_room/flywheel/lib/transform/Translate;")})
    private static Translate redirectWithShip(PoseTransformStack instance, class_243 vec3, Operation<Translate> original, @Local(argsOnly=true) class_243 camera) {
        ClientShip ship = VSClientGameUtils.getClientShip(lastHovered.method_10263(), lastHovered.method_10264(), lastHovered.method_10260());
        if (ship != null) {
            Vector3d inWorldJOML = ship.getRenderTransform().getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(class_243.method_24954((class_2382)lastHovered)));
            return ((PoseTransformStack)((PoseTransformStack)instance.translate(inWorldJOML.x, inWorldJOML.y, inWorldJOML.z)).translate(-camera.field_1352, -camera.field_1351, -camera.field_1350)).rotate((Quaternionfc)ship.getRenderTransform().getShipToWorldRotation().get(new Quaternionf()));
        }
        return (Translate)original.call(new Object[]{instance, vec3});
    }
}

