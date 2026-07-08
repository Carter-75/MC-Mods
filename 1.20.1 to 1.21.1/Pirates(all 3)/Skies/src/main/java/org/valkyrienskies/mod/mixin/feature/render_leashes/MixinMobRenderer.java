/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1297
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_4604
 *  net.minecraft.class_638
 *  net.minecraft.class_927
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.feature.render_leashes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1297;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_4604;
import net.minecraft.class_638;
import net.minecraft.class_927;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_927.class})
public class MixinMobRenderer {
    @WrapOperation(method={"renderLeash"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getRopeHoldPosition(F)Lnet/minecraft/world/phys/Vec3;")})
    public class_243 getRopeHoldPosition(class_1297 instance, float partialTicks, Operation<class_243> getRopeHoldPosition) {
        class_243 origVec = (class_243)getRopeHoldPosition.call(new Object[]{instance, Float.valueOf(partialTicks)});
        Vector3d vec = VectorConversionsMCKt.toJOML(origVec);
        LoadedShip ship = VSGameUtilsKt.getLoadedShipManagingPos(instance.method_37908(), (Vector3dc)vec);
        if (ship != null) {
            ship.getShipToWorld().transformPosition(vec);
            return VectorConversionsMCKt.toMinecraft(vec);
        }
        return origVec;
    }

    @Redirect(method={"shouldRender(Lnet/minecraft/world/entity/Mob;Lnet/minecraft/client/renderer/culling/Frustum;DDD)Z"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/culling/Frustum;isVisible(Lnet/minecraft/world/phys/AABB;)Z"))
    private boolean isTransformedAABBVisible(class_4604 frustum, class_238 aABB, @Local class_1297 leashHolder) {
        return frustum.method_23093(VSGameUtilsKt.transformRenderAABBToWorld((class_638)leashHolder.method_37908(), (class_2374)leashHolder.method_19538(), leashHolder.method_5830()));
    }
}

