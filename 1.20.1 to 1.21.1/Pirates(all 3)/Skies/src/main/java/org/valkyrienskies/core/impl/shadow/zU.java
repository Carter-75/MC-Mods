/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.zr_0;

public final class zU
extends zr_0 {
    private static final long h = -6104179812103820574L;
    private static final int i = 512;
    private static final int j = 13;
    private static final int k = 9;
    private static final int l = 5;

    public zU() {
        super(512, 13, 9, 5);
    }

    private zU(int n2) {
        super(512, 13, 9, 5, n2);
    }

    private zU(int[] nArray) {
        super(512, 13, 9, 5, nArray);
    }

    private zU(long l2) {
        super(512, 13, 9, 5, l2);
    }

    protected final int b(int n2) {
        int n3 = this.c[this.a];
        int n4 = this.b[this.a];
        int n5 = this.b[this.e[this.a]];
        int n6 = this.b[this.f[this.a]];
        int n7 = this.b[n3];
        int n8 = n4;
        int n9 = n5;
        n4 = n8 ^ n8 << 16 ^ (n9 ^ n9 << 15);
        int n10 = n6;
        n5 = n10 ^ n10 >>> 11;
        n6 = n4 ^ n5;
        int n11 = n7;
        int n12 = n4;
        int n13 = n6;
        n4 = n11 ^ n11 << 2 ^ (n12 ^ n12 << 18) ^ n5 << 28 ^ (n13 ^ n13 << 5 & 0xDA442D24);
        this.b[this.a] = n6;
        this.b[n3] = n4;
        this.a = n3;
        return n4 >>> 32 - n2;
    }
}

