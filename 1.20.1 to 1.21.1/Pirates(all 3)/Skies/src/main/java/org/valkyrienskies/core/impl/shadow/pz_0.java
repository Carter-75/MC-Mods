/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pC;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.pz
 */
public final class pz_0
implements pC {
    private tq_0 a;
    private tq_0 b;
    private tq_0 c;
    private tu_0 d;
    private tq_0 e;

    private pz_0(double[][] dArray, double[][] dArray2, double[][] dArray3, double[] dArray4, double[][] dArray5) {
        this(new sy_0(dArray), new sy_0(dArray2), new sy_0(dArray3), new sA(dArray4), new sy_0(dArray5));
    }

    private pz_0(double[][] dArray, double[][] dArray2, double[][] dArray3) {
        this(new sy_0(dArray), new sy_0(dArray2), new sy_0(dArray3), null, null);
    }

    private pz_0(sy_0 sy_02, sy_0 sy_03, sy_0 sy_04, sA sA2, sy_0 sy_05) {
        this.a = sy_02;
        this.b = sy_03;
        this.c = sy_04;
        this.d = sA2;
        this.e = sy_05;
    }

    public final tq_0 a() {
        return this.a;
    }

    public final tq_0 b() {
        return this.b;
    }

    public final tq_0 c() {
        return this.c;
    }

    public final tu_0 d() {
        return this.d;
    }

    public final tq_0 e() {
        return this.e;
    }
}

