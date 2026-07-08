/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2={"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "", "state", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "", "isActive", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "list", "<init>", "()V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1454:1\n341#2,6:1455\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n*L\n1364#1:1455,6\n*E\n"})
public final class NodeList
extends LockFreeLinkedListHead
implements Incomplete {
    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    @NotNull
    public NodeList getList() {
        return this;
    }

    @NotNull
    public final String getString(@NotNull String state) {
        StringBuilder stringBuilder;
        StringBuilder $this$getString_u24lambda_u241 = stringBuilder = new StringBuilder();
        boolean bl = false;
        $this$getString_u24lambda_u241.append("List{");
        $this$getString_u24lambda_u241.append(state);
        $this$getString_u24lambda_u241.append("}[");
        boolean first2 = false;
        first2 = true;
        LockFreeLinkedListHead this_$iv = this;
        boolean $i$f$forEach = false;
        Object object = this_$iv.getNext();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode cur$iv = (LockFreeLinkedListNode)object;
        while (!Intrinsics.areEqual((Object)cur$iv, (Object)this_$iv)) {
            if (cur$iv instanceof JobNode) {
                JobNode node = (JobNode)cur$iv;
                boolean bl2 = false;
                if (first2) {
                    first2 = false;
                } else {
                    $this$getString_u24lambda_u241.append(", ");
                }
                $this$getString_u24lambda_u241.append(node);
            }
            cur$iv = cur$iv.getNextNode();
        }
        $this$getString_u24lambda_u241.append("]");
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override
    @NotNull
    public String toString() {
        return DebugKt.getDEBUG() ? this.getString("Active") : super.toString();
    }
}

