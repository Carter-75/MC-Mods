/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zq
 */
public abstract class zq_0
implements zF {
    private double a = Double.NaN;

    private void a() {
        this.a = Double.NaN;
    }

    public final void a(int n2) {
        this.setSeed(n2);
    }

    public final void a(int[] nArray) {
        long l2 = 0L;
        for (int n2 : nArray) {
            l2 = l2 * 0xFFFFFFFBL + (long)n2;
        }
        this.setSeed(l2);
    }

    public abstract void setSeed(long var1);

    public void nextBytes(byte[] bytes) {
        int n2 = 0;
        while (n2 < bytes.length) {
            int n3 = this.nextInt();
            for (int i2 = 0; i2 < 3; ++i2) {
                if (i2 > 0) {
                    n3 >>= 8;
                }
                bytes[n2++] = (byte)n3;
                if (n2 != bytes.length) continue;
                return;
            }
        }
    }

    public int nextInt() {
        return (int)((2.0 * this.nextDouble() - 1.0) * 2.147483647E9);
    }

    /*
     * WARNING - void declaration
     */
    public int nextInt(int n2) {
        void var1_1;
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        int n3 = (int)(this.nextDouble() * (double)n2);
        if (n3 < n2) {
            return n3;
        }
        return (int)(var1_1 - true);
    }

    public long nextLong() {
        return (long)((2.0 * this.nextDouble() - 1.0) * 9.223372036854776E18);
    }

    public boolean nextBoolean() {
        return this.nextDouble() <= 0.5;
    }

    public float nextFloat() {
        return (float)this.nextDouble();
    }

    public abstract double nextDouble();

    public double nextGaussian() {
        if (!Double.isNaN(this.a)) {
            double d2 = this.a;
            this.a = Double.NaN;
            return d2;
        }
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 1.0;
        while (d5 >= 1.0) {
            d3 = 2.0 * this.nextDouble() - 1.0;
            d4 = 2.0 * this.nextDouble() - 1.0;
            double d6 = d3;
            double d7 = d4;
            d5 = d6 * d6 + d7 * d7;
        }
        if (d5 != 0.0) {
            d5 = BY.a(-2.0 * BY.k(d5) / d5);
        }
        this.a = d4 * d5;
        return d3 * d5;
    }
}

