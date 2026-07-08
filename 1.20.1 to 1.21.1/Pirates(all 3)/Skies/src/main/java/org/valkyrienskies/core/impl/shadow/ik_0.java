/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.impl.shadow.ip_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ik
 */
public final class ik_0
implements il_0 {
    private final int a;
    private final int b;
    private final int c;
    private final boolean d;

    public ik_0(int n2, int n3, int n4, boolean bl) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = bl;
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

    private boolean e() {
        return this.d;
    }

    @Override
    public final ip_0 d() {
        return ip_0.EMPTY;
    }

    private int f() {
        ik_0 ik_02 = this;
        return ik_02.a;
    }

    private int g() {
        ik_0 ik_02 = this;
        return ik_02.b;
    }

    private int h() {
        ik_0 ik_02 = this;
        return ik_02.c;
    }

    private boolean i() {
        return this.d;
    }

    private static ik_0 a(int n2, int n3, int n4, boolean bl) {
        return new ik_0(n2, n3, n4, bl);
    }

    private static /* synthetic */ ik_0 a(ik_0 ik_02, int n2, int n3, int n4, boolean bl, int n5) {
        ik_0 ik_03;
        if ((n5 & 1) != 0) {
            ik_03 = ik_02;
            n2 = ik_03.a;
        }
        if ((n5 & 2) != 0) {
            ik_03 = ik_02;
            n3 = ik_03.b;
        }
        if ((n5 & 4) != 0) {
            ik_03 = ik_02;
            n4 = ik_03.c;
        }
        if ((n5 & 8) != 0) {
            bl = ik_02.d;
        }
        int n6 = n2;
        int n7 = n3;
        int n8 = n4;
        n4 = bl ? 1 : 0;
        n3 = n8;
        n2 = n7;
        int n9 = n6;
        return new ik_0(n9, n2, n3, n4 != 0);
    }

    public final String toString() {
        ik_0 ik_02 = this;
        ik_0 ik_03 = ik_02;
        ik_0 ik_04 = this;
        ik_03 = ik_04;
        ik_03 = this;
        return "EmptyVoxelShapeUpdate(regionX=" + ik_02.a + ", regionY=" + ik_04.b + ", regionZ=" + ik_03.c + ", overwriteExistingVoxels=" + this.d + ')';
    }

    public final int hashCode() {
        ik_0 ik_02 = this;
        int n2 = Integer.hashCode(ik_02.a);
        ik_0 ik_03 = this;
        int n3 = n2 * 31 + Integer.hashCode(ik_03.b);
        ik_0 ik_04 = this;
        int n4 = n3 * 31 + Integer.hashCode(ik_04.c);
        int n5 = this.d ? 1 : 0;
        if (n5 != 0) {
            n5 = 1;
        }
        n4 = n4 * 31 + n5;
        return n4;
    }

    public final boolean equals(Object other) {
        ik_0 ik_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ik_0)) {
            return false;
        }
        ik_02 = ik_02;
        ik_0 ik_03 = this;
        ik_0 ik_04 = ik_03;
        ik_04 = ik_02;
        if (ik_03.a != ik_04.a) {
            return false;
        }
        ik_0 ik_05 = this;
        ik_04 = ik_05;
        ik_04 = ik_02;
        if (ik_05.b != ik_04.b) {
            return false;
        }
        ik_0 ik_06 = this;
        ik_04 = ik_06;
        ik_04 = ik_02;
        if (ik_06.c != ik_04.c) {
            return false;
        }
        return this.d == ik_02.d;
    }
}

