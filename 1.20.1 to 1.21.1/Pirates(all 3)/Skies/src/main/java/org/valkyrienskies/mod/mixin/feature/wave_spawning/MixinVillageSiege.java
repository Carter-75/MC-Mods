/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1419
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.wave_spawning;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1419;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_1419.class})
public class MixinVillageSiege {
    @WrapOperation(method={"tryToSetupSiege"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/ai/village/VillageSiege;findRandomSpawnPos(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/phys/Vec3;")})
    private class_243 onFindRandomSpawnPos(class_1419 instance, class_3218 k2, class_2338 l2, Operation<class_243> original) {
        class_2338 transformedCenter = class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates((class_1937)k2, l2));
        class_243 result2 = (class_243)original.call(new Object[]{instance, k2, transformedCenter});
        if (result2 != null) {
            return result2;
        }
        return (class_243)original.call(new Object[]{instance, k2, l2});
    }

    @WrapOperation(method={"trySpawn"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/ai/village/VillageSiege;findRandomSpawnPos(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/phys/Vec3;")})
    private class_243 onFindRandomSpawnPos2(class_1419 instance, class_3218 k2, class_2338 l2, Operation<class_243> original) {
        class_2338 transformedCenter = class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates((class_1937)k2, l2));
        class_243 result2 = (class_243)original.call(new Object[]{instance, k2, transformedCenter});
        if (result2 != null) {
            return result2;
        }
        return (class_243)original.call(new Object[]{instance, k2, l2});
    }
}

