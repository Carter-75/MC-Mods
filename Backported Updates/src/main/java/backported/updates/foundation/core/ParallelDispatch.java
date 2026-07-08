/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.core;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public interface ParallelDispatch {
    public CompletableFuture<Void> enqueueWork(Runnable var1);

    public <T> CompletableFuture<T> enqueueWork(Supplier<T> var1);
}

