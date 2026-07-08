/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BB;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.bw_0;
import org.valkyrienskies.core.impl.shadow.bz_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oK;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class BA
implements Serializable,
BB {
    private static final long a = -3004689053607543335L;
    private double b = 0.0;
    private double c = 0.0;
    private double d = 0.0;
    private double e = 0.0;
    private double f = 0.0;
    private long g = 0L;
    private double h = 0.0;
    private double i = 0.0;
    private final boolean j;

    public BA() {
        this(true);
    }

    private BA(boolean bl) {
        this.j = true;
    }

    public final void a(double d2, double d3) {
        if (this.g == 0L) {
            this.h = d2;
            this.i = d3;
        } else if (this.j) {
            double d4 = 1.0 + (double)this.g;
            double d5 = (double)this.g / (1.0 + (double)this.g);
            double d6 = d2 - this.h;
            double d7 = d3 - this.i;
            double d8 = d6;
            this.c += d8 * d8 * d5;
            double d9 = d7;
            this.e += d9 * d9 * d5;
            this.f += d6 * d7 * d5;
            this.h += d6 / d4;
            this.i += d7 / d4;
        }
        if (!this.j) {
            double d10 = d2;
            this.c += d10 * d10;
            double d11 = d3;
            this.e += d11 * d11;
            this.f += d2 * d3;
        }
        this.b += d2;
        this.d += d3;
        ++this.g;
    }

    private void a(BA bA) {
        if (this.g == 0L) {
            this.h = bA.h;
            this.i = bA.i;
            this.c = bA.c;
            this.e = bA.e;
            this.f = bA.f;
        } else if (this.j) {
            double d2 = (double)bA.g / (double)(bA.g + this.g);
            double d3 = (double)(this.g * bA.g) / (double)(bA.g + this.g);
            double d4 = bA.h - this.h;
            double d5 = bA.i - this.i;
            double d6 = d4;
            this.c += bA.c + d6 * d6 * d3;
            double d7 = d5;
            this.e += bA.e + d7 * d7 * d3;
            this.f += bA.f + d4 * d5 * d3;
            this.h += d4 * d2;
            this.i += d5 * d2;
        } else {
            this.c += bA.c;
            this.e += bA.e;
            this.f += bA.f;
        }
        this.b += bA.b;
        this.d += bA.d;
        this.g += bA.g;
    }

    private void b(double d2, double d3) {
        if (this.g > 0L) {
            if (this.j) {
                double d4 = (double)this.g - 1.0;
                double d5 = (double)this.g / ((double)this.g - 1.0);
                double d6 = d2 - this.h;
                double d7 = d3 - this.i;
                double d8 = d6;
                this.c -= d8 * d8 * d5;
                double d9 = d7;
                this.e -= d9 * d9 * d5;
                this.f -= d6 * d7 * d5;
                this.h -= d6 / d4;
                this.i -= d7 / d4;
            } else {
                double d10 = (double)this.g - 1.0;
                double d11 = d2;
                this.c -= d11 * d11;
                double d12 = d3;
                this.e -= d12 * d12;
                this.f -= d2 * d3;
                this.h -= d2 / d10;
                this.i -= d3 / d10;
            }
            this.b -= d2;
            this.d -= d3;
            --this.g;
        }
    }

    private void a(double[][] dArray) {
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (dArray[i2].length < 2) {
                throw new bw_0(px_0.INVALID_REGRESSION_OBSERVATION, dArray[i2].length, 2);
            }
            this.a(dArray[i2][0], dArray[i2][1]);
        }
    }

    public final void a(double[] dArray, double d2) {
        if (dArray == null || dArray.length == 0) {
            throw new bw_0(px_0.INVALID_REGRESSION_OBSERVATION, dArray != null ? dArray.length : 0, 1);
        }
        this.a(dArray[0], d2);
    }

    public final void a(double[][] dArray, double[] dArray2) {
        int n2;
        if (dArray == null || dArray2 == null || dArray.length != dArray2.length) {
            throw new bw_0(px_0.DIMENSIONS_MISMATCH_SIMPLE, dArray == null ? 0 : dArray.length, dArray2 == null ? 0 : dArray2.length);
        }
        boolean bl = true;
        for (n2 = 0; n2 < dArray.length; ++n2) {
            if (dArray[n2] != null && dArray[n2].length != 0) continue;
            bl = false;
        }
        if (!bl) {
            throw new bw_0(px_0.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, 0, 1);
        }
        for (n2 = 0; n2 < dArray.length; ++n2) {
            this.a(dArray[n2][0], dArray2[n2]);
        }
    }

    private void b(double[][] dArray) {
        for (int i2 = 0; i2 < dArray.length && this.g > 0L; ++i2) {
            double d2;
            double d3 = dArray[i2][1];
            double d4 = dArray[i2][0];
            BA bA = this;
            if (bA.g <= 0L) continue;
            if (bA.j) {
                d2 = (double)bA.g - 1.0;
                double d5 = (double)bA.g / ((double)bA.g - 1.0);
                double d6 = d4 - bA.h;
                double d7 = d3 - bA.i;
                double d8 = d6;
                bA.c -= d8 * d8 * d5;
                double d9 = d7;
                bA.e -= d9 * d9 * d5;
                bA.f -= d6 * d7 * d5;
                bA.h -= d6 / d2;
                bA.i -= d7 / d2;
            } else {
                d2 = (double)bA.g - 1.0;
                double d10 = d4;
                bA.c -= d10 * d10;
                double d11 = d3;
                bA.e -= d11 * d11;
                bA.f -= d4 * d3;
                bA.h -= d4 / d2;
                bA.i -= d3 / d2;
            }
            bA.b -= d4;
            bA.d -= d3;
            --bA.g;
        }
    }

    public final void c() {
        this.b = 0.0;
        this.c = 0.0;
        this.d = 0.0;
        this.e = 0.0;
        this.f = 0.0;
        this.g = 0L;
    }

    public final long b() {
        return this.g;
    }

    private double a(double d2) {
        double d3 = this.g();
        if (this.j) {
            return this.c(d3) + d3 * d2;
        }
        return d3 * d2;
    }

    private double f() {
        if (this.j) {
            BA bA = this;
            return bA.c(bA.g());
        }
        return 0.0;
    }

    public final boolean a() {
        return this.j;
    }

    private double g() {
        if (this.g < 2L) {
            return Double.NaN;
        }
        if (BY.w(this.c) < 4.9E-323) {
            return Double.NaN;
        }
        return this.f / this.c;
    }

    private double h() {
        return BY.e(0.0, this.e - this.f * this.f / this.c);
    }

    private double i() {
        if (this.g < 2L) {
            return Double.NaN;
        }
        return this.e;
    }

    private double j() {
        if (this.g < 2L) {
            return Double.NaN;
        }
        return this.c;
    }

    private double k() {
        return this.f;
    }

    private double l() {
        BA bA = this;
        double d2 = bA.g();
        BA bA2 = bA;
        double d3 = d2;
        return d3 * d3 * bA2.c;
    }

    private double m() {
        if (this.g < 3L) {
            return Double.NaN;
        }
        if (this.j) {
            return this.h() / (double)(this.g - 2L);
        }
        return this.h() / (double)(this.g - 1L);
    }

    public final double e() {
        double d2 = this.g();
        double d3 = BY.a(this.n());
        if (d2 < 0.0) {
            d3 = -d3;
        }
        return d3;
    }

    private double n() {
        double d2 = this.i();
        return (d2 - this.h()) / d2;
    }

    private double o() {
        if (!this.j) {
            return Double.NaN;
        }
        return BY.a(this.m() * (1.0 / (double)this.g + this.h * this.h / this.c));
    }

    private double p() {
        return BY.a(this.m() / this.c);
    }

    private double q() {
        double d2 = 0.05;
        BA bA = this;
        if (bA.g < 3L) {
            return Double.NaN;
        }
        oK oK2 = new oK(bA.g - 2L);
        double cfr_ignored_0 = 0.05 / 2.0;
        return bA.p() * oK2.a(0.975);
    }

    private double b(double d2) {
        if (this.g < 3L) {
            return Double.NaN;
        }
        oK oK2 = new oK(this.g - 2L);
        double cfr_ignored_0 = 0.05 / 2.0;
        return this.p() * oK2.a(0.975);
    }

    private double r() {
        if (this.g < 3L) {
            return Double.NaN;
        }
        oK oK2 = new oK(this.g - 2L);
        return 2.0 * (1.0 - oK2.e(BY.w(this.g()) / this.p()));
    }

    private double c(double d2) {
        if (this.j) {
            return (this.d - d2 * this.b) / (double)this.g;
        }
        return 0.0;
    }

    private double d(double d2) {
        double d3 = d2;
        return d3 * d3 * this.c;
    }

    public final bz_0 d() {
        if (this.j) {
            if (this.g < 3L) {
                throw new pf_0(px_0.NOT_ENOUGH_DATA_REGRESSION);
            }
            if (BY.w(this.c) > cq_0.b) {
                double d2;
                double[] dArray = new double[2];
                Object object = this;
                if (((BA)object).j) {
                    BA bA = object;
                    d2 = bA.c(bA.g());
                } else {
                    d2 = 0.0;
                }
                dArray[0] = d2;
                dArray[1] = this.g();
                object = dArray;
                double d3 = this.m();
                double d4 = this.e + this.d * this.d / (double)this.g;
                double[] dArray2 = new double[]{d3 * (this.h * this.h / this.c + 1.0 / (double)this.g), -this.h * d3 / this.c, d3 / this.c};
                return new bz_0((double[])object, new double[][]{dArray2}, true, this.g, 2, this.d, d4, this.h(), true, false);
            }
            double[] dArray = new double[]{this.d / (double)this.g, Double.NaN};
            double[] dArray3 = new double[]{this.i / ((double)this.g - 1.0), Double.NaN, Double.NaN};
            return new bz_0(dArray, new double[][]{dArray3}, true, this.g, 1, this.d, this.e, this.h(), true, false);
        }
        if (this.g < 2L) {
            throw new pf_0(px_0.NOT_ENOUGH_DATA_REGRESSION);
        }
        if (!Double.isNaN(this.c)) {
            double[] dArray = new double[]{this.m() / this.c};
            double[] dArray4 = new double[]{this.f / this.c};
            return new bz_0(dArray4, new double[][]{dArray}, true, this.g, 1, this.d, this.e, this.h(), false, false);
        }
        double[] dArray = new double[]{Double.NaN};
        double[] dArray5 = new double[]{Double.NaN};
        return new bz_0(dArray5, new double[][]{dArray}, true, this.g, 1, Double.NaN, Double.NaN, Double.NaN, false, false);
    }

    public final bz_0 a(int[] objectArray) {
        if (objectArray == null || objectArray.length == 0) {
            throw new oV(px_0.ARRAY_ZERO_LENGTH_OR_NULL_NOT_ALLOWED, new Object[0]);
        }
        if (objectArray.length > 2 || objectArray.length > 1 && !this.j) {
            throw new bw_0(px_0.ARRAY_SIZE_EXCEEDS_MAX_VARIABLES, objectArray.length > 1 && !this.j ? 1 : 2);
        }
        if (this.j) {
            if (objectArray.length == 2) {
                if (objectArray[0] == 1) {
                    throw new bw_0(px_0.NOT_INCREASING_SEQUENCE, new Object[0]);
                }
                if (objectArray[0] != 0) {
                    throw new po_0(objectArray[0], (Number)0, 1);
                }
                if (objectArray[1] != 1) {
                    throw new po_0(objectArray[0], (Number)0, 1);
                }
                return this.d();
            }
            if (objectArray[0] != 1 && objectArray[0] != 0) {
                throw new po_0(objectArray[0], (Number)0, 1);
            }
            double d2 = this.d * this.d / (double)this.g;
            double d3 = this.e + d2;
            if (objectArray[0] == 0) {
                double[] dArray = new double[]{this.e / (double)((this.g - 1L) * this.g)};
                double[] dArray2 = new double[]{this.i};
                return new bz_0(dArray2, new double[][]{dArray}, true, this.g, 1, this.d, d3 + d2, this.e, true, false);
            }
            if (objectArray[0] == 1) {
                double d4;
                double d5 = this.c + this.b * this.b / (double)this.g;
                double d6 = d4 = this.f + this.b * this.d / (double)this.g;
                double d7 = BY.e(0.0, d3 - d6 * d6 / d5);
                double d8 = d7 / (double)(this.g - 1L);
                if (!Double.isNaN(d5)) {
                    objectArray = new double[]{d8 / d5};
                    double[] dArray = new double[]{d4 / d5};
                    return new bz_0(dArray, new double[][]{objectArray}, true, this.g, 1, this.d, d3, d7, false, false);
                }
                objectArray = new double[]{Double.NaN};
                double[] dArray = new double[]{Double.NaN};
                return new bz_0(dArray, new double[][]{objectArray}, true, this.g, 1, Double.NaN, Double.NaN, Double.NaN, false, false);
            }
        } else {
            if (objectArray[0] != 0) {
                throw new po_0(objectArray[0], (Number)0, 0);
            }
            return this.d();
        }
        return null;
    }
}

