/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\b\u00a2\u0006\u0004\b\u0006\u0010\u0007*\u0010\b\u0007\u0010\t\"\u00020\u00012\u00020\u0001B\u0002\b\b\u00a8\u0006\n"}, d2={"T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "lock", "Lkotlin/Function0;", "block", "synchronizedImpl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlinx/coroutines/InternalCoroutinesApi;", "SynchronizedObject", "kotlinx-coroutines-core"})
public final class SynchronizedKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @InternalCoroutinesApi
    public static final <T> T synchronizedImpl(@NotNull Object lock, @NotNull Function0<? extends T> block) {
        boolean $i$f$synchronizedImpl = false;
        Object object = lock;
        synchronized (object) {
            Object object2;
            try {
                object2 = block.invoke();
            }
            finally {
                InlineMarker.finallyStart((int)1);
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl10 : MonitorExitStatement: MONITOREXIT : var3_3
                InlineMarker.finallyEnd((int)1);
            }
            return (T)object2;
        }
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void SynchronizedObject$annotations() {
    }
}

