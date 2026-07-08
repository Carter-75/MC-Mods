/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\b\u001a=\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a-\u0010\u0018\u001a\u00020\u0017*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\u001a8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2={"T", "", "replay", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "MutableSharedFlow", "(IILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "fuseSharedFlow", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "", "", "", "index", "getBufferAt", "([Ljava/lang/Object;J)Ljava/lang/Object;", "item", "", "setBufferAt", "([Ljava/lang/Object;JLjava/lang/Object;)V", "Lkotlinx/coroutines/internal/Symbol;", "NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
public final class SharedFlowKt {
    @JvmField
    @NotNull
    public static final Symbol NO_VALUE = new Symbol("NO_VALUE");

    @NotNull
    public static final <T> MutableSharedFlow<T> MutableSharedFlow(int replay, int extraBufferCapacity, @NotNull BufferOverflow onBufferOverflow) {
        if (!(replay >= 0)) {
            boolean $i$a$-require-SharedFlowKt$MutableSharedFlow$42 = false;
            String $i$a$-require-SharedFlowKt$MutableSharedFlow$42 = "replay cannot be negative, but was " + replay;
            throw new IllegalArgumentException($i$a$-require-SharedFlowKt$MutableSharedFlow$42.toString());
        }
        if (!(extraBufferCapacity >= 0)) {
            boolean $i$a$-require-SharedFlowKt$MutableSharedFlow$52 = false;
            String $i$a$-require-SharedFlowKt$MutableSharedFlow$52 = "extraBufferCapacity cannot be negative, but was " + extraBufferCapacity;
            throw new IllegalArgumentException($i$a$-require-SharedFlowKt$MutableSharedFlow$52.toString());
        }
        if (!(replay > 0 || extraBufferCapacity > 0 || onBufferOverflow == BufferOverflow.SUSPEND)) {
            boolean $i$a$-require-SharedFlowKt$MutableSharedFlow$62 = false;
            String $i$a$-require-SharedFlowKt$MutableSharedFlow$62 = "replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + (Object)((Object)onBufferOverflow);
            throw new IllegalArgumentException($i$a$-require-SharedFlowKt$MutableSharedFlow$62.toString());
        }
        int bufferCapacity0 = replay + extraBufferCapacity;
        int bufferCapacity = bufferCapacity0 < 0 ? Integer.MAX_VALUE : bufferCapacity0;
        return new SharedFlowImpl(replay, bufferCapacity, onBufferOverflow);
    }

    public static /* synthetic */ MutableSharedFlow MutableSharedFlow$default(int n2, int n3, BufferOverflow bufferOverflow, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n2 = 0;
        }
        if ((n4 & 2) != 0) {
            n3 = 0;
        }
        if ((n4 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return SharedFlowKt.MutableSharedFlow(n2, n3, bufferOverflow);
    }

    private static final Object getBufferAt(Object[] $this$getBufferAt, long index) {
        return $this$getBufferAt[(int)index & $this$getBufferAt.length - 1];
    }

    private static final void setBufferAt(Object[] $this$setBufferAt, long index, Object item) {
        $this$setBufferAt[(int)index & $this$setBufferAt.length - 1] = item;
    }

    @NotNull
    public static final <T> Flow<T> fuseSharedFlow(@NotNull SharedFlow<? extends T> $this$fuseSharedFlow, @NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        if ((capacity == 0 || capacity == -3) && onBufferOverflow == BufferOverflow.SUSPEND) {
            return $this$fuseSharedFlow;
        }
        return new ChannelFlowOperatorImpl($this$fuseSharedFlow, context, capacity, onBufferOverflow);
    }

    public static final /* synthetic */ Object access$getBufferAt(Object[] $receiver, long index) {
        return SharedFlowKt.getBufferAt($receiver, index);
    }

    public static final /* synthetic */ void access$setBufferAt(Object[] $receiver, long index, Object item) {
        SharedFlowKt.setBufferAt($receiver, index, item);
    }
}

