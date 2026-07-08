/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.co_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class wR
extends co_0<double[], double[]>
implements Serializable {
    private static final long c = 20120513L;

    public wR(double[] dArray, double[] dArray2) {
        this(dArray, dArray2, true);
    }

    public wR(double[] dArray, double[] dArray2, boolean bl) {
        super(bl ? (Object)(dArray == null ? null : (double[])dArray.clone()) : dArray, bl ? (Object)(dArray2 == null ? null : (double[])dArray2.clone()) : dArray2);
    }

    private double[] d() {
        double[] dArray = (double[])this.e();
        if (dArray == null) {
            return null;
        }
        return (double[])dArray.clone();
    }

    public final double[] a() {
        return (double[])this.e();
    }

    private double[] h() {
        double[] dArray = (double[])super.c();
        if (dArray == null) {
            return null;
        }
        return (double[])dArray.clone();
    }

    public final double[] b() {
        return (double[])super.c();
    }

    private a i() {
        return new a((double[])this.e(), this.h());
    }

    @Override
    public final /* synthetic */ Object c() {
        return this.h();
    }

    static final class a
    implements Serializable {
        private static final long a = 20120513L;
        private final double[] b;
        private final double[] c;

        a(double[] dArray, double[] dArray2) {
            this.b = (double[])dArray.clone();
            this.c = (double[])dArray2.clone();
        }

        private wR a() {
            return new wR(this.b, this.c, false);
        }
    }
}

