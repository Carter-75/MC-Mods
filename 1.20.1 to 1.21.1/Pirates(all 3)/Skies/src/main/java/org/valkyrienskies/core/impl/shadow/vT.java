/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.vU;
import org.valkyrienskies.core.impl.shadow.wl_0;

public final class vT
extends wl_0 {
    private static final double[] f = new double[]{0.5, 0.5, 1.0};
    private static final double[][] g = new double[][]{{0.5}, {(BY.a(2.0) - 1.0) / 2.0, (2.0 - BY.a(2.0)) / 2.0}, {0.0, -BY.a(2.0) / 2.0, (2.0 + BY.a(2.0)) / 2.0}};
    private static final double[] h = new double[]{0.16666666666666666, (2.0 - BY.a(2.0)) / 6.0, (2.0 + BY.a(2.0)) / 6.0, 0.16666666666666666};

    private vT(double d2) {
        super("Gill", f, g, h, new vU(), d2);
    }
}

