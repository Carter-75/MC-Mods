/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.wI;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wR;
import org.valkyrienskies.core.impl.shadow.xC;
import org.valkyrienskies.core.impl.shadow.xG;
import org.valkyrienskies.core.impl.shadow.xH;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class xF
extends wI<wR> {
    private double[] a;
    private tq_0 b;
    private kY c;

    protected xF(wK<wR> wK2) {
        super(wK2);
    }

    protected final double[] b(double[] dArray) {
        super.k();
        return this.c.a(dArray);
    }

    public wR c(wO ... wOArray) {
        return (wR)super.a(wOArray);
    }

    public final tq_0 b() {
        return this.b.i();
    }

    public final double[] d() {
        return (double[])this.a.clone();
    }

    public final int m() {
        return this.a.length;
    }

    @Override
    public void b(wO ... wOArray) {
        super.b(wOArray);
        for (wO wO2 : wOArray) {
            if (wO2 instanceof xC) {
                xC xC2 = (xC)wO2;
                this.c = xC2.a;
                continue;
            }
            if (wO2 instanceof xG) {
                this.a = ((xG)wO2).a();
                continue;
            }
            if (!(wO2 instanceof xH)) continue;
            this.b = ((xH)wO2).a();
        }
        xF xF2 = this;
        if (xF2.a.length != xF2.b.g()) {
            throw new oS(xF2.a.length, xF2.b.g());
        }
    }

    private void n() {
        if (this.a.length != this.b.g()) {
            throw new oS(this.a.length, this.b.g());
        }
    }

    @Override
    public /* synthetic */ Object a(wO[] wOArray) {
        return this.c(wOArray);
    }
}

