/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0082\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u0003*\u00020\u000eH\u0082\b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u000b\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00188\u0002X\u0082\u0004R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2={"Lkotlinx/coroutines/internal/OnDemandAllocatingPool;", "T", "", "", "allocate", "()Z", "", "close", "()Ljava/util/List;", "", "stateRepresentation$kotlinx_coroutines_core", "()Ljava/lang/String;", "stateRepresentation", "toString", "", "tryForbidNewElements", "()I", "isClosed", "(I)Z", "Lkotlinx/atomicfu/AtomicInt;", "controlState", "Lkotlin/Function1;", "create", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/atomicfu/AtomicArray;", "elements", "maxCapacity", "I", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nOnDemandAllocatingPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPoolKt\n*L\n1#1,107:1\n41#1:108\n41#1:109\n35#1,7:110\n41#1:127\n1549#2:117\n1620#2,2:118\n1622#2:122\n1549#2:123\n1620#2,3:124\n101#3,2:120\n*S KotlinDebug\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n*L\n35#1:108\n54#1:109\n76#1:110,7\n92#1:127\n77#1:117\n77#1:118,2\n77#1:122\n91#1:123\n91#1:124,3\n79#1:120,2\n*E\n"})
public final class OnDemandAllocatingPool<T> {
    private final int maxCapacity;
    @NotNull
    private final Function1<Integer, T> create;
    @Volatile
    private volatile int controlState;
    @NotNull
    private final AtomicReferenceArray elements;
    @NotNull
    private static final AtomicIntegerFieldUpdater controlState$FU = AtomicIntegerFieldUpdater.newUpdater(OnDemandAllocatingPool.class, "controlState");

    public OnDemandAllocatingPool(int maxCapacity, @NotNull Function1<? super Integer, ? extends T> create) {
        this.maxCapacity = maxCapacity;
        this.create = create;
        this.elements = new AtomicReferenceArray(this.maxCapacity);
    }

    private final int tryForbidNewElements() {
        int it;
        boolean $i$f$tryForbidNewElements = false;
        OnDemandAllocatingPool onDemandAllocatingPool = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = controlState$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            it = atomicfu$handler$iv.get(this);
            boolean bl = false;
            OnDemandAllocatingPool onDemandAllocatingPool2 = this;
            int $this$isClosed$iv = it;
            boolean $i$f$isClosed = false;
            if (!(($this$isClosed$iv & Integer.MIN_VALUE) != 0)) continue;
            return 0;
        } while (!controlState$FU.compareAndSet(this, it, it | Integer.MIN_VALUE));
        return it;
    }

    private final boolean isClosed(int $this$isClosed) {
        boolean $i$f$isClosed = false;
        return ($this$isClosed & Integer.MIN_VALUE) != 0;
    }

    public final boolean allocate() {
        int ctl;
        OnDemandAllocatingPool onDemandAllocatingPool = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = controlState$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            ctl = atomicfu$handler$iv.get(this);
            boolean bl = false;
            OnDemandAllocatingPool onDemandAllocatingPool2 = this;
            int $this$isClosed$iv = ctl;
            boolean $i$f$isClosed = false;
            if (($this$isClosed$iv & Integer.MIN_VALUE) != 0) {
                return false;
            }
            if (ctl < this.maxCapacity) continue;
            return true;
        } while (!controlState$FU.compareAndSet(this, ctl, ctl + 1));
        this.elements.set(ctl, this.create.invoke((Object)ctl));
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<T> close() {
        void $this$mapTo$iv$iv;
        int n2;
        block3: {
            int it$iv;
            OnDemandAllocatingPool this_$iv = this;
            boolean $i$f$tryForbidNewElements = false;
            OnDemandAllocatingPool onDemandAllocatingPool = this_$iv;
            AtomicIntegerFieldUpdater atomicfu$handler$iv$iv = controlState$FU;
            boolean $i$f$loop$atomicfu = false;
            do {
                it$iv = atomicfu$handler$iv$iv.get(this_$iv);
                boolean bl = false;
                OnDemandAllocatingPool onDemandAllocatingPool2 = this_$iv;
                int $this$isClosed$iv$iv = it$iv;
                boolean $i$f$isClosed = false;
                if (!(($this$isClosed$iv$iv & Integer.MIN_VALUE) != 0)) continue;
                n2 = 0;
                break block3;
            } while (!controlState$FU.compareAndSet(this_$iv, it$iv, it$iv | Integer.MIN_VALUE));
            n2 = it$iv;
        }
        int elementsExisting = n2;
        Iterable $this$map$iv = (Iterable)RangesKt.until((int)0, (int)elementsExisting);
        boolean $i$f$map = false;
        Iterable this_$iv$iv = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void i2;
            Object element;
            int item$iv$iv;
            int this_$iv$iv2 = item$iv$iv = ((IntIterator)iterator2).nextInt();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            boolean $i$f$loop = false;
            do {
                boolean bl2 = false;
            } while ((element = this.elements.getAndSet((int)i2, null)) == null);
            collection.add(element);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final String stateRepresentation$kotlinx_coroutines_core() {
        void $this$mapTo$iv$iv;
        int ctl = controlState$FU.get(this);
        Iterable $this$map$iv = (Iterable)RangesKt.until((int)0, (int)(ctl & Integer.MAX_VALUE));
        boolean $i$f$map22 = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void it;
            int item$iv$iv;
            int n2 = item$iv$iv = ((IntIterator)iterator2).nextInt();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(this.elements.get((int)it));
        }
        String elementsStr = ((List)destination$iv$iv).toString();
        OnDemandAllocatingPool $i$f$map22 = this;
        int $this$isClosed$iv = ctl;
        boolean $i$f$isClosed = false;
        String closedStr = ($this$isClosed$iv & Integer.MIN_VALUE) != 0 ? "[closed]" : "";
        return elementsStr + closedStr;
    }

    @NotNull
    public String toString() {
        return "OnDemandAllocatingPool(" + this.stateRepresentation$kotlinx_coroutines_core() + ')';
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicfu$handler, Function1<? super Integer, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            int n2 = atomicfu$handler.get(atomicfu$dispatchReceiver);
            atomicfu$action.invoke((Object)n2);
        }
    }
}

