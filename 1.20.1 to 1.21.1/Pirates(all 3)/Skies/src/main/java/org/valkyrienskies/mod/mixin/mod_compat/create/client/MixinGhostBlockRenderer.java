/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.createmod.catnip.ghostblock.GhostBlockParams
 *  net.createmod.catnip.render.SuperRenderTypeBuffer
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.createmod.catnip.ghostblock.GhostBlockParams;
import net.createmod.catnip.render.SuperRenderTypeBuffer;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixin.mod_compat.create.accessors.GhostBlockParamsAccessor;

@Mixin(targets={"net.createmod.catnip.ghostblock.GhostBlockRenderer$DefaultGhostBlockRenderer", "net.createmod.catnip.ghostblock.GhostBlockRenderer$TransparentGhostBlockRenderer"})
public class MixinGhostBlockRenderer {
    @WrapMethod(method={"render"})
    private void wrapRender(class_4587 ms, SuperRenderTypeBuffer buffer, class_243 camera, GhostBlockParams params, Operation<Void> original) {
        class_2338 pos = ((GhostBlockParamsAccessor)params).getPos();
        ClientShip ship = VSClientGameUtils.getClientShip(pos.method_10263(), pos.method_10264(), pos.method_10260());
        if (ship != null) {
            ms.method_22903();
            class_243 cameraInShip = VectorConversionsMCKt.toMinecraft(ship.getRenderTransform().getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(camera)));
            ms.method_22907(VectorConversionsMCKt.toFloat(ship.getRenderTransform().getShipToWorldRotation()));
            ms.method_23760().method_23761().scale(ship.getRenderTransform().getShipToWorldScaling().get(new Vector3f()));
            original.call(new Object[]{ms, buffer, cameraInShip, params});
            ms.method_22909();
        } else {
            original.call(new Object[]{ms, buffer, camera, params});
        }
    }
}

