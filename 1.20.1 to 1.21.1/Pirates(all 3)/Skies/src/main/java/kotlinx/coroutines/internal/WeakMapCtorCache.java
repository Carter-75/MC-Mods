/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.CtorCache;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005j\u0002`\u00062\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR:\u0010\r\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005j\u0002`\u00060\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2={"Lkotlinx/coroutines/internal/WeakMapCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "Ljava/lang/Class;", "", "key", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "get", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/WeakHashMap;", "exceptionCtors", "Ljava/util/WeakHashMap;", "<init>", "()V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/WeakMapCtorCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
final class WeakMapCtorCache
extends CtorCache {
    @NotNull
    public static final WeakMapCtorCache INSTANCE = new WeakMapCtorCache();
    @NotNull
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    @NotNull
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap();

    private WeakMapCtorCache() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @NotNull
    public Function1<Throwable, Throwable> get(@NotNull Class<? extends Throwable> key) {
        ReentrantReadWriteLock.ReadLock readLock = cacheLock.readLock();
        readLock.lock();
        try {
            boolean bl = false;
            Function1<Throwable, Throwable> function1 = exceptionCtors.get(key);
            if (function1 != null) {
                Function1<Throwable, Throwable> it = function1;
                boolean bl2 = false;
                Function1<Throwable, Throwable> function12 = it;
                return function12;
            }
            Object var4_4 = null;
        }
        finally {
            readLock.unlock();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = cacheLock;
        readLock = reentrantReadWriteLock.readLock();
        int n2 = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            Function1 function1;
            boolean bl = false;
            Function1<Throwable, Throwable> function13 = exceptionCtors.get(key);
            if (function13 != null) {
                Function1<Throwable, Throwable> it = function13;
                boolean bl3 = false;
                Function1<Throwable, Throwable> function14 = it;
                return function14;
            }
            Function1 it = function1 = ExceptionsConstructorKt.access$createConstructor(key);
            boolean bl4 = false;
            ((Map)exceptionCtors).put(key, it);
            Function1 function15 = function1;
            return function15;
        }
        finally {
            for (int it = 0; it < n2; ++it) {
                readLock.lock();
            }
            writeLock.unlock();
        }
    }
}

