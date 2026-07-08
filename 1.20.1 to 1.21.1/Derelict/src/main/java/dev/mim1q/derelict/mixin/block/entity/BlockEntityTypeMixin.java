/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_3481
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.mim1q.derelict.mixin.block.entity;

import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_3481;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2591.class})
public abstract class BlockEntityTypeMixin {
    @Inject(method={"supports"}, at={@At(value="HEAD")}, cancellable=true)
    private void derelict$supports(class_2680 state, CallbackInfoReturnable<Boolean> cir) {
        if (class_2591.field_11911.equals(this) && state.method_26164(class_3481.field_15500)) {
            cir.setReturnValue((Object)true);
        }
    }
}

