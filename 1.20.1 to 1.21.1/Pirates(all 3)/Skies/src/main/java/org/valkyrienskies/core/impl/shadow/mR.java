/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.mQ;
import org.valkyrienskies.core.impl.shadow.mT;
import org.valkyrienskies.core.impl.shadow.zN;

@Deprecated
public final class mR
implements mT {
    private static int a = 2000;
    private static int b = 2;
    private final int c;
    private final int d;

    public mR() {
        this(2000, 2);
    }

    private mR(int n2, int n3) {
        this.c = 2000;
        this.d = 2;
    }

    public final kW a(double[][] dArray, double[] dArray2) {
        zN zN2 = new zN(dArray[0].length);
        return new mQ(dArray, dArray2, this.d, this.c, zN2);
    }
}

