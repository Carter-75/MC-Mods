/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ah_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.oA;
import org.valkyrienskies.core.impl.shadow.oB;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oz_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

public final class oQ {
    private static final int a = 1000;
    private static final double b = 1.0E-5;
    private final double[][] c;
    private oz_0 d;
    private double e = 0.0;

    private oQ(double[][] dArray) {
        if (dArray.length <= 0) {
            throw new pk_0(dArray.length);
        }
        this.c = new double[dArray.length][dArray[0].length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (dArray[i2].length != dArray[0].length) {
                throw new oS(dArray[i2].length, dArray[0].length);
            }
            if (dArray[i2].length < 2) {
                throw new pn_0((pw_0)px_0.NUMBER_TOO_SMALL, (Number)dArray[i2].length, 2, true);
            }
            this.c[i2] = ch_0.a(dArray[i2], dArray[i2].length);
        }
    }

    private void a(oz_0 object, int n2, double d2) {
        n2 = this.c.length;
        int n3 = this.c[0].length;
        int n4 = ((oA)object).c().size();
        Object object2 = ((oA)object).c().get(0);
        int n5 = ((oB)((co_0)object2).b).c().length;
        if (n5 != n3) {
            throw new oS(n5, n3);
        }
        n5 = 0;
        double d3 = 0.0;
        this.e = Double.NEGATIVE_INFINITY;
        this.d = new oz_0(((oA)object).c());
        while (n5++ <= 1000 && BY.w(d3 - this.e) > 1.0E-5) {
            int n6;
            int n7;
            d3 = this.e;
            double d4 = 0.0;
            object = this.d.c();
            Object object3 = new double[n4];
            oB[] oBArray = new oB[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                object2 = (co_0)object.get(i2);
                object3[i2] = (Double)((co_0)object2).a;
                object2 = (co_0)object.get(i2);
                oBArray[i2] = (oB)((co_0)object2).b;
            }
            double[][] dArray = new double[n2][n4];
            object = new double[n4];
            object2 = new double[n4][n3];
            for (int i3 = 0; i3 < n2; ++i3) {
                double d5 = this.d.a(this.c[i3]);
                d4 += BY.k(d5);
                for (n7 = 0; n7 < n4; ++n7) {
                    dArray[i3][n7] = object3[n7] * oBArray[n7].a(this.c[i3]) / d5;
                    Object object4 = object;
                    int n8 = n7;
                    object4[n8] = object4[n8] + dArray[i3][n7];
                    for (n6 = 0; n6 < n3; ++n6) {
                        Object object5 = object2[n7];
                        int n9 = n6;
                        object5[n9] = object5[n9] + dArray[i3][n7] * this.c[i3][n6];
                    }
                }
            }
            this.e = d4 / (double)n2;
            double[] dArray2 = new double[n4];
            double[][] dArray3 = new double[n4][n3];
            for (int i4 = 0; i4 < n4; ++i4) {
                dArray2[i4] = (double)(object[i4] / (double)n2);
                for (n7 = 0; n7 < n3; ++n7) {
                    dArray3[i4][n7] = (double)(object2[i4][n7] / object[i4]);
                }
            }
            tq_0[] tq_0Array = new tq_0[n4];
            for (n7 = 0; n7 < n4; ++n7) {
                int n10 = n3;
                tq_0Array[n7] = new sy_0(n10, n10);
            }
            for (n7 = 0; n7 < n2; ++n7) {
                for (n6 = 0; n6 < n4; ++n6) {
                    sy_0 sy_02 = new sy_0(ch_0.a(this.c[n7], dArray3[n6]));
                    object3 = sy_02;
                    object3 = sy_02.c(object3.d()).b(dArray[n7][n6]);
                    tq_0Array[n6] = tq_0Array[n6].a((tq_0)object3);
                }
            }
            int n11 = n3;
            double[][][] dArray4 = new double[n4][n11][n11];
            for (n6 = 0; n6 < n4; ++n6) {
                tq_0Array[n6] = tq_0Array[n6].b(1.0 / object[n6]);
                dArray4[n6] = tq_0Array[n6].a();
            }
            this.d = new oz_0(dArray2, dArray3, dArray4);
        }
        if (BY.w(d3 - this.e) > 1.0E-5) {
            throw new oR();
        }
    }

    private void a(oz_0 oz_02) {
        double d2 = 1.0E-5;
        int n2 = 1000;
        Object object = oz_02;
        oQ oQ2 = this;
        int n3 = oQ2.c.length;
        int n4 = oQ2.c[0].length;
        int n5 = ((oA)object).c().size();
        Object object2 = ((oA)object).c().get(0);
        int n6 = ((oB)((co_0)object2).b).c().length;
        if (n6 != n4) {
            throw new oS(n6, n4);
        }
        n6 = 0;
        double d3 = 0.0;
        oQ2.e = Double.NEGATIVE_INFINITY;
        oQ2.d = new oz_0(((oA)object).c());
        while (n6++ <= 1000 && BY.w(d3 - oQ2.e) > 1.0E-5) {
            int n7;
            int n8;
            d3 = oQ2.e;
            double d4 = 0.0;
            object = oQ2.d.c();
            Object object3 = new double[n5];
            oB[] oBArray = new oB[n5];
            for (int i2 = 0; i2 < n5; ++i2) {
                object2 = (co_0)object.get(i2);
                object3[i2] = (Double)((co_0)object2).a;
                object2 = (co_0)object.get(i2);
                oBArray[i2] = (oB)((co_0)object2).b;
            }
            double[][] dArray = new double[n3][n5];
            object = new double[n5];
            object2 = new double[n5][n4];
            for (int i3 = 0; i3 < n3; ++i3) {
                double d5 = oQ2.d.a(oQ2.c[i3]);
                d4 += BY.k(d5);
                for (n8 = 0; n8 < n5; ++n8) {
                    dArray[i3][n8] = object3[n8] * oBArray[n8].a(oQ2.c[i3]) / d5;
                    Object object4 = object;
                    int n9 = n8;
                    object4[n9] = object4[n9] + dArray[i3][n8];
                    for (n7 = 0; n7 < n4; ++n7) {
                        Object object5 = object2[n8];
                        int n10 = n7;
                        object5[n10] = object5[n10] + dArray[i3][n8] * oQ2.c[i3][n7];
                    }
                }
            }
            oQ2.e = d4 / (double)n3;
            double[] dArray2 = new double[n5];
            double[][] dArray3 = new double[n5][n4];
            for (int i4 = 0; i4 < n5; ++i4) {
                dArray2[i4] = (double)(object[i4] / (double)n3);
                for (n8 = 0; n8 < n4; ++n8) {
                    dArray3[i4][n8] = (double)(object2[i4][n8] / object[i4]);
                }
            }
            tq_0[] tq_0Array = new tq_0[n5];
            for (n8 = 0; n8 < n5; ++n8) {
                int n11 = n4;
                tq_0Array[n8] = new sy_0(n11, n11);
            }
            for (n8 = 0; n8 < n3; ++n8) {
                for (n7 = 0; n7 < n5; ++n7) {
                    sy_0 sy_02 = new sy_0(ch_0.a(oQ2.c[n8], dArray3[n7]));
                    object3 = sy_02;
                    object3 = sy_02.c(object3.d()).b(dArray[n8][n7]);
                    tq_0Array[n7] = tq_0Array[n7].a((tq_0)object3);
                }
            }
            int n12 = n4;
            double[][][] dArray4 = new double[n5][n12][n12];
            for (n7 = 0; n7 < n5; ++n7) {
                tq_0Array[n7] = tq_0Array[n7].b(1.0 / object[n7]);
                dArray4[n7] = tq_0Array[n7].a();
            }
            oQ2.d = new oz_0(dArray2, dArray3, dArray4);
        }
        if (BY.w(d3 - oQ2.e) > 1.0E-5) {
            throw new oR();
        }
    }

    private static oz_0 a(double[][] object, int n2) {
        if (((double[][])object).length < 2) {
            throw new pk_0(((double[][])object).length);
        }
        if (n2 < 2) {
            throw new pn_0(n2, (Number)2, true);
        }
        if (n2 > ((double[][])object).length) {
            throw new pm_0(n2, (Number)((double[][])object).length, true);
        }
        int n3 = ((double[][])object).length;
        int n4 = object[0].length;
        Object[] objectArray = new a[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            objectArray[i2] = new a(object[i2]);
        }
        Arrays.sort(objectArray);
        double d2 = 1.0 / (double)n2;
        object = new ArrayList(n2);
        for (int i3 = 0; i3 < n2; ++i3) {
            int n5 = i3 * n3 / n2;
            int n6 = (i3 + 1) * n3 / n2;
            int n7 = n6 - n5;
            double[][] dArray = new double[n7][n4];
            double[] dArray2 = new double[n4];
            int n8 = 0;
            while (n5 < n6) {
                for (int i4 = 0; i4 < n4; ++i4) {
                    Object object2 = objectArray[n5];
                    double d3 = ((a)object2).a[i4];
                    int n9 = i4;
                    dArray2[n9] = dArray2[n9] + d3;
                    dArray[n8][i4] = d3;
                }
                ++n5;
                ++n8;
            }
            ch_0.a(1.0 / (double)n7, dArray2);
            double[][] dArray3 = new ah_0(dArray).a().a();
            oB oB2 = new oB(dArray2, dArray3);
            object.add(new co_0<Double, oB>(d2, oB2));
        }
        return new oz_0((List<co_0<Double, oB>>)object);
    }

    private double a() {
        return this.e;
    }

    private oz_0 b() {
        return new oz_0(this.d.c());
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a
    implements Comparable<a> {
        final double[] a;
        private Double b;

        a(double[] dArray) {
            this.a = dArray;
            this.b = 0.0;
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                this.b = this.b + dArray[i2];
            }
            this.b = this.b / (double)dArray.length;
        }

        private int a(a a2) {
            return this.b.compareTo(a2.b);
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
                return ch_0.i(this.a, ((a)var1_1).a);
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public final double[] a() {
            return this.a;
        }
    }
}

