/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.wl_0;
import org.valkyrienskies.core.impl.shadow.wq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.wp
 */
public final class wp_0
extends wl_0 {
    private static final double[] f = new double[]{0.3333333333333333, 0.6666666666666666, 1.0};
    private static final double[][] g = new double[][]{{0.3333333333333333}, {-0.3333333333333333, 1.0}, {1.0, -1.0, 1.0}};
    private static final double[] h = new double[]{0.125, 0.375, 0.375, 0.125};

    private wp_0(double d2) {
        super("3/8", f, g, h, new wq_0(), d2);
    }
}

