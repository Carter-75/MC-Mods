/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.logistics.packagePort.PackagePortBlockEntity
 *  com.simibubi.create.content.logistics.packagePort.PackagePortTarget
 *  com.simibubi.create.content.logistics.packagePort.frogport.FrogportVisual
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.logistics.packagePort.PackagePortBlockEntity;
import com.simibubi.create.content.logistics.packagePort.PackagePortTarget;
import com.simibubi.create.content.logistics.packagePort.frogport.FrogportVisual;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.CompatUtil;

@Mixin(value={FrogportVisual.class})
public class MixinFrogportVisual {
    @WrapOperation(method={"animate"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/logistics/packagePort/PackagePortTarget;getExactTargetLocation(Lcom/simibubi/create/content/logistics/packagePort/PackagePortBlockEntity;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/phys/Vec3;")})
    class_243 adjustPosition(PackagePortTarget instance, PackagePortBlockEntity packagePortBlockEntity, class_1936 levelAccessor, class_2338 blockPos, Operation<class_243> original) {
        return CompatUtil.INSTANCE.toSameSpaceAs(packagePortBlockEntity.method_10997(), (class_243)original.call(new Object[]{instance, packagePortBlockEntity, levelAccessor, blockPos}), blockPos);
    }
}

