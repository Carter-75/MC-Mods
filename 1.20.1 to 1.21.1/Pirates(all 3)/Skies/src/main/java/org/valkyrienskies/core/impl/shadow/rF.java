/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oT;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rI;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rZ;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;
import org.valkyrienskies.core.impl.shadow.rz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class rF
implements Serializable,
rI<rv_0, rB> {
    private static final long a = 20140129L;
    private final rB[] b;
    private final double c;
    private transient rz_0[] d;

    public rF(rB[] rBArray, double d2) {
        boolean bl;
        block4: {
            this.c = d2;
            rB[] rBArray2 = rBArray;
            rF rF2 = this;
            if (rBArray2.length >= 3) {
                int n2 = 0;
                for (int i2 = 0; i2 < rBArray2.length; ++i2) {
                    rB rB2 = rBArray2[i2 == 0 ? rBArray2.length - 1 : i2 - 1];
                    rB rB3 = rBArray2[i2];
                    rB rB4 = rBArray2[i2 == rBArray2.length - 1 ? 0 : i2 + 1];
                    rB2 = rB3.g(rB2);
                    rB3 = rB4.g(rB3);
                    rB rB5 = rB2;
                    rB4 = rB5;
                    rB rB6 = rB3;
                    rB4 = rB6;
                    rB rB7 = rB2;
                    rB4 = rB7;
                    rB4 = rB3;
                    double d3 = ch_0.a(rB5.c, rB6.d, -rB7.d, rB4.c);
                    int n3 = cq_0.a(d3, 0.0, rF2.c);
                    if ((double)n3 == 0.0) continue;
                    if ((double)n2 != 0.0 && n3 != n2) {
                        bl = false;
                        break block4;
                    }
                    n2 = n3;
                }
            }
            bl = true;
        }
        if (!bl) {
            throw new oV(px_0.NOT_CONVEX, new Object[0]);
        }
        this.b = (rB[])rBArray.clone();
    }

    private boolean a(rB[] rBArray) {
        if (rBArray.length < 3) {
            return true;
        }
        int n2 = 0;
        for (int i2 = 0; i2 < rBArray.length; ++i2) {
            rB rB2 = rBArray[i2 == 0 ? rBArray.length - 1 : i2 - 1];
            rB rB3 = rBArray[i2];
            rB rB4 = rBArray[i2 == rBArray.length - 1 ? 0 : i2 + 1];
            rB2 = rB3.g(rB2);
            rB3 = rB4.g(rB3);
            rB rB5 = rB2;
            rB4 = rB5;
            rB rB6 = rB3;
            rB4 = rB6;
            rB rB7 = rB2;
            rB4 = rB7;
            rB4 = rB3;
            double d2 = ch_0.a(rB5.c, rB6.d, -rB7.d, rB4.c);
            int n3 = cq_0.a(d2, 0.0, this.c);
            if ((double)n3 == 0.0) continue;
            if ((double)n2 != 0.0 && n3 != n2) {
                return false;
            }
            n2 = n3;
        }
        return true;
    }

    private rB[] c() {
        return (rB[])this.b.clone();
    }

    private rz_0[] d() {
        return (rz_0[])this.e().clone();
    }

    private rz_0[] e() {
        if (this.d == null) {
            int n2 = this.b.length;
            if (n2 <= 1) {
                this.d = new rz_0[0];
            } else if (n2 == 2) {
                this.d = new rz_0[1];
                rB rB2 = this.b[0];
                rB rB3 = this.b[1];
                this.d[0] = new rz_0(rB2, rB3, new rw_0(rB2, rB3, this.c));
            } else {
                this.d = new rz_0[n2];
                rB rB4 = null;
                rB rB5 = null;
                int n3 = 0;
                rB[] rBArray = this.b;
                int n4 = this.b.length;
                for (int i2 = 0; i2 < n4; ++i2) {
                    rB rB6 = rBArray[i2];
                    if (rB5 == null) {
                        rB4 = rB6;
                        rB5 = rB6;
                        continue;
                    }
                    this.d[n3++] = new rz_0(rB5, rB6, new rw_0(rB5, rB6, this.c));
                    rB5 = rB6;
                }
                this.d[n3] = new rz_0(rB5, rB4, new rw_0(rB5, rB4, this.c));
            }
        }
        return this.d;
    }

    @Override
    public final rY<rv_0> a() {
        if (this.b.length < 3) {
            throw new oT();
        }
        rZ rZ2 = new rZ();
        rz_0[] rz_0Array = this.e();
        rw_0[] rw_0Array = new rw_0[rz_0Array.length];
        for (int i2 = 0; i2 < rz_0Array.length; ++i2) {
            rz_0 rz_02 = rz_0Array[i2];
            rw_0Array[i2] = rz_02.i;
        }
        return rZ2.a(rw_0Array);
    }

    public final /* synthetic */ rB[] b() {
        rF rF2 = this;
        return (rB[])rF2.b.clone();
    }
}

