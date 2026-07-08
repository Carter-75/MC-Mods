/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.util.thread.ThreadExecutor
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.server.MinecraftServer
 *  org.apache.commons.lang3.tuple.Pair
 */
package backported.updates.foundation.core.fabric;

import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.util.config.ConfigBuilder;
import backported.updates.foundation.core.util.config.IConfigSpec;
import backported.updates.foundation.core.util.config.ModConfig;
import backported.updates.foundation.core.util.config.SimpleConfigBuilder;
import backported.updates.foundation.core.util.config.SimpleConfigSpec;
import backported.updates.foundation.fabric.PlatformFabric;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.thread.ThreadExecutor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.tuple.Pair;

public class EnvironmentImpl {
    private static final Supplier<Supplier<ThreadExecutor<?>>> CLIENT_EXECUTOR = () -> MinecraftClient::getInstance;

    public static boolean isClientSide() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    public static boolean isProduction() {
        return !FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    public static boolean hasModLoaded(String modId) {
        Objects.requireNonNull(modId, "Mod ID cannot be null");
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    public static String getModVersion(String modId) {
        Objects.requireNonNull(modId, "Mod ID cannot be null");
        return FabricLoader.getInstance().getModContainer(modId).map(container -> container.getMetadata().getVersion().toString()).orElse(null);
    }

    public static Optional<MinecraftServer> getCurrentServer() {
        return Optional.ofNullable(PlatformFabric.getServer());
    }

    public static ThreadExecutor<?> getGameExecutor() {
        if (Environment.isClientSide()) {
            return CLIENT_EXECUTOR.get().get();
        }
        return (ThreadExecutor)Environment.getCurrentServer().orElseThrow(() -> new IllegalStateException("No server available"));
    }

    public static Path getGameDir() {
        return FabricLoader.getInstance().getGameDir();
    }

    public static Path getConfigDir() {
        return FabricLoader.getInstance().getConfigDir();
    }

    public static <T> T registerSafeConfig(String modId, ModConfig.Type type, String fileName, Function<ConfigBuilder, T> spec) {
        Pair<T, SimpleConfigSpec> pair = new SimpleConfigBuilder().configure(spec);
        new ModConfig(type, (IConfigSpec)pair.getRight(), modId, fileName);
        return (T)pair.getLeft();
    }

    public static <T> T registerSafeConfig(String modId, ModConfig.Type type, Function<ConfigBuilder, T> spec) {
        return EnvironmentImpl.registerSafeConfig(modId, type, EnvironmentImpl.defaultConfigName(type, modId), spec);
    }

    private static String defaultConfigName(ModConfig.Type type, String modId) {
        return String.format("%s-%s.toml", modId, type.extension());
    }

    public static Environment.Loader getLoader() {
        return Environment.Loader.FABRIC;
    }
}

