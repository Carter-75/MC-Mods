/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.pM;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class pN
implements Serializable {
    private static final long a = 20130813L;
    private final List<pM> b = new ArrayList<pM>();

    private void a(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        double d6 = 1.0;
        pN pN2 = this;
        pN2.b.add(new pM(1.0, d5, d4));
    }

    private void a(double d2, double d3, double d4) {
        this.b.add(new pM(1.0, d3, d4));
    }

    private void a(pM pM2) {
        this.b.add(pM2);
    }

    private List<pM> a() {
        return new ArrayList<pM>(this.b);
    }

    private void b() {
        this.b.clear();
    }
}

