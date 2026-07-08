/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.jvm.JvmField
 */
package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.scheduling.TaskContext;
import kotlinx.coroutines.scheduling.TasksKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b!\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0010\u00a2\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000fR\u0015\u0010\u0006\u001a\u00020\u00038\u00c0\u0002X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "getMode$kotlinx_coroutines_core", "()I", "mode", "", "submissionTime", "J", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "<init>", "()V", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "kotlinx-coroutines-core"})
@PublishedApi
public abstract class Task
implements Runnable {
    @JvmField
    public long submissionTime;
    @JvmField
    @NotNull
    public TaskContext taskContext;

    public Task(long submissionTime, @NotNull TaskContext taskContext) {
        this.submissionTime = submissionTime;
        this.taskContext = taskContext;
    }

    public Task() {
        this(0L, TasksKt.NonBlockingContext);
    }

    public final int getMode$kotlinx_coroutines_core() {
        boolean $i$f$getMode$kotlinx_coroutines_core = false;
        return this.taskContext.getTaskMode();
    }
}

