/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.wJ;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wL;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wS;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class wI<PAIR>
extends wJ<PAIR> {
    private double[] a;
    private double[] b;
    private double[] c;

    public wI(wK<PAIR> wK2) {
        super(wK2);
    }

    @Override
    public PAIR a(wO ... wOArray) {
        return super.a(wOArray);
    }

    @Override
    public void b(wO ... object) {
        super.b((wO[])object);
        for (Object object2 : object) {
            if (object2 instanceof wL) {
                this.a = ((wL)object2).a();
                continue;
            }
            if (!(object2 instanceof wS)) continue;
            object2 = (wS)object2;
            this.b = ((wS)object2).a();
            this.c = ((wS)object2).b();
        }
        wI wI2 = this;
        if (wI2.a != null) {
            double d2;
            double d3;
            int n2;
            int n3 = wI2.a.length;
            if (wI2.b != null) {
                if (wI2.b.length != n3) {
                    throw new oS(wI2.b.length, n3);
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    d3 = wI2.a[n2];
                    d2 = wI2.b[n2];
                    if (!(d3 < d2)) continue;
                    throw new pn_0(d3, (Number)d2, true);
                }
            }
            if (wI2.c != null) {
                if (wI2.c.length != n3) {
                    throw new oS(wI2.c.length, n3);
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    d3 = wI2.a[n2];
                    d2 = wI2.c[n2];
                    if (!(d3 > d2)) continue;
                    throw new pm_0(d3, (Number)d2, true);
                }
            }
        }
    }

    public final double[] e() {
        if (this.a == null) {
            return null;
        }
        return (double[])this.a.clone();
    }

    public final double[] f() {
        if (this.b == null) {
            return null;
        }
        return (double[])this.b.clone();
    }

    public final double[] g() {
        if (this.c == null) {
            return null;
        }
        return (double[])this.c.clone();
    }

    private void b() {
        if (this.a != null) {
            double d2;
            double d3;
            int n2;
            int n3 = this.a.length;
            if (this.b != null) {
                if (this.b.length != n3) {
                    throw new oS(this.b.length, n3);
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    d3 = this.a[n2];
                    d2 = this.b[n2];
                    if (!(d3 < d2)) continue;
                    throw new pn_0(d3, (Number)d2, true);
                }
            }
            if (this.c != null) {
                if (this.c.length != n3) {
                    throw new oS(this.c.length, n3);
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    d3 = this.a[n2];
                    d2 = this.c[n2];
                    if (!(d3 > d2)) continue;
                    throw new pm_0(d3, (Number)d2, true);
                }
            }
        }
    }
}

