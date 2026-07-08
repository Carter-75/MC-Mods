/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.contraptions.actors.contraptionControls.ContraptionControlsRenderer
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.contraptions.actors.contraptionControls.ContraptionControlsRenderer;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={ContraptionControlsRenderer.class})
public abstract class MixinContraptionControlsRenderer {
    @WrapOperation(method={"renderInContraption"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D", remap=true)})
    private static double redirectDistance(class_243 from, class_243 to2, Operation<Double> original) {
        return VSGameUtilsKt.squaredDistanceBetweenInclShips((class_1937)class_310.method_1551().field_1687, from, to2, original);
    }
}

