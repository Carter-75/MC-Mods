/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Lifecycle
 *  net.minecraft.world.level.LevelProperties
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.garden;

import com.mojang.serialization.Lifecycle;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={LevelProperties.class})
public class LevelPropertiesMixin {
    @Shadow
    @Final
    private Lifecycle lifecycle;

    @Inject(method={"getLifecycle()Lcom/mojang/serialization/Lifecycle;"}, at={@At(value="HEAD")}, cancellable=true)
    private void getLifecycle(CallbackInfoReturnable<Lifecycle> callbackInfoReturnable) {
        if (this.lifecycle == Lifecycle.experimental()) {
            callbackInfoReturnable.setReturnValue(Lifecycle.stable());
            callbackInfoReturnable.cancel();
        }
    }
}

