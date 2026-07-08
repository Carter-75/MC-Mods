/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.logistics.box.PackageEntity
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.entity;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.logistics.box.PackageEntity;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_265;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.EntityShipCollisionUtils;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={PackageEntity.class})
public abstract class MixinPackageEntity
extends class_1309 {
    protected MixinPackageEntity(class_1299<? extends class_1309> entityType, class_1937 level) {
        super(entityType, level);
    }

    @WrapMethod(method={"fromItemStack"})
    private static PackageEntity wrapFromItemStack(class_1937 world, class_243 position, class_1799 itemstack, Operation<PackageEntity> original) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(world, position.field_1352, position.field_1351, position.field_1350);
        if (ship != null) {
            Vector3d worldPos = ship.getTransform().getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(position));
            PackageEntity result2 = (PackageEntity)original.call(new Object[]{world, VectorConversionsMCKt.toMinecraft(worldPos), itemstack});
            ((IEntityDraggingInformationProvider)result2).getDraggingInformation().setLastShipStoodOn(ship.getId());
            return result2;
        }
        return (PackageEntity)original.call(new Object[]{world, position, itemstack});
    }

    @WrapMethod(method={"fromDroppedItem"})
    private static PackageEntity wrapFromDroppedItem(class_1937 world, class_1297 originalEntity, class_1799 itemstack, Operation<PackageEntity> original) {
        Ship ship = VSGameUtilsKt.getShipManaging(originalEntity);
        if (ship != null) {
            Vector3d worldPos = ship.getTransform().getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(originalEntity.method_19538()));
            originalEntity.method_33574(VectorConversionsMCKt.toMinecraft(worldPos));
            PackageEntity result2 = (PackageEntity)original.call(new Object[]{world, originalEntity, itemstack});
            ((IEntityDraggingInformationProvider)result2).getDraggingInformation().setLastShipStoodOn(ship.getId());
            return result2;
        }
        return (PackageEntity)original.call(new Object[]{world, originalEntity, itemstack});
    }

    @WrapMethod(method={"centerPackage"})
    private static boolean wrapCenterPackageToShip(class_1297 entity, class_243 target, Operation<Boolean> original) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(entity.method_37908(), target.field_1352, target.field_1351, target.field_1350);
        if (ship != null) {
            Vector3d worldPos = ship.getTransform().getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(target));
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOn(ship.getId());
            return (Boolean)original.call(new Object[]{entity, VectorConversionsMCKt.toMinecraft(worldPos)});
        }
        return (Boolean)original.call(new Object[]{entity, target});
    }

    @WrapOperation(method={"travel"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/logistics/box/PackageEntity;collideBoundingBox(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/AABB;Lnet/minecraft/world/level/Level;Ljava/util/List;)Lnet/minecraft/world/phys/Vec3;")})
    private class_243 redirectToShipCollision(class_1297 entity, class_243 motion, class_238 aabb, class_1937 level, List<class_265> list, Operation<class_243> collideOriginal) {
        EntityDraggingInformation entityDraggingInformation = ((IEntityDraggingInformationProvider)entity).getDraggingInformation();
        Long shipId = entityDraggingInformation.getLastShipStoodOn();
        class_243 worldMotion = (class_243)collideOriginal.call(new Object[]{entity, motion, aabb, level, list});
        class_243 adjustedMotion = EntityShipCollisionUtils.INSTANCE.adjustEntityMovementForShipCollisions(entity, worldMotion, aabb, level);
        entityDraggingInformation.setLastShipStoodOn(shipId);
        return adjustedMotion;
    }
}

