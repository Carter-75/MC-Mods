/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.JvmName
 */
package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f8G\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006("}, d2={"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "creationStackBottom", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCreationStackBottom$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "", "Ljava/lang/StackTraceElement;", "creationStackTrace", "Ljava/util/List;", "getCreationStackTrace", "()Ljava/util/List;", "lastObservedFrame", "getLastObservedFrame", "lastObservedStackTrace", "Ljava/lang/Thread;", "lastObservedThread", "Ljava/lang/Thread;", "getLastObservedThread", "()Ljava/lang/Thread;", "", "sequenceNumber", "J", "getSequenceNumber", "()J", "", "state", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "source", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"})
@PublishedApi
public final class DebugCoroutineInfo {
    @NotNull
    private final CoroutineContext context;
    @Nullable
    private final CoroutineStackFrame creationStackBottom;
    private final long sequenceNumber;
    @NotNull
    private final List<StackTraceElement> creationStackTrace;
    @NotNull
    private final String state;
    @Nullable
    private final Thread lastObservedThread;
    @Nullable
    private final CoroutineStackFrame lastObservedFrame;
    @NotNull
    private final List<StackTraceElement> lastObservedStackTrace;

    public DebugCoroutineInfo(@NotNull DebugCoroutineInfoImpl source, @NotNull CoroutineContext context) {
        this.context = context;
        this.creationStackBottom = source.getCreationStackBottom$kotlinx_coroutines_core();
        this.sequenceNumber = source.sequenceNumber;
        this.creationStackTrace = source.getCreationStackTrace();
        this.state = source.getState$kotlinx_coroutines_core();
        this.lastObservedThread = source.lastObservedThread;
        this.lastObservedFrame = source.getLastObservedFrame$kotlinx_coroutines_core();
        this.lastObservedStackTrace = source.lastObservedStackTrace$kotlinx_coroutines_core();
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Nullable
    public final CoroutineStackFrame getCreationStackBottom$kotlinx_coroutines_core() {
        return this.creationStackBottom;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @NotNull
    public final List<StackTraceElement> getCreationStackTrace() {
        return this.creationStackTrace;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    @Nullable
    public final Thread getLastObservedThread() {
        return this.lastObservedThread;
    }

    @Nullable
    public final CoroutineStackFrame getLastObservedFrame() {
        return this.lastObservedFrame;
    }

    @JvmName(name="lastObservedStackTrace")
    @NotNull
    public final List<StackTraceElement> lastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }
}

