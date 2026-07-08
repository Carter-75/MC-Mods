/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_3218
 *  net.minecraft.class_3765
 *  net.minecraft.class_3767
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.wave_spawning;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.Map;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_3218;
import net.minecraft.class_3765;
import net.minecraft.class_3767;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_3767.class})
public class MixinRaids {
    @Shadow
    @Final
    private class_3218 field_16641;
    @Shadow
    @Final
    private Map<Integer, class_3765> field_16639;

    @WrapOperation(method={"getNearbyRaid"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/raid/Raid;getCenter()Lnet/minecraft/core/BlockPos;")})
    private class_2338 onGetNearbyRaid(class_3765 instance, Operation<class_2338> original) {
        return class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates((class_1937)this.field_16641, (class_2338)original.call(new Object[]{instance})));
    }
}

