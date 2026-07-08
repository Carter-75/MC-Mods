/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gV
 */
public final class gv_1<I, O>
implements Serializable,
fq_1<I, O> {
    private static final long a = 6374440726369055124L;
    private static gv_1 b = new gv_1(null);
    private final O c;

    public static <I, O> fq_1<I, O> a() {
        return b;
    }

    public static <I, O> fq_1<I, O> b(O o) {
        if (o == null) {
            return b;
        }
        return new gv_1<I, O>(o);
    }

    private gv_1(O o) {
        this.c = o;
    }

    @Override
    public final O a(I i2) {
        return this.c;
    }

    private O b() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        block6: {
            block5: {
                O o;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof gv_1)) {
                    return false;
                }
                gv_1 gv_12 = (gv_1)o;
                o = gv_12.c;
                gv_12 = this;
                if (o == gv_12.c) break block5;
                if (o == null) break block6;
                gv_12 = this;
                if (!o.equals(gv_12.c)) break block6;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int n2 = "ConstantTransformer".hashCode() << 2;
        gv_1 gv_12 = this;
        if (gv_12.c != null) {
            gv_12 = this;
            n2 |= gv_12.c.hashCode();
        }
        return n2;
    }
}

