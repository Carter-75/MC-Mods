/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Ref$IntRef
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__CountKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a#\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2={"T", "Lkotlinx/coroutines/flow/Flow;", "", "count", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CountKt {
    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object count(@NotNull Flow<? extends T> var0, @NotNull Continuation<? super Integer> var1_1) {
        if (!(var1_1 instanceof count.1)) ** GOTO lbl-1000
        var4_2 = var1_1;
        if ((var4_2.label & -2147483648) != 0) {
            var4_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var1_1){
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.count(null, (Continuation<? super Integer>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                i = new Ref.IntRef();
                $continuation.L$0 = i;
                $continuation.label = 1;
                v0 = $this$count.collect(new FlowCollector(i){
                    final /* synthetic */ Ref.IntRef $i;
                    {
                        this.$i = $i;
                    }

                    @Nullable
                    public final Object emit(T it, @NotNull Continuation<? super Unit> $completion) {
                        ++this.$i.element;
                        int cfr_ignored_0 = this.$i.element;
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$continuation);
                if (v0 == var5_4) {
                    return var5_4;
                }
                ** GOTO lbl23
            }
            case 1: {
                i = (Ref.IntRef)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl23:
                // 2 sources

                return Boxing.boxInt((int)i.element);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object count(@NotNull Flow<? extends T> var0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> var1_1, @NotNull Continuation<? super Integer> var2_2) {
        if (!(var2_2 instanceof count.3)) ** GOTO lbl-1000
        var5_3 = var2_2;
        if ((var5_3.label & -2147483648) != 0) {
            var5_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var2_2){
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.count(null, null, (Continuation<? super Integer>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                i = new Ref.IntRef();
                $continuation.L$0 = i;
                $continuation.label = 1;
                v0 = $this$count.collect(new FlowCollector(predicate, i){
                    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;
                    final /* synthetic */ Ref.IntRef $i;
                    {
                        this.$predicate = $predicate;
                        this.$i = $i;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof count.emit.1)) ** GOTO lbl-1000
                        var4_3 = var2_2;
                        if ((var4_3.label & -2147483648) != 0) {
                            var4_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                Object L$0;
                                /* synthetic */ Object result;
                                final /* synthetic */ count.4<T> this$0;
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
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                $continuation.L$0 = this;
                                $continuation.label = 1;
                                v0 = this.$predicate.invoke((Object)value, (Object)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl22
                            }
                            case 1: {
                                this = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl22:
                                // 2 sources

                                if (((Boolean)v0).booleanValue()) {
                                    ++this.$i.element;
                                    this.$i.element;
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (Continuation<Unit>)$continuation);
                if (v0 == var6_5) {
                    return var6_5;
                }
                ** GOTO lbl23
            }
            case 1: {
                i = (Ref.IntRef)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl23:
                // 2 sources

                return Boxing.boxInt((int)i.element);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

