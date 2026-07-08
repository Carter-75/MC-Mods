/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.mM;
import org.valkyrienskies.core.impl.shadow.mT;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.zN;

public final class mS
implements mT {
    final double a;
    private final mM c;
    private final boolean d;
    final double b;

    private mS(int n2, int n3, double d2, double d3, double d4, double d5, boolean bl, double d6) {
        this(new mM(n2, n3, d2, d3, d4, new zN(n2)), d5, bl, d6);
    }

    private mS(mM mM2, double d2, boolean bl, double d3) {
        if (d2 < 0.0) {
            throw new pj_0(d2);
        }
        this.c = mM2;
        this.a = d2;
        this.d = bl;
        this.b = d3;
    }

    public final kW a(double[][] dArray, double[] dArray2) {
        if (dArray == null || dArray2 == null) {
            throw new pl_0();
        }
        if (dArray.length == 0) {
            throw new pf_0();
        }
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray[0] == null) {
            throw new pl_0();
        }
        mM mM2 = this.c;
        int n2 = mM2.c;
        if (n2 != dArray[0].length) {
            throw new oS(dArray[0].length, n2);
        }
        mM mM3 = this.d ? this.c : this.c.a();
        return new kW(this, mM3, dArray, dArray2){
            private /* synthetic */ mM a;
            private /* synthetic */ double[][] b;
            private /* synthetic */ double[] c;
            private /* synthetic */ mS d;
            {
                this.d = mS2;
                this.a = mM2;
                this.b = dArray;
                this.c = dArray2;
            }

            public final double a(double[] object) {
                double d2;
                double d3;
                double d4;
                double d5;
                int n2;
                Object object2 = object;
                mS mS2 = this.d;
                object = mS2;
                object = this.d;
                double d6 = ((mS)object).b;
                double d7 = mS2.a;
                double[] dArray2 = this.c;
                double[][] dArray3 = this.b;
                Object dArray4 = object2;
                object = this.a;
                if (d7 < 0.0) {
                    throw new pj_0(d7);
                }
                Object object22 = object;
                for (n2 = 0; n2 < ((mM)object22).d; ++n2) {
                    ((mM)object22).b.set(n2, new mM.b(0.0, 0.0));
                }
                int n3 = dArray3.length;
                for (int i2 = 0; i2 < n3; ++i2) {
                    double d8;
                    double d9;
                    double[] dArray = ch_0.a(dArray3[i2], (double[])dArray4);
                    object22 = dArray;
                    double d10 = ch_0.d(dArray);
                    if (BY.w(d9) < d6) {
                        return dArray2[i2];
                    }
                    d5 = d8 = BY.a(d10, -d7);
                    d4 = dArray2[i2];
                    Object object3 = object22;
                    object22 = object;
                    for (int i3 = 0; i3 < ((mM)object22).d; ++i3) {
                        mM.b b2;
                        double d11;
                        double d12;
                        Object object4 = ((mM)object22).a.get(i3);
                        double[] object5 = ((mM.a)object4).a;
                        Object object6 = object3;
                        object4 = ((mM.a)object4).a;
                        d3 = ch_0.h(((mM.a)object4).a, (double[])object6) / (ch_0.d((double[])object4) * ch_0.d((double[])object6));
                        if (!(d12 > 0.0)) continue;
                        double d13 = d3 * d5;
                        if (!(d11 > ((mM)object22).f)) continue;
                        object4 = ((mM)object22).b.get(i3);
                        if (!(d13 > b2.a)) continue;
                        ((mM)object22).b.set(i3, new mM.b(d13, d4));
                    }
                }
                object22 = object;
                n2 = 0;
                d4 = 0.0;
                d5 = 0.0;
                Iterator<mM.b> iterator2 = ((mM)object22).b.iterator();
                while (iterator2.hasNext()) {
                    mM.b b3;
                    mM.b b32 = b3 = iterator2.next();
                    d3 = b3.a;
                    if (d3 != 0.0) {
                        b32 = b3;
                        d4 += d3 * b32.b;
                        d5 += d3;
                        continue;
                    }
                    ++n2;
                }
                double d14 = (double)n2 / (double)((mM)object22).d;
                if (d2 <= ((mM)object22).e) {
                    return d4 / d5;
                }
                return ((mM)object22).g;
            }
        };
    }

    static /* synthetic */ double a(mS mS2) {
        return mS2.a;
    }

    static /* synthetic */ double b(mS mS2) {
        return mS2.b;
    }
}

