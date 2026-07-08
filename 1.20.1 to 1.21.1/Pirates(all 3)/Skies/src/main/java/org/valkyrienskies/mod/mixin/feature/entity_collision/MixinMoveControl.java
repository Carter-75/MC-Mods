/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1308
 *  net.minecraft.class_1335
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.entity_collision;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1308;
import net.minecraft.class_1335;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.api.ValkyrienSkies;

@Mixin(value={class_1335.class})
public class MixinMoveControl {
    @Shadow
    @Final
    protected class_1308 field_6371;

    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/block/state/BlockState;getCollisionShape(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/phys/shapes/VoxelShape;")})
    private class_265 vs$insertShipCollisions(class_2680 instance, class_1922 blockGetter, class_2338 blockPos, Operation<class_265> original) {
        class_265 originalShape = (class_265)original.call(new Object[]{instance, this.field_6371.method_37908(), blockPos});
        if (originalShape.method_1110()) {
            Iterable<Vector3d> alternates = ValkyrienSkies.positionToNearbyShips(this.field_6371.method_37908(), blockPos.method_10263(), blockPos.method_10264(), blockPos.method_10260());
            for (Vector3d alternate : alternates) {
                class_265 alternateShape;
                class_2338 alternatePos = class_2338.method_49638((class_2374)ValkyrienSkies.toMinecraft(alternate));
                class_2680 alternateState = this.field_6371.method_37908().method_8320(alternatePos);
                if (alternateState.method_26215() || (alternateShape = alternateState.method_26220((class_1922)this.field_6371.method_37908(), alternatePos)).method_1110()) continue;
                return alternateShape;
            }
        }
        return originalShape;
    }
}

