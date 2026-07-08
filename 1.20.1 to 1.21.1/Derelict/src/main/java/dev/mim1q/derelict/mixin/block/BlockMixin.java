/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_4538
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.mim1q.derelict.mixin.block;

import dev.mim1q.derelict.init.ModBlocksAndItems;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_4538;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2248.class})
public class BlockMixin {
    @Inject(method={"sideCoversSmallSquare"}, at={@At(value="HEAD")}, cancellable=true)
    private static void derelict$sideCoversSmallSquare(class_4538 world, class_2338 pos, class_2350 side, CallbackInfoReturnable<Boolean> cir) {
        if (side == class_2350.field_11033 && world.method_8320(pos).method_27852((class_2248)ModBlocksAndItems.INSTANCE.getSPIDER_SILK_STRAND())) {
            cir.setReturnValue((Object)true);
        }
    }
}

