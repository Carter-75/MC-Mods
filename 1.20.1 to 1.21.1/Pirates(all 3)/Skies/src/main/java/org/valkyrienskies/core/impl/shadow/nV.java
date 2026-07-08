/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class nV
implements Serializable {
    private static final long a = 20120201L;
    private int b = 0;
    private double[] c = null;
    private double[] d = null;
    private double[] e = null;
    private boolean f = true;

    private boolean a() {
        if (this.b == 0) {
            throw new oX(px_0.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);
        }
        return this.f;
    }

    private void a(int n2) {
        if (n2 == 0) {
            throw new pr_0(px_0.CANNOT_COMPUTE_0TH_ROOT_OF_UNITY, new Object[0]);
        }
        this.f = n2 > 0;
        if ((n2 = BY.a(n2)) == this.b) {
            return;
        }
        double d2 = Math.PI * 2 / (double)n2;
        double d3 = BY.o(d2);
        double d4 = BY.n(d2);
        this.c = new double[n2];
        this.d = new double[n2];
        this.e = new double[n2];
        this.c[0] = 1.0;
        this.d[0] = 0.0;
        this.e[0] = 0.0;
        for (int i2 = 1; i2 < n2; ++i2) {
            this.c[i2] = this.c[i2 - 1] * d3 - this.d[i2 - 1] * d4;
            this.d[i2] = this.c[i2 - 1] * d4 + this.d[i2 - 1] * d3;
            this.e[i2] = -this.d[i2];
        }
        this.b = n2;
    }

    private double b(int n2) {
        if (this.b == 0) {
            throw new oX(px_0.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);
        }
        if (n2 < 0 || n2 >= this.b) {
            throw new po_0(px_0.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, (Number)n2, 0, this.b - 1);
        }
        return this.c[n2];
    }

    private double c(int n2) {
        if (this.b == 0) {
            throw new oX(px_0.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);
        }
        if (n2 < 0 || n2 >= this.b) {
            throw new po_0(px_0.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, (Number)n2, 0, this.b - 1);
        }
        if (this.f) {
            return this.d[n2];
        }
        return this.e[n2];
    }

    private int b() {
        return this.b;
    }
}

