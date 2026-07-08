/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.bt_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tb_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bu
 */
public final class bu_0
extends bt_0 {
    private sy_0 a;
    private tq_0 b;

    private void a(double[] object, double[][] dArray, double[][] dArray2) {
        bu_0.a(dArray, object);
        this.a((double[])object);
        this.a(dArray);
        double[][] dArray3 = dArray;
        dArray = dArray2;
        object = dArray3;
        if (dArray3.length != dArray.length) {
            throw new oS(((double[])object).length, dArray.length);
        }
        if (dArray.length > 0 && dArray.length != dArray[0].length) {
            throw new th_0(dArray.length, dArray[0].length);
        }
        dArray = dArray2;
        object = this;
        this.a = new sy_0(dArray);
        object.b = null;
    }

    private void b(double[][] dArray) {
        this.a = new sy_0(dArray);
        this.b = null;
    }

    private tq_0 m() {
        if (this.b == null) {
            this.b = new tb_0(this.a).a().b();
        }
        return this.b;
    }

    protected final tu_0 i() {
        tq_0 tq_02 = this.m();
        tq_0 tq_03 = this.a().d();
        tq_0 tq_04 = tq_03.c(tq_02).c(this.a());
        tq_04 = new tb_0(tq_04).a().b();
        return tq_04.c(tq_03).c(tq_02).a(this.b());
    }

    protected final tq_0 j() {
        tq_0 tq_02 = this.m();
        tq_02 = this.a().d().c(tq_02).c(this.a());
        return new tb_0(tq_02).a().b();
    }

    protected final double k() {
        tu_0 tu_02 = this.l();
        double d2 = tu_02.b((tu_0)((Object)this.m().a(tu_02)));
        return d2 / (double)(this.a().f() - this.a().g());
    }
}

