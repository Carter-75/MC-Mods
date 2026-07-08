/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.yp
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.yp;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.yp
 */
@Deprecated
public final class yp_0
extends co_0<double[], Double>
implements Serializable {
    private static final long c = 20120513L;

    public yp_0(double[] dArray, double d2) {
        this(dArray, d2, true);
    }

    public yp_0(double[] dArray, double d2, boolean bl) {
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

        private yp_0 a() {
            return new yp(this.b, this.c, false);
        }
    }
}

