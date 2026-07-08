/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.zr_0;

public final class zT
extends zr_0 {
    private static final long h = 4032007538246675492L;
    private static final int i = 44497;
    private static final int j = 23;
    private static final int k = 481;
    private static final int l = 229;

    public zT() {
        super(44497, 23, 481, 229);
    }

    private zT(int n2) {
        super(44497, 23, 481, 229, n2);
    }

    private zT(int[] nArray) {
        super(44497, 23, 481, 229, nArray);
    }

    private zT(long l2) {
        super(44497, 23, 481, 229, l2);
    }

    protected final int b(int n2) {
        int n3 = this.c[this.a];
        int n4 = this.d[this.a];
        int n5 = this.b[this.a];
        int n6 = this.b[this.e[this.a]];
        int n7 = this.b[this.f[this.a]];
        int n8 = this.b[this.g[this.a]];
        int n9 = Short.MIN_VALUE & this.b[n3] ^ Short.MAX_VALUE & this.b[n4];
        int n10 = n5;
        int n11 = n6;
        n5 = n10 ^ n10 << 24 ^ (n11 ^ n11 >>> 30);
        int n12 = n7;
        n6 = n12 ^ n12 << 10 ^ n8 << 26;
        n7 = n5 ^ n6;
        n8 = (n6 << 9 ^ n6 >>> 23) & 0xFBFFFFFF;
        n6 = (n6 & 0x20000) != 0 ? n8 ^ 0xB729FCEC : n8;
        int n13 = n5;
        n5 = n9 ^ (n13 ^ n13 >>> 20) ^ n6 ^ n7;
        this.b[this.a] = n7;
        this.b[n3] = n5;
        int n14 = n4;
        this.b[n14] = this.b[n14] & Short.MIN_VALUE;
        this.a = n3;
        int n15 = n5;
        n5 = n15 ^ n15 << 7 & 0x93DD1400;
        n5 ^= n5 << 15 & 0xFA118000;
        return n5 >>> 32 - n2;
    }
}

