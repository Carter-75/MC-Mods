/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArrayDeque
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0006J\u0015\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00078TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010#\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006("}, d2={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "unconfined", "", "decrementUseCount", "(Z)V", "", "delta", "(Z)J", "Lkotlinx/coroutines/DispatchedTask;", "task", "dispatchUnconfined", "(Lkotlinx/coroutines/DispatchedTask;)V", "incrementUseCount", "", "parallelism", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "processNextEvent", "()J", "processUnconfinedEvent", "()Z", "shouldBeProcessedFromContext", "shutdown", "()V", "isActive", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "getNextTime", "nextTime", "shared", "Z", "Lkotlin/collections/ArrayDeque;", "unconfinedQueue", "Lkotlin/collections/ArrayDeque;", "useCount", "J", "<init>", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
public abstract class EventLoop
extends CoroutineDispatcher {
    private long useCount;
    private boolean shared;
    @Nullable
    private ArrayDeque<DispatchedTask<?>> unconfinedQueue;

    public long processNextEvent() {
        if (!this.processUnconfinedEvent()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    protected boolean isEmpty() {
        return this.isUnconfinedQueueEmpty();
    }

    protected long getNextTime() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            return Long.MAX_VALUE;
        }
        ArrayDeque<DispatchedTask<?>> queue = arrayDeque;
        return queue.isEmpty() ? Long.MAX_VALUE : 0L;
    }

    public final boolean processUnconfinedEvent() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            return false;
        }
        ArrayDeque<DispatchedTask<?>> queue = arrayDeque;
        DispatchedTask dispatchedTask = (DispatchedTask)queue.removeFirstOrNull();
        if (dispatchedTask == null) {
            return false;
        }
        DispatchedTask task = dispatchedTask;
        task.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    public final void dispatchUnconfined(@NotNull DispatchedTask<?> task) {
        ArrayDeque arrayDeque = this.unconfinedQueue;
        if (arrayDeque == null) {
            ArrayDeque arrayDeque2;
            ArrayDeque it = arrayDeque2 = new ArrayDeque();
            boolean bl = false;
            this.unconfinedQueue = it;
            arrayDeque = arrayDeque2;
        }
        ArrayDeque queue = arrayDeque;
        queue.addLast(task);
    }

    public final boolean isActive() {
        return this.useCount > 0L;
    }

    public final boolean isUnconfinedLoopActive() {
        return this.useCount >= this.delta(true);
    }

    public final boolean isUnconfinedQueueEmpty() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.unconfinedQueue;
        return arrayDeque != null ? arrayDeque.isEmpty() : true;
    }

    private final long delta(boolean unconfined) {
        return unconfined ? 0x100000000L : 1L;
    }

    public final void incrementUseCount(boolean unconfined) {
        this.useCount += this.delta(unconfined);
        if (!unconfined) {
            this.shared = true;
        }
    }

    public static /* synthetic */ void incrementUseCount$default(EventLoop eventLoop, boolean bl, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((n2 & 1) != 0) {
            bl = false;
        }
        eventLoop.incrementUseCount(bl);
    }

    public final void decrementUseCount(boolean unconfined) {
        this.useCount -= this.delta(unconfined);
        if (this.useCount > 0L) {
            return;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.useCount == 0L)) {
                throw new AssertionError();
            }
        }
        if (this.shared) {
            this.shutdown();
        }
    }

    public static /* synthetic */ void decrementUseCount$default(EventLoop eventLoop, boolean bl, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((n2 & 1) != 0) {
            bl = false;
        }
        eventLoop.decrementUseCount(bl);
    }

    @Override
    @NotNull
    public final CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        return this;
    }

    public void shutdown() {
    }
}

