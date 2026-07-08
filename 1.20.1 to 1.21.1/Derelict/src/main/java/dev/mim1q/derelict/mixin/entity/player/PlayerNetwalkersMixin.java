/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.mim1q.derelict.mixin.entity.player;

import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.tag.ModBlockTags;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1657.class})
public abstract class PlayerNetwalkersMixin {
    @Shadow
    public abstract class_1799 method_6118(class_1304 var1);

    @Inject(method={"slowMovement"}, at={@At(value="HEAD")}, cancellable=true)
    private void derelict$slowMovement(class_2680 state, class_243 multiplier, CallbackInfo ci) {
        if (state.method_26164(ModBlockTags.INSTANCE.getCOBWEBS()) && this.method_6118(class_1304.field_6172).method_31574((class_1792)ModBlocksAndItems.INSTANCE.getNETWALKERS())) {
            ci.cancel();
        }
    }
}

