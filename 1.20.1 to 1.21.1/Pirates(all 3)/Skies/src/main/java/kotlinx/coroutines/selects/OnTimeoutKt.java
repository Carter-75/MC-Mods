/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.selects.OnTimeout;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001aN\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00020\u000b2\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u000e"}, d2={"R", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "timeMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "", "onTimeout", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", "Lkotlin/time/Duration;", "timeout", "onTimeout-8Mi8wO0", "kotlinx-coroutines-core"})
public final class OnTimeoutKt {
    @ExperimentalCoroutinesApi
    public static final <R> void onTimeout(@NotNull SelectBuilder<? super R> $this$onTimeout, long timeMillis, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        $this$onTimeout.invoke(new OnTimeout(timeMillis).getSelectClause(), block);
    }

    @ExperimentalCoroutinesApi
    public static final <R> void onTimeout-8Mi8wO0(@NotNull SelectBuilder<? super R> $this$onTimeout_u2d8Mi8wO0, long timeout, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        OnTimeoutKt.onTimeout($this$onTimeout_u2d8Mi8wO0, DelayKt.toDelayMillis-LRDsOJo(timeout), block);
    }
}

