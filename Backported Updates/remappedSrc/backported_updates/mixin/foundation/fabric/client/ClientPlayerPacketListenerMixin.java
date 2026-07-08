/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2535
 *  net.minecraft.class_2678
 *  net.minecraft.class_2724
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_746
 *  net.minecraft.class_8673
 *  net.minecraft.class_8675
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.LocalPlayerEvents;
import net.minecraft.class_2535;
import net.minecraft.class_2678;
import net.minecraft.class_2724;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;
import net.minecraft.class_8673;
import net.minecraft.class_8675;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_634.class})
public abstract class ClientPlayerPacketListenerMixin
extends class_8673 {
    @Unique
    private class_746 oldPlayer;

    protected ClientPlayerPacketListenerMixin(class_310 minecraft, class_2535 connection, class_8675 commonListenerCookie) {
        super(minecraft, connection, commonListenerCookie);
    }

    @Inject(method={"handleLogin"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/Options;setServerRenderDistance(I)V", shift=At.Shift.AFTER)})
    private void platform$handleLogin(class_2678 packet, CallbackInfo ci) {
        LocalPlayerEvents.ON_LOGIN.invoker().onLogin(this.field_45588.field_1724);
    }

    @Inject(method={"handleRespawn"}, at={@At(value="HEAD")})
    private void platform$captureOldPlayer(class_2724 packet, CallbackInfo ci) {
        this.oldPlayer = this.field_45588.field_1724;
    }

    @Inject(method={"handleRespawn"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/ClientLevel;addEntity(Lnet/minecraft/world/entity/Entity;)V")})
    private void platform$handleRespawn(class_2724 packet, CallbackInfo ci) {
        LocalPlayerEvents.ON_RESPAWN.invoker().onRespawn(this.oldPlayer, this.field_45588.field_1724);
        this.oldPlayer = null;
    }
}

