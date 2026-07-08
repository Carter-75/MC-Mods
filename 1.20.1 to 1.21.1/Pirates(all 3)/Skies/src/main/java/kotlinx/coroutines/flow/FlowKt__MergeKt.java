/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$;
import kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000P\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a9\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001ag\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u000227\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001aj\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u000229\b\u0005\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000f\u001aq\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u001127\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001ac\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u000223\b\u0001\u0010\r\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u000f\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u001a\u00a2\u0006\u0004\b\u0004\u0010\u001b\u001at\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0001\u0010\r\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001c\u00a2\u0006\u0002\b\u001fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\" \u0010\"\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%\"\u001a\u0010)\u001a\u00020(8\u0006X\u0087T\u00a2\u0006\f\n\u0004\b)\u0010*\u0012\u0004\b+\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2={"T", "", "Lkotlinx/coroutines/flow/Flow;", "flows", "merge", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "R", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "transform", "flatMapConcat", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatMapLatest", "", "concurrency", "flatMapMerge", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "flattenMerge", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "mapLatest", "", "(Ljava/lang/Iterable;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "transformLatest", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "DEFAULT_CONCURRENCY", "I", "getDEFAULT_CONCURRENCY", "()I", "getDEFAULT_CONCURRENCY$annotations", "()V", "", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "Ljava/lang/String;", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n53#2:219\n55#2:223\n53#2:224\n55#2:228\n50#3:220\n55#3:222\n50#3:225\n55#3:227\n107#4:221\n107#4:226\n107#4:229\n1#5:230\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n47#1:219\n47#1:223\n74#1:224\n74#1:228\n47#1:220\n47#1:222\n74#1:225\n74#1:227\n47#1:221\n74#1:226\n82#1:229\n*E\n"})
final class FlowKt__MergeKt {
    private static final int DEFAULT_CONCURRENCY = SystemPropsKt.systemProp("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    @FlowPreview
    public static /* synthetic */ void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return DEFAULT_CONCURRENCY;
    }

    @FlowPreview
    public static /* synthetic */ void getDEFAULT_CONCURRENCY$annotations() {
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapConcat(@NotNull Flow<? extends T> $this$flatMapConcat, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform2) {
        Flow<? extends T> $this$map$iv = $this$flatMapConcat;
        boolean $i$f$map = false;
        Flow<? extends T> $this$unsafeTransform$iv$iv = $this$map$iv;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return FlowKt.flattenConcat(new Flow<Flow<? extends R>>($this$unsafeTransform$iv$iv, transform2){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ Function2 $transform$inlined$1;
            {
                this.$this_unsafeTransform$inlined = flow;
                this.$transform$inlined$1 = function2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$transform$inlined$1){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ Function2 $transform$inlined;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$transform$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(Object var1_1, @NotNull Continuation var2_2) {
                        if (!(var2_2 instanceof flatMapConcat$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                int label;
                                Object L$0;
                                final /* synthetic */ flatMapConcat$$inlined$map$1$2 this$0;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                @Nullable
                                public final Object invokeSuspend(@NotNull Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit((Object)null, (Continuation)this);
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = value;
                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = false;
                                var9_11 = $this$map_u24lambda_u245;
                                $continuation.L$0 = var9_11;
                                $continuation.label = 1;
                                v0 = this.$transform$inlined.invoke((Object)value, (Object)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl27
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = false;
                                var9_11 = (FlowCollector)$continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl27:
                                // 2 sources

                                $continuation.L$0 = null;
                                $continuation.label = 2;
                                v1 = var9_11.emit(v0, (Continuation<Unit>)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl37
                            }
                            case 2: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl37:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (Continuation<Unit>)$completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapMerge(@NotNull Flow<? extends T> $this$flatMapMerge, int concurrency, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform2) {
        Flow<? extends T> $this$map$iv = $this$flatMapMerge;
        boolean $i$f$map = false;
        Flow<? extends T> $this$unsafeTransform$iv$iv = $this$map$iv;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return FlowKt.flattenMerge(new Flow<Flow<? extends R>>($this$unsafeTransform$iv$iv, transform2){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ Function2 $transform$inlined$1;
            {
                this.$this_unsafeTransform$inlined = flow;
                this.$transform$inlined$1 = function2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$transform$inlined$1){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ Function2 $transform$inlined;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$transform$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(Object var1_1, @NotNull Continuation var2_2) {
                        if (!(var2_2 instanceof flatMapMerge$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                int label;
                                Object L$0;
                                final /* synthetic */ flatMapMerge$$inlined$map$1$2 this$0;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                @Nullable
                                public final Object invokeSuspend(@NotNull Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit((Object)null, (Continuation)this);
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = value;
                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = false;
                                var9_11 = $this$map_u24lambda_u245;
                                $continuation.L$0 = var9_11;
                                $continuation.label = 1;
                                v0 = this.$transform$inlined.invoke((Object)value, (Object)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl27
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = false;
                                var9_11 = (FlowCollector)$continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl27:
                                // 2 sources

                                $continuation.L$0 = null;
                                $continuation.label = 2;
                                v1 = var9_11.emit(v0, (Continuation<Unit>)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl37
                            }
                            case 2: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl37:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (Continuation<Unit>)$completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        }, concurrency);
    }

    public static /* synthetic */ Flow flatMapMerge$default(Flow flow, int n2, Function2 function2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flatMapMerge(flow, n2, function2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> flattenConcat(@NotNull Flow<? extends Flow<? extends T>> $this$flattenConcat) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$flattenConcat){
            final /* synthetic */ Flow $this_flattenConcat$inlined;
            {
                this.$this_flattenConcat$inlined = flow;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super T> $this$flattenConcat_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = this.$this_flattenConcat$inlined.collect(new FlowCollector($this$flattenConcat_u24lambda_u240){
                    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = $receiver;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(@NotNull Flow<? extends T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof flattenConcat.1.emit.1)) ** GOTO lbl-1000
                        var4_3 = var2_2;
                        if ((var4_3.label & -2147483648) != 0) {
                            var4_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                final /* synthetic */ flattenConcat.1.1<T> this$0;
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
                                v0 = FlowKt.emitAll(this.$this_unsafeFlow, value, (Continuation<? super Unit>)$continuation);
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
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> merge(@NotNull Iterable<? extends Flow<? extends T>> $this$merge) {
        return new ChannelLimitedFlowMerge($this$merge, null, 0, null, 14, null);
    }

    @NotNull
    public static final <T> Flow<T> merge(Flow<? extends T> ... flows) {
        return FlowKt.merge(ArraysKt.asIterable((Object[])flows));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> flattenMerge(@NotNull Flow<? extends Flow<? extends T>> $this$flattenMerge, int concurrency) {
        if (!(concurrency > 0)) {
            boolean bl = false;
            String string = "Expected positive concurrency level, but had " + concurrency;
            throw new IllegalArgumentException(string.toString());
        }
        return concurrency == 1 ? FlowKt.flattenConcat($this$flattenMerge) : (Flow)new ChannelFlowMerge($this$flattenMerge, concurrency, null, 0, null, 28, null);
    }

    public static /* synthetic */ Flow flattenMerge$default(Flow flow, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flattenMerge(flow, n2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> transformLatest(@NotNull Flow<? extends T> $this$transformLatest, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return new ChannelFlowTransformLatest(transform2, $this$transformLatest, null, 0, null, 28, null);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapLatest(@NotNull Flow<? extends T> $this$flatMapLatest, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform2) {
        boolean $i$f$flatMapLatest = false;
        return FlowKt.transformLatest($this$flatMapLatest, (Function3)new Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object>(transform2, null){
            int label;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            final /* synthetic */ Function2<T, Continuation<? super Flow<? extends R>>, Object> $transform;
            {
                this.$transform = $transform;
                super(3, $completion);
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
                        $this$transformLatest = (FlowCollector)this.L$0;
                        it = this.L$1;
                        var4_5 = $this$transformLatest;
                        this.L$0 = var4_5;
                        this.label = 1;
                        v0 = this.$transform.invoke(it, (Object)this);
                        if (v0 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl18
                    }
                    case 1: {
                        var4_5 = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl18:
                        // 2 sources

                        this.L$0 = null;
                        this.label = 2;
                        v1 = FlowKt.emitAll(var4_5, (Flow)v0, (Continuation<? super Unit>)((Continuation)this));
                        if (v1 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl27
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl27:
                        // 2 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                FlowCollector $this$transformLatest = (FlowCollector)this.L$0;
                Object it = this.L$1;
                FlowCollector flowCollector = $this$transformLatest;
                Object object = this.$transform.invoke(it, (Object)((Object)this));
                Flow flow = (Flow)object;
                Continuation continuation = (Continuation)this;
                InlineMarker.mark((int)0);
                FlowKt.emitAll(flowCollector, flow, (Continuation<? super Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, T p2, @Nullable Continuation<? super Unit> p3) {
                Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                function3.L$0 = p1;
                function3.L$1 = p2;
                return function3.invokeSuspend((Object)Unit.INSTANCE);
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> mapLatest(@NotNull Flow<? extends T> $this$mapLatest, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt.transformLatest($this$mapLatest, (Function3)new Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object>(transform2, null){
            int label;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            final /* synthetic */ Function2<T, Continuation<? super R>, Object> $transform;
            {
                this.$transform = $transform;
                super(3, $completion);
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
                        $this$transformLatest = (FlowCollector)this.L$0;
                        it = this.L$1;
                        var4_5 = $this$transformLatest;
                        this.L$0 = var4_5;
                        this.label = 1;
                        v0 = this.$transform.invoke(it, (Object)this);
                        if (v0 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl18
                    }
                    case 1: {
                        var4_5 = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl18:
                        // 2 sources

                        this.L$0 = null;
                        this.label = 2;
                        v1 = var4_5.emit(v0, (Continuation<Unit>)((Continuation)this));
                        if (v1 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl27
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl27:
                        // 2 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, T p2, @Nullable Continuation<? super Unit> p3) {
                Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                function3.L$0 = p1;
                function3.L$1 = p2;
                return function3.invokeSuspend((Object)Unit.INSTANCE);
            }
        });
    }
}

