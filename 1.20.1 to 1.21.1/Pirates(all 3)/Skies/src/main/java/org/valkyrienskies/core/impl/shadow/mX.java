/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.kP;
import org.valkyrienskies.core.impl.shadow.mG;
import org.valkyrienskies.core.impl.shadow.mH;
import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pK;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.wV;
import org.valkyrienskies.core.impl.shadow.xJ;

@Deprecated
public final class mX
extends mH {
    private final pK a;
    private final int b;
    private final pK c;
    private final int d;

    public mX() {
        this(3);
    }

    private mX(int n2) {
        this(3, 3);
    }

    private mX(int n2, int n3) {
        if (n2 < 0) {
            throw new pj_0(n2);
        }
        if (n3 < 0) {
            throw new pj_0(n3);
        }
        this.b = n2;
        this.d = n3;
        wV wV2 = new wV(100.0 * cq_0.a, 100.0 * cq_0.b);
        this.a = new pK(new xJ(false, wV2));
        this.c = new pK(new xJ(false, wV2));
    }

    public final mG b(double[] dArray, double[] dArray2, double[][] object) {
        int n2;
        int n3;
        if (dArray.length == 0 || dArray2.length == 0 || ((double[][])object).length == 0) {
            throw new pf_0();
        }
        if (dArray.length != ((double[][])object).length) {
            throw new oS(dArray.length, ((double[][])object).length);
        }
        int n4 = dArray.length;
        int n5 = dArray2.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            if (object[i2].length == n5) continue;
            throw new oS(object[i2].length, n5);
        }
        ch_0.a(dArray);
        ch_0.a(dArray2);
        Object object2 = new ni_0[n5];
        for (int i3 = 0; i3 < n5; ++i3) {
            this.a.b();
            for (n3 = 0; n3 < n4; ++n3) {
                this.a.a(1.0, dArray[n3], object[n3][i3]);
            }
            object2[i3] = new ni_0(this.a.a(new double[this.b + 1]));
        }
        double[][] dArray3 = new double[n4][n5];
        for (n3 = 0; n3 < n5; ++n3) {
            object = object2[n3];
            for (n2 = 0; n2 < n4; ++n2) {
                dArray3[n2][n3] = ((ni_0)object).a(dArray[n2]);
            }
        }
        ni_0[] ni_0Array = new ni_0[n4];
        for (int i4 = 0; i4 < n4; ++i4) {
            this.c.b();
            for (n2 = 0; n2 < n5; ++n2) {
                this.c.a(1.0, dArray2[n2], dArray3[i4][n2]);
            }
            ni_0Array[i4] = new ni_0(this.c.a(new double[this.d + 1]));
        }
        double[][] dArray4 = new double[n4][n5];
        for (n2 = 0; n2 < n4; ++n2) {
            object2 = ni_0Array[n2];
            for (int i5 = 0; i5 < n5; ++i5) {
                dArray4[n2][i5] = ((ni_0)object2).a(dArray2[i5]);
            }
        }
        return super.b(dArray, dArray2, dArray4);
    }

    public final /* synthetic */ kP a(double[] dArray, double[] dArray2, double[][] dArray3) {
        return ((mH)this).b(dArray, dArray2, dArray3);
    }
}

