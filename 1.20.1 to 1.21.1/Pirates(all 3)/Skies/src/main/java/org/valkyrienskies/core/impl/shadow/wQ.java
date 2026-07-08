/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.co_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class wQ
extends co_0<double[], Double>
implements Serializable {
    private static final long c = 20120513L;

    public wQ(double[] dArray, double d2) {
        this(dArray, d2, true);
    }

    public wQ(double[] dArray, double d2, boolean bl) {
        super(bl ? (Object)(dArray == null ? null : (double[])dArray.clone()) : dArray, d2);
    }

    public final double[] a() {
        double[] dArray = (double[])this.e();
        if (dArray == null) {
            return null;
        }
        return (double[])dArray.clone();
    }

    public final double[] b() {
        return (double[])this.e();
    }

    private a d() {
        return new a((double[])this.e(), (Double)this.c());
    }

    static final class a
    implements Serializable {
        private static final long a = 20120513L;
        private final double[] b;
        private final double c;

        a(double[] dArray, double d2) {
            this.b = (double[])dArray.clone();
            this.c = d2;
        }

        private wQ a() {
            return new wQ(this.b, this.c, false);
        }
    }
}

