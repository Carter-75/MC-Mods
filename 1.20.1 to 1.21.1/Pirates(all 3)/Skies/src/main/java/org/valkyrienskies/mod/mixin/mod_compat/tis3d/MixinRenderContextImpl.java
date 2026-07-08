/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  li.cil.tis3d.client.renderer.RenderContextImpl
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.tis3d;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import li.cil.tis3d.client.renderer.RenderContextImpl;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Pseudo
@Mixin(value={RenderContextImpl.class})
public abstract class MixinRenderContextImpl {
    @WrapOperation(method={"closeEnoughForDetails(Lnet/minecraft/core/BlockPos;)Z"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;closerToCenterThan(Lnet/minecraft/core/Position;D)Z")})
    private boolean vs$closerToCenterThan(class_2338 instance, class_2374 pos, double dist, Operation<Boolean> orig) {
        Ship ship = VSGameUtilsKt.getShipManagingPos((class_1937)class_310.method_1551().field_1687, instance);
        if (ship != null) {
            return (Boolean)orig.call(new Object[]{instance, VectorConversionsMCKt.toMinecraft(ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(pos))), dist});
        }
        return (Boolean)orig.call(new Object[]{instance, pos, dist});
    }
}

