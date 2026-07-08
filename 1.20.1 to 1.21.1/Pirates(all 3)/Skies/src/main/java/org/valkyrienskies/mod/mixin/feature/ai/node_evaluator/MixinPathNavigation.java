/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_11
 *  net.minecraft.class_1408
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.ai.node_evaluator;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_11;
import net.minecraft.class_1408;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_1408.class})
public class MixinPathNavigation {
    @Shadow
    @Final
    protected class_1937 field_6677;

    @WrapOperation(method={"moveTo(DDDD)Z"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/ai/navigation/PathNavigation;createPath(DDDI)Lnet/minecraft/world/level/pathfinder/Path;")})
    private class_11 onMoveToCreatePath(class_1408 instance, double d2, double e2, double f2, int i2, Operation<class_11> original) {
        class_243 transformedPos = VSGameUtilsKt.toWorldCoordinates(this.field_6677, new class_243(d2, e2, f2));
        return (class_11)original.call(new Object[]{instance, transformedPos.field_1352, transformedPos.field_1351, transformedPos.field_1350, i2});
    }

    @WrapOperation(method={"isStableDestination"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;")})
    private class_2680 vs$getBlockStateIsNotStable(class_1937 instance, class_2338 blockPos, Operation<class_2680> original) {
        class_2680 originalState = (class_2680)original.call(new Object[]{instance, blockPos});
        if (originalState.method_26216((class_1922)instance, blockPos)) {
            return originalState;
        }
        Iterable<Vector3d> candidates = ValkyrienSkies.positionToNearbyShips(instance, blockPos.method_10084().method_10263(), blockPos.method_10084().method_10264(), blockPos.method_10084().method_10260());
        for (Vector3d candidate : candidates) {
            Ship ship = ValkyrienSkies.getShipManagingBlock(instance, candidate);
            if (ship == null) continue;
            Vector3d upVector = ship.getTransform().getShipToWorld().transformDirection(VectorConversionsMCKt.toJOMLD(class_2350.field_11036.method_10163())).normalize();
            class_2350 closestDirection = class_2350.method_10142((double)upVector.x(), (double)upVector.y(), (double)upVector.z()).method_10153();
            class_2338 candidatePos = class_2338.method_49638((class_2374)ValkyrienSkies.toMinecraft(candidate)).method_10093(closestDirection);
            class_2680 candidateState = (class_2680)original.call(new Object[]{instance, candidatePos});
            if (!candidateState.method_26216((class_1922)instance, candidatePos)) continue;
            return candidateState;
        }
        return originalState;
    }
}

