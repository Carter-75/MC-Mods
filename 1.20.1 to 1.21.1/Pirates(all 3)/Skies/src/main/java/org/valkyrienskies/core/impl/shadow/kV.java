/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.kQ;
import org.valkyrienskies.core.impl.shadow.kR;
import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.kX;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.lN;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lf_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.lk_0;
import org.valkyrienskies.core.impl.shadow.ll_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class kV {
    private kV() {
    }

    private static 1 a(lc_0 ... lc_0Array) {
        return new lc_0(lc_0Array){
            private /* synthetic */ lc_0[] a;
            {
                this.a = lc_0Array;
            }

            public final double a(double d2) {
                double d3 = d2;
                for (int i2 = this.a.length - 1; i2 >= 0; --i2) {
                    d3 = this.a[i2].a(d3);
                }
                return d3;
            }
        };
    }

    private static 12 a(ln_0 ... ln_0Array) {
        return new ln_0(ln_0Array){
            private /* synthetic */ ln_0[] a;
            {
                this.a = ln_0Array;
            }

            public final double a(double d2) {
                double d3 = d2;
                for (int i2 = this.a.length - 1; i2 >= 0; --i2) {
                    d3 = this.a[i2].a(d3);
                }
                return d3;
            }

            public final lg_0 a(lg_0 lg_02) {
                for (int i2 = this.a.length - 1; i2 >= 0; --i2) {
                    lg_02 = this.a[i2].a(lg_02);
                }
                return lg_02;
            }
        };
    }

    @Deprecated
    private static 13 a(final kS ... kSArray) {
        return new kS(){

            public final double a(double d2) {
                double d3 = d2;
                for (int i2 = kSArray.length - 1; i2 >= 0; --i2) {
                    d3 = kSArray[i2].a(d3);
                }
                return d3;
            }

            public final lc_0 a() {
                return new lc_0(this){
                    private /* synthetic */ 13 a;
                    {
                        this.a = var1_1;
                    }

                    public final double a(double d2) {
                        double d3 = 1.0;
                        double d4 = d2;
                        for (int i2 = this.a.kSArray.length - 1; i2 >= 0; --i2) {
                            d3 *= this.a.kSArray[i2].a().a(d4);
                            d4 = this.a.kSArray[i2].a(d4);
                        }
                        return d3;
                    }
                };
            }
        };
    }

    private static 14 b(lc_0 ... lc_0Array) {
        return new lc_0(lc_0Array){
            private /* synthetic */ lc_0[] a;
            {
                this.a = lc_0Array;
            }

            public final double a(double d2) {
                double d3 = this.a[0].a(d2);
                for (int i2 = 1; i2 < this.a.length; ++i2) {
                    d3 += this.a[i2].a(d2);
                }
                return d3;
            }
        };
    }

    private static 15 b(ln_0 ... ln_0Array) {
        return new ln_0(ln_0Array){
            private /* synthetic */ ln_0[] a;
            {
                this.a = ln_0Array;
            }

            public final double a(double d2) {
                double d3 = this.a[0].a(d2);
                for (int i2 = 1; i2 < this.a.length; ++i2) {
                    d3 += this.a[i2].a(d2);
                }
                return d3;
            }

            public final lg_0 a(lg_0 lg_02) {
                lg_0 lg_03 = this.a[0].a(lg_02);
                for (int i2 = 1; i2 < this.a.length; ++i2) {
                    lg_03 = lg_03.a(this.a[i2].a(lg_02));
                }
                return lg_03;
            }
        };
    }

    @Deprecated
    private static 16 b(final kS ... kSArray) {
        return new kS(){

            public final double a(double d2) {
                double d3 = kSArray[0].a(d2);
                for (int i2 = 1; i2 < kSArray.length; ++i2) {
                    d3 += kSArray[i2].a(d2);
                }
                return d3;
            }

            public final lc_0 a() {
                return new lc_0(this){
                    private /* synthetic */ 16 a;
                    {
                        this.a = var1_1;
                    }

                    public final double a(double d2) {
                        double d3 = this.a.kSArray[0].a().a(d2);
                        for (int i2 = 1; i2 < this.a.kSArray.length; ++i2) {
                            d3 += this.a.kSArray[i2].a().a(d2);
                        }
                        return d3;
                    }
                };
            }
        };
    }

    private static 17 c(lc_0 ... lc_0Array) {
        return new lc_0(lc_0Array){
            private /* synthetic */ lc_0[] a;
            {
                this.a = lc_0Array;
            }

            public final double a(double d2) {
                double d3 = this.a[0].a(d2);
                for (int i2 = 1; i2 < this.a.length; ++i2) {
                    d3 *= this.a[i2].a(d2);
                }
                return d3;
            }
        };
    }

    private static 18 c(ln_0 ... ln_0Array) {
        return new ln_0(ln_0Array){
            private /* synthetic */ ln_0[] a;
            {
                this.a = ln_0Array;
            }

            public final double a(double d2) {
                double d3 = this.a[0].a(d2);
                for (int i2 = 1; i2 < this.a.length; ++i2) {
                    d3 *= this.a[i2].a(d2);
                }
                return d3;
            }

            public final lg_0 a(lg_0 lg_02) {
                lg_0 lg_03 = this.a[0].a(lg_02);
                for (int i2 = 1; i2 < this.a.length; ++i2) {
                    lg_03 = lg_03.b(this.a[i2].a(lg_02));
                }
                return lg_03;
            }
        };
    }

    @Deprecated
    private static 19 c(final kS ... kSArray) {
        return new kS(){

            public final double a(double d2) {
                double d3 = kSArray[0].a(d2);
                for (int i2 = 1; i2 < kSArray.length; ++i2) {
                    d3 *= kSArray[i2].a(d2);
                }
                return d3;
            }

            public final lc_0 a() {
                return new lc_0(this){
                    private /* synthetic */ 19 a;
                    {
                        this.a = var1_1;
                    }

                    public final double a(double d2) {
                        double d3 = 0.0;
                        for (int i2 = 0; i2 < this.a.kSArray.length; ++i2) {
                            double d4 = this.a.kSArray[i2].a().a(d2);
                            for (int i3 = 0; i3 < this.a.kSArray.length; ++i3) {
                                if (i2 == i3) continue;
                                d4 *= this.a.kSArray[i3].a(d2);
                            }
                            d3 += d4;
                        }
                        return d3;
                    }
                };
            }
        };
    }

    private static 2 a(kP kP2, lc_0 lc_02, lc_0 lc_03) {
        return new lc_0(kP2, lc_02, lc_03){
            private /* synthetic */ kP a;
            private /* synthetic */ lc_0 b;
            private /* synthetic */ lc_0 c;
            {
                this.a = kP2;
                this.b = lc_02;
                this.c = lc_03;
            }

            public final double a(double d2) {
                return this.a.a(this.b.a(d2), this.c.a(d2));
            }
        };
    }

    private static 3 a(kP kP2, lN lN2, double d2) {
        return new kW(kP2, d2, lN2){
            private /* synthetic */ kP a;
            private /* synthetic */ double b;
            private /* synthetic */ lc_0 c;
            {
                this.a = kP2;
                this.b = d2;
                this.c = lc_02;
            }

            public final double a(double[] dArray) {
                double d2 = this.a.a(this.b, this.c.a(dArray[0]));
                for (int i2 = 1; i2 < dArray.length; ++i2) {
                    d2 = this.a.a(d2, this.c.a(dArray[i2]));
                }
                return d2;
            }
        };
    }

    private static kW b(kP kP2, double d2) {
        double d3 = d2;
        lN lN2 = new lN();
        return new /* invalid duplicate definition of identical inner class */;
    }

    private static 4 c(kP kP2, double d2) {
        return new lc_0(kP2, d2){
            private /* synthetic */ kP a;
            private /* synthetic */ double b;
            {
                this.a = kP2;
                this.b = d2;
            }

            public final double a(double d2) {
                return this.a.a(this.b, d2);
            }
        };
    }

    public static 5 a(kP kP2, double d2) {
        return new lc_0(kP2, d2){
            private /* synthetic */ kP a;
            private /* synthetic */ double b;
            {
                this.a = kP2;
                this.b = d2;
            }

            public final double a(double d2) {
                return this.a.a(d2, this.b);
            }
        };
    }

    public static double[] a(lc_0 lc_02, double d2, double d3, int n2) {
        if (n2 <= 0) {
            throw new pk_0(px_0.NOT_POSITIVE_NUMBER_OF_SAMPLES, n2);
        }
        if (d2 >= d3) {
            throw new pm_0(d2, (Number)d3, false);
        }
        double[] dArray = new double[n2];
        double d4 = (d3 - d2) / (double)n2;
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = lc_02.a(d2 + (double)i2 * d4);
        }
        return dArray;
    }

    @Deprecated
    public static 6 a(final ln_0 ln_02) {
        return new kS(){

            public final double a(double d2) {
                return ln_02.a(d2);
            }

            public final lc_0 a() {
                return new lc_0(this){
                    private /* synthetic */ 6 a;
                    {
                        this.a = var1_1;
                    }

                    public final double a(double d2) {
                        return this.a.ln_02.a(new lg_0(1, 1, 0, d2)).a(new int[]{1});
                    }
                };
            }
        };
    }

    @Deprecated
    private static 7 a(kS kS2) {
        return new ln_0(kS2){
            private /* synthetic */ kS a;
            {
                this.a = kS2;
            }

            public final double a(double d2) {
                return this.a.a(d2);
            }

            public final lg_0 a(lg_0 lg_02) {
                lg_0 lg_03 = lg_02;
                lf_0 lf_02 = lg_03.a;
                switch (lf_02.b) {
                    case 0: {
                        lg_03 = lg_02;
                        lf_02 = lg_03.a;
                        lg_03 = lg_02;
                        return new lg_0(lf_02.a, 0, this.a.a(lg_03.b[0]));
                    }
                    case 1: {
                        lg_03 = lg_02;
                        lf_02 = lg_03.a;
                        int n2 = lf_02.a;
                        double[] dArray = new double[n2 + 1];
                        double[] dArray2 = dArray;
                        lg_03 = lg_02;
                        dArray[0] = this.a.a(lg_03.b[0]);
                        lg_03 = lg_02;
                        double d2 = this.a.a().a(lg_03.b[0]);
                        int[] nArray = new int[n2];
                        for (int i2 = 0; i2 < n2; ++i2) {
                            nArray[i2] = 1;
                            dArray2[i2 + 1] = d2 * lg_02.a(nArray);
                            nArray[i2] = 0;
                        }
                        return new lg_0(n2, 1, dArray2);
                    }
                }
                lg_03 = lg_02;
                lf_02 = lg_03.a;
                throw new pm_0(lf_02.b, (Number)1, true);
            }
        };
    }

    @Deprecated
    public static 8 a(final lk_0 lk_02) {
        return new kQ(){

            public final double a(double[] dArray) {
                return lk_02.a(dArray);
            }

            public final 1 a(int n2) {
                return new kW(this, n2){
                    private /* synthetic */ int a;
                    private /* synthetic */ 8 b;
                    {
                        this.b = var1_1;
                        this.a = n2;
                    }

                    public final double a(double[] dArray) {
                        int n2 = dArray.length;
                        lg_0[] lg_0Array = new lg_0[n2];
                        for (int i2 = 0; i2 < n2; ++i2) {
                            lg_0Array[i2] = i2 == this.a ? new lg_0(1, 1, 0, dArray[i2]) : new lg_0(1, 1, dArray[i2]);
                        }
                        lg_0 lg_02 = this.b.lk_02.a(lg_0Array);
                        return lg_02.a(new int[]{1});
                    }
                };
            }

            public final 2 a() {
                return new kY(this){
                    private /* synthetic */ 8 a;
                    {
                        this.a = var1_1;
                    }

                    public final double[] a(double[] dArray) {
                        int n2 = dArray.length;
                        Object[] objectArray = new lg_0[n2];
                        for (int i2 = 0; i2 < n2; ++i2) {
                            objectArray[i2] = new lg_0(n2, 1, i2, dArray[i2]);
                        }
                        lg_0 lg_02 = this.a.lk_02.a((lg_0[])objectArray);
                        dArray = new double[n2];
                        objectArray = new int[n2];
                        for (int i3 = 0; i3 < n2; ++i3) {
                            objectArray[i3] = (lg_0)true;
                            dArray[i3] = lg_02.a((int[])objectArray);
                            objectArray[i3] = (lg_0)false;
                        }
                        return dArray;
                    }
                };
            }
        };
    }

    @Deprecated
    private static 9 a(kQ kQ2) {
        return new lk_0(kQ2){
            private /* synthetic */ kQ a;
            {
                this.a = kQ2;
            }

            public final double a(double[] dArray) {
                return this.a.a(dArray);
            }

            public final lg_0 a(lg_0[] lg_0Array) {
                lg_0 lg_02 = lg_0Array[0];
                lf_0 lf_02 = lg_02.a;
                int n2 = lf_02.a;
                lg_02 = lg_0Array[0];
                lf_02 = lg_02.a;
                int n3 = lf_02.b;
                int n4 = lg_0Array.length;
                if (n3 > 1) {
                    throw new pm_0(n3, (Number)1, true);
                }
                for (int i2 = 0; i2 < n4; ++i2) {
                    lg_02 = lg_0Array[i2];
                    lf_02 = lg_02.a;
                    if (lf_02.a != n2) {
                        lg_02 = lg_0Array[i2];
                        lf_02 = lg_02.a;
                        throw new oS(lf_02.a, n2);
                    }
                    lg_02 = lg_0Array[i2];
                    lf_02 = lg_02.a;
                    if (lf_02.b == n3) continue;
                    lg_02 = lg_0Array[i2];
                    lf_02 = lg_02.a;
                    throw new oS(lf_02.b, n3);
                }
                double[] dArray = new double[n4];
                for (int i3 = 0; i3 < n4; ++i3) {
                    lg_02 = lg_0Array[i3];
                    dArray[i3] = lg_02.b[0];
                }
                double d2 = this.a.a(dArray);
                dArray = this.a.a().a(dArray);
                double[] dArray2 = new double[n2 + 1];
                double[] dArray3 = dArray2;
                dArray2[0] = d2;
                int[] nArray = new int[n2];
                for (int i4 = 0; i4 < n2; ++i4) {
                    nArray[i4] = 1;
                    for (int i5 = 0; i5 < n4; ++i5) {
                        int n5 = i4 + 1;
                        dArray3[n5] = dArray3[n5] + dArray[i5] * lg_0Array[i5].a(nArray);
                    }
                    nArray[i4] = 0;
                }
                return new lg_0(n2, n3, dArray3);
            }
        };
    }

    @Deprecated
    public static 10 a(final ll_0 ll_02) {
        return new kR(){

            public final double[] a(double[] dArray) {
                return ll_02.a(dArray);
            }

            public final kX a() {
                return new kX(this){
                    private /* synthetic */ 10 a;
                    {
                        this.a = var1_1;
                    }

                    public final double[][] a(double[] object) {
                        int n2 = ((double[])object).length;
                        Object[] objectArray = new lg_0[n2];
                        for (int i2 = 0; i2 < n2; ++i2) {
                            objectArray[i2] = new lg_0(n2, 1, i2, object[i2]);
                        }
                        lg_0[] lg_0Array = this.a.ll_02.a((lg_0[])objectArray);
                        object = new double[lg_0Array.length][n2];
                        objectArray = new int[n2];
                        for (int i3 = 0; i3 < lg_0Array.length; ++i3) {
                            for (int i4 = 0; i4 < n2; ++i4) {
                                objectArray[i4] = (lg_0)true;
                                object[i3][i4] = lg_0Array[i3].a((int[])objectArray);
                                objectArray[i4] = (lg_0)false;
                            }
                        }
                        return object;
                    }
                };
            }
        };
    }

    @Deprecated
    public static 11 a(kR kR2) {
        return new ll_0(kR2){
            private /* synthetic */ kR a;
            {
                this.a = kR2;
            }

            public final double[] a(double[] dArray) {
                return this.a.a(dArray);
            }

            public final lg_0[] a(lg_0[] lg_0Array) {
                lg_0[] lg_0Array2 = lg_0Array[0];
                lf_0 lf_02 = lg_0Array2.a;
                int n2 = lf_02.a;
                lg_0Array2 = lg_0Array[0];
                lf_02 = lg_0Array2.a;
                int n3 = lf_02.b;
                int n4 = lg_0Array.length;
                if (n3 > 1) {
                    throw new pm_0(n3, (Number)1, true);
                }
                for (int i2 = 0; i2 < n4; ++i2) {
                    lg_0Array2 = lg_0Array[i2];
                    lf_02 = lg_0Array2.a;
                    if (lf_02.a != n2) {
                        lg_0Array2 = lg_0Array[i2];
                        lf_02 = lg_0Array2.a;
                        throw new oS(lf_02.a, n2);
                    }
                    lg_0Array2 = lg_0Array[i2];
                    lf_02 = lg_0Array2.a;
                    if (lf_02.b == n3) continue;
                    lg_0Array2 = lg_0Array[i2];
                    lf_02 = lg_0Array2.a;
                    throw new oS(lf_02.b, n3);
                }
                Object object = new double[n4];
                for (int i3 = 0; i3 < n4; ++i3) {
                    lg_0Array2 = lg_0Array[i3];
                    object[i3] = lg_0Array2.b[0];
                }
                double[] dArray = this.a.a((double[])object);
                object = this.a.a().a((double[])object);
                lg_0Array2 = new lg_0[dArray.length];
                for (int i4 = 0; i4 < lg_0Array2.length; ++i4) {
                    double[] dArray2 = new double[n2 + 1];
                    double[] dArray3 = dArray2;
                    dArray2[0] = dArray[i4];
                    int[] nArray = new int[n2];
                    for (int i5 = 0; i5 < n2; ++i5) {
                        nArray[i5] = 1;
                        for (int i6 = 0; i6 < n4; ++i6) {
                            int n5 = i5 + 1;
                            dArray3[n5] = dArray3[n5] + object[i4][i6] * lg_0Array[i6].a(nArray);
                        }
                        nArray[i5] = 0;
                    }
                    lg_0Array2[i4] = new lg_0(n2, n3, dArray3);
                }
                return lg_0Array2;
            }
        };
    }
}

