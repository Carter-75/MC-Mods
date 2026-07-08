/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH&\u00a2\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH&\u00a2\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH&\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH&\u00a2\u0006\u0004\b\u0013\u0010\fJ\u001f\u0010\u0017\u001a\u00060\u0014j\u0002`\u00152\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015H&\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2={"Lkotlinx/coroutines/AbstractTimeSource;", "", "", "currentTimeMillis", "()J", "nanoTime", "blocker", "nanos", "", "parkNanos", "(Ljava/lang/Object;J)V", "registerTimeLoopThread", "()V", "trackTask", "unTrackTask", "Ljava/lang/Thread;", "thread", "unpark", "(Ljava/lang/Thread;)V", "unregisterTimeLoopThread", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "wrapTask", "(Ljava/lang/Runnable;)Ljava/lang/Runnable;", "<init>", "kotlinx-coroutines-core"})
public abstract class AbstractTimeSource {
    public abstract long currentTimeMillis();

    public abstract long nanoTime();

    @NotNull
    public abstract Runnable wrapTask(@NotNull Runnable var1);

    public abstract void trackTask();

    public abstract void unTrackTask();

    public abstract void registerTimeLoopThread();

    public abstract void unregisterTimeLoopThread();

    public abstract void parkNanos(@NotNull Object var1, long var2);

    public abstract void unpark(@NotNull Thread var1);
}

