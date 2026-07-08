/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1646
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_4133
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.ai.goal.villagers;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1646;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_4133;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_4133.class})
public class MixinWorkAtPoi {
    @WrapOperation(method={"canStillUse(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/npc/Villager;J)Z"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerToCenterThan(Lnet/minecraft/core/Position;D)Z")})
    private boolean onCloserToCenterThan(class_2338 instance, class_2374 position, double v, Operation<Boolean> original, @Local class_1646 villager) {
        return (Boolean)original.call(new Object[]{class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates(villager.method_37908(), instance)), position, v});
    }

    @WrapOperation(method={"checkExtraStartConditions(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/npc/Villager;)Z"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerToCenterThan(Lnet/minecraft/core/Position;D)Z")})
    private boolean onCloserToCenterThan2(class_2338 instance, class_2374 position, double v, Operation<Boolean> original, @Local class_1646 villager) {
        return (Boolean)original.call(new Object[]{class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates(villager.method_37908(), instance)), position, v});
    }
}

