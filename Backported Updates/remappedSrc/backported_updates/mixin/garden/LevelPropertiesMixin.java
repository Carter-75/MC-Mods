/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Lifecycle
 *  net.minecraft.class_31
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.garden;

import com.mojang.serialization.Lifecycle;
import net.minecraft.class_31;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_31.class})
public class LevelPropertiesMixin {
    @Shadow
    @Final
    private Lifecycle field_25426;

    @Inject(method={"getLifecycle()Lcom/mojang/serialization/Lifecycle;"}, at={@At(value="HEAD")}, cancellable=true)
    private void getLifecycle(CallbackInfoReturnable<Lifecycle> callbackInfoReturnable) {
        if (this.field_25426 == Lifecycle.experimental()) {
            callbackInfoReturnable.setReturnValue((Object)Lifecycle.stable());
            callbackInfoReturnable.cancel();
        }
    }
}

