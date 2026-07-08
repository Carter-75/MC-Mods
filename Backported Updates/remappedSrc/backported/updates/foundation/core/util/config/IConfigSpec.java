/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.core.util.config;

import backported.updates.foundation.nightconfig.core.CommentedConfig;
import backported.updates.foundation.nightconfig.core.UnmodifiableConfig;

public interface IConfigSpec<T extends IConfigSpec<T>>
extends UnmodifiableConfig {
    default public T self() {
        return (T)this;
    }

    public void setConfig(CommentedConfig var1);

    public boolean isCorrecting();

    public boolean isCorrect(CommentedConfig var1);

    public int correct(CommentedConfig var1);

    public void afterReload();
}

