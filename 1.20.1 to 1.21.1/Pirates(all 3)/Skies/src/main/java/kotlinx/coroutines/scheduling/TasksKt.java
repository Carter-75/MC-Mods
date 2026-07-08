/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.scheduling.NanoTimeSource;
import kotlinx.coroutines.scheduling.SchedulerTimeSource;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import kotlinx.coroutines.scheduling.TaskContextImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0001\u001a\u00020\u00008\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0005\"\u0014\u0010\r\u001a\u00020\u00008\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0002\"\u0014\u0010\u000e\u001a\u00020\u00038\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0005\"\u0014\u0010\u000f\u001a\u00020\u00038\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005\"\u0014\u0010\u0010\u001a\u00020\t8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000b\"\u0016\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0019\u0010\u0016\u001a\u00020\u0015*\u00020\u00148\u00c0\u0002X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2={"Lkotlinx/coroutines/scheduling/TaskContext;", "BlockingContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "CORE_POOL_SIZE", "I", "", "DEFAULT_SCHEDULER_NAME", "Ljava/lang/String;", "", "IDLE_WORKER_KEEP_ALIVE_NS", "J", "MAX_POOL_SIZE", "NonBlockingContext", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "Lkotlinx/coroutines/scheduling/Task;", "", "isBlocking", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"})
public final class TasksKt {
    @JvmField
    @NotNull
    public static final String DEFAULT_SCHEDULER_NAME = SystemPropsKt.systemProp("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
    @JvmField
    public static final long WORK_STEALING_TIME_RESOLUTION_NS = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
    @JvmField
    public static final int CORE_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast((int)SystemPropsKt.getAVAILABLE_PROCESSORS(), (int)2), 1, 0, 8, null);
    @JvmField
    public static final int MAX_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", 0x1FFFFE, 0, 0x1FFFFE, 4, null);
    @JvmField
    public static final long IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
    @JvmField
    @NotNull
    public static SchedulerTimeSource schedulerTimeSource = NanoTimeSource.INSTANCE;
    public static final int TASK_NON_BLOCKING = 0;
    public static final int TASK_PROBABLY_BLOCKING = 1;
    @JvmField
    @NotNull
    public static final TaskContext NonBlockingContext = new TaskContextImpl(0);
    @JvmField
    @NotNull
    public static final TaskContext BlockingContext = new TaskContextImpl(1);

    public static final boolean isBlocking(@NotNull Task $this$isBlocking) {
        boolean $i$f$isBlocking = false;
        return $this$isBlocking.taskContext.getTaskMode() == 1;
    }
}

