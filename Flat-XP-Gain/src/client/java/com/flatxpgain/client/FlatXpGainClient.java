package com.flatxpgain.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import com.flatxpgain.FlatXpGain;
import com.flatxpgain.config.ModConfig;
import com.flatxpgain.network.ConfigSyncPayload;

public class FlatXpGainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(ConfigSyncPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                ModConfig serverConfig = new ModConfig();
                serverConfig.modEnabled = payload.modEnabled();
                serverConfig.flatXpEnabled = payload.flatXpEnabled();
                serverConfig.linearXpEnabled = payload.linearXpEnabled();
                serverConfig.level1XpCost = payload.level1XpCost();
                serverConfig.nextXpAddition = payload.nextXpAddition();
                FlatXpGain.SERVER_CONFIG = serverConfig;
            });
        });

        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            FlatXpGain.SERVER_CONFIG = null;
        });
    }
}
