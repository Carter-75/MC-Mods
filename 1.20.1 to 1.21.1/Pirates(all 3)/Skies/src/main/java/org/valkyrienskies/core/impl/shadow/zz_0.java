/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.zs_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zz
 */
public final class zz_0
extends zs_0
implements Serializable {
    private static final long a = 8661194735290153518L;
    private static final int b = 624;
    private static final int c = 397;
    private static final int[] d = new int[]{0, -1727483681};
    private int[] e = new int[624];
    private int f;

    public zz_0() {
        ((zs_0)this).setSeed(System.currentTimeMillis() + (long)System.identityHashCode(this));
    }

    private zz_0(int n2) {
        ((zs_0)this).a(n2);
    }

    private zz_0(int[] nArray) {
        ((zs_0)this).a(nArray);
    }

    private zz_0(long l2) {
        ((zs_0)this).setSeed(l2);
    }

    public final void a(int n2) {
        long l2 = n2;
        this.e[0] = (int)l2;
        this.f = 1;
        while (this.f < 624) {
            long l3 = l2;
            l2 = 1812433253L * (l3 ^ l3 >> 30) + (long)this.f & 0xFFFFFFFFL;
            this.e[this.f] = (int)l2;
            ++this.f;
        }
        this.a();
    }

    public final void a(int[] nArray) {
        long l2;
        long l3;
        long l4;
        int n2;
        if (nArray == null) {
            ((zs_0)this).setSeed(System.currentTimeMillis() + (long)System.identityHashCode(this));
            return;
        }
        ((zs_0)this).a(19650218);
        int n3 = 1;
        int n4 = 0;
        for (n2 = BY.b(624, nArray.length); n2 != 0; --n2) {
            l4 = (long)this.e[n3] & Integer.MAX_VALUE | (this.e[n3] < 0 ? 0x80000000L : 0L);
            long l5 = l3 = (long)this.e[n3 - 1] & Integer.MAX_VALUE | (this.e[n3 - 1] < 0 ? 0x80000000L : 0L);
            l2 = (l4 ^ (l5 ^ l5 >> 30) * 1664525L) + (long)nArray[n4] + (long)n4;
            this.e[n3] = (int)l2;
            ++n4;
            if (++n3 >= 624) {
                this.e[0] = this.e[623];
                n3 = 1;
            }
            if (n4 < nArray.length) continue;
            n4 = 0;
        }
        for (n2 = 623; n2 != 0; --n2) {
            l4 = (long)this.e[n3] & Integer.MAX_VALUE | (this.e[n3] < 0 ? 0x80000000L : 0L);
            long l6 = l3 = (long)this.e[n3 - 1] & Integer.MAX_VALUE | (this.e[n3 - 1] < 0 ? 0x80000000L : 0L);
            l2 = (l4 ^ (l6 ^ l6 >> 30) * 1566083941L) - (long)n3;
            this.e[n3] = (int)l2;
            if (++n3 < 624) continue;
            this.e[0] = this.e[623];
            n3 = 1;
        }
        this.e[0] = Integer.MIN_VALUE;
        this.a();
    }

    /*
     * WARNING - void declaration
     */
    public final void setSeed(long seed) {
        void var1_1;
        ((zs_0)this).a(new int[]{(int)(seed >>> 32), (int)var1_1});
    }

    protected final int b(int n2) {
        int n3;
        if (this.f >= 624) {
            int n4;
            int n5 = this.e[0];
            for (n4 = 0; n4 < 227; ++n4) {
                n3 = n5;
                n5 = this.e[n4 + 1];
                n3 = n3 & Integer.MIN_VALUE | n5 & Integer.MAX_VALUE;
                this.e[n4] = this.e[n4 + 397] ^ n3 >>> 1 ^ d[n3 & 1];
            }
            for (n4 = 227; n4 < 623; ++n4) {
                n3 = n5;
                n5 = this.e[n4 + 1];
                n3 = n3 & Integer.MIN_VALUE | n5 & Integer.MAX_VALUE;
                this.e[n4] = this.e[n4 + -227] ^ n3 >>> 1 ^ d[n3 & 1];
            }
            n3 = n5 & Integer.MIN_VALUE | this.e[0] & Integer.MAX_VALUE;
            this.e[623] = this.e[396] ^ n3 >>> 1 ^ d[n3 & 1];
            this.f = 0;
        }
        n3 = this.e[this.f++];
        n3 ^= n3 >>> 11;
        n3 ^= n3 << 7 & 0x9D2C5680;
        n3 ^= n3 << 15 & 0xEFC60000;
        n3 ^= n3 >>> 18;
        return n3 >>> 32 - n2;
    }
}

