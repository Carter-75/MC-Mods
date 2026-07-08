/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.ue
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.ue;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ue
 */
public final class ue_0
implements Serializable {
    private static final long b = 20130207L;
    public final long a;
    private final int c;
    private final AtomicReference<double[]> d;
    private final AtomicLong e = new AtomicLong(0L);
    private final AtomicLong f = new AtomicLong(0L);

    ue_0(long l2, double[] dArray) {
        this.a = l2;
        this.c = dArray.length;
        this.d = new AtomicReference<Object>(dArray.clone());
    }

    public final synchronized ue_0 a() {
        ue_0 ue_02 = this;
        ue_02 = new ue_0(ue_02.a, this.c());
        ue_02.e.set(this.e.get());
        ue_02.f.set(this.f.get());
        return ue_02;
    }

    public final long b() {
        return this.a;
    }

    private int d() {
        return this.c;
    }

    public final double[] c() {
        return (double[])this.d.get().clone();
    }

    public final boolean a(double[] object, double[] dArray) {
        boolean bl;
        double[] dArray2;
        block5: {
            if (dArray.length != this.c) {
                throw new oS(dArray.length, this.c);
            }
            dArray2 = this.d.get();
            double[] dArray3 = object;
            double[] dArray4 = dArray2;
            object = this;
            if (dArray3.length != object.c) {
                throw new oS(dArray3.length, object.c);
            }
            for (int i2 = 0; i2 < object.c; ++i2) {
                if (cq_0.a(dArray4[i2], dArray3[i2])) continue;
                bl = false;
                break block5;
            }
            bl = true;
        }
        if (!bl) {
            return false;
        }
        this.e.incrementAndGet();
        if (this.d.compareAndSet(dArray2, (double[])dArray.clone())) {
            this.f.incrementAndGet();
            return true;
        }
        return false;
    }

    private long e() {
        return this.e.get();
    }

    private long f() {
        return this.f.get();
    }

    private boolean b(double[] dArray, double[] dArray2) {
        if (dArray2.length != this.c) {
            throw new oS(dArray2.length, this.c);
        }
        for (int i2 = 0; i2 < this.c; ++i2) {
            if (cq_0.a(dArray[i2], dArray2[i2])) continue;
            return false;
        }
        return true;
    }

    private static void g() {
        throw new IllegalStateException();
    }

    private a h() {
        return new a(this.a, this.d.get());
    }

    static final class a
    implements Serializable {
        private static final long a = 20130207L;
        private final double[] b;
        private final long c;

        a(long l2, double[] dArray) {
            this.c = l2;
            this.b = dArray;
        }

        private ue_0 a() {
            return new ue(this.c, this.b);
        }
    }
}

