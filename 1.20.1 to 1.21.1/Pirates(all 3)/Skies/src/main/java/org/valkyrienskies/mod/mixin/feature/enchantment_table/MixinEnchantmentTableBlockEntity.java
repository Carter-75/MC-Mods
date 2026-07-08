/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2605
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package org.valkyrienskies.mod.mixin.feature.enchantment_table;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2605;
import net.minecraft.class_2680;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_2605.class})
public class MixinEnchantmentTableBlockEntity
extends class_2586 {
    @WrapOperation(method={"bookAnimationTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;getNearestPlayer(DDDDZ)Lnet/minecraft/world/entity/player/Player;")})
    private static class_1657 adjustForWorld(class_1937 level, double x, double y, double z, double r, boolean b2, Operation<class_1657> original) {
        class_243 worldPos = VSGameUtilsKt.toWorldCoordinates(level, new class_243(x, y, z));
        return (class_1657)original.call(new Object[]{level, worldPos.field_1352, worldPos.field_1351, worldPos.field_1350, r, b2});
    }

    @ModifyVariable(method={"bookAnimationTick"}, at=@At(value="STORE"), ordinal=0)
    private static double worldX(double x, @Local class_1657 player, @Local(argsOnly=true) class_2338 blockPos) {
        class_243 worldPos = VSGameUtilsKt.toWorldCoordinates(player.method_37908(), blockPos.method_46558());
        return player.method_23317() - worldPos.field_1352;
    }

    @ModifyVariable(method={"bookAnimationTick"}, at=@At(value="STORE"), ordinal=1)
    private static double worldZ(double x, @Local class_1657 player, @Local(argsOnly=true) class_2338 blockPos) {
        class_243 worldPos = VSGameUtilsKt.toWorldCoordinates(player.method_37908(), blockPos.method_46558());
        return player.method_23321() - worldPos.field_1350;
    }

    @WrapOperation(method={"bookAnimationTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/util/Mth;atan2(DD)D")})
    private static double adjustYaw(double d2, double e2, Operation<Double> original, @Local(argsOnly=true) class_1937 level, @Local(argsOnly=true) class_2338 blockPos, @Local class_1657 player) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(level, blockPos);
        if (ship != null) {
            Matrix4dc shipTransform = ship.getTransform().getShipToWorld();
            Matrix4d invTransform = new Matrix4d(shipTransform).invertAffine();
            Vector3d P_w = new Vector3d(player.method_23317(), player.method_23318(), player.method_23321());
            Vector3d P_l = new Vector3d();
            invTransform.transformPosition(P_w, P_l);
            Vector3d T_l = new Vector3d((double)blockPos.method_10263() + 0.5, (double)blockPos.method_10264() + 0.5, (double)blockPos.method_10260() + 0.5);
            Vector3d D_l = new Vector3d(P_l).sub(T_l);
            return (Double)original.call(new Object[]{D_l.z(), D_l.x()});
        }
        return (Double)original.call(new Object[]{d2, e2});
    }

    public MixinEnchantmentTableBlockEntity(class_2591<?> blockEntityType, class_2338 blockPos, class_2680 blockState) {
        super(blockEntityType, blockPos, blockState);
    }
}

