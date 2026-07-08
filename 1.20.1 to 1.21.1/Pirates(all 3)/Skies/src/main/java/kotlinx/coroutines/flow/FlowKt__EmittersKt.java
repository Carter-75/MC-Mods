/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
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
import kotlinx.coroutines.flow.FlowKt__EmittersKt;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$;
import kotlinx.coroutines.flow.ThrowingCollector;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001as\u0010\u0010\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002D\u0010\r\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00a2\u0006\u0002\b\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001al\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00112D\u0010\r\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00a2\u0006\u0002\b\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001aU\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00112-\u0010\r\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0014\u00a2\u0006\u0002\b\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001aU\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00112-\u0010\r\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0014\u00a2\u0006\u0002\b\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0016\u001au\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00112D\b\u0005\u0010\u001a\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00a2\u0006\u0002\b\fH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0013\u001au\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00112D\b\u0005\u0010\u001a\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00a2\u0006\u0002\b\fH\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2={"Lkotlinx/coroutines/flow/FlowCollector;", "", "ensureActive", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "T", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "action", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeSafely", "Lkotlinx/coroutines/flow/Flow;", "onCompletion", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "onEmpty", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "onStart", "R", "value", "transform", "unsafeTransform", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n107#2:223\n107#2:224\n107#2:225\n107#2:226\n75#3:227\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n50#1:223\n76#1:224\n146#1:225\n181#1:226\n218#1:227\n*E\n"})
final class FlowKt__EmittersKt {
    @NotNull
    public static final <T, R> Flow<R> transform(@NotNull Flow<? extends T> $this$transform, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        boolean $i$f$transform = false;
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>($this$transform, transform2, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow<T> $this_transform;
            final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> $transform;
            {
                this.$this_transform = $receiver;
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
                        ResultKt.throwOnFailure((Object)object);
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        this.label = 1;
                        Object object3 = this.$this_transform.collect(new FlowCollector(this.$transform, $this$flow){
                            final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> $transform;
                            final /* synthetic */ FlowCollector<R> $$this$flow;
                            {
                                this.$transform = $transform;
                                this.$$this$flow = $$this$flow;
                            }

                            /*
                             * Unable to fully structure code
                             */
                            @Nullable
                            public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                if (!(var2_2 instanceof transform.emit.1)) ** GOTO lbl-1000
                                var4_3 = var2_2;
                                if ((var4_3.label & -2147483648) != 0) {
                                    var4_3.label -= -2147483648;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    $continuation = new ContinuationImpl(this, var2_2){
                                        /* synthetic */ Object result;
                                        final /* synthetic */ transform.1<T> this$0;
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
                                        $continuation.label = 1;
                                        v0 = this.$transform.invoke(this.$$this$flow, (Object)value, (Object)$continuation);
                                        if (v0 == var5_5) {
                                            return var5_5;
                                        }
                                        ** GOTO lbl20
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = $result;
lbl20:
                                        // 2 sources

                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @Nullable
                            public final Object emit$$forInline(T value, @NotNull Continuation<? super Unit> $completion) {
                                InlineMarker.mark((int)4);
                                new /* invalid duplicate definition of identical inner class */;
                                InlineMarker.mark((int)5);
                                this.$transform.invoke(this.$$this$flow, value, $completion);
                                return Unit.INSTANCE;
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

            @Nullable
            public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                FlowCollector $this$flow = (FlowCollector)this.L$0;
                FlowCollector flowCollector = new /* invalid duplicate definition of identical inner class */;
                Continuation continuation = (Continuation)this;
                InlineMarker.mark((int)0);
                this.$this_transform.collect(flowCollector, (Continuation<Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
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

    @PublishedApi
    @NotNull
    public static final <T, R> Flow<R> unsafeTransform(@NotNull Flow<? extends T> $this$unsafeTransform, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>($this$unsafeTransform, transform2){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ Function3 $transform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow;
                this.$transform$inlined = function3;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super R> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super R> $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector(this.$transform$inlined, $this$unsafeTransform_u24lambda_u240){
                    final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> $transform;
                    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                    {
                        this.$transform = $transform;
                        this.$this_unsafeFlow = $receiver;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof unsafeTransform.1.emit.1)) ** GOTO lbl-1000
                        var4_3 = var2_2;
                        if ((var4_3.label & -2147483648) != 0) {
                            var4_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                final /* synthetic */ unsafeTransform.1.1<T> this$0;
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
                                $continuation.label = 1;
                                v0 = this.$transform.invoke(this.$this_unsafeFlow, (Object)value, (Object)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl20
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl20:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Nullable
                    public final Object emit$$forInline(T value, @NotNull Continuation<? super Unit> $completion) {
                        InlineMarker.mark((int)4);
                        new /* invalid duplicate definition of identical inner class */;
                        InlineMarker.mark((int)5);
                        this.$transform.invoke(this.$this_unsafeFlow, value, $completion);
                        return Unit.INSTANCE;
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            @Nullable
            public Object collect$$forInline(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, $completion){
                    /* synthetic */ Object result;
                    int label;
                    final /* synthetic */ unsafeTransform$$inlined$unsafeFlow$1 this$0;
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
                InlineMarker.mark((int)5);
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                FlowCollector flowCollector = new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                this.$this_unsafeTransform$inlined.collect(flowCollector, (Continuation<Unit>)$completion);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> onStart(@NotNull Flow<? extends T> $this$onStart, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>(action, $this$onStart){
            final /* synthetic */ Function2 $action$inlined;
            final /* synthetic */ Flow $this_onStart$inlined;
            {
                this.$action$inlined = function2;
                this.$this_onStart$inlined = flow;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof onStart$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ onStart$$inlined$unsafeFlow$1 this$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
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
                        $this$onStart_u24lambda_u241 = collector;
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onStart$1 = false;
                        var9_11 = $continuation;
                        $i$f$currentCoroutineContext = false;
                        safeCollector = new SafeCollector<T>($this$onStart_u24lambda_u241, $continuation.getContext());
                        $continuation.L$0 = this;
                        $continuation.L$1 = $this$onStart_u24lambda_u241;
                        $continuation.L$2 = safeCollector;
                        $continuation.label = 1;
                        InlineMarker.mark((int)6);
                        v0 = this.$action$inlined.invoke(safeCollector, (Object)$continuation);
                        InlineMarker.mark((int)7);
                        v1 = v0;
                        if (v0 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl47
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onStart$1 = false;
                        safeCollector = (SafeCollector<T>)$continuation.L$2;
                        $this$onStart_u24lambda_u241 = (FlowCollector)$continuation.L$1;
                        this = $continuation.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v1 = $result;
                        }
                        catch (Throwable var9_12) {
                            throw var9_12;
                        }
                        finally {
                            safeCollector.releaseIntercepted();
                        }
lbl47:
                        // 2 sources

                        $continuation.L$0 = null;
                        $continuation.L$1 = null;
                        $continuation.L$2 = null;
                        $continuation.label = 2;
                        v2 = this.$this_onStart$inlined.collect($this$onStart_u24lambda_u241, (Continuation<Unit>)$continuation);
                        if (v2 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl59
                    }
                    case 2: {
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onStart$1 = false;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl59:
                        // 2 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> onCompletion(@NotNull Flow<? extends T> $this$onCompletion, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$onCompletion, action){
            final /* synthetic */ Flow $this_onCompletion$inlined;
            final /* synthetic */ Function3 $action$inlined;
            {
                this.$this_onCompletion$inlined = flow;
                this.$action$inlined = function3;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof onCompletion$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ onCompletion$$inlined$unsafeFlow$1 this$0;
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
                        $this$onCompletion_u24lambda_u242 = collector;
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onCompletion$1 = false;
                        try {
                            $continuation.L$0 = this;
                            $continuation.L$1 = $this$onCompletion_u24lambda_u242;
                            $continuation.label = 1;
                            v0 = this.$this_onCompletion$inlined.collect($this$onCompletion_u24lambda_u242, (Continuation<Unit>)$continuation);
                        }
                        catch (Throwable e) {
                            $continuation.L$0 = e;
                            $continuation.L$1 = null;
                            $continuation.label = 2;
                            v1 = FlowKt__EmittersKt.access$invokeSafely$FlowKt__EmittersKt(new ThrowingCollector(e), this.$action$inlined, e, (Continuation)$continuation);
                            v2 = v1;
                            if (v1 != var5_5) throw e;
                            return var5_5;
                        }
                        v3 = v0;
                        if (v0 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl48
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onCompletion$1 = false;
                        $this$onCompletion_u24lambda_u242 = (FlowCollector)$continuation.L$1;
                        this = $continuation.L$0;
                        {
                            ResultKt.throwOnFailure((Object)$result);
                            v3 = $result;
                            ** break;
                        }
                    }
                    case 2: {
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onCompletion$1 = false;
                        e = (Throwable)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
                        throw e;
                    }
lbl48:
                    // 2 sources

                    var10_15 = $continuation;
                    $i$f$currentCoroutineContext = false;
                    sc = new SafeCollector<T>($this$onCompletion_u24lambda_u242, $continuation.getContext());
                    $continuation.L$0 = sc;
                    $continuation.L$1 = null;
                    $continuation.label = 3;
                    InlineMarker.mark((int)6);
                    v4 = this.$action$inlined.invoke(sc, null, (Object)$continuation);
                    InlineMarker.mark((int)7);
                    v5 = v4;
                    if (v4 != var5_5) return Unit.INSTANCE;
                    return var5_5;
                    case 3: {
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onCompletion$1 = false;
                        sc = (SafeCollector<T>)$continuation.L$0;
                        ** try [egrp 3[TRYBLOCK] [3 : 336->345)] { 
lbl70:
                        // 1 sources

                        ResultKt.throwOnFailure((Object)$result);
                        v5 = $result;
                        return Unit.INSTANCE;
lbl74:
                        // 1 sources

                        finally {
                            sc.releaseIntercepted();
                        }
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> onEmpty(@NotNull Flow<? extends T> $this$onEmpty, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$onEmpty, action){
            final /* synthetic */ Flow $this_onEmpty$inlined;
            final /* synthetic */ Function2 $action$inlined;
            {
                this.$this_onEmpty$inlined = flow;
                this.$action$inlined = function2;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof onEmpty$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ onEmpty$$inlined$unsafeFlow$1 this$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
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
                        $this$onEmpty_u24lambda_u243 = collector;
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onEmpty$1 = false;
                        isEmpty = new Ref.BooleanRef();
                        isEmpty.element = true;
                        $continuation.L$0 = this;
                        $continuation.L$1 = $this$onEmpty_u24lambda_u243;
                        $continuation.L$2 = isEmpty;
                        $continuation.label = 1;
                        v0 = this.$this_onEmpty$inlined.collect(new FlowCollector(isEmpty, $this$onEmpty_u24lambda_u243){
                            final /* synthetic */ Ref.BooleanRef $isEmpty;
                            final /* synthetic */ FlowCollector<T> $this_unsafeFlow;
                            {
                                this.$isEmpty = $isEmpty;
                                this.$this_unsafeFlow = $receiver;
                            }

                            /*
                             * Unable to fully structure code
                             */
                            @Nullable
                            public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                if (!(var2_2 instanceof onEmpty.1.emit.1)) ** GOTO lbl-1000
                                var4_3 = var2_2;
                                if ((var4_3.label & -2147483648) != 0) {
                                    var4_3.label -= -2147483648;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    $continuation = new ContinuationImpl(this, var2_2){
                                        /* synthetic */ Object result;
                                        final /* synthetic */ onEmpty.1.1<T> this$0;
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
                                        this.$isEmpty.element = false;
                                        $continuation.label = 1;
                                        v0 = this.$this_unsafeFlow.emit(it, (Continuation<Unit>)$continuation);
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
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (Continuation<Unit>)$continuation);
                        if (v0 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl32
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onEmpty$1 = false;
                        isEmpty = (Ref.BooleanRef)$continuation.L$2;
                        $this$onEmpty_u24lambda_u243 = (FlowCollector)$continuation.L$1;
                        this = $continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl32:
                        // 2 sources

                        if (isEmpty.element) {
                            var10_12 = $continuation;
                            $i$f$currentCoroutineContext = false;
                            collector = new SafeCollector<T>($this$onEmpty_u24lambda_u243, $continuation.getContext());
                            $continuation.L$0 = collector;
                            $continuation.L$1 = null;
                            $continuation.L$2 = null;
                            $continuation.label = 2;
                            InlineMarker.mark((int)6);
                            v1 = this.$action$inlined.invoke(collector, (Object)$continuation);
                            InlineMarker.mark((int)7);
                            v2 = v1;
                            if (v1 == var5_5) {
                                return var5_5;
                            }
                        }
                        ** GOTO lbl63
                    }
                    case 2: {
                        $i$a$-unsafeFlow-FlowKt__EmittersKt$onEmpty$1 = false;
                        collector = (SafeCollector<T>)$continuation.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v2 = $result;
                        }
                        catch (Throwable var10_13) {
                            throw var10_13;
                        }
                        finally {
                            collector.releaseIntercepted();
                        }
lbl63:
                        // 2 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    public static final void ensureActive(@NotNull FlowCollector<?> $this$ensureActive) {
        if ($this$ensureActive instanceof ThrowingCollector) {
            throw ((ThrowingCollector)$this$ensureActive).e;
        }
    }

    /*
     * Unable to fully structure code
     */
    private static final <T> Object invokeSafely$FlowKt__EmittersKt(FlowCollector<? super T> var0, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> var1_1, Throwable var2_2, Continuation<? super Unit> var3_3) {
        if (!(var3_3 instanceof invokeSafely.1)) ** GOTO lbl-1000
        var8_4 = var3_3;
        if ((var8_4.label & -2147483648) != 0) {
            var8_4.label -= -2147483648;
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
                    return FlowKt__EmittersKt.access$invokeSafely$FlowKt__EmittersKt(null, null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var9_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = cause;
                $continuation.label = 1;
                v0 = action.invoke($this$invokeSafely, (Object)cause, $continuation);
                ** if (v0 != var9_6) goto lbl19
lbl18:
                // 1 sources

                return var9_6;
lbl19:
                // 1 sources

                ** GOTO lbl33
            }
            case 1: {
                cause = (Throwable)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                }
                catch (Throwable e) {
                    if (cause != null && cause != e) {
                        $this$addSuppressedThrowable$iv = e;
                        $i$f$addSuppressedThrowable = false;
                        ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable$iv, (Throwable)cause);
                    }
                    throw e;
                }
lbl33:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static final /* synthetic */ Object access$invokeSafely$FlowKt__EmittersKt(FlowCollector $receiver, Function3 action, Throwable cause, Continuation $completion) {
        return FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt($receiver, action, cause, (Continuation<? super Unit>)$completion);
    }
}

