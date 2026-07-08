/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 */
package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ConflatedBroadcastChannel;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"E", "", "capacity", "Lkotlinx/coroutines/channels/BroadcastChannel;", "BroadcastChannel", "(I)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/internal/Symbol;", "NO_ELEMENT", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"})
public final class BroadcastChannelKt {
    @NotNull
    private static final Symbol NO_ELEMENT = new Symbol("NO_ELEMENT");

    @Deprecated(message="BroadcastChannel is deprecated in the favour of SharedFlow and StateFlow, and is no longer supported", level=DeprecationLevel.WARNING)
    @ObsoleteCoroutinesApi
    @NotNull
    public static final <E> BroadcastChannel<E> BroadcastChannel(int capacity) {
        BroadcastChannel broadcastChannel;
        switch (capacity) {
            case 0: {
                throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
            }
            case 0x7FFFFFFF: {
                throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
            }
            case -1: {
                broadcastChannel = new ConflatedBroadcastChannel();
                break;
            }
            case -2: {
                broadcastChannel = new BroadcastChannelImpl(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
                break;
            }
            default: {
                broadcastChannel = new BroadcastChannelImpl(capacity);
            }
        }
        return broadcastChannel;
    }

    public static final /* synthetic */ Symbol access$getNO_ELEMENT$p() {
        return NO_ELEMENT;
    }
}

