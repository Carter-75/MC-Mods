/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gF
 */
public final class gf_1<E>
implements Serializable,
Comparator<E> {
    private static final long b = -721644942746081630L;
    public final List<Comparator<E>> a;
    private BitSet c = null;
    private boolean d = false;

    public gf_1() {
        this(new ArrayList<Comparator<E>>(), new BitSet());
    }

    private gf_1(Comparator<E> comparator) {
        this(comparator, false);
    }

    private gf_1(Comparator<E> comparator, boolean bl) {
        this.a = new ArrayList<Comparator<E>>(1);
        this.a.add(comparator);
        this.c = new BitSet(1);
    }

    private gf_1(List<Comparator<E>> list) {
        this(list, new BitSet(list.size()));
    }

    private gf_1(List<Comparator<E>> list, BitSet bitSet) {
        this.a = list;
        this.c = bitSet;
    }

    public final void a(Comparator<E> comparator) {
        this.a(comparator, false);
    }

    private void a(Comparator<E> comparator, boolean bl) {
        this.a();
        this.a.add(comparator);
    }

    private void a(int n2, Comparator<E> comparator) {
        int n3 = n2;
        n2 = 0;
        Comparator<E> comparator2 = comparator;
        int n4 = n3;
        gf_1 gf_12 = this;
        gf_12.a();
        gf_12.a.set(n4, comparator2);
        gf_12.c.clear(n4);
    }

    private void a(int n2, Comparator<E> comparator, boolean bl) {
        this.a();
        this.a.set(n2, comparator);
        this.c.clear(n2);
    }

    private void a(int n2) {
        this.a();
        this.c.clear(n2);
    }

    private void b(int n2) {
        this.a();
        this.c.set(n2);
    }

    private int b() {
        return this.a.size();
    }

    private boolean c() {
        return this.d;
    }

    public void a() {
        if (this.d) {
            throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    private void d() {
        if (this.a.size() == 0) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    @Override
    public final int compare(E o1, E o2) {
        Object object;
        if (!this.d) {
            object = this;
            if (((gf_1)object).a.size() == 0) {
                throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
            }
            this.d = true;
        }
        object = this.a.iterator();
        int n2 = 0;
        while (object.hasNext()) {
            Comparator comparator = (Comparator)object.next();
            int n3 = comparator.compare(o1, o2);
            if (n3 != 0) {
                if (this.c.get(n2)) {
                    n3 = n3 > 0 ? -1 : 1;
                }
                return n3;
            }
            ++n2;
        }
        return 0;
    }

    public final int hashCode() {
        int n2 = 0;
        if (this.a != null) {
            n2 = 0 ^ this.a.hashCode();
        }
        if (this.c != null) {
            n2 ^= this.c.hashCode();
        }
        return n2;
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass().equals(this.getClass())) {
            gf_1 gf_12;
            gf_12 = gf_12;
            return (this.c == null ? gf_12.c == null : this.c.equals(gf_12.c)) && (this.a == null ? gf_12.a == null : this.a.equals(gf_12.a));
        }
        return false;
    }
}

