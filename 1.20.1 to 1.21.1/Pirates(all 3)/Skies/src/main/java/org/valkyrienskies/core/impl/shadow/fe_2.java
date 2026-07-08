/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.gd_1;
import org.valkyrienskies.core.impl.shadow.ge_1;
import org.valkyrienskies.core.impl.shadow.gf_1;
import org.valkyrienskies.core.impl.shadow.gh_1;
import org.valkyrienskies.core.impl.shadow.gi_1;
import org.valkyrienskies.core.impl.shadow.gj_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fe
 */
public final class fe_2 {
    public static final ge_1 a = ge_1.a();

    private fe_2() {
    }

    public static <E extends Comparable<? super E>> Comparator<E> a() {
        return a;
    }

    private static <E> Comparator<E> a(Comparator<E> ... comparatorArray) {
        gf_1 gf_12 = new gf_1();
        for (Comparator<E> comparator : comparatorArray) {
            if (comparator == null) {
                throw new NullPointerException("Comparator cannot be null");
            }
            gf_1 gf_13 = gf_12;
            Comparator<E> comparator2 = comparator;
            comparator = gf_13;
            boolean bl = false;
            comparator = gf_13;
            gf_13.a();
            ((gf_1)comparator).a.add(comparator2);
        }
        return gf_12;
    }

    private static <E> Comparator<E> a(Collection<Comparator<E>> comparatorArray) {
        comparatorArray = comparatorArray.toArray(new Comparator[comparatorArray.size()]);
        gf_1 gf_12 = new gf_1();
        for (Comparator bl : comparatorArray) {
            if (bl == null) {
                throw new NullPointerException("Comparator cannot be null");
            }
            Comparator comparator = bl;
            gf_1 gf_13 = gf_12;
            boolean bl2 = false;
            gf_1 gf_132 = gf_13;
            gf_13.a();
            gf_132.a.add(comparator);
        }
        return gf_12;
    }

    private static <E> Comparator<E> a(Comparator<E> comparator) {
        return new gi_1<E>(comparator);
    }

    private static Comparator<Boolean> a(boolean bl) {
        return gd_1.a(bl);
    }

    private static <E> Comparator<E> b(Comparator<E> ge_12) {
        if (ge_12 == null) {
            ge_12 = a;
        }
        return new gh_1(ge_12, false);
    }

    private static <E> Comparator<E> c(Comparator<E> ge_12) {
        if (ge_12 == null) {
            ge_12 = a;
        }
        return new gh_1(ge_12, true);
    }

    private static <I, O> Comparator<I> a(Comparator<O> ge_12, fq_1<? super I, ? extends O> fq_12) {
        if (ge_12 == null) {
            ge_12 = a;
        }
        return new gj_1<I, O>(fq_12, ge_12);
    }

    private static <E> E a(E e2, E e3, Comparator<E> ge_12) {
        int n2;
        if (ge_12 == null) {
            ge_12 = a;
        }
        if ((n2 = ge_12.compare(e2, e3)) < 0) {
            return e2;
        }
        return e3;
    }

    private static <E> E b(E e2, E e3, Comparator<E> ge_12) {
        int n2;
        if (ge_12 == null) {
            ge_12 = a;
        }
        if ((n2 = ge_12.compare(e2, e3)) > 0) {
            return e2;
        }
        return e3;
    }
}

