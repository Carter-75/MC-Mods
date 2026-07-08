/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.server.network.ServerPlayerEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ServerWorld.class})
public abstract class ServerLevelMixin {
    @Inject(method={"addPlayer"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$addPlayer(ServerPlayerEntity player, CallbackInfo ci) {
        if (EntityEvents.ON_SPAWN.invoker().onSpawn((Entity)player, (World)(Object)this).isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"addEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$addEntity(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (EntityEvents.ON_SPAWN.invoker().onSpawn(entity, (World)(Object)this).isCancelled()) {
            cir.setReturnValue(false);
        }
    }
}

