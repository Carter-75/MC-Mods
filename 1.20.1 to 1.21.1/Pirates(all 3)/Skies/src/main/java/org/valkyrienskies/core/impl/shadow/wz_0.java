/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.ws_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.wz
 */
public final class wz_0
extends ws_0 {
    private static final long a = -7179861704951334960L;
    private double[] b;
    private double c;
    private double n;
    private double[] o;
    private sy_0 p;

    public wz_0() {
    }

    private wz_0(wz_0 wz_02) {
        super(wz_02);
        this.c = wz_02.c;
        this.n = wz_02.n;
        if (wz_02.o != null) {
            this.o = (double[])wz_02.o.clone();
        }
        if (wz_02.p != null) {
            sy_0 sy_02 = wz_02.p;
            this.p = new sy_0(sy_02.a, true);
        }
        if (wz_02.b != null) {
            this.b = (double[])wz_02.b.clone();
        }
    }

    protected final ws_0 a() {
        return new wz_0(this);
    }

    public final void a(double[] dArray, boolean bl, uE uE2, uE[] uEArray) {
        super.a(dArray, bl, uE2, uEArray);
        this.b = new double[dArray.length];
    }

    public final void a(double d2, double d3, double[] dArray, sy_0 sy_02) {
        this.n = d2;
        this.c = d3;
        this.o = dArray;
        this.p = sy_02;
        wz_0 wz_02 = this;
        wz_02.d(wz_02.i());
    }

    public final void e(double d2) {
        double d3 = d2 / this.c;
        int n2 = 0;
        while (n2 < this.o.length) {
            int n3 = n2++;
            this.o[n3] = this.o[n3] * d3;
        }
        Object object = this.p;
        object = ((sy_0)object).a;
        double d4 = d3;
        for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
            d4 *= d3;
            Object object2 = object[i2];
            int n4 = 0;
            while (n4 < ((Object)object2).length) {
                Object object3 = object2;
                int n5 = n4++;
                object3[n5] = object3[n5] * d4;
            }
        }
        this.c = d2;
    }

    private double[] n() {
        this.k();
        return this.b;
    }

    protected final void a(double d2, double d3) {
        int n2;
        double d4 = this.f - this.n;
        double d5 = d4 / this.c;
        Arrays.fill(this.b, 0.0);
        Arrays.fill(this.h, 0.0);
        Object object = this.p;
        object = ((sy_0)object).a;
        for (n2 = ((sy_0)object).a.length - 1; n2 >= 0; --n2) {
            int n3 = n2 + 2;
            Object object2 = object[n2];
            double d6 = BY.a(d5, n3);
            int n4 = 0;
            while (n4 < ((Object)object2).length) {
                reference var16_8 = object2[n4] * d6;
                int n5 = n4;
                this.b[n5] = this.b[n5] + var16_8;
                int n6 = n4++;
                this.h[n6] = this.h[n6] + (double)n3 * var16_8;
            }
        }
        for (n2 = 0; n2 < this.e.length; ++n2) {
            int n7 = n2;
            this.b[n7] = this.b[n7] + this.o[n2] * d5;
            this.g[n2] = this.e[n2] + this.b[n2];
            this.h[n2] = (this.h[n2] + this.o[n2] * d5) / d4;
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void writeExternal(ObjectOutput out) {
        void var1_1;
        int n2;
        this.a(out);
        out.writeDouble(this.c);
        out.writeDouble(this.n);
        int n3 = n2 = this.e == null ? -1 : this.e.length;
        if (this.o == null) {
            out.writeBoolean(false);
        } else {
            out.writeBoolean(true);
            for (int i2 = 0; i2 < n2; ++i2) {
                out.writeDouble(this.o[i2]);
            }
        }
        if (this.p == null) {
            out.writeBoolean(false);
            return;
        }
        out.writeBoolean(true);
        var1_1.writeObject(this.p);
    }

    /*
     * WARNING - void declaration
     */
    public final void readExternal(ObjectInput in) {
        void var1_1;
        int n2;
        double d2 = this.a(in);
        this.c = in.readDouble();
        this.n = in.readDouble();
        int n3 = this.e == null ? -1 : this.e.length;
        boolean bl = in.readBoolean();
        if (bl) {
            this.o = new double[n3];
            for (n2 = 0; n2 < n3; ++n2) {
                this.o[n2] = in.readDouble();
            }
        } else {
            this.o = null;
        }
        this.p = (n2 = in.readBoolean()) != 0 ? (sy_0)var1_1.readObject() : null;
        if (bl && n2 != 0) {
            this.b = new double[n3];
            this.d(d2);
            return;
        }
        this.b = null;
    }
}

