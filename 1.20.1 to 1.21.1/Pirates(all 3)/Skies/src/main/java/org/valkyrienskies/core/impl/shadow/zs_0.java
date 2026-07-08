/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zs
 */
public abstract class zs_0
implements Serializable,
zF {
    private static final long a = 20130104L;
    private double b = Double.NaN;

    public abstract void a(int var1);

    public abstract void a(int[] var1);

    public abstract void setSeed(long var1);

    protected abstract int b(int var1);

    public boolean nextBoolean() {
        return this.b(1) != 0;
    }

    public double nextDouble() {
        long l2 = (long)this.b(26) << 26;
        int n2 = this.b(26);
        return (double)(l2 | (long)n2) * 2.220446049250313E-16;
    }

    public float nextFloat() {
        return (float)this.b(23) * 1.1920929E-7f;
    }

    public double nextGaussian() {
        double d2;
        if (Double.isNaN(this.b)) {
            double d3 = this.nextDouble();
            double d4 = this.nextDouble();
            double d5 = d3 * (Math.PI * 2);
            double d6 = BY.a(-2.0 * BY.k(d4));
            d2 = d6 * BY.o(d5);
            this.b = d6 * BY.n(d5);
        } else {
            d2 = this.b;
            this.b = Double.NaN;
        }
        return d2;
    }

    public int nextInt() {
        return this.b(32);
    }

    /*
     * WARNING - void declaration
     */
    public int nextInt(int n2) {
        void var1_1;
        if (n2 > 0) {
            int n3;
            int n4;
            int n5 = n2;
            if ((n5 & -n5) == n2) {
                return (int)((long)n2 * (long)this.b(31) >> 31);
            }
            while ((n4 = this.b(31)) - (n3 = n4 % n2) + (n2 - 1) < 0) {
            }
            return n3;
        }
        throw new pk_0((int)var1_1);
    }

    public long nextLong() {
        long l2 = (long)this.b(32) << 32;
        long l3 = (long)this.b(32) & 0xFFFFFFFFL;
        return l2 | l3;
    }

    private long a(long l2) {
        if (l2 > 0L) {
            long l3;
            long l4;
            do {
                l3 = (long)this.b(31) << 32;
            } while ((l3 |= (long)this.b(32) & 0xFFFFFFFFL) - (l4 = l3 % l2) + (l2 - 1L) < 0L);
            return l4;
        }
        throw new pk_0(l2);
    }

    public final void a() {
        this.b = Double.NaN;
    }

    /*
     * WARNING - void declaration
     */
    public void nextBytes(byte[] bytes) {
        void var1_1;
        this.b(bytes, 0, ((void)var1_1).length);
    }

    private void a(byte[] byArray, int n2, int n3) {
        if (n2 < 0 || n2 >= byArray.length) {
            throw new po_0(n2, (Number)0, byArray.length);
        }
        if (n3 < 0 || n3 > byArray.length - n2) {
            throw new po_0(n3, (Number)0, byArray.length - n2);
        }
        this.b(byArray, n2, n3);
    }

    private void b(byte[] byArray, int n2, int n3) {
        int n4;
        int n5 = n2;
        int n6 = n5 + (n3 & 0x7FFFFFFC);
        while (n5 < n6) {
            n4 = this.b(32);
            byArray[n5++] = (byte)n4;
            byArray[n5++] = (byte)(n4 >>> 8);
            byArray[n5++] = (byte)(n4 >>> 16);
            byArray[n5++] = (byte)(n4 >>> 24);
        }
        n4 = n2 + n3;
        if (n5 < n4) {
            n2 = this.b(32);
            while (true) {
                byArray[n5++] = (byte)n2;
                if (n5 >= n4) break;
                n2 >>>= 8;
            }
        }
    }
}

