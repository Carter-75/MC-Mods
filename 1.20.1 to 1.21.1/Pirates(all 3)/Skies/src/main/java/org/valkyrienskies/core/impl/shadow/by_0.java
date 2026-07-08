/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.AH;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.aa_0;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.bt_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tb_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.By
 */
public final class by_0
extends bt_0 {
    private tn_0 a = null;
    private final double b;

    public by_0() {
        this(0.0);
    }

    private by_0(double d2) {
        this.b = 0.0;
    }

    private void a(double[] dArray, double[][] dArray2) {
        by_0.a(dArray2, dArray);
        this.a(dArray);
        this.a(dArray2);
    }

    public final void a(double[] dArray, int n2, int n3) {
        super.a(dArray, n2, n3);
        this.a = new tn_0(this.a(), this.b);
    }

    private tq_0 m() {
        int n2;
        int n3;
        Object object;
        int n4;
        Object object2 = this.a;
        if (((tn_0)object2).c == null) {
            tn_0 tn_02 = object2;
            if (tn_02.d == null) {
                n4 = tn_02.a.length;
                int n5 = tn_02.a[0].length;
                object = new double[n5][n5];
                for (n3 = n5 - 1; n3 >= BY.a(n5, n4); --n3) {
                    object[n3][n3] = 1.0;
                }
                for (n3 = BY.a(n5, n4) - 1; n3 >= 0; --n3) {
                    double[] dArray = tn_02.a[n3];
                    object[n3][n3] = 1.0;
                    if (dArray[n3] == 0.0) continue;
                    for (n2 = n3; n2 < n5; ++n2) {
                        int n6;
                        double d2 = 0.0;
                        for (n6 = n3; n6 < n5; ++n6) {
                            d2 -= object[n2][n6] * dArray[n6];
                        }
                        d2 /= tn_02.b[n3] * dArray[n3];
                        for (n6 = n3; n6 < n5; ++n6) {
                            double[] dArray2 = object[n2];
                            int n7 = n6;
                            dArray2[n7] = dArray2[n7] + -d2 * dArray[n6];
                        }
                    }
                }
                tn_02.d = td_0.a(object);
            }
            tn_02.c = tn_02.d.d();
        }
        object2 = ((tn_0)object2).c;
        int n8 = this.a.a().g();
        int n9 = n4 = object2.g();
        sy_0 sy_02 = new sy_0(n9, n9);
        object = sy_02;
        object = sy_02.a;
        for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                object[n3][n2] = n3 == n2 && n3 < n8 ? 1.0 : 0.0;
            }
        }
        return object2.c(sy_02).c(object2.d());
    }

    private double n() {
        if (this.c()) {
            return aa_0.a(this.b().g());
        }
        return ((ao_0)new AH()).a(this.b().g());
    }

    private double o() {
        tu_0 tu_02 = this.l();
        return tu_02.b(tu_02);
    }

    private double p() {
        return 1.0 - this.o() / this.n();
    }

    private double q() {
        double d2 = this.a().f();
        if (this.c()) {
            by_0 by_02 = this;
            double d3 = d2;
            return 1.0 - (1.0 - (1.0 - by_02.o() / by_02.n())) * (d3 / (d3 - (double)this.a().g()));
        }
        return 1.0 - this.o() * (d2 - 1.0) / (this.n() * (d2 - (double)this.a().g()));
    }

    protected final void a(double[][] dArray) {
        super.a(dArray);
        this.a = new tn_0(this.a(), this.b);
    }

    protected final tu_0 i() {
        return this.a.c().a(this.b());
    }

    protected final tq_0 j() {
        int n2 = this.a().g();
        tq_0 tq_02 = this.a.a().a(0, n2 - 1, 0, n2 - 1);
        tq_02 = new tb_0(tq_02).a().b();
        return tq_02.c(tq_02.d());
    }
}

