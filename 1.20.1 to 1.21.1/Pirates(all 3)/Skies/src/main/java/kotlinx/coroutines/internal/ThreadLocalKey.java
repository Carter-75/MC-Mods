/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadLocalElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0081\b\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c2\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c6\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014\u00a8\u0006\u0017"}, d2={"Lkotlinx/coroutines/internal/ThreadLocalKey;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/internal/ThreadLocalElement;", "Ljava/lang/ThreadLocal;", "component1", "()Ljava/lang/ThreadLocal;", "threadLocal", "copy", "(Ljava/lang/ThreadLocal;)Lkotlinx/coroutines/internal/ThreadLocalKey;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/ThreadLocal;", "<init>", "(Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"})
@PublishedApi
public final class ThreadLocalKey
implements CoroutineContext.Key<ThreadLocalElement<?>> {
    @NotNull
    private final ThreadLocal<?> threadLocal;

    public ThreadLocalKey(@NotNull ThreadLocal<?> threadLocal) {
        this.threadLocal = threadLocal;
    }

    private final ThreadLocal<?> component1() {
        return this.threadLocal;
    }

    @NotNull
    public final ThreadLocalKey copy(@NotNull ThreadLocal<?> threadLocal) {
        return new ThreadLocalKey(threadLocal);
    }

    public static /* synthetic */ ThreadLocalKey copy$default(ThreadLocalKey threadLocalKey, ThreadLocal threadLocal, int n2, Object object) {
        if ((n2 & 1) != 0) {
            threadLocal = threadLocalKey.threadLocal;
        }
        return threadLocalKey.copy(threadLocal);
    }

    @NotNull
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.threadLocal + ')';
    }

    public int hashCode() {
        return this.threadLocal.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadLocalKey)) {
            return false;
        }
        ThreadLocalKey threadLocalKey = (ThreadLocalKey)other;
        return Intrinsics.areEqual(this.threadLocal, threadLocalKey.threadLocal);
    }
}

