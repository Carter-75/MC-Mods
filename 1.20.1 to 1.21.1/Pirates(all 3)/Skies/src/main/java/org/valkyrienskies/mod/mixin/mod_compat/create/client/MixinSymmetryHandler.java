/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.equipment.symmetryWand.SymmetryHandler
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.equipment.symmetryWand.SymmetryHandler;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;

@Mixin(value={SymmetryHandler.class})
public class MixinSymmetryHandler {
    @WrapOperation(method={"render", "onRenderWorld"}, at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V", ordinal=0)})
    private static void translateToWorldIfShip(class_4587 ms, double d2, double e2, double f2, Operation<Void> original, @Local(name={"pos"}) class_2338 pos, @Local(name={"view"}) class_243 view) {
        ClientShip ship = VSClientGameUtils.getClientShip(pos.method_10263(), pos.method_10264(), pos.method_10260());
        if (ship != null) {
            Vector3d posInWorld = ship.getRenderTransform().getShipToWorld().transformPosition(pos.method_10263(), pos.method_10264(), pos.method_10260(), new Vector3d());
            ms.method_22904(posInWorld.x - view.field_1352, posInWorld.y - view.field_1351, posInWorld.z - view.field_1350);
            ms.method_22907(ship.getRenderTransform().getShipToWorldRotation().get(new Quaternionf()));
        } else {
            original.call(new Object[]{ms, d2, e2, f2});
        }
    }
}

