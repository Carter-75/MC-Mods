/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.FilenameUtils
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package backported.updates.foundation.core.util.config;

import backported.updates.foundation.core.events.ConfigEvents;
import backported.updates.foundation.core.util.config.ModConfig;
import backported.updates.foundation.nightconfig.core.CommentedConfig;
import backported.updates.foundation.nightconfig.core.ConfigFormat;
import backported.updates.foundation.nightconfig.core.file.CommentedFileConfig;
import backported.updates.foundation.nightconfig.core.file.FileWatcher;
import backported.updates.foundation.nightconfig.core.io.ParsingException;
import backported.updates.foundation.nightconfig.core.io.WritingMode;
import backported.updates.foundation.nightconfig.toml.TomlFormat;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.function.Function;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigFileTypeHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    static ConfigFileTypeHandler TOML = new ConfigFileTypeHandler();

    public static void backUpConfig(CommentedFileConfig commentedFileConfig) {
        ConfigFileTypeHandler.backUpConfig(commentedFileConfig, 5);
    }

    public static void backUpConfig(CommentedFileConfig commentedFileConfig, int maxBackups) {
        Path bakFileLocation = commentedFileConfig.getNioPath().getParent();
        String bakFileName = FilenameUtils.removeExtension((String)commentedFileConfig.getFile().getName());
        String bakFileExtension = FilenameUtils.getExtension((String)commentedFileConfig.getFile().getName()) + ".bak";
        Path bakFile = bakFileLocation.resolve(bakFileName + "-1." + bakFileExtension);
        try {
            for (int i = maxBackups; i > 0; --i) {
                Path oldBak = bakFileLocation.resolve(bakFileName + "-" + i + "." + bakFileExtension);
                if (!Files.exists(oldBak, new LinkOption[0])) continue;
                if (i >= maxBackups) {
                    Files.delete(oldBak);
                    continue;
                }
                Files.move(oldBak, bakFileLocation.resolve(bakFileName + "-" + (i + 1) + "." + bakFileExtension), new CopyOption[0]);
            }
            Files.copy(commentedFileConfig.getNioPath(), bakFile, new CopyOption[0]);
        }
        catch (IOException exception) {
            LOGGER.warn("Failed to back up config file {}", (Object)commentedFileConfig.getNioPath(), (Object)exception);
        }
    }

    public Function<ModConfig, CommentedFileConfig> reader(Path configBasePath) {
        return config -> {
            Path configPath = configBasePath.resolve(config.getFileName());
            CommentedFileConfig configData = (CommentedFileConfig)CommentedFileConfig.builder(configPath, (ConfigFormat<? extends CommentedConfig>)TomlFormat.instance()).sync().preserveInsertionOrder().autosave().onFileNotFound(this::setupConfigFile).writingMode(WritingMode.REPLACE).build();
            LOGGER.debug("Built TOML config for {}", (Object)configPath.toString());
            try {
                configData.load();
            }
            catch (ParsingException exception) {
                throw new ConfigLoadingException((ModConfig)config, exception);
            }
            LOGGER.debug("Loaded TOML config file {}", (Object)configPath.toString());
            try {
                FileWatcher.defaultInstance().addWatch(configPath, (Runnable)new ConfigWatcher((ModConfig)config, configData, Thread.currentThread().getContextClassLoader()));
                LOGGER.debug("Watching TOML config file {} for changes", (Object)configPath.toString());
            }
            catch (IOException exception) {
                throw new RuntimeException("Couldn't watch config file", exception);
            }
            return configData;
        };
    }

    public void unload(Path configBasePath, ModConfig config) {
        Path configPath = configBasePath.resolve(config.getFileName());
        try {
            FileWatcher.defaultInstance().removeWatch(configBasePath.resolve(config.getFileName()));
        }
        catch (RuntimeException exception) {
            LOGGER.error("Failed to remove config {} from tracker!", (Object)configPath.toString(), (Object)exception);
        }
    }

    private boolean setupConfigFile(Path file, ConfigFormat<?> format) throws IOException {
        Files.createFile(file, new FileAttribute[0]);
        format.initEmptyFile(file);
        return true;
    }

    private static class ConfigLoadingException
    extends RuntimeException {
        public ConfigLoadingException(ModConfig config, Exception cause) {
            super("Failed loading config file " + config.getFileName() + " of type " + String.valueOf((Object)config.getType()) + " for modid " + config.getModId(), cause);
        }
    }

    private static class ConfigWatcher
    implements Runnable {
        private final ModConfig modConfig;
        private final CommentedFileConfig commentedFileConfig;
        private final ClassLoader realClassLoader;

        ConfigWatcher(ModConfig modConfig, CommentedFileConfig commentedFileConfig, ClassLoader classLoader) {
            this.modConfig = modConfig;
            this.commentedFileConfig = commentedFileConfig;
            this.realClassLoader = classLoader;
        }

        @Override
        public void run() {
            Thread.currentThread().setContextClassLoader(this.realClassLoader);
            if (!this.modConfig.getSpec().isCorrecting()) {
                try {
                    this.commentedFileConfig.load();
                    if (!this.modConfig.getSpec().isCorrect(this.commentedFileConfig)) {
                        LOGGER.warn("Configuration file {} is not correct. Correcting", (Object)this.commentedFileConfig.getFile().getAbsolutePath());
                        ConfigFileTypeHandler.backUpConfig(this.commentedFileConfig);
                        this.modConfig.getSpec().correct(this.commentedFileConfig);
                        this.commentedFileConfig.save();
                    }
                }
                catch (ParsingException exception) {
                    throw new ConfigLoadingException(this.modConfig, exception);
                }
                LOGGER.debug("Config file {} changed, sending notifies", (Object)this.modConfig.getFileName());
                this.modConfig.getSpec().afterReload();
                ConfigEvents.RELOADING.invoker().onModConfig(this.modConfig);
            }
        }
    }
}

