/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Comparator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gD
 */
public final class gd_1
implements Serializable,
Comparator<Boolean> {
    private static final long a = 1830042991606340609L;
    private static final gd_1 b = new gd_1(true);
    private static final gd_1 c = new gd_1(false);
    private boolean d = false;

    private static gd_1 a() {
        return b;
    }

    private static gd_1 b() {
        return c;
    }

    public static gd_1 a(boolean bl) {
        if (bl) {
            return b;
        }
        return c;
    }

    public gd_1() {
        this(false);
    }

    private gd_1(boolean bl) {
        this.d = bl;
    }

    private int a(Boolean bl, Boolean bl2) {
        boolean bl3;
        boolean bl4 = bl;
        if (bl4 ^ (bl3 = bl2.booleanValue())) {
            if (bl4 ^ this.d) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    public final int hashCode() {
        int n2 = "BooleanComparator".hashCode();
        if (this.d) {
            return -1 * n2;
        }
        return n2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object object) {
        void var1_1;
        return this == object || object instanceof gd_1 && this.d == ((gd_1)var1_1).d;
    }

    private boolean c() {
        return this.d;
    }

    @Override
    public final /* synthetic */ int compare(Object object, Object object2) {
        boolean bl;
        Boolean bl2 = (Boolean)object2;
        object2 = (Boolean)object;
        object = this;
        boolean bl3 = (Boolean)object2;
        if (bl3 ^ (bl = bl2.booleanValue())) {
            if (bl3 ^ ((gd_1)object).d) {
                return 1;
            }
            return -1;
        }
        return 0;
    }
}

