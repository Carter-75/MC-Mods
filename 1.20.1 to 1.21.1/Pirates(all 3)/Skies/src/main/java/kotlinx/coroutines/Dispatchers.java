/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.Unconfined;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004R \u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u0004\u001a\u0004\b\b\u0010\tR \u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\f\u0010\tR\u001a\u0010\u0012\u001a\u00020\u000e8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0014\u0010\t\u00a8\u0006\u0017"}, d2={"Lkotlinx/coroutines/Dispatchers;", "", "", "shutdown", "()V", "Lkotlinx/coroutines/CoroutineDispatcher;", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "IO", "getIO", "getIO$annotations", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "Main", "Unconfined", "getUnconfined", "getUnconfined$annotations", "<init>", "kotlinx-coroutines-core"})
public final class Dispatchers {
    @NotNull
    public static final Dispatchers INSTANCE = new Dispatchers();
    @NotNull
    private static final CoroutineDispatcher Default = DefaultScheduler.INSTANCE;
    @NotNull
    private static final CoroutineDispatcher Unconfined = kotlinx.coroutines.Unconfined.INSTANCE;
    @NotNull
    private static final CoroutineDispatcher IO = DefaultIoScheduler.INSTANCE;

    private Dispatchers() {
    }

    @NotNull
    public static final CoroutineDispatcher getDefault() {
        return Default;
    }

    @JvmStatic
    public static /* synthetic */ void getDefault$annotations() {
    }

    @NotNull
    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    @JvmStatic
    public static /* synthetic */ void getMain$annotations() {
    }

    @NotNull
    public static final CoroutineDispatcher getUnconfined() {
        return Unconfined;
    }

    @JvmStatic
    public static /* synthetic */ void getUnconfined$annotations() {
    }

    @NotNull
    public static final CoroutineDispatcher getIO() {
        return IO;
    }

    @JvmStatic
    public static /* synthetic */ void getIO$annotations() {
    }

    @DelicateCoroutinesApi
    public final void shutdown() {
        DefaultExecutor.INSTANCE.shutdown();
        DefaultScheduler.INSTANCE.shutdown$kotlinx_coroutines_core();
    }
}

