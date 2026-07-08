/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_4466
 *  net.minecraft.class_4466$class_4470
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.ai.goal.bees;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_4466;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_4466.class_4470.class})
public class MixinEnterHiveGoal {
    @Shadow
    @Final
    class_4466 field_20367;

    @WrapOperation(method={"canBeeUse"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerToCenterThan(Lnet/minecraft/core/Position;D)Z")})
    private boolean onCloserToCenterThan(class_2338 instance, class_2374 position, double v, Operation<Boolean> original) {
        return (Boolean)original.call(new Object[]{class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates(this.field_20367.method_37908(), instance)), position, v});
    }
}

