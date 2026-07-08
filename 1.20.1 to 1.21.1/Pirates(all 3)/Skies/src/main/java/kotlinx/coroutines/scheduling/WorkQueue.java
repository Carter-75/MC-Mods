/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.scheduling.GlobalQueue;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TasksKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b8\u00109J!\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001bH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b \u0010!J)\u0010%\u001a\u00020$2\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"\u00a2\u0006\u0004\b%\u0010&J+\u0010'\u001a\u00020$2\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"H\u0002\u00a2\u0006\u0004\b'\u0010&J\u0015\u0010(\u001a\u00020\f*\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b(\u0010)R\u000b\u0010+\u001a\u00020*8\u0002X\u0082\u0004R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u001a8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u000b\u00102\u001a\u00020*8\u0002X\u0082\u0004R\u0013\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002038\u0002X\u0082\u0004R\u000b\u00105\u001a\u00020*8\u0002X\u0082\u0004R\u0014\u00107\u001a\u00020\u001a8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00100\u00a8\u0006:"}, d2={"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBlocking", "pollBuffer", "pollCpu", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "onlyBlocking", "pollWithExclusiveMode", "(Z)Lkotlinx/coroutines/scheduling/Task;", "", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "stealWithExclusiveMode", "(I)Lkotlinx/coroutines/scheduling/Task;", "index", "tryExtractFromTheMiddle", "(IZ)Lkotlinx/coroutines/scheduling/Task;", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTaskRef", "", "trySteal", "(ILkotlin/jvm/internal/Ref$ObjectRef;)J", "tryStealLastScheduled", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Lkotlinx/atomicfu/AtomicInt;", "blockingTasksInBuffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "getBufferSize", "()I", "bufferSize", "consumerIndex", "Lkotlinx/atomicfu/AtomicRef;", "lastScheduledTask", "producerIndex", "getSize$kotlinx_coroutines_core", "size", "<init>", "()V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,255:1\n93#2:256\n93#2:257\n93#2:258\n93#2:261\n93#2:262\n1#3:259\n25#4:260\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n95#1:256\n162#1:257\n185#1:258\n205#1:261\n249#1:262\n205#1:260\n*E\n"})
public final class WorkQueue {
    @NotNull
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray(128);
    @Volatile
    @Nullable
    private volatile Object lastScheduledTask;
    @Volatile
    private volatile int producerIndex;
    @Volatile
    private volatile int consumerIndex;
    @Volatile
    private volatile int blockingTasksInBuffer;
    @NotNull
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
    @NotNull
    private static final AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    @NotNull
    private static final AtomicIntegerFieldUpdater consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    @NotNull
    private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    private final int getBufferSize() {
        return producerIndex$FU.get(this) - consumerIndex$FU.get(this);
    }

    public final int getSize$kotlinx_coroutines_core() {
        return lastScheduledTask$FU.get(this) != null ? this.getBufferSize() + 1 : this.getBufferSize();
    }

    @Nullable
    public final Task poll() {
        Task task = lastScheduledTask$FU.getAndSet(this, null);
        if (task == null) {
            task = this.pollBuffer();
        }
        return task;
    }

    @Nullable
    public final Task add(@NotNull Task task, boolean fair) {
        if (fair) {
            return this.addLast(task);
        }
        Task task2 = lastScheduledTask$FU.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        Task previous = task2;
        return this.addLast(previous);
    }

    public static /* synthetic */ Task add$default(WorkQueue workQueue, Task task, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        return workQueue.add(task, bl);
    }

    private final Task addLast(Task task) {
        if (this.getBufferSize() == 127) {
            return task;
        }
        Task $this$isBlocking$iv = task;
        boolean $i$f$isBlocking = false;
        if ($this$isBlocking$iv.taskContext.getTaskMode() == 1) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        int nextIndex = producerIndex$FU.get(this) & 0x7F;
        while (this.buffer.get(nextIndex) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(nextIndex, task);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    public final long trySteal(int stealingMode, @NotNull Ref.ObjectRef<Task> stolenTaskRef) {
        Task task;
        Task task2 = task = stealingMode == 3 ? this.pollBuffer() : this.stealWithExclusiveMode(stealingMode);
        if (task != null) {
            stolenTaskRef.element = task;
            return -1L;
        }
        return this.tryStealLastScheduled(stealingMode, stolenTaskRef);
    }

    private final Task stealWithExclusiveMode(int stealingMode) {
        boolean onlyBlocking;
        int start = consumerIndex$FU.get(this);
        int end = producerIndex$FU.get(this);
        boolean bl = onlyBlocking = stealingMode == 1;
        while (start != end) {
            if (onlyBlocking && blockingTasksInBuffer$FU.get(this) == 0) {
                return null;
            }
            Task task = this.tryExtractFromTheMiddle(start++, onlyBlocking);
            if (task == null) continue;
            return task;
        }
        return null;
    }

    @Nullable
    public final Task pollBlocking() {
        return this.pollWithExclusiveMode(true);
    }

    @Nullable
    public final Task pollCpu() {
        return this.pollWithExclusiveMode(false);
    }

    private final Task pollWithExclusiveMode(boolean onlyBlocking) {
        while ((Task)lastScheduledTask$FU.get(this) != null) {
            Task lastScheduled;
            Task $this$isBlocking$iv = lastScheduled;
            boolean $i$f$isBlocking = false;
            if ($this$isBlocking$iv.taskContext.getTaskMode() == 1 != onlyBlocking) break;
            if (!lastScheduledTask$FU.compareAndSet(this, lastScheduled, null)) continue;
            return lastScheduled;
        }
        int start = consumerIndex$FU.get(this);
        int end = producerIndex$FU.get(this);
        while (start != end) {
            Task task;
            if (onlyBlocking && blockingTasksInBuffer$FU.get(this) == 0) {
                return null;
            }
            if ((task = this.tryExtractFromTheMiddle(--end, onlyBlocking)) == null) continue;
            return task;
        }
        return null;
    }

    private final Task tryExtractFromTheMiddle(int index, boolean onlyBlocking) {
        int arrayIndex = index & 0x7F;
        Task value = this.buffer.get(arrayIndex);
        if (value != null) {
            Task $this$isBlocking$iv = value;
            boolean $i$f$isBlocking = false;
            if ($this$isBlocking$iv.taskContext.getTaskMode() == 1 == onlyBlocking && this.buffer.compareAndSet(arrayIndex, value, null)) {
                if (onlyBlocking) {
                    blockingTasksInBuffer$FU.decrementAndGet(this);
                }
                return value;
            }
        }
        return null;
    }

    public final void offloadAllWorkTo(@NotNull GlobalQueue globalQueue) {
        Task task = lastScheduledTask$FU.getAndSet(this, null);
        if (task != null) {
            Task it = task;
            boolean bl = false;
            globalQueue.addLast(it);
        }
        while (this.pollTo(globalQueue)) {
        }
    }

    private final long tryStealLastScheduled(int stealingMode, Ref.ObjectRef<Task> stolenTaskRef) {
        Task lastScheduled;
        do {
            if ((Task)lastScheduledTask$FU.get(this) == null) {
                return -2L;
            }
            Task $this$maskForStealingMode$iv = lastScheduled;
            boolean $i$f$getMaskForStealingMode = false;
            Task $this$isBlocking$iv$iv = $this$maskForStealingMode$iv;
            boolean $i$f$isBlocking = false;
            if ((($this$isBlocking$iv$iv.taskContext.getTaskMode() == 1 ? 1 : 2) & stealingMode) == 0) {
                return -2L;
            }
            long time = TasksKt.schedulerTimeSource.nanoTime();
            long staleness = time - lastScheduled.submissionTime;
            if (staleness >= TasksKt.WORK_STEALING_TIME_RESOLUTION_NS) continue;
            return TasksKt.WORK_STEALING_TIME_RESOLUTION_NS - staleness;
        } while (!lastScheduledTask$FU.compareAndSet(this, lastScheduled, null));
        stolenTaskRef.element = lastScheduled;
        return -1L;
    }

    private final boolean pollTo(GlobalQueue queue) {
        Task task = this.pollBuffer();
        if (task == null) {
            return false;
        }
        Task task2 = task;
        queue.addLast(task2);
        return true;
    }

    private final Task pollBuffer() {
        Task task;
        while (true) {
            int tailLocal;
            if ((tailLocal = consumerIndex$FU.get(this)) - producerIndex$FU.get(this) == 0) {
                return null;
            }
            int index = tailLocal & 0x7F;
            if (!consumerIndex$FU.compareAndSet(this, tailLocal, tailLocal + 1)) continue;
            task = this.buffer.getAndSet(index, null);
            if (task != null) break;
        }
        Task value = task;
        this.decrementIfBlocking(value);
        return value;
    }

    private final void decrementIfBlocking(Task $this$decrementIfBlocking) {
        if ($this$decrementIfBlocking != null) {
            Task $this$isBlocking$iv = $this$decrementIfBlocking;
            boolean $i$f$isBlocking = false;
            if ($this$isBlocking$iv.taskContext.getTaskMode() == 1) {
                int value = blockingTasksInBuffer$FU.decrementAndGet(this);
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl = false;
                    if (!(value >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }
}

