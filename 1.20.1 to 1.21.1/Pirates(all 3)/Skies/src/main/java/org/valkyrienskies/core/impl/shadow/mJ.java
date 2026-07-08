/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.ng_0;
import org.valkyrienskies.core.impl.shadow.nj_0;
import org.valkyrienskies.core.impl.shadow.nk_0;

public final class mJ
implements Serializable,
ng_0 {
    private static final long a = 107049519551235069L;

    private static nk_0 a(double[] dArray, double[] dArray2) {
        nj_0.a(dArray, dArray2, true);
        double[] dArray3 = new double[dArray.length - 1];
        System.arraycopy(dArray, 0, dArray3, 0, dArray3.length);
        nj_0.a(dArray, dArray2, true);
        dArray2 = (double[])dArray2.clone();
        int n2 = dArray.length;
        double[] dArray4 = new double[n2];
        double[] dArray5 = dArray4;
        dArray4[0] = dArray2[0];
        for (int i2 = 1; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n2 - i2; ++i3) {
                double d2 = dArray[i3 + i2] - dArray[i3];
                dArray2[i3] = (dArray2[i3 + 1] - dArray2[i3]) / d2;
            }
            dArray5[i2] = dArray2[0];
        }
        dArray = dArray5;
        return new nk_0(dArray, dArray3);
    }

    private static double[] c(double[] dArray, double[] dArray2) {
        nj_0.a(dArray, dArray2, true);
        dArray2 = (double[])dArray2.clone();
        int n2 = dArray.length;
        double[] dArray3 = new double[n2];
        double[] dArray4 = dArray3;
        dArray3[0] = dArray2[0];
        for (int i2 = 1; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n2 - i2; ++i3) {
                double d2 = dArray[i3 + i2] - dArray[i3];
                dArray2[i3] = (dArray2[i3 + 1] - dArray2[i3]) / d2;
            }
            dArray4[i2] = dArray2[0];
        }
        return dArray4;
    }

    public final /* synthetic */ lc_0 b(double[] dArray, double[] dArray2) {
        nj_0.a(dArray, dArray2, true);
        double[] dArray3 = new double[dArray.length - 1];
        System.arraycopy(dArray, 0, dArray3, 0, dArray3.length);
        nj_0.a(dArray, dArray2, true);
        dArray2 = (double[])dArray2.clone();
        int n2 = dArray.length;
        double[] dArray4 = new double[n2];
        double[] dArray5 = dArray4;
        dArray4[0] = dArray2[0];
        for (int i2 = 1; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n2 - i2; ++i3) {
                double d2 = dArray[i3 + i2] - dArray[i3];
                dArray2[i3] = (dArray2[i3 + 1] - dArray2[i3]) / d2;
            }
            dArray5[i2] = dArray2[0];
        }
        dArray = dArray5;
        return new nk_0(dArray, dArray3);
    }
}

