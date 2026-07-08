/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.ng_0;
import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.nl_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class mB
implements ng_0 {
    private static final int a = 5;

    public final nl_0 a(double[] dArray, double[] dArray2) {
        int n2;
        int n3;
        if (dArray == null || dArray2 == null) {
            throw new pl_0();
        }
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length < 5) {
            throw new pn_0((pw_0)px_0.NUMBER_OF_POINTS, (Number)dArray.length, 5, true);
        }
        ch_0.a(dArray);
        int n4 = dArray.length - 1;
        double[] dArray3 = new double[n4];
        double[] dArray4 = new double[n4];
        for (n3 = 0; n3 < dArray3.length; ++n3) {
            dArray3[n3] = (dArray2[n3 + 1] - dArray2[n3]) / (dArray[n3 + 1] - dArray[n3]);
        }
        for (n3 = 1; n3 < dArray4.length; ++n3) {
            dArray4[n3] = BY.w(dArray3[n3] - dArray3[n3 - 1]);
        }
        double[] dArray5 = new double[dArray.length];
        for (n2 = 2; n2 < dArray5.length - 2; ++n2) {
            double d2 = dArray4[n2 + 1];
            double d3 = dArray4[n2 - 1];
            if (cq_0.a(d2, 0.0) && cq_0.a(d3, 0.0)) {
                double d4 = dArray[n2];
                double d5 = dArray[n2 + 1];
                double d6 = dArray[n2 - 1];
                dArray5[n2] = ((d5 - d4) * dArray3[n2 - 1] + (d4 - d6) * dArray3[n2]) / (d5 - d6);
                continue;
            }
            dArray5[n2] = (d2 * dArray3[n2 - 1] + d3 * dArray3[n2]) / (d2 + d3);
        }
        dArray5[0] = mB.a(dArray, dArray2, 0, 0, 1, 2);
        dArray5[1] = mB.a(dArray, dArray2, 1, 0, 1, 2);
        dArray5[dArray.length - 2] = mB.a(dArray, dArray2, dArray.length - 2, dArray.length - 3, dArray.length - 2, dArray.length - 1);
        dArray5[dArray.length - 1] = mB.a(dArray, dArray2, dArray.length - 1, dArray.length - 3, dArray.length - 2, dArray.length - 1);
        dArray4 = dArray5;
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length != dArray4.length) {
            throw new oS(dArray.length, dArray4.length);
        }
        if (dArray.length < 2) {
            throw new pn_0((pw_0)px_0.NUMBER_OF_POINTS, (Number)dArray.length, 2, true);
        }
        int n5 = dArray.length - 1;
        ni_0[] ni_0Array = new ni_0[n5];
        dArray5 = new double[4];
        for (n2 = 0; n2 < ni_0Array.length; ++n2) {
            double d7 = dArray[n2 + 1] - dArray[n2];
            double d8 = d7 * d7;
            double d9 = dArray2[n2];
            double d10 = dArray2[n2 + 1];
            double d11 = dArray4[n2];
            double d12 = dArray4[n2 + 1];
            dArray5[0] = d9;
            dArray5[1] = dArray4[n2];
            dArray5[2] = (3.0 * (d10 - d9) / d7 - d11 * 2.0 - d12) / d7;
            dArray5[3] = (2.0 * (d9 - d10) / d7 + d11 + d12) / d8;
            ni_0Array[n2] = new ni_0(dArray5);
        }
        return new nl_0(dArray, ni_0Array);
    }

    private static double a(double[] dArray, double[] dArray2, int n2, int n3, int n4, int n5) {
        double d2;
        double d3 = dArray2[n3];
        double d4 = dArray2[n4];
        double d5 = dArray2[n5];
        double d6 = dArray[n2] - dArray[n3];
        double d7 = dArray[n4] - dArray[n3];
        double d8 = d2 = dArray[n5] - dArray[n3];
        double d9 = (d5 - d3 - d2 / d7 * (d4 - d3)) / (d8 * d8 - d7 * d2);
        double d10 = (d4 - d3 - d9 * d7 * d7) / d7;
        return d9 * 2.0 * d6 + d10;
    }

    private static nl_0 a(double[] dArray, double[] dArray2, double[] dArray3) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length != dArray3.length) {
            throw new oS(dArray.length, dArray3.length);
        }
        if (dArray.length < 2) {
            throw new pn_0((pw_0)px_0.NUMBER_OF_POINTS, (Number)dArray.length, 2, true);
        }
        int n2 = dArray.length - 1;
        ni_0[] ni_0Array = new ni_0[n2];
        double[] dArray4 = new double[4];
        for (int i2 = 0; i2 < ni_0Array.length; ++i2) {
            double d2 = dArray[i2 + 1] - dArray[i2];
            double d3 = d2 * d2;
            double d4 = dArray2[i2];
            double d5 = dArray2[i2 + 1];
            double d6 = dArray3[i2];
            double d7 = dArray3[i2 + 1];
            dArray4[0] = d4;
            dArray4[1] = dArray3[i2];
            dArray4[2] = (3.0 * (d5 - d4) / d2 - d6 * 2.0 - d7) / d2;
            dArray4[3] = (2.0 * (d4 - d5) / d2 + d6 + d7) / d3;
            ni_0Array[i2] = new ni_0(dArray4);
        }
        return new nl_0(dArray, ni_0Array);
    }

    public final /* synthetic */ lc_0 b(double[] dArray, double[] dArray2) {
        return this.a(dArray, dArray2);
    }
}

