/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.kX;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.kZ;
import org.valkyrienskies.core.impl.shadow.pM;
import org.valkyrienskies.core.impl.shadow.wL;
import org.valkyrienskies.core.impl.shadow.wM;
import org.valkyrienskies.core.impl.shadow.wR;
import org.valkyrienskies.core.impl.shadow.xC;
import org.valkyrienskies.core.impl.shadow.xD;
import org.valkyrienskies.core.impl.shadow.xF;
import org.valkyrienskies.core.impl.shadow.xG;
import org.valkyrienskies.core.impl.shadow.xH;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public class pE<T extends kZ> {
    private final xF b;
    final List<pM> a;

    public pE(xF xF2) {
        this.b = xF2;
        this.a = new ArrayList<pM>();
    }

    private void a(double d2, double d3) {
        this.a(1.0, d2, d3);
    }

    public final void a(double d2, double d3, double d4) {
        this.a.add(new pM(1.0, d3, d4));
    }

    private void a(pM pM2) {
        this.a.add(pM2);
    }

    public final pM[] a() {
        return this.a.toArray(new pM[this.a.size()]);
    }

    public final void b() {
        this.a.clear();
    }

    public final double[] a(T t, double[] dArray) {
        return this.a(Integer.MAX_VALUE, t, dArray);
    }

    public final double[] a(int n2, T t, double[] dArray) {
        Serializable serializable;
        Serializable serializable2;
        double[] dArray2 = new double[this.a.size()];
        double[] dArray3 = new double[this.a.size()];
        int n3 = 0;
        Object object = this.a.iterator();
        while (object.hasNext()) {
            serializable = serializable2 = object.next();
            dArray2[n3] = serializable.c;
            serializable = serializable2;
            dArray3[n3] = serializable.a;
            ++n3;
        }
        object = new a((kZ)t);
        serializable = serializable2 = this.b.c(new wM(n2), ((a)object).a(), ((a)object).b(), new xG(dArray2), new xH(dArray3), new wL(dArray));
        wR wR2 = serializable2;
        return (double[])((co_0)((Object)serializable2)).a;
    }

    static /* synthetic */ List a(pE pE2) {
        return pE2.a;
    }

    final class a {
        final kZ a;

        a(kZ kZ2) {
            this.a = kZ2;
        }

        public final xC a() {
            return new xC(new kY(this){
                private /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final double[] a(double[] dArray) {
                    Object object = this.a.pE.this;
                    double[] dArray2 = new double[((pE)object).a.size()];
                    int n2 = 0;
                    object = this.a.pE.this;
                    for (pM pM2 : ((pE)object).a) {
                        int n3 = n2++;
                        a a2 = this.a;
                        object = a2;
                        object = pM2;
                        dArray2[n3] = a2.a.a(((pM)object).b, dArray);
                    }
                    return dArray2;
                }
            });
        }

        public final xD b() {
            return new xD(new kX(this){
                private /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final double[][] a(double[] dArray) {
                    Object object = this.a.pE.this;
                    double[][] dArrayArray = new double[((pE)object).a.size()][];
                    int n2 = 0;
                    object = this.a.pE.this;
                    for (pM pM2 : ((pE)object).a) {
                        int n3 = n2++;
                        a a2 = this.a;
                        object = a2;
                        object = pM2;
                        dArrayArray[n3] = a2.a.b(((pM)object).b, dArray);
                    }
                    return dArrayArray;
                }
            });
        }

        static /* synthetic */ kZ a(a a2) {
            return a2.a;
        }
    }
}

