/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.github.fabricators_of_create.porting_lib.block.CullingBlockEntityIterator
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_310
 *  net.minecraft.class_4604
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.fabric.mixin.compat.create.client;

import io.github.fabricators_of_create.porting_lib.block.CullingBlockEntityIterator;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_310;
import net.minecraft.class_4604;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={CullingBlockEntityIterator.class})
public abstract class MixinCullingBlockEntityIterator {
    @Redirect(method={"nextCulled"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/culling/Frustum;isVisible(Lnet/minecraft/world/phys/AABB;)Z"))
    private boolean inject(class_4604 instance, class_238 arg) {
        class_238 newAABB = arg;
        class_638 level = class_310.method_1551().field_1687;
        if (level != null) {
            newAABB = VSGameUtilsKt.transformAabbToWorld((class_1937)level, arg);
        }
        return instance.method_23093(newAABB);
    }
}

