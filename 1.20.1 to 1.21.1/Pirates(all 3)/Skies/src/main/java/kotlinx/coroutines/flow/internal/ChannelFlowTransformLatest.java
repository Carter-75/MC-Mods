/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperator;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003Bz\u0012B\u0010\u0019\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012\u00a2\u0006\u0002\b\u0018\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011RS\u0010\u0019\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0012\u00a2\u0006\u0002\b\u00188\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", "T", "R", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "create", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "flowCollect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "transform", "Lkotlin/jvm/functions/Function3;", "Lkotlinx/coroutines/flow/Flow;", "flow", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
public final class ChannelFlowTransformLatest<T, R>
extends ChannelFlowOperator<T, R> {
    @NotNull
    private final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> transform;

    public ChannelFlowTransformLatest(@NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform2, @NotNull Flow<? extends T> flow, @NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        super(flow, context, capacity, onBufferOverflow);
        this.transform = transform2;
    }

    public /* synthetic */ ChannelFlowTransformLatest(Function3 function3, Flow flow, CoroutineContext coroutineContext, int n2, BufferOverflow bufferOverflow, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 4) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n3 & 8) != 0) {
            n2 = -2;
        }
        if ((n3 & 0x10) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        this(function3, flow, coroutineContext, n2, bufferOverflow);
    }

    @Override
    @NotNull
    protected ChannelFlow<R> create(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return new ChannelFlowTransformLatest<T, R>(this.transform, this.flow, context, capacity, onBufferOverflow);
    }

    @Override
    @Nullable
    protected Object flowCollect(@NotNull FlowCollector<? super R> collector2, @NotNull Continuation<? super Unit> $completion) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(collector2 instanceof SendingCollector)) {
                throw new AssertionError();
            }
        }
        Object object = CoroutineScopeKt.coroutineScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, collector2, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;
            final /* synthetic */ FlowCollector<R> $collector;
            {
                this.this$0 = $receiver;
                this.$collector = $collector;
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
                        CoroutineScope $this$coroutineScope = (CoroutineScope)this.L$0;
                        Ref.ObjectRef previousFlow = new Ref.ObjectRef();
                        this.label = 1;
                        Object object3 = this.this$0.flow.collect(new FlowCollector((Ref.ObjectRef<Job>)previousFlow, $this$coroutineScope, this.this$0, this.$collector){
                            final /* synthetic */ Ref.ObjectRef<Job> $previousFlow;
                            final /* synthetic */ CoroutineScope $$this$coroutineScope;
                            final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;
                            final /* synthetic */ FlowCollector<R> $collector;
                            {
                                this.$previousFlow = $previousFlow;
                                this.$$this$coroutineScope = $$this$coroutineScope;
                                this.this$0 = $receiver;
                                this.$collector = $collector;
                            }

                            /*
                             * Unable to fully structure code
                             */
                            @Nullable
                            public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                if (!(var2_2 instanceof flowCollect.emit.1)) ** GOTO lbl-1000
                                var7_3 = var2_2;
                                if ((var7_3.label & -2147483648) != 0) {
                                    var7_3.label -= -2147483648;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    $continuation = new ContinuationImpl(this, var2_2){
                                        Object L$0;
                                        Object L$1;
                                        Object L$2;
                                        /* synthetic */ Object result;
                                        final /* synthetic */ flowCollect.1<T> this$0;
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
                                var8_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = (Job)this.$previousFlow.element;
                                        if (v0 == null) break;
                                        $this$emit_u24lambda_u240 = var3_6 = v0;
                                        $i$a$-apply-ChannelFlowTransformLatest$flowCollect$3$1$1 = false;
                                        $this$emit_u24lambda_u240.cancel(new ChildCancelledException());
                                        $continuation.L$0 = this;
                                        $continuation.L$1 = value;
                                        $continuation.L$2 = var3_6;
                                        $continuation.label = 1;
                                        v1 = $this$emit_u24lambda_u240.join((Continuation<? super Unit>)$continuation);
                                        if (v1 == var8_5) {
                                            return var8_5;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        $i$a$-apply-ChannelFlowTransformLatest$flowCollect$3$1$1 = false;
                                        var3_7 = (Job)$continuation.L$2;
                                        value = $continuation.L$1;
                                        this = $continuation.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v1 = $result;
                                        break;
                                    }
                                }
                                this.$previousFlow.element = BuildersKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.this$0, this.$collector, value, null){
                                    int label;
                                    final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;
                                    final /* synthetic */ FlowCollector<R> $collector;
                                    final /* synthetic */ T $value;
                                    {
                                        this.this$0 = $receiver;
                                        this.$collector = $collector;
                                        this.$value = $value;
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
                                                Object object3 = ChannelFlowTransformLatest.access$getTransform$p(this.this$0).invoke(this.$collector, this.$value, (Object)((Object)this));
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
                                }, 1, null);
                                return Unit.INSTANCE;
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
                Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Function3 access$getTransform$p(ChannelFlowTransformLatest $this) {
        return $this.transform;
    }
}

