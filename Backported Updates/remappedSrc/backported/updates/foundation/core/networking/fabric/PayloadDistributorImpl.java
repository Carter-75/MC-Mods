/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.networking.v1.PlayerLookup
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.minecraft.class_1297
 *  net.minecraft.class_1923
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_8710
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.core.networking.fabric;

import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.networking.fabric.ClientPayloadDistributor;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1297;
import net.minecraft.class_1923;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_8710;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;

public class PayloadDistributorImpl {
    public static void sendToServer(class_8710 payload) {
        if (Environment.isClientSide()) {
            ClientPayloadDistributor.sendToServer(payload);
        }
    }

    public static void sendToPlayer(class_3222 player, class_8710 payload) {
        ServerPlayNetworking.send((class_3222)player, (class_8710)payload);
    }

    public static void sendToPlayersInDimension(class_3218 level, class_8710 payload) {
        PlayerLookup.world((class_3218)level).forEach(player -> ServerPlayNetworking.send((class_3222)player, (class_8710)payload));
    }

    public static void sendToPlayersNear(class_3218 level, @Nullable class_3222 excluded, double x, double y, double z, double radius, class_8710 payload) {
        PlayerLookup.around((class_3218)level, (class_243)new class_243(x, y, z), (double)radius).forEach(player -> {
            if (player != excluded) {
                ServerPlayNetworking.send((class_3222)player, (class_8710)payload);
            }
        });
    }

    public static void sendToAllPlayers(class_8710 payload) {
        Environment.getCurrentServer().ifPresent(server -> PlayerLookup.all((MinecraftServer)server).forEach(player -> ServerPlayNetworking.send((class_3222)player, (class_8710)payload)));
    }

    public static void sendToPlayersTrackingEntity(class_1297 entity, class_8710 payload) {
        PlayerLookup.tracking((class_1297)entity).forEach(player -> ServerPlayNetworking.send((class_3222)player, (class_8710)payload));
    }

    public static void sendToPlayersTrackingChunk(class_3218 level, class_1923 pos, class_8710 payload) {
        PlayerLookup.tracking((class_3218)level, (class_1923)pos).forEach(player -> ServerPlayNetworking.send((class_3222)player, (class_8710)payload));
    }
}

