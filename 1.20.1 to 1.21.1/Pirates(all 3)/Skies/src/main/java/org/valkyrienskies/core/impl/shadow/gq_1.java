/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.hf_2;
import org.valkyrienskies.core.impl.shadow.hp_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gQ
 */
public final class gq_1<T>
implements Serializable,
fq_1<T, T> {
    private static final long a = 3514945074733160196L;
    private final fq_1<? super T, ? extends T>[] b;

    public static <T> fq_1<T, T> a(fq_1<? super T, ? extends T> ... fq_1Array) {
        hf_2.b(fq_1Array);
        if (fq_1Array.length == 0) {
            return hp_2.a();
        }
        return new gq_1<T>(fq_1Array);
    }

    public static <T> fq_1<T, T> a(Collection<? extends fq_1<? super T, ? extends T>> fq_1Array) {
        if (fq_1Array == null) {
            throw new NullPointerException("Transformer collection must not be null");
        }
        if (fq_1Array.size() == 0) {
            return hp_2.a();
        }
        fq_1Array = fq_1Array.toArray(new fq_1[fq_1Array.size()]);
        hf_2.b(fq_1Array);
        return new gq_1<T>(false, fq_1Array);
    }

    private gq_1(boolean bl, fq_1<? super T, ? extends T>[] fq_1Array) {
        this.b = bl ? hf_2.a(fq_1Array) : fq_1Array;
    }

    private gq_1(fq_1<? super T, ? extends T> ... fq_1Array) {
        this(true, fq_1Array);
    }

    @Override
    public final T a(T t) {
        fq_1<? super T, ? extends T>[] fq_1Array = this.b;
        int n2 = this.b.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            fq_1<T, T> fq_12 = fq_1Array[i2];
            t = fq_12.a(t);
        }
        return t;
    }

    private fq_1<? super T, ? extends T>[] a() {
        return hf_2.a(this.b);
    }
}

