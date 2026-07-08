/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  net.minecraft.class_1820
 *  net.minecraft.class_1829
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.mim1q.derelict.mixin.item;

import dev.mim1q.derelict.tag.ModBlockTags;
import net.minecraft.class_1799;
import net.minecraft.class_1820;
import net.minecraft.class_1829;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1820.class, class_1829.class})
public class SwordAndShearsSuitableBlocksMixin {
    @Inject(method={"isSuitableFor"}, at={@At(value="HEAD")}, cancellable=true)
    private void derelict$isSuitableFor(class_2680 state, CallbackInfoReturnable<Boolean> cir) {
        if (state.method_26164(ModBlockTags.INSTANCE.getCOBWEBS())) {
            cir.setReturnValue((Object)true);
        }
    }

    @Inject(method={"getMiningSpeedMultiplier"}, at={@At(value="HEAD")}, cancellable=true)
    private void derelict$getMiningSpeedMultiplier(class_1799 stack, class_2680 state, CallbackInfoReturnable<Float> cir) {
        if (state.method_26164(ModBlockTags.INSTANCE.getCOBWEBS())) {
            cir.setReturnValue((Object)Float.valueOf(15.0f));
        }
    }
}

