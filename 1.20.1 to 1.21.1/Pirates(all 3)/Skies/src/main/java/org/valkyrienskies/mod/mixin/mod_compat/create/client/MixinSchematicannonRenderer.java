/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.llamalad7.mixinextras.sugar.ref.LocalRef
 *  com.simibubi.create.content.schematics.cannon.SchematicannonBlockEntity
 *  com.simibubi.create.content.schematics.cannon.SchematicannonRenderer
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.simibubi.create.content.schematics.cannon.SchematicannonBlockEntity;
import com.simibubi.create.content.schematics.cannon.SchematicannonRenderer;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.CompatUtil;

@Mixin(value={SchematicannonRenderer.class})
public abstract class MixinSchematicannonRenderer {
    @ModifyExpressionValue(method={"getCannonAngles"}, at={@At(value="FIELD", target="Lcom/simibubi/create/content/schematics/cannon/SchematicannonBlockEntity;previousTarget:Lnet/minecraft/core/BlockPos;")}, require=0, remap=false)
    private static class_2338 transformPreviousTargetForge(class_2338 original, @Local(argsOnly=true) SchematicannonBlockEntity blockEntity, @Local(argsOnly=true) class_2338 blockPos) {
        return original != null ? class_2338.method_49638((class_2374)CompatUtil.INSTANCE.toSameSpaceAs(blockEntity.method_10997(), original.method_46558(), blockPos)) : null;
    }

    @ModifyExpressionValue(method={"getCannonAngles"}, at={@At(value="FIELD", target="Lcom/simibubi/create/content/schematics/cannon/SchematicannonBlockEntity;previousTarget:Lnet/minecraft/core/BlockPos;")}, require=0)
    private static class_2338 transformPreviousTargetFabric(class_2338 original, @Local(argsOnly=true) SchematicannonBlockEntity blockEntity, @Local(argsOnly=true) class_2338 blockPos) {
        return original != null ? class_2338.method_49638((class_2374)CompatUtil.INSTANCE.toSameSpaceAs(blockEntity.method_10997(), original.method_46558(), blockPos)) : null;
    }

    @Inject(method={"getCannonAngles"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;subtract(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/core/BlockPos;")})
    private static void transformBlockPos(SchematicannonBlockEntity blockEntity, class_2338 pos, float partialTicks, CallbackInfoReturnable<double[]> cir, @Local(ordinal=1) LocalRef<class_2338> target) {
        target.set((Object)class_2338.method_49638((class_2374)CompatUtil.INSTANCE.toSameSpaceAs(blockEntity.method_10997(), ((class_2338)target.get()).method_46558(), pos)));
    }

    @WrapOperation(method={"renderLaunchedBlocks"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;atCenterOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;", ordinal=1)})
    private static class_243 transformTarget(class_2382 vec3i, Operation<class_243> original, @Local(argsOnly=true) SchematicannonBlockEntity blockEntity) {
        return CompatUtil.INSTANCE.toSameSpaceAs(blockEntity.method_10997(), (class_243)original.call(new Object[]{vec3i}), blockEntity.method_11016());
    }
}

