/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a?\u0010\t\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0003H\u0082\b\u00a2\u0006\u0004\b\t\u0010\n\u001a#\u0010\r\u001a\u00028\u0000\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000b*\u00028\u0000H\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001av\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\"\u000e\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u000f*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00028\u000028\b\b\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00028\u00000\u0015H\u0080\b\u00f8\u0001\u0000\u001al\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\"\u000e\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u000f*\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u001226\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00028\u00000\u0015H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a+\u0010\u001d\u001a\u00020\u0007\"\u000e\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u000f*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0080\b\"\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\u00018\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2={"Lkotlinx/atomicfu/AtomicInt;", "", "delta", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cur", "", "condition", "addConditionally", "(Lkotlinx/atomicfu/AtomicInt;ILkotlin/jvm/functions/Function1;)Z", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "close", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/internal/Segment;", "S", "Lkotlinx/atomicfu/AtomicRef;", "", "id", "startFrom", "Lkotlin/Function2;", "prev", "createNewSegment", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "findSegmentAndMoveForward", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "to", "moveForward", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "POINTERS_SHIFT", "I", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,269:1\n46#1,8:284\n107#2,7:270\n107#2,7:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n74#1:284,8\n27#1:270,7\n85#1:277,7\n*E\n"})
public final class ConcurrentLinkedListKt {
    private static final int POINTERS_SHIFT = 16;
    @NotNull
    private static final Symbol CLOSED = new Symbol("CLOSED");

    @NotNull
    public static final <S extends Segment<S>> Object findSegmentInternal(@NotNull S $this$findSegmentInternal, long id, @NotNull Function2<? super Long, ? super S, ? extends S> createNewSegment2) {
        Object cur = $this$findSegmentInternal;
        while (((Segment)cur).id < id || ((Segment)cur).isRemoved()) {
            ConcurrentLinkedListNode this_$iv = (ConcurrentLinkedListNode)cur;
            boolean $i$f$nextOrIfClosed = false;
            Object it$iv = ConcurrentLinkedListNode.access$getNextOrClosed(this_$iv);
            boolean bl = false;
            if (it$iv == ConcurrentLinkedListKt.CLOSED) {
                boolean bl2 = false;
                return SegmentOrClosed.constructor-impl(CLOSED);
            }
            Segment next = (Segment)((ConcurrentLinkedListNode)it$iv);
            if (next != null) {
                cur = next;
                continue;
            }
            Segment newTail = (Segment)createNewSegment2.invoke((Object)(((Segment)cur).id + 1L), cur);
            if (!((ConcurrentLinkedListNode)cur).trySetNext((ConcurrentLinkedListNode)newTail)) continue;
            if (((Segment)cur).isRemoved()) {
                ((ConcurrentLinkedListNode)cur).remove();
            }
            cur = newTail;
        }
        return SegmentOrClosed.constructor-impl(cur);
    }

    @NotNull
    public static final <N extends ConcurrentLinkedListNode<N>> N close(@NotNull N $this$close) {
        ConcurrentLinkedListNode cur = null;
        cur = $this$close;
        while (true) {
            ConcurrentLinkedListNode this_$iv = cur;
            boolean $i$f$nextOrIfClosed = false;
            Object it$iv = ConcurrentLinkedListNode.access$getNextOrClosed(this_$iv);
            boolean bl = false;
            if (it$iv == ConcurrentLinkedListKt.CLOSED) {
                boolean bl2 = false;
                return (N)cur;
            }
            ConcurrentLinkedListNode next = (ConcurrentLinkedListNode)it$iv;
            if (next == null) {
                if (!cur.markAsClosed()) continue;
                return (N)cur;
            }
            cur = next;
        }
    }

    public static final boolean moveForward$atomicfu(@Nullable Object atomicfu$dispatchReceiver, @NotNull AtomicReferenceFieldUpdater atomicfu$handler, @NotNull S to) {
        boolean $i$f$moveForward$atomicfu = false;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            Segment cur = (Segment)atomicfu$handler.get(atomicfu$dispatchReceiver);
            boolean bl = false;
            if (cur.id >= ((Segment)to).id) {
                return true;
            }
            if (!((Segment)to).tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, cur, to)) {
                if (cur.decPointers$kotlinx_coroutines_core()) {
                    cur.remove();
                }
                return true;
            }
            if (!((Segment)to).decPointers$kotlinx_coroutines_core()) continue;
            ((ConcurrentLinkedListNode)to).remove();
        }
    }

    public static final boolean moveForward$atomicfu$array(@Nullable Object atomicfu$dispatchReceiver, @NotNull AtomicReferenceArray atomicfu$handler, int atomicfu$index, @NotNull S to) {
        boolean $i$f$moveForward$atomicfu$array = false;
        boolean $i$f$loop$atomicfu$array = false;
        while (true) {
            Segment cur = (Segment)atomicfu$handler.get(atomicfu$index);
            boolean bl = false;
            if (cur.id >= ((Segment)to).id) {
                return true;
            }
            if (!((Segment)to).tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (atomicfu$handler.compareAndSet(atomicfu$index, cur, to)) {
                if (cur.decPointers$kotlinx_coroutines_core()) {
                    cur.remove();
                }
                return true;
            }
            if (!((Segment)to).decPointers$kotlinx_coroutines_core()) continue;
            ((ConcurrentLinkedListNode)to).remove();
        }
    }

    @NotNull
    public static final Object findSegmentAndMoveForward$atomicfu(@Nullable Object atomicfu$dispatchReceiver, @NotNull AtomicReferenceFieldUpdater atomicfu$handler, long id, @NotNull S startFrom, @NotNull Function2<? super Long, ? super S, ? extends S> createNewSegment2) {
        Object s;
        boolean $i$f$findSegmentAndMoveForward$atomicfu = false;
        while (!SegmentOrClosed.isClosed-impl(s = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, createNewSegment2))) {
            boolean bl;
            Object to$iv = SegmentOrClosed.getSegment-impl(s);
            boolean $i$f$moveForward$atomicfu = false;
            boolean $i$f$loop$atomicfu = false;
            while (true) {
                Segment cur$iv = (Segment)atomicfu$handler.get(atomicfu$dispatchReceiver);
                boolean bl2 = false;
                if (cur$iv.id >= ((Segment)to$iv).id) {
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl = false;
                    break;
                }
                if (atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, cur$iv, to$iv)) {
                    if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv.remove();
                    }
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv).remove();
            }
            if (!bl) continue;
        }
        return s;
    }

    @NotNull
    public static final Object findSegmentAndMoveForward$atomicfu$array(@Nullable Object atomicfu$dispatchReceiver, @NotNull AtomicReferenceArray atomicfu$handler, int atomicfu$index, long id, @NotNull S startFrom, @NotNull Function2<? super Long, ? super S, ? extends S> createNewSegment2) {
        Object s;
        boolean $i$f$findSegmentAndMoveForward$atomicfu$array = false;
        while (!SegmentOrClosed.isClosed-impl(s = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, createNewSegment2))) {
            boolean bl;
            Object to$iv = SegmentOrClosed.getSegment-impl(s);
            boolean $i$f$moveForward$atomicfu$array = false;
            boolean $i$f$loop$atomicfu$array = false;
            while (true) {
                Segment cur$iv = (Segment)atomicfu$handler.get(atomicfu$index);
                boolean bl2 = false;
                if (cur$iv.id >= ((Segment)to$iv).id) {
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl = false;
                    break;
                }
                if (atomicfu$handler.compareAndSet(atomicfu$index, cur$iv, to$iv)) {
                    if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv.remove();
                    }
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv).remove();
            }
            if (!bl) continue;
        }
        return s;
    }

    private static final boolean addConditionally$atomicfu(Object atomicfu$dispatchReceiver, AtomicIntegerFieldUpdater atomicfu$handler, int delta, Function1<? super Integer, Boolean> condition) {
        int cur;
        boolean $i$f$addConditionally$atomicfu = false;
        do {
            if (((Boolean)condition.invoke((Object)(cur = atomicfu$handler.get(atomicfu$dispatchReceiver)))).booleanValue()) continue;
            return false;
        } while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, cur, cur + delta));
        return true;
    }

    private static final boolean addConditionally$atomicfu$array(Object atomicfu$dispatchReceiver, AtomicIntegerArray atomicfu$handler, int atomicfu$index, int delta, Function1<? super Integer, Boolean> condition) {
        int cur;
        boolean $i$f$addConditionally$atomicfu$array = false;
        do {
            if (((Boolean)condition.invoke((Object)(cur = atomicfu$handler.get(atomicfu$index)))).booleanValue()) continue;
            return false;
        } while (!atomicfu$handler.compareAndSet(atomicfu$index, cur, cur + delta));
        return true;
    }

    private static final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }

    private static final void loop$atomicfu$array(AtomicReferenceArray atomicfu$handler, int atomicfu$index, Function1<Object, Unit> atomicfu$action) {
        boolean $i$f$loop$atomicfu$array = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$index));
        }
    }
}

