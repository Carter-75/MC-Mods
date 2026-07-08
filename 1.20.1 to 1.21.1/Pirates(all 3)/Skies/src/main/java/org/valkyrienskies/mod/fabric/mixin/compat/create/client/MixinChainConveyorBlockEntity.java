/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.api.contraption.transformable.TransformableBlockEntity
 *  com.simibubi.create.content.kinetics.base.KineticBlockEntity
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorPackage$ChainConveyorPackagePhysicsData
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.fabric.mixin.compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.api.contraption.transformable.TransformableBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorPackage;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ChainConveyorBlockEntity.class})
public abstract class MixinChainConveyorBlockEntity
extends KineticBlockEntity
implements TransformableBlockEntity {
    @Unique
    private ClientShip vs$ship;
    @Unique
    private Vector3dc vs$shipPrevVelocity;
    @Unique
    private Vector3dc vs$shipCurrentVelocity;
    @Unique
    private Vector3dc vs$shipPrevOmega;
    @Unique
    private Vector3dc vs$shipCurrentOmega;
    @Unique
    private ShipTransform vs$shipPrevTransform;

    private MixinChainConveyorBlockEntity(class_2591<?> typeIn, class_2338 pos, class_2680 state) {
        super(typeIn, pos, state);
    }

    @Inject(method={"tickBoxVisuals()V"}, at={@At(value="HEAD")}, remap=false)
    private void getShipVelocity(CallbackInfo ci) {
        this.vs$ship = VSClientGameUtils.getClientShip(this.field_11867.method_10263(), this.field_11867.method_10264(), this.field_11867.method_10260());
        if (this.vs$ship != null) {
            this.vs$shipCurrentVelocity = this.vs$ship.getVelocity();
            this.vs$shipCurrentOmega = new Vector3d(this.vs$ship.getOmega());
        } else {
            this.vs$shipCurrentVelocity = null;
            this.vs$shipCurrentOmega = null;
        }
    }

    @WrapOperation(method={"tickBoxVisuals(Lcom/simibubi/create/content/kinetics/chainConveyor/ChainConveyorPackage;)V"}, at={@At(value="FIELD", target="Lcom/simibubi/create/content/kinetics/chainConveyor/ChainConveyorPackage$ChainConveyorPackagePhysicsData;motion:Lnet/minecraft/world/phys/Vec3;", opcode=181, remap=true)}, remap=false)
    private void adjustToShipAcceleration(ChainConveyorPackage.ChainConveyorPackagePhysicsData instance, class_243 value, Operation<Void> original) {
        if (this.vs$ship != null && this.vs$shipPrevVelocity != null && this.vs$shipCurrentVelocity != null) {
            Vector3d radius = this.vs$ship.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(instance.pos)).sub(this.vs$ship.getTransform().getPositionInWorld());
            Vector3d prevRadius = this.vs$shipPrevTransform.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(instance.prevPos)).sub(this.vs$shipPrevTransform.getPositionInWorld());
            Vector3d acceleration = new Vector3d(this.vs$shipCurrentVelocity).add(this.vs$shipCurrentOmega.cross(radius, new Vector3d()));
            acceleration.sub(new Vector3d(this.vs$shipPrevVelocity).add(this.vs$shipPrevOmega.cross(prevRadius, new Vector3d())));
            this.vs$ship.getWorldToShip().transformDirection(acceleration);
            if (acceleration.length() > 3.0) {
                acceleration.normalize().mul(3.0);
            }
            original.call(new Object[]{instance, value.method_1019(VectorConversionsMCKt.toMinecraft(acceleration).method_1021(-0.2))});
        } else {
            original.call(new Object[]{instance, value});
        }
    }

    @Inject(method={"tickBoxVisuals()V"}, at={@At(value="TAIL")}, remap=false)
    private void updatePrevVelocity(CallbackInfo ci) {
        this.vs$shipPrevVelocity = this.vs$shipCurrentVelocity;
        this.vs$shipPrevOmega = this.vs$shipCurrentOmega;
        if (this.vs$ship != null) {
            this.vs$shipPrevTransform = this.vs$ship.getTransform();
        }
    }
}

