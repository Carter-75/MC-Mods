/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ConflatedBufferedChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001aE\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\u0004\b\u0004\u0010\u000b\u001aX\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00000\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a^\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0017\u0010\u0014\u001a^\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u0019\u0010\u0014\u001a\\\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0004\b\u001b\u0010\u0014\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2={"E", "", "capacity", "Lkotlinx/coroutines/channels/Channel;", "Channel", "(I)Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "onUndeliveredElement", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/channels/Channel;", "T", "Lkotlinx/coroutines/channels/ChannelResult;", "", "Lkotlin/ParameterName;", "name", "exception", "onFailure", "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrElse", "action", "onClosed-WpGqRn0", "onClosed", "onFailure-WpGqRn0", "value", "onSuccess-WpGqRn0", "onSuccess", "kotlinx-coroutines-core"})
public final class ChannelKt {
    public static final <T> T getOrElse-WpGqRn0(@NotNull Object $this$getOrElse_u2dWpGqRn0, @NotNull Function1<? super Throwable, ? extends T> onFailure) {
        boolean bl = false;
        return (T)($this$getOrElse_u2dWpGqRn0 instanceof ChannelResult.Failed ? onFailure.invoke((Object)ChannelResult.exceptionOrNull-impl($this$getOrElse_u2dWpGqRn0)) : $this$getOrElse_u2dWpGqRn0);
    }

    @NotNull
    public static final <T> Object onSuccess-WpGqRn0(@NotNull Object $this$onSuccess_u2dWpGqRn0, @NotNull Function1<? super T, Unit> action) {
        boolean bl = false;
        if (!($this$onSuccess_u2dWpGqRn0 instanceof ChannelResult.Failed)) {
            action.invoke($this$onSuccess_u2dWpGqRn0);
        }
        return $this$onSuccess_u2dWpGqRn0;
    }

    @NotNull
    public static final <T> Object onFailure-WpGqRn0(@NotNull Object $this$onFailure_u2dWpGqRn0, @NotNull Function1<? super Throwable, Unit> action) {
        boolean bl = false;
        if ($this$onFailure_u2dWpGqRn0 instanceof ChannelResult.Failed) {
            action.invoke((Object)ChannelResult.exceptionOrNull-impl($this$onFailure_u2dWpGqRn0));
        }
        return $this$onFailure_u2dWpGqRn0;
    }

    @NotNull
    public static final <T> Object onClosed-WpGqRn0(@NotNull Object $this$onClosed_u2dWpGqRn0, @NotNull Function1<? super Throwable, Unit> action) {
        boolean bl = false;
        if ($this$onClosed_u2dWpGqRn0 instanceof ChannelResult.Closed) {
            action.invoke((Object)ChannelResult.exceptionOrNull-impl($this$onClosed_u2dWpGqRn0));
        }
        return $this$onClosed_u2dWpGqRn0;
    }

    @NotNull
    public static final <E> Channel<E> Channel(int capacity, @NotNull BufferOverflow onBufferOverflow, @Nullable Function1<? super E, Unit> onUndeliveredElement) {
        Channel channel;
        switch (capacity) {
            case 0: {
                channel = onBufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(0, onUndeliveredElement) : (BufferedChannel)new ConflatedBufferedChannel<E>(1, onBufferOverflow, onUndeliveredElement);
                break;
            }
            case -1: {
                if (!(onBufferOverflow == BufferOverflow.SUSPEND)) {
                    boolean bl = false;
                    String string = "CONFLATED capacity cannot be used with non-default onBufferOverflow";
                    throw new IllegalArgumentException(string.toString());
                }
                channel = new ConflatedBufferedChannel<E>(1, BufferOverflow.DROP_OLDEST, onUndeliveredElement);
                break;
            }
            case 0x7FFFFFFF: {
                channel = new BufferedChannel<E>(Integer.MAX_VALUE, onUndeliveredElement);
                break;
            }
            case -2: {
                channel = onBufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), onUndeliveredElement) : (BufferedChannel)new ConflatedBufferedChannel<E>(1, onBufferOverflow, onUndeliveredElement);
                break;
            }
            default: {
                channel = onBufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(capacity, onUndeliveredElement) : (BufferedChannel)new ConflatedBufferedChannel<E>(capacity, onBufferOverflow, onUndeliveredElement);
            }
        }
        return channel;
    }

    public static /* synthetic */ Channel Channel$default(int n2, BufferOverflow bufferOverflow, Function1 function1, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        if ((n3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((n3 & 4) != 0) {
            function1 = null;
        }
        return ChannelKt.Channel(n2, bufferOverflow, function1);
    }

    public static /* synthetic */ Channel Channel$default(int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        return ChannelKt.Channel$default(n2, null, null, 6, null);
    }
}

