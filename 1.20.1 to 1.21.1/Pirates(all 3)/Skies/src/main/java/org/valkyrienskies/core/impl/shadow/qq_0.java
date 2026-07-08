/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qp_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.qq
 */
public final class qq_0 {
    final qp_0 a;
    final qp_0 b;

    public qq_0(qp_0 qp_02, qp_0 qp_03) {
        this.a = qp_02;
        this.b = qp_03;
    }

    public final qp_0 a() {
        return this.a;
    }

    public final qp_0 b() {
        return this.b;
    }

    public final String toString() {
        Object[] objectArray = new Object[2];
        qq_0 qq_02 = this;
        objectArray[0] = qq_02.a;
        qq_02 = this;
        objectArray[1] = qq_02.b;
        return String.format("(%s,%s)", objectArray);
    }
}

