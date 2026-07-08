/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001aO\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u00a2\u0006\u0002\b\u000bH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\u0000H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0016\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0016\u001a\u00020\u0015*\u00020\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019\u00a2\u0006\u0004\b\u0016\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u00020\u0015*\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001e\"\u001b\u0010 \u001a\u00020\u001f*\u00020\u00028F\u00a2\u0006\f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2={"Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/CoroutineScope;", "CoroutineScope", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;", "MainScope", "()Lkotlinx/coroutines/CoroutineScope;", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "coroutineScope", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "message", "", "cause", "", "cancel", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/Throwable;)V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/CancellationException;)V", "ensureActive", "(Lkotlinx/coroutines/CoroutineScope;)V", "plus", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;", "", "isActive", "(Lkotlinx/coroutines/CoroutineScope;)Z", "isActive$annotations", "kotlinx-coroutines-core"})
public final class CoroutineScopeKt {
    @NotNull
    public static final CoroutineScope plus(@NotNull CoroutineScope $this$plus, @NotNull CoroutineContext context) {
        return new ContextScope($this$plus.getCoroutineContext().plus(context));
    }

    @NotNull
    public static final CoroutineScope MainScope() {
        return new ContextScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus((CoroutineContext)Dispatchers.getMain()));
    }

    public static final boolean isActive(@NotNull CoroutineScope $this$isActive) {
        Job job = (Job)$this$isActive.getCoroutineContext().get((CoroutineContext.Key)Job.Key);
        return job != null ? job.isActive() : true;
    }

    public static /* synthetic */ void isActive$annotations(CoroutineScope coroutineScope) {
    }

    @Nullable
    public static final <R> Object coroutineScope(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> block, @NotNull Continuation<? super R> $completion) {
        Continuation<? super R> uCont = $completion;
        boolean bl = false;
        ScopeCoroutine<? super R> coroutine = new ScopeCoroutine<R>(uCont.getContext(), uCont);
        Object object = UndispatchedKt.startUndispatchedOrReturn(coroutine, coroutine, block);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    @NotNull
    public static final CoroutineScope CoroutineScope(@NotNull CoroutineContext context) {
        return new ContextScope(context.get((CoroutineContext.Key)Job.Key) != null ? context : context.plus((CoroutineContext)JobKt.Job$default(null, 1, null)));
    }

    public static final void cancel(@NotNull CoroutineScope $this$cancel, @Nullable CancellationException cause) {
        Job job = (Job)$this$cancel.getCoroutineContext().get((CoroutineContext.Key)Job.Key);
        if (job == null) {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + $this$cancel).toString());
        }
        Job job2 = job;
        job2.cancel(cause);
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, CancellationException cancellationException, int n2, Object object) {
        if ((n2 & 1) != 0) {
            cancellationException = null;
        }
        CoroutineScopeKt.cancel(coroutineScope, cancellationException);
    }

    public static final void cancel(@NotNull CoroutineScope $this$cancel, @NotNull String message, @Nullable Throwable cause) {
        CoroutineScopeKt.cancel($this$cancel, ExceptionsKt.CancellationException(message, cause));
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, String string, Throwable throwable, int n2, Object object) {
        if ((n2 & 2) != 0) {
            throwable = null;
        }
        CoroutineScopeKt.cancel(coroutineScope, string, throwable);
    }

    public static final void ensureActive(@NotNull CoroutineScope $this$ensureActive) {
        JobKt.ensureActive($this$ensureActive.getCoroutineContext());
    }

    @Nullable
    public static final Object currentCoroutineContext(@NotNull Continuation<? super CoroutineContext> $completion) {
        boolean $i$f$currentCoroutineContext = false;
        return $completion.getContext();
    }

    private static final Object currentCoroutineContext$$forInline(Continuation<? super CoroutineContext> $completion) {
        boolean $i$f$currentCoroutineContext = false;
        InlineMarker.mark((int)3);
        return null.getContext();
    }
}

