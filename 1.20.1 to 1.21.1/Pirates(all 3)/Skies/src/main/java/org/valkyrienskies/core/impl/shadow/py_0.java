/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pB;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.py
 */
public final class py_0
implements pB {
    private tq_0 a;
    private tq_0 b;

    private py_0(double[][] dArray, double[][] dArray2) {
        this(new sy_0(dArray), new sy_0(dArray2));
    }

    private py_0(sy_0 sy_02, sy_0 sy_03) {
        this.a = sy_02;
        this.b = sy_03;
    }

    public final tq_0 a() {
        return this.a;
    }

    public final tq_0 b() {
        return this.b;
    }
}

