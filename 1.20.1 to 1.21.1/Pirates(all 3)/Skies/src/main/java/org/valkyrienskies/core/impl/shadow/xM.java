/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.xP;
import org.valkyrienskies.core.impl.shadow.xR;
import org.valkyrienskies.core.impl.shadow.xS;
import org.valkyrienskies.core.impl.shadow.xi_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class xM
extends xR {
    private static final double a = 0.5 * (3.0 - BY.a(5.0));
    private static final double b = 2.0 * BY.x(1.0);
    private final double c;
    private final double d;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public xM(double d2, double d3, xP xP2) {
        super(xP2);
        if (d2 < b) {
            throw new pn_0(d2, (Number)b, true);
        }
        if (d3 <= 0.0) {
            throw new pk_0(d3);
        }
        this.c = d2;
        this.d = d3;
    }

    private xM(double d2, double d3) {
        this(d2, d3, null);
    }

    private xS g() {
        xS xS2;
        double d2;
        double d3;
        double d4;
        boolean bl = this.b() == xi_0.MINIMIZE;
        double d5 = this.e();
        double d6 = this.d();
        double d7 = this.f();
        wK<xS> wK2 = this.j();
        if (d5 < d7) {
            d4 = d5;
            d3 = d7;
        } else {
            d4 = d7;
            d3 = d5;
        }
        double d8 = d2 = d6;
        double d9 = d2;
        double d10 = 0.0;
        double d11 = 0.0;
        double d12 = this.a(d2);
        if (!bl) {
            d12 = -d12;
        }
        double d13 = d12;
        double d14 = d12;
        xS xS3 = null;
        xS xS4 = xS2 = new xS(d2, bl ? d12 : -d12);
        while (true) {
            double d15 = 0.5 * (d4 + d3);
            double d16 = this.c * BY.w(d2) + this.d;
            double d17 = d16 * 2.0;
            boolean bl2 = BY.w(d2 - d15) <= d17 - 0.5 * (d3 - d4);
            if (!bl2) {
                double d18;
                if (BY.w(d11) > d16) {
                    double d19;
                    double d20 = (d2 - d9) * (d12 - d13);
                    double d21 = (d2 - d8) * (d12 - d14);
                    double d22 = (d2 - d8) * d21 - (d2 - d9) * d20;
                    d21 = 2.0 * (d21 - d20);
                    if (d19 > 0.0) {
                        d22 = -d22;
                    } else {
                        d21 = -d21;
                    }
                    d20 = d11;
                    d11 = d10;
                    if (d22 > d21 * (d4 - d2) && d22 < d21 * (d3 - d2) && BY.w(d22) < BY.w(d21 * 0.5 * d20)) {
                        d10 = d22 / d21;
                        d18 = d2 + d10;
                        if (d18 - d4 < d17 || d3 - d18 < d17) {
                            d10 = d2 <= d15 ? d16 : -d16;
                        }
                    } else {
                        d11 = d2 < d15 ? d3 - d2 : d4 - d2;
                        d10 = a * d11;
                    }
                } else {
                    d11 = d2 < d15 ? d3 - d2 : d4 - d2;
                    d10 = a * d11;
                }
                d18 = BY.w(d10) < d16 ? (d10 >= 0.0 ? d2 + d16 : d2 - d16) : d2 + d10;
                double d23 = this.a(d18);
                if (!bl) {
                    d23 = -d23;
                }
                xS3 = xS2;
                xS2 = new xS(d18, bl ? d23 : -d23);
                xS4 = xM.a(xS4, xM.a(xS3, xS2, bl), bl);
                if (wK2 != null && wK2.a(this.i(), xS3, xS2)) {
                    return xS4;
                }
                if (d23 <= d12) {
                    if (d18 < d2) {
                        d3 = d2;
                    } else {
                        d4 = d2;
                    }
                    d8 = d9;
                    d13 = d14;
                    d9 = d2;
                    d14 = d12;
                    d2 = d18;
                    d12 = d23;
                } else {
                    if (d18 < d2) {
                        d4 = d18;
                    } else {
                        d3 = d18;
                    }
                    if (d23 <= d14 || cq_0.a(d9, d2)) {
                        d8 = d9;
                        d13 = d14;
                        d9 = d18;
                        d14 = d23;
                    } else if (d23 <= d13 || cq_0.a(d8, d2) || cq_0.a(d8, d9)) {
                        d8 = d18;
                        d13 = d23;
                    }
                }
            } else {
                return xM.a(xS4, xM.a(xS3, xS2, bl), bl);
            }
            this.l();
        }
    }

    private static xS a(xS xS2, xS xS3, boolean bl) {
        xS xS4;
        xS xS5;
        if (xS2 == null) {
            return xS3;
        }
        if (xS3 == null) {
            return xS2;
        }
        if (bl) {
            xS xS6;
            xS xS7;
            xS xS8 = xS2;
            xS8 = xS3;
            if (xS7.b <= xS6.b) {
                return xS2;
            }
            return xS3;
        }
        xS xS9 = xS2;
        xS9 = xS3;
        if (xS5.b >= xS4.b) {
            return xS2;
        }
        return xS3;
    }

    @Override
    public final /* synthetic */ Object c() {
        xS xS2;
        double d2;
        double d3;
        double d4;
        xM xM2 = this;
        boolean bl = xM2.b() == xi_0.MINIMIZE;
        double d5 = xM2.e();
        double d6 = xM2.d();
        double d7 = xM2.f();
        wK<xS> wK2 = xM2.j();
        if (d5 < d7) {
            d4 = d5;
            d3 = d7;
        } else {
            d4 = d7;
            d3 = d5;
        }
        double d8 = d2 = d6;
        double d9 = d2;
        double d10 = 0.0;
        double d11 = 0.0;
        double d12 = xM2.a(d2);
        if (!bl) {
            d12 = -d12;
        }
        double d13 = d12;
        double d14 = d12;
        xS xS3 = null;
        xS xS4 = xS2 = new xS(d2, bl ? d12 : -d12);
        while (true) {
            double d15 = 0.5 * (d4 + d3);
            double d16 = xM2.c * BY.w(d2) + xM2.d;
            double d17 = d16 * 2.0;
            boolean bl2 = BY.w(d2 - d15) <= d17 - 0.5 * (d3 - d4);
            if (!bl2) {
                double d18;
                if (BY.w(d11) > d16) {
                    double d19;
                    double d20 = (d2 - d9) * (d12 - d13);
                    double d21 = (d2 - d8) * (d12 - d14);
                    double d22 = (d2 - d8) * d21 - (d2 - d9) * d20;
                    d21 = 2.0 * (d21 - d20);
                    if (d19 > 0.0) {
                        d22 = -d22;
                    } else {
                        d21 = -d21;
                    }
                    d20 = d11;
                    d11 = d10;
                    if (d22 > d21 * (d4 - d2) && d22 < d21 * (d3 - d2) && BY.w(d22) < BY.w(d21 * 0.5 * d20)) {
                        d10 = d22 / d21;
                        d18 = d2 + d10;
                        if (d18 - d4 < d17 || d3 - d18 < d17) {
                            d10 = d2 <= d15 ? d16 : -d16;
                        }
                    } else {
                        d11 = d2 < d15 ? d3 - d2 : d4 - d2;
                        d10 = a * d11;
                    }
                } else {
                    d11 = d2 < d15 ? d3 - d2 : d4 - d2;
                    d10 = a * d11;
                }
                d18 = BY.w(d10) < d16 ? (d10 >= 0.0 ? d2 + d16 : d2 - d16) : d2 + d10;
                double d23 = xM2.a(d18);
                if (!bl) {
                    d23 = -d23;
                }
                xS3 = xS2;
                xS2 = new xS(d18, bl ? d23 : -d23);
                xS4 = xM.a(xS4, xM.a(xS3, xS2, bl), bl);
                if (wK2 != null && wK2.a(xM2.i(), xS3, xS2)) {
                    return xS4;
                }
                if (d23 <= d12) {
                    if (d18 < d2) {
                        d3 = d2;
                    } else {
                        d4 = d2;
                    }
                    d8 = d9;
                    d13 = d14;
                    d9 = d2;
                    d14 = d12;
                    d2 = d18;
                    d12 = d23;
                } else {
                    if (d18 < d2) {
                        d4 = d18;
                    } else {
                        d3 = d18;
                    }
                    if (d23 <= d14 || cq_0.a(d9, d2)) {
                        d8 = d9;
                        d13 = d14;
                        d9 = d18;
                        d14 = d23;
                    } else if (d23 <= d13 || cq_0.a(d8, d2) || cq_0.a(d8, d9)) {
                        d8 = d18;
                        d13 = d23;
                    }
                }
            } else {
                return xM.a(xS4, xM.a(xS3, xS2, bl), bl);
            }
            xM2.l();
        }
    }
}

