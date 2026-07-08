/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.JvmField
 */
package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "stackTraceElement", "Ljava/lang/StackTraceElement;", "<init>", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/StackTraceElement;)V", "kotlinx-coroutines-core"})
@PublishedApi
public final class StackTraceFrame
implements CoroutineStackFrame {
    @Nullable
    private final CoroutineStackFrame callerFrame;
    @JvmField
    @NotNull
    public final StackTraceElement stackTraceElement;

    public StackTraceFrame(@Nullable CoroutineStackFrame callerFrame, @NotNull StackTraceElement stackTraceElement) {
        this.callerFrame = callerFrame;
        this.stackTraceElement = stackTraceElement;
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        return this.callerFrame;
    }

    @NotNull
    public StackTraceElement getStackTraceElement() {
        return this.stackTraceElement;
    }
}

