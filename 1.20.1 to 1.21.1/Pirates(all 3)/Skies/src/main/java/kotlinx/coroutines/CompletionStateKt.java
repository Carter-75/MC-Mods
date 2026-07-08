/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001aK\u0010\u000f\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a0\u0010\u000f\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2={"T", "", "state", "Lkotlin/coroutines/Continuation;", "uCont", "Lkotlin/Result;", "recoverResult", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", "toState", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "caller", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCompletionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n+ 2 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,67:1\n61#2,2:68\n61#2,2:70\n*S KotlinDebug\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n*L\n21#1:68,2\n27#1:70,2\n*E\n"})
public final class CompletionStateKt {
    @Nullable
    public static final <T> Object toState(@NotNull Object $this$toState, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        Object object;
        Object object2 = $this$toState;
        Throwable throwable = Result.exceptionOrNull-impl((Object)object2);
        if (throwable == null) {
            Object it = object2;
            boolean bl = false;
            object = onCancellation != null ? new CompletedWithCancellation(it, onCancellation) : it;
        } else {
            Throwable it = throwable;
            boolean bl = false;
            object = new CompletedExceptionally(it, false, 2, null);
        }
        return object;
    }

    public static /* synthetic */ Object toState$default(Object object, Function1 function1, int n2, Object object2) {
        if ((n2 & 1) != 0) {
            function1 = null;
        }
        return CompletionStateKt.toState(object, (Function1<? super Throwable, Unit>)function1);
    }

    @Nullable
    public static final <T> Object toState(@NotNull Object $this$toState, @NotNull CancellableContinuation<?> caller) {
        Object object;
        Object object2 = $this$toState;
        Throwable throwable = Result.exceptionOrNull-impl((Object)object2);
        if (throwable == null) {
            Object it = object2;
            boolean bl = false;
            object = it;
        } else {
            Throwable it = throwable;
            boolean bl = false;
            boolean $i$f$recoverStackTrace = false;
            object = new CompletedExceptionally(!DebugKt.getRECOVER_STACK_TRACES() || !((Continuation)caller instanceof CoroutineStackFrame) ? it : StackTraceRecoveryKt.access$recoverFromStackFrame(it, (CoroutineStackFrame)caller), false, 2, null);
        }
        return object;
    }

    @NotNull
    public static final <T> Object recoverResult(@Nullable Object state, @NotNull Continuation<? super T> uCont) {
        Object object;
        if (state instanceof CompletedExceptionally) {
            Throwable exception$iv = ((CompletedExceptionally)state).cause;
            boolean $i$f$recoverStackTrace = false;
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)(!DebugKt.getRECOVER_STACK_TRACES() || !(uCont instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)uCont))));
        } else {
            object = Result.constructor-impl((Object)state);
        }
        return object;
    }
}

