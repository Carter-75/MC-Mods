/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ah_0;
import org.valkyrienskies.core.impl.shadow.al_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Am
 */
public final class am_0
extends ah_0 {
    private al_0[] a;
    private int b;

    private am_0(int n2) {
        this(n2, true);
    }

    private am_0(int n2, boolean bl) {
        this.b = n2;
        this.a = new al_0[this.b * (this.b + 1) / 2];
        bl = true;
        am_0 am_02 = this;
        for (int i2 = 0; i2 < am_02.b; ++i2) {
            int n3 = 0;
            while (n3 < am_02.b) {
                al_0 al_02 = new al_0(bl);
                int n4 = n3++;
                int n5 = i2;
                am_0 am_03 = am_02;
                am_03.a[am_0.a((int)n5, (int)n4)] = al_02;
            }
        }
    }

    private void a(boolean bl) {
        for (int i2 = 0; i2 < this.b; ++i2) {
            for (int i3 = 0; i3 < this.b; ++i3) {
                this.a(i2, i3, new al_0(bl));
            }
        }
    }

    private static int a(int n2, int n3) {
        if (n3 < n2) {
            int n4 = n2;
            return n4 * (n4 + 1) / 2 + n3;
        }
        int n5 = n3;
        return n5 * (n5 + 1) / 2 + n2;
    }

    private al_0 b(int n2, int n3) {
        return this.a[am_0.a(n2, n3)];
    }

    private void a(int n2, int n3, al_0 al_02) {
        this.a[am_0.a((int)n2, (int)n3)] = al_02;
    }

    private double c(int n2, int n3) {
        return this.b(n2, n3).a();
    }

    private void a(double[] dArray) {
        int n2 = dArray.length;
        if (n2 != this.b) {
            throw new oS(n2, this.b);
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = i2; i3 < n2; ++i3) {
                double d2 = dArray[i3];
                double d3 = dArray[i2];
                al_0 al_02 = this.b(i2, i3);
                al_02.c += 1.0;
                double d4 = d3 - al_02.a;
                double d5 = d2 - al_02.b;
                al_02.a += d4 / al_02.c;
                al_02.b += d5 / al_02.c;
                al_02.d += (al_02.c - 1.0) / al_02.c * d4 * d5;
            }
        }
    }

    private void a(am_0 am_02) {
        if (am_02.b != this.b) {
            throw new oS(am_02.b, this.b);
        }
        for (int i2 = 0; i2 < this.b; ++i2) {
            for (int i3 = i2; i3 < this.b; ++i3) {
                al_0 al_02 = am_02.b(i2, i3);
                al_0 al_03 = this.b(i2, i3);
                double d2 = al_03.c;
                al_03.c += al_02.c;
                double d3 = al_02.a - al_03.a;
                double d4 = al_02.b - al_03.b;
                al_03.a += d3 * al_02.c / al_03.c;
                al_03.b += d4 * al_02.c / al_03.c;
                al_03.d += al_02.d + d2 * al_02.c / al_03.c * d3 * d4;
            }
        }
    }

    public final tq_0 a() {
        am_0 am_02 = this;
        double[][] dArray = new double[am_02.b][am_02.b];
        for (int i2 = 0; i2 < am_02.b; ++i2) {
            for (int i3 = 0; i3 < am_02.b; ++i3) {
                dArray[i2][i3] = am_02.b(i2, i3).a();
            }
        }
        return td_0.a(dArray);
    }

    private double[][] c() {
        double[][] dArray = new double[this.b][this.b];
        for (int i2 = 0; i2 < this.b; ++i2) {
            for (int i3 = 0; i3 < this.b; ++i3) {
                dArray[i2][i3] = this.b(i2, i3).a();
            }
        }
        return dArray;
    }

    public final int b() {
        throw new pb_0();
    }
}

