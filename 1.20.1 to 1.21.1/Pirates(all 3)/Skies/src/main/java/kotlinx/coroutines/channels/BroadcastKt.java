/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastChannelKt;
import kotlinx.coroutines.channels.BroadcastCoroutine;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.LazyBroadcastCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u00a0\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062-\b\u0002\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000e2/\b\u0001\u0010\u0015\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010\u00a2\u0006\u0002\b\u0014H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00192\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u00a2\u0006\u0004\b\u0017\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"E", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcast", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlinx/coroutines/CoroutineStart;)Lkotlinx/coroutines/channels/BroadcastChannel;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,202:1\n48#2,4:203\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n51#1:203,4\n*E\n"})
public final class BroadcastKt {
    @Deprecated(message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported", level=DeprecationLevel.WARNING)
    @ObsoleteCoroutinesApi
    @NotNull
    public static final <E> BroadcastChannel<E> broadcast(@NotNull ReceiveChannel<? extends E> $this$broadcast, int capacity, @NotNull CoroutineStart start) {
        boolean $i$f$CoroutineExceptionHandler = false;
        CoroutineExceptionHandler.Key key = CoroutineExceptionHandler.Key;
        CoroutineScope scope = CoroutineScopeKt.plus(CoroutineScopeKt.plus(GlobalScope.INSTANCE, (CoroutineContext)Dispatchers.getUnconfined()), (CoroutineContext)new CoroutineExceptionHandler(key){

            public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
                boolean bl = false;
            }
        });
        ReceiveChannel<? extends E> channel = $this$broadcast;
        return BroadcastKt.broadcast$default(scope, null, capacity, start, (Function1)new Function1<Throwable, Unit>($this$broadcast){
            final /* synthetic */ ReceiveChannel<E> $this_broadcast;
            {
                this.$this_broadcast = $receiver;
                super(1);
            }

            public final void invoke(@Nullable Throwable it) {
                ChannelsKt.cancelConsumed(this.$this_broadcast, it);
            }
        }, new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(channel, null){
            Object L$1;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $channel;
            {
                this.$channel = $channel;
                super(2, $completion);
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
                        $this$broadcast = (ProducerScope)this.L$0;
                        var3_4 = this.$channel.iterator();
lbl7:
                        // 2 sources

                        while (true) {
                            this.L$0 = $this$broadcast;
                            this.L$1 = var3_4;
                            this.label = 1;
                            v0 = var3_4.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var5_2) {
                                return var5_2;
                            }
                            ** GOTO lbl20
                            break;
                        }
                    }
                    case 1: {
                        var3_4 = (ChannelIterator<E>)this.L$1;
                        $this$broadcast = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl20:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) break;
                        e = var3_4.next();
                        this.L$0 = $this$broadcast;
                        this.L$1 = var3_4;
                        this.label = 2;
                        v1 = $this$broadcast.send(e, (Continuation<Unit>)((Continuation)this));
                        if (v1 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl34
                    }
                    case 2: {
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$broadcast = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl34:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super E> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 1, null);
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(ReceiveChannel receiveChannel, int n2, CoroutineStart coroutineStart, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = 1;
        }
        if ((n3 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return BroadcastKt.broadcast(receiveChannel, n2, coroutineStart);
    }

    @Deprecated(message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported", level=DeprecationLevel.WARNING)
    @ObsoleteCoroutinesApi
    @NotNull
    public static final <E> BroadcastChannel<E> broadcast(@NotNull CoroutineScope $this$broadcast, @NotNull CoroutineContext context, int capacity, @NotNull CoroutineStart start, @Nullable Function1<? super Throwable, Unit> onCompletion, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        BroadcastCoroutine coroutine;
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($this$broadcast, context);
        BroadcastChannel channel = BroadcastChannelKt.BroadcastChannel(capacity);
        BroadcastCoroutine broadcastCoroutine = coroutine = start.isLazy() ? (BroadcastCoroutine)new LazyBroadcastCoroutine(newContext, channel, block) : new BroadcastCoroutine(newContext, channel, true);
        if (onCompletion != null) {
            coroutine.invokeOnCompletion(onCompletion);
        }
        coroutine.start(start, coroutine, block);
        return coroutine;
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int n2, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n3 & 2) != 0) {
            n2 = 1;
        }
        if ((n3 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        if ((n3 & 8) != 0) {
            function1 = null;
        }
        return BroadcastKt.broadcast(coroutineScope, coroutineContext, n2, coroutineStart, (Function1<? super Throwable, Unit>)function1, function2);
    }
}

