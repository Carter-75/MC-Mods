/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.ac_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ab
 */
@Deprecated
public final class ab_0<T extends ac_0<T>>
implements Serializable {
    private static final long c = -3442297081515880464L;
    final List<T> a;
    final T b;

    public ab_0(T t) {
        this.b = t;
        this.a = new ArrayList<T>();
    }

    public final void a(T t) {
        this.a.add(t);
    }

    public final List<T> a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }
}

