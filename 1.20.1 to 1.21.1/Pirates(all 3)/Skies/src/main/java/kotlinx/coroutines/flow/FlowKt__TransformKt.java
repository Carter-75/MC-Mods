/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.IndexedValue
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 */
package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filter$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$map$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012$\b\u0004\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\t\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u00a2\u0006\u0004\b\n\u0010\u000b\u001a3\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\t*\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u00a2\u0006\u0004\b\n\u0010\u000e\u001aO\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012$\b\u0004\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\b\u001a)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u0005*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001\u00a2\u0006\u0004\b\u0010\u0010\u000b\u001ad\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\u000123\b\u0004\u0010\u0014\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\b\u001aj\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\t*\u00020\u0005*\b\u0012\u0004\u0012\u00028\u00000\u000125\b\u0004\u0010\u0014\u001a/\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\b\u001aJ\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\b\u001a~\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001a\u001a\u00028\u00012H\b\u0001\u0010\u001d\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001an\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012F\u0010\u001d\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001b\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001a~\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001a\u001a\u00028\u00012H\b\u0001\u0010\u001d\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010\u001f\u001a)\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\u0004\b$\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2={"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "filter", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "R", "filterIsInstance", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/reflect/KClass;", "klass", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/reflect/KClass;)Lkotlinx/coroutines/flow/Flow;", "filterNot", "filterNotNull", "Lkotlin/ParameterName;", "name", "value", "transform", "map", "mapNotNull", "", "action", "onEach", "initial", "Lkotlin/Function3;", "accumulator", "operation", "runningFold", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "runningReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "scan", "Lkotlin/collections/IndexedValue;", "withIndex", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,136:1\n21#1:143\n23#1:147\n21#1:148\n23#1:152\n50#2:137\n55#2:139\n50#2:140\n55#2:142\n50#2:144\n55#2:146\n50#2:149\n55#2:151\n50#2:153\n55#2:155\n50#2:156\n55#2:158\n50#2:159\n55#2:161\n50#2:163\n55#2:165\n107#3:138\n107#3:141\n107#3:145\n107#3:150\n107#3:154\n107#3:157\n107#3:160\n107#3:162\n107#3:164\n107#3:166\n107#3:167\n*S KotlinDebug\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n36#1:143\n36#1:147\n41#1:148\n41#1:152\n21#1:137\n21#1:139\n28#1:140\n28#1:142\n36#1:144\n36#1:146\n41#1:149\n41#1:151\n46#1:153\n46#1:155\n53#1:156\n53#1:158\n60#1:159\n60#1:161\n78#1:163\n78#1:165\n21#1:138\n28#1:141\n36#1:145\n41#1:150\n46#1:154\n53#1:157\n60#1:160\n68#1:162\n78#1:164\n105#1:166\n125#1:167\n*E\n"})
final class FlowKt__TransformKt {
    @NotNull
    public static final <T> Flow<T> filter(@NotNull Flow<? extends T> $this$filter, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        boolean $i$f$filter = false;
        Flow<? extends T> $this$unsafeTransform$iv = $this$filter;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$unsafeTransform$iv, predicate){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ Function2 $predicate$inlined;
            {
                this.$this_unsafeTransform$inlined = flow;
                this.$predicate$inlined = function2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$predicate$inlined){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ Function2 $predicate$inlined;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$predicate$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof filter$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                int label;
                                final /* synthetic */ filter$$inlined$unsafeTransform$1$2 this$0;
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
                                    return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                (Continuation)$continuation;
                                var6_6 = value;
                                $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filter$1 = false;
                                $continuation.L$0 = value;
                                $continuation.L$1 = $this$filter_u24lambda_u240;
                                $continuation.label = 1;
                                v0 = this.$predicate$inlined.invoke(value, (Object)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl30
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filter$1 = false;
                                $this$filter_u24lambda_u240 = (FlowCollector)$continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl30:
                                // 2 sources

                                if (!((Boolean)v0).booleanValue()) break;
                                $continuation.L$0 = null;
                                $continuation.L$1 = null;
                                $continuation.label = 2;
                                v1 = $this$filter_u24lambda_u240.emit(value, (Continuation<Unit>)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                break;
                            }
                            case 2: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filter$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
                                break;
                            }
                        }
                        return Unit.INSTANCE;
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    /*
                     * WARNING - void declaration
                     */
                    @Nullable
                    public final Object emit$$forInline(Object value, @NotNull Continuation $completion) {
                        block0: {
                            void value2;
                            InlineMarker.mark((int)4);
                            new /* invalid duplicate definition of identical inner class */;
                            InlineMarker.mark((int)5);
                            Continuation continuation = $completion;
                            Object object = value;
                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                            boolean bl = false;
                            if (!((Boolean)this.$predicate$inlined.invoke((Object)value2, (Object)$completion)).booleanValue()) break block0;
                            InlineMarker.mark((int)0);
                            $this$filter_u24lambda_u240.emit(value2, (Continuation<Unit>)$completion);
                            InlineMarker.mark((int)1);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$completion);
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
                    final /* synthetic */ filter$$inlined$unsafeTransform$1 this$0;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
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
    public static final <T> Flow<T> filterNot(@NotNull Flow<? extends T> $this$filterNot, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        boolean $i$f$filterNot = false;
        Flow<? extends T> $this$unsafeTransform$iv = $this$filterNot;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$unsafeTransform$iv, predicate){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ Function2 $predicate$inlined;
            {
                this.$this_unsafeTransform$inlined = flow;
                this.$predicate$inlined = function2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$predicate$inlined){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ Function2 $predicate$inlined;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$predicate$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof filterNot$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                int label;
                                final /* synthetic */ filterNot$$inlined$unsafeTransform$1$2 this$0;
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
                                    return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                (Continuation)$continuation;
                                var6_6 = value;
                                $this$filterNot_u24lambda_u241 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filterNot$1 = false;
                                $continuation.L$0 = value;
                                $continuation.L$1 = $this$filterNot_u24lambda_u241;
                                $continuation.label = 1;
                                v0 = this.$predicate$inlined.invoke(value, (Object)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl30
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filterNot$1 = false;
                                $this$filterNot_u24lambda_u241 = (FlowCollector)$continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl30:
                                // 2 sources

                                if (((Boolean)v0).booleanValue()) break;
                                $continuation.L$0 = null;
                                $continuation.L$1 = null;
                                $continuation.label = 2;
                                v1 = $this$filterNot_u24lambda_u241.emit(value, (Continuation<Unit>)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                break;
                            }
                            case 2: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filterNot$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
                                break;
                            }
                        }
                        return Unit.INSTANCE;
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    /*
                     * WARNING - void declaration
                     */
                    @Nullable
                    public final Object emit$$forInline(Object value, @NotNull Continuation $completion) {
                        block0: {
                            void value2;
                            InlineMarker.mark((int)4);
                            new /* invalid duplicate definition of identical inner class */;
                            InlineMarker.mark((int)5);
                            Continuation continuation = $completion;
                            Object object = value;
                            FlowCollector $this$filterNot_u24lambda_u241 = this.$this_unsafeFlow;
                            boolean bl = false;
                            if (((Boolean)this.$predicate$inlined.invoke((Object)value2, (Object)$completion)).booleanValue()) break block0;
                            InlineMarker.mark((int)0);
                            $this$filterNot_u24lambda_u241.emit(value2, (Continuation<Unit>)$completion);
                            InlineMarker.mark((int)1);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$completion);
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
                    final /* synthetic */ filterNot$$inlined$unsafeTransform$1 this$0;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
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

    public static final /* synthetic */ <R> Flow<R> filterIsInstance(Flow<?> $this$filterIsInstance) {
        boolean $i$f$filterIsInstance = false;
        Flow<?> $this$filter$iv = $this$filterIsInstance;
        boolean $i$f$filter = false;
        Flow<?> $this$unsafeTransform$iv$iv = $this$filter$iv;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        Intrinsics.needClassReification();
        return new Flow<Object>($this$unsafeTransform$iv$iv){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Intrinsics.needClassReification();
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = $receiver;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(Object var1_1, @NotNull Continuation var2_2) {
                        if (!(var2_2 instanceof filterIsInstance$$inlined$filter$1$2$1)) ** GOTO lbl-1000
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
                                Object L$1;
                                final /* synthetic */ filterIsInstance$$inlined$filter$1$2 this$0;
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
                                $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filter$1 = false;
                                (Continuation)$continuation;
                                it = value;
                                $i$a$-filter-FlowKt__TransformKt$filterIsInstance$1 = false;
                                Intrinsics.reifiedOperationMarker((int)3, (String)"R");
                                if (!(it instanceof Object)) break;
                                $continuation.label = 1;
                                v0 = $this$filter_u24lambda_u240.emit(value, (Continuation<Unit>)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                break;
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filter$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
                                break;
                            }
                        }
                        return Unit.INSTANCE;
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    /*
                     * WARNING - void declaration
                     */
                    @Nullable
                    public final Object emit$$forInline(Object value, @NotNull Continuation $completion) {
                        block0: {
                            void value2;
                            InlineMarker.mark((int)4);
                            new /* invalid duplicate definition of identical inner class */;
                            InlineMarker.mark((int)5);
                            Continuation continuation = $completion;
                            Object object = value;
                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                            boolean bl = false;
                            Continuation continuation2 = $completion;
                            void it = value2;
                            boolean bl2 = false;
                            Intrinsics.reifiedOperationMarker((int)3, (String)"R");
                            if (!(it instanceof Object)) break block0;
                            InlineMarker.mark((int)0);
                            $this$filter_u24lambda_u240.emit(value2, (Continuation<Unit>)$completion);
                            InlineMarker.mark((int)1);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$completion);
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
                    final /* synthetic */ filterIsInstance$$inlined$filter$1 this$0;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
                    }
                };
                InlineMarker.mark((int)5);
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Intrinsics.needClassReification();
                FlowCollector flowCollector = new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                this.$this_unsafeTransform$inlined.collect(flowCollector, (Continuation<Unit>)$completion);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <R> Flow<R> filterIsInstance(@NotNull Flow<?> $this$filterIsInstance, @NotNull KClass<R> klass) {
        Flow<?> $this$filter$iv = $this$filterIsInstance;
        boolean $i$f$filter = false;
        Flow<?> $this$unsafeTransform$iv$iv = $this$filter$iv;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<Object>($this$unsafeTransform$iv$iv, klass){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ KClass $klass$inlined;
            {
                this.$this_unsafeTransform$inlined = flow;
                this.$klass$inlined = kClass;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$klass$inlined){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ KClass $klass$inlined;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$klass$inlined = kClass;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(Object var1_1, @NotNull Continuation var2_2) {
                        if (!(var2_2 instanceof filterIsInstance$$inlined$filter$2$2$1)) ** GOTO lbl-1000
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
                                Object L$1;
                                final /* synthetic */ filterIsInstance$$inlined$filter$2$2 this$0;
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
                                $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filter$1 = false;
                                (Continuation)$continuation;
                                it = value;
                                $i$a$-filter-FlowKt__TransformKt$filterIsInstance$2 = false;
                                if (!this.$klass$inlined.isInstance((Object)it)) break;
                                $continuation.label = 1;
                                v0 = $this$filter_u24lambda_u240.emit(value, (Continuation<Unit>)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                break;
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filter$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
                                break;
                            }
                        }
                        return Unit.INSTANCE;
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (Continuation<Unit>)$completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> filterNotNull(@NotNull Flow<? extends T> $this$filterNotNull) {
        Flow<? extends T> $this$unsafeTransform$iv = $this$filterNotNull;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$unsafeTransform$iv){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = $receiver;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof filterNotNull$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                int label;
                                final /* synthetic */ filterNotNull$$inlined$unsafeTransform$1$2 this$0;
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
                                (Continuation)$continuation;
                                var6_6 = value;
                                $this$filterNotNull_u24lambda_u244 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filterNotNull$1 = false;
                                v0 = value;
                                if (v0 == null) break;
                                $continuation.label = 1;
                                v1 = $this$filterNotNull_u24lambda_u244.emit(v0, (Continuation<Unit>)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                break;
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$filterNotNull$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
                                break;
                            }
                        }
                        return Unit.INSTANCE;
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (Continuation<Unit>)$completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T, R> Flow<R> map(@NotNull Flow<? extends T> $this$map, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform2) {
        boolean $i$f$map = false;
        Flow<? extends T> $this$unsafeTransform$iv = $this$map;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>($this$unsafeTransform$iv, transform2){
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
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof map$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                int label;
                                final /* synthetic */ map$$inlined$unsafeTransform$1$2 this$0;
                                Object L$0;
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
                                (Continuation)$continuation;
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
                                ** GOTO lbl29
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = false;
                                var9_11 = (FlowCollector)$continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl29:
                                // 2 sources

                                $continuation.L$0 = null;
                                $continuation.label = 2;
                                v1 = var9_11.emit(v0, (Continuation<Unit>)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl39
                            }
                            case 2: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl39:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    /*
                     * WARNING - void declaration
                     */
                    @Nullable
                    public final Object emit$$forInline(Object value, @NotNull Continuation $completion) {
                        void value2;
                        InlineMarker.mark((int)4);
                        new /* invalid duplicate definition of identical inner class */;
                        InlineMarker.mark((int)5);
                        Continuation continuation = $completion;
                        Object object = value;
                        FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                        boolean bl = false;
                        FlowCollector flowCollector = $this$map_u24lambda_u245;
                        Object object2 = this.$transform$inlined.invoke((Object)value2, (Object)$completion);
                        InlineMarker.mark((int)0);
                        flowCollector.emit(object2, (Continuation<Unit>)$completion);
                        InlineMarker.mark((int)1);
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$completion);
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
                    final /* synthetic */ map$$inlined$unsafeTransform$1 this$0;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
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
    public static final <T, R> Flow<R> mapNotNull(@NotNull Flow<? extends T> $this$mapNotNull, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform2) {
        boolean $i$f$mapNotNull = false;
        Flow<? extends T> $this$unsafeTransform$iv = $this$mapNotNull;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>($this$unsafeTransform$iv, transform2){
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
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof mapNotNull$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                int label;
                                final /* synthetic */ mapNotNull$$inlined$unsafeTransform$1$2 this$0;
                                Object L$0;
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
                                (Continuation)$continuation;
                                var6_6 = value;
                                $this$mapNotNull_u24lambda_u246 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1 = false;
                                $continuation.L$0 = $this$mapNotNull_u24lambda_u246;
                                $continuation.label = 1;
                                v0 = this.$transform$inlined.invoke((Object)value, (Object)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl28
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1 = false;
                                $this$mapNotNull_u24lambda_u246 = (FlowCollector)$continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl28:
                                // 2 sources

                                if (v0 != null) {
                                    transformed = v0;
                                    $continuation.L$0 = null;
                                    $continuation.label = 2;
                                    v1 = $this$mapNotNull_u24lambda_u246.emit(transformed, (Continuation<Unit>)$continuation);
                                    if (v1 == var5_5) {
                                        return var5_5;
                                    }
                                }
                                ** GOTO lbl40
                            }
                            case 2: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl40:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    /*
                     * WARNING - void declaration
                     */
                    @Nullable
                    public final Object emit$$forInline(Object value, @NotNull Continuation $completion) {
                        void value2;
                        InlineMarker.mark((int)4);
                        new /* invalid duplicate definition of identical inner class */;
                        InlineMarker.mark((int)5);
                        Continuation continuation = $completion;
                        Object object = value;
                        FlowCollector $this$mapNotNull_u24lambda_u246 = this.$this_unsafeFlow;
                        boolean bl = false;
                        Object object2 = this.$transform$inlined.invoke((Object)value2, (Object)$completion);
                        if (object2 != null) {
                            Object transformed = object2;
                            InlineMarker.mark((int)0);
                            $this$mapNotNull_u24lambda_u246.emit(transformed, (Continuation<Unit>)$completion);
                            InlineMarker.mark((int)1);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<Unit>)$completion);
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
                    final /* synthetic */ mapNotNull$$inlined$unsafeTransform$1 this$0;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect((FlowCollector)null, (Continuation)this);
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
    public static final <T> Flow<IndexedValue<T>> withIndex(@NotNull Flow<? extends T> $this$withIndex) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<IndexedValue<? extends T>>($this$withIndex){
            final /* synthetic */ Flow $this_withIndex$inlined;
            {
                this.$this_withIndex$inlined = flow;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super IndexedValue<? extends T>> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super IndexedValue<? extends T>> $this$withIndex_u24lambda_u247 = collector2;
                boolean bl = false;
                Ref.IntRef index = new Ref.IntRef();
                Object object = this.$this_withIndex$inlined.collect(new FlowCollector($this$withIndex_u24lambda_u247, index){
                    final /* synthetic */ FlowCollector<IndexedValue<? extends T>> $this_unsafeFlow;
                    final /* synthetic */ Ref.IntRef $index;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$index = $index;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof withIndex.1.emit.1)) ** GOTO lbl-1000
                        var6_3 = var2_2;
                        if ((var6_3.label & -2147483648) != 0) {
                            var6_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                final /* synthetic */ withIndex.1.1<T> this$0;
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
                        var7_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var3_6 = this.$index.element;
                                this.$index.element = var3_6 + 1;
                                $i$f$checkIndexOverflow = false;
                                if (index$iv < 0) {
                                    throw new ArithmeticException("Index overflow has happened");
                                }
                                $continuation.label = 1;
                                v0 = this.$this_unsafeFlow.emit(new IndexedValue(var3_6, (Object)value), (Continuation<Unit>)$continuation);
                                if (v0 == var7_5) {
                                    return var7_5;
                                }
                                ** GOTO lbl25
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl25:
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
    public static final <T> Flow<T> onEach(@NotNull Flow<? extends T> $this$onEach, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        Flow<? extends T> $this$unsafeTransform$iv = $this$onEach;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$unsafeTransform$iv, action){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ Function2 $action$inlined;
            {
                this.$this_unsafeTransform$inlined = flow;
                this.$action$inlined = function2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$action$inlined){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ Function2 $action$inlined;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$action$inlined = function2;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof onEach$$inlined$unsafeTransform$1$2$1)) ** GOTO lbl-1000
                        var3_3 = var2_2;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                /* synthetic */ Object result;
                                int label;
                                final /* synthetic */ onEach$$inlined$unsafeTransform$1$2 this$0;
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
                                    return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = (Continuation)$continuation;
                                var7_7 = value;
                                $this$onEach_u24lambda_u248 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$onEach$1 = false;
                                $continuation.L$0 = value;
                                $continuation.L$1 = $this$onEach_u24lambda_u248;
                                $continuation.label = 1;
                                InlineMarker.mark((int)6);
                                v0 = this.$action$inlined.invoke(value, (Object)$continuation);
                                InlineMarker.mark((int)7);
                                v1 = v0;
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl32
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$onEach$1 = false;
                                $this$onEach_u24lambda_u248 = (FlowCollector)$continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl32:
                                // 2 sources

                                $continuation.L$0 = null;
                                $continuation.L$1 = null;
                                $continuation.label = 2;
                                v2 = $this$onEach_u24lambda_u248.emit(value, (Continuation<Unit>)$continuation);
                                if (v2 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl43
                            }
                            case 2: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$onEach$1 = false;
                                ResultKt.throwOnFailure((Object)$result);
                                v2 = $result;
lbl43:
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
        };
    }

    @NotNull
    public static final <T, R> Flow<R> scan(@NotNull Flow<? extends T> $this$scan, R initial, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        return FlowKt.runningFold($this$scan, initial, operation);
    }

    @NotNull
    public static final <T, R> Flow<R> runningFold(@NotNull Flow<? extends T> $this$runningFold, R initial, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>(initial, $this$runningFold, operation){
            final /* synthetic */ Object $initial$inlined;
            final /* synthetic */ Flow $this_runningFold$inlined;
            final /* synthetic */ Function3 $operation$inlined;
            {
                this.$initial$inlined = object;
                this.$this_runningFold$inlined = flow;
                this.$operation$inlined = function3;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public Object collect(@NotNull FlowCollector<? super R> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof runningFold$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                var3_3 = var2_2;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, var2_2){
                        /* synthetic */ Object result;
                        int label;
                        final /* synthetic */ runningFold$$inlined$unsafeFlow$1 this$0;
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
                        (Continuation)$continuation;
                        $this$runningFold_u24lambda_u249 = collector;
                        $i$a$-unsafeFlow-FlowKt__TransformKt$runningFold$1 = false;
                        accumulator = new Ref.ObjectRef();
                        accumulator.element = this.$initial$inlined;
                        $continuation.L$0 = this;
                        $continuation.L$1 = $this$runningFold_u24lambda_u249;
                        $continuation.L$2 = accumulator;
                        $continuation.label = 1;
                        v0 = $this$runningFold_u24lambda_u249.emit(accumulator.element, (Continuation<Unit>)$continuation);
                        if (v0 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl33
                    }
                    case 1: {
                        $i$a$-unsafeFlow-FlowKt__TransformKt$runningFold$1 = false;
                        accumulator = (Ref.ObjectRef)$continuation.L$2;
                        $this$runningFold_u24lambda_u249 = (FlowCollector)$continuation.L$1;
                        this = $continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl33:
                        // 2 sources

                        $continuation.L$0 = null;
                        $continuation.L$1 = null;
                        $continuation.L$2 = null;
                        $continuation.label = 2;
                        v1 = this.$this_runningFold$inlined.collect(new FlowCollector(accumulator, this.$operation$inlined, $this$runningFold_u24lambda_u249){
                            final /* synthetic */ Ref.ObjectRef<R> $accumulator;
                            final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;
                            final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                            {
                                this.$accumulator = $accumulator;
                                this.$operation = $operation;
                                this.$this_unsafeFlow = $receiver;
                            }

                            /*
                             * Unable to fully structure code
                             */
                            @Nullable
                            public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                if (!(var2_2 instanceof runningFold.1.emit.1)) ** GOTO lbl-1000
                                var5_3 = var2_2;
                                if ((var5_3.label & -2147483648) != 0) {
                                    var5_3.label -= -2147483648;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    $continuation = new ContinuationImpl(this, var2_2){
                                        Object L$0;
                                        Object L$1;
                                        /* synthetic */ Object result;
                                        final /* synthetic */ runningFold.1.1<T> this$0;
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
                                        var3_6 = this.$accumulator;
                                        $continuation.L$0 = this;
                                        $continuation.L$1 = var3_6;
                                        $continuation.label = 1;
                                        v0 = this.$operation.invoke(this.$accumulator.element, (Object)value, (Object)$continuation);
                                        if (v0 == var6_5) {
                                            return var6_5;
                                        }
                                        ** GOTO lbl25
                                    }
                                    case 1: {
                                        var3_6 = (Ref.ObjectRef<R>)$continuation.L$1;
                                        this = $continuation.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = $result;
lbl25:
                                        // 2 sources

                                        var3_6.element = v0;
                                        $continuation.L$0 = null;
                                        $continuation.L$1 = null;
                                        $continuation.label = 2;
                                        v1 = this.$this_unsafeFlow.emit(this.$accumulator.element, (Continuation<Unit>)$continuation);
                                        if (v1 == var6_5) {
                                            return var6_5;
                                        }
                                        ** GOTO lbl36
                                    }
                                    case 2: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        v1 = $result;
lbl36:
                                        // 2 sources

                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (Continuation<Unit>)$continuation);
                        if (v1 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl45
                    }
                    case 2: {
                        $i$a$-unsafeFlow-FlowKt__TransformKt$runningFold$1 = false;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl45:
                        // 2 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> runningReduce(@NotNull Flow<? extends T> $this$runningReduce, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$runningReduce, operation){
            final /* synthetic */ Flow $this_runningReduce$inlined;
            final /* synthetic */ Function3 $operation$inlined;
            {
                this.$this_runningReduce$inlined = flow;
                this.$operation$inlined = function3;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super T> $this$runningReduce_u24lambda_u2410 = collector2;
                boolean bl = false;
                Ref.ObjectRef accumulator = new Ref.ObjectRef();
                accumulator.element = NullSurrogateKt.NULL;
                Object object = this.$this_runningReduce$inlined.collect(new FlowCollector((Ref.ObjectRef<Object>)accumulator, this.$operation$inlined, $this$runningReduce_u24lambda_u2410){
                    final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
                    final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
                    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;
                    {
                        this.$accumulator = $accumulator;
                        this.$operation = $operation;
                        this.$this_unsafeFlow = $receiver;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                        if (!(var2_2 instanceof runningReduce.1.emit.1)) ** GOTO lbl-1000
                        var5_3 = var2_2;
                        if ((var5_3.label & -2147483648) != 0) {
                            var5_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, var2_2){
                                Object L$0;
                                Object L$1;
                                /* synthetic */ Object result;
                                final /* synthetic */ runningReduce.1.1<T> this$0;
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
                                if (this.$accumulator.element != NullSurrogateKt.NULL) ** GOTO lbl16
                                v1 = value;
                                ** GOTO lbl31
lbl16:
                                // 1 sources

                                var3_6 = v0;
                                $continuation.L$0 = this;
                                $continuation.L$1 = var3_6;
                                $continuation.label = 1;
                                v2 = this.$operation.invoke(this.$accumulator.element, (Object)value, (Object)$continuation);
                                if (v2 == var6_5) {
                                    return var6_5;
                                }
                                ** GOTO lbl29
                            }
                            case 1: {
                                var3_6 = (Ref.ObjectRef<Object>)$continuation.L$1;
                                this = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v2 = $result;
lbl29:
                                // 2 sources

                                v1 = v2;
                                v0 = var3_6;
lbl31:
                                // 2 sources

                                v0.element = v1;
                                $continuation.L$0 = null;
                                $continuation.L$1 = null;
                                $continuation.label = 2;
                                v3 = this.$this_unsafeFlow.emit(this.$accumulator.element, (Continuation<Unit>)$continuation);
                                if (v3 == var6_5) {
                                    return var6_5;
                                }
                                ** GOTO lbl42
                            }
                            case 2: {
                                ResultKt.throwOnFailure((Object)$result);
                                v3 = $result;
lbl42:
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
}

