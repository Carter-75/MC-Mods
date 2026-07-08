/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0018\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0080\b\u00a2\u0006\u0004\b\u0003\u0010\u0004\"&\u0010\u000b\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0005j\u0002`\u00068@X\u0080\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b*\f\b\u0000\u0010\f\"\u00020\u00052\u00020\u0005*\f\b\u0000\u0010\r\"\u00020\u00002\u00020\u0000\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/scheduling/TaskContext;", "Lkotlinx/coroutines/SchedulerTaskContext;", "", "afterTask", "(Lkotlinx/coroutines/scheduling/TaskContext;)V", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "getTaskContext", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/TaskContext;", "getTaskContext$annotations", "(Lkotlinx/coroutines/scheduling/Task;)V", "taskContext", "SchedulerTask", "SchedulerTaskContext", "kotlinx-coroutines-core"})
public final class SchedulerTaskKt {
    @NotNull
    public static final TaskContext getTaskContext(@NotNull Task $this$taskContext) {
        return $this$taskContext.taskContext;
    }

    public static /* synthetic */ void getTaskContext$annotations(Task task) {
    }

    public static final void afterTask(@NotNull TaskContext $this$afterTask) {
        boolean $i$f$afterTask = false;
        $this$afterTask.afterTask();
    }
}

