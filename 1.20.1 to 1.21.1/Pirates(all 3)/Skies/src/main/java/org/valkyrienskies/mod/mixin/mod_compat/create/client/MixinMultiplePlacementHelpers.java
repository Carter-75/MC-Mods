/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.createmod.catnip.placement.PlacementOffset
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_3965
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import net.createmod.catnip.placement.PlacementOffset;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3965;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(targets={"com.simibubi.create.content.contraptions.bearing.SailBlock$PlacementHelper", "com.simibubi.create.foundation.placement.PoleHelper", "com.simibubi.create.content.decoration.girder.GirderPlacementHelper", "com.simibubi.create.content.trains.display.FlapDisplayBlock$PlacementHelper"})
public class MixinMultiplePlacementHelpers {
    @Unique
    private class_1937 world;

    @Inject(method={"getOffset"}, at={@At(value="HEAD")})
    private void harvestWorld(class_1657 player, class_1937 world, class_2680 state, class_2338 pos, class_3965 ray, CallbackInfoReturnable<PlacementOffset> cir) {
        this.world = world;
    }

    @Redirect(method={"getOffset"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/BlockHitResult;getLocation()Lnet/minecraft/world/phys/Vec3;"))
    private class_243 redirectGetLocation(class_3965 instance) {
        class_243 result2 = instance.method_17784();
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.world, instance.method_17777());
        if (ship != null && !VSGameUtilsKt.isBlockInShipyard(this.world, result2.field_1352, result2.field_1351, result2.field_1350)) {
            Vector3d tempVec = VectorConversionsMCKt.toJOML(result2);
            ship.getWorldToShip().transformPosition(tempVec, tempVec);
            result2 = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return result2;
    }
}

