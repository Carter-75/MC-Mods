/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Ref$BooleanRef
 */
package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/flow/StartedLazily;", "Lkotlinx/coroutines/flow/SharingStarted;", "Lkotlinx/coroutines/flow/StateFlow;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "command", "(Lkotlinx/coroutines/flow/StateFlow;)Lkotlinx/coroutines/flow/Flow;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "kotlinx-coroutines-core"})
final class StartedLazily
implements SharingStarted {
    @Override
    @NotNull
    public Flow<SharingCommand> command(@NotNull StateFlow<Integer> subscriptionCount) {
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super SharingCommand>, Continuation<? super Unit>, Object>(subscriptionCount, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ StateFlow<Integer> $subscriptionCount;
            {
                this.$subscriptionCount = $subscriptionCount;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        Ref.BooleanRef started = new Ref.BooleanRef();
                        this.label = 1;
                        Object object3 = this.$subscriptionCount.collect((FlowCollector<Integer>)new FlowCollector(started, $this$flow){
                            final /* synthetic */ Ref.BooleanRef $started;
                            final /* synthetic */ FlowCollector<SharingCommand> $$this$flow;
                            {
                                this.$started = $started;
                                this.$$this$flow = $$this$flow;
                            }

                            /*
                             * Unable to fully structure code
                             */
                            @Nullable
                            public final Object emit(int var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                if (!(var2_2 instanceof command.emit.1)) ** GOTO lbl-1000
                                var4_3 = var2_2;
                                if ((var4_3.label & -2147483648) != 0) {
                                    var4_3.label -= -2147483648;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    $continuation = new ContinuationImpl(this, var2_2){
                                        /* synthetic */ Object result;
                                        final /* synthetic */ command.1<T> this$0;
                                        int label;
                                        {
                                            this.this$0 = this$0;
                                            super($completion);
                                        }

                                        @Nullable
                                        public final Object invokeSuspend(@NotNull Object $result) {
                                            this.result = $result;
                                            this.label |= Integer.MIN_VALUE;
                                            return this.this$0.emit(0, (Continuation<Unit>)((Continuation)this));
                                        }
                                    };
                                }
                                $result = $continuation.result;
                                var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        if (count <= 0 || this.$started.element) break;
                                        this.$started.element = true;
                                        $continuation.label = 1;
                                        v0 = this.$$this$flow.emit(SharingCommand.START, (Continuation<Unit>)$continuation);
                                        if (v0 == var5_5) {
                                            return var5_5;
                                        }
                                        ** GOTO lbl22
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = $result;
lbl22:
                                        // 2 sources

                                        return Unit.INSTANCE;
                                    }
                                }
                                return Unit.INSTANCE;
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (Continuation<?>)((Continuation)this));
                        if (object3 != object2) throw new KotlinNothingValueException();
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        throw new KotlinNothingValueException();
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<FlowCollector<? super SharingCommand>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super SharingCommand> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Lazily";
    }
}

