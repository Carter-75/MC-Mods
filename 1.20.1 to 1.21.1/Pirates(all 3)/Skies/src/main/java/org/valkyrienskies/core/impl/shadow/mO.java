/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.ng_0;
import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.nl_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class mO
implements ng_0 {
    private static nl_0 a(double[] dArray, double[] dArray2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length < 2) {
            throw new pn_0((pw_0)px_0.NUMBER_OF_POINTS, (Number)dArray.length, 2, true);
        }
        int n2 = dArray.length - 1;
        ch_0.a(dArray);
        double[] dArray3 = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray3[i2] = (dArray2[i2 + 1] - dArray2[i2]) / (dArray[i2 + 1] - dArray[i2]);
        }
        ni_0[] ni_0Array = new ni_0[n2];
        double[] dArray4 = new double[2];
        for (int i3 = 0; i3 < n2; ++i3) {
            dArray4[0] = dArray2[i3];
            dArray4[1] = dArray3[i3];
            ni_0Array[i3] = new ni_0(dArray4);
        }
        return new nl_0(dArray, ni_0Array);
    }

    public final /* synthetic */ lc_0 b(double[] dArray, double[] dArray2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length < 2) {
            throw new pn_0((pw_0)px_0.NUMBER_OF_POINTS, (Number)dArray.length, 2, true);
        }
        int n2 = dArray.length - 1;
        ch_0.a(dArray);
        double[] dArray3 = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray3[i2] = (dArray2[i2 + 1] - dArray2[i2]) / (dArray[i2 + 1] - dArray[i2]);
        }
        ni_0[] ni_0Array = new ni_0[n2];
        double[] dArray4 = new double[2];
        for (int i3 = 0; i3 < n2; ++i3) {
            dArray4[0] = dArray2[i3];
            dArray4[1] = dArray3[i3];
            ni_0Array[i3] = new ni_0(dArray4);
        }
        return new nl_0(dArray, ni_0Array);
    }
}

