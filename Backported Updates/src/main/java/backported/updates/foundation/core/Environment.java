/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.util.thread.ThreadExecutor
 *  net.minecraft.server.MinecraftServer
 *  org.apache.commons.lang3.tuple.Pair
 */
package backported.updates.foundation.core;

import backported.updates.foundation.core.fabric.EnvironmentImpl;
import backported.updates.foundation.core.util.config.ConfigBuilder;
import backported.updates.foundation.core.util.config.IConfigSpec;
import backported.updates.foundation.core.util.config.ModConfig;
import backported.updates.foundation.core.util.config.SimpleConfigBuilder;
import backported.updates.foundation.core.util.config.SimpleConfigSpec;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Function;
import net.minecraft.util.thread.ThreadExecutor;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.tuple.Pair;

public class Environment {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static boolean isClientSide() {
        return EnvironmentImpl.isClientSide();
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static boolean isProduction() {
        return EnvironmentImpl.isProduction();
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static boolean hasModLoaded(String modId) {
        return EnvironmentImpl.hasModLoaded(modId);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static String getModVersion(String modId) {
        return EnvironmentImpl.getModVersion(modId);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static Optional<MinecraftServer> getCurrentServer() {
        return EnvironmentImpl.getCurrentServer();
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static ThreadExecutor<?> getGameExecutor() {
        return EnvironmentImpl.getGameExecutor();
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static Path getGameDir() {
        return EnvironmentImpl.getGameDir();
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static Path getConfigDir() {
        return EnvironmentImpl.getConfigDir();
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> T registerSafeConfig(String modId, ModConfig.Type type, Function<ConfigBuilder, T> spec) {
        return EnvironmentImpl.registerSafeConfig(modId, type, spec);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> T registerSafeConfig(String modId, ModConfig.Type type, String fileName, Function<ConfigBuilder, T> spec) {
        return EnvironmentImpl.registerSafeConfig(modId, type, fileName, spec);
    }

    public static <T> T registerUnsafeConfig(String modId, ModConfig.Type type, String fileName, Function<ConfigBuilder, T> spec) {
        Pair<T, SimpleConfigSpec> pair = new SimpleConfigBuilder().configure(spec);
        new ModConfig(type, (IConfigSpec)pair.getRight(), modId, fileName);
        return (T)pair.getLeft();
    }

    public static <T> T registerUnsafeConfig(String modId, ModConfig.Type type, Function<ConfigBuilder, T> spec) {
        return Environment.registerUnsafeConfig(modId, type, Environment.defaultConfigName(type, modId), spec);
    }

    private static String defaultConfigName(ModConfig.Type type, String modId) {
        return String.format("%s-%s.toml", modId, type.extension());
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static Loader getLoader() {
        return EnvironmentImpl.getLoader();
    }

    public static boolean isForge() {
        return Environment.getLoader() == Loader.FORGE;
    }

    public static boolean isFabric() {
        return Environment.getLoader() == Loader.FABRIC;
    }

    public static enum Loader {
        FORGE,
        FABRIC;

    }
}

