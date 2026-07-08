/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 */
package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\b"}, d2={"Lkotlinx/coroutines/DelayWithTimeoutDiagnostics;", "Lkotlinx/coroutines/Delay;", "Lkotlin/time/Duration;", "timeout", "", "timeoutMessage-LRDsOJo", "(J)Ljava/lang/String;", "timeoutMessage", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
public interface DelayWithTimeoutDiagnostics
extends Delay {
    @NotNull
    public String timeoutMessage-LRDsOJo(long var1);

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated(message="Deprecated without replacement as an internal method never intended for public use", level=DeprecationLevel.ERROR)
        @Nullable
        public static Object delay(@NotNull DelayWithTimeoutDiagnostics $this, long time, @NotNull Continuation<? super Unit> $completion) {
            Object object = Delay.DefaultImpls.delay($this, time, $completion);
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return object;
            }
            return Unit.INSTANCE;
        }

        @NotNull
        public static DisposableHandle invokeOnTimeout(@NotNull DelayWithTimeoutDiagnostics $this, long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
            return Delay.DefaultImpls.invokeOnTimeout($this, timeMillis, block, context);
        }
    }
}

