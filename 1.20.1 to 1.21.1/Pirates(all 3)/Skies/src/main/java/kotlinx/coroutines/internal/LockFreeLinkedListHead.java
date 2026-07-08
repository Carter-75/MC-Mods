/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u000fJ4\u0010\u0007\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0003\u0018\u0001*\u00060\u0001j\u0002`\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\b\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0016"}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "T", "Lkotlin/Function1;", "", "block", "forEach", "(Lkotlin/jvm/functions/Function1;)V", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "remove", "()Ljava/lang/Void;", "validate$kotlinx_coroutines_core", "()V", "validate", "", "isEmpty", "()Z", "isRemoved", "<init>", "kotlinx-coroutines-core"})
public class LockFreeLinkedListHead
extends LockFreeLinkedListNode {
    public final boolean isEmpty() {
        return this.getNext() == this;
    }

    public final /* synthetic */ <T extends LockFreeLinkedListNode> void forEach(Function1<? super T, Unit> block) {
        boolean $i$f$forEach = false;
        Object object = this.getNext();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode cur = (LockFreeLinkedListNode)object;
        while (!Intrinsics.areEqual((Object)cur, (Object)this)) {
            Intrinsics.reifiedOperationMarker((int)3, (String)"T");
            if (cur instanceof LockFreeLinkedListNode) {
                block.invoke((Object)cur);
            }
            cur = cur.getNextNode();
        }
    }

    @NotNull
    public final Void remove() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    @Override
    public boolean isRemoved() {
        return false;
    }

    @Override
    @Nullable
    protected LockFreeLinkedListNode nextIfRemoved() {
        return null;
    }

    public final void validate$kotlinx_coroutines_core() {
        LockFreeLinkedListNode prev2 = this;
        Object object = this.getNext();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode cur = (LockFreeLinkedListNode)object;
        while (!Intrinsics.areEqual((Object)cur, (Object)this)) {
            LockFreeLinkedListNode next = cur.getNextNode();
            cur.validateNode$kotlinx_coroutines_core(prev2, next);
            prev2 = cur;
            cur = next;
        }
        Object object2 = this.getNext();
        Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        this.validateNode$kotlinx_coroutines_core(prev2, (LockFreeLinkedListNode)object2);
    }
}

