/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.internal.InlineOnly
 */
package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlinx.coroutines.AbstractTimeSource;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0081\b\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u0000H\u0081\b\u00a2\u0006\u0004\b\u0003\u0010\u0002\u001a \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0000H\u0081\b\u00a2\u0006\u0004\b\b\u0010\t\u001a\u0010\u0010\n\u001a\u00020\u0007H\u0081\b\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\u0007H\u0081\b\u00a2\u0006\u0004\b\f\u0010\u000b\u001a\u0010\u0010\r\u001a\u00020\u0007H\u0081\b\u00a2\u0006\u0004\b\r\u0010\u000b\u001a\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0081\b\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u0010\u0010\u0012\u001a\u00020\u0007H\u0081\b\u00a2\u0006\u0004\b\u0012\u0010\u000b\u001a \u0010\u0016\u001a\u00060\u0013j\u0002`\u00142\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0081\b\u00a2\u0006\u0004\b\u0016\u0010\u0017\"$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2={"", "currentTimeMillis", "()J", "nanoTime", "", "blocker", "nanos", "", "parkNanos", "(Ljava/lang/Object;J)V", "registerTimeLoopThread", "()V", "trackTask", "unTrackTask", "Ljava/lang/Thread;", "thread", "unpark", "(Ljava/lang/Thread;)V", "unregisterTimeLoopThread", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "wrapTask", "(Ljava/lang/Runnable;)Ljava/lang/Runnable;", "Lkotlinx/coroutines/AbstractTimeSource;", "timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "getTimeSource", "()Lkotlinx/coroutines/AbstractTimeSource;", "setTimeSource", "(Lkotlinx/coroutines/AbstractTimeSource;)V", "kotlinx-coroutines-core"})
public final class AbstractTimeSourceKt {
    @Nullable
    private static AbstractTimeSource timeSource;

    @Nullable
    public static final AbstractTimeSource getTimeSource() {
        return timeSource;
    }

    public static final void setTimeSource(@Nullable AbstractTimeSource abstractTimeSource) {
        timeSource = abstractTimeSource;
    }

    @InlineOnly
    private static final long currentTimeMillis() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        return abstractTimeSource != null ? abstractTimeSource.currentTimeMillis() : System.currentTimeMillis();
    }

    @InlineOnly
    private static final long nanoTime() {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        return abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime();
    }

    @InlineOnly
    private static final Runnable wrapTask(Runnable block) {
        Object object = AbstractTimeSourceKt.getTimeSource();
        if (object == null || (object = ((AbstractTimeSource)object).wrapTask(block)) == null) {
            object = block;
        }
        return object;
    }

    @InlineOnly
    private static final void trackTask() {
        block0: {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource == null) break block0;
            abstractTimeSource.trackTask();
        }
    }

    @InlineOnly
    private static final void unTrackTask() {
        block0: {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource == null) break block0;
            abstractTimeSource.unTrackTask();
        }
    }

    @InlineOnly
    private static final void registerTimeLoopThread() {
        block0: {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource == null) break block0;
            abstractTimeSource.registerTimeLoopThread();
        }
    }

    @InlineOnly
    private static final void unregisterTimeLoopThread() {
        block0: {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource == null) break block0;
            abstractTimeSource.unregisterTimeLoopThread();
        }
    }

    @InlineOnly
    private static final void parkNanos(Object blocker, long nanos) {
        Unit unit;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.parkNanos(blocker, nanos);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LockSupport.parkNanos(blocker, nanos);
        }
    }

    @InlineOnly
    private static final void unpark(Thread thread) {
        Unit unit;
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

