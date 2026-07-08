/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.JobSupportKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2={"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "joinBlocking", "()Ljava/lang/Object;", "Ljava/lang/Thread;", "blockedThread", "Ljava/lang/Thread;", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "", "isScopedCoroutine", "()Z", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BlockingCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
final class BlockingCoroutine<T>
extends AbstractCoroutine<T> {
    @NotNull
    private final Thread blockedThread;
    @Nullable
    private final EventLoop eventLoop;

    public BlockingCoroutine(@NotNull CoroutineContext parentContext, @NotNull Thread blockedThread, @Nullable EventLoop eventLoop) {
        super(parentContext, true, true);
        this.blockedThread = blockedThread;
        this.eventLoop = eventLoop;
    }

    @Override
    protected boolean isScopedCoroutine() {
        return true;
    }

    @Override
    protected void afterCompletion(@Nullable Object state) {
        if (!Intrinsics.areEqual((Object)Thread.currentThread(), (Object)this.blockedThread)) {
            Unit unit;
            Thread thread = this.blockedThread;
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource != null) {
                abstractTimeSource.unpark(thread);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(thread);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final T joinBlocking() {
        CompletedExceptionally completedExceptionally;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.registerTimeLoopThread();
        }
        try {
            EventLoop eventLoop = this.eventLoop;
            if (eventLoop != null) {
                EventLoop.incrementUseCount$default(eventLoop, false, 1, null);
            }
            try {
                while (true) {
                    long parkNanos;
                    if (Thread.interrupted()) {
                        InterruptedException interruptedException;
                        InterruptedException it = interruptedException = new InterruptedException();
                        boolean bl = false;
                        this.cancelCoroutine(it);
                        throw (Throwable)interruptedException;
                    }
                    EventLoop eventLoop2 = this.eventLoop;
                    long l2 = parkNanos = eventLoop2 != null ? eventLoop2.processNextEvent() : Long.MAX_VALUE;
                    if (!this.isCompleted()) {
                        Unit unit;
                        AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.getTimeSource();
                        if (abstractTimeSource2 != null) {
                            abstractTimeSource2.parkNanos(this, parkNanos);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit != null) continue;
                        LockSupport.parkNanos(this, parkNanos);
                        continue;
                    }
                    break;
                }
            }
            finally {
                EventLoop eventLoop3 = this.eventLoop;
                if (eventLoop3 != null) {
                    EventLoop.decrementUseCount$default(eventLoop3, false, 1, null);
                }
            }
        }
        finally {
            AbstractTimeSource abstractTimeSource3 = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource3 != null) {
                abstractTimeSource3.unregisterTimeLoopThread();
            }
        }
        Object state = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        CompletedExceptionally completedExceptionally2 = completedExceptionally = state instanceof CompletedExceptionally ? (CompletedExceptionally)state : null;
        if (completedExceptionally != null) {
            CompletedExceptionally it = completedExceptionally;
            boolean bl = false;
            throw it.cause;
        }
        return (T)state;
    }
}

