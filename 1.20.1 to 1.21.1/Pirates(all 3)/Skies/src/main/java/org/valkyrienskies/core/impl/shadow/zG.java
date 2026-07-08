/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Random;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.zF;

public final class zG {
    private zG() {
    }

    public static 1 a(Random random) {
        return new zF(random){
            private /* synthetic */ Random a;
            {
                this.a = random;
            }

            public final void a(int n2) {
                this.a.setSeed(n2);
            }

            public final void a(int[] nArray) {
                this.a.setSeed(zG.a(nArray));
            }

            /*
             * WARNING - void declaration
             */
            public final void setSeed(long seed) {
                void var1_1;
                this.a.setSeed((long)var1_1);
            }

            /*
             * WARNING - void declaration
             */
            public final void nextBytes(byte[] bytes) {
                void var1_1;
                this.a.nextBytes((byte[])var1_1);
            }

            public final int nextInt() {
                return this.a.nextInt();
            }

            /*
             * WARNING - void declaration
             */
            public final int nextInt(int n2) {
                void var1_1;
                if (n2 <= 0) {
                    throw new pk_0(n2);
                }
                return this.a.nextInt((int)var1_1);
            }

            public final long nextLong() {
                return this.a.nextLong();
            }

            public final boolean nextBoolean() {
                return this.a.nextBoolean();
            }

            public final float nextFloat() {
                return this.a.nextFloat();
            }

            public final double nextDouble() {
                return this.a.nextDouble();
            }

            public final double nextGaussian() {
                return this.a.nextGaussian();
            }
        };
    }

    public static long a(int[] nArray) {
        long l2 = 0L;
        for (int n2 : nArray) {
            l2 = l2 * 0xFFFFFFFBL + (long)n2;
        }
        return l2;
    }
}

