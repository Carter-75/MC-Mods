/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.kinetics.fan.AirCurrent
 *  com.simibubi.create.content.kinetics.fan.AirFlowParticle
 *  com.simibubi.create.content.kinetics.fan.IAirCurrentSource
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_4002
 *  net.minecraft.class_638
 *  net.minecraft.class_708
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.fan.AirCurrent;
import com.simibubi.create.content.kinetics.fan.AirFlowParticle;
import com.simibubi.create.content.kinetics.fan.IAirCurrentSource;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_4002;
import net.minecraft.class_638;
import net.minecraft.class_708;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.IExtendedAirCurrentSource;

@Mixin(value={AirFlowParticle.class})
public abstract class MixinAirFlowParticle
extends class_708 {
    @Shadow
    @Final
    private IAirCurrentSource source;

    protected MixinAirFlowParticle(class_638 level, double x, double y, double z, class_4002 sprites, float gravity) {
        super(level, x, y, z, sprites, gravity);
    }

    @WrapOperation(method={"<init>"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/fan/AirFlowParticle;setPos(DDD)V")})
    private void setPos(AirFlowParticle particle, double x, double y, double z, Operation<Void> original) {
        Ship ship = this.getShip();
        if (ship != null) {
            Vector3d p = new Vector3d(x, y, z);
            ship.getPrevTickTransform().getWorldToShip().transformPosition(p);
            ship.getTransform().getShipToWorld().transformPosition(p);
            original.call(new Object[]{particle, p.x, p.y, p.z});
            return;
        }
        original.call(new Object[]{particle, x, y, z});
    }

    @Unique
    private Ship getShip() {
        if (this.source == null) {
            return null;
        }
        IAirCurrentSource iAirCurrentSource = this.source;
        if (iAirCurrentSource instanceof IExtendedAirCurrentSource) {
            IExtendedAirCurrentSource se = (IExtendedAirCurrentSource)iAirCurrentSource;
            return se.getShip();
        }
        if (this.source.getAirCurrentWorld() != null) {
            return VSGameUtilsKt.getShipManagingPos(this.source.getAirCurrentWorld(), this.source.getAirCurrentPos());
        }
        return null;
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/AABB;contains(DDD)Z"))
    private boolean redirectBounds(class_238 instance, double x, double y, double z) {
        AirCurrent current = this.source.getAirCurrent();
        class_1937 level = this.source.getAirCurrentWorld();
        Ship ship = this.getShip();
        if (current != null && level != null && ship != null) {
            Vector3d tempPos = ship.getTransform().getWorldToShip().transformPosition(x, y, z, new Vector3d());
            return instance.method_1008(tempPos.x, tempPos.y, tempPos.z);
        }
        return instance.method_1008(x, y, z);
    }

    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;subtract(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;")})
    private class_243 transformPosToShip(class_243 instance, class_243 vec3, Operation<class_243> original) {
        Ship ship = this.getShip();
        if (ship != null) {
            instance = VectorConversionsMCKt.toMinecraft(ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(instance)));
        }
        return (class_243)original.call(new Object[]{instance, vec3});
    }

    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;scale(D)Lnet/minecraft/world/phys/Vec3;", ordinal=0)})
    private class_243 transformDirectionForMotion(class_243 dir, double d2, Operation<class_243> original) {
        Ship ship = this.getShip();
        if (ship != null) {
            Vector3d tempVec = new Vector3d();
            ship.getTransform().getShipToWorld().transformDirection(dir.field_1352, dir.field_1351, dir.field_1350, tempVec);
            dir = VectorConversionsMCKt.toMinecraft(tempVec);
        }
        return (class_243)original.call(new Object[]{dir, d2});
    }

    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/fan/AirFlowParticle;move(DDD)V")})
    private void moveWithShip(AirFlowParticle particle, double x, double y, double z, Operation<Void> original) {
        original.call(new Object[]{particle, x, y, z});
        Ship ship = this.getShip();
        if (ship != null) {
            Vector3d p = new Vector3d(this.field_3874, this.field_3854, this.field_3871);
            ship.getPrevTickTransform().getWorldToShip().transformPosition(p);
            ship.getTransform().getShipToWorld().transformPosition(p);
            this.field_3852 = p.x - this.field_3858;
            this.field_3869 = p.y - this.field_3838;
            this.field_3850 = p.z - this.field_3856;
            this.method_3063(p.x, p.y, p.z);
        }
    }
}

