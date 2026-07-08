/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.wM;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.xO;
import org.valkyrienskies.core.impl.shadow.xR;
import org.valkyrienskies.core.impl.shadow.xS;
import org.valkyrienskies.core.impl.shadow.xi_0;
import org.valkyrienskies.core.impl.shadow.zF;

public final class xN
extends xR {
    private final xR a;
    private int b;
    private int c;
    private zF d;
    private xS[] e;
    private wO[] f;
    private int g = -1;
    private int h = -1;

    private xN(xR xR2, int n2, zF zF2) {
        super(xR2.j());
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.a = xR2;
        this.c = n2;
        this.d = zF2;
    }

    public final int a() {
        return this.b;
    }

    private xS[] g() {
        if (this.e == null) {
            throw new oX(px_0.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
        }
        return (xS[])this.e.clone();
    }

    public final xS c(wO ... wOArray) {
        this.f = wOArray;
        return super.c(wOArray);
    }

    private xS m() {
        for (int i2 = 0; i2 < this.f.length; ++i2) {
            if (this.f[i2] instanceof wM) {
                this.f[i2] = null;
                this.g = i2;
                continue;
            }
            if (!(this.f[i2] instanceof xO)) continue;
            this.f[i2] = null;
            this.h = i2;
        }
        if (this.g == -1) {
            throw new oX();
        }
        if (this.h == -1) {
            throw new oX();
        }
        RuntimeException runtimeException = null;
        this.e = new xS[this.c];
        this.b = 0;
        int n2 = this.h();
        double d2 = this.e();
        double d3 = this.f();
        double d4 = this.d();
        for (int i3 = 0; i3 < this.c; ++i3) {
            try {
                this.f[this.g] = new wM(n2 - this.b);
                double d5 = i3 == 0 ? d4 : d2 + this.d.nextDouble() * (d3 - d2);
                this.f[this.h] = new xO(d2, d3, d5);
                this.e[i3] = this.a.c(this.f);
            }
            catch (RuntimeException runtimeException2) {
                RuntimeException runtimeException3 = runtimeException2;
                runtimeException = runtimeException2;
                this.e[i3] = null;
            }
            this.b += this.a.a();
        }
        xN xN2 = this;
        xi_0 xi_02 = xN2.b();
        xN xN3 = xN2;
        Arrays.sort(xN2.e, new Comparator<xS>(xN3, xi_02){
            private /* synthetic */ xi_0 a;
            private /* synthetic */ xN b;
            {
                this.b = xN2;
                this.a = xi_02;
            }

            private int a(xS xS2, xS xS3) {
                if (xS2 == null) {
                    if (xS3 == null) {
                        return 0;
                    }
                    return 1;
                }
                if (xS3 == null) {
                    return -1;
                }
                double d2 = xS2.b;
                xS2 = xS3;
                double d3 = xS2.b;
                if (this.a == xi_0.MINIMIZE) {
                    return Double.compare(d2, d3);
                }
                return Double.compare(d3, d2);
            }
        });
        if (this.e[0] == null) {
            throw runtimeException;
        }
        return this.e[0];
    }

    private void a(xi_0 xi_02) {
        Arrays.sort(this.e, new /* invalid duplicate definition of identical inner class */);
    }

    public final /* synthetic */ Object c() {
        return this.m();
    }

    public final /* synthetic */ Object a(wO[] wOArray) {
        return ((xR)this).c(wOArray);
    }
}

