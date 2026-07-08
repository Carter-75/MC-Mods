package com.flatxpgain;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import com.flatxpgain.config.ModConfig;
import com.flatxpgain.network.ConfigSyncPayload;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlatXpGain implements ModInitializer {
    public static final String MOD_ID = "flat_xp_gain";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static ModConfig CONFIG;
    public static ModConfig SERVER_CONFIG = null;

    public static ModConfig getActiveConfig() {
        return SERVER_CONFIG != null ? SERVER_CONFIG : CONFIG;
    }

    @Override
    public void onInitialize() {
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        
        PayloadTypeRegistry.clientboundPlay().register(ConfigSyncPayload.ID, ConfigSyncPayload.CODEC);

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ConfigSyncPayload payload = new ConfigSyncPayload(
                CONFIG.modEnabled, CONFIG.flatXpEnabled, CONFIG.linearXpEnabled, CONFIG.level1XpCost, CONFIG.nextXpAddition
            );
            ServerPlayNetworking.send(handler.getPlayer(), payload);
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(Commands.literal("flatxpgain")
                .then(Commands.literal("reload")
                    .executes(context -> {
                        AutoConfig.getConfigHolder(ModConfig.class).load();
                        CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
                        
                        ConfigSyncPayload payload = new ConfigSyncPayload(
                            CONFIG.modEnabled, CONFIG.flatXpEnabled, CONFIG.linearXpEnabled, CONFIG.level1XpCost, CONFIG.nextXpAddition
                        );
                        for (ServerPlayer player : context.getSource().getServer().getPlayerList().getPlayers()) {
                            ServerPlayNetworking.send(player, payload);
                        }

                        context.getSource().sendSuccess(() -> Component.literal("Flat XP Gain config reloaded and synced!"), false);
                        return 1;
                    })
                )
            );
        });

        LOGGER.info("Flat XP Gain initialized.");
    }
}
