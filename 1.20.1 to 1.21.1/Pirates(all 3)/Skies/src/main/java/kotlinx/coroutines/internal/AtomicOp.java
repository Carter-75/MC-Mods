/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OpDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\r\u0010\u000bR\u0013\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e8\u0002X\u0082\u0004R\u0018\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2={"Lkotlinx/coroutines/internal/AtomicOp;", "T", "Lkotlinx/coroutines/internal/OpDescriptor;", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "Lkotlinx/atomicfu/AtomicRef;", "_consensus", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "<init>", "()V", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
@SourceDebugExtension(value={"SMAP\nAtomic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Atomic.kt\nkotlinx/coroutines/internal/AtomicOp\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
public abstract class AtomicOp<T>
extends OpDescriptor {
    @Volatile
    @Nullable
    private volatile Object _consensus = AtomicKt.NO_DECISION;
    @NotNull
    private static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");

    @Override
    @NotNull
    public AtomicOp<?> getAtomicOp() {
        return this;
    }

    private final Object decide(Object decision) {
        Object current;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(decision != AtomicKt.NO_DECISION)) {
                throw new AssertionError();
            }
        }
        if ((current = _consensus$FU.get(this)) != AtomicKt.NO_DECISION) {
            return current;
        }
        if (_consensus$FU.compareAndSet(this, AtomicKt.NO_DECISION, decision)) {
            return decision;
        }
        return _consensus$FU.get(this);
    }

    @Nullable
    public abstract Object prepare(T var1);

    public abstract void complete(T var1, @Nullable Object var2);

    @Override
    @Nullable
    public final Object perform(@Nullable Object affected) {
        Object decision = _consensus$FU.get(this);
        if (decision == AtomicKt.NO_DECISION) {
            decision = this.decide(this.prepare(affected));
        }
        this.complete(affected, decision);
        return decision;
    }
}

