/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference0Impl
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Removed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J,\u0010\n\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\b\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u00022\n\u0010\f\u001a\u00060\u0000j\u0002`\u0002H\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0013\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0082\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0016\u001a\u00060\u0000j\u0002`\u00022\n\u0010\u0015\u001a\u00060\u0000j\u0002`\u0002H\u0082\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00042\n\u0010\f\u001a\u00060\u0000j\u0002`\u0002H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0006J,\u0010\u001a\u001a\u00020\u00192\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0081\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0002H\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0002H\u0001\u00a2\u0006\u0004\b \u0010\u001dJ\u000f\u0010\"\u001a\u00020!H\u0002\u00a2\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016\u00a2\u0006\u0004\b%\u0010&J/\u0010)\u001a\u00020(2\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u00022\n\u0010\f\u001a\u00060\u0000j\u0002`\u00022\u0006\u0010'\u001a\u00020\u0019H\u0001\u00a2\u0006\u0004\b)\u0010*J'\u0010.\u001a\u00020\u00042\n\u0010+\u001a\u00060\u0000j\u0002`\u00022\n\u0010\f\u001a\u00060\u0000j\u0002`\u0002H\u0000\u00a2\u0006\u0004\b,\u0010-R\u0011\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010/8\u0002X\u0082\u0004R\u0011\u00101\u001a\b\u0012\u0004\u0012\u00020\u00000/8\u0002X\u0082\u0004R\u0013\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0/8\u0002X\u0082\u0004R\u0014\u00103\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u0010\u001fR\u0011\u0010\f\u001a\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0015\u00107\u001a\u00060\u0000j\u0002`\u00028F\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u001dR\u0015\u00109\u001a\u00060\u0000j\u0002`\u00028F\u00a2\u0006\u0006\u001a\u0004\b8\u0010\u001d\u00a8\u0006="}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "_removedRef", "isRemoved", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "<init>", "()V", "CondAddOp", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
@SourceDebugExtension(value={"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,367:1\n73#1,3:369\n1#2:368\n*S KotlinDebug\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n*L\n134#1:369,3\n*E\n"})
public class LockFreeLinkedListNode {
    @Volatile
    @Nullable
    private volatile Object _next = this;
    @Volatile
    @Nullable
    private volatile Object _prev = this;
    @Volatile
    @Nullable
    private volatile Object _removedRef;
    @NotNull
    private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    @NotNull
    private static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    @NotNull
    private static final AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");

    private final Removed removed() {
        Removed removed = (Removed)_removedRef$FU.get(this);
        if (removed == null) {
            Removed removed2;
            Removed it = removed2 = new Removed(this);
            boolean bl = false;
            _removedRef$FU.lazySet(this, it);
            removed = removed2;
        }
        return removed;
    }

    @PublishedApi
    @NotNull
    public final CondAddOp makeCondAddOp(@NotNull LockFreeLinkedListNode node, @NotNull Function0<Boolean> condition) {
        boolean $i$f$makeCondAddOp = false;
        return new CondAddOp(node, condition){
            final /* synthetic */ Function0<Boolean> $condition;
            {
                this.$condition = $condition;
                super($node);
            }

            @Nullable
            public Object prepare(@NotNull LockFreeLinkedListNode affected) {
                return (Boolean)this.$condition.invoke() != false ? null : LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
    }

    public boolean isRemoved() {
        return this.getNext() instanceof Removed;
    }

    @NotNull
    public final Object getNext() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _next$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            Object next = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if (!(next instanceof OpDescriptor)) {
                return next;
            }
            ((OpDescriptor)next).perform(this);
        }
    }

    @NotNull
    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(this.getNext());
    }

    @NotNull
    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this.correctPrev(null);
        if (lockFreeLinkedListNode == null) {
            lockFreeLinkedListNode = this.findPrevNonRemoved((LockFreeLinkedListNode)_prev$FU.get(this));
        }
        return lockFreeLinkedListNode;
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode current) {
        while (current.isRemoved()) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this_;
            Object v = _prev$FU.get(current);
            LockFreeLinkedListNode this_ = lockFreeLinkedListNode;
            current = (LockFreeLinkedListNode)v;
        }
        return current;
    }

    public final boolean addOneIfEmpty(@NotNull LockFreeLinkedListNode node) {
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, this);
        do {
            Object next;
            if ((next = this.getNext()) == this) continue;
            return false;
        } while (!_next$FU.compareAndSet(this, this, node));
        node.finishAdd(this);
        return true;
    }

    public final void addLast(@NotNull LockFreeLinkedListNode node) {
        while (!this.getPrevNode().addNext(node, this)) {
        }
    }

    public final boolean addLastIf(@NotNull LockFreeLinkedListNode node, @NotNull Function0<Boolean> condition) {
        boolean $i$f$addLastIf = false;
        LockFreeLinkedListNode this_$iv = this;
        boolean $i$f$makeCondAddOp = false;
        CondAddOp condAdd = new /* invalid duplicate definition of identical inner class */;
        while (true) {
            LockFreeLinkedListNode prev2 = this.getPrevNode();
            switch (prev2.tryCondAddNext(node, this, condAdd)) {
                case 1: {
                    return true;
                }
                case 2: {
                    return false;
                }
            }
        }
    }

    @PublishedApi
    public final boolean addNext(@NotNull LockFreeLinkedListNode node, @NotNull LockFreeLinkedListNode next) {
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, next);
        if (!_next$FU.compareAndSet(this, next, node)) {
            return false;
        }
        node.finishAdd(next);
        return true;
    }

    @PublishedApi
    public final int tryCondAddNext(@NotNull LockFreeLinkedListNode node, @NotNull LockFreeLinkedListNode next, @NotNull CondAddOp condAdd) {
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, next);
        condAdd.oldNext = next;
        if (!_next$FU.compareAndSet(this, next, condAdd)) {
            return 0;
        }
        return condAdd.perform(this) == null ? 1 : 2;
    }

    public boolean remove() {
        return this.removeOrNext() == null;
    }

    @PublishedApi
    @Nullable
    public final LockFreeLinkedListNode removeOrNext() {
        Removed removed;
        Object next;
        do {
            if ((next = this.getNext()) instanceof Removed) {
                return ((Removed)next).ref;
            }
            if (next == this) {
                return (LockFreeLinkedListNode)next;
            }
            Intrinsics.checkNotNull((Object)next, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        } while (!_next$FU.compareAndSet(this, next, removed = ((LockFreeLinkedListNode)next).removed()));
        ((LockFreeLinkedListNode)next).correctPrev(null);
        return null;
    }

    private final void finishAdd(LockFreeLinkedListNode next) {
        LockFreeLinkedListNode nextPrev;
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _prev$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            nextPrev = (LockFreeLinkedListNode)atomicfu$handler$iv.get(next);
            boolean bl = false;
            if (this.getNext() == next) continue;
            return;
        } while (!_prev$FU.compareAndSet(next, nextPrev, this));
        if (this.isRemoved()) {
            next.correctPrev(null);
        }
    }

    @Nullable
    protected LockFreeLinkedListNode nextIfRemoved() {
        Object object = this.getNext();
        Removed removed = object instanceof Removed ? (Removed)object : null;
        return removed != null ? removed.ref : null;
    }

    private final LockFreeLinkedListNode correctPrev(OpDescriptor op) {
        block0: while (true) {
            LockFreeLinkedListNode oldPrev;
            LockFreeLinkedListNode prev2 = oldPrev = (LockFreeLinkedListNode)_prev$FU.get(this_);
            LockFreeLinkedListNode last2 = null;
            while (true) {
                LockFreeLinkedListNode this_;
                OpDescriptor opDescriptor;
                LockFreeLinkedListNode lockFreeLinkedListNode;
                Object prevNext = _next$FU.get(prev2);
                if (prevNext == this_) {
                    if (oldPrev == prev2) {
                        return prev2;
                    }
                    if (!_prev$FU.compareAndSet(this_, oldPrev, prev2)) {
                        lockFreeLinkedListNode = this_;
                        opDescriptor = op;
                        this_ = lockFreeLinkedListNode;
                        op = opDescriptor;
                        continue block0;
                    }
                    return prev2;
                }
                if (this_.isRemoved()) {
                    return null;
                }
                if (prevNext == op) {
                    return prev2;
                }
                if (prevNext instanceof OpDescriptor) {
                    ((OpDescriptor)prevNext).perform(prev2);
                    lockFreeLinkedListNode = this_;
                    opDescriptor = op;
                    this_ = lockFreeLinkedListNode;
                    op = opDescriptor;
                    continue block0;
                }
                if (prevNext instanceof Removed) {
                    if (last2 != null) {
                        if (!_next$FU.compareAndSet(last2, prev2, ((Removed)prevNext).ref)) {
                            lockFreeLinkedListNode = this_;
                            opDescriptor = op;
                            this_ = lockFreeLinkedListNode;
                            op = opDescriptor;
                            continue block0;
                        }
                        prev2 = last2;
                        last2 = null;
                        continue;
                    }
                    prev2 = (LockFreeLinkedListNode)_prev$FU.get(prev2);
                    continue;
                }
                last2 = prev2;
                Intrinsics.checkNotNull(prevNext, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                prev2 = (LockFreeLinkedListNode)prevNext;
            }
            break;
        }
    }

    public final void validateNode$kotlinx_coroutines_core(@NotNull LockFreeLinkedListNode prev2, @NotNull LockFreeLinkedListNode next) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(prev2 == _prev$FU.get(this))) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(next == _next$FU.get(this))) {
                throw new AssertionError();
            }
        }
    }

    @NotNull
    public String toString() {
        return new PropertyReference0Impl(this){

            @Nullable
            public Object get() {
                return DebugStringsKt.getClassSimpleName(this.receiver);
            }
        } + '@' + DebugStringsKt.getHexAddress(this);
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "failure", "", "complete", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)V", "newNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "oldNext", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"})
    @PublishedApi
    public static abstract class CondAddOp
    extends AtomicOp<LockFreeLinkedListNode> {
        @JvmField
        @NotNull
        public final LockFreeLinkedListNode newNode;
        @JvmField
        @Nullable
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(@NotNull LockFreeLinkedListNode newNode) {
            this.newNode = newNode;
        }

        @Override
        public void complete(@NotNull LockFreeLinkedListNode affected, @Nullable Object failure) {
            LockFreeLinkedListNode update;
            boolean success = failure == null;
            LockFreeLinkedListNode lockFreeLinkedListNode = update = success ? this.newNode : this.oldNext;
            if (update != null && _next$FU.compareAndSet(affected, this, update) && success) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.oldNext;
                Intrinsics.checkNotNull((Object)lockFreeLinkedListNode2);
                this.newNode.finishAdd(lockFreeLinkedListNode2);
            }
        }
    }
}

