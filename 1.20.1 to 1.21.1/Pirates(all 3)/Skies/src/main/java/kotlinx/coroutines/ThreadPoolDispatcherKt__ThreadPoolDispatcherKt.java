/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"", "nThreads", "", "name", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "newFixedThreadPoolContext", "(ILjava/lang/String;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/ThreadPoolDispatcherKt")
@SourceDebugExtension(value={"SMAP\nThreadPoolDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadPoolDispatcher.kt\nkotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
final class ThreadPoolDispatcherKt__ThreadPoolDispatcherKt {
    @DelicateCoroutinesApi
    @NotNull
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int nThreads, @NotNull String name) {
        if (!(nThreads >= 1)) {
            boolean $i$a$-require-ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$newFixedThreadPoolContext$22 = false;
            String $i$a$-require-ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$newFixedThreadPoolContext$22 = "Expected at least one thread, but " + nThreads + " specified";
            throw new IllegalArgumentException($i$a$-require-ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$newFixedThreadPoolContext$22.toString());
        }
        AtomicInteger threadNo = new AtomicInteger();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(nThreads, arg_0 -> ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.newFixedThreadPoolContext$lambda$1$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt(nThreads, name, threadNo, arg_0));
        return ExecutorsKt.from(executor);
    }

    private static final Thread newFixedThreadPoolContext$lambda$1$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt(int $nThreads, String $name, AtomicInteger $threadNo, Runnable runnable) {
        Thread t = new Thread(runnable, $nThreads == 1 ? $name : $name + '-' + $threadNo.incrementAndGet());
        t.setDaemon(true);
        return t;
    }
}

