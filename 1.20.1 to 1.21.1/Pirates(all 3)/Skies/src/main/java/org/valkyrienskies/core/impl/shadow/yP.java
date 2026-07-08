/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kR;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ll_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.sM;
import org.valkyrienskies.core.impl.shadow.sN;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.yB;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.ye_0;
import org.valkyrienskies.core.impl.shadow.yg_0;
import org.valkyrienskies.core.impl.shadow.yo_0;
import org.valkyrienskies.core.impl.shadow.yq_0;
import org.valkyrienskies.core.impl.shadow.yv_0;
import org.valkyrienskies.core.impl.shadow.yw_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class yP
extends yB<kR>
implements ye_0 {
    @Deprecated
    private static final double c = 1.0E-14;
    @Deprecated
    private double[][] d;
    @Deprecated
    private int e;
    @Deprecated
    private int f;
    @Deprecated
    protected double[] a;
    @Deprecated
    private double[] g;
    @Deprecated
    private double[] h;
    @Deprecated
    protected double b;
    private ll_0 i;
    private int j;
    private tq_0 k;

    @Deprecated
    protected yP() {
    }

    protected yP(ya_0<yq_0> ya_02) {
        super(ya_02);
    }

    private int k() {
        return this.j;
    }

    @Deprecated
    private void l() {
        yP yP2 = this;
        tq_0 tq_02 = yP2.b(yP2.a);
        this.d = tq_02.b(-1.0).a();
    }

    protected final tq_0 b(double[] dArray) {
        int n2;
        ++this.j;
        Object object = new lg_0[dArray.length];
        int n3 = dArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            object[i2] = new lg_0(n3, 1, i2, dArray[i2]);
        }
        lg_0[] lg_0Array = this.i.a((lg_0[])object);
        if (lg_0Array.length != (n2 = this.f().length)) {
            throw new oS(lg_0Array.length, n2);
        }
        object = new double[n2][n3];
        for (int i3 = 0; i3 < n2; ++i3) {
            int[] nArray = new int[n3];
            for (int i4 = 0; i4 < n3; ++i4) {
                nArray[i4] = 1;
                object[i3][i4] = (lg_0)lg_0Array[i3].a(nArray);
                nArray[i4] = 0;
            }
        }
        return this.k.c(td_0.a((double[][])object));
    }

    @Deprecated
    private void m() {
        this.g = this.a(this.a);
        yP yP2 = this;
        Object object = yP2.d(yP2.g);
        this.b = this.c((double[])object);
        object = new sA((double[])object);
        this.h = ((tu_0)((Object)this.k.a((tu_0)object))).g();
    }

    protected final double c(double[] object) {
        sA sA2 = new sA((double[])object);
        object = sA2;
        return BY.a(((tu_0)((Object)sA2)).b((tu_0)((Object)this.e().a((tu_0)object))));
    }

    private double n() {
        return BY.a(this.o() / (double)this.f);
    }

    private double o() {
        return this.b * this.b;
    }

    public final tq_0 j() {
        return this.k.i();
    }

    protected final void a(double d2) {
        this.b = d2;
    }

    @Deprecated
    private double[][] p() {
        double d2 = 1.0E-14;
        yP yP2 = this;
        return yP2.a(yP2.a, 1.0E-14);
    }

    @Deprecated
    private double[][] b(double d2) {
        yP yP2 = this;
        return yP2.a(yP2.a, 1.0E-14);
    }

    private double[][] a(double[] object, double d2) {
        tq_0 tq_02 = this.b((double[])object);
        object = tq_02;
        object = tq_02.d().c((tq_0)object);
        sG sG2 = new tn_0((tq_0)object, d2).c();
        object = sG2;
        return sG2.b().a();
    }

    @Deprecated
    private double[] q() {
        if (this.f <= this.e) {
            throw new pn_0((pw_0)px_0.NO_DEGREES_OF_FREEDOM, (Number)this.f, this.e, false);
        }
        double[] dArray = new double[this.e];
        double d2 = BY.a(this.o() / (double)(this.f - this.e));
        yP yP2 = this;
        double[][] dArray2 = yP2.a(yP2.a, 1.0E-14);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray[i2] = BY.a(dArray2[i2][i2]) * d2;
        }
        return dArray;
    }

    private double[] b(double[] object, double d2) {
        int n2 = ((double[])object).length;
        double[] dArray = new double[n2];
        object = this.a((double[])object, d2);
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = BY.a((double)object[i2][i2]);
        }
        return dArray;
    }

    @Override
    @Deprecated
    private yq_0 a(int n2, kR kR2, double[] dArray, double[] dArray2, double[] dArray3) {
        return this.a(n2, (ll_0)kV.a(kR2), new yo_0[]{new yv_0(dArray), new yw_0(dArray2), new yg_0(dArray3)});
    }

    @Override
    @Deprecated
    private yq_0 a(int n2, ll_0 ll_02, double[] dArray, double[] dArray2, double[] dArray3) {
        return this.a(n2, ll_02, new yo_0[]{new yv_0(dArray), new yw_0(dArray2), new yg_0(dArray3)});
    }

    @Override
    @Deprecated
    private yq_0 a(int n2, ll_0 ll_02, yo_0 ... yo_0Array) {
        return super.a(n2, kV.a(ll_02), yo_0Array);
    }

    @Override
    public final void i() {
        tq_0 tq_02;
        super.i();
        this.j = 0;
        tq_0 tq_03 = this.e();
        if (tq_03 instanceof sM) {
            int n2 = tq_03.f();
            sM sM2 = new sM(n2);
            int n3 = 0;
            while (n3 < n2) {
                int n4 = n3;
                int n5 = n3++;
                sM2.c(n4, n4, BY.a(tq_03.b(n5, n5)));
            }
            tq_02 = sM2;
        } else {
            sN sN2 = new sN(tq_03);
            tq_02 = sN2.e();
        }
        this.k = tq_02;
        this.i = kV.a((kR)this.g());
        this.a = this.d();
        this.f = this.f().length;
        this.e = this.a.length;
    }

    protected final double[] d(double[] dArray) {
        double[] dArray2 = this.f();
        if (dArray.length != dArray2.length) {
            throw new oS(dArray2.length, dArray.length);
        }
        double[] dArray3 = new double[dArray2.length];
        for (int i2 = 0; i2 < dArray2.length; ++i2) {
            dArray3[i2] = dArray2[i2] - dArray[i2];
        }
        return dArray3;
    }

    private static tq_0 a(tq_0 tq_02) {
        if (tq_02 instanceof sM) {
            int n2 = tq_02.f();
            sM sM2 = new sM(n2);
            int n3 = 0;
            while (n3 < n2) {
                int n4 = n3;
                int n5 = n3++;
                sM2.c(n4, n4, BY.a(tq_02.b(n5, n5)));
            }
            return sM2;
        }
        sN sN2 = new sN(tq_02);
        return sN2.e();
    }

    @Override
    @Deprecated
    public final /* synthetic */ yq_0 a(int n2, kY kY2, double[] object, double[] dArray, double[] dArray2) {
        double[] dArray3 = dArray2;
        dArray2 = dArray;
        dArray = object;
        object = (kR)kY2;
        int n3 = n2;
        yP yP2 = this;
        return yP2.a(n3, (ll_0)kV.a((kR)object), new yo_0[]{new yv_0(dArray), new yw_0(dArray2), new yg_0(dArray3)});
    }
}

