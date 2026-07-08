/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.wB;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ws
 */
public abstract class ws_0
implements wB {
    protected double d;
    protected double[] e;
    protected double f;
    protected double[] g;
    protected double[] h;
    private double[] a;
    private double[] b;
    private double[][] c;
    private double[][] n;
    public double i;
    public double j;
    public double k;
    public double l;
    private boolean o;
    public boolean m;
    private boolean p;
    private uE q;
    private uE[] r;

    public ws_0() {
        this.i = Double.NaN;
        this.j = Double.NaN;
        this.k = Double.NaN;
        this.l = Double.NaN;
        this.d = Double.NaN;
        this.f = Double.NaN;
        this.e = null;
        this.o = false;
        this.m = true;
        this.p = true;
        this.q = null;
        this.r = null;
        this.c(-1);
    }

    public ws_0(double[] dArray, boolean bl, uE uE2, uE[] uEArray) {
        this.i = Double.NaN;
        this.j = Double.NaN;
        this.k = Double.NaN;
        this.l = Double.NaN;
        this.d = Double.NaN;
        this.f = Double.NaN;
        this.e = dArray;
        this.o = false;
        this.m = bl;
        this.p = true;
        this.q = uE2;
        this.r = uEArray == null ? null : (uE[])uEArray.clone();
        this.c(dArray.length);
    }

    public ws_0(ws_0 ws_02) {
        this.i = ws_02.i;
        this.j = ws_02.j;
        this.k = ws_02.k;
        this.l = ws_02.l;
        this.d = ws_02.d;
        this.f = ws_02.f;
        if (ws_02.e == null) {
            this.e = null;
            this.q = null;
            this.r = null;
            this.c(-1);
        } else {
            this.e = (double[])ws_02.e.clone();
            this.g = (double[])ws_02.g.clone();
            this.h = (double[])ws_02.h.clone();
            this.a = (double[])ws_02.a.clone();
            this.b = (double[])ws_02.b.clone();
            this.c = new double[ws_02.c.length][];
            this.n = new double[ws_02.n.length][];
            for (int i2 = 0; i2 < this.c.length; ++i2) {
                this.c[i2] = (double[])ws_02.c[i2].clone();
                this.n[i2] = (double[])ws_02.n[i2].clone();
            }
        }
        this.o = ws_02.o;
        this.m = ws_02.m;
        this.p = ws_02.p;
        this.q = ws_02.q;
        this.r = ws_02.r == null ? null : (uE[])ws_02.r.clone();
    }

    private void c(int n2) {
        if (n2 < 0) {
            this.g = null;
            this.h = null;
            this.a = null;
            this.b = null;
            this.c = null;
            this.n = null;
            return;
        }
        this.g = new double[n2];
        this.h = new double[n2];
        uE uE2 = this.q;
        this.a = new double[uE2.b];
        uE2 = this.q;
        this.b = new double[uE2.b];
        if (this.r == null) {
            this.c = null;
            this.n = null;
            return;
        }
        this.c = new double[this.r.length][];
        this.n = new double[this.r.length][];
        for (n2 = 0; n2 < this.r.length; ++n2) {
            uE2 = this.r[n2];
            this.c[n2] = new double[uE2.b];
            uE2 = this.r[n2];
            this.n[n2] = new double[uE2.b];
        }
    }

    protected void a(double[] dArray, boolean bl, uE uE2, uE[] uEArray) {
        this.i = Double.NaN;
        this.j = Double.NaN;
        this.k = Double.NaN;
        this.l = Double.NaN;
        this.d = Double.NaN;
        this.f = Double.NaN;
        this.e = dArray;
        this.o = false;
        this.m = bl;
        this.p = true;
        this.q = uE2;
        this.r = (uE[])uEArray.clone();
        this.c(dArray.length);
    }

    public final wB d() {
        this.m();
        return this.a();
    }

    protected abstract ws_0 a();

    public void c() {
        this.k = this.i = this.j;
        this.l = this.j;
    }

    public void a(double d2) {
        this.l = this.j = d2;
        this.d = this.j - this.i;
        this.d(d2);
        this.o = false;
    }

    public final void b(double d2) {
        this.k = d2;
    }

    public final void c(double d2) {
        this.l = d2;
    }

    public final double e() {
        return this.i;
    }

    public final double f() {
        return this.j;
    }

    public final double g() {
        return this.k;
    }

    public final double h() {
        return this.l;
    }

    public final double i() {
        return this.f;
    }

    public final void d(double d2) {
        this.f = d2;
        this.p = true;
    }

    public final boolean j() {
        return this.m;
    }

    protected abstract void a(double var1, double var3);

    private void n() {
        if (this.p) {
            double d2 = this.j - this.f;
            double d3 = this.d == 0.0 ? 0.0 : (this.d - d2) / this.d;
            this.a(d3, d2);
            this.p = false;
        }
    }

    public final double[] k() {
        this.n();
        this.q.a(this.g, this.a);
        return this.a;
    }

    public final double[] l() {
        this.n();
        this.q.a(this.h, this.b);
        return this.b;
    }

    public final double[] a(int n2) {
        this.n();
        this.r[n2].a(this.g, this.c[n2]);
        return this.c[n2];
    }

    public final double[] b(int n2) {
        this.n();
        this.r[n2].a(this.h, this.n[n2]);
        return this.n[n2];
    }

    public final void m() {
        if (!this.o) {
            this.b();
            this.o = true;
        }
    }

    protected void b() {
    }

    public abstract void writeExternal(ObjectOutput var1);

    public abstract void readExternal(ObjectInput var1);

    protected final void a(ObjectOutput objectOutput) {
        if (this.e == null) {
            objectOutput.writeInt(-1);
        } else {
            objectOutput.writeInt(this.e.length);
        }
        objectOutput.writeDouble(this.i);
        objectOutput.writeDouble(this.j);
        objectOutput.writeDouble(this.k);
        objectOutput.writeDouble(this.l);
        objectOutput.writeDouble(this.d);
        objectOutput.writeBoolean(this.m);
        objectOutput.writeObject(this.q);
        objectOutput.write(this.r.length);
        uE[] uEArray = this.r;
        int n2 = this.r.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            uE uE2 = uEArray[i2];
            objectOutput.writeObject(uE2);
        }
        if (this.e != null) {
            for (int i3 = 0; i3 < this.e.length; ++i3) {
                objectOutput.writeDouble(this.e[i3]);
            }
        }
        objectOutput.writeDouble(this.f);
        try {
            this.m();
            return;
        }
        catch (pc_0 pc_02) {
            IOException iOException = new IOException(pc_02.getLocalizedMessage());
            iOException.initCause(pc_02);
            throw iOException;
        }
    }

    protected final double a(ObjectInput objectInput) {
        int n2;
        int n3 = objectInput.readInt();
        this.i = objectInput.readDouble();
        this.j = objectInput.readDouble();
        this.k = objectInput.readDouble();
        this.l = objectInput.readDouble();
        this.d = objectInput.readDouble();
        this.m = objectInput.readBoolean();
        this.q = (uE)objectInput.readObject();
        this.r = new uE[objectInput.read()];
        for (n2 = 0; n2 < this.r.length; ++n2) {
            this.r[n2] = (uE)objectInput.readObject();
        }
        this.p = true;
        if (n3 < 0) {
            this.e = null;
        } else {
            this.e = new double[n3];
            for (n2 = 0; n2 < this.e.length; ++n2) {
                this.e[n2] = objectInput.readDouble();
            }
        }
        this.f = Double.NaN;
        this.c(n3);
        this.o = true;
        return objectInput.readDouble();
    }
}

