/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_3218.class})
public abstract class ServerLevelMixin {
    @Inject(method={"addPlayer"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$addPlayer(class_3222 player, CallbackInfo ci) {
        if (EntityEvents.ON_SPAWN.invoker().onSpawn((class_1297)player, (class_1937)((class_3218)this)).isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"addEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$addEntity(class_1297 entity, CallbackInfoReturnable<Boolean> cir) {
        if (EntityEvents.ON_SPAWN.invoker().onSpawn(entity, (class_1937)((class_3218)this)).isCancelled()) {
            cir.setReturnValue((Object)false);
        }
    }
}

