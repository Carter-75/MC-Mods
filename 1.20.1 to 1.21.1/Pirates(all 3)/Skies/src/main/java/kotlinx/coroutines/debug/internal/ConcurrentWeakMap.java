/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin._Assertions
 *  kotlin.collections.AbstractMutableMap
 *  kotlin.collections.AbstractMutableSet
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.markers.KMutableIterator
 *  kotlin.jvm.internal.markers.KMutableMap$Entry
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.debug.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt;
import kotlinx.coroutines.debug.internal.HashedWeakRef;
import kotlinx.coroutines.debug.internal.Marked;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003,-.B\u0011\u0012\b\b\u0002\u0010'\u001a\u00020)\u00a2\u0006\u0004\b*\u0010+J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\f\u0010\u000bJ\u001a\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\b\u0010\u0010\u001a\u0004\u0018\u00018\u0001H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u000fJ\r\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u000bR\u000b\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004R!\u0010\u001a\u001a\u0018\u0012\u0014\u0012\u00120\u0019R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u00188\u0002X\u0082\u0004R&\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c0\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u001c\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", "V", "Lkotlin/collections/AbstractMutableMap;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "w", "", "cleanWeakRef", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "clear", "()V", "decrementSize", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putSynchronized", "remove", "runWeakRefQueueCleaningLoopUntilInterrupted", "Lkotlinx/atomicfu/AtomicInt;", "_size", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "core", "", "", "getEntries", "()Ljava/util/Set;", "entries", "getKeys", "keys", "", "getSize", "()I", "size", "Ljava/lang/ref/ReferenceQueue;", "weakRefQueue", "Ljava/lang/ref/ReferenceQueue;", "", "<init>", "(Z)V", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
public final class ConcurrentWeakMap<K, V>
extends AbstractMutableMap<K, V> {
    @Volatile
    private volatile int _size;
    @Volatile
    @Nullable
    private volatile Object core;
    @Nullable
    private final ReferenceQueue<K> weakRefQueue;
    @NotNull
    private static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    @NotNull
    private static final AtomicReferenceFieldUpdater core$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core");

    public ConcurrentWeakMap(boolean weakRefQueue) {
        this.core = new Core(16);
        this.weakRefQueue = weakRefQueue ? new ReferenceQueue() : null;
    }

    public /* synthetic */ ConcurrentWeakMap(boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl = false;
        }
        this(bl);
    }

    public int getSize() {
        return _size$FU.get(this);
    }

    private final void decrementSize() {
        _size$FU.decrementAndGet(this);
    }

    @Nullable
    public V get(@Nullable Object key) {
        if (key == null) {
            return null;
        }
        return ((Core)core$FU.get(this)).getImpl(key);
    }

    @Nullable
    public V put(@NotNull K key, @NotNull V value) {
        Object oldValue = Core.putImpl$default((Core)core$FU.get(this), key, value, null, 4, null);
        if (oldValue == ConcurrentWeakMapKt.access$getREHASH$p()) {
            oldValue = this.putSynchronized(key, value);
        }
        if (oldValue == null) {
            _size$FU.incrementAndGet(this);
        }
        return (V)oldValue;
    }

    @Nullable
    public V remove(@Nullable Object key) {
        if (key == null) {
            return null;
        }
        Object oldValue = Core.putImpl$default((Core)core$FU.get(this), key, null, null, 4, null);
        if (oldValue == ConcurrentWeakMapKt.access$getREHASH$p()) {
            oldValue = this.putSynchronized(key, null);
        }
        if (oldValue != null) {
            _size$FU.decrementAndGet(this);
        }
        return (V)oldValue;
    }

    private final synchronized V putSynchronized(K key, V value) {
        Core curCore = (Core)core$FU.get(this);
        Object oldValue;
        while ((oldValue = Core.putImpl$default(curCore, key, value, null, 4, null)) == ConcurrentWeakMapKt.access$getREHASH$p()) {
            curCore = curCore.rehash();
            core$FU.set(this, curCore);
        }
        return (V)oldValue;
    }

    @NotNull
    public Set<K> getKeys() {
        return (Set)((Object)new KeyValueSet(keys.1.INSTANCE));
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return (Set)((Object)new KeyValueSet(entries.1.INSTANCE));
    }

    public void clear() {
        for (Object k2 : this.keySet()) {
            this.remove(k2);
        }
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        if (!(this.weakRefQueue != null)) {
            boolean bl = false;
            String string = "Must be created with weakRefQueue = true";
            throw new IllegalStateException(string.toString());
        }
        try {
            while (true) {
                Reference<K> reference = this.weakRefQueue.remove();
                Intrinsics.checkNotNull(reference, (String)"null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                this.cleanWeakRef((HashedWeakRef)reference);
            }
        }
        catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private final void cleanWeakRef(HashedWeakRef<?> w) {
        ((Core)core$FU.get(this)).cleanWeakRef(w);
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\n\u00a2\u0006\u0004\b&\u0010'J\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ3\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u0011\"\u0004\b\u0002\u0010\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0019\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u001f8\u0002X\u0082\u0004R\u000b\u0010\"\u001a\u00020!8\u0002X\u0082\u0004R\u0014\u0010#\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001eR\u0014\u0010$\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0013\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f8\u0002X\u0082\u0004\u00a8\u0006)"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "weakRef", "", "cleanWeakRef", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "key", "getImpl", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "hash", "index", "(I)I", "E", "Lkotlin/Function2;", "factory", "", "keyValueIterator", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "value", "weakKey0", "putImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "rehash", "()Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "removeCleanedAt", "(I)V", "allocated", "I", "Lkotlinx/atomicfu/AtomicArray;", "keys", "Lkotlinx/atomicfu/AtomicInt;", "load", "shift", "threshold", "values", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "KeyValueIterator", "kotlinx-coroutines-core"})
    private final class Core {
        private final int allocated;
        private final int shift;
        private final int threshold;
        @Volatile
        private volatile int load;
        @NotNull
        private final AtomicReferenceArray keys;
        @NotNull
        private final AtomicReferenceArray values;
        @NotNull
        private static final AtomicIntegerFieldUpdater load$FU = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");

        public Core(int allocated) {
            this.allocated = allocated;
            this.shift = Integer.numberOfLeadingZeros(this.allocated) + 1;
            this.threshold = 2 * this.allocated / 3;
            this.keys = new AtomicReferenceArray(this.allocated);
            this.values = new AtomicReferenceArray(this.allocated);
        }

        private final int index(int hash) {
            return hash * -1640531527 >>> this.shift;
        }

        @Nullable
        public final V getImpl(@NotNull K key) {
            int index = this.index(key.hashCode());
            while ((HashedWeakRef)this.keys.get(index) != null) {
                HashedWeakRef w;
                Object k2 = w.get();
                if (Intrinsics.areEqual(key, k2)) {
                    Object value = this.values.get(index);
                    return value instanceof Marked ? ((Marked)value).ref : value;
                }
                if (k2 == null) {
                    this.removeCleanedAt(index);
                }
                if (index == 0) {
                    index = this.allocated;
                }
                --index;
            }
            return null;
        }

        private final void removeCleanedAt(int index) {
            Object oldValue;
            do {
                if (this.values.get(index) == null) {
                    return;
                }
                if (!(oldValue instanceof Marked)) continue;
                return;
            } while (!this.values.compareAndSet(index, oldValue, null));
            ConcurrentWeakMap.this.decrementSize();
        }

        @Nullable
        public final Object putImpl(@NotNull K key, @Nullable V value, @Nullable HashedWeakRef<K> weakKey0) {
            int index = this.index(key.hashCode());
            boolean loadIncremented = false;
            HashedWeakRef weakKey = weakKey0;
            while (true) {
                HashedWeakRef w;
                if ((w = (HashedWeakRef)this.keys.get(index)) == null) {
                    if (value == null) {
                        return null;
                    }
                    if (!loadIncremented) {
                        int n2;
                        int n3;
                        int n4;
                        Core core = this;
                        AtomicIntegerFieldUpdater atomicfu$handler$iv = load$FU;
                        boolean $i$f$update$atomicfu = false;
                        do {
                            n2 = n4 = atomicfu$handler$iv.get(this);
                            boolean bl = false;
                            if (n2 < this.threshold) continue;
                            return ConcurrentWeakMapKt.access$getREHASH$p();
                        } while (!atomicfu$handler$iv.compareAndSet(this, n4, n3 = n2 + 1));
                        loadIncremented = true;
                    }
                    if (weakKey == null) {
                        weakKey = new HashedWeakRef(key, ConcurrentWeakMap.this.weakRefQueue);
                    }
                    if (this.keys.compareAndSet(index, null, weakKey)) break;
                    continue;
                }
                Object k2 = w.get();
                if (Intrinsics.areEqual(key, k2)) {
                    if (!loadIncremented) break;
                    load$FU.decrementAndGet(this);
                    break;
                }
                if (k2 == null) {
                    this.removeCleanedAt(index);
                }
                if (index == 0) {
                    index = this.allocated;
                }
                --index;
            }
            Object oldValue = null;
            do {
                if (!((oldValue = (Object)this.values.get(index)) instanceof Marked)) continue;
                return ConcurrentWeakMapKt.access$getREHASH$p();
            } while (!this.values.compareAndSet(index, oldValue, value));
            return oldValue;
        }

        public static /* synthetic */ Object putImpl$default(Core core, Object object, Object object2, HashedWeakRef hashedWeakRef, int n2, Object object3) {
            if ((n2 & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.putImpl(object, object2, hashedWeakRef);
        }

        @NotNull
        public final Core rehash() {
            Core newCore;
            block0: while (true) {
                int newCapacity = Integer.highestOneBit(RangesKt.coerceAtLeast((int)ConcurrentWeakMap.this.size(), (int)4)) * 4;
                newCore = new Core(newCapacity);
                int n2 = this.allocated;
                for (int index = 0; index < n2; ++index) {
                    boolean bl;
                    Object k2;
                    HashedWeakRef w;
                    HashedWeakRef hashedWeakRef = w = (HashedWeakRef)this.keys.get(index);
                    Object object = k2 = hashedWeakRef != null ? hashedWeakRef.get() : null;
                    if (w != null && k2 == null) {
                        this.removeCleanedAt(index);
                    }
                    Object value = null;
                    do {
                        if (!((value = (Object)this.values.get(index)) instanceof Marked)) continue;
                        value = ((Marked)value).ref;
                        break;
                    } while (!this.values.compareAndSet(index, value, ConcurrentWeakMapKt.access$mark(value)));
                    if (k2 == null || value == null) continue;
                    Object oldValue = newCore.putImpl(k2, value, w);
                    if (oldValue == ConcurrentWeakMapKt.access$getREHASH$p()) continue block0;
                    boolean bl2 = bl = oldValue == null;
                    if (!_Assertions.ENABLED || bl) continue;
                    String string = "Assertion failed";
                    throw new AssertionError((Object)string);
                }
                break;
            }
            return newCore;
        }

        public final void cleanWeakRef(@NotNull HashedWeakRef<?> weakRef) {
            int index = this.index(weakRef.hash);
            while ((HashedWeakRef)this.keys.get(index) != null) {
                HashedWeakRef w;
                if (w == weakRef) {
                    this.removeCleanedAt(index);
                    return;
                }
                if (index == 0) {
                    index = this.allocated;
                }
                --index;
            }
            return;
        }

        @NotNull
        public final <E> Iterator<E> keyValueIterator(@NotNull Function2<? super K, ? super V, ? extends E> factory) {
            return new KeyValueIterator<E>(factory);
        }

        private final void update$atomicfu(AtomicIntegerFieldUpdater atomicfu$handler, Function1<? super Integer, Integer> atomicfu$action, Object atomicfu$dispatchReceiver) {
            Object object;
            int n2;
            boolean $i$f$update$atomicfu = false;
            while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, n2 = atomicfu$handler.get(atomicfu$dispatchReceiver), ((Number)(object = atomicfu$action.invoke((Object)n2))).intValue())) {
            }
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\f\u0010\rR&\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00028\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015\u00a8\u0006\u0019"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", "E", "", "", "findNext", "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "remove", "()Ljava/lang/Void;", "Lkotlin/Function2;", "factory", "Lkotlin/jvm/functions/Function2;", "", "index", "I", "key", "Ljava/lang/Object;", "value", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
        @SourceDebugExtension(value={"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
        private final class KeyValueIterator<E>
        implements Iterator<E>,
        KMutableIterator {
            @NotNull
            private final Function2<K, V, E> factory;
            private int index;
            private K key;
            private V value;

            public KeyValueIterator(Function2<? super K, ? super V, ? extends E> factory) {
                this.factory = factory;
                this.index = -1;
                this.findNext();
            }

            private final void findNext() {
                block2: {
                    Object value;
                    while (true) {
                        ++this.index;
                        if (this.index >= Core.this.allocated) break block2;
                        HashedWeakRef hashedWeakRef = (HashedWeakRef)Core.this.keys.get(this.index);
                        if (hashedWeakRef == null || (hashedWeakRef = hashedWeakRef.get()) == null) continue;
                        this.key = hashedWeakRef;
                        value = Core.this.values.get(this.index);
                        if (value instanceof Marked) {
                            value = ((Marked)value).ref;
                        }
                        if (value != null) break;
                    }
                    this.value = value;
                    return;
                }
            }

            @Override
            public boolean hasNext() {
                return this.index < Core.this.allocated;
            }

            @Override
            public E next() {
                Object object;
                Object object2;
                if (this.index >= Core.this.allocated) {
                    throw new NoSuchElementException();
                }
                Object object3 = this.key;
                if (object3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"key");
                    object3 = Unit.INSTANCE;
                }
                if ((object2 = this.value) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"value");
                    object2 = Unit.INSTANCE;
                }
                Object it = object = this.factory.invoke(object3, object2);
                boolean bl = false;
                this.findNext();
                return (E)object;
            }

            @NotNull
            public Void remove() {
                ConcurrentWeakMapKt.access$noImpl();
                throw new KotlinNothingValueException();
            }
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u0007\u001a\u00028\u0002\u0012\u0006\u0010\u000b\u001a\u00028\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00028\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00028\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", "V", "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "key", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "value", "getValue", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlinx-coroutines-core"})
    private static final class Entry<K, V>
    implements Map.Entry<K, V>,
    KMutableMap.Entry {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V newValue) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\tR&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", "element", "", "add", "(Ljava/lang/Object;)Z", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function2;", "factory", "Lkotlin/jvm/functions/Function2;", "", "getSize", "()I", "size", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
    private final class KeyValueSet<E>
    extends AbstractMutableSet<E> {
        @NotNull
        private final Function2<K, V, E> factory;

        public KeyValueSet(Function2<? super K, ? super V, ? extends E> factory) {
            this.factory = factory;
        }

        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        public boolean add(E element) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }

        @NotNull
        public Iterator<E> iterator() {
            return ((Core)core$FU.get(ConcurrentWeakMap.this)).keyValueIterator(this.factory);
        }
    }
}

