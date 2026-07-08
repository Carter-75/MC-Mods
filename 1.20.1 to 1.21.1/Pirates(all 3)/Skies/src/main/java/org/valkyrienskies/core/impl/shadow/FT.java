/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.ig_0;
import org.valkyrienskies.core.impl.shadow.il_0;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R,\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\u0007\u0010\nR(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0007\u0010\u0010"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FT;", "", "", "c", "()Z", "Ljava/util/concurrent/Future;", "Lorg/valkyrienskies/core/impl/shadow/Ig;", "a", "Ljava/util/concurrent/Future;", "()Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "Ljava/util/Queue;", "Lorg/valkyrienskies/core/impl/shadow/Il;", "b", "Ljava/util/Queue;", "()Ljava/util/Queue;", "(Ljava/util/Queue;)V", "p0", "p1", "<init>", "(Ljava/util/concurrent/Future;Ljava/util/Queue;)V"})
public final class FT {
    public Future<ig_0> a;
    public Queue<il_0> b;

    private FT(Future<ig_0> future, Queue<il_0> queue) {
        Intrinsics.checkNotNullParameter(queue, (String)"");
        this.a = future;
        this.b = queue;
    }

    public /* synthetic */ FT(Future future, Queue queue, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            future = null;
        }
        if ((n2 & 2) != 0) {
            queue = new ArrayDeque();
        }
        this(future, queue);
    }

    @JvmName(name="a")
    public final Future<ig_0> a() {
        return this.a;
    }

    @JvmName(name="a")
    public final void a(Future<ig_0> future) {
        this.a = future;
    }

    @JvmName(name="b")
    public final Queue<il_0> b() {
        return this.b;
    }

    @JvmName(name="a")
    private void a(Queue<il_0> queue) {
        Intrinsics.checkNotNullParameter(queue, (String)"");
        this.b = queue;
    }

    public final boolean c() {
        return this.a == null && this.b.isEmpty();
    }

    public FT() {
        this(null, null, 3, null);
    }
}

