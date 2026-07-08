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
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0004\u00a8\u0006\u0005"}, d2={"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"})
public interface Channel<E>
extends SendChannel<E>,
ReceiveChannel<E> {
    @NotNull
    public static final Factory Factory = kotlinx.coroutines.channels.Channel$Factory.$$INSTANCE;
    public static final int UNLIMITED = Integer.MAX_VALUE;
    public static final int RENDEZVOUS = 0;
    public static final int CONFLATED = -1;
    public static final int BUFFERED = -2;
    public static final int OPTIONAL_CHANNEL = -3;
    @NotNull
    public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated(message="Deprecated in the favour of 'trySend' method", replaceWith=@ReplaceWith(expression="trySend(element).isSuccess", imports={}), level=DeprecationLevel.ERROR)
        public static <E> boolean offer(@NotNull Channel<E> $this, E element) {
            return SendChannel.DefaultImpls.offer((SendChannel)$this, element);
        }

        @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
        public static /* synthetic */ void cancel(Channel $this) {
            ReceiveChannel.DefaultImpls.cancel($this);
        }

        @Deprecated(message="Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith=@ReplaceWith(expression="tryReceive().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
        @Nullable
        public static <E> E poll(@NotNull Channel<E> $this) {
            return ReceiveChannel.DefaultImpls.poll((ReceiveChannel)$this);
        }

        @Deprecated(message="Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
        @LowPriorityInOverloadResolution
        @Nullable
        public static <E> Object receiveOrNull(@NotNull Channel<E> $this, @NotNull Continuation<? super E> $completion) {
            return ReceiveChannel.DefaultImpls.receiveOrNull((ReceiveChannel)$this, $completion);
        }

        @NotNull
        public static <E> SelectClause1<E> getOnReceiveOrNull(@NotNull Channel<E> $this) {
            return ReceiveChannel.DefaultImpls.getOnReceiveOrNull((ReceiveChannel)$this);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0011"}, d2={"Lkotlinx/coroutines/channels/Channel$Factory;", "", "", "BUFFERED", "I", "CHANNEL_DEFAULT_CAPACITY", "getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core", "()I", "CONFLATED", "", "DEFAULT_BUFFER_PROPERTY_NAME", "Ljava/lang/String;", "OPTIONAL_CHANNEL", "RENDEZVOUS", "UNLIMITED", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Factory {
        static final /* synthetic */ Factory $$INSTANCE;
        public static final int UNLIMITED = Integer.MAX_VALUE;
        public static final int RENDEZVOUS = 0;
        public static final int CONFLATED = -1;
        public static final int BUFFERED = -2;
        public static final int OPTIONAL_CHANNEL = -3;
        @NotNull
        public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";
        private static final int CHANNEL_DEFAULT_CAPACITY;

        private Factory() {
        }

        public final int getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() {
            return CHANNEL_DEFAULT_CAPACITY;
        }

        static {
            $$INSTANCE = new Factory();
            CHANNEL_DEFAULT_CAPACITY = SystemPropsKt.systemProp("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 0x7FFFFFFE);
        }
    }
}

