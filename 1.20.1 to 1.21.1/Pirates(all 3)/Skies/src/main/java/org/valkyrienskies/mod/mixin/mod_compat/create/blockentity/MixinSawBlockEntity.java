/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.kinetics.base.BlockBreakingKineticBlockEntity
 *  com.simibubi.create.content.kinetics.saw.SawBlockEntity
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.base.BlockBreakingKineticBlockEntity;
import com.simibubi.create.content.kinetics.saw.SawBlockEntity;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={SawBlockEntity.class})
public abstract class MixinSawBlockEntity
extends BlockBreakingKineticBlockEntity {
    public MixinSawBlockEntity(class_2591<?> type, class_2338 pos, class_2680 state) {
        super(type, pos, state);
    }

    @WrapOperation(method={"dropItemFromCutTree"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;subtract(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/core/BlockPos;")})
    private class_2338 shipWorldPosSubtract(class_2338 breakingPos, class_2382 worldPosition, Operation<class_2338> subtract) {
        Ship shipTree = VSGameUtilsKt.getShipManagingPos(this.field_11863, breakingPos);
        Ship shipSaw = VSGameUtilsKt.getShipManagingPos(this.field_11863, new class_2338(worldPosition));
        Vector3d sawWorldPos = VectorConversionsMCKt.toJOML(class_243.method_24953((class_2382)worldPosition));
        if (shipSaw == null && shipTree == null) {
            return (class_2338)subtract.call(new Object[]{breakingPos, worldPosition});
        }
        if (shipSaw != null) {
            shipSaw.getShipToWorld().transformPosition(sawWorldPos);
        }
        if (shipTree != null) {
            shipTree.getWorldToShip().transformPosition(sawWorldPos);
        }
        return (class_2338)subtract.call(new Object[]{breakingPos, class_2338.method_49637((double)sawWorldPos.x, (double)sawWorldPos.y, (double)sawWorldPos.z)});
    }
}

