/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.coroutines.sync.SemaphoreSegment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000b\u001a8\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013\"\u0014\u0010\u0018\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\"\u0014\u0010\u0019\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2={"", "permits", "acquiredPermits", "Lkotlinx/coroutines/sync/Semaphore;", "Semaphore", "(II)Lkotlinx/coroutines/sync/Semaphore;", "", "id", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "prev", "createSegment", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", "T", "Lkotlin/Function0;", "action", "withPermit", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "BROKEN", "Lkotlinx/coroutines/internal/Symbol;", "CANCELLED", "MAX_SPIN_CYCLES", "I", "PERMIT", "SEGMENT_SIZE", "TAKEN", "kotlinx-coroutines-core"})
public final class SemaphoreKt {
    private static final int MAX_SPIN_CYCLES = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
    @NotNull
    private static final Symbol PERMIT = new Symbol("PERMIT");
    @NotNull
    private static final Symbol TAKEN = new Symbol("TAKEN");
    @NotNull
    private static final Symbol BROKEN = new Symbol("BROKEN");
    @NotNull
    private static final Symbol CANCELLED = new Symbol("CANCELLED");
    private static final int SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    @NotNull
    public static final Semaphore Semaphore(int permits, int acquiredPermits) {
        return new SemaphoreImpl(permits, acquiredPermits);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int n2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n3 = 0;
        }
        return SemaphoreKt.Semaphore(n2, n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object withPermit(@NotNull Semaphore var0, @NotNull Function0<? extends T> var1_1, @NotNull Continuation<? super T> var2_2) {
        if (!(var2_2 instanceof withPermit.1)) ** GOTO lbl-1000
        var6_3 = var2_2;
        if ((var6_3.label & -2147483648) != 0) {
            var6_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var2_2){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return SemaphoreKt.withPermit(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var7_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$withPermit = false;
                $continuation.L$0 = $this$withPermit;
                $continuation.L$1 = action;
                $continuation.label = 1;
                v0 = $this$withPermit.acquire((Continuation<? super Unit>)$continuation);
                if (v0 == var7_5) {
                    return var7_5;
                }
                ** GOTO lbl27
            }
            case 1: {
                $i$f$withPermit = false;
                action = (Function0)$continuation.L$1;
                $this$withPermit = (Semaphore)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl27:
                // 2 sources

                try {
                    var4_8 = action.invoke();
                    return var4_8;
                }
                finally {
                    InlineMarker.finallyStart((int)1);
                    $this$withPermit.release();
                    InlineMarker.finallyEnd((int)1);
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final <T> Object withPermit$$forInline(Semaphore $this$withPermit, Function0<? extends T> action, Continuation<? super T> $completion) {
        boolean $i$f$withPermit = false;
        InlineMarker.mark((int)0);
        $this$withPermit.acquire($completion);
        InlineMarker.mark((int)1);
        try {
            Object object = action.invoke();
            return object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            $this$withPermit.release();
            InlineMarker.finallyEnd((int)1);
        }
    }

    private static final SemaphoreSegment createSegment(long id, SemaphoreSegment prev2) {
        return new SemaphoreSegment(id, prev2, 0);
    }

    public static final /* synthetic */ SemaphoreSegment access$createSegment(long id, SemaphoreSegment prev2) {
        return SemaphoreKt.createSegment(id, prev2);
    }

    public static final /* synthetic */ int access$getSEGMENT_SIZE$p() {
        return SEGMENT_SIZE;
    }

    public static final /* synthetic */ Symbol access$getPERMIT$p() {
        return PERMIT;
    }

    public static final /* synthetic */ Symbol access$getTAKEN$p() {
        return TAKEN;
    }

    public static final /* synthetic */ int access$getMAX_SPIN_CYCLES$p() {
        return MAX_SPIN_CYCLES;
    }

    public static final /* synthetic */ Symbol access$getBROKEN$p() {
        return BROKEN;
    }

    public static final /* synthetic */ Symbol access$getCANCELLED$p() {
        return CANCELLED;
    }
}

