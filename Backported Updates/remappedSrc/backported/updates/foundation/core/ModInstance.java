/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  org.jetbrains.annotations.NotNull
 */
package backported.updates.foundation.core;

import backported.updates.foundation.core.ParallelDispatch;
import backported.updates.foundation.core.fabric.ModInstanceBuilderImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.Objects;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public abstract class ModInstance {
    public final String modId;
    protected Runnable onCommon;
    protected Consumer<ParallelDispatch> onPostCommon;
    protected Runnable onClient;
    protected Consumer<ParallelDispatch> onPostClient;

    protected ModInstance(String modId, Runnable onCommon, Consumer<ParallelDispatch> onPostCommon, Runnable onClient, Consumer<ParallelDispatch> onPostClient) {
        this.modId = Objects.requireNonNull(modId, "Mod ID cannot be null");
        this.onCommon = onCommon;
        this.onPostCommon = onPostCommon;
        this.onClient = onClient;
        this.onPostClient = onPostClient;
        this.populateIfEmpty();
    }

    public static Builder create(@NotNull String modId) {
        return new Builder(modId);
    }

    public abstract void bootstrap();

    private void populateIfEmpty() {
        if (this.onCommon == null) {
            this.onCommon = () -> {};
        }
        if (this.onPostCommon == null) {
            this.onPostCommon = dispatch -> {};
        }
        if (this.onClient == null) {
            this.onClient = () -> {};
        }
        if (this.onPostClient == null) {
            this.onPostClient = dispatch -> {};
        }
    }

    public static class Builder {
        private final String modId;
        private Runnable onCommon;
        private Consumer<ParallelDispatch> onPostCommon;
        private Runnable onClient;
        private Consumer<ParallelDispatch> onPostClient;

        protected Builder(String modId) {
            this.modId = Objects.requireNonNull(modId, "Mod ID cannot be null");
        }

        public Builder common(Runnable common) {
            this.onCommon = common;
            return this;
        }

        public Builder postCommon(Consumer<ParallelDispatch> common) {
            this.onPostCommon = common;
            return this;
        }

        public Builder client(Runnable client) {
            this.onClient = client;
            return this;
        }

        public Builder postClient(Consumer<ParallelDispatch> client) {
            this.onPostClient = client;
            return this;
        }

        public ModInstance build() {
            return Builder.builder(this.modId, this.onCommon, this.onPostCommon, this.onClient, this.onPostClient);
        }

        @ExpectPlatform
        @ExpectPlatform.Transformed
        public static ModInstance builder(String modId, Runnable common, Consumer<ParallelDispatch> postCommon, Runnable client, Consumer<ParallelDispatch> postClient) {
            return ModInstanceBuilderImpl.builder(modId, common, postCommon, client, postClient);
        }
    }
}

