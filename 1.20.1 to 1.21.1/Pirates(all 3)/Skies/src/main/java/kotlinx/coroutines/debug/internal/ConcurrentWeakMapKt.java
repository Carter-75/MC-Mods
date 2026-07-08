/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.Marked;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000$\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\u0015\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\"\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\t\"\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"", "noImpl", "()Ljava/lang/Void;", "", "Lkotlinx/coroutines/debug/internal/Marked;", "mark", "(Ljava/lang/Object;)Lkotlinx/coroutines/debug/internal/Marked;", "", "MAGIC", "I", "MARKED_NULL", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_TRUE", "MIN_CAPACITY", "Lkotlinx/coroutines/internal/Symbol;", "REHASH", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"})
public final class ConcurrentWeakMapKt {
    private static final int MAGIC = -1640531527;
    private static final int MIN_CAPACITY = 16;
    @NotNull
    private static final Symbol REHASH = new Symbol("REHASH");
    @NotNull
    private static final Marked MARKED_NULL = new Marked(null);
    @NotNull
    private static final Marked MARKED_TRUE = new Marked(true);

    private static final Marked mark(Object $this$mark) {
        Object object = $this$mark;
        return object == null ? MARKED_NULL : (Intrinsics.areEqual((Object)object, (Object)true) ? MARKED_TRUE : new Marked($this$mark));
    }

    private static final Void noImpl() {
        throw new UnsupportedOperationException("not implemented");
    }

    public static final /* synthetic */ Symbol access$getREHASH$p() {
        return REHASH;
    }

    public static final /* synthetic */ Marked access$mark(Object $receiver) {
        return ConcurrentWeakMapKt.mark($receiver);
    }

    public static final /* synthetic */ Void access$noImpl() {
        return ConcurrentWeakMapKt.noImpl();
    }
}

