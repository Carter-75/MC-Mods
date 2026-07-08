/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lM;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pD;
import org.valkyrienskies.core.impl.shadow.pM;
import org.valkyrienskies.core.impl.shadow.pT;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sM;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class pH
extends pD {
    private static final lM.a a = new lM.a();
    private final double[] b;
    private final int c;

    private pH(double[] dArray, int n2) {
        this.b = dArray;
        this.c = n2;
    }

    private static pH a() {
        return new pH(null, Integer.MAX_VALUE);
    }

    private pH a(double[] dArray) {
        return new pH((double[])dArray.clone(), this.c);
    }

    private pH a(int n2) {
        return new pH(this.b, n2);
    }

    @Override
    protected final pW a(Collection<pM> object) {
        double[] dArray;
        Object object2;
        Object object3;
        int n2 = object.size();
        double[] dArray2 = new double[n2];
        double[] dArray3 = new double[n2];
        int n3 = 0;
        Object object4 = object.iterator();
        while (object4.hasNext()) {
            object2 = object3 = object4.next();
            dArray2[n3] = ((pM)object2).c;
            object2 = object3;
            dArray3[n3] = ((pM)object2).a;
            ++n3;
        }
        object4 = new pD.a(a, (Collection<pM>)object);
        if (this.b != null) {
            dArray = this.b;
        } else {
            object = new a((Collection<pM>)object);
            double[] dArray4 = new double[3];
            dArray4[0] = ((a)object).a;
            dArray4[1] = ((a)object).b;
            dArray = dArray4;
            dArray4[2] = ((a)object).c;
        }
        object3 = dArray;
        int n4 = Integer.MAX_VALUE;
        object2 = new pT();
        new pT().a = Integer.MAX_VALUE;
        ((pT)v2).b = n4 = this.c;
        sM sM2 = new sM(dArray3);
        object2 = ((pT)object2).b((double[])object3).a(dArray2);
        v3.c = sM2;
        return ((pT)object2).a(((pD.a)object4).a(), ((pD.a)object4).b()).a();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a {
        final double a;
        final double b;
        final double c;

        public a(Collection<pM> pMArray) {
            double d2;
            double d3;
            double d4;
            pM pM2;
            if (pMArray.size() < 4) {
                throw new pn_0((pw_0)px_0.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, (Number)pMArray.size(), 4, true);
            }
            Object object = pMArray;
            Object object2 = new ArrayList<pM>((Collection<pM>)object);
            pM pM3 = (pM)object2.get(0);
            int n2 = object2.size();
            for (int i2 = 1; i2 < n2; ++i2) {
                pM pM4;
                pM pM5;
                pM pM6 = pM3;
                pM2 = pM3 = (pM)object2.get(i2);
                pM2 = pM6;
                if (!(pM5.b < pM4.b)) continue;
                int n3 = i2 - 1;
                pM pM7 = (pM)object2.get(n3);
                while (n3 >= 0) {
                    pM pM8;
                    pM pM9;
                    pM2 = pM3;
                    pM2 = pM7;
                    if (!(pM9.b < pM8.b)) break;
                    object2.set(n3 + 1, pM7);
                    if (n3-- == 0) continue;
                    pM7 = (pM)object2.get(n3);
                }
                object2.set(n3 + 1, pM3);
                pM3 = (pM)object2.get(i2);
            }
            object = pMArray = object2.toArray(new pM[0]);
            object2 = new double[2];
            double d5 = 0.0;
            double d6 = 0.0;
            double d7 = 0.0;
            double d8 = 0.0;
            double d9 = 0.0;
            pM2 = object[0];
            double d10 = pM2.b;
            pM2 = object[0];
            double d11 = pM2.c;
            double d12 = 0.0;
            double d13 = 0.0;
            double d14 = d10;
            for (int i3 = 1; i3 < ((pM[])object).length; ++i3) {
                double d15 = d10;
                double d16 = d11;
                pM2 = object[i3];
                d10 = pM2.b;
                pM2 = object[i3];
                d11 = pM2.c;
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
                int n4 = ((pM[])object).length - 1;
                pM pM10 = object[n4];
                pM2 = pM10;
                pM2 = object[0];
                d4 = pM10.b - pM2.b;
                if (d4 == 0.0) {
                    throw new pr_0();
                }
                object2[1] = Math.PI * 2 / d4;
                d3 = Double.POSITIVE_INFINITY;
                d2 = Double.NEGATIVE_INFINITY;
                for (int i4 = 1; i4 < ((pM[])object).length; ++i4) {
                    double d28;
                    pM2 = object[i4];
                    double d29 = pM2.c;
                    if (d28 < d3) {
                        d3 = d29;
                    }
                    if (!(d29 > d2)) continue;
                    d2 = d29;
                }
                object2[0] = 0.5 * (d2 - d3);
            } else {
                if (d25 == 0.0) {
                    throw new oX(px_0.ZERO_DENOMINATOR, new Object[0]);
                }
                object2[0] = BY.a(d24 / d25);
                object2[1] = BY.a(d25 / d27);
            }
            object = object2;
            this.a = (double)object[0];
            this.b = (double)object[1];
            object = this;
            double d30 = 0.0;
            double d31 = 0.0;
            pM2 = pMArray[0];
            double d32 = pM2.b;
            pM2 = pMArray[0];
            double d33 = pM2.c;
            for (int i5 = 1; i5 < pMArray.length; ++i5) {
                d9 = d32;
                d10 = d33;
                pM2 = pMArray[i5];
                d32 = pM2.b;
                pM2 = pMArray[i5];
                d33 = pM2.c;
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

        private static List<pM> a(Collection<pM> collection) {
            collection = new ArrayList<pM>(collection);
            pM pM2 = (pM)collection.get(0);
            int n2 = collection.size();
            for (int i2 = 1; i2 < n2; ++i2) {
                pM pM3;
                pM pM4;
                pM pM5 = pM2;
                pM pM6 = pM2 = (pM)collection.get(i2);
                pM6 = pM5;
                if (!(pM4.b < pM3.b)) continue;
                int n3 = i2 - 1;
                pM pM7 = (pM)collection.get(n3);
                while (n3 >= 0) {
                    pM pM8;
                    pM pM9;
                    pM6 = pM2;
                    pM6 = pM7;
                    if (!(pM9.b < pM8.b)) break;
                    collection.set(n3 + 1, pM7);
                    if (n3-- == 0) continue;
                    pM7 = (pM)collection.get(n3);
                }
                collection.set(n3 + 1, pM2);
                pM2 = (pM)collection.get(i2);
            }
            return collection;
        }

        private static double[] a(pM[] pMArray) {
            double d2;
            double d3;
            double d4;
            double[] dArray = new double[2];
            double d5 = 0.0;
            double d6 = 0.0;
            double d7 = 0.0;
            double d8 = 0.0;
            double d9 = 0.0;
            pM pM2 = pMArray[0];
            double d10 = pM2.b;
            pM2 = pMArray[0];
            double d11 = pM2.c;
            double d12 = 0.0;
            double d13 = 0.0;
            double d14 = d10;
            for (int i2 = 1; i2 < pMArray.length; ++i2) {
                double d15 = d10;
                double d16 = d11;
                pM pM3 = pMArray[i2];
                d10 = pM3.b;
                pM3 = pMArray[i2];
                d11 = pM3.c;
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
                int n2 = pMArray.length - 1;
                pM pM4 = pMArray[n2];
                pM pM5 = pM4;
                pM5 = pMArray[0];
                d4 = pM4.b - pM5.b;
                if (d4 == 0.0) {
                    throw new pr_0();
                }
                dArray[1] = Math.PI * 2 / d4;
                d3 = Double.POSITIVE_INFINITY;
                d2 = Double.NEGATIVE_INFINITY;
                for (int i3 = 1; i3 < pMArray.length; ++i3) {
                    double d28;
                    pM5 = pMArray[i3];
                    double d29 = pM5.c;
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

        private double b(pM[] pMArray) {
            double d2 = 0.0;
            double d3 = 0.0;
            pM pM2 = pMArray[0];
            double d4 = pM2.b;
            pM2 = pMArray[0];
            double d5 = pM2.c;
            for (int i2 = 1; i2 < pMArray.length; ++i2) {
                double d6 = d4;
                double d7 = d5;
                pM pM3 = pMArray[i2];
                d4 = pM3.b;
                pM3 = pMArray[i2];
                d5 = pM3.c;
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

