/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.ReplaceWith
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001aE\u0010\f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00028\u00010\t\u00a2\u0006\u0002\b\nH\u0087\b\u00a2\u0006\u0004\b\f\u0010\r\u001aR\u0010\f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00002\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00028\u00010\t\u00a2\u0006\u0002\b\nH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\f\u0010\u000e\u001a7\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\tH\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\tH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0012\u001a+\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014\"\b\b\u0000\u0010\u0006*\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a)\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0018\"\u0014\u0010\u001c\u001a\u00020\u001b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2={"Lkotlinx/coroutines/channels/ReceiveChannel;", "", "cause", "", "cancelConsumed", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Throwable;)V", "E", "R", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "consume", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "action", "consumeEach", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/selects/SelectClause1;", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toList", "", "DEFAULT_CLOSE_MESSAGE", "Ljava/lang/String;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/channels/ChannelsKt")
@SourceDebugExtension(value={"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,141:1\n82#1,11:142\n105#1:153\n82#1,6:154\n106#1,2:160\n92#1:162\n88#1,3:163\n33#1,5:166\n*S KotlinDebug\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n105#1:142,11\n116#1:153\n116#1:154,6\n116#1:160,2\n116#1:162\n116#1:163,3\n129#1:166,5\n*E\n"})
final class ChannelsKt__Channels_commonKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Deprecated(message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported", level=DeprecationLevel.WARNING)
    @ObsoleteCoroutinesApi
    public static final <E, R> R consume(@NotNull BroadcastChannel<E> $this$consume, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> block) {
        boolean $i$f$consume = false;
        ReceiveChannel<E> channel = $this$consume.openSubscription();
        try {
            Object object = block.invoke(channel);
            return (R)object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            ReceiveChannel.DefaultImpls.cancel$default(channel, null, 1, null);
            InlineMarker.finallyEnd((int)1);
        }
    }

    @Deprecated(message="Deprecated in the favour of 'receiveCatching'", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}), level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel $this$receiveOrNull, Continuation $completion) {
        Intrinsics.checkNotNull((Object)$this$receiveOrNull, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return $this$receiveOrNull.receiveOrNull($completion);
    }

    @Deprecated(message="Deprecated in the favour of 'onReceiveCatching'", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ SelectClause1 onReceiveOrNull(ReceiveChannel $this$onReceiveOrNull) {
        Intrinsics.checkNotNull((Object)$this$onReceiveOrNull, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return $this$onReceiveOrNull.getOnReceiveOrNull();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <E, R> R consume(@NotNull ReceiveChannel<? extends E> $this$consume, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> block) {
        boolean $i$f$consume = false;
        Throwable cause = null;
        try {
            Object object = block.invoke($this$consume);
            return (R)object;
        }
        catch (Throwable e2) {
            cause = e2;
            throw e2;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            ChannelsKt.cancelConsumed($this$consume, cause);
            InlineMarker.finallyEnd((int)1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Nullable
    public static final <E> Object consumeEach(@NotNull ReceiveChannel<? extends E> var0, @NotNull Function1<? super E, Unit> var1_1, @NotNull Continuation<? super Unit> var2_2) {
        if (!(var2_2 instanceof consumeEach.1)) ** GOTO lbl-1000
        var12_3 = var2_2;
        if ((var12_3.label & -2147483648) != 0) {
            var12_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt__Channels_commonKt.consumeEach(null, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var13_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$consumeEach = false;
                $this$consume$iv = $this$consumeEach;
                $i$f$consume = false;
                cause$iv = null;
                try {
                    $this$consumeEach_u24lambda_u241 = $this$consume$iv;
                    $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2 = false;
                    var9_14 = $this$consumeEach_u24lambda_u241.iterator();
                }
                catch (Throwable e$iv) {
                    try {
                        cause$iv = e$iv;
                        throw e$iv;
                    }
                    catch (Throwable var7_12) {
                        InlineMarker.finallyStart((int)1);
                        ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                        InlineMarker.finallyEnd((int)1);
                        throw var7_12;
                    }
                }
lbl32:
                // 2 sources

                while (true) {
                    $continuation.L$0 = action;
                    $continuation.L$1 = $this$consume$iv;
                    $continuation.L$2 = var9_14;
                    $continuation.label = 1;
                    v0 = var9_14.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var13_5) {
                        return var13_5;
                    }
                    ** GOTO lbl52
                    break;
                }
            }
            case 1: {
                $i$f$consumeEach = false;
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2 = false;
                var9_14 = (ChannelIterator<E>)$continuation.L$2;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$1;
                action = (Function1)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl52:
                    // 2 sources

                    if (((Boolean)v0).booleanValue()) {
                        e = var9_14.next();
                        action.invoke(e);
                        ** continue;
                    }
                    $this$consumeEach_u24lambda_u241 = Unit.INSTANCE;
                }
                InlineMarker.finallyStart((int)1);
                ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                InlineMarker.finallyEnd((int)1);
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private static final <E> Object consumeEach$$forInline(ReceiveChannel<? extends E> $this$consumeEach, Function1<? super E, Unit> action, Continuation<? super Unit> $completion) {
        void $this$consume$iv;
        boolean $i$f$consumeEach = false;
        ReceiveChannel<? extends E> receiveChannel = $this$consumeEach;
        boolean $i$f$consume = false;
        Throwable cause$iv = null;
        try {
            ReceiveChannel $this$consumeEach_u24lambda_u241 = (ReceiveChannel)$this$consume$iv;
            boolean bl = false;
            ChannelIterator channelIterator = $this$consumeEach_u24lambda_u241.iterator();
            while (true) {
                InlineMarker.mark((int)3);
                InlineMarker.mark((int)0);
                Object object = channelIterator.hasNext(null);
                InlineMarker.mark((int)1);
                if (!((Boolean)object).booleanValue()) break;
                Object e2 = channelIterator.next();
                action.invoke(e2);
            }
            $this$consumeEach_u24lambda_u241 = Unit.INSTANCE;
        }
        catch (Throwable e$iv) {
            cause$iv = e$iv;
            throw e$iv;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
            InlineMarker.finallyEnd((int)1);
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
    @Nullable
    public static final <E> Object toList(@NotNull ReceiveChannel<? extends E> var0, @NotNull Continuation<? super List<? extends E>> var1_1) {
        if (!(var1_1 instanceof toList.1)) ** GOTO lbl-1000
        var17_2 = var1_1;
        if ((var17_2.label & -2147483648) != 0) {
            var17_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var1_1){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.toList(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var18_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$toList_u24lambda_u243 = var2_5 = CollectionsKt.createListBuilder();
                $i$a$-buildList-ChannelsKt__Channels_commonKt$toList$2 = false;
                $this$consumeEach$iv = $this$toList;
                $i$f$consumeEach = false;
                $this$consume$iv$iv = $this$consumeEach$iv;
                $i$f$consume = false;
                cause$iv$iv = null;
                try {
                    $this$consumeEach_u24lambda_u241$iv = $this$consume$iv$iv;
                    $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                    var12_17 = $this$consumeEach_u24lambda_u241$iv.iterator();
                }
                catch (Throwable e$iv$iv) {
                    try {
                        cause$iv$iv = e$iv$iv;
                        throw e$iv$iv;
                    }
                    catch (Throwable var10_15) {
                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                        throw var10_15;
                    }
                }
lbl33:
                // 2 sources

                while (true) {
                    $continuation.L$0 = var2_5;
                    $continuation.L$1 = $this$toList_u24lambda_u243;
                    $continuation.L$2 = $this$consume$iv$iv;
                    $continuation.L$3 = var12_17;
                    $continuation.label = 1;
                    v0 = var12_17.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var18_4) {
                        return var18_4;
                    }
                    ** GOTO lbl56
                    break;
                }
            }
            case 1: {
                $i$a$-buildList-ChannelsKt__Channels_commonKt$toList$2 = false;
                $i$f$consumeEach = false;
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                var12_17 = (ChannelIterator<E>)$continuation.L$3;
                cause$iv$iv = null;
                $this$consume$iv$iv = (ReceiveChannel)$continuation.L$2;
                $this$toList_u24lambda_u243 = (List)$continuation.L$1;
                var2_5 = (List)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl56:
                    // 2 sources

                    if (((Boolean)v0).booleanValue()) {
                        it = e$iv = var12_17.next();
                        $i$a$-consumeEach-ChannelsKt__Channels_commonKt$toList$2$1 = false;
                        $this$toList_u24lambda_u243.add(it);
                        ** continue;
                    }
                    $this$consumeEach_u24lambda_u241$iv = Unit.INSTANCE;
                }
                ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                return CollectionsKt.build((List)var2_5);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported", level=DeprecationLevel.WARNING)
    @Nullable
    public static final <E> Object consumeEach(@NotNull BroadcastChannel<E> var0, @NotNull Function1<? super E, Unit> var1_1, @NotNull Continuation<? super Unit> var2_2) {
        if (!(var2_2 instanceof consumeEach.3)) ** GOTO lbl-1000
        var12_3 = var2_2;
        if ((var12_3.label & -2147483648) != 0) {
            var12_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt__Channels_commonKt.consumeEach(null, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var13_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$consumeEach = false;
                $this$consume$iv = $this$consumeEach;
                $i$f$consume = false;
                channel$iv = $this$consume$iv.openSubscription();
                try {
                    $this$consumeEach_u24lambda_u244 = channel$iv;
                    $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$4 = false;
                    var9_13 = $this$consumeEach_u24lambda_u244.iterator();
                }
                catch (Throwable var7_11) {
                    InlineMarker.finallyStart((int)1);
                    ReceiveChannel.DefaultImpls.cancel$default(channel$iv, null, 1, null);
                    InlineMarker.finallyEnd((int)1);
                    throw var7_11;
                }
lbl27:
                // 2 sources

                while (true) {
                    $continuation.L$0 = action;
                    $continuation.L$1 = channel$iv;
                    $continuation.L$2 = var9_13;
                    $continuation.label = 1;
                    v0 = var9_13.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var13_5) {
                        return var13_5;
                    }
                    ** GOTO lbl46
                    break;
                }
            }
            case 1: {
                $i$f$consumeEach = false;
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$4 = false;
                var9_13 = (ChannelIterator<E>)$continuation.L$2;
                channel$iv = (ReceiveChannel)$continuation.L$1;
                action = (Function1)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl46:
                    // 2 sources

                    if (((Boolean)v0).booleanValue()) {
                        element = var9_13.next();
                        action.invoke(element);
                        ** continue;
                    }
                    var7_10 = Unit.INSTANCE;
                }
                InlineMarker.finallyStart((int)1);
                ReceiveChannel.DefaultImpls.cancel$default(channel$iv, null, 1, null);
                InlineMarker.finallyEnd((int)1);
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Deprecated(message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported", level=DeprecationLevel.WARNING)
    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> $this$consumeEach, Function1<? super E, Unit> action, Continuation<? super Unit> $completion) {
        block4: {
            void $this$consume$iv;
            boolean $i$f$consumeEach = false;
            BroadcastChannel<E> broadcastChannel = $this$consumeEach;
            boolean $i$f$consume = false;
            ReceiveChannel channel$iv = $this$consume$iv.openSubscription();
            ReceiveChannel $this$consumeEach_u24lambda_u244 = channel$iv;
            boolean bl = false;
            ChannelIterator channelIterator = $this$consumeEach_u24lambda_u244.iterator();
            while (true) {
                InlineMarker.mark((int)3);
                InlineMarker.mark((int)0);
                Object object = channelIterator.hasNext(null);
                InlineMarker.mark((int)1);
                if (!((Boolean)object).booleanValue()) break;
                Object element = channelIterator.next();
                action.invoke(element);
            }
            Unit unit = Unit.INSTANCE;
            break block4;
            finally {
                InlineMarker.finallyStart((int)1);
                ReceiveChannel.DefaultImpls.cancel$default(channel$iv, null, 1, null);
                InlineMarker.finallyEnd((int)1);
            }
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @PublishedApi
    public static final void cancelConsumed(@NotNull ReceiveChannel<?> $this$cancelConsumed, @Nullable Throwable cause) {
        CancellationException cancellationException;
        ReceiveChannel<?> receiveChannel = $this$cancelConsumed;
        Throwable throwable = cause;
        if (throwable != null) {
            void it;
            Throwable throwable2 = throwable;
            ReceiveChannel<?> receiveChannel2 = receiveChannel;
            boolean bl = false;
            CancellationException cancellationException2 = it instanceof CancellationException ? (CancellationException)it : null;
            if (cancellationException2 == null) {
                cancellationException2 = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", (Throwable)it);
            }
            cancellationException = cancellationException2;
            receiveChannel = receiveChannel2;
        } else {
            cancellationException = null;
        }
        receiveChannel.cancel(cancellationException);
    }
}

