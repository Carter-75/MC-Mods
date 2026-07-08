/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\b\u0010\u0007J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u000eR\u000b\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004\u00a8\u0006\u0018"}, d2={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getResult", "", "tryResume", "()Z", "trySuspend", "Lkotlinx/atomicfu/AtomicInt;", "_decision", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"})
@PublishedApi
public final class DispatchedCoroutine<T>
extends ScopeCoroutine<T> {
    @Volatile
    @JvmField
    private volatile int _decision;
    @NotNull
    private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");

    public DispatchedCoroutine(@NotNull CoroutineContext context, @NotNull Continuation<? super T> uCont) {
        super(context, uCont);
    }

    private final boolean trySuspend() {
        DispatchedCoroutine dispatchedCoroutine = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = _decision$FU;
        boolean $i$f$loop$atomicfu = false;
        block4: while (true) {
            int decision = atomicfu$handler$iv.get(this);
            boolean bl = false;
            switch (decision) {
                case 0: {
                    if (!_decision$FU.compareAndSet(this, 0, 1)) continue block4;
                    return true;
                }
                case 2: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already suspended".toString());
                }
            }
            break;
        }
    }

    private final boolean tryResume() {
        DispatchedCoroutine dispatchedCoroutine = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = _decision$FU;
        boolean $i$f$loop$atomicfu = false;
        block4: while (true) {
            int decision = atomicfu$handler$iv.get(this);
            boolean bl = false;
            switch (decision) {
                case 0: {
                    if (!_decision$FU.compareAndSet(this, 0, 2)) continue block4;
                    return true;
                }
                case 1: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already resumed".toString());
                }
            }
            break;
        }
    }

    @Override
    protected void afterCompletion(@Nullable Object state) {
        this.afterResume(state);
    }

    @Override
    protected void afterResume(@Nullable Object state) {
        if (this.tryResume()) {
            return;
        }
        DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt.intercepted((Continuation)this.uCont), CompletionStateKt.recoverResult(state, this.uCont), null, 2, null);
    }

    @Nullable
    public final Object getResult$kotlinx_coroutines_core() {
        if (this.trySuspend()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        if (state instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)state).cause;
        }
        return state;
    }

    @NotNull
    public static final AtomicIntegerFieldUpdater get_decision$FU() {
        return _decision$FU;
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicfu$handler, Function1<? super Integer, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            int n2 = atomicfu$handler.get(atomicfu$dispatchReceiver);
            atomicfu$action.invoke((Object)n2);
        }
    }
}

