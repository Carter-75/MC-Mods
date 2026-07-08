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
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import kotlinx.coroutines.internal.LockFreeTaskQueue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u00014B\u0017\u0012\u0006\u0010&\u001a\u00020\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b2\u00103J\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0097A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ4\u0010\u0012\u001a\u00020\u00052\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0016\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0010R\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u000fH\u0082\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0017\u00a2\u0006\u0004\b\u0014\u0010\u000eJ,\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00032\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0019H\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010!\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0096\u0001\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002\u00a2\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010(R\u001e\u0010*\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u000b\u0010-\u001a\u00020,8\u0002X\u0082\u0004R\u0018\u00100\u001a\u00060.j\u0002`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2={"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "", "time", "", "delay", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "startWorker", "dispatchInternal", "(Ljava/lang/Runnable;Lkotlin/jvm/functions/Function1;)V", "dispatchYield", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "", "parallelism", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "obtainTaskOrDeallocateWorker", "()Ljava/lang/Runnable;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "", "tryAllocateWorker", "()Z", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "I", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Lkotlinx/atomicfu/AtomicInt;", "runningWorkers", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "workerAllocationLock", "Ljava/lang/Object;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "Worker", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,134:1\n66#1,8:135\n66#1,8:143\n28#2,4:151\n28#2,4:156\n20#3:155\n20#3:160\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n*L\n48#1:135,8\n55#1:143,8\n79#1:151,4\n92#1:156,4\n79#1:155\n92#1:160\n*E\n"})
public final class LimitedDispatcher
extends CoroutineDispatcher
implements Delay {
    @NotNull
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    private final /* synthetic */ Delay $$delegate_0;
    @Volatile
    private volatile int runningWorkers;
    @NotNull
    private final LockFreeTaskQueue<Runnable> queue;
    @NotNull
    private final Object workerAllocationLock;
    @NotNull
    private static final AtomicIntegerFieldUpdater runningWorkers$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");

    public LimitedDispatcher(@NotNull CoroutineDispatcher dispatcher, int parallelism) {
        this.dispatcher = dispatcher;
        this.parallelism = parallelism;
        Delay delay = dispatcher instanceof Delay ? (Delay)((Object)dispatcher) : null;
        if (delay == null) {
            delay = DefaultExecutorKt.getDefaultDelay();
        }
        this.$$delegate_0 = delay;
        this.queue = new LockFreeTaskQueue(false);
        this.workerAllocationLock = new Object();
    }

    @Override
    @Deprecated(message="Deprecated without replacement as an internal method never intended for public use", level=DeprecationLevel.ERROR)
    @Nullable
    public Object delay(long time, @NotNull Continuation<? super Unit> $completion) {
        return this.$$delegate_0.delay(time, $completion);
    }

    @Override
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return this.$$delegate_0.invokeOnTimeout(timeMillis, block, context);
    }

    @Override
    public void scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        this.$$delegate_0.scheduleResumeAfterDelay(timeMillis, continuation);
    }

    @Override
    @ExperimentalCoroutinesApi
    @NotNull
    public CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        if (parallelism >= this.parallelism) {
            return this;
        }
        return super.limitedParallelism(parallelism);
    }

    @Override
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        LimitedDispatcher this_$iv = this;
        boolean $i$f$dispatchInternal = false;
        this_$iv.queue.addLast(block);
        if (runningWorkers$FU.get(this_$iv) < this_$iv.parallelism && this_$iv.tryAllocateWorker()) {
            Runnable runnable = this_$iv.obtainTaskOrDeallocateWorker();
            if (runnable != null) {
                Runnable task$iv = runnable;
                Worker worker = this_$iv.new Worker(task$iv);
                boolean bl = false;
                this.dispatcher.dispatch((CoroutineContext)this, worker);
            }
        }
    }

    @Override
    @InternalCoroutinesApi
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        LimitedDispatcher this_$iv = this;
        boolean $i$f$dispatchInternal = false;
        this_$iv.queue.addLast(block);
        if (runningWorkers$FU.get(this_$iv) < this_$iv.parallelism && this_$iv.tryAllocateWorker()) {
            Runnable runnable = this_$iv.obtainTaskOrDeallocateWorker();
            if (runnable != null) {
                Runnable task$iv = runnable;
                Worker worker = this_$iv.new Worker(task$iv);
                boolean bl = false;
                this.dispatcher.dispatchYield((CoroutineContext)this, worker);
            }
        }
    }

    private final void dispatchInternal(Runnable block, Function1<? super Worker, Unit> startWorker) {
        boolean $i$f$dispatchInternal = false;
        this.queue.addLast(block);
        if (runningWorkers$FU.get(this) >= this.parallelism) {
            return;
        }
        if (!this.tryAllocateWorker()) {
            return;
        }
        Runnable runnable = this.obtainTaskOrDeallocateWorker();
        if (runnable == null) {
            return;
        }
        Runnable task = runnable;
        startWorker.invoke((Object)new Worker(task));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final boolean tryAllocateWorker() {
        Object lock$iv = this.workerAllocationLock;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        Object object = lock$iv;
        synchronized (object) {
            block4: {
                boolean bl = false;
                if (runningWorkers$FU.get(this) < this.parallelism) break block4;
                boolean bl2 = false;
                return bl2;
            }
            runningWorkers$FU.incrementAndGet(this);
            boolean bl = true;
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Runnable obtainTaskOrDeallocateWorker() {
        Runnable nextTask;
        while ((nextTask = this.queue.removeFirstOrNull()) == null) {
            Object lock$iv = this.workerAllocationLock;
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            Object object = lock$iv;
            synchronized (object) {
                block5: {
                    boolean bl = false;
                    runningWorkers$FU.decrementAndGet(this);
                    if (this.queue.getSize() != 0) break block5;
                    Runnable runnable = null;
                    return runnable;
                }
                int n2 = runningWorkers$FU.incrementAndGet(this);
            }
        }
        return nextTask;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00060\u0001j\u0002`\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "run", "()V", "currentTask", "Ljava/lang/Runnable;", "<init>", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "kotlinx-coroutines-core"})
    private final class Worker
    implements Runnable {
        @NotNull
        private Runnable currentTask;

        public Worker(Runnable currentTask) {
            this.currentTask = currentTask;
        }

        @Override
        public void run() {
            int fairnessCounter = 0;
            do {
                try {
                    this.currentTask.run();
                }
                catch (Throwable e2) {
                    CoroutineExceptionHandlerKt.handleCoroutineException((CoroutineContext)EmptyCoroutineContext.INSTANCE, e2);
                }
                if (LimitedDispatcher.this.obtainTaskOrDeallocateWorker() == null) {
                    return;
                }
                this.currentTask = this.currentTask;
            } while (++fairnessCounter < 16 || !LimitedDispatcher.this.dispatcher.isDispatchNeeded((CoroutineContext)LimitedDispatcher.this));
            LimitedDispatcher.this.dispatcher.dispatch((CoroutineContext)LimitedDispatcher.this, this);
        }
    }
}

