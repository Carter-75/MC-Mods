/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3244
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.fabric.mixin.server.network;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3244;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_3244.class})
public abstract class MixinServerGamePacketListenerImpl {
    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D")}, method={"handleUseItemOn"})
    private double skipDistanceCheck(class_243 instance, class_243 chunkPos, Operation<Double> getChessboardDistance) {
        return 0.0;
    }

    @WrapOperation(method={"handleInteract"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getBoundingBox()Lnet/minecraft/world/phys/AABB;")})
    class_238 getWorldAABB(class_1297 entity, Operation<class_238> getAABB) {
        return VSGameUtilsKt.transformAabbToWorld(entity.method_37908(), (class_238)getAABB.call(new Object[]{entity}));
    }
}

