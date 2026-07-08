/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.IndexedValue
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000@\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ap\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\t\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u0092\u0001\u0010\u0014\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0014\u0010\u000f\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u000e2\u0016\u0010\u0011\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u000e0\u001029\u0010\t\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u00a2\u0006\u0002\b\u0013H\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015*\u001c\b\u0002\u0010\u0017\"\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00162\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2={"T1", "T2", "R", "Lkotlinx/coroutines/flow/Flow;", "flow", "flow2", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "transform", "zipImpl", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "flows", "Lkotlin/Function0;", "arrayFactory", "", "Lkotlin/ExtensionFunctionType;", "combineInternal", "(Lkotlinx/coroutines/flow/FlowCollector;[Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/collections/IndexedValue;", "Update", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,143:1\n107#2:144\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n86#1:144\n*E\n"})
public final class CombineKt {
    @PublishedApi
    @Nullable
    public static final <R, T> Object combineInternal(@NotNull FlowCollector<? super R> $this$combineInternal, @NotNull Flow<? extends T>[] flows, @NotNull Function0<T[]> arrayFactory, @NotNull Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform2, @NotNull Continuation<? super Unit> $completion) {
        Object object = FlowCoroutineKt.flowScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(flows, arrayFactory, transform2, $this$combineInternal, null){
            Object L$1;
            Object L$2;
            int I$0;
            int I$1;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow<T>[] $flows;
            final /* synthetic */ Function0<T[]> $arrayFactory;
            final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
            final /* synthetic */ FlowCollector<R> $this_combineInternal;
            {
                this.$flows = $flows;
                this.$arrayFactory = $arrayFactory;
                this.$transform = $transform;
                this.$this_combineInternal = $receiver;
                super(2, $completion);
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
                        $this$flowScope = (CoroutineScope)this.L$0;
                        size = this.$flows.length;
                        if (size == 0) {
                            return Unit.INSTANCE;
                        }
                        latestValues = new Object[size];
                        ArraysKt.fill$default((Object[])latestValues, (Object)NullSurrogateKt.UNINITIALIZED, (int)0, (int)0, (int)6, null);
                        resultChannel = ChannelKt.Channel$default(size, null, null, 6, null);
                        nonClosed = new AtomicInteger(size);
                        remainingAbsentValues = size;
                        for (i = 0; i < size; ++i) {
                            BuildersKt.launch$default($this$flowScope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$flows, i, nonClosed, (Channel<IndexedValue<Object>>)resultChannel, null){
                                int label;
                                final /* synthetic */ Flow<T>[] $flows;
                                final /* synthetic */ int $i;
                                final /* synthetic */ AtomicInteger $nonClosed;
                                final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
                                {
                                    this.$flows = $flows;
                                    this.$i = $i;
                                    this.$nonClosed = $nonClosed;
                                    this.$resultChannel = $resultChannel;
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
                                            Object object3 = this.$flows[this.$i].collect(new FlowCollector(this.$resultChannel, this.$i){
                                                final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
                                                final /* synthetic */ int $i;
                                                {
                                                    this.$resultChannel = $resultChannel;
                                                    this.$i = $i;
                                                }

                                                /*
                                                 * Unable to fully structure code
                                                 */
                                                @Nullable
                                                public final Object emit(T var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                                    if (!(var2_2 instanceof combineInternal.emit.1)) ** GOTO lbl-1000
                                                    var4_3 = var2_2;
                                                    if ((var4_3.label & -2147483648) != 0) {
                                                        var4_3.label -= -2147483648;
                                                    } else lbl-1000:
                                                    // 2 sources

                                                    {
                                                        $continuation = new ContinuationImpl(this, var2_2){
                                                            /* synthetic */ Object result;
                                                            final /* synthetic */ combineInternal.1<T> this$0;
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
                                                            v0 = this.$resultChannel.send((IndexedValue<Object>)new IndexedValue(this.$i, (Object)value), (Continuation<Unit>)$continuation);
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

                                                            $continuation.label = 2;
                                                            v1 = YieldKt.yield((Continuation<? super Unit>)$continuation);
                                                            if (v1 == var5_5) {
                                                                return var5_5;
                                                            }
                                                            ** GOTO lbl28
                                                        }
                                                        case 2: {
                                                            ResultKt.throwOnFailure((Object)$result);
                                                            v1 = $result;
lbl28:
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
                                                if (this.$nonClosed.decrementAndGet() == 0) {
                                                    SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                                                }
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
                        }
                        lastReceivedEpoch = new byte[size];
                        currentEpoch = 0;
lbl21:
                        // 5 sources

                        while (true) {
                            currentEpoch = (byte)(currentEpoch + 1);
                            this.L$0 = latestValues;
                            this.L$1 = resultChannel;
                            this.L$2 = lastReceivedEpoch;
                            this.I$0 = remainingAbsentValues;
                            this.I$1 = currentEpoch;
                            this.label = 1;
                            v0 = resultChannel.receiveCatching-JP2dKIU((Continuation)this);
                            if (v0 == var13_2) {
                                return var13_2;
                            }
                            ** GOTO lbl41
                            break;
                        }
                    }
                    case 1: {
                        currentEpoch = this.I$1;
                        remainingAbsentValues = this.I$0;
                        lastReceivedEpoch = (byte[])this.L$2;
                        resultChannel = (Channel)this.L$1;
                        latestValues = (Object[])this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = ((ChannelResult)$result).unbox-impl();
lbl41:
                        // 2 sources

                        if ((IndexedValue)ChannelResult.getOrNull-impl(v0) == null) break;
                        while (true) {
                            index = element.getIndex();
                            previous = latestValues[index];
                            latestValues[index] = element.getValue();
                            if (previous == NullSurrogateKt.UNINITIALIZED) {
                                --remainingAbsentValues;
                            }
                            if (lastReceivedEpoch[index] == currentEpoch) break;
                            lastReceivedEpoch[index] = (byte)currentEpoch;
                            if ((IndexedValue)ChannelResult.getOrNull-impl(resultChannel.tryReceive-PtdJZtk()) == null) break;
                        }
                        if (remainingAbsentValues != 0) ** GOTO lbl21
                        results = (Object[])this.$arrayFactory.invoke();
                        if (results != null) break;
                        this.L$0 = latestValues;
                        this.L$1 = resultChannel;
                        this.L$2 = lastReceivedEpoch;
                        this.I$0 = remainingAbsentValues;
                        this.I$1 = currentEpoch;
                        this.label = 2;
                        v1 = this.$transform.invoke(this.$this_combineInternal, (Object)latestValues, (Object)this);
                        if (v1 != var13_2) ** GOTO lbl21
                        return var13_2;
                    }
                    case 2: {
                        currentEpoch = this.I$1;
                        remainingAbsentValues = this.I$0;
                        lastReceivedEpoch = (byte[])this.L$2;
                        resultChannel = (Channel)this.L$1;
                        latestValues = (Object[])this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
                        ** GOTO lbl21
                    }
                }
                ArraysKt.copyInto$default((Object[])latestValues, (Object[])results, (int)0, (int)0, (int)0, (int)14, null);
                this.L$0 = latestValues;
                this.L$1 = resultChannel;
                this.L$2 = lastReceivedEpoch;
                this.I$0 = remainingAbsentValues;
                this.I$1 = currentEpoch;
                this.label = 3;
                v2 = this.$transform.invoke(this.$this_combineInternal, (Object)results, (Object)this);
                if (v2 == var13_2) {
                    return var13_2;
                }
                ** GOTO lbl94
                {
                    case 3: {
                        currentEpoch = this.I$1;
                        remainingAbsentValues = this.I$0;
                        lastReceivedEpoch = (byte[])this.L$2;
                        resultChannel = (Channel)this.L$1;
                        latestValues = (Object[])this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl94:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
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

    @NotNull
    public static final <T1, T2, R> Flow<R> zipImpl(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform2) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>(flow2, flow, transform2){
            final /* synthetic */ Flow $flow2$inlined;
            final /* synthetic */ Flow $flow$inlined;
            final /* synthetic */ Function3 $transform$inlined;
            {
                this.$flow2$inlined = flow;
                this.$flow$inlined = flow2;
                this.$transform$inlined = function3;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super R> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super R> $this$zipImpl_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = CoroutineScopeKt.coroutineScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>($this$zipImpl_u24lambda_u240, this.$flow2$inlined, this.$flow$inlined, this.$transform$inlined, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                    final /* synthetic */ Flow<T2> $flow2;
                    final /* synthetic */ Flow<T1> $flow;
                    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$flow2 = $flow2;
                        this.$flow = $flow;
                        this.$transform = $transform;
                        super(2, $completion);
                    }

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object var1_1) {
                        var7_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)var1_1);
                                $this$coroutineScope = (CoroutineScope)this.L$0;
                                second = ProduceKt.produce$default($this$coroutineScope, null, 0, (Function2)new Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object>(this.$flow2, null){
                                    int label;
                                    private /* synthetic */ Object L$0;
                                    final /* synthetic */ Flow<T2> $flow2;
                                    {
                                        this.$flow2 = $flow2;
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
                                                Object object3 = this.$flow2.collect(new FlowCollector($this$produce){
                                                    final /* synthetic */ ProducerScope<Object> $$this$produce;
                                                    {
                                                        this.$$this$produce = $$this$produce;
                                                    }

                                                    /*
                                                     * Unable to fully structure code
                                                     */
                                                    @Nullable
                                                    public final Object emit(T2 var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                                        if (!(var2_2 instanceof zipImpl.1.second.emit.1)) ** GOTO lbl-1000
                                                        var4_3 = var2_2;
                                                        if ((var4_3.label & -2147483648) != 0) {
                                                            var4_3.label -= -2147483648;
                                                        } else lbl-1000:
                                                        // 2 sources

                                                        {
                                                            $continuation = new ContinuationImpl(this, var2_2){
                                                                /* synthetic */ Object result;
                                                                final /* synthetic */ zipImpl.1.second.1<T> this$0;
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
                                                                v0 = this.$$this$produce.getChannel();
                                                                v1 = value;
                                                                if (v1 == null) {
                                                                    v1 = NullSurrogateKt.NULL;
                                                                }
                                                                $continuation.label = 1;
                                                                v2 = v0.send(v1, (Continuation<Unit>)$continuation);
                                                                if (v2 == var5_5) {
                                                                    return var5_5;
                                                                }
                                                                ** GOTO lbl24
                                                            }
                                                            case 1: {
                                                                ResultKt.throwOnFailure((Object)$result);
                                                                v2 = $result;
lbl24:
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
                                collectJob = JobKt.Job$default(null, 1, null);
                                Intrinsics.checkNotNull((Object)second, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
                                ((SendChannel)second).invokeOnClose((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(collectJob, this.$this_unsafeFlow){
                                    final /* synthetic */ CompletableJob $collectJob;
                                    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                                    {
                                        this.$collectJob = $collectJob;
                                        this.$this_unsafeFlow = $receiver;
                                        super(1);
                                    }

                                    public final void invoke(@Nullable Throwable it) {
                                        if (this.$collectJob.isActive()) {
                                            this.$collectJob.cancel(new AbortFlowException(this.$this_unsafeFlow));
                                        }
                                    }
                                }));
                                scopeContext = $this$coroutineScope.getCoroutineContext();
                                cnt = ThreadContextKt.threadContextElements(scopeContext);
                                this.L$0 = second;
                                this.label = 1;
                                v0 = ChannelFlowKt.withContextUndispatched$default($this$coroutineScope.getCoroutineContext().plus((CoroutineContext)collectJob), Unit.INSTANCE, null, (Function2)new Function2<Unit, Continuation<? super Unit>, Object>(this.$flow, scopeContext, cnt, (ReceiveChannel<? extends Object>)second, this.$this_unsafeFlow, this.$transform, null){
                                    int label;
                                    final /* synthetic */ Flow<T1> $flow;
                                    final /* synthetic */ CoroutineContext $scopeContext;
                                    final /* synthetic */ Object $cnt;
                                    final /* synthetic */ ReceiveChannel<Object> $second;
                                    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                                    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                                    {
                                        this.$flow = $flow;
                                        this.$scopeContext = $scopeContext;
                                        this.$cnt = $cnt;
                                        this.$second = $second;
                                        this.$this_unsafeFlow = $receiver;
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
                                                this.label = 1;
                                                Object object3 = this.$flow.collect(new FlowCollector(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform){
                                                    final /* synthetic */ CoroutineContext $scopeContext;
                                                    final /* synthetic */ Object $cnt;
                                                    final /* synthetic */ ReceiveChannel<Object> $second;
                                                    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                                                    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                                                    {
                                                        this.$scopeContext = $scopeContext;
                                                        this.$cnt = $cnt;
                                                        this.$second = $second;
                                                        this.$this_unsafeFlow = $receiver;
                                                        this.$transform = $transform;
                                                    }

                                                    /*
                                                     * Unable to fully structure code
                                                     */
                                                    @Nullable
                                                    public final Object emit(T1 var1_1, @NotNull Continuation<? super Unit> var2_2) {
                                                        if (!(var2_2 instanceof zipImpl.1.emit.1)) ** GOTO lbl-1000
                                                        var4_3 = var2_2;
                                                        if ((var4_3.label & -2147483648) != 0) {
                                                            var4_3.label -= -2147483648;
                                                        } else lbl-1000:
                                                        // 2 sources

                                                        {
                                                            $continuation = new ContinuationImpl(this, var2_2){
                                                                /* synthetic */ Object result;
                                                                final /* synthetic */ zipImpl.1.1<T> this$0;
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
                                                                v0 = ChannelFlowKt.withContextUndispatched(this.$scopeContext, Unit.INSTANCE, this.$cnt, (Function2)new Function2<Unit, Continuation<? super Unit>, Object>(this.$second, this.$this_unsafeFlow, this.$transform, value, null){
                                                                    Object L$0;
                                                                    int label;
                                                                    final /* synthetic */ ReceiveChannel<Object> $second;
                                                                    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                                                                    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                                                                    final /* synthetic */ T1 $value;
                                                                    {
                                                                        this.$second = $second;
                                                                        this.$this_unsafeFlow = $receiver;
                                                                        this.$transform = $transform;
                                                                        this.$value = $value;
                                                                        super(2, $completion);
                                                                    }

                                                                    /*
                                                                     * Unable to fully structure code
                                                                     */
                                                                    @Nullable
                                                                    public final Object invokeSuspend(@NotNull Object var1_1) {
                                                                        var9_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                        switch (this.label) {
                                                                            case 0: {
                                                                                ResultKt.throwOnFailure((Object)var1_1);
                                                                                this.label = 1;
                                                                                v0 = this.$second.receiveCatching-JP2dKIU((Continuation<ChannelResult<Object>>)((Continuation)this));
                                                                                if (v0 == var9_2) {
                                                                                    return var9_2;
                                                                                }
                                                                                ** GOTO lbl13
                                                                            }
                                                                            case 1: {
                                                                                ResultKt.throwOnFailure((Object)$result);
                                                                                v0 = ((ChannelResult)$result).unbox-impl();
lbl13:
                                                                                // 2 sources

                                                                                var3_3 = v0;
                                                                                var4_4 = this.$this_unsafeFlow;
                                                                                $i$f$getOrElse-WpGqRn0 = false;
                                                                                if ($this$getOrElse_u2dWpGqRn0$iv instanceof ChannelResult.Failed) {
                                                                                    it = ChannelResult.exceptionOrNull-impl($this$getOrElse_u2dWpGqRn0$iv);
                                                                                    $i$a$-getOrElse-WpGqRn0-CombineKt$zipImpl$1$1$2$1$1$otherValue$1 = false;
                                                                                    v1 = it;
                                                                                    if (v1 == null) {
                                                                                        v1 = new AbortFlowException(var4_4);
                                                                                    }
                                                                                    throw v1;
                                                                                }
                                                                                otherValue = $this$getOrElse_u2dWpGqRn0$iv;
                                                                                var8_10 = this.$this_unsafeFlow;
                                                                                this_$iv = NullSurrogateKt.NULL;
                                                                                $i$f$unbox = false;
                                                                                this.L$0 = var8_10;
                                                                                this.label = 2;
                                                                                v2 = this.$transform.invoke(this.$value, otherValue == this_$iv ? null : var2_9, (Object)this);
                                                                                if (v2 == var9_2) {
                                                                                    return var9_2;
                                                                                }
                                                                                ** GOTO lbl38
                                                                            }
                                                                            case 2: {
                                                                                var8_10 = (FlowCollector<R>)this.L$0;
                                                                                ResultKt.throwOnFailure((Object)$result);
                                                                                v2 = $result;
lbl38:
                                                                                // 2 sources

                                                                                this.L$0 = null;
                                                                                this.label = 3;
                                                                                v3 = var8_10.emit(v2, (Continuation<Unit>)((Continuation)this));
                                                                                if (v3 == var9_2) {
                                                                                    return var9_2;
                                                                                }
                                                                                ** GOTO lbl47
                                                                            }
                                                                            case 3: {
                                                                                ResultKt.throwOnFailure((Object)$result);
                                                                                v3 = $result;
lbl47:
                                                                                // 2 sources

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
                                                                }, $continuation);
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
                                        return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                    }

                                    @Nullable
                                    public final Object invoke(@NotNull Unit p1, @Nullable Continuation<? super Unit> p2) {
                                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }, (Continuation)this, 4, null);
                                ** if (v0 != var7_2) goto lbl19
lbl18:
                                // 1 sources

                                return var7_2;
lbl19:
                                // 1 sources

                                ** GOTO lbl26
                            }
                            case 1: {
                                second = (ReceiveChannel)this.L$0;
                                try {
                                    ResultKt.throwOnFailure((Object)$result);
                                    v0 = $result;
                                }
                                catch (AbortFlowException e) {
                                    FlowExceptions_commonKt.checkOwnership(e, this.$this_unsafeFlow);
                                    ** GOTO lbl37
                                }
lbl26:
                                // 2 sources

                                ReceiveChannel.DefaultImpls.cancel$default(second, null, 1, null);
                                ** GOTO lbl37
                            }
                            {
                                finally {
                                    ReceiveChannel.DefaultImpls.cancel$default(second, null, 1, null);
                                }
                            }
lbl37:
                            // 2 sources

                            return Unit.INSTANCE;
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
        };
    }
}

