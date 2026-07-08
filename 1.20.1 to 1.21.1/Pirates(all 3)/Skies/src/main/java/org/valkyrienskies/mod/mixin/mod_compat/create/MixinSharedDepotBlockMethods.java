/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.logistics.depot.SharedDepotBlockMethods
 *  net.minecraft.class_1297
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.simibubi.create.content.logistics.depot.SharedDepotBlockMethods;
import net.minecraft.class_1297;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={SharedDepotBlockMethods.class})
public abstract class MixinSharedDepotBlockMethods {
    @Redirect(method={"onLanded"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;blockPosition()Lnet/minecraft/core/BlockPos;"))
    private static class_2338 redirectBlockPosition(class_1297 instance) {
        class_2338 result2 = instance.method_24515();
        LoadedShip ship = VSGameUtilsKt.getLoadedShipManagingPos(instance.method_37908(), (class_2382)instance.method_23312());
        if (ship != null) {
            Vector3d tempVec = new Vector3d(instance.method_19538().field_1352, instance.method_19538().field_1351, instance.method_19538().field_1350);
            ship.getWorldToShip().transformPosition(tempVec, tempVec);
            result2 = class_2338.method_49637((double)Math.floor(tempVec.x), (double)Math.floor(tempVec.y), (double)Math.floor(tempVec.z));
        }
        return result2;
    }
}

