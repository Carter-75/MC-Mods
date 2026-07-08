/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lL;
import org.valkyrienskies.core.impl.shadow.pD;
import org.valkyrienskies.core.impl.shadow.pM;
import org.valkyrienskies.core.impl.shadow.pT;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sM;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class pF
extends pD {
    private static final 1 a = new lL.a(){

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
    private final double[] b;
    private final int c;

    private pF(double[] dArray, int n2) {
        this.b = dArray;
        this.c = n2;
    }

    private static pF a() {
        return new pF(null, Integer.MAX_VALUE);
    }

    private pF a(double[] dArray) {
        return new pF((double[])dArray.clone(), this.c);
    }

    private pF a(int n2) {
        return new pF(this.b, n2);
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

        public a(Collection<pM> object) {
            if (object == null) {
                throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
            }
            if (object.size() < 3) {
                throw new pn_0(object.size(), (Number)3, true);
            }
            Collection<pM> collection = object;
            object = this;
            collection = new ArrayList<pM>(collection);
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
            Collections.sort(collection, object);
            object = collection;
            object = this.a(object.toArray((pM[])new pM[0]));
            this.a = (double)object[0];
            this.b = (double)object[1];
            this.c = (double)object[2];
        }

        public final double[] a() {
            return new double[]{this.a, this.b, this.c};
        }

        private List<pM> a(Collection<pM> collection) {
            collection = new ArrayList<pM>(collection);
            Comparator<pM> comparator = new /* invalid duplicate definition of identical inner class */;
            Collections.sort(collection, comparator);
            return collection;
        }

        private double[] a(pM[] pMArray) {
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

        private static int b(pM[] pMArray) {
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
                if (org.valkyrienskies.core.impl.shadow.pF$a.a(d2, pM2.c, pM5.c)) {
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

