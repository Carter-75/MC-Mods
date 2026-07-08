/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.te_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tj_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public final class sE {
    private static double a = 1.0E-15;
    private static double b = 1.0E-10;
    private double[][] c;
    private tq_0 d;
    private tq_0 e;

    public sE(tq_0 tq_02) {
        this(tq_02, 1.0E-15, 1.0E-10);
    }

    public sE(tq_0 tq_02, double d2, double d3) {
        double[] dArray;
        int n2;
        if (!tq_02.e()) {
            throw new th_0(tq_02.f(), tq_02.g());
        }
        int n3 = tq_02.f();
        this.c = tq_02.a();
        this.d = null;
        this.e = null;
        for (n2 = 0; n2 < n3; ++n2) {
            dArray = this.c[n2];
            for (int i2 = n2 + 1; i2 < n3; ++i2) {
                double[] dArray2 = this.c[i2];
                double d4 = dArray[i2];
                double d5 = dArray2[n2];
                double d6 = d2 * BY.e(BY.w(d4), BY.w(d5));
                if (BY.w(d4 - d5) > d6) {
                    throw new tj_0(n2, i2, d2);
                }
                dArray2[n2] = 0.0;
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            double[] dArray3;
            dArray = this.c[n2];
            if (dArray3[n2] <= d3) {
                throw new te_0(dArray[n2], n2, d3);
            }
            dArray[n2] = BY.a(dArray[n2]);
            double d7 = 1.0 / dArray[n2];
            for (int i3 = n3 - 1; i3 > n2; --i3) {
                int n4 = i3;
                dArray[n4] = dArray[n4] * d7;
                double[] dArray4 = this.c[i3];
                for (int i4 = i3; i4 < n3; ++i4) {
                    int n5 = i4;
                    dArray4[n5] = dArray4[n5] - dArray[i3] * dArray[i4];
                }
            }
        }
    }

    private tq_0 b() {
        if (this.d == null) {
            sE sE2 = this;
            if (sE2.e == null) {
                sE2.e = td_0.a(sE2.c);
            }
            sE2.d = sE2.e.d();
        }
        return this.d;
    }

    private tq_0 c() {
        if (this.e == null) {
            this.e = td_0.a(this.c);
        }
        return this.e;
    }

    private double d() {
        double d2 = 1.0;
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            double d3;
            double d4 = d3 = this.c[i2][i2];
            d2 *= d4 * d4;
        }
        return d2;
    }

    public final a a() {
        return new a(this.c, 0);
    }

    static final class 1 {
    }

    static final class a
    implements sG {
        private final double[][] a;

        private a(double[][] dArray) {
            this.a = dArray;
        }

        public final boolean a() {
            return true;
        }

        public final tu_0 a(tu_0 object) {
            int n2;
            int n3 = this.a.length;
            if (((tu_0)object).f() != n3) {
                throw new oS(((tu_0)object).f(), n3);
            }
            object = ((tu_0)object).g();
            for (n2 = 0; n2 < n3; ++n2) {
                double[] dArray = this.a[n2];
                Object object2 = object;
                int n4 = n2;
                object2[n4] = object2[n4] / dArray[n2];
                Object object3 = object[n2];
                for (int i2 = n2 + 1; i2 < n3; ++i2) {
                    Object object4 = object;
                    int n5 = i2;
                    object4[n5] = object4[n5] - object3 * dArray[i2];
                }
            }
            for (n2 = n3 - 1; n2 >= 0; --n2) {
                Object object5 = object;
                int n6 = n2;
                object5[n6] = object5[n6] / this.a[n2][n2];
                Object object6 = object[n2];
                for (int i3 = 0; i3 < n2; ++i3) {
                    Object object7 = object;
                    int n7 = i3;
                    object7[n7] = object7[n7] - object6 * this.a[i3][n2];
                }
            }
            return new sA((double[])object, false);
        }

        public final tq_0 a(tq_0 object) {
            int n2;
            int n3 = this.a.length;
            if (object.f() != n3) {
                throw new oS(object.f(), n3);
            }
            int n4 = object.g();
            object = object.a();
            for (n2 = 0; n2 < n3; ++n2) {
                double[] dArray = this.a[n2];
                double d2 = dArray[n2];
                Object object2 = object[n2];
                int n5 = 0;
                while (n5 < n4) {
                    Object object3 = object2;
                    int n6 = n5++;
                    object3[n6] = object3[n6] / d2;
                }
                for (n5 = n2 + 1; n5 < n3; ++n5) {
                    Object object4 = object[n5];
                    double d3 = dArray[n5];
                    for (int i2 = 0; i2 < n4; ++i2) {
                        Object object5 = object4;
                        int n7 = i2;
                        object5[n7] = object5[n7] - object2[i2] * d3;
                    }
                }
            }
            for (n2 = n3 - 1; n2 >= 0; --n2) {
                double d4 = this.a[n2][n2];
                Object object6 = object[n2];
                int n8 = 0;
                while (n8 < n4) {
                    Object object7 = object6;
                    int n9 = n8++;
                    object7[n9] = object7[n9] / d4;
                }
                for (n8 = 0; n8 < n2; ++n8) {
                    Object object8 = object[n8];
                    double d5 = this.a[n8][n2];
                    for (int i3 = 0; i3 < n4; ++i3) {
                        Object object9 = object8;
                        int n10 = i3;
                        object9[n10] = object9[n10] - object6[i3] * d5;
                    }
                }
            }
            return new sy_0((double[][])object);
        }

        public final tq_0 b() {
            a a2 = this;
            return a2.a(td_0.a(a2.a.length));
        }

        /* synthetic */ a(double[][] dArray, byte by) {
            this(dArray);
        }
    }
}

