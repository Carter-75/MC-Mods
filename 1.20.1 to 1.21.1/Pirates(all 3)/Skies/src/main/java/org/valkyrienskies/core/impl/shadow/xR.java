/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.wJ;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.xO;
import org.valkyrienskies.core.impl.shadow.xQ;
import org.valkyrienskies.core.impl.shadow.xS;
import org.valkyrienskies.core.impl.shadow.xi_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class xR
extends wJ<xS> {
    private lc_0 a;
    private xi_0 b;
    private double c;
    private double d;
    private double e;

    protected xR(wK<xS> wK2) {
        super(wK2);
    }

    public xS c(wO ... wOArray) {
        return (xS)super.a(wOArray);
    }

    public final xi_0 b() {
        return this.b;
    }

    @Override
    public final void b(wO ... wOArray) {
        super.b(wOArray);
        for (wO wO2 : wOArray) {
            wO wO3;
            if (wO2 instanceof xO) {
                wO3 = wO2 = (xO)wO2;
                this.d = ((xO)wO3).a;
                wO3 = wO2;
                this.e = ((xO)wO3).b;
                wO3 = wO2;
                this.c = ((xO)wO3).c;
                continue;
            }
            if (wO2 instanceof xQ) {
                wO3 = (xQ)wO2;
                this.a = ((xQ)wO3).a;
                continue;
            }
            if (!(wO2 instanceof xi_0)) continue;
            this.b = (xi_0)wO2;
        }
    }

    public final double d() {
        return this.c;
    }

    public final double e() {
        return this.d;
    }

    public final double f() {
        return this.e;
    }

    protected final double a(double d2) {
        super.k();
        return this.a.a(d2);
    }

    @Override
    public /* synthetic */ Object a(wO[] wOArray) {
        return this.c(wOArray);
    }
}

