/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.tJ;
import org.valkyrienskies.core.impl.shadow.tK;
import org.valkyrienskies.core.impl.shadow.tL;
import org.valkyrienskies.core.impl.shadow.tM;
import org.valkyrienskies.core.impl.shadow.tQ;
import org.valkyrienskies.core.impl.shadow.tS;
import org.valkyrienskies.core.impl.shadow.tT;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class tR<T extends tL>
extends tM<T> {
    private final tQ<T> a;
    private final int b;
    private final tS<T> c;

    private tR(tQ<T> tQ2, int n2) {
        this(tQ2, n2, new tT(tQ2.a()));
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private tR(tQ tQ2, int n2, tT tT2) {
        super(tQ2.a());
        this.a = tQ2;
        this.b = n2;
        this.c = tT2;
    }

    private tQ<T> b() {
        return this.a;
    }

    private int c() {
        return this.b;
    }

    private tS<T> d() {
        return this.c;
    }

    @Override
    public final List<tJ<T>> a(Collection<T> collection) {
        List<tK<T>> list = null;
        double d2 = Double.POSITIVE_INFINITY;
        for (int i2 = 0; i2 < this.b; ++i2) {
            double d3;
            List<tK<T>> list2 = ((tM)this.a).a(collection);
            double d4 = this.c.a(list2);
            double d5 = d2;
            double d6 = d4;
            if (!(d3 < d5)) continue;
            list = list2;
            d2 = d4;
        }
        return list;
    }
}

