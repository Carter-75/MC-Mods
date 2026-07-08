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
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.CancellableFlowImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/flow/CancellableFlowImpl;", "T", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;)V", "kotlinx-coroutines-core"})
final class CancellableFlowImpl<T>
implements CancellableFlow<T> {
    @NotNull
    private final Flow<T> flow;

    public CancellableFlowImpl(@NotNull Flow<? extends T> flow) {
        this.flow = flow;
    }

    @Override
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.flow.collect(new FlowCollector(collector2){
            final /* synthetic */ FlowCollector<T> $collector;
            {
                this.$collector = $collector;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof collect.emit.1)) ** GOTO lbl-1000
                var5_3 = var2_2;
                if ((var5_3.label & -2147483648) != 0) {
                    var5_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        final /* synthetic */ collect.2<T> this$0;
                        int label;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                        }
                    };
                }
                $result = $continuation.result;
                var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        $i$f$currentCoroutineContext = false;
                        JobKt.ensureActive($continuation.getContext());
                        $continuation.label = 1;
                        v0 = this.$collector.emit(it, (Continuation<Unit>)$continuation);
                        if (v0 == var6_5) {
                            return var6_5;
                        }
                        ** GOTO lbl23
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl23:
                        // 2 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }
}

