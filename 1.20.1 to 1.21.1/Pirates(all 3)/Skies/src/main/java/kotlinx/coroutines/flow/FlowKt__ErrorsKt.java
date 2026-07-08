/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aj\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012B\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0002\u00a2\u0006\u0002\b\u000b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a3\u0010\u0010\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0017\u001a\u00020\u0014*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u001b\u001a\u00020\u0014*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001ae\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u001c23\b\u0002\u0010\u001f\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001e\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001a\u007f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012W\u0010\u001f\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\"\u00a2\u0006\u0002\b\u000b\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2={"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "action", "catch", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "collector", "catchImpl", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "isCancellationCause$FlowKt__ErrorsKt", "(Ljava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)Z", "isCancellationCause", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "isSameExceptionAs", "", "retries", "Lkotlin/Function2;", "predicate", "retry", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "attempt", "retryWhen", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nErrors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,224:1\n107#2:225\n107#2:227\n1#3:226\n163#4:228\n*S KotlinDebug\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n58#1:225\n132#1:227\n221#1:228\n*E\n"})
final class FlowKt__ErrorsKt {
    @NotNull
    public static final <T> Flow<T> catch(@NotNull Flow<? extends T> $this$catch, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$catch, action){
            final /* synthetic */ Flow $this_catch$inlined;
            final /* synthetic */ Function3 $action$inlined;
            {
                this.$this_catch$inlined = flow;
                this.$action$inlined = function3;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof catch$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ catch$$inlined$unsafeFlow$1 this$0;
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
                        var6_6 = (Continuation)$continuation;
                        $this$catch_u24lambda_u240 = collector;
                        $i$a$-unsafeFlow-FlowKt__ErrorsKt$catch$1 = false;
                        $continuation.L$0 = this;
                        $continuation.L$1 = $this$catch_u24lambda_u240;
                        $continuation.label = 1;
                        v0 = FlowKt.catchImpl(this.$this_catch$inlined, $this$catch_u24lambda_u240, (Continuation<? super Throwable>)$continuation);
                        if (v0 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl28
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__ErrorsKt$catch$1 = false;
                        $this$catch_u24lambda_u240 = (FlowCollector)$continuation.L$1;
                        this = $continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl28:
                        // 2 sources

                        if ((exception = (Throwable)v0) != null) {
                            $continuation.L$0 = null;
                            $continuation.L$1 = null;
                            $continuation.label = 2;
                            InlineMarker.mark((int)6);
                            v1 = this.$action$inlined.invoke((Object)$this$catch_u24lambda_u240, (Object)exception, (Object)$continuation);
                            InlineMarker.mark((int)7);
                            v2 = v1;
                            if (v1 == var5_5) {
                                return var5_5;
                            }
                        }
                        ** GOTO lbl43
                    }
                    case 2: {
                        $i$a$-unsafeFlow-FlowKt__ErrorsKt$catch$1 = false;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl43:
                        // 2 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> retry(@NotNull Flow<? extends T> $this$retry, long retries, @NotNull Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        if (!(retries > 0L)) {
            boolean bl = false;
            String string = "Expected positive amount of retries, but had " + retries;
            throw new IllegalArgumentException(string.toString());
        }
        return FlowKt.retryWhen($this$retry, (Function4)new Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object>(retries, predicate, null){
            int label;
            /* synthetic */ Object L$0;
            /* synthetic */ long J$0;
            final /* synthetic */ long $retries;
            final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> $predicate;
            {
                this.$retries = $retries;
                this.$predicate = $predicate;
                super(4, $completion);
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
                        cause = (Throwable)this.L$0;
                        attempt = this.J$0;
                        if (attempt >= this.$retries) ** GOTO lbl-1000
                        this.label = 1;
                        v0 = this.$predicate.invoke((Object)cause, (Object)this);
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

                        if (((Boolean)v0).booleanValue()) {
                            v1 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v1 = false;
                        }
                        return Boxing.boxBoolean((boolean)v1);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super T> p1, @NotNull Throwable p2, long p3, @Nullable Continuation<? super Boolean> p4) {
                Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> function4 = new /* invalid duplicate definition of identical inner class */;
                function4.L$0 = p2;
                function4.J$0 = p3;
                return function4.invokeSuspend((Object)Unit.INSTANCE);
            }
        });
    }

    public static /* synthetic */ Flow retry$default(Flow flow, long l2, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = Long.MAX_VALUE;
        }
        if ((n2 & 2) != 0) {
            function2 = (Function2)new Function2<Throwable, Continuation<? super Boolean>, Object>(null){
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object object) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)object);
                            return Boxing.boxBoolean((boolean)true);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                @Nullable
                public final Object invoke(@NotNull Throwable p1, @Nullable Continuation<? super Boolean> p2) {
                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                }
            };
        }
        return FlowKt.retry(flow, l2, (Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>)function2);
    }

    @NotNull
    public static final <T> Flow<T> retryWhen(@NotNull Flow<? extends T> $this$retryWhen, @NotNull Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$retryWhen, predicate){
            final /* synthetic */ Flow $this_retryWhen$inlined;
            final /* synthetic */ Function4 $predicate$inlined;
            {
                this.$this_retryWhen$inlined = flow;
                this.$predicate$inlined = function4;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof retryWhen$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ retryWhen$$inlined$unsafeFlow$1 this$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        long J$0;
                        int I$0;
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
                        $this$retryWhen_u24lambda_u242 = collector;
                        $i$a$-unsafeFlow-FlowKt__ErrorsKt$retryWhen$1 = false;
                        attempt = 0L;
                        var11_10 = false;
                        while (true) {
                            shallRetry = 0;
                            $continuation.L$0 = this;
                            $continuation.L$1 = $this$retryWhen_u24lambda_u242;
                            $continuation.L$2 = null;
                            $continuation.J$0 = attempt;
                            $continuation.I$0 = shallRetry;
                            $continuation.label = 1;
                            v0 = FlowKt.catchImpl(this.$this_retryWhen$inlined, $this$retryWhen_u24lambda_u242, (Continuation<? super Throwable>)$continuation);
                            if (v0 == var5_5) {
                                return var5_5;
                            }
                            ** GOTO lbl37
                            break;
                        }
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__ErrorsKt$retryWhen$1 = false;
                        shallRetry = $continuation.I$0;
                        attempt = $continuation.J$0;
                        $this$retryWhen_u24lambda_u242 = (FlowCollector)$continuation.L$1;
                        this = $continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl37:
                        // 2 sources

                        if ((cause = (Throwable)v0) == null) ** GOTO lbl65
                        v1 = Boxing.boxLong((long)attempt);
                        $continuation.L$0 = this;
                        $continuation.L$1 = $this$retryWhen_u24lambda_u242;
                        $continuation.L$2 = cause;
                        $continuation.J$0 = attempt;
                        $continuation.label = 2;
                        InlineMarker.mark((int)6);
                        v2 = this.$predicate$inlined.invoke((Object)$this$retryWhen_u24lambda_u242, (Object)cause, (Object)v1, (Object)$continuation);
                        InlineMarker.mark((int)7);
                        v3 = v2;
                        if (v2 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl59
                    }
                    case 2: {
                        $i$a$-unsafeFlow-FlowKt__ErrorsKt$retryWhen$1 = false;
                        attempt = $continuation.J$0;
                        cause = (Throwable)$continuation.L$2;
                        $this$retryWhen_u24lambda_u242 = (FlowCollector)$continuation.L$1;
                        this = $continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v3 = $result;
lbl59:
                        // 2 sources

                        if (((Boolean)v3).booleanValue()) {
                            shallRetry = 1;
                            var13_12 = attempt;
                            attempt = var13_12 + 1L;
                        } else {
                            throw cause;
                        }
lbl65:
                        // 2 sources

                        if (shallRetry != 0) ** continue;
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
    @Nullable
    public static final <T> Object catchImpl(@NotNull Flow<? extends T> var0, @NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Throwable> var2_2) {
        if (!(var2_2 instanceof catchImpl.1)) ** GOTO lbl-1000
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
                    return FlowKt.catchImpl(null, null, (Continuation<? super Throwable>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var8_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                fromDownstream = new Ref.ObjectRef();
                $continuation.L$0 = fromDownstream;
                $continuation.label = 1;
                v0 = $this$catchImpl.collect(new FlowCollector(collector, (Ref.ObjectRef<Throwable>)fromDownstream){
                    final /* synthetic */ FlowCollector<T> $collector;
                    final /* synthetic */ Ref.ObjectRef<Throwable> $fromDownstream;
                    {
                        this.$collector = $collector;
                        this.$fromDownstream = $fromDownstream;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof catchImpl.emit.1)) ** GOTO lbl-1000
                        var5_3 = var2_2;
                        if ((var5_3.label & -2147483648) != 0) {
                            var5_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                Object L$0;
                                /* synthetic */ Object result;
                                final /* synthetic */ catchImpl.2<T> this$0;
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
                                $continuation.L$0 = this;
                                $continuation.label = 1;
                                v0 = this.$collector.emit(it, (Continuation<Unit>)$continuation);
                                ** if (v0 != var6_5) goto lbl19
lbl18:
                                // 1 sources

                                return var6_5;
lbl19:
                                // 1 sources

                                ** GOTO lbl30
                            }
                            case 1: {
                                this = $continuation.L$0;
                                try {
                                    ResultKt.throwOnFailure((Object)$result);
                                    v0 = $result;
                                }
                                catch (Throwable e) {
                                    this.$fromDownstream.element = e;
                                    throw e;
                                }
lbl30:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (Continuation<Unit>)$continuation);
                ** if (v0 != var8_5) goto lbl20
lbl19:
                // 1 sources

                return var8_5;
lbl20:
                // 1 sources

                ** GOTO lbl39
            }
            case 1: {
                fromDownstream = (Ref.ObjectRef)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (Throwable e) {
                    fromDownstream = (Throwable)fromDownstream.element;
                    if (FlowKt__ErrorsKt.isSameExceptionAs$FlowKt__ErrorsKt(e, fromDownstream) || FlowKt__ErrorsKt.isCancellationCause$FlowKt__ErrorsKt(e, $continuation.getContext())) {
                        throw e;
                    }
                    if (fromDownstream == null) {
                        return e;
                    }
                    if (e instanceof CancellationException) {
                        ExceptionsKt.addSuppressed((Throwable)fromDownstream, (Throwable)e);
                        throw fromDownstream;
                    }
                    ExceptionsKt.addSuppressed((Throwable)e, (Throwable)fromDownstream);
                    throw e;
                }
lbl39:
                // 2 sources

                return null;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable $this$isCancellationCause, CoroutineContext coroutineContext) {
        Job job = (Job)coroutineContext.get((CoroutineContext.Key)Job.Key);
        if (job == null || !job.isCancelled()) {
            return false;
        }
        return FlowKt__ErrorsKt.isSameExceptionAs$FlowKt__ErrorsKt($this$isCancellationCause, job.getCancellationException());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable $this$isSameExceptionAs, Throwable other) {
        if (other == null) return false;
        boolean $i$f$unwrap = false;
        $i$f$unwrap = false;
        if (!Intrinsics.areEqual((Object)(!DebugKt.getRECOVER_STACK_TRACES() ? other : StackTraceRecoveryKt.unwrapImpl(other)), (Object)(!DebugKt.getRECOVER_STACK_TRACES() ? $this$isSameExceptionAs : StackTraceRecoveryKt.unwrapImpl($this$isSameExceptionAs)))) return false;
        return true;
    }
}

