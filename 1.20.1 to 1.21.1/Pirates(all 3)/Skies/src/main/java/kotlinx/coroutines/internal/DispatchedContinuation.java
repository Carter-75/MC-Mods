/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010T\u001a\u00020S\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\bX\u0010YJ\u000f\u0010\t\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0010\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0010\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u001fH\u0000\u00a2\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b#\u0010$J\u000f\u0010'\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b&\u0010\bJH\u00100\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2%\b\b\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010*H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/J\u001a\u00104\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u00010\nH\u0080\b\u00a2\u0006\u0004\b2\u00103J!\u00107\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J \u00108\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00106J\u0011\u0010;\u001a\u0004\u0018\u00010\nH\u0010\u00a2\u0006\u0004\b9\u0010:J\u000f\u0010=\u001a\u00020<H\u0016\u00a2\u0006\u0004\b=\u0010>J\u001d\u0010C\u001a\u0004\u0018\u00010\f2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030?H\u0000\u00a2\u0006\u0004\bA\u0010BR\u0013\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0D8\u0002X\u0082\u0004R\u001e\u0010F\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e\u00a2\u0006\f\n\u0004\bF\u0010G\u0012\u0004\bH\u0010\bR\u001c\u0010K\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010\u0016\u001a\u00020\u00158\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010NR\u0014\u0010O\u001a\u00020\n8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010GR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010QR\u0014\u0010T\u001a\u00020S8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001a\u0010W\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Z"}, d2={"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "", "awaitReusability$kotlinx_coroutines_core", "()V", "awaitReusability", "", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation$kotlinx_coroutines_core", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "isReusable$kotlinx_coroutines_core", "()Z", "isReusable", "postponeCancellation$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Z", "postponeCancellation", "release$kotlinx_coroutines_core", "release", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith$kotlinx_coroutines_core", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeCancellableWith", "state", "resumeCancelled$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "resumeCancelled", "resumeUndispatchedWith$kotlinx_coroutines_core", "(Ljava/lang/Object;)V", "resumeUndispatchedWith", "resumeWith", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "tryReleaseClaimedContinuation$kotlinx_coroutines_core", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "tryReleaseClaimedContinuation", "Lkotlinx/atomicfu/AtomicRef;", "_reusableCancellableContinuation", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n243#1,8:381\n255#1:389\n256#1,2:400\n258#1:404\n1#2:318\n1#2:324\n1#2:365\n297#3,5:319\n302#3,12:325\n314#3:359\n297#3,5:360\n302#3,12:366\n314#3:419\n200#4,3:337\n203#4,14:345\n200#4,3:378\n203#4,14:405\n95#5,5:340\n107#5,10:390\n118#5,2:402\n107#5,13:420\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n*L\n224#1:381,8\n225#1:389\n225#1:400,2\n225#1:404\n202#1:324\n223#1:365\n202#1:319,5\n202#1:325,12\n202#1:359\n223#1:360,5\n223#1:366,12\n223#1:419\n202#1:337,3\n202#1:345,14\n223#1:378,3\n223#1:405,14\n203#1:340,5\n225#1:390,10\n225#1:402,2\n255#1:420,13\n*E\n"})
public final class DispatchedContinuation<T>
extends DispatchedTask<T>
implements CoroutineStackFrame,
Continuation<T> {
    @JvmField
    @NotNull
    public final CoroutineDispatcher dispatcher;
    @JvmField
    @NotNull
    public final Continuation<T> continuation;
    @JvmField
    @Nullable
    public Object _state;
    @JvmField
    @NotNull
    public final Object countOrElement;
    @Volatile
    @Nullable
    private volatile Object _reusableCancellableContinuation;
    @NotNull
    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");

    public DispatchedContinuation(@NotNull CoroutineDispatcher dispatcher, @NotNull Continuation<? super T> continuation) {
        super(-1);
        this.dispatcher = dispatcher;
        this.continuation = continuation;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(this.getContext());
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.continuation;
        return continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame)continuation : null;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    private final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object v = _reusableCancellableContinuation$FU.get(this);
        return v instanceof CancellableContinuationImpl ? (CancellableContinuationImpl)v : null;
    }

    public final boolean isReusable$kotlinx_coroutines_core() {
        return _reusableCancellableContinuation$FU.get(this) != null;
    }

    public final void awaitReusability$kotlinx_coroutines_core() {
        Object it;
        DispatchedContinuation dispatchedContinuation = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _reusableCancellableContinuation$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            it = atomicfu$handler$iv.get(this);
            boolean bl = false;
        } while (it == DispatchedContinuationKt.REUSABLE_CLAIMED);
    }

    public final void release$kotlinx_coroutines_core() {
        block0: {
            this.awaitReusability$kotlinx_coroutines_core();
            CancellableContinuationImpl<?> cancellableContinuationImpl = this.getReusableCancellableContinuation();
            if (cancellableContinuationImpl == null) break block0;
            cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
        }
    }

    @Nullable
    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation$kotlinx_coroutines_core() {
        Object state;
        DispatchedContinuation dispatchedContinuation = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _reusableCancellableContinuation$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if (state == null) {
                _reusableCancellableContinuation$FU.set(this, DispatchedContinuationKt.REUSABLE_CLAIMED);
                return null;
            }
            if (state instanceof CancellableContinuationImpl) {
                if (!_reusableCancellableContinuation$FU.compareAndSet(this, state, DispatchedContinuationKt.REUSABLE_CLAIMED)) continue;
                return (CancellableContinuationImpl)state;
            }
            if (state != DispatchedContinuationKt.REUSABLE_CLAIMED && !(state instanceof Throwable)) break;
        }
        throw new IllegalStateException(("Inconsistent state " + state).toString());
    }

    @Nullable
    public final Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core(@NotNull CancellableContinuation<?> continuation) {
        Object state;
        block3: {
            DispatchedContinuation dispatchedContinuation = this;
            AtomicReferenceFieldUpdater atomicfu$handler$iv = _reusableCancellableContinuation$FU;
            boolean $i$f$loop$atomicfu = false;
            do {
                state = atomicfu$handler$iv.get(this);
                boolean bl = false;
                if (state != DispatchedContinuationKt.REUSABLE_CLAIMED) break block3;
            } while (!_reusableCancellableContinuation$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, continuation));
            return null;
        }
        if (state instanceof Throwable) {
            if (!_reusableCancellableContinuation$FU.compareAndSet(this, state, null)) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            return (Throwable)state;
        }
        throw new IllegalStateException(("Inconsistent state " + state).toString());
    }

    public final boolean postponeCancellation$kotlinx_coroutines_core(@NotNull Throwable cause) {
        DispatchedContinuation dispatchedContinuation = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _reusableCancellableContinuation$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            Object state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            Object v = state;
            if (Intrinsics.areEqual(v, (Object)DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                if (!_reusableCancellableContinuation$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, cause)) continue;
                return true;
            }
            if (v instanceof Throwable) {
                return true;
            }
            if (_reusableCancellableContinuation$FU.compareAndSet(this, state, null)) break;
        }
        return false;
    }

    @Override
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        Object state = this._state;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(state != DispatchedContinuationKt.access$getUNDEFINED$p())) {
                throw new AssertionError();
            }
        }
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return state;
    }

    @Override
    @NotNull
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public void resumeWith(@NotNull Object result2) {
        CoroutineContext context = this.continuation.getContext();
        Object state = CompletionStateKt.toState$default(result2, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = state;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context, this);
        } else {
            void $this$executeUnconfined_u24default$iv;
            DispatchedContinuation dispatchedContinuation = this;
            int mode$iv = 0;
            boolean doYield$iv = false;
            boolean $i$f$executeUnconfined = false;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!true) {
                    throw new AssertionError();
                }
            }
            EventLoop eventLoop$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$iv.isUnconfinedLoopActive()) {
                $this$executeUnconfined_u24default$iv._state = state;
                $this$executeUnconfined_u24default$iv.resumeMode = mode$iv;
                eventLoop$iv.dispatchUnconfined((DispatchedTask)$this$executeUnconfined_u24default$iv);
            } else {
                DispatchedTask $this$runUnconfinedEventLoop$iv$iv = (DispatchedTask)$this$executeUnconfined_u24default$iv;
                boolean $i$f$runUnconfinedEventLoop = false;
                eventLoop$iv.incrementUseCount(true);
                try {
                    void context$iv;
                    boolean bl = false;
                    CoroutineContext coroutineContext = this.getContext();
                    Object countOrElement$iv = this.countOrElement;
                    boolean $i$f$withCoroutineContext = false;
                    Object oldValue$iv = ThreadContextKt.updateThreadContext((CoroutineContext)context$iv, countOrElement$iv);
                    try {
                        boolean bl2 = false;
                        this.continuation.resumeWith(result2);
                        Unit unit = Unit.INSTANCE;
                    }
                    finally {
                        ThreadContextKt.restoreThreadContext((CoroutineContext)context$iv, oldValue$iv);
                    }
                    while (eventLoop$iv.processUnconfinedEvent()) {
                    }
                }
                catch (Throwable e$iv$iv) {
                    $this$runUnconfinedEventLoop$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv, null);
                }
                finally {
                    eventLoop$iv.decrementUseCount(true);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void resumeCancellableWith$kotlinx_coroutines_core(@NotNull Object result2, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        boolean $i$f$resumeCancellableWith$kotlinx_coroutines_core = false;
        Object state = CompletionStateKt.toState(result2, onCancellation);
        if (this.dispatcher.isDispatchNeeded(this.getContext())) {
            this._state = state;
            this.resumeMode = 1;
            this.dispatcher.dispatch(this.getContext(), this);
        } else {
            void $this$executeUnconfined_u24default$iv;
            DispatchedContinuation dispatchedContinuation = this;
            int mode$iv = 1;
            boolean doYield$iv = false;
            boolean $i$f$executeUnconfined = false;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!true) {
                    throw new AssertionError();
                }
            }
            EventLoop eventLoop$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$iv.isUnconfinedLoopActive()) {
                $this$executeUnconfined_u24default$iv._state = state;
                $this$executeUnconfined_u24default$iv.resumeMode = mode$iv;
                eventLoop$iv.dispatchUnconfined((DispatchedTask)$this$executeUnconfined_u24default$iv);
            } else {
                DispatchedTask $this$runUnconfinedEventLoop$iv$iv = (DispatchedTask)$this$executeUnconfined_u24default$iv;
                boolean $i$f$runUnconfinedEventLoop = false;
                eventLoop$iv.incrementUseCount(true);
                try {
                    boolean bl;
                    boolean bl2 = false;
                    DispatchedContinuation this_$iv = this;
                    boolean $i$f$resumeCancelled$kotlinx_coroutines_core = false;
                    Continuation<T> job$iv = (Continuation<T>)this_$iv.getContext().get((CoroutineContext.Key)Job.Key);
                    if (job$iv != null && !job$iv.isActive()) {
                        CancellationException cause$iv = job$iv.getCancellationException();
                        this_$iv.cancelCompletedResult$kotlinx_coroutines_core(state, cause$iv);
                        ((Continuation)this_$iv).resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)cause$iv)));
                        bl = true;
                    } else {
                        bl = false;
                    }
                    if (!bl) {
                        void continuation$iv$iv;
                        this_$iv = this;
                        boolean $i$f$resumeUndispatchedWith$kotlinx_coroutines_core = false;
                        job$iv = this_$iv.continuation;
                        Object countOrElement$iv$iv = this_$iv.countOrElement;
                        boolean $i$f$withContinuationContext = false;
                        CoroutineContext context$iv$iv = continuation$iv$iv.getContext();
                        Object oldValue$iv$iv = ThreadContextKt.updateThreadContext(context$iv$iv, countOrElement$iv$iv);
                        UndispatchedCoroutine<?> undispatchedCompletion$iv$iv = oldValue$iv$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation$iv$iv, context$iv$iv, oldValue$iv$iv) : null;
                        try {
                            boolean bl3 = false;
                            this_$iv.continuation.resumeWith(result2);
                            Unit unit = Unit.INSTANCE;
                        }
                        finally {
                            InlineMarker.finallyStart((int)1);
                            if (undispatchedCompletion$iv$iv == null || undispatchedCompletion$iv$iv.clearThreadContext()) {
                                ThreadContextKt.restoreThreadContext(context$iv$iv, oldValue$iv$iv);
                            }
                            InlineMarker.finallyEnd((int)1);
                        }
                    }
                    while (eventLoop$iv.processUnconfinedEvent()) {
                    }
                }
                catch (Throwable e$iv$iv) {
                    $this$runUnconfinedEventLoop$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv, null);
                }
                finally {
                    InlineMarker.finallyStart((int)1);
                    eventLoop$iv.decrementUseCount(true);
                    InlineMarker.finallyEnd((int)1);
                }
            }
        }
    }

    @Override
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object takenState, @NotNull Throwable cause) {
        if (takenState instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation)takenState).onCancellation.invoke((Object)cause);
        }
    }

    public final boolean resumeCancelled$kotlinx_coroutines_core(@Nullable Object state) {
        boolean $i$f$resumeCancelled$kotlinx_coroutines_core = false;
        Job job = (Job)this.getContext().get((CoroutineContext.Key)Job.Key);
        if (job != null && !job.isActive()) {
            CancellationException cause = job.getCancellationException();
            this.cancelCompletedResult$kotlinx_coroutines_core(state, cause);
            ((Continuation)this).resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)cause)));
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void resumeUndispatchedWith$kotlinx_coroutines_core(@NotNull Object result2) {
        void continuation$iv;
        boolean $i$f$resumeUndispatchedWith$kotlinx_coroutines_core = false;
        Continuation<T> continuation = this.continuation;
        Object countOrElement$iv = this.countOrElement;
        boolean $i$f$withContinuationContext = false;
        CoroutineContext context$iv = continuation$iv.getContext();
        Object oldValue$iv = ThreadContextKt.updateThreadContext(context$iv, countOrElement$iv);
        UndispatchedCoroutine<?> undispatchedCompletion$iv = oldValue$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation$iv, context$iv, oldValue$iv) : null;
        try {
            boolean bl = false;
            this.continuation.resumeWith(result2);
            Unit unit = Unit.INSTANCE;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            if (undispatchedCompletion$iv == null || undispatchedCompletion$iv.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context$iv, oldValue$iv);
            }
            InlineMarker.finallyEnd((int)1);
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(@NotNull CoroutineContext context, T value) {
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(context, this);
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + (Object)((Object)this.dispatcher) + ", " + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }
}

