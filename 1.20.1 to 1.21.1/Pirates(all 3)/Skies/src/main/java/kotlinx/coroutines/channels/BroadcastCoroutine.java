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
 *  kotlin.coroutines.CoroutineContext$Key
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B%\u0012\u0006\u00109\u001a\u000208\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010:\u001a\u00020\b\u00a2\u0006\u0004\b;\u0010<J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\t\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u00a2\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\u0010\u0010\nJ5\u0010\u0015\u001a\u00020\u00032#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0011H\u0096\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00028\u0000H\u0097\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0096\u0001\u00a2\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$J'\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u0010\u0017\u001a\u00028\u0000H\u0096\u0001\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'R \u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000-8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00101\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u00020\b8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b3\u00102R&\u00107\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000-048\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006="}, d2={"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "(Ljava/lang/Throwable;)V", "close", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "element", "offer", "(Ljava/lang/Object;)Z", "handled", "onCancelled", "(Ljava/lang/Throwable;Z)V", "value", "onCompleted", "(Lkotlin/Unit;)V", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "_channel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "get_channel", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "isActive", "()Z", "isClosedForSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Z)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,202:1\n706#2,2:203\n706#2,2:205\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n*L\n152#1:203,2\n157#1:205,2\n*E\n"})
class BroadcastCoroutine<E>
extends AbstractCoroutine<Unit>
implements ProducerScope<E>,
BroadcastChannel<E> {
    @NotNull
    private final BroadcastChannel<E> _channel;

    public BroadcastCoroutine(@NotNull CoroutineContext parentContext, @NotNull BroadcastChannel<E> _channel, boolean active) {
        super(parentContext, false, active);
        this._channel = _channel;
        this.initParentJob((Job)parentContext.get((CoroutineContext.Key)Job.Key));
    }

    @NotNull
    protected final BroadcastChannel<E> get_channel() {
        return this._channel;
    }

    @Override
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override
    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    @Override
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        this._channel.invokeOnClose(handler);
    }

    @Override
    @Deprecated(message="Deprecated in the favour of 'trySend' method", replaceWith=@ReplaceWith(expression="trySend(element).isSuccess", imports={}), level=DeprecationLevel.ERROR)
    public boolean offer(E element) {
        return this._channel.offer(element);
    }

    @Override
    @NotNull
    public ReceiveChannel<E> openSubscription() {
        return this._channel.openSubscription();
    }

    @Override
    @Nullable
    public Object send(E element, @NotNull Continuation<? super Unit> $completion) {
        return this._channel.send(element, $completion);
    }

    @Override
    @NotNull
    public Object trySend-JP2dKIU(E element) {
        return this._channel.trySend-JP2dKIU(element);
    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    @NotNull
    public SendChannel<E> getChannel() {
        return this;
    }

    @Override
    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public final /* synthetic */ boolean cancel(Throwable cause) {
        Throwable throwable = cause;
        if (throwable == null) {
            Object message$iv = null;
            Throwable cause$iv = null;
            boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
            throwable = new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), cause$iv, this);
        }
        this.cancelInternal(throwable);
        return true;
    }

    @Override
    public final void cancel(@Nullable CancellationException cause) {
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

    @Override
    protected void onCompleted(@NotNull Unit value) {
        SendChannel.DefaultImpls.close$default(this._channel, null, 1, null);
    }

    @Override
    protected void onCancelled(@NotNull Throwable cause, boolean handled) {
        boolean processed = this._channel.close(cause);
        if (!processed && !handled) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), cause);
        }
    }

    @Override
    public boolean close(@Nullable Throwable cause) {
        boolean result2 = this._channel.close(cause);
        this.start();
        return result2;
    }
}

