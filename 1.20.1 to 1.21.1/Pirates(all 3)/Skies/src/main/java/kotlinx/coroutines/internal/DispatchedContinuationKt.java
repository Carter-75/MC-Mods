/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aB\u0010\n\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082\b\u00a2\u0006\u0004\b\n\u0010\u000b\u001aW\u0010\u0016\u001a\u00020\b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u0019\u0010\u0018\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\b0\u0000H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\u001a8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2={"Lkotlinx/coroutines/internal/DispatchedContinuation;", "", "contState", "", "mode", "", "doYield", "Lkotlin/Function0;", "", "block", "executeUnconfined", "(Lkotlinx/coroutines/internal/DispatchedContinuation;Ljava/lang/Object;IZLkotlin/jvm/functions/Function0;)Z", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "resumeCancellableWith", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "(Lkotlinx/coroutines/internal/DispatchedContinuation;)Z", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 2 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n297#1,5:325\n302#1,12:331\n314#1:387\n301#1:389\n302#1,12:391\n314#1:420\n217#2,7:318\n224#2:346\n243#2,8:347\n225#2:355\n255#2:356\n256#2,2:367\n258#2:371\n227#2:372\n229#2:388\n1#3:330\n1#3:390\n1#3:421\n200#4,3:343\n203#4,14:373\n200#4,17:403\n200#4,17:422\n107#5,10:357\n118#5,2:369\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n*L\n282#1:325,5\n282#1:331,12\n282#1:387\n287#1:389\n287#1:391,12\n287#1:420\n282#1:318,7\n282#1:346\n282#1:347,8\n282#1:355\n282#1:356\n282#1:367,2\n282#1:371\n282#1:372\n282#1:388\n282#1:330\n287#1:390\n282#1:343,3\n282#1:373,14\n287#1:403,17\n313#1:422,17\n282#1:357,10\n282#1:369,2\n*E\n"})
public final class DispatchedContinuationKt {
    @NotNull
    private static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    @JvmField
    @NotNull
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @InternalCoroutinesApi
    public static final <T> void resumeCancellableWith(@NotNull Continuation<? super T> $this$resumeCancellableWith, @NotNull Object result2, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        if ($this$resumeCancellableWith instanceof DispatchedContinuation) {
            DispatchedContinuation this_$iv = (DispatchedContinuation)$this$resumeCancellableWith;
            boolean $i$f$resumeCancellableWith$kotlinx_coroutines_core = false;
            Object state$iv = CompletionStateKt.toState(result2, onCancellation);
            if (this_$iv.dispatcher.isDispatchNeeded(this_$iv.getContext())) {
                this_$iv._state = state$iv;
                this_$iv.resumeMode = 1;
                this_$iv.dispatcher.dispatch(this_$iv.getContext(), this_$iv);
            } else {
                void $this$executeUnconfined_u24default$iv$iv;
                DispatchedContinuation dispatchedContinuation = this_$iv;
                int mode$iv$iv = 1;
                boolean doYield$iv$iv = false;
                boolean $i$f$executeUnconfined = false;
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl = false;
                    if (!true) {
                        throw new AssertionError();
                    }
                }
                EventLoop eventLoop$iv$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
                if (eventLoop$iv$iv.isUnconfinedLoopActive()) {
                    $this$executeUnconfined_u24default$iv$iv._state = state$iv;
                    $this$executeUnconfined_u24default$iv$iv.resumeMode = mode$iv$iv;
                    eventLoop$iv$iv.dispatchUnconfined((DispatchedTask)$this$executeUnconfined_u24default$iv$iv);
                } else {
                    DispatchedTask $this$runUnconfinedEventLoop$iv$iv$iv = (DispatchedTask)$this$executeUnconfined_u24default$iv$iv;
                    boolean $i$f$runUnconfinedEventLoop = false;
                    eventLoop$iv$iv.incrementUseCount(true);
                    try {
                        boolean bl;
                        boolean bl2 = false;
                        DispatchedContinuation this_$iv$iv = this_$iv;
                        boolean $i$f$resumeCancelled$kotlinx_coroutines_core = false;
                        Continuation job$iv$iv = (Continuation)this_$iv$iv.getContext().get((CoroutineContext.Key)Job.Key);
                        if (job$iv$iv != null && !job$iv$iv.isActive()) {
                            CancellationException cause$iv$iv = job$iv$iv.getCancellationException();
                            this_$iv$iv.cancelCompletedResult$kotlinx_coroutines_core(state$iv, cause$iv$iv);
                            ((Continuation)this_$iv$iv).resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)cause$iv$iv)));
                            bl = true;
                        } else {
                            bl = false;
                        }
                        if (!bl) {
                            void continuation$iv$iv$iv;
                            this_$iv$iv = this_$iv;
                            boolean $i$f$resumeUndispatchedWith$kotlinx_coroutines_core = false;
                            job$iv$iv = this_$iv$iv.continuation;
                            Object countOrElement$iv$iv$iv = this_$iv$iv.countOrElement;
                            boolean $i$f$withContinuationContext = false;
                            CoroutineContext context$iv$iv$iv = continuation$iv$iv$iv.getContext();
                            Object oldValue$iv$iv$iv = ThreadContextKt.updateThreadContext(context$iv$iv$iv, countOrElement$iv$iv$iv);
                            UndispatchedCoroutine<?> undispatchedCompletion$iv$iv$iv = oldValue$iv$iv$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation$iv$iv$iv, context$iv$iv$iv, oldValue$iv$iv$iv) : null;
                            try {
                                boolean bl3 = false;
                                this_$iv$iv.continuation.resumeWith(result2);
                                Unit unit = Unit.INSTANCE;
                            }
                            finally {
                                if (undispatchedCompletion$iv$iv$iv == null || undispatchedCompletion$iv$iv$iv.clearThreadContext()) {
                                    ThreadContextKt.restoreThreadContext(context$iv$iv$iv, oldValue$iv$iv$iv);
                                }
                            }
                        }
                        while (eventLoop$iv$iv.processUnconfinedEvent()) {
                        }
                    }
                    catch (Throwable e$iv$iv$iv) {
                        $this$runUnconfinedEventLoop$iv$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv$iv, null);
                    }
                    finally {
                        eventLoop$iv$iv.decrementUseCount(true);
                    }
                }
            }
        } else {
            $this$resumeCancellableWith.resumeWith(result2);
        }
    }

    public static /* synthetic */ void resumeCancellableWith$default(Continuation continuation, Object object, Function1 function1, int n2, Object object2) {
        if ((n2 & 2) != 0) {
            function1 = null;
        }
        DispatchedContinuationKt.resumeCancellableWith(continuation, object, (Function1<? super Throwable, Unit>)function1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public static final boolean yieldUndispatched(@NotNull DispatchedContinuation<? super Unit> $this$yieldUndispatched) {
        void $this$executeUnconfined$iv;
        boolean bl;
        EventLoop eventLoop$iv;
        DispatchedContinuation<? super Unit> dispatchedContinuation = $this$yieldUndispatched;
        Unit unit = Unit.INSTANCE;
        boolean bl2 = true;
        boolean doYield$iv = true;
        boolean $i$f$executeUnconfined = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!true) {
                throw new AssertionError();
            }
        }
        if ((eventLoop$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core()).isUnconfinedQueueEmpty()) {
            bl = false;
        } else if (eventLoop$iv.isUnconfinedLoopActive()) {
            void mode$iv;
            void contState$iv;
            $this$executeUnconfined$iv._state = contState$iv;
            $this$executeUnconfined$iv.resumeMode = mode$iv;
            eventLoop$iv.dispatchUnconfined((DispatchedTask)$this$executeUnconfined$iv);
            bl = true;
        } else {
            DispatchedTask $this$runUnconfinedEventLoop$iv$iv = (DispatchedTask)$this$executeUnconfined$iv;
            boolean $i$f$runUnconfinedEventLoop = false;
            eventLoop$iv.incrementUseCount(true);
            try {
                boolean bl4 = false;
                $this$yieldUndispatched.run();
                while (eventLoop$iv.processUnconfinedEvent()) {
                }
            }
            catch (Throwable e$iv$iv) {
                $this$runUnconfinedEventLoop$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv, null);
            }
            finally {
                eventLoop$iv.decrementUseCount(true);
            }
            bl = false;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final boolean executeUnconfined(DispatchedContinuation<?> $this$executeUnconfined, Object contState, int mode, boolean doYield, Function0<Unit> block) {
        boolean bl;
        boolean $i$f$executeUnconfined = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(mode != -1)) {
                throw new AssertionError();
            }
        }
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (doYield && eventLoop.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop.isUnconfinedLoopActive()) {
            $this$executeUnconfined._state = contState;
            $this$executeUnconfined.resumeMode = mode;
            eventLoop.dispatchUnconfined((DispatchedTask)$this$executeUnconfined);
            bl = true;
        } else {
            DispatchedTask $this$runUnconfinedEventLoop$iv = $this$executeUnconfined;
            boolean $i$f$runUnconfinedEventLoop = false;
            eventLoop.incrementUseCount(true);
            try {
                block.invoke();
                while (eventLoop.processUnconfinedEvent()) {
                }
            }
            catch (Throwable e$iv) {
                $this$runUnconfinedEventLoop$iv.handleFatalException$kotlinx_coroutines_core(e$iv, null);
            }
            finally {
                InlineMarker.finallyStart((int)1);
                eventLoop.decrementUseCount(true);
                InlineMarker.finallyEnd((int)1);
            }
            bl = false;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation $this$executeUnconfined_u24default, Object contState, int mode, boolean doYield, Function0 block, int n2, Object object) {
        boolean bl;
        if ((n2 & 4) != 0) {
            doYield = false;
        }
        boolean $i$f$executeUnconfined = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean eventLoop = false;
            if (!(mode != -1)) {
                throw new AssertionError();
            }
        }
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (doYield && eventLoop.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop.isUnconfinedLoopActive()) {
            $this$executeUnconfined_u24default._state = contState;
            $this$executeUnconfined_u24default.resumeMode = mode;
            eventLoop.dispatchUnconfined($this$executeUnconfined_u24default);
            bl = true;
        } else {
            DispatchedTask $this$runUnconfinedEventLoop$iv = $this$executeUnconfined_u24default;
            boolean $i$f$runUnconfinedEventLoop = false;
            eventLoop.incrementUseCount(true);
            try {
                block.invoke();
                while (eventLoop.processUnconfinedEvent()) {
                }
            }
            catch (Throwable e$iv) {
                $this$runUnconfinedEventLoop$iv.handleFatalException$kotlinx_coroutines_core(e$iv, null);
            }
            finally {
                InlineMarker.finallyStart((int)1);
                eventLoop.decrementUseCount(true);
                InlineMarker.finallyEnd((int)1);
            }
            bl = false;
        }
        return bl;
    }

    public static final /* synthetic */ Symbol access$getUNDEFINED$p() {
        return UNDEFINED;
    }
}

