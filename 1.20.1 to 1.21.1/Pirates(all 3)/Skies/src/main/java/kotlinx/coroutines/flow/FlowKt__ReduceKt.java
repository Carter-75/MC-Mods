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
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$first$;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001aG\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\t\u001a%\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u0003\u001aI\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\t\u001a{\u0010\u0013\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00028\u00012H\b\u0004\u0010\u0012\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\rH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0003\u001a%\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0003\u001au\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0017\"\b\b\u0001\u0010\u0000*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00012F\u0010\u0012\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a#\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0003\u001a%\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2={"T", "Lkotlinx/coroutines/flow/Flow;", "first", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "R", "initial", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "acc", "value", "operation", "fold", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastOrNull", "S", "accumulator", "reduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "singleOrNull", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,172:1\n126#2,15:173\n126#2,15:188\n126#2,15:203\n126#2,15:218\n126#2,15:233\n*S KotlinDebug\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n72#1:173,15\n92#1:188,15\n106#1:203,15\n124#1:218,15\n137#1:233,15\n*E\n"})
final class FlowKt__ReduceKt {
    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <S, T extends S> Object reduce(@NotNull Flow<? extends T> var0, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> var1_1, @NotNull Continuation<? super S> var2_2) {
        if (!(var2_2 instanceof reduce.1)) ** GOTO lbl-1000
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
                    return FlowKt.reduce(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                accumulator = new Ref.ObjectRef();
                accumulator.element = NullSurrogateKt.NULL;
                $continuation.L$0 = accumulator;
                $continuation.label = 1;
                v0 = $this$reduce.collect(new FlowCollector((Ref.ObjectRef<Object>)accumulator, operation){
                    final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
                    final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> $operation;
                    {
                        this.$accumulator = $accumulator;
                        this.$operation = $operation;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        block7: {
                            if (!(var2_2 instanceof reduce.emit.1)) ** GOTO lbl-1000
                            var5_3 = var2_2;
                            if ((var5_3.label & -2147483648) != 0) {
                                var5_3.label -= -2147483648;
                            } else lbl-1000:
                            // 2 sources

                            {
                                $continuation = new ContinuationImpl(this, var2_2){
                                    Object L$0;
                                    /* synthetic */ Object result;
                                    final /* synthetic */ reduce.2<T> this$0;
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
                                    v0 = this.$accumulator;
                                    if (this.$accumulator.element == NullSurrogateKt.NULL) break;
                                    var3_6 = v0;
                                    $continuation.L$0 = var3_6;
                                    $continuation.label = 1;
                                    v1 = this.$operation.invoke(this.$accumulator.element, (Object)value, (Object)$continuation);
                                    if (v1 == var6_5) {
                                        return var6_5;
                                    }
                                    ** GOTO lbl25
                                }
                                case 1: {
                                    var3_6 = (Ref.ObjectRef)$continuation.L$0;
                                    ResultKt.throwOnFailure((Object)$result);
                                    v1 = $result;
lbl25:
                                    // 2 sources

                                    v2 = v1;
                                    v0 = var3_6;
                                    break block7;
                                }
                            }
                            v2 = var1_1;
                        }
                        v0.element = v2;
                        return Unit.INSTANCE;
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (Continuation<Unit>)$continuation);
                if (v0 == var6_5) {
                    return var6_5;
                }
                ** GOTO lbl24
            }
            case 1: {
                accumulator = (Ref.ObjectRef)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                if (accumulator.element == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Empty flow can't be reduced");
                }
                return accumulator.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T, R> Object fold(@NotNull Flow<? extends T> var0, R var1_1, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> var2_2, @NotNull Continuation<? super R> var3_3) {
        if (!(var3_3 instanceof fold.1)) ** GOTO lbl-1000
        var7_4 = var3_3;
        if ((var7_4.label & -2147483648) != 0) {
            var7_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var3_3){
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt__ReduceKt.fold(null, null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var8_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$fold = false;
                accumulator = new Ref.ObjectRef();
                accumulator.element = initial;
                $continuation.L$0 = accumulator;
                $continuation.label = 1;
                v0 = $this$fold.collect(new FlowCollector(accumulator, operation){
                    final /* synthetic */ Ref.ObjectRef<R> $accumulator;
                    final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;
                    {
                        this.$accumulator = $accumulator;
                        this.$operation = $operation;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof fold.emit.1)) ** GOTO lbl-1000
                        var5_3 = var2_2;
                        if ((var5_3.label & -2147483648) != 0) {
                            var5_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                Object L$0;
                                /* synthetic */ Object result;
                                final /* synthetic */ fold.2<T> this$0;
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
                                $continuation.L$0 = var3_6 = this.$accumulator;
                                $continuation.label = 1;
                                v0 = this.$operation.invoke(this.$accumulator.element, (Object)value, (Object)$continuation);
                                if (v0 == var6_5) {
                                    return var6_5;
                                }
                                ** GOTO lbl22
                            }
                            case 1: {
                                var3_6 = (Ref.ObjectRef<R>)$continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl22:
                                // 2 sources

                                var3_6.element = v0;
                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Nullable
                    public final Object emit$$forInline(T value, @NotNull Continuation<? super Unit> $completion) {
                        Object object;
                        InlineMarker.mark((int)4);
                        new /* invalid duplicate definition of identical inner class */;
                        InlineMarker.mark((int)5);
                        Ref.ObjectRef<R> objectRef = this.$accumulator;
                        objectRef.element = object = this.$operation.invoke(this.$accumulator.element, value, $completion);
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$continuation);
                if (v0 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl26
            }
            case 1: {
                $i$f$fold = false;
                accumulator = (Ref.ObjectRef)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl26:
                // 2 sources

                return accumulator.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private static final <T, R> Object fold$$forInline(Flow<? extends T> $this$fold, R initial, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation, Continuation<? super R> $completion) {
        boolean $i$f$fold = false;
        Ref.ObjectRef accumulator = new Ref.ObjectRef();
        accumulator.element = initial;
        FlowCollector flowCollector = new /* invalid duplicate definition of identical inner class */;
        InlineMarker.mark((int)0);
        $this$fold.collect(flowCollector, $completion);
        InlineMarker.mark((int)1);
        return accumulator.element;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object single(@NotNull Flow<? extends T> var0, @NotNull Continuation<? super T> var1_1) {
        if (!(var1_1 instanceof single.1)) ** GOTO lbl-1000
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
                    return FlowKt.single(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                result = new Ref.ObjectRef();
                result.element = NullSurrogateKt.NULL;
                $continuation.L$0 = result;
                $continuation.label = 1;
                v0 = $this$single.collect(new FlowCollector((Ref.ObjectRef<Object>)result){
                    final /* synthetic */ Ref.ObjectRef<Object> $result;
                    {
                        this.$result = $result;
                    }

                    @Nullable
                    public final Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
                        if (!(this.$result.element == NullSurrogateKt.NULL)) {
                            boolean bl = false;
                            String string = "Flow has more than one element";
                            throw new IllegalArgumentException(string.toString());
                        }
                        this.$result.element = value;
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$continuation);
                if (v0 == var5_4) {
                    return var5_4;
                }
                ** GOTO lbl24
            }
            case 1: {
                result = (Ref.ObjectRef)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                if (result.element == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Flow is empty");
                }
                return result.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object singleOrNull(@NotNull Flow<? extends T> var0, @NotNull Continuation<? super T> var1_1) {
        if (!(var1_1 instanceof singleOrNull.1)) ** GOTO lbl-1000
        var8_2 = var1_1;
        if ((var8_2.label & -2147483648) != 0) {
            var8_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var1_1){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.singleOrNull(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var9_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                result = new Ref.ObjectRef();
                result.element = NullSurrogateKt.NULL;
                $this$collectWhile$iv = $this$singleOrNull;
                $i$f$collectWhile = false;
                collector$iv = new FlowCollector<T>(result){
                    final /* synthetic */ Ref.ObjectRef $result$inlined;
                    {
                        this.$result$inlined = objectRef;
                    }

                    @Nullable
                    public Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
                        boolean bl;
                        Continuation<? super Unit> continuation = $completion;
                        T it = value;
                        boolean bl2 = false;
                        if (this.$result$inlined.element == NullSurrogateKt.NULL) {
                            this.$result$inlined.element = it;
                            bl = true;
                        } else {
                            this.$result$inlined.element = NullSurrogateKt.NULL;
                            bl = false;
                        }
                        if (!bl) {
                            throw new AbortFlowException(this);
                        }
                        return Unit.INSTANCE;
                    }
                };
                $continuation.L$0 = result;
                $continuation.L$1 = collector$iv;
                $continuation.label = 1;
                v0 = $this$collectWhile$iv.collect(collector$iv, (Continuation<Unit>)$continuation);
                ** if (v0 != var9_4) goto lbl25
lbl24:
                // 1 sources

                return var9_4;
lbl25:
                // 1 sources

                ** GOTO lbl38
            }
            case 1: {
                $i$f$collectWhile = false;
                collector$iv = $continuation.L$1;
                result = (Ref.ObjectRef)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (AbortFlowException e$iv) {
                    FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                }
lbl38:
                // 3 sources

                return result.element == NullSurrogateKt.NULL ? null : result.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object first(@NotNull Flow<? extends T> var0, @NotNull Continuation<? super T> var1_1) {
        if (!(var1_1 instanceof first.1)) ** GOTO lbl-1000
        var8_2 = var1_1;
        if ((var8_2.label & -2147483648) != 0) {
            var8_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var1_1){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.first(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var9_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                result = new Ref.ObjectRef();
                result.element = NullSurrogateKt.NULL;
                $this$collectWhile$iv = $this$first;
                $i$f$collectWhile = false;
                collector$iv = new FlowCollector<T>(result){
                    final /* synthetic */ Ref.ObjectRef $result$inlined;
                    {
                        this.$result$inlined = objectRef;
                    }

                    @Nullable
                    public Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
                        Continuation<? super Unit> continuation = $completion;
                        T it = value;
                        boolean bl = false;
                        this.$result$inlined.element = it;
                        if (!false) {
                            throw new AbortFlowException(this);
                        }
                        return Unit.INSTANCE;
                    }
                };
                $continuation.L$0 = result;
                $continuation.L$1 = collector$iv;
                $continuation.label = 1;
                v0 = $this$collectWhile$iv.collect(collector$iv, (Continuation<Unit>)$continuation);
                ** if (v0 != var9_4) goto lbl25
lbl24:
                // 1 sources

                return var9_4;
lbl25:
                // 1 sources

                ** GOTO lbl38
            }
            case 1: {
                $i$f$collectWhile = false;
                collector$iv = $continuation.L$1;
                result = (Ref.ObjectRef)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (AbortFlowException e$iv) {
                    FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                }
lbl38:
                // 3 sources

                if (result.element == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Expected at least one element");
                }
                return result.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object first(@NotNull Flow<? extends T> var0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> var1_1, @NotNull Continuation<? super T> var2_2) {
        if (!(var2_2 instanceof first.3)) ** GOTO lbl-1000
        var9_3 = var2_2;
        if ((var9_3.label & -2147483648) != 0) {
            var9_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.first(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var10_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                result = new Ref.ObjectRef();
                result.element = NullSurrogateKt.NULL;
                $this$collectWhile$iv = $this$first;
                $i$f$collectWhile = false;
                collector$iv = new FlowCollector<T>(predicate, result){
                    final /* synthetic */ Function2 $predicate$inlined;
                    final /* synthetic */ Ref.ObjectRef $result$inlined;
                    {
                        this.$predicate$inlined = function2;
                        this.$result$inlined = objectRef;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof first$$inlined$collectWhile$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                Object L$0;
                                /* synthetic */ Object result;
                                int label;
                                final /* synthetic */ first$$inlined$collectWhile$2 this$0;
                                Object L$1;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                @Nullable
                                public final Object invokeSuspend(@NotNull Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (Continuation<? super Unit>)((Continuation)this));
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = (Continuation)$continuation;
                                it = value;
                                $i$a$-collectWhile-FlowKt__ReduceKt$first$4 = false;
                                $continuation.L$0 = this;
                                $continuation.L$1 = it;
                                $continuation.label = 1;
                                InlineMarker.mark((int)6);
                                v0 = this.$predicate$inlined.invoke(it, (Object)$continuation);
                                InlineMarker.mark((int)7);
                                v1 = v0;
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl31
                            }
                            case 1: {
                                $i$a$-collectWhile-FlowKt__ReduceKt$first$4 = false;
                                it = $continuation.L$1;
                                this = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl31:
                                // 2 sources

                                if (((Boolean)v1).booleanValue()) {
                                    this.$result$inlined.element = it;
                                    v2 = false;
                                } else {
                                    v2 = true;
                                }
                                if (!v2) {
                                    throw new AbortFlowException(this);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                };
                $continuation.L$0 = predicate;
                $continuation.L$1 = result;
                $continuation.L$2 = collector$iv;
                $continuation.label = 1;
                v0 = $this$collectWhile$iv.collect(collector$iv, (Continuation<Unit>)$continuation);
                ** if (v0 != var10_5) goto lbl26
lbl25:
                // 1 sources

                return var10_5;
lbl26:
                // 1 sources

                ** GOTO lbl40
            }
            case 1: {
                $i$f$collectWhile = false;
                collector$iv = $continuation.L$2;
                result = (Ref.ObjectRef)$continuation.L$1;
                predicate = (Function2)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (AbortFlowException e$iv) {
                    FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                }
lbl40:
                // 3 sources

                if (result.element == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Expected at least one element matching the predicate " + predicate);
                }
                return result.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> var0, @NotNull Continuation<? super T> var1_1) {
        if (!(var1_1 instanceof firstOrNull.1)) ** GOTO lbl-1000
        var8_2 = var1_1;
        if ((var8_2.label & -2147483648) != 0) {
            var8_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var1_1){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt.firstOrNull(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var9_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                result = new Ref.ObjectRef();
                $this$collectWhile$iv = $this$firstOrNull;
                $i$f$collectWhile = false;
                collector$iv = new FlowCollector<T>(result){
                    final /* synthetic */ Ref.ObjectRef $result$inlined;
                    {
                        this.$result$inlined = objectRef;
                    }

                    @Nullable
                    public Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
                        Continuation<? super Unit> continuation = $completion;
                        T it = value;
                        boolean bl = false;
                        this.$result$inlined.element = it;
                        if (!false) {
                            throw new AbortFlowException(this);
                        }
                        return Unit.INSTANCE;
                    }
                };
                $continuation.L$0 = result;
                $continuation.L$1 = collector$iv;
                $continuation.label = 1;
                v0 = $this$collectWhile$iv.collect(collector$iv, (Continuation<Unit>)$continuation);
                ** if (v0 != var9_4) goto lbl24
lbl23:
                // 1 sources

                return var9_4;
lbl24:
                // 1 sources

                ** GOTO lbl37
            }
            case 1: {
                $i$f$collectWhile = false;
                collector$iv = $continuation.L$1;
                result = (Ref.ObjectRef)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (AbortFlowException e$iv) {
                    FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                }
lbl37:
                // 3 sources

                return result.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> var0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> var1_1, @NotNull Continuation<? super T> var2_2) {
        if (!(var2_2 instanceof firstOrNull.3)) ** GOTO lbl-1000
        var9_3 = var2_2;
        if ((var9_3.label & -2147483648) != 0) {
            var9_3.label -= -2147483648;
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
                    return FlowKt.firstOrNull(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var10_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                result = new Ref.ObjectRef();
                $this$collectWhile$iv = $this$firstOrNull;
                $i$f$collectWhile = false;
                collector$iv = new FlowCollector<T>((Function2)predicate, result){
                    final /* synthetic */ Function2 $predicate$inlined;
                    final /* synthetic */ Ref.ObjectRef $result$inlined;
                    {
                        this.$predicate$inlined = function2;
                        this.$result$inlined = objectRef;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof firstOrNull$$inlined$collectWhile$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                Object L$0;
                                /* synthetic */ Object result;
                                int label;
                                final /* synthetic */ firstOrNull$$inlined$collectWhile$2 this$0;
                                Object L$1;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                @Nullable
                                public final Object invokeSuspend(@NotNull Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (Continuation<? super Unit>)((Continuation)this));
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = (Continuation)$continuation;
                                it = value;
                                $i$a$-collectWhile-FlowKt__ReduceKt$firstOrNull$4 = false;
                                $continuation.L$0 = this;
                                $continuation.L$1 = it;
                                $continuation.label = 1;
                                InlineMarker.mark((int)6);
                                v0 = this.$predicate$inlined.invoke(it, (Object)$continuation);
                                InlineMarker.mark((int)7);
                                v1 = v0;
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl31
                            }
                            case 1: {
                                $i$a$-collectWhile-FlowKt__ReduceKt$firstOrNull$4 = false;
                                it = $continuation.L$1;
                                this = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl31:
                                // 2 sources

                                if (((Boolean)v1).booleanValue()) {
                                    this.$result$inlined.element = it;
                                    v2 = false;
                                } else {
                                    v2 = true;
                                }
                                if (!v2) {
                                    throw new AbortFlowException(this);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                };
                $continuation.L$0 = result;
                $continuation.L$1 = collector$iv;
                $continuation.label = 1;
                v0 = $this$collectWhile$iv.collect(collector$iv, (Continuation<Unit>)$continuation);
                ** if (v0 != var10_5) goto lbl24
lbl23:
                // 1 sources

                return var10_5;
lbl24:
                // 1 sources

                ** GOTO lbl37
            }
            case 1: {
                $i$f$collectWhile = false;
                collector$iv = $continuation.L$1;
                result = (Ref.ObjectRef)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (AbortFlowException e$iv) {
                    FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                }
lbl37:
                // 3 sources

                return result.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object last(@NotNull Flow<? extends T> var0, @NotNull Continuation<? super T> var1_1) {
        if (!(var1_1 instanceof last.1)) ** GOTO lbl-1000
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
                    return FlowKt.last(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                result = new Ref.ObjectRef();
                result.element = NullSurrogateKt.NULL;
                $continuation.L$0 = result;
                $continuation.label = 1;
                v0 = $this$last.collect(new FlowCollector((Ref.ObjectRef<Object>)result){
                    final /* synthetic */ Ref.ObjectRef<Object> $result;
                    {
                        this.$result = $result;
                    }

                    @Nullable
                    public final Object emit(T it, @NotNull Continuation<? super Unit> $completion) {
                        this.$result.element = it;
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$continuation);
                if (v0 == var5_4) {
                    return var5_4;
                }
                ** GOTO lbl24
            }
            case 1: {
                result = (Ref.ObjectRef)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                if (result.element == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Expected at least one element");
                }
                return result.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object lastOrNull(@NotNull Flow<? extends T> var0, @NotNull Continuation<? super T> var1_1) {
        if (!(var1_1 instanceof lastOrNull.1)) ** GOTO lbl-1000
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
                    return FlowKt.lastOrNull(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                result = new Ref.ObjectRef();
                $continuation.L$0 = result;
                $continuation.label = 1;
                v0 = $this$lastOrNull.collect(new FlowCollector(result){
                    final /* synthetic */ Ref.ObjectRef<T> $result;
                    {
                        this.$result = $result;
                    }

                    @Nullable
                    public final Object emit(T it, @NotNull Continuation<? super Unit> $completion) {
                        this.$result.element = it;
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$continuation);
                if (v0 == var5_4) {
                    return var5_4;
                }
                ** GOTO lbl23
            }
            case 1: {
                result = (Ref.ObjectRef)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl23:
                // 2 sources

                return result.element;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

