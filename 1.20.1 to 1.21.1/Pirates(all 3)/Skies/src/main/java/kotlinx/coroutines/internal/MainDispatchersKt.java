/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import kotlinx.coroutines.internal.MissingMainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\u001a'\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u000f\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0007\u00a2\u0006\u0004\b\f\u0010\r\u001a!\u0010\u0011\u001a\u00020\n*\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000fH\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"", "cause", "", "errorHint", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "createMissingDispatcher", "(Ljava/lang/Throwable;Ljava/lang/String;)Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "", "throwMissingMainDispatcherException", "()Ljava/lang/Void;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "", "isMissing", "(Lkotlinx/coroutines/MainCoroutineDispatcher;)Z", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "factories", "tryCreateDispatcher", "(Lkotlinx/coroutines/internal/MainDispatcherFactory;Ljava/util/List;)Lkotlinx/coroutines/MainCoroutineDispatcher;", "FAST_SERVICE_LOADER_PROPERTY_NAME", "Ljava/lang/String;", "SUPPORT_MISSING", "Z", "getSUPPORT_MISSING$annotations", "()V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatchersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class MainDispatchersKt {
    @NotNull
    private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";
    private static final boolean SUPPORT_MISSING = true;

    @InternalCoroutinesApi
    @NotNull
    public static final MainCoroutineDispatcher tryCreateDispatcher(@NotNull MainDispatcherFactory $this$tryCreateDispatcher, @NotNull List<? extends MainDispatcherFactory> factories) {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        try {
            mainCoroutineDispatcher = $this$tryCreateDispatcher.createDispatcher(factories);
        }
        catch (Throwable cause) {
            mainCoroutineDispatcher = MainDispatchersKt.createMissingDispatcher(cause, $this$tryCreateDispatcher.hintOnError());
        }
        return mainCoroutineDispatcher;
    }

    @InternalCoroutinesApi
    public static final boolean isMissing(@NotNull MainCoroutineDispatcher $this$isMissing) {
        return $this$isMissing.getImmediate() instanceof MissingMainCoroutineDispatcher;
    }

    private static /* synthetic */ void getSUPPORT_MISSING$annotations() {
    }

    private static final MissingMainCoroutineDispatcher createMissingDispatcher(Throwable cause, String errorHint) {
        if (!SUPPORT_MISSING) {
            if (cause != null) {
                Throwable it = cause;
                boolean bl = false;
                throw it;
            }
            MainDispatchersKt.throwMissingMainDispatcherException();
            throw new KotlinNothingValueException();
        }
        return new MissingMainCoroutineDispatcher(cause, errorHint);
    }

    static /* synthetic */ MissingMainCoroutineDispatcher createMissingDispatcher$default(Throwable throwable, String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            throwable = null;
        }
        if ((n2 & 2) != 0) {
            string = null;
        }
        return MainDispatchersKt.createMissingDispatcher(throwable, string);
    }

    @NotNull
    public static final Void throwMissingMainDispatcherException() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}

