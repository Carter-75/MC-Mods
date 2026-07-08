/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 *  net.minecraft.client.world.ClientWorld
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ClientWorld.class})
public class ClientLevelMixin {
    @Inject(method={"addEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$addEntity(Entity entity, CallbackInfo ci) {
        if (EntityEvents.ON_SPAWN.invoker().onSpawn(entity, (World)(Object)this).isCancelled()) {
            ci.cancel();
        }
    }
}

