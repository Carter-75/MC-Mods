/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lM;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.yJ;
import org.valkyrienskies.core.impl.shadow.yN;
import org.valkyrienskies.core.impl.shadow.ye_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yL
extends yJ<lM.a> {
    private yL(ye_0 ye_02) {
        super(ye_02);
    }

    private double[] a(double[] dArray) {
        return this.a(new lM.a(), dArray);
    }

    private double[] b() {
        Object object = new a(this.a());
        double[] dArray = new double[]{((a)object).a, ((a)object).b, ((a)object).c};
        object = this;
        return ((yJ)object).a(new lM.a(), dArray);
    }

    public static final class a {
        final double a;
        final double b;
        final double c;

        public a(yN[] yNArray) {
            double d2;
            double d3;
            double d4;
            yN yN2;
            if (yNArray.length < 4) {
                throw new pn_0((pw_0)px_0.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, (Number)yNArray.length, 4, true);
            }
            Object object = yNArray;
            Object[] objectArray = (yN[])yNArray.clone();
            yN yN3 = objectArray[0];
            for (int i2 = 1; i2 < objectArray.length; ++i2) {
                yN yN4;
                yN yN5;
                yN yN6 = yN3;
                yN2 = yN3 = objectArray[i2];
                yN2 = yN6;
                if (!(yN5.b < yN4.b)) continue;
                int n2 = i2 - 1;
                yN yN7 = objectArray[n2];
                while (n2 >= 0) {
                    yN yN8;
                    yN yN9;
                    yN2 = yN3;
                    yN2 = yN7;
                    if (!(yN9.b < yN8.b)) break;
                    objectArray[n2 + 1] = yN7;
                    if (n2-- == 0) continue;
                    yN7 = objectArray[n2];
                }
                objectArray[n2 + 1] = yN3;
                yN3 = objectArray[i2];
            }
            yNArray = objectArray;
            object = objectArray;
            objectArray = new double[2];
            double d5 = 0.0;
            double d6 = 0.0;
            double d7 = 0.0;
            double d8 = 0.0;
            double d9 = 0.0;
            yN2 = object[0];
            double d10 = yN2.b;
            yN2 = object[0];
            double d11 = yN2.c;
            double d12 = 0.0;
            double d13 = 0.0;
            double d14 = d10;
            for (int i3 = 1; i3 < ((yN[])object).length; ++i3) {
                double d15 = d10;
                double d16 = d11;
                yN2 = object[i3];
                d10 = yN2.b;
                yN2 = object[i3];
                d11 = yN2.c;
                double d17 = d10 - d15;
                d4 = d11 - d16;
                double d18 = d16;
                double d19 = d11;
                d3 = d17 * (d18 * d18 + d16 * d11 + d19 * d19) / 3.0;
                double d20 = d4;
                d2 = d20 * d20 / d17;
                double d21 = d10 - d14;
                d13 += d2;
                double d22 = d21;
                d5 += d22 * d22;
                double d23 = d12 += d3;
                d6 += d23 * d23;
                d7 += d21 * d12;
                d8 += d21 * d13;
                d9 += d12 * d13;
            }
            double d24 = d6 * d8 - d7 * d9;
            double d25 = d7 * d8 - d5 * d9;
            double d26 = d7;
            double d27 = d5 * d6 - d26 * d26;
            if (d24 / d25 < 0.0 || d25 / d27 < 0.0) {
                int n3 = ((yN[])object).length - 1;
                yN yN10 = object[n3];
                yN2 = yN10;
                yN2 = object[0];
                d4 = yN10.b - yN2.b;
                if (d4 == 0.0) {
                    throw new pr_0();
                }
                objectArray[1] = (yN)(Math.PI * 2 / d4);
                d3 = Double.POSITIVE_INFINITY;
                d2 = Double.NEGATIVE_INFINITY;
                for (int i4 = 1; i4 < ((yN[])object).length; ++i4) {
                    double d28;
                    yN2 = object[i4];
                    double d29 = yN2.c;
                    if (d28 < d3) {
                        d3 = d29;
                    }
                    if (!(d29 > d2)) continue;
                    d2 = d29;
                }
                objectArray[0] = (yN)(0.5 * (d2 - d3));
            } else {
                if (d25 == 0.0) {
                    throw new oX(px_0.ZERO_DENOMINATOR, new Object[0]);
                }
                objectArray[0] = (yN)BY.a(d24 / d25);
                objectArray[1] = (yN)BY.a(d25 / d27);
            }
            object = objectArray;
            this.a = (double)object[0];
            this.b = (double)object[1];
            object = this;
            double d30 = 0.0;
            double d31 = 0.0;
            yN2 = yNArray[0];
            double d32 = yN2.b;
            yN2 = yNArray[0];
            double d33 = yN2.c;
            for (int i5 = 1; i5 < yNArray.length; ++i5) {
                d9 = d32;
                d10 = d33;
                yN2 = yNArray[i5];
                d32 = yN2.b;
                yN2 = yNArray[i5];
                d33 = yN2.c;
                d11 = (d33 - d10) / (d32 - d9);
                d12 = object.b * d32;
                d13 = BY.o(d12);
                d14 = BY.n(d12);
                d30 += object.b * d33 * d13 - d11 * d14;
                d31 += object.b * d33 * d14 + d11 * d13;
            }
            this.c = BY.b(-d31, d30);
        }

        public final double[] a() {
            return new double[]{this.a, this.b, this.c};
        }

        private static yN[] a(yN[] yNArray) {
            yNArray = (yN[])yNArray.clone();
            yN yN2 = yNArray[0];
            for (int i2 = 1; i2 < yNArray.length; ++i2) {
                yN yN3;
                yN yN4;
                yN yN5 = yN2;
                yN yN6 = yN2 = yNArray[i2];
                yN6 = yN5;
                if (!(yN4.b < yN3.b)) continue;
                int n2 = i2 - 1;
                yN yN7 = yNArray[n2];
                while (n2 >= 0) {
                    yN yN8;
                    yN yN9;
                    yN6 = yN2;
                    yN6 = yN7;
                    if (!(yN9.b < yN8.b)) break;
                    yNArray[n2 + 1] = yN7;
                    if (n2-- == 0) continue;
                    yN7 = yNArray[n2];
                }
                yNArray[n2 + 1] = yN2;
                yN2 = yNArray[i2];
            }
            return yNArray;
        }

        private static double[] b(yN[] yNArray) {
            double d2;
            double d3;
            double d4;
            double[] dArray = new double[2];
            double d5 = 0.0;
            double d6 = 0.0;
            double d7 = 0.0;
            double d8 = 0.0;
            double d9 = 0.0;
            yN yN2 = yNArray[0];
            double d10 = yN2.b;
            yN2 = yNArray[0];
            double d11 = yN2.c;
            double d12 = 0.0;
            double d13 = 0.0;
            double d14 = d10;
            for (int i2 = 1; i2 < yNArray.length; ++i2) {
                double d15 = d10;
                double d16 = d11;
                yN yN3 = yNArray[i2];
                d10 = yN3.b;
                yN3 = yNArray[i2];
                d11 = yN3.c;
                double d17 = d10 - d15;
                d4 = d11 - d16;
                double d18 = d16;
                double d19 = d11;
                d3 = d17 * (d18 * d18 + d16 * d11 + d19 * d19) / 3.0;
                double d20 = d4;
                d2 = d20 * d20 / d17;
                double d21 = d10 - d14;
                d13 += d2;
                double d22 = d21;
                d5 += d22 * d22;
                double d23 = d12 += d3;
                d6 += d23 * d23;
                d7 += d21 * d12;
                d8 += d21 * d13;
                d9 += d12 * d13;
            }
            double d24 = d6 * d8 - d7 * d9;
            double d25 = d7 * d8 - d5 * d9;
            double d26 = d7;
            double d27 = d5 * d6 - d26 * d26;
            if (d24 / d25 < 0.0 || d25 / d27 < 0.0) {
                int n2 = yNArray.length - 1;
                yN yN4 = yNArray[n2];
                yN yN5 = yN4;
                yN5 = yNArray[0];
                d4 = yN4.b - yN5.b;
                if (d4 == 0.0) {
                    throw new pr_0();
                }
                dArray[1] = Math.PI * 2 / d4;
                d3 = Double.POSITIVE_INFINITY;
                d2 = Double.NEGATIVE_INFINITY;
                for (int i3 = 1; i3 < yNArray.length; ++i3) {
                    double d28;
                    yN5 = yNArray[i3];
                    double d29 = yN5.c;
                    if (d28 < d3) {
                        d3 = d29;
                    }
                    if (!(d29 > d2)) continue;
                    d2 = d29;
                }
                dArray[0] = 0.5 * (d2 - d3);
            } else {
                if (d25 == 0.0) {
                    throw new oX(px_0.ZERO_DENOMINATOR, new Object[0]);
                }
                dArray[0] = BY.a(d24 / d25);
                dArray[1] = BY.a(d25 / d27);
            }
            return dArray;
        }

        private double c(yN[] yNArray) {
            double d2 = 0.0;
            double d3 = 0.0;
            yN yN2 = yNArray[0];
            double d4 = yN2.b;
            yN2 = yNArray[0];
            double d5 = yN2.c;
            for (int i2 = 1; i2 < yNArray.length; ++i2) {
                double d6 = d4;
                double d7 = d5;
                yN yN3 = yNArray[i2];
                d4 = yN3.b;
                yN3 = yNArray[i2];
                d5 = yN3.c;
                double d8 = (d5 - d7) / (d4 - d6);
                double d9 = this.b * d4;
                double d10 = BY.o(d9);
                double d11 = BY.n(d9);
                d2 += this.b * d5 * d10 - d8 * d11;
                d3 += this.b * d5 * d11 + d8 * d10;
            }
            return BY.b(-d3, d2);
        }
    }
}

