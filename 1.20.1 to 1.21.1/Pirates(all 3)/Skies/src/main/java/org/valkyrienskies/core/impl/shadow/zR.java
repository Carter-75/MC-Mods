/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.zr_0;

public final class zR
extends zr_0 {
    private static final long h = -7203498180754925124L;
    private static final int i = 19937;
    private static final int j = 70;
    private static final int k = 179;
    private static final int l = 449;

    public zR() {
        super(19937, 70, 179, 449);
    }

    private zR(int n2) {
        super(19937, 70, 179, 449, n2);
    }

    private zR(int[] nArray) {
        super(19937, 70, 179, 449, nArray);
    }

    public zR(long l2) {
        super(19937, 70, 179, 449, l2);
    }

    protected final int b(int n2) {
        int n3 = this.c[this.a];
        int n4 = this.d[this.a];
        int n5 = this.b[this.a];
        int n6 = this.b[this.e[this.a]];
        int n7 = this.b[this.f[this.a]];
        int n8 = this.b[this.g[this.a]];
        int n9 = Integer.MIN_VALUE & this.b[n3] ^ Integer.MAX_VALUE & this.b[n4];
        int n10 = n5;
        int n11 = n6;
        n5 = n10 ^ n10 << 25 ^ (n11 ^ n11 >>> 27);
        int n12 = n8;
        n6 = n7 >>> 9 ^ (n12 ^ n12 >>> 1);
        n7 = n5 ^ n6;
        int n13 = n5;
        int n14 = n6;
        int n15 = n7;
        n5 = n9 ^ (n13 ^ n13 << 9) ^ (n14 ^ n14 << 21) ^ (n15 ^ n15 >>> 21);
        this.b[this.a] = n7;
        this.b[n3] = n5;
        int n16 = n4;
        this.b[n16] = this.b[n16] & Integer.MIN_VALUE;
        this.a = n3;
        int n17 = n5;
        n5 = n17 ^ n17 << 7 & 0xE46E1700;
        n5 ^= n5 << 15 & 0x9B868000;
        return n5 >>> 32 - n2;
    }
}

