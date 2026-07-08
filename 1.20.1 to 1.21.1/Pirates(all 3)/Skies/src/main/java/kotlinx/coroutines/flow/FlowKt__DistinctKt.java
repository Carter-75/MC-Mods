/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__DistinctKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a[\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\n\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\u0004\b\u0002\u0010\u000b\u001a=\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001aw\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00110\r2:\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013\"*\u0010\u0014\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\t0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"$\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2={"T", "Lkotlinx/coroutines/flow/Flow;", "distinctUntilChanged", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "areEquivalent", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "K", "Lkotlin/Function1;", "keySelector", "distinctUntilChangedBy", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "", "distinctUntilChangedBy$FlowKt__DistinctKt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "defaultAreEquivalent", "Lkotlin/jvm/functions/Function2;", "defaultKeySelector", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__DistinctKt {
    @NotNull
    private static final Function1<Object, Object> defaultKeySelector = defaultKeySelector.1.INSTANCE;
    @NotNull
    private static final Function2<Object, Object, Boolean> defaultAreEquivalent = defaultAreEquivalent.1.INSTANCE;

    @NotNull
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> $this$distinctUntilChanged) {
        return $this$distinctUntilChanged instanceof StateFlow ? $this$distinctUntilChanged : FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt($this$distinctUntilChanged, defaultKeySelector, defaultAreEquivalent);
    }

    @NotNull
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> $this$distinctUntilChanged, @NotNull Function2<? super T, ? super T, Boolean> areEquivalent) {
        Intrinsics.checkNotNull(areEquivalent, (String)"null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt($this$distinctUntilChanged, defaultKeySelector, (Function2<Object, Object, Boolean>)((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(areEquivalent, (int)2)));
    }

    @NotNull
    public static final <T, K> Flow<T> distinctUntilChangedBy(@NotNull Flow<? extends T> $this$distinctUntilChangedBy, @NotNull Function1<? super T, ? extends K> keySelector) {
        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt($this$distinctUntilChangedBy, keySelector, defaultAreEquivalent);
    }

    private static final <T> Flow<T> distinctUntilChangedBy$FlowKt__DistinctKt(Flow<? extends T> $this$distinctUntilChangedBy, Function1<? super T, ? extends Object> keySelector, Function2<Object, Object, Boolean> areEquivalent) {
        return $this$distinctUntilChangedBy instanceof DistinctFlowImpl && ((DistinctFlowImpl)$this$distinctUntilChangedBy).keySelector == keySelector && ((DistinctFlowImpl)$this$distinctUntilChangedBy).areEquivalent == areEquivalent ? $this$distinctUntilChangedBy : (Flow<? extends T>)new DistinctFlowImpl<T>($this$distinctUntilChangedBy, keySelector, areEquivalent);
    }
}

