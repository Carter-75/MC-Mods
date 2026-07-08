/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.trains.track.BezierConnection
 *  com.simibubi.create.content.trains.track.TrackBlockOutline
 *  com.simibubi.create.content.trains.track.TrackBlockOutline$BezierPointSelection
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.trains.track.BezierConnection;
import com.simibubi.create.content.trains.track.TrackBlockOutline;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={TrackBlockOutline.class})
public class MixinTrackBlockOutline {
    @Shadow
    public static TrackBlockOutline.BezierPointSelection result;

    @WrapOperation(method={"pickCurves"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/trains/track/BezierConnection;getBounds()Lnet/minecraft/world/phys/AABB;")})
    private static class_238 getBoundsToWorld(BezierConnection connection, Operation<class_238> original) {
        return VSGameUtilsKt.transformAabbToWorld((class_1937)class_310.method_1551().field_1687, (class_238)original.call(new Object[]{connection}));
    }

    @WrapOperation(method={"pickCurves"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/trains/track/BezierConnection;getPosition(D)Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 getPositionToWorld(BezierConnection connection, double t, Operation<class_243> original) {
        return VSGameUtilsKt.toWorldCoordinates((class_1937)class_310.method_1551().field_1687, (class_243)original.call(new Object[]{connection, t}));
    }

    @WrapOperation(method={"Lcom/simibubi/create/content/trains/track/TrackBlockOutline;drawCustomBlockSelection(Lnet/minecraft/client/renderer/LevelRenderer;Lnet/minecraft/client/Camera;Lnet/minecraft/world/phys/HitResult;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;)Z", "Lcom/simibubi/create/content/trains/track/TrackBlockOutline;drawCustomBlockSelection(Lnet/minecraftforge/client/event/RenderHighlightEvent$Block;)V"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V")})
    private static void wrapSelection(class_4587 instance, double d2, double e2, double f2, Operation<Void> original, @Local class_2338 hitPos, @Local class_243 camPos) {
        ClientShip ship = VSClientGameUtils.getClientShip(hitPos.method_10263(), hitPos.method_10264(), hitPos.method_10260());
        if (ship != null) {
            Vector3d posInWorld = ship.getRenderTransform().getShipToWorld().transformPosition(hitPos.method_10263(), hitPos.method_10264(), hitPos.method_10260(), new Vector3d());
            instance.method_22904(posInWorld.x - camPos.field_1352, posInWorld.y - camPos.field_1351, posInWorld.z - camPos.field_1350);
            instance.method_22907(ship.getRenderTransform().getShipToWorld().getNormalizedRotation(new Quaternionf()));
        } else {
            original.call(new Object[]{instance, d2, e2, f2});
        }
    }
}

