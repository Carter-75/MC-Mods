/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorPackage
 *  com.simibubi.create.infrastructure.config.AllConfigs
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorPackage;
import com.simibubi.create.infrastructure.config.AllConfigs;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.CompatUtil;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={ChainConveyorBlockEntity.class})
public class MixinChainConveyorBlockEntity
extends class_2586 {
    @Inject(method={"exportToPort"}, at={@At(value="HEAD")}, cancellable=true)
    private void cancelExportIfTooFar(ChainConveyorPackage box, class_2338 offset, CallbackInfoReturnable<Boolean> cir) {
        class_2338 targetPos = this.method_11016().method_10081((class_2382)offset);
        if (VSGameUtilsKt.getShipManagingPos(this.field_11863, this.field_11867) == VSGameUtilsKt.getShipManagingPos(this.field_11863, targetPos)) {
            return;
        }
        double dist = CompatUtil.INSTANCE.toSameSpaceAs(this.field_11863, this.method_11016().method_46558(), targetPos.method_46558()).method_1022(targetPos.method_46558());
        if (dist > (double)((Integer)AllConfigs.server().logistics.packagePortRange.get() + 2)) {
            cir.setReturnValue((Object)false);
        }
    }

    @Inject(method={"notifyPortToAnticipate"}, at={@At(value="HEAD")}, cancellable=true)
    private void cancelNotifyIfTooFar(class_2338 offset, CallbackInfo ci) {
        class_2338 targetPos = this.method_11016().method_10081((class_2382)offset);
        if (VSGameUtilsKt.getShipManagingPos(this.field_11863, this.field_11867) == VSGameUtilsKt.getShipManagingPos(this.field_11863, targetPos)) {
            return;
        }
        double dist = CompatUtil.INSTANCE.toSameSpaceAs(this.field_11863, this.method_11016().method_46558(), targetPos.method_46558()).method_1022(targetPos.method_46558());
        if (dist > (double)((Integer)AllConfigs.server().logistics.packagePortRange.get() + 2)) {
            ci.cancel();
        }
    }

    public MixinChainConveyorBlockEntity(class_2591<?> blockEntityType, class_2338 blockPos, class_2680 blockState) {
        super(blockEntityType, blockPos, blockState);
    }
}

