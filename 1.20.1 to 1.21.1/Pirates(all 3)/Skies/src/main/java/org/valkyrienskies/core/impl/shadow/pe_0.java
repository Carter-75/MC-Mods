/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.pe
 */
public final class pe_0
extends oV {
    private static final long b = -3629324471511904459L;
    private final double c;
    private final double d;
    private final double e;
    private final double f;

    public pe_0(double d2, double d3, double d4, double d5) {
        this(px_0.SAME_SIGN_AT_ENDPOINTS, d2, d3, d4, d5, new Object[0]);
    }

    public pe_0(px_0 px_02, double d2, double d3, double d4, double d5, Object ... objectArray) {
        super(px_02, d2, d3, d4, d5, objectArray);
        this.c = d2;
        this.d = d3;
        this.e = d4;
        this.f = d5;
    }

    private double b() {
        return this.c;
    }

    private double c() {
        return this.d;
    }

    private double d() {
        return this.e;
    }

    private double e() {
        return this.f;
    }
}

