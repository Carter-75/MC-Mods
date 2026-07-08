/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lL;
import org.valkyrienskies.core.impl.shadow.pE;
import org.valkyrienskies.core.impl.shadow.pM;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.xF;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class pG
extends pE<lL.a> {
    private pG(xF xF2) {
        super(xF2);
    }

    private double[] a(double[] dArray) {
        lL.a a2 = new lL.a(this){
            private /* synthetic */ pG a;
            {
                this.a = pG2;
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

    private double[] c() {
        Object object = new a(this.a());
        Object object2 = object = (Object)new double[]{((a)object).a, ((a)object).b, ((a)object).c};
        object = this;
        lL.a a2 = new /* invalid duplicate definition of identical inner class */;
        return ((pE)object).a(a2, (double[])object2);
    }

    public static final class a {
        final double a;
        final double b;
        final double c;

        public a(pM[] object) {
            if (object == null) {
                throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
            }
            if (((pM[])object).length < 3) {
                throw new pn_0(((pM[])object).length, (Number)3, true);
            }
            pM[] pMArray = object;
            object = this;
            pMArray = (pM[])pMArray.clone();
            object = new Comparator<pM>((a)object){
                private /* synthetic */ a a;
                {
                    this.a = a2;
                }

                private static int a(pM pM2, pM pM3) {
                    if (pM2 == null && pM3 == null) {
                        return 0;
                    }
                    if (pM2 == null) {
                        return -1;
                    }
                    if (pM3 == null) {
                        return 1;
                    }
                    pM pM4 = pM2;
                    pM pM5 = pM4;
                    pM5 = pM3;
                    int n2 = Double.compare(pM4.b, pM5.b);
                    if (n2 < 0) {
                        return -1;
                    }
                    if (n2 > 0) {
                        return 1;
                    }
                    pM pM6 = pM2;
                    pM pM7 = pM6;
                    pM7 = pM3;
                    int n3 = Double.compare(pM6.c, pM7.c);
                    if (n3 < 0) {
                        return -1;
                    }
                    if (n3 > 0) {
                        return 1;
                    }
                    pM pM8 = pM2;
                    pM pM9 = pM8;
                    pM9 = pM3;
                    int n4 = Double.compare(pM8.a, pM9.a);
                    if (n4 < 0) {
                        return -1;
                    }
                    if (n4 > 0) {
                        return 1;
                    }
                    return 0;
                }
            };
            Arrays.sort(pMArray, object);
            object = pMArray;
            object = this.b((pM[])object);
            this.a = (double)object[0];
            this.b = (double)object[1];
            this.c = (double)object[2];
        }

        public final double[] a() {
            return new double[]{this.a, this.b, this.c};
        }

        private pM[] a(pM[] pMArray) {
            pMArray = (pM[])pMArray.clone();
            Comparator<pM> comparator = new /* invalid duplicate definition of identical inner class */;
            Arrays.sort(pMArray, comparator);
            return pMArray;
        }

        private double[] b(pM[] pMArray) {
            double d2;
            double d3;
            pM pM2;
            pM[] pMArray2 = pMArray;
            int n2 = 0;
            for (int i2 = 1; i2 < pMArray2.length; ++i2) {
                pM pM3;
                pM pM4;
                pM2 = pMArray2[i2];
                pM2 = pMArray2[n2];
                if (!(pM4.c > pM3.c)) continue;
                n2 = i2;
            }
            int n3 = n2;
            pM2 = pMArray[n3];
            double d4 = pM2.c;
            pM2 = pMArray[n3];
            double d5 = pM2.b;
            try {
                d3 = d4 + (d5 - d4) / 2.0;
                double d6 = this.a(pMArray, n3, -1, d3);
                double d7 = this.a(pMArray, n3, 1, d3);
                d2 = d7 - d6;
            }
            catch (po_0 po_02) {
                pM pM5 = pMArray[pMArray.length - 1];
                pM2 = pM5;
                pM2 = pMArray[0];
                d2 = pM5.b - pM2.b;
            }
            d3 = d2 / (2.0 * BY.a(2.0 * BY.k(2.0)));
            return new double[]{d4, d5, d3};
        }

        private static int c(pM[] pMArray) {
            int n2 = 0;
            for (int i2 = 1; i2 < pMArray.length; ++i2) {
                pM pM2;
                pM pM3;
                pM pM4 = pMArray[i2];
                pM4 = pMArray[n2];
                if (!(pM3.c > pM2.c)) continue;
                n2 = i2;
            }
            return n2;
        }

        private double a(pM[] object, int n2, int n3, double d2) {
            if (n3 == 0) {
                throw new pr_0();
            }
            object = this.b((pM[])object, n2, n3, d2);
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

        private pM[] b(pM[] pMArray, int n2, int n3, double d2) {
            if (n3 == 0) {
                throw new pr_0();
            }
            while (n3 < 0 ? n2 + n3 >= 0 : n2 + n3 < pMArray.length) {
                pM pM2;
                pM pM3 = pMArray[n2];
                pM pM4 = pMArray[n2 + n3];
                pM pM5 = pM3;
                pM5 = pM4;
                if (org.valkyrienskies.core.impl.shadow.pG$a.a(d2, pM2.c, pM5.c)) {
                    if (n3 < 0) {
                        return new pM[]{pM4, pM3};
                    }
                    return new pM[]{pM3, pM4};
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

