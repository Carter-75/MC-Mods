/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.Volatile
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CompletedExceptionally;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u000b\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlinx/coroutines/CompletedExceptionally;", "", "makeResumed", "()Z", "Lkotlinx/atomicfu/AtomicBoolean;", "_resumed", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "kotlinx-coroutines-core"})
public final class CancelledContinuation
extends CompletedExceptionally {
    @Volatile
    private volatile int _resumed;
    @NotNull
    private static final AtomicIntegerFieldUpdater _resumed$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed");

    public CancelledContinuation(@NotNull Continuation<?> continuation, @Nullable Throwable cause, boolean handled) {
        Throwable throwable = cause;
        if (throwable == null) {
            throwable = new CancellationException("Continuation " + continuation + " was cancelled normally");
        }
        super(throwable, handled);
        this._resumed = 0;
    }

    public final boolean makeResumed() {
        return _resumed$FU.compareAndSet(this, 0, 1);
    }
}

