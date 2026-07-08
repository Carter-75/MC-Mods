/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Queue;
import org.valkyrienskies.core.impl.shadow.gv_2;

public abstract class jZ<E>
extends gv_2<E>
implements Queue<E> {
    private static final long a = -2629815475789577029L;

    protected jZ() {
    }

    protected jZ(Queue<E> queue) {
        super(queue);
    }

    protected final Queue<E> a() {
        return (Queue)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean offer(E obj) {
        void var1_1;
        jZ jZ2 = this;
        return ((Queue)super.f()).offer(var1_1);
    }

    @Override
    public E poll() {
        jZ jZ2 = this;
        return ((Queue)super.f()).poll();
    }

    @Override
    public E peek() {
        jZ jZ2 = this;
        return ((Queue)super.f()).peek();
    }

    @Override
    public E element() {
        jZ jZ2 = this;
        return ((Queue)super.f()).element();
    }

    @Override
    public E remove() {
        jZ jZ2 = this;
        return ((Queue)super.f()).remove();
    }
}

