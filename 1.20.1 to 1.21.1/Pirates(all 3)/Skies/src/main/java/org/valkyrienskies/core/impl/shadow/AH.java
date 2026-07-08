/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AC;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public class AH
extends AC
implements Serializable {
    private static final long f = 3942403127395076445L;
    protected double e;

    public AH() {
        this.e = Double.NaN;
    }

    private AH(AH aH) {
        super(aH);
        this.e = aH.e;
    }

    public void a(double d2) {
        if (this.a < 1L) {
            AH aH = this;
            aH.e = 0.0;
            aH.b = 0.0;
        }
        super.a(d2);
        this.e += ((double)this.a - 1.0) * this.c * this.d;
    }

    public void b() {
        super.b();
        this.e = Double.NaN;
    }

    public double c() {
        return this.e;
    }

    public AH i() {
        AH aH = new AH();
        AH.a(this, aH);
        return aH;
    }

    public static void a(AH aH, AH aH2) {
        ci_0.a(aH);
        ci_0.a(aH2);
        AC.a(aH, aH2);
        aH2.e = aH.e;
    }

    public /* synthetic */ AC f() {
        return this.i();
    }

    public /* synthetic */ an_0 a() {
        return this.i();
    }

    public /* synthetic */ AA d() {
        return this.i();
    }
}

