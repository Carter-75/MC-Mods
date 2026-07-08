/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.scheduling.Task;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0014\u0010\u0001\u001a\u00020\u00008\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00008\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u00058\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0018\u0010\t\u001a\u00060\u0000j\u0002`\b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0002\"\u0018\u0010\n\u001a\u00060\u0000j\u0002`\b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0002\"\u0018\u0010\u000b\u001a\u00060\u0000j\u0002`\b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0002\"\u0014\u0010\f\u001a\u00020\u00058\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007\"\u0019\u0010\u0010\u001a\u00020\u0000*\u00020\r8\u00c0\u0002X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f*\f\b\u0000\u0010\u0011\"\u00020\u00002\u00020\u0000\u00a8\u0006\u0012"}, d2={"", "BUFFER_CAPACITY", "I", "BUFFER_CAPACITY_BASE", "MASK", "", "NOTHING_TO_STEAL", "J", "Lkotlinx/coroutines/scheduling/StealingMode;", "STEAL_ANY", "STEAL_BLOCKING_ONLY", "STEAL_CPU_ONLY", "TASK_STOLEN", "Lkotlinx/coroutines/scheduling/Task;", "getMaskForStealingMode", "(Lkotlinx/coroutines/scheduling/Task;)I", "maskForStealingMode", "StealingMode", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n*L\n1#1,255:1\n93#2:256\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n25#1:256\n*E\n"})
public final class WorkQueueKt {
    public static final int BUFFER_CAPACITY_BASE = 7;
    public static final int BUFFER_CAPACITY = 128;
    public static final int MASK = 127;
    public static final long TASK_STOLEN = -1L;
    public static final long NOTHING_TO_STEAL = -2L;
    public static final int STEAL_ANY = 3;
    public static final int STEAL_CPU_ONLY = 2;
    public static final int STEAL_BLOCKING_ONLY = 1;

    public static final int getMaskForStealingMode(@NotNull Task $this$maskForStealingMode) {
        boolean $i$f$getMaskForStealingMode = false;
        Task $this$isBlocking$iv = $this$maskForStealingMode;
        boolean $i$f$isBlocking = false;
        return $this$isBlocking$iv.taskContext.getTaskMode() == 1 ? 1 : 2;
    }
}

