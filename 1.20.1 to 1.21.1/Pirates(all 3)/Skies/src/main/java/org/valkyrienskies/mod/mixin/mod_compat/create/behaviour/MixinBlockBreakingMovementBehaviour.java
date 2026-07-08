/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.behaviour.MovementContext
 *  com.simibubi.create.content.kinetics.base.BlockBreakingMovementBehaviour
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.behaviour;

import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.kinetics.base.BlockBreakingMovementBehaviour;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={BlockBreakingMovementBehaviour.class})
public class MixinBlockBreakingMovementBehaviour {
    @Unique
    private MovementContext movementContext;

    private class_243 flatten(class_243 vec3) {
        if (vec3.field_1352 == 0.0) {
            vec3 = new class_243(0.0, vec3.field_1351, vec3.field_1350);
        }
        if (vec3.field_1351 == 0.0) {
            vec3 = new class_243(vec3.field_1352, 0.0, vec3.field_1350);
        }
        if (vec3.field_1350 == 0.0) {
            vec3 = new class_243(vec3.field_1352, vec3.field_1351, 0.0);
        }
        return vec3;
    }

    @Redirect(method={"tickBreaker"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;equals(Ljava/lang/Object;)Z"))
    private boolean redirectEquals(class_243 instance, Object vec3) {
        class_243 other = (class_243)vec3;
        other = this.flatten(other);
        instance = this.flatten(instance);
        return instance.equals((Object)other);
    }

    @Inject(method={"throwEntity"}, at={@At(value="HEAD")})
    private void injectThrowEntity(MovementContext context, class_1297 entity, CallbackInfo ci) {
        this.movementContext = context;
    }

    @Redirect(method={"throwEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"))
    private void redirectSetDeltaMovement(class_1297 instance, class_243 motion) {
        Ship ship;
        if (this.movementContext != null && VSGameUtilsKt.isBlockInShipyard(this.movementContext.world, this.movementContext.contraption.anchor) && (ship = VSGameUtilsKt.getShipManagingPos(this.movementContext.world, this.movementContext.contraption.anchor)) != null) {
            motion = VectorConversionsMCKt.toMinecraft(ship.getShipToWorld().transformDirection(VectorConversionsMCKt.toJOML(motion), new Vector3d()));
        }
        instance.method_18799(motion);
    }
}

