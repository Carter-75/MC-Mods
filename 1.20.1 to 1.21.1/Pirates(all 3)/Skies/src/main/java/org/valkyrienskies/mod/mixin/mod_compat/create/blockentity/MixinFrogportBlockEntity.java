/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.logistics.packagePort.PackagePortBlockEntity
 *  com.simibubi.create.content.logistics.packagePort.PackagePortTarget
 *  com.simibubi.create.content.logistics.packagePort.frogport.FrogportBlockEntity
 *  com.simibubi.create.infrastructure.config.AllConfigs
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.logistics.packagePort.PackagePortBlockEntity;
import com.simibubi.create.content.logistics.packagePort.PackagePortTarget;
import com.simibubi.create.content.logistics.packagePort.frogport.FrogportBlockEntity;
import com.simibubi.create.infrastructure.config.AllConfigs;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.CompatUtil;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={FrogportBlockEntity.class})
public abstract class MixinFrogportBlockEntity
extends PackagePortBlockEntity {
    @Inject(method={"lazyTick"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/logistics/packagePort/frogport/FrogportBlockEntity;tryPullingFromOwnAndAdjacentInventories()V")}, cancellable=true)
    private void cancelIfTooFar(CallbackInfo ci) {
        class_2338 targetPos = this.method_11016().method_10081((class_2382)(this.target != null ? this.target.relativePos : class_2338.field_10980));
        if (VSGameUtilsKt.getShipManagingPos(this.field_11863, this.field_11867) == VSGameUtilsKt.getShipManagingPos(this.field_11863, targetPos)) {
            return;
        }
        double dist = CompatUtil.INSTANCE.toSameSpaceAs(this.field_11863, this.method_11016().method_46558(), targetPos.method_46558()).method_1022(targetPos.method_46558());
        if (dist > (double)((Integer)AllConfigs.server().logistics.packagePortRange.get() + 2)) {
            ci.cancel();
        }
    }

    @WrapOperation(method={"getYaw"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/logistics/packagePort/PackagePortTarget;getExactTargetLocation(Lcom/simibubi/create/content/logistics/packagePort/PackagePortBlockEntity;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/phys/Vec3;")})
    private class_243 adjustPosition(PackagePortTarget instance, PackagePortBlockEntity packagePortBlockEntity, class_1936 levelAccessor, class_2338 blockPos, Operation<class_243> original) {
        return CompatUtil.INSTANCE.toSameSpaceAs(packagePortBlockEntity.method_10997(), (class_243)original.call(new Object[]{instance, packagePortBlockEntity, levelAccessor, blockPos}), blockPos);
    }

    public MixinFrogportBlockEntity(class_2591<?> blockEntityType, class_2338 blockPos, class_2680 blockState) {
        super(blockEntityType, blockPos, blockState);
    }
}

