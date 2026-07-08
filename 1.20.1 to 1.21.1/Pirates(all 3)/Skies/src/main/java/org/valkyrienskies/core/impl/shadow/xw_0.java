/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.xw
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.sN;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.xi_0;
import org.valkyrienskies.core.impl.shadow.xp_0;
import org.valkyrienskies.core.impl.shadow.xw;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xw
 */
public final class xw_0
extends xp_0 {
    private int c;
    private final boolean d;
    private final int e;
    private double[] f;
    private int g;
    private int h;
    boolean b = true;
    private final boolean i;
    private final int j;
    private final double k;
    private double l;
    private double m;
    private double n;
    private double o;
    private int p;
    private double q;
    private tq_0 r;
    private double s;
    private double t;
    private double u;
    private double v;
    private double w;
    private double x;
    private double y;
    private double z;
    private double A;
    private double B;
    private tq_0 C;
    private tq_0 D;
    private tq_0 E;
    private double F;
    private tq_0 G;
    private tq_0 H;
    private tq_0 I;
    private tq_0 J;
    private tq_0 K;
    private tq_0 L;
    private int M;
    private double[] N;
    private int O;
    private final zF P;
    private final List<Double> Q = new ArrayList<Double>();
    private final List<tq_0> R = new ArrayList<tq_0>();
    private final List<Double> S = new ArrayList<Double>();
    private final List<tq_0> T = new ArrayList<tq_0>();

    private xw_0(int n2, double d2, boolean bl, int n3, int n4, zF zF2, boolean bl2, wK<wQ> wK2) {
        super(wK2);
        this.j = n2;
        this.k = d2;
        this.d = bl;
        this.h = n3;
        this.e = n4;
        this.P = zF2;
        this.i = bl2;
    }

    private List<Double> b() {
        return this.Q;
    }

    private List<tq_0> d() {
        return this.R;
    }

    private List<Double> m() {
        return this.S;
    }

    private List<tq_0> o() {
        return this.T;
    }

    @Override
    public final wQ c(wO ... wOArray) {
        return super.c(wOArray);
    }

    private wQ p() {
        int n2;
        int n3;
        this.b = this.n().equals(xi_0.MINIMIZE);
        b b2 = new b();
        Object object = this.e();
        this.g = ((double[])object).length;
        double[] dArray = object;
        Object object2 = this;
        if (((xw_0)object2).c <= 0) {
            throw new pk_0(((xw_0)object2).c);
        }
        Object object3 = new double[dArray.length][1];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            object3[i2][0] = ((xw_0)object2).f[i2];
        }
        sy_0 sy_02 = new sy_0((double[][])object3, false);
        ((xw_0)object2).t = xw_0.f(sy_02);
        ((xw_0)object2).l = 1000.0 * xw_0.f(sy_02);
        ((xw_0)object2).m = 1.0E-11 * xw_0.f(sy_02);
        ((xw_0)object2).n = 1.0E-12;
        ((xw_0)object2).o = 1.0E-13;
        ((xw_0)object2).p = ((xw_0)object2).c / 2;
        ((xw_0)object2).q = BY.k((double)((xw_0)object2).p + 0.5);
        double d2 = 1.0;
        double d3 = ((xw_0)object2).p;
        double d4 = 1.0;
        int n4 = (int)(d3 - 1.0 + 1.0);
        Object object4 = new double[n4][1];
        double d5 = 1.0;
        for (n3 = 0; n3 < n4; ++n3) {
            object4[n3][0] = d5;
            d5 += 1.0;
        }
        sy_0 sy_03 = new sy_0((double[][])object4, false);
        double[][] dArray2 = new double[sy_03.f()][sy_03.g()];
        for (int i3 = 0; i3 < sy_03.f(); ++i3) {
            for (int i4 = 0; i4 < sy_03.g(); ++i4) {
                dArray2[i3][i4] = BY.k(sy_03.b(i3, i4));
            }
        }
        ((xw_0)object2).r = new sy_0(dArray2, false).b(-1.0).a(((xw_0)object2).q);
        double d6 = 0.0;
        double d7 = 0.0;
        for (n2 = 0; n2 < ((xw_0)object2).p; ++n2) {
            double d8 = ((xw_0)object2).r.b(n2, 0);
            d6 += d8;
            double d9 = d8;
            d7 += d9 * d9;
        }
        ((xw_0)object2).r = ((xw_0)object2).r.b(1.0 / d6);
        double d10 = d6;
        ((xw_0)object2).s = d10 * d10 / d7;
        ((xw_0)object2).u = (4.0 + ((xw_0)object2).s / (double)((xw_0)object2).g) / ((double)(((xw_0)object2).g + 4) + 2.0 * ((xw_0)object2).s / (double)((xw_0)object2).g);
        ((xw_0)object2).v = (((xw_0)object2).s + 2.0) / ((double)((xw_0)object2).g + ((xw_0)object2).s + 3.0);
        ((xw_0)object2).w = (1.0 + 2.0 * BY.e(0.0, BY.a((((xw_0)object2).s - 1.0) / (double)(((xw_0)object2).g + 1)) - 1.0)) * BY.e(0.3, 1.0 - (double)((xw_0)object2).g / (1.0E-6 + (double)((xw_0)object2).j)) + ((xw_0)object2).v;
        ((xw_0)object2).x = 2.0 / (((double)((xw_0)object2).g + 1.3) * ((double)((xw_0)object2).g + 1.3) + ((xw_0)object2).s);
        ((xw_0)object2).y = BY.d(1.0 - ((xw_0)object2).x, 2.0 * (((xw_0)object2).s - 2.0 + 1.0 / ((xw_0)object2).s) / ((double)((((xw_0)object2).g + 2) * (((xw_0)object2).g + 2)) + ((xw_0)object2).s));
        ((xw_0)object2).A = BY.d(1.0, ((xw_0)object2).x * ((double)((xw_0)object2).g + 1.5) / 3.0);
        ((xw_0)object2).B = BY.d(1.0 - ((xw_0)object2).x, ((xw_0)object2).y * ((double)((xw_0)object2).g + 1.5) / 3.0);
        ((xw_0)object2).z = BY.a((double)((xw_0)object2).g) * (1.0 - 1.0 / (4.0 * (double)((xw_0)object2).g) + 1.0 / (21.0 * (double)((xw_0)object2).g * (double)((xw_0)object2).g));
        ((xw_0)object2).C = td_0.c(dArray);
        ((xw_0)object2).J = sy_02.b(1.0 / ((xw_0)object2).t);
        ((xw_0)object2).L = xw_0.c(((xw_0)object2).J);
        ((xw_0)object2).D = xw_0.c(((xw_0)object2).g, 1);
        ((xw_0)object2).E = xw_0.c(((xw_0)object2).g, 1);
        ((xw_0)object2).F = ((xw_0)object2).E.c();
        ((xw_0)object2).G = xw_0.b(((xw_0)object2).g, ((xw_0)object2).g);
        ((xw_0)object2).H = xw_0.a(((xw_0)object2).g, 1);
        ((xw_0)object2).I = xw_0.b(((xw_0)object2).G, xw_0.a(((xw_0)object2).J.d(), ((xw_0)object2).g, 1));
        ((xw_0)object2).K = ((xw_0)object2).G.c(xw_0.e(xw_0.c(((xw_0)object2).H)).c(((xw_0)object2).G.d()));
        ((xw_0)object2).O = 10 + (int)((double)(30 * ((xw_0)object2).g) / (double)((xw_0)object2).c);
        ((xw_0)object2).N = new double[((xw_0)object2).O];
        for (n2 = 0; n2 < ((xw_0)object2).O; ++n2) {
            ((xw_0)object2).N[n2] = Double.MAX_VALUE;
        }
        this.M = 0;
        e e2 = b2.a((double[])object);
        object = e2;
        Object object5 = e2;
        object5 = object;
        double d11 = e2.a + object.b;
        xw_0.a(this.N, d11);
        object = new wQ(this.e(), this.b ? d11 : -d11);
        Object object6 = null;
        this.M = 1;
        block8: while (this.M <= this.j) {
            int n5;
            int n6;
            boolean bl;
            Object object7;
            int n7;
            int n8;
            this.l();
            xw_0 xw_02 = this;
            int n9 = this.c;
            int n10 = xw_02.g;
            object2 = xw_02;
            double[][] dArray3 = new double[n10][n9];
            for (n8 = 0; n8 < n10; ++n8) {
                for (int i5 = 0; i5 < n9; ++i5) {
                    dArray3[n8][i5] = ((xw_0)object2).P.nextGaussian();
                }
            }
            Object object8 = new sy_0(dArray3, false);
            sy_0 sy_04 = xw_0.c(this.g, this.c);
            double[] dArray4 = new double[this.c];
            object4 = new e[this.c];
            for (n3 = 0; n3 < this.c; ++n3) {
                tq_0 tq_02 = null;
                for (n7 = 0; n7 < this.e + 1; ++n7) {
                    boolean bl2;
                    double[] dArray5;
                    block48: {
                        tq_02 = this.h <= 0 ? this.C.a(this.I.c(object8.c(n3)).b(this.t)) : this.C.a(xw_0.b(this.J, object8.c(n3)).b(this.t));
                        if (n7 >= this.e) break;
                        double[] dArray6 = tq_02.g(0);
                        object2 = b2;
                        dArray5 = ((b)object2).xw_0.this.f();
                        double[] dArray7 = ((b)object2).xw_0.this.g();
                        for (n8 = 0; n8 < dArray6.length; ++n8) {
                            if (dArray6[n8] < dArray5[n8]) {
                                bl2 = false;
                            } else {
                                if (!(dArray6[n8] > dArray7[n8])) continue;
                                bl2 = false;
                            }
                            break block48;
                        }
                        bl2 = true;
                    }
                    if (bl2) break;
                    xw_0 xw_03 = this;
                    n10 = xw_03.g;
                    object2 = xw_03;
                    dArray5 = new double[n10];
                    for (int i6 = 0; i6 < n10; ++i6) {
                        dArray5[i6] = ((xw_0)object2).P.nextGaussian();
                    }
                    object8.b(n3, dArray5);
                }
                int n11 = n3;
                sy_0 sy_05 = sy_04;
                n10 = 0;
                object2 = tq_02;
                for (n8 = 0; n8 < object2.f(); ++n8) {
                    sy_05.c(n8, n11, object2.b(n8, 0));
                }
                try {
                    object4[n3] = (double[])b2.a(sy_04.g(n3));
                    continue;
                }
                catch (pp_0 pp_02) {
                    break block8;
                }
            }
            object2 = object4;
            double d12 = Double.NEGATIVE_INFINITY;
            double d13 = Double.MAX_VALUE;
            Object object9 = object2;
            int n12 = ((Object)object9).length;
            for (n2 = 0; n2 < n12; ++n2) {
                Object object10;
                Object object11;
                object5 = object7 = object9[n2];
                if (((e)object11).a > d12) {
                    object5 = object7;
                    d12 = ((e)object5).a;
                }
                object5 = object7;
                if (!(((e)object10).a < d13)) continue;
                object5 = object7;
                d13 = ((e)object5).a;
            }
            double d14 = d12 - d13;
            for (n7 = 0; n7 < ((double[][])object4).length; ++n7) {
                double[] dArray8 = object4[n7];
                object5 = dArray8;
                double[] dArray9 = object4[n7];
                object5 = dArray9;
                dArray4[n7] = dArray8.a + dArray9.b * d14;
            }
            int[] nArray = xw_0.c(dArray4);
            object4 = this.C;
            sy_04 = xw_0.a((tq_0)sy_04, ch_0.a(nArray, this.p));
            this.C = sy_04.c(this.r);
            tq_0 tq_03 = xw_0.a((tq_0)object8, ch_0.a(nArray, this.p));
            tq_0 tq_04 = tq_03.c(this.r);
            object3 = object4;
            tq_0 tq_05 = tq_04;
            object2 = this;
            this.E = ((xw_0)object2).E.b(1.0 - ((xw_0)object2).v).a(((xw_0)object2).G.c(tq_05).b(BY.a(((xw_0)object2).v * (2.0 - ((xw_0)object2).v) * ((xw_0)object2).s)));
            ((xw_0)object2).F = ((xw_0)object2).E.c();
            boolean bl3 = ((xw_0)object2).F / BY.a(1.0 - BY.a(1.0 - ((xw_0)object2).v, 2 * ((xw_0)object2).M)) / ((xw_0)object2).z < 1.4 + 2.0 / ((double)((xw_0)object2).g + 1.0);
            ((xw_0)object2).D = ((xw_0)object2).D.b(1.0 - ((xw_0)object2).u);
            if (bl3) {
                ((xw_0)object2).D = ((xw_0)object2).D.a(((xw_0)object2).C.b((tq_0)object3).b(BY.a(((xw_0)object2).u * (2.0 - ((xw_0)object2).u) * ((xw_0)object2).s) / ((xw_0)object2).t));
            }
            boolean bl4 = bl3;
            if (this.h <= 0) {
                Object object12;
                int n13;
                Object object13 = object4;
                int[] nArray2 = nArray;
                sy_0 sy_06 = object8;
                object3 = sy_04;
                bl = bl4;
                object2 = this;
                double d15 = 0.0;
                if (((xw_0)object2).x + ((xw_0)object2).y > 0.0) {
                    tq_03 = object3.b(xw_0.a((tq_0)object13, 1, ((xw_0)object2).p)).b(1.0 / ((xw_0)object2).t);
                    object7 = ((xw_0)object2).D.c(((xw_0)object2).D.d()).b(((xw_0)object2).x);
                    double d16 = bl ? 0.0 : ((xw_0)object2).x * ((xw_0)object2).u * (2.0 - ((xw_0)object2).u);
                    d16 = d16 + (1.0 - ((xw_0)object2).x - ((xw_0)object2).y);
                    if (((xw_0)object2).d) {
                        int n14;
                        d15 = (1.0 - ((xw_0)object2).y) * 0.25 * ((xw_0)object2).s / (BY.a((double)(((xw_0)object2).g + 2), 1.5) + 2.0 * ((xw_0)object2).s);
                        int[] nArray3 = xw_0.b(nArray2);
                        object8 = xw_0.a((tq_0)sy_06, ch_0.a(nArray3, ((xw_0)object2).p));
                        Object object14 = xw_0.c((tq_0)object8);
                        Object object15 = new double[1][object14.g()];
                        for (n14 = 0; n14 < object14.g(); ++n14) {
                            double d17 = 0.0;
                            for (int i7 = 0; i7 < object14.f(); ++i7) {
                                d17 += object14.b(i7, n14);
                            }
                            object15[0][n14] = d17;
                        }
                        sy_0 sy_07 = xw_0.b(new sy_0((double[][])object15, false));
                        object4 = sy_07;
                        int[] nArray4 = xw_0.c(sy_07.f(0));
                        sy_0 sy_08 = xw_0.a((tq_0)object4, nArray4);
                        object14 = xw_0.b(nArray4);
                        sy_0 sy_09 = xw_0.a((tq_0)object4, (int[])object14);
                        object4 = sy_09;
                        object15 = sy_08;
                        object14 = sy_09;
                        double[][] dArray10 = new double[sy_09.f()][object14.g()];
                        for (int i8 = 0; i8 < object14.f(); ++i8) {
                            for (n13 = 0; n13 < object14.g(); ++n13) {
                                dArray10[i8][n13] = object14.b(i8, n13) / object15.b(i8, n13);
                            }
                        }
                        object4 = new sy_0(dArray10, false);
                        object14 = nArray4;
                        object15 = new int[nArray4.length];
                        for (n14 = 0; n14 < ((Object)object14).length; ++n14) {
                            object15[object14[n14]] = n14;
                        }
                        object14 = object15;
                        double d18 = 0.33999999999999997 / xw_0.c((tq_0)(object4 = (Object)xw_0.a((tq_0)object4, (int[])object14))).c(((xw_0)object2).r).b(0, 0);
                        if (d15 > d18) {
                            d15 = d18;
                        }
                        object8 = xw_0.b((tq_0)object8, xw_0.a((tq_0)object4, ((xw_0)object2).g, 1));
                        object8 = ((xw_0)object2).I.c((tq_0)object8);
                        object8 = object8.c(xw_0.e(((xw_0)object2).r)).c(object8.d());
                        ((xw_0)object2).K = ((xw_0)object2).K.b(d16 += d15 * 0.5).a((tq_0)object7).a(tq_03.b(((xw_0)object2).y + d15 * 0.5).c(xw_0.b(xw_0.a(((xw_0)object2).r, 1, ((xw_0)object2).g), tq_03.d()))).b(object8.b(d15));
                    } else {
                        ((xw_0)object2).K = ((xw_0)object2).K.b(d16).a((tq_0)object7).a(tq_03.b(((xw_0)object2).y).c(xw_0.b(xw_0.a(((xw_0)object2).r, 1, ((xw_0)object2).g), tq_03.d())));
                    }
                }
                double d19 = d15;
                Object object16 = object2;
                if (((xw_0)object12).x + ((xw_0)object16).y + d19 > 0.0 && (double)((xw_0)object16).M % 1.0 / (((xw_0)object16).x + ((xw_0)object16).y + d19) / (double)((xw_0)object16).g / 10.0 < 1.0) {
                    ((xw_0)object16).K = xw_0.a(((xw_0)object16).K, 0).a(xw_0.a(((xw_0)object16).K, 1).d());
                    sN sN2 = new sN(((xw_0)object16).K);
                    ((xw_0)object16).G = sN2.a();
                    ((xw_0)object16).H = sN2.b();
                    ((xw_0)object16).J = xw_0.e(((xw_0)object16).H);
                    if (xw_0.g(((xw_0)object16).J) <= 0.0) {
                        for (n13 = 0; n13 < ((xw_0)object16).g; ++n13) {
                            if (!(((xw_0)object16).J.b(n13, 0) < 0.0)) continue;
                            ((xw_0)object16).J.c(n13, 0, 0.0);
                        }
                        double d20 = xw_0.f(((xw_0)object16).J) / 1.0E14;
                        ((xw_0)object16).K = ((xw_0)object16).K.a(xw_0.b(((xw_0)object16).g, ((xw_0)object16).g).b(d20));
                        ((xw_0)object16).J = ((xw_0)object16).J.a(xw_0.a(((xw_0)object16).g, 1).b(d20));
                    }
                    if (xw_0.f(((xw_0)object16).J) > 1.0E14 * xw_0.g(((xw_0)object16).J)) {
                        double d21 = xw_0.f(((xw_0)object16).J) / 1.0E14 - xw_0.g(((xw_0)object16).J);
                        ((xw_0)object16).K = ((xw_0)object16).K.a(xw_0.b(((xw_0)object16).g, ((xw_0)object16).g).b(d21));
                        ((xw_0)object16).J = ((xw_0)object16).J.a(xw_0.a(((xw_0)object16).g, 1).b(d21));
                    }
                    ((xw_0)object16).L = xw_0.e(((xw_0)object16).K);
                    ((xw_0)object16).J = xw_0.b(((xw_0)object16).J);
                    ((xw_0)object16).I = xw_0.b(((xw_0)object16).G, xw_0.a(((xw_0)object16).J.d(), ((xw_0)object16).g, 1));
                }
            } else {
                object3 = tq_03;
                bl = bl4;
                object2 = this;
                double d22 = bl ? 0.0 : ((xw_0)object2).A * ((xw_0)object2).u * (2.0 - ((xw_0)object2).u);
                d22 = d22 + (1.0 - ((xw_0)object2).A - ((xw_0)object2).B);
                ((xw_0)object2).L = ((xw_0)object2).L.b(d22).a(xw_0.c(((xw_0)object2).D).b(((xw_0)object2).A)).a(xw_0.b(((xw_0)object2).L, xw_0.c((tq_0)object3).c(((xw_0)object2).r)).b(((xw_0)object2).B));
                ((xw_0)object2).J = xw_0.b(((xw_0)object2).L);
                if (((xw_0)object2).h > 1 && ((xw_0)object2).M > ((xw_0)object2).h) {
                    ((xw_0)object2).h = 0;
                    ((xw_0)object2).G = xw_0.b(((xw_0)object2).g, ((xw_0)object2).g);
                    ((xw_0)object2).I = xw_0.e(((xw_0)object2).J);
                    ((xw_0)object2).K = xw_0.e(((xw_0)object2).L);
                }
            }
            this.t *= BY.i(BY.d(1.0, (this.F / this.z - 1.0) * this.v / this.w));
            double d23 = dArray4[nArray[0]];
            double d24 = dArray4[nArray[nArray.length - 1]];
            if (d11 > d23) {
                d11 = d23;
                object6 = object;
                double[] dArray11 = sy_04.g(0);
                object2 = b2;
                object = new wQ(((b)object2).c(dArray11), this.b ? d23 : -d23);
                if (this.j() != null && this.j().a(this.M, (double[])object, (double[])object6)) break;
            }
            if (this.k != 0.0 && d23 < (this.b ? this.k : -this.k)) break;
            object8 = xw_0.b(this.L).g(0);
            object4 = this.D.g(0);
            for (n6 = 0; n6 < this.g && !(this.t * BY.e(BY.w((double)object4[n6]), (double)object8[n6]) > this.m); ++n6) {
                if (n6 >= this.g - 1) break block8;
            }
            for (n6 = 0; n6 < this.g; ++n6) {
                if (this.t * object8[n6] > this.l) break block8;
            }
            object2 = this.N;
            Object object17 = Double.MAX_VALUE;
            for (n5 = 0; n5 < ((Object)object2).length; ++n5) {
                if (!(object17 > object2[n5])) continue;
                object17 = object2[n5];
            }
            double d25 = object17;
            object2 = this.N;
            object17 = -1.7976931348623157E308;
            for (n5 = 0; n5 < ((Object)object2).length; ++n5) {
                if (!(object17 < object2[n5])) continue;
                object17 = object2[n5];
            }
            Object object18 = object17;
            if (this.M > 2 && BY.e(object18, d24) - BY.d(d25, d23) < this.n || this.M > this.N.length && object18 - d25 < this.o || xw_0.f(this.J) / xw_0.g(this.J) > 1.0E7) break;
            if (this.j() != null) {
                object8 = new wQ(sy_04.g(0), this.b ? d23 : -d23);
                if (object6 != null && this.j().a(this.M, (double[])object8, (double[])object6)) break;
                object6 = object8;
            }
            if (d11 == dArray4[nArray[(int)(0.1 + (double)this.c / 4.0)]]) {
                this.t *= BY.i(0.2 + this.v / this.w);
            }
            if (this.M > 2 && BY.e(object18, d23) - BY.d(d25, d23) == 0.0) {
                this.t *= BY.i(0.2 + this.v / this.w);
            }
            xw_0.a(this.N, d23);
            if (this.i) {
                this.Q.add(this.t);
                this.S.add(d23);
                this.R.add(this.C.d());
                this.T.add(this.J.d().b(100000.0));
            }
            ++this.M;
        }
        return object;
    }

    @Override
    public final void b(wO ... objectArray) {
        super.b((wO[])objectArray);
        Object[] objectArray2 = objectArray;
        int n2 = objectArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = objectArray2[i2];
            if (object instanceof d) {
                this.f = ((d)object).a();
                continue;
            }
            if (!(object instanceof c)) continue;
            c c2 = (c)object;
            this.c = c2.a;
        }
        xw_0 xw_02 = this;
        double[] dArray = xw_02.e();
        double[] dArray2 = xw_02.f();
        double[] dArray3 = xw_02.g();
        if (xw_02.f != null) {
            if (xw_02.f.length != dArray.length) {
                throw new oS(xw_02.f.length, dArray.length);
            }
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                if (!(xw_02.f[i3] > dArray3[i3] - dArray2[i3])) continue;
                throw new po_0(xw_02.f[i3], (Number)0, dArray3[i3] - dArray2[i3]);
            }
        }
    }

    private void q() {
        double[] dArray = this.e();
        double[] dArray2 = this.f();
        double[] dArray3 = this.g();
        if (this.f != null) {
            if (this.f.length != dArray.length) {
                throw new oS(this.f.length, dArray.length);
            }
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                if (!(this.f[i2] > dArray3[i2] - dArray2[i2])) continue;
                throw new po_0(this.f[i2], (Number)0, dArray3[i2] - dArray2[i2]);
            }
        }
    }

    private void a(double[] dArray) {
        int n2;
        if (this.c <= 0) {
            throw new pk_0(this.c);
        }
        double[][] dArray2 = new double[dArray.length][1];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray2[i2][0] = this.f[i2];
        }
        sy_0 sy_02 = new sy_0(dArray2, false);
        this.t = xw_0.f(sy_02);
        this.l = 1000.0 * xw_0.f(sy_02);
        this.m = 1.0E-11 * xw_0.f(sy_02);
        this.n = 1.0E-12;
        this.o = 1.0E-13;
        this.p = this.c / 2;
        this.q = BY.k((double)this.p + 0.5);
        this.r = xw_0.a(xw_0.a(1.0, (double)this.p, 1.0)).b(-1.0).a(this.q);
        double d2 = 0.0;
        double d3 = 0.0;
        for (n2 = 0; n2 < this.p; ++n2) {
            double d4 = this.r.b(n2, 0);
            d2 += d4;
            double d5 = d4;
            d3 += d5 * d5;
        }
        this.r = this.r.b(1.0 / d2);
        double d6 = d2;
        this.s = d6 * d6 / d3;
        this.u = (4.0 + this.s / (double)this.g) / ((double)(this.g + 4) + 2.0 * this.s / (double)this.g);
        this.v = (this.s + 2.0) / ((double)this.g + this.s + 3.0);
        this.w = (1.0 + 2.0 * BY.e(0.0, BY.a((this.s - 1.0) / (double)(this.g + 1)) - 1.0)) * BY.e(0.3, 1.0 - (double)this.g / (1.0E-6 + (double)this.j)) + this.v;
        this.x = 2.0 / (((double)this.g + 1.3) * ((double)this.g + 1.3) + this.s);
        this.y = BY.d(1.0 - this.x, 2.0 * (this.s - 2.0 + 1.0 / this.s) / ((double)((this.g + 2) * (this.g + 2)) + this.s));
        this.A = BY.d(1.0, this.x * ((double)this.g + 1.5) / 3.0);
        this.B = BY.d(1.0 - this.x, this.y * ((double)this.g + 1.5) / 3.0);
        this.z = BY.a((double)this.g) * (1.0 - 1.0 / (4.0 * (double)this.g) + 1.0 / (21.0 * (double)this.g * (double)this.g));
        this.C = td_0.c(dArray);
        this.J = sy_02.b(1.0 / this.t);
        this.L = xw_0.c(this.J);
        this.D = xw_0.c(this.g, 1);
        this.E = xw_0.c(this.g, 1);
        this.F = this.E.c();
        this.G = xw_0.b(this.g, this.g);
        this.H = xw_0.a(this.g, 1);
        this.I = xw_0.b(this.G, xw_0.a(this.J.d(), this.g, 1));
        this.K = this.G.c(xw_0.e(xw_0.c(this.H)).c(this.G.d()));
        this.O = 10 + (int)((double)(30 * this.g) / (double)this.c);
        this.N = new double[this.O];
        for (n2 = 0; n2 < this.O; ++n2) {
            this.N[n2] = Double.MAX_VALUE;
        }
    }

    private boolean a(tq_0 tq_02, tq_0 tq_03) {
        this.E = this.E.b(1.0 - this.v).a(this.G.c(tq_02).b(BY.a(this.v * (2.0 - this.v) * this.s)));
        this.F = this.E.c();
        boolean bl = this.F / BY.a(1.0 - BY.a(1.0 - this.v, 2 * this.M)) / this.z < 1.4 + 2.0 / ((double)this.g + 1.0);
        this.D = this.D.b(1.0 - this.u);
        if (bl) {
            this.D = this.D.a(this.C.b(tq_03).b(BY.a(this.u * (2.0 - this.u) * this.s) / this.t));
        }
        return bl;
    }

    private void a(boolean bl, tq_0 tq_02) {
        double d2 = bl ? 0.0 : this.A * this.u * (2.0 - this.u);
        d2 = d2 + (1.0 - this.A - this.B);
        this.L = this.L.b(d2).a(xw_0.c(this.D).b(this.A)).a(xw_0.b(this.L, xw_0.c(tq_02).c(this.r)).b(this.B));
        this.J = xw_0.b(this.L);
        if (this.h > 1 && this.M > this.h) {
            this.h = 0;
            this.G = xw_0.b(this.g, this.g);
            this.I = xw_0.e(this.J);
            this.K = xw_0.e(this.L);
        }
    }

    private void a(boolean bl, tq_0 tq_02, tq_0 tq_03, int[] nArray, tq_0 tq_04) {
        double d2 = 0.0;
        if (this.x + this.y > 0.0) {
            tq_02 = tq_02.b(xw_0.a(tq_04, 1, this.p)).b(1.0 / this.t);
            tq_04 = this.D.c(this.D.d()).b(this.x);
            double d3 = bl ? 0.0 : this.x * this.u * (2.0 - this.u);
            d3 = d3 + (1.0 - this.x - this.y);
            if (this.d) {
                d2 = (1.0 - this.y) * 0.25 * this.s / (BY.a((double)(this.g + 2), 1.5) + 2.0 * this.s);
                Object object = xw_0.b(nArray);
                sy_0 sy_02 = xw_0.a(tq_03, ch_0.a((int[])object, this.p));
                object = sy_02;
                tq_03 = xw_0.b(xw_0.d(xw_0.c(sy_02)));
                nArray = xw_0.c(tq_03.f(0));
                sy_0 sy_03 = xw_0.a(tq_03, nArray);
                int[] nArray2 = xw_0.b(nArray);
                tq_03 = xw_0.a(tq_03, nArray2);
                tq_03 = xw_0.c(tq_03, sy_03);
                double d4 = 0.33999999999999997 / xw_0.c(tq_03 = xw_0.a(tq_03, nArray = xw_0.a(nArray))).c(this.r).b(0, 0);
                if (d2 > d4) {
                    d2 = d4;
                }
                object = xw_0.b((tq_0)object, xw_0.a(tq_03, this.g, 1));
                tq_0 tq_05 = this.I.c((tq_0)object);
                object = tq_05;
                object = tq_05.c(xw_0.e(this.r)).c(object.d());
                this.K = this.K.b(d3 += d2 * 0.5).a(tq_04).a(tq_02.b(this.y + d2 * 0.5).c(xw_0.b(xw_0.a(this.r, 1, this.g), tq_02.d()))).b(object.b(d2));
            } else {
                this.K = this.K.b(d3).a(tq_04).a(tq_02.b(this.y).c(xw_0.b(xw_0.a(this.r, 1, this.g), tq_02.d())));
            }
        }
        this.a(d2);
    }

    private void a(double d2) {
        if (this.x + this.y + d2 > 0.0 && (double)this.M % 1.0 / (this.x + this.y + d2) / (double)this.g / 10.0 < 1.0) {
            double d3;
            this.K = xw_0.a(this.K, 0).a(xw_0.a(this.K, 1).d());
            sN sN2 = new sN(this.K);
            this.G = sN2.a();
            this.H = sN2.b();
            this.J = xw_0.e(this.H);
            if (xw_0.g(this.J) <= 0.0) {
                for (int i2 = 0; i2 < this.g; ++i2) {
                    if (!(this.J.b(i2, 0) < 0.0)) continue;
                    this.J.c(i2, 0, 0.0);
                }
                d3 = xw_0.f(this.J) / 1.0E14;
                this.K = this.K.a(xw_0.b(this.g, this.g).b(d3));
                this.J = this.J.a(xw_0.a(this.g, 1).b(d3));
            }
            if (xw_0.f(this.J) > 1.0E14 * xw_0.g(this.J)) {
                d3 = xw_0.f(this.J) / 1.0E14 - xw_0.g(this.J);
                this.K = this.K.a(xw_0.b(this.g, this.g).b(d3));
                this.J = this.J.a(xw_0.a(this.g, 1).b(d3));
            }
            this.L = xw_0.e(this.K);
            this.J = xw_0.b(this.J);
            this.I = xw_0.b(this.G, xw_0.a(this.J.d(), this.g, 1));
        }
    }

    private static void a(double[] dArray, double d2) {
        for (int i2 = dArray.length - 1; i2 > 0; --i2) {
            dArray[i2] = dArray[i2 - 1];
        }
        dArray[0] = d2;
    }

    private static int[] c(double[] dArray) {
        Object[] objectArray = new a[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            objectArray[i2] = new a(dArray[i2], i2);
        }
        Arrays.sort(objectArray);
        int[] nArray = new int[dArray.length];
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            nArray[i3] = ((a)objectArray[i3]).b;
        }
        return nArray;
    }

    private static double a(e[] eArray) {
        double d2 = Double.NEGATIVE_INFINITY;
        double d3 = Double.MAX_VALUE;
        int n2 = eArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2;
            e e3;
            e e4;
            e e5 = e4 = eArray[i2];
            if (e3.a > d2) {
                e5 = e4;
                d2 = e5.a;
            }
            e5 = e4;
            if (!(e2.a < d3)) continue;
            e5 = e4;
            d3 = e5.a;
        }
        return d2 - d3;
    }

    private static sy_0 a(tq_0 tq_02) {
        double[][] dArray = new double[tq_02.f()][tq_02.g()];
        for (int i2 = 0; i2 < tq_02.f(); ++i2) {
            for (int i3 = 0; i3 < tq_02.g(); ++i3) {
                dArray[i2][i3] = BY.k(tq_02.b(i2, i3));
            }
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 b(tq_0 tq_02) {
        double[][] dArray = new double[tq_02.f()][tq_02.g()];
        for (int i2 = 0; i2 < tq_02.f(); ++i2) {
            for (int i3 = 0; i3 < tq_02.g(); ++i3) {
                dArray[i2][i3] = BY.a(tq_02.b(i2, i3));
            }
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 c(tq_0 tq_02) {
        double[][] dArray = new double[tq_02.f()][tq_02.g()];
        for (int i2 = 0; i2 < tq_02.f(); ++i2) {
            for (int i3 = 0; i3 < tq_02.g(); ++i3) {
                double d2;
                double d3 = d2 = tq_02.b(i2, i3);
                dArray[i2][i3] = d3 * d3;
            }
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 b(tq_0 tq_02, tq_0 tq_03) {
        double[][] dArray = new double[tq_02.f()][tq_02.g()];
        for (int i2 = 0; i2 < tq_02.f(); ++i2) {
            for (int i3 = 0; i3 < tq_02.g(); ++i3) {
                dArray[i2][i3] = tq_02.b(i2, i3) * tq_03.b(i2, i3);
            }
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 c(tq_0 tq_02, tq_0 tq_03) {
        double[][] dArray = new double[tq_02.f()][tq_02.g()];
        for (int i2 = 0; i2 < tq_02.f(); ++i2) {
            for (int i3 = 0; i3 < tq_02.g(); ++i3) {
                dArray[i2][i3] = tq_02.b(i2, i3) / tq_03.b(i2, i3);
            }
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 a(tq_0 tq_02, int[] nArray) {
        double[][] dArray = new double[tq_02.f()][nArray.length];
        for (int i2 = 0; i2 < tq_02.f(); ++i2) {
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                dArray[i2][i3] = tq_02.b(i2, nArray[i3]);
            }
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 a(tq_0 tq_02, int n2) {
        double[][] dArray = new double[tq_02.f()][tq_02.g()];
        for (int i2 = 0; i2 < tq_02.f(); ++i2) {
            for (int i3 = 0; i3 < tq_02.g(); ++i3) {
                dArray[i2][i3] = i2 <= i3 - n2 ? tq_02.b(i2, i3) : 0.0;
            }
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 d(tq_0 tq_02) {
        double[][] dArray = new double[1][tq_02.g()];
        for (int i2 = 0; i2 < tq_02.g(); ++i2) {
            double d2 = 0.0;
            for (int i3 = 0; i3 < tq_02.f(); ++i3) {
                d2 += tq_02.b(i3, i2);
            }
            dArray[0][i2] = d2;
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 e(tq_0 tq_02) {
        if (tq_02.g() == 1) {
            double[][] dArray = new double[tq_02.f()][tq_02.f()];
            for (int i2 = 0; i2 < tq_02.f(); ++i2) {
                dArray[i2][i2] = tq_02.b(i2, 0);
            }
            return new sy_0(dArray, false);
        }
        double[][] dArray = new double[tq_02.f()][1];
        for (int i3 = 0; i3 < tq_02.g(); ++i3) {
            int n2 = i3;
            dArray[i3][0] = tq_02.b(n2, n2);
        }
        return new sy_0(dArray, false);
    }

    private static void a(tq_0 tq_02, int n2, tq_0 tq_03, int n3) {
        for (n2 = 0; n2 < tq_02.f(); ++n2) {
            tq_03.c(n2, n3, tq_02.b(n2, 0));
        }
    }

    private static sy_0 a(int n2, int n3) {
        double[][] dArray = new double[n2][1];
        for (int i2 = 0; i2 < n2; ++i2) {
            Arrays.fill(dArray[i2], 1.0);
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 b(int n2, int n3) {
        double[][] dArray = new double[n2][n3];
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 >= n3) continue;
            dArray[i2][i2] = 1.0;
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 c(int n2, int n3) {
        return new sy_0(n2, n3);
    }

    private static sy_0 a(tq_0 tq_02, int n2, int n3) {
        int n4 = tq_02.f();
        int n5 = tq_02.g();
        double[][] dArray = new double[n2 * n4][n3 * n5];
        for (int i2 = 0; i2 < n2 * n4; ++i2) {
            for (int i3 = 0; i3 < n3 * n5; ++i3) {
                dArray[i2][i3] = tq_02.b(i2 % n4, i3 % n5);
            }
        }
        return new sy_0(dArray, false);
    }

    private static sy_0 a(double d2, double d3, double d4) {
        int n2 = (int)(d3 - 1.0 + 1.0);
        double[][] dArray = new double[n2][1];
        double d5 = 1.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2][0] = d5;
            d5 += 1.0;
        }
        return new sy_0(dArray, false);
    }

    private static double f(tq_0 tq_02) {
        double d2 = -1.7976931348623157E308;
        for (int i2 = 0; i2 < tq_02.f(); ++i2) {
            for (int i3 = 0; i3 < tq_02.g(); ++i3) {
                double d3 = tq_02.b(i2, i3);
                if (!(d2 < d3)) continue;
                d2 = d3;
            }
        }
        return d2;
    }

    private static double g(tq_0 tq_02) {
        double d2 = Double.MAX_VALUE;
        for (int i2 = 0; i2 < tq_02.f(); ++i2) {
            for (int i3 = 0; i3 < tq_02.g(); ++i3) {
                double d3 = tq_02.b(i2, i3);
                if (!(d2 > d3)) continue;
                d2 = d3;
            }
        }
        return d2;
    }

    private static double d(double[] dArray) {
        double d2 = -1.7976931348623157E308;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (!(d2 < dArray[i2])) continue;
            d2 = dArray[i2];
        }
        return d2;
    }

    private static double e(double[] dArray) {
        double d2 = Double.MAX_VALUE;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (!(d2 > dArray[i2])) continue;
            d2 = dArray[i2];
        }
        return d2;
    }

    private static int[] a(int[] nArray) {
        int[] nArray2 = new int[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray2[nArray[i2]] = i2;
        }
        return nArray2;
    }

    private static int[] b(int[] nArray) {
        int[] nArray2 = new int[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray2[i2] = nArray[nArray.length - i2 - 1];
        }
        return nArray2;
    }

    private double[] a(int n2) {
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.P.nextGaussian();
        }
        return dArray;
    }

    private sy_0 d(int n2, int n3) {
        double[][] dArray = new double[n2][n3];
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                dArray[i2][i3] = this.P.nextGaussian();
            }
        }
        return new sy_0(dArray, false);
    }

    @Override
    public final /* synthetic */ Object a(wO[] object) {
        wO[] wOArray = object;
        object = this;
        return super.c(wOArray);
    }

    @Override
    public final /* synthetic */ Object c() {
        return this.p();
    }

    static /* synthetic */ boolean a(xw_0 xw_02) {
        return xw_02.b;
    }

    final class b {
        private final boolean b;

        b() {
            this.b = true;
        }

        public final e a(double[] object) {
            double d2;
            double d3 = 0.0;
            if (this.b) {
                double[] dArray = this.c((double[])object);
                d2 = xw_0.this.b(dArray);
                d3 = this.a((double[])object, dArray);
            } else {
                d2 = xw_0.this.b((double[])object);
            }
            xw_0 xw_02 = xw_0.this;
            object = xw_02;
            d2 = ((xw)xw_02).b ? d2 : -d2;
            xw_0 xw_03 = xw_0.this;
            object = xw_03;
            d3 = ((xw)xw_03).b ? d3 : -d3;
            return new e(d2, d3);
        }

        public final boolean b(double[] dArray) {
            double[] dArray2 = xw_0.this.f();
            double[] dArray3 = xw_0.this.g();
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                if (dArray[i2] < dArray2[i2]) {
                    return false;
                }
                if (!(dArray[i2] > dArray3[i2])) continue;
                return false;
            }
            return true;
        }

        double[] c(double[] dArray) {
            double[] dArray2 = xw_0.this.f();
            double[] dArray3 = xw_0.this.g();
            double[] dArray4 = new double[dArray.length];
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                dArray4[i2] = dArray[i2] < dArray2[i2] ? dArray2[i2] : (dArray[i2] > dArray3[i2] ? dArray3[i2] : dArray[i2]);
            }
            return dArray4;
        }

        private double a(double[] object, double[] dArray) {
            double d2 = 0.0;
            for (int i2 = 0; i2 < ((double[])object).length; ++i2) {
                double d3 = BY.w(object[i2] - dArray[i2]);
                d2 += d3;
            }
            xw_0 xw_02 = xw_0.this;
            object = xw_02;
            if (((xw)xw_02).b) {
                return d2;
            }
            return -d2;
        }

        static /* synthetic */ double[] a(b b2, double[] dArray) {
            return b2.c(dArray);
        }
    }

    static final class e {
        double a;
        double b;

        e(double d2, double d3) {
            this.a = d2;
            this.b = d3;
        }

        static /* synthetic */ double a(e e2) {
            return e2.a;
        }

        static /* synthetic */ double b(e e2) {
            return e2.b;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a
    implements Comparable<a> {
        private final double a;
        private final int b;

        a(double d2, int n2) {
            this.a = d2;
            this.b = n2;
        }

        private int b(a a2) {
            return Double.compare(this.a, a2.a);
        }

        /*
         * WARNING - void declaration
         */
        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof a) {
                void var1_1;
                return Double.compare(this.a, ((a)var1_1).a) == 0;
            }
            return false;
        }

        public final int hashCode() {
            long l2 = Double.doubleToLongBits(this.a);
            return (int)(0x15F34EL ^ l2 >>> 32 ^ l2);
        }

        @Override
        public final /* synthetic */ int compareTo(Object object) {
            a a2 = (a)object;
            object = this;
            return Double.compare(((a)object).a, a2.a);
        }
    }

    public static final class c
    implements wO {
        final int a;

        private c(int n2) {
            if (n2 <= 0) {
                throw new pk_0(n2);
            }
            this.a = n2;
        }

        public final int a() {
            return this.a;
        }
    }

    public static final class d
    implements wO {
        private final double[] a;

        private d(double[] dArray) {
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                if (!(dArray[i2] < 0.0)) continue;
                throw new pj_0(dArray[i2]);
            }
            this.a = (double[])dArray.clone();
        }

        public final double[] a() {
            return (double[])this.a.clone();
        }
    }
}

