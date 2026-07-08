/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  li.cil.tis3d.common.entity.InfraredPacketEntity
 *  li.cil.tis3d.util.Raytracing$CollisionDetector
 *  net.minecraft.class_1937
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.tis3d;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import li.cil.tis3d.common.entity.InfraredPacketEntity;
import li.cil.tis3d.util.Raytracing;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3959;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.world.RaycastUtilsKt;
import org.valkyrienskies.mod.compat.tis3d.Tis3dClipContext;

@Pseudo
@Mixin(value={InfraredPacketEntity.class})
public class MixinInfraredPacketEntity {
    @WrapOperation(method={"checkCollision()Lnet/minecraft/world/phys/HitResult;"}, at={@At(value="INVOKE", target="li/cil/tis3d/util/Raytracing.raytrace (Lnet/minecraft/world/level/Level;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lli/cil/tis3d/util/Raytracing$CollisionDetector;)Lnet/minecraft/world/phys/HitResult;")})
    private class_239 vs$raytrace(class_1937 level, class_243 start, class_243 target, Raytracing.CollisionDetector collisionDetector, Operation<class_239> orig) {
        return RaycastUtilsKt.clipIncludeShips(level, new Tis3dClipContext(start, target, class_3959.class_3960.field_23142, class_3959.class_242.field_1347, null));
    }
}

