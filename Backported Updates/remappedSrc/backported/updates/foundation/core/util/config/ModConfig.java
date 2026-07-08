/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.core.util.config;

import backported.updates.foundation.core.util.config.ConfigFileTypeHandler;
import backported.updates.foundation.core.util.config.ConfigTracker;
import backported.updates.foundation.core.util.config.IConfigSpec;
import backported.updates.foundation.nightconfig.core.CommentedConfig;
import backported.updates.foundation.nightconfig.core.file.FileConfig;
import java.nio.file.Path;
import java.util.Locale;

public class ModConfig {
    private final Type type;
    private final IConfigSpec<?> spec;
    private final String fileName;
    private final String modId;
    private final ConfigFileTypeHandler configHandler = ConfigFileTypeHandler.TOML;
    private CommentedConfig configData;

    public ModConfig(Type type, IConfigSpec<?> spec, String modId, String fileName) {
        this.type = type;
        this.spec = spec;
        this.fileName = fileName;
        this.modId = modId;
        ConfigTracker.INSTANCE.trackConfig(this);
    }

    public Type getType() {
        return this.type;
    }

    public String getFileName() {
        return this.fileName;
    }

    public ConfigFileTypeHandler getHandler() {
        return this.configHandler;
    }

    public <T extends IConfigSpec<T>> IConfigSpec<T> getSpec() {
        return this.spec;
    }

    public String getModId() {
        return this.modId;
    }

    public CommentedConfig getConfigData() {
        return this.configData;
    }

    void setConfigData(CommentedConfig configData) {
        this.configData = configData;
        this.spec.setConfig(this.configData);
    }

    public void save() {
        CommentedConfig commentedConfig = this.configData;
        if (commentedConfig instanceof FileConfig) {
            FileConfig config = (FileConfig)((Object)commentedConfig);
            config.save();
        }
    }

    public Path getFullPath() {
        Path path;
        CommentedConfig commentedConfig = this.configData;
        if (commentedConfig instanceof FileConfig) {
            FileConfig config = (FileConfig)((Object)commentedConfig);
            path = config.getNioPath();
        } else {
            path = null;
        }
        return path;
    }

    public static enum Type {
        COMMON,
        CLIENT,
        SERVER;


        public String extension() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }
}

