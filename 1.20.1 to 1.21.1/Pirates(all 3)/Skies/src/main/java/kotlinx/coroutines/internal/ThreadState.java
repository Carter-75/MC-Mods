/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0006\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\fR$\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2={"Lkotlinx/coroutines/internal/ThreadState;", "", "Lkotlinx/coroutines/ThreadContextElement;", "element", "value", "", "append", "(Lkotlinx/coroutines/ThreadContextElement;Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "restore", "(Lkotlin/coroutines/CoroutineContext;)V", "Lkotlin/coroutines/CoroutineContext;", "", "elements", "[Lkotlinx/coroutines/ThreadContextElement;", "", "i", "I", "values", "[Ljava/lang/Object;", "n", "<init>", "(Lkotlin/coroutines/CoroutineContext;I)V", "kotlinx-coroutines-core"})
final class ThreadState {
    @JvmField
    @NotNull
    public final CoroutineContext context;
    @NotNull
    private final Object[] values;
    @NotNull
    private final ThreadContextElement<Object>[] elements;
    private int i;

    public ThreadState(@NotNull CoroutineContext context, int n2) {
        this.context = context;
        this.values = new Object[n2];
        this.elements = new ThreadContextElement[n2];
    }

    public final void append(@NotNull ThreadContextElement<?> element, @Nullable Object value) {
        this.values[this.i] = value;
        int n2 = this.i;
        this.i = n2 + 1;
        Intrinsics.checkNotNull(element, (String)"null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        this.elements[n2] = element;
    }

    public final void restore(@NotNull CoroutineContext context) {
        int n2 = this.elements.length + -1;
        if (0 <= n2) {
            do {
                int i2 = n2--;
                ThreadContextElement<Object> threadContextElement = this.elements[i2];
                Intrinsics.checkNotNull(threadContextElement);
                threadContextElement.restoreThreadContext(context, this.values[i2]);
            } while (0 <= n2);
        }
    }
}

