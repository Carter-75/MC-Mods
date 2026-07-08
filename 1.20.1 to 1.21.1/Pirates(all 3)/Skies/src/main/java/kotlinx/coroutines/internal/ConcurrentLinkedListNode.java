/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b#\u0010$J\r\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\u0004\u0018\u00018\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086\b\u00a2\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000e\u0010\u0005J\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00128\u0002X\u0082\u0004R\u0013\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00128\u0002X\u0082\u0004R\u0016\u0010\u0017\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00028\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\bR\u0011\u0010\u001b\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\bR\u0013\u0010\u001d\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010 \u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\"\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0016\u00a8\u0006%"}, d2={"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "", "cleanPrev", "()V", "", "markAsClosed", "()Z", "Lkotlin/Function0;", "", "onClosedAction", "nextOrIfClosed", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "remove", "value", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "getAliveSegmentLeft", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "aliveSegmentLeft", "getAliveSegmentRight", "aliveSegmentRight", "isRemoved", "isTail", "getNext", "next", "getNextOrClosed", "()Ljava/lang/Object;", "nextOrClosed", "getPrev", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n107#1,7:270\n1#2:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n115#1:270,7\n*E\n"})
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    @Volatile
    @Nullable
    private volatile Object _next;
    @Volatile
    @Nullable
    private volatile Object _prev;
    @NotNull
    private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
    @NotNull
    private static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");

    public ConcurrentLinkedListNode(@Nullable N prev2) {
        this._prev = prev2;
    }

    private final Object getNextOrClosed() {
        return _next$FU.get(this);
    }

    @Nullable
    public final N nextOrIfClosed(@NotNull Function0 onClosedAction) {
        boolean $i$f$nextOrIfClosed = false;
        Object it = this.getNextOrClosed();
        boolean bl = false;
        if (it == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            onClosedAction.invoke();
            throw new KotlinNothingValueException();
        }
        return (N)((ConcurrentLinkedListNode)it);
    }

    @Nullable
    public final N getNext() {
        ConcurrentLinkedListNode this_$iv = this;
        boolean $i$f$nextOrIfClosed = false;
        Object it$iv = this_$iv.getNextOrClosed();
        boolean bl = false;
        if (it$iv == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            boolean bl2 = false;
            return null;
        }
        return (N)((ConcurrentLinkedListNode)it$iv);
    }

    public final boolean trySetNext(@NotNull N value) {
        return _next$FU.compareAndSet(this, null, value);
    }

    public final boolean isTail() {
        return this.getNext() == null;
    }

    @Nullable
    public final N getPrev() {
        return (N)((ConcurrentLinkedListNode)_prev$FU.get(this));
    }

    public final void cleanPrev() {
        _prev$FU.lazySet(this, null);
    }

    public final boolean markAsClosed() {
        return _next$FU.compareAndSet(this, null, ConcurrentLinkedListKt.access$getCLOSED$p());
    }

    public abstract boolean isRemoved();

    public final void remove() {
        N prev2;
        N next;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.isRemoved() || this.isTail())) {
                throw new AssertionError();
            }
        }
        if (this.isTail()) {
            return;
        }
        do {
            ConcurrentLinkedListNode it;
            Object v;
            Object v2;
            prev2 = this.getAliveSegmentLeft();
            next = this.getAliveSegmentRight();
            ConcurrentLinkedListNode concurrentLinkedListNode = this;
            AtomicReferenceFieldUpdater atomicfu$handler$iv = _prev$FU;
            boolean $i$f$update$atomicfu = false;
            do {
                v2 = atomicfu$handler$iv.get(next);
                it = (ConcurrentLinkedListNode)v2;
                boolean bl = false;
            } while (!atomicfu$handler$iv.compareAndSet(next, v2, v = it == null ? null : (Object)prev2));
            if (prev2 == null) continue;
            _next$FU.set(prev2, next);
        } while (((ConcurrentLinkedListNode)next).isRemoved() && !((ConcurrentLinkedListNode)next).isTail() || prev2 != null && ((ConcurrentLinkedListNode)prev2).isRemoved());
    }

    private final N getAliveSegmentLeft() {
        Object cur = this.getPrev();
        while (cur != null && ((ConcurrentLinkedListNode)cur).isRemoved()) {
            cur = (ConcurrentLinkedListNode)_prev$FU.get(cur);
        }
        return cur;
    }

    private final N getAliveSegmentRight() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(!this.isTail())) {
                throw new AssertionError();
            }
        }
        N n2 = this.getNext();
        Intrinsics.checkNotNull(n2);
        N cur = n2;
        while (((ConcurrentLinkedListNode)cur).isRemoved()) {
            if (((ConcurrentLinkedListNode)cur).getNext() != null) continue;
            return cur;
        }
        return cur;
    }

    private final void update$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, ? extends Object> atomicfu$action, Object atomicfu$dispatchReceiver) {
        Object object;
        Object v;
        boolean $i$f$update$atomicfu = false;
        while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, v = atomicfu$handler.get(atomicfu$dispatchReceiver), object = atomicfu$action.invoke(v))) {
        }
    }
}

