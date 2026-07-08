/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.server.network.ServerPlayNetworkHandler
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ServerPlayNetworkHandler.class})
public class ServerGamePacketListenerImplMixin {
    @Shadow
    public ServerPlayerEntity player;
    @Shadow
    private int vehicleFloatingTicks;

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void vb$preventFlyingKick(CallbackInfo ci) {
        HappyGhast ghast;
        Entity vehicle = this.player.getVehicle();
        if (vehicle instanceof HappyGhast && !(ghast = (HappyGhast)vehicle).isBaby()) {
            this.vehicleFloatingTicks = 0;
        }
    }
}

