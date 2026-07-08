/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.Waiter;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lkotlinx/coroutines/channels/WaiterEB;", "", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/Waiter;", "waiter", "Lkotlinx/coroutines/Waiter;", "<init>", "(Lkotlinx/coroutines/Waiter;)V", "kotlinx-coroutines-core"})
final class WaiterEB {
    @JvmField
    @NotNull
    public final Waiter waiter;

    public WaiterEB(@NotNull Waiter waiter) {
        this.waiter = waiter;
    }

    @NotNull
    public String toString() {
        return "WaiterEB(" + this.waiter + ')';
    }
}

