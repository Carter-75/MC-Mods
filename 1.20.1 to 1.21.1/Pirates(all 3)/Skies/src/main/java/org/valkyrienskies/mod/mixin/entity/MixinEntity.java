/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_128
 *  net.minecraft.class_129
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_4738
 *  net.minecraft.class_1299
 *  net.minecraft.class_148
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3965
 *  net.minecraft.class_5539
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.entity;

import net.minecraft.class_128;
import net.minecraft.class_129;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_148;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_5539;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.ShipMountedToData;
import org.valkyrienskies.mod.common.util.EntityDragger;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.common.world.RaycastUtilsKt;

@Mixin(value={class_1297.class})
public abstract class MixinEntity
implements IEntityDraggingInformationProvider {
    @Unique
    private final EntityDraggingInformation draggingInformation = new EntityDraggingInformation();
    @Shadow
    public class_1937 field_6002;
    @Shadow
    public boolean field_6007;

    @Redirect(method={"pick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;clip(Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;"))
    public class_3965 addShipsToRaycast(class_1937 receiver, class_3959 ctx) {
        return RaycastUtilsKt.clipIncludeShips(receiver, ctx);
    }

    @Inject(at={@At(value="TAIL")}, method={"checkInsideBlocks"})
    private void afterCheckInside(CallbackInfo ci) {
        AABBd boundingBox = VectorConversionsMCKt.toJOML(this.method_5829());
        AABBd temp = new AABBd();
        for (Ship ship : VSGameUtilsKt.getShipsIntersecting(this.field_6002, boundingBox)) {
            AABBd inShipBB = boundingBox.transform(ship.getShipTransform().getWorldToShipMatrix(), temp);
            this.originalCheckInside(inShipBB);
        }
    }

    @Unique
    private void originalCheckInside(AABBd aABB) {
        class_1297 self = (class_1297)class_1297.class.cast(this);
        class_2338 blockPos = class_2338.method_49637((double)(aABB.minX + 0.001), (double)(aABB.minY + 0.001), (double)(aABB.minZ + 0.001));
        class_2338 blockPos2 = class_2338.method_49637((double)(aABB.maxX - 0.001), (double)(aABB.maxY - 0.001), (double)(aABB.maxZ - 0.001));
        class_2338.class_2339 mutableBlockPos = new class_2338.class_2339();
        if (this.field_6002.method_22343(blockPos, blockPos2)) {
            for (int i2 = blockPos.method_10263(); i2 <= blockPos2.method_10263(); ++i2) {
                for (int j2 = blockPos.method_10264(); j2 <= blockPos2.method_10264(); ++j2) {
                    for (int k2 = blockPos.method_10260(); k2 <= blockPos2.method_10260(); ++k2) {
                        mutableBlockPos.method_10103(i2, j2, k2);
                        class_2680 blockState = this.field_6002.method_8320((class_2338)mutableBlockPos);
                        try {
                            blockState.method_26178(this.field_6002, (class_2338)mutableBlockPos, self);
                            this.method_5622(blockState);
                            continue;
                        }
                        catch (Throwable var12) {
                            class_128 crashReport = class_128.method_560((Throwable)var12, (String)"Colliding entity with block");
                            class_129 crashReportCategory = crashReport.method_562("Block being collided with");
                            class_129.method_586((class_129)crashReportCategory, (class_5539)this.field_6002, (class_2338)mutableBlockPos, (class_2680)blockState);
                            throw new class_148(crashReport);
                        }
                    }
                }
            }
        }
    }

    @Inject(method={"getEyePosition(F)Lnet/minecraft/world/phys/Vec3;"}, at={@At(value="HEAD")}, cancellable=true)
    private void preGetEyePosition(float partialTicks, CallbackInfoReturnable<class_243> cir) {
        ShipMountedToData shipMountedToData = VSGameUtilsKt.getShipMountedToData((class_1297)class_1297.class.cast(this), Float.valueOf(partialTicks));
        if (shipMountedToData == null) {
            Object shipDraggedBy;
            IEntityDraggingInformationProvider dragProvider;
            class_1657 player;
            Object t = class_1297.class.cast(this);
            if (t instanceof class_1657 && (player = (class_1657)t) instanceof IEntityDraggingInformationProvider && (dragProvider = (IEntityDraggingInformationProvider)player).getDraggingInformation().isEntityBeingDraggedByAShip() && dragProvider.getDraggingInformation().getServerRelativePlayerYaw() != null && (shipDraggedBy = VSGameUtilsKt.getAllShips(this.field_6002).getById(dragProvider.getDraggingInformation().getLastShipStoodOn())) != null) {
                class_243 localEyePosition = EntityDragger.INSTANCE.serversideEyePosition((class_1297)player);
                if (!VSGameUtilsKt.isBlockInShipyard(this.field_6002, localEyePosition)) {
                    return;
                }
                ShipTransform shipTransform = shipDraggedBy instanceof ClientShip ? ((ClientShip)shipDraggedBy).getRenderTransform() : shipDraggedBy.getShipTransform();
                class_243 worldEyePosition = VectorConversionsMCKt.toMinecraft(shipTransform.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(localEyePosition)));
                cir.setReturnValue((Object)worldEyePosition);
            }
            return;
        }
        LoadedShip shipMountedTo = shipMountedToData.getShipMountedTo();
        ShipTransform shipTransform = shipMountedTo instanceof ClientShip ? ((ClientShip)shipMountedTo).getRenderTransform() : shipMountedTo.getTransform();
        Vector3d basePos = shipTransform.getShipToWorld().transformPosition(shipMountedToData.getMountPosInShip(), new Vector3d());
        Vector3d eyeRelativePos = shipTransform.getShipToWorldRotation().transform(new Vector3d(0.0, this.method_5751(), 0.0));
        class_243 newEyePos = VectorConversionsMCKt.toMinecraft(basePos.add(eyeRelativePos, new Vector3d()));
        cir.setReturnValue((Object)newEyePos);
    }

    @Inject(method={"getEyePosition()Lnet/minecraft/world/phys/Vec3;"}, at={@At(value="HEAD")}, cancellable=true)
    private void preGetEyePositionServer(CallbackInfoReturnable<class_243> cir) {
        ShipMountedToData shipMountedToData = VSGameUtilsKt.getShipMountedToData((class_1297)class_1297.class.cast(this), null);
        if (shipMountedToData == null) {
            return;
        }
        LoadedShip shipMountedTo = shipMountedToData.getShipMountedTo();
        ShipTransform shipTransform = shipMountedTo instanceof ClientShip ? ((ClientShip)shipMountedTo).getRenderTransform() : shipMountedTo.getShipTransform();
        Vector3d basePos = shipTransform.getShipToWorldMatrix().transformPosition(shipMountedToData.getMountPosInShip(), new Vector3d());
        Vector3d eyeRelativePos = shipTransform.getShipCoordinatesToWorldCoordinatesRotation().transform(new Vector3d(0.0, this.method_5751(), 0.0));
        class_243 newEyePos = VectorConversionsMCKt.toMinecraft(basePos.add(eyeRelativePos, new Vector3d()));
        cir.setReturnValue((Object)newEyePos);
    }

    @Inject(method={"calculateViewVector"}, at={@At(value="HEAD")}, cancellable=true)
    private void preCalculateViewVector(float xRot, float yRot, CallbackInfoReturnable<class_243> cir) {
        LoadedShip shipMountedTo = VSGameUtilsKt.getShipMountedTo((class_1297)class_1297.class.cast(this));
        if (shipMountedTo == null) {
            return;
        }
        float f2 = xRot * ((float)Math.PI / 180);
        float g2 = -yRot * ((float)Math.PI / 180);
        float h2 = class_3532.method_15362((float)g2);
        float i2 = class_3532.method_15374((float)g2);
        float j2 = class_3532.method_15362((float)f2);
        float k2 = class_3532.method_15374((float)f2);
        Vector3d originalViewVector = new Vector3d(i2 * j2, -k2, h2 * j2);
        ShipTransform shipTransform = shipMountedTo instanceof ClientShip ? ((ClientShip)shipMountedTo).getRenderTransform() : shipMountedTo.getTransform();
        class_243 newViewVector = VectorConversionsMCKt.toMinecraft(shipTransform.getShipToWorldRotation().transform(originalViewVector, new Vector3d()));
        cir.setReturnValue((Object)newViewVector);
    }

    @Inject(method={"shouldRender"}, at={@At(value="HEAD")}, cancellable=true)
    private void onShouldRender(double d2, double e2, double f2, CallbackInfoReturnable<Boolean> cir) {
        Object ship;
        if (this.draggingInformation.isEntityBeingDraggedByAShip() && (ship = VSGameUtilsKt.getShipObjectWorld(this.field_6002).getAllShips().getById(this.draggingInformation.getLastShipStoodOn())) != null) {
            ShipTransform shipTransform;
            ShipTransform shipTransform2 = shipTransform = ship instanceof ClientShip ? ((ClientShip)ship).getRenderTransform() : ship.getTransform();
            if (this.draggingInformation.getRelativePositionOnShip() != null) {
                Vector3d redir = shipTransform.getShipToWorld().transformPosition(this.draggingInformation.getRelativePositionOnShip(), new Vector3d());
                double distX = redir.x() - d2;
                double distY = redir.y() - e2;
                double distZ = redir.z() - f2;
                double sqrDist = distX * distX + distY * distY + distZ * distZ;
                cir.setReturnValue((Object)this.method_5640(sqrDist));
            }
        }
    }

    @Shadow
    public abstract class_238 method_5829();

    @Shadow
    protected abstract void method_5865(class_1297 var1, class_1297.class_4738 var2);

    @Shadow
    protected abstract void method_5622(class_2680 var1);

    @Shadow
    public abstract double method_23321();

    @Shadow
    public abstract double method_23318();

    @Shadow
    public abstract double method_23317();

    @Shadow
    public abstract float method_5751();

    @Shadow
    public abstract class_1299<?> method_5864();

    @Shadow
    public abstract boolean method_5640(double var1);

    @Shadow
    public abstract void method_5762(double var1, double var3, double var5);

    @Override
    @NotNull
    public EntityDraggingInformation getDraggingInformation() {
        return this.draggingInformation;
    }

    @Override
    public boolean vs$shouldDrag() {
        return true;
    }

    @Override
    public void vs$dragImmediately(Ship ship) {
        if (ship == null) {
            return;
        }
        this.draggingInformation.setLastShipStoodOn(ship.getId());
        this.draggingInformation.setShouldImpulseMovement(false);
    }
}

