/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zg_0;
import org.valkyrienskies.core.impl.shadow.zm_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.zk
 */
@Deprecated
public final class zk_0<FUNC extends lc_0>
implements zg_0<FUNC> {
    private final zg_0<FUNC> a;
    private int b;
    private int c;
    private int d;
    private zF e;
    private zm_0[] f;

    private zk_0(zg_0<FUNC> zg_02, int n2, zF zF2) {
        if (zg_02 == null || zF2 == null) {
            throw new pl_0();
        }
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.a = zg_02;
        this.d = n2;
        this.e = zF2;
    }

    @Override
    public final ya_0<zm_0> c() {
        return this.a.c();
    }

    @Override
    public final int a() {
        return this.b;
    }

    @Override
    public final int b() {
        return this.c;
    }

    private zm_0[] d() {
        if (this.f == null) {
            throw new oX(px_0.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
        }
        return (zm_0[])this.f.clone();
    }

    @Override
    public final zm_0 a(int n2, FUNC FUNC, yf_0 yf_02, double d2, double d3) {
        return this.a(n2, FUNC, yf_02, d2, d3, d2 + 0.5 * (d3 - d2));
    }

    @Override
    public final zm_0 a(int n2, FUNC object, yf_0 yf_02, double d2, double d3, double d4) {
        RuntimeException runtimeException = null;
        this.f = new zm_0[this.d];
        this.c = 0;
        for (int i2 = 0; i2 < this.d; ++i2) {
            try {
                double d5 = i2 == 0 ? d4 : d2 + this.e.nextDouble() * (d3 - d2);
                this.f[i2] = this.a.a(n2 - this.c, object, yf_02, d2, d3, d5);
            }
            catch (RuntimeException runtimeException2) {
                RuntimeException runtimeException3 = runtimeException2;
                runtimeException = runtimeException2;
                this.f[i2] = null;
            }
            this.c += this.a.b();
        }
        object = yf_02;
        zk_0 zk_02 = this;
        Arrays.sort(zk_02.f, new Comparator<zm_0>(zk_02, object){
            private /* synthetic */ yf_0 a;
            private /* synthetic */ zk_0 b;
            {
                this.b = zk_02;
                this.a = yf_02;
            }

            private int a(zm_0 zm_02, zm_0 zm_03) {
                if (zm_02 == null) {
                    if (zm_03 == null) {
                        return 0;
                    }
                    return 1;
                }
                if (zm_03 == null) {
                    return -1;
                }
                double d2 = zm_02.b;
                zm_02 = zm_03;
                double d3 = zm_02.b;
                if (this.a == yf_0.MINIMIZE) {
                    return Double.compare(d2, d3);
                }
                return Double.compare(d3, d2);
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

