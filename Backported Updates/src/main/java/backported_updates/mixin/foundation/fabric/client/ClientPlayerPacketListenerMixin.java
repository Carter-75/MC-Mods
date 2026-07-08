/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.packet.s2c.play.GameJoinS2CPacket
 *  net.minecraft.network.packet.s2c.play.PlayerRespawnS2CPacket
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.ClientCommonNetworkHandler
 *  net.minecraft.client.network.ClientConnectionState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.LocalPlayerEvents;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerRespawnS2CPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.client.network.ClientConnectionState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ClientPlayNetworkHandler.class})
public abstract class ClientPlayerPacketListenerMixin
extends ClientCommonNetworkHandler {
    @Unique
    private ClientPlayerEntity oldPlayer;

    protected ClientPlayerPacketListenerMixin(MinecraftClient minecraft, ClientConnection connection, ClientConnectionState commonListenerCookie) {
        super(minecraft, connection, commonListenerCookie);
    }

    @Inject(method={"onGameJoin"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/option/GameOptions;setServerViewDistance(I)V", shift=At.Shift.AFTER)})
    private void platform$handleLogin(GameJoinS2CPacket packet, CallbackInfo ci) {
        LocalPlayerEvents.ON_LOGIN.invoker().onLogin(this.client.player);
    }

    @Inject(method={"onPlayerRespawn"}, at={@At(value="HEAD")})
    private void platform$captureOldPlayer(PlayerRespawnS2CPacket packet, CallbackInfo ci) {
        this.oldPlayer = this.client.player;
    }

    @Inject(method={"onPlayerRespawn"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/world/ClientWorld;addEntity(Lnet/minecraft/entity/Entity;)V")})
    private void platform$handleRespawn(PlayerRespawnS2CPacket packet, CallbackInfo ci) {
        LocalPlayerEvents.ON_RESPAWN.invoker().onRespawn(this.oldPlayer, this.client.player);
        this.oldPlayer = null;
    }
}

