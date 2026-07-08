/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Removed;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u001a\u0017\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004\" \u0010\u0005\u001a\u00020\u00008\u0000X\u0081\u0004\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\f\u001a\u00020\u000b8\u0000X\u0081T\u00a2\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\n\"\u001a\u0010\u000f\u001a\u00020\u000b8\u0000X\u0081T\u00a2\u0006\f\n\u0004\b\u000f\u0010\r\u0012\u0004\b\u0010\u0010\n\"\u001a\u0010\u0011\u001a\u00020\u000b8\u0000X\u0081T\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u0012\u0004\b\u0012\u0010\n*\f\b\u0002\u0010\u0013\"\u00020\u00012\u00020\u0001\u00a8\u0006\u0014"}, d2={"", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "unwrap", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "CONDITION_FALSE", "Ljava/lang/Object;", "getCONDITION_FALSE", "()Ljava/lang/Object;", "getCONDITION_FALSE$annotations", "()V", "", "FAILURE", "I", "getFAILURE$annotations", "SUCCESS", "getSUCCESS$annotations", "UNDECIDED", "getUNDECIDED$annotations", "Node", "kotlinx-coroutines-core"})
public final class LockFreeLinkedListKt {
    public static final int UNDECIDED = 0;
    public static final int SUCCESS = 1;
    public static final int FAILURE = 2;
    @NotNull
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");

    @PublishedApi
    public static /* synthetic */ void getUNDECIDED$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSUCCESS$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getFAILURE$annotations() {
    }

    @NotNull
    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    @PublishedApi
    public static /* synthetic */ void getCONDITION_FALSE$annotations() {
    }

    @PublishedApi
    @NotNull
    public static final LockFreeLinkedListNode unwrap(@NotNull Object $this$unwrap) {
        Object object = $this$unwrap instanceof Removed ? (Removed)$this$unwrap : null;
        if (object == null || (object = ((Removed)object).ref) == null) {
            Intrinsics.checkNotNull((Object)$this$unwrap, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            object = (LockFreeLinkedListNode)$this$unwrap;
        }
        return object;
    }
}

