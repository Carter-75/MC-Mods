/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.zr_0;

public final class zP
extends zr_0 {
    private static final long h = 5680173464174485492L;
    private static final int i = 1024;
    private static final int j = 3;
    private static final int k = 24;
    private static final int l = 10;

    public zP() {
        super(1024, 3, 24, 10);
    }

    private zP(int n2) {
        super(1024, 3, 24, 10, n2);
    }

    private zP(int[] nArray) {
        super(1024, 3, 24, 10, nArray);
    }

    private zP(long l2) {
        super(1024, 3, 24, 10, l2);
    }

    protected final int b(int n2) {
        int n3 = this.c[this.a];
        int n4 = this.b[this.a];
        int n5 = this.b[this.e[this.a]];
        int n6 = this.b[this.f[this.a]];
        int n7 = this.b[this.g[this.a]];
        int n8 = this.b[n3];
        int n9 = n5;
        int n10 = n6;
        int n11 = n7;
        n5 = n10 ^ n10 << 19 ^ (n11 ^ n11 << 14);
        n6 = (n4 ^= n9 ^ n9 >>> 8) ^ n5;
        int n12 = n8;
        int n13 = n4;
        int n14 = n5;
        n4 = n12 ^ n12 << 11 ^ (n13 ^ n13 << 7) ^ (n14 ^ n14 << 13);
        this.b[this.a] = n6;
        this.b[n3] = n4;
        this.a = n3;
        return n4 >>> 32 - n2;
    }
}

