/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.CancellableFlowImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a/\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00072\b\b\u0002\u0010\t\u001a\u00020\bH\u0007\u00a2\u0006\u0004\b\n\u0010\u000b\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\n\u0010\u000e\u001a#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0010\u001a+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lkotlin/coroutines/CoroutineContext;", "context", "", "checkFlowContext$FlowKt__ContextKt", "(Lkotlin/coroutines/CoroutineContext;)V", "checkFlowContext", "T", "Lkotlinx/coroutines/flow/Flow;", "", "capacity", "buffer", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "cancellable", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "conflate", "flowOn", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ContextKt {
    @NotNull
    public static final <T> Flow<T> buffer(@NotNull Flow<? extends T> $this$buffer, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        if (!(capacity >= 0 || capacity == -2 || capacity == -1)) {
            boolean $i$a$-require-FlowKt__ContextKt$buffer$32 = false;
            String $i$a$-require-FlowKt__ContextKt$buffer$32 = "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + capacity;
            throw new IllegalArgumentException($i$a$-require-FlowKt__ContextKt$buffer$32.toString());
        }
        if (!(capacity != -1 || onBufferOverflow == BufferOverflow.SUSPEND)) {
            boolean $i$a$-require-FlowKt__ContextKt$buffer$42 = false;
            String $i$a$-require-FlowKt__ContextKt$buffer$42 = "CONFLATED capacity cannot be used with non-default onBufferOverflow";
            throw new IllegalArgumentException($i$a$-require-FlowKt__ContextKt$buffer$42.toString());
        }
        int capacity2 = capacity;
        BufferOverflow onBufferOverflow2 = onBufferOverflow;
        if (capacity2 == -1) {
            capacity2 = 0;
            onBufferOverflow2 = BufferOverflow.DROP_OLDEST;
        }
        return $this$buffer instanceof FusibleFlow ? FusibleFlow.DefaultImpls.fuse$default((FusibleFlow)$this$buffer, null, capacity2, onBufferOverflow2, 1, null) : (Flow)new ChannelFlowOperatorImpl($this$buffer, null, capacity2, onBufferOverflow2, 2, null);
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int n2, BufferOverflow bufferOverflow, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = -2;
        }
        if ((n3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow, n2, bufferOverflow);
    }

    @Deprecated(message="Since 1.4.0, binary compatibility with earlier versions", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Flow buffer(Flow $this$buffer, int capacity) {
        return FlowKt.buffer$default($this$buffer, capacity, null, 2, null);
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = -2;
        }
        return FlowKt.buffer(flow, n2);
    }

    @NotNull
    public static final <T> Flow<T> conflate(@NotNull Flow<? extends T> $this$conflate) {
        return FlowKt.buffer$default($this$conflate, -1, null, 2, null);
    }

    @NotNull
    public static final <T> Flow<T> flowOn(@NotNull Flow<? extends T> $this$flowOn, @NotNull CoroutineContext context) {
        FlowKt__ContextKt.checkFlowContext$FlowKt__ContextKt(context);
        return Intrinsics.areEqual((Object)context, (Object)EmptyCoroutineContext.INSTANCE) ? $this$flowOn : ($this$flowOn instanceof FusibleFlow ? FusibleFlow.DefaultImpls.fuse$default((FusibleFlow)$this$flowOn, context, 0, null, 6, null) : (Flow)new ChannelFlowOperatorImpl($this$flowOn, context, 0, null, 12, null));
    }

    @NotNull
    public static final <T> Flow<T> cancellable(@NotNull Flow<? extends T> $this$cancellable) {
        return $this$cancellable instanceof CancellableFlow ? $this$cancellable : (Flow)new CancellableFlowImpl<T>($this$cancellable);
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext context) {
        if (!(context.get((CoroutineContext.Key)Job.Key) == null)) {
            boolean bl = false;
            String string = "Flow context cannot contain job in it. Had " + context;
            throw new IllegalArgumentException(string.toString());
        }
    }
}

