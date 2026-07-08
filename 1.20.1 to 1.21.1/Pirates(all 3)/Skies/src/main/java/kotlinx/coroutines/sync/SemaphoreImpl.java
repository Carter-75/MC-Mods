/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KFunction
 */
package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.coroutines.sync.SemaphoreSegment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00102\u001a\u00020\u0016\u0012\u0006\u00105\u001a\u00020\u0016\u00a2\u0006\u0004\b6\u00107J\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004Jd\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00028\u00002!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u00072!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00020\u0007H\u0083\b\u00a2\u0006\u0004\b\u0003\u0010\rJ\u001d\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0005\u00a2\u0006\u0004\b\u0003\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001d\u001a\u00020\u00022\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001f\u0010\u0015J\u000f\u0010 \u001a\u00020\nH\u0016\u00a2\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\"\u0010!J\u0013\u0010#\u001a\u00020\n*\u00020\u001bH\u0002\u00a2\u0006\u0004\b#\u0010$R\u000b\u0010&\u001a\u00020%8\u0002X\u0082\u0004R\u0014\u0010(\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0018R\u000b\u0010*\u001a\u00020)8\u0002X\u0082\u0004R\u000b\u0010+\u001a\u00020)8\u0002X\u0082\u0004R\u0011\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004R \u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0011\u00104\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2={"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "W", "waiter", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "suspend", "onAcquired", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancellableContinuation;", "(Lkotlinx/coroutines/CancellableContinuation;)V", "acquireSlowPath", "Lkotlinx/coroutines/Waiter;", "addAcquireToQueue", "(Lkotlinx/coroutines/Waiter;)Z", "coerceAvailablePermitsAtMaximum", "()V", "", "decPermits", "()I", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "ignoredParam", "onAcquireRegFunction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "release", "tryAcquire", "()Z", "tryResumeNextFromQueue", "tryResumeAcquire", "(Ljava/lang/Object;)Z", "Lkotlinx/atomicfu/AtomicInt;", "_availablePermits", "getAvailablePermits", "availablePermits", "Lkotlinx/atomicfu/AtomicLong;", "deqIdx", "enqIdx", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "head", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "permits", "I", "tail", "acquiredPermits", "<init>", "(II)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 5 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n205#1,10:411\n205#1,10:421\n1#2:398\n332#3,12:399\n72#4,3:431\n46#4,8:434\n72#4,3:445\n46#4,8:448\n375#5:442\n375#5:443\n367#5:444\n378#5:456\n367#5:457\n375#5:458\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n*L\n197#1:411,10\n221#1:421,10\n187#1:399,12\n289#1:431,3\n289#1:434,8\n322#1:445,3\n322#1:448,8\n293#1:442\n299#1:443\n313#1:444\n328#1:456\n334#1:457\n337#1:458\n*E\n"})
public class SemaphoreImpl
implements Semaphore {
    private final int permits;
    @Volatile
    @Nullable
    private volatile Object head;
    @Volatile
    private volatile long deqIdx;
    @Volatile
    @Nullable
    private volatile Object tail;
    @Volatile
    private volatile long enqIdx;
    @Volatile
    private volatile int _availablePermits;
    @NotNull
    private final Function1<Throwable, Unit> onCancellationRelease;
    @NotNull
    private static final AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    @NotNull
    private static final AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    @NotNull
    private static final AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    @NotNull
    private static final AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    @NotNull
    private static final AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    public SemaphoreImpl(int permits, int acquiredPermits) {
        this.permits = permits;
        if (!(this.permits > 0)) {
            boolean $i$a$-require-SemaphoreImpl$32 = false;
            String $i$a$-require-SemaphoreImpl$32 = "Semaphore should have at least 1 permit, but had " + this.permits;
            throw new IllegalArgumentException($i$a$-require-SemaphoreImpl$32.toString());
        }
        if (!(0 <= acquiredPermits ? acquiredPermits <= this.permits : false)) {
            boolean bl = false;
            String string = "The number of acquired permits should be in 0.." + this.permits;
            throw new IllegalArgumentException(string.toString());
        }
        SemaphoreSegment s = new SemaphoreSegment(0L, null, 2);
        this.head = s;
        this.tail = s;
        this._availablePermits = this.permits - acquiredPermits;
        this.onCancellationRelease = (Function1)new Function1<Throwable, Unit>(this){
            final /* synthetic */ SemaphoreImpl this$0;
            {
                this.this$0 = $receiver;
                super(1);
            }

            public final void invoke(@NotNull Throwable throwable) {
                this.this$0.release();
            }
        };
    }

    @Override
    public int getAvailablePermits() {
        return Math.max(_availablePermits$FU.get(this), 0);
    }

    @Override
    public boolean tryAcquire() {
        while (true) {
            int p;
            if ((p = _availablePermits$FU.get(this)) > this.permits) {
                this.coerceAvailablePermitsAtMaximum();
                continue;
            }
            if (p <= 0) {
                return false;
            }
            if (_availablePermits$FU.compareAndSet(this, p, p - 1)) break;
        }
        return true;
    }

    @Override
    @Nullable
    public Object acquire(@NotNull Continuation<? super Unit> $completion) {
        return SemaphoreImpl.acquire$suspendImpl(this, $completion);
    }

    static /* synthetic */ Object acquire$suspendImpl(SemaphoreImpl $this, Continuation<? super Unit> $completion) {
        int p = $this.decPermits();
        if (p > 0) {
            return Unit.INSTANCE;
        }
        Object object = $this.acquireSlowPath($completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final Object acquireSlowPath(Continuation<? super Unit> $completion) {
        boolean $i$f$suspendCancellableCoroutineReusable = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont$iv));
        try {
            CancellableContinuationImpl cont = cancellable$iv;
            boolean bl2 = false;
            if (!this.addAcquireToQueue(cont)) {
                this.acquire(cont);
            }
        }
        catch (Throwable e$iv) {
            cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw e$iv;
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    protected final void acquire(@NotNull CancellableContinuation<? super Unit> waiter) {
        CancellableContinuation<? super Unit> cont;
        SemaphoreImpl this_$iv = this;
        boolean $i$f$acquire = false;
        do {
            int p$iv;
            if ((p$iv = this_$iv.decPermits()) > 0) {
                cont = waiter;
                boolean bl = false;
                cont.resume((Unit)Unit.INSTANCE, this.onCancellationRelease);
                break;
            }
            cont = waiter;
            boolean bl = false;
            Intrinsics.checkNotNull(cont, (String)"null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        } while (!this.addAcquireToQueue((Waiter)((Object)cont)));
    }

    private final <W> void acquire(W waiter, Function1<? super W, Boolean> suspend, Function1<? super W, Unit> onAcquired) {
        boolean $i$f$acquire = false;
        do {
            int p;
            if ((p = this.decPermits()) <= 0) continue;
            onAcquired.invoke(waiter);
            return;
        } while (!((Boolean)suspend.invoke(waiter)).booleanValue());
    }

    protected final void onAcquireRegFunction(@NotNull SelectInstance<?> select, @Nullable Object ignoredParam) {
        SelectInstance<?> s;
        SemaphoreImpl this_$iv = this;
        boolean $i$f$acquire = false;
        do {
            int p$iv;
            if ((p$iv = this_$iv.decPermits()) > 0) {
                s = select;
                boolean bl = false;
                s.selectInRegistrationPhase(Unit.INSTANCE);
                break;
            }
            s = select;
            boolean bl = false;
            Intrinsics.checkNotNull(s, (String)"null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        } while (!this.addAcquireToQueue((Waiter)((Object)s)));
    }

    private final int decPermits() {
        int p;
        while ((p = _availablePermits$FU.getAndDecrement(this)) > this.permits) {
        }
        return p;
    }

    @Override
    public void release() {
        do {
            int p;
            if ((p = _availablePermits$FU.getAndIncrement(this)) >= this.permits) {
                this.coerceAvailablePermitsAtMaximum();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
            if (p < 0) continue;
            return;
        } while (!this.tryResumeNextFromQueue());
    }

    private final void coerceAvailablePermitsAtMaximum() {
        int cur;
        while ((cur = _availablePermits$FU.get(this)) > this.permits && !_availablePermits$FU.compareAndSet(this, cur, this.permits)) {
        }
    }

    /*
     * WARNING - void declaration
     */
    private final boolean addAcquireToQueue(Waiter waiter) {
        Object this_$iv;
        Object s$iv;
        SemaphoreSegment curTail = (SemaphoreSegment)tail$FU.get(this);
        long enqIdx = enqIdx$FU.getAndIncrement(this);
        KFunction createNewSegment2 = (KFunction)addAcquireToQueue.createNewSegment.1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = tail$FU;
        long id$iv22 = enqIdx / (long)SemaphoreKt.access$getSEGMENT_SIZE$p();
        boolean $i$f$findSegmentAndMoveForward$atomicfu = false;
        while (!SegmentOrClosed.isClosed-impl(s$iv = ConcurrentLinkedListKt.findSegmentInternal((Segment)curTail, id$iv22, (Function2)createNewSegment2))) {
            boolean bl;
            Object to$iv$iv = SegmentOrClosed.getSegment-impl(s$iv);
            boolean $i$f$moveForward$atomicfu = false;
            boolean $i$f$loop$atomicfu = false;
            while (true) {
                void atomicfu$handler$iv;
                Segment cur$iv$iv = (Segment)atomicfu$handler$iv.get(this);
                boolean bl2 = false;
                if (cur$iv$iv.id >= ((Segment)to$iv$iv).id) {
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl = false;
                    break;
                }
                if (atomicfu$handler$iv.compareAndSet(this, cur$iv$iv, to$iv$iv)) {
                    if (cur$iv$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv$iv.remove();
                    }
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv$iv).remove();
            }
            if (!bl) continue;
        }
        SemaphoreSegment segment = (SemaphoreSegment)SegmentOrClosed.getSegment-impl(s$iv);
        int i2 = (int)(enqIdx % (long)SemaphoreKt.access$getSEGMENT_SIZE$p());
        SemaphoreSegment id$iv22 = segment;
        Symbol expected$iv = null;
        boolean $i$f$cas = false;
        if (((SemaphoreSegment)this_$iv).getAcquirers().compareAndSet(i2, expected$iv, waiter)) {
            waiter.invokeOnCancellation(segment, i2);
            return true;
        }
        this_$iv = segment;
        expected$iv = SemaphoreKt.access$getPERMIT$p();
        Symbol value$iv = SemaphoreKt.access$getTAKEN$p();
        boolean $i$f$cas2 = false;
        if (((SemaphoreSegment)this_$iv).getAcquirers().compareAndSet(i2, expected$iv, value$iv)) {
            this_$iv = waiter;
            if (this_$iv instanceof CancellableContinuation) {
                Intrinsics.checkNotNull((Object)waiter, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                CancellableContinuation cfr_ignored_0 = (CancellableContinuation)((Object)waiter);
                ((CancellableContinuation)((Object)waiter)).resume(Unit.INSTANCE, this.onCancellationRelease);
            } else if (this_$iv instanceof SelectInstance) {
                ((SelectInstance)((Object)waiter)).selectInRegistrationPhase(Unit.INSTANCE);
            } else {
                throw new IllegalStateException(("unexpected: " + waiter).toString());
            }
            return true;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            SemaphoreSegment this_$iv2 = segment;
            boolean $i$f$get = false;
            if (!(this_$iv2.getAcquirers().get(i2) == SemaphoreKt.access$getBROKEN$p())) {
                throw new AssertionError();
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private final boolean tryResumeNextFromQueue() {
        void this_$iv222;
        Object s$iv;
        SemaphoreSegment curHead = (SemaphoreSegment)head$FU.get(this);
        long deqIdx = deqIdx$FU.getAndIncrement(this);
        long id = deqIdx / (long)SemaphoreKt.access$getSEGMENT_SIZE$p();
        KFunction createNewSegment2 = (KFunction)tryResumeNextFromQueue.createNewSegment.1.INSTANCE;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = head$FU;
        boolean $i$f$findSegmentAndMoveForward$atomicfu = false;
        while (!SegmentOrClosed.isClosed-impl(s$iv = ConcurrentLinkedListKt.findSegmentInternal((Segment)curHead, id, (Function2)createNewSegment2))) {
            boolean bl;
            Object to$iv$iv = SegmentOrClosed.getSegment-impl(s$iv);
            boolean $i$f$moveForward$atomicfu = false;
            boolean $i$f$loop$atomicfu = false;
            while (true) {
                Segment cur$iv$iv = (Segment)atomicfu$handler$iv.get(this);
                boolean bl2 = false;
                if (cur$iv$iv.id >= ((Segment)to$iv$iv).id) {
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl = false;
                    break;
                }
                if (atomicfu$handler$iv.compareAndSet(this, cur$iv$iv, to$iv$iv)) {
                    if (cur$iv$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv$iv.remove();
                    }
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv$iv).remove();
            }
            if (!bl) continue;
        }
        SemaphoreSegment segment = (SemaphoreSegment)SegmentOrClosed.getSegment-impl(s$iv);
        segment.cleanPrev();
        if (segment.id > id) {
            return false;
        }
        int i2 = (int)(deqIdx % (long)SemaphoreKt.access$getSEGMENT_SIZE$p());
        s$iv = segment;
        Symbol value$iv222 = SemaphoreKt.access$getPERMIT$p();
        boolean $i$f$getAndSet = false;
        Symbol cellState = this_$iv222.getAcquirers().getAndSet(i2, value$iv222);
        if (cellState == null) {
            void expected$iv;
            int this_$iv222 = SemaphoreKt.access$getMAX_SPIN_CYCLES$p();
            int value$iv222 = 0;
            while (value$iv222 < this_$iv222) {
                int it = value$iv222++;
                boolean bl = false;
                SemaphoreSegment this_$iv = segment;
                boolean $i$f$get = false;
                if (this_$iv.getAcquirers().get(i2) != SemaphoreKt.access$getTAKEN$p()) continue;
                return true;
            }
            SemaphoreSegment this_$iv222 = segment;
            Symbol value$iv222 = SemaphoreKt.access$getPERMIT$p();
            Symbol value$iv = SemaphoreKt.access$getBROKEN$p();
            boolean $i$f$cas = false;
            return !this_$iv222.getAcquirers().compareAndSet(i2, expected$iv, value$iv);
        }
        if (cellState == SemaphoreKt.access$getCANCELLED$p()) {
            return false;
        }
        return this.tryResumeAcquire(cellState);
    }

    private final boolean tryResumeAcquire(Object $this$tryResumeAcquire) {
        boolean bl;
        Object object = $this$tryResumeAcquire;
        if (object instanceof CancellableContinuation) {
            Intrinsics.checkNotNull((Object)$this$tryResumeAcquire, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cfr_ignored_0 = (CancellableContinuation)$this$tryResumeAcquire;
            Object token2 = ((CancellableContinuation)$this$tryResumeAcquire).tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
            if (token2 != null) {
                ((CancellableContinuation)$this$tryResumeAcquire).completeResume(token2);
                bl = true;
            } else {
                bl = false;
            }
        } else if (object instanceof SelectInstance) {
            bl = ((SelectInstance)$this$tryResumeAcquire).trySelect(this, Unit.INSTANCE);
        } else {
            throw new IllegalStateException(("unexpected: " + $this$tryResumeAcquire).toString());
        }
        return bl;
    }

    public static final /* synthetic */ Object access$acquireSlowPath(SemaphoreImpl $this, Continuation $completion) {
        return $this.acquireSlowPath((Continuation<? super Unit>)$completion);
    }
}

