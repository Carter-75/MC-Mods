/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.av_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.mO;
import org.valkyrienskies.core.impl.shadow.mU;
import org.valkyrienskies.core.impl.shadow.oT;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class AS
extends an_0
implements Serializable,
av_0 {
    private static final int a = 5;
    private static final double b = 50.0;
    private static final long c = 2283912083175715479L;
    private static final DecimalFormat d = new DecimalFormat("00.00");
    private final List<Double> e = new a<Double>(5);
    private final double f;
    private transient double g;
    private d h = null;
    private double i = Double.NaN;
    private long j;

    private AS(double d2) {
        if (d2 > 100.0 || d2 < 0.0) {
            throw new po_0(px_0.OUT_OF_RANGE, (Number)d2, 0, 100);
        }
        this.f = d2 / 100.0;
    }

    AS() {
        this(50.0);
    }

    @Override
    public final int hashCode() {
        double d2 = ((an_0)this).c();
        d2 = Double.isNaN(d2) ? 37.0 : d2;
        double d3 = this.h == null ? 0.0 : (double)this.h.hashCode();
        double[] dArray = new double[]{d2, this.f, d3, this.j};
        return Arrays.hashCode(dArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final boolean equals(Object o) {
        AS aS;
        boolean bl = false;
        if (this == o) {
            return true;
        }
        if (o == null) return bl;
        if (!(o instanceof AS)) return bl;
        aS = aS;
        bl = this.h != null && aS.h != null;
        boolean bl2 = this.h == null && aS.h == null;
        bl = bl ? this.h.equals(aS.h) : bl2;
        if (!bl) return false;
        AS aS2 = this;
        AS aS3 = aS2;
        aS3 = aS;
        if (aS2.j != aS3.j) return false;
        return true;
    }

    @Override
    public final void a(double d2) {
        ++this.j;
        this.g = d2;
        if (this.h == null) {
            if (this.e.add(d2)) {
                Collections.sort(this.e);
                this.i = this.e.get((int)(this.f * (double)(this.e.size() - 1)));
                return;
            }
            double d3 = this.f;
            List<Double> list = this.e;
            this.h = new c(list, d3, 0);
        }
        this.i = this.h.a(d2);
    }

    public final String toString() {
        if (this.h == null) {
            return String.format("obs=%s pValue=%s", d.format(this.g), d.format(this.i));
        }
        return String.format("obs=%s markers=%s", d.format(this.g), this.h.toString());
    }

    @Override
    public final long g_() {
        return this.j;
    }

    @Override
    public final an_0 a() {
        AS aS = new AS(100.0 * this.f);
        if (this.h != null) {
            aS.h = (d)this.h.clone();
        }
        aS.j = this.j;
        aS.i = this.i;
        aS.e.clear();
        aS.e.addAll(this.e);
        return aS;
    }

    private double f() {
        return this.f;
    }

    @Override
    public final void b() {
        this.h = null;
        this.e.clear();
        this.j = 0L;
        this.i = Double.NaN;
    }

    @Override
    public final double c() {
        if (Double.compare(this.f, 1.0) == 0) {
            this.i = this.g();
        } else if (Double.compare(this.f, 0.0) == 0) {
            this.i = this.h();
        }
        return this.i;
    }

    private double g() {
        double d2 = Double.NaN;
        if (this.h != null) {
            d2 = this.h.b(5);
        } else if (!this.e.isEmpty()) {
            d2 = this.e.get(this.e.size() - 1);
        }
        return d2;
    }

    private double h() {
        double d2 = Double.NaN;
        if (this.h != null) {
            d2 = this.h.b(1);
        } else if (!this.e.isEmpty()) {
            d2 = this.e.get(0);
        }
        return d2;
    }

    private static d a(List<Double> list, double d2) {
        return new c(list, d2, 0);
    }

    @Override
    public final /* synthetic */ AA d() {
        return ((an_0)this).a();
    }

    static final class 1 {
    }

    protected static interface d
    extends Cloneable {
        public double a();

        public Object clone();

        public double b(int var1);

        public double a(double var1);

        public double a(int var1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a<E>
    extends ArrayList<E>
    implements Serializable {
        private static final long a = 2283952083075725479L;
        private final int b;

        a(int n2) {
            super(5);
            this.b = 5;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean add(E e2) {
            if (this.size() < this.b) {
                void var1_1;
                return super.add(var1_1);
            }
            return false;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final boolean addAll(Collection<? extends E> collection) {
            boolean bl = collection != null && collection.size() + this.size() <= this.b;
            if (bl) {
                void var1_1;
                return super.addAll(var1_1);
            }
            return false;
        }
    }

    static final class b
    implements Serializable,
    Cloneable {
        private static final long i = -3575879478288538431L;
        private int j;
        double a;
        double b;
        double c;
        double d;
        transient b e;
        transient b f;
        final mU g = new mU();
        transient mO h = new mO();

        private b() {
            b b2;
            b2 = b2.e = (b2.f = this);
        }

        private b(double d2, double d3, double d4, double d5) {
            this();
            this.c = d2;
            this.b = d3;
            this.d = d4;
            this.a = d5;
        }

        private b d(b b2) {
            ci_0.a(b2);
            this.f = b2;
            return this;
        }

        private b e(b b2) {
            ci_0.a(b2);
            this.e = b2;
            return this;
        }

        private b b(int n2) {
            this.j = n2;
            return this;
        }

        private void a() {
            this.b += this.d;
        }

        void a(int n2) {
            this.a += (double)n2;
        }

        private double b() {
            return this.b - this.a;
        }

        private double c() {
            boolean bl;
            b b2 = this;
            double d2 = b2.b - b2.a;
            boolean bl2 = this.e.a - this.a > 1.0;
            boolean bl3 = bl = this.f.a - this.a < -1.0;
            if (d2 >= 1.0 && bl2 || d2 <= -1.0 && bl) {
                int n2 = d2 >= 0.0 ? 1 : -1;
                double[] dArray = new double[]{this.f.a, this.a, this.e.a};
                double[] dArray2 = new double[]{this.f.c, this.c, this.e.c};
                double d3 = this.a + (double)n2;
                Object object = this.g.b(dArray, dArray2);
                this.c = object.a(d3);
                double d4 = this.c;
                if (d4 <= (object = (Object)dArray2)[0] || d4 >= object[2]) {
                    int n3 = d3 - dArray[1] > 0.0 ? 1 : -1;
                    dArray = new double[]{dArray[1], dArray[n3 + 1]};
                    dArray2 = new double[]{dArray2[1], dArray2[n3 + 1]};
                    ch_0.a(dArray, (double[][])new double[][]{dArray2});
                    lc_0 lc_02 = this.h.b(dArray, dArray2);
                    this.c = lc_02.a(d3);
                }
                this.a(n2);
            }
            return this.c;
        }

        private static boolean a(double[] dArray, double d2) {
            return d2 <= dArray[0] || d2 >= dArray[2];
        }

        public final boolean equals(Object o) {
            boolean bl;
            block4: {
                boolean bl2;
                block3: {
                    b b2;
                    block2: {
                        bl = false;
                        if (this != o) break block2;
                        bl2 = true;
                        break block3;
                    }
                    if (o == null || !(o instanceof b)) break block4;
                    b2 = b2;
                    bl = Double.compare(this.c, b2.c) == 0;
                    bl = bl && Double.compare(this.a, b2.a) == 0;
                    bl = bl && Double.compare(this.b, b2.b) == 0;
                    bl = bl && Double.compare(this.d, b2.d) == 0;
                    bl = bl && this.e.j == b2.e.j;
                    bl2 = bl && this.f.j == b2.f.j;
                }
                bl = bl2;
            }
            return bl;
        }

        public final int hashCode() {
            return Arrays.hashCode(new double[]{this.c, this.a, this.d, this.b, this.f.j, this.e.j});
        }

        private void a(ObjectInputStream objectInputStream) {
            b b2;
            objectInputStream.defaultReadObject();
            b2 = b2.f = (b2.e = this);
            this.h = new mO();
        }

        public final Object clone() {
            return new b(this.c, this.b, this.d, this.a);
        }

        public final String toString() {
            return String.format("index=%.0f,n=%.0f,np=%.2f,q=%.2f,dn=%.2f,prev=%d,next=%d", this.j, cq_0.a(this.a, 0), cq_0.a(this.b, 2), cq_0.a(this.c, 2), cq_0.a(this.d, 2), this.f.j, this.e.j);
        }

        static /* synthetic */ b a(b b2, b b3) {
            ci_0.a(b3);
            b2.f = b3;
            return b2;
        }

        static /* synthetic */ b b(b b2, b b3) {
            ci_0.a(b3);
            b2.e = b3;
            return b2;
        }

        static /* synthetic */ b a(b b2, int n2) {
            v0.j = n2;
            return b2;
        }

        /* synthetic */ b(byte by) {
            this();
        }

        /* synthetic */ b(double d2, double d3, double d4, double d5, byte by) {
            this(d2, d3, d4, d5);
        }

        static /* synthetic */ double a(b b2, double d2) {
            b2.c = d2;
            return b2.c;
        }

        static /* synthetic */ double a(b b2) {
            boolean bl;
            b b3 = b2;
            double d2 = b2.b - b3.a;
            int n2 = b2.e.a - b2.a > 1.0 ? 1 : 0;
            boolean bl2 = bl = b2.f.a - b2.a < -1.0;
            if (d2 >= 1.0 && n2 != 0 || d2 <= -1.0 && bl) {
                n2 = d2 >= 0.0 ? 1 : -1;
                double[] dArray = new double[]{b2.f.a, b2.a, b2.e.a};
                double[] dArray2 = new double[]{b2.f.c, b2.c, b2.e.c};
                double d3 = b2.a + (double)n2;
                Object object = b2.g.b(dArray, dArray2);
                b2.c = object.a(d3);
                double d4 = b2.c;
                if (d4 <= (object = (Object)dArray2)[0] || d4 >= object[2]) {
                    int n3 = d3 - dArray[1] > 0.0 ? 1 : -1;
                    dArray = new double[]{dArray[1], dArray[n3 + 1]};
                    dArray2 = new double[]{dArray2[1], dArray2[n3 + 1]};
                    ch_0.a(dArray, (double[][])new double[][]{dArray2});
                    lc_0 lc_02 = b2.h.b(dArray, dArray2);
                    b2.c = lc_02.a(d3);
                }
                b2.a(n2);
            }
            return b2.c;
        }

        static /* synthetic */ void b(b b2, int n2) {
            b2.a(n2);
        }

        static /* synthetic */ void b(b b2) {
            b2.b += b2.d;
        }

        static /* synthetic */ double c(b b2) {
            return b2.c;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class c
    implements Serializable,
    d {
        private static final long a = 1L;
        private static final int b = 2;
        private static final int c = 4;
        private final b[] d;
        private transient int e;

        private c(b[] bArray) {
            this.e = -1;
            ci_0.a(bArray);
            this.d = bArray;
            for (int i2 = 1; i2 < 5; ++i2) {
                org.valkyrienskies.core.impl.shadow.AS$b.a(org.valkyrienskies.core.impl.shadow.AS$b.b(org.valkyrienskies.core.impl.shadow.AS$b.a(this.d[i2], this.d[i2 - 1]), this.d[i2 + 1]), i2);
            }
            org.valkyrienskies.core.impl.shadow.AS$b.a(org.valkyrienskies.core.impl.shadow.AS$b.b(org.valkyrienskies.core.impl.shadow.AS$b.a(this.d[0], this.d[0]), this.d[1]), 0);
            org.valkyrienskies.core.impl.shadow.AS$b.a(org.valkyrienskies.core.impl.shadow.AS$b.b(org.valkyrienskies.core.impl.shadow.AS$b.a(this.d[5], this.d[4]), this.d[5]), 5);
        }

        private c(List<Double> list, double d2) {
            double d3 = d2;
            int n2 = list == null ? -1 : list.size();
            if (n2 < 5) {
                throw new oT(px_0.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, n2, 5);
            }
            Collections.sort(list);
            this(new b[]{new b(0), new b(list.get(0), 1.0, 0.0, 1.0, 0), new b(list.get(1), 1.0 + d3 * 2.0, d3 / 2.0, 2.0, 0), new b(list.get(2), 1.0 + d3 * 4.0, d3, 3.0, 0), new b(list.get(3), 3.0 + d3 * 2.0, (d3 + 1.0) / 2.0, 4.0, 0), new b(list.get(4), 5.0, 1.0, 5.0, 0)});
        }

        private static b[] a(List<Double> list, double d2) {
            int n2 = list == null ? -1 : list.size();
            if (n2 < 5) {
                throw new oT(px_0.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, n2, 5);
            }
            Collections.sort(list);
            return new b[]{new b(0), new b(list.get(0), 1.0, 0.0, 1.0, 0), new b(list.get(1), 1.0 + d2 * 2.0, d2 / 2.0, 2.0, 0), new b(list.get(2), 1.0 + d2 * 4.0, d2, 3.0, 0), new b(list.get(3), 3.0 + d2 * 2.0, (d2 + 1.0) / 2.0, 4.0, 0), new b(list.get(4), 5.0, 1.0, 5.0, 0)};
        }

        public final int hashCode() {
            return Arrays.deepHashCode(this.d);
        }

        public final boolean equals(Object o) {
            boolean bl = false;
            if (this == o) {
                bl = true;
            } else if (o != null && o instanceof c) {
                c c2;
                c2 = c2;
                bl = Arrays.deepEquals(this.d, c2.d);
            }
            return bl;
        }

        @Override
        public final double a(double d2) {
            b b2;
            b b3;
            double d3;
            double d4 = d2;
            c c2 = this;
            this.e = -1;
            if (d4 < c2.b(1)) {
                d3 = d4;
                b3 = c2.d[1];
                c2.d[1].c = d3;
                c2.e = 1;
            } else if (d4 < c2.b(2)) {
                c2.e = 1;
            } else if (d4 < c2.b(3)) {
                c2.e = 2;
            } else if (d4 < c2.b(4)) {
                c2.e = 3;
            } else if (d4 <= c2.b(5)) {
                c2.e = 4;
            } else {
                d3 = d4;
                b3 = c2.d[5];
                c2.d[5].c = d3;
                c2.e = 4;
            }
            int n2 = c2.e;
            int n3 = 5;
            int n4 = n2 + 1;
            int n5 = 1;
            c c3 = this;
            for (n3 = n4; n3 <= 5; ++n3) {
                int n6 = 1;
                b2 = c3.d[n3];
                b2.a(n6);
            }
            c3 = this;
            for (n5 = 1; n5 < c3.d.length; ++n5) {
                b b4;
                b b5 = b4 = c3.d[n5];
                b4.b += b5.d;
            }
            c3 = this;
            for (n5 = 2; n5 <= 4; ++n5) {
                boolean bl;
                b b6;
                int n7 = n5;
                Object object = c3;
                if (n7 < 2 || n7 > 4) {
                    throw new po_0(n7, (Number)2, 4);
                }
                b2 = b6 = ((c)object).d[n7];
                Object object2 = b6;
                double d5 = b6.b - ((b)object2).a;
                int n8 = b2.e.a - b2.a > 1.0 ? 1 : 0;
                boolean bl2 = bl = b2.f.a - b2.a < -1.0;
                if (d5 >= 1.0 && n8 != 0 || d5 <= -1.0 && bl) {
                    n8 = d5 >= 0.0 ? 1 : -1;
                    double[] dArray = new double[]{b2.f.a, b2.a, b2.e.a};
                    object = new double[]{b2.f.c, b2.c, b2.e.c};
                    double d6 = b2.a + (double)n8;
                    object2 = b2.g.b(dArray, (double[])object);
                    b2.c = object2.a(d6);
                    double d7 = b2.c;
                    if (d7 <= (object2 = object)[0] || d7 >= object2[2]) {
                        int n9 = d6 - dArray[1] > 0.0 ? 1 : -1;
                        dArray = new double[]{dArray[1], dArray[n9 + 1]};
                        object = new double[]{(double)object[1], (double)object[n9 + 1]};
                        ch_0.a(dArray, (double[][])new double[][]{(double[])object});
                        object2 = b2.h.b(dArray, (double[])object);
                        b2.c = object2.a(d6);
                    }
                    b2.a(n8);
                }
                double cfr_ignored_0 = b2.c;
            }
            c3 = this;
            return c3.b(3);
        }

        @Override
        public final double a() {
            return this.b(3);
        }

        private int b(double d2) {
            this.e = -1;
            if (d2 < this.b(1)) {
                double d3 = d2;
                b b2 = this.d[1];
                this.d[1].c = d3;
                this.e = 1;
            } else if (d2 < this.b(2)) {
                this.e = 1;
            } else if (d2 < this.b(3)) {
                this.e = 2;
            } else if (d2 < this.b(4)) {
                this.e = 3;
            } else if (d2 <= this.b(5)) {
                this.e = 4;
            } else {
                double d4 = d2;
                b b3 = this.d[5];
                this.d[5].c = d4;
                this.e = 4;
            }
            return this.e;
        }

        private void b() {
            for (int i2 = 2; i2 <= 4; ++i2) {
                this.a(i2);
            }
        }

        @Override
        public final double a(int n2) {
            if (n2 < 2 || n2 > 4) {
                throw new po_0(n2, (Number)2, 4);
            }
            return org.valkyrienskies.core.impl.shadow.AS$b.a(this.d[n2]);
        }

        private void a(int n2, int n3, int n4) {
            for (n2 = n3; n2 <= 5; ++n2) {
                n4 = 1;
                b b2 = this.d[n2];
                b2.a(n4);
            }
        }

        private void c() {
            for (int i2 = 1; i2 < this.d.length; ++i2) {
                org.valkyrienskies.core.impl.shadow.AS$b.b(this.d[i2]);
            }
        }

        private void a(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            for (int i2 = 1; i2 < 5; ++i2) {
                org.valkyrienskies.core.impl.shadow.AS$b.a(org.valkyrienskies.core.impl.shadow.AS$b.b(org.valkyrienskies.core.impl.shadow.AS$b.a(this.d[i2], this.d[i2 - 1]), this.d[i2 + 1]), i2);
            }
            org.valkyrienskies.core.impl.shadow.AS$b.a(org.valkyrienskies.core.impl.shadow.AS$b.b(org.valkyrienskies.core.impl.shadow.AS$b.a(this.d[0], this.d[0]), this.d[1]), 0);
            org.valkyrienskies.core.impl.shadow.AS$b.a(org.valkyrienskies.core.impl.shadow.AS$b.b(org.valkyrienskies.core.impl.shadow.AS$b.a(this.d[5], this.d[4]), this.d[5]), 5);
        }

        @Override
        public final double b(int n2) {
            if (n2 >= this.d.length || n2 <= 0) {
                throw new po_0(n2, (Number)1, this.d.length);
            }
            b b2 = this.d[n2];
            return b2.c;
        }

        @Override
        public final Object clone() {
            return new c(new b[]{new b(0), (b)this.d[1].clone(), (b)this.d[2].clone(), (b)this.d[3].clone(), (b)this.d[4].clone(), (b)this.d[5].clone()});
        }

        public final String toString() {
            return String.format("m1=[%s],m2=[%s],m3=[%s],m4=[%s],m5=[%s]", this.d[1].toString(), this.d[2].toString(), this.d[3].toString(), this.d[4].toString(), this.d[5].toString());
        }

        /* synthetic */ c(List list, double d2, byte by) {
            this(list, d2);
        }
    }
}

