/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.fe_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gH
 */
public final class gh_1<E>
implements Serializable,
Comparator<E> {
    private static final long a = -5820772575483504339L;
    private final Comparator<? super E> b;
    private final boolean c;

    public gh_1() {
        this(fe_2.a, true);
    }

    private gh_1(Comparator<? super E> comparator) {
        this(comparator, true);
    }

    private gh_1(boolean bl) {
        this(fe_2.a, bl);
    }

    public gh_1(Comparator<? super E> comparator, boolean bl) {
        this.b = comparator;
        this.c = bl;
        if (comparator == null) {
            throw new NullPointerException("null nonNullComparator");
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int compare(E o1, E o2) {
        void var2_2;
        void var1_1;
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            if (this.c) {
                return 1;
            }
            return -1;
        }
        if (o2 == null) {
            if (this.c) {
                return -1;
            }
            return 1;
        }
        return this.b.compare(var1_1, var2_2);
    }

    public final int hashCode() {
        return (this.c ? -1 : 1) * this.b.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        gh_1 gh_12;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        gh_12 = gh_12;
        return this.c == gh_12.c && this.b.equals(gh_12.b);
    }
}

