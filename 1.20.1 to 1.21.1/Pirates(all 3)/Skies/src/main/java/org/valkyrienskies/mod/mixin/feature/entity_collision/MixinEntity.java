/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1313
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_4048
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package org.valkyrienskies.mod.mixin.feature.entity_collision;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1313;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_4048;
import net.minecraft.class_5819;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.EntityShipCollisionUtils;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;

@Mixin(value={class_1297.class})
public abstract class MixinEntity
implements IEntityDraggingInformationProvider {
    @Shadow
    public boolean field_6007;
    @Shadow
    protected boolean field_5953;
    @Shadow
    public int field_6012;
    @Shadow
    public class_1937 field_6002;
    @Shadow
    private class_243 field_22467;
    @Shadow
    @Final
    protected class_5819 field_5974;
    @Shadow
    private class_4048 field_18065;

    @Shadow
    public abstract void method_33574(class_243 var1);

    @Shadow
    public abstract boolean method_5779(class_1297 var1);

    @Shadow
    public abstract boolean method_5787();

    @Shadow
    public abstract class_1299<?> method_5864();

    @Shadow
    public abstract Iterable<class_1297> method_5736();

    @Shadow
    public abstract class_2338 method_23312();

    @Inject(at={@At(value="HEAD")}, method={"move"}, cancellable=true)
    private void beforeMove(class_1313 type, class_243 pos, CallbackInfo ci) {
        if (EntityShipCollisionUtils.isCollidingWithUnloadedShips((class_1297)class_1297.class.cast(this))) {
            ci.cancel();
        }
    }

    @WrapOperation(method={"move"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;collide(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;")})
    public class_243 collideWithShips(class_1297 entity, class_243 movement, Operation<class_243> collide) {
        class_238 box = this.method_5829();
        movement = EntityShipCollisionUtils.INSTANCE.adjustEntityMovementForShipCollisions(entity, movement, box, this.field_6002);
        Object[] objectArray = new Object[]{entity, movement};
        class_243 collisionResultWithWorld = (class_243)collide.call(objectArray);
        if (collisionResultWithWorld.method_1025(movement) > 1.0E-12) {
            EntityDraggingInformation entityDraggingInformation = this.getDraggingInformation();
            if (entityDraggingInformation.getIgnoreNextGroundStand()) {
                entityDraggingInformation.setIgnoreNextGroundStand(false);
                return collisionResultWithWorld;
            }
            entityDraggingInformation.setLastShipStoodOn(null);
            entityDraggingInformation.setAddedYawRotLastTick(0.0);
            for (class_1297 entityRiding : entity.method_5736()) {
                EntityDraggingInformation passengerDraggingInformation = ((IEntityDraggingInformationProvider)entityRiding).getDraggingInformation();
                passengerDraggingInformation.setLastShipStoodOn(null);
                passengerDraggingInformation.setAddedYawRotLastTick(0.0);
            }
        }
        return collisionResultWithWorld;
    }

    @Inject(method={"move"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setDeltaMovement(DDD)V")}, locals=LocalCapture.CAPTURE_FAILHARD, cancellable=true)
    private void redirectSetVelocity(class_1313 moverType, class_243 movement, CallbackInfo callbackInfo, class_243 movementAdjustedForCollisions) {
        Vector3d collisionResponseHorizontal = new Vector3d(movementAdjustedForCollisions.field_1352 - movement.field_1352, 0.0, movementAdjustedForCollisions.field_1350 - movement.field_1350);
        if (collisionResponseHorizontal.lengthSquared() > 1.0E-6) {
            class_243 deltaMovement = this.method_18798();
            Vector3d collisionResponseHorizontalNormal = collisionResponseHorizontal.normalize(new Vector3d());
            double parallelHorizontalVelocityComponent = collisionResponseHorizontalNormal.dot(deltaMovement.field_1352, 0.0, deltaMovement.field_1350);
            this.method_18800(deltaMovement.field_1352 - collisionResponseHorizontalNormal.x() * parallelHorizontalVelocityComponent, deltaMovement.field_1351, deltaMovement.field_1350 - collisionResponseHorizontalNormal.z() * parallelHorizontalVelocityComponent);
        }
        this.method_36974();
        callbackInfo.cancel();
    }

    @Unique
    private class_2338 getPosStandingOnFromShips(Vector3dc blockPosInGlobal) {
        double radius = 0.5;
        AABBd testAABB = new AABBd(blockPosInGlobal.x() - 0.5, blockPosInGlobal.y() - 0.5, blockPosInGlobal.z() - 0.5, blockPosInGlobal.x() + 0.5, blockPosInGlobal.y() + 0.5, blockPosInGlobal.z() + 0.5);
        Iterable<Ship> intersectingShips = VSGameUtilsKt.getShipsIntersecting(this.field_6002, testAABB);
        for (Ship ship : intersectingShips) {
            Vector3d blockPosInLocal = ship.getTransform().getWorldToShip().transformPosition(blockPosInGlobal, new Vector3d());
            class_2338 blockPos = class_2338.method_49637((double)blockPosInLocal.x(), (double)blockPosInLocal.y(), (double)blockPosInLocal.z());
            class_2680 blockState = this.field_6002.method_8320(blockPos);
            if (!blockState.method_26215()) {
                return blockPos;
            }
            Vector3d blockPosInLocal2 = ship.getTransform().getWorldToShip().transformPosition(new Vector3d(blockPosInGlobal.x(), blockPosInGlobal.y() - 1.0, blockPosInGlobal.z()));
            class_2338 blockPos2 = class_2338.method_49637((double)blockPosInLocal2.x(), (double)blockPosInLocal2.y(), (double)blockPosInLocal2.z());
            class_2680 blockState2 = this.field_6002.method_8320(blockPos2);
            if (blockState2.method_26215()) continue;
            return blockPos2;
        }
        return null;
    }

    @Inject(method={"getBlockPosBelowThatAffectsMyMovement"}, at={@At(value="HEAD")}, cancellable=true)
    private void preGetBlockPosBelowThatAffectsMyMovement(CallbackInfoReturnable<class_2338> cir) {
        Vector3d blockPosInGlobal = new Vector3d(this.field_22467.field_1352, this.method_5829().field_1322 - 0.5, this.field_22467.field_1350);
        class_2338 blockPosStandingOnFromShip = this.getPosStandingOnFromShips(blockPosInGlobal);
        if (blockPosStandingOnFromShip != null) {
            cir.setReturnValue((Object)blockPosStandingOnFromShip);
        }
    }

    @Inject(method={"getOnPos(F)Lnet/minecraft/core/BlockPos;"}, at={@At(value="HEAD")}, cancellable=true)
    private void preGetOnPos(CallbackInfoReturnable<class_2338> cir) {
        Vector3d blockPosInGlobal = new Vector3d(this.field_22467.field_1352, this.field_22467.field_1351 - 0.2, this.field_22467.field_1350);
        class_2338 blockPosStandingOnFromShip = this.getPosStandingOnFromShips(blockPosInGlobal);
        if (blockPosStandingOnFromShip != null) {
            cir.setReturnValue((Object)blockPosStandingOnFromShip);
        }
    }

    @WrapOperation(method={"spawnSprintParticle"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;blockPosition()Lnet/minecraft/core/BlockPos;")})
    private class_2338 skipBlockPosition(class_1297 entity, Operation<class_2338> original, @Local class_2338 posOn) {
        if (VSGameUtilsKt.isBlockInShipyard(this.field_6002, posOn)) {
            return posOn;
        }
        return (class_2338)original.call(new Object[]{entity});
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void markImpulsedFirstTick(CallbackInfo ci) {
        if (this.field_5953 && this.getDraggingInformation().isEntityBeingDraggedByAShip() && !this.field_6002.field_9236) {
            this.field_6007 = true;
        }
    }

    @Inject(method={"baseTick"}, at={@At(value="TAIL")})
    private void postBaseTick(CallbackInfo ci) {
        EntityDraggingInformation entityDraggingInformation = this.getDraggingInformation();
        if (this.field_6002 != null && this.field_6002.field_9236 && this.field_6012 > 1) {
            LoadedShip ship = VSGameUtilsKt.getLoadedShipManagingPos(this.field_6002, (class_2382)this.method_23312());
            if (ship != null) {
                entityDraggingInformation.setLastShipStoodOn(ship.getId());
                this.method_5736().forEach(entity -> {
                    EntityDraggingInformation passengerDraggingInformation = ((IEntityDraggingInformationProvider)entity).getDraggingInformation();
                    passengerDraggingInformation.setLastShipStoodOn(ship.getId());
                });
            } else if (!this.field_6002.method_8320(this.method_23312()).method_26215()) {
                if (entityDraggingInformation.getIgnoreNextGroundStand()) {
                    entityDraggingInformation.setIgnoreNextGroundStand(false);
                } else {
                    entityDraggingInformation.setLastShipStoodOn(null);
                    this.method_5736().forEach(entity -> {
                        EntityDraggingInformation passengerDraggingInformation = ((IEntityDraggingInformationProvider)entity).getDraggingInformation();
                        passengerDraggingInformation.setLastShipStoodOn(null);
                    });
                }
            }
        }
    }

    @Shadow
    public abstract class_238 method_5829();

    @Shadow
    public abstract void method_18800(double var1, double var3, double var5);

    @Shadow
    protected abstract void method_36974();

    @Shadow
    protected abstract class_243 method_17835(class_243 var1);

    @Shadow
    public abstract class_243 method_18798();

    @Shadow
    public abstract double method_23321();

    @Shadow
    public abstract double method_23318();

    @Shadow
    public abstract double method_23317();
}

