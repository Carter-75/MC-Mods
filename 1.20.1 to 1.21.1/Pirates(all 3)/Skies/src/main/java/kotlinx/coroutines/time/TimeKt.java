/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines.time;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001aW\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0001\u001a\u00020\u00002'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u00a2\u0006\u0002\b\nH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\f\u0010\r\u001aL\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0001\u001a\u00020\u00002'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u00a2\u0006\u0002\b\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\r\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0013\u001a\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001aF\u0010\u0019\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0001\u001a\u00020\u00002\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0018\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u001b\u001a\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u001c\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2={"Ljava/time/Duration;", "duration", "", "delay", "(Ljava/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "withTimeout", "(Ljava/time/Duration;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "", "coerceToMillis", "(Ljava/time/Duration;)J", "Lkotlinx/coroutines/flow/Flow;", "timeout", "debounce", "(Lkotlinx/coroutines/flow/Flow;Ljava/time/Duration;)Lkotlinx/coroutines/flow/Flow;", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlin/Function1;", "onTimeout", "(Lkotlinx/coroutines/selects/SelectBuilder;Ljava/time/Duration;Lkotlin/jvm/functions/Function1;)V", "period", "sample", "kotlinx-coroutines-core"})
public final class TimeKt {
    @Nullable
    public static final Object delay(@NotNull Duration duration, @NotNull Continuation<? super Unit> $completion) {
        Object object = DelayKt.delay(TimeKt.coerceToMillis(duration), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> $this$debounce, @NotNull Duration timeout) {
        return FlowKt.debounce($this$debounce, TimeKt.coerceToMillis(timeout));
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> $this$sample, @NotNull Duration period) {
        return FlowKt.sample($this$sample, TimeKt.coerceToMillis(period));
    }

    public static final <R> void onTimeout(@NotNull SelectBuilder<? super R> $this$onTimeout, @NotNull Duration duration, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        OnTimeoutKt.onTimeout($this$onTimeout, TimeKt.coerceToMillis(duration), block);
    }

    @Nullable
    public static final <T> Object withTimeout(@NotNull Duration duration, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        return TimeoutKt.withTimeout(TimeKt.coerceToMillis(duration), block, $completion);
    }

    @Nullable
    public static final <T> Object withTimeoutOrNull(@NotNull Duration duration, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        return TimeoutKt.withTimeoutOrNull(TimeKt.coerceToMillis(duration), block, $completion);
    }

    private static final long coerceToMillis(Duration $this$coerceToMillis) {
        if ($this$coerceToMillis.compareTo(Duration.ZERO) <= 0) {
            return 0L;
        }
        if ($this$coerceToMillis.compareTo(ChronoUnit.MILLIS.getDuration()) <= 0) {
            return 1L;
        }
        long maxSeconds = 9223372036854775L;
        int maxNanos = 807000000;
        return $this$coerceToMillis.getSeconds() < maxSeconds || $this$coerceToMillis.getSeconds() == maxSeconds && $this$coerceToMillis.getNano() < maxNanos ? $this$coerceToMillis.toMillis() : Long.MAX_VALUE;
    }
}

