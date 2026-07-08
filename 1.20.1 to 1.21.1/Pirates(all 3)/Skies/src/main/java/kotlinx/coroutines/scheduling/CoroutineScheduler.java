/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.scheduling.GlobalQueue;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import kotlinx.coroutines.scheduling.TaskImpl;
import kotlinx.coroutines.scheduling.TasksKt;
import kotlinx.coroutines.scheduling.WorkQueue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0003`abB+\u0012\u0006\u0010M\u001a\u00020\n\u0012\u0006\u0010W\u001a\u00020\n\u0012\b\b\u0002\u0010T\u001a\u00020\b\u0012\b\b\u0002\u0010Y\u001a\u00020>\u00a2\u0006\u0004\b^\u0010_J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0086\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\b\u00a2\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0018\u001a\u00020\u00032\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\b\u00a2\u0006\u0004\b\u001a\u0010\fJ\u0015\u0010\u001c\u001a\b\u0018\u00010\u001bR\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eH\u0082\b\u00a2\u0006\u0004\b\u001e\u0010\u0010J\u0010\u0010\u001f\u001a\u00020\nH\u0082\b\u00a2\u0006\u0004\b\u001f\u0010\u0012J-\u0010!\u001a\u00020\u000e2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u0005\u00a2\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\u00020\u000e2\n\u0010#\u001a\u00060\u0013j\u0002`\u0014H\u0016\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\bH\u0082\b\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\nH\u0082\b\u00a2\u0006\u0004\b(\u0010\u0012J\u001b\u0010*\u001a\u00020\n2\n\u0010)\u001a\u00060\u001bR\u00020\u0000H\u0002\u00a2\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\b\u0018\u00010\u001bR\u00020\u0000H\u0002\u00a2\u0006\u0004\b,\u0010\u001dJ\u0019\u0010-\u001a\u00020\u00052\n\u0010)\u001a\u00060\u001bR\u00020\u0000\u00a2\u0006\u0004\b-\u0010.J)\u00101\u001a\u00020\u000e2\n\u0010)\u001a\u00060\u001bR\u00020\u00002\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n\u00a2\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\bH\u0082\b\u00a2\u0006\u0004\b3\u0010'J\u0015\u00104\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\b\u00a2\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u000e\u00a2\u0006\u0004\b=\u0010\u0010J\u000f\u0010?\u001a\u00020>H\u0016\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0005H\u0082\b\u00a2\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\bE\u0010BJ+\u0010F\u001a\u0004\u0018\u00010\u0003*\b\u0018\u00010\u001bR\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\bF\u0010GR\u000b\u0010I\u001a\u00020H8\u0002X\u0082\u0004R\u0015\u0010\u000b\u001a\u00020\n8\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010\u0012R\u000b\u0010L\u001a\u00020K8\u0002X\u0082\u0004R\u0014\u0010M\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0015\u0010\u001a\u001a\u00020\n8\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bO\u0010\u0012R\u0014\u0010Q\u001a\u00020P8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020P8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010RR\u0014\u0010T\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0011\u0010V\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\bV\u0010BR\u0014\u0010W\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010NR\u000b\u0010X\u001a\u00020K8\u0002X\u0082\u0004R\u0014\u0010Y\u001a\u00020>8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001e\u0010\\\u001a\f\u0012\b\u0012\u00060\u001bR\u00020\u00000[8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006c"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "", "state", "", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "stateSnapshot", "skipUnpark", "signalBlockingWork", "(JZ)V", "signalCpuWork", "", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/atomicfu/AtomicBoolean;", "_isTerminated", "getAvailableCpuPermits", "Lkotlinx/atomicfu/AtomicLong;", "controlState", "corePoolSize", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "idleWorkerKeepAliveNs", "J", "isTerminated", "maxPoolSize", "parkedWorkersStack", "schedulerName", "Ljava/lang/String;", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "<init>", "(IIJLjava/lang/String;)V", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 7 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1033:1\n285#1:1036\n283#1:1037\n283#1:1038\n285#1:1039\n280#1:1045\n281#1,5:1046\n291#1:1052\n283#1:1053\n284#1:1054\n283#1:1060\n284#1:1061\n280#1:1062\n288#1:1063\n283#1:1064\n283#1:1067\n284#1:1068\n285#1:1069\n93#2:1034\n93#2:1051\n1#3:1035\n28#4,4:1040\n28#4,4:1055\n20#5:1044\n20#5:1059\n90#6:1065\n610#7:1066\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n281#1:1036\n288#1:1037\n289#1:1038\n298#1:1039\n347#1:1045\n375#1:1046,5\n398#1:1052\n445#1:1053\n446#1:1054\n482#1:1060\n483#1:1061\n489#1:1062\n498#1:1063\n498#1:1064\n576#1:1067\n577#1:1068\n578#1:1069\n119#1:1034\n395#1:1051\n347#1:1040,4\n478#1:1055,4\n347#1:1044\n478#1:1059\n515#1:1065\n522#1:1066\n*E\n"})
public final class CoroutineScheduler
implements Executor,
Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    public final int corePoolSize;
    @JvmField
    public final int maxPoolSize;
    @JvmField
    public final long idleWorkerKeepAliveNs;
    @JvmField
    @NotNull
    public final String schedulerName;
    @JvmField
    @NotNull
    public final GlobalQueue globalCpuQueue;
    @JvmField
    @NotNull
    public final GlobalQueue globalBlockingQueue;
    @Volatile
    private volatile long parkedWorkersStack;
    @JvmField
    @NotNull
    public final ResizableAtomicArray<Worker> workers;
    @Volatile
    private volatile long controlState;
    @Volatile
    private volatile int _isTerminated;
    @NotNull
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    @NotNull
    private static final AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    @NotNull
    private static final AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    @JvmField
    @NotNull
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    private static final int PARKED = -1;
    private static final int CLAIMED = 0;
    private static final int TERMINATED = 1;
    private static final int BLOCKING_SHIFT = 21;
    private static final long CREATED_MASK = 0x1FFFFFL;
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CPU_PERMITS_MASK = 9223367638808264704L;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    public static final int MAX_SUPPORTED_POOL_SIZE = 0x1FFFFE;
    private static final long PARKED_INDEX_MASK = 0x1FFFFFL;
    private static final long PARKED_VERSION_MASK = -2097152L;
    private static final long PARKED_VERSION_INC = 0x200000L;

    public CoroutineScheduler(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, @NotNull String schedulerName) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.idleWorkerKeepAliveNs = idleWorkerKeepAliveNs;
        this.schedulerName = schedulerName;
        if (!(this.corePoolSize >= 1)) {
            boolean $i$a$-require-CoroutineScheduler$52 = false;
            String $i$a$-require-CoroutineScheduler$52 = "Core pool size " + this.corePoolSize + " should be at least 1";
            throw new IllegalArgumentException($i$a$-require-CoroutineScheduler$52.toString());
        }
        if (!(this.maxPoolSize >= this.corePoolSize)) {
            boolean $i$a$-require-CoroutineScheduler$62 = false;
            String $i$a$-require-CoroutineScheduler$62 = "Max pool size " + this.maxPoolSize + " should be greater than or equals to core pool size " + this.corePoolSize;
            throw new IllegalArgumentException($i$a$-require-CoroutineScheduler$62.toString());
        }
        if (!(this.maxPoolSize <= 0x1FFFFE)) {
            boolean $i$a$-require-CoroutineScheduler$72 = false;
            String $i$a$-require-CoroutineScheduler$72 = "Max pool size " + this.maxPoolSize + " should not exceed maximal supported number of threads 2097150";
            throw new IllegalArgumentException($i$a$-require-CoroutineScheduler$72.toString());
        }
        if (!(this.idleWorkerKeepAliveNs > 0L)) {
            boolean bl = false;
            String string = "Idle worker keep alive time " + this.idleWorkerKeepAliveNs + " must be positive";
            throw new IllegalArgumentException(string.toString());
        }
        this.globalCpuQueue = new GlobalQueue();
        this.globalBlockingQueue = new GlobalQueue();
        this.workers = new ResizableAtomicArray((this.corePoolSize + 1) * 2);
        this.controlState = (long)this.corePoolSize << 42;
        this._isTerminated = 0;
    }

    public /* synthetic */ CoroutineScheduler(int n2, int n3, long l2, String string, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 4) != 0) {
            l2 = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        }
        if ((n4 & 8) != 0) {
            string = TasksKt.DEFAULT_SCHEDULER_NAME;
        }
        this(n2, n3, l2, string);
    }

    private final boolean addToGlobalQueue(Task task) {
        Task $this$isBlocking$iv = task;
        boolean $i$f$isBlocking = false;
        return $this$isBlocking$iv.taskContext.getTaskMode() == 1 ? this.globalBlockingQueue.addLast(task) : this.globalCpuQueue.addLast(task);
    }

    public final void parkedWorkersStackTopUpdate(@NotNull Worker worker, int oldIndex, int newIndex) {
        long updVersion;
        long top;
        int n2;
        int updIndex;
        CoroutineScheduler coroutineScheduler = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = parkedWorkersStack$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            top = atomicfu$handler$iv.get(this);
            boolean bl = false;
            int index = (int)(top & 0x1FFFFFL);
            updVersion = top + 0x200000L & 0xFFFFFFFFFFE00000L;
            if (index == oldIndex) {
                if (newIndex == 0) {
                    n2 = this.parkedWorkersStackNextIndex(worker);
                    continue;
                }
                n2 = newIndex;
                continue;
            }
            n2 = index;
        } while ((updIndex = n2) < 0 || !parkedWorkersStack$FU.compareAndSet(this, top, updVersion | (long)updIndex));
    }

    public final boolean parkedWorkersStackPush(@NotNull Worker worker) {
        int updIndex;
        long updVersion;
        long top;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        CoroutineScheduler coroutineScheduler = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = parkedWorkersStack$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            top = atomicfu$handler$iv.get(this);
            boolean bl = false;
            int index = (int)(top & 0x1FFFFFL);
            updVersion = top + 0x200000L & 0xFFFFFFFFFFE00000L;
            updIndex = worker.getIndexInArray();
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl2 = false;
                if (!(updIndex != 0)) {
                    throw new AssertionError();
                }
            }
            worker.setNextParkedWorker(this.workers.get(index));
        } while (!parkedWorkersStack$FU.compareAndSet(this, top, updVersion | (long)updIndex));
        return true;
    }

    private final Worker parkedWorkersStackPop() {
        long updVersion;
        long top;
        Worker worker;
        int updIndex;
        CoroutineScheduler coroutineScheduler = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = parkedWorkersStack$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            top = atomicfu$handler$iv.get(this);
            boolean bl = false;
            int index = (int)(top & 0x1FFFFFL);
            if (this.workers.get(index) == null) {
                return null;
            }
            updVersion = top + 0x200000L & 0xFFFFFFFFFFE00000L;
        } while ((updIndex = this.parkedWorkersStackNextIndex(worker)) < 0 || !parkedWorkersStack$FU.compareAndSet(this, top, updVersion | (long)updIndex));
        worker.setNextParkedWorker(NOT_IN_STACK);
        return worker;
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object next = worker.getNextParkedWorker();
        while (next != NOT_IN_STACK) {
            if (next == null) {
                return 0;
            }
            Worker nextWorker = (Worker)next;
            int updIndex = nextWorker.getIndexInArray();
            if (updIndex != 0) {
                return updIndex;
            }
            next = nextWorker.getNextParkedWorker();
        }
        return -1;
    }

    private final int getCreatedWorkers() {
        boolean $i$f$getCreatedWorkers = false;
        return (int)(CoroutineScheduler.controlState$FU.get(this) & 0x1FFFFFL);
    }

    private final int getAvailableCpuPermits() {
        boolean $i$f$getAvailableCpuPermits = false;
        CoroutineScheduler coroutineScheduler = this;
        long state$iv = controlState$FU.get(this);
        boolean $i$f$availableCpuPermits = false;
        return (int)((state$iv & 0x7FFFFC0000000000L) >> 42);
    }

    private final int createdWorkers(long state) {
        boolean $i$f$createdWorkers = false;
        return (int)(state & 0x1FFFFFL);
    }

    private final int blockingTasks(long state) {
        boolean $i$f$blockingTasks = false;
        return (int)((state & 0x3FFFFE00000L) >> 21);
    }

    public final int availableCpuPermits(long state) {
        boolean $i$f$availableCpuPermits = false;
        return (int)((state & 0x7FFFFC0000000000L) >> 42);
    }

    private final int incrementCreatedWorkers() {
        boolean $i$f$incrementCreatedWorkers = false;
        CoroutineScheduler coroutineScheduler = this;
        long state$iv = controlState$FU.incrementAndGet(this);
        boolean $i$f$createdWorkers = false;
        return (int)(state$iv & 0x1FFFFFL);
    }

    private final int decrementCreatedWorkers() {
        boolean $i$f$decrementCreatedWorkers = false;
        CoroutineScheduler coroutineScheduler = this;
        long state$iv = CoroutineScheduler.controlState$FU.getAndDecrement(this);
        boolean $i$f$createdWorkers = false;
        return (int)(state$iv & 0x1FFFFFL);
    }

    private final long incrementBlockingTasks() {
        boolean $i$f$incrementBlockingTasks = false;
        return controlState$FU.addAndGet(this, 0x200000L);
    }

    private final void decrementBlockingTasks() {
        boolean $i$f$decrementBlockingTasks = false;
        CoroutineScheduler.controlState$FU.addAndGet(this, -2097152L);
    }

    private final boolean tryAcquireCpuPermit() {
        long update;
        long state;
        boolean $i$f$tryAcquireCpuPermit = false;
        CoroutineScheduler coroutineScheduler = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = CoroutineScheduler.controlState$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            CoroutineScheduler this_$iv = this;
            boolean $i$f$availableCpuPermits = false;
            int available = (int)((state & 0x7FFFFC0000000000L) >> 42);
            if (available == 0) {
                return false;
            }
            update = state - 0x40000000000L;
        } while (!CoroutineScheduler.controlState$FU.compareAndSet(this, state, update));
        return true;
    }

    private final long releaseCpuPermit() {
        boolean $i$f$releaseCpuPermit = false;
        return CoroutineScheduler.controlState$FU.addAndGet(this, 0x40000000000L);
    }

    public final boolean isTerminated() {
        return _isTerminated$FU.get(this) != 0;
    }

    @Override
    public void execute(@NotNull Runnable command2) {
        CoroutineScheduler.dispatch$default(this, command2, null, false, 6, null);
    }

    @Override
    public void close() {
        this.shutdown(10000L);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void shutdown(long timeout) {
        Runnable runnable;
        int n2;
        if (!_isTerminated$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        Worker currentWorker = this.currentWorker();
        ResizableAtomicArray<Worker> lock$iv = this.workers;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ResizableAtomicArray<Worker> resizableAtomicArray = lock$iv;
        synchronized (resizableAtomicArray) {
            n2 = 0;
            CoroutineScheduler this_$iv = this;
            boolean $i$f$getCreatedWorkers = false;
            n2 = (int)(CoroutineScheduler.controlState$FU.get(this_$iv) & 0x1FFFFFL);
        }
        int created = n2;
        int i2 = 1;
        if (i2 <= created) {
            while (true) {
                Worker worker;
                Intrinsics.checkNotNull((Object)this.workers.get(i2));
                if (worker != currentWorker) {
                    while (worker.isAlive()) {
                        LockSupport.unpark(worker);
                        worker.join(timeout);
                    }
                    WorkerState state = worker.state;
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        boolean bl2 = false;
                        if (!(state == WorkerState.TERMINATED)) {
                            throw new AssertionError();
                        }
                    }
                    worker.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                }
                if (i2 == created) break;
                ++i2;
            }
        }
        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
        while ((runnable = currentWorker) != null && (runnable = runnable.findTask(true)) != null || (runnable = (Task)this.globalCpuQueue.removeFirstOrNull()) != null || (runnable = (Task)this.globalBlockingQueue.removeFirstOrNull()) != null) {
            Runnable task = runnable;
            this.runSafely((Task)task);
        }
        Worker worker = currentWorker;
        if (worker != null) {
            worker.tryReleaseCpu(WorkerState.TERMINATED);
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            CoroutineScheduler this_$iv = this;
            boolean $i$f$getAvailableCpuPermits = false;
            CoroutineScheduler bl2 = this_$iv;
            long state$iv$iv = controlState$FU.get(this_$iv);
            boolean $i$f$availableCpuPermits = false;
            if (!((int)((state$iv$iv & 0x7FFFFC0000000000L) >> 42) == this.corePoolSize)) {
                throw new AssertionError();
            }
        }
        parkedWorkersStack$FU.set(this, 0L);
        controlState$FU.set(this, 0L);
    }

    public final void dispatch(@NotNull Runnable block, @NotNull TaskContext taskContext, boolean tailDispatch) {
        boolean skipUnpark;
        long l2;
        boolean isBlockingTask;
        Task task;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
        if (abstractTimeSource != null) {
            abstractTimeSource.trackTask();
        }
        Task $this$isBlocking$iv = task = this.createTask(block, taskContext);
        boolean $i$f$isBlocking = false;
        boolean bl = isBlockingTask = $this$isBlocking$iv.taskContext.getTaskMode() == 1;
        if (isBlockingTask) {
            CoroutineScheduler this_$iv = this;
            boolean $i$f$incrementBlockingTasks = false;
            l2 = controlState$FU.addAndGet(this_$iv, 0x200000L);
        } else {
            l2 = 0L;
        }
        long stateSnapshot = l2;
        Worker currentWorker = this.currentWorker();
        Task notAdded = this.submitToLocalQueue(currentWorker, task, tailDispatch);
        if (notAdded != null && !this.addToGlobalQueue(notAdded)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        boolean bl2 = skipUnpark = tailDispatch && currentWorker != null;
        if (isBlockingTask) {
            this.signalBlockingWork(stateSnapshot, skipUnpark);
        } else {
            if (skipUnpark) {
                return;
            }
            this.signalCpuWork();
        }
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            taskContext = TasksKt.NonBlockingContext;
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, bl);
    }

    @NotNull
    public final Task createTask(@NotNull Runnable block, @NotNull TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (block instanceof Task) {
            ((Task)block).submissionTime = nanoTime;
            ((Task)block).taskContext = taskContext;
            return (Task)block;
        }
        return new TaskImpl(block, nanoTime, taskContext);
    }

    private final void signalBlockingWork(long stateSnapshot, boolean skipUnpark) {
        if (skipUnpark) {
            return;
        }
        if (this.tryUnpark()) {
            return;
        }
        if (this.tryCreateWorker(stateSnapshot)) {
            return;
        }
        this.tryUnpark();
    }

    public final void signalCpuWork() {
        if (this.tryUnpark()) {
            return;
        }
        if (CoroutineScheduler.tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        this.tryUnpark();
    }

    private final boolean tryCreateWorker(long state) {
        CoroutineScheduler this_$iv = this;
        boolean $i$f$createdWorkers = false;
        int created = (int)(state & 0x1FFFFFL);
        CoroutineScheduler this_$iv2 = this;
        boolean $i$f$blockingTasks = false;
        int blocking = (int)((state & 0x3FFFFE00000L) >> 21);
        int cpuWorkers = RangesKt.coerceAtLeast((int)(created - blocking), (int)0);
        if (cpuWorkers < this.corePoolSize) {
            int newCpuWorkers = this.createNewWorker();
            if (newCpuWorkers == 1 && this.corePoolSize > 1) {
                this.createNewWorker();
            }
            if (newCpuWorkers > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long l2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = controlState$FU.get(coroutineScheduler);
        }
        return coroutineScheduler.tryCreateWorker(l2);
    }

    private final boolean tryUnpark() {
        Worker worker;
        do {
            if (this.parkedWorkersStackPop() != null) continue;
            return false;
        } while (!Worker.getWorkerCtl$FU().compareAndSet(worker, -1, 0));
        LockSupport.unpark(worker);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final int createNewWorker() {
        int n2;
        int n3;
        Worker worker = null;
        ResizableAtomicArray<Worker> lock$iv = this.workers;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ResizableAtomicArray<Worker> resizableAtomicArray = lock$iv;
        synchronized (resizableAtomicArray) {
            int cpuWorkers;
            block10: {
                int created;
                block9: {
                    block8: {
                        boolean bl = false;
                        if (!this.isTerminated()) break block8;
                        int n4 = -1;
                        return n4;
                    }
                    long state = controlState$FU.get(this);
                    CoroutineScheduler this_$iv = this;
                    boolean $i$f$createdWorkers = false;
                    created = (int)(state & 0x1FFFFFL);
                    CoroutineScheduler this_$iv2 = this;
                    boolean $i$f$blockingTasks = false;
                    int blocking = (int)((state & 0x3FFFFE00000L) >> 21);
                    cpuWorkers = RangesKt.coerceAtLeast((int)(created - blocking), (int)0);
                    if (cpuWorkers < this.corePoolSize) break block9;
                    int n5 = 0;
                    return n5;
                }
                if (created < this.maxPoolSize) break block10;
                int n6 = 0;
                return n6;
            }
            CoroutineScheduler this_$iv = this;
            boolean $i$f$getCreatedWorkers2 = false;
            int newIndex = (int)(CoroutineScheduler.controlState$FU.get(this_$iv) & 0x1FFFFFL) + 1;
            if (!(newIndex > 0 && this.workers.get(newIndex) == null)) {
                String $i$f$getCreatedWorkers2 = "Failed requirement.";
                throw new IllegalArgumentException($i$f$getCreatedWorkers2.toString());
            }
            worker = new Worker(newIndex);
            this.workers.setSynchronized(newIndex, worker);
            this_$iv = this;
            boolean $i$f$incrementCreatedWorkers = false;
            CoroutineScheduler coroutineScheduler = this_$iv;
            long state$iv$iv = controlState$FU.incrementAndGet(this_$iv);
            boolean $i$f$createdWorkers = false;
            if (!(newIndex == (int)(state$iv$iv & 0x1FFFFFL))) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            n3 = cpuWorkers + 1;
        }
        int it = n2 = n3;
        boolean bl = false;
        worker.start();
        return n2;
    }

    private final Task submitToLocalQueue(Worker $this$submitToLocalQueue, Task task, boolean tailDispatch) {
        if ($this$submitToLocalQueue == null) {
            return task;
        }
        if ($this$submitToLocalQueue.state == WorkerState.TERMINATED) {
            return task;
        }
        Task this_$iv = task;
        boolean $i$f$getMode$kotlinx_coroutines_core = false;
        if (this_$iv.taskContext.getTaskMode() == 0 && $this$submitToLocalQueue.state == WorkerState.BLOCKING) {
            return task;
        }
        $this$submitToLocalQueue.mayHaveLocalTasks = true;
        return $this$submitToLocalQueue.localQueue.add(task, tailDispatch);
    }

    private final Worker currentWorker() {
        Thread thread;
        Thread thread2 = Thread.currentThread();
        Worker worker = thread2 instanceof Worker ? (Worker)thread2 : null;
        if (worker != null) {
            Thread it = thread2 = worker;
            boolean bl = false;
            Thread this_$iv = it;
            boolean $i$f$getScheduler = false;
            thread = Intrinsics.areEqual((Object)((Worker)this_$iv).CoroutineScheduler.this, (Object)this) ? thread2 : null;
        } else {
            thread = null;
        }
        return thread;
    }

    @NotNull
    public String toString() {
        int parkedWorkers = 0;
        int blockingWorkers = 0;
        int cpuWorkers = 0;
        int dormant = 0;
        int terminated = 0;
        ArrayList queueSizes = new ArrayList();
        int n2 = this.workers.currentLength();
        block7: for (int index = 1; index < n2; ++index) {
            Worker worker;
            if (this.workers.get(index) == null) continue;
            int queueSize = worker.localQueue.getSize$kotlinx_coroutines_core();
            switch (WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()]) {
                case 1: {
                    ++parkedWorkers;
                    continue block7;
                }
                case 2: {
                    ++blockingWorkers;
                    ((Collection)queueSizes).add("" + queueSize + 'b');
                    continue block7;
                }
                case 3: {
                    ++cpuWorkers;
                    ((Collection)queueSizes).add("" + queueSize + 'c');
                    continue block7;
                }
                case 4: {
                    ++dormant;
                    if (queueSize <= 0) continue block7;
                    ((Collection)queueSizes).add("" + queueSize + 'd');
                    continue block7;
                }
                case 5: {
                    ++terminated;
                }
            }
        }
        long state = controlState$FU.get(this);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.schedulerName).append('@').append(DebugStringsKt.getHexAddress(this)).append("[Pool Size {core = ").append(this.corePoolSize).append(", max = ").append(this.maxPoolSize).append("}, Worker States {CPU = ").append(cpuWorkers).append(", blocking = ").append(blockingWorkers).append(", parked = ").append(parkedWorkers).append(", dormant = ").append(dormant).append(", terminated = ").append(terminated).append("}, running workers queues = ").append(queueSizes).append(", global CPU queue size = ").append(this.globalCpuQueue.getSize()).append(", global blocking queue size = ").append(this.globalBlockingQueue.getSize());
        CoroutineScheduler this_$iv = this;
        boolean $i$f$createdWorkers = false;
        this_$iv = this;
        boolean $i$f$blockingTasks = false;
        this_$iv = this;
        boolean $i$f$availableCpuPermits = false;
        stringBuilder.append(", Control State {created workers= ").append((int)(state & 0x1FFFFFL)).append(", blocking tasks = ").append((int)((state & 0x3FFFFE00000L) >> 21)).append(", CPUs acquired = ").append(this.corePoolSize - (int)((state & 0x7FFFFC0000000000L) >> 42)).append("}]");
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void runSafely(@NotNull Task task) {
        try {
            task.run();
        }
        catch (Throwable e2) {
            Thread thread = Thread.currentThread();
            thread.getUncaughtExceptionHandler().uncaughtException(thread, e2);
        }
        finally {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.getTimeSource();
            if (abstractTimeSource != null) {
                abstractTimeSource.unTrackTask();
            }
        }
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicfu$handler, Function1<? super Long, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            long l2 = atomicfu$handler.get(atomicfu$dispatchReceiver);
            atomicfu$action.invoke((Object)l2);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00058\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007\u00a8\u0006\u0018"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "", "BLOCKING_MASK", "J", "", "BLOCKING_SHIFT", "I", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "Lkotlinx/coroutines/internal/Symbol;", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[WorkerState.values().length];
            try {
                nArray[WorkerState.PARKING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.BLOCKING.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.DORMANT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkerState.TERMINATED.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u00100\u001a\u00020\u0002\u00a2\u0006\u0004\bP\u0010QB\t\b\u0002\u00a2\u0006\u0004\bP\u0010RJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\f\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b \u0010\u001eJ\r\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b$\u0010\u001eJ\u000f\u0010%\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b%\u0010\u0018J\u000f\u0010&\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b&\u0010\u001eJ\u0015\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\u001d\u0010-\u001a\u0004\u0018\u00010\b2\n\u0010,\u001a\u00060\u0002j\u0002`+H\u0002\u00a2\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b/\u0010\u001eR*\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u0010\u0006R\u0014\u00107\u001a\u0002068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00109R\u0016\u0010:\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00102R\u0012\u0010G\u001a\u00020D8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010;R\b\u0010O\u001a\u00020N8\u0006\u00a8\u0006S"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findBlockingTask", "()Lkotlinx/coroutines/scheduling/Task;", "findCpuTask", "mayHaveLocalTasks", "findTask", "mode", "idleReset", "inStack", "()Z", "isIo", "upperBound", "nextInt", "(I)I", "park", "()V", "pollGlobalQueues", "run", "", "runSingleTask", "()J", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "trySteal", "(I)Lkotlinx/coroutines/scheduling/Task;", "tryTerminateWorker", "index", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "Z", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "terminationDeadline", "Lkotlinx/atomicfu/AtomicInt;", "workerCtl", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1033:1\n298#2:1034\n285#2:1035\n299#2,4:1036\n304#2:1040\n294#2,2:1041\n294#2,2:1045\n280#2:1052\n289#2:1053\n283#2:1054\n280#2:1055\n1#3:1043\n90#4:1044\n28#5,4:1047\n20#6:1051\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n665#1:1034\n665#1:1035\n665#1:1036,4\n679#1:1040\n753#1:1041,2\n807#1:1045,2\n855#1:1052\n881#1:1053\n881#1:1054\n963#1:1055\n790#1:1044\n851#1:1047,4\n851#1:1051\n*E\n"})
    public final class Worker
    extends Thread {
        private volatile int indexInArray;
        @JvmField
        @NotNull
        public final WorkQueue localQueue;
        @NotNull
        private final Ref.ObjectRef<Task> stolenTask;
        @JvmField
        @NotNull
        public WorkerState state;
        @Volatile
        private volatile int workerCtl;
        private long terminationDeadline;
        @Nullable
        private volatile Object nextParkedWorker;
        private long minDelayUntilStealableTaskNs;
        private int rngState;
        @JvmField
        public boolean mayHaveLocalTasks;
        @NotNull
        private static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");

        private Worker() {
            this.setDaemon(true);
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref.ObjectRef();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int index) {
            this.setName(CoroutineScheduler.this.schedulerName + "-worker-" + (index == 0 ? "TERMINATED" : String.valueOf(index)));
            this.indexInArray = index;
        }

        public Worker(int index) {
            this();
            this.setIndexInArray(index);
        }

        @NotNull
        public final CoroutineScheduler getScheduler() {
            boolean $i$f$getScheduler = false;
            return CoroutineScheduler.this;
        }

        public final int getWorkerCtl() {
            return this.workerCtl;
        }

        @Nullable
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(@Nullable Object object) {
            this.nextParkedWorker = object;
        }

        private final boolean tryAcquireCpuPermit() {
            boolean bl;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                bl = true;
            } else {
                boolean bl2;
                block6: {
                    long update$iv;
                    long state$iv;
                    CoroutineScheduler this_$iv = CoroutineScheduler.this;
                    boolean $i$f$tryAcquireCpuPermit = false;
                    CoroutineScheduler coroutineScheduler = this_$iv;
                    AtomicLongFieldUpdater atomicfu$handler$iv$iv = controlState$FU;
                    boolean $i$f$loop$atomicfu = false;
                    do {
                        state$iv = atomicfu$handler$iv$iv.get(this_$iv);
                        boolean bl3 = false;
                        CoroutineScheduler this_$iv$iv = this_$iv;
                        boolean $i$f$availableCpuPermits = false;
                        int available$iv = (int)((state$iv & 0x7FFFFC0000000000L) >> 42);
                        if (available$iv == 0) {
                            bl2 = false;
                            break block6;
                        }
                        update$iv = state$iv - 0x40000000000L;
                    } while (!controlState$FU.compareAndSet(this_$iv, state$iv, update$iv));
                    bl2 = true;
                }
                if (bl2) {
                    this.state = WorkerState.CPU_ACQUIRED;
                    bl = true;
                } else {
                    bl = false;
                }
            }
            return bl;
        }

        public final boolean tryReleaseCpu(@NotNull WorkerState newState) {
            boolean hadCpu;
            WorkerState previousState = this.state;
            boolean bl = hadCpu = previousState == WorkerState.CPU_ACQUIRED;
            if (hadCpu) {
                CoroutineScheduler this_$iv = CoroutineScheduler.this;
                boolean $i$f$releaseCpuPermit = false;
                controlState$FU.addAndGet(this_$iv, 0x40000000000L);
            }
            if (previousState != newState) {
                this.state = newState;
            }
            return hadCpu;
        }

        @Override
        public void run() {
            this.runWorker();
        }

        private final void runWorker() {
            boolean rescanned = false;
            while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                Task task = this.findTask(this.mayHaveLocalTasks);
                if (task != null) {
                    rescanned = false;
                    this.minDelayUntilStealableTaskNs = 0L;
                    this.executeTask(task);
                    continue;
                }
                this.mayHaveLocalTasks = false;
                if (this.minDelayUntilStealableTaskNs != 0L) {
                    if (!rescanned) {
                        rescanned = true;
                        continue;
                    }
                    rescanned = false;
                    this.tryReleaseCpu(WorkerState.PARKING);
                    Thread.interrupted();
                    LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                    this.minDelayUntilStealableTaskNs = 0L;
                    continue;
                }
                this.tryPark();
            }
            this.tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final long runSingleTask() {
            Task task;
            WorkerState stateSnapshot = this.state;
            boolean isCpuThread = this.state == WorkerState.CPU_ACQUIRED;
            Task task2 = task = isCpuThread ? this.findCpuTask() : this.findBlockingTask();
            if (task == null) {
                if (this.minDelayUntilStealableTaskNs == 0L) {
                    return -1L;
                }
                return this.minDelayUntilStealableTaskNs;
            }
            CoroutineScheduler.this.runSafely(task);
            if (!isCpuThread) {
                CoroutineScheduler this_$iv = CoroutineScheduler.this;
                boolean $i$f$decrementBlockingTasks = false;
                controlState$FU.addAndGet(this_$iv, -2097152L);
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(this.state == stateSnapshot)) {
                    throw new AssertionError();
                }
            }
            return 0L;
        }

        public final boolean isIo() {
            return this.state == WorkerState.BLOCKING;
        }

        private final void tryPark() {
            if (!this.inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            workerCtl$FU.set(this, -1);
            while (this.inStack() && workerCtl$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                this.tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                this.park();
            }
        }

        private final boolean inStack() {
            return this.nextParkedWorker != NOT_IN_STACK;
        }

        private final void executeTask(Task task) {
            Task this_$iv = task;
            boolean $i$f$getMode$kotlinx_coroutines_core = false;
            int taskMode = this_$iv.taskContext.getTaskMode();
            this.idleReset(taskMode);
            this.beforeTask(taskMode);
            CoroutineScheduler.this.runSafely(task);
            this.afterTask(taskMode);
        }

        private final void beforeTask(int taskMode) {
            if (taskMode == 0) {
                return;
            }
            if (this.tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork();
            }
        }

        private final void afterTask(int taskMode) {
            if (taskMode == 0) {
                return;
            }
            CoroutineScheduler this_$iv = CoroutineScheduler.this;
            boolean $i$f$decrementBlockingTasks = false;
            controlState$FU.addAndGet(this_$iv, -2097152L);
            WorkerState currentState = this.state;
            if (currentState != WorkerState.TERMINATED) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl = false;
                    if (!(currentState == WorkerState.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.DORMANT;
            }
        }

        public final int nextInt(int upperBound) {
            int r = this.rngState;
            r ^= r << 13;
            r ^= r >> 17;
            r ^= r << 5;
            this.rngState = r;
            int mask = upperBound - 1;
            if ((mask & upperBound) == 0) {
                return r & mask;
            }
            return (r & Integer.MAX_VALUE) % upperBound;
        }

        private final void park() {
            if (this.terminationDeadline == 0L) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0L) {
                this.terminationDeadline = 0L;
                this.tryTerminateWorker();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * WARNING - void declaration
         */
        private final void tryTerminateWorker() {
            void lock$iv;
            ResizableAtomicArray<Worker> resizableAtomicArray = CoroutineScheduler.this.workers;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            void var5_5 = lock$iv;
            synchronized (var5_5) {
                boolean bl = false;
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                CoroutineScheduler this_$iv = coroutineScheduler;
                boolean $i$f$getCreatedWorkers = false;
                if ((int)(controlState$FU.get(this_$iv) & 0x1FFFFFL) <= coroutineScheduler.corePoolSize) {
                    return;
                }
                if (!workerCtl$FU.compareAndSet(this, -1, 1)) {
                    return;
                }
                int oldIndex = this.indexInArray;
                this.setIndexInArray(0);
                coroutineScheduler.parkedWorkersStackTopUpdate(this, oldIndex, 0);
                CoroutineScheduler this_$iv2 = coroutineScheduler;
                boolean $i$f$decrementCreatedWorkers = false;
                CoroutineScheduler coroutineScheduler2 = this_$iv2;
                long state$iv$iv = controlState$FU.getAndDecrement(this_$iv2);
                boolean $i$f$createdWorkers = false;
                int lastIndex = (int)(state$iv$iv & 0x1FFFFFL);
                if (lastIndex != oldIndex) {
                    Worker worker = coroutineScheduler.workers.get(lastIndex);
                    Intrinsics.checkNotNull((Object)worker);
                    Worker lastWorker = worker;
                    coroutineScheduler.workers.setSynchronized(oldIndex, lastWorker);
                    lastWorker.setIndexInArray(oldIndex);
                    coroutineScheduler.parkedWorkersStackTopUpdate(lastWorker, lastIndex, oldIndex);
                }
                coroutineScheduler.workers.setSynchronized(lastIndex, null);
                Unit unit = Unit.INSTANCE;
            }
            this.state = WorkerState.TERMINATED;
        }

        private final void idleReset(int mode) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl = false;
                    if (!(mode == 1)) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
            }
        }

        @Nullable
        public final Task findTask(boolean mayHaveLocalTasks) {
            if (this.tryAcquireCpuPermit()) {
                return this.findAnyTask(mayHaveLocalTasks);
            }
            return this.findBlockingTask();
        }

        private final Task findBlockingTask() {
            Task task = this.localQueue.pollBlocking();
            if (task == null && (task = (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull()) == null) {
                task = this.trySteal(1);
            }
            return task;
        }

        private final Task findCpuTask() {
            Task task = this.localQueue.pollCpu();
            if (task == null && (task = (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull()) == null) {
                task = this.trySteal(2);
            }
            return task;
        }

        private final Task findAnyTask(boolean scanLocalQueue) {
            if (scanLocalQueue) {
                Task task;
                boolean globalFirst;
                boolean bl = globalFirst = this.nextInt(2 * CoroutineScheduler.this.corePoolSize) == 0;
                if (globalFirst && (task = this.pollGlobalQueues()) != null) {
                    Task it = task;
                    boolean bl2 = false;
                    return it;
                }
                task = this.localQueue.poll();
                if (task != null) {
                    Task it = task;
                    boolean bl3 = false;
                    return it;
                }
                if (!globalFirst && (task = this.pollGlobalQueues()) != null) {
                    Task it = task;
                    boolean bl4 = false;
                    return it;
                }
            } else {
                Task task = this.pollGlobalQueues();
                if (task != null) {
                    Task it = task;
                    boolean bl = false;
                    return it;
                }
            }
            return this.trySteal(3);
        }

        private final Task pollGlobalQueues() {
            if (this.nextInt(2) == 0) {
                Task task = (Task)CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (task != null) {
                    Task it = task;
                    boolean bl = false;
                    return it;
                }
                return (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task task = (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (task != null) {
                Task it = task;
                boolean bl = false;
                return it;
            }
            return (Task)CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        private final Task trySteal(int stealingMode) {
            CoroutineScheduler this_$iv = CoroutineScheduler.this;
            boolean $i$f$getCreatedWorkers = false;
            int created = (int)(controlState$FU.get(this_$iv) & 0x1FFFFFL);
            if (created < 2) {
                return null;
            }
            int currentIndex = 0;
            currentIndex = this.nextInt(created);
            long minDelay = 0L;
            minDelay = Long.MAX_VALUE;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            for (int i2 = 0; i2 < created; ++i2) {
                Worker worker;
                int it = i2;
                boolean bl = false;
                if (++currentIndex > created) {
                    currentIndex = 1;
                }
                if ((worker = coroutineScheduler.workers.get(currentIndex)) == null || worker == this) continue;
                long stealResult = worker.localQueue.trySteal(stealingMode, this.stolenTask);
                if (stealResult == -1L) {
                    Task result2 = (Task)this.stolenTask.element;
                    this.stolenTask.element = null;
                    return result2;
                }
                if (stealResult <= 0L) continue;
                minDelay = Math.min(minDelay, stealResult);
            }
            this.minDelayUntilStealableTaskNs = minDelay != Long.MAX_VALUE ? minDelay : 0L;
            return null;
        }

        @NotNull
        public static final AtomicIntegerFieldUpdater getWorkerCtl$FU() {
            return workerCtl$FU;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"})
    public static final class WorkerState
    extends Enum<WorkerState> {
        public static final /* enum */ WorkerState CPU_ACQUIRED = new WorkerState();
        public static final /* enum */ WorkerState BLOCKING = new WorkerState();
        public static final /* enum */ WorkerState PARKING = new WorkerState();
        public static final /* enum */ WorkerState DORMANT = new WorkerState();
        public static final /* enum */ WorkerState TERMINATED = new WorkerState();
        private static final /* synthetic */ WorkerState[] $VALUES;

        public static WorkerState[] values() {
            return (WorkerState[])$VALUES.clone();
        }

        public static WorkerState valueOf(String value) {
            return Enum.valueOf(WorkerState.class, value);
        }

        static {
            $VALUES = workerStateArray = new WorkerState[]{WorkerState.CPU_ACQUIRED, WorkerState.BLOCKING, WorkerState.PARKING, WorkerState.DORMANT, WorkerState.TERMINATED};
        }
    }
}

