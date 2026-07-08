/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gG
 */
public final class gg_1<T>
implements Serializable,
Comparator<T> {
    private static final long a = 82794675842863201L;
    private final Map<T, Integer> b = new HashMap<T, Integer>();
    private int c = 0;
    private boolean d = false;
    private a e = org.valkyrienskies.core.impl.shadow.gG$a.EXCEPTION;

    public gg_1() {
    }

    private gg_1(T ... TArray) {
        if (TArray == null) {
            throw new NullPointerException("The list of items must not be null");
        }
        for (T t : TArray) {
            this.a(t);
        }
    }

    private gg_1(List<T> object) {
        if (object == null) {
            throw new NullPointerException("The list of items must not be null");
        }
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            this.a(e2);
        }
    }

    private boolean a() {
        return this.d;
    }

    private void b() {
        gg_1 gg_12 = this;
        if (gg_12.d) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    private a c() {
        return this.e;
    }

    private void a(a a2) {
        this.b();
        if (a2 == null) {
            throw new NullPointerException("Unknown object behavior must not be null");
        }
        this.e = a2;
    }

    private boolean a(T object) {
        this.b();
        object = this.b.put(object, this.c++);
        return object == null;
    }

    private boolean a(T object, T t) {
        this.b();
        Integer n2 = this.b.get(object);
        if (n2 == null) {
            throw new IllegalArgumentException(object + " not known to " + this);
        }
        object = this.b.put(t, n2);
        return object == null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int compare(T obj1, T obj2) {
        this.d = true;
        Integer n2 = this.b.get(obj1);
        Integer n3 = this.b.get(obj2);
        if (n2 == null || n3 == null) {
            switch (this.e) {
                case BEFORE: {
                    if (n2 == null) {
                        if (n3 == null) {
                            return 0;
                        }
                        return -1;
                    }
                    return 1;
                }
                case AFTER: {
                    if (n2 == null) {
                        if (n3 == null) {
                            return 0;
                        }
                        return 1;
                    }
                    return -1;
                }
                case EXCEPTION: {
                    void var2_2;
                    void var1_1;
                    var1_1 = n2 == null ? var1_1 : var2_2;
                    throw new IllegalArgumentException("Attempting to compare unknown object " + var1_1);
                }
            }
            throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + (Object)((Object)this.e));
        }
        return n2.compareTo(n3);
    }

    public final int hashCode() {
        int n2 = 629 + (this.b == null ? 0 : this.b.hashCode());
        n2 = n2 * 37 + (this.e == null ? 0 : this.e.hashCode());
        n2 = n2 * 37 + this.c;
        n2 = n2 * 37 + (this.d ? 0 : 1);
        return n2;
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass().equals(this.getClass())) {
            gg_1 gg_12;
            gg_12 = gg_12;
            return (this.b == null ? gg_12.b == null : this.b.equals(gg_12.b)) && (this.e == null ? gg_12.e == null : this.e == gg_12.e && this.c == gg_12.c && this.d == gg_12.d && this.e == gg_12.e);
        }
        return false;
    }

    public static enum a {
        BEFORE,
        AFTER,
        EXCEPTION;

    }
}

