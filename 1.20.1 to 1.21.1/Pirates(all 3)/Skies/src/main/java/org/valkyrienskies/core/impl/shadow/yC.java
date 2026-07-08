/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.sN;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.yA;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yn_0;
import org.valkyrienskies.core.impl.shadow.yo_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.yt_0;
import org.valkyrienskies.core.impl.shadow.yz_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yC
extends yA<kW>
implements yn_0 {
    private static int b = 0;
    private static double c = 0.0;
    private static boolean d = true;
    private static int e = 30000;
    private static int f = 0;
    private static zz_0 g = new zz_0();
    private int h;
    private boolean i;
    private int j;
    private double[] k;
    private int l;
    private int m = 0;
    private boolean n = true;
    private boolean o = false;
    private int p;
    private double q;
    private double r;
    private double s;
    private double t;
    private double u;
    private int v;
    private double w;
    private tq_0 x;
    private double y;
    private double z;
    private double A;
    private double B;
    private double C;
    private double D;
    private double E;
    private double F;
    private double G;
    private double H;
    private tq_0 I;
    private tq_0 J;
    private tq_0 K;
    private double L;
    private tq_0 M;
    private tq_0 N;
    private tq_0 O;
    private tq_0 P;
    private tq_0 Q;
    private tq_0 R;
    private int S;
    private double[] T;
    private int U;
    private zF V;
    private List<Double> W = new ArrayList<Double>();
    private List<tq_0> X = new ArrayList<tq_0>();
    private List<Double> Y = new ArrayList<Double>();
    private List<tq_0> Z = new ArrayList<tq_0>();

    @Deprecated
    public yC() {
        this(0);
    }

    @Deprecated
    private yC(int n2) {
        this(0, null, 30000, 0.0, true, 0, 0, g, false, null);
    }

    @Deprecated
    private yC(int n2, double[] dArray) {
        this(n2, dArray, 30000, 0.0, true, 0, 0, g, false);
    }

    @Deprecated
    private yC(int n2, double[] dArray, int n3, double d2, boolean bl, int n4, int n5, zF zF2, boolean bl2) {
        this(n2, dArray, 30000, 0.0, true, 0, 0, zF2, false, new yt_0());
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Deprecated
    private yC(int n2, double[] dArray, int n3, double d2, boolean bl, int n4, int n5, zF zF2, boolean bl2, yt_0 yt_02) {
        super(yt_02);
        this.h = n2;
        this.k = dArray == null ? null : (double[])dArray.clone();
        this.p = n3;
        this.q = d2;
        this.i = bl;
        this.m = n4;
        this.j = n5;
        this.V = zF2;
        this.o = bl2;
    }

    private yC(int n2, double d2, boolean bl, int n3, int n4, zF zF2, boolean bl2, ya_0<yp_0> ya_02) {
        super(ya_02);
        this.p = n2;
        this.q = d2;
        this.i = bl;
        this.m = n3;
        this.j = n4;
        this.V = zF2;
        this.o = bl2;
    }

    private List<Double> i() {
        return this.W;
    }

    private List<tq_0> j() {
        return this.X;
    }

    private List<Double> k() {
        return this.Y;
    }

    private List<tq_0> l() {
        return this.Z;
    }

    @Override
    protected final yp_0 a(int n2, kW kW2, yf_0 yf_02, yo_0 ... yo_0Array) {
        yo_0[] yo_0Array2 = yo_0Array;
        yC yC2 = this;
        for (yo_0 yo_02 : yo_0Array2) {
            if (yo_02 instanceof d) {
                yC2.k = ((d)yo_02).a();
                continue;
            }
            if (!(yo_02 instanceof c)) continue;
            yo_02 = (c)yo_02;
            yC2.h = ((c)yo_02).a;
        }
        return super.a(n2, kW2, yf_02, yo_0Array);
    }

    @Override
    protected final yp_0 d() {
        int n2;
        Object object = this;
        double[] dArray = ((yz_0)object).f();
        Object object2 = ((yz_0)object).g();
        double[] dArray2 = ((yz_0)object).h();
        if (((yC)object).k != null) {
            if (((yC)object).k.length != dArray.length) {
                throw new oS(((yC)object).k.length, dArray.length);
            }
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                if (((yC)object).k[i2] < 0.0) {
                    throw new pj_0(((yC)object).k[i2]);
                }
                if (!(((yC)object).k[i2] > dArray2[i2] - object2[i2])) continue;
                throw new po_0(((yC)object).k[i2], (Number)0, dArray2[i2] - object2[i2]);
            }
        }
        this.n = this.e().equals(yf_0.MINIMIZE);
        b b2 = new b();
        Object object3 = this.f();
        this.l = ((double[])object3).length;
        dArray = object3;
        object = this;
        if (((yC)object).h <= 0) {
            ((yC)object).h = 4 + (int)(3.0 * BY.k(((yC)object).l));
        }
        object2 = new double[dArray.length][1];
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            object2[i3][0] = ((yC)object).k == null ? 0.3 : ((yC)object).k[i3];
        }
        sy_0 sy_02 = new sy_0((double[][])object2, false);
        ((yC)object).z = yC.f(sy_02);
        ((yC)object).r = 1000.0 * yC.f(sy_02);
        ((yC)object).s = 1.0E-11 * yC.f(sy_02);
        ((yC)object).t = 1.0E-12;
        ((yC)object).u = 1.0E-13;
        ((yC)object).v = ((yC)object).h / 2;
        ((yC)object).w = BY.k((double)((yC)object).v + 0.5);
        double d2 = 1.0;
        double d3 = ((yC)object).v;
        double d4 = 1.0;
        int n3 = (int)(d3 - 1.0 + 1.0);
        Object object4 = new double[n3][1];
        double d5 = 1.0;
        for (int i4 = 0; i4 < n3; ++i4) {
            object4[i4][0] = d5;
            d5 += 1.0;
        }
        sy_0 sy_03 = new sy_0((double[][])object4, false);
        double[][] dArray3 = new double[sy_03.f()][sy_03.g()];
        for (int i5 = 0; i5 < sy_03.f(); ++i5) {
            for (int i6 = 0; i6 < sy_03.g(); ++i6) {
                dArray3[i5][i6] = BY.k(sy_03.b(i5, i6));
            }
        }
        ((yC)object).x = new sy_0(dArray3, false).b(-1.0).a(((yC)object).w);
        double d6 = 0.0;
        double d7 = 0.0;
        for (n2 = 0; n2 < ((yC)object).v; ++n2) {
            double d8 = ((yC)object).x.b(n2, 0);
            d6 += d8;
            double d9 = d8;
            d7 += d9 * d9;
        }
        ((yC)object).x = ((yC)object).x.b(1.0 / d6);
        double d10 = d6;
        ((yC)object).y = d10 * d10 / d7;
        ((yC)object).A = (4.0 + ((yC)object).y / (double)((yC)object).l) / ((double)(((yC)object).l + 4) + 2.0 * ((yC)object).y / (double)((yC)object).l);
        ((yC)object).B = (((yC)object).y + 2.0) / ((double)((yC)object).l + ((yC)object).y + 3.0);
        ((yC)object).C = (1.0 + 2.0 * BY.e(0.0, BY.a((((yC)object).y - 1.0) / (double)(((yC)object).l + 1)) - 1.0)) * BY.e(0.3, 1.0 - (double)((yC)object).l / (1.0E-6 + (double)((yC)object).p)) + ((yC)object).B;
        ((yC)object).D = 2.0 / (((double)((yC)object).l + 1.3) * ((double)((yC)object).l + 1.3) + ((yC)object).y);
        ((yC)object).E = BY.d(1.0 - ((yC)object).D, 2.0 * (((yC)object).y - 2.0 + 1.0 / ((yC)object).y) / ((double)((((yC)object).l + 2) * (((yC)object).l + 2)) + ((yC)object).y));
        ((yC)object).G = BY.d(1.0, ((yC)object).D * ((double)((yC)object).l + 1.5) / 3.0);
        ((yC)object).H = BY.d(1.0 - ((yC)object).D, ((yC)object).E * ((double)((yC)object).l + 1.5) / 3.0);
        ((yC)object).F = BY.a((double)((yC)object).l) * (1.0 - 1.0 / (4.0 * (double)((yC)object).l) + 1.0 / (21.0 * (double)((yC)object).l * (double)((yC)object).l));
        ((yC)object).I = td_0.c(dArray);
        ((yC)object).P = sy_02.b(1.0 / ((yC)object).z);
        ((yC)object).R = yC.c(((yC)object).P);
        ((yC)object).J = yC.c(((yC)object).l, 1);
        ((yC)object).K = yC.c(((yC)object).l, 1);
        ((yC)object).L = ((yC)object).K.c();
        ((yC)object).M = yC.b(((yC)object).l, ((yC)object).l);
        ((yC)object).N = yC.a(((yC)object).l, 1);
        ((yC)object).O = yC.b(((yC)object).M, yC.a(((yC)object).P.d(), ((yC)object).l, 1));
        ((yC)object).Q = ((yC)object).M.c(yC.e(yC.c(((yC)object).N)).c(((yC)object).M.d()));
        ((yC)object).U = 10 + (int)((double)(30 * ((yC)object).l) / (double)((yC)object).h);
        ((yC)object).T = new double[((yC)object).U];
        for (n2 = 0; n2 < ((yC)object).U; ++n2) {
            ((yC)object).T[n2] = Double.MAX_VALUE;
        }
        this.S = 0;
        double d11 = b2.a((double[])object3);
        yC.a(this.T, d11);
        object3 = new yp_0(this.f(), this.n ? d11 : -d11);
        Object object5 = null;
        this.S = 1;
        block9: while (this.S <= this.p) {
            int n4;
            int n5;
            boolean bl;
            int n6;
            yC yC2 = this;
            int n7 = this.h;
            int n8 = yC2.l;
            object = yC2;
            double[][] dArray4 = new double[n8][n7];
            for (n6 = 0; n6 < n8; ++n6) {
                for (int i7 = 0; i7 < n7; ++i7) {
                    dArray4[n6][i7] = ((yC)object).V.nextGaussian();
                }
            }
            Object object6 = new sy_0(dArray4, false);
            Object object7 = yC.c(this.l, this.h);
            double[] dArray5 = new double[this.h];
            for (int i8 = 0; i8 < this.h; ++i8) {
                object4 = null;
                for (int i9 = 0; i9 < this.j + 1; ++i9) {
                    boolean bl2;
                    double[] dArray6;
                    block49: {
                        object4 = this.m <= 0 ? (Object)this.I.a(this.O.c(object6.c(i8)).b(this.z)) : (Object)this.I.a(yC.b(this.P, object6.c(i8)).b(this.z));
                        if (i9 >= this.j) break;
                        double[] dArray7 = object4.g(0);
                        object = b2;
                        dArray6 = ((b)object).yC.this.g();
                        double[] dArray8 = ((b)object).yC.this.h();
                        for (n6 = 0; n6 < dArray7.length; ++n6) {
                            if (dArray7[n6] < dArray6[n6]) {
                                bl2 = false;
                            } else {
                                if (!(dArray7[n6] > dArray8[n6])) continue;
                                bl2 = false;
                            }
                            break block49;
                        }
                        bl2 = true;
                    }
                    if (bl2) break;
                    yC yC3 = this;
                    n8 = yC3.l;
                    object = yC3;
                    dArray6 = new double[n8];
                    for (int i10 = 0; i10 < n8; ++i10) {
                        dArray6[i10] = ((yC)object).V.nextGaussian();
                    }
                    object6.b(i8, dArray6);
                }
                int n9 = i8;
                sy_0 sy_04 = object7;
                n8 = 0;
                object = object4;
                for (n6 = 0; n6 < object.f(); ++n6) {
                    sy_04.c(n6, n9, object.b(n6, 0));
                }
                try {
                    dArray5[i8] = b2.a(object7.g(i8));
                    continue;
                }
                catch (pp_0 pp_02) {
                    break block9;
                }
            }
            int[] nArray = yC.c(dArray5);
            object4 = this.I;
            sy_0 sy_05 = yC.a((tq_0)object7, ch_0.a(nArray, this.v));
            this.I = sy_05.c(this.x);
            object7 = yC.a((tq_0)object6, ch_0.a(nArray, this.v));
            object = object7.c(this.x);
            object2 = object4;
            Object object8 = object;
            object = this;
            this.K = ((yC)object).K.b(1.0 - ((yC)object).B).a(((yC)object).M.c((tq_0)object8).b(BY.a(((yC)object).B * (2.0 - ((yC)object).B) * ((yC)object).y)));
            ((yC)object).L = ((yC)object).K.c();
            boolean bl3 = ((yC)object).L / BY.a(1.0 - BY.a(1.0 - ((yC)object).B, 2 * ((yC)object).S)) / ((yC)object).F < 1.4 + 2.0 / ((double)((yC)object).l + 1.0);
            ((yC)object).J = ((yC)object).J.b(1.0 - ((yC)object).A);
            if (bl3) {
                ((yC)object).J = ((yC)object).J.a(((yC)object).I.b((tq_0)object2).b(BY.a(((yC)object).A * (2.0 - ((yC)object).A) * ((yC)object).y) / ((yC)object).z));
            }
            boolean bl4 = bl3;
            if (this.m <= 0) {
                Object object9;
                int n10;
                Object object10 = object4;
                int[] nArray2 = nArray;
                sy_0 sy_06 = object6;
                object2 = sy_05;
                bl = bl4;
                object = this;
                d7 = 0.0;
                if (((yC)object).D + ((yC)object).E > 0.0) {
                    object6 = object2.b(yC.a((tq_0)object10, 1, ((yC)object).v)).b(1.0 / ((yC)object).z);
                    tq_0 tq_02 = ((yC)object).J.c(((yC)object).J.d()).b(((yC)object).D);
                    double d12 = bl ? 0.0 : ((yC)object).D * ((yC)object).A * (2.0 - ((yC)object).A);
                    d12 = d12 + (1.0 - ((yC)object).D - ((yC)object).E);
                    if (((yC)object).i) {
                        int n11;
                        d7 = (1.0 - ((yC)object).E) * 0.25 * ((yC)object).y / (BY.a((double)(((yC)object).l + 2), 1.5) + 2.0 * ((yC)object).y);
                        int[] nArray3 = yC.b(nArray2);
                        object7 = yC.a((tq_0)sy_06, ch_0.a(nArray3, ((yC)object).v));
                        Object object11 = yC.c((tq_0)object7);
                        Object object12 = new double[1][object11.g()];
                        for (n11 = 0; n11 < object11.g(); ++n11) {
                            double d13 = 0.0;
                            for (int i11 = 0; i11 < object11.f(); ++i11) {
                                d13 += object11.b(i11, n11);
                            }
                            object12[0][n11] = d13;
                        }
                        object4 = yC.b(new sy_0((double[][])object12, false));
                        int[] nArray4 = yC.c(object4.f(0));
                        sy_0 sy_07 = yC.a((tq_0)object4, nArray4);
                        object11 = yC.b(nArray4);
                        object4 = yC.a((tq_0)object4, (int[])object11);
                        object12 = sy_07;
                        object11 = object4;
                        double[][] dArray9 = new double[object4.f()][object11.g()];
                        for (int i12 = 0; i12 < object11.f(); ++i12) {
                            for (n10 = 0; n10 < object11.g(); ++n10) {
                                dArray9[i12][n10] = object11.b(i12, n10) / object12.b(i12, n10);
                            }
                        }
                        object4 = new sy_0(dArray9, false);
                        object11 = nArray4;
                        object12 = new int[nArray4.length];
                        for (n11 = 0; n11 < ((Object)object11).length; ++n11) {
                            object12[object11[n11]] = n11;
                        }
                        object11 = object12;
                        double d14 = 0.33999999999999997 / yC.c((tq_0)(object4 = yC.a((tq_0)object4, (int[])object11))).c(((yC)object).x).b(0, 0);
                        if (d7 > d14) {
                            d7 = d14;
                        }
                        object7 = yC.b((tq_0)object7, yC.a((tq_0)object4, ((yC)object).l, 1));
                        object7 = ((yC)object).O.c((tq_0)object7);
                        object7 = object7.c(yC.e(((yC)object).x)).c(object7.d());
                        ((yC)object).Q = ((yC)object).Q.b(d12 += d7 * 0.5).a(tq_02).a(object6.b(((yC)object).E + d7 * 0.5).c(yC.b(yC.a(((yC)object).x, 1, ((yC)object).l), object6.d()))).b(object7.b(d7));
                    } else {
                        ((yC)object).Q = ((yC)object).Q.b(d12).a(tq_02).a(object6.b(((yC)object).E).c(yC.b(yC.a(((yC)object).x, 1, ((yC)object).l), object6.d())));
                    }
                }
                double d15 = d7;
                Object object13 = object;
                if (((yC)object9).D + ((yC)object13).E + d15 > 0.0 && (double)((yC)object13).S % 1.0 / (((yC)object13).D + ((yC)object13).E + d15) / (double)((yC)object13).l / 10.0 < 1.0) {
                    ((yC)object13).Q = yC.a(((yC)object13).Q, 0).a(yC.a(((yC)object13).Q, 1).d());
                    sN sN2 = new sN(((yC)object13).Q);
                    ((yC)object13).M = sN2.a();
                    ((yC)object13).N = sN2.b();
                    ((yC)object13).P = yC.e(((yC)object13).N);
                    if (yC.g(((yC)object13).P) <= 0.0) {
                        for (n10 = 0; n10 < ((yC)object13).l; ++n10) {
                            if (!(((yC)object13).P.b(n10, 0) < 0.0)) continue;
                            ((yC)object13).P.c(n10, 0, 0.0);
                        }
                        double d16 = yC.f(((yC)object13).P) / 1.0E14;
                        ((yC)object13).Q = ((yC)object13).Q.a(yC.b(((yC)object13).l, ((yC)object13).l).b(d16));
                        ((yC)object13).P = ((yC)object13).P.a(yC.a(((yC)object13).l, 1).b(d16));
                    }
                    if (yC.f(((yC)object13).P) > 1.0E14 * yC.g(((yC)object13).P)) {
                        double d17 = yC.f(((yC)object13).P) / 1.0E14 - yC.g(((yC)object13).P);
                        ((yC)object13).Q = ((yC)object13).Q.a(yC.b(((yC)object13).l, ((yC)object13).l).b(d17));
                        ((yC)object13).P = ((yC)object13).P.a(yC.a(((yC)object13).l, 1).b(d17));
                    }
                    ((yC)object13).R = yC.e(((yC)object13).Q);
                    ((yC)object13).P = yC.b(((yC)object13).P);
                    ((yC)object13).O = yC.b(((yC)object13).M, yC.a(((yC)object13).P.d(), ((yC)object13).l, 1));
                }
            } else {
                object2 = object7;
                bl = bl4;
                object = this;
                double d18 = bl ? 0.0 : ((yC)object).G * ((yC)object).A * (2.0 - ((yC)object).A);
                d18 = d18 + (1.0 - ((yC)object).G - ((yC)object).H);
                ((yC)object).R = ((yC)object).R.b(d18).a(yC.c(((yC)object).J).b(((yC)object).G)).a(yC.b(((yC)object).R, yC.c((tq_0)object2).c(((yC)object).x)).b(((yC)object).H));
                ((yC)object).P = yC.b(((yC)object).R);
                if (((yC)object).m > 1 && ((yC)object).S > ((yC)object).m) {
                    ((yC)object).m = 0;
                    ((yC)object).M = yC.b(((yC)object).l, ((yC)object).l);
                    ((yC)object).O = yC.e(((yC)object).P);
                    ((yC)object).Q = yC.e(((yC)object).R);
                }
            }
            this.z *= BY.i(BY.d(1.0, (this.L / this.F - 1.0) * this.B / this.C));
            double d19 = dArray5[nArray[0]];
            double d20 = dArray5[nArray[nArray.length - 1]];
            if (d11 > d19) {
                d11 = d19;
                object5 = object3;
                double[] dArray10 = sy_05.g(0);
                object = b2;
                object3 = new yp_0(((b)object).c(dArray10), this.n ? d19 : -d19);
                if (this.c() != null && this.c().a(this.S, (yp_0)object3, (yp_0)object5)) break;
            }
            if (this.q != 0.0 && d19 < (this.n ? this.q : -this.q)) break;
            object6 = yC.b(this.R).g(0);
            object7 = this.J.g(0);
            for (n5 = 0; n5 < this.l && !(this.z * BY.e(BY.w((double)object7[n5]), (double)object6[n5]) > this.s); ++n5) {
                if (n5 >= this.l - 1) break block9;
            }
            for (n5 = 0; n5 < this.l; ++n5) {
                if (this.z * object6[n5] > this.r) break block9;
            }
            object = this.T;
            double d21 = Double.MAX_VALUE;
            for (n4 = 0; n4 < ((Object)object).length; ++n4) {
                if (!(d21 > object[n4])) continue;
                d21 = (double)object[n4];
            }
            double d22 = d21;
            object = this.T;
            d21 = -1.7976931348623157E308;
            for (n4 = 0; n4 < ((Object)object).length; ++n4) {
                if (!(d21 < object[n4])) continue;
                d21 = (double)object[n4];
            }
            Object object14 = d21;
            if (this.S > 2 && BY.e(object14, d20) - BY.d(d22, d19) < this.t || this.S > this.T.length && object14 - d22 < this.u || yC.f(this.P) / yC.g(this.P) > 1.0E7) break;
            if (this.c() != null) {
                object6 = new yp_0(sy_05.g(0), this.n ? d19 : -d19);
                if (object5 != null && this.c().a(this.S, (yp_0)object6, (yp_0)object5)) break;
                object5 = object6;
            }
            if (d11 == dArray5[nArray[(int)(0.1 + (double)this.h / 4.0)]]) {
                this.z *= BY.i(0.2 + this.B / this.C);
            }
            if (this.S > 2 && BY.e(object14, d19) - BY.d(d22, d19) == 0.0) {
                this.z *= BY.i(0.2 + this.B / this.C);
            }
            yC.a(this.T, d19);
            d21 = d20 - d19;
            object = b2;
            b2.a = d21;
            if (this.o) {
                this.W.add(this.z);
                this.Y.add(d19);
                this.X.add(this.I.d());
                this.Z.add(this.P.d().b(100000.0));
            }
            ++this.S;
        }
        return object3;
    }

    private void a(yo_0 ... yo_0Array) {
        for (yo_0 yo_02 : yo_0Array) {
            if (yo_02 instanceof d) {
                this.k = ((d)yo_02).a();
                continue;
            }
            if (!(yo_02 instanceof c)) continue;
            yo_02 = (c)yo_02;
            this.h = ((c)yo_02).a;
        }
    }

    private void m() {
        double[] dArray = this.f();
        double[] dArray2 = this.g();
        double[] dArray3 = this.h();
        if (this.k != null) {
            if (this.k.length != dArray.length) {
                throw new oS(this.k.length, dArray.length);
            }
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                if (this.k[i2] < 0.0) {
                    throw new pj_0(this.k[i2]);
                }
                if (!(this.k[i2] > dArray3[i2] - dArray2[i2])) continue;
                throw new po_0(this.k[i2], (Number)0, dArray3[i2] - dArray2[i2]);
            }
        }
    }

    private void b(double[] dArray) {
        int n2;
        if (this.h <= 0) {
            this.h = 4 + (int)(3.0 * BY.k(this.l));
        }
        double[][] dArray2 = new double[dArray.length][1];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray2[i2][0] = this.k == null ? 0.3 : this.k[i2];
        }
        sy_0 sy_02 = new sy_0(dArray2, false);
        this.z = yC.f(sy_02);
        this.r = 1000.0 * yC.f(sy_02);
        this.s = 1.0E-11 * yC.f(sy_02);
        this.t = 1.0E-12;
        this.u = 1.0E-13;
        this.v = this.h / 2;
        this.w = BY.k((double)this.v + 0.5);
        this.x = yC.a(yC.a(1.0, (double)this.v, 1.0)).b(-1.0).a(this.w);
        double d2 = 0.0;
        double d3 = 0.0;
        for (n2 = 0; n2 < this.v; ++n2) {
            double d4 = this.x.b(n2, 0);
            d2 += d4;
            double d5 = d4;
            d3 += d5 * d5;
        }
        this.x = this.x.b(1.0 / d2);
        double d6 = d2;
        this.y = d6 * d6 / d3;
        this.A = (4.0 + this.y / (double)this.l) / ((double)(this.l + 4) + 2.0 * this.y / (double)this.l);
        this.B = (this.y + 2.0) / ((double)this.l + this.y + 3.0);
        this.C = (1.0 + 2.0 * BY.e(0.0, BY.a((this.y - 1.0) / (double)(this.l + 1)) - 1.0)) * BY.e(0.3, 1.0 - (double)this.l / (1.0E-6 + (double)this.p)) + this.B;
        this.D = 2.0 / (((double)this.l + 1.3) * ((double)this.l + 1.3) + this.y);
        this.E = BY.d(1.0 - this.D, 2.0 * (this.y - 2.0 + 1.0 / this.y) / ((double)((this.l + 2) * (this.l + 2)) + this.y));
        this.G = BY.d(1.0, this.D * ((double)this.l + 1.5) / 3.0);
        this.H = BY.d(1.0 - this.D, this.E * ((double)this.l + 1.5) / 3.0);
        this.F = BY.a((double)this.l) * (1.0 - 1.0 / (4.0 * (double)this.l) + 1.0 / (21.0 * (double)this.l * (double)this.l));
        this.I = td_0.c(dArray);
        this.P = sy_02.b(1.0 / this.z);
        this.R = yC.c(this.P);
        this.J = yC.c(this.l, 1);
        this.K = yC.c(this.l, 1);
        this.L = this.K.c();
        this.M = yC.b(this.l, this.l);
        this.N = yC.a(this.l, 1);
        this.O = yC.b(this.M, yC.a(this.P.d(), this.l, 1));
        this.Q = this.M.c(yC.e(yC.c(this.N)).c(this.M.d()));
        this.U = 10 + (int)((double)(30 * this.l) / (double)this.h);
        this.T = new double[this.U];
        for (n2 = 0; n2 < this.U; ++n2) {
            this.T[n2] = Double.MAX_VALUE;
        }
    }

    private boolean a(tq_0 tq_02, tq_0 tq_03) {
        this.K = this.K.b(1.0 - this.B).a(this.M.c(tq_02).b(BY.a(this.B * (2.0 - this.B) * this.y)));
        this.L = this.K.c();
        boolean bl = this.L / BY.a(1.0 - BY.a(1.0 - this.B, 2 * this.S)) / this.F < 1.4 + 2.0 / ((double)this.l + 1.0);
        this.J = this.J.b(1.0 - this.A);
        if (bl) {
            this.J = this.J.a(this.I.b(tq_03).b(BY.a(this.A * (2.0 - this.A) * this.y) / this.z));
        }
        return bl;
    }

    private void a(boolean bl, tq_0 tq_02) {
        double d2 = bl ? 0.0 : this.G * this.A * (2.0 - this.A);
        d2 = d2 + (1.0 - this.G - this.H);
        this.R = this.R.b(d2).a(yC.c(this.J).b(this.G)).a(yC.b(this.R, yC.c(tq_02).c(this.x)).b(this.H));
        this.P = yC.b(this.R);
        if (this.m > 1 && this.S > this.m) {
            this.m = 0;
            this.M = yC.b(this.l, this.l);
            this.O = yC.e(this.P);
            this.Q = yC.e(this.R);
        }
    }

    private void a(boolean bl, tq_0 tq_02, tq_0 tq_03, int[] nArray, tq_0 tq_04) {
        double d2 = 0.0;
        if (this.D + this.E > 0.0) {
            tq_02 = tq_02.b(yC.a(tq_04, 1, this.v)).b(1.0 / this.z);
            tq_04 = this.J.c(this.J.d()).b(this.D);
            double d3 = bl ? 0.0 : this.D * this.A * (2.0 - this.A);
            d3 = d3 + (1.0 - this.D - this.E);
            if (this.i) {
                d2 = (1.0 - this.E) * 0.25 * this.y / (BY.a((double)(this.l + 2), 1.5) + 2.0 * this.y);
                Object object = yC.b(nArray);
                sy_0 sy_02 = yC.a(tq_03, ch_0.a((int[])object, this.v));
                object = sy_02;
                tq_03 = yC.b(yC.d(yC.c(sy_02)));
                nArray = yC.c(tq_03.f(0));
                sy_0 sy_03 = yC.a(tq_03, nArray);
                int[] nArray2 = yC.b(nArray);
                tq_03 = yC.a(tq_03, nArray2);
                tq_03 = yC.c(tq_03, sy_03);
                double d4 = 0.33999999999999997 / yC.c(tq_03 = yC.a(tq_03, nArray = yC.a(nArray))).c(this.x).b(0, 0);
                if (d2 > d4) {
                    d2 = d4;
                }
                object = yC.b((tq_0)object, yC.a(tq_03, this.l, 1));
                tq_0 tq_05 = this.O.c((tq_0)object);
                object = tq_05;
                object = tq_05.c(yC.e(this.x)).c(object.d());
                this.Q = this.Q.b(d3 += d2 * 0.5).a(tq_04).a(tq_02.b(this.E + d2 * 0.5).c(yC.b(yC.a(this.x, 1, this.l), tq_02.d()))).b(object.b(d2));
            } else {
                this.Q = this.Q.b(d3).a(tq_04).a(tq_02.b(this.E).c(yC.b(yC.a(this.x, 1, this.l), tq_02.d())));
            }
        }
        this.a(d2);
    }

    private void a(double d2) {
        if (this.D + this.E + d2 > 0.0 && (double)this.S % 1.0 / (this.D + this.E + d2) / (double)this.l / 10.0 < 1.0) {
            double d3;
            this.Q = yC.a(this.Q, 0).a(yC.a(this.Q, 1).d());
            sN sN2 = new sN(this.Q);
            this.M = sN2.a();
            this.N = sN2.b();
            this.P = yC.e(this.N);
            if (yC.g(this.P) <= 0.0) {
                for (int i2 = 0; i2 < this.l; ++i2) {
                    if (!(this.P.b(i2, 0) < 0.0)) continue;
                    this.P.c(i2, 0, 0.0);
                }
                d3 = yC.f(this.P) / 1.0E14;
                this.Q = this.Q.a(yC.b(this.l, this.l).b(d3));
                this.P = this.P.a(yC.a(this.l, 1).b(d3));
            }
            if (yC.f(this.P) > 1.0E14 * yC.g(this.P)) {
                d3 = yC.f(this.P) / 1.0E14 - yC.g(this.P);
                this.Q = this.Q.a(yC.b(this.l, this.l).b(d3));
                this.P = this.P.a(yC.a(this.l, 1).b(d3));
            }
            this.R = yC.e(this.Q);
            this.P = yC.b(this.P);
            this.O = yC.b(this.M, yC.a(this.P.d(), this.l, 1));
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
            dArray[i2] = this.V.nextGaussian();
        }
        return dArray;
    }

    private sy_0 d(int n2, int n3) {
        double[][] dArray = new double[n2][n3];
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                dArray[i2][i3] = this.V.nextGaussian();
            }
        }
        return new sy_0(dArray, false);
    }

    final class b {
        double a = 1.0;
        private final boolean c;

        b() {
            this.c = true;
        }

        public final double a(double[] object) {
            double d2;
            if (this.c) {
                double[] dArray = this.c((double[])object);
                double d3 = yC.this.a(dArray);
                double[] dArray2 = dArray;
                dArray = object;
                object = this;
                double d4 = 0.0;
                for (int i2 = 0; i2 < dArray.length; ++i2) {
                    double d5 = BY.w(dArray[i2] - dArray2[i2]);
                    d4 += d5 * object.a;
                }
                d2 = d3 + (object.yC.this.n ? d4 : -d4);
            } else {
                d2 = yC.this.a((double[])object);
            }
            if (yC.this.n) {
                return d2;
            }
            return -d2;
        }

        public final boolean b(double[] dArray) {
            double[] dArray2 = yC.this.g();
            double[] dArray3 = yC.this.h();
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                if (dArray[i2] < dArray2[i2]) {
                    return false;
                }
                if (!(dArray[i2] > dArray3[i2])) continue;
                return false;
            }
            return true;
        }

        public final void a(double d2) {
            this.a = d2;
        }

        double[] c(double[] dArray) {
            double[] dArray2 = yC.this.g();
            double[] dArray3 = yC.this.h();
            double[] dArray4 = new double[dArray.length];
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                dArray4[i2] = dArray[i2] < dArray2[i2] ? dArray2[i2] : (dArray[i2] > dArray3[i2] ? dArray3[i2] : dArray[i2]);
            }
            return dArray4;
        }

        private double a(double[] dArray, double[] dArray2) {
            double d2 = 0.0;
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                double d3 = BY.w(dArray[i2] - dArray2[i2]);
                d2 += d3 * this.a;
            }
            if (yC.this.n) {
                return d2;
            }
            return -d2;
        }

        static /* synthetic */ double[] a(b b2, double[] dArray) {
            return b2.c(dArray);
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
    implements yo_0 {
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
    implements yo_0 {
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

