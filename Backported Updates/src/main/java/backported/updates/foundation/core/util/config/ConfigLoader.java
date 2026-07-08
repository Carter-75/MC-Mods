/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.WorldSavePath
 *  net.minecraft.server.MinecraftServer
 */
package backported.updates.foundation.core.util.config;

import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.events.ServerLifecycleEvents;
import backported.updates.foundation.core.networking.ServerListenerEvents;
import backported.updates.foundation.core.util.config.ConfigTracker;
import backported.updates.foundation.core.util.config.ModConfig;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import net.minecraft.util.WorldSavePath;
import net.minecraft.server.MinecraftServer;

public class ConfigLoader {
    static final WorldSavePath SERVERCONFIG = new WorldSavePath("serverconfig");

    private static Path getServerConfigPath(MinecraftServer server) {
        Path config = server.getSavePath(SERVERCONFIG);
        if (!Files.isDirectory(config, new LinkOption[0])) {
            try {
                Files.createDirectories(config, new FileAttribute[0]);
            }
            catch (IOException exception) {
                throw new RuntimeException("Failed to create " + String.valueOf(config), exception);
            }
        }
        return config;
    }

    public static void bootstrap() {
        ConfigTracker.INSTANCE.loadConfigs(ModConfig.Type.COMMON, Environment.getConfigDir());
        if (Environment.isClientSide()) {
            ConfigTracker.INSTANCE.loadConfigs(ModConfig.Type.CLIENT, Environment.getConfigDir());
        }
        ServerLifecycleEvents.STARTING.register(server -> ConfigTracker.INSTANCE.loadConfigs(ModConfig.Type.SERVER, ConfigLoader.getServerConfigPath(server)));
        ServerLifecycleEvents.STOPPING.register(server -> ConfigTracker.INSTANCE.unloadConfigs(ModConfig.Type.SERVER, ConfigLoader.getServerConfigPath(server)));
        ServerListenerEvents.JOIN.register((handler, server) -> ConfigTracker.INSTANCE.syncConfigs(Environment.isClientSide()));
    }
}

