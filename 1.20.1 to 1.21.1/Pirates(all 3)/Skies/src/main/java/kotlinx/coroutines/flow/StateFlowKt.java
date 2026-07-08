/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a=\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a4\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\b\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a4\u0010\u0014\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\b\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a4\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\b\u00a2\u0006\u0004\b\u0016\u0010\u0012\"\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019\u00a8\u0006\u001b"}, d2={"T", "value", "Lkotlinx/coroutines/flow/MutableStateFlow;", "MutableStateFlow", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuseStateFlow", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "function", "getAndUpdate", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "update", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)V", "updateAndGet", "Lkotlinx/coroutines/internal/Symbol;", "NONE", "Lkotlinx/coroutines/internal/Symbol;", "PENDING", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,428:1\n1#2:429\n*E\n"})
public final class StateFlowKt {
    @NotNull
    private static final Symbol NONE = new Symbol("NONE");
    @NotNull
    private static final Symbol PENDING = new Symbol("PENDING");

    @NotNull
    public static final <T> MutableStateFlow<T> MutableStateFlow(T value) {
        Object object = value;
        if (object == null) {
            object = NullSurrogateKt.NULL;
        }
        return new StateFlowImpl(object);
    }

    public static final <T> T updateAndGet(@NotNull MutableStateFlow<T> $this$updateAndGet, @NotNull Function1<? super T, ? extends T> function) {
        Object nextValue;
        T prevValue;
        boolean $i$f$updateAndGet = false;
        while (!$this$updateAndGet.compareAndSet(prevValue = $this$updateAndGet.getValue(), nextValue = function.invoke(prevValue))) {
        }
        return (T)nextValue;
    }

    public static final <T> T getAndUpdate(@NotNull MutableStateFlow<T> $this$getAndUpdate, @NotNull Function1<? super T, ? extends T> function) {
        Object nextValue;
        T prevValue;
        boolean $i$f$getAndUpdate = false;
        while (!$this$getAndUpdate.compareAndSet(prevValue = $this$getAndUpdate.getValue(), nextValue = function.invoke(prevValue))) {
        }
        return prevValue;
    }

    public static final <T> void update(@NotNull MutableStateFlow<T> $this$update, @NotNull Function1<? super T, ? extends T> function) {
        Object nextValue;
        T prevValue;
        boolean $i$f$update = false;
        while (!$this$update.compareAndSet(prevValue = $this$update.getValue(), nextValue = function.invoke(prevValue))) {
        }
    }

    @NotNull
    public static final <T> Flow<T> fuseStateFlow(@NotNull StateFlow<? extends T> $this$fuseStateFlow, @NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(capacity != -1)) {
                throw new AssertionError();
            }
        }
        boolean bl = 0 <= capacity ? capacity < 2 : false;
        if ((bl || capacity == -2) && onBufferOverflow == BufferOverflow.DROP_OLDEST) {
            return $this$fuseStateFlow;
        }
        return SharedFlowKt.fuseSharedFlow((SharedFlow)$this$fuseStateFlow, context, capacity, onBufferOverflow);
    }

    public static final /* synthetic */ Symbol access$getNONE$p() {
        return NONE;
    }

    public static final /* synthetic */ Symbol access$getPENDING$p() {
        return PENDING;
    }
}

