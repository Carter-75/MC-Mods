/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.hf_2;
import org.valkyrienskies.core.impl.shadow.ho_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gP
 */
public final class gp_1<E>
implements Serializable,
fb_2<E> {
    private static final long a = -3520677225766901240L;
    private final fb_2<? super E>[] b;

    public static <E> fb_2<E> a(fb_2<? super E> ... fb_2Array) {
        hf_2.b(fb_2Array);
        if (fb_2Array.length == 0) {
            return ho_2.a();
        }
        return new gp_1<E>(fb_2Array);
    }

    public static <E> fb_2<E> a(Collection<? extends fb_2<? super E>> object) {
        if (object == null) {
            throw new NullPointerException("Closure collection must not be null");
        }
        if (object.size() == 0) {
            return ho_2.a();
        }
        fb_2[] fb_2Array = new fb_2[object.size()];
        int n2 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            fb_2 fb_22 = (fb_2)object.next();
            fb_2Array[n2++] = fb_22;
        }
        hf_2.b(fb_2Array);
        return new gp_1<E>(false, fb_2Array);
    }

    private gp_1(boolean bl, fb_2<? super E> ... fb_2Array) {
        this.b = bl ? hf_2.a(fb_2Array) : fb_2Array;
    }

    private gp_1(fb_2<? super E> ... fb_2Array) {
        this(true, fb_2Array);
    }

    @Override
    public final void a(E e2) {
        fb_2<? super E>[] fb_2Array = this.b;
        int n2 = this.b.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            fb_2<E> fb_22 = fb_2Array[i2];
            fb_22.a(e2);
        }
    }

    private fb_2<? super E>[] a() {
        return hf_2.a(this.b);
    }
}

