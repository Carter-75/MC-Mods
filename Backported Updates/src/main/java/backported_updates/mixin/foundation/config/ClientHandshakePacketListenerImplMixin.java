/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.s2c.login.LoginQueryRequestS2CPacket
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientLoginNetworkHandler
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.config;

import backported.updates.foundation.core.util.config.ConfigTracker;
import net.minecraft.network.packet.s2c.login.LoginQueryRequestS2CPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientLoginNetworkHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ClientLoginNetworkHandler.class})
public class ClientHandshakePacketListenerImplMixin {
    @Shadow
    @Final
    private MinecraftClient client;
    @Unique
    private boolean hasLoadedConfigs;

    @Inject(method={"onQueryRequest"}, at={@At(value="HEAD")})
    public void handleCustomQuery(LoginQueryRequestS2CPacket packet, CallbackInfo ci) {
        if (!this.hasLoadedConfigs && !this.client.isIntegratedServerRunning()) {
            ConfigTracker.INSTANCE.loadDefaultServerConfigs();
            this.hasLoadedConfigs = true;
        }
    }
}

