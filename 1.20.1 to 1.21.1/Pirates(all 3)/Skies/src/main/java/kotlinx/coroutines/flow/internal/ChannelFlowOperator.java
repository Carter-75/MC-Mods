/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0004X\u0085\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "newContext", "collectWithContextUndispatched", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowCollect", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"})
public abstract class ChannelFlowOperator<S, T>
extends ChannelFlow<T> {
    @JvmField
    @NotNull
    protected final Flow<S> flow;

    public ChannelFlowOperator(@NotNull Flow<? extends S> flow, @NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        super(context, capacity, onBufferOverflow);
        this.flow = flow;
    }

    @Nullable
    protected abstract Object flowCollect(@NotNull FlowCollector<? super T> var1, @NotNull Continuation<? super Unit> var2);

    private final Object collectWithContextUndispatched(FlowCollector<? super T> collector2, CoroutineContext newContext, Continuation<? super Unit> $completion) {
        FlowCollector originalContextCollector = ChannelFlowKt.access$withUndispatchedContextCollector(collector2, $completion.getContext());
        Object object = ChannelFlowKt.withContextUndispatched$default(newContext, originalContextCollector, null, new Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object>(this, null){
            int label;
            /* synthetic */ Object L$0;
            final /* synthetic */ ChannelFlowOperator<S, T> this$0;
            {
                this.this$0 = $receiver;
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
                        FlowCollector it = (FlowCollector)this.L$0;
                        this.label = 1;
                        Object object3 = this.this$0.flowCollect(it, (Continuation<Unit>)((Continuation)this));
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
                Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super T> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, $completion, 4, null);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    protected Object collectTo(@NotNull ProducerScope<? super T> scope, @NotNull Continuation<? super Unit> $completion) {
        return ChannelFlowOperator.collectTo$suspendImpl(this, scope, $completion);
    }

    static /* synthetic */ <S, T> Object collectTo$suspendImpl(ChannelFlowOperator<S, T> $this, ProducerScope<? super T> scope, Continuation<? super Unit> $completion) {
        Object object = $this.flowCollect(new SendingCollector((SendChannel)scope), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
        return ChannelFlowOperator.collect$suspendImpl(this, collector2, $completion);
    }

    static /* synthetic */ <S, T> Object collect$suspendImpl(ChannelFlowOperator<S, T> $this, FlowCollector<? super T> collector2, Continuation<? super Unit> $completion) {
        if ($this.capacity == -3) {
            CoroutineContext collectContext = $completion.getContext();
            CoroutineContext newContext = CoroutineContextKt.newCoroutineContext(collectContext, $this.context);
            if (Intrinsics.areEqual((Object)newContext, (Object)collectContext)) {
                Object object = $this.flowCollect(collector2, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual((Object)newContext.get((CoroutineContext.Key)ContinuationInterceptor.Key), (Object)collectContext.get((CoroutineContext.Key)ContinuationInterceptor.Key))) {
                Object object = super.collectWithContextUndispatched(collector2, newContext, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        }
        Object object = super.collect(collector2, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @NotNull
    public String toString() {
        return this.flow + " -> " + super.toString();
    }

    public static final /* synthetic */ Object access$collectWithContextUndispatched(ChannelFlowOperator $this, FlowCollector collector2, CoroutineContext newContext, Continuation $completion) {
        return $this.collectWithContextUndispatched(collector2, newContext, (Continuation<Unit>)$completion);
    }
}

