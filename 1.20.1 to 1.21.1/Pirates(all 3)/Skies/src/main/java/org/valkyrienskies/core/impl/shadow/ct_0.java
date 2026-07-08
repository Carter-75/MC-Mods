/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.BW;
import org.valkyrienskies.core.impl.shadow.cl_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ct
 */
public final class ct_0
implements Serializable,
cl_0 {
    private static final long a = 4605318041528645258L;
    private BW b = null;
    private Map<Class<?>, cl_0> c = new HashMap();

    public ct_0() {
        this.b = new BW();
    }

    private boolean a(Class<?> clazz) {
        return this.c.containsKey(clazz);
    }

    private boolean a(cl_0 cl_02) {
        return this.c.containsValue(cl_02);
    }

    private cl_0 b(Class<?> clazz) {
        return this.c.get(clazz);
    }

    private cl_0 a(Class<?> clazz, cl_0 cl_02) {
        return this.c.put(clazz, cl_02);
    }

    private cl_0 c(Class<?> clazz) {
        return this.c.remove(clazz);
    }

    private void a() {
        this.c.clear();
    }

    private Set<Class<?>> b() {
        return this.c.keySet();
    }

    private Collection<cl_0> c() {
        return this.c.values();
    }

    @Override
    public final double a(Object object) {
        double d2 = Double.NaN;
        if (object instanceof Number || object instanceof String) {
            d2 = this.b.a(object);
        } else {
            Class<?> clazz = object.getClass();
            cl_0 cl_02 = this;
            cl_02 = ((ct_0)cl_02).c.get(clazz);
            if (cl_02 != null) {
                d2 = cl_02.a(object);
            }
        }
        return d2;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ct_0) {
            ct_0 ct_02;
            ct_02 = ct_02;
            if (!((Object)this.b).equals(ct_02.b)) {
                return false;
            }
            if (this.c.size() != ct_02.c.size()) {
                return false;
            }
            for (Map.Entry<Class<?>, cl_0> entry : this.c.entrySet()) {
                if (entry.getValue().equals(ct_02.c.get(entry.getKey()))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int n2 = ((Object)this.b).hashCode();
        for (cl_0 cl_02 : this.c.values()) {
            n2 = n2 * 31 + cl_02.hashCode();
        }
        return n2;
    }
}

