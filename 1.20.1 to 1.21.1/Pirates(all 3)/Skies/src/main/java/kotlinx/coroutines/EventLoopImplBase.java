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
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoopImplPlatform;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000f\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004=>?@B\u0007\u00a2\u0006\u0004\b<\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u00032\n\u0010\u000f\u001a\u00060\u0006j\u0002`\u0007H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00122\n\u0010\u000f\u001a\u00060\u0006j\u0002`\u0007H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0004\u00a2\u0006\u0004\b\u0019\u0010\u0005J\u001d\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0002\u00a2\u0006\u0004\b \u0010!J#\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u00152\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H\u0004\u00a2\u0006\u0004\b$\u0010%J%\u0010(\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030&H\u0016\u00a2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u001bH\u0002\u00a2\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b,\u0010\u0005R\u0013\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0-8\u0002X\u0082\u0004R\u000b\u00101\u001a\u0002008\u0002X\u0082\u0004R\u0013\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020-8\u0002X\u0082\u0004R$\u00105\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00128B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00128TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u00106R\u0014\u0010;\u001a\u00020\u00158TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010\u0017\u00a8\u0006A"}, d2={"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "", "closeQueue", "()V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_delayed", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleted", "", "_queue", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "<init>", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n60#2:544\n61#2,7:550\n28#3,4:545\n20#4:549\n56#5:557\n1#6:558\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n269#1:544\n269#1:550,7\n269#1:545,4\n269#1:549\n280#1:557\n*E\n"})
public abstract class EventLoopImplBase
extends EventLoopImplPlatform
implements Delay {
    @Volatile
    @Nullable
    private volatile Object _queue;
    @Volatile
    @Nullable
    private volatile Object _delayed;
    @Volatile
    private volatile int _isCompleted = 0;
    @NotNull
    private static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    @NotNull
    private static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    @NotNull
    private static final AtomicIntegerFieldUpdater _isCompleted$FU = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted");

    private final boolean isCompleted() {
        return _isCompleted$FU.get(this) != 0;
    }

    private final void setCompleted(boolean value) {
        _isCompleted$FU.set(this, value ? 1 : 0);
    }

    @Override
    protected boolean isEmpty() {
        if (!this.isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue delayed = (DelayedTaskQueue)_delayed$FU.get(this);
        if (delayed != null && !delayed.isEmpty()) {
            return false;
        }
        Object queue = _queue$FU.get(this);
        return queue == null ? true : (queue instanceof LockFreeTaskQueueCore ? ((LockFreeTaskQueueCore)queue).isEmpty() : queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p());
    }

    @Override
    protected long getNextTime() {
        Object object;
        if (super.getNextTime() == 0L) {
            return 0L;
        }
        Object queue = _queue$FU.get(this);
        if (queue != null) {
            if (queue instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore)queue).isEmpty()) {
                    return 0L;
                }
            } else {
                if (queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                    return Long.MAX_VALUE;
                }
                return 0L;
            }
        }
        if ((object = (DelayedTaskQueue)_delayed$FU.get(this)) == null || (object = (DelayedTask)((ThreadSafeHeap)object).peek()) == null) {
            return Long.MAX_VALUE;
        }
        Object nextDelayedTask = object;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        return RangesKt.coerceAtLeast((long)(((DelayedTask)nextDelayedTask).nanoTime - (abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime())), (long)0L);
    }

    @Override
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this.setCompleted(true);
        this.closeQueue();
        while (this.processNextEvent() <= 0L) {
        }
        this.rescheduleAllDelayed();
    }

    @Override
    public void scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        long timeNanos = EventLoop_commonKt.delayToNanos(timeMillis);
        if (timeNanos < 0x3FFFFFFFFFFFFFFFL) {
            DelayedResumeTask delayedResumeTask;
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            long now = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
            DelayedResumeTask task = delayedResumeTask = new DelayedResumeTask(now + timeNanos, continuation);
            boolean bl = false;
            this.schedule(now, task);
            CancellableContinuationKt.disposeOnCancellation(continuation, task);
        }
    }

    @NotNull
    protected final DisposableHandle scheduleInvokeOnTimeout(long timeMillis, @NotNull Runnable block) {
        DisposableHandle disposableHandle;
        long timeNanos = EventLoop_commonKt.delayToNanos(timeMillis);
        if (timeNanos < 0x3FFFFFFFFFFFFFFFL) {
            DelayedRunnableTask delayedRunnableTask;
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            long now = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
            DelayedRunnableTask task = delayedRunnableTask = new DelayedRunnableTask(now + timeNanos, block);
            boolean bl = false;
            this.schedule(now, task);
            disposableHandle = delayedRunnableTask;
        } else {
            disposableHandle = NonDisposableHandle.INSTANCE;
        }
        return disposableHandle;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long processNextEvent() {
        Runnable task;
        if (this.processUnconfinedEvent()) {
            return 0L;
        }
        DelayedTaskQueue delayed = (DelayedTaskQueue)_delayed$FU.get(this);
        if (delayed != null && !delayed.isEmpty()) {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            long now = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
            while (true) {
                Object v1;
                ThreadSafeHeap this_$iv = delayed;
                boolean $i$f$removeFirstIf = false;
                boolean $i$f$synchronized = false;
                boolean $i$f$synchronizedImpl = false;
                ThreadSafeHeap threadSafeHeap = this_$iv;
                synchronized (threadSafeHeap) {
                    Object t;
                    block8: {
                        boolean bl = false;
                        if (this_$iv.firstImpl() != null) break block8;
                        Object var11_10 = null;
                        // MONITOREXIT @DISABLED, blocks:[0, 2, 4, 7] lbl21 : MonitorExitStatement: MONITOREXIT : var9_8
                        v1 = var11_10;
                    }
                    Object first$iv = t;
                    DelayedTask it = (DelayedTask)first$iv;
                    boolean bl = false;
                    Object var15_14 = (it.timeToExecute(now) ? this.enqueueImpl(it) : false) ? this_$iv.removeAtImpl(0) : null;
                    // MONITOREXIT @DISABLED, blocks:[1, 2, 4, 7] lbl29 : MonitorExitStatement: MONITOREXIT : var9_8
                    v1 = var15_14;
                }
                if ((DelayedTask)v1 == null) break;
            }
        }
        if ((task = this.dequeue()) != null) {
            boolean $i$f$platformAutoreleasePool = false;
            boolean bl = false;
            task.run();
            return 0L;
        }
        return this.getNextTime();
    }

    @Override
    public final void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        this.enqueue(block);
    }

    public void enqueue(@NotNull Runnable task) {
        if (this.enqueueImpl(task)) {
            this.unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(task);
        }
    }

    private final boolean enqueueImpl(Runnable task) {
        EventLoopImplBase eventLoopImplBase = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _queue$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            Object queue = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if (this.isCompleted()) {
                return false;
            }
            Object v = queue;
            if (v == null) {
                if (!_queue$FU.compareAndSet(this, null, task)) continue;
                return true;
            }
            if (v instanceof LockFreeTaskQueueCore) {
                Intrinsics.checkNotNull(queue, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                switch (((LockFreeTaskQueueCore)queue).addLast(task)) {
                    case 0: {
                        return true;
                    }
                    case 2: {
                        return false;
                    }
                    case 1: {
                        _queue$FU.compareAndSet(this, queue, ((LockFreeTaskQueueCore)queue).next());
                    }
                }
                continue;
            }
            if (queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return false;
            }
            LockFreeTaskQueueCore<Runnable> newQueue = new LockFreeTaskQueueCore<Runnable>(8, true);
            Intrinsics.checkNotNull(queue, (String)"null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            newQueue.addLast((Runnable)queue);
            newQueue.addLast(task);
            if (_queue$FU.compareAndSet(this, queue, newQueue)) break;
        }
        return true;
    }

    private final Runnable dequeue() {
        Object queue;
        EventLoopImplBase eventLoopImplBase = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _queue$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            queue = atomicfu$handler$iv.get(this);
            boolean bl = false;
            Object v = queue;
            if (v == null) {
                return null;
            }
            if (v instanceof LockFreeTaskQueueCore) {
                Intrinsics.checkNotNull(queue, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                Object result2 = ((LockFreeTaskQueueCore)queue).removeFirstOrNull();
                if (result2 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable)result2;
                }
                _queue$FU.compareAndSet(this, queue, ((LockFreeTaskQueueCore)queue).next());
                continue;
            }
            if (queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return null;
            }
            if (_queue$FU.compareAndSet(this, queue, null)) break;
        }
        Intrinsics.checkNotNull(queue, (String)"null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        return (Runnable)queue;
    }

    private final void closeQueue() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!this.isCompleted()) {
                throw new AssertionError();
            }
        }
        EventLoopImplBase bl = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _queue$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            Object queue = atomicfu$handler$iv.get(this);
            boolean bl2 = false;
            Object v = queue;
            if (v == null) {
                if (!_queue$FU.compareAndSet(this, null, EventLoop_commonKt.access$getCLOSED_EMPTY$p())) continue;
                return;
            }
            if (v instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore)queue).close();
                return;
            }
            if (queue == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return;
            }
            LockFreeTaskQueueCore<Runnable> newQueue = new LockFreeTaskQueueCore<Runnable>(8, true);
            Intrinsics.checkNotNull(queue, (String)"null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            newQueue.addLast((Runnable)queue);
            if (_queue$FU.compareAndSet(this, queue, newQueue)) break;
        }
    }

    public final void schedule(long now, @NotNull DelayedTask delayedTask) {
        switch (this.scheduleImpl(now, delayedTask)) {
            case 0: {
                if (this.shouldUnpark(delayedTask)) {
                    this.unpark();
                }
                break;
            }
            case 1: {
                this.reschedule(now, delayedTask);
                break;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("unexpected result".toString());
            }
        }
    }

    private final boolean shouldUnpark(DelayedTask task) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue)_delayed$FU.get(this);
        return (delayedTaskQueue != null ? (DelayedTask)delayedTaskQueue.peek() : null) == task;
    }

    private final int scheduleImpl(long now, DelayedTask delayedTask) {
        if (this.isCompleted()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue)_delayed$FU.get(this);
        if (delayedTaskQueue == null) {
            EventLoopImplBase $this$scheduleImpl_u24lambda_u248 = this;
            boolean bl = false;
            _delayed$FU.compareAndSet($this$scheduleImpl_u24lambda_u248, null, new DelayedTaskQueue(now));
            Object v = _delayed$FU.get($this$scheduleImpl_u24lambda_u248);
            Intrinsics.checkNotNull(v);
            delayedTaskQueue = (DelayedTaskQueue)v;
        }
        DelayedTaskQueue delayedQueue = delayedTaskQueue;
        return delayedTask.scheduleTask(now, delayedQueue, this);
    }

    protected final void resetAll() {
        _queue$FU.set(this, null);
        _delayed$FU.set(this, null);
    }

    private final void rescheduleAllDelayed() {
        Object object;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        long now = abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
        while ((object = (DelayedTaskQueue)_delayed$FU.get(this)) != null && (object = (DelayedTask)((ThreadSafeHeap)object).removeFirstOrNull()) != null) {
            Object delayedTask = object;
            this.reschedule(now, (DelayedTask)delayedTask);
        }
    }

    @Override
    @Deprecated(message="Deprecated without replacement as an internal method never intended for public use", level=DeprecationLevel.ERROR)
    @Nullable
    public Object delay(long time, @NotNull Continuation<? super Unit> $completion) {
        return Delay.DefaultImpls.delay(this, time, $completion);
    }

    @Override
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return Delay.DefaultImpls.invokeOnTimeout(this, timeMillis, block, context);
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "run", "()V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "nanoTime", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
    private final class DelayedResumeTask
    extends DelayedTask {
        @NotNull
        private final CancellableContinuation<Unit> cont;

        public DelayedResumeTask(@NotNull long nanoTime, CancellableContinuation<? super Unit> cont) {
            super(nanoTime);
            this.cont = cont;
        }

        @Override
        public void run() {
            CancellableContinuation<Unit> cancellableContinuation = this.cont;
            EventLoopImplBase eventLoopImplBase = EventLoopImplBase.this;
            CancellableContinuation<Unit> $this$run_u24lambda_u240 = cancellableContinuation;
            boolean bl = false;
            $this$run_u24lambda_u240.resumeUndispatched(eventLoopImplBase, Unit.INSTANCE);
        }

        @Override
        @NotNull
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\n\u001a\u00060\bj\u0002`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "run", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Ljava/lang/Runnable;", "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"})
    private static final class DelayedRunnableTask
    extends DelayedTask {
        @NotNull
        private final Runnable block;

        public DelayedRunnableTask(long nanoTime, @NotNull Runnable block) {
            super(nanoTime);
            this.block = block;
        }

        @Override
        public void run() {
            this.block.run();
        }

        @Override
        @NotNull
        public String toString() {
            return super.toString() + this.block;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\u000f\u0012\u0006\u0010,\u001a\u00020\u000f\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR0\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f2\f\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020\t8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00060"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "other", "", "compareTo", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "", "dispose", "()V", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "scheduleTask", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;Lkotlinx/coroutines/EventLoopImplBase;)I", "", "timeToExecute", "(J)Z", "", "toString", "()Ljava/lang/String;", "_heap", "Ljava/lang/Object;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "value", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "heap", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "nanoTime", "J", "<init>", "(J)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,543:1\n28#2,4:544\n28#2,4:550\n28#2,4:562\n20#3:548\n20#3:554\n20#3:566\n72#4:549\n73#4,7:555\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n437#1:544,4\n439#1:550,4\n479#1:562,4\n437#1:548\n439#1:554\n479#1:566\n439#1:549\n439#1:555,7\n*E\n"})
    public static abstract class DelayedTask
    implements Runnable,
    Comparable<DelayedTask>,
    DisposableHandle,
    ThreadSafeHeapNode {
        @JvmField
        public long nanoTime;
        @Nullable
        private volatile Object _heap;
        private int index;

        public DelayedTask(long nanoTime) {
            this.nanoTime = nanoTime;
            this.index = -1;
        }

        @Override
        @Nullable
        public ThreadSafeHeap<?> getHeap() {
            Object object = this._heap;
            return object instanceof ThreadSafeHeap ? (ThreadSafeHeap)object : null;
        }

        @Override
        public void setHeap(@Nullable ThreadSafeHeap<?> value) {
            if (!(this._heap != EventLoop_commonKt.access$getDISPOSED_TASK$p())) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            this._heap = value;
        }

        @Override
        public int getIndex() {
            return this.index;
        }

        @Override
        public void setIndex(int n2) {
            this.index = n2;
        }

        @Override
        public int compareTo(@NotNull DelayedTask other) {
            long dTime = this.nanoTime - other.nanoTime;
            return dTime > 0L ? 1 : (dTime < 0L ? -1 : 0);
        }

        public final boolean timeToExecute(long now) {
            return now - this.nanoTime >= 0L;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final int scheduleTask(long now, @NotNull DelayedTaskQueue delayed, @NotNull EventLoopImplBase eventLoop) {
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            DelayedTask delayedTask = this;
            synchronized (delayedTask) {
                boolean bl = false;
                if (this._heap == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    return 2;
                }
                ThreadSafeHeap this_$iv = delayed;
                boolean $i$f$addLastIf = false;
                boolean $i$f$synchronized2 = false;
                boolean $i$f$synchronizedImpl2 = false;
                ThreadSafeHeap threadSafeHeap = this_$iv;
                synchronized (threadSafeHeap) {
                    boolean bl2 = false;
                    DelayedTask firstTask = (DelayedTask)this_$iv.firstImpl();
                    boolean bl3 = false;
                    if (eventLoop.isCompleted()) {
                        return 1;
                    }
                    if (firstTask == null) {
                        delayed.timeNow = now;
                    } else {
                        long minTime;
                        long firstTime = firstTask.nanoTime;
                        long l2 = minTime = firstTime - now >= 0L ? now : firstTime;
                        if (minTime - delayed.timeNow > 0L) {
                            delayed.timeNow = minTime;
                        }
                    }
                    if (this.nanoTime - delayed.timeNow < 0L) {
                        this.nanoTime = delayed.timeNow;
                    }
                    this_$iv.addImpl((ThreadSafeHeapNode)this);
                    return 0;
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public final void dispose() {
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            DelayedTask delayedTask = this;
            synchronized (delayedTask) {
                boolean bl = false;
                Object heap = this._heap;
                if (heap == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    return;
                }
                DelayedTaskQueue delayedTaskQueue = heap instanceof DelayedTaskQueue ? (DelayedTaskQueue)heap : null;
                if (delayedTaskQueue != null) {
                    delayedTaskQueue.remove((ThreadSafeHeapNode)this);
                }
                this._heap = EventLoop_commonKt.access$getDISPOSED_TASK$p();
                Unit unit = Unit.INSTANCE;
            }
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "timeNow", "J", "<init>", "(J)V", "kotlinx-coroutines-core"})
    public static final class DelayedTaskQueue
    extends ThreadSafeHeap<DelayedTask> {
        @JvmField
        public long timeNow;

        public DelayedTaskQueue(long timeNow) {
            this.timeNow = timeNow;
        }
    }
}

