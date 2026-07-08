/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.Empty;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.IncompleteStateBox;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0002\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00048\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0006\"\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0006\"\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0014"}, d2={"", "boxIncomplete", "(Ljava/lang/Object;)Ljava/lang/Object;", "unboxState", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_RETRY", "COMPLETING_WAITING_CHILDREN", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_NEW", "", "FALSE", "I", "RETRY", "SEALED", "TOO_LATE_TO_CANCEL", "TRUE", "kotlinx-coroutines-core"})
public final class JobSupportKt {
    @NotNull
    private static final Symbol COMPLETING_ALREADY = new Symbol("COMPLETING_ALREADY");
    @JvmField
    @NotNull
    public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
    @NotNull
    private static final Symbol COMPLETING_RETRY = new Symbol("COMPLETING_RETRY");
    @NotNull
    private static final Symbol TOO_LATE_TO_CANCEL = new Symbol("TOO_LATE_TO_CANCEL");
    private static final int RETRY = -1;
    private static final int FALSE = 0;
    private static final int TRUE = 1;
    @NotNull
    private static final Symbol SEALED = new Symbol("SEALED");
    @NotNull
    private static final Empty EMPTY_NEW = new Empty(false);
    @NotNull
    private static final Empty EMPTY_ACTIVE = new Empty(true);

    @Nullable
    public static final Object boxIncomplete(@Nullable Object $this$boxIncomplete) {
        return $this$boxIncomplete instanceof Incomplete ? new IncompleteStateBox((Incomplete)$this$boxIncomplete) : $this$boxIncomplete;
    }

    @Nullable
    public static final Object unboxState(@Nullable Object $this$unboxState) {
        Object object = $this$unboxState instanceof IncompleteStateBox ? (IncompleteStateBox)$this$unboxState : null;
        if (object == null || (object = ((IncompleteStateBox)object).state) == null) {
            object = $this$unboxState;
        }
        return object;
    }

    public static final /* synthetic */ Empty access$getEMPTY_ACTIVE$p() {
        return EMPTY_ACTIVE;
    }

    public static final /* synthetic */ Empty access$getEMPTY_NEW$p() {
        return EMPTY_NEW;
    }

    public static final /* synthetic */ Symbol access$getCOMPLETING_ALREADY$p() {
        return COMPLETING_ALREADY;
    }

    public static final /* synthetic */ Symbol access$getTOO_LATE_TO_CANCEL$p() {
        return TOO_LATE_TO_CANCEL;
    }

    public static final /* synthetic */ Symbol access$getCOMPLETING_RETRY$p() {
        return COMPLETING_RETRY;
    }

    public static final /* synthetic */ Symbol access$getSEALED$p() {
        return SEALED;
    }
}

