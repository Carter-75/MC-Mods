/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pD;
import org.valkyrienskies.core.impl.shadow.pM;
import org.valkyrienskies.core.impl.shadow.pT;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.sM;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class pJ
extends pD {
    private static final ni_0.a a = new ni_0.a();
    private final double[] b;
    private final int c;

    private pJ(double[] dArray, int n2) {
        this.b = dArray;
        this.c = n2;
    }

    private static pJ a(int n2) {
        return new pJ(new double[n2 + 1], Integer.MAX_VALUE);
    }

    private pJ a(double[] dArray) {
        return new pJ((double[])dArray.clone(), this.c);
    }

    private pJ b(int n2) {
        return new pJ(this.b, n2);
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
        pD.a a2 = new pD.a(a, collection);
        if (this.b == null) {
            throw new oY();
        }
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

