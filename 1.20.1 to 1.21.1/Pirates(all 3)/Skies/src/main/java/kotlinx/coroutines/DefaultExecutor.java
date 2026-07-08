/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.EventLoopImplBase;
import kotlinx.coroutines.ThreadLocalEventLoop;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002\u00a2\u0006\u0004\b<\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00042\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\r\u0010\u0006J+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u001f\u0010\u0006J\u000f\u0010 \u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b \u0010\u0006J\u000f\u0010!\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b!\u0010\u0006J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f\u00a2\u0006\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020%8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020%8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020%8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020%8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010'R\u0014\u00100\u001a\u00020/8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001e\u00102\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b2\u00103\u0012\u0004\b4\u0010\u0006R\u0016\u00105\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010'R\u0014\u00106\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0019R\u0014\u00107\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010\u0019R\u0014\u00109\u001a\u00020\u00178@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u0010\u0019R\u0014\u0010;\u001a\u00020\u00078TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010\t\u00a8\u0006="}, d2={"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "acknowledgeShutdownIfNeeded", "()V", "Ljava/lang/Thread;", "createThreadSync", "()Ljava/lang/Thread;", "task", "enqueue", "(Ljava/lang/Runnable;)V", "ensureStarted$kotlinx_coroutines_core", "ensureStarted", "", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "", "notifyStartup", "()Z", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "reschedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "run", "shutdown", "shutdownError", "timeout", "shutdownForTests", "(J)V", "", "ACTIVE", "I", "DEFAULT_KEEP_ALIVE_MS", "J", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "", "THREAD_NAME", "Ljava/lang/String;", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutDown", "isShutdownRequested", "isThreadPresent$kotlinx_coroutines_core", "isThreadPresent", "getThread", "thread", "<init>", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
public final class DefaultExecutor
extends EventLoopImplBase
implements Runnable {
    @NotNull
    public static final DefaultExecutor INSTANCE;
    @NotNull
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    private static final long DEFAULT_KEEP_ALIVE_MS = 1000L;
    private static final long KEEP_ALIVE_NANOS;
    @Nullable
    private static volatile Thread _thread;
    private static final int FRESH = 0;
    private static final int ACTIVE = 1;
    private static final int SHUTDOWN_REQ = 2;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN = 4;
    private static volatile int debugStatus;

    private DefaultExecutor() {
    }

    private static /* synthetic */ void get_thread$annotations() {
    }

    @Override
    @NotNull
    protected Thread getThread() {
        Thread thread = _thread;
        if (thread == null) {
            thread = this.createThreadSync();
        }
        return thread;
    }

    private final boolean isShutDown() {
        return debugStatus == 4;
    }

    private final boolean isShutdownRequested() {
        int debugStatus = DefaultExecutor.debugStatus;
        return debugStatus == 2 || debugStatus == 3;
    }

    @Override
    public void enqueue(@NotNull Runnable task) {
        if (this.isShutDown()) {
            this.shutdownError();
        }
        super.enqueue(task);
    }

    @Override
    protected void reschedule(long now, @NotNull EventLoopImplBase.DelayedTask delayedTask) {
        this.shutdownError();
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return this.scheduleInvokeOnTimeout(timeMillis, block);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.registerTimeLoopThread();
        }
        try {
            long shutdownNanos = Long.MAX_VALUE;
            if (!this.notifyStartup()) {
                return;
            }
            while (true) {
                Unit unit;
                Thread.interrupted();
                long parkNanos = this.processNextEvent();
                if (parkNanos == Long.MAX_VALUE) {
                    long tillShutdown;
                    long now;
                    AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.getTimeSource();
                    long l2 = now = abstractTimeSource2 != null ? abstractTimeSource2.nanoTime() : System.nanoTime();
                    if (shutdownNanos == Long.MAX_VALUE) {
                        shutdownNanos = now + KEEP_ALIVE_NANOS;
                    }
                    if ((tillShutdown = shutdownNanos - now) <= 0L) {
                        return;
                    }
                    parkNanos = RangesKt.coerceAtMost((long)parkNanos, (long)tillShutdown);
                } else {
                    shutdownNanos = Long.MAX_VALUE;
                }
                if (parkNanos <= 0L) continue;
                if (this.isShutdownRequested()) {
                    return;
                }
                AbstractTimeSource abstractTimeSource3 = AbstractTimeSourceKt.getTimeSource();
                if (abstractTimeSource3 != null) {
                    abstractTimeSource3.parkNanos(this, parkNanos);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) continue;
                LockSupport.parkNanos(this, parkNanos);
            }
        }
        finally {
            _thread = null;
            this.acknowledgeShutdownIfNeeded();
            AbstractTimeSource abstractTimeSource4 = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource4 != null) {
                abstractTimeSource4.unregisterTimeLoopThread();
            }
            if (!this.isEmpty()) {
                this.getThread();
            }
        }
    }

    private final synchronized Thread createThreadSync() {
        Thread thread = _thread;
        if (thread == null) {
            Thread thread2;
            Thread $this$createThreadSync_u24lambda_u240 = thread2 = new Thread((Runnable)this, THREAD_NAME);
            boolean bl = false;
            _thread = $this$createThreadSync_u24lambda_u240;
            $this$createThreadSync_u24lambda_u240.setDaemon(true);
            $this$createThreadSync_u24lambda_u240.start();
            thread = thread2;
        }
        return thread;
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(_thread == null)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(debugStatus == 0 || debugStatus == 3)) {
                throw new AssertionError();
            }
        }
        debugStatus = 0;
        this.createThreadSync();
        while (debugStatus == 0) {
            Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type java.lang.Object");
            ((Object)this).wait();
        }
    }

    private final synchronized boolean notifyStartup() {
        if (this.isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type java.lang.Object");
        ((Object)this).notifyAll();
        return true;
    }

    public final synchronized void shutdownForTests(long timeout) {
        long deadline = System.currentTimeMillis() + timeout;
        if (!this.isShutdownRequested()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            if (_thread != null) {
                Unit unit;
                Thread it;
                boolean bl = false;
                AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
                if (abstractTimeSource != null) {
                    abstractTimeSource.unpark(it);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    LockSupport.unpark(it);
                }
            }
            long remaining = deadline - System.currentTimeMillis();
            if (remaining <= 0L) break;
            Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type java.lang.Object");
            ((Object)this).wait(timeout);
        }
        debugStatus = 0;
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (!this.isShutdownRequested()) {
            return;
        }
        debugStatus = 3;
        this.resetAll();
        Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type java.lang.Object");
        ((Object)this).notifyAll();
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        return _thread != null;
    }

    static {
        Long l2;
        TimeUnit timeUnit;
        INSTANCE = new DefaultExecutor();
        EventLoop.incrementUseCount$default(INSTANCE, false, 1, null);
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        try {
            timeUnit = timeUnit2;
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        }
        catch (SecurityException e2) {
            timeUnit = timeUnit2;
            l2 = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l2);
    }
}

