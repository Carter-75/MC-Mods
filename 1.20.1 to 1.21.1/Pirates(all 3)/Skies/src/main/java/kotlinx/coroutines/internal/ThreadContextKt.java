/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.ThreadState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\r\u001a\u00020\f8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\"*\u0010\u0011\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"2\u0010\u0014\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00130\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\"&\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012\u00a8\u0006\u0017"}, d2={"Lkotlin/coroutines/CoroutineContext;", "context", "", "oldState", "", "restoreThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "threadContextElements", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "countOrElement", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "countAll", "Lkotlin/jvm/functions/Function2;", "Lkotlinx/coroutines/ThreadContextElement;", "findOne", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "kotlinx-coroutines-core"})
public final class ThreadContextKt {
    @JvmField
    @NotNull
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");
    @NotNull
    private static final Function2<Object, CoroutineContext.Element, Object> countAll = countAll.1.INSTANCE;
    @NotNull
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne = findOne.1.INSTANCE;
    @NotNull
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> updateState = updateState.1.INSTANCE;

    @NotNull
    public static final Object threadContextElements(@NotNull CoroutineContext context) {
        Object object = context.fold((Object)0, countAll);
        Intrinsics.checkNotNull((Object)object);
        return object;
    }

    @Nullable
    public static final Object updateThreadContext(@NotNull CoroutineContext context, @Nullable Object countOrElement) {
        Object object;
        Object object2 = countOrElement;
        if (object2 == null) {
            object2 = ThreadContextKt.threadContextElements(context);
        }
        Object countOrElement2 = object2;
        if (countOrElement2 == Integer.valueOf(0)) {
            object = NO_THREAD_ELEMENTS;
        } else if (countOrElement2 instanceof Integer) {
            object = context.fold((Object)new ThreadState(context, ((Number)countOrElement2).intValue()), updateState);
        } else {
            Intrinsics.checkNotNull((Object)countOrElement2, (String)"null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ThreadContextElement element = (ThreadContextElement)countOrElement2;
            object = element.updateThreadContext(context);
        }
        return object;
    }

    public static final void restoreThreadContext(@NotNull CoroutineContext context, @Nullable Object oldState) {
        if (oldState == NO_THREAD_ELEMENTS) {
            return;
        }
        if (oldState instanceof ThreadState) {
            ((ThreadState)oldState).restore(context);
        } else {
            Object object = context.fold(null, findOne);
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ThreadContextElement element = (ThreadContextElement)object;
            element.restoreThreadContext(context, oldState);
        }
    }
}

