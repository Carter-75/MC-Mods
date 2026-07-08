/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.se
 */
@Deprecated
public final class se_0
implements Comparable<se_0> {
    private static final long a = Long.MIN_VALUE;
    private static final long b = 0x7FF0000000000000L;
    private static final long c = 0xFFFFFFFFFFFFFL;
    private static final long d = 0x10000000000000L;
    private double[] e;
    private int f;
    private int g;
    private long[] h;
    private boolean i;
    private boolean j;
    private boolean k;

    private se_0(double ... dArray) {
        this.e = (double[])dArray.clone();
        int n2 = Integer.MIN_VALUE;
        this.g = Integer.MAX_VALUE;
        this.i = false;
        this.j = false;
        this.k = false;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            long l2;
            if (Double.isInfinite(dArray[i2])) {
                if (dArray[i2] < 0.0) {
                    this.j = true;
                    continue;
                }
                this.i = true;
                continue;
            }
            if (Double.isNaN(dArray[i2])) {
                this.k = true;
                continue;
            }
            long l3 = Double.doubleToLongBits(dArray[i2]);
            long l4 = se_0.c(l3);
            if (l4 == 0L) continue;
            int n3 = se_0.b(l3);
            long l5 = l2 = l4;
            long l6 = 0xFFFFFFFFL;
            int n4 = 32;
            int n5 = 0;
            while (n4 != 0) {
                if ((l5 & l6) != l5) {
                    n5 |= n4;
                    l5 >>= n4;
                }
                l6 >>= (n4 >>= 1);
            }
            n2 = BY.b(n2, n3 + n5);
            l5 = l2 = l4;
            l6 = -4294967296L;
            n4 = 32;
            n5 = 0;
            while (n4 != 0) {
                if ((l5 & l6) == l5) {
                    n5 |= n4;
                    l5 >>= n4;
                }
                l6 >>= (n4 >>= 1);
            }
            this.g = BY.a(this.g, n3 + n5);
        }
        if (this.i && this.j) {
            this.i = false;
            this.j = false;
            this.k = true;
        }
        if (this.g <= n2) {
            this.a(n2 + 16);
            return;
        }
        this.h = new long[]{0L};
    }

    private void a(int n2) {
        this.f = n2 + 31;
        this.f -= this.f % 32;
        if (this.h != null && this.h.length == 1 && this.h[0] == 0L) {
            return;
        }
        n2 = this.f + 1 - this.g;
        n2 = (n2 + 62) / 63;
        this.h = new long[this.e.length * n2];
        n2 = 0;
        int n3 = 62;
        long l2 = 0L;
        int n4 = this.f;
        while (n2 < this.h.length) {
            for (int i2 = 0; i2 < this.e.length; ++i2) {
                if (this.a(i2, n4) != 0) {
                    l2 |= 1L << n3;
                }
                if (n3-- != 0) continue;
                this.h[n2++] = l2;
                l2 = 0L;
                n3 = 62;
            }
            --n4;
        }
    }

    private int a(se_0 se_02) {
        if (this.e.length == se_02.e.length) {
            if (this.k) {
                return 1;
            }
            if (se_02.k) {
                return -1;
            }
            if (this.j || se_02.i) {
                return -1;
            }
            if (this.i || se_02.j) {
                return 1;
            }
            if (this.f < se_02.f) {
                this.a(se_02.f);
            } else if (this.f > se_02.f) {
                se_02.a(this.f);
            }
            int n2 = BY.a(this.h.length, se_02.h.length);
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this.h[i2] < se_02.h[i2]) {
                    return -1;
                }
                if (this.h[i2] <= se_02.h[i2]) continue;
                return 1;
            }
            if (this.h.length < se_02.h.length) {
                return -1;
            }
            if (this.h.length > se_02.h.length) {
                return 1;
            }
            return 0;
        }
        return this.e.length - se_02.e.length;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof se_0) {
            void var1_1;
            return this.a((se_0)var1_1) == 0;
        }
        return false;
    }

    public final int hashCode() {
        int n2 = Arrays.hashCode(this.e);
        n2 = n2 * 37 + this.f;
        n2 = n2 * 37 + this.g;
        n2 = n2 * 37 + (this.i ? 97 : 71);
        n2 = n2 * 37 + (this.j ? 97 : 71);
        n2 = n2 * 37 + (this.k ? 97 : 71);
        return n2;
    }

    private double[] a() {
        return (double[])this.e.clone();
    }

    private static long a(long l2) {
        return l2 & Long.MIN_VALUE;
    }

    private static int b(long l2) {
        return (int)((l2 & 0x7FF0000000000000L) >> 52) - 1075;
    }

    private static long c(long l2) {
        if ((l2 & 0x7FF0000000000000L) == 0L) {
            return (l2 & 0xFFFFFFFFFFFFFL) << 1;
        }
        return 0x10000000000000L | l2 & 0xFFFFFFFFFFFFFL;
    }

    private static int d(long l2) {
        long l3 = l2;
        long l4 = 0xFFFFFFFFL;
        int n2 = 32;
        int n3 = 0;
        while (n2 != 0) {
            if ((l3 & l4) != l3) {
                n3 |= n2;
                l3 >>= n2;
            }
            l4 >>= (n2 >>= 1);
        }
        return n3;
    }

    private static int e(long l2) {
        long l3 = l2;
        long l4 = -4294967296L;
        int n2 = 32;
        int n3 = 0;
        while (n2 != 0) {
            if ((l3 & l4) == l3) {
                n3 |= n2;
                l3 >>= n2;
            }
            l4 >>= (n2 >>= 1);
        }
        return n3;
    }

    private int a(int n2, int n3) {
        long l2 = Double.doubleToLongBits(this.e[n2]);
        if (n3 < (n2 = se_0.b(l2)) || n3 > this.f) {
            return 0;
        }
        if (n3 == this.f) {
            long l3 = l2;
            if ((l3 & Long.MIN_VALUE) == 0L) {
                return 1;
            }
            return 0;
        }
        if (n3 > n2 + 52) {
            long l4 = l2;
            if ((l4 & Long.MIN_VALUE) == 0L) {
                return 0;
            }
            return 1;
        }
        long l5 = l2;
        long l6 = (l5 & Long.MIN_VALUE) == 0L ? se_0.c(l2) : -se_0.c(l2);
        return (int)(l6 >> n3 - n2 & 1L);
    }

    @Override
    public final /* synthetic */ int compareTo(Object object) {
        return this.a((se_0)object);
    }
}

