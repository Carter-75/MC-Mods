/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__CollectKt;
import kotlinx.coroutines.flow.internal.NopCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001aX\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000023\b\u0004\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005H\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\f\u001am\u0010\u0010\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002H\b\u0004\u0010\u000b\u001aB\b\u0001\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\rH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001aV\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\f\u001a1\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u001a\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2={"Lkotlinx/coroutines/flow/Flow;", "", "collect", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "action", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "", "index", "collectIndexed", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectLatest", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "emitAll", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Job;", "launchIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CollectKt {
    @Nullable
    public static final Object collect(@NotNull Flow<?> $this$collect, @NotNull Continuation<? super Unit> $completion) {
        Object object = $this$collect.collect(NopCollector.INSTANCE, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public static final <T> Job launchIn(@NotNull Flow<? extends T> $this$launchIn, @NotNull CoroutineScope scope) {
        return BuildersKt.launch$default(scope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>($this$launchIn, null){
            int label;
            final /* synthetic */ Flow<T> $this_launchIn;
            {
                this.$this_launchIn = $receiver;
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
                        this.label = 1;
                        Object object3 = FlowKt.collect(this.$this_launchIn, (Continuation<? super Unit>)((Continuation)this));
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
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 3, null);
    }

    @Nullable
    public static final <T> Object collectIndexed(@NotNull Flow<? extends T> $this$collectIndexed, @NotNull Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> action, @NotNull Continuation<? super Unit> $completion) {
        boolean $i$f$collectIndexed = false;
        Object object = $this$collectIndexed.collect(new FlowCollector<T>(action){
            private int index;
            final /* synthetic */ Function3<Integer, T, Continuation<? super Unit>, Object> $action;
            {
                this.$action = $action;
            }

            /*
             * WARNING - void declaration
             */
            @Nullable
            public Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
                void index$iv;
                int n2 = this.index;
                this.index = n2 + 1;
                boolean $i$f$checkIndexOverflow = false;
                if (index$iv < 0) {
                    throw new ArithmeticException("Index overflow has happened");
                }
                Object object = this.$action.invoke((Object)Boxing.boxInt((int)n2), value, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            @Nullable
            public Object emit$$forInline(T value, @NotNull Continuation<? super Unit> $completion) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, $completion){
                    /* synthetic */ Object result;
                    final /* synthetic */ collectIndexed.2<T> this$0;
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
                InlineMarker.mark((int)5);
                int n2 = this.index;
                this.index = n2 + 1;
                int index$iv = n2;
                boolean $i$f$checkIndexOverflow = false;
                if (index$iv < 0) {
                    throw new ArithmeticException("Index overflow has happened");
                }
                this.$action.invoke((Object)index$iv, value, $completion);
                return Unit.INSTANCE;
            }
        }, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private static final <T> Object collectIndexed$$forInline(Flow<? extends T> $this$collectIndexed, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        boolean $i$f$collectIndexed = false;
        FlowCollector flowCollector = new /* invalid duplicate definition of identical inner class */;
        InlineMarker.mark((int)0);
        $this$collectIndexed.collect(flowCollector, $completion);
        InlineMarker.mark((int)1);
        return Unit.INSTANCE;
    }

    @Nullable
    public static final <T> Object collectLatest(@NotNull Flow<? extends T> $this$collectLatest, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, @NotNull Continuation<? super Unit> $completion) {
        Object object = FlowKt.collect(FlowKt.buffer$default(FlowKt.mapLatest($this$collectLatest, action), 0, null, 2, null), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> $this$emitAll, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super Unit> $completion) {
        FlowKt.ensureActive($this$emitAll);
        Object object = flow.collect($this$emitAll, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(message="Backwards compatibility with JS and K/N", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ <T> Object collect(Flow<? extends T> $this$collect, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        boolean $i$f$collect = false;
        Object object = $this$collect.collect(new FlowCollector<T>(action){
            final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $action;
            {
                this.$action = $action;
            }

            @Nullable
            public Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
                Object object = this.$action.invoke(value, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            @Nullable
            public Object emit$$forInline(T value, @NotNull Continuation<? super Unit> $completion) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, $completion){
                    /* synthetic */ Object result;
                    final /* synthetic */ collect.3<T> this$0;
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
                InlineMarker.mark((int)5);
                this.$action.invoke(value, $completion);
                return Unit.INSTANCE;
            }
        }, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(message="Backwards compatibility with JS and K/N", level=DeprecationLevel.HIDDEN)
    private static final /* synthetic */ <T> Object collect$$forInline(Flow<? extends T> $this$collect, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        boolean $i$f$collect = false;
        FlowCollector flowCollector = new /* invalid duplicate definition of identical inner class */;
        InlineMarker.mark((int)0);
        $this$collect.collect(flowCollector, $completion);
        InlineMarker.mark((int)1);
        return Unit.INSTANCE;
    }
}

