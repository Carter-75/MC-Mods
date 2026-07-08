/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.hf_2;
import org.valkyrienskies.core.impl.shadow.ho_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hD
 */
public final class hd_1<E>
implements Serializable,
fb_2<E> {
    private static final long a = 3518477308466486130L;
    private final ff_1<? super E>[] b;
    private final fb_2<? super E>[] c;
    private final fb_2<? super E> d;

    public static <E> fb_2<E> a(ff_1<? super E>[] ff_1Array, fb_2<? super E>[] fb_2Array, fb_2<? super E> fb_22) {
        hf_2.b(ff_1Array);
        hf_2.b(fb_2Array);
        if (ff_1Array.length != fb_2Array.length) {
            throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
        }
        if (ff_1Array.length == 0) {
            if (fb_22 == null) {
                return ho_2.a();
            }
            return fb_22;
        }
        return new hd_1<E>(ff_1Array, fb_2Array, fb_22);
    }

    public static <E> fb_2<E> a(Map<ff_1<E>, fb_2<E>> object) {
        if (object == null) {
            throw new NullPointerException("The predicate and closure map must not be null");
        }
        fb_2 fb_22 = (fb_2)object.remove(null);
        int n2 = object.size();
        if (n2 == 0) {
            if (fb_22 == null) {
                return ho_2.a();
            }
            return fb_22;
        }
        fb_2[] fb_2Array = new fb_2[n2];
        ff_1[] ff_1Array = new ff_1[n2];
        int n3 = 0;
        for (Map.Entry entry : object.entrySet()) {
            ff_1Array[n3] = (ff_1)entry.getKey();
            fb_2Array[n3] = (fb_2)entry.getValue();
            ++n3;
        }
        return new hd_1<E>(false, ff_1Array, fb_2Array, fb_22);
    }

    private hd_1(boolean bl, ff_1<? super E>[] ff_1Array, fb_2<? super E>[] fb_2Array, fb_2<? super E> fb_22) {
        this.b = bl ? hf_2.a(ff_1Array) : ff_1Array;
        this.c = bl ? hf_2.a(fb_2Array) : fb_2Array;
        this.d = fb_22 == null ? ho_2.a() : fb_22;
    }

    private hd_1(ff_1<? super E>[] ff_1Array, fb_2<? super E>[] fb_2Array, fb_2<? super E> fb_22) {
        this(true, ff_1Array, fb_2Array, fb_22);
    }

    @Override
    public final void a(E e2) {
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (!this.b[i2].a(e2)) continue;
            this.c[i2].a(e2);
            return;
        }
        this.d.a(e2);
    }

    private ff_1<? super E>[] a() {
        return hf_2.a(this.b);
    }

    private fb_2<? super E>[] b() {
        return hf_2.a(this.c);
    }

    private fb_2<? super E> c() {
        return this.d;
    }
}

