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

public final class mY
implements ng_0 {
    public static nl_0 a(double[] dArray, double[] dArray2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length < 3) {
            throw new pn_0((pw_0)px_0.NUMBER_OF_POINTS, (Number)dArray.length, 3, true);
        }
        int n2 = dArray.length - 1;
        ch_0.a(dArray);
        double[] dArray3 = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray3[i2] = dArray[i2 + 1] - dArray[i2];
        }
        double[] dArray4 = new double[n2];
        double[] dArray5 = new double[n2 + 1];
        dArray4[0] = 0.0;
        dArray5[0] = 0.0;
        for (int i3 = 1; i3 < n2; ++i3) {
            double d2 = 2.0 * (dArray[i3 + 1] - dArray[i3 - 1]) - dArray3[i3 - 1] * dArray4[i3 - 1];
            dArray4[i3] = dArray3[i3] / d2;
            dArray5[i3] = (3.0 * (dArray2[i3 + 1] * dArray3[i3 - 1] - dArray2[i3] * (dArray[i3 + 1] - dArray[i3 - 1]) + dArray2[i3 - 1] * dArray3[i3]) / (dArray3[i3 - 1] * dArray3[i3]) - dArray3[i3 - 1] * dArray5[i3 - 1]) / d2;
        }
        double[] dArray6 = new double[n2];
        double[] dArray7 = new double[n2 + 1];
        double[] dArray8 = new double[n2];
        dArray5[n2] = 0.0;
        dArray7[n2] = 0.0;
        for (int i4 = n2 - 1; i4 >= 0; --i4) {
            dArray7[i4] = dArray5[i4] - dArray4[i4] * dArray7[i4 + 1];
            dArray6[i4] = (dArray2[i4 + 1] - dArray2[i4]) / dArray3[i4] - dArray3[i4] * (dArray7[i4 + 1] + 2.0 * dArray7[i4]) / 3.0;
            dArray8[i4] = (dArray7[i4 + 1] - dArray7[i4]) / (3.0 * dArray3[i4]);
        }
        ni_0[] ni_0Array = new ni_0[n2];
        dArray3 = new double[4];
        for (int i5 = 0; i5 < n2; ++i5) {
            dArray3[0] = dArray2[i5];
            dArray3[1] = dArray6[i5];
            dArray3[2] = dArray7[i5];
            dArray3[3] = dArray8[i5];
            ni_0Array[i5] = new ni_0(dArray3);
        }
        return new nl_0(dArray, ni_0Array);
    }

    public final /* synthetic */ lc_0 b(double[] dArray, double[] dArray2) {
        return mY.a(dArray, dArray2);
    }
}

