/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines.stream;

import java.util.stream.Stream;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.stream.StreamFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"T", "Ljava/util/stream/Stream;", "Lkotlinx/coroutines/flow/Flow;", "consumeAsFlow", "(Ljava/util/stream/Stream;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"})
public final class StreamKt {
    @NotNull
    public static final <T> Flow<T> consumeAsFlow(@NotNull Stream<T> $this$consumeAsFlow) {
        return new StreamFlow<T>($this$consumeAsFlow);
    }
}

