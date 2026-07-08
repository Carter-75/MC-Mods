/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.core.fabric;

import backported.updates.foundation.core.ParallelDispatch;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class FabricParallelDispatch
implements ParallelDispatch {
    @Override
    public CompletableFuture<Void> enqueueWork(Runnable work) {
        work.run();
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public <T> CompletableFuture<T> enqueueWork(Supplier<T> work) {
        return CompletableFuture.completedFuture(work.get());
    }
}

