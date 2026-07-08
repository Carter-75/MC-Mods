/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.xY;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yg_0;
import org.valkyrienskies.core.impl.shadow.yo_0;
import org.valkyrienskies.core.impl.shadow.yq_0;
import org.valkyrienskies.core.impl.shadow.yu_0;
import org.valkyrienskies.core.impl.shadow.yv_0;
import org.valkyrienskies.core.impl.shadow.yw_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class yB<FUNC extends kY>
implements xY<FUNC> {
    private cb_0 a = new cb_0();
    private ya_0<yq_0> b;
    private double[] c;
    private tq_0 d;
    @Deprecated
    private double[] e;
    private double[] f;
    private FUNC g;

    @Deprecated
    public yB() {
        this(new yu_0());
    }

    public yB(ya_0<yq_0> ya_02) {
        this.b = ya_02;
    }

    @Override
    public final int a() {
        cb_0 cb_02 = this.a;
        return cb_02.a;
    }

    @Override
    public final int b() {
        cb_0 cb_02 = this.a;
        return cb_02.b;
    }

    @Override
    public final ya_0<yq_0> c() {
        return this.b;
    }

    protected final double[] a(double[] dArray) {
        try {
            this.a.c();
        }
        catch (pc_0 pc_02) {
            pc_0 pc_03 = pc_02;
            throw new pp_0(pc_03.a);
        }
        return this.g.a(dArray);
    }

    @Override
    @Deprecated
    public yq_0 a(int n2, FUNC FUNC, double[] object, double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        dArray2 = dArray;
        dArray = object;
        object = FUNC;
        int n3 = n2;
        yB yB2 = this;
        if (object == null) {
            throw new pl_0();
        }
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray2 == null) {
            throw new pl_0();
        }
        if (dArray3 == null) {
            throw new pl_0();
        }
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        return yB2.a(n3, object, new yv_0(dArray), new yw_0(dArray2), new yg_0(dArray3));
    }

    private yq_0 b(int n2, FUNC FUNC, yo_0 ... yo_0Array) {
        return this.a(n2, FUNC, yo_0Array);
    }

    @Deprecated
    private yq_0 b(int n2, FUNC FUNC, double[] dArray, double[] dArray2, double[] dArray3) {
        if (FUNC == null) {
            throw new pl_0();
        }
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray2 == null) {
            throw new pl_0();
        }
        if (dArray3 == null) {
            throw new pl_0();
        }
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        return this.a(n2, FUNC, new yv_0(dArray), new yw_0(dArray2), new yg_0(dArray3));
    }

    public final yq_0 a(int n2, FUNC FUNC, yo_0 ... yo_0Array) {
        this.a.a(n2);
        this.a.d();
        this.g = FUNC;
        this.a(yo_0Array);
        this.l();
        this.i();
        return this.h();
    }

    public final double[] d() {
        return (double[])this.f.clone();
    }

    public final tq_0 e() {
        return this.d.i();
    }

    public final double[] f() {
        return (double[])this.c.clone();
    }

    protected final FUNC g() {
        return this.g;
    }

    protected abstract yq_0 h();

    @Deprecated
    private double[] j() {
        return this.c;
    }

    @Deprecated
    private double[] k() {
        return this.e;
    }

    public void i() {
        int n2 = this.c.length;
        this.e = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2;
            this.e[i2] = this.d.b(n3, n3);
        }
    }

    private void a(yo_0 ... yo_0Array) {
        for (yo_0 yo_02 : yo_0Array) {
            if (yo_02 instanceof yv_0) {
                this.c = ((yv_0)yo_02).a();
                continue;
            }
            if (yo_02 instanceof yw_0) {
                this.d = ((yw_0)yo_02).a();
                continue;
            }
            if (!(yo_02 instanceof yg_0)) continue;
            this.f = ((yg_0)yo_02).a();
        }
    }

    private void l() {
        if (this.c.length != this.d.g()) {
            throw new oS(this.c.length, this.d.g());
        }
    }
}

