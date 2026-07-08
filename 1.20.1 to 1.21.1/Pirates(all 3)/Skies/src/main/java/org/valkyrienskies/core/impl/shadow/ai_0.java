/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.sD;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ai
 */
public final class ai_0 {
    private final tq_0 a;

    public ai_0() {
        this.a = null;
    }

    private ai_0(double[][] dArray) {
        this(td_0.a(dArray));
    }

    private ai_0(tq_0 tq_02) {
        this.a = this.a(tq_02);
    }

    private tq_0 a() {
        return this.a;
    }

    private sD a(tq_0 tq_02) {
        int n2;
        int n3 = n2 = tq_02.g();
        sD sD2 = new sD(n3, n3);
        int n4 = 0;
        while (n4 < n2) {
            for (int i2 = 0; i2 < n4; ++i2) {
                double d2 = this.a(tq_02.g(n4), tq_02.g(i2));
                sD2.c(n4, i2, d2);
                sD2.c(i2, n4, d2);
            }
            int n5 = n4++;
            sD2.c(n5, n5, 1.0);
        }
        return sD2;
    }

    private tq_0 a(double[][] dArray) {
        return this.a(new sD(dArray));
    }

    private double a(double[] object, double[] object2) {
        int n2;
        if (((double[])object).length != ((double[])object2).length) {
            throw new oS(((double[])object).length, ((double[])object2).length);
        }
        int n3 = ((double[])object).length;
        long l2 = ai_0.a(n3 - 1);
        Object object3 = new co_0[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            object3[i2] = new co_0<Double, Double>(object[i2], object2[i2]);
        }
        Arrays.sort(object3, new Comparator<co_0<Double, Double>>(this){
            private /* synthetic */ ai_0 a;
            {
                this.a = ai_02;
            }

            private static int a(co_0<Double, Double> co_02, co_0<Double, Double> co_03) {
                co_0<Double, Double> co_04 = co_02;
                co_0<Double, Double> co_05 = co_04;
                co_05 = co_03;
                int n2 = ((Double)co_04.a).compareTo((Double)co_05.a);
                if (n2 != 0) {
                    return n2;
                }
                co_0<Double, Double> co_06 = co_02;
                co_0<Double, Double> co_07 = co_06;
                co_07 = co_03;
                return ((Double)co_06.b).compareTo((Double)co_07.b);
            }

            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                object2 = (co_0)object2;
                Object object3 = object = (co_0)object;
                object3 = object2;
                int n2 = ((Double)((co_0)object).a).compareTo((Double)((co_0)object3).a);
                if (n2 != 0) {
                    return n2;
                }
                Object object4 = object;
                Object object5 = object4;
                object5 = object2;
                return ((Double)((co_0)object4).b).compareTo((Double)((co_0)object5).b);
            }
        });
        long l3 = 0L;
        long l4 = 0L;
        long l5 = 1L;
        long l6 = 1L;
        object = object3[0];
        for (int i3 = 1; i3 < n3; ++i3) {
            co_0 co_02 = object3[i3];
            object2 = co_02;
            object2 = object;
            if (((Double)co_02.a).equals(object.a)) {
                ++l5;
                co_0 co_03 = co_02;
                object2 = co_03;
                object2 = object;
                if (((Double)co_03.b).equals(object.b)) {
                    ++l6;
                } else {
                    l4 += ai_0.a(l6 - 1L);
                    l6 = 1L;
                }
            } else {
                l3 += ai_0.a(l5 - 1L);
                l5 = 1L;
                l4 += ai_0.a(l6 - 1L);
                l6 = 1L;
            }
            object = co_02;
        }
        l3 += ai_0.a(l5 - 1L);
        l4 += ai_0.a(l6 - 1L);
        long l7 = 0L;
        object = new co_0[n3];
        for (int i4 = 1; i4 < n3; i4 <<= 1) {
            for (int i5 = 0; i5 < n3; i5 += 2 * i4) {
                int n4;
                int n5 = i5;
                n2 = n4 = BY.a(n5 + i4, n3);
                int n6 = BY.a(n4 + i4, n3);
                int n7 = i5;
                while (n5 < n4 || n2 < n6) {
                    if (n5 < n4) {
                        if (n2 < n6) {
                            co_0 co_04 = object3[n5];
                            object2 = co_04;
                            co_0 co_05 = object3[n2];
                            object2 = co_05;
                            if (((Double)co_04.b).compareTo((Double)co_05.b) <= 0) {
                                object[n7] = (double)object3[n5];
                                ++n5;
                            } else {
                                object[n7] = (double)object3[n2];
                                ++n2;
                                l7 += (long)(n4 - n5);
                            }
                        } else {
                            object[n7] = (double)object3[n5];
                            ++n5;
                        }
                    } else {
                        object[n7] = (double)object3[n2];
                        ++n2;
                    }
                    ++n7;
                }
            }
            co_0[] co_0Array = object3;
            object3 = object;
            object = co_0Array;
        }
        long l8 = 0L;
        long l9 = 1L;
        object = object3[0];
        for (n2 = 1; n2 < n3; ++n2) {
            co_0 co_06 = object3[n2];
            object2 = co_06;
            object2 = object;
            if (((Double)co_06.b).equals(object.b)) {
                ++l9;
            } else {
                l8 += ai_0.a(l9 - 1L);
                l9 = 1L;
            }
            object = co_06;
        }
        long l10 = l2 - l3 - (l8 += ai_0.a(l9 - 1L)) + l4 - 2L * l7;
        double d2 = (double)(l2 - l3) * (double)(l2 - l8);
        return (double)l10 / BY.a(d2);
    }

    private static long a(long l2) {
        long l3 = l2;
        return l3 * (l3 + 1L) / 2L;
    }
}

