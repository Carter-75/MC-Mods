/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1657
 *  net.minecraft.class_1747
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3726
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.block_placement;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1657;
import net.minecraft.class_1747;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import org.joml.Intersectiond;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.PlayerUtil;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_1747.class})
public abstract class MixinBlockItem {
    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/world/item/BlockItem;getPlacementState(Lnet/minecraft/world/item/context/BlockPlaceContext;)Lnet/minecraft/world/level/block/state/BlockState;")}, method={"place"})
    private class_2680 transformPlayerWhenPlacing(class_1747 _instance, class_1750 _ctx, Operation<class_2680> original, class_1750 ctx) {
        if (ctx == null || ctx.method_8036() == null) {
            return null;
        }
        return (class_2680)PlayerUtil.transformPlayerTemporarily(ctx.method_8036(), ctx.method_8045(), ctx.method_8037(), () -> (class_2680)original.call(new Object[]{this, ctx}));
    }

    @WrapOperation(method={"canPlace"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;isUnobstructed(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/phys/shapes/CollisionContext;)Z")})
    private boolean checkObstructionByPlayer(class_1937 level, class_2680 blockState, class_2338 blockPos, class_3726 ctx, Operation<Boolean> original, @Local(argsOnly=true) class_1750 blockPlaceContext) {
        Ship ship;
        boolean result2 = (Boolean)original.call(new Object[]{level, blockState, blockPos, ctx});
        if (result2 && (ship = VSGameUtilsKt.getShipManagingPos(level, blockPos)) != null) {
            class_265 voxelShape = blockState.method_26194((class_1922)level, blockPos, ctx);
            class_1657 player = blockPlaceContext.method_8036();
            if (player != null && !player.method_31481() && player.field_23807 && !voxelShape.method_1110() && MixinBlockItem.vs_testObAab(VectorConversionsMCKt.toJOML(voxelShape.method_1107().method_996(blockPos)), ship.getShipToWorld(), VectorConversionsMCKt.toJOML(player.method_5829().method_1011(0.1)))) {
                return false;
            }
        }
        return result2;
    }

    @Unique
    private static boolean vs_testObAab(AABBd aabb, Matrix4dc transform2, AABBd other) {
        Vector3d tX2 = new Vector3d(transform2.m00(), transform2.m01(), transform2.m02()).normalize();
        Vector3d tY2 = new Vector3d(transform2.m10(), transform2.m11(), transform2.m12()).normalize();
        Vector3d tZ2 = new Vector3d(transform2.m20(), transform2.m21(), transform2.m22()).normalize();
        Vector3d transformedCenter = transform2.transformPosition(aabb.center(new Vector3d()));
        Vector3d wX2 = new Vector3d(1.0, 0.0, 0.0);
        Vector3d wY2 = new Vector3d(0.0, 1.0, 0.0);
        Vector3d wZ2 = new Vector3d(0.0, 0.0, 1.0);
        return Intersectiond.testObOb(transformedCenter, tX2, tY2, tZ2, aabb.getSize(new Vector3d()).mul(0.5), other.center(new Vector3d()), wX2, wY2, wZ2, other.getSize(new Vector3d()).mul(0.5));
    }
}

