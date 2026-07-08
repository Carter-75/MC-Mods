/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.kinetics.crusher.CrushingWheelControllerBlockEntity
 *  com.simibubi.create.foundation.blockEntity.SmartBlockEntity
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.crusher.CrushingWheelControllerBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import org.joml.Vector3d;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={CrushingWheelControllerBlockEntity.class})
public abstract class MixinCrushingWheelControllerTileEntity
extends SmartBlockEntity {
    @Shadow
    public class_1297 processingEntity;

    public MixinCrushingWheelControllerTileEntity(class_2591<?> type, class_2338 pos, class_2680 state) {
        super(type, pos, state);
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;getEntities(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;"))
    private List<class_1297> redirectBounds(class_1937 instance, class_1297 entity, class_238 area, Predicate<class_1297> predicate) {
        if (instance != null) {
            area = VSGameUtilsKt.transformAabbToWorld(instance, area);
            return instance.method_8333(entity, area, predicate);
        }
        return new ArrayList<class_1297>();
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/AABB;intersects(Lnet/minecraft/world/phys/AABB;)Z"))
    private boolean redirectIntersects(class_238 instance, class_238 other) {
        Iterator<Ship> ships;
        class_1937 level = this.method_10997();
        if (level != null && (ships = VSGameUtilsKt.getShipsIntersecting(level, instance).iterator()).hasNext()) {
            AABBd result2 = new AABBd();
            VectorConversionsMCKt.toJOML(instance).transform(ships.next().getTransform().getWorldToShip(), result2);
            instance = VectorConversionsMCKt.toMinecraft(result2);
        }
        return instance.method_994(other);
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"))
    private void redirectSetDeltaMovement(class_1297 instance, class_243 motion) {
        class_243 transformedDirection = this.directionShip2World(motion);
        instance.method_18799(transformedDirection);
    }

    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setPos(DDD)V")})
    private void redirectSetPosition(class_1297 instance, double d2, double e2, double f2, Operation<Void> original) {
        Vector3d worldCoord = VSGameUtilsKt.toWorldCoordinates(this.method_10997(), d2, e2, f2);
        original.call(new Object[]{instance, worldCoord.x, worldCoord.y, worldCoord.z});
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getX()D"))
    private double redirectEntityGetX(class_1297 instance) {
        return this.getTransformedPosition((class_1297)instance).field_1352;
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getY()D"))
    private double redirectEntityGetY(class_1297 instance) {
        return this.getTransformedPosition((class_1297)instance).field_1351;
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getZ()D"))
    private double redirectEntityGetZ(class_1297 instance) {
        return this.getTransformedPosition((class_1297)instance).field_1350;
    }

    private class_243 getTransformedPosition(class_1297 instance) {
        class_243 result2 = instance.method_19538();
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.method_10997(), this.method_11016());
        if (ship != null) {
            Vector3d tempVec = new Vector3d();
            ship.getTransform().getWorldToShip().transformPosition(result2.field_1352, result2.field_1351, result2.field_1350, tempVec);
            result2 = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return result2;
    }

    @ModifyVariable(method={"tick"}, at=@At(value="STORE"), name={"xMotion"}, remap=false)
    private double doubleXMotion(double original) {
        return ((double)this.field_11867.method_10263() + 0.5 - this.redirectEntityGetX(this.processingEntity)) / 2.0;
    }

    @ModifyVariable(method={"tick"}, at=@At(value="STORE"), name={"zMotion"}, remap=false)
    private double doubleZMotion(double original) {
        return ((double)this.field_11867.method_10260() + 0.5 - this.redirectEntityGetZ(this.processingEntity)) / 2.0;
    }

    private class_243 directionShip2World(class_243 direction) {
        class_243 result2 = direction;
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.method_10997(), this.method_11016());
        if (ship != null) {
            Vector3d tempVec = new Vector3d();
            ship.getTransform().getShipToWorld().transformDirection(result2.field_1352, result2.field_1351, result2.field_1350, tempVec);
            result2 = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return result2;
    }
}

