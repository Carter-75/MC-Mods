/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\f\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"", "", "checkParallelism", "(I)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int $this$checkParallelism) {
        if (!($this$checkParallelism >= 1)) {
            boolean bl = false;
            String string = "Expected positive parallelism level, but got " + $this$checkParallelism;
            throw new IllegalArgumentException(string.toString());
        }
    }
}

