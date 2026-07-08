/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class qR<S extends qN, P extends qM<S>>
implements Serializable {
    private static final long d = 20140126L;
    public final P a;
    public final double b;
    public final P[] c;

    public qR(P p, double d2, P ... PArray) {
        this.a = p;
        this.b = d2;
        this.c = (qM[])PArray.clone();
    }

    public final P a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public final P[] c() {
        return (qM[])this.c.clone();
    }

    public final int d() {
        return this.c.length;
    }

    private boolean a(P p) {
        return p.a(this.a) <= this.b;
    }

    public final boolean a(P p, double d2) {
        return p.a(this.a) <= this.b + d2;
    }
}

