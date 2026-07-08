/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lL;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.yJ;
import org.valkyrienskies.core.impl.shadow.yN;
import org.valkyrienskies.core.impl.shadow.ye_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yK
extends yJ<lL.a> {
    private yK(ye_0 ye_02) {
        super(ye_02);
    }

    private double[] a(double[] dArray) {
        lL.a a2 = new lL.a(this){
            private /* synthetic */ yK a;
            {
                this.a = yK2;
            }

            public final double a(double d2, double ... dArray) {
                double d3 = Double.POSITIVE_INFINITY;
                try {
                    d3 = super.a(d2, dArray);
                }
                catch (pk_0 pk_02) {}
                return d3;
            }

            public final double[] b(double d2, double ... dArray) {
                double[] dArray2 = new double[]{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
                try {
                    dArray2 = super.b(d2, dArray);
                }
                catch (pk_0 pk_02) {}
                return dArray2;
            }
        };
        return this.a(a2, dArray);
    }

    private double[] b() {
        Object object = new a(this.a());
        Object object2 = object = (Object)new double[]{((a)object).a, ((a)object).b, ((a)object).c};
        object = this;
        lL.a a2 = new /* invalid duplicate definition of identical inner class */;
        return ((yJ)object).a(a2, (double[])object2);
    }

    public static final class a {
        final double a;
        final double b;
        final double c;

        public a(yN[] object) {
            if (object == null) {
                throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
            }
            if (((yN[])object).length < 3) {
                throw new pn_0(((yN[])object).length, (Number)3, true);
            }
            yN[] yNArray = object;
            object = this;
            yNArray = (yN[])yNArray.clone();
            object = new Comparator<yN>((a)object){
                private /* synthetic */ a a;
                {
                    this.a = a2;
                }

                private static int a(yN yN2, yN yN3) {
                    if (yN2 == null && yN3 == null) {
                        return 0;
                    }
                    if (yN2 == null) {
                        return -1;
                    }
                    if (yN3 == null) {
                        return 1;
                    }
                    yN yN4 = yN2;
                    yN yN5 = yN4;
                    yN5 = yN3;
                    int n2 = Double.compare(yN4.b, yN5.b);
                    if (n2 < 0) {
                        return -1;
                    }
                    if (n2 > 0) {
                        return 1;
                    }
                    yN yN6 = yN2;
                    yN yN7 = yN6;
                    yN7 = yN3;
                    int n3 = Double.compare(yN6.c, yN7.c);
                    if (n3 < 0) {
                        return -1;
                    }
                    if (n3 > 0) {
                        return 1;
                    }
                    yN yN8 = yN2;
                    yN yN9 = yN8;
                    yN9 = yN3;
                    int n4 = Double.compare(yN8.a, yN9.a);
                    if (n4 < 0) {
                        return -1;
                    }
                    if (n4 > 0) {
                        return 1;
                    }
                    return 0;
                }
            };
            Arrays.sort(yNArray, object);
            object = yNArray;
            object = this.b((yN[])object);
            this.a = (double)object[0];
            this.b = (double)object[1];
            this.c = (double)object[2];
        }

        public final double[] a() {
            return new double[]{this.a, this.b, this.c};
        }

        private yN[] a(yN[] yNArray) {
            yNArray = (yN[])yNArray.clone();
            Comparator<yN> comparator = new /* invalid duplicate definition of identical inner class */;
            Arrays.sort(yNArray, comparator);
            return yNArray;
        }

        private double[] b(yN[] yNArray) {
            double d2;
            double d3;
            yN yN2;
            yN[] yNArray2 = yNArray;
            int n2 = 0;
            for (int i2 = 1; i2 < yNArray2.length; ++i2) {
                yN yN3;
                yN yN4;
                yN2 = yNArray2[i2];
                yN2 = yNArray2[n2];
                if (!(yN4.c > yN3.c)) continue;
                n2 = i2;
            }
            int n3 = n2;
            yN2 = yNArray[n3];
            double d4 = yN2.c;
            yN2 = yNArray[n3];
            double d5 = yN2.b;
            try {
                d3 = d4 + (d5 - d4) / 2.0;
                double d6 = this.a(yNArray, n3, -1, d3);
                double d7 = this.a(yNArray, n3, 1, d3);
                d2 = d7 - d6;
            }
            catch (po_0 po_02) {
                yN yN5 = yNArray[yNArray.length - 1];
                yN2 = yN5;
                yN2 = yNArray[0];
                d2 = yN5.b - yN2.b;
            }
            d3 = d2 / (2.0 * BY.a(2.0 * BY.k(2.0)));
            return new double[]{d4, d5, d3};
        }

        private static int c(yN[] yNArray) {
            int n2 = 0;
            for (int i2 = 1; i2 < yNArray.length; ++i2) {
                yN yN2;
                yN yN3;
                yN yN4 = yNArray[i2];
                yN4 = yNArray[n2];
                if (!(yN3.c > yN2.c)) continue;
                n2 = i2;
            }
            return n2;
        }

        private double a(yN[] object, int n2, int n3, double d2) {
            if (n3 == 0) {
                throw new pr_0();
            }
            object = this.b((yN[])object, n2, n3, d2);
            Object object2 = object[0];
            object = object[1];
            Object object3 = object2;
            if (object2.c == d2) {
                object3 = object2;
                return object2.b;
            }
            object3 = object;
            if (object.c == d2) {
                object3 = object;
                return object.b;
            }
            object3 = object2;
            object3 = object2;
            object3 = object;
            object3 = object2;
            object3 = object;
            object3 = object2;
            return object2.b + (d2 - object2.c) * (object.b - object2.b) / (object.c - object2.c);
        }

        private yN[] b(yN[] yNArray, int n2, int n3, double d2) {
            if (n3 == 0) {
                throw new pr_0();
            }
            while (n3 < 0 ? n2 + n3 >= 0 : n2 + n3 < yNArray.length) {
                yN yN2;
                yN yN3 = yNArray[n2];
                yN yN4 = yNArray[n2 + n3];
                yN yN5 = yN3;
                yN5 = yN4;
                if (org.valkyrienskies.core.impl.shadow.yK$a.a(d2, yN2.c, yN5.c)) {
                    if (n3 < 0) {
                        return new yN[]{yN4, yN3};
                    }
                    return new yN[]{yN3, yN4};
                }
                n2 += n3;
            }
            throw new po_0(d2, (Number)Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        }

        private static boolean a(double d2, double d3, double d4) {
            return d2 >= d3 && d2 <= d4 || d2 >= d4 && d2 <= d3;
        }
    }
}

