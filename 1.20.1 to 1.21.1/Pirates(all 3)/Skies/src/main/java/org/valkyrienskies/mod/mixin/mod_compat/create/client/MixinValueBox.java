/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.foundation.blockEntity.behaviour.ValueBox
 *  net.minecraft.class_2338
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
import com.simibubi.create.foundation.blockEntity.behaviour.ValueBox;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;

@Mixin(value={ValueBox.class})
public class MixinValueBox {
    @Shadow
    protected class_2338 pos;

    @WrapOperation(method={"render"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V", ordinal=0)})
    public void wrapOpTranslate(class_4587 instance, double x, double y, double z, Operation<Void> operation) {
        ClientShip ship = VSClientGameUtils.getClientShip(x, y, z);
        if (ship != null) {
            class_243 camera = class_310.method_1551().field_1773.method_19418().method_19326();
            VSClientGameUtils.transformRenderWithShip(ship.getRenderTransform(), instance, (double)this.pos.method_10263(), (double)this.pos.method_10264(), (double)this.pos.method_10260(), camera.field_1352, camera.field_1351, camera.field_1350);
        } else {
            operation.call(new Object[]{instance, x, y, z});
        }
    }
}

