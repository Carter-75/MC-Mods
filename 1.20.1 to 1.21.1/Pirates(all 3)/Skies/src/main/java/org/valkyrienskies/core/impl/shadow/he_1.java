/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.gv_1;
import org.valkyrienskies.core.impl.shadow.hf_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hE
 */
public final class he_1<I, O>
implements Serializable,
fq_1<I, O> {
    private static final long a = -6404460890903469332L;
    private final ff_1<? super I>[] b;
    private final fq_1<? super I, ? extends O>[] c;
    private final fq_1<? super I, ? extends O> d;

    public static <I, O> fq_1<I, O> a(ff_1<? super I>[] ff_1Array, fq_1<? super I, ? extends O>[] fq_1Array, fq_1<? super I, ? extends O> fq_12) {
        hf_2.b(ff_1Array);
        hf_2.b(fq_1Array);
        if (ff_1Array.length != fq_1Array.length) {
            throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
        }
        if (ff_1Array.length == 0) {
            if (fq_12 == null) {
                return gv_1.a();
            }
            return fq_12;
        }
        return new he_1<I, O>(ff_1Array, fq_1Array, fq_12);
    }

    public static <I, O> fq_1<I, O> a(Map<? extends ff_1<? super I>, ? extends fq_1<? super I, ? extends O>> object) {
        if (object == null) {
            throw new NullPointerException("The predicate and transformer map must not be null");
        }
        if (object.size() == 0) {
            return gv_1.a();
        }
        fq_1 fq_12 = (fq_1)object.remove(null);
        int n2 = object.size();
        if (n2 == 0) {
            if (fq_12 == null) {
                return gv_1.a();
            }
            return fq_12;
        }
        fq_1[] fq_1Array = new fq_1[n2];
        ff_1[] ff_1Array = new ff_1[n2];
        int n3 = 0;
        for (Map.Entry entry : object.entrySet()) {
            ff_1Array[n3] = (ff_1)entry.getKey();
            fq_1Array[n3] = (fq_1)entry.getValue();
            ++n3;
        }
        return new he_1<I, O>(false, ff_1Array, fq_1Array, fq_12);
    }

    private he_1(boolean bl, ff_1<? super I>[] ff_1Array, fq_1<? super I, ? extends O>[] fq_1Array, fq_1<? super I, ? extends O> fq_12) {
        this.b = bl ? hf_2.a(ff_1Array) : ff_1Array;
        this.c = bl ? hf_2.a(fq_1Array) : fq_1Array;
        this.d = fq_12 == null ? gv_1.a() : fq_12;
    }

    private he_1(ff_1<? super I>[] ff_1Array, fq_1<? super I, ? extends O>[] fq_1Array, fq_1<? super I, ? extends O> fq_12) {
        this(true, ff_1Array, fq_1Array, fq_12);
    }

    @Override
    public final O a(I i2) {
        for (int i3 = 0; i3 < this.b.length; ++i3) {
            if (!this.b[i3].a(i2)) continue;
            return this.c[i3].a(i2);
        }
        return this.d.a(i2);
    }

    private ff_1<? super I>[] a() {
        return hf_2.a(this.b);
    }

    private fq_1<? super I, ? extends O>[] b() {
        return hf_2.a(this.c);
    }

    private fq_1<? super I, ? extends O> c() {
        return this.d;
    }
}

