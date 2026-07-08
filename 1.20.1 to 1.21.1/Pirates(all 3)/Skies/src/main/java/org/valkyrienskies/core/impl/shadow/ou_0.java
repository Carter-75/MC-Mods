/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qd_0;
import org.valkyrienskies.core.impl.shadow.qe_0;
import org.valkyrienskies.core.impl.shadow.qh_0;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ou
 */
public final class ou_0
implements Serializable {
    private static final long a = -4670676796862967187L;
    private int b;

    private ou_0(int n2) {
        if (n2 <= 0) {
            throw new pk_0(px_0.NOT_POSITIVE_NUMBER_OF_SAMPLES, n2);
        }
        this.b = n2;
    }

    private double a(double d2) {
        return this.a(d2, false);
    }

    private double b(double d2) {
        return this.a(d2, true);
    }

    private double a(double d2, boolean bl) {
        double d3 = 1.0 / (double)this.b;
        double d4 = d3 * 0.5;
        if (d2 <= d4) {
            return 0.0;
        }
        if (d4 < d2 && d2 <= d3) {
            double d5 = 1.0;
            double d6 = d2 * 2.0 - d3;
            for (int i2 = 1; i2 <= this.b; ++i2) {
                d5 *= (double)i2 * d6;
            }
            return d5;
        }
        if (1.0 - d3 <= d2 && d2 < 1.0) {
            return 1.0 - 2.0 * BY.a(1.0 - d2, this.b);
        }
        if (1.0 <= d2) {
            return 1.0;
        }
        if (bl) {
            return this.c(d2);
        }
        return this.d(d2);
    }

    private double c(double d2) {
        int n2 = (int)BY.z((double)this.b * d2);
        Object object = this.e(d2);
        object = object.a(this.b);
        object = (qd_0)object.b(n2 - 1, n2 - 1);
        for (int i2 = 1; i2 <= this.b; ++i2) {
            object = ((qd_0)object).c(i2).b(this.b);
        }
        return ((qd_0)object).a(20, 4).doubleValue();
    }

    private double d(double d2) {
        int n2;
        int n3 = (int)BY.z((double)this.b * d2);
        sx_0 sx_02 = this.e(d2);
        int n4 = n2 = sx_02.f();
        sy_0 sy_02 = new sy_0(n4, n4);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                sy_02.c(i2, i3, ((qd_0)sx_02.b(i2, i3)).doubleValue());
            }
        }
        tq_0 tq_02 = sy_02.a(this.b);
        double d3 = tq_02.b(n3 - 1, n3 - 1);
        for (int i4 = 1; i4 <= this.b; ++i4) {
            d3 *= (double)i4 / (double)this.b;
        }
        return d3;
    }

    private sQ<qd_0> e(double d2) {
        int n2;
        qd_0 qd_02;
        double d3;
        int n3 = (int)BY.z((double)this.b * d2);
        int n4 = 2 * n3 - 1;
        double d4 = (double)n3 - (double)this.b * d2;
        if (d3 >= 1.0) {
            throw new pm_0(d4, (Number)1.0, false);
        }
        try {
            qd_02 = new qd_0(d4, 1.0E-20, 10000);
        }
        catch (qh_0 qh_02) {
            try {
                qd_02 = new qd_0(d4, 1.0E-10, 10000);
            }
            catch (qh_0 qh_03) {
                qd_02 = new qd_0(d4, 1.0E-5, 10000);
            }
        }
        int n5 = n4;
        kN[][] kNArray = new qd_0[n5][n5];
        for (n3 = 0; n3 < n4; ++n3) {
            for (int i2 = 0; i2 < n4; ++i2) {
                kNArray[n3][i2] = n3 - i2 + 1 < 0 ? qd_0.c : qd_0.b;
            }
        }
        qd_0[] qd_0Array = new qd_0[n4];
        qd_0[] qd_0Array2 = qd_0Array;
        qd_0Array[0] = qd_02;
        for (n2 = 1; n2 < n4; ++n2) {
            qd_0Array2[n2] = qd_02.d(qd_0Array2[n2 - 1]);
        }
        for (n2 = 0; n2 < n4; ++n2) {
            kNArray[n2][0] = kNArray[n2][0].e(qd_0Array2[n2]);
            kNArray[n4 - 1][n2] = ((qd_0)kNArray[n4 - 1][n2]).e(qd_0Array2[n4 - n2 - 1]);
        }
        if (qd_02.b(qd_0.e) == 1) {
            kNArray[n4 - 1][0] = ((qd_0)kNArray[n4 - 1][0]).a(qd_02.c(2).e(1).d(n4));
        }
        for (n2 = 0; n2 < n4; ++n2) {
            for (int i3 = 0; i3 < n2 + 1; ++i3) {
                if (n2 - i3 + 1 <= 0) continue;
                for (int i4 = 2; i4 <= n2 - i3 + 1; ++i4) {
                    kNArray[n2][i3] = ((qd_0)kNArray[n2][i3]).b(i4);
                }
            }
        }
        return new sx_0((kM)qe_0.a.a(), kNArray);
    }
}

