/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.logistics.box.PackageItem
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1838
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.item;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.logistics.box.PackageItem;
import net.minecraft.class_1792;
import net.minecraft.class_1838;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={PackageItem.class})
public abstract class MixinPackageItem
extends class_1792 {
    public MixinPackageItem(class_1792.class_1793 properties) {
        super(properties);
    }

    @WrapOperation(method={"useOn"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/item/context/UseOnContext;getClickLocation()Lnet/minecraft/world/phys/Vec3;")})
    private class_243 wrapOnUse(class_1838 context, Operation<class_243> original) {
        class_243 pos = (class_243)original.call(new Object[]{context});
        Ship ship = VSGameUtilsKt.getShipManagingPos(context.method_8045(), (class_2374)pos);
        if (ship != null) {
            Vector3d worldPos = ship.getShipToWorld().transformPosition(pos.field_1352, pos.field_1351, pos.field_1350, new Vector3d());
            return VectorConversionsMCKt.toMinecraft(worldPos);
        }
        return pos;
    }
}

