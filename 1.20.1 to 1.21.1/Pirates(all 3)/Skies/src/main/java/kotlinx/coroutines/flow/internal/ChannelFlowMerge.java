/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.SendingCollector;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BA\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u0019\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014\u00a2\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u0007\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "", "additionalToStringProps", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "create", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "concurrency", "I", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"})
public final class ChannelFlowMerge<T>
extends ChannelFlow<T> {
    @NotNull
    private final Flow<Flow<T>> flow;
    private final int concurrency;

    public ChannelFlowMerge(@NotNull Flow<? extends Flow<? extends T>> flow, int concurrency, @NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        super(context, capacity, onBufferOverflow);
        this.flow = flow;
        this.concurrency = concurrency;
    }

    public /* synthetic */ ChannelFlowMerge(Flow flow, int n2, CoroutineContext coroutineContext, int n3, BufferOverflow bufferOverflow, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 4) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n4 & 8) != 0) {
            n3 = -2;
        }
        if ((n4 & 0x10) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        this(flow, n2, coroutineContext, n3, bufferOverflow);
    }

    @Override
    @NotNull
    protected ChannelFlow<T> create(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return new ChannelFlowMerge<T>(this.flow, this.concurrency, context, capacity, onBufferOverflow);
    }

    @Override
    @NotNull
    public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope scope) {
        return ProduceKt.produce(scope, this.context, this.capacity, this.getCollectToFun$kotlinx_coroutines_core());
    }

    @Override
    @Nullable
    protected Object collectTo(@NotNull ProducerScope<? super T> scope, @NotNull Continuation<? super Unit> $completion) {
        Semaphore semaphore = SemaphoreKt.Semaphore$default(this.concurrency, 0, 2, null);
        SendingCollector collector2 = new SendingCollector((SendChannel)scope);
        Job job = (Job)$completion.getContext().get((CoroutineContext.Key)Job.Key);
        Object object = this.flow.collect(new FlowCollector(job, semaphore, scope, collector2){
            final /* synthetic */ Job $job;
            final /* synthetic */ Semaphore $semaphore;
            final /* synthetic */ ProducerScope<T> $scope;
            final /* synthetic */ SendingCollector<T> $collector;
            {
                this.$job = $job;
                this.$semaphore = $semaphore;
                this.$scope = $scope;
                this.$collector = $collector;
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object emit(@NotNull Flow<? extends T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
                if (!(var2_2 instanceof collectTo.emit.1)) ** GOTO lbl-1000
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
                        final /* synthetic */ collectTo.2<T> this$0;
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
                        v0 = this.$job;
                        if (v0 != null) {
                            JobKt.ensureActive(v0);
                        }
                        $continuation.L$0 = this;
                        $continuation.L$1 = inner;
                        $continuation.label = 1;
                        v1 = this.$semaphore.acquire((Continuation<? super Unit>)$continuation);
                        if (v1 == var5_5) {
                            return var5_5;
                        }
                        ** GOTO lbl27
                    }
                    case 1: {
                        inner = (Flow)$continuation.L$1;
                        this = $continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl27:
                        // 2 sources

                        BuildersKt.launch$default(this.$scope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(inner, this.$collector, this.$semaphore, null){
                            int label;
                            final /* synthetic */ Flow<T> $inner;
                            final /* synthetic */ SendingCollector<T> $collector;
                            final /* synthetic */ Semaphore $semaphore;
                            {
                                this.$inner = $inner;
                                this.$collector = $collector;
                                this.$semaphore = $semaphore;
                                super(2, $completion);
                            }

                            /*
                             * WARNING - Removed try catching itself - possible behaviour change.
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
                                        Object object3 = this.$inner.collect(this.$collector, (Continuation<Unit>)((Continuation)this));
                                        if (object3 != object2) return Unit.INSTANCE;
                                        return object2;
                                    }
                                    case 1: {
                                        Object object3;
                                        try {
                                            void $result;
                                            ResultKt.throwOnFailure((Object)$result);
                                            object3 = $result;
                                            return Unit.INSTANCE;
                                        }
                                        catch (Throwable throwable) {
                                            throw throwable;
                                        }
                                        finally {
                                            this.$semaphore.release();
                                        }
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

    @Override
    @NotNull
    protected String additionalToStringProps() {
        return "concurrency=" + this.concurrency;
    }
}

