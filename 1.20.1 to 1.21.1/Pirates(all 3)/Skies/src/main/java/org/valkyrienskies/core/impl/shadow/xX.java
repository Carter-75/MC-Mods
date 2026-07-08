/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.xY;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yq_0;
import org.valkyrienskies.core.impl.shadow.zH;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public class xX<FUNC extends kY>
implements xY<FUNC> {
    private final xY<FUNC> a;
    private int b;
    private int c;
    private int d;
    private zH e;
    private yq_0[] f;

    protected xX(xY<FUNC> xY2, int n2, zH zH2) {
        if (xY2 == null || zH2 == null) {
            throw new pl_0();
        }
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.a = xY2;
        this.d = n2;
        this.e = zH2;
    }

    private yq_0[] d() {
        if (this.f == null) {
            throw new oX(px_0.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
        }
        return (yq_0[])this.f.clone();
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
    public final ya_0<yq_0> c() {
        return this.a.c();
    }

    @Override
    public final yq_0 a(int n2, FUNC object, double[] dArray, double[] dArray2, double[] dArray3) {
        this.b = n2;
        RuntimeException runtimeException = null;
        this.f = new yq_0[this.d];
        this.c = 0;
        for (int i2 = 0; i2 < this.d; ++i2) {
            try {
                this.f[i2] = this.a.a(n2 - this.c, object, dArray, dArray2, i2 == 0 ? dArray3 : this.e.a());
            }
            catch (oR oR2) {
                this.f[i2] = null;
            }
            catch (RuntimeException runtimeException2) {
                runtimeException = runtimeException2;
                runtimeException = runtimeException2;
                this.f[i2] = null;
            }
            this.c += this.a.b();
        }
        double[] dArray4 = dArray;
        dArray = dArray2;
        object = dArray4;
        xX xX2 = this;
        Arrays.sort(xX2.f, new Comparator<yq_0>(xX2, object, dArray){
            private /* synthetic */ double[] a;
            private /* synthetic */ double[] b;
            private /* synthetic */ xX c;
            {
                this.c = xX2;
                this.a = dArray;
                this.b = dArray2;
            }

            private int a(yq_0 yq_02, yq_0 yq_03) {
                if (yq_02 == null) {
                    if (yq_03 == null) {
                        return 0;
                    }
                    return 1;
                }
                if (yq_03 == null) {
                    return -1;
                }
                return Double.compare(this.a(yq_02), this.a(yq_03));
            }

            private double a(yq_0 object) {
                object = ((yq_0)object).d();
                double d2 = 0.0;
                for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
                    reference var6_4 = object[i2] - this.a[i2];
                    d2 += this.b[i2] * var6_4 * var6_4;
                }
                return d2;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                yq_0 yq_02 = (yq_0)object2;
                object2 = (yq_0)object;
                object = this;
                if (object2 == null) {
                    if (yq_02 != null) return 1;
                    return 0;
                }
                if (yq_02 == null) {
                    return -1;
                }
                int n2 = Double.compare(super.a((yq_0)object2), super.a(yq_02));
                return n2;
            }
        });
        if (this.f[0] == null) {
            throw runtimeException;
        }
        return this.f[0];
    }

    private void a(double[] dArray, double[] dArray2) {
        Arrays.sort(this.f, new /* invalid duplicate definition of identical inner class */);
    }
}

