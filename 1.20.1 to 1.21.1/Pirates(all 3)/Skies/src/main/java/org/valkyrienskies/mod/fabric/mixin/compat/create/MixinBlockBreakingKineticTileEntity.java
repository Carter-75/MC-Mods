/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.kinetics.base.BlockBreakingKineticBlockEntity
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.fabric.mixin.compat.create;

import com.simibubi.create.content.kinetics.base.BlockBreakingKineticBlockEntity;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={BlockBreakingKineticBlockEntity.class})
public abstract class MixinBlockBreakingKineticTileEntity {
    @Shadow
    protected abstract class_2338 getBreakingPos();

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/base/BlockBreakingKineticBlockEntity;getBreakingPos()Lnet/minecraft/core/BlockPos;"))
    private class_2338 getBreakingBlockPos(BlockBreakingKineticBlockEntity self) {
        class_243 target;
        class_243 origin;
        class_2338 orig = this.getBreakingPos();
        Ship ship = VSGameUtilsKt.getShipManagingPos(self.method_10997(), self.method_11016());
        if (ship != null) {
            origin = VectorConversionsMCKt.toMinecraft(ship.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOMLD((class_2382)self.method_11016()).add(0.5, 0.5, 0.5)));
            target = VectorConversionsMCKt.toMinecraft(ship.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOMLD((class_2382)orig).add(0.5, 0.5, 0.5)));
        } else {
            origin = class_243.method_24953((class_2382)self.method_11016());
            target = class_243.method_24953((class_2382)orig);
        }
        class_243 diff = target.method_1020(origin);
        class_3965 result2 = self.method_10997().method_17742(new class_3959(origin.method_1019(diff.method_1021(0.4)), target.method_1019(diff.method_1021(0.2)), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, null));
        if (result2.method_17783() == class_239.class_240.field_1333) {
            return orig;
        }
        return result2.method_17777();
    }
}

