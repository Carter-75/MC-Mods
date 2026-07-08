/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_745
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_745;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_746.class, class_745.class})
public class ClientPlayerAttackMixin {
    @Inject(method={"hurt"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$onAttack(class_1282 source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (EntityEvents.ON_ATTACK.invoker().onAttack((class_1297)((class_1657)this), source).isCancelled()) {
            cir.setReturnValue((Object)false);
        }
    }
}

