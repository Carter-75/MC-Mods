/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.coroutines.Continuation
 *  kotlin.internal.LowPriorityInOverloadResolution
 */
package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2={"Lkotlinx/coroutines/channels/ActorScope;", "E", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/Channel;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "kotlinx-coroutines-core"})
@ObsoleteCoroutinesApi
public interface ActorScope<E>
extends CoroutineScope,
ReceiveChannel<E> {
    @NotNull
    public Channel<E> getChannel();

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
        public static /* synthetic */ void cancel(ActorScope $this) {
            ReceiveChannel.DefaultImpls.cancel($this);
        }

        @Deprecated(message="Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith=@ReplaceWith(expression="tryReceive().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
        @Nullable
        public static <E> E poll(@NotNull ActorScope<E> $this) {
            return ReceiveChannel.DefaultImpls.poll((ReceiveChannel)$this);
        }

        @Deprecated(message="Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
        @LowPriorityInOverloadResolution
        @Nullable
        public static <E> Object receiveOrNull(@NotNull ActorScope<E> $this, @NotNull Continuation<? super E> $completion) {
            return ReceiveChannel.DefaultImpls.receiveOrNull((ReceiveChannel)$this, $completion);
        }

        @NotNull
        public static <E> SelectClause1<E> getOnReceiveOrNull(@NotNull ActorScope<E> $this) {
            return ReceiveChannel.DefaultImpls.getOnReceiveOrNull((ReceiveChannel)$this);
        }
    }
}

