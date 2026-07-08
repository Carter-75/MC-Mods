/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.fe_2;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gJ
 */
public final class gj_1<I, O>
implements Serializable,
Comparator<I> {
    private static final long a = 3456940356043606220L;
    private final Comparator<O> b;
    private final fq_1<? super I, ? extends O> c;

    private gj_1(fq_1<? super I, ? extends O> fq_12) {
        this(fq_12, fe_2.a);
    }

    public gj_1(fq_1<? super I, ? extends O> fq_12, Comparator<O> comparator) {
        this.b = comparator;
        this.c = fq_12;
    }

    @Override
    public final int compare(I obj1, I obj2) {
        O o;
        O o2;
        o2 = this.c.a((void)o2);
        o = this.c.a((void)o);
        return this.b.compare(o2, o);
    }

    public final int hashCode() {
        int n2 = 629 + (this.b == null ? 0 : this.b.hashCode());
        n2 = n2 * 37 + (this.c == null ? 0 : this.c.hashCode());
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
            gj_1 gj_12;
            gj_12 = gj_12;
            return (this.b == null ? gj_12.b == null : this.b.equals(gj_12.b)) && (this.c == null ? gj_12.c == null : this.c.equals(gj_12.c));
        }
        return false;
    }
}

