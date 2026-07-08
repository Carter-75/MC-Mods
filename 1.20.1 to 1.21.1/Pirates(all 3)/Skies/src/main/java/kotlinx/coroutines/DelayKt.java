/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.time.Duration
 */
package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0086@\u00f8\u0001\u0001\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u0007\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\bH\u0000\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\"\u0018\u0010\u0006\u001a\u00020\u000f*\u00020\u000e8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0012"}, d2={"", "awaitCancellation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "delay", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/time/Duration;", "duration", "delay-VtjQ1oo", "toDelayMillis-LRDsOJo", "(J)J", "toDelayMillis", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/Delay;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n314#2,11:174\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n*L\n106#1:163,11\n127#1:174,11\n*E\n"})
public final class DelayKt {
    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final Object awaitCancellation(@NotNull Continuation<?> var0) {
        if (!(var0 instanceof awaitCancellation.1)) ** GOTO lbl-1000
        var7_1 = var0;
        if ((var7_1.label & -2147483648) != 0) {
            var7_1.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var0){
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return DelayKt.awaitCancellation((Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var8_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$suspendCancellableCoroutine = false;
                $continuation.label = 1;
                uCont$iv = (Continuation)$continuation;
                $i$a$-suspendCoroutineUninterceptedOrReturn-CancellableContinuationKt$suspendCancellableCoroutine$2$iv = false;
                cancellable$iv = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted((Continuation)uCont$iv), 1);
                cancellable$iv.initCancellability();
                (CancellableContinuation)cancellable$iv;
                $i$a$-suspendCancellableCoroutine-DelayKt$awaitCancellation$2 = false;
                v0 = cancellable$iv.getResult();
                if (v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)$continuation));
                }
                v1 = v0;
                if (v0 == var8_3) {
                    return var8_3;
                }
                ** GOTO lbl35
            }
            case 1: {
                $i$f$suspendCancellableCoroutine = false;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl35:
                // 2 sources

                throw new KotlinNothingValueException();
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public static final Object delay(long timeMillis, @NotNull Continuation<? super Unit> $completion) {
        if (timeMillis <= 0L) {
            return Unit.INSTANCE;
        }
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl2 = false;
        if (timeMillis < Long.MAX_VALUE) {
            DelayKt.getDelay(cont.getContext()).scheduleResumeAfterDelay(timeMillis, cont);
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object delay-VtjQ1oo(long duration, @NotNull Continuation<? super Unit> $completion) {
        Object object = DelayKt.delay(DelayKt.toDelayMillis-LRDsOJo(duration), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public static final Delay getDelay(@NotNull CoroutineContext $this$delay) {
        CoroutineContext.Element element = $this$delay.get((CoroutineContext.Key)ContinuationInterceptor.Key);
        Delay delay = element instanceof Delay ? (Delay)element : null;
        if (delay == null) {
            delay = DefaultExecutorKt.getDefaultDelay();
        }
        return delay;
    }

    public static final long toDelayMillis-LRDsOJo(long $this$toDelayMillis_u2dLRDsOJo) {
        return Duration.compareTo-LRDsOJo((long)$this$toDelayMillis_u2dLRDsOJo, (long)Duration.Companion.getZERO-UwyO8pc()) > 0 ? RangesKt.coerceAtLeast((long)Duration.getInWholeMilliseconds-impl((long)$this$toDelayMillis_u2dLRDsOJo), (long)1L) : 0L;
    }
}

