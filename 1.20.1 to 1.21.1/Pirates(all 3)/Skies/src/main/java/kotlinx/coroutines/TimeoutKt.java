/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.time.DurationKt
 *  kotlin.time.DurationUnit
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DelayWithTimeoutDiagnostics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutCoroutine;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000>\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001aa\u0010\u0012\u001a\u0004\u0018\u00010\u000f\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\n*\u00028\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f\u00a2\u0006\u0002\b\u0010H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001aW\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0014\u001a\u00020\u00002'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f\u00a2\u0006\u0002\b\u0010H\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a]\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0018\u001a\u00020\u00172'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f\u00a2\u0006\u0002\b\u0010H\u0086@\u00f8\u0001\u0001\u00f8\u0001\u0000\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\u0019\u0010\u0016\u001aL\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0014\u001a\u00020\u00002'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f\u00a2\u0006\u0002\b\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0016\u001aR\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0018\u001a\u00020\u00172'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f\u00a2\u0006\u0002\b\u0010H\u0086@\u00f8\u0001\u0001\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0016\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001c"}, d2={"", "time", "Lkotlinx/coroutines/Delay;", "delay", "Lkotlinx/coroutines/Job;", "coroutine", "Lkotlinx/coroutines/TimeoutCancellationException;", "TimeoutCancellationException", "(JLkotlinx/coroutines/Delay;Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/TimeoutCancellationException;", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "setupTimeout", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "timeMillis", "withTimeout", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/time/Duration;", "timeout", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"})
public final class TimeoutKt {
    @Nullable
    public static final <T> Object withTimeout(long timeMillis, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        if (timeMillis <= 0L) {
            throw new TimeoutCancellationException("Timed out immediately");
        }
        Continuation<? super T> uCont = $completion;
        boolean bl = false;
        Object object = TimeoutKt.setupTimeout(new TimeoutCoroutine(timeMillis, uCont), block);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    @Nullable
    public static final <T> Object withTimeout-KLykuaI(long timeout, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        return TimeoutKt.withTimeout(DelayKt.toDelayMillis-LRDsOJo(timeout), block, $completion);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object withTimeoutOrNull(long var0, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> var2_1, @NotNull Continuation<? super T> var3_2) {
        if (!(var3_2 instanceof withTimeoutOrNull.1)) ** GOTO lbl-1000
        var9_3 = var3_2;
        if ((var9_3.label & -2147483648) != 0) {
            var9_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var3_2){
                long J$0;
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return TimeoutKt.withTimeoutOrNull(0L, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var10_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (timeMillis <= 0L) {
                    return null;
                }
                coroutine = new Ref.ObjectRef();
                $continuation.L$0 = block;
                $continuation.L$1 = coroutine;
                $continuation.J$0 = timeMillis;
                $continuation.label = 1;
                uCont = (Continuation)$continuation;
                $i$a$-suspendCoroutineUninterceptedOrReturn-TimeoutKt$withTimeoutOrNull$2 = false;
                coroutine.element = timeoutCoroutine = new TimeoutCoroutine<U, T>(timeMillis, uCont);
                v0 = TimeoutKt.setupTimeout(timeoutCoroutine, block);
                if (v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)$continuation));
                }
                v1 = v0;
                if (v0 == var10_5) {
                    return var10_5;
                }
                ** GOTO lbl40
            }
            case 1: {
                $continuation.J$0;
                coroutine = (Ref.ObjectRef)$continuation.L$1;
                var2_1 = (Function2)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl40:
                    // 2 sources

                    return v1;
                }
                catch (TimeoutCancellationException e) {
                    if (e.coroutine == coroutine.element) {
                        return null;
                    }
                    throw e;
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public static final <T> Object withTimeoutOrNull-KLykuaI(long timeout, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        return TimeoutKt.withTimeoutOrNull(DelayKt.toDelayMillis-LRDsOJo(timeout), block, $completion);
    }

    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> coroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        Continuation cont = coroutine.uCont;
        CoroutineContext context = cont.getContext();
        JobKt.disposeOnCompletion(coroutine, DelayKt.getDelay(context).invokeOnTimeout(coroutine.time, coroutine, coroutine.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout((ScopeCoroutine)coroutine, coroutine, block);
    }

    @NotNull
    public static final TimeoutCancellationException TimeoutCancellationException(long time, @NotNull Delay delay, @NotNull Job coroutine) {
        Object object;
        block3: {
            block2: {
                object = delay instanceof DelayWithTimeoutDiagnostics ? (DelayWithTimeoutDiagnostics)delay : null;
                if (object == null) break block2;
                if ((object = object.timeoutMessage-LRDsOJo(DurationKt.toDuration((long)time, (DurationUnit)DurationUnit.MILLISECONDS))) != null) break block3;
            }
            object = "Timed out waiting for " + time + " ms";
        }
        Object message = object;
        return new TimeoutCancellationException((String)message, coroutine);
    }
}

