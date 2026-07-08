/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.zF;

public final class zK
implements zF {
    private final zF a;

    private zK(zF zF2) {
        this.a = zF2;
    }

    public final void a(int n2) {
        this.a.a(n2);
    }

    public final void a(int[] nArray) {
        this.a.a(nArray);
    }

    /*
     * WARNING - void declaration
     */
    public final synchronized void setSeed(long seed) {
        void var1_1;
        this.a.setSeed((long)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    public final synchronized void nextBytes(byte[] bytes) {
        void var1_1;
        this.a.nextBytes((byte[])var1_1);
    }

    public final synchronized int nextInt() {
        return this.a.nextInt();
    }

    /*
     * WARNING - void declaration
     */
    public final synchronized int nextInt(int n2) {
        void var1_1;
        return this.a.nextInt((int)var1_1);
    }

    public final synchronized long nextLong() {
        return this.a.nextLong();
    }

    public final synchronized boolean nextBoolean() {
        return this.a.nextBoolean();
    }

    public final synchronized float nextFloat() {
        return this.a.nextFloat();
    }

    public final synchronized double nextDouble() {
        return this.a.nextDouble();
    }

    public final synchronized double nextGaussian() {
        return this.a.nextGaussian();
    }
}

