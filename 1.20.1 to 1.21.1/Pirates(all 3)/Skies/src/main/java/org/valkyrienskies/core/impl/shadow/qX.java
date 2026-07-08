/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.qW;
import org.valkyrienskies.core.impl.shadow.qY;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rV;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class qX
implements rV<qU> {
    private static final double c = 1.0E-10;
    public qZ a;
    public boolean b;
    private final double d;

    public qX(qZ qZ2, boolean bl, double d2) {
        this.a = qZ2;
        this.b = bl;
        this.d = d2;
    }

    @Deprecated
    private qX(qZ qZ2, boolean bl) {
        this(qZ2, bl, 1.0E-10);
    }

    private qX h() {
        return this;
    }

    @Override
    private double a(qO<qU> qO2) {
        return this.a((qM<qU>)qO2);
    }

    @Override
    public final double a(qM<qU> qZ2) {
        qZ qZ3 = qZ2;
        qZ2 = qZ3;
        qZ2 = this.a;
        double d2 = qZ3.d - qZ2.d;
        if (this.b) {
            return d2;
        }
        return -d2;
    }

    public final qY a() {
        return new qY(this, null);
    }

    private qW i() {
        return new qW(this.d);
    }

    @Override
    public final boolean a(rV<qU> rV2) {
        return !(this.b ^ ((qX)rV2).b);
    }

    @Override
    public final qM<qU> b(qM<qU> qM2) {
        return this.a;
    }

    @Override
    public final double b() {
        return this.d;
    }

    public final qZ c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    private void j() {
        this.b = !this.b;
    }

    public final /* synthetic */ rK e() {
        qX qX2 = this;
        return new qW(qX2.d);
    }

    public final /* synthetic */ rL f() {
        return this.a();
    }
}

