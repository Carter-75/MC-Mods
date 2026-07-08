/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\b\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a,\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b*\u00060\fj\u0002`\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0080\b\u00a2\u0006\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014*\f\b\u0000\u0010\u0015\"\u00020\f2\u00020\f\u00a8\u0006\u0016"}, d2={"E", "", "expectedSize", "", "identitySet", "(I)Ljava/util/Set;", "Ljava/util/concurrent/Executor;", "executor", "", "removeFutureOnCancel", "(Ljava/util/concurrent/Executor;)Z", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Lkotlin/Function0;", "action", "withLock", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "ReentrantLock", "kotlinx-coroutines-core"})
public final class ConcurrentKt {
    @Nullable
    private static final Method REMOVE_FUTURE_ON_CANCEL;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T withLock(@NotNull ReentrantLock $this$withLock, @NotNull Function0<? extends T> action) {
        Object object;
        boolean $i$f$withLock = false;
        Lock lock = $this$withLock;
        lock.lock();
        try {
            object = action.invoke();
        }
        finally {
            InlineMarker.finallyStart((int)1);
            lock.unlock();
            InlineMarker.finallyEnd((int)1);
        }
        return (T)object;
    }

    @NotNull
    public static final <E> Set<E> identitySet(int expectedSize) {
        boolean $i$f$identitySet = false;
        return Collections.newSetFromMap(new IdentityHashMap(expectedSize));
    }

    public static final boolean removeFutureOnCancel(@NotNull Executor executor) {
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor)executor : null;
            if (scheduledThreadPoolExecutor == null) {
                return false;
            }
            ScheduledThreadPoolExecutor executor2 = scheduledThreadPoolExecutor;
            Method method = REMOVE_FUTURE_ON_CANCEL;
            if (method == null) {
                return false;
            }
            Object[] objectArray = new Object[]{true};
            method.invoke((Object)executor2, objectArray);
            return true;
        }
        catch (Throwable e2) {
            return false;
        }
    }

    public static /* synthetic */ void ReentrantLock$annotations() {
    }

    static {
        Object object;
        try {
            object = new Class[]{Boolean.TYPE};
            object = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", (Class<?>)object);
        }
        catch (Throwable e2) {
            object = null;
        }
        REMOVE_FUTURE_ON_CANCEL = object;
    }
}

