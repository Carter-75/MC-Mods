/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.foundation.sound.SoundScapes
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.simibubi.create.foundation.sound.SoundScapes;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={SoundScapes.class})
public abstract class MixinSoundScapes {
    @Redirect(method={"outOfRange"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerThan(Lnet/minecraft/core/Vec3i;D)Z"))
    private static boolean redirectCloserThan(class_2338 instance, class_2382 vec3i, double v) {
        class_243 newVec3 = new class_243((double)vec3i.method_10263(), (double)vec3i.method_10264(), (double)vec3i.method_10260());
        class_1937 world = class_310.method_1551().field_1724.method_37908();
        Ship ship = VSGameUtilsKt.getShipManagingPos(world, (class_2374)newVec3);
        if (ship != null) {
            newVec3 = VSGameUtilsKt.toWorldCoordinates(ship, newVec3);
        }
        return new class_243((double)instance.method_10263(), (double)instance.method_10264(), (double)instance.method_10260()).method_24802((class_2374)newVec3, v);
    }

    @ModifyVariable(method={"play"}, at=@At(value="HEAD"), index=1, argsOnly=true)
    private static class_2338 modBlockPos(class_2338 value) {
        class_2338 result2 = value;
        class_1937 world = class_310.method_1551().field_1724.method_37908();
        Ship ship = VSGameUtilsKt.getShipManagingPos(world, value);
        if (ship != null) {
            Vector3d tempVec = new Vector3d();
            ship.getTransform().getShipToWorld().transformPosition(value.method_10263(), value.method_10264(), value.method_10260(), tempVec);
            result2 = class_2338.method_49637((double)tempVec.x, (double)tempVec.y, (double)tempVec.z);
        }
        return result2;
    }
}

