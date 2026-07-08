/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.LinkedList;
import java.util.Queue;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.kb_0;
import org.valkyrienskies.core.impl.shadow.kc_0;
import org.valkyrienskies.core.impl.shadow.kd_0;
import org.valkyrienskies.core.impl.shadow.ke_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fI
 */
public final class fi_1 {
    private static Queue a = ke_0.a(new LinkedList());

    private fi_1() {
    }

    private static <E> Queue<E> a(Queue<E> queue) {
        return kc_0.a(queue);
    }

    private static <E> Queue<E> b(Queue<? extends E> queue) {
        return ke_0.a(queue);
    }

    private static <E> Queue<E> a(Queue<E> queue, ff_1<? super E> ff_12) {
        return kb_0.a(queue, ff_12);
    }

    private static <E> Queue<E> a(Queue<E> queue, fq_1<? super E, ? extends E> fq_12) {
        return kd_0.a(queue, fq_12);
    }

    private static <E> Queue<E> a() {
        return a;
    }
}

