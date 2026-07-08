/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.IntIterator
 *  kotlin.collections.LongIterator
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.LongRange
 *  kotlin.sequences.Sequence
 */
package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.CallbackFlowBuilder;
import kotlinx.coroutines.flow.ChannelFlowBuilder;
import kotlinx.coroutines.flow.EmptyFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$;
import kotlinx.coroutines.flow.SafeFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001aM\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\n\u001a\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001aM\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u00a2\u0006\u0002\b\u0006\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\n\u001a!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0010\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0015\u001a#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0015\u001a\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001a0\b*\u00020\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001b\u001a\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\b*\u00020\u001c\u00a2\u0006\u0004\b\u0017\u0010\u001e\u001a#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001f\u00a2\u0006\u0004\b\u0017\u0010 \u001a#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000!\u00a2\u0006\u0004\b\u0017\u0010\"\u001a\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001a0\b*\u00020#\u00a2\u0006\u0004\b\u0017\u0010$\u001a\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\b*\u00020%\u00a2\u0006\u0004\b\u0017\u0010&\u001a#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000'\u00a2\u0006\u0004\b\u0017\u0010(\u001a6\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050)\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010*\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2={"T", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/flow/Flow;", "callbackFlow", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "channelFlow", "emptyFlow", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "value", "flowOf", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "", "elements", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function0;", "asFlow", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/flow/Flow;", "", "", "([I)Lkotlinx/coroutines/flow/Flow;", "", "", "([J)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/Iterable;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/util/Iterator;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,354:1\n107#2:355\n107#2:356\n107#2:357\n107#2:358\n107#2:359\n107#2:360\n107#2:361\n107#2:362\n107#2:363\n107#2:364\n107#2:365\n107#2:366\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n68#1:355\n82#1:356\n89#1:357\n98#1:358\n107#1:359\n122#1:360\n131#1:361\n153#1:362\n164#1:363\n175#1:364\n184#1:365\n193#1:366\n*E\n"})
final class FlowKt__BuildersKt {
    @NotNull
    public static final <T> Flow<T> flow(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return new SafeFlow(block);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Function0<? extends T> $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$asFlow){
            final /* synthetic */ Function0 $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = function0;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<Object> $this$asFlow_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = $this$asFlow_u24lambda_u240.emit(this.$this_asFlow$inlined.invoke(), $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$asFlow){
            final /* synthetic */ Function1 $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = function1;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof asFlow$$inlined$unsafeFlow$2$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ asFlow$$inlined$unsafeFlow$2 this$0;
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
                        var6_6 = (Continuation)$continuation;
                        $this$asFlow_u24lambda_u241 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$2 = false;
                        var9_10 = $this$asFlow_u24lambda_u241;
                        $continuation.L$0 = var9_10;
                        $continuation.label = 1;
                        InlineMarker.mark((int)6);
                        v0 = this.$this_asFlow$inlined.invoke((Object)$continuation);
                        InlineMarker.mark((int)7);
                        v1 = v0;
                        if (v0 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl30
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$2 = false;
                        var9_10 = (FlowCollector)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl30:
                        // 2 sources

                        var10_11 = v1;
                        $continuation.L$0 = null;
                        $continuation.label = 2;
                        v2 = var9_10.emit(var10_11, (Continuation<Unit>)$continuation);
                        if (v2 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl41
                    }
                    case 2: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$2 = false;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl41:
                        // 2 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterable<? extends T> $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$asFlow){
            final /* synthetic */ Iterable $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = iterable;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof asFlow$$inlined$unsafeFlow$3$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ asFlow$$inlined$unsafeFlow$3 this$0;
                        Object L$0;
                        Object L$1;
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
                        $this$asFlow_u24lambda_u243 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$3 = false;
                        $this$forEach$iv = this.$this_asFlow$inlined;
                        $i$f$forEach = false;
                        var10_10 = $this$forEach$iv.iterator();
lbl19:
                        // 3 sources

                        while (var10_10.hasNext()) {
                            value = element$iv = var10_10.next();
                            $i$a$-forEach-FlowKt__BuildersKt$asFlow$3$1 = false;
                            $continuation.L$0 = $this$asFlow_u24lambda_u243;
                            $continuation.L$1 = var10_10;
                            $continuation.label = 1;
                            v0 = $this$asFlow_u24lambda_u243.emit(value, (Continuation<Unit>)$continuation);
                            if (v0 != var5_5) continue;
                            return var5_5;
                        }
                        break;
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$3 = false;
                        $i$f$forEach = false;
                        $i$a$-forEach-FlowKt__BuildersKt$asFlow$3$1 = false;
                        var10_10 = (Iterator<T>)$continuation.L$1;
                        $this$asFlow_u24lambda_u243 = (FlowCollector)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
                        ** GOTO lbl19
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterator<? extends T> $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$asFlow){
            final /* synthetic */ Iterator $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = iterator2;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof asFlow$$inlined$unsafeFlow$4$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ asFlow$$inlined$unsafeFlow$4 this$0;
                        Object L$0;
                        Object L$1;
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
                        $this$asFlow_u24lambda_u245 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$4 = false;
                        $this$forEach$iv = this.$this_asFlow$inlined;
                        $i$f$forEach = false;
                        var10_10 = $this$forEach$iv;
lbl19:
                        // 3 sources

                        while (var10_10.hasNext()) {
                            value = element$iv = var10_10.next();
                            $i$a$-forEach-FlowKt__BuildersKt$asFlow$4$1 = false;
                            $continuation.L$0 = $this$asFlow_u24lambda_u245;
                            $continuation.L$1 = var10_10;
                            $continuation.label = 1;
                            v0 = $this$asFlow_u24lambda_u245.emit(value, (Continuation<Unit>)$continuation);
                            if (v0 != var5_5) continue;
                            return var5_5;
                        }
                        break;
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$4 = false;
                        $i$f$forEach = false;
                        $i$a$-forEach-FlowKt__BuildersKt$asFlow$4$1 = false;
                        var10_10 = (Iterator)$continuation.L$1;
                        $this$asFlow_u24lambda_u245 = (FlowCollector)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
                        ** GOTO lbl19
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Sequence<? extends T> $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$asFlow){
            final /* synthetic */ Sequence $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = sequence;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof asFlow$$inlined$unsafeFlow$5$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ asFlow$$inlined$unsafeFlow$5 this$0;
                        Object L$0;
                        Object L$1;
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
                        $this$asFlow_u24lambda_u247 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$5 = false;
                        $this$forEach$iv = this.$this_asFlow$inlined;
                        $i$f$forEach = false;
                        var10_10 = $this$forEach$iv.iterator();
lbl19:
                        // 3 sources

                        while (var10_10.hasNext()) {
                            value = element$iv = var10_10.next();
                            $i$a$-forEach-FlowKt__BuildersKt$asFlow$5$1 = false;
                            $continuation.L$0 = $this$asFlow_u24lambda_u247;
                            $continuation.L$1 = var10_10;
                            $continuation.label = 1;
                            v0 = $this$asFlow_u24lambda_u247.emit(value, (Continuation<Unit>)$continuation);
                            if (v0 != var5_5) continue;
                            return var5_5;
                        }
                        break;
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$5 = false;
                        $i$f$forEach = false;
                        $i$a$-forEach-FlowKt__BuildersKt$asFlow$5$1 = false;
                        var10_10 = (Iterator)$continuation.L$1;
                        $this$asFlow_u24lambda_u247 = (FlowCollector)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
                        ** GOTO lbl19
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> flowOf(T ... elements) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>(elements){
            final /* synthetic */ Object[] $elements$inlined;
            {
                this.$elements$inlined = objectArray;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof flowOf$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ flowOf$$inlined$unsafeFlow$1 this$0;
                        Object L$0;
                        Object L$1;
                        int I$0;
                        int I$1;
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
                        $this$flowOf_u24lambda_u248 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$flowOf$1 = false;
                        var8_8 = 0;
                        var9_9 = this.$elements$inlined.length;
lbl18:
                        // 2 sources

                        while (var8_8 < var9_9) {
                            element = this.$elements$inlined[var8_8];
                            $continuation.L$0 = this;
                            $continuation.L$1 = $this$flowOf_u24lambda_u248;
                            $continuation.I$0 = var8_8;
                            $continuation.I$1 = var9_9;
                            $continuation.label = 1;
                            v0 = $this$flowOf_u24lambda_u248.emit(element, (Continuation<Unit>)$continuation);
                            if (v0 == var5_5) {
                                return var5_5;
                            }
                            ** GOTO lbl38
                        }
                        break;
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$flowOf$1 = false;
                        var9_9 = $continuation.I$1;
                        var8_8 = $continuation.I$0;
                        $this$flowOf_u24lambda_u248 = (FlowCollector)$continuation.L$1;
                        this = $continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl38:
                        // 2 sources

                        ++var8_8;
                        ** GOTO lbl18
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> flowOf(T value) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>(value){
            final /* synthetic */ Object $value$inlined;
            {
                this.$value$inlined = object;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<Object> $this$flowOf_u24lambda_u249 = collector2;
                boolean bl = false;
                Object object = $this$flowOf_u24lambda_u249.emit(this.$value$inlined, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> emptyFlow() {
        return EmptyFlow.INSTANCE;
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull T[] $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$asFlow){
            final /* synthetic */ Object[] $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = objectArray;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof asFlow$$inlined$unsafeFlow$6$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ asFlow$$inlined$unsafeFlow$6 this$0;
                        Object L$0;
                        Object L$1;
                        int I$0;
                        int I$1;
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
                        $this$asFlow_u24lambda_u2411 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$6 = false;
                        $this$forEach$iv = this.$this_asFlow$inlined;
                        $i$f$forEach = false;
                        var10_10 = 0;
                        var11_11 = $this$forEach$iv.length;
lbl20:
                        // 2 sources

                        while (var10_10 < var11_11) {
                            value = element$iv = $this$forEach$iv[var10_10];
                            $i$a$-forEach-FlowKt__BuildersKt$asFlow$6$1 = false;
                            $continuation.L$0 = $this$asFlow_u24lambda_u2411;
                            $continuation.L$1 = $this$forEach$iv;
                            $continuation.I$0 = var10_10;
                            $continuation.I$1 = var11_11;
                            $continuation.label = 1;
                            v0 = $this$asFlow_u24lambda_u2411.emit(value, (Continuation<Unit>)$continuation);
                            if (v0 == var5_5) {
                                return var5_5;
                            }
                            ** GOTO lbl43
                        }
                        break;
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$6 = false;
                        $i$f$forEach = false;
                        $i$a$-forEach-FlowKt__BuildersKt$asFlow$6$1 = false;
                        var11_11 = $continuation.I$1;
                        var10_10 = $continuation.I$0;
                        $this$forEach$iv = (Object[])$continuation.L$1;
                        $this$asFlow_u24lambda_u2411 = (FlowCollector)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl43:
                        // 2 sources

                        ++var10_10;
                        ** GOTO lbl20
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull int[] $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<Integer>($this$asFlow){
            final /* synthetic */ int[] $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = nArray;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Integer> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof asFlow$$inlined$unsafeFlow$7$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ asFlow$$inlined$unsafeFlow$7 this$0;
                        Object L$0;
                        Object L$1;
                        int I$0;
                        int I$1;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.collect((FlowCollector<? super Integer>)null, (Continuation<? super Unit>)((Continuation)this));
                        }
                    };
                }
                $result = $continuation.result;
                var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        (Continuation)$continuation;
                        $this$asFlow_u24lambda_u2413 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$7 = false;
                        $this$forEach$iv = this.$this_asFlow$inlined;
                        $i$f$forEach = false;
                        var10_10 = 0;
                        var11_11 = $this$forEach$iv.length;
lbl20:
                        // 2 sources

                        while (var10_10 < var11_11) {
                            value = element$iv = $this$forEach$iv[var10_10];
                            $i$a$-forEach-FlowKt__BuildersKt$asFlow$7$1 = false;
                            $continuation.L$0 = $this$asFlow_u24lambda_u2413;
                            $continuation.L$1 = $this$forEach$iv;
                            $continuation.I$0 = var10_10;
                            $continuation.I$1 = var11_11;
                            $continuation.label = 1;
                            v0 = $this$asFlow_u24lambda_u2413.emit(Boxing.boxInt((int)value), (Continuation<Unit>)$continuation);
                            if (v0 == var5_5) {
                                return var5_5;
                            }
                            ** GOTO lbl43
                        }
                        break;
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$7 = false;
                        $i$f$forEach = false;
                        $i$a$-forEach-FlowKt__BuildersKt$asFlow$7$1 = false;
                        var11_11 = $continuation.I$1;
                        var10_10 = $continuation.I$0;
                        $this$forEach$iv = (int[])$continuation.L$1;
                        $this$asFlow_u24lambda_u2413 = (FlowCollector)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl43:
                        // 2 sources

                        ++var10_10;
                        ** GOTO lbl20
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull long[] $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<Long>($this$asFlow){
            final /* synthetic */ long[] $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = lArray;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Long> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof asFlow$$inlined$unsafeFlow$8$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ asFlow$$inlined$unsafeFlow$8 this$0;
                        Object L$0;
                        Object L$1;
                        int I$0;
                        int I$1;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.collect((FlowCollector<? super Long>)null, (Continuation<? super Unit>)((Continuation)this));
                        }
                    };
                }
                $result = $continuation.result;
                var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        (Continuation)$continuation;
                        $this$asFlow_u24lambda_u2415 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$8 = false;
                        $this$forEach$iv = this.$this_asFlow$inlined;
                        $i$f$forEach = false;
                        var10_10 = 0;
                        var11_11 = $this$forEach$iv.length;
lbl20:
                        // 2 sources

                        while (var10_10 < var11_11) {
                            value = element$iv = $this$forEach$iv[var10_10];
                            $i$a$-forEach-FlowKt__BuildersKt$asFlow$8$1 = false;
                            $continuation.L$0 = $this$asFlow_u24lambda_u2415;
                            $continuation.L$1 = $this$forEach$iv;
                            $continuation.I$0 = var10_10;
                            $continuation.I$1 = var11_11;
                            $continuation.label = 1;
                            v0 = $this$asFlow_u24lambda_u2415.emit(Boxing.boxLong((long)value), (Continuation<Unit>)$continuation);
                            if (v0 == var5_5) {
                                return var5_5;
                            }
                            ** GOTO lbl43
                        }
                        break;
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$8 = false;
                        $i$f$forEach = false;
                        $i$a$-forEach-FlowKt__BuildersKt$asFlow$8$1 = false;
                        var11_11 = $continuation.I$1;
                        var10_10 = $continuation.I$0;
                        $this$forEach$iv = (long[])$continuation.L$1;
                        $this$asFlow_u24lambda_u2415 = (FlowCollector)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl43:
                        // 2 sources

                        ++var10_10;
                        ** GOTO lbl20
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull IntRange $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<Integer>($this$asFlow){
            final /* synthetic */ IntRange $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = intRange;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Integer> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof asFlow$$inlined$unsafeFlow$9$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ asFlow$$inlined$unsafeFlow$9 this$0;
                        Object L$0;
                        Object L$1;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.collect((FlowCollector<? super Integer>)null, (Continuation<? super Unit>)((Continuation)this));
                        }
                    };
                }
                $result = $continuation.result;
                var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        (Continuation)$continuation;
                        $this$asFlow_u24lambda_u2417 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$9 = false;
                        $this$forEach$iv = (Iterable)this.$this_asFlow$inlined;
                        $i$f$forEach = false;
                        var10_10 = $this$forEach$iv.iterator();
lbl19:
                        // 3 sources

                        while (var10_10.hasNext()) {
                            value = element$iv = ((IntIterator)var10_10).nextInt();
                            $i$a$-forEach-FlowKt__BuildersKt$asFlow$9$1 = false;
                            $continuation.L$0 = $this$asFlow_u24lambda_u2417;
                            $continuation.L$1 = var10_10;
                            $continuation.label = 1;
                            v0 = $this$asFlow_u24lambda_u2417.emit(Boxing.boxInt((int)value), (Continuation<Unit>)$continuation);
                            if (v0 != var5_5) continue;
                            return var5_5;
                        }
                        break;
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$9 = false;
                        $i$f$forEach = false;
                        $i$a$-forEach-FlowKt__BuildersKt$asFlow$9$1 = false;
                        var10_10 = (Iterator<T>)$continuation.L$1;
                        $this$asFlow_u24lambda_u2417 = (FlowCollector)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
                        ** GOTO lbl19
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull LongRange $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<Long>($this$asFlow){
            final /* synthetic */ LongRange $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = longRange;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Long> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof asFlow$$inlined$unsafeFlow$10$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ asFlow$$inlined$unsafeFlow$10 this$0;
                        Object L$0;
                        Object L$1;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.collect((FlowCollector<? super Long>)null, (Continuation<? super Unit>)((Continuation)this));
                        }
                    };
                }
                $result = $continuation.result;
                var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        (Continuation)$continuation;
                        $this$asFlow_u24lambda_u2419 = collector;
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$10 = false;
                        $this$forEach$iv = (Iterable)this.$this_asFlow$inlined;
                        $i$f$forEach = false;
                        var10_10 = $this$forEach$iv.iterator();
lbl19:
                        // 3 sources

                        while (var10_10.hasNext()) {
                            value = element$iv = ((LongIterator)var10_10).nextLong();
                            $i$a$-forEach-FlowKt__BuildersKt$asFlow$10$1 = false;
                            $continuation.L$0 = $this$asFlow_u24lambda_u2419;
                            $continuation.L$1 = var10_10;
                            $continuation.label = 1;
                            v0 = $this$asFlow_u24lambda_u2419.emit(Boxing.boxLong((long)value), (Continuation<Unit>)$continuation);
                            if (v0 != var5_5) continue;
                            return var5_5;
                        }
                        break;
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$10 = false;
                        $i$f$forEach = false;
                        $i$a$-forEach-FlowKt__BuildersKt$asFlow$10$1 = false;
                        var10_10 = (Iterator<T>)$continuation.L$1;
                        $this$asFlow_u24lambda_u2419 = (FlowCollector)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
                        ** GOTO lbl19
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> channelFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return new ChannelFlowBuilder(block, null, 0, null, 14, null);
    }

    @NotNull
    public static final <T> Flow<T> callbackFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return new CallbackFlowBuilder(block, null, 0, null, 14, null);
    }
}

