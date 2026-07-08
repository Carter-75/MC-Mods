/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.kX;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.kZ;
import org.valkyrienskies.core.impl.shadow.pM;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.pX;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class pD {
    private double[] b(Collection<pM> collection) {
        return new pX().a(this.a(collection)).e().g();
    }

    private static pX a() {
        return new pX();
    }

    protected abstract pW a(Collection<pM> var1);

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    protected static final class a {
        final kZ a;
        final double[] b;

        public a(kZ kZ2, Collection<pM> object) {
            this.a = kZ2;
            int n2 = object.size();
            this.b = new double[n2];
            n2 = 0;
            object = object.iterator();
            while (object.hasNext()) {
                pM pM2 = (pM)object.next();
                this.b[n2++] = pM2.b;
            }
        }

        public final 1 a() {
            return new kY(this){
                private /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final double[] a(double[] dArray) {
                    a a2 = this.a;
                    int n2 = a2.b.length;
                    double[] dArray2 = new double[n2];
                    for (int i2 = 0; i2 < n2; ++i2) {
                        a a3 = this.a;
                        a2 = a3;
                        a2 = this.a;
                        dArray2[i2] = a3.a.a(a2.b[i2], dArray);
                    }
                    return dArray2;
                }
            };
        }

        public final 2 b() {
            return new kX(this){
                private /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final double[][] a(double[] dArray) {
                    a a2 = this.a;
                    int n2 = a2.b.length;
                    double[][] dArrayArray = new double[n2][];
                    for (int i2 = 0; i2 < n2; ++i2) {
                        a a3 = this.a;
                        a2 = a3;
                        a2 = this.a;
                        dArrayArray[i2] = a3.a.b(a2.b[i2], dArray);
                    }
                    return dArrayArray;
                }
            };
        }

        static /* synthetic */ double[] a(a a2) {
            return a2.b;
        }

        static /* synthetic */ kZ b(a a2) {
            return a2.a;
        }
    }
}

