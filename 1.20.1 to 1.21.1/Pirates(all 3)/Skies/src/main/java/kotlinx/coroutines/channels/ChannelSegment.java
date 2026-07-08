/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.WaiterEB;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0002B7\u0012\u0006\u00108\u001a\u000207\u0012\u000e\u00109\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u00101\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010,\u0012\u0006\u0010:\u001a\u00020\u0003\u00a2\u0006\u0004\b;\u0010<J+\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0015J)\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\b\u00a2\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\"\u0010\u0015J!\u0010%\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0000\u00a2\u0006\u0004\b'\u0010&J\u001f\u0010+\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b*\u0010&R\u001c\u0010-\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000,8F\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u0013\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005028\u0002X\u0082\u0004R\u0014\u00106\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u00a8\u0006="}, d2={"Lkotlinx/coroutines/channels/ChannelSegment;", "E", "Lkotlinx/coroutines/internal/Segment;", "", "index", "", "from", "to", "", "casState$kotlinx_coroutines_core", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "casState", "", "cleanElement$kotlinx_coroutines_core", "(I)V", "cleanElement", "update", "getAndSetState$kotlinx_coroutines_core", "(ILjava/lang/Object;)Ljava/lang/Object;", "getAndSetState", "getElement$kotlinx_coroutines_core", "(I)Ljava/lang/Object;", "getElement", "getState$kotlinx_coroutines_core", "getState", "", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "onCancellation", "(ILjava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)V", "receiver", "onCancelledRequest", "(IZ)V", "retrieveElement$kotlinx_coroutines_core", "retrieveElement", "value", "setElementLazy", "(ILjava/lang/Object;)V", "setState$kotlinx_coroutines_core", "setState", "element", "storeElement$kotlinx_coroutines_core", "storeElement", "Lkotlinx/coroutines/channels/BufferedChannel;", "_channel", "Lkotlinx/coroutines/channels/BufferedChannel;", "getChannel", "()Lkotlinx/coroutines/channels/BufferedChannel;", "channel", "Lkotlinx/atomicfu/AtomicArray;", "data", "getNumberOfSlots", "()I", "numberOfSlots", "", "id", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/channels/ChannelSegment;Lkotlinx/coroutines/channels/BufferedChannel;I)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n1#2:3056\n*E\n"})
public final class ChannelSegment<E>
extends Segment<ChannelSegment<E>> {
    @Nullable
    private final BufferedChannel<E> _channel;
    @NotNull
    private final AtomicReferenceArray data;

    public ChannelSegment(long id, @Nullable ChannelSegment<E> prev2, @Nullable BufferedChannel<E> channel, int pointers) {
        super(id, (Segment)prev2, pointers);
        this._channel = channel;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    @NotNull
    public final BufferedChannel<E> getChannel() {
        BufferedChannel<E> bufferedChannel = this._channel;
        Intrinsics.checkNotNull(bufferedChannel);
        return bufferedChannel;
    }

    @Override
    public int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    public final void storeElement$kotlinx_coroutines_core(int index, E element) {
        this.setElementLazy(index, element);
    }

    public final E getElement$kotlinx_coroutines_core(int index) {
        return this.data.get(index * 2);
    }

    public final E retrieveElement$kotlinx_coroutines_core(int index) {
        E e2;
        E it = e2 = this.getElement$kotlinx_coroutines_core(index);
        boolean bl = false;
        this.cleanElement$kotlinx_coroutines_core(index);
        return e2;
    }

    public final void cleanElement$kotlinx_coroutines_core(int index) {
        this.setElementLazy(index, null);
    }

    private final void setElementLazy(int index, Object value) {
        this.data.lazySet(index * 2, value);
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core(int index) {
        return this.data.get(index * 2 + 1);
    }

    public final void setState$kotlinx_coroutines_core(int index, @Nullable Object value) {
        this.data.set(index * 2 + 1, value);
    }

    public final boolean casState$kotlinx_coroutines_core(int index, @Nullable Object from, @Nullable Object to) {
        return this.data.compareAndSet(index * 2 + 1, from, to);
    }

    @Nullable
    public final Object getAndSetState$kotlinx_coroutines_core(int index, @Nullable Object update) {
        return this.data.getAndSet(index * 2 + 1, update);
    }

    @Override
    public void onCancellation(int index, @Nullable Throwable cause, @NotNull CoroutineContext context) {
        Object cur;
        boolean isSender = index >= BufferedChannelKt.SEGMENT_SIZE;
        int index2 = isSender ? index - BufferedChannelKt.SEGMENT_SIZE : index;
        E element = this.getElement$kotlinx_coroutines_core(index2);
        while (true) {
            cur = this.getState$kotlinx_coroutines_core(index2);
            if (cur instanceof Waiter || cur instanceof WaiterEB) {
                Symbol update = isSender ? BufferedChannelKt.access$getINTERRUPTED_SEND$p() : BufferedChannelKt.access$getINTERRUPTED_RCV$p();
                if (!this.casState$kotlinx_coroutines_core(index2, cur, update)) continue;
                this.cleanElement$kotlinx_coroutines_core(index2);
                this.onCancelledRequest(index2, !isSender);
                if (isSender) {
                    Function1 function1 = this.getChannel().onUndeliveredElement;
                    if (function1 != null) {
                        OnUndeliveredElementKt.callUndeliveredElement(function1, element, context);
                    }
                }
                return;
            }
            if (cur == BufferedChannelKt.access$getINTERRUPTED_SEND$p() || cur == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                this.cleanElement$kotlinx_coroutines_core(index2);
                if (isSender) {
                    Function1 function1 = this.getChannel().onUndeliveredElement;
                    if (function1 != null) {
                        OnUndeliveredElementKt.callUndeliveredElement(function1, element, context);
                    }
                }
                return;
            }
            if (cur != BufferedChannelKt.access$getRESUMING_BY_EB$p() && cur != BufferedChannelKt.access$getRESUMING_BY_RCV$p()) break;
        }
        if (cur == BufferedChannelKt.access$getDONE_RCV$p() || cur == BufferedChannelKt.BUFFERED) {
            return;
        }
        if (cur == BufferedChannelKt.getCHANNEL_CLOSED()) {
            return;
        }
        throw new IllegalStateException(("unexpected state: " + cur).toString());
    }

    public final void onCancelledRequest(int index, boolean receiver) {
        if (receiver) {
            this.getChannel().waitExpandBufferCompletion$kotlinx_coroutines_core(this.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)index);
        }
        this.onSlotCleaned();
    }
}

