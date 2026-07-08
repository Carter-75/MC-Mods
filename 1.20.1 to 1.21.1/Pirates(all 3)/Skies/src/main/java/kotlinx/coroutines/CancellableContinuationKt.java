/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandlerBase;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.DisposeOnCancel;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\b0\u0006H\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u000b\u001a\u001f\u0010\u000f\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2={"T", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getOrCreateCancellableContinuation", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "block", "suspendCancellableCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "Lkotlinx/coroutines/DisposableHandle;", "handle", "disposeOnCancellation", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCancellableContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n*L\n1#1,386:1\n1#2:387\n19#3:388\n*S KotlinDebug\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n380#1:388\n*E\n"})
public final class CancellableContinuationKt {
    @Nullable
    public static final <T> Object suspendCancellableCoroutine(@NotNull Function1<? super CancellableContinuation<? super T>, Unit> block, @NotNull Continuation<? super T> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super T> uCont = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont), 1);
        cancellable.initCancellability();
        block.invoke(cancellable);
        Object object = cancellable.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    private static final <T> Object suspendCancellableCoroutine$$forInline(Function1<? super CancellableContinuation<? super T>, Unit> block, Continuation<? super T> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        InlineMarker.mark((int)0);
        Continuation<? super T> uCont = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont), 1);
        cancellable.initCancellability();
        block.invoke(cancellable);
        Object object = cancellable.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        InlineMarker.mark((int)1);
        return object;
    }

    @Nullable
    public static final <T> Object suspendCancellableCoroutineReusable(@NotNull Function1<? super CancellableContinuationImpl<? super T>, Unit> block, @NotNull Continuation<? super T> $completion) {
        boolean $i$f$suspendCancellableCoroutineReusable = false;
        Continuation<? super T> uCont = $completion;
        boolean bl = false;
        CancellableContinuationImpl<T> cancellable = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont));
        try {
            block.invoke(cancellable);
        }
        catch (Throwable e2) {
            cancellable.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw e2;
        }
        Object object = cancellable.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    private static final <T> Object suspendCancellableCoroutineReusable$$forInline(Function1<? super CancellableContinuationImpl<? super T>, Unit> block, Continuation<? super T> $completion) {
        boolean $i$f$suspendCancellableCoroutineReusable = false;
        InlineMarker.mark((int)0);
        Continuation<? super T> uCont = $completion;
        boolean bl = false;
        CancellableContinuationImpl<T> cancellable = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont));
        try {
            block.invoke(cancellable);
        }
        catch (Throwable e2) {
            cancellable.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw e2;
        }
        Object object = cancellable.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        InlineMarker.mark((int)1);
        return object;
    }

    @NotNull
    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(@NotNull Continuation<? super T> delegate) {
        CancellableContinuationImpl cancellableContinuationImpl;
        block5: {
            block4: {
                CancellableContinuationImpl cancellableContinuationImpl2;
                if (!(delegate instanceof DispatchedContinuation)) {
                    return new CancellableContinuationImpl<T>(delegate, 1);
                }
                cancellableContinuationImpl = ((DispatchedContinuation)delegate).claimReusableCancellableContinuation$kotlinx_coroutines_core();
                if (cancellableContinuationImpl == null) break block4;
                CancellableContinuationImpl it = cancellableContinuationImpl2 = cancellableContinuationImpl;
                boolean bl = false;
                cancellableContinuationImpl = it.resetStateReusable() ? cancellableContinuationImpl2 : null;
                if (cancellableContinuationImpl != null) break block5;
            }
            return new CancellableContinuationImpl<T>(delegate, 2);
        }
        return cancellableContinuationImpl;
    }

    @InternalCoroutinesApi
    public static final void disposeOnCancellation(@NotNull CancellableContinuation<?> $this$disposeOnCancellation, @NotNull DisposableHandle handle) {
        CancelHandlerBase $this$asHandler$iv = new DisposeOnCancel(handle);
        boolean $i$f$getAsHandler = false;
        $this$disposeOnCancellation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)$this$asHandler$iv));
    }
}

