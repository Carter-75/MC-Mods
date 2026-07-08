/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.JobSupportKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u001f\u0012\u0006\u00103\u001a\u00020(\u0012\u0006\u00104\u001a\u00020\u0016\u0012\u0006\u00105\u001a\u00020\u0016\u00a2\u0006\u0004\b6\u00107J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u000bH\u0010\u00a2\u0006\u0004\b\u0013\u0010\rJ\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u001b\u0010\nJ\u0019\u0010\u001c\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0004\u00a2\u0006\u0004\b\u001c\u0010\nJ\u001e\u0010\u001f\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\nJO\u0010\"\u001a\u00020\b\"\u0004\b\u0001\u0010 2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00028\u00012'\u0010&\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060$\u00a2\u0006\u0002\b%\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010'R\u001d\u0010)\u001a\u00020(8\u0006\u00a2\u0006\u0012\n\u0004\b)\u0010*\u0012\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010,R\u0014\u00101\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "", "state", "", "afterResume", "(Ljava/lang/Object;)V", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "handleOnCompletionException", "nameString$kotlinx_coroutines_core", "nameString", "cause", "", "handled", "onCancelled", "(Ljava/lang/Throwable;Z)V", "value", "onCompleted", "onCompletionInternal", "Lkotlin/Result;", "result", "resumeWith", "R", "Lkotlinx/coroutines/CoroutineStart;", "start", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "block", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContext$annotations", "()V", "getCoroutineContext", "coroutineContext", "isActive", "()Z", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
public abstract class AbstractCoroutine<T>
extends JobSupport
implements Job,
Continuation<T>,
CoroutineScope {
    @NotNull
    private final CoroutineContext context;

    public AbstractCoroutine(@NotNull CoroutineContext parentContext, boolean initParentJob, boolean active) {
        super(active);
        if (initParentJob) {
            this.initParentJob((Job)parentContext.get((CoroutineContext.Key)Job.Key));
        }
        this.context = parentContext.plus((CoroutineContext)this);
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.context;
    }

    public static /* synthetic */ void getContext$annotations() {
    }

    @Override
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    protected void onCompleted(T value) {
    }

    protected void onCancelled(@NotNull Throwable cause, boolean handled) {
    }

    @Override
    @NotNull
    protected String cancellationExceptionMessage() {
        return DebugStringsKt.getClassSimpleName(this) + " was cancelled";
    }

    @Override
    protected final void onCompletionInternal(@Nullable Object state) {
        if (state instanceof CompletedExceptionally) {
            this.onCancelled(((CompletedExceptionally)state).cause, ((CompletedExceptionally)state).getHandled());
        } else {
            this.onCompleted(state);
        }
    }

    public final void resumeWith(@NotNull Object result2) {
        Object state = this.makeCompletingOnce$kotlinx_coroutines_core(CompletionStateKt.toState$default(result2, null, 1, null));
        if (state == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        this.afterResume(state);
    }

    protected void afterResume(@Nullable Object state) {
        this.afterCompletion(state);
    }

    @Override
    public final void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable exception) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, exception);
    }

    @Override
    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        String string = CoroutineContextKt.getCoroutineName(this.context);
        if (string == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        String coroutineName = string;
        return '\"' + coroutineName + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    public final <R> void start(@NotNull CoroutineStart start, R receiver, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        start.invoke(block, receiver, this);
    }
}

