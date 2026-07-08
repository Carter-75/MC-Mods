/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.file;

import backported.updates.foundation.nightconfig.core.CommentedConfig;
import backported.updates.foundation.nightconfig.core.Config;
import backported.updates.foundation.nightconfig.core.ConfigFormat;
import backported.updates.foundation.nightconfig.core.file.CommentedFileConfig;
import backported.updates.foundation.nightconfig.core.utils.CommentedConfigWrapper;
import backported.updates.foundation.nightconfig.core.utils.TransformingMap;
import backported.updates.foundation.nightconfig.core.utils.TransformingSet;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CheckedCommentedFileConfig
extends CommentedConfigWrapper<CommentedFileConfig>
implements CommentedFileConfig {
    CheckedCommentedFileConfig(CommentedFileConfig config) {
        super(config);
    }

    @Override
    public Path getNioPath() {
        return ((CommentedFileConfig)this.config).getNioPath();
    }

    @Override
    public File getFile() {
        return ((CommentedFileConfig)this.config).getFile();
    }

    @Override
    public void save() {
        ((CommentedFileConfig)this.config).save();
    }

    @Override
    public void load() {
        ((CommentedFileConfig)this.config).load();
    }

    @Override
    public void close() {
        ((CommentedFileConfig)this.config).close();
    }

    @Override
    public CommentedFileConfig checked() {
        return this;
    }

    @Override
    public <T> T set(List<String> path, Object value) {
        return super.set(path, this.checkedValue(value));
    }

    @Override
    public boolean add(List<String> path, Object value) {
        return super.add(path, this.checkedValue(value));
    }

    @Override
    public Map<String, Object> valueMap() {
        return new TransformingMap<String, Object, Object>(super.valueMap(), v -> v, this::checkedValue, o -> o);
    }

    @Override
    public Set<? extends CommentedConfig.Entry> entrySet() {
        return new TransformingSet<CommentedConfig.Entry, CommentedConfig.Entry>(super.entrySet(), v -> v, this::checkedValue, o -> o);
    }

    @Override
    public String toString() {
        return "checked of " + this.config;
    }

    private void checkValue(Object value) {
        ConfigFormat<?> format = this.configFormat();
        if (value != null && !format.supportsType(value.getClass())) {
            throw new IllegalArgumentException("Unsupported value type: " + value.getClass().getTypeName());
        }
        if (value == null && !format.supportsType(null)) {
            throw new IllegalArgumentException("Null values aren't supported by this configuration.");
        }
        if (value instanceof Config) {
            ((Config)value).valueMap().forEach((k, v) -> this.checkValue(v));
        }
    }

    private <T> T checkedValue(T value) {
        this.checkValue(value);
        return value;
    }
}

