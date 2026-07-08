/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 */
package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ActorScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2={"Lkotlinx/coroutines/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "", "exception", "", "handleJobException", "(Ljava/lang/Throwable;)Z", "cause", "", "onCancelling", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlinx/coroutines/channels/Channel;", "channel", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "kotlinx-coroutines-core"})
class ActorCoroutine<E>
extends ChannelCoroutine<E>
implements ActorScope<E> {
    public ActorCoroutine(@NotNull CoroutineContext parentContext, @NotNull Channel<E> channel, boolean active) {
        super(parentContext, channel, false, active);
        this.initParentJob((Job)parentContext.get((CoroutineContext.Key)Job.Key));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onCancelling(@Nullable Throwable cause) {
        CancellationException cancellationException;
        Channel channel = this.get_channel();
        Throwable throwable = cause;
        if (throwable != null) {
            void it;
            Throwable throwable2 = throwable;
            Channel channel2 = channel;
            boolean bl = false;
            CancellationException cancellationException2 = it instanceof CancellationException ? (CancellationException)it : null;
            if (cancellationException2 == null) {
                cancellationException2 = ExceptionsKt.CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled", (Throwable)it);
            }
            cancellationException = cancellationException2;
            channel = channel2;
        } else {
            cancellationException = null;
        }
        channel.cancel(cancellationException);
    }

    @Override
    protected boolean handleJobException(@NotNull Throwable exception) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), exception);
        return true;
    }
}

