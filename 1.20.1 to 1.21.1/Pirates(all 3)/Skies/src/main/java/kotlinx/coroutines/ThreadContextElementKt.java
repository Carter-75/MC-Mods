/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0002\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0001H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u0001H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2={"T", "Ljava/lang/ThreadLocal;", "value", "Lkotlinx/coroutines/ThreadContextElement;", "asContextElement", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "", "ensurePresent", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isPresent", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nThreadContextElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,288:1\n266#1:289\n1#2:290\n*S KotlinDebug\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n*L\n287#1:289\n*E\n"})
public final class ThreadContextElementKt {
    @NotNull
    public static final <T> ThreadContextElement<T> asContextElement(@NotNull ThreadLocal<T> $this$asContextElement, T value) {
        return new ThreadLocalElement<T>(value, $this$asContextElement);
    }

    public static /* synthetic */ ThreadContextElement asContextElement$default(ThreadLocal threadLocal, Object object, int n2, Object object2) {
        if ((n2 & 1) != 0) {
            object = threadLocal.get();
        }
        return ThreadContextElementKt.asContextElement(threadLocal, object);
    }

    @Nullable
    public static final Object isPresent(@NotNull ThreadLocal<?> $this$isPresent, @NotNull Continuation<? super Boolean> $completion) {
        boolean $i$f$isPresent = false;
        return Boxing.boxBoolean(($completion.getContext().get((CoroutineContext.Key)new ThreadLocalKey($this$isPresent)) != null ? 1 : 0) != 0);
    }

    private static final Object isPresent$$forInline(ThreadLocal<?> $this$isPresent, Continuation<? super Boolean> $completion) {
        boolean $i$f$isPresent = false;
        InlineMarker.mark((int)3);
        return null.getContext().get((CoroutineContext.Key)new ThreadLocalKey($this$isPresent)) != null;
    }

    @Nullable
    public static final Object ensurePresent(@NotNull ThreadLocal<?> $this$ensurePresent, @NotNull Continuation<? super Unit> $completion) {
        boolean $i$f$ensurePresent = false;
        ThreadLocal<?> $this$isPresent$iv = $this$ensurePresent;
        boolean $i$f$isPresent = false;
        if (!($completion.getContext().get((CoroutineContext.Key)new ThreadLocalKey($this$isPresent$iv)) != null)) {
            boolean bl = false;
            String string = "ThreadLocal " + $this$ensurePresent + " is missing from context " + $completion.getContext();
            throw new IllegalStateException(string.toString());
        }
        return Unit.INSTANCE;
    }

    private static final Object ensurePresent$$forInline(ThreadLocal<?> $this$ensurePresent, Continuation<? super Unit> $completion) {
        boolean $i$f$ensurePresent = false;
        ThreadLocal<?> $this$isPresent$iv = $this$ensurePresent;
        boolean $i$f$isPresent = false;
        InlineMarker.mark((int)3);
        boolean bl = null.getContext().get((CoroutineContext.Key)new ThreadLocalKey($this$isPresent$iv)) != null;
        if (!bl) {
            boolean bl2 = false;
            StringBuilder stringBuilder = new StringBuilder().append("ThreadLocal ").append($this$ensurePresent).append(" is missing from context ");
            InlineMarker.mark((int)3);
            String string = stringBuilder.append(null.getContext()).toString();
            throw new IllegalStateException(string.toString());
        }
        return Unit.INSTANCE;
    }
}

