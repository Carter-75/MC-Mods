/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.NopCollector;
import kotlinx.coroutines.flow.internal.SendingCollector;
import kotlinx.coroutines.flow.internal.StackFrameContinuation;
import kotlinx.coroutines.flow.internal.UndispatchedContextCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a]\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00052\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\fH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2={"T", "V", "Lkotlin/coroutines/CoroutineContext;", "newContext", "value", "", "countOrElement", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "withContextUndispatched", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "asChannelFlow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "withUndispatchedContextCollector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,245:1\n95#2,5:246\n*S KotlinDebug\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n*L\n226#1:246,5\n*E\n"})
public final class ChannelFlowKt {
    @NotNull
    public static final <T> ChannelFlow<T> asChannelFlow(@NotNull Flow<? extends T> $this$asChannelFlow) {
        ChannelFlow channelFlow = $this$asChannelFlow instanceof ChannelFlow ? (ChannelFlow)$this$asChannelFlow : null;
        if (channelFlow == null) {
            channelFlow = new ChannelFlowOperatorImpl($this$asChannelFlow, null, 0, null, 14, null);
        }
        return channelFlow;
    }

    private static final <T> FlowCollector<T> withUndispatchedContextCollector(FlowCollector<? super T> $this$withUndispatchedContextCollector, CoroutineContext emitContext) {
        FlowCollector flowCollector = $this$withUndispatchedContextCollector;
        return (flowCollector instanceof SendingCollector ? true : flowCollector instanceof NopCollector) ? $this$withUndispatchedContextCollector : (FlowCollector)new UndispatchedContextCollector<T>($this$withUndispatchedContextCollector, emitContext);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public static final <T, V> Object withContextUndispatched(@NotNull CoroutineContext newContext, V value, @NotNull Object countOrElement, @NotNull Function2<? super V, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        Object object;
        Continuation<? super T> uCont = $completion;
        boolean bl = false;
        boolean $i$f$withCoroutineContext = false;
        Object oldValue$iv = ThreadContextKt.updateThreadContext(newContext, countOrElement);
        try {
            boolean bl2 = false;
            Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2 = block;
            Continuation continuation = new StackFrameContinuation<T>(uCont, newContext);
            Object object2 = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, (int)2)).invoke(value, (Object)continuation);
            object = object2;
        }
        finally {
            ThreadContextKt.restoreThreadContext(newContext, oldValue$iv);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    public static /* synthetic */ Object withContextUndispatched$default(CoroutineContext coroutineContext, Object object, Object object2, Function2 function2, Continuation continuation, int n2, Object object3) {
        if ((n2 & 4) != 0) {
            object2 = ThreadContextKt.threadContextElements(coroutineContext);
        }
        return ChannelFlowKt.withContextUndispatched(coroutineContext, object, object2, function2, continuation);
    }

    public static final /* synthetic */ FlowCollector access$withUndispatchedContextCollector(FlowCollector $receiver, CoroutineContext emitContext) {
        return ChannelFlowKt.withUndispatchedContextCollector($receiver, emitContext);
    }
}

