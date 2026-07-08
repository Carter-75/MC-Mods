/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.aw_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oo_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Be
 */
public final class be_0 {
    public final double a(Collection<double[]> object) {
        a a2 = this.c((Collection<double[]>)object);
        object = a2;
        object = a2;
        return a2.c;
    }

    public final double b(Collection<double[]> object) {
        Object object2 = object = this.c((Collection<double[]>)object);
        Object object3 = object2;
        object3 = object;
        Object object4 = object3 = new oo_0(null, (double)((a)object2).a, (double)((a)object3).b);
        object3 = object;
        return 1.0 - ((oo_0)object4).e(((a)object3).c);
    }

    private double a(Collection<aw_0> object, boolean bl) {
        Object object2 = object = be_0.b(object, bl);
        Object object3 = object2;
        object3 = object;
        Object object4 = object3 = new oo_0(null, (double)((a)object2).a, (double)((a)object3).b);
        object3 = object;
        return 1.0 - ((oo_0)object4).e(((a)object3).c);
    }

    a c(Collection<double[]> object) {
        ci_0.a(object);
        ArrayList<aw_0> arrayList = new ArrayList<aw_0>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            double[] dArray = (double[])object.next();
            aw_0 aw_02 = new aw_0();
            arrayList.add(aw_02);
            for (double d2 : dArray) {
                aw_02.a(d2);
            }
        }
        return be_0.b(arrayList, false);
    }

    public final boolean a(Collection<double[]> collection, double d2) {
        if (d2 <= 0.0 || d2 > 0.5) {
            throw new po_0(px_0.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, (Number)d2, 0, 0.5);
        }
        return this.b(collection) < d2;
    }

    private static a b(Collection<aw_0> collection, boolean bl) {
        double d2;
        double d3;
        ci_0.a(collection);
        if (!bl) {
            if (collection.size() < 2) {
                throw new oS(px_0.TWO_OR_MORE_CATEGORIES_REQUIRED, collection.size(), 2);
            }
            for (aw_0 aw_02 : collection) {
                if (aw_02.d() > 1L) continue;
                throw new oS(px_0.TWO_OR_MORE_VALUES_IN_CATEGORY_REQUIRED, (int)aw_02.d(), 2);
            }
        }
        bl = false;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        int n2 = 0;
        for (aw_0 aw_03 : collection) {
            d3 = aw_03.f();
            double d7 = aw_03.i();
            int n3 = (int)aw_03.d();
            n2 += n3;
            d5 += d3;
            d6 += d7;
            bl += n3 - 1;
            double d8 = d3;
            d2 = d7 - d8 * d8 / (double)n3;
            d4 += d2;
        }
        double d9 = d5;
        double d10 = d6 - d9 * d9 / (double)n2;
        d3 = d10 - d4;
        int n4 = collection.size() - 1;
        double d11 = d3 / (double)n4;
        d2 = d4 / (double)bl;
        double d12 = d11 / d2;
        return new a(n4, bl ? 1 : 0, d12, 0);
    }

    static final class 1 {
    }

    static final class a {
        final int a;
        final int b;
        final double c;

        private a(int n2, int n3, double d2) {
            this.a = n2;
            this.b = n3;
            this.c = d2;
        }

        static /* synthetic */ double a(a a2) {
            return a2.c;
        }

        static /* synthetic */ int b(a a2) {
            return a2.a;
        }

        static /* synthetic */ int c(a a2) {
            return a2.b;
        }

        /* synthetic */ a(int n2, int n3, double d2, byte by) {
            this(n2, n3, d2);
        }
    }
}

