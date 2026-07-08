/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.kR;
import org.valkyrienskies.core.impl.shadow.kX;
import org.valkyrienskies.core.impl.shadow.kZ;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ll_0;
import org.valkyrienskies.core.impl.shadow.yN;
import org.valkyrienskies.core.impl.shadow.ye_0;
import org.valkyrienskies.core.impl.shadow.yl_0;
import org.valkyrienskies.core.impl.shadow.yq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public class yJ<T extends kZ> {
    @Deprecated
    private final ye_0 b;
    private final yl_0 c;
    final List<yN> a;

    @Deprecated
    public yJ(ye_0 ye_02) {
        this.b = ye_02;
        this.c = null;
        this.a = new ArrayList<yN>();
    }

    private yJ(yl_0 yl_02) {
        this.b = null;
        this.c = yl_02;
        this.a = new ArrayList<yN>();
    }

    private void a(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        double d6 = 1.0;
        yJ yJ2 = this;
        yJ2.a.add(new yN(1.0, d5, d4));
    }

    private void a(double d2, double d3, double d4) {
        this.a.add(new yN(1.0, d3, d4));
    }

    private void a(yN yN2) {
        this.a.add(yN2);
    }

    public final yN[] a() {
        return this.a.toArray(new yN[this.a.size()]);
    }

    private void b() {
        this.a.clear();
    }

    public final double[] a(T t, double[] dArray) {
        return this.a(Integer.MAX_VALUE, t, dArray);
    }

    public final double[] a(int n2, T t, double[] dArray) {
        Object object;
        double[] dArray2 = new double[this.a.size()];
        double[] dArray3 = new double[this.a.size()];
        int n3 = 0;
        for (yN yN2 : this.a) {
            object = yN2;
            dArray2[n3] = ((yN)object).c;
            object = yN2;
            dArray3[n3] = ((yN)object).a;
            ++n3;
        }
        yq_0 yq_02 = this.c == null ? this.b.a(n2, new a((kZ)t), dArray2, dArray3, dArray) : this.c.a(n2, new b(this, (kZ)t), dArray2, dArray3, dArray);
        yq_0 yq_03 = object = yq_02;
        return (double[])((co_0)object).a;
    }

    static /* synthetic */ List a(yJ yJ2) {
        return yJ2.a;
    }

    final class b
    implements ll_0 {
        private final kZ a;
        private /* synthetic */ yJ b;

        b(yJ yJ2, kZ kZ2) {
            this.b = yJ2;
            this.a = kZ2;
        }

        public final double[] a(double[] dArray) {
            yJ object2 = this.b;
            double[] dArray2 = new double[object2.a.size()];
            int n2 = 0;
            yJ yJ2 = this.b;
            for (yN yN2 : yJ2.a) {
                int n3 = n2++;
                yN yN3 = yN2;
                dArray2[n3] = this.a.a(yN3.b, dArray);
            }
            return dArray2;
        }

        /*
         * WARNING - void declaration
         */
        public final lg_0[] a(lg_0[] lg_0Array) {
            double[] dArray = new double[lg_0Array.length];
            for (int i2 = 0; i2 < lg_0Array.length; ++i2) {
                lg_0 object2 = lg_0Array[i2];
                dArray[i2] = object2.b[0];
            }
            yJ yJ2 = this.b;
            lg_0[] lg_0Array2 = new lg_0[yJ2.a.size()];
            int n2 = 0;
            yJ yJ3 = this.b;
            Iterator<yN> iterator2 = yJ3.a.iterator();
            while (iterator2.hasNext()) {
                void var6_12;
                yN yN2;
                yN yN3 = yN2 = iterator2.next();
                lg_0 lg_02 = new lg_0(lg_0Array.length, 1, this.a.a(yN3.b, dArray));
                for (int i2 = 0; i2 < lg_0Array.length; ++i2) {
                    lg_0 lg_03 = var6_12.a(new lg_0(lg_0Array.length, 1, i2, 0.0));
                }
                lg_0Array2[n2++] = var6_12;
            }
            return lg_0Array2;
        }
    }

    @Deprecated
    final class a
    implements kR {
        final kZ a;

        a(kZ kZ2) {
            this.a = kZ2;
        }

        public final kX a() {
            return new kX(this){
                private /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final double[][] a(double[] dArray) {
                    yJ object2 = this.a.yJ.this;
                    double[][] dArrayArray = new double[object2.a.size()][];
                    int n2 = 0;
                    yJ yJ2 = this.a.yJ.this;
                    for (yN yN2 : yJ2.a) {
                        int n3 = n2++;
                        a a2 = this.a;
                        yN yN3 = yN2;
                        dArrayArray[n3] = a2.a.b(yN3.b, dArray);
                    }
                    return dArrayArray;
                }
            };
        }

        public final double[] a(double[] dArray) {
            yJ object2 = yJ.this;
            double[] dArray2 = new double[object2.a.size()];
            int n2 = 0;
            yJ yJ2 = yJ.this;
            for (yN yN2 : yJ2.a) {
                int n3 = n2++;
                yN yN3 = yN2;
                dArray2[n3] = this.a.a(yN3.b, dArray);
            }
            return dArray2;
        }

        static /* synthetic */ kZ a(a a2) {
            return a2.a;
        }
    }
}

