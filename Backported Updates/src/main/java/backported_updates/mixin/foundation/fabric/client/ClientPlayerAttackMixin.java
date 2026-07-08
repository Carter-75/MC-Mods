/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.damage.DamageSource
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ClientPlayerEntity.class, OtherClientPlayerEntity.class})
public class ClientPlayerAttackMixin {
    @Inject(method={"damage"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$onAttack(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (EntityEvents.ON_ATTACK.invoker().onAttack((Entity)(PlayerEntity)(Object)this, source).isCancelled()) {
            cir.setReturnValue(false);
        }
    }
}

