/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.wA;
import org.valkyrienskies.core.impl.shadow.wB;
import org.valkyrienskies.core.impl.shadow.ws_0;

public final class uD
implements Serializable,
wA {
    private static final long a = -1417964919405031606L;
    private double b;
    private double c;
    private boolean d = true;
    private int e = 0;
    private List<wB> f = new ArrayList<wB>();

    public uD() {
        this.b = Double.NaN;
        this.c = Double.NaN;
    }

    private void a(uD uD2) {
        if (uD2.f.size() == 0) {
            return;
        }
        if (this.f.size() == 0) {
            this.b = uD2.b;
            this.d = uD2.d;
        } else {
            double d2;
            if (this.d().length != uD2.d().length) {
                throw new oS(uD2.d().length, this.d().length);
            }
            if (this.d ^ uD2.d) {
                throw new oV(px_0.PROPAGATION_DIRECTION_MISMATCH, new Object[0]);
            }
            Object object = this.f.get(this.e);
            double d3 = object.h();
            double d4 = object.g();
            double d5 = d3 - d4;
            object = uD2;
            double d6 = ((uD)object).b - d3;
            if (BY.w(d2) > 0.001 * BY.w(d5)) {
                throw new oV(px_0.HOLE_BETWEEN_MODELS_TIME_RANGES, BY.w(d6));
            }
        }
        for (wB wB2 : uD2.f) {
            this.f.add(wB2.d());
        }
        this.e = this.f.size() - 1;
        this.c = this.f.get(this.e).h();
    }

    public final void a(double d2, double[] dArray, double d3) {
        this.b = Double.NaN;
        this.c = Double.NaN;
        this.d = true;
        this.e = 0;
        this.f.clear();
    }

    public final void a(ws_0 ws_02, boolean bl) {
        if (this.f.size() == 0) {
            this.b = ws_02.g();
            this.d = ws_02.j();
        }
        this.f.add(ws_02.d());
        if (bl) {
            this.c = ws_02.h();
            this.e = this.f.size() - 1;
        }
    }

    private double a() {
        return this.b;
    }

    private double b() {
        return this.c;
    }

    private double c() {
        return this.f.get(this.e).i();
    }

    private void a(double d2) {
        int n2 = 0;
        wB wB2 = this.f.get(0);
        double d3 = 0.5 * (wB2.g() + wB2.h());
        int n3 = this.f.size() - 1;
        wB wB3 = this.f.get(n3);
        double d4 = 0.5 * (wB3.g() + wB3.h());
        if (this.a(d2, wB2) <= 0) {
            this.e = 0;
            wB2.d(d2);
            return;
        }
        if (this.a(d2, wB3) >= 0) {
            this.e = n3;
            wB3.d(d2);
            return;
        }
        while (n3 - n2 > 5) {
            wB2 = this.f.get(this.e);
            int n4 = this.a(d2, wB2);
            if (n4 < 0) {
                n3 = this.e;
                d4 = 0.5 * (wB2.g() + wB2.h());
            } else if (n4 > 0) {
                n2 = this.e;
                d3 = 0.5 * (wB2.g() + wB2.h());
            } else {
                wB2.d(d2);
                return;
            }
            int n5 = (n2 + n3) / 2;
            wB3 = this.f.get(n5);
            double d5 = 0.5 * (wB3.g() + wB3.h());
            if (BY.w(d5 - d3) < 1.0E-6 || BY.w(d4 - d5) < 1.0E-6) {
                this.e = n5;
            } else {
                double d6 = d4 - d5;
                double d7 = d5 - d3;
                double d8 = d4 - d3;
                double d9 = d2 - d4;
                double d10 = d2 - d5;
                double d11 = d2 - d3;
                double d12 = (d10 * d11 * d7 * (double)n3 - d9 * d11 * d8 * (double)n5 + d9 * d10 * d6 * (double)n2) / (d6 * d7 * d8);
                this.e = (int)BY.A(d12);
            }
            int n6 = BY.b(n2 + 1, (n2 * 9 + n3) / 10);
            int n7 = BY.a(n3 - 1, (n2 + n3 * 9) / 10);
            if (this.e < n6) {
                this.e = n6;
                continue;
            }
            if (this.e <= n7) continue;
            this.e = n7;
        }
        this.e = n2;
        while (this.e <= n3 && this.a(d2, this.f.get(this.e)) > 0) {
            ++this.e;
        }
        this.f.get(this.e).d(d2);
    }

    private double[] d() {
        return this.f.get(this.e).k();
    }

    private double[] e() {
        return this.f.get(this.e).l();
    }

    private double[] a(int n2) {
        return this.f.get(this.e).a(n2);
    }

    private double[] b(int n2) {
        return this.f.get(this.e).b(n2);
    }

    private int a(double d2, wB wB2) {
        if (this.d) {
            if (d2 < wB2.g()) {
                return -1;
            }
            if (d2 > wB2.h()) {
                return 1;
            }
            return 0;
        }
        if (d2 > wB2.g()) {
            return -1;
        }
        if (d2 < wB2.h()) {
            return 1;
        }
        return 0;
    }
}

