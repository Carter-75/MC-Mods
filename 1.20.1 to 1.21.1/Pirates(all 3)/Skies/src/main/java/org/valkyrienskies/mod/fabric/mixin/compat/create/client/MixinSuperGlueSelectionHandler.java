/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes
 *  com.simibubi.create.content.contraptions.glue.SuperGlueSelectionHandler
 *  com.simibubi.create.foundation.utility.RaycastHelper
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.fabric.mixin.compat.create.client;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import com.simibubi.create.content.contraptions.glue.SuperGlueSelectionHandler;
import com.simibubi.create.foundation.utility.RaycastHelper;
import java.util.Iterator;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_746;
import org.joml.Matrix4d;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.primitives.AABBic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={SuperGlueSelectionHandler.class})
public abstract class MixinSuperGlueSelectionHandler {
    @Unique
    private class_243 newTarget;

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getEyePosition()Lnet/minecraft/world/phys/Vec3;"))
    private class_243 redirectGetTraceOrigin(class_746 playerIn) {
        double range = ReachEntityAttributes.getReachDistance((class_1309)playerIn, (double)(playerIn.method_7337() ? 5.0 : 4.5));
        class_243 origin = playerIn.method_33571();
        class_243 target = RaycastHelper.getTraceTarget((class_1657)playerIn, (double)range, (class_243)origin);
        class_238 searchAABB = new class_238(origin, target).method_1009(0.25, 2.0, 0.25);
        Iterator<Ship> ships = VSGameUtilsKt.getShipsIntersecting(playerIn.method_37908(), searchAABB).iterator();
        if (ships.hasNext()) {
            Ship ship = ships.next();
            Matrix4d world2Ship = (Matrix4d)ship.getTransform().getWorldToShip();
            AABBic shAABBi = ship.getShipAABB();
            if (shAABBi != null) {
                class_238 shipAABB = new class_238((double)shAABBi.minX(), (double)shAABBi.minY(), (double)shAABBi.minZ(), (double)shAABBi.maxX(), (double)shAABBi.maxY(), (double)shAABBi.maxZ());
                origin = VectorConversionsMCKt.toMinecraft(world2Ship.transformPosition(VectorConversionsMCKt.toJOML(origin)));
                target = VectorConversionsMCKt.toMinecraft(world2Ship.transformPosition(VectorConversionsMCKt.toJOML(target)));
                Quaterniond tempQuat = new Quaterniond();
                if (playerIn.method_5854() != null && playerIn.method_5854().method_5829().method_994(shipAABB.method_1014(20.0))) {
                    ship.getTransform().getWorldToShip().getNormalizedRotation(tempQuat);
                    tempQuat.invert();
                    Vector3d offset = VectorConversionsMCKt.toJOML(target.method_1020(origin));
                    tempQuat.transform(offset);
                    target = origin.method_1019(VectorConversionsMCKt.toMinecraft(offset));
                }
            }
        }
        this.newTarget = target;
        return origin;
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/foundation/utility/RaycastHelper;getTraceTarget(Lnet/minecraft/world/entity/player/Player;DLnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;"))
    private class_243 redirectGetTraceTarget(class_1657 playerIn, double range, class_243 origin) {
        return this.newTarget;
    }
}

