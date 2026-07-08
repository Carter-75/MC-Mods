/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1628
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.mim1q.derelict.mixin.entity;

import dev.mim1q.derelict.tag.ModBlockTags;
import net.minecraft.class_1628;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1628.class})
public class SpiderEntityMixin {
    @Inject(method={"slowMovement"}, at={@At(value="HEAD")}, cancellable=true)
    private void derelict$slowMovement(class_2680 state, class_243 multiplier, CallbackInfo ci) {
        if (state.method_26164(ModBlockTags.INSTANCE.getCOBWEBS())) {
            ci.cancel();
        }
    }
}

