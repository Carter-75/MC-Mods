/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.gT$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.gT;
import org.valkyrienskies.core.impl.shadow.gt_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gT
 */
public final class gt_1<T>
implements Serializable,
ff_1<T> {
    private static final long a = -1863209236504077399L;
    private final T b;
    private final Comparator<T> c;
    private final gt_2.a_1 d;

    private static <T> ff_1<T> a(T t, Comparator<T> comparator) {
        gt_2.a_1 a_12 = gT.a.EQUAL;
        if (comparator == null) {
            throw new NullPointerException("Comparator must not be null.");
        }
        if (a_12 == null) {
            throw new NullPointerException("Criterion must not be null.");
        }
        return new gt_1<T>(t, comparator, a_12);
    }

    private static <T> ff_1<T> a(T t, Comparator<T> comparator, gt_2.a_1 a_12) {
        if (comparator == null) {
            throw new NullPointerException("Comparator must not be null.");
        }
        if (a_12 == null) {
            throw new NullPointerException("Criterion must not be null.");
        }
        return new gt_1<T>(t, comparator, a_12);
    }

    private gt_1(T t, Comparator<T> comparator, gt_2.a_1 a_12) {
        this.b = t;
        this.c = comparator;
        this.d = a_12;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean a(T t) {
        void var1_8;
        int bl = this.c.compare(this.b, t);
        switch (1.a[this.d.ordinal()]) {
            case 1: {
                boolean bl2 = bl == 0;
                break;
            }
            case 2: {
                boolean bl3 = bl > 0;
                break;
            }
            case 3: {
                boolean bl4 = bl < 0;
                break;
            }
            case 4: {
                boolean bl5 = bl >= 0;
                break;
            }
            case 5: {
                boolean bl6 = bl <= 0;
                break;
            }
            default: {
                throw new IllegalStateException("The current criterion '" + (Object)((Object)this.d) + "' is invalid.");
            }
        }
        return (boolean)var1_8;
    }
}

