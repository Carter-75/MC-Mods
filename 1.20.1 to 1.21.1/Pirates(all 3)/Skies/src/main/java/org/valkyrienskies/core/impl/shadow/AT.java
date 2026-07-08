/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.bp_0;
import org.valkyrienskies.core.impl.shadow.cg_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cj_0;
import org.valkyrienskies.core.impl.shadow.cp_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public class AT
extends ao_0
implements Serializable {
    private static final long a = -8091216485095130416L;
    private static final int b = 10;
    private static final int c = 512;
    private final cg_0 d;
    private final a e;
    private final bp_0 f;
    private double g;
    private int[] h;

    public AT() {
        this(50.0);
    }

    public AT(double d2) {
        this(50.0, org.valkyrienskies.core.impl.shadow.AT$a.LEGACY, bp_0.REMOVED, new cg_0(new cj_0()));
    }

    public AT(AT aT) {
        ci_0.a(aT);
        AT aT2 = aT;
        this.e = aT2.e;
        aT2 = aT;
        this.f = aT2.f;
        aT2 = aT;
        this.d = aT2.d;
        ((ao_0)this).c(aT.e());
        if (aT.h != null) {
            System.arraycopy(aT.h, 0, this.h, 0, aT.h.length);
        }
        this.a(aT.g);
    }

    protected AT(double d2, a a2, bp_0 bp_02, cg_0 cg_02) {
        this.a(d2);
        this.h = null;
        ci_0.a((Object)a2);
        ci_0.a((Object)bp_02);
        ci_0.a(cg_02);
        this.e = a2;
        this.f = bp_02;
        this.d = cg_02;
    }

    public final void c(double[] dArray) {
        if (dArray == null) {
            this.h = null;
        } else {
            this.h = new int[512];
            Arrays.fill(this.h, -1);
        }
        super.c(dArray);
    }

    public final void c(double[] dArray, int n2, int n3) {
        if (dArray == null) {
            this.h = null;
        } else {
            this.h = new int[512];
            Arrays.fill(this.h, -1);
        }
        super.c(dArray, n2, n3);
    }

    private double b(double d2) {
        AT aT = this;
        return aT.a(aT.e(), d2);
    }

    public final double a(double[] dArray, double d2) {
        int n2 = 0;
        int n3 = 0;
        double[] dArray2 = dArray;
        ch_0.a(dArray, n3, n2, false);
        return this.a(dArray, 0, dArray.length, d2);
    }

    public final double a(double[] dArray, int n2, int n3) {
        return this.a(dArray, n2, n3, this.g);
    }

    public final double a(double[] objectArray, int n2, int n3, double d2) {
        int n4 = n3;
        int n5 = n2;
        double[] dArray = objectArray;
        ch_0.a(objectArray, n5, n4, false);
        if (d2 > 100.0 || d2 <= 0.0) {
            throw new po_0(px_0.OUT_OF_BOUNDS_QUANTILE_VALUE, (Number)d2, 0, 100);
        }
        if (n3 == 0) {
            return Double.NaN;
        }
        if (n3 == 1) {
            return objectArray[n2];
        }
        double[] dArray2 = this.e((double[])objectArray, n2, n3);
        objectArray = this.b((double[])objectArray);
        if (dArray2.length == 0) {
            return Double.NaN;
        }
        return this.e.a(dArray2, (int[])objectArray, d2, this.d);
    }

    @Deprecated
    private static int b(double[] dArray, int n2, int n3) {
        return new cj_0().a(dArray, n2, n3);
    }

    private double f() {
        return this.g;
    }

    public final void a(double d2) {
        if (d2 <= 0.0 || d2 > 100.0) {
            throw new po_0(px_0.OUT_OF_BOUNDS_QUANTILE_VALUE, (Number)d2, 0, 100);
        }
        this.g = d2;
    }

    private AT g() {
        return new AT(this);
    }

    @Deprecated
    private static void h() {
        throw new pb_0();
    }

    private double[] e(double[] dArray, int n2, int n3) {
        if (dArray == this.e()) {
            dArray = this.e();
        } else {
            switch (this.f) {
                case MAXIMAL: {
                    dArray = AT.a(dArray, n2, n3, Double.NaN, Double.POSITIVE_INFINITY);
                    break;
                }
                case MINIMAL: {
                    dArray = AT.a(dArray, n2, n3, Double.NaN, Double.NEGATIVE_INFINITY);
                    break;
                }
                case REMOVED: {
                    dArray = AT.b(dArray, n2, n3, Double.NaN);
                    break;
                }
                case FAILED: {
                    dArray = AT.f(dArray, n2, n3);
                    ch_0.c(dArray);
                    break;
                }
                default: {
                    dArray = AT.f(dArray, n2, n3);
                }
            }
        }
        return dArray;
    }

    private static double[] f(double[] dArray, int n2, int n3) {
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        ch_0.a(dArray, n5, n4, false);
        int n6 = n2;
        return ch_0.a(dArray, n6, n6 + n3);
    }

    private static double[] a(double[] dArray, int n2, int n3, double d2, double d3) {
        dArray = AT.f(dArray, n2, n3);
        for (n2 = 0; n2 < n3; ++n2) {
            dArray[n2] = cq_0.b(Double.NaN, dArray[n2]) ? d3 : dArray[n2];
        }
        return dArray;
    }

    private static double[] b(double[] dArray, int n2, int n3, double d2) {
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        ch_0.a(dArray, n5, n4, false);
        BitSet bitSet = new BitSet(n3);
        for (n4 = n2; n4 < n2 + n3; ++n4) {
            if (!cq_0.b(Double.NaN, dArray[n4])) continue;
            bitSet.set(n4 - n2);
        }
        if (bitSet.isEmpty()) {
            dArray2 = AT.f(dArray, n2, n3);
        } else if (bitSet.cardinality() == n3) {
            dArray2 = new double[]{};
        } else {
            int n6;
            dArray2 = new double[n3 - bitSet.cardinality()];
            n4 = n2;
            int n7 = 0;
            int n8 = 0;
            while ((n6 = bitSet.nextSetBit(n8)) != -1) {
                n8 = n6 - n8;
                System.arraycopy(dArray, n4, dArray2, n7, n8);
                n7 += n8;
                n8 = bitSet.nextClearBit(n6);
                n4 = n2 + n8;
            }
            if (n4 < n2 + n3) {
                System.arraycopy(dArray, n4, dArray2, n7, n2 + n3 - n4);
            }
        }
        return dArray2;
    }

    private int[] b(double[] objectArray) {
        if (objectArray == this.e()) {
            objectArray = this.h;
        } else {
            int[] nArray = new int[512];
            objectArray = nArray;
            Arrays.fill(nArray, -1);
        }
        return objectArray;
    }

    public final a a() {
        return this.e;
    }

    public AT a(a a2) {
        return new AT(this.g, a2, this.f, this.d);
    }

    public final bp_0 b() {
        return this.f;
    }

    public AT a(bp_0 bp_02) {
        return new AT(this.g, this.e, bp_02, this.d);
    }

    public final cg_0 c() {
        return this.d;
    }

    private cp_0 i() {
        cg_0 cg_02 = this.d;
        return cg_02.a;
    }

    public AT a(cg_0 cg_02) {
        return new AT(this.g, this.e, this.f, cg_02);
    }

    public final /* synthetic */ AA d() {
        AT aT = this;
        return new AT(aT);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum a {
        LEGACY("Legacy Apache Commons Math"){

            protected final double a(double d2, int n2) {
                if (Double.compare(d2, 0.0) == 0) {
                    return 0.0;
                }
                if (Double.compare(d2, 1.0) == 0) {
                    return n2;
                }
                return d2 * (double)(n2 + 1);
            }
        }
        ,
        R_1("R-1"){

            protected final double a(double d2, int n2) {
                if (Double.compare(d2, 0.0) == 0) {
                    return 0.0;
                }
                return (double)n2 * d2 + 0.5;
            }

            protected final double a(double[] dArray, int[] nArray, double d2, int n2, cg_0 cg_02) {
                return super.a(dArray, nArray, BY.z(d2 - 0.5), n2, cg_02);
            }
        }
        ,
        R_2("R-2"){

            protected final double a(double d2, int n2) {
                if (Double.compare(d2, 1.0) == 0) {
                    return n2;
                }
                if (Double.compare(d2, 0.0) == 0) {
                    return 0.0;
                }
                return (double)n2 * d2 + 0.5;
            }

            protected final double a(double[] dArray, int[] nArray, double d2, int n2, cg_0 cg_02) {
                double d3 = super.a(dArray, nArray, BY.z(d2 - 0.5), n2, cg_02);
                double d4 = super.a(dArray, nArray, BY.y(d2 + 0.5), n2, cg_02);
                return (d3 + d4) / 2.0;
            }
        }
        ,
        R_3("R-3"){

            protected final double a(double d2, int n2) {
                double d3 = 0.5 / (double)n2;
                if (Double.compare(d2, d3) <= 0) {
                    return 0.0;
                }
                return BY.A((double)n2 * d2);
            }
        }
        ,
        R_4("R-4"){

            protected final double a(double d2, int n2) {
                double d3 = 1.0 / (double)n2;
                if (Double.compare(d2, d3) < 0) {
                    return 0.0;
                }
                if (Double.compare(d2, 1.0) == 0) {
                    return n2;
                }
                return (double)n2 * d2;
            }
        }
        ,
        R_5("R-5"){

            protected final double a(double d2, int n2) {
                double d3 = 0.5 / (double)n2;
                double d4 = ((double)n2 - 0.5) / (double)n2;
                if (Double.compare(d2, d3) < 0) {
                    return 0.0;
                }
                if (Double.compare(d2, d4) >= 0) {
                    return n2;
                }
                return (double)n2 * d2 + 0.5;
            }
        }
        ,
        R_6("R-6"){

            protected final double a(double d2, int n2) {
                double d3 = 1.0 / (double)(n2 + 1);
                double d4 = 1.0 * (double)n2 / (double)(n2 + 1);
                if (Double.compare(d2, d3) < 0) {
                    return 0.0;
                }
                if (Double.compare(d2, d4) >= 0) {
                    return n2;
                }
                return (double)(n2 + 1) * d2;
            }
        }
        ,
        R_7("R-7"){

            protected final double a(double d2, int n2) {
                if (Double.compare(d2, 0.0) == 0) {
                    return 0.0;
                }
                if (Double.compare(d2, 1.0) == 0) {
                    return n2;
                }
                return 1.0 + (double)(n2 - 1) * d2;
            }
        }
        ,
        R_8("R-8"){

            protected final double a(double d2, int n2) {
                double d3 = 0.6666666666666666 / ((double)n2 + 0.3333333333333333);
                double d4 = ((double)n2 - 0.3333333333333333) / ((double)n2 + 0.3333333333333333);
                if (Double.compare(d2, d3) < 0) {
                    return 0.0;
                }
                if (Double.compare(d2, d4) >= 0) {
                    return n2;
                }
                return ((double)n2 + 0.3333333333333333) * d2 + 0.3333333333333333;
            }
        }
        ,
        R_9("R-9"){

            protected final double a(double d2, int n2) {
                double d3 = 0.625 / ((double)n2 + 0.25);
                double d4 = ((double)n2 - 0.375) / ((double)n2 + 0.25);
                if (Double.compare(d2, d3) < 0) {
                    return 0.0;
                }
                if (Double.compare(d2, d4) >= 0) {
                    return n2;
                }
                return ((double)n2 + 0.25) * d2 + 0.375;
            }
        };

        private final String name;

        private a(String string2) {
            this.name = string2;
        }

        protected abstract double a(double var1, int var3);

        protected double a(double[] dArray, int[] nArray, double d2, int n2, cg_0 cg_02) {
            double d3 = BY.y(d2);
            int n3 = (int)d3;
            double d4 = d2 - d3;
            if (d2 < 1.0) {
                return cg_02.a(dArray, nArray, 0);
            }
            if (d2 >= (double)n2) {
                return cg_02.a(dArray, nArray, n2 - 1);
            }
            double d5 = cg_02.a(dArray, nArray, n3 - 1);
            double d6 = cg_02.a(dArray, nArray, n3);
            return d5 + d4 * (d6 - d5);
        }

        protected final double a(double[] dArray, int[] nArray, double d2, cg_0 cg_02) {
            ci_0.a((Object)dArray);
            if (d2 > 100.0 || d2 <= 0.0) {
                throw new po_0(px_0.OUT_OF_BOUNDS_QUANTILE_VALUE, (Number)d2, 0, 100);
            }
            return this.a(dArray, nArray, this.a(d2 / 100.0, dArray.length), dArray.length, cg_02);
        }

        private double a(double[] dArray, double d2, cg_0 cg_02) {
            return this.a(dArray, null, d2, cg_02);
        }

        private String a() {
            return this.name;
        }

        /* synthetic */ a(String string, int n2, String string2, byte by) {
            this(string2);
        }
    }
}

