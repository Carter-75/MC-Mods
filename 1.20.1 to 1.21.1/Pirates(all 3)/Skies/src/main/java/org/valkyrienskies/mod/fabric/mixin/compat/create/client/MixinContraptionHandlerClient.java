/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  com.simibubi.create.content.contraptions.ContraptionHandlerClient
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.fabric.mixin.compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.contraptions.ContraptionHandlerClient;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ContraptionHandlerClient.class})
public class MixinContraptionHandlerClient {
    @WrapOperation(method={"rayTraceContraption"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/contraptions/AbstractContraptionEntity;toLocalVector(Lnet/minecraft/world/phys/Vec3;F)Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 wrapRayTraceContraptionToLocalVector(AbstractContraptionEntity instance, class_243 localVec, float partialTicks, Operation<class_243> toLocalVector) {
        ClientShip clientShip = VSGameUtilsKt.getLoadedShipManagingPos(class_310.method_1551().field_1687, instance.getAnchorVec().field_1352, instance.getAnchorVec().field_1351, instance.getAnchorVec().field_1350);
        if (clientShip != null) {
            class_243 newLocalVec = VectorConversionsMCKt.toMinecraft(clientShip.getRenderTransform().getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(localVec)));
            return (class_243)toLocalVector.call(new Object[]{instance, newLocalVec, Float.valueOf(partialTicks)});
        }
        return (class_243)toLocalVector.call(new Object[]{instance, localVec, Float.valueOf(partialTicks)});
    }

    @WrapOperation(method={"rightClickingOnContraptionsGetsHandledLocally"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/contraptions/AbstractContraptionEntity;getBoundingBox()Lnet/minecraft/world/phys/AABB;")})
    private static class_238 wrapRightClickingOnContraptionsGetsHandledLocallyGetBoundingBox(AbstractContraptionEntity instance, Operation<class_238> getBoundingBox) {
        ClientShip clientShip = VSGameUtilsKt.getLoadedShipManagingPos(class_310.method_1551().field_1687, instance.getAnchorVec().field_1352, instance.getAnchorVec().field_1351, instance.getAnchorVec().field_1350);
        if (clientShip != null) {
            class_238 original = (class_238)getBoundingBox.call(new Object[]{instance});
            AABBd modified = VectorConversionsMCKt.toJOML(original).transform(clientShip.getRenderTransform().getShipToWorld());
            return VectorConversionsMCKt.toMinecraft(modified);
        }
        return (class_238)getBoundingBox.call(new Object[]{instance});
    }
}

