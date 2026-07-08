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
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SubscribedFlowCollector;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BG\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\r\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t\u00a2\u0006\u0002\b\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR>\u0010\r\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t\u00a2\u0006\u0002\b\f8\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "action", "Lkotlin/jvm/functions/Function2;", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,426:1\n329#2:427\n*S KotlinDebug\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n*L\n417#1:427\n*E\n"})
public final class SubscribedFlowCollector<T>
implements FlowCollector<T> {
    @NotNull
    private final FlowCollector<T> collector;
    @NotNull
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> action;

    public SubscribedFlowCollector(@NotNull FlowCollector<? super T> collector2, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        this.collector = collector2;
        this.action = action;
    }

    @Override
    @Nullable
    public Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
        return this.collector.emit(value, $completion);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public final Object onSubscription(@NotNull Continuation<? super Unit> var1_1) {
        if (!(var1_1 instanceof onSubscription.1)) ** GOTO lbl-1000
        var5_2 = var1_1;
        if ((var5_2.label & -2147483648) != 0) {
            var5_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, var1_1){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                final /* synthetic */ SubscribedFlowCollector<T> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.onSubscription((Continuation<Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var6_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$currentCoroutineContext = false;
                safeCollector = new SafeCollector<T>(this.collector, $continuation.getContext());
                $continuation.L$0 = this;
                $continuation.L$1 = safeCollector;
                $continuation.label = 1;
                v0 = this.action.invoke(safeCollector, (Object)$continuation);
                ** if (v0 != var6_4) goto lbl23
lbl22:
                // 1 sources

                return var6_4;
lbl23:
                // 1 sources

                ** GOTO lbl37
            }
            case 1: {
                safeCollector = (SafeCollector<T>)$continuation.L$1;
                this = (SubscribedFlowCollector)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (Throwable var3_6) {
                    throw var3_6;
                }
                finally {
                    safeCollector.releaseIntercepted();
                }
lbl37:
                // 2 sources

                if (!(this.collector instanceof SubscribedFlowCollector)) break;
                $continuation.L$0 = null;
                $continuation.L$1 = null;
                $continuation.label = 2;
                v1 = ((SubscribedFlowCollector)this.collector).onSubscription((Continuation<Unit>)$continuation);
                if (v1 == var6_4) {
                    return var6_4;
                }
                ** GOTO lbl48
            }
            case 2: {
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl48:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

