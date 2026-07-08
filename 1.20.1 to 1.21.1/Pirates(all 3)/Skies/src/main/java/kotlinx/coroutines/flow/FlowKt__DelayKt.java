/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.OverloadResolutionByLambdaReturnType
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Ref$LongRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.time.Duration
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__DelayKt;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u001a9\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a<\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0002H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0006\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0004\b\u0005\u0010\n\u001a3\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\n\u001a9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\r\u0010\u0006\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a-\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0016\u001a\u00020\u0003H\u0007\u00a2\u0006\u0004\b\u0017\u0010\n\u001a3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0018\u001a\u00020\u0007H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\n\u001a3\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\n\u001a3\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001d"}, d2={"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "", "timeoutMillis", "debounce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/time/Duration;", "timeout", "debounceDuration", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "debounce-HG0u8IE", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "debounceInternal", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "fixedPeriodTicker", "(Lkotlinx/coroutines/CoroutineScope;JJ)Lkotlinx/coroutines/channels/ReceiveChannel;", "periodMillis", "sample", "period", "sample-HG0u8IE", "timeout-HG0u8IE", "timeoutInternal-HG0u8IE$FlowKt__DelayKt", "timeoutInternal", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n1#2:416\n*E\n"})
final class FlowKt__DelayKt {
    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> $this$debounce, long timeoutMillis) {
        if (!(timeoutMillis >= 0L)) {
            boolean bl = false;
            String string = "Debounce timeout should not be negative";
            throw new IllegalArgumentException(string.toString());
        }
        if (timeoutMillis == 0L) {
            return $this$debounce;
        }
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt($this$debounce, (Function1)new Function1<T, Long>(timeoutMillis){
            final /* synthetic */ long $timeoutMillis;
            {
                this.$timeoutMillis = $timeoutMillis;
                super(1);
            }

            @NotNull
            public final Long invoke(T it) {
                return this.$timeoutMillis;
            }
        });
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> $this$debounce, @NotNull Function1<? super T, Long> timeoutMillis) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt($this$debounce, timeoutMillis);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce-HG0u8IE(@NotNull Flow<? extends T> $this$debounce_u2dHG0u8IE, long timeout) {
        return FlowKt.debounce($this$debounce_u2dHG0u8IE, DelayKt.toDelayMillis-LRDsOJo(timeout));
    }

    @FlowPreview
    @JvmName(name="debounceDuration")
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> Flow<T> debounceDuration(@NotNull Flow<? extends T> $this$debounce, @NotNull Function1<? super T, Duration> timeout) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt($this$debounce, (Function1)new Function1<T, Long>(timeout){
            final /* synthetic */ Function1<T, Duration> $timeout;
            {
                this.$timeout = $timeout;
                super(1);
            }

            @NotNull
            public final Long invoke(T emittedItem) {
                return DelayKt.toDelayMillis-LRDsOJo(((Duration)this.$timeout.invoke(emittedItem)).unbox-impl());
            }
        });
    }

    private static final <T> Flow<T> debounceInternal$FlowKt__DelayKt(Flow<? extends T> $this$debounceInternal, Function1<? super T, Long> timeoutMillisSelector) {
        return FlowCoroutineKt.scopedFlow((Function3)new Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object>(timeoutMillisSelector, $this$debounceInternal, null){
            Object L$2;
            Object L$3;
            int label;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
            final /* synthetic */ Flow<T> $this_debounceInternal;
            {
                this.$timeoutMillisSelector = $timeoutMillisSelector;
                this.$this_debounceInternal = $receiver;
                super(3, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var13_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$scopedFlow = (CoroutineScope)this.L$0;
                        downstream = (FlowCollector)this.L$1;
                        values = ProduceKt.produce$default($this$scopedFlow, null, 0, (Function2)new Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object>(this.$this_debounceInternal, null){
                            int label;
                            private /* synthetic */ Object L$0;
                            final /* synthetic */ Flow<T> $this_debounceInternal;
                            {
                                this.$this_debounceInternal = $receiver;
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
                                        ProducerScope $this$produce = (ProducerScope)this.L$0;
                                        this.label = 1;
                                        Object object3 = this.$this_debounceInternal.collect(new FlowCollector($this$produce){
                                            final /* synthetic */ ProducerScope<Object> $$this$produce;
                                            {
                                                this.$$this$produce = $$this$produce;
                                            }

                                            /*
                                             * Unable to fully structure code
                                             */
                                            @Nullable
                                            public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                                if (!(var2_2 instanceof debounceInternal.values.emit.1)) ** GOTO lbl-1000
                                                var4_3 = var2_2;
                                                if ((var4_3.label & -2147483648) != 0) {
                                                    var4_3.label -= -2147483648;
                                                } else lbl-1000:
                                                // 2 sources

                                                {
                                                    $continuation = new ContinuationImpl(this, var2_2){
                                                        /* synthetic */ Object result;
                                                        final /* synthetic */ debounceInternal.values.1<T> this$0;
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
                                                        v0 = value;
                                                        if (v0 == null) {
                                                            v0 = NullSurrogateKt.NULL;
                                                        }
                                                        $continuation.label = 1;
                                                        v1 = this.$$this$produce.send(v0, (Continuation<Unit>)$continuation);
                                                        if (v1 == var5_5) {
                                                            return var5_5;
                                                        }
                                                        ** GOTO lbl23
                                                    }
                                                    case 1: {
                                                        ResultKt.throwOnFailure((Object)$result);
                                                        v1 = $result;
lbl23:
                                                        // 2 sources

                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        }, (Continuation<Unit>)((Continuation)this));
                                        if (object3 != object2) return Unit.INSTANCE;
                                        return object2;
                                    }
                                    case 1: {
                                        void $result;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object3 = $result;
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                                Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                                function2.L$0 = value;
                                return (Continuation)function2;
                            }

                            @Nullable
                            public final Object invoke(@NotNull ProducerScope<Object> p1, @Nullable Continuation<? super Unit> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, 3, null);
                        lastValue = new Ref.ObjectRef();
lbl9:
                        // 3 sources

                        while (lastValue.element != NullSurrogateKt.DONE) {
                            timeoutMillis = new Ref.LongRef();
                            if (lastValue.element == null) ** GOTO lbl42
                            var7_9 = NullSurrogateKt.NULL;
                            value$iv = lastValue.element;
                            $i$f$unbox = false;
                            timeoutMillis.element = ((Number)this.$timeoutMillisSelector.invoke(value$iv == this_$iv ? null : value$iv)).longValue();
                            if (!(timeoutMillis.element >= 0L)) {
                                $i$a$-require-FlowKt__DelayKt$debounceInternal$1$1 = false;
                                $i$a$-require-FlowKt__DelayKt$debounceInternal$1$1 = "Debounce timeout should not be negative";
                                throw new IllegalArgumentException($i$a$-require-FlowKt__DelayKt$debounceInternal$1$1.toString());
                            }
                            if (timeoutMillis.element != 0L) ** GOTO lbl42
                            this_$iv = NullSurrogateKt.NULL;
                            value$iv = lastValue.element;
                            $i$f$unbox = false;
                            this.L$0 = downstream;
                            this.L$1 = values;
                            this.L$2 = lastValue;
                            this.L$3 = timeoutMillis;
                            this.label = 1;
                            v0 = downstream.emit(value$iv == this_$iv ? null : value$iv, (Continuation<Unit>)((Continuation)this));
                            if (v0 == var13_2) {
                                return var13_2;
                            }
                            ** GOTO lbl41
                        }
                        break;
                    }
                    case 1: {
                        timeoutMillis = (Ref.LongRef)this.L$3;
                        lastValue = (Ref.ObjectRef)this.L$2;
                        values = (ReceiveChannel)this.L$1;
                        downstream = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl41:
                        // 2 sources

                        lastValue.element = null;
lbl42:
                        // 3 sources

                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            $i$a$-assert-FlowKt__DelayKt$debounceInternal$1$2 = false;
                            if (!(lastValue.element == null || timeoutMillis.element > 0L)) {
                                throw new AssertionError();
                            }
                        }
                        $i$f$select = false;
                        $this$select_u24lambda_u241$iv = new SelectImplementation<R>(this.getContext());
                        $i$a$-run-SelectKt$select$3$iv = false;
                        $this$invokeSuspend_u24lambda_u242 = $this$select_u24lambda_u241$iv;
                        $i$a$-select-FlowKt__DelayKt$debounceInternal$1$3 = false;
                        if (lastValue.element != null) {
                            OnTimeoutKt.onTimeout($this$invokeSuspend_u24lambda_u242, timeoutMillis.element, (Function1)new Function1<Continuation<? super Unit>, Object>(downstream, (Ref.ObjectRef<Object>)lastValue, null){
                                int label;
                                final /* synthetic */ FlowCollector<T> $downstream;
                                final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
                                {
                                    this.$downstream = $downstream;
                                    this.$lastValue = $lastValue;
                                    super(1, $completion);
                                }

                                /*
                                 * Unable to fully structure code
                                 */
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object var1_1) {
                                    var5_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            ResultKt.throwOnFailure((Object)var1_1);
                                            var2_3 = NullSurrogateKt.NULL;
                                            value$iv = this.$lastValue.element;
                                            $i$f$unbox = false;
                                            this.label = 1;
                                            v0 = this.$downstream.emit(value$iv == this_$iv ? null : var3_4, (Continuation<Unit>)((Continuation)this));
                                            if (v0 == var5_2) {
                                                return var5_2;
                                            }
                                            ** GOTO lbl16
                                        }
                                        case 1: {
                                            ResultKt.throwOnFailure((Object)$result);
                                            v0 = $result;
lbl16:
                                            // 2 sources

                                            this.$lastValue.element = null;
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                @NotNull
                                public final Continuation<Unit> create(@NotNull Continuation<?> $completion) {
                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                }

                                @Nullable
                                public final Object invoke(@Nullable Continuation<? super Unit> p1) {
                                    return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
                                }
                            });
                        }
                        $this$invokeSuspend_u24lambda_u242.invoke(values.getOnReceiveCatching(), (Function2)new Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object>((Ref.ObjectRef<Object>)lastValue, downstream, null){
                            Object L$1;
                            int label;
                            /* synthetic */ Object L$0;
                            final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
                            final /* synthetic */ FlowCollector<T> $downstream;
                            {
                                this.$lastValue = $lastValue;
                                this.$downstream = $downstream;
                                super(2, $completion);
                            }

                            /*
                             * Unable to fully structure code
                             */
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object var1_1) {
                                var12_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)var1_1);
                                        $this$onSuccess_u2dWpGqRn0$iv = value = ((ChannelResult)this.L$0).unbox-impl();
                                        var4_6 = this.$lastValue;
                                        $i$f$onSuccess-WpGqRn0 = false;
                                        if (!($this$onSuccess_u2dWpGqRn0$iv instanceof ChannelResult.Failed)) {
                                            it = $this$onSuccess_u2dWpGqRn0$iv;
                                            $i$a$-onSuccess-WpGqRn0-FlowKt__DelayKt$debounceInternal$1$3$2$1 = false;
                                            var4_6.element = it;
                                        }
                                        var4_6 = this.$lastValue;
                                        var5_8 = this.$downstream;
                                        $i$f$onFailure-WpGqRn0 = false;
                                        if (!($this$onFailure_u2dWpGqRn0$iv instanceof ChannelResult.Failed)) ** GOTO lbl46
                                        it = ChannelResult.exceptionOrNull-impl($this$onFailure_u2dWpGqRn0$iv);
                                        $i$a$-onFailure-WpGqRn0-FlowKt__DelayKt$debounceInternal$1$3$2$2 = false;
                                        v0 = it;
                                        if (v0 != null) {
                                            it = v0;
                                            $i$a$-let-FlowKt__DelayKt$debounceInternal$1$3$2$2$1 = false;
                                            throw it;
                                        }
                                        if (var4_6.element != null) {
                                            var9_20 = NullSurrogateKt.NULL;
                                            value$iv = var4_6.element;
                                            $i$f$unbox = false;
                                            this.L$0 = $this$onFailure_u2dWpGqRn0$iv;
                                            this.L$1 = var4_6;
                                            this.label = 1;
                                            v1 = var5_8.emit(value$iv == this_$iv ? null : value$iv, (Continuation<Unit>)this);
                                            if (v1 == var12_2) {
                                                return var12_2;
                                            }
                                        }
                                        ** GOTO lbl43
                                    }
                                    case 1: {
                                        $i$f$onFailure-WpGqRn0 = false;
                                        $i$a$-onFailure-WpGqRn0-FlowKt__DelayKt$debounceInternal$1$3$2$2 = false;
                                        var4_6 = (Ref.ObjectRef<Object>)this.L$1;
                                        $this$onFailure_u2dWpGqRn0$iv = this.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v1 = $result;
lbl43:
                                        // 2 sources

                                        var4_6.element = NullSurrogateKt.DONE;
lbl46:
                                        // 2 sources

                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                                Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                                function2.L$0 = value;
                                return (Continuation)function2;
                            }

                            @Nullable
                            public final Object invoke-WpGqRn0(@NotNull Object p1, @Nullable Continuation<? super Unit> p2) {
                                return (this.create(ChannelResult.box-impl(p1), p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        });
                        this.L$0 = downstream;
                        this.L$1 = values;
                        this.L$2 = lastValue;
                        this.L$3 = null;
                        this.label = 2;
                        v1 = $this$select_u24lambda_u241$iv.doSelect(this);
                        if (v1 != var13_2) ** GOTO lbl9
                        return var13_2;
                    }
                    case 2: {
                        $i$f$select = false;
                        $i$a$-run-SelectKt$select$3$iv = false;
                        lastValue = (Ref.ObjectRef)this.L$2;
                        values = (ReceiveChannel)this.L$1;
                        downstream = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
                        ** GOTO lbl9
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @NotNull FlowCollector<? super T> p2, @Nullable Continuation<? super Unit> p3) {
                Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                function3.L$0 = p1;
                function3.L$1 = p2;
                return function3.invokeSuspend((Object)Unit.INSTANCE);
            }
        });
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> $this$sample, long periodMillis) {
        if (!(periodMillis > 0L)) {
            boolean bl = false;
            String string = "Sample period should be positive";
            throw new IllegalArgumentException(string.toString());
        }
        return FlowCoroutineKt.scopedFlow((Function3)new Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object>(periodMillis, $this$sample, null){
            Object L$2;
            Object L$3;
            int label;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            final /* synthetic */ long $periodMillis;
            final /* synthetic */ Flow<T> $this_sample;
            {
                this.$periodMillis = $periodMillis;
                this.$this_sample = $receiver;
                super(3, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var12_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$scopedFlow = (CoroutineScope)this.L$0;
                        downstream = (FlowCollector)this.L$1;
                        values = ProduceKt.produce$default($this$scopedFlow, null, -1, (Function2)new Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object>(this.$this_sample, null){
                            int label;
                            private /* synthetic */ Object L$0;
                            final /* synthetic */ Flow<T> $this_sample;
                            {
                                this.$this_sample = $receiver;
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
                                        ProducerScope $this$produce = (ProducerScope)this.L$0;
                                        this.label = 1;
                                        Object object3 = this.$this_sample.collect(new FlowCollector($this$produce){
                                            final /* synthetic */ ProducerScope<Object> $$this$produce;
                                            {
                                                this.$$this$produce = $$this$produce;
                                            }

                                            /*
                                             * Unable to fully structure code
                                             */
                                            @Nullable
                                            public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                                if (!(var2_2 instanceof sample.values.emit.1)) ** GOTO lbl-1000
                                                var4_3 = var2_2;
                                                if ((var4_3.label & -2147483648) != 0) {
                                                    var4_3.label -= -2147483648;
                                                } else lbl-1000:
                                                // 2 sources

                                                {
                                                    $continuation = new ContinuationImpl(this, var2_2){
                                                        /* synthetic */ Object result;
                                                        final /* synthetic */ sample.values.1<T> this$0;
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
                                                        v0 = value;
                                                        if (v0 == null) {
                                                            v0 = NullSurrogateKt.NULL;
                                                        }
                                                        $continuation.label = 1;
                                                        v1 = this.$$this$produce.send(v0, (Continuation<Unit>)$continuation);
                                                        if (v1 == var5_5) {
                                                            return var5_5;
                                                        }
                                                        ** GOTO lbl23
                                                    }
                                                    case 1: {
                                                        ResultKt.throwOnFailure((Object)$result);
                                                        v1 = $result;
lbl23:
                                                        // 2 sources

                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        }, (Continuation<Unit>)((Continuation)this));
                                        if (object3 != object2) return Unit.INSTANCE;
                                        return object2;
                                    }
                                    case 1: {
                                        void $result;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object3 = $result;
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                                Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                                function2.L$0 = value;
                                return (Continuation)function2;
                            }

                            @Nullable
                            public final Object invoke(@NotNull ProducerScope<Object> p1, @Nullable Continuation<? super Unit> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, 1, null);
                        lastValue = new Ref.ObjectRef();
                        ticker = FlowKt.fixedPeriodTicker$default($this$scopedFlow, this.$periodMillis, 0L, 2, null);
lbl10:
                        // 3 sources

                        while (lastValue.element != NullSurrogateKt.DONE) {
                            $i$f$select = false;
                            $this$select_u24lambda_u241$iv = new SelectImplementation<R>(this.getContext());
                            $i$a$-run-SelectKt$select$3$iv = false;
                            $this$invokeSuspend_u24lambda_u240 = $this$select_u24lambda_u241$iv;
                            $i$a$-select-FlowKt__DelayKt$sample$2$1 = false;
                            $this$invokeSuspend_u24lambda_u240.invoke(values.getOnReceiveCatching(), (Function2)new Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object>((Ref.ObjectRef<Object>)lastValue, (ReceiveChannel<Unit>)ticker, null){
                                int label;
                                /* synthetic */ Object L$0;
                                final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
                                final /* synthetic */ ReceiveChannel<Unit> $ticker;
                                {
                                    this.$lastValue = $lastValue;
                                    this.$ticker = $ticker;
                                    super(2, $completion);
                                }

                                /*
                                 * WARNING - void declaration
                                 */
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object object) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            void $this$onFailure_u2dWpGqRn0$iv;
                                            Object result2;
                                            ResultKt.throwOnFailure((Object)object);
                                            Object $this$onSuccess_u2dWpGqRn0$iv = result2 = ((ChannelResult)this.L$0).unbox-impl();
                                            Object object2 = this.$lastValue;
                                            boolean bl = false;
                                            if (!($this$onSuccess_u2dWpGqRn0$iv instanceof ChannelResult.Failed)) {
                                                Object it = $this$onSuccess_u2dWpGqRn0$iv;
                                                boolean bl2 = false;
                                                ((Ref.ObjectRef)object2).element = it;
                                            }
                                            object2 = this.$ticker;
                                            Ref.ObjectRef<Object> objectRef = this.$lastValue;
                                            boolean bl3 = false;
                                            if ($this$onFailure_u2dWpGqRn0$iv instanceof ChannelResult.Failed) {
                                                Throwable it = ChannelResult.exceptionOrNull-impl($this$onFailure_u2dWpGqRn0$iv);
                                                boolean bl4 = false;
                                                Throwable throwable = it;
                                                if (throwable != null) {
                                                    Throwable it2 = throwable;
                                                    boolean bl5 = false;
                                                    throw it2;
                                                }
                                                object2.cancel(new ChildCancelledException());
                                                objectRef.element = NullSurrogateKt.DONE;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                                    Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                                    function2.L$0 = value;
                                    return (Continuation)function2;
                                }

                                @Nullable
                                public final Object invoke-WpGqRn0(@NotNull Object p1, @Nullable Continuation<? super Unit> p2) {
                                    return (this.create(ChannelResult.box-impl(p1), p2)).invokeSuspend(Unit.INSTANCE);
                                }
                            });
                            $this$invokeSuspend_u24lambda_u240.invoke(ticker.getOnReceive(), (Function2)new Function2<Unit, Continuation<? super Unit>, Object>((Ref.ObjectRef<Object>)lastValue, downstream, null){
                                int label;
                                final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
                                final /* synthetic */ FlowCollector<T> $downstream;
                                {
                                    this.$lastValue = $lastValue;
                                    this.$downstream = $downstream;
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
                                            void var2_3;
                                            ResultKt.throwOnFailure((Object)object);
                                            Object object3 = this.$lastValue.element;
                                            if (object3 == null) {
                                                return Unit.INSTANCE;
                                            }
                                            Object value = object3;
                                            this.$lastValue.element = null;
                                            Symbol this_$iv = NullSurrogateKt.NULL;
                                            boolean $i$f$unbox = false;
                                            this.label = 1;
                                            Object object4 = this.$downstream.emit(value == this_$iv ? null : var2_3, (Continuation<Unit>)((Continuation)this));
                                            if (object4 != object2) return Unit.INSTANCE;
                                            return object2;
                                        }
                                        case 1: {
                                            void $result;
                                            ResultKt.throwOnFailure((Object)$result);
                                            Object object4 = $result;
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                }

                                @Nullable
                                public final Object invoke(@NotNull Unit p1, @Nullable Continuation<? super Unit> p2) {
                                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                }
                            });
                            this.L$0 = downstream;
                            this.L$1 = values;
                            this.L$2 = lastValue;
                            this.L$3 = ticker;
                            this.label = 1;
                            v0 = $this$select_u24lambda_u241$iv.doSelect(this);
                            if (v0 != var12_2) continue;
                            return var12_2;
                        }
                        break;
                    }
                    case 1: {
                        $i$f$select = false;
                        $i$a$-run-SelectKt$select$3$iv = false;
                        ticker = (ReceiveChannel)this.L$3;
                        lastValue = (Ref.ObjectRef)this.L$2;
                        values = (ReceiveChannel)this.L$1;
                        downstream = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
                        ** GOTO lbl10
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @NotNull FlowCollector<? super T> p2, @Nullable Continuation<? super Unit> p3) {
                Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                function3.L$0 = p1;
                function3.L$1 = p2;
                return function3.invokeSuspend((Object)Unit.INSTANCE);
            }
        });
    }

    @NotNull
    public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope $this$fixedPeriodTicker, long delayMillis, long initialDelayMillis) {
        if (!(delayMillis >= 0L)) {
            boolean $i$a$-require-FlowKt__DelayKt$fixedPeriodTicker$32 = false;
            String $i$a$-require-FlowKt__DelayKt$fixedPeriodTicker$32 = "Expected non-negative delay, but has " + delayMillis + " ms";
            throw new IllegalArgumentException($i$a$-require-FlowKt__DelayKt$fixedPeriodTicker$32.toString());
        }
        if (!(initialDelayMillis >= 0L)) {
            boolean bl = false;
            String string = "Expected non-negative initial delay, but has " + initialDelayMillis + " ms";
            throw new IllegalArgumentException(string.toString());
        }
        return ProduceKt.produce$default($this$fixedPeriodTicker, null, 0, (Function2)new Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object>(initialDelayMillis, delayMillis, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ long $initialDelayMillis;
            final /* synthetic */ long $delayMillis;
            {
                this.$initialDelayMillis = $initialDelayMillis;
                this.$delayMillis = $delayMillis;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var3_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        this.L$0 = $this$produce;
                        this.label = 1;
                        v0 = DelayKt.delay(this.$initialDelayMillis, (Continuation<? super Unit>)((Continuation)this));
                        if (v0 == var3_2) {
                            return var3_2;
                        }
                        ** GOTO lbl16
                    }
                    case 1: {
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl16:
                        // 3 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.label = 2;
                            v1 = $this$produce.getChannel().send(Unit.INSTANCE, (Continuation<Unit>)((Continuation)this));
                            if (v1 == var3_2) {
                                return var3_2;
                            }
                            ** GOTO lbl27
                            break;
                        }
                    }
                    case 2: {
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl27:
                        // 2 sources

                        this.L$0 = $this$produce;
                        this.label = 3;
                        v2 = DelayKt.delay(this.$delayMillis, (Continuation<? super Unit>)((Continuation)this));
                        if (v2 == var3_2) {
                            return var3_2;
                        }
                        ** GOTO lbl37
                    }
                    case 3: {
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl37:
                        // 2 sources

                        ** continue;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super Unit> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 1, null);
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long l2, long l3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            l3 = l2;
        }
        return FlowKt.fixedPeriodTicker(coroutineScope, l2, l3);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> sample-HG0u8IE(@NotNull Flow<? extends T> $this$sample_u2dHG0u8IE, long period) {
        return FlowKt.sample($this$sample_u2dHG0u8IE, DelayKt.toDelayMillis-LRDsOJo(period));
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> timeout-HG0u8IE(@NotNull Flow<? extends T> $this$timeout_u2dHG0u8IE, long timeout) {
        return FlowKt__DelayKt.timeoutInternal-HG0u8IE$FlowKt__DelayKt($this$timeout_u2dHG0u8IE, timeout);
    }

    private static final <T> Flow<T> timeoutInternal-HG0u8IE$FlowKt__DelayKt(Flow<? extends T> $this$timeoutInternal_u2dHG0u8IE, long timeout) {
        return FlowCoroutineKt.scopedFlow((Function3)new Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object>(timeout, $this$timeoutInternal_u2dHG0u8IE, null){
            long J$0;
            int label;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            final /* synthetic */ long $timeout;
            final /* synthetic */ Flow<T> $this_timeoutInternal;
            {
                this.$timeout = $timeout;
                this.$this_timeoutInternal = $receiver;
                super(3, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var13_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$scopedFlow = (CoroutineScope)this.L$0;
                        downStream = (FlowCollector)this.L$1;
                        if (Duration.compareTo-LRDsOJo((long)this.$timeout, (long)Duration.Companion.getZERO-UwyO8pc()) <= 0) {
                            throw new TimeoutCancellationException("Timed out immediately");
                        }
                        values = FlowKt.produceIn(FlowKt.buffer$default(this.$this_timeoutInternal, 0, null, 2, null), $this$scopedFlow);
                        var5_6 = this.$timeout;
                        $i$f$whileSelect = false;
                        while (true) {
                            $i$f$select = false;
                            $this$select_u24lambda_u241$iv$iv = new SelectImplementation<R>(this.getContext());
                            $i$a$-run-SelectKt$select$3$iv$iv = false;
                            $this$invokeSuspend_u24lambda_u240 = $this$select_u24lambda_u241$iv$iv;
                            $i$a$-whileSelect-FlowKt__DelayKt$timeoutInternal$1$1 = false;
                            $this$invokeSuspend_u24lambda_u240.invoke(values.getOnReceiveCatching(), (Function2)new Function2<ChannelResult<? extends T>, Continuation<? super Boolean>, Object>(downStream, null){
                                int label;
                                /* synthetic */ Object L$0;
                                final /* synthetic */ FlowCollector<T> $downStream;
                                {
                                    this.$downStream = $downStream;
                                    super(2, $completion);
                                }

                                /*
                                 * Unable to fully structure code
                                 */
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object var1_1) {
                                    var8_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            ResultKt.throwOnFailure((Object)var1_1);
                                            var3_4 = value = ((ChannelResult)this.L$0).unbox-impl();
                                            var4_5 = this.$downStream;
                                            $i$f$onSuccess-WpGqRn0 = false;
                                            if (!($this$onSuccess_u2dWpGqRn0$iv instanceof ChannelResult.Failed)) {
                                                it = $this$onSuccess_u2dWpGqRn0$iv;
                                                $i$a$-onSuccess-WpGqRn0-FlowKt__DelayKt$timeoutInternal$1$1$1$1 = false;
                                                this.L$0 = $this$onSuccess_u2dWpGqRn0$iv;
                                                this.label = 1;
                                                v0 = var4_5.emit(it, (Continuation<Unit>)this);
                                                if (v0 == var8_2) {
                                                    return var8_2;
                                                }
                                            }
                                            ** GOTO lbl24
                                        }
                                        case 1: {
                                            $i$f$onSuccess-WpGqRn0 = false;
                                            $i$a$-onSuccess-WpGqRn0-FlowKt__DelayKt$timeoutInternal$1$1$1$1 = false;
                                            $this$onSuccess_u2dWpGqRn0$iv = this.L$0;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v0 = $result;
lbl24:
                                            // 2 sources

                                            $i$f$onClosed-WpGqRn0 = false;
                                            if ($this$onClosed_u2dWpGqRn0$iv instanceof ChannelResult.Closed) {
                                                ChannelResult.exceptionOrNull-impl($this$onClosed_u2dWpGqRn0$iv);
                                                $i$a$-onClosed-WpGqRn0-FlowKt__DelayKt$timeoutInternal$1$1$1$2 = false;
                                                return Boxing.boxBoolean((boolean)false);
                                            }
                                            return Boxing.boxBoolean((boolean)true);
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                                    Function2<ChannelResult<? extends T>, Continuation<? super Boolean>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                                    function2.L$0 = value;
                                    return (Continuation)function2;
                                }

                                @Nullable
                                public final Object invoke-WpGqRn0(@NotNull Object p1, @Nullable Continuation<? super Boolean> p2) {
                                    return (this.create(ChannelResult.box-impl(p1), p2)).invokeSuspend(Unit.INSTANCE);
                                }
                            });
                            OnTimeoutKt.onTimeout-8Mi8wO0($this$invokeSuspend_u24lambda_u240, var5_6, (Function1)new Function1<Continuation<?>, Object>(var5_6, null){
                                int label;
                                final /* synthetic */ long $timeout;
                                {
                                    this.$timeout = $timeout;
                                    super(1, $completion);
                                }

                                @Nullable
                                public final Object invokeSuspend(@NotNull Object object) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            ResultKt.throwOnFailure((Object)object);
                                            throw new TimeoutCancellationException("Timed out waiting for " + Duration.toString-impl((long)this.$timeout));
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                @NotNull
                                public final Continuation<Unit> create(@NotNull Continuation<?> $completion) {
                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                }

                                @Nullable
                                public final Object invoke(@Nullable Continuation<?> p1) {
                                    return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
                                }
                            });
                            this.L$0 = downStream;
                            this.L$1 = values;
                            this.J$0 = var5_6;
                            this.label = 1;
                            v0 = $this$select_u24lambda_u241$iv$iv.doSelect(this);
                            if (v0 != var13_2) continue;
                            return var13_2;
                        }
                    }
                    case 1: {
                        $i$f$whileSelect = false;
                        $i$f$select = false;
                        $i$a$-run-SelectKt$select$3$iv$iv = false;
                        var5_6 = this.J$0;
                        values = (ReceiveChannel<T>)this.L$1;
                        downStream = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
                        if (((Boolean)v0).booleanValue()) ** continue;
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @NotNull FlowCollector<? super T> p2, @Nullable Continuation<? super Unit> p3) {
                Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                function3.L$0 = p1;
                function3.L$1 = p2;
                return function3.invokeSuspend((Object)Unit.INSTANCE);
            }
        });
    }
}

