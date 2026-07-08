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
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Ref$ObjectRef
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002Bg\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011\u0012:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007RH\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2={"Lkotlinx/coroutines/flow/DistinctFlowImpl;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "old", "new", "", "areEquivalent", "Lkotlin/jvm/functions/Function2;", "Lkotlin/Function1;", "keySelector", "Lkotlin/jvm/functions/Function1;", "upstream", "Lkotlinx/coroutines/flow/Flow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
final class DistinctFlowImpl<T>
implements Flow<T> {
    @NotNull
    private final Flow<T> upstream;
    @JvmField
    @NotNull
    public final Function1<T, Object> keySelector;
    @JvmField
    @NotNull
    public final Function2<Object, Object, Boolean> areEquivalent;

    public DistinctFlowImpl(@NotNull Flow<? extends T> upstream, @NotNull Function1<? super T, ? extends Object> keySelector, @NotNull Function2<Object, Object, Boolean> areEquivalent) {
        this.upstream = upstream;
        this.keySelector = keySelector;
        this.areEquivalent = areEquivalent;
    }

    @Override
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
        Ref.ObjectRef previousKey = new Ref.ObjectRef();
        previousKey.element = NullSurrogateKt.NULL;
        Object object = this.upstream.collect(new FlowCollector(this, (Ref.ObjectRef<Object>)previousKey, collector2){
            final /* synthetic */ DistinctFlowImpl<T> this$0;
            final /* synthetic */ Ref.ObjectRef<Object> $previousKey;
            final /* synthetic */ FlowCollector<T> $collector;
            {
                this.this$0 = $receiver;
                this.$previousKey = $previousKey;
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
                        key = this.this$0.keySelector.invoke((Object)value);
                        if (this.$previousKey.element != NullSurrogateKt.NULL && ((Boolean)this.this$0.areEquivalent.invoke(this.$previousKey.element, key)).booleanValue()) break;
                        this.$previousKey.element = key;
                        $continuation.label = 1;
                        v0 = this.$collector.emit(value, (Continuation<Unit>)$continuation);
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
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }
}

