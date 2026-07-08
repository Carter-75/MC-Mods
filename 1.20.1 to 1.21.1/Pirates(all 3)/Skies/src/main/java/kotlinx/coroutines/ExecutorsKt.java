/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatcherExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0006*\u00020\u0005H\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0000*\u00020\u0001\u00a2\u0006\u0004\b\b\u0010\t*\u0010\b\u0007\u0010\u000b\"\u00020\u00062\u00020\u0006B\u0002\b\n\u00a8\u0006\f"}, d2={"Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "from", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/CoroutineDispatcher;", "asCoroutineDispatcher", "Ljava/util/concurrent/ExecutorService;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "asExecutor", "(Lkotlinx/coroutines/CoroutineDispatcher;)Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/ExperimentalCoroutinesApi;", "CloseableCoroutineDispatcher", "kotlinx-coroutines-core"})
public final class ExecutorsKt {
    @JvmName(name="from")
    @NotNull
    public static final ExecutorCoroutineDispatcher from(@NotNull ExecutorService $this$asCoroutineDispatcher) {
        return new ExecutorCoroutineDispatcherImpl($this$asCoroutineDispatcher);
    }

    @JvmName(name="from")
    @NotNull
    public static final CoroutineDispatcher from(@NotNull Executor $this$asCoroutineDispatcher) {
        Object object = $this$asCoroutineDispatcher instanceof DispatcherExecutor ? (DispatcherExecutor)$this$asCoroutineDispatcher : null;
        if (object == null || (object = object.dispatcher) == null) {
            object = new ExecutorCoroutineDispatcherImpl($this$asCoroutineDispatcher);
        }
        return object;
    }

    @NotNull
    public static final Executor asExecutor(@NotNull CoroutineDispatcher $this$asExecutor) {
        Object object = $this$asExecutor instanceof ExecutorCoroutineDispatcher ? (ExecutorCoroutineDispatcher)$this$asExecutor : null;
        if (object == null || (object = ((ExecutorCoroutineDispatcher)object).getExecutor()) == null) {
            object = new DispatcherExecutor($this$asExecutor);
        }
        return object;
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void CloseableCoroutineDispatcher$annotations() {
    }
}

