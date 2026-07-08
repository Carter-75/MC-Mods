/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007\u00a2\u0006\u0004\b7\u0010\u0011J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\tJ.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u0016\u001a\u0004\u0018\u00018\u00002!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001bH\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00028\u00002\u0006\u0010!\u001a\u00020 H\u0001\u00a2\u0006\u0004\b\"\u0010#J&\u0010$\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b\u00a2\u0006\u0004\b$\u0010\u0017J\u000f\u0010%\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b%\u0010\u0019J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020 H\u0082\u0010\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010&\u001a\u00020 H\u0082\u0010\u00a2\u0006\u0004\b)\u0010(J\u001f\u0010+\u001a\u00020\u00072\u0006\u0010&\u001a\u00020 2\u0006\u0010*\u001a\u00020 H\u0002\u00a2\u0006\u0004\b+\u0010,R\u000b\u0010.\u001a\u00020-8\u0002X\u0082\u0004R \u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0011\u00101\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b1\u00102R$\u00106\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020 8F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u0010(\u00a8\u00068"}, d2={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "()V", "Lkotlin/ParameterName;", "name", "value", "predicate", "find", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "Lkotlinx/atomicfu/AtomicInt;", "_size", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "getSize", "()I", "setSize", "size", "<init>", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
@SourceDebugExtension(value={"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n28#2,4:169\n28#2,4:174\n28#2,4:179\n28#2,4:184\n28#2,4:189\n28#2,4:194\n28#2,4:199\n28#2,4:204\n20#3:173\n20#3:178\n20#3:183\n20#3:188\n20#3:193\n20#3:198\n20#3:203\n20#3:208\n1#4:209\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n35#1:169,4\n42#1:174,4\n50#1:179,4\n52#1:184,4\n60#1:189,4\n69#1:194,4\n72#1:199,4\n81#1:204,4\n35#1:173\n42#1:178\n50#1:183\n52#1:188\n60#1:193\n69#1:198\n72#1:203\n81#1:208\n*E\n"})
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    @Nullable
    private T[] a;
    @Volatile
    private volatile int _size;
    @NotNull
    private static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");

    public final int getSize() {
        return _size$FU.get(this);
    }

    private final void setSize(int value) {
        _size$FU.set(this, value);
    }

    public final boolean isEmpty() {
        return this.getSize() == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void clear() {
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl = false;
            if (this.a != null) {
                ArraysKt.fill$default((Object[])this.a, null, (int)0, (int)0, (int)6, null);
            }
            _size$FU.set(this, 0);
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public final T find(@NotNull Function1<? super T, Boolean> predicate) {
        T t;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            T t2;
            block4: {
                boolean bl = false;
                int n2 = this.getSize();
                for (int i2 = 0; i2 < n2; ++i2) {
                    T value;
                    Intrinsics.checkNotNull(this.a != null ? this.a[i2] : null);
                    value = value;
                    if (!((Boolean)predicate.invoke(value)).booleanValue()) continue;
                    t2 = value;
                    break block4;
                }
                t2 = null;
            }
            t = t2;
        }
        return t;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public final T peek() {
        T t;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl = false;
            t = this.firstImpl();
        }
        return t;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public final T removeFirstOrNull() {
        T t;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl = false;
            t = this.getSize() > 0 ? (T)this.removeAtImpl(0) : null;
        }
        return t;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Nullable
    public final T removeFirstIf(@NotNull Function1<? super T, Boolean> predicate) {
        block5: {
            boolean $i$f$removeFirstIf = false;
            boolean $i$f$synchronized = false;
            boolean $i$f$synchronizedImpl = false;
            ThreadSafeHeap threadSafeHeap = this;
            // MONITORENTER : threadSafeHeap
            boolean bl = false;
            if (this.firstImpl() != null) break block5;
            T t = null;
            InlineMarker.finallyStart((int)2);
            // MONITOREXIT : threadSafeHeap
            InlineMarker.finallyEnd((int)2);
            return t;
        }
        try {
            T t;
            T first2 = t;
            T t2 = ((Boolean)predicate.invoke(first2)).booleanValue() ? (T)this.removeAtImpl(0) : null;
            return t2;
        }
        finally {
            InlineMarker.finallyStart((int)1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void addLast(@NotNull T node) {
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl = false;
            this.addImpl(node);
            Unit unit = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean addLastIf(@NotNull T node, @NotNull Function1<? super T, Boolean> cond) {
        boolean $i$f$addLastIf = false;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl;
            try {
                boolean bl2;
                boolean bl3 = false;
                if (((Boolean)cond.invoke(this.firstImpl())).booleanValue()) {
                    this.addImpl(node);
                    bl2 = true;
                } else {
                    bl2 = false;
                }
                bl = bl2;
            }
            finally {
                InlineMarker.finallyStart((int)1);
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl20 : MonitorExitStatement: MONITOREXIT : var6_6
                InlineMarker.finallyEnd((int)1);
            }
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean remove(@NotNull T node) {
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        ThreadSafeHeap threadSafeHeap = this;
        synchronized (threadSafeHeap) {
            boolean bl;
            boolean bl2 = false;
            if (node.getHeap() == null) {
                bl = false;
            } else {
                int index = node.getIndex();
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl3 = false;
                    if (!(index >= 0)) {
                        throw new AssertionError();
                    }
                }
                this.removeAtImpl(index);
                bl = true;
            }
            boolean bl4 = bl;
            return bl4;
        }
    }

    @PublishedApi
    @Nullable
    public final T firstImpl() {
        return (T)(this.a != null ? this.a[0] : null);
    }

    /*
     * Unable to fully structure code
     */
    @PublishedApi
    @NotNull
    public final T removeAtImpl(int index) {
        block6: {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                $i$a$-assert-ThreadSafeHeap$removeAtImpl$1 = false;
                if (!(this.getSize() > 0)) {
                    throw new AssertionError();
                }
            }
            Intrinsics.checkNotNull(this.a);
            a = this.a;
            var3_4 = this.getSize();
            this.setSize(var3_4 + -1);
            if (index >= this.getSize()) break block6;
            this.swap(index, this.getSize());
            j = (index - 1) / 2;
            if (index <= 0) ** GOTO lbl-1000
            v0 = a[index];
            Intrinsics.checkNotNull(v0);
            v1 = (Comparable)v0;
            v2 = a[j];
            Intrinsics.checkNotNull(v2);
            if (v1.compareTo(v2) < 0) {
                this.swap(index, j);
                this.siftUpFrom(j);
            } else lbl-1000:
            // 2 sources

            {
                this.siftDownFrom(index);
            }
        }
        v3 = a[this.getSize()];
        Intrinsics.checkNotNull(v3);
        result = v3;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            $i$a$-assert-ThreadSafeHeap$removeAtImpl$2 = false;
            if (!(result.getHeap() == this)) {
                throw new AssertionError();
            }
        }
        result.setHeap(null);
        result.setIndex(-1);
        a[this.getSize()] = null;
        return result;
    }

    @PublishedApi
    public final void addImpl(@NotNull T node) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(node.getHeap() == null)) {
                throw new AssertionError();
            }
        }
        node.setHeap(this);
        ThreadSafeHeapNode[] a2 = this.realloc();
        int n2 = this.getSize();
        this.setSize(n2 + 1);
        int i2 = n2;
        a2[i2] = node;
        node.setIndex(i2);
        this.siftUpFrom(i2);
    }

    private final void siftUpFrom(int i2) {
        while (i2 > 0) {
            Intrinsics.checkNotNull(this.a);
            T[] a2 = this.a;
            int j2 = (i2 - 1) / 2;
            T t = a2[j2];
            Intrinsics.checkNotNull(t);
            Comparable comparable = (Comparable)t;
            T t2 = a2[i2];
            Intrinsics.checkNotNull(t2);
            if (comparable.compareTo(t2) <= 0) {
                return;
            }
            this.swap(i2, j2);
            i2 = j2;
        }
        return;
    }

    private final void siftDownFrom(int i2) {
        int j2;
        while ((j2 = 2 * i2 + 1) < this_.getSize()) {
            Intrinsics.checkNotNull(this_.a);
            T[] a2 = this_.a;
            if (j2 + 1 < this_.getSize()) {
                T t = a2[j2 + 1];
                Intrinsics.checkNotNull(t);
                Comparable comparable = (Comparable)t;
                T t2 = a2[j2];
                Intrinsics.checkNotNull(t2);
                if (comparable.compareTo(t2) < 0) {
                    ++j2;
                }
            }
            T t = a2[i2];
            Intrinsics.checkNotNull(t);
            Comparable comparable = (Comparable)t;
            T t3 = a2[j2];
            Intrinsics.checkNotNull(t3);
            if (comparable.compareTo(t3) <= 0) {
                return;
            }
            this_.swap(i2, j2);
            ThreadSafeHeap threadSafeHeap = this_;
            int n2 = j2;
            ThreadSafeHeap this_ = threadSafeHeap;
            i2 = n2;
        }
        return;
    }

    private final T[] realloc() {
        Object[] objectArray;
        T[] a2 = this.a;
        if (a2 == null) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArray;
            ThreadSafeHeapNode[] it = threadSafeHeapNodeArray = new ThreadSafeHeapNode[4];
            boolean bl = false;
            this.a = it;
            objectArray = threadSafeHeapNodeArray;
        } else if (this.getSize() >= a2.length) {
            T[] TArray = Arrays.copyOf(a2, this.getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(TArray, (String)"copyOf(this, newSize)");
            T[] TArray2 = TArray;
            ThreadSafeHeapNode[] it = (ThreadSafeHeapNode[])TArray2;
            boolean bl = false;
            this.a = it;
            objectArray = (ThreadSafeHeapNode[])TArray2;
        } else {
            objectArray = a2;
        }
        return objectArray;
    }

    private final void swap(int i2, int j2) {
        Intrinsics.checkNotNull(this.a);
        T[] a2 = this.a;
        T t = a2[j2];
        Intrinsics.checkNotNull(t);
        T ni = t;
        T t2 = a2[i2];
        Intrinsics.checkNotNull(t2);
        T nj = t2;
        a2[i2] = ni;
        a2[j2] = nj;
        ni.setIndex(i2);
        nj.setIndex(j2);
    }
}

