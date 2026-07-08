/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Random;
import org.valkyrienskies.core.impl.shadow.zF;

public final class zB
extends Random
implements zF {
    private static final long a = 2306581345647615033L;
    private final zF b;

    private zB() {
        this.b = null;
    }

    private zB(zF zF2) {
        this.b = zF2;
    }

    private static zB a(zF zF2) {
        return new zB(zF2);
    }

    public final boolean nextBoolean() {
        return this.b.nextBoolean();
    }

    /*
     * WARNING - void declaration
     */
    public final void nextBytes(byte[] bytes) {
        void var1_1;
        this.b.nextBytes((byte[])var1_1);
    }

    public final double nextDouble() {
        return this.b.nextDouble();
    }

    public final float nextFloat() {
        return this.b.nextFloat();
    }

    public final double nextGaussian() {
        return this.b.nextGaussian();
    }

    public final int nextInt() {
        return this.b.nextInt();
    }

    /*
     * WARNING - void declaration
     */
    public final int nextInt(int n2) {
        void var1_1;
        return this.b.nextInt((int)var1_1);
    }

    public final long nextLong() {
        return this.b.nextLong();
    }

    public final void a(int n2) {
        if (this.b != null) {
            this.b.a(n2);
        }
    }

    public final void a(int[] nArray) {
        if (this.b != null) {
            this.b.a(nArray);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void setSeed(long seed) {
        if (this.b != null) {
            void var1_1;
            this.b.setSeed((long)var1_1);
        }
    }
}

