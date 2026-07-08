/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2478
 *  net.minecraft.class_2551
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_7713
 *  net.minecraft.class_7715
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.common;

import net.minecraft.class_2478;
import net.minecraft.class_2551;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_7713;
import net.minecraft.class_7715;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2591.class})
public class BlockEntityTypeMixin {
    @Inject(method={"isValid"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$isValid(class_2680 state, CallbackInfoReturnable<Boolean> cir) {
        if (class_2591.field_11911.equals(this) && (state.method_26204() instanceof class_2478 || state.method_26204() instanceof class_2551)) {
            cir.setReturnValue((Object)true);
        }
        if (class_2591.field_40330.equals(this) && (state.method_26204() instanceof class_7713 || state.method_26204() instanceof class_7715)) {
            cir.setReturnValue((Object)true);
        }
    }
}

