/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001e\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001\u00a2\u0006\u0004\b\b\u0010\tR#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\n8\u0006X\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/channels/ReceiveCatching;", "E", "Lkotlinx/coroutines/Waiter;", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/channels/ChannelResult;", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "<init>", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "kotlinx-coroutines-core"})
final class ReceiveCatching<E>
implements Waiter {
    @JvmField
    @NotNull
    public final CancellableContinuationImpl<ChannelResult<? extends E>> cont;

    public ReceiveCatching(@NotNull CancellableContinuationImpl<? super ChannelResult<? extends E>> cont) {
        this.cont = cont;
    }

    @Override
    public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
        this.cont.invokeOnCancellation(segment, index);
    }
}

