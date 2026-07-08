/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Queue;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.gy_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kb
 */
public final class kb_0<E>
extends gy_2<E>
implements Queue<E> {
    private static final long b = 2307609000539943581L;

    public static <E> kb_0<E> a(Queue<E> queue, ff_1<? super E> ff_12) {
        return new kb_0<E>(queue, ff_12);
    }

    private kb_0(Queue<E> queue, ff_1<? super E> ff_12) {
        super(queue, ff_12);
    }

    private Queue<E> a() {
        return (Queue)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean offer(E object) {
        void var1_1;
        this.b(object);
        kb_0 kb_02 = this;
        return ((Queue)super.f()).offer(var1_1);
    }

    @Override
    public final E poll() {
        kb_0 kb_02 = this;
        return ((Queue)super.f()).poll();
    }

    @Override
    public final E peek() {
        kb_0 kb_02 = this;
        return ((Queue)super.f()).peek();
    }

    @Override
    public final E element() {
        kb_0 kb_02 = this;
        return ((Queue)super.f()).element();
    }

    @Override
    public final E remove() {
        kb_0 kb_02 = this;
        return ((Queue)super.f()).remove();
    }
}

