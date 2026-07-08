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
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.ChannelAsFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ChannelsKt;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a9\u0010\u0011\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2={"T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "(Lkotlinx/coroutines/channels/BroadcastChannel;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "consumeAsFlow", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "", "emitAll", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "consume", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "Lkotlinx/coroutines/CoroutineScope;", "scope", "produceIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "receiveAsFlow", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,176:1\n107#2:177\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n153#1:177\n*E\n"})
final class FlowKt__ChannelsKt {
    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> $this$emitAll, @NotNull ReceiveChannel<? extends T> channel, @NotNull Continuation<? super Unit> $completion) {
        Object object = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt($this$emitAll, channel, true, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> var0, ReceiveChannel<? extends T> var1_1, boolean var2_2, Continuation<? super Unit> var3_3) {
        if (!(var3_3 instanceof emitAllImpl.1)) ** GOTO lbl-1000
        var8_4 = var3_3;
        if ((var8_4.label & -2147483648) != 0) {
            var8_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var3_3){
                Object L$0;
                Object L$1;
                Object L$2;
                boolean Z$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt(null, null, false, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var9_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                FlowKt.ensureActive($this$emitAllImpl);
                cause = null;
                try {
                    var5_8 = channel.iterator();
                }
                catch (Throwable e) {
                    try {
                        cause = e;
                        throw e;
                    }
                    catch (Throwable var5_10) {
                        if (consume == false) throw var5_10;
                        ChannelsKt.cancelConsumed(channel, cause);
                        throw var5_10;
                    }
                }
lbl26:
                // 3 sources

                while (true) {
                    $continuation.L$0 = $this$emitAllImpl;
                    $continuation.L$1 = channel;
                    $continuation.L$2 = var5_8;
                    $continuation.Z$0 = consume;
                    $continuation.label = 1;
                    v0 = var5_8.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var9_6) {
                        return var9_6;
                    }
                    ** GOTO lbl45
                    break;
                }
            }
            case 1: {
                consume = $continuation.Z$0;
                var5_8 = (ChannelIterator<E>)$continuation.L$2;
                cause = null;
                channel = (ReceiveChannel)$continuation.L$1;
                $this$emitAllImpl = (FlowCollector)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl45:
                    // 2 sources

                    if (!((Boolean)v0).booleanValue()) break;
                    element = var5_8.next();
                    $continuation.L$0 = $this$emitAllImpl;
                    $continuation.L$1 = channel;
                    $continuation.L$2 = var5_8;
                    $continuation.Z$0 = consume;
                    $continuation.label = 2;
                    v1 = $this$emitAllImpl.emit(element, (Continuation<? super Unit>)$continuation);
                    if (v1 != var9_6) ** GOTO lbl26
                }
                return var9_6;
            }
            case 2: {
                consume = $continuation.Z$0;
                var5_8 = (ChannelIterator)$continuation.L$2;
                cause = null;
                channel = (ReceiveChannel)$continuation.L$1;
                $this$emitAllImpl = (FlowCollector)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
                    ** continue;
                }
            }
        }
        if (consume == false) return Unit.INSTANCE;
        ChannelsKt.cancelConsumed(channel, cause);
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public static final <T> Flow<T> receiveAsFlow(@NotNull ReceiveChannel<? extends T> $this$receiveAsFlow) {
        return new ChannelAsFlow($this$receiveAsFlow, false, null, 0, null, 28, null);
    }

    @NotNull
    public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> $this$consumeAsFlow) {
        return new ChannelAsFlow($this$consumeAsFlow, true, null, 0, null, 28, null);
    }

    @Deprecated(message="'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow", level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull BroadcastChannel<T> $this$asFlow) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$asFlow){
            final /* synthetic */ BroadcastChannel $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = broadcastChannel;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super T> $this$asFlow_u24lambda_u240 = collector2;
                boolean bl = false;
                Object object = FlowKt.emitAll($this$asFlow_u24lambda_u240, this.$this_asFlow$inlined.openSubscription(), $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> $this$produceIn, @NotNull CoroutineScope scope) {
        return ChannelFlowKt.asChannelFlow($this$produceIn).produceImpl(scope);
    }

    public static final /* synthetic */ Object access$emitAllImpl$FlowKt__ChannelsKt(FlowCollector $receiver, ReceiveChannel channel, boolean consume, Continuation $completion) {
        return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt($receiver, channel, consume, (Continuation<? super Unit>)$completion);
    }
}

