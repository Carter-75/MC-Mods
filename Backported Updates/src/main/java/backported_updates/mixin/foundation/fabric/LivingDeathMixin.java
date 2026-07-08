/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.damage.DamageSource
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.server.network.ServerPlayerEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LivingEntity.class, PlayerEntity.class, ServerPlayerEntity.class})
public class LivingDeathMixin {
    @Inject(method={"onDeath"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$onDeath(DamageSource source, CallbackInfo ci) {
        if (EntityEvents.ON_REMOVE.invoker().onRemove((Entity)(LivingEntity)(Object)this, source).isCancelled()) {
            ci.cancel();
        }
        if (!EntityEvents.ON_DEATH.invoker().onDeath((Entity)(LivingEntity)(Object)this, source)) {
            ci.cancel();
        }
    }
}

