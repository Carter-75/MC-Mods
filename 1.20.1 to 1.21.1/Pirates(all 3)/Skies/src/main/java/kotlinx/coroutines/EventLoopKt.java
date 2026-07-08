/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BlockingEventLoop;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a \u0010\u0006\u001a\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0080\b\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u000f\u0010\t\u001a\u00020\bH\u0007\u00a2\u0006\u0004\b\t\u0010\n\u001a\u000f\u0010\u000b\u001a\u00020\bH\u0001\u00a2\u0006\u0004\b\u000b\u0010\n\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\fH\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/EventLoop;", "createEventLoop", "()Lkotlinx/coroutines/EventLoop;", "Lkotlin/Function0;", "", "block", "platformAutoreleasePool", "(Lkotlin/jvm/functions/Function0;)V", "", "processNextEventInCurrentThread", "()J", "runSingleTaskFromCurrentSystemDispatcher", "Ljava/lang/Thread;", "", "isIoDispatcherThread", "(Ljava/lang/Thread;)Z", "kotlinx-coroutines-core"})
public final class EventLoopKt {
    @NotNull
    public static final EventLoop createEventLoop() {
        return new BlockingEventLoop(Thread.currentThread());
    }

    @InternalCoroutinesApi
    public static final long processNextEventInCurrentThread() {
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
        return eventLoop != null ? eventLoop.processNextEvent() : Long.MAX_VALUE;
    }

    public static final void platformAutoreleasePool(@NotNull Function0<Unit> block) {
        boolean $i$f$platformAutoreleasePool = false;
        block.invoke();
    }

    @InternalCoroutinesApi
    @DelicateCoroutinesApi
    @PublishedApi
    public static final long runSingleTaskFromCurrentSystemDispatcher() {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof CoroutineScheduler.Worker)) {
            throw new IllegalStateException("Expected CoroutineScheduler.Worker, but got " + thread);
        }
        return ((CoroutineScheduler.Worker)thread).runSingleTask();
    }

    @InternalCoroutinesApi
    @DelicateCoroutinesApi
    @PublishedApi
    public static final boolean isIoDispatcherThread(@NotNull Thread $this$isIoDispatcherThread) {
        if (!($this$isIoDispatcherThread instanceof CoroutineScheduler.Worker)) {
            return false;
        }
        return ((CoroutineScheduler.Worker)$this$isIoDispatcherThread).isIo();
    }
}

