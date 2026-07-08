/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.network.packet.CustomPayload
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.core.networking;

import backported.updates.foundation.core.networking.fabric.PayloadDistributorImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.network.packet.CustomPayload;
import org.jetbrains.annotations.Nullable;

public class PayloadDistributor {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToServer(CustomPayload packetPayload) {
        PayloadDistributorImpl.sendToServer(packetPayload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayer(ServerPlayerEntity player, CustomPayload payload) {
        PayloadDistributorImpl.sendToPlayer(player, payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayersInDimension(ServerWorld level, CustomPayload payload) {
        PayloadDistributorImpl.sendToPlayersInDimension(level, payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayersNear(ServerWorld level, @Nullable ServerPlayerEntity excluded, double x, double y, double z, double radius, CustomPayload payload) {
        PayloadDistributorImpl.sendToPlayersNear(level, excluded, x, y, z, radius, payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToAllPlayers(CustomPayload payload) {
        PayloadDistributorImpl.sendToAllPlayers(payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayersTrackingEntity(Entity entity, CustomPayload payload) {
        PayloadDistributorImpl.sendToPlayersTrackingEntity(entity, payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayersTrackingChunk(ServerWorld level, ChunkPos pos, CustomPayload payload) {
        PayloadDistributorImpl.sendToPlayersTrackingChunk(level, pos, payload);
    }
}

