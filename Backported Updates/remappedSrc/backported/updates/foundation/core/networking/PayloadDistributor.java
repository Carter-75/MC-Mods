/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_1297
 *  net.minecraft.class_1923
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_8710
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.core.networking;

import backported.updates.foundation.core.networking.fabric.PayloadDistributorImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.class_1297;
import net.minecraft.class_1923;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_8710;
import org.jetbrains.annotations.Nullable;

public class PayloadDistributor {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToServer(class_8710 packetPayload) {
        PayloadDistributorImpl.sendToServer(packetPayload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayer(class_3222 player, class_8710 payload) {
        PayloadDistributorImpl.sendToPlayer(player, payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayersInDimension(class_3218 level, class_8710 payload) {
        PayloadDistributorImpl.sendToPlayersInDimension(level, payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayersNear(class_3218 level, @Nullable class_3222 excluded, double x, double y, double z, double radius, class_8710 payload) {
        PayloadDistributorImpl.sendToPlayersNear(level, excluded, x, y, z, radius, payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToAllPlayers(class_8710 payload) {
        PayloadDistributorImpl.sendToAllPlayers(payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayersTrackingEntity(class_1297 entity, class_8710 payload) {
        PayloadDistributorImpl.sendToPlayersTrackingEntity(entity, payload);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void sendToPlayersTrackingChunk(class_3218 level, class_1923 pos, class_8710 payload) {
        PayloadDistributorImpl.sendToPlayersTrackingChunk(level, pos, payload);
    }
}

