/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.nQ;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tA;
import org.valkyrienskies.core.impl.shadow.tI;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.tz_0;

public final class sN {
    private static final double d = 1.0E-12;
    private byte e = (byte)30;
    private double[] f;
    private double[] g;
    private tI h;
    public double[] a;
    public double[] b;
    public sA[] c;
    private tq_0 i;
    private tq_0 j;
    private tq_0 k;
    private final boolean l;

    /*
     * Could not resolve type clashes
     */
    public sN(tq_0 object) {
        int n2;
        int n3;
        double d2;
        double d3;
        int n4;
        double d4 = (double)(10 * object.f() * object.g()) * cq_0.a;
        this.l = td_0.a((tq_0)object, d4);
        if (this.l) {
            Object object2 = object;
            object = this;
            this.h = new tI((tq_0)object2);
            tI tI2 = ((sN)object).h;
            ((sN)object).f = tI2.b;
            tI2 = ((sN)object).h;
            ((sN)object).g = tI2.c;
            sN sN2 = this;
            object = sN2.h;
            if (((tI)object).d == null) {
                object2 = object;
                if (((tI)object2).e == null) {
                    int n5 = ((tI)object2).a.length;
                    double[][] dArray = new double[n5][n5];
                    for (int i2 = n5 - 1; i2 > 0; --i2) {
                        int n6;
                        double[] dArray2 = ((tI)object2).a[i2 - 1];
                        dArray[i2][i2] = 1.0;
                        if (dArray2[i2] == 0.0) continue;
                        double d5 = 1.0 / (((tI)object2).c[i2 - 1] * dArray2[i2]);
                        double d6 = 1.0 / ((tI)object2).c[i2 - 1];
                        dArray[i2][i2] = 1.0 + d6 * dArray2[i2];
                        for (n6 = i2 + 1; n6 < n5; ++n6) {
                            dArray[i2][n6] = d6 * dArray2[n6];
                        }
                        for (n6 = i2 + 1; n6 < n5; ++n6) {
                            int n7;
                            d6 = 0.0;
                            for (n7 = i2 + 1; n7 < n5; ++n7) {
                                d6 += dArray[n6][n7] * dArray2[n7];
                            }
                            dArray[n6][i2] = (d6 *= d5) * dArray2[i2];
                            for (n7 = i2 + 1; n7 < n5; ++n7) {
                                double[] dArray3 = dArray[n6];
                                int n8 = n7;
                                dArray3[n8] = dArray3[n8] + d6 * dArray2[n7];
                            }
                        }
                    }
                    dArray[0][0] = 1.0;
                    ((tI)object2).e = td_0.a(dArray);
                }
                ((tI)object2).d = ((tI)object2).e.d();
            }
            sN2.a(((tI)object).d.a());
            return;
        }
        Object object3 = object;
        object = this;
        Object object4 = new tz_0((tq_0)object3);
        double[][] dArray = ((tz_0)object4).b().a();
        ((sN)object).a = new double[dArray.length];
        ((sN)object).b = new double[dArray.length];
        for (n4 = 0; n4 < ((sN)object).a.length; ++n4) {
            if (n4 == ((sN)object).a.length - 1 || cq_0.b(dArray[n4 + 1][n4], 0.0, 1.0E-12)) {
                ((sN)object).a[n4] = dArray[n4][n4];
                continue;
            }
            d3 = dArray[n4 + 1][n4 + 1];
            double d7 = 0.5 * (dArray[n4][n4] - d3);
            d2 = BY.a(BY.w(d7 * d7 + dArray[n4 + 1][n4] * dArray[n4][n4 + 1]));
            ((sN)object).a[n4] = d3 + d7;
            ((sN)object).b[n4] = d2;
            ((sN)object).a[n4 + 1] = d3 + d7;
            ((sN)object).b[n4 + 1] = -d2;
            ++n4;
        }
        object3 = object = object4;
        object = this;
        object4 = ((tz_0)object3).b().a();
        dArray = ((tz_0)object3).a().a();
        n4 = ((Object)object4).length;
        d3 = 0.0;
        for (int i3 = 0; i3 < n4; ++i3) {
            for (int i4 = BY.b(i3 - 1, 0); i4 < n4; ++i4) {
                d3 += BY.w((double)object4[i3][i4]);
            }
        }
        if (cq_0.b(d3, 0.0, 1.0E-12)) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        Object object5 = 0.0;
        d2 = 0.0;
        Object object6 = 0.0;
        for (n3 = n4 - 1; n3 >= 0; --n3) {
            nQ nQ2;
            Object object7;
            reference var29_45;
            reference var25_40;
            int n9;
            int n10;
            double d8 = ((sN)object).a[n3];
            double d9 = ((sN)object).b[n3];
            if (cq_0.a(d9, 0.0)) {
                n10 = n3;
                object4[n3][n3] = 1.0;
                for (n9 = n3 - 1; n9 >= 0; --n9) {
                    var25_40 = object4[n9][n9] - d8;
                    object5 = 0.0;
                    for (int i5 = n10; i5 <= n3; ++i5) {
                        object5 += object4[n9][i5] * object4[i5][n3];
                    }
                    if (cq_0.a(((sN)object).b[n9], 0.0, 1.0E-12) < 0) {
                        object6 = var25_40;
                        d2 = object5;
                        continue;
                    }
                    n10 = n9;
                    if (cq_0.a(((sN)object).b[n9], 0.0)) {
                        object4[n9][n3] = var25_40 != 0.0 ? (Object)(-object5 / var25_40) : (Object)(-object5 / (cq_0.a * d3));
                    } else {
                        Object object8 = object4[n9][n9 + 1];
                        var29_45 = object4[n9 + 1][n9];
                        d9 = (((sN)object).a[n9] - d8) * (((sN)object).a[n9] - d8) + ((sN)object).b[n9] * ((sN)object).b[n9];
                        object4[n9][n3] = object7 = (object8 * d2 - object6 * object5) / d9;
                        object4[n9 + 1][n3] = BY.w((double)object8) > BY.w(object6) ? (Object)((-object5 - var25_40 * object7) / object8) : (Object)((-d2 - var29_45 * object7) / object6);
                    }
                    double d10 = BY.w((double)object4[n9][n3]);
                    if (!(cq_0.a * d10 * d10 > 1.0)) continue;
                    for (int i6 = n9; i6 <= n3; ++i6) {
                        Object object9 = object4[i6];
                        int n11 = n3;
                        object9[n11] = object9[n11] / d10;
                    }
                }
                continue;
            }
            if (!(d9 < 0.0)) continue;
            n10 = n3 - 1;
            if (BY.w((double)object4[n3][n3 - 1]) > BY.w((double)object4[n3 - 1][n3])) {
                object4[n3 - 1][n3 - 1] = d9 / object4[n3][n3 - 1];
                object4[n3 - 1][n3] = -(object4[n3][n3] - d8) / object4[n3][n3 - 1];
            } else {
                nQ nQ3;
                nQ2 = nQ3 = sN.a(0.0, (double)(-object4[n3 - 1][n3]), (double)(object4[n3 - 1][n3 - 1] - d8), d9);
                object4[n3 - 1][n3 - 1] = nQ2.d;
                nQ2 = nQ3;
                object4[n3 - 1][n3] = nQ2.c;
            }
            object4[n3][n3 - 1] = 0.0;
            object4[n3][n3] = 1.0;
            for (n9 = n3 - 2; n9 >= 0; --n9) {
                var25_40 = (reference)0.0;
                double d11 = 0.0;
                for (int i7 = n10; i7 <= n3; ++i7) {
                    var25_40 += object4[n9][i7] * object4[i7][n3 - 1];
                    d11 += object4[n9][i7] * object4[i7][n3];
                }
                var29_45 = object4[n9][n9] - d8;
                if (cq_0.a(((sN)object).b[n9], 0.0, 1.0E-12) < 0) {
                    object6 = var29_45;
                    object5 = var25_40;
                    d2 = d11;
                    continue;
                }
                n10 = n9;
                if (cq_0.a(((sN)object).b[n9], 0.0)) {
                    nQ nQ4;
                    nQ2 = nQ4 = sN.a((double)(-var25_40), -d11, (double)var29_45, d9);
                    object4[n9][n3 - 1] = nQ2.d;
                    nQ2 = nQ4;
                    object4[n9][n3] = nQ2.c;
                } else {
                    nQ nQ5;
                    object7 = object4[n9][n9 + 1];
                    Object object10 = object4[n9 + 1][n9];
                    double d12 = d9;
                    double d13 = (((sN)object).a[n9] - d8) * (((sN)object).a[n9] - d8) + ((sN)object).b[n9] * ((sN)object).b[n9] - d12 * d12;
                    double d14 = (((sN)object).a[n9] - d8) * 2.0 * d9;
                    if (cq_0.a(d13, 0.0) && cq_0.a(d14, 0.0)) {
                        d13 = cq_0.a * d3 * (BY.w((double)var29_45) + BY.w(d9) + BY.w((double)object7) + BY.w((double)object10) + BY.w(object6));
                    }
                    nQ2 = nQ5 = sN.a((double)(object7 * object5 - object6 * var25_40 + d9 * d11), (double)(object7 * d2 - object6 * d11 - d9 * var25_40), d13, d14);
                    object4[n9][n3 - 1] = nQ2.d;
                    nQ2 = nQ5;
                    object4[n9][n3] = nQ2.c;
                    if (BY.w((double)object7) > BY.w(object6) + BY.w(d9)) {
                        object4[n9 + 1][n3 - 1] = (-var25_40 - var29_45 * object4[n9][n3 - 1] + d9 * object4[n9][n3]) / object7;
                        object4[n9 + 1][n3] = (-d11 - var29_45 * object4[n9][n3] - d9 * object4[n9][n3 - 1]) / object7;
                    } else {
                        nQ2 = nQ5 = sN.a(-object5 - object10 * object4[n9][n3 - 1], -d2 - object10 * object4[n9][n3], object6, d9);
                        object4[n9 + 1][n3 - 1] = nQ2.d;
                        nQ2 = nQ5;
                        object4[n9 + 1][n3] = nQ2.c;
                    }
                }
                object7 = BY.e(BY.w((double)object4[n9][n3 - 1]), BY.w((double)object4[n9][n3]));
                if (!(cq_0.a * object7 * object7 > 1.0)) continue;
                for (int i8 = n9; i8 <= n3; ++i8) {
                    Object object11 = object4[i8];
                    int n12 = n3 - 1;
                    object11[n12] = object11[n12] / object7;
                    Object object12 = object4[i8];
                    int n13 = n3;
                    object12[n13] = object12[n13] / object7;
                }
            }
        }
        for (n3 = n4 - 1; n3 >= 0; --n3) {
            for (int i9 = 0; i9 <= n4 - 1; ++i9) {
                object6 = 0.0;
                for (n2 = 0; n2 <= BY.a(n3, n4 - 1); ++n2) {
                    object6 += dArray[i9][n2] * object4[n2][n3];
                }
                dArray[i9][n3] = object6;
            }
        }
        ((sN)object).c = new sA[n4];
        double[] dArray4 = new double[n4];
        for (int i10 = 0; i10 < n4; ++i10) {
            for (n2 = 0; n2 < n4; ++n2) {
                dArray4[n2] = dArray[n2][i10];
            }
            ((sN)object).c[i10] = new sA(dArray4);
        }
    }

    @Deprecated
    private sN(tq_0 tq_02, byte by) {
        this(tq_02);
    }

    private sN(double[] dArray, double[] object) {
        this.l = true;
        this.f = (double[])dArray.clone();
        this.g = (double[])object.clone();
        this.h = null;
        int n2 = dArray.length;
        object = new double[n2][n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            object[i2][i2] = 1.0;
        }
        this.a((double[][])object);
    }

    @Deprecated
    private sN(double[] dArray, double[] dArray2, byte by) {
        this(dArray, dArray2);
    }

    public final tq_0 a() {
        if (this.i == null) {
            int n2;
            int n3 = n2 = this.c.length;
            this.i = td_0.a(n3, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.i.b(i2, (tu_0)((Object)this.c[i2]));
            }
        }
        return this.i;
    }

    public final tq_0 b() {
        if (this.j == null) {
            this.j = td_0.a(this.a);
            for (int i2 = 0; i2 < this.b.length; ++i2) {
                if (cq_0.a(this.b[i2], 0.0, 1.0E-12) > 0) {
                    int n2 = i2;
                    this.j.c(n2, n2 + 1, this.b[i2]);
                    continue;
                }
                if (cq_0.a(this.b[i2], 0.0, 1.0E-12) >= 0) continue;
                int n3 = i2;
                this.j.c(n3, n3 - 1, this.b[i2]);
            }
        }
        return this.j;
    }

    private tq_0 g() {
        if (this.k == null) {
            int n2;
            int n3 = n2 = this.c.length;
            this.k = td_0.a(n3, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.k.a(i2, (tu_0)((Object)this.c[i2]));
            }
        }
        return this.k;
    }

    private boolean h() {
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (cq_0.b(this.b[i2], 0.0, 1.0E-12)) continue;
            return true;
        }
        return false;
    }

    public final double[] c() {
        return (double[])this.a.clone();
    }

    private double b(int n2) {
        return this.a[n2];
    }

    private double[] i() {
        return (double[])this.b.clone();
    }

    private double c(int n2) {
        return this.b[n2];
    }

    public final sA a(int n2) {
        return this.c[n2].a();
    }

    public final double d() {
        double d2 = 1.0;
        double[] dArray = this.a;
        int n2 = this.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d3 = dArray[i2];
            d2 *= d3;
        }
        return d2;
    }

    public final tq_0 e() {
        if (!this.l) {
            throw new pb_0();
        }
        double[] dArray = new double[this.a.length];
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            double d2;
            double d3 = this.a[i2];
            if (d2 <= 0.0) {
                throw new pb_0();
            }
            dArray[i2] = BY.a(d3);
        }
        tq_0 tq_02 = td_0.a(dArray);
        tq_0 tq_03 = this.a();
        tq_0 tq_04 = this.g();
        return tq_03.c(tq_02).c(tq_04);
    }

    public final a f() {
        if (this.h()) {
            throw new pb_0();
        }
        return new a(this.a, this.b, this.c, 0);
    }

    private void a(tq_0 object) {
        this.h = new tI((tq_0)object);
        object = this.h;
        this.f = ((tI)object).b;
        object = this.h;
        this.g = ((tI)object).c;
    }

    private void a(double[][] dArray) {
        int n2;
        dArray = (double[][])dArray.clone();
        int n3 = this.f.length;
        this.a = new double[n3];
        this.b = new double[n3];
        double[] dArray2 = new double[n3];
        for (int i2 = 0; i2 < n3 - 1; ++i2) {
            this.a[i2] = this.f[i2];
            dArray2[i2] = this.g[i2];
        }
        this.a[n3 - 1] = this.f[n3 - 1];
        dArray2[n3 - 1] = 0.0;
        double d2 = 0.0;
        for (n2 = 0; n2 < n3; ++n2) {
            if (BY.w(this.a[n2]) > d2) {
                d2 = BY.w(this.a[n2]);
            }
            if (!(BY.w(dArray2[n2]) > d2)) continue;
            d2 = BY.w(dArray2[n2]);
        }
        if (d2 != 0.0) {
            for (n2 = 0; n2 < n3; ++n2) {
                if (BY.w(this.a[n2]) <= cq_0.a * d2) {
                    this.a[n2] = 0.0;
                }
                if (!(BY.w(dArray2[n2]) <= cq_0.a * d2)) continue;
                dArray2[n2] = 0.0;
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            int n4;
            int n5 = 0;
            do {
                int n6;
                double d3;
                for (n4 = n2; n4 < n3 - 1; ++n4) {
                    d3 = BY.w(this.a[n4]) + BY.w(this.a[n4 + 1]);
                    if (BY.w(dArray2[n4]) + d3 == d3) break;
                }
                if (n4 == n2) continue;
                if (n5 == this.e) {
                    throw new pc_0(px_0.CONVERGENCE_FAILED, this.e, new Object[0]);
                }
                ++n5;
                double d4 = d3 = (this.a[n2 + 1] - this.a[n2]) / (2.0 * dArray2[n2]);
                double d5 = BY.a(1.0 + d4 * d4);
                d3 = d3 < 0.0 ? this.a[n4] - this.a[n2] + dArray2[n2] / (d3 - d5) : this.a[n4] - this.a[n2] + dArray2[n2] / (d3 + d5);
                double d6 = 0.0;
                double d7 = 1.0;
                double d8 = 1.0;
                for (n6 = n4 - 1; n6 >= n2; --n6) {
                    double d9 = d7 * dArray2[n6];
                    double d10 = d8 * dArray2[n6];
                    if (BY.w(d9) >= BY.w(d3)) {
                        d8 = d3 / d9;
                        d5 = BY.a(d8 * d8 + 1.0);
                        dArray2[n6 + 1] = d9 * d5;
                        d7 = 1.0 / d5;
                        d8 *= d7;
                    } else {
                        d7 = d9 / d3;
                        d5 = BY.a(d7 * d7 + 1.0);
                        dArray2[n6 + 1] = d3 * d5;
                        d8 = 1.0 / d5;
                        d7 *= d8;
                    }
                    if (dArray2[n6 + 1] == 0.0) {
                        int n7 = n6 + 1;
                        this.a[n7] = this.a[n7] - d6;
                        dArray2[n4] = 0.0;
                        break;
                    }
                    d3 = this.a[n6 + 1] - d6;
                    d5 = (this.a[n6] - d3) * d7 + d8 * 2.0 * d10;
                    d6 = d7 * d5;
                    this.a[n6 + 1] = d3 + d6;
                    d3 = d8 * d5 - d10;
                    for (int i3 = 0; i3 < n3; ++i3) {
                        d9 = dArray[i3][n6 + 1];
                        dArray[i3][n6 + 1] = d7 * dArray[i3][n6] + d8 * d9;
                        dArray[i3][n6] = d8 * dArray[i3][n6] - d7 * d9;
                    }
                }
                if (d5 == 0.0 && n6 >= n2) continue;
                int n8 = n2;
                this.a[n8] = this.a[n8] - d6;
                dArray2[n2] = d3;
                dArray2[n4] = 0.0;
            } while (n4 != n2);
        }
        for (n2 = 0; n2 < n3; ++n2) {
            int n9;
            int n10 = n2;
            double d11 = this.a[n2];
            for (n9 = n2 + 1; n9 < n3; ++n9) {
                if (!(this.a[n9] > d11)) continue;
                n10 = n9;
                d11 = this.a[n9];
            }
            if (n10 == n2) continue;
            this.a[n10] = this.a[n2];
            this.a[n2] = d11;
            for (n9 = 0; n9 < n3; ++n9) {
                d11 = dArray[n9][n2];
                dArray[n9][n2] = dArray[n9][n10];
                dArray[n9][n10] = d11;
            }
        }
        double d12 = 0.0;
        for (n2 = 0; n2 < n3; ++n2) {
            if (!(BY.w(this.a[n2]) > d12)) continue;
            d12 = BY.w(this.a[n2]);
        }
        if (d12 != 0.0) {
            for (n2 = 0; n2 < n3; ++n2) {
                if (!(BY.w(this.a[n2]) < cq_0.a * d12)) continue;
                this.a[n2] = 0.0;
            }
        }
        this.c = new sA[n3];
        double[] dArray3 = new double[n3];
        for (int i4 = 0; i4 < n3; ++i4) {
            for (int i5 = 0; i5 < n3; ++i5) {
                dArray3[i5] = dArray[i5][i4];
            }
            this.c[i4] = new sA(dArray3);
        }
    }

    private tz_0 b(tq_0 object) {
        object = new tz_0((tq_0)object);
        double[][] dArray = ((tz_0)object).b().a();
        this.a = new double[dArray.length];
        this.b = new double[dArray.length];
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (i2 == this.a.length - 1 || cq_0.b(dArray[i2 + 1][i2], 0.0, 1.0E-12)) {
                this.a[i2] = dArray[i2][i2];
                continue;
            }
            double d2 = dArray[i2 + 1][i2 + 1];
            double d3 = 0.5 * (dArray[i2][i2] - d2);
            double d4 = BY.a(BY.w(d3 * d3 + dArray[i2 + 1][i2] * dArray[i2][i2 + 1]));
            this.a[i2] = d2 + d3;
            this.b[i2] = d4;
            this.a[i2 + 1] = d2 + d3;
            this.b[i2 + 1] = -d4;
            ++i2;
        }
        return object;
    }

    private static nQ a(double d2, double d3, double d4, double d5) {
        return new nQ(d2, d3).b(new nQ(d4, d5));
    }

    private void a(tz_0 object) {
        int n2;
        int n3;
        double[][] dArray = ((tz_0)object).b().a();
        object = ((tz_0)object).a().a();
        int n4 = dArray.length;
        double d2 = 0.0;
        for (int i2 = 0; i2 < n4; ++i2) {
            for (int i3 = BY.b(i2 - 1, 0); i3 < n4; ++i3) {
                d2 += BY.w(dArray[i2][i3]);
            }
        }
        if (cq_0.b(d2, 0.0, 1.0E-12)) {
            throw new oU(px_0.ZERO_NORM, new Object[0]);
        }
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        for (n3 = n4 - 1; n3 >= 0; --n3) {
            nQ nQ2;
            double d6;
            double d7;
            double d8;
            int n5;
            int n6;
            double d9 = this.a[n3];
            double d10 = this.b[n3];
            if (cq_0.a(d10, 0.0)) {
                n6 = n3;
                dArray[n3][n3] = 1.0;
                for (n5 = n3 - 1; n5 >= 0; --n5) {
                    d8 = dArray[n5][n5] - d9;
                    d3 = 0.0;
                    for (int i4 = n6; i4 <= n3; ++i4) {
                        d3 += dArray[n5][i4] * dArray[i4][n3];
                    }
                    if (cq_0.a(this.b[n5], 0.0, 1.0E-12) < 0) {
                        d5 = d8;
                        d4 = d3;
                        continue;
                    }
                    n6 = n5;
                    if (cq_0.a(this.b[n5], 0.0)) {
                        dArray[n5][n3] = d8 != 0.0 ? -d3 / d8 : -d3 / (cq_0.a * d2);
                    } else {
                        double d11 = dArray[n5][n5 + 1];
                        d7 = dArray[n5 + 1][n5];
                        d10 = (this.a[n5] - d9) * (this.a[n5] - d9) + this.b[n5] * this.b[n5];
                        dArray[n5][n3] = d6 = (d11 * d4 - d5 * d3) / d10;
                        dArray[n5 + 1][n3] = BY.w(d11) > BY.w(d5) ? (-d3 - d8 * d6) / d11 : (-d4 - d7 * d6) / d5;
                    }
                    double d12 = BY.w(dArray[n5][n3]);
                    if (!(cq_0.a * d12 * d12 > 1.0)) continue;
                    for (int i5 = n5; i5 <= n3; ++i5) {
                        double[] dArray2 = dArray[i5];
                        int n7 = n3;
                        dArray2[n7] = dArray2[n7] / d12;
                    }
                }
                continue;
            }
            if (!(d10 < 0.0)) continue;
            n6 = n3 - 1;
            if (BY.w(dArray[n3][n3 - 1]) > BY.w(dArray[n3 - 1][n3])) {
                dArray[n3 - 1][n3 - 1] = d10 / dArray[n3][n3 - 1];
                dArray[n3 - 1][n3] = -(dArray[n3][n3] - d9) / dArray[n3][n3 - 1];
            } else {
                nQ nQ3;
                nQ2 = nQ3 = sN.a(0.0, -dArray[n3 - 1][n3], dArray[n3 - 1][n3 - 1] - d9, d10);
                dArray[n3 - 1][n3 - 1] = nQ2.d;
                nQ2 = nQ3;
                dArray[n3 - 1][n3] = nQ2.c;
            }
            dArray[n3][n3 - 1] = 0.0;
            dArray[n3][n3] = 1.0;
            for (n5 = n3 - 2; n5 >= 0; --n5) {
                d8 = 0.0;
                double d13 = 0.0;
                for (int i6 = n6; i6 <= n3; ++i6) {
                    d8 += dArray[n5][i6] * dArray[i6][n3 - 1];
                    d13 += dArray[n5][i6] * dArray[i6][n3];
                }
                d7 = dArray[n5][n5] - d9;
                if (cq_0.a(this.b[n5], 0.0, 1.0E-12) < 0) {
                    d5 = d7;
                    d3 = d8;
                    d4 = d13;
                    continue;
                }
                n6 = n5;
                if (cq_0.a(this.b[n5], 0.0)) {
                    nQ nQ4;
                    nQ2 = nQ4 = sN.a(-d8, -d13, d7, d10);
                    dArray[n5][n3 - 1] = nQ2.d;
                    nQ2 = nQ4;
                    dArray[n5][n3] = nQ2.c;
                } else {
                    nQ nQ5;
                    d6 = dArray[n5][n5 + 1];
                    double d14 = dArray[n5 + 1][n5];
                    double d15 = d10;
                    double d16 = (this.a[n5] - d9) * (this.a[n5] - d9) + this.b[n5] * this.b[n5] - d15 * d15;
                    double d17 = (this.a[n5] - d9) * 2.0 * d10;
                    if (cq_0.a(d16, 0.0) && cq_0.a(d17, 0.0)) {
                        d16 = cq_0.a * d2 * (BY.w(d7) + BY.w(d10) + BY.w(d6) + BY.w(d14) + BY.w(d5));
                    }
                    nQ2 = nQ5 = sN.a(d6 * d3 - d5 * d8 + d10 * d13, d6 * d4 - d5 * d13 - d10 * d8, d16, d17);
                    dArray[n5][n3 - 1] = nQ2.d;
                    nQ2 = nQ5;
                    dArray[n5][n3] = nQ2.c;
                    if (BY.w(d6) > BY.w(d5) + BY.w(d10)) {
                        dArray[n5 + 1][n3 - 1] = (-d8 - d7 * dArray[n5][n3 - 1] + d10 * dArray[n5][n3]) / d6;
                        dArray[n5 + 1][n3] = (-d13 - d7 * dArray[n5][n3] - d10 * dArray[n5][n3 - 1]) / d6;
                    } else {
                        nQ2 = nQ5 = sN.a(-d3 - d14 * dArray[n5][n3 - 1], -d4 - d14 * dArray[n5][n3], d5, d10);
                        dArray[n5 + 1][n3 - 1] = nQ2.d;
                        nQ2 = nQ5;
                        dArray[n5 + 1][n3] = nQ2.c;
                    }
                }
                d6 = BY.e(BY.w(dArray[n5][n3 - 1]), BY.w(dArray[n5][n3]));
                if (!(cq_0.a * d6 * d6 > 1.0)) continue;
                for (int i7 = n5; i7 <= n3; ++i7) {
                    double[] dArray3 = dArray[i7];
                    int n8 = n3 - 1;
                    dArray3[n8] = dArray3[n8] / d6;
                    double[] dArray4 = dArray[i7];
                    int n9 = n3;
                    dArray4[n9] = dArray4[n9] / d6;
                }
            }
        }
        for (n3 = n4 - 1; n3 >= 0; --n3) {
            for (int i8 = 0; i8 <= n4 - 1; ++i8) {
                d5 = 0.0;
                for (n2 = 0; n2 <= BY.a(n3, n4 - 1); ++n2) {
                    d5 += object[i8][n2] * dArray[n2][n3];
                }
                object[i8][n3] = d5;
            }
        }
        this.c = new sA[n4];
        double[] dArray5 = new double[n4];
        for (int i9 = 0; i9 < n4; ++i9) {
            for (n2 = 0; n2 < n4; ++n2) {
                dArray5[n2] = (double)object[n2][i9];
            }
            this.c[i9] = new sA(dArray5);
        }
    }

    static final class 1 {
    }

    public static final class a
    implements sG {
        private double[] a;
        private double[] b;
        private final sA[] c;

        private a(double[] dArray, double[] dArray2, sA[] sAArray) {
            this.a = dArray;
            this.b = dArray2;
            this.c = sAArray;
        }

        public final tu_0 a(tu_0 tu_02) {
            if (!this.a()) {
                throw new tA();
            }
            int n2 = this.a.length;
            if (tu_02.f() != n2) {
                throw new oS(tu_02.f(), n2);
            }
            double[] dArray = new double[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                sA sA2 = this.c[i2];
                Object object = sA2;
                object = sA2.a;
                double d2 = ((tu_0)((Object)sA2)).b(tu_02) / this.a[i2];
                for (int i3 = 0; i3 < n2; ++i3) {
                    int n3 = i3;
                    dArray[n3] = dArray[n3] + d2 * object[i3];
                }
            }
            return new sA(dArray, false);
        }

        public final tq_0 a(tq_0 tq_02) {
            if (!this.a()) {
                throw new tA();
            }
            int n2 = this.a.length;
            if (tq_02.f() != n2) {
                throw new oS(tq_02.f(), n2);
            }
            int n3 = tq_02.g();
            double[][] dArray = new double[n2][n3];
            double[] dArray2 = new double[n2];
            for (int i2 = 0; i2 < n3; ++i2) {
                int n4;
                for (n4 = 0; n4 < n2; ++n4) {
                    dArray2[n4] = tq_02.b(n4, i2);
                    dArray[n4][i2] = 0.0;
                }
                for (n4 = 0; n4 < n2; ++n4) {
                    int n5;
                    sA sA2 = this.c[n4];
                    Object object = sA2;
                    object = sA2.a;
                    double d2 = 0.0;
                    for (n5 = 0; n5 < n2; ++n5) {
                        d2 += ((tu_0)((Object)sA2)).a(n5) * dArray2[n5];
                    }
                    d2 /= this.a[n4];
                    for (n5 = 0; n5 < n2; ++n5) {
                        double[] dArray3 = dArray[n5];
                        int n6 = i2;
                        dArray3[n6] = dArray3[n6] + d2 * object[n5];
                    }
                }
            }
            return new sy_0(dArray, false);
        }

        public final boolean a() {
            int n2;
            double d2 = 0.0;
            for (n2 = 0; n2 < this.a.length; ++n2) {
                d2 = BY.e(d2, this.a(n2));
            }
            if (d2 == 0.0) {
                return false;
            }
            for (n2 = 0; n2 < this.a.length; ++n2) {
                if (!cq_0.b(this.a(n2) / d2, 0.0, 1.0E-12)) continue;
                return false;
            }
            return true;
        }

        private double a(int n2) {
            double d2 = this.a[n2];
            double d3 = this.b[n2];
            double d4 = d2;
            double d5 = d3;
            return BY.a(d4 * d4 + d5 * d5);
        }

        public final tq_0 b() {
            if (!this.a()) {
                throw new tA();
            }
            int n2 = this.a.length;
            double[][] dArray = new double[n2][n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                double[] dArray2 = dArray[i2];
                for (int i3 = 0; i3 < n2; ++i3) {
                    double d2 = 0.0;
                    for (int i4 = 0; i4 < n2; ++i4) {
                        Object object = this.c[i4];
                        object = ((sA)object).a;
                        d2 += object[i2] * object[i3] / this.a[i4];
                    }
                    dArray2[i3] = d2;
                }
            }
            return td_0.a(dArray);
        }

        public /* synthetic */ a(double[] dArray, double[] dArray2, sA[] sAArray, byte by) {
            this(dArray, dArray2, sAArray);
        }
    }
}

