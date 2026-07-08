/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.foundation.blockEntity.SmartBlockEntity
 *  com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer
 *  net.minecraft.class_2382
 *  net.minecraft.class_4587
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import net.minecraft.class_2382;
import net.minecraft.class_4587;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={SmartBlockEntityRenderer.class})
public class MixinSmartBlockEntityRenderer {
    @WrapOperation(method={"renderNameplateOnHover"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V")})
    private <T extends SmartBlockEntity> void revertShipRotation(class_4587 matrices, double d2, double e2, double f2, Operation<Void> original, @Local(argsOnly=true) T entity) {
        original.call(new Object[]{matrices, d2, e2, f2});
        ClientShip ship = (ClientShip)VSGameUtilsKt.getLoadedShipManagingPos(entity.method_10997(), (class_2382)entity.method_11016());
        if (ship != null) {
            matrices.method_22907(new Quaternionf(ship.getRenderTransform().getShipToWorldRotation()).invert());
        }
    }
}

