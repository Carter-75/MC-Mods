/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.xV;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yg_0;
import org.valkyrienskies.core.impl.shadow.yo_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.yr_0;
import org.valkyrienskies.core.impl.shadow.yt_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.yz
 */
@Deprecated
public abstract class yz_0<FUNC extends kW>
implements xV<FUNC> {
    private cb_0 b = new cb_0();
    private ya_0<yp_0> c;
    yf_0 a;
    private double[] d;
    private double[] e;
    private double[] f;
    private kW g;

    @Deprecated
    public yz_0() {
        this(new yt_0());
    }

    public yz_0(ya_0<yp_0> ya_02) {
        this.c = ya_02;
    }

    @Override
    public final int a() {
        cb_0 cb_02 = this.b;
        return cb_02.a;
    }

    @Override
    public final int b() {
        cb_0 cb_02 = this.b;
        return cb_02.b;
    }

    @Override
    public final ya_0<yp_0> c() {
        return this.c;
    }

    protected final double a(double[] dArray) {
        try {
            this.b.c();
        }
        catch (pc_0 pc_02) {
            pc_0 pc_03 = pc_02;
            throw new pp_0(pc_03.a);
        }
        return this.g.a(dArray);
    }

    @Override
    @Deprecated
    public yp_0 a(int n2, FUNC FUNC, yf_0 yf_02, double[] dArray) {
        return this.a(n2, FUNC, yf_02, new yg_0(dArray));
    }

    private yp_0 b(int n2, FUNC FUNC, yf_0 yf_02, yo_0 ... yo_0Array) {
        return this.a(n2, FUNC, yf_02, yo_0Array);
    }

    @Override
    @Deprecated
    public yp_0 a(int n2, FUNC FUNC, yf_0 yf_02, double[] dArray) {
        return this.a(n2, FUNC, yf_02, new yg_0(dArray));
    }

    public yp_0 a(int n2, FUNC object, yf_0 object2, yo_0 ... yo_0Array) {
        this.b.a(n2);
        this.b.d();
        this.g = object;
        this.a = object2;
        object = yo_0Array;
        yz_0 yz_02 = this;
        for (Object object3 : object) {
            if (object3 instanceof yg_0) {
                yz_02.d = ((yg_0)object3).a();
                continue;
            }
            if (!(object3 instanceof yr_0)) continue;
            yr_0 yr_02 = (yr_0)object3;
            yz_02.e = yr_02.a();
            yz_02.f = yr_02.b();
        }
        yz_02 = this;
        if (yz_02.d != null) {
            int n3 = yz_02.d.length;
            if (yz_02.e != null) {
                if (yz_02.e.length != n3) {
                    throw new oS(yz_02.e.length, n3);
                }
                for (int i2 = 0; i2 < n3; ++i2) {
                    double d2 = yz_02.d[i2];
                    double d3 = yz_02.e[i2];
                    if (!(d2 < d3)) continue;
                    throw new pn_0(d2, (Number)d3, true);
                }
            }
            if (yz_02.f != null) {
                if (yz_02.f.length != n3) {
                    throw new oS(yz_02.f.length, n3);
                }
                for (int i3 = 0; i3 < n3; ++i3) {
                    double d4 = yz_02.d[i3];
                    double d5 = yz_02.f[i3];
                    if (!(d4 > d5)) continue;
                    throw new pm_0(d4, (Number)d5, true);
                }
            }
            if (yz_02.e == null) {
                yz_02.e = new double[n3];
                for (int i4 = 0; i4 < n3; ++i4) {
                    yz_02.e[i4] = Double.NEGATIVE_INFINITY;
                }
            }
            if (yz_02.f == null) {
                yz_02.f = new double[n3];
                for (int i5 = 0; i5 < n3; ++i5) {
                    yz_02.f[i5] = Double.POSITIVE_INFINITY;
                }
            }
        }
        return this.d();
    }

    private void a(yo_0 ... yo_0Array) {
        for (yo_0 yo_02 : yo_0Array) {
            if (yo_02 instanceof yg_0) {
                this.d = ((yg_0)yo_02).a();
                continue;
            }
            if (!(yo_02 instanceof yr_0)) continue;
            yo_02 = (yr_0)yo_02;
            this.e = ((yr_0)yo_02).a();
            this.f = ((yr_0)yo_02).b();
        }
    }

    public final yf_0 e() {
        return this.a;
    }

    public final double[] f() {
        if (this.d == null) {
            return null;
        }
        return (double[])this.d.clone();
    }

    public final double[] g() {
        if (this.e == null) {
            return null;
        }
        return (double[])this.e.clone();
    }

    public final double[] h() {
        if (this.f == null) {
            return null;
        }
        return (double[])this.f.clone();
    }

    protected abstract yp_0 d();

    private void i() {
        if (this.d != null) {
            double d2;
            double d3;
            int n2;
            int n3 = this.d.length;
            if (this.e != null) {
                if (this.e.length != n3) {
                    throw new oS(this.e.length, n3);
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    d3 = this.d[n2];
                    d2 = this.e[n2];
                    if (!(d3 < d2)) continue;
                    throw new pn_0(d3, (Number)d2, true);
                }
            }
            if (this.f != null) {
                if (this.f.length != n3) {
                    throw new oS(this.f.length, n3);
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    d3 = this.d[n2];
                    d2 = this.f[n2];
                    if (!(d3 > d2)) continue;
                    throw new pm_0(d3, (Number)d2, true);
                }
            }
            if (this.e == null) {
                this.e = new double[n3];
                for (n2 = 0; n2 < n3; ++n2) {
                    this.e[n2] = Double.NEGATIVE_INFINITY;
                }
            }
            if (this.f == null) {
                this.f = new double[n3];
                for (n2 = 0; n2 < n3; ++n2) {
                    this.f[n2] = Double.POSITIVE_INFINITY;
                }
            }
        }
    }
}

