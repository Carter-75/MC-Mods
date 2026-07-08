/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.file;

import backported.updates.foundation.nightconfig.core.CommentedConfig;
import backported.updates.foundation.nightconfig.core.ConfigFormat;
import backported.updates.foundation.nightconfig.core.file.AutosaveCommentedFileConfig;
import backported.updates.foundation.nightconfig.core.file.CommentedFileConfig;
import backported.updates.foundation.nightconfig.core.file.FileConfig;
import backported.updates.foundation.nightconfig.core.file.GenericBuilder;
import backported.updates.foundation.nightconfig.core.file.SimpleCommentedFileConfig;
import java.nio.file.Path;

public final class CommentedFileConfigBuilder
extends GenericBuilder<CommentedConfig, CommentedFileConfig> {
    CommentedFileConfigBuilder(Path file, ConfigFormat<? extends CommentedConfig> format) {
        super(file, format);
    }

    @Override
    protected CommentedFileConfig buildAutosave(FileConfig chain) {
        return new AutosaveCommentedFileConfig((CommentedConfig)this.getConfig(), chain);
    }

    @Override
    protected CommentedFileConfig buildNormal(FileConfig chain) {
        return new SimpleCommentedFileConfig((CommentedConfig)this.getConfig(), chain);
    }
}

