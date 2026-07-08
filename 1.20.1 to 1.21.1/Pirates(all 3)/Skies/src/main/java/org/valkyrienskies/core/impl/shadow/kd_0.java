/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Queue;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.ga_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kd
 */
public final class kd_0<E>
extends ga_1<E>
implements Queue<E> {
    private static final long b = -7901091318986132033L;

    public static <E> kd_0<E> a(Queue<E> queue, fq_1<? super E, ? extends E> fq_12) {
        return new kd_0<E>(queue, fq_12);
    }

    private static <E> kd_0<E> b(Queue<E> objectArray, fq_1<? super E, ? extends E> fq_12) {
        kd_0<E> kd_02 = new kd_0<E>(objectArray, fq_12);
        if (objectArray.size() > 0) {
            Object[] objectArray2 = objectArray.toArray();
            objectArray.clear();
            objectArray = objectArray2;
            int n2 = objectArray2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                kd_02.f().add(fq_12.a(object));
            }
        }
        return kd_02;
    }

    private kd_0(Queue<E> queue, fq_1<? super E, ? extends E> fq_12) {
        super(queue, fq_12);
    }

    private Queue<E> a() {
        return (Queue)this.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean offer(E obj) {
        void var1_1;
        kd_0 kd_02 = this;
        return ((Queue)kd_02.f()).offer(this.b(var1_1));
    }

    @Override
    public final E poll() {
        kd_0 kd_02 = this;
        return ((Queue)kd_02.f()).poll();
    }

    @Override
    public final E peek() {
        kd_0 kd_02 = this;
        return ((Queue)kd_02.f()).peek();
    }

    @Override
    public final E element() {
        kd_0 kd_02 = this;
        return ((Queue)kd_02.f()).element();
    }

    @Override
    public final E remove() {
        kd_0 kd_02 = this;
        return ((Queue)kd_02.f()).remove();
    }
}

