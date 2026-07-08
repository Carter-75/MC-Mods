/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.ThreadPoolDispatcherKt__MultithreadedDispatchers_commonKt;
import kotlinx.coroutines.ThreadPoolDispatcherKt__ThreadPoolDispatcherKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=4, xi=48, d1={"kotlinx/coroutines/ThreadPoolDispatcherKt__MultithreadedDispatchers_commonKt", "kotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt"})
public final class ThreadPoolDispatcherKt {
    @ExperimentalCoroutinesApi
    @DelicateCoroutinesApi
    @NotNull
    public static final ExecutorCoroutineDispatcher newSingleThreadContext(@NotNull String name) {
        return ThreadPoolDispatcherKt__MultithreadedDispatchers_commonKt.newSingleThreadContext(name);
    }

    @DelicateCoroutinesApi
    @NotNull
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int nThreads, @NotNull String name) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.newFixedThreadPoolContext(nThreads, name);
    }
}

