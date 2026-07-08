/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 */
package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableFutureHandle;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.ResumeUndispatchedRunnable;
import kotlinx.coroutines.internal.ConcurrentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b.\u0010/J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00192\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eH\u0016\u00a2\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016\u00a2\u0006\u0004\b#\u0010$J5\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010&*\u00020%2\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u00a2\u0006\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020)8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00060"}, d2={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "", "cancelJobOnRejection", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/RejectedExecutionException;)V", "close", "()V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "", "toString", "()Ljava/lang/String;", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledFuture;", "scheduleBlock", "(Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;J)Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "<init>", "(Ljava/util/concurrent/Executor;)V", "kotlinx-coroutines-core"})
public final class ExecutorCoroutineDispatcherImpl
extends ExecutorCoroutineDispatcher
implements Delay {
    @NotNull
    private final Executor executor;

    public ExecutorCoroutineDispatcherImpl(@NotNull Executor executor) {
        this.executor = executor;
        ConcurrentKt.removeFutureOnCancel(this.getExecutor());
    }

    @Override
    @NotNull
    public Executor getExecutor() {
        return this.executor;
    }

    @Override
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        try {
            Executor executor = this.getExecutor();
            Object object = AbstractTimeSourceKt.getTimeSource();
            if (object == null || (object = ((AbstractTimeSource)object).wrapTask(block)) == null) {
                object = block;
            }
            executor.execute((Runnable)object);
        }
        catch (RejectedExecutionException e2) {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource != null) {
                abstractTimeSource.unTrackTask();
            }
            this.cancelJobOnRejection(context, e2);
            Dispatchers.getIO().dispatch(context, block);
        }
    }

    @Override
    public void scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        ScheduledFuture<?> future;
        Executor executor = this.getExecutor();
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService)executor : null;
        ScheduledFuture<?> scheduledFuture = future = scheduledExecutorService != null ? this.scheduleBlock(scheduledExecutorService, new ResumeUndispatchedRunnable(this, continuation), continuation.getContext(), timeMillis) : null;
        if (future != null) {
            JobKt.cancelFutureOnCancellation(continuation, (Future)future);
            return;
        }
        DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(timeMillis, continuation);
    }

    @Override
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        Executor executor = this.getExecutor();
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService)executor : null;
        ScheduledFuture<?> future = scheduledExecutorService != null ? this.scheduleBlock(scheduledExecutorService, block, context, timeMillis) : null;
        return future != null ? (DisposableHandle)new DisposableFutureHandle((Future)future) : DefaultExecutor.INSTANCE.invokeOnTimeout(timeMillis, block, context);
    }

    private final ScheduledFuture<?> scheduleBlock(ScheduledExecutorService $this$scheduleBlock, Runnable block, CoroutineContext context, long timeMillis) {
        ScheduledFuture<?> scheduledFuture;
        try {
            scheduledFuture = $this$scheduleBlock.schedule(block, timeMillis, TimeUnit.MILLISECONDS);
        }
        catch (RejectedExecutionException e2) {
            this.cancelJobOnRejection(context, e2);
            scheduledFuture = null;
        }
        return scheduledFuture;
    }

    private final void cancelJobOnRejection(CoroutineContext context, RejectedExecutionException exception) {
        JobKt.cancel(context, ExceptionsKt.CancellationException("The task was rejected", exception));
    }

    @Override
    public void close() {
        block0: {
            Executor executor = this.getExecutor();
            ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService)executor : null;
            if (executorService == null) break block0;
            executorService.shutdown();
        }
    }

    @Override
    @NotNull
    public String toString() {
        return this.getExecutor().toString();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ExecutorCoroutineDispatcherImpl && ((ExecutorCoroutineDispatcherImpl)other).getExecutor() == this.getExecutor();
    }

    public int hashCode() {
        return System.identityHashCode(this.getExecutor());
    }

    @Override
    @Deprecated(message="Deprecated without replacement as an internal method never intended for public use", level=DeprecationLevel.ERROR)
    @Nullable
    public Object delay(long time, @NotNull Continuation<? super Unit> $completion) {
        return Delay.DefaultImpls.delay(this, time, $completion);
    }
}

