/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AH;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

class AC
extends an_0
implements Serializable {
    private static final long e = 6112755307178490473L;
    protected long a;
    protected double b;
    protected double c;
    protected double d;

    AC() {
        this.a = 0L;
        this.b = Double.NaN;
        this.c = Double.NaN;
        this.d = Double.NaN;
    }

    AC(AH aH) {
        AC.a(aH, this);
    }

    public void a(double d2) {
        if (this.a == 0L) {
            this.b = 0.0;
        }
        ++this.a;
        double d3 = this.a;
        this.c = d2 - this.b;
        this.d = this.c / d3;
        this.b += this.d;
    }

    public void b() {
        this.b = Double.NaN;
        this.a = 0L;
        this.c = Double.NaN;
        this.d = Double.NaN;
    }

    public double c() {
        return this.b;
    }

    public long g_() {
        return this.a;
    }

    public AC f() {
        AC aC = new AC();
        AC.a(this, aC);
        return aC;
    }

    public static void a(AC aC, AC aC2) {
        ci_0.a(aC);
        ci_0.a(aC2);
        aC2.c(aC.e());
        aC2.a = aC.a;
        aC2.b = aC.b;
        aC2.c = aC.c;
        aC2.d = aC.d;
    }

    public /* synthetic */ an_0 a() {
        return this.f();
    }

    public /* synthetic */ AA d() {
        return this.f();
    }
}

