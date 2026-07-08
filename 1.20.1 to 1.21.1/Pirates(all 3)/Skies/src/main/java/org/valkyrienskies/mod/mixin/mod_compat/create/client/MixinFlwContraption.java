/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.render.ContraptionMatrices
 *  net.minecraft.class_1297
 *  net.minecraft.class_3532
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.simibubi.create.content.contraptions.render.ContraptionMatrices;
import net.minecraft.class_1297;
import net.minecraft.class_3532;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={ContraptionMatrices.class})
public abstract class MixinFlwContraption {
    @Inject(at={@At(value="HEAD")}, method={"translateToEntity"}, cancellable=true, remap=false)
    private static void beforeSetupModelViewPartial(Matrix4f matrix, class_1297 entity, float pt, CallbackInfo ci) {
        Ship ship = VSGameUtilsKt.getShipManaging(entity);
        if (ship instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            VSClientGameUtils.transformRenderWithShip(ship2.getRenderTransform(), matrix, class_3532.method_16436((double)pt, (double)entity.field_6038, (double)entity.method_23317()), class_3532.method_16436((double)pt, (double)entity.field_5971, (double)entity.method_23318()), class_3532.method_16436((double)pt, (double)entity.field_5989, (double)entity.method_23321()), (double)matrix.get(3, 0), (double)matrix.get(3, 1), (double)matrix.get(3, 2));
            ci.cancel();
        }
    }
}

