/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

public final class FP<E>
extends AbstractQueue<E>
implements Serializable,
BlockingQueue<E> {
    private final ReentrantLock a = new ReentrantLock();
    private final Condition b = this.a.newCondition();
    private final SortedSet<E> c = new TreeSet();

    private int a() {
        this.a.lock();
        try {
            int n2 = this.c.size();
            return n2;
        }
        finally {
            this.a.unlock();
        }
    }

    @Override
    public final Iterator<E> iterator() {
        this.a.lock();
        try {
            Iterator iterator2 = CollectionsKt.toMutableList((Collection)this.c).listIterator();
            return iterator2;
        }
        finally {
            this.a.unlock();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E poll(long timeout, TimeUnit unit) {
        void var1_1;
        void var3_4;
        Intrinsics.checkNotNullParameter((Object)((Object)unit), (String)"");
        long l2 = var3_4.toNanos((long)var1_1);
        this.a.lockInterruptibly();
        try {
            E e2 = null;
            while (l2 > 0L) {
                E e3 = this.b();
                e2 = e3;
                if (e3 != null) break;
                l2 = this.b.awaitNanos(l2);
            }
            return e2;
        }
        finally {
            this.a.unlock();
        }
    }

    @Override
    public final E poll() {
        this.a.lock();
        try {
            E e2 = this.b();
            return e2;
        }
        finally {
            this.a.unlock();
        }
    }

    private final E b() {
        if (this.c.isEmpty()) {
            return null;
        }
        E e2 = this.c.first();
        this.c.remove(e2);
        return e2;
    }

    @Override
    public final E peek() {
        this.a.lock();
        try {
            E e2 = !((Collection)this.c).isEmpty() ? (E)this.c.first() : null;
            return e2;
        }
        finally {
            this.a.unlock();
        }
    }

    @Override
    public final E take() {
        this.a.lockInterruptibly();
        try {
            E e2;
            while ((e2 = this.b()) == null) {
                this.b.await();
            }
            return e2;
        }
        finally {
            this.a.unlock();
        }
    }

    @Override
    public final int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public final int drainTo(Collection<? super E> drain, int maxElements) {
        Intrinsics.checkNotNullParameter(drain, (String)"");
        if (Intrinsics.areEqual(drain, (Object)this)) {
            throw new IllegalArgumentException();
        }
        if (maxElements <= 0) {
            return 0;
        }
        this.a.lock();
        try {
            int n2;
            Iterator iterator2 = this.c.iterator();
            for (n2 = 0; iterator2.hasNext() && n2 < maxElements; ++n2) {
                drain.add(iterator2.next());
            }
            int n3 = n2;
            return n3;
        }
        finally {
            this.a.unlock();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int drainTo(Collection<? super E> drain) {
        void var1_1;
        Intrinsics.checkNotNullParameter(drain, (String)"");
        return this.drainTo((Collection<? super E>)var1_1, Integer.MAX_VALUE);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void put(E e2) {
        void var1_1;
        this.offer(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean offer(E e2, long timeout, TimeUnit unit) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)((Object)unit), (String)"");
        return this.offer(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean offer(E e2) {
        this.a.lock();
        try {
            void var1_1;
            this.c.add(var1_1);
            this.b.signal();
            return true;
        }
        finally {
            this.a.unlock();
        }
    }

    private boolean a(E e2) {
        this.a.lock();
        try {
            boolean bl = this.c.remove(e2);
            return bl;
        }
        finally {
            this.a.unlock();
        }
    }

    private void a(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"");
        FP fP = this;
        fP.a.lock();
        try {
            function0.invoke();
            return;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            fP = this;
            fP.a.unlock();
            InlineMarker.finallyEnd((int)1);
        }
    }

    @Override
    public final int size() {
        return this.a();
    }

    private static /* synthetic */ ReentrantLock a(FP fP) {
        return fP.a;
    }
}

