/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_3222
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_3222;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1309.class, class_1657.class, class_3222.class})
public class LivingDeathMixin {
    @Inject(method={"die"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$onDeath(class_1282 source, CallbackInfo ci) {
        if (EntityEvents.ON_REMOVE.invoker().onRemove((class_1297)((class_1309)this), source).isCancelled()) {
            ci.cancel();
        }
        if (!EntityEvents.ON_DEATH.invoker().onDeath((class_1297)((class_1309)this), source)) {
            ci.cancel();
        }
    }
}

