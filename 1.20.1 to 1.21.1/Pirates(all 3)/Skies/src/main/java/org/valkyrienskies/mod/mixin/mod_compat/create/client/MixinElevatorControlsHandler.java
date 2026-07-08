/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  com.simibubi.create.content.contraptions.elevator.ElevatorControlsHandler
 *  net.minecraft.class_238
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.contraptions.elevator.ElevatorControlsHandler;
import net.minecraft.class_238;
import net.minecraft.class_310;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ElevatorControlsHandler.class})
public class MixinElevatorControlsHandler {
    @WrapOperation(method={"onScroll"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/contraptions/AbstractContraptionEntity;getBoundingBox()Lnet/minecraft/world/phys/AABB;")})
    private static class_238 onScrollGetBoundingBox(AbstractContraptionEntity instance, Operation<class_238> getBoundingBox) {
        ClientShip clientShip = VSGameUtilsKt.getLoadedShipManagingPos(class_310.method_1551().field_1687, instance.getAnchorVec().field_1352, instance.getAnchorVec().field_1351, instance.getAnchorVec().field_1350);
        if (clientShip != null) {
            class_238 original = (class_238)getBoundingBox.call(new Object[]{instance});
            AABBd modified = VectorConversionsMCKt.toJOML(original).transform(clientShip.getRenderTransform().getShipToWorld());
            return VectorConversionsMCKt.toMinecraft(modified);
        }
        return (class_238)getBoundingBox.call(new Object[]{instance});
    }
}

