/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.wA;
import org.valkyrienskies.core.impl.shadow.wB;
import org.valkyrienskies.core.impl.shadow.wD;
import org.valkyrienskies.core.impl.shadow.wE;
import org.valkyrienskies.core.impl.shadow.ws_0;
import org.valkyrienskies.core.impl.shadow.wy_0;

public final class wC
implements wA {
    private double a;
    private final wy_0 b;
    private double c;
    private double d;
    private double[] e;
    private double[] f;
    private boolean g;
    private final wD h;
    private final int i;

    private wC(double d2, wy_0 wy_02) {
        this(d2, wy_02, wE.INCREMENT$34d2fcad, wD.FIRST);
    }

    private wC(double d2, wy_0 wy_02, int n2) {
        this(d2, wy_02, n2, wD.FIRST);
    }

    private wC(double d2, wy_0 wy_02, wD wD2) {
        this(d2, wy_02, wE.INCREMENT$34d2fcad, wD2);
    }

    private wC(double d2, wy_0 wy_02, int n2, wD wD2) {
        this.a = BY.w(d2);
        this.b = wy_02;
        this.i = n2;
        this.h = wD2;
        this.c = Double.NaN;
        this.d = Double.NaN;
        this.e = null;
        this.f = null;
        this.g = true;
    }

    public final void a(double d2, double[] dArray, double d3) {
        this.c = Double.NaN;
        this.d = Double.NaN;
        this.e = null;
        this.f = null;
        this.g = true;
    }

    public final void a(ws_0 ws_02, boolean bl) {
        boolean bl2;
        double d2;
        if (this.e == null) {
            this.c = ws_02.g();
            this.d = ws_02.g();
            ws_02.d(this.d);
            this.e = (double[])ws_02.k().clone();
            this.f = (double[])ws_02.l().clone();
            boolean bl3 = this.g = ws_02.h() >= this.d;
            if (!this.g) {
                this.a = -this.a;
            }
        }
        double d3 = d2 = this.i == wE.INCREMENT$34d2fcad ? this.d + this.a : (BY.y(this.d / this.a) + 1.0) * this.a;
        if (this.i == wE.MULTIPLES$34d2fcad && cq_0.b(d2, this.d, 1)) {
            d2 += this.a;
        }
        while (bl2 = this.a(d2, ws_02)) {
            this.a(false);
            this.a((wB)ws_02, d2);
            d2 += this.a;
        }
        if (bl) {
            wD wD2 = this.h;
            boolean bl4 = wD2.last && this.d != ws_02.h();
            this.a(!bl4);
            if (bl4) {
                ws_0 ws_03 = ws_02;
                this.a((wB)ws_03, ws_03.h());
                this.a(true);
            }
        }
    }

    private boolean a(double d2, wB wB2) {
        if (this.g) {
            return d2 <= wB2.h();
        }
        return d2 >= wB2.h();
    }

    private void a(boolean bl) {
        wD wD2 = this.h;
        if (!wD2.first && this.c == this.d) {
            return;
        }
    }

    private void a(wB wB2, double d2) {
        this.d = d2;
        wB2.d(this.d);
        System.arraycopy(wB2.k(), 0, this.e, 0, this.e.length);
        System.arraycopy(wB2.l(), 0, this.f, 0, this.f.length);
    }
}

