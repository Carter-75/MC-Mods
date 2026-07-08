/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  net.minecraft.class_3222
 *  net.minecraft.class_3898$class_3208
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.server.world;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_3222;
import net.minecraft.class_3898;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_3898.class_3208.class})
public class MixinChunkMap$TrackedEntity {
    @Shadow
    @Final
    class_1297 field_18247;
    @Unique
    private Ship inCallShip = null;

    @ModifyExpressionValue(method={"updatePlayer"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;position()Lnet/minecraft/world/phys/Vec3;")})
    class_243 includeShips(class_243 original) {
        Vector3d pos = VectorConversionsMCKt.toJOML(original);
        this.inCallShip = VSGameUtilsKt.getLoadedShipManagingPos(this.field_18247.method_37908(), (Vector3dc)pos);
        Ship ship = this.inCallShip;
        if (ship != null) {
            return VectorConversionsMCKt.toMinecraft(ship.getShipToWorld().transformPosition(pos));
        }
        return original;
    }

    @WrapOperation(method={"updatePlayer"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;broadcastToPlayer(Lnet/minecraft/server/level/ServerPlayer;)Z")})
    boolean skipWierdCheck(class_1297 instance, class_3222 serverPlayer, Operation<Boolean> broadcastToPlayer) {
        return this.inCallShip != null || (Boolean)broadcastToPlayer.call(new Object[]{instance, serverPlayer}) != false;
    }
}

