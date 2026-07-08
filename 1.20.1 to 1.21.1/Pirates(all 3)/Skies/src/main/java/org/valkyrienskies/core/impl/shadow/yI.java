/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yn_0;
import org.valkyrienskies.core.impl.shadow.yo_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.yt_0;
import org.valkyrienskies.core.impl.shadow.yx_0;
import org.valkyrienskies.core.impl.shadow.yz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yI
extends yz_0<kW>
implements yn_0 {
    private yx_0 b;

    @Deprecated
    public yI() {
        this(new yt_0());
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private yI(yt_0 yt_02) {
        super(yt_02);
    }

    private yI(double d2, double d3) {
        this(new yt_0(d2, d3));
    }

    @Deprecated
    private void a(yx_0 yx_02) {
        this.a(new yo_0[]{yx_02});
    }

    @Override
    protected final yp_0 a(int n2, kW kW2, yf_0 yf_02, yo_0 ... yo_0Array) {
        this.a(yo_0Array);
        return super.a(n2, kW2, yf_02, yo_0Array);
    }

    private void a(yo_0 ... yo_0Array) {
        for (yo_0 yo_02 : yo_0Array) {
            if (!(yo_02 instanceof yx_0)) continue;
            this.b = (yx_0)yo_02;
        }
    }

    @Override
    protected final yp_0 d() {
        if (this.b == null) {
            throw new pl_0();
        }
        kW kW2 = new kW(this){
            private /* synthetic */ yI a;
            {
                this.a = yI2;
            }

            public final double a(double[] dArray) {
                return this.a.a(dArray);
            }
        };
        boolean bl = this.e() == yf_0.MINIMIZE;
        Comparator<yp_0> comparator = new Comparator<yp_0>(this, bl){
            private /* synthetic */ boolean a;
            private /* synthetic */ yI b;
            {
                this.b = yI2;
                this.a = bl;
            }

            private int a(yp_0 yp_02, yp_0 yp_03) {
                double d2 = (Double)yp_02.c();
                double d3 = (Double)yp_03.c();
                if (this.a) {
                    return Double.compare(d2, d3);
                }
                return Double.compare(d3, d2);
            }

            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                yp_0 yp_02 = (yp_0)object2;
                object2 = (yp_0)object;
                object = this;
                double d2 = (Double)((co_0)object2).c();
                double d3 = (Double)yp_02.c();
                if (object.a) {
                    return Double.compare(d2, d3);
                }
                return Double.compare(d3, d2);
            }
        };
        double[] dArray = this.f();
        yp_0[] yp_0Array = this.b;
        if (this.b.c != dArray.length) {
            throw new oS(yp_0Array.c, dArray.length);
        }
        yp_0Array.a = new yp_0[yp_0Array.c + 1];
        yp_0Array.a[0] = new yp_0(dArray, Double.NaN);
        for (int i2 = 0; i2 < yp_0Array.c; ++i2) {
            double[] dArray2 = yp_0Array.b[i2];
            double[] dArray3 = new double[yp_0Array.c];
            for (int i3 = 0; i3 < yp_0Array.c; ++i3) {
                dArray3[i3] = dArray[i3] + dArray2[i3];
            }
            yp_0Array.a[i2 + 1] = new yp_0(dArray3, Double.NaN);
        }
        this.b.a(kW2, comparator);
        yp_0Array = null;
        int n2 = 0;
        ya_0<yp_0> ya_02 = this.c();
        while (true) {
            if (n2 > 0) {
                boolean bl2 = true;
                int n3 = 0;
                while (true) {
                    Object object = this.b;
                    if (n3 >= ((yx_0)object).a.length) break;
                    object = yp_0Array[n3];
                    bl2 = bl2 && ya_02.a(n2, (yp_0)object, this.b.a(n3));
                    ++n3;
                }
                if (bl2) {
                    return this.b.a(0);
                }
            }
            yp_0Array = this.b.c();
            this.b.a(kW2, comparator);
            ++n2;
        }
    }
}

