/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
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
import kotlinx.coroutines.flow.FlowKt__LimitKt;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$;
import kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aX\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000123\b\u0004\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002H\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001aJ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0016\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0005\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0017\u0010\u0010\u001aJ\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0012\u001ar\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u00028\u00000\u00012D\b\u0001\u0010\u001c\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001a\u00a2\u0006\u0002\b\u001b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2={"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "", "collectWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "count", "drop", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "dropWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAbort", "take", "takeWhile", "R", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "transform", "transformWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,141:1\n1#2:142\n107#3:143\n107#3:144\n107#3:145\n107#3:146\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n22#1:143\n33#1:144\n52#1:145\n83#1:146\n*E\n"})
final class FlowKt__LimitKt {
    @NotNull
    public static final <T> Flow<T> drop(@NotNull Flow<? extends T> $this$drop, int count2) {
        if (!(count2 >= 0)) {
            boolean bl = false;
            String string = "Drop count should be non-negative, but had " + count2;
            throw new IllegalArgumentException(string.toString());
        }
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$drop, count2){
            final /* synthetic */ Flow $this_drop$inlined;
            final /* synthetic */ int $count$inlined;
            {
                this.$this_drop$inlined = flow;
                this.$count$inlined = n2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super T> $this$drop_u24lambda_u241 = collector2;
                boolean bl = false;
                Ref.IntRef skipped = new Ref.IntRef();
                Object object = this.$this_drop$inlined.collect(new FlowCollector(skipped, this.$count$inlined, $this$drop_u24lambda_u241){
                    final /* synthetic */ Ref.IntRef $skipped;
                    final /* synthetic */ int $count;
                    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;
                    {
                        this.$skipped = $skipped;
                        this.$count = $count;
                        this.$this_unsafeFlow = $receiver;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof drop.2.emit.1)) ** GOTO lbl-1000
                        var4_3 = var2_2;
                        if ((var4_3.label & -2147483648) != 0) {
                            var4_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                final /* synthetic */ drop.2.1<T> this$0;
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
                                if (this.$skipped.element < this.$count) break;
                                $continuation.label = 1;
                                v0 = this.$this_unsafeFlow.emit(value, (Continuation<Unit>)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl21
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl21:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        ++this.$skipped.element;
                        this.$skipped.element;
                        return Unit.INSTANCE;
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> dropWhile(@NotNull Flow<? extends T> $this$dropWhile, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$dropWhile, predicate){
            final /* synthetic */ Flow $this_dropWhile$inlined;
            final /* synthetic */ Function2 $predicate$inlined;
            {
                this.$this_dropWhile$inlined = flow;
                this.$predicate$inlined = function2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super T> $this$dropWhile_u24lambda_u242 = collector2;
                boolean bl = false;
                Ref.BooleanRef matched = new Ref.BooleanRef();
                Object object = this.$this_dropWhile$inlined.collect(new FlowCollector(matched, $this$dropWhile_u24lambda_u242, this.$predicate$inlined){
                    final /* synthetic */ Ref.BooleanRef $matched;
                    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;
                    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;
                    {
                        this.$matched = $matched;
                        this.$this_unsafeFlow = $receiver;
                        this.$predicate = $predicate;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof dropWhile.1.emit.1)) ** GOTO lbl-1000
                        var4_3 = var2_2;
                        if ((var4_3.label & -2147483648) != 0) {
                            var4_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                Object L$0;
                                Object L$1;
                                /* synthetic */ Object result;
                                final /* synthetic */ dropWhile.1.1<T> this$0;
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
                                if (!this.$matched.element) break;
                                $continuation.label = 1;
                                v0 = this.$this_unsafeFlow.emit(value, (Continuation<Unit>)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl21
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl21:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        $continuation.L$0 = this;
                        $continuation.L$1 = value;
                        $continuation.label = 2;
                        v1 = this.$predicate.invoke(value, (Object)$continuation);
                        if (v1 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl34
                        {
                            case 2: {
                                value = $continuation.L$1;
                                this = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl34:
                                // 2 sources

                                if (((Boolean)v1).booleanValue()) break;
                                this.$matched.element = true;
                                $continuation.L$0 = null;
                                $continuation.L$1 = null;
                                $continuation.label = 3;
                                v2 = this.$this_unsafeFlow.emit(value, (Continuation<Unit>)$continuation);
                                if (v2 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl46
                            }
                            case 3: {
                                ResultKt.throwOnFailure((Object)$result);
                                v2 = $result;
lbl46:
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
        };
    }

    @NotNull
    public static final <T> Flow<T> take(@NotNull Flow<? extends T> $this$take, int count2) {
        if (!(count2 > 0)) {
            boolean bl = false;
            String string = "Requested element count " + count2 + " should be positive";
            throw new IllegalArgumentException(string.toString());
        }
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$take, count2){
            final /* synthetic */ Flow $this_take$inlined;
            final /* synthetic */ int $count$inlined;
            {
                this.$this_take$inlined = flow;
                this.$count$inlined = n2;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof take$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ take$$inlined$unsafeFlow$1 this$0;
                        Object L$0;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                        }
                    };
                }
                $result = $continuation.result;
                var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        (Continuation)$continuation;
                        $this$take_u24lambda_u244 = collector;
                        $i$a$-unsafeFlow-FlowKt__LimitKt$take$2 = false;
                        consumed = new Ref.IntRef();
                        $continuation.L$0 = $this$take_u24lambda_u244;
                        $continuation.label = 1;
                        v0 = this.$this_take$inlined.collect(new FlowCollector(consumed, this.$count$inlined, $this$take_u24lambda_u244){
                            final /* synthetic */ Ref.IntRef $consumed;
                            final /* synthetic */ int $count;
                            final /* synthetic */ FlowCollector<T> $this_unsafeFlow;
                            {
                                this.$consumed = $consumed;
                                this.$count = $count;
                                this.$this_unsafeFlow = $receiver;
                            }

                            /*
                             * Unable to fully structure code
                             */
                            @Nullable
                            public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                if (!(var2_2 instanceof take.2.emit.1)) ** GOTO lbl-1000
                                var4_3 = var2_2;
                                if ((var4_3.label & -2147483648) != 0) {
                                    var4_3.label -= -2147483648;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    $continuation = new ContinuationImpl(this, var2_2){
                                        /* synthetic */ Object result;
                                        final /* synthetic */ take.2.1<T> this$0;
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
                                        ++this.$consumed.element;
                                        if (this.$consumed.element >= this.$count) break;
                                        $continuation.label = 1;
                                        v0 = this.$this_unsafeFlow.emit(value, (Continuation<Unit>)$continuation);
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
                                $continuation.label = 2;
                                v1 = FlowKt__LimitKt.access$emitAbort$FlowKt__LimitKt(this.$this_unsafeFlow, value, (Continuation)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl31
                                {
                                    case 2: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        v1 = $result;
lbl31:
                                        // 2 sources

                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (Continuation<Unit>)$continuation);
                        ** if (v0 != var5_5) goto lbl24
lbl23:
                        // 1 sources

                        return var5_5;
lbl24:
                        // 1 sources

                        ** GOTO lbl36
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__LimitKt$take$2 = false;
                        $this$take_u24lambda_u244 = (FlowCollector)$continuation.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
                        }
                        catch (AbortFlowException e) {
                            FlowExceptions_commonKt.checkOwnership(e, $this$take_u24lambda_u244);
                        }
lbl36:
                        // 3 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    /*
     * Unable to fully structure code
     */
    private static final <T> Object emitAbort$FlowKt__LimitKt(FlowCollector<? super T> var0, T var1_1, Continuation<? super Unit> var2_2) {
        if (!(var2_2 instanceof emitAbort.1)) ** GOTO lbl-1000
        var4_3 = var2_2;
        if ((var4_3.label & -2147483648) != 0) {
            var4_3.label -= -2147483648;
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
                    return FlowKt__LimitKt.access$emitAbort$FlowKt__LimitKt(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = $this$emitAbort;
                $continuation.label = 1;
                v0 = $this$emitAbort.emit(value, (Continuation<? super Unit>)$continuation);
                if (v0 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                $this$emitAbort = (FlowCollector)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                throw new AbortFlowException($this$emitAbort);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public static final <T> Flow<T> takeWhile(@NotNull Flow<? extends T> $this$takeWhile, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$takeWhile, predicate){
            final /* synthetic */ Flow $this_takeWhile$inlined;
            final /* synthetic */ Function2 $predicate$inlined;
            {
                this.$this_takeWhile$inlined = flow;
                this.$predicate$inlined = function2;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof takeWhile$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ takeWhile$$inlined$unsafeFlow$1 this$0;
                        Object L$0;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                        }
                    };
                }
                $result = $continuation.result;
                var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        (Continuation)$continuation;
                        $this$takeWhile_u24lambda_u246 = collector;
                        $i$a$-unsafeFlow-FlowKt__LimitKt$takeWhile$1 = false;
                        var8_9 = this.$this_takeWhile$inlined;
                        $completion$iv = $continuation;
                        $i$f$collectWhile = false;
                        collector$iv = new FlowCollector<T>(this.$predicate$inlined, (FlowCollector)$this$takeWhile_u24lambda_u246){
                            final /* synthetic */ Function2 $predicate$inlined;
                            final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
                            {
                                this.$predicate$inlined = function2;
                                this.$this_unsafeFlow$inlined = flowCollector;
                            }

                            /*
                             * Unable to fully structure code
                             */
                            @Nullable
                            public Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                block10: {
                                    if (!(var2_2 instanceof takeWhile$lambda$6$$inlined$collectWhile$1$1)) ** GOTO lbl-1000
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
                                            final /* synthetic */ takeWhile$lambda$6$$inlined$collectWhile$1 this$0;
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
                                            value = value;
                                            $i$a$-collectWhile-FlowKt__LimitKt$takeWhile$1$1 = false;
                                            $continuation.L$0 = this;
                                            $continuation.L$1 = value;
                                            $continuation.label = 1;
                                            InlineMarker.mark((int)6);
                                            v0 = this.$predicate$inlined.invoke(value, (Object)$continuation);
                                            InlineMarker.mark((int)7);
                                            v1 = v0;
                                            if (v0 == var5_5) {
                                                return var5_5;
                                            }
                                            ** GOTO lbl31
                                        }
                                        case 1: {
                                            $i$a$-collectWhile-FlowKt__LimitKt$takeWhile$1$1 = false;
                                            value = $continuation.L$1;
                                            this = $continuation.L$0;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v1 = $result;
lbl31:
                                            // 2 sources

                                            if (!((Boolean)v1).booleanValue()) break;
                                            $continuation.L$0 = this;
                                            $continuation.L$1 = null;
                                            $continuation.label = 2;
                                            v2 = this.$this_unsafeFlow$inlined.emit(value, (Continuation<Unit>)$continuation);
                                            if (v2 == var5_5) {
                                                return var5_5;
                                            }
                                            ** GOTO lbl44
                                        }
                                        case 2: {
                                            $i$a$-collectWhile-FlowKt__LimitKt$takeWhile$1$1 = false;
                                            this = $continuation.L$0;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v2 = $result;
lbl44:
                                            // 2 sources

                                            v3 = true;
                                            break block10;
                                        }
                                    }
                                    v3 = false;
                                }
                                if (!v3) {
                                    throw new AbortFlowException(this);
                                }
                                return Unit.INSTANCE;
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        };
                        $continuation.L$0 = collector$iv;
                        $continuation.label = 1;
                        v0 = $this$collectWhile$iv.collect(collector$iv, (Continuation<? super Unit>)$completion$iv);
                        ** if (v0 != var5_5) goto lbl27
lbl26:
                        // 1 sources

                        return var5_5;
lbl27:
                        // 1 sources

                        ** GOTO lbl41
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__LimitKt$takeWhile$1 = false;
                        $i$f$collectWhile = false;
                        collector$iv = $continuation.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
                        }
                        catch (AbortFlowException e$iv) {
                            FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                        }
lbl41:
                        // 3 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T, R> Flow<R> transformWhile(@NotNull Flow<? extends T> $this$transformWhile, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> transform2) {
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>($this$transformWhile, transform2, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow<T> $this_transformWhile;
            final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Boolean>, Object> $transform;
            {
                this.$this_transformWhile = $receiver;
                this.$transform = $transform;
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
                        void $this$collectWhile$iv;
                        ResultKt.throwOnFailure((Object)object);
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        Flow<T> flow = this.$this_transformWhile;
                        Function3<FlowCollector<? super R>, T, Continuation<? super Boolean>, Object> function3 = this.$transform;
                        boolean $i$f$collectWhile = false;
                        transformWhile$1$invokeSuspend$$inlined$collectWhile$1 collector$iv = new FlowCollector<T>(function3, $this$flow){
                            final /* synthetic */ Function3 $transform$inlined;
                            final /* synthetic */ FlowCollector $$this$flow$inlined;
                            {
                                this.$transform$inlined = function3;
                                this.$$this$flow$inlined = flowCollector;
                            }

                            /*
                             * Unable to fully structure code
                             */
                            @Nullable
                            public Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                if (!(var2_2 instanceof transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1)) ** GOTO lbl-1000
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
                                        final /* synthetic */ transformWhile$1$invokeSuspend$$inlined$collectWhile$1 this$0;
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
                                        value = value;
                                        $i$a$-collectWhile-FlowKt__LimitKt$transformWhile$1$1 = false;
                                        $continuation.L$0 = this;
                                        $continuation.label = 1;
                                        InlineMarker.mark((int)6);
                                        v0 = this.$transform$inlined.invoke((Object)this.$$this$flow$inlined, (Object)value, (Object)$continuation);
                                        InlineMarker.mark((int)7);
                                        v1 = v0;
                                        if (v0 == var5_5) {
                                            return var5_5;
                                        }
                                        ** GOTO lbl30
                                    }
                                    case 1: {
                                        $i$a$-collectWhile-FlowKt__LimitKt$transformWhile$1$1 = false;
                                        this = $continuation.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v1 = $result;
lbl30:
                                        // 2 sources

                                        if (!((Boolean)v1).booleanValue()) {
                                            throw new AbortFlowException(this);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        };
                        this.L$0 = collector$iv;
                        this.label = 1;
                        Object object3 = $this$collectWhile$iv.collect(collector$iv, (Continuation<? super Unit>)((Continuation)this));
                        if (object3 != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        Object object3;
                        boolean $i$f$collectWhile = false;
                        transformWhile$1$invokeSuspend$$inlined$collectWhile$1 collector$iv = this.L$0;
                        try {
                            void $result;
                            ResultKt.throwOnFailure((Object)$result);
                            object3 = $result;
                            return Unit.INSTANCE;
                        }
                        catch (AbortFlowException e$iv) {
                            FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                        }
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object collectWhile(@NotNull Flow<? extends T> var0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> var1_1, @NotNull Continuation<? super Unit> var2_2) {
        if (!(var2_2 instanceof collectWhile.1)) ** GOTO lbl-1000
        var7_3 = var2_2;
        if ((var7_3.label & -2147483648) != 0) {
            var7_3.label -= -2147483648;
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
                    return FlowKt__LimitKt.collectWhile(null, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var8_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$collectWhile = false;
                collector = new FlowCollector<T>(predicate){
                    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;
                    {
                        this.$predicate = $predicate;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof collectWhile.collector.emit.1)) ** GOTO lbl-1000
                        var4_3 = var2_2;
                        if ((var4_3.label & -2147483648) != 0) {
                            var4_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                Object L$0;
                                /* synthetic */ Object result;
                                final /* synthetic */ collectWhile.collector.1<T> this$0;
                                int label;
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

                                if (!((Boolean)v0).booleanValue()) {
                                    throw new AbortFlowException(this);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Nullable
                    public Object emit$$forInline(T value, @NotNull Continuation<? super Unit> $completion) {
                        InlineMarker.mark((int)4);
                        new /* invalid duplicate definition of identical inner class */;
                        InlineMarker.mark((int)5);
                        if (!((Boolean)this.$predicate.invoke(value, $completion)).booleanValue()) {
                            throw new AbortFlowException(this);
                        }
                        return Unit.INSTANCE;
                    }
                };
                $continuation.L$0 = collector;
                $continuation.label = 1;
                v0 = $this$collectWhile.collect(collector, (Continuation<Unit>)$continuation);
                ** if (v0 != var8_5) goto lbl21
lbl20:
                // 1 sources

                return var8_5;
lbl21:
                // 1 sources

                ** GOTO lbl32
            }
            case 1: {
                $i$f$collectWhile = false;
                collector = $continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (AbortFlowException e) {
                    FlowExceptions_commonKt.checkOwnership(e, collector);
                }
lbl32:
                // 3 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private static final <T> Object collectWhile$$forInline(Flow<? extends T> $this$collectWhile, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, Continuation<? super Unit> $completion) {
        boolean $i$f$collectWhile = false;
        FlowCollector collector2 = new /* invalid duplicate definition of identical inner class */;
        try {
            FlowCollector flowCollector = collector2;
            InlineMarker.mark((int)0);
            $this$collectWhile.collect(flowCollector, $completion);
            InlineMarker.mark((int)1);
        }
        catch (AbortFlowException e2) {
            FlowExceptions_commonKt.checkOwnership(e2, collector2);
        }
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$emitAbort$FlowKt__LimitKt(FlowCollector $receiver, Object value, Continuation $completion) {
        return FlowKt__LimitKt.emitAbort$FlowKt__LimitKt($receiver, value, (Continuation<? super Unit>)$completion);
    }
}

