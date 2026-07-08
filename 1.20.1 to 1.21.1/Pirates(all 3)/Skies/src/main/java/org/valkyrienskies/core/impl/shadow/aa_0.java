/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import org.valkyrienskies.core.impl.shadow.AE;
import org.valkyrienskies.core.impl.shadow.AG;
import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.AP;
import org.valkyrienskies.core.impl.shadow.AR;
import org.valkyrienskies.core.impl.shadow.AT;
import org.valkyrienskies.core.impl.shadow.AU;
import org.valkyrienskies.core.impl.shadow.AV;
import org.valkyrienskies.core.impl.shadow.AW;
import org.valkyrienskies.core.impl.shadow.AX;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.aq_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zZ;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Aa
 */
public final class aa_0 {
    private static final AV a = new AV();
    private static final AX b = new AX();
    private static final AU c = new AU();
    private static final AW d = new AW();
    private static final AR e = new AR();
    private static final AP f = new AP();
    private static final AG g = new AG();
    private static final AM h = new AM();
    private static final AT i = new AT();
    private static final AE j = new AE();

    private aa_0() {
    }

    private static double d(double[] dArray) {
        return a.a(dArray);
    }

    private static double a(double[] dArray, int n2, int n3) {
        return a.a(dArray, n2, n3);
    }

    public static double a(double[] dArray) {
        return b.a(dArray);
    }

    private static double b(double[] dArray, int n2, int n3) {
        return b.a(dArray, n2, n3);
    }

    private static double e(double[] dArray) {
        return c.a(dArray);
    }

    private static double c(double[] dArray, int n2, int n3) {
        return c.a(dArray, n2, n3);
    }

    private static double f(double[] dArray) {
        return d.a(dArray);
    }

    private static double d(double[] dArray, int n2, int n3) {
        return d.a(dArray, n2, n3);
    }

    public static double b(double[] dArray) {
        return g.a(dArray);
    }

    private static double e(double[] dArray, int n2, int n3) {
        return g.a(dArray, n2, n3);
    }

    private static double g(double[] dArray) {
        return ((ao_0)j).a(dArray);
    }

    private static double f(double[] dArray, int n2, int n3) {
        return ((ao_0)j).a(dArray, n2, n3);
    }

    public static double c(double[] dArray) {
        return ((ao_0)h).a(dArray);
    }

    private static double g(double[] dArray, int n2, int n3) {
        return ((ao_0)h).a(dArray, n2, n3);
    }

    private static double a(double[] dArray, double d2, int n2, int n3) {
        return h.a(dArray, d2, n2, n3);
    }

    private static double a(double[] dArray, double d2) {
        return h.a(dArray, d2);
    }

    private static double h(double[] dArray) {
        return ((ao_0)new AM(false)).a(dArray);
    }

    private static double h(double[] dArray, int n2, int n3) {
        return ((ao_0)new AM(false)).a(dArray, n2, n3);
    }

    private static double b(double[] dArray, double d2, int n2, int n3) {
        return new AM(false).a(dArray, d2, n2, n3);
    }

    private static double b(double[] dArray, double d2) {
        return new AM(false).a(dArray, d2);
    }

    private static double i(double[] dArray) {
        return f.a(dArray);
    }

    private static double i(double[] dArray, int n2, int n3) {
        return f.a(dArray, n2, n3);
    }

    private static double j(double[] dArray) {
        return e.a(dArray);
    }

    private static double j(double[] dArray, int n2, int n3) {
        return e.a(dArray, n2, n3);
    }

    private static double c(double[] dArray, double d2) {
        return i.a(dArray, d2);
    }

    private static double a(double[] dArray, int n2, int n3, double d2) {
        return i.a(dArray, n2, n3, d2);
    }

    private static double b(double[] dArray, double[] dArray2) {
        int n2 = dArray.length;
        if (n2 != dArray2.length) {
            throw new oS(n2, dArray2.length);
        }
        if (n2 <= 0) {
            throw new pf_0(px_0.INSUFFICIENT_DIMENSION);
        }
        double d2 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            d2 += dArray[i2] - dArray2[i2];
        }
        return d2;
    }

    public static double a(double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        dArray2 = dArray;
        int n2 = dArray.length;
        if (n2 != dArray3.length) {
            throw new oS(n2, dArray3.length);
        }
        if (n2 <= 0) {
            throw new pf_0(px_0.INSUFFICIENT_DIMENSION);
        }
        double d2 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            d2 += dArray2[i2] - dArray3[i2];
        }
        return d2 / (double)dArray.length;
    }

    public static double a(double[] dArray, double[] dArray2, double d2) {
        double d3 = 0.0;
        double d4 = 0.0;
        int n2 = dArray.length;
        if (n2 != dArray2.length) {
            throw new oS(n2, dArray2.length);
        }
        if (n2 < 2) {
            throw new pn_0(n2, (Number)2, true);
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            double d5 = dArray[i2] - dArray2[i2];
            d3 += (d5 - d2) * (d5 - d2);
            d4 += d5 - d2;
        }
        double d6 = d4;
        return (d3 - d6 * d6 / (double)n2) / (double)(n2 - 1);
    }

    private static double[] k(double[] dArray) {
        Object object = new aq_0();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            ((aq_0)object).a(dArray[i2]);
        }
        double d2 = ((aq_0)object).b();
        double d3 = ((aq_0)object).e();
        object = new double[dArray.length];
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            object[i3] = (dArray[i3] - d2) / d3;
        }
        return object;
    }

    private static double[] l(double[] dArray) {
        if (dArray == null) {
            throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
        }
        return aa_0.l(dArray, 0, dArray.length);
    }

    private static double[] k(double[] dArray, int n2, int n3) {
        if (dArray == null) {
            throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
        }
        if (n2 < 0) {
            throw new pj_0(px_0.START_POSITION, n2);
        }
        if (n3 < 0) {
            throw new pj_0(px_0.LENGTH, n3);
        }
        return aa_0.l(dArray, n2, n3);
    }

    private static double[] l(double[] object, int n2, int n3) {
        zZ zZ2 = new zZ();
        for (int i2 = n2; i2 < n2 + n3; ++i2) {
            double d2 = object[i2];
            if (Double.isNaN(d2)) continue;
            Double d3 = d2;
            zZ zZ3 = zZ2;
            zZ3.a(d3, 1L);
        }
        List<Comparable<?>> list = zZ2.a();
        double[] dArray = new double[list.size()];
        int n4 = 0;
        object = list.iterator();
        while (object.hasNext()) {
            Comparable comparable = (Comparable)object.next();
            dArray[n4++] = (Double)comparable;
        }
        return dArray;
    }
}

