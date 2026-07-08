/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.file;

import backported.updates.foundation.nightconfig.core.Config;
import backported.updates.foundation.nightconfig.core.ConfigFormat;
import backported.updates.foundation.nightconfig.core.file.AutosaveFileConfig;
import backported.updates.foundation.nightconfig.core.file.FileConfig;
import backported.updates.foundation.nightconfig.core.file.GenericBuilder;
import java.nio.file.Path;

public class FileConfigBuilder
extends GenericBuilder<Config, FileConfig> {
    FileConfigBuilder(Path file, ConfigFormat<? extends Config> format) {
        super(file, format);
    }

    @Override
    protected FileConfig buildAutosave(FileConfig chain) {
        return new AutosaveFileConfig<FileConfig>(chain);
    }

    @Override
    protected FileConfig buildNormal(FileConfig chain) {
        return chain;
    }
}

