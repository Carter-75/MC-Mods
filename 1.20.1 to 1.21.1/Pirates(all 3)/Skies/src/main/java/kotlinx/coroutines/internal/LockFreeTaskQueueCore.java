/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 5*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u000256B\u0017\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\r\u00a2\u0006\u0004\b3\u00104J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\f\u0010\u000bJ\r\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u000fJ-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017\"\u0004\b\u0001\u0010\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ3\u0010\"\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\t2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\"\u0010#R%\u0010%\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\t0$8\u0002X\u0082\u0004R\u000b\u0010'\u001a\u00020&8\u0002X\u0082\u0004R\u0013\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010(8\u0002X\u0082\u0004R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u000fR\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u0010.\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0011\u00102\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u00a8\u00067"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "element", "", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/atomicfu/AtomicRef;", "_next", "Lkotlinx/atomicfu/AtomicLong;", "_state", "Lkotlinx/atomicfu/AtomicArray;", "array", "capacity", "I", "isEmpty", "mask", "singleConsumer", "Z", "getSize", "()I", "size", "<init>", "(IZ)V", "Companion", "Placeholder", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nLockFreeTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n+ 2 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n299#2,3:309\n299#2,3:312\n299#2,3:315\n299#2,3:318\n299#2,3:321\n299#2,3:325\n299#2,3:328\n1#3:324\n*S KotlinDebug\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n*L\n91#1:309,3\n92#1:312,3\n107#1:315,3\n167#1:318,3\n200#1:321,3\n231#1:325,3\n247#1:328,3\n*E\n"})
public final class LockFreeTaskQueueCore<E> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int capacity;
    private final boolean singleConsumer;
    private final int mask;
    @Volatile
    @Nullable
    private volatile Object _next;
    @Volatile
    private volatile long _state;
    @NotNull
    private final AtomicReferenceArray array;
    @NotNull
    private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    @NotNull
    private static final AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    public static final int INITIAL_CAPACITY = 8;
    public static final int CAPACITY_BITS = 30;
    public static final int MAX_CAPACITY_MASK = 0x3FFFFFFF;
    public static final int HEAD_SHIFT = 0;
    public static final long HEAD_MASK = 0x3FFFFFFFL;
    public static final int TAIL_SHIFT = 30;
    public static final long TAIL_MASK = 0xFFFFFFFC0000000L;
    public static final int FROZEN_SHIFT = 60;
    public static final long FROZEN_MASK = 0x1000000000000000L;
    public static final int CLOSED_SHIFT = 61;
    public static final long CLOSED_MASK = 0x2000000000000000L;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    @JvmField
    @NotNull
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    public static final int ADD_SUCCESS = 0;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_CLOSED = 2;

    public LockFreeTaskQueueCore(int capacity, boolean singleConsumer) {
        this.capacity = capacity;
        this.singleConsumer = singleConsumer;
        this.mask = this.capacity - 1;
        this.array = new AtomicReferenceArray(this.capacity);
        if (!(this.mask <= 0x3FFFFFFF)) {
            String string = "Check failed.";
            throw new IllegalStateException(string.toString());
        }
        if (!((this.capacity & this.mask) == 0)) {
            String string = "Check failed.";
            throw new IllegalStateException(string.toString());
        }
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isEmpty() {
        void tail;
        int tail$iv;
        Companion companion = Companion;
        long $this$withState$iv = _state$FU.get(this);
        boolean $i$f$withState = false;
        int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
        int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
        int head = head$iv;
        boolean bl = false;
        return head == tail;
    }

    /*
     * WARNING - void declaration
     */
    public final int getSize() {
        void tail;
        int tail$iv;
        Companion companion = Companion;
        long $this$withState$iv = _state$FU.get(this);
        boolean $i$f$withState = false;
        int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
        int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
        int head = head$iv;
        boolean bl = false;
        return tail - head & 0x3FFFFFFF;
    }

    public final boolean close() {
        long state;
        long l2;
        long l3;
        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$update$atomicfu = false;
        do {
            state = l3 = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if ((state & 0x2000000000000000L) != 0L) {
                return true;
            }
            if ((state & 0x1000000000000000L) == 0L) continue;
            return false;
        } while (!atomicfu$handler$iv.compareAndSet(this, l3, l2 = state | 0x2000000000000000L));
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public final int addLast(@NotNull E element) {
        void tail;
        int mask;
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            int tail$iv;
            long state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if ((state & 0x3000000000000000L) != 0L) {
                return Companion.addFailReason(state);
            }
            Companion companion = Companion;
            long $this$withState$iv = state;
            boolean $i$f$withState = false;
            int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
            int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
            int head = head$iv;
            boolean bl2 = false;
            mask = this.mask;
            if ((tail + 2 & mask) == (head & mask)) {
                return 1;
            }
            if (!this.singleConsumer && this.array.get(tail & mask) != null) {
                if (this.capacity >= 1024 && (tail - head & 0x3FFFFFFF) <= this.capacity >> 1) continue;
                return 1;
            }
            int newTail = tail + true & 0x3FFFFFFF;
            if (_state$FU.compareAndSet(this, state, Companion.updateTail(state, newTail))) break;
        }
        this.array.set(tail & mask, element);
        LockFreeTaskQueueCore<E> cur = this;
        while ((_state$FU.get(cur) & 0x1000000000000000L) != 0L && super.fillPlaceholder((int)tail, element) != null) {
        }
        return 0;
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int index, E element) {
        Object old = this.array.get(index & this.mask);
        if (old instanceof Placeholder && ((Placeholder)old).index == index) {
            this.array.set(index & this.mask, element);
            return this;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object removeFirstOrNull() {
        var1_1 = this;
        atomicfu$handler$iv = LockFreeTaskQueueCore._state$FU;
        $i$f$loop$atomicfu = false;
        do lbl-1000:
        // 3 sources

        {
            block5: {
                state = atomicfu$handler$iv.get(this);
                $i$a$-loop$atomicfu-LockFreeTaskQueueCore$removeFirstOrNull$1 = false;
                if ((state & 0x1000000000000000L) != 0L) {
                    return LockFreeTaskQueueCore.REMOVE_FROZEN;
                }
                var7_6 = LockFreeTaskQueueCore.Companion;
                $this$withState$iv = state;
                $i$f$withState = false;
                head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
                var13_11 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
                head = head$iv;
                $i$a$-withState-LockFreeTaskQueueCore$removeFirstOrNull$1$1 = false;
                if ((tail & this.mask) == (head & this.mask)) {
                    return null;
                }
                element = this.array.get(head & this.mask);
                if (element != null) break block5;
                if (!this.singleConsumer) ** GOTO lbl-1000
                return null;
            }
            if (element instanceof Placeholder) {
                return null;
            }
            newHead = head + 1 & 0x3FFFFFFF;
            if (!LockFreeTaskQueueCore._state$FU.compareAndSet(this, state, LockFreeTaskQueueCore.Companion.updateHead(state, newHead))) continue;
            this.array.set(head & this.mask, null);
            return element;
        } while (!this.singleConsumer);
        cur = this;
        while (true) {
            if (cur.removeSlowPath(head, newHead) != null) continue;
            return element;
        }
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int oldHead, int newHead) {
        int head;
        long state;
        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            Companion companion = Companion;
            long $this$withState$iv = state;
            boolean $i$f$withState = false;
            int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
            int tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
            head = head$iv;
            boolean bl2 = false;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl3 = false;
                if (!(head == oldHead)) {
                    throw new AssertionError();
                }
            }
            if ((state & 0x1000000000000000L) == 0L) continue;
            return this.next();
        } while (!_state$FU.compareAndSet(this, state, Companion.updateHead(state, newHead)));
        this.array.set(head & this.mask, null);
        return null;
    }

    @NotNull
    public final LockFreeTaskQueueCore<E> next() {
        return this.allocateOrGetNextCopy(this.markFrozen());
    }

    private final long markFrozen() {
        long state;
        long l2;
        long l3;
        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$updateAndGet$atomicfu = false;
        do {
            state = l3 = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if ((state & 0x1000000000000000L) == 0L) continue;
            return state;
        } while (!atomicfu$handler$iv.compareAndSet(this, l3, l2 = state | 0x1000000000000000L));
        return l2;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long state) {
        LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _next$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            LockFreeTaskQueueCore next = (LockFreeTaskQueueCore)atomicfu$handler$iv.get(this);
            boolean bl = false;
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = next;
            if (lockFreeTaskQueueCore2 != null) {
                return lockFreeTaskQueueCore2;
            }
            _next$FU.compareAndSet(this, null, this.allocateNextCopy(state));
        }
    }

    /*
     * WARNING - void declaration
     */
    private final LockFreeTaskQueueCore<E> allocateNextCopy(long state) {
        void tail;
        int tail$iv;
        LockFreeTaskQueueCore<E> next = new LockFreeTaskQueueCore<E>(this.capacity * 2, this.singleConsumer);
        Companion companion = Companion;
        long $this$withState$iv = state;
        boolean $i$f$withState = false;
        int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
        int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
        int head = head$iv;
        boolean bl = false;
        int index = head;
        while ((index & this.mask) != (tail & this.mask)) {
            Object object = this.array.get(index & this.mask);
            if (object == null) {
                object = new Placeholder(index);
            }
            Object value = object;
            next.array.set(index & next.mask, value);
            ++index;
        }
        _state$FU.set(next, Companion.wo(state, 0x1000000000000000L));
        return next;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <R> List<R> map(@NotNull Function1<? super E, ? extends R> transform2) {
        void tail;
        int tail$iv;
        ArrayList<Object> res = new ArrayList<Object>(this.capacity);
        Companion companion = Companion;
        long $this$withState$iv = _state$FU.get(this);
        boolean $i$f$withState = false;
        int head$iv = (int)(($this$withState$iv & 0x3FFFFFFFL) >> 0);
        int n2 = tail$iv = (int)(($this$withState$iv & 0xFFFFFFFC0000000L) >> 30);
        int head = head$iv;
        boolean bl = false;
        int index = head;
        while ((index & this.mask) != (tail & this.mask)) {
            Object element = this.array.get(index & this.mask);
            if (element != null && !(element instanceof Placeholder)) {
                res.add(transform2.invoke(element));
            }
            ++index;
        }
        return res;
    }

    public final boolean isClosed() {
        return (_state$FU.get(this) & 0x2000000000000000L) != 0L;
    }

    private final void update$atomicfu(AtomicLongFieldUpdater atomicfu$handler, Function1<? super Long, Long> atomicfu$action, Object atomicfu$dispatchReceiver) {
        Object object;
        long l2;
        boolean $i$f$update$atomicfu = false;
        while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, l2 = atomicfu$handler.get(atomicfu$dispatchReceiver), ((Number)(object = atomicfu$action.invoke((Object)l2))).longValue())) {
        }
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicfu$handler, Function1<? super Long, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            long l2 = atomicfu$handler.get(atomicfu$dispatchReceiver);
            atomicfu$action.invoke((Object)l2);
        }
    }

    private final long updateAndGet$atomicfu(AtomicLongFieldUpdater atomicfu$handler, Function1<? super Long, Long> atomicfu$action, Object atomicfu$dispatchReceiver) {
        Object object;
        long l2;
        boolean $i$f$updateAndGet$atomicfu = false;
        while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, l2 = atomicfu$handler.get(atomicfu$dispatchReceiver), ((Number)(object = atomicfu$action.invoke((Object)l2))).longValue())) {
        }
        return ((Number)object).longValue();
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\bJR\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u000b*\u00020\u000226\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00010\fH\u0086\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0015\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0086\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u0014\u0010$\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0018R\u0014\u0010%\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0018R\u0014\u0010'\u001a\u00020&8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u001dR\u0014\u0010*\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0018\u00a8\u0006-"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "", "", "addFailReason", "(J)I", "newHead", "updateHead", "(JI)J", "newTail", "updateTail", "T", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "block", "withState", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "other", "wo", "(JJ)J", "ADD_CLOSED", "I", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "J", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "Lkotlinx/coroutines/internal/Symbol;", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Companion {
        private Companion() {
        }

        public final long wo(long $this$wo, long other) {
            return $this$wo & (other ^ 0xFFFFFFFFFFFFFFFFL);
        }

        public final long updateHead(long $this$updateHead, int newHead) {
            return this.wo($this$updateHead, 0x3FFFFFFFL) | (long)newHead << 0;
        }

        public final long updateTail(long $this$updateTail, int newTail) {
            return this.wo($this$updateTail, 0xFFFFFFFC0000000L) | (long)newTail << 30;
        }

        public final <T> T withState(long $this$withState, @NotNull Function2<? super Integer, ? super Integer, ? extends T> block) {
            boolean $i$f$withState = false;
            int head = (int)(($this$withState & 0x3FFFFFFFL) >> 0);
            int tail = (int)(($this$withState & 0xFFFFFFFC0000000L) >> 30);
            return (T)block.invoke((Object)head, (Object)tail);
        }

        public final int addFailReason(long $this$addFailReason) {
            return ($this$addFailReason & 0x2000000000000000L) != 0L ? 2 : 1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "", "index", "I", "<init>", "(I)V", "kotlinx-coroutines-core"})
    public static final class Placeholder {
        @JvmField
        public final int index;

        public Placeholder(int index) {
            this.index = index;
        }
    }
}

