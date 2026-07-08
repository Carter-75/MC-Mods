/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"T", "Lkotlin/coroutines/Continuation;", "completion", "probeCoroutineCreated", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"})
public final class ProbesSupportKt {
    @NotNull
    public static final <T> Continuation<T> probeCoroutineCreated(@NotNull Continuation<? super T> completion) {
        boolean $i$f$probeCoroutineCreated = false;
        return DebugProbesKt.probeCoroutineCreated(completion);
    }
}

