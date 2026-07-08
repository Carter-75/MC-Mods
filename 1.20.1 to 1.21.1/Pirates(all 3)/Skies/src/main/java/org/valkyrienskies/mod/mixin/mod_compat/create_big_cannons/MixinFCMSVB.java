/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.foundation.blockEntity.SmartBlockEntity
 *  com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  rbasamoyai.createbigcannons.cannon_control.fixed_cannon_mount.FixedCannonMountBlockEntity$FixedCannonMountScrollValueBehaviour
 */
package org.valkyrienskies.mod.mixin.mod_compat.create_big_cannons;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import rbasamoyai.createbigcannons.cannon_control.fixed_cannon_mount.FixedCannonMountBlockEntity;

@Mixin(value={FixedCannonMountBlockEntity.FixedCannonMountScrollValueBehaviour.class})
public abstract class MixinFCMSVB
extends BlockEntityBehaviour {
    public MixinFCMSVB(SmartBlockEntity be) {
        super(be);
    }

    @WrapOperation(method={"testHit"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;subtract(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;")})
    public class_243 redirectSubtract(class_243 instance, class_243 vec, Operation<class_243> original) {
        class_1937 level = this.getWorld();
        class_243 pos1 = instance;
        class_243 pos2 = vec;
        if (level != null) {
            Ship ship1 = VSGameUtilsKt.getShipManagingPos(level, pos1.field_1352, pos1.field_1351, pos1.field_1350);
            Ship ship2 = VSGameUtilsKt.getShipManagingPos(level, pos2.field_1352, pos2.field_1351, pos2.field_1350);
            if (ship1 != null && ship2 == null) {
                pos2 = VectorConversionsMCKt.toMinecraft(ship1.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(pos2)));
            } else if (ship1 == null && ship2 != null) {
                pos1 = VectorConversionsMCKt.toMinecraft(ship2.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(pos1)));
            }
        }
        return pos1.method_1020(pos2);
    }
}

