/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.YieldContext;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0003"}, d2={"", "yield", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class YieldKt {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public static final Object yield(@NotNull Continuation<? super Unit> $completion) {
        block5: {
            block6: {
                block4: {
                    uCont = $completion;
                    $i$a$-suspendCoroutineUninterceptedOrReturn-YieldKt$yield$2 = false;
                    context = uCont.getContext();
                    JobKt.ensureActive(context);
                    var4_4 = IntrinsicsKt.intercepted(uCont);
                    v0 = var4_4 instanceof DispatchedContinuation != false ? (DispatchedContinuation)var4_4 : null;
                    if (v0 != null) break block4;
                    v1 /* !! */  = Unit.INSTANCE;
                    break block5;
                }
                cont = v0;
                if (!cont.dispatcher.isDispatchNeeded(context)) break block6;
                cont.dispatchYield$kotlinx_coroutines_core(context, Unit.INSTANCE);
                ** GOTO lbl-1000
            }
            yieldContext = new YieldContext();
            cont.dispatchYield$kotlinx_coroutines_core(context.plus((CoroutineContext)yieldContext), Unit.INSTANCE);
            if (yieldContext.dispatcherWasUnconfined) {
                v1 /* !! */  = DispatchedContinuationKt.yieldUndispatched(cont) ? IntrinsicsKt.getCOROUTINE_SUSPENDED() : Unit.INSTANCE;
            } else lbl-1000:
            // 2 sources

            {
                v1 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }
        if (v1 /* !! */  == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (v1 /* !! */  == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1 /* !! */ ;
        }
        return Unit.INSTANCE;
    }
}

