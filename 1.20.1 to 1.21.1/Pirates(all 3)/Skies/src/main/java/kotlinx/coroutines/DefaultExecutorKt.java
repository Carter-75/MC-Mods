/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u0001\u0010\u0002\" \u0010\u0003\u001a\u00020\u00008\u0000X\u0081\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0005\u0010\u0002\"\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlinx/coroutines/Delay;", "initializeDefaultDelay", "()Lkotlinx/coroutines/Delay;", "DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "getDefaultDelay$annotations", "()V", "", "defaultMainDelayOptIn", "Z", "kotlinx-coroutines-core"})
public final class DefaultExecutorKt {
    private static final boolean defaultMainDelayOptIn = SystemPropsKt.systemProp("kotlinx.coroutines.main.delay", false);
    @NotNull
    private static final Delay DefaultDelay = DefaultExecutorKt.initializeDefaultDelay();

    @NotNull
    public static final Delay getDefaultDelay() {
        return DefaultDelay;
    }

    @PublishedApi
    public static /* synthetic */ void getDefaultDelay$annotations() {
    }

    private static final Delay initializeDefaultDelay() {
        if (!defaultMainDelayOptIn) {
            return DefaultExecutor.INSTANCE;
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        return MainDispatchersKt.isMissing(main) || !(main instanceof Delay) ? (Delay)DefaultExecutor.INSTANCE : (Delay)((Object)main);
    }
}

