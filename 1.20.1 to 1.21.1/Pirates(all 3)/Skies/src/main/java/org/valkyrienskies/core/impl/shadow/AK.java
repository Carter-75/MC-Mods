/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AH;
import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AK
extends an_0
implements Serializable {
    private static final long a = 5728716329662425188L;
    private AM b = null;

    public AK() {
        this.b = new AM();
    }

    private AK(AH aH) {
        this.b = new AM(aH);
    }

    private AK(AK aK) {
        AK.a(aK, this);
    }

    private AK(boolean bl) {
        this.b = new AM(bl);
    }

    private AK(boolean bl, AH aH) {
        this.b = new AM(bl, aH);
    }

    public final void a(double d2) {
        ((an_0)this.b).a(d2);
    }

    public final long g_() {
        return this.b.g_();
    }

    public final double c() {
        return BY.a(((an_0)this.b).c());
    }

    public final void b() {
        ((an_0)this.b).b();
    }

    public final double a(double[] dArray) {
        return BY.a(((ao_0)this.b).a(dArray));
    }

    public final double a(double[] dArray, int n2, int n3) {
        return BY.a(((ao_0)this.b).a(dArray, n2, n3));
    }

    private double a(double[] dArray, double d2, int n2, int n3) {
        return BY.a(this.b.a(dArray, d2, n2, n3));
    }

    private double a(double[] dArray, double d2) {
        return BY.a(this.b.a(dArray, d2));
    }

    private boolean f() {
        AM aM = this.b;
        return aM.b;
    }

    private void a(boolean bl) {
        boolean bl2 = bl;
        AM aM = this.b;
        this.b.b = bl2;
    }

    private AK g() {
        AK aK = new AK();
        AK.a(this, aK);
        return aK;
    }

    private static void a(AK aK, AK aK2) {
        ci_0.a(aK);
        ci_0.a(aK2);
        aK2.c(aK.e());
        aK2.b = aK.b.g();
    }

    public final /* synthetic */ an_0 a() {
        return this.g();
    }

    public final /* synthetic */ AA d() {
        return this.g();
    }
}

