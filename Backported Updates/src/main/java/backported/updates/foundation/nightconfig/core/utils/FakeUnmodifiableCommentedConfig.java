/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.utils;

import backported.updates.foundation.nightconfig.core.UnmodifiableCommentedConfig;
import backported.updates.foundation.nightconfig.core.UnmodifiableConfig;
import backported.updates.foundation.nightconfig.core.utils.TransformingSet;
import backported.updates.foundation.nightconfig.core.utils.UnmodifiableConfigWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class FakeUnmodifiableCommentedConfig
extends UnmodifiableConfigWrapper<UnmodifiableConfig>
implements UnmodifiableCommentedConfig {
    public FakeUnmodifiableCommentedConfig(UnmodifiableConfig config) {
        super(config);
    }

    @Override
    public String getComment(List<String> path) {
        return null;
    }

    @Override
    public boolean containsComment(List<String> path) {
        return false;
    }

    @Override
    public Map<String, UnmodifiableCommentedConfig.CommentNode> getComments() {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, String> commentMap() {
        return Collections.emptyMap();
    }

    @Override
    public Set<? extends UnmodifiableCommentedConfig.Entry> entrySet() {
        return (Set<? extends UnmodifiableCommentedConfig.Entry>)new TransformingSet<UnmodifiableConfig.Entry, FakeCommentedEntry>(this.config.entrySet(), x$0 -> new FakeCommentedEntry((UnmodifiableConfig.Entry)x$0), o -> null, o -> o);
    }

    private static final class FakeCommentedEntry
    implements UnmodifiableCommentedConfig.Entry {
        private final UnmodifiableConfig.Entry entry;

        private FakeCommentedEntry(UnmodifiableConfig.Entry entry) {
            this.entry = entry;
        }

        @Override
        public String getComment() {
            return null;
        }

        @Override
        public String getKey() {
            return this.entry.getKey();
        }

        @Override
        public <T> T getRawValue() {
            return this.entry.getRawValue();
        }
    }
}

