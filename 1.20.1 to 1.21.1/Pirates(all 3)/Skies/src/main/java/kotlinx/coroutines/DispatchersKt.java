/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0014\u0010\u0001\u001a\u00020\u00008\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u001e\u0010\t\u001a\u00020\u0004*\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2={"", "IO_PARALLELISM_PROPERTY_NAME", "Ljava/lang/String;", "Lkotlinx/coroutines/Dispatchers;", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "(Lkotlinx/coroutines/Dispatchers;)Lkotlinx/coroutines/CoroutineDispatcher;", "getIO$annotations", "(Lkotlinx/coroutines/Dispatchers;)V", "IO", "kotlinx-coroutines-core"})
public final class DispatchersKt {
    @NotNull
    public static final String IO_PARALLELISM_PROPERTY_NAME = "kotlinx.coroutines.io.parallelism";

    public static final /* synthetic */ CoroutineDispatcher getIO(Dispatchers $this$IO) {
        return Dispatchers.getIO();
    }

    @Deprecated(message="Should not be used directly", level=DeprecationLevel.HIDDEN)
    public static /* synthetic */ void getIO$annotations(Dispatchers dispatchers) {
    }
}

