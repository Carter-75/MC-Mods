/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
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
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutinesInternalError;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTaskKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u0011\b\u0000\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b$\u0010%J!\u0010\u000b\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0010\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0010\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0010\u00a2\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0017\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0004H \u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8 X\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006&"}, d2={"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "handleFatalException", "run", "()V", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "I", "<init>", "(I)V", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n1#2:223\n107#3,10:224\n118#3,2:238\n220#4:234\n221#4:237\n61#5,2:235\n75#6:240\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n*L\n90#1:224,10\n90#1:238,2\n103#1:234\n103#1:237\n103#1:235,2\n142#1:240\n*E\n"})
public abstract class DispatchedTask<T>
extends Task {
    @JvmField
    public int resumeMode;

    public DispatchedTask(int resumeMode) {
        this.resumeMode = resumeMode;
    }

    @NotNull
    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    @Nullable
    public abstract Object takeState$kotlinx_coroutines_core();

    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object takenState, @NotNull Throwable cause) {
    }

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object state) {
        return (T)state;
    }

    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object state) {
        CompletedExceptionally completedExceptionally = state instanceof CompletedExceptionally ? (CompletedExceptionally)state : null;
        return completedExceptionally != null ? completedExceptionally.cause : null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void run() {
        Object $this$run_u24lambda_u242;
        Object continuation22222;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.taskContext;
        Throwable fatalException = null;
        try {
            Continuation<T> continuation = this.getDelegate$kotlinx_coroutines_core();
            Intrinsics.checkNotNull(continuation, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            DispatchedContinuation delegate = (DispatchedContinuation)continuation;
            continuation22222 = delegate.continuation;
            Object countOrElement$iv = delegate.countOrElement;
            boolean $i$f$withContinuationContext = false;
            CoroutineContext context$iv = continuation22222.getContext();
            Object oldValue$iv = ThreadContextKt.updateThreadContext(context$iv, countOrElement$iv);
            UndispatchedCoroutine<?> undispatchedCompletion$iv = oldValue$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation22222, context$iv, oldValue$iv) : null;
            try {
                Job job;
                boolean bl = false;
                CoroutineContext context = continuation22222.getContext();
                Object state = this.takeState$kotlinx_coroutines_core();
                Throwable exception = this.getExceptionalResult$kotlinx_coroutines_core(state);
                Job job2 = job = exception == null && DispatchedTaskKt.isCancellableMode(this.resumeMode) ? (Job)context.get((CoroutineContext.Key)Job.Key) : null;
                if (job != null && !job.isActive()) {
                    CancellationException cause = job.getCancellationException();
                    this.cancelCompletedResult$kotlinx_coroutines_core(state, cause);
                    Continuation $this$resumeWithStackTrace$iv = continuation22222;
                    boolean $i$f$resumeWithStackTrace = false;
                    boolean $i$f$recoverStackTrace = false;
                    $this$resumeWithStackTrace$iv.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)(!DebugKt.getRECOVER_STACK_TRACES() || !($this$resumeWithStackTrace$iv instanceof CoroutineStackFrame) ? (Throwable)cause : StackTraceRecoveryKt.access$recoverFromStackFrame(cause, (CoroutineStackFrame)$this$resumeWithStackTrace$iv)))));
                } else if (exception != null) {
                    continuation22222.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)exception)));
                } else {
                    continuation22222.resumeWith(Result.constructor-impl(this.getSuccessfulResult$kotlinx_coroutines_core(state)));
                }
                Unit unit = Unit.INSTANCE;
            }
            finally {
                if (undispatchedCompletion$iv == null || undispatchedCompletion$iv.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context$iv, oldValue$iv);
                }
            }
            continuation22222 = this;
        }
        catch (Throwable e2) {
            try {
                fatalException = e2;
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
                Object object;
                DispatchedTask continuation22222 = this;
                try {
                    DispatchedTask $this$run_u24lambda_u2422 = continuation22222;
                    boolean bl = false;
                    taskContext.afterTask();
                    object = Result.constructor-impl((Object)Unit.INSTANCE);
                }
                catch (Throwable bl) {
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
                }
                Object result3 = object;
                this.handleFatalException$kotlinx_coroutines_core(fatalException, Result.exceptionOrNull-impl((Object)result3));
            }
        }
        try {
            $this$run_u24lambda_u242 = (DispatchedTask)continuation22222;
            boolean bl = false;
            taskContext.afterTask();
            $this$run_u24lambda_u242 = Result.constructor-impl((Object)Unit.INSTANCE);
        }
        catch (Throwable bl) {
            $this$run_u24lambda_u242 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
        }
        Object result2 = $this$run_u24lambda_u242;
        this.handleFatalException$kotlinx_coroutines_core(fatalException, Result.exceptionOrNull-impl((Object)result2));
    }

    public final void handleFatalException$kotlinx_coroutines_core(@Nullable Throwable exception, @Nullable Throwable finallyException) {
        Throwable throwable;
        if (exception == null && finallyException == null) {
            return;
        }
        if (exception != null && finallyException != null) {
            Throwable $this$addSuppressedThrowable$iv = exception;
            boolean $i$f$addSuppressedThrowable = false;
            ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable$iv, (Throwable)finallyException);
        }
        if ((throwable = exception) == null) {
            throwable = finallyException;
        }
        Throwable cause = throwable;
        String string = "Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
        Throwable throwable2 = cause;
        Intrinsics.checkNotNull((Object)throwable2);
        CoroutinesInternalError reason = new CoroutinesInternalError(string, throwable2);
        CoroutineExceptionHandlerKt.handleCoroutineException(this.getDelegate$kotlinx_coroutines_core().getContext(), reason);
    }
}

