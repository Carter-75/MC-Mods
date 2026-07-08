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
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.internal.LowPriorityInOverloadResolution
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010D\u001a\u00020C\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010E\u001a\u00020\t\u0012\u0006\u0010F\u001a\u00020\t\u00a2\u0006\u0004\bG\u0010HJ\u000f\u0010\u0005\u001a\u00020\u0003H\u0017\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007\u00a2\u0006\u0004\b\u0005\u0010\nJ\u001d\u0010\u0005\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u00a2\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001\u00a2\u0006\u0004\b\u0010\u0010\nJ5\u0010\u0015\u001a\u00020\u00032#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0096\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0096\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00028\u0000H\u0097\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00018\u0000H\u0097\u0001\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\"\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0096A\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010 J\u0015\u0010$\u001a\u0004\u0018\u00018\u0000H\u0097A\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010 J\u001b\u0010%\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0096\u0001\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u001eJ'\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030!2\u0006\u0010\u001a\u001a\u00028\u0000H\u0096\u0001\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*R \u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F\u00a2\u0006\u0006\u001a\u0004\b0\u0010/R\u0014\u00102\u001a\u00020\t8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020\t8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b4\u00103R\u0014\u00105\u001a\u00020\t8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b5\u00103R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00028\u0000068\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b7\u00108R#\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!068\u0016X\u0096\u0005\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b:\u00108R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000068VX\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b<\u00108R&\u0010B\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000?0>8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006I"}, d2={"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "cancel", "()V", "", "cause", "", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "(Ljava/lang/Throwable;)V", "close", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "element", "offer", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveCatching", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReceive-PtdJZtk", "tryReceive", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "_channel", "Lkotlinx/coroutines/channels/Channel;", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "getChannel", "channel", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "getOnReceiveOrNull", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nChannelCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,41:1\n706#2,2:42\n706#2,2:44\n706#2,2:46\n*S KotlinDebug\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n*L\n21#1:42,2\n26#1:44,2\n32#1:46,2\n*E\n"})
public class ChannelCoroutine<E>
extends AbstractCoroutine<Unit>
implements Channel<E> {
    @NotNull
    private final Channel<E> _channel;

    public ChannelCoroutine(@NotNull CoroutineContext parentContext, @NotNull Channel<E> _channel, boolean initParentJob, boolean active) {
        super(parentContext, initParentJob, active);
        this._channel = _channel;
    }

    @NotNull
    protected final Channel<E> get_channel() {
        return this._channel;
    }

    @Override
    public boolean isClosedForReceive() {
        return this._channel.isClosedForReceive();
    }

    @Override
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override
    public boolean isEmpty() {
        return this._channel.isEmpty();
    }

    @Override
    @NotNull
    public SelectClause1<E> getOnReceive() {
        return this._channel.getOnReceive();
    }

    @Override
    @NotNull
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return this._channel.getOnReceiveCatching();
    }

    @Override
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        return this._channel.getOnReceiveOrNull();
    }

    @Override
    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    @Override
    public boolean close(@Nullable Throwable cause) {
        return this._channel.close(cause);
    }

    @Override
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        this._channel.invokeOnClose(handler);
    }

    @Override
    @NotNull
    public ChannelIterator<E> iterator() {
        return this._channel.iterator();
    }

    @Override
    @Deprecated(message="Deprecated in the favour of 'trySend' method", replaceWith=@ReplaceWith(expression="trySend(element).isSuccess", imports={}), level=DeprecationLevel.ERROR)
    public boolean offer(E element) {
        return this._channel.offer(element);
    }

    @Override
    @Deprecated(message="Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith=@ReplaceWith(expression="tryReceive().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
    @Nullable
    public E poll() {
        return this._channel.poll();
    }

    @Override
    @Nullable
    public Object receive(@NotNull Continuation<? super E> $completion) {
        return this._channel.receive($completion);
    }

    @Override
    @Nullable
    public Object receiveCatching-JP2dKIU(@NotNull Continuation<? super ChannelResult<? extends E>> $completion) {
        Object object = this._channel.receiveCatching-JP2dKIU($completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return object;
    }

    @Override
    @Deprecated(message="Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
    @LowPriorityInOverloadResolution
    @Nullable
    public Object receiveOrNull(@NotNull Continuation<? super E> $completion) {
        return this._channel.receiveOrNull($completion);
    }

    @Override
    @Nullable
    public Object send(E element, @NotNull Continuation<? super Unit> $completion) {
        return this._channel.send(element, $completion);
    }

    @Override
    @NotNull
    public Object tryReceive-PtdJZtk() {
        return this._channel.tryReceive-PtdJZtk();
    }

    @Override
    @NotNull
    public Object trySend-JP2dKIU(E element) {
        return this._channel.trySend-JP2dKIU(element);
    }

    @NotNull
    public final Channel<E> getChannel() {
        return this;
    }

    @Override
    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ void cancel() {
        Object message$iv = null;
        Throwable cause$iv = null;
        boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
        this.cancelInternal(new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), cause$iv, this));
    }

    @Override
    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public final /* synthetic */ boolean cancel(Throwable cause) {
        Object message$iv = null;
        Throwable cause$iv = null;
        boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
        this.cancelInternal(new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), cause$iv, this));
        return true;
    }

    @Override
    public final void cancel(@Nullable CancellationException cause) {
        if (this.isCancelled()) {
            return;
        }
        CancellationException cancellationException = cause;
        if (cancellationException == null) {
            Object message$iv = null;
            Throwable cause$iv = null;
            boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
            cancellationException = new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), cause$iv, this);
        }
        this.cancelInternal(cancellationException);
    }

    @Override
    public void cancelInternal(@NotNull Throwable cause) {
        CancellationException exception = JobSupport.toCancellationException$default(this, cause, null, 1, null);
        this._channel.cancel(exception);
        this.cancelCoroutine(exception);
    }
}

