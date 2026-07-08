/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0081\b\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"", "index", "checkIndexOverflow", "(I)I", "Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Lkotlinx/coroutines/flow/FlowCollector;", "owner", "", "checkOwnership", "(Lkotlinx/coroutines/flow/internal/AbortFlowException;Lkotlinx/coroutines/flow/FlowCollector;)V", "kotlinx-coroutines-core"})
public final class FlowExceptions_commonKt {
    public static final void checkOwnership(@NotNull AbortFlowException $this$checkOwnership, @NotNull FlowCollector<?> owner) {
        if ($this$checkOwnership.owner != owner) {
            throw $this$checkOwnership;
        }
    }

    @PublishedApi
    public static final int checkIndexOverflow(int index) {
        boolean $i$f$checkIndexOverflow = false;
        if (index < 0) {
            throw new ArithmeticException("Index overflow has happened");
        }
        return index;
    }
}

