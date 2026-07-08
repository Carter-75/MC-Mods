/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.AY;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.og_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class AZ {
    private boolean a(int n2, int n3, double d2, AY aY, double d3) {
        double d4;
        AY aY2 = aY;
        double d5 = d2;
        if (n2 < 0) {
            throw new pj_0(n2);
        }
        if (n3 < 0) {
            throw new pj_0(n3);
        }
        if (d5 < 0.0 || d5 > 1.0) {
            throw new po_0(d5, (Number)0, 1);
        }
        if (n2 < n3) {
            throw new oV(px_0.BINOMIAL_INVALID_PARAMETERS_ORDER, n2, n3);
        }
        if (aY2 == null) {
            throw new pl_0();
        }
        og_0 og_02 = new og_0(null, n2, d5);
        switch (aY2) {
            case GREATER_THAN: {
                d4 = 1.0 - og_02.d(n3 - 1);
                break;
            }
            case LESS_THAN: {
                d4 = og_02.d(n3);
                break;
            }
            case TWO_SIDED: {
                int n4 = 0;
                double d6 = 0.0;
                do {
                    double d7;
                    double d8;
                    if ((d8 = og_02.c(n4)) == (d7 = og_02.c(n2))) {
                        d6 += d8 * 2.0;
                        ++n4;
                        --n2;
                        continue;
                    }
                    if (d8 < d7) {
                        d6 += d8;
                        ++n4;
                        continue;
                    }
                    d6 += d7;
                    --n2;
                } while (n4 <= n3 && n2 >= n3);
                d4 = d6;
                break;
            }
            default: {
                throw new oY(px_0.OUT_OF_RANGE_SIMPLE, new Object[]{aY2, AY.TWO_SIDED, AY.LESS_THAN});
            }
        }
        double d9 = d4;
        return d4 < d3;
    }

    private static double a(int n2, int n3, double d2, AY aY) {
        if (n2 < 0) {
            throw new pj_0(n2);
        }
        if (n3 < 0) {
            throw new pj_0(n3);
        }
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        if (n2 < n3) {
            throw new oV(px_0.BINOMIAL_INVALID_PARAMETERS_ORDER, n2, n3);
        }
        if (aY == null) {
            throw new pl_0();
        }
        og_0 og_02 = new og_0(null, n2, d2);
        switch (aY) {
            case GREATER_THAN: {
                return 1.0 - og_02.d(n3 - 1);
            }
            case LESS_THAN: {
                return og_02.d(n3);
            }
            case TWO_SIDED: {
                int n4 = 0;
                double d3 = 0.0;
                do {
                    double d4;
                    double d5;
                    if ((d5 = og_02.c(n4)) == (d4 = og_02.c(n2))) {
                        d3 += d5 * 2.0;
                        ++n4;
                        --n2;
                        continue;
                    }
                    if (d5 < d4) {
                        d3 += d5;
                        ++n4;
                        continue;
                    }
                    d3 += d4;
                    --n2;
                } while (n4 <= n3 && n2 >= n3);
                return d3;
            }
        }
        throw new oY(px_0.OUT_OF_RANGE_SIMPLE, new Object[]{aY, AY.TWO_SIDED, AY.LESS_THAN});
    }
}

