/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.ws_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.wm
 */
abstract class wm_0
extends ws_0 {
    protected double[] a;
    protected double[][] b;
    protected uA c;

    protected wm_0() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    wm_0(wm_0 wm_02) {
        super(wm_02);
        if (wm_02.e != null) {
            this.a = (double[])wm_02.a.clone();
            this.b = new double[wm_02.b.length][];
            for (int i2 = 0; i2 < wm_02.b.length; ++i2) {
                this.b[i2] = (double[])wm_02.b[i2].clone();
            }
        } else {
            this.a = null;
            this.b = null;
        }
        this.c = null;
    }

    public void a(uA uA2, double[] dArray, double[][] dArray2, boolean bl, uE uE2, uE[] uEArray) {
        this.a(dArray, bl, uE2, uEArray);
        this.a = null;
        this.b = dArray2;
        this.c = uA2;
    }

    public final void c() {
        this.a = (double[])this.e.clone();
        super.c();
    }

    public void writeExternal(ObjectOutput out) {
        int n2;
        this.a(out);
        int n3 = this.e == null ? -1 : this.e.length;
        for (n2 = 0; n2 < n3; ++n2) {
            out.writeDouble(this.a[n2]);
        }
        n2 = this.b == null ? -1 : this.b.length;
        out.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                out.writeDouble(this.b[i2][i3]);
            }
        }
    }

    public void readExternal(ObjectInput in) {
        int n2;
        double d2 = this.a(in);
        int n3 = this.e == null ? -1 : this.e.length;
        if (n3 < 0) {
            this.a = null;
        } else {
            this.a = new double[n3];
            for (n2 = 0; n2 < n3; ++n2) {
                this.a[n2] = in.readDouble();
            }
        }
        n2 = in.readInt();
        this.b = n2 < 0 ? null : new double[n2][];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.b[i2] = n3 < 0 ? null : new double[n3];
            for (int i3 = 0; i3 < n3; ++i3) {
                this.b[i2][i3] = in.readDouble();
            }
        }
        this.c = null;
        if (this.e != null) {
            this.d(d2);
            return;
        }
        this.f = d2;
    }
}

