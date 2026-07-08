/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.mI;
import org.valkyrienskies.core.impl.shadow.mV;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;

public final class mW
implements mI {
    private static mV b(double[] dArray, double[] dArray2, double[][] dArray3) {
        if (dArray == null || dArray2 == null || dArray3 == null || dArray3[0] == null) {
            throw new pl_0();
        }
        if (dArray.length == 0 || dArray2.length == 0 || dArray3.length == 0) {
            throw new pf_0();
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        return new mV(dArray, dArray2, dArray3);
    }

    public final /* synthetic */ kP a(double[] dArray, double[] dArray2, double[][] dArray3) {
        if (dArray == null || dArray2 == null || dArray3 == null || dArray3[0] == null) {
            throw new pl_0();
        }
        if (dArray.length == 0 || dArray2.length == 0 || dArray3.length == 0) {
            throw new pf_0();
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        return new mV(dArray, dArray2, dArray3);
    }
}

