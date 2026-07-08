/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.file;

import backported.updates.foundation.nightconfig.core.CommentedConfig;
import backported.updates.foundation.nightconfig.core.file.CommentedFileConfig;
import backported.updates.foundation.nightconfig.core.file.FileConfig;
import backported.updates.foundation.nightconfig.core.utils.CommentedConfigWrapper;
import backported.updates.foundation.nightconfig.core.utils.ObservedMap;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

final class AutosaveCommentedFileConfig
extends CommentedConfigWrapper<CommentedConfig>
implements CommentedFileConfig {
    private final FileConfig fileConfig;

    AutosaveCommentedFileConfig(CommentedConfig config, FileConfig fileConfig) {
        super(config);
        this.fileConfig = fileConfig;
    }

    @Override
    public <T> T set(List<String> path, Object value) {
        Object result = super.set(path, value);
        this.save();
        return result;
    }

    @Override
    public boolean add(List<String> path, Object value) {
        boolean result = super.add(path, value);
        this.save();
        return result;
    }

    @Override
    public <T> T remove(List<String> path) {
        Object result = super.remove(path);
        this.save();
        return result;
    }

    @Override
    public String setComment(List<String> path, String comment) {
        String result = super.setComment(path, comment);
        this.save();
        return result;
    }

    @Override
    public String removeComment(List<String> path) {
        String result = super.removeComment(path);
        this.save();
        return result;
    }

    @Override
    public Map<String, Object> valueMap() {
        return new ObservedMap<String, Object>(super.valueMap(), this::save);
    }

    @Override
    public Map<String, String> commentMap() {
        return new ObservedMap<String, String>(super.commentMap(), this::save);
    }

    @Override
    public File getFile() {
        return this.fileConfig.getFile();
    }

    @Override
    public Path getNioPath() {
        return this.fileConfig.getNioPath();
    }

    @Override
    public void save() {
        this.fileConfig.save();
    }

    @Override
    public void load() {
        this.fileConfig.load();
    }

    @Override
    public void close() {
        this.fileConfig.close();
    }
}

