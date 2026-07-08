/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.internal.ThreadLocalKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u001c\u001a\u00028\u0000\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ*\u0010\u0007\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2={"Lkotlinx/coroutines/internal/ThreadLocalElement;", "T", "Lkotlinx/coroutines/ThreadContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "minusKey", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "context", "oldState", "", "restoreThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Ljava/lang/ThreadLocal;", "threadLocal", "Ljava/lang/ThreadLocal;", "value", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"})
public final class ThreadLocalElement<T>
implements ThreadContextElement<T> {
    private final T value;
    @NotNull
    private final ThreadLocal<T> threadLocal;
    @NotNull
    private final CoroutineContext.Key<?> key;

    public ThreadLocalElement(T value, @NotNull ThreadLocal<T> threadLocal) {
        this.value = value;
        this.threadLocal = threadLocal;
        this.key = new ThreadLocalKey(this.threadLocal);
    }

    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return this.key;
    }

    @Override
    public T updateThreadContext(@NotNull CoroutineContext context) {
        T oldState = this.threadLocal.get();
        this.threadLocal.set(this.value);
        return oldState;
    }

    @Override
    public void restoreThreadContext(@NotNull CoroutineContext context, T oldState) {
        this.threadLocal.set(oldState);
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Intrinsics.areEqual(this.getKey(), key) ? (CoroutineContext)EmptyCoroutineContext.INSTANCE : (CoroutineContext)this;
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        CoroutineContext.Element element;
        if (Intrinsics.areEqual(this.getKey(), key)) {
            Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
            element = this;
        } else {
            element = null;
        }
        return (E)element;
    }

    @NotNull
    public String toString() {
        return "ThreadLocal(value=" + this.value + ", threadLocal = " + this.threadLocal + ')';
    }

    public <R> R fold(R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return ThreadContextElement.DefaultImpls.fold(this, initial, operation);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext context) {
        return ThreadContextElement.DefaultImpls.plus(this, context);
    }
}

