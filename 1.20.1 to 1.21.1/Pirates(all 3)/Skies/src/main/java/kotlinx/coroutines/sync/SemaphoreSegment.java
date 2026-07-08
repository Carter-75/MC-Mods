/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J,\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0086\b\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0086\b\u00a2\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0086\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a8\u0006R\u0014\u0010\u001e\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2={"Lkotlinx/coroutines/sync/SemaphoreSegment;", "Lkotlinx/coroutines/internal/Segment;", "", "index", "", "expected", "value", "", "cas", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "get", "(I)Ljava/lang/Object;", "getAndSet", "(ILjava/lang/Object;)Ljava/lang/Object;", "", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "", "onCancellation", "(ILjava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)V", "set", "(ILjava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/atomicfu/AtomicArray;", "acquirers", "getNumberOfSlots", "()I", "numberOfSlots", "", "id", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;I)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n371#1,2:398\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n384#1:398,2\n*E\n"})
final class SemaphoreSegment
extends Segment<SemaphoreSegment> {
    @NotNull
    private final AtomicReferenceArray acquirers = new AtomicReferenceArray(SemaphoreKt.access$getSEGMENT_SIZE$p());

    public SemaphoreSegment(long id, @Nullable SemaphoreSegment prev2, int pointers) {
        super(id, (Segment)prev2, pointers);
    }

    @NotNull
    public final AtomicReferenceArray getAcquirers() {
        return this.acquirers;
    }

    @Override
    public int getNumberOfSlots() {
        return SemaphoreKt.access$getSEGMENT_SIZE$p();
    }

    @Nullable
    public final Object get(int index) {
        boolean $i$f$get = false;
        return this.getAcquirers().get(index);
    }

    public final void set(int index, @Nullable Object value) {
        boolean $i$f$set = false;
        this.getAcquirers().set(index, value);
    }

    public final boolean cas(int index, @Nullable Object expected, @Nullable Object value) {
        boolean $i$f$cas = false;
        return this.getAcquirers().compareAndSet(index, expected, value);
    }

    @Nullable
    public final Object getAndSet(int index, @Nullable Object value) {
        boolean $i$f$getAndSet = false;
        return this.getAcquirers().getAndSet(index, value);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onCancellation(int index, @Nullable Throwable cause, @NotNull CoroutineContext context) {
        void this_$iv;
        SemaphoreSegment semaphoreSegment = this;
        Symbol value$iv = SemaphoreKt.access$getCANCELLED$p();
        boolean $i$f$set = false;
        this_$iv.getAcquirers().set(index, value$iv);
        this.onSlotCleaned();
    }

    @NotNull
    public String toString() {
        return "SemaphoreSegment[id=" + this.id + ", hashCode=" + this.hashCode() + ']';
    }
}

