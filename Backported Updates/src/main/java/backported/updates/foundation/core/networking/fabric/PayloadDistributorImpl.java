/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.networking.v1.PlayerLookup
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.network.packet.CustomPayload
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.core.networking.fabric;

import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.networking.fabric.ClientPayloadDistributor;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;

public class PayloadDistributorImpl {
    public static void sendToServer(CustomPayload payload) {
        if (Environment.isClientSide()) {
            ClientPayloadDistributor.sendToServer(payload);
        }
    }

    public static void sendToPlayer(ServerPlayerEntity player, CustomPayload payload) {
        ServerPlayNetworking.send((ServerPlayerEntity)player, (CustomPayload)payload);
    }

    public static void sendToPlayersInDimension(ServerWorld level, CustomPayload payload) {
        PlayerLookup.world((ServerWorld)level).forEach(player -> ServerPlayNetworking.send((ServerPlayerEntity)player, (CustomPayload)payload));
    }

    public static void sendToPlayersNear(ServerWorld level, @Nullable ServerPlayerEntity excluded, double x, double y, double z, double radius, CustomPayload payload) {
        PlayerLookup.around((ServerWorld)level, (Vec3d)new Vec3d(x, y, z), (double)radius).forEach(player -> {
            if (player != excluded) {
                ServerPlayNetworking.send((ServerPlayerEntity)player, (CustomPayload)payload);
            }
        });
    }

    public static void sendToAllPlayers(CustomPayload payload) {
        Environment.getCurrentServer().ifPresent(server -> PlayerLookup.all((MinecraftServer)server).forEach(player -> ServerPlayNetworking.send((ServerPlayerEntity)player, (CustomPayload)payload)));
    }

    public static void sendToPlayersTrackingEntity(Entity entity, CustomPayload payload) {
        PlayerLookup.tracking((Entity)entity).forEach(player -> ServerPlayNetworking.send((ServerPlayerEntity)player, (CustomPayload)payload));
    }

    public static void sendToPlayersTrackingChunk(ServerWorld level, ChunkPos pos, CustomPayload payload) {
        PlayerLookup.tracking((ServerWorld)level, (ChunkPos)pos).forEach(player -> ServerPlayNetworking.send((ServerPlayerEntity)player, (CustomPayload)payload));
    }
}

