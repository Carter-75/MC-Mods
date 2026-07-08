/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nq_0;
import org.valkyrienskies.core.impl.shadow.nr_0;
import org.valkyrienskies.core.impl.shadow.nx_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.vi_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.nt
 */
public abstract class nt_0
extends nq_0
implements nx_0<lc_0> {
    private static double d = 1.0E-6;
    private int e = nr_0.ANY_SIDE$37d0779;
    private final int f;

    protected nt_0(double d2, int n2) {
        super(d2);
        this.f = n2;
    }

    protected nt_0(double d2, double d3, int n2) {
        super(d2, d3);
        this.f = n2;
    }

    protected nt_0(double d2, double d3, double d4, int n2) {
        super(d2, d3, d4);
        this.f = n2;
    }

    @Override
    public final double a(int n2, vi_0.1 var2_2, double d2, double d3, int n3) {
        return this.a(n2, var2_2, d2, d3, d2 + 0.5 * (d3 - d2), n3);
    }

    @Override
    public final double a(int n2, lc_0 lc_02, double d2, double d3, double d4, int n3) {
        this.e = n3;
        return super.b(n2, lc_02, d2, d3, d4);
    }

    @Override
    public final double b(int n2, lc_0 lc_02, double d2, double d3, double d4) {
        return this.a(n2, lc_02, d2, d3, d4, nr_0.ANY_SIDE$37d0779);
    }

    @Override
    protected final double j() {
        double d2 = this.d();
        double d3 = this.e();
        double d4 = this.b(d2);
        double d5 = this.b(d3);
        if (d4 == 0.0) {
            return d2;
        }
        if (d5 == 0.0) {
            return d3;
        }
        this.c(d2, d3);
        double d6 = this.i();
        double d7 = this.g();
        double d8 = this.h();
        boolean bl = false;
        block19: do {
            double d9;
            double d10;
            double d11;
            if ((d11 = this.b(d10 = d3 - d5 * (d3 - d2) / (d5 - d4))) == 0.0) {
                return d10;
            }
            if (d5 * d11 < 0.0) {
                d2 = d3;
                d4 = d5;
                bl = !bl;
            } else {
                switch (1.a[this.f - 1]) {
                    case 1: {
                        d4 *= 0.5;
                        break;
                    }
                    case 2: {
                        double d12 = d5;
                        d4 *= d12 / (d12 + d11);
                        break;
                    }
                    case 3: {
                        if (d10 != d3) break;
                        throw new oR();
                    }
                    default: {
                        throw new oY();
                    }
                }
            }
            d3 = d10;
            d5 = d11;
            if (!(BY.w(d9) <= d6)) continue;
            switch (1.b[this.e - 1]) {
                case 1: {
                    return d3;
                }
                case 2: {
                    if (!bl) continue block19;
                    return d3;
                }
                case 3: {
                    if (bl) continue block19;
                    return d3;
                }
                case 4: {
                    if (!(d5 <= 0.0)) continue block19;
                    return d3;
                }
                case 5: {
                    if (!(d5 >= 0.0)) continue block19;
                    return d3;
                }
                default: {
                    throw new oY();
                }
            }
        } while (!(BY.w(d3 - d2) < BY.e(d8 * BY.w(d3), d7)));
        switch (1.b[this.e - 1]) {
            case 1: {
                return d3;
            }
            case 2: {
                if (bl) {
                    return d3;
                }
                return d2;
            }
            case 3: {
                if (bl) {
                    return d2;
                }
                return d3;
            }
            case 4: {
                if (d5 <= 0.0) {
                    return d3;
                }
                return d2;
            }
            case 5: {
                if (d5 >= 0.0) {
                    return d3;
                }
                return d2;
            }
        }
        throw new oY();
    }

    static final class 1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            b = new int[nr_0.values$267468cd().length];
            try {
                1.b[nr_0.ANY_SIDE$37d0779 - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.b[nr_0.LEFT_SIDE$37d0779 - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.b[nr_0.RIGHT_SIDE$37d0779 - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.b[nr_0.BELOW_SIDE$37d0779 - 1] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.b[nr_0.ABOVE_SIDE$37d0779 - 1] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            a = new int[org.valkyrienskies.core.impl.shadow.nt$a.values$d90a97d().length];
            try {
                1.a[org.valkyrienskies.core.impl.shadow.nt$a.ILLINOIS$31c873c3 - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[org.valkyrienskies.core.impl.shadow.nt$a.PEGASUS$31c873c3 - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[org.valkyrienskies.core.impl.shadow.nt$a.REGULA_FALSI$31c873c3 - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    protected static final class a
    extends Enum<a> {
        public static final int REGULA_FALSI$31c873c3 = 1;
        public static final int ILLINOIS$31c873c3 = 2;
        public static final int PEGASUS$31c873c3 = 3;
        private static final /* synthetic */ int[] $VALUES$69504202;

        public static int[] values$d90a97d() {
            return (int[])$VALUES$69504202.clone();
        }

        private a() {
        }

        static {
            $VALUES$69504202 = new int[]{REGULA_FALSI$31c873c3, ILLINOIS$31c873c3, PEGASUS$31c873c3};
        }
    }
}

