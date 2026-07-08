/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.kinetics.belt.BeltBlockEntity
 *  com.simibubi.create.content.kinetics.belt.transport.BeltMovementHandler
 *  com.simibubi.create.content.kinetics.belt.transport.BeltMovementHandler$TransportedEntityInfo
 *  net.minecraft.class_1297
 *  net.minecraft.class_1313
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.kinetics.belt.transport.BeltMovementHandler;
import net.minecraft.class_1297;
import net.minecraft.class_1313;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={BeltMovementHandler.class})
public abstract class MixinBeltMovementHandler {
    @Unique
    private static Vector3d blockPos;
    @Unique
    private static class_1937 level;
    @Unique
    private static Ship ship;
    @Unique
    private static class_2350.class_2351 axis;
    @Unique
    private static class_1297 entity;

    @Inject(method={"transportEntity"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/Direction;fromAxisAndDirection(Lnet/minecraft/core/Direction$Axis;Lnet/minecraft/core/Direction$AxisDirection;)Lnet/minecraft/core/Direction;")}, locals=LocalCapture.CAPTURE_FAILHARD)
    private static void injectHead(BeltBlockEntity beltTe, class_1297 entityIn, BeltMovementHandler.TransportedEntityInfo info, CallbackInfo ci, class_2338 pos) {
        blockPos = VectorConversionsMCKt.toJOMLD((class_2382)pos);
        entity = entityIn;
        level = beltTe.method_10997();
        if (level != null) {
            ship = VSGameUtilsKt.getShipManagingPos(level, (Vector3dc)blockPos);
        }
    }

    @ModifyVariable(method={"transportEntity"}, at=@At(value="STORE"), name={"axis"})
    private static class_2350.class_2351 injectHarvestAxis(class_2350.class_2351 value) {
        axis = value;
        return value;
    }

    @Redirect(method={"transportEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;move(Lnet/minecraft/world/entity/MoverType;Lnet/minecraft/world/phys/Vec3;)V", ordinal=2))
    private static void redirectMove1(class_1297 instance, class_1313 type, class_243 pos) {
        if (ship != null) {
            instance.method_5784(type, new class_243(pos.field_1352 * 3.0, 0.2, pos.field_1350 * 3.0));
        } else {
            instance.method_5784(type, pos);
        }
    }

    @Redirect(method={"transportEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;move(Lnet/minecraft/world/entity/MoverType;Lnet/minecraft/world/phys/Vec3;)V", ordinal=1))
    private static void redirectMove2(class_1297 instance, class_1313 type, class_243 pos) {
        if (ship != null) {
            instance.method_5784(type, new class_243(pos.field_1352 * 3.0, 0.0, pos.field_1350 * 3.0));
        } else {
            instance.method_5784(type, pos);
        }
    }

    @Redirect(method={"transportEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/Direction$Axis;choose(DDD)D"))
    private static double redirectChoose(class_2350.class_2351 instance, double x, double y, double z) {
        if (ship != null) {
            class_243 mul = new class_243(0.0, 0.0, 0.0);
            if (instance == class_2350.class_2351.field_11048) {
                mul = MixinBeltMovementHandler.redirectGetNormal(new class_2382(1, 0, 0));
            }
            if (instance == class_2350.class_2351.field_11052) {
                mul = MixinBeltMovementHandler.redirectGetNormal(new class_2382(0, 1, 0));
            }
            if (instance == class_2350.class_2351.field_11051) {
                mul = MixinBeltMovementHandler.redirectGetNormal(new class_2382(0, 0, 1));
            }
            return Math.abs(x * mul.field_1352) + Math.abs(y * mul.field_1351) + Math.abs(z * mul.field_1350);
        }
        return instance.method_10172(x, y, z);
    }

    @ModifyVariable(method={"transportEntity"}, at=@At(value="STORE"), name={"diffCenter"})
    private static double modDiffCenter(double value) {
        return axis == class_2350.class_2351.field_11051 ? MixinBeltMovementHandler.blockPos.x + 0.5 - MixinBeltMovementHandler.getPos((class_1297)MixinBeltMovementHandler.entity).field_1352 : MixinBeltMovementHandler.blockPos.z + 0.5 - MixinBeltMovementHandler.getPos((class_1297)MixinBeltMovementHandler.entity).field_1350;
    }

    @Redirect(method={"transportEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;atLowerCornerOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectGetNormal(class_2382 toCopy) {
        class_243 result2 = class_243.method_24954((class_2382)toCopy);
        if (level != null && ship != null) {
            Vector3d tempVec = VectorConversionsMCKt.toJOML(result2);
            Quaterniond tempQuat = new Quaterniond();
            ship.getTransform().getShipToWorld().getNormalizedRotation(tempQuat);
            tempVec.rotate(tempQuat);
            result2 = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return result2;
    }

    @Redirect(method={"transportEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getX()D"))
    private static double redirectGetX(class_1297 instance) {
        return MixinBeltMovementHandler.getPos((class_1297)instance).field_1352;
    }

    @Redirect(method={"transportEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getY()D"))
    private static double redirectGetY(class_1297 instance) {
        return MixinBeltMovementHandler.getPos((class_1297)instance).field_1351;
    }

    @Redirect(method={"transportEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getZ()D"))
    private static double redirectGetZ(class_1297 instance) {
        return MixinBeltMovementHandler.getPos((class_1297)instance).field_1350;
    }

    @Unique
    private static class_243 getPos(class_1297 entity) {
        class_243 result2 = entity.method_19538();
        if (level != null && ship != null) {
            Vector3d tempVec = VectorConversionsMCKt.toJOML(result2);
            ship.getTransform().getWorldToShip().transformPosition(tempVec);
            result2 = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return result2;
    }
}

