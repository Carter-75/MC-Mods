/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.wU;
import org.valkyrienskies.core.impl.shadow.xi_0;
import org.valkyrienskies.core.impl.shadow.xp_0;
import org.valkyrienskies.core.impl.shadow.xu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class xA
extends xp_0 {
    private xu_0 b;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private xA(wU wU2) {
        super(wU2);
    }

    private xA(double d2, double d3) {
        this(new wU(d2, d3));
    }

    @Override
    public final wQ c(wO ... wOArray) {
        return super.c(wOArray);
    }

    private wQ b() {
        Object object;
        int n2;
        wQ[] wQArray = this;
        if (wQArray.b == null) {
            throw new pl_0();
        }
        if (wQArray.f() != null || wQArray.g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
        kW kW2 = new kW(this){
            private /* synthetic */ xA a;
            {
                this.a = xA2;
            }

            public final double a(double[] dArray) {
                return this.a.b(dArray);
            }
        };
        boolean bl = this.n() == xi_0.MINIMIZE;
        Comparator<wQ> comparator = new Comparator<wQ>(this, bl){
            private /* synthetic */ boolean a;
            private /* synthetic */ xA b;
            {
                this.b = xA2;
                this.a = bl;
            }

            private int a(wQ wQ2, wQ wQ3) {
                double d2 = (Double)wQ2.c();
                double d3 = (Double)wQ3.c();
                if (this.a) {
                    return Double.compare(d2, d3);
                }
                return Double.compare(d3, d2);
            }

            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                wQ wQ2 = (wQ)object2;
                object2 = (wQ)object;
                object = this;
                double d2 = (Double)((co_0)object2).c();
                double d3 = (Double)wQ2.c();
                if (object.a) {
                    return Double.compare(d2, d3);
                }
                return Double.compare(d3, d2);
            }
        };
        Object object2 = this.e();
        wQArray = this.b;
        if (wQArray.c != ((double[])object2).length) {
            throw new oS(wQArray.c, ((double[])object2).length);
        }
        wQArray.a = new wQ[wQArray.c + 1];
        wQArray.a[0] = new wQ((double[])object2, Double.NaN);
        for (n2 = 0; n2 < wQArray.c; ++n2) {
            double[] dArray = wQArray.b[n2];
            object = new double[wQArray.c];
            for (int i2 = 0; i2 < wQArray.c; ++i2) {
                object[i2] = object2[i2] + dArray[i2];
            }
            wQArray.a[n2 + 1] = new wQ((double[])object, Double.NaN);
        }
        this.b.a(kW2, comparator);
        wQArray = null;
        object2 = this.j();
        while (true) {
            if (this.i() > 0) {
                n2 = 1;
                int n3 = 0;
                while (true) {
                    xu_0 xu_02 = this.b;
                    object = xu_02;
                    if (n3 >= xu_02.a.length) break;
                    object = wQArray[n3];
                    n2 = n2 != 0 && object2.a(0, object, this.b.a(n3)) ? 1 : 0;
                    ++n3;
                }
                if (n2 != 0) {
                    return this.b.a(0);
                }
            }
            wQArray = this.b.c();
            this.b.a(kW2, comparator);
            this.l();
        }
    }

    @Override
    public final void b(wO ... wOArray) {
        super.b(wOArray);
        for (wO wO2 : wOArray) {
            if (!(wO2 instanceof xu_0)) continue;
            this.b = (xu_0)wO2;
            return;
        }
    }

    private void d() {
        if (this.b == null) {
            throw new pl_0();
        }
        if (this.f() != null || this.g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
    }

    @Override
    public final /* synthetic */ Object a(wO[] object) {
        wO[] wOArray = object;
        object = this;
        return super.c(wOArray);
    }

    @Override
    public final /* synthetic */ Object c() {
        Object object;
        int n2;
        xA xA2 = this;
        wQ[] wQArray = xA2;
        if (xA2.b == null) {
            throw new pl_0();
        }
        if (wQArray.f() != null || wQArray.g() != null) {
            throw new pb_0(px_0.CONSTRAINT, new Object[0]);
        }
        kW kW2 = new /* invalid duplicate definition of identical inner class */;
        boolean bl = xA2.n() == xi_0.MINIMIZE;
        Comparator<wQ> comparator = new /* invalid duplicate definition of identical inner class */;
        Object object2 = xA2.e();
        wQArray = xA2.b;
        if (wQArray.c != ((double[])object2).length) {
            throw new oS(wQArray.c, ((double[])object2).length);
        }
        wQArray.a = new wQ[wQArray.c + 1];
        wQArray.a[0] = new wQ((double[])object2, Double.NaN);
        for (n2 = 0; n2 < wQArray.c; ++n2) {
            double[] dArray = wQArray.b[n2];
            object = new double[wQArray.c];
            for (int i2 = 0; i2 < wQArray.c; ++i2) {
                object[i2] = object2[i2] + dArray[i2];
            }
            wQArray.a[n2 + 1] = new wQ((double[])object, Double.NaN);
        }
        xA2.b.a(kW2, comparator);
        wQArray = null;
        object2 = xA2.j();
        while (true) {
            if (xA2.i() > 0) {
                n2 = 1;
                int n3 = 0;
                while (true) {
                    xu_0 xu_02 = xA2.b;
                    object = xu_02;
                    if (n3 >= xu_02.a.length) break;
                    object = wQArray[n3];
                    n2 = n2 != 0 && object2.a(0, object, xA2.b.a(n3)) ? 1 : 0;
                    ++n3;
                }
                if (n2 != 0) {
                    return xA2.b.a(0);
                }
            }
            wQArray = xA2.b.c();
            xA2.b.a(kW2, comparator);
            xA2.l();
        }
    }
}

