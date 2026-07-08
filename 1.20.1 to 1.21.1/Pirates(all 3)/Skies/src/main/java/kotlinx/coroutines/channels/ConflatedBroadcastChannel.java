/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Deprecated(message="ConflatedBroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported", level=DeprecationLevel.WARNING)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\t\b\u0016\u00a2\u0006\u0004\b.\u0010/B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00028\u0000\u00a2\u0006\u0004\b.\u00100B\u0017\b\u0002\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001f\u00a2\u0006\u0004\b.\u00101J\u001c\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0097\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u0006\u001a\u00020\n2\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0001\u00a2\u0006\u0004\b\f\u0010\u0007J5\u0010\u0011\u001a\u00020\n2#\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n0\rH\u0096\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00028\u0000H\u0097\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0001\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00058\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R&\u0010(\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000%0$8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010+\u001a\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0013\u0010-\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b,\u0010*\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u00062"}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "broadcast", "Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "value", "getValueOrNull", "valueOrNull", "<init>", "()V", "(Ljava/lang/Object;)V", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "kotlinx-coroutines-core"})
@ObsoleteCoroutinesApi
public final class ConflatedBroadcastChannel<E>
implements BroadcastChannel<E> {
    @NotNull
    private final BroadcastChannelImpl<E> broadcast;

    private ConflatedBroadcastChannel(BroadcastChannelImpl<E> broadcast2) {
        this.broadcast = broadcast2;
    }

    @Override
    public boolean isClosedForSend() {
        return this.broadcast.isClosedForSend();
    }

    @Override
    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this.broadcast.getOnSend();
    }

    @Override
    @Deprecated(message="Binary compatibility only", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ boolean cancel(Throwable cause) {
        return this.broadcast.cancel(cause);
    }

    @Override
    public void cancel(@Nullable CancellationException cause) {
        this.broadcast.cancel(cause);
    }

    @Override
    public boolean close(@Nullable Throwable cause) {
        return this.broadcast.close(cause);
    }

    @Override
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        this.broadcast.invokeOnClose(handler);
    }

    @Override
    @Deprecated(message="Deprecated in the favour of 'trySend' method", replaceWith=@ReplaceWith(expression="trySend(element).isSuccess", imports={}), level=DeprecationLevel.ERROR)
    public boolean offer(E element) {
        return this.broadcast.offer(element);
    }

    @Override
    @NotNull
    public ReceiveChannel<E> openSubscription() {
        return this.broadcast.openSubscription();
    }

    @Override
    @Nullable
    public Object send(E element, @NotNull Continuation<? super Unit> $completion) {
        return this.broadcast.send(element, $completion);
    }

    @Override
    @NotNull
    public Object trySend-JP2dKIU(E element) {
        return this.broadcast.trySend-JP2dKIU(element);
    }

    public ConflatedBroadcastChannel() {
        this((E)new BroadcastChannelImpl(-1));
    }

    public ConflatedBroadcastChannel(E value) {
        this();
        this.trySend-JP2dKIU(value);
    }

    public final E getValue() {
        return this.broadcast.getValue();
    }

    @Nullable
    public final E getValueOrNull() {
        return this.broadcast.getValueOrNull();
    }
}

