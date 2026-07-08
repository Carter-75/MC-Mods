/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.ho_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.he
 */
public final class he_2<E>
implements fb_2<E> {
    private final int a;
    private final fb_2<? super E> b;

    public static <E> fb_2<E> a(int n2, fb_2<? super E> fb_22) {
        if (n2 <= 0 || fb_22 == null) {
            return ho_2.a();
        }
        if (n2 == 1) {
            return fb_22;
        }
        return new he_2<E>(n2, fb_22);
    }

    public he_2(int n2, fb_2<? super E> fb_22) {
        this.a = n2;
        this.b = fb_22;
    }

    @Override
    public final void a(E e2) {
        for (int i2 = 0; i2 < this.a; ++i2) {
            this.b.a(e2);
        }
    }

    private fb_2<? super E> a() {
        return this.b;
    }

    private int b() {
        return this.a;
    }
}

