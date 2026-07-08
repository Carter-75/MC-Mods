/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.Volatile
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010)\u001a\u00020#\u00a2\u0006\u0004\b,\u0010-J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0006J#\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u00020\u00042\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\r\u0010\u0011J#\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u000eJ\u001b\u0010\u0014\u001a\u00020\u00042\n\u0010\u0013\u001a\u00060\nj\u0002`\u000bH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000b\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004R\u0016\u0010!\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010'\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020#8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010+\u00a8\u0006."}, d2={"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "Lkotlinx/atomicfu/AtomicInt;", "inFlightTasks", "name", "Ljava/lang/String;", "", "parallelism", "I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "taskMode", "getTaskMode", "()I", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILjava/lang/String;I)V", "kotlinx-coroutines-core"})
final class LimitingDispatcher
extends ExecutorCoroutineDispatcher
implements TaskContext,
Executor {
    @NotNull
    private final ExperimentalCoroutineDispatcher dispatcher;
    private final int parallelism;
    @Nullable
    private final String name;
    private final int taskMode;
    @NotNull
    private final ConcurrentLinkedQueue<Runnable> queue;
    @Volatile
    private volatile int inFlightTasks;
    @NotNull
    private static final AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");

    public LimitingDispatcher(@NotNull ExperimentalCoroutineDispatcher dispatcher, int parallelism, @Nullable String name, int taskMode) {
        this.dispatcher = dispatcher;
        this.parallelism = parallelism;
        this.name = name;
        this.taskMode = taskMode;
        this.queue = new ConcurrentLinkedQueue();
    }

    @Override
    public int getTaskMode() {
        return this.taskMode;
    }

    @Override
    @NotNull
    public Executor getExecutor() {
        return this;
    }

    @Override
    public void execute(@NotNull Runnable command2) {
        this.dispatch(command2, false);
    }

    @Override
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        this.dispatch(block, false);
    }

    private final void dispatch(Runnable block, boolean tailDispatch) {
        Runnable taskToSchedule = block;
        while (true) {
            int inFlight;
            if ((inFlight = inFlightTasks$FU.incrementAndGet(this)) <= this.parallelism) {
                this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(taskToSchedule, this, tailDispatch);
                return;
            }
            this.queue.add(taskToSchedule);
            if (inFlightTasks$FU.decrementAndGet(this) >= this.parallelism) {
                return;
            }
            if (this.queue.poll() != null) continue;
            return;
        }
    }

    @Override
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        this.dispatch(block, true);
    }

    @Override
    @NotNull
    public String toString() {
        String string = this.name;
        if (string == null) {
            string = super.toString() + "[dispatcher = " + this.dispatcher + ']';
        }
        return string;
    }

    @Override
    public void afterTask() {
        Runnable next = this.queue.poll();
        if (next != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(next, this, true);
            return;
        }
        inFlightTasks$FU.decrementAndGet(this);
        Runnable runnable = this.queue.poll();
        if (runnable == null) {
            return;
        }
        next = runnable;
        this.dispatch(next, true);
    }
}

