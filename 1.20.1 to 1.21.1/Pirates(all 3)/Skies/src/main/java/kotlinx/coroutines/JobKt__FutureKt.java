/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancelFutureOnCancel;
import kotlinx.coroutines.CancelFutureOnCompletion;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00062\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0007\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lkotlinx/coroutines/CancellableContinuation;", "Ljava/util/concurrent/Future;", "future", "", "cancelFutureOnCancellation", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/util/concurrent/Future;)V", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/DisposableHandle;", "cancelFutureOnCompletion", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/Future;)Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/JobKt")
final class JobKt__FutureKt {
    @InternalCoroutinesApi
    @NotNull
    public static final DisposableHandle cancelFutureOnCompletion(@NotNull Job $this$cancelFutureOnCompletion, @NotNull Future<?> future) {
        return $this$cancelFutureOnCompletion.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new CancelFutureOnCompletion(future)));
    }

    public static final void cancelFutureOnCancellation(@NotNull CancellableContinuation<?> $this$cancelFutureOnCancellation, @NotNull Future<?> future) {
        $this$cancelFutureOnCancellation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new CancelFutureOnCancel(future)));
    }
}

