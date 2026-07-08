/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.createmod.catnip.math.VecHelper
 *  net.createmod.catnip.placement.PlacementClient
 *  net.minecraft.class_1937
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import net.createmod.catnip.math.VecHelper;
import net.createmod.catnip.placement.PlacementClient;
import net.minecraft.class_1937;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_638;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={PlacementClient.class})
public class MixinPlacementHelpers {
    @Redirect(method={"drawDirectionIndicator"}, at=@At(value="INVOKE", target="Lnet/createmod/catnip/math/VecHelper;getCenterOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectGetCenterOf(class_2382 pos) {
        Ship ship;
        class_243 result2 = VecHelper.getCenterOf((class_2382)pos);
        class_638 world = class_310.method_1551().field_1687;
        if (world != null && VSGameUtilsKt.isBlockInShipyard((class_1937)world, pos.method_10263(), pos.method_10264(), pos.method_10260()) && (ship = VSGameUtilsKt.getShipManagingPos((class_1937)world, pos.method_10263(), pos.method_10264(), pos.method_10260())) instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            Vector3d tempVec = new Vector3d((double)pos.method_10263() + 0.5, (double)pos.method_10264() + 0.5, (double)pos.method_10260() + 0.5);
            ship2.getShipToWorld().transformPosition(tempVec, tempVec);
            result2 = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return result2;
    }
}

