/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_757
 *  net.minecraft.class_761
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.client.renderer;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3959;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_757;
import net.minecraft.class_761;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.mod.client.IVSCamera;
import org.valkyrienskies.mod.common.IShipObjectWorldClientProvider;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.ShipMountedToData;
import org.valkyrienskies.mod.common.util.EntityDragger;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.world.RaycastUtilsKt;
import org.valkyrienskies.mod.mixinducks.client.MinecraftDuck;

@Mixin(value={class_757.class})
public abstract class MixinGameRenderer {
    @Shadow
    @Final
    private class_310 field_4015;
    @Shadow
    @Final
    private class_4184 field_18765;

    @Shadow
    protected abstract double method_3196(class_4184 var1, float var2, boolean var3);

    @Shadow
    public abstract Matrix4f method_22973(double var1);

    @Unique
    private static class_239 entityRaycastNoTransform(class_1297 entity, double maxDistance, float tickDelta, boolean includeFluids) {
        class_243 vec3d = entity.method_5836(tickDelta);
        class_243 vec3d2 = entity.method_5828(tickDelta);
        class_243 vec3d3 = vec3d.method_1031(vec3d2.field_1352 * maxDistance, vec3d2.field_1351 * maxDistance, vec3d2.field_1350 * maxDistance);
        return RaycastUtilsKt.clipIncludeShips(entity.method_37908(), new class_3959(vec3d, vec3d3, class_3959.class_3960.field_17559, includeFluids ? class_3959.class_242.field_1347 : class_3959.class_242.field_1348, entity), false);
    }

    @WrapOperation(method={"pick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;pick(DFZ)Lnet/minecraft/world/phys/HitResult;")})
    public class_239 modifyCrosshairTargetBlocks(class_1297 receiver, double maxDistance, float tickDelta, boolean includeFluids, Operation<class_239> pick) {
        class_239 original = MixinGameRenderer.entityRaycastNoTransform(receiver, maxDistance, tickDelta, includeFluids);
        ((MinecraftDuck)this.field_4015).vs$setOriginalCrosshairTarget(original);
        return (class_239)pick.call(new Object[]{receiver, maxDistance, Float.valueOf(tickDelta), includeFluids});
    }

    @WrapOperation(method={"pick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D")})
    public double correctDistanceChecks(class_243 instance, class_243 vec3, Operation<Double> original) {
        return VSGameUtilsKt.squaredDistanceBetweenInclShips((class_1937)this.field_4015.field_1687, instance, vec3, original);
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void preRender(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        class_638 clientWorld = this.field_4015.field_1687;
        if (clientWorld != null) {
            VsiClientShipWorld shipWorld = ((IShipObjectWorldClientProvider)IShipObjectWorldClientProvider.class.cast(this.field_4015)).getShipObjectWorld();
            if (shipWorld == null) {
                return;
            }
            shipWorld.updateRenderTransforms(tickDelta);
            for (class_1297 entity : clientWorld.method_18112()) {
                ClientShip shipObject;
                if (!EntityDragger.isDraggable(entity)) continue;
                Vector3d entityShouldBeHere = null;
                ShipMountedToData shipMountedToData = VSGameUtilsKt.getShipMountedToData(entity, Float.valueOf(tickDelta));
                if (shipMountedToData != null) {
                    ClientShip shipMountedTo = (ClientShip)shipMountedToData.getShipMountedTo();
                    Vector3dc passengerPos = shipMountedToData.getMountPosInShip();
                    entityShouldBeHere = shipMountedTo.getRenderTransform().getShipToWorld().transformPosition(passengerPos, new Vector3d());
                    entity.method_5814(entityShouldBeHere.x(), entityShouldBeHere.y(), entityShouldBeHere.z());
                    entity.field_6014 = entityShouldBeHere.x();
                    entity.field_6036 = entityShouldBeHere.y();
                    entity.field_5969 = entityShouldBeHere.z();
                    entity.field_6038 = entityShouldBeHere.x();
                    entity.field_5971 = entityShouldBeHere.y();
                    entity.field_5989 = entityShouldBeHere.z();
                    continue;
                }
                EntityDraggingInformation entityDraggingInformation = ((IEntityDraggingInformationProvider)entity).getDraggingInformation();
                Long lastShipStoodOn = entityDraggingInformation.getLastShipStoodOn();
                if (lastShipStoodOn != null && entityDraggingInformation.isEntityBeingDraggedByAShip() && (shipObject = (ClientShip)VSGameUtilsKt.getShipObjectWorld(clientWorld).getLoadedShips().getById(lastShipStoodOn)) != null) {
                    entityDraggingInformation.setCachedLastPosition(new Vector3d(entity.field_6014, entity.field_6036, entity.field_5969));
                    entityDraggingInformation.setRestoreCachedLastPosition(true);
                    Vector3dc entityAddedVelocity = entityDraggingInformation.getAddedMovementLastTick();
                    double entityMovementX = entity.method_23317() - entityAddedVelocity.x() - entity.field_6014;
                    double entityMovementY = entity.method_23318() - entityAddedVelocity.y() - entity.field_6036;
                    double entityMovementZ = entity.method_23321() - entityAddedVelocity.z() - entity.field_5969;
                    Vector3d entityShouldBeHerePreTransform = new Vector3d(entity.field_6014 + entityMovementX * (double)tickDelta, entity.field_6036 + entityMovementY * (double)tickDelta, entity.field_5969 + entityMovementZ * (double)tickDelta);
                    entityShouldBeHere = shipObject.getRenderTransform().getShipToWorldMatrix().transformPosition(shipObject.getPrevTickShipTransform().getWorldToShipMatrix().transformPosition(entityShouldBeHerePreTransform, new Vector3d()));
                }
                if (entityShouldBeHere == null || !((double)tickDelta < 0.99999)) continue;
                entity.field_6014 = (entityShouldBeHere.x() - entity.method_23317() * (double)tickDelta) / (1.0 - (double)tickDelta);
                entity.field_6036 = (entityShouldBeHere.y() - entity.method_23318() * (double)tickDelta) / (1.0 - (double)tickDelta);
                entity.field_5969 = (entityShouldBeHere.z() - entity.method_23321() * (double)tickDelta) / (1.0 - (double)tickDelta);
            }
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void postRender(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        class_638 clientWorld = this.field_4015.field_1687;
        if (clientWorld != null) {
            for (class_1297 entity : clientWorld.method_18112()) {
                EntityDraggingInformation vsEntity = ((IEntityDraggingInformationProvider)entity).getDraggingInformation();
                if (!vsEntity.getRestoreCachedLastPosition()) continue;
                vsEntity.setRestoreCachedLastPosition(false);
                Vector3dc cachedLastPosition = vsEntity.getCachedLastPosition();
                if (cachedLastPosition != null) {
                    entity.field_6014 = cachedLastPosition.x();
                    entity.field_6036 = cachedLastPosition.y();
                    entity.field_5969 = cachedLastPosition.z();
                    continue;
                }
                System.err.println("How was cachedLastPosition was null?");
            }
        }
    }

    @WrapOperation(method={"renderLevel"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/LevelRenderer;prepareCullFrustum(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/phys/Vec3;Lorg/joml/Matrix4f;)V")})
    private void setupCameraWithMountedShip(class_761 instance, class_4587 ignore, class_243 vec3, Matrix4f matrix4f, Operation<Void> prepareCullFrustum, float partialTicks, long finishTimeNano, class_4587 matrixStack) {
        class_638 clientLevel = this.field_4015.field_1687;
        class_746 player = this.field_4015.field_1724;
        if (clientLevel == null || player == null) {
            prepareCullFrustum.call(new Object[]{instance, matrixStack, vec3, matrix4f});
            return;
        }
        ShipMountedToData shipMountedToData = VSGameUtilsKt.getShipMountedToData((class_1297)player, Float.valueOf(partialTicks));
        if (shipMountedToData == null) {
            prepareCullFrustum.call(new Object[]{instance, matrixStack, vec3, matrix4f});
            return;
        }
        class_1297 playerVehicle = player.method_5854();
        if (playerVehicle == null) {
            prepareCullFrustum.call(new Object[]{instance, matrixStack, vec3, matrix4f});
            return;
        }
        class_4184 camera = this.field_18765;
        if (camera == null) {
            prepareCullFrustum.call(new Object[]{instance, matrixStack, vec3, matrix4f});
            return;
        }
        ClientShip clientShip = (ClientShip)shipMountedToData.getShipMountedTo();
        ((IVSCamera)camera).setupWithShipMounted((class_1922)this.field_4015.field_1687, (class_1297)(this.field_4015.method_1560() == null ? this.field_4015.field_1724 : this.field_4015.method_1560()), !this.field_4015.field_1690.method_31044().method_31034(), this.field_4015.field_1690.method_31044().method_31035(), partialTicks, clientShip, shipMountedToData.getMountPosInShip());
        Quaternionf invShipRenderRotation = new Quaternionf(clientShip.getRenderTransform().getShipToWorldRotation().conjugate(new Quaterniond()));
        matrixStack.method_22907(invShipRenderRotation);
        Matrix3f matrix3f = new Matrix3f(matrixStack.method_23760().method_23762());
        matrix3f.invert();
        RenderSystem.setInverseViewRotationMatrix((Matrix3f)matrix3f);
        double fov = this.method_3196(camera, partialTicks, true);
        prepareCullFrustum.call(new Object[]{instance, matrixStack, camera.method_19326(), this.method_22973(Math.max(fov, (double)((Integer)this.field_4015.field_1690.method_41808().method_41753()).intValue()))});
    }

    @ModifyReturnValue(method={"getDepthFar"}, at={@At(value="RETURN")})
    public float includeShipsIn(float originalDepth) {
        float maxDistance = originalDepth;
        for (ClientShip ship : VSGameUtilsKt.getShipObjectWorld(class_310.method_1551()).getLoadedShips()) {
            class_243 cameraPos = this.field_18765.method_19326();
            AABBdc shipAABB = ship.getRenderAABB();
            double furthestDistanceSq = 0.0;
            double dMinX = shipAABB.minX() - cameraPos.method_10216();
            double dMaxX = shipAABB.maxX() - cameraPos.method_10216();
            double dMinY = shipAABB.minY() - cameraPos.method_10214();
            double dMaxY = shipAABB.maxY() - cameraPos.method_10214();
            double dMinZ = shipAABB.minZ() - cameraPos.method_10215();
            double dMaxZ = shipAABB.maxZ() - cameraPos.method_10215();
            double furthestDist = Math.sqrt(Math.max(dMinX * dMinX, dMaxX * dMaxX) + Math.max(dMinY * dMinY, dMaxY * dMaxY) + Math.max(dMinZ * dMinZ, dMaxZ * dMaxZ));
            maxDistance = Math.max(maxDistance, (float)furthestDist);
        }
        return maxDistance;
    }
}

