/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_638.class})
public class ClientLevelMixin {
    @Inject(method={"addEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$addEntity(class_1297 entity, CallbackInfo ci) {
        if (EntityEvents.ON_SPAWN.invoker().onSpawn(entity, (class_1937)((class_638)this)).isCancelled()) {
            ci.cancel();
        }
    }
}

