/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1297
 *  net.minecraft.class_2382
 *  net.minecraft.class_4587
 *  net.minecraft.class_897
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.shipyard_entities;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1297;
import net.minecraft.class_2382;
import net.minecraft.class_4587;
import net.minecraft.class_897;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_897.class})
public class MixinEntityRenderer {
    @WrapOperation(method={"Lnet/minecraft/client/renderer/entity/EntityRenderer;renderNameTag(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/network/chat/Component;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V")})
    void revertShipRotation(class_4587 matrices, float f2, float g2, float h2, Operation<Void> original, @Local(argsOnly=true) class_1297 entity) {
        original.call(new Object[]{matrices, Float.valueOf(f2), Float.valueOf(g2), Float.valueOf(h2)});
        ClientShip ship = (ClientShip)VSGameUtilsKt.getLoadedShipManagingPos(entity.method_37908(), (class_2382)entity.method_24515());
        if (ship != null) {
            matrices.method_22907(new Quaternionf(ship.getRenderTransform().getShipToWorldRotation()).invert());
        }
    }
}

