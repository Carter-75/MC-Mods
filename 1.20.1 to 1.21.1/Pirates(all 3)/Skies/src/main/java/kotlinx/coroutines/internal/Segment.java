/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B!\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u001f\u001a\u00020\b\u00a2\u0006\u0004\b \u0010!J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH&\u00a2\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0006R\u000b\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004R\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2={"Lkotlinx/coroutines/internal/Segment;", "S", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/NotCompleted;", "", "decPointers$kotlinx_coroutines_core", "()Z", "decPointers", "", "index", "", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "", "onCancellation", "(ILjava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)V", "onSlotCleaned", "()V", "tryIncPointers$kotlinx_coroutines_core", "tryIncPointers", "Lkotlinx/atomicfu/AtomicInt;", "cleanedAndPointers", "", "id", "J", "isRemoved", "getNumberOfSlots", "()I", "numberOfSlots", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n1#1,269:1\n252#2,4:270\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n*L\n225#1:270,4\n*E\n"})
public abstract class Segment<S extends Segment<S>>
extends ConcurrentLinkedListNode<S>
implements NotCompleted {
    @JvmField
    public final long id;
    @Volatile
    private volatile int cleanedAndPointers;
    @NotNull
    private static final AtomicIntegerFieldUpdater cleanedAndPointers$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");

    public Segment(long id, @Nullable S prev2, int pointers) {
        super((ConcurrentLinkedListNode)prev2);
        this.id = id;
        this.cleanedAndPointers = pointers << 16;
    }

    public abstract int getNumberOfSlots();

    @Override
    public boolean isRemoved() {
        return cleanedAndPointers$FU.get(this) == this.getNumberOfSlots() && !this.isTail();
    }

    /*
     * WARNING - void declaration
     */
    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        boolean bl;
        block1: {
            int cur$iv;
            void atomicfu$handler$iv;
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = cleanedAndPointers$FU;
            int delta$iv = 65536;
            boolean $i$f$addConditionally$atomicfu = false;
            do {
                int it = cur$iv = atomicfu$handler$iv.get(this);
                boolean bl2 = false;
                if (it != this.getNumberOfSlots() || this.isTail()) continue;
                bl = false;
                break block1;
            } while (!atomicfu$handler$iv.compareAndSet(this, cur$iv, cur$iv + delta$iv));
            bl = true;
        }
        return bl;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return cleanedAndPointers$FU.addAndGet(this, -65536) == this.getNumberOfSlots() && !this.isTail();
    }

    public abstract void onCancellation(int var1, @Nullable Throwable var2, @NotNull CoroutineContext var3);

    public final void onSlotCleaned() {
        if (cleanedAndPointers$FU.incrementAndGet(this) == this.getNumberOfSlots()) {
            this.remove();
        }
    }
}

