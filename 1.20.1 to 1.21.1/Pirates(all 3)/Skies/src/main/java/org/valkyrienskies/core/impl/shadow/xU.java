/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.xV;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.zH;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public class xU<FUNC extends kW>
implements xV<FUNC> {
    private final xV<FUNC> a;
    private int b;
    private int c;
    private int d;
    private zH e;
    private yp_0[] f;

    protected xU(xV<FUNC> xV2, int n2, zH zH2) {
        if (xV2 == null || zH2 == null) {
            throw new pl_0();
        }
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.a = xV2;
        this.d = n2;
        this.e = zH2;
    }

    private yp_0[] d() {
        if (this.f == null) {
            throw new oX(px_0.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
        }
        return (yp_0[])this.f.clone();
    }

    @Override
    public final int a() {
        return this.b;
    }

    @Override
    public final int b() {
        return this.c;
    }

    @Override
    public final ya_0<yp_0> c() {
        return this.a.c();
    }

    @Override
    public final yp_0 a(int n2, FUNC object, yf_0 yf_02, double[] dArray) {
        this.b = n2;
        RuntimeException runtimeException = null;
        this.f = new yp_0[this.d];
        this.c = 0;
        for (int i2 = 0; i2 < this.d; ++i2) {
            try {
                this.f[i2] = this.a.a(n2 - this.c, object, yf_02, i2 == 0 ? dArray : this.e.a());
            }
            catch (RuntimeException runtimeException2) {
                runtimeException = runtimeException2;
                runtimeException = runtimeException2;
                this.f[i2] = null;
            }
            this.c += this.a.b();
        }
        object = yf_02;
        xU xU2 = this;
        Arrays.sort(xU2.f, new Comparator<yp_0>(xU2, object){
            private /* synthetic */ yf_0 a;
            private /* synthetic */ xU b;
            {
                this.b = xU2;
                this.a = yf_02;
            }

            private int a(yp_0 yp_02, yp_0 yp_03) {
                if (yp_02 == null) {
                    if (yp_03 == null) {
                        return 0;
                    }
                    return 1;
                }
                if (yp_03 == null) {
                    return -1;
                }
                double d2 = (Double)yp_02.c();
                double d3 = (Double)yp_03.c();
                if (this.a == yf_0.MINIMIZE) {
                    return Double.compare(d2, d3);
                }
                return Double.compare(d3, d2);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                yp_0 yp_02 = (yp_0)object2;
                object2 = (yp_0)object;
                object = this;
                if (object2 == null) {
                    if (yp_02 != null) return 1;
                    return 0;
                }
                if (yp_02 == null) {
                    return -1;
                }
                double d2 = (Double)((co_0)object2).c();
                double d3 = (Double)yp_02.c();
                if (object.a == yf_0.MINIMIZE) {
                    return Double.compare(d2, d3);
                }
                int n2 = Double.compare(d3, d2);
                return n2;
            }
        });
        if (this.f[0] == null) {
            throw runtimeException;
        }
        return this.f[0];
    }

    private void a(yf_0 yf_02) {
        Arrays.sort(this.f, new /* invalid duplicate definition of identical inner class */);
    }
}

