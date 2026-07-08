/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CompletionHandlerBase;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.DisposeOnCompletion;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0005\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0007\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\t\u001a\u00020\r*\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007\u00a2\u0006\u0004\b\t\u0010\u000e\u001a#\u0010\t\u001a\u00020\b*\u00020\u00072\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u00a2\u0006\u0004\b\t\u0010\u0011\u001a%\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\t\u0010\u0014\u001a\u0017\u0010\u0015\u001a\u00020\b*\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\b*\u00020\u0007H\u0007\u00a2\u0006\u0004\b\u0017\u0010\n\u001a\u001f\u0010\u0017\u001a\u00020\b*\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0017\u001a\u00020\b*\u00020\u00072\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0011\u001a\u0013\u0010\u0017\u001a\u00020\b*\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0019\u001a\u001f\u0010\u0017\u001a\u00020\b*\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007\u00a2\u0006\u0004\b\u0017\u0010\u001a\u001a#\u0010\u0017\u001a\u00020\b*\u00020\u00002\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u00a2\u0006\u0004\b\u0017\u0010\u001b\u001a\u001b\u0010\u001e\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010 \u001a\u00020\b*\u00020\u0007\u00a2\u0006\u0004\b \u0010\n\u001a\u0011\u0010 \u001a\u00020\b*\u00020\u0000\u00a2\u0006\u0004\b \u0010\u0019\u001a\u001d\u0010$\u001a\u00020\u000b*\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u0000H\u0002\u00a2\u0006\u0004\b\"\u0010#\"\u0015\u0010%\u001a\u00020\r*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\"\u0015\u0010!\u001a\u00020\u0000*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2={"Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/CompletableJob;", "Job", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableJob;", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "Job0", "Lkotlin/coroutines/CoroutineContext;", "", "cancel", "(Lkotlin/coroutines/CoroutineContext;)V", "", "cause", "", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "", "message", "(Lkotlinx/coroutines/Job;Ljava/lang/String;Ljava/lang/Throwable;)V", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "(Lkotlinx/coroutines/Job;)V", "(Lkotlinx/coroutines/Job;Ljava/lang/Throwable;)V", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "disposeOnCompletion", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/DisposableHandle;)Lkotlinx/coroutines/DisposableHandle;", "ensureActive", "job", "orCancellation$JobKt__JobKt", "(Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "orCancellation", "isActive", "(Lkotlin/coroutines/CoroutineContext;)Z", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/JobKt")
@SourceDebugExtension(value={"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,685:1\n13#2:686\n1295#3,2:687\n1295#3,2:689\n1295#3,2:691\n1295#3,2:693\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n494#1:686\n521#1:687,2\n535#1:689,2\n629#1:691,2\n653#1:693,2\n*E\n"})
final class JobKt__JobKt {
    @NotNull
    public static final CompletableJob Job(@Nullable Job parent) {
        return new JobImpl(parent);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int n2, Object object) {
        if ((n2 & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    @JvmName(name="Job")
    public static final /* synthetic */ Job Job(Job parent) {
        return JobKt.Job(parent);
    }

    public static /* synthetic */ Job Job$default(Job job, int n2, Object object) {
        if ((n2 & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job $this$disposeOnCompletion, @NotNull DisposableHandle handle) {
        CompletionHandlerBase $this$asHandler$iv = new DisposeOnCompletion(handle);
        boolean $i$f$getAsHandler = false;
        return $this$disposeOnCompletion.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)$this$asHandler$iv));
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job $this$cancelAndJoin, @NotNull Continuation<? super Unit> $completion) {
        Job.DefaultImpls.cancel$default($this$cancelAndJoin, null, 1, null);
        Object object = $this$cancelAndJoin.join($completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static final void cancelChildren(@NotNull Job $this$cancelChildren, @Nullable CancellationException cause) {
        Sequence<Job> $this$forEach$iv = $this$cancelChildren.getChildren();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Job it = (Job)element$iv;
            boolean bl = false;
            it.cancel(cause);
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int n2, Object object) {
        if ((n2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job, cancellationException);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(Job $this$cancelChildren) {
        JobKt.cancelChildren($this$cancelChildren, null);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(Job $this$cancelChildren, Throwable cause) {
        Sequence<Job> $this$forEach$iv = $this$cancelChildren.getChildren();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Job it = (Job)element$iv;
            boolean bl = false;
            JobSupport jobSupport = it instanceof JobSupport ? (JobSupport)it : null;
            if (jobSupport == null) continue;
            jobSupport.cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(cause, $this$cancelChildren));
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable throwable, int n2, Object object) {
        if ((n2 & 1) != 0) {
            throwable = null;
        }
        JobKt.cancelChildren(job, throwable);
    }

    public static final boolean isActive(@NotNull CoroutineContext $this$isActive) {
        Job job = (Job)$this$isActive.get((CoroutineContext.Key)Job.Key);
        return job != null ? job.isActive() : true;
    }

    public static final void cancel(@NotNull CoroutineContext $this$cancel, @Nullable CancellationException cause) {
        block0: {
            Job job = (Job)$this$cancel.get((CoroutineContext.Key)Job.Key);
            if (job == null) break block0;
            job.cancel(cause);
        }
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n2, Object object) {
        if ((n2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancel(CoroutineContext $this$cancel) {
        JobKt.cancel($this$cancel, null);
    }

    public static final void ensureActive(@NotNull Job $this$ensureActive) {
        if (!$this$ensureActive.isActive()) {
            throw $this$ensureActive.getCancellationException();
        }
    }

    public static final void ensureActive(@NotNull CoroutineContext $this$ensureActive) {
        block0: {
            Job job = (Job)$this$ensureActive.get((CoroutineContext.Key)Job.Key);
            if (job == null) break block0;
            JobKt.ensureActive(job);
        }
    }

    public static final void cancel(@NotNull Job $this$cancel, @NotNull String message, @Nullable Throwable cause) {
        $this$cancel.cancel(ExceptionsKt.CancellationException(message, cause));
    }

    public static /* synthetic */ void cancel$default(Job job, String string, Throwable throwable, int n2, Object object) {
        if ((n2 & 2) != 0) {
            throwable = null;
        }
        JobKt.cancel(job, string, throwable);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ boolean cancel(CoroutineContext $this$cancel, Throwable cause) {
        CoroutineContext.Element element = $this$cancel.get((CoroutineContext.Key)Job.Key);
        JobSupport jobSupport = element instanceof JobSupport ? (JobSupport)element : null;
        if (jobSupport == null) {
            return false;
        }
        JobSupport job = jobSupport;
        job.cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(cause, job));
        return true;
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable throwable, int n2, Object object) {
        if ((n2 & 1) != 0) {
            throwable = null;
        }
        return JobKt.cancel(coroutineContext, throwable);
    }

    public static final void cancelChildren(@NotNull CoroutineContext $this$cancelChildren, @Nullable CancellationException cause) {
        block1: {
            Sequence<Job> sequence = (Sequence<Job>)$this$cancelChildren.get((CoroutineContext.Key)Job.Key);
            if (sequence == null || (sequence = sequence.getChildren()) == null) break block1;
            Sequence<Job> $this$forEach$iv = sequence;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Job it = (Job)element$iv;
                boolean bl = false;
                it.cancel(cause);
            }
        }
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int n2, Object object) {
        if ((n2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(CoroutineContext $this$cancelChildren) {
        JobKt.cancelChildren($this$cancelChildren, null);
    }

    @NotNull
    public static final Job getJob(@NotNull CoroutineContext $this$job) {
        Job job = (Job)$this$job.get((CoroutineContext.Key)Job.Key);
        if (job == null) {
            throw new IllegalStateException(("Current context doesn't contain Job in it: " + $this$job).toString());
        }
        return job;
    }

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void cancelChildren(CoroutineContext $this$cancelChildren, Throwable cause) {
        Job job = (Job)$this$cancelChildren.get((CoroutineContext.Key)Job.Key);
        if (job == null) {
            return;
        }
        Job job2 = job;
        Sequence<Job> $this$forEach$iv = job2.getChildren();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Job it = (Job)element$iv;
            boolean bl = false;
            JobSupport jobSupport = it instanceof JobSupport ? (JobSupport)it : null;
            if (jobSupport == null) continue;
            jobSupport.cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(cause, job2));
        }
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable throwable, int n2, Object object) {
        if ((n2 & 1) != 0) {
            throwable = null;
        }
        JobKt.cancelChildren(coroutineContext, throwable);
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable $this$orCancellation, Job job) {
        Throwable throwable = $this$orCancellation;
        if (throwable == null) {
            throwable = new JobCancellationException("Job was cancelled", null, job);
        }
        return throwable;
    }
}

