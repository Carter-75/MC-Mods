/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugStringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u000b\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0004\u00a8\u0006\u0011"}, d2={"Lkotlinx/coroutines/CompletedExceptionally;", "", "", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Lkotlinx/atomicfu/AtomicBoolean;", "_handled", "", "cause", "Ljava/lang/Throwable;", "getHandled", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "kotlinx-coroutines-core"})
public class CompletedExceptionally {
    @JvmField
    @NotNull
    public final Throwable cause;
    @Volatile
    private volatile int _handled;
    @NotNull
    private static final AtomicIntegerFieldUpdater _handled$FU = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled");

    public CompletedExceptionally(@NotNull Throwable cause, boolean handled) {
        this.cause = cause;
        this._handled = handled ? 1 : 0;
    }

    public /* synthetic */ CompletedExceptionally(Throwable throwable, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        this(throwable, bl);
    }

    public final boolean getHandled() {
        return _handled$FU.get(this) != 0;
    }

    public final boolean makeHandled() {
        return _handled$FU.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '[' + this.cause + ']';
    }
}

