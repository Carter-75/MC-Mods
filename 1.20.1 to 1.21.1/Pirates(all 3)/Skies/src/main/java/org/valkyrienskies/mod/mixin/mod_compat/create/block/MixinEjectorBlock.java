/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.logistics.depot.EjectorBlock
 *  net.minecraft.class_1297
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.simibubi.create.content.logistics.depot.EjectorBlock;
import net.minecraft.class_1297;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={EjectorBlock.class})
public abstract class MixinEjectorBlock {
    @Redirect(method={"updateEntityAfterFallOn"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;blockPosition()Lnet/minecraft/core/BlockPos;"))
    private class_2338 redirectBlockPosition(class_1297 instance) {
        return instance.method_23312();
    }

    @Redirect(method={"updateEntityAfterFallOn"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;position()Lnet/minecraft/world/phys/Vec3;"))
    private class_243 redirectEntityPosition(class_1297 instance) {
        Ship ship;
        class_243 result2 = instance.method_19538();
        if (VSGameUtilsKt.getShipManagingPos(instance.method_37908(), (class_2374)instance.method_19538()) == null && (ship = VSGameUtilsKt.getShipManagingPos(instance.method_37908(), instance.method_23312())) != null) {
            Vector3d tempVec = VectorConversionsMCKt.toJOML(result2);
            ship.getWorldToShip().transformPosition(tempVec, tempVec);
            result2 = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return result2;
    }

    @Redirect(method={"updateEntityAfterFallOn"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setPos(DDD)V"))
    private void redirectSetPos(class_1297 instance, double x, double y, double z) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(instance.method_37908(), instance.method_23312());
        if (ship != null) {
            Vector3d tempVec = new Vector3d();
            ship.getTransform().getShipToWorld().transformPosition(x, y, z, tempVec);
            instance.method_5814(tempVec.x, tempVec.y, tempVec.z);
        } else {
            instance.method_5814(x, y, z);
        }
    }
}

