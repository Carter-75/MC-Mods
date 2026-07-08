/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import kotlinx.coroutines.scheduling.LimitingDispatcher;
import kotlinx.coroutines.scheduling.TaskContext;
import kotlinx.coroutines.scheduling.TasksKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\b\u0011\u0018\u00002\u00020\u0001B'\b\u0016\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u001c\u00a2\u0006\u0004\b-\u0010.B\u001d\b\u0017\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010/B)\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010+\u001a\u00020\u001c\u00a2\u0006\u0004\b-\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0019\u001a\u00020\u00072\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0013J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u001cH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010 R\u0014\u0010+\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2={"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "blocking", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "", "close", "()V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "createScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "tailDispatch", "dispatchWithContext$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "dispatchWithContext", "dispatchYield", "limited", "", "toString", "()Ljava/lang/String;", "corePoolSize", "I", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "", "idleWorkerKeepAliveNs", "J", "maxPoolSize", "schedulerName", "Ljava/lang/String;", "<init>", "(IILjava/lang/String;)V", "(II)V", "(IIJLjava/lang/String;)V", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,213:1\n1#2:214\n*E\n"})
public class ExperimentalCoroutineDispatcher
extends ExecutorCoroutineDispatcher {
    private final int corePoolSize;
    private final int maxPoolSize;
    private final long idleWorkerKeepAliveNs;
    @NotNull
    private final String schedulerName;
    @NotNull
    private CoroutineScheduler coroutineScheduler;

    public ExperimentalCoroutineDispatcher(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, @NotNull String schedulerName) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.idleWorkerKeepAliveNs = idleWorkerKeepAliveNs;
        this.schedulerName = schedulerName;
        this.coroutineScheduler = this.createScheduler();
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int n2, int n3, long l2, String string, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 8) != 0) {
            string = "CoroutineScheduler";
        }
        this(n2, n3, l2, string);
    }

    public ExperimentalCoroutineDispatcher(int corePoolSize, int maxPoolSize, @NotNull String schedulerName) {
        this(corePoolSize, maxPoolSize, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, schedulerName);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int n2, int n3, String string, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 1) != 0) {
            n2 = TasksKt.CORE_POOL_SIZE;
        }
        if ((n4 & 2) != 0) {
            n3 = TasksKt.MAX_POOL_SIZE;
        }
        if ((n4 & 4) != 0) {
            string = TasksKt.DEFAULT_SCHEDULER_NAME;
        }
        this(n2, n3, string);
    }

    @Deprecated(message="Binary compatibility for Ktor 1.0-beta", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ ExperimentalCoroutineDispatcher(int corePoolSize, int maxPoolSize) {
        this(corePoolSize, maxPoolSize, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, null, 8, null);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int n2, int n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 1) != 0) {
            n2 = TasksKt.CORE_POOL_SIZE;
        }
        if ((n4 & 2) != 0) {
            n3 = TasksKt.MAX_POOL_SIZE;
        }
        this(n2, n3);
    }

    @Override
    @NotNull
    public Executor getExecutor() {
        return this.coroutineScheduler;
    }

    @Override
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, null, false, 6, null);
        }
        catch (RejectedExecutionException e2) {
            DefaultExecutor.INSTANCE.dispatch(context, block);
        }
    }

    @Override
    public void dispatchYield(@NotNull CoroutineContext context, @NotNull Runnable block) {
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, null, true, 2, null);
        }
        catch (RejectedExecutionException e2) {
            DefaultExecutor.INSTANCE.dispatchYield(context, block);
        }
    }

    @Override
    public void close() {
        this.coroutineScheduler.close();
    }

    @Override
    @NotNull
    public String toString() {
        return super.toString() + "[scheduler = " + this.coroutineScheduler + ']';
    }

    @NotNull
    public final CoroutineDispatcher blocking(int parallelism) {
        if (!(parallelism > 0)) {
            boolean bl = false;
            String string = "Expected positive parallelism level, but have " + parallelism;
            throw new IllegalArgumentException(string.toString());
        }
        return new LimitingDispatcher(this, parallelism, null, 1);
    }

    public static /* synthetic */ CoroutineDispatcher blocking$default(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int n2, int n3, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
        }
        if ((n3 & 1) != 0) {
            n2 = 16;
        }
        return experimentalCoroutineDispatcher.blocking(n2);
    }

    @NotNull
    public final CoroutineDispatcher limited(int parallelism) {
        if (!(parallelism > 0)) {
            boolean $i$a$-require-ExperimentalCoroutineDispatcher$limited$32 = false;
            String $i$a$-require-ExperimentalCoroutineDispatcher$limited$32 = "Expected positive parallelism level, but have " + parallelism;
            throw new IllegalArgumentException($i$a$-require-ExperimentalCoroutineDispatcher$limited$32.toString());
        }
        if (!(parallelism <= this.corePoolSize)) {
            boolean bl = false;
            String string = "Expected parallelism level lesser than core pool size (" + this.corePoolSize + "), but have " + parallelism;
            throw new IllegalArgumentException(string.toString());
        }
        return new LimitingDispatcher(this, parallelism, null, 0);
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(@NotNull Runnable block, @NotNull TaskContext context, boolean tailDispatch) {
        try {
            this.coroutineScheduler.dispatch(block, context, tailDispatch);
        }
        catch (RejectedExecutionException e2) {
            DefaultExecutor.INSTANCE.enqueue(this.coroutineScheduler.createTask(block, context));
        }
    }

    private final CoroutineScheduler createScheduler() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }
}

