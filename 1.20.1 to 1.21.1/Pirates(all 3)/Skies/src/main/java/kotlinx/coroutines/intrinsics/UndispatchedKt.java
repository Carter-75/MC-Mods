/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0082\b\u00a2\u0006\u0004\b\u0007\u0010\b\u001a@\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001aT\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f2\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u000e\u001a@\u0010\u000f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\n\u001a[\u0010\u0012\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\r\u001a\u00028\u00012'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f\u00a2\u0006\u0002\b\u0011H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a[\u0010\u0014\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\r\u001a\u00028\u00012'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f\u00a2\u0006\u0002\b\u0011H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0013\u001aF\u0010\u001a\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00102\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00032\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0018H\u0082\b\u00a2\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2={"T", "Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/Function1;", "", "block", "", "startDirect", "(Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "startUndispatchedOrReturn", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "", "", "shouldThrow", "Lkotlin/Function0;", "startBlock", "undispatchedResult", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nUndispatched.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n+ 2 ProbesSupport.kt\nkotlinx/coroutines/internal/ProbesSupportKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,127:1\n55#1:128\n56#1,11:130\n55#1:141\n56#1,2:143\n58#1,9:150\n55#1:159\n56#1,2:161\n58#1,9:168\n97#1,4:178\n114#1,6:182\n120#1,5:190\n97#1,4:195\n114#1,6:199\n120#1,5:207\n11#2:129\n11#2:142\n11#2:160\n11#2:177\n95#3,5:145\n95#3,5:163\n61#4,2:188\n61#4,2:205\n61#4,2:212\n61#4,2:214\n*S KotlinDebug\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n*L\n18#1:128\n18#1:130,11\n29#1:141\n29#1:143,2\n29#1:150,9\n42#1:159\n42#1:161,2\n42#1:168,9\n77#1:178,4\n77#1:182,6\n77#1:190,5\n88#1:195,4\n88#1:199,6\n88#1:207,5\n18#1:129\n29#1:142\n42#1:160\n55#1:177\n30#1:145,5\n43#1:163,5\n77#1:188,2\n88#1:205,2\n119#1:212,2\n120#1:214,2\n*E\n"})
public final class UndispatchedKt {
    public static final <T> void startCoroutineUnintercepted(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $this$startCoroutineUnintercepted, @NotNull Continuation<? super T> completion) {
        block3: {
            Object object;
            boolean $i$f$startDirect = false;
            boolean $i$f$probeCoroutineCreated = false;
            Continuation actualCompletion$iv = DebugProbesKt.probeCoroutineCreated(completion);
            try {
                Continuation actualCompletion = actualCompletion$iv;
                boolean bl = false;
                object = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUnintercepted, (int)1)).invoke((Object)actualCompletion);
            }
            catch (Throwable e$iv) {
                actualCompletion$iv.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)e$iv)));
                break block3;
            }
            Object value$iv = object;
            if (value$iv != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                actualCompletion$iv.resumeWith(Result.constructor-impl((Object)value$iv));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public static final <T> void startCoroutineUndispatched(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $this$startCoroutineUndispatched, @NotNull Continuation<? super T> completion) {
        block7: {
            Object object;
            boolean $i$f$startDirect = false;
            boolean $i$f$probeCoroutineCreated = false;
            Continuation actualCompletion$iv = DebugProbesKt.probeCoroutineCreated(completion);
            try {
                Object object2;
                void context$iv;
                Continuation actualCompletion = actualCompletion$iv;
                boolean bl = false;
                CoroutineContext coroutineContext = completion.getContext();
                Object countOrElement$iv = null;
                boolean $i$f$withCoroutineContext = false;
                Object oldValue$iv = ThreadContextKt.updateThreadContext((CoroutineContext)context$iv, countOrElement$iv);
                try {
                    boolean bl2 = false;
                    object2 = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUndispatched, (int)1)).invoke((Object)actualCompletion);
                }
                finally {
                    ThreadContextKt.restoreThreadContext((CoroutineContext)context$iv, oldValue$iv);
                }
                object = object2;
            }
            catch (Throwable e$iv) {
                actualCompletion$iv.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)e$iv)));
                break block7;
            }
            Object value$iv = object;
            if (value$iv != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                actualCompletion$iv.resumeWith(Result.constructor-impl((Object)value$iv));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public static final <R, T> void startCoroutineUndispatched(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineUndispatched, R receiver, @NotNull Continuation<? super T> completion) {
        block7: {
            Object object;
            boolean $i$f$startDirect = false;
            boolean $i$f$probeCoroutineCreated = false;
            Continuation actualCompletion$iv = DebugProbesKt.probeCoroutineCreated(completion);
            try {
                Object object2;
                void context$iv;
                Continuation actualCompletion = actualCompletion$iv;
                boolean bl = false;
                CoroutineContext coroutineContext = completion.getContext();
                Object countOrElement$iv = null;
                boolean $i$f$withCoroutineContext = false;
                Object oldValue$iv = ThreadContextKt.updateThreadContext((CoroutineContext)context$iv, countOrElement$iv);
                try {
                    boolean bl2 = false;
                    object2 = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUndispatched, (int)2)).invoke(receiver, (Object)actualCompletion);
                }
                finally {
                    ThreadContextKt.restoreThreadContext((CoroutineContext)context$iv, oldValue$iv);
                }
                object = object2;
            }
            catch (Throwable e$iv) {
                actualCompletion$iv.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)e$iv)));
                break block7;
            }
            Object value$iv = object;
            if (value$iv != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                actualCompletion$iv.resumeWith(Result.constructor-impl((Object)value$iv));
            }
        }
    }

    private static final <T> void startDirect(Continuation<? super T> completion, Function1<? super Continuation<? super T>, ? extends Object> block) {
        Object object;
        boolean $i$f$startDirect = false;
        boolean $i$f$probeCoroutineCreated = false;
        Continuation actualCompletion = DebugProbesKt.probeCoroutineCreated(completion);
        try {
            object = block.invoke((Object)actualCompletion);
        }
        catch (Throwable e2) {
            actualCompletion.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)e2)));
            return;
        }
        Object value = object;
        if (value != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            actualCompletion.resumeWith(Result.constructor-impl((Object)value));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final <T, R> Object startUndispatchedOrReturn(@NotNull ScopeCoroutine<? super T> $this$startUndispatchedOrReturn, R receiver, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        Object object;
        Object object2;
        ScopeCoroutine<T> $this$undispatchedResult$iv = $this$startUndispatchedOrReturn;
        boolean $i$f$undispatchedResult = false;
        try {
            boolean bl = false;
            object2 = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, (int)2)).invoke(receiver, (Object)$this$startUndispatchedOrReturn);
        }
        catch (Throwable e$iv) {
            object2 = new CompletedExceptionally(e$iv, false, 2, null);
        }
        CompletedExceptionally result$iv = object2;
        if (result$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        } else {
            Object state$iv = $this$undispatchedResult$iv.makeCompletingOnce$kotlinx_coroutines_core(result$iv);
            if (state$iv == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            } else if (state$iv instanceof CompletedExceptionally) {
                Throwable it = ((CompletedExceptionally)state$iv).cause;
                boolean bl = false;
                if (true) {
                    void exception$iv$iv;
                    e$iv = ((CompletedExceptionally)state$iv).cause;
                    Continuation continuation$iv$iv = $this$undispatchedResult$iv.uCont;
                    boolean $i$f$recoverStackTrace = false;
                    throw !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv$iv instanceof CoroutineStackFrame) ? exception$iv$iv : StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)exception$iv$iv, (CoroutineStackFrame)continuation$iv$iv);
                }
                if (result$iv instanceof CompletedExceptionally) {
                    Throwable exception$iv$iv = result$iv.cause;
                    Continuation continuation$iv$iv = $this$undispatchedResult$iv.uCont;
                    boolean $i$f$recoverStackTrace = false;
                    throw !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv$iv instanceof CoroutineStackFrame) ? exception$iv$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv$iv, (CoroutineStackFrame)continuation$iv$iv);
                }
                object = result$iv;
            } else {
                object = JobSupportKt.unboxState(state$iv);
            }
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(@NotNull ScopeCoroutine<? super T> $this$startUndispatchedOrReturnIgnoreTimeout, R receiver, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        Object object;
        Object object2;
        ScopeCoroutine<T> $this$undispatchedResult$iv = $this$startUndispatchedOrReturnIgnoreTimeout;
        boolean $i$f$undispatchedResult = false;
        try {
            boolean bl = false;
            object2 = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, (int)2)).invoke(receiver, (Object)$this$startUndispatchedOrReturnIgnoreTimeout);
        }
        catch (Throwable e$iv) {
            object2 = new CompletedExceptionally(e$iv, false, 2, null);
        }
        CompletedExceptionally result$iv = object2;
        if (result$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        } else {
            Object state$iv = $this$undispatchedResult$iv.makeCompletingOnce$kotlinx_coroutines_core(result$iv);
            if (state$iv == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            } else if (state$iv instanceof CompletedExceptionally) {
                Throwable e2 = ((CompletedExceptionally)state$iv).cause;
                boolean bl = false;
                if (!(e2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException)e2).coroutine != $this$startUndispatchedOrReturnIgnoreTimeout) {
                    void exception$iv$iv;
                    e$iv = ((CompletedExceptionally)state$iv).cause;
                    Continuation continuation$iv$iv = $this$undispatchedResult$iv.uCont;
                    boolean $i$f$recoverStackTrace = false;
                    throw !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv$iv instanceof CoroutineStackFrame) ? exception$iv$iv : StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)exception$iv$iv, (CoroutineStackFrame)continuation$iv$iv);
                }
                if (result$iv instanceof CompletedExceptionally) {
                    Throwable exception$iv$iv = result$iv.cause;
                    Continuation continuation$iv$iv = $this$undispatchedResult$iv.uCont;
                    boolean $i$f$recoverStackTrace = false;
                    throw !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv$iv instanceof CoroutineStackFrame) ? exception$iv$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv$iv, (CoroutineStackFrame)continuation$iv$iv);
                }
                object = result$iv;
            } else {
                object = JobSupportKt.unboxState(state$iv);
            }
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private static final <T> Object undispatchedResult(ScopeCoroutine<? super T> $this$undispatchedResult, Function1<? super Throwable, Boolean> shouldThrow, Function0<? extends Object> startBlock) {
        Object object;
        Object object2;
        boolean $i$f$undispatchedResult = false;
        try {
            object2 = startBlock.invoke();
        }
        catch (Throwable e2) {
            object2 = new CompletedExceptionally(e2, false, 2, null);
        }
        Object result2 = object2;
        if (result2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state = $this$undispatchedResult.makeCompletingOnce$kotlinx_coroutines_core(result2);
        if (state == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (state instanceof CompletedExceptionally) {
            if (((Boolean)shouldThrow.invoke((Object)((CompletedExceptionally)state).cause)).booleanValue()) {
                void exception$iv;
                e2 = ((CompletedExceptionally)state).cause;
                Continuation continuation$iv = $this$undispatchedResult.uCont;
                boolean $i$f$recoverStackTrace = false;
                throw !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)exception$iv, (CoroutineStackFrame)continuation$iv);
            }
            if (result2 instanceof CompletedExceptionally) {
                Throwable exception$iv = ((CompletedExceptionally)result2).cause;
                Continuation continuation$iv = $this$undispatchedResult.uCont;
                boolean $i$f$recoverStackTrace = false;
                throw !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)continuation$iv);
            }
            object = result2;
        } else {
            object = JobSupportKt.unboxState(state);
        }
        return object;
    }
}

