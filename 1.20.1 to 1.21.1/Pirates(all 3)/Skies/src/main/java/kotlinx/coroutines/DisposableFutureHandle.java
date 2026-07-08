/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/DisposableFutureHandle;", "Lkotlinx/coroutines/DisposableHandle;", "", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/util/concurrent/Future;", "future", "Ljava/util/concurrent/Future;", "<init>", "(Ljava/util/concurrent/Future;)V", "kotlinx-coroutines-core"})
final class DisposableFutureHandle
implements DisposableHandle {
    @NotNull
    private final Future<?> future;

    public DisposableFutureHandle(@NotNull Future<?> future) {
        this.future = future;
    }

    @Override
    public void dispose() {
        this.future.cancel(false);
    }

    @NotNull
    public String toString() {
        return "DisposableFutureHandle[" + this.future + ']';
    }
}

