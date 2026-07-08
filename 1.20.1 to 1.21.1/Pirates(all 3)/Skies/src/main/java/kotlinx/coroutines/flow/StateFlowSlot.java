/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u000fJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b0\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2={"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "allocateLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlin/coroutines/Continuation;", "freeLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "()V", "takePending", "()Z", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "<init>", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,428:1\n1#2:429\n314#3,11:430\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n*L\n298#1:430,11\n*E\n"})
final class StateFlowSlot
extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    @Volatile
    @Nullable
    private volatile Object _state;
    @NotNull
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");

    @Override
    public boolean allocateLocked(@NotNull StateFlowImpl<?> flow) {
        if (_state$FU.get(this) != null) {
            return false;
        }
        _state$FU.set(this, StateFlowKt.access$getNONE$p());
        return true;
    }

    @Override
    @NotNull
    public Continuation<Unit>[] freeLocked(@NotNull StateFlowImpl<?> flow) {
        _state$FU.set(this, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final void makePending() {
        Object state;
        StateFlowSlot stateFlowSlot = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if (state == null) {
                return;
            }
            if (state == StateFlowKt.access$getPENDING$p()) {
                return;
            }
            if (state == StateFlowKt.access$getNONE$p()) {
                if (!_state$FU.compareAndSet(this, state, StateFlowKt.access$getPENDING$p())) continue;
                return;
            }
            if (_state$FU.compareAndSet(this, state, StateFlowKt.access$getNONE$p())) break;
        }
        ((Continuation)((CancellableContinuationImpl)state)).resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
    }

    public final boolean takePending() {
        Symbol symbol = _state$FU.getAndSet(this, StateFlowKt.access$getNONE$p());
        Intrinsics.checkNotNull((Object)symbol);
        Symbol state = symbol;
        boolean bl = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(!(state instanceof CancellableContinuationImpl))) {
                throw new AssertionError();
            }
        }
        return state == StateFlowKt.access$getPENDING$p();
    }

    @Nullable
    public final Object awaitPending(@NotNull Continuation<? super Unit> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl2 = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!(!(StateFlowSlot._state$FU.get(this) instanceof CancellableContinuationImpl))) {
                throw new AssertionError();
            }
        }
        if (!StateFlowSlot._state$FU.compareAndSet(this, StateFlowKt.access$getNONE$p(), cont)) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl4 = false;
                if (!(StateFlowSlot._state$FU.get(this) == StateFlowKt.access$getPENDING$p())) {
                    throw new AssertionError();
                }
            }
            ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }
}

