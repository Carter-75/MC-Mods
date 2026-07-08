/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.mD;
import org.valkyrienskies.core.impl.shadow.mI;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;

public final class mE
implements mI {
    private 1 b(double[] dArray, double[] dArray2, double[][] dArray3) {
        if (dArray.length == 0 || dArray2.length == 0 || dArray3.length == 0) {
            throw new pf_0();
        }
        if (dArray.length != dArray3.length) {
            throw new oS(dArray.length, dArray3.length);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        int n2 = dArray.length;
        int n3 = dArray2.length;
        double[][] dArray4 = new double[n2][n3];
        double[][] dArray5 = new double[n2][n3];
        double[][] dArray6 = new double[n2][n3];
        for (int i2 = 1; i2 < n2 - 1; ++i2) {
            int n4 = i2 + 1;
            int n5 = i2 - 1;
            double d2 = dArray[n4];
            double d3 = dArray[n5];
            double d4 = d2 - d3;
            for (int i3 = 1; i3 < n3 - 1; ++i3) {
                int n6 = i3 + 1;
                int n7 = i3 - 1;
                double d5 = dArray2[n6];
                double d6 = dArray2[n7];
                double d7 = d5 - d6;
                dArray4[i2][i3] = (dArray3[n4][i3] - dArray3[n5][i3]) / d4;
                dArray5[i2][i3] = (dArray3[i2][n6] - dArray3[i2][n7]) / d7;
                double d8 = d4 * d7;
                dArray6[i2][i3] = (dArray3[n4][n6] - dArray3[n4][n7] - dArray3[n5][n6] + dArray3[n5][n7]) / d8;
            }
        }
        return new mD(this, dArray, dArray2, dArray3, dArray4, dArray5, dArray6, dArray, dArray2){
            private /* synthetic */ double[] a;
            private /* synthetic */ double[] b;
            private /* synthetic */ mE c;
            {
                this.c = mE2;
                this.a = dArray7;
                this.b = dArray8;
                super(dArray, dArray2, dArray3, dArray4, dArray5, dArray6);
            }

            public final boolean b(double d2, double d3) {
                return !(d2 < this.a[1] || d2 > this.a[this.a.length - 2] || d3 < this.b[1]) && !(d3 > this.b[this.b.length - 2]);
            }
        };
    }

    public final /* synthetic */ kP a(double[] object, double[] dArray, double[][] object2) {
        double[][] dArray2 = object2;
        object2 = dArray;
        dArray = object;
        object = this;
        if (((double[])dArray).length == 0 || ((double[][])object2).length == 0 || dArray2.length == 0) {
            throw new pf_0();
        }
        if (((double[])dArray).length != dArray2.length) {
            throw new oS(((double[])dArray).length, dArray2.length);
        }
        ch_0.a(dArray);
        ch_0.a((double[])object2);
        int n2 = ((double[])dArray).length;
        int n3 = ((double[][])object2).length;
        double[][] dArray3 = new double[n2][n3];
        double[][] dArray4 = new double[n2][n3];
        double[][] dArray5 = new double[n2][n3];
        for (int i2 = 1; i2 < n2 - 1; ++i2) {
            int n4 = i2 + 1;
            int n5 = i2 - 1;
            double d2 = dArray[n4];
            double d3 = dArray[n5];
            double d4 = d2 - d3;
            for (int i3 = 1; i3 < n3 - 1; ++i3) {
                int n6 = i3 + 1;
                int n7 = i3 - 1;
                double[] dArray6 = object2[n6];
                double[] dArray7 = object2[n7];
                reference var29_21 = dArray6 - dArray7;
                dArray3[i2][i3] = (double)((dArray2[n4][i3] - dArray2[n5][i3]) / d4);
                dArray4[i2][i3] = (double)((dArray2[i2][n6] - dArray2[i2][n7]) / var29_21);
                double d5 = d4 * var29_21;
                dArray5[i2][i3] = (double)((dArray2[n4][n6] - dArray2[n4][n7] - dArray2[n5][n6] + dArray2[n5][n7]) / d5);
            }
        }
        return new /* invalid duplicate definition of identical inner class */;
    }
}

