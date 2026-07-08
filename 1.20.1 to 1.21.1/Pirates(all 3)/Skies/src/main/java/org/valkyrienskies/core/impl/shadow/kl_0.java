/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.kf_0;
import org.valkyrienskies.core.impl.shadow.km_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kl
 */
public final class kl_0<T>
implements kf_0<T> {
    private final List<T> a = new ArrayList<T>();
    private final List<T> b = new ArrayList<T>();
    private int c = 0;
    private final km_0<T> d;

    private kl_0(km_0<T> km_02) {
        this.d = km_02;
    }

    @Override
    public final void a(T t) {
        this.a.add(t);
    }

    @Override
    public final void c(T t) {
        if (this.b.isEmpty() && this.a.isEmpty()) {
            ++this.c;
            return;
        }
        this.b.clear();
        this.a.clear();
        this.c = 1;
    }

    @Override
    public final void b(T t) {
        this.b.add(t);
    }
}

