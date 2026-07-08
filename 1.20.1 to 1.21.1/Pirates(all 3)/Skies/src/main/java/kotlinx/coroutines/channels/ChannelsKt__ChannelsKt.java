/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2={"E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "", "sendBlocking", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/ChannelResult;", "trySendBlocking", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/channels/ChannelsKt")
@SourceDebugExtension(value={"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,61:1\n514#2,6:62\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n*L\n37#1:62,6\n*E\n"})
final class ChannelsKt__ChannelsKt {
    @NotNull
    public static final <E> Object trySendBlocking(@NotNull SendChannel<? super E> $this$trySendBlocking, E element) {
        Object $this$onSuccess_u2dWpGqRn0$iv = $this$trySendBlocking.trySend-JP2dKIU(element);
        boolean bl = false;
        if (!($this$onSuccess_u2dWpGqRn0$iv instanceof ChannelResult.Failed)) {
            Unit it = (Unit)$this$onSuccess_u2dWpGqRn0$iv;
            boolean bl2 = false;
            return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
        }
        return ((ChannelResult)BuildersKt.runBlocking$default(null, (Function2)new Function2<CoroutineScope, Continuation<? super ChannelResult<? extends Unit>>, Object>($this$trySendBlocking, element, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ SendChannel<E> $this_trySendBlocking;
            final /* synthetic */ E $element;
            {
                this.$this_trySendBlocking = $receiver;
                this.$element = $element;
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
                        var4_4 = $this$runBlocking = (CoroutineScope)this.L$0;
                        var5_5 = this.$this_trySendBlocking;
                        var6_6 = this.$element;
                        $i$a$-runCatching-ChannelsKt__ChannelsKt$trySendBlocking$2$r$1 = false;
                        this.label = 1;
                        v0 = var5_5.send(var6_6, (Continuation<Unit>)this);
                        ** if (v0 != var9_2) goto lbl16
lbl15:
                        // 1 sources

                        return var9_2;
lbl16:
                        // 1 sources

                        ** GOTO lbl23
                    }
                    case 1: {
                        $i$a$-runCatching-ChannelsKt__ChannelsKt$trySendBlocking$2$r$1 = false;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl23:
                            // 2 sources

                            var7_10 = Result.constructor-impl((Object)Unit.INSTANCE);
                        }
                        catch (Throwable var8_9) {
                            var7_10 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var8_9));
                        }
                        r = var7_10;
                        return ChannelResult.box-impl(Result.isSuccess-impl((Object)r) != false ? ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE) : ChannelResult.Companion.closed-JP2dKIU(Result.exceptionOrNull-impl((Object)r)));
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<CoroutineScope, Continuation<? super ChannelResult<? extends Unit>>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super ChannelResult<Unit>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 1, null)).unbox-impl();
    }

    @Deprecated(message="Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith=@ReplaceWith(expression="trySendBlocking(element)", imports={}), level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void sendBlocking(SendChannel $this$sendBlocking, Object element) {
        if (ChannelResult.isSuccess-impl($this$sendBlocking.trySend-JP2dKIU(element))) {
            return;
        }
        BuildersKt.runBlocking$default(null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>($this$sendBlocking, element, null){
            int label;
            final /* synthetic */ SendChannel<E> $this_sendBlocking;
            final /* synthetic */ E $element;
            {
                this.$this_sendBlocking = $receiver;
                this.$element = $element;
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
                        Object object3 = this.$this_sendBlocking.send(this.$element, (Continuation<Unit>)((Continuation)this));
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
    }
}

