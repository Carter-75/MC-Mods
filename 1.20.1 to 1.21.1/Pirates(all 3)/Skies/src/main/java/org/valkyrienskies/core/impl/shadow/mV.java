/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.mB;
import org.valkyrienskies.core.impl.shadow.nl_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oT;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.po_0;

public final class mV
implements kP {
    private static final int a = 5;
    private final double[] b;
    private final double[] c;
    private final double[][] d;

    public mV(double[] dArray, double[] dArray2, double[][] dArray3) {
        if (dArray == null || dArray2 == null || dArray3 == null || dArray3[0] == null) {
            throw new pl_0();
        }
        int n2 = dArray.length;
        int n3 = dArray2.length;
        if (n2 == 0 || n3 == 0 || dArray3.length == 0 || dArray3[0].length == 0) {
            throw new pf_0();
        }
        if (n2 < 5 || n3 < 5 || dArray3.length < 5 || dArray3[0].length < 5) {
            throw new oT();
        }
        if (n2 != dArray3.length) {
            throw new oS(n2, dArray3.length);
        }
        if (n3 != dArray3[0].length) {
            throw new oS(n3, dArray3[0].length);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        this.b = (double[])dArray.clone();
        this.c = (double[])dArray2.clone();
        this.d = (double[][])dArray3.clone();
    }

    public final double a(double d2, double d3) {
        int n2;
        mB mB2 = new mB();
        int n3 = mV.a(d2, this.b, 2, 5);
        int n4 = mV.a(d3, this.c, 2, 5);
        double[] dArray = new double[5];
        double[] dArray2 = new double[5];
        double[] dArray3 = new double[5];
        double[] dArray4 = new double[5];
        for (n2 = 0; n2 < 5; ++n2) {
            dArray[n2] = this.b[n3 + n2];
            dArray2[n2] = this.c[n4 + n2];
        }
        for (n2 = 0; n2 < 5; ++n2) {
            for (int i2 = 0; i2 < 5; ++i2) {
                dArray3[i2] = this.d[n3 + i2][n4 + n2];
            }
            nl_0 nl_02 = mB2.a(dArray, dArray3);
            dArray4[n2] = nl_02.a(d2);
        }
        nl_0 nl_03 = mB2.a(dArray2, dArray4);
        double d4 = nl_03.a(d3);
        return d4;
    }

    private boolean b(double d2, double d3) {
        return !(d2 < this.b[0] || d2 > this.b[this.b.length - 1] || d3 < this.c[0]) && !(d3 > this.c[this.c.length - 1]);
    }

    private static int a(double d2, double[] dArray, int n2, int n3) {
        n2 = Arrays.binarySearch(dArray, d2);
        if (n2 == -1 || n2 == -dArray.length - 1) {
            throw new po_0(d2, (Number)dArray[0], dArray[dArray.length - 1]);
        }
        n2 = n2 < 0 ? -n2 - 2 - 1 : (n2 -= 2);
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 + 5 >= dArray.length) {
            n2 = dArray.length - 5;
        }
        return n2;
    }
}

