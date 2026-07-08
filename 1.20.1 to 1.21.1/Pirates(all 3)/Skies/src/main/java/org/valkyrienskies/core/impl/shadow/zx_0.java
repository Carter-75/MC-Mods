/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.zs_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zx
 */
public final class zx_0
extends zs_0
implements Serializable {
    private static final long a = 7288197941165002400L;
    private static final int b = 8;
    private static final int c = 256;
    private static final int d = 128;
    private static final int e = 1020;
    private static final int f = -1640531527;
    private final int[] g = new int[256];
    private final int[] h = new int[256];
    private int i;
    private int j;
    private int k;
    private int l;
    private final int[] m = new int[8];
    private int n;
    private int o;
    private int p;

    public zx_0() {
        ((zs_0)this).setSeed(System.currentTimeMillis() + (long)System.identityHashCode(this));
    }

    private zx_0(long l2) {
        ((zs_0)this).setSeed(l2);
    }

    private zx_0(int[] nArray) {
        ((zs_0)this).a(nArray);
    }

    public final void a(int n2) {
        ((zs_0)this).a(new int[]{n2});
    }

    /*
     * WARNING - void declaration
     */
    public final void setSeed(long seed) {
        void var1_1;
        ((zs_0)this).a(new int[]{(int)(seed >>> 32), (int)var1_1});
    }

    public final void a(int[] nArray) {
        if (nArray == null) {
            ((zs_0)this).setSeed(System.currentTimeMillis() + (long)System.identityHashCode(this));
            return;
        }
        int n2 = nArray.length;
        int n3 = this.g.length;
        System.arraycopy(nArray, 0, this.g, 0, BY.a(n2, n3));
        if (n2 < n3) {
            for (int i2 = n2; i2 < n3; ++i2) {
                long l2;
                long l3 = l2 = (long)this.g[i2 - n2];
                this.g[i2] = (int)(1812433253L * (l3 ^ l3 >> 30) + (long)i2);
            }
        }
        this.e();
    }

    protected final int b(int n2) {
        if (this.i < 0) {
            this.b();
            this.i = 255;
        }
        return this.g[this.i--] >>> 32 - n2;
    }

    private void b() {
        this.o = 0;
        this.p = 128;
        this.k += ++this.l;
        while (this.o < 128) {
            this.c();
        }
        this.p = 0;
        while (this.p < 128) {
            this.c();
        }
    }

    private void c() {
        this.n = this.h[this.o];
        this.j ^= this.j << 13;
        this.j += this.h[this.p++];
        this.d();
        this.n = this.h[this.o];
        this.j ^= this.j >>> 6;
        this.j += this.h[this.p++];
        this.d();
        this.n = this.h[this.o];
        this.j ^= this.j << 2;
        this.j += this.h[this.p++];
        this.d();
        this.n = this.h[this.o];
        this.j ^= this.j >>> 16;
        this.j += this.h[this.p++];
        this.d();
    }

    private void d() {
        this.h[this.o] = this.h[(this.n & 0x3FC) >> 2] + this.j + this.k;
        this.k = this.h[(this.h[this.o] >> 8 & 0x3FC) >> 2] + this.n;
        this.g[this.o++] = this.k;
    }

    private void e() {
        int n2;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        for (n2 = 0; n2 < this.m.length; ++n2) {
            this.m[n2] = -1640531527;
        }
        for (n2 = 0; n2 < 4; ++n2) {
            this.f();
        }
        for (n2 = 0; n2 < 256; n2 += 8) {
            this.m[0] = this.m[0] + this.g[n2];
            this.m[1] = this.m[1] + this.g[n2 + 1];
            this.m[2] = this.m[2] + this.g[n2 + 2];
            this.m[3] = this.m[3] + this.g[n2 + 3];
            this.m[4] = this.m[4] + this.g[n2 + 4];
            this.m[5] = this.m[5] + this.g[n2 + 5];
            this.m[6] = this.m[6] + this.g[n2 + 6];
            this.m[7] = this.m[7] + this.g[n2 + 7];
            this.f();
            this.c(n2);
        }
        for (n2 = 0; n2 < 256; n2 += 8) {
            this.m[0] = this.m[0] + this.h[n2];
            this.m[1] = this.m[1] + this.h[n2 + 1];
            this.m[2] = this.m[2] + this.h[n2 + 2];
            this.m[3] = this.m[3] + this.h[n2 + 3];
            this.m[4] = this.m[4] + this.h[n2 + 4];
            this.m[5] = this.m[5] + this.h[n2 + 5];
            this.m[6] = this.m[6] + this.h[n2 + 6];
            this.m[7] = this.m[7] + this.h[n2 + 7];
            this.f();
            this.c(n2);
        }
        this.b();
        this.i = 255;
        this.a();
    }

    private void f() {
        this.m[0] = this.m[0] ^ this.m[1] << 11;
        this.m[3] = this.m[3] + this.m[0];
        this.m[1] = this.m[1] + this.m[2];
        this.m[1] = this.m[1] ^ this.m[2] >>> 2;
        this.m[4] = this.m[4] + this.m[1];
        this.m[2] = this.m[2] + this.m[3];
        this.m[2] = this.m[2] ^ this.m[3] << 8;
        this.m[5] = this.m[5] + this.m[2];
        this.m[3] = this.m[3] + this.m[4];
        this.m[3] = this.m[3] ^ this.m[4] >>> 16;
        this.m[6] = this.m[6] + this.m[3];
        this.m[4] = this.m[4] + this.m[5];
        this.m[4] = this.m[4] ^ this.m[5] << 10;
        this.m[7] = this.m[7] + this.m[4];
        this.m[5] = this.m[5] + this.m[6];
        this.m[5] = this.m[5] ^ this.m[6] >>> 4;
        this.m[0] = this.m[0] + this.m[5];
        this.m[6] = this.m[6] + this.m[7];
        this.m[6] = this.m[6] ^ this.m[7] << 8;
        this.m[1] = this.m[1] + this.m[6];
        this.m[7] = this.m[7] + this.m[0];
        this.m[7] = this.m[7] ^ this.m[0] >>> 9;
        this.m[2] = this.m[2] + this.m[7];
        this.m[0] = this.m[0] + this.m[1];
    }

    private void c(int n2) {
        this.h[n2] = this.m[0];
        this.h[n2 + 1] = this.m[1];
        this.h[n2 + 2] = this.m[2];
        this.h[n2 + 3] = this.m[3];
        this.h[n2 + 4] = this.m[4];
        this.h[n2 + 5] = this.m[5];
        this.h[n2 + 6] = this.m[6];
        this.h[n2 + 7] = this.m[7];
    }
}

