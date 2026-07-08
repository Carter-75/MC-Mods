/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.NodeList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "", "toString", "()Ljava/lang/String;", "", "isActive", "()Z", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "<init>", "(Lkotlinx/coroutines/NodeList;)V", "kotlinx-coroutines-core"})
public final class InactiveNodeList
implements Incomplete {
    @NotNull
    private final NodeList list;

    public InactiveNodeList(@NotNull NodeList list) {
        this.list = list;
    }

    @Override
    @NotNull
    public NodeList getList() {
        return this.list;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @NotNull
    public String toString() {
        return DebugKt.getDEBUG() ? this.getList().getString("New") : super.toString();
    }
}

