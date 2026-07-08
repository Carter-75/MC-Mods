/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Queue;
import org.valkyrienskies.core.impl.shadow.gz_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kc
 */
public final class kc_0<E>
extends gz_2<E>
implements Queue<E> {
    private static final long b = 1L;

    public static <E> kc_0<E> a(Queue<E> queue) {
        return new kc_0<E>(queue);
    }

    private kc_0(Queue<E> queue) {
        super(queue);
    }

    private kc_0(Queue<E> queue, Object object) {
        super(queue, object);
    }

    private Queue<E> a() {
        return (Queue)super.e();
    }

    @Override
    public final E element() {
        Object object = this.a;
        synchronized (object) {
            kc_0 kc_02 = this;
            return ((Queue)super.e()).element();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        Object object2 = this.a;
        synchronized (object2) {
            void var1_1;
            kc_0 kc_02 = this;
            return ((Queue)super.e()).equals(var1_1);
        }
    }

    @Override
    public final int hashCode() {
        Object object = this.a;
        synchronized (object) {
            kc_0 kc_02 = this;
            return ((Queue)super.e()).hashCode();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean offer(E e2) {
        Object object = this.a;
        synchronized (object) {
            void var1_1;
            kc_0 kc_02 = this;
            return ((Queue)super.e()).offer(var1_1);
        }
    }

    @Override
    public final E peek() {
        Object object = this.a;
        synchronized (object) {
            kc_0 kc_02 = this;
            return ((Queue)super.e()).peek();
        }
    }

    @Override
    public final E poll() {
        Object object = this.a;
        synchronized (object) {
            kc_0 kc_02 = this;
            return ((Queue)super.e()).poll();
        }
    }

    @Override
    public final E remove() {
        Object object = this.a;
        synchronized (object) {
            kc_0 kc_02 = this;
            return ((Queue)super.e()).remove();
        }
    }
}

