/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1309.class})
public class LivingEntityMixin {
    @Inject(method={"hurt"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$onAttack(class_1282 source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (this instanceof class_1657) {
            return;
        }
        if (EntityEvents.ON_ATTACK.invoker().onAttack((class_1297)((class_1309)this), source).isCancelled()) {
            cir.setReturnValue((Object)false);
        }
    }
}

