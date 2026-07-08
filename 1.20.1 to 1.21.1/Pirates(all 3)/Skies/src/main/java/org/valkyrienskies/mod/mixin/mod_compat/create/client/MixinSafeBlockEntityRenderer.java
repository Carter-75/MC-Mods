/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.simibubi.create.foundation.blockEntity.renderer.SafeBlockEntityRenderer
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.simibubi.create.foundation.blockEntity.renderer.SafeBlockEntityRenderer;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={SafeBlockEntityRenderer.class}, remap=false)
public abstract class MixinSafeBlockEntityRenderer {
    @WrapMethod(method={"shouldCullItem"})
    private boolean cullIfOnShip(class_243 itemPos, class_1937 level, Operation<Boolean> original) {
        ClientShip ship = VSClientGameUtils.getClientShip(itemPos.field_1352, itemPos.field_1351, itemPos.field_1350);
        if (ship != null) {
            Vector3d shipItemPosD = ship.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(itemPos));
            return (Boolean)original.call(new Object[]{VectorConversionsMCKt.toMinecraft(shipItemPosD), level});
        }
        return (Boolean)original.call(new Object[]{itemPos, level});
    }
}

