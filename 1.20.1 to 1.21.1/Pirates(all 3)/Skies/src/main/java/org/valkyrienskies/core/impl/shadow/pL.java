/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.kZ;
import org.valkyrienskies.core.impl.shadow.pD;
import org.valkyrienskies.core.impl.shadow.pM;
import org.valkyrienskies.core.impl.shadow.pT;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.sM;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class pL
extends pD {
    private final kZ a;
    private final double[] b;
    private final int c;

    private pL(kZ kZ2, double[] dArray, int n2) {
        this.a = kZ2;
        this.b = dArray;
        this.c = n2;
    }

    private static pL a(kZ kZ2, double[] dArray) {
        return new pL(kZ2, dArray, Integer.MAX_VALUE);
    }

    private pL a(double[] dArray) {
        return new pL(this.a, (double[])dArray.clone(), this.c);
    }

    private pL a(int n2) {
        return new pL(this.a, this.b, n2);
    }

    @Override
    protected final pW a(Collection<pM> collection) {
        Object object;
        int n2 = collection.size();
        double[] dArray = new double[n2];
        double[] dArray2 = new double[n2];
        int n3 = 0;
        for (pM pM2 : collection) {
            object = pM2;
            dArray[n3] = ((pM)object).c;
            object = pM2;
            dArray2[n3] = ((pM)object).a;
            ++n3;
        }
        pD.a a2 = new pD.a(this.a, collection);
        int n4 = Integer.MAX_VALUE;
        object = new pT();
        new pT().a = Integer.MAX_VALUE;
        ((pT)v0).b = n4 = this.c;
        sM sM2 = new sM(dArray2);
        object = ((pT)object).b(this.b).a(dArray);
        v1.c = sM2;
        return ((pT)object).a(a2.a(), a2.b()).a();
    }
}

