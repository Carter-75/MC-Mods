/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.zf_0;
import org.valkyrienskies.core.impl.shadow.zj_0;
import org.valkyrienskies.core.impl.shadow.zm_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.zi
 */
@Deprecated
public class zi_0
extends zf_0 {
    private static final double a = 0.5 * (3.0 - BY.a(5.0));
    private static final double b = 2.0 * BY.x(1.0);
    private final double c;
    private final double d;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zi_0(double d2, double d3, zj_0 zj_02) {
        super(zj_02);
        if (d2 < b) {
            throw new pn_0(d2, (Number)b, true);
        }
        if (d3 <= 0.0) {
            throw new pk_0(d3);
        }
        this.c = d2;
        this.d = d3;
    }

    private zi_0(double d2, double d3) {
        this(d2, d3, null);
    }

    @Override
    protected final zm_0 h() {
        zm_0 zm_02;
        double d2;
        double d3;
        double d4;
        boolean bl = this.d() == yf_0.MINIMIZE;
        double d5 = this.e();
        double d6 = this.g();
        double d7 = this.f();
        ya_0<zm_0> ya_02 = this.c();
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
        zm_0 zm_03 = null;
        zm_0 zm_04 = zm_02 = new zm_0(d2, bl ? d12 : -d12);
        int n2 = 0;
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
                zm_03 = zm_02;
                zm_02 = new zm_0(d18, bl ? d23 : -d23);
                zm_04 = zi_0.a(zm_04, zi_0.a(zm_03, zm_02, bl), bl);
                if (ya_02 != null && ya_02.a(n2, zm_03, zm_02)) {
                    return zm_04;
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
                return zi_0.a(zm_04, zi_0.a(zm_03, zm_02, bl), bl);
            }
            ++n2;
        }
    }

    private static zm_0 a(zm_0 zm_02, zm_0 zm_03, boolean bl) {
        zm_0 zm_04;
        zm_0 zm_05;
        if (zm_02 == null) {
            return zm_03;
        }
        if (zm_03 == null) {
            return zm_02;
        }
        if (bl) {
            zm_0 zm_06;
            zm_0 zm_07;
            zm_0 zm_08 = zm_02;
            zm_08 = zm_03;
            if (zm_07.b <= zm_06.b) {
                return zm_02;
            }
            return zm_03;
        }
        zm_0 zm_09 = zm_02;
        zm_09 = zm_03;
        if (zm_05.b >= zm_04.b) {
            return zm_02;
        }
        return zm_03;
    }
}

