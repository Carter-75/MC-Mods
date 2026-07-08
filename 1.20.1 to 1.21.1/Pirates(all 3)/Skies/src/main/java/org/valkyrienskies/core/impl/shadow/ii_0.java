/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.impl.shadow.ip_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ii
 */
public final class ii_0
implements il_0 {
    private final int a;
    private final int b;
    private final int c;

    public ii_0(int n2, int n3, int n4) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
    }

    @Override
    public final int a() {
        return this.a;
    }

    @Override
    public final int b() {
        return this.b;
    }

    @Override
    public final int c() {
        return this.c;
    }

    @Override
    public final ip_0 d() {
        return ip_0.DELETE;
    }

    private int e() {
        ii_0 ii_02 = this;
        return ii_02.a;
    }

    private int f() {
        ii_0 ii_02 = this;
        return ii_02.b;
    }

    private int g() {
        ii_0 ii_02 = this;
        return ii_02.c;
    }

    private static ii_0 a(int n2, int n3, int n4) {
        return new ii_0(n2, n3, n4);
    }

    private static /* synthetic */ ii_0 a(ii_0 ii_02, int n2, int n3, int n4, int n5) {
        ii_0 ii_03;
        if ((n5 & 1) != 0) {
            ii_03 = ii_02;
            n2 = ii_03.a;
        }
        if ((n5 & 2) != 0) {
            ii_03 = ii_02;
            n3 = ii_03.b;
        }
        if ((n5 & 4) != 0) {
            ii_03 = ii_02;
            n4 = ii_03.c;
        }
        int n6 = n2;
        int n7 = n3;
        n3 = n4;
        n2 = n7;
        int n8 = n6;
        return new ii_0(n8, n2, n3);
    }

    public final String toString() {
        ii_0 ii_02 = this;
        ii_0 ii_03 = ii_02;
        ii_0 ii_04 = this;
        ii_03 = ii_04;
        ii_03 = this;
        return "DeleteVoxelShapeUpdate(regionX=" + ii_02.a + ", regionY=" + ii_04.b + ", regionZ=" + ii_03.c + ')';
    }

    public final int hashCode() {
        ii_0 ii_02 = this;
        int n2 = Integer.hashCode(ii_02.a);
        ii_0 ii_03 = this;
        int n3 = n2 * 31 + Integer.hashCode(ii_03.b);
        ii_0 ii_04 = this;
        int n4 = n3 * 31 + Integer.hashCode(ii_04.c);
        return n4;
    }

    public final boolean equals(Object other) {
        ii_0 ii_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ii_0)) {
            return false;
        }
        ii_02 = ii_02;
        ii_0 ii_03 = this;
        ii_0 ii_04 = ii_03;
        ii_04 = ii_02;
        if (ii_03.a != ii_04.a) {
            return false;
        }
        ii_0 ii_05 = this;
        ii_04 = ii_05;
        ii_04 = ii_02;
        if (ii_05.b != ii_04.b) {
            return false;
        }
        ii_0 ii_06 = this;
        ii_04 = ii_06;
        ii_04 = ii_02;
        return ii_06.c == ii_04.c;
    }
}

