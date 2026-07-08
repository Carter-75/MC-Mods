/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.fe_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gI
 */
public final class gi_1<E>
implements Serializable,
Comparator<E> {
    private static final long a = 2858887242028539265L;
    private final Comparator<? super E> b;

    public gi_1() {
        this(null);
    }

    public gi_1(Comparator<? super E> comparator) {
        this.b = comparator == null ? fe_2.a : comparator;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int compare(E obj1, E obj2) {
        void var1_1;
        void var2_2;
        return this.b.compare(var2_2, var1_1);
    }

    public final int hashCode() {
        return "ReverseComparator".hashCode() ^ this.b.hashCode();
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
            gi_1 gi_12;
            gi_12 = gi_12;
            return this.b.equals(gi_12.b);
        }
        return false;
    }
}

