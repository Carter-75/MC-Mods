/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.zs_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zr
 */
public abstract class zr_0
extends zs_0
implements Serializable {
    private static final long h = -817701723016583596L;
    protected int a;
    protected final int[] b;
    protected final int[] c;
    protected final int[] d;
    protected final int[] e;
    protected final int[] f;
    protected final int[] g;

    protected zr_0(int n2, int n3, int n4, int n5) {
        this(n2, n3, n4, n5, null);
    }

    protected zr_0(int n2, int n3, int n4, int n5, int n6) {
        this(n2, n3, n4, n5, new int[]{n6});
    }

    protected zr_0(int n2, int n3, int n4, int n5, int[] nArray) {
        n2 = (n2 + 32 - 1) / 32;
        this.b = new int[n2];
        this.a = 0;
        this.c = new int[n2];
        this.d = new int[n2];
        this.e = new int[n2];
        this.f = new int[n2];
        this.g = new int[n2];
        int n6 = 0;
        while (n6 < n2) {
            int n7 = n6;
            this.c[n7] = (n7 + n2 - 1) % n2;
            int n8 = n6;
            this.d[n8] = (n8 + n2 - 2) % n2;
            int n9 = n6;
            this.e[n9] = (n9 + n3) % n2;
            int n10 = n6;
            this.f[n10] = (n10 + n4) % n2;
            int n11 = n6++;
            this.g[n11] = (n11 + n5) % n2;
        }
        ((zs_0)this).a(nArray);
    }

    protected zr_0(int n2, int n3, int n4, int n5, long l2) {
        this(n2, n3, n4, n5, new int[]{(int)(l2 >>> 32), (int)l2});
    }

    public final void a(int n2) {
        ((zs_0)this).a(new int[]{n2});
    }

    public final void a(int[] nArray) {
        if (nArray == null) {
            ((zs_0)this).setSeed(System.currentTimeMillis() + (long)System.identityHashCode(this));
            return;
        }
        System.arraycopy(nArray, 0, this.b, 0, BY.a(nArray.length, this.b.length));
        if (nArray.length < this.b.length) {
            for (int i2 = nArray.length; i2 < this.b.length; ++i2) {
                long l2;
                long l3 = l2 = (long)this.b[i2 - nArray.length];
                this.b[i2] = (int)(1812433253L * (l3 ^ l3 >> 30) + (long)i2);
            }
        }
        this.a = 0;
        this.a();
    }

    /*
     * WARNING - void declaration
     */
    public void setSeed(long seed) {
        void var1_1;
        ((zs_0)this).a(new int[]{(int)(seed >>> 32), (int)var1_1});
    }

    protected abstract int b(int var1);
}

