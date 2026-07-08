/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.rh
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rO;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rZ;
import org.valkyrienskies.core.impl.shadow.rc_0;
import org.valkyrienskies.core.impl.shadow.rh;
import org.valkyrienskies.core.impl.shadow.ri_0;
import org.valkyrienskies.core.impl.shadow.rj_0;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;
import org.valkyrienskies.core.impl.shadow.ry_0;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.rh
 */
public final class rh_0 {
    rs_0 a;
    rs_0 b;
    rs_0 c;

    private rh_0(rs_0 rs_02, rs_0 rs_03) {
        this.a = rs_02;
        this.b = rs_03;
        this.c = rs_0.c(rs_02, rs_03);
    }

    private rB[][] a(rj_0 rBArray) {
        Object object = rBArray;
        rB[] rBArray2 = new a(this, object.a);
        rBArray.a(true).a(rBArray2);
        Object object2 = rBArray2;
        rBArray = rBArray2.a;
        rBArray = rBArray.b();
        for (int i2 = 0; i2 < rBArray.length; ++i2) {
            rB[] rBArray3 = rBArray[i2];
            int n2 = rBArray3.length;
            int n3 = 0;
            while (n3 < n2) {
                int n4 = n3;
                int n5 = n2;
                object2 = rBArray3;
                rB rB2 = rBArray3[(n4 + n5 - 1) % n5];
                rB rB3 = object2[n4];
                object2 = object2[(n4 + 1) % n5];
                rB rB4 = rB3;
                object = rB4;
                object = rB2;
                double d2 = rB4.c - object.c;
                rB rB5 = rB3;
                object = rB5;
                object = rB2;
                double d3 = rB5.d - object.d;
                object = object2;
                object = rB3;
                double d4 = object2.c - object.c;
                object = object2;
                object = rB3;
                double d5 = object2.d - object.d;
                double d6 = d2 * d5 - d4 * d3;
                double d7 = d2 * d4 + d3 * d5;
                double d8 = d2;
                double d9 = d3;
                double d10 = d4;
                double d11 = d5;
                double d12 = BY.a((d8 * d8 + d9 * d9) * (d10 * d10 + d11 * d11));
                if (BY.w(d6) <= d12 * 1.0E-6 && d7 >= 0.0) {
                    for (int i3 = n3; i3 < n2 - 1; ++i3) {
                        rBArray3[i3] = rBArray3[i3 + 1];
                    }
                    --n2;
                    continue;
                }
                ++n3;
            }
            if (n2 == rBArray3.length) continue;
            rBArray[i2] = new rB[n2];
            System.arraycopy(rBArray3, 0, rBArray[i2], 0, n2);
        }
        return rBArray;
    }

    private static boolean a(rB[] object, int n2, int n3) {
        rB rB2 = object[(n3 + n2 - 1) % n2];
        Object object2 = object[n3];
        object = object[(n3 + 1) % n2];
        Object object3 = object2;
        object3 = rB2;
        double d2 = object2.c - object3.c;
        object3 = object2;
        object3 = rB2;
        double d3 = object2.d - object3.d;
        object3 = object;
        object3 = object2;
        double d4 = object.c - object2.c;
        object3 = object;
        object3 = object2;
        double d5 = object.d - object2.d;
        double d6 = d2 * d5 - d4 * d3;
        double d7 = d2 * d4 + d3 * d5;
        double d8 = d2;
        double d9 = d3;
        double d10 = d4;
        double d11 = d5;
        double d12 = BY.a((d8 * d8 + d9 * d9) * (d10 * d10 + d11 * d11));
        return BY.w(d6) <= d12 * 1.0E-6 && d7 >= 0.0;
    }

    static /* synthetic */ rs_0 a(rh_0 rh_02) {
        return rh_02.c;
    }

    static /* synthetic */ rs_0 b(rh_0 rh_02) {
        return rh_02.a;
    }

    static /* synthetic */ rs_0 c(rh_0 rh_02) {
        return rh_02.b;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class a
    implements rN<rc_0> {
        ry_0 a;
        private final double b;
        private /* synthetic */ rh_0 c;

        a(rh_0 rh_02, double d2) {
            this.c = rh_02;
            this.a = new ry_0(new rM<rv_0>(Boolean.FALSE), d2);
            this.b = d2;
        }

        @Override
        public final int a(rM<rc_0> rM2) {
            return rN.a.MINUS_SUB_PLUS$672d2271;
        }

        @Override
        public final void b(rM<rc_0> object) {
            Object object2 = object;
            object2 = object = (rO)((rM)object2).e;
            if (((rO)object).a != null) {
                object2 = object;
                this.a(((rO)object2).a, false);
            }
            object2 = object;
            if (((rO)object2).b != null) {
                object2 = object;
                this.a(((rO)object2).b, true);
            }
        }

        @Override
        public final void c(rM<rc_0> rM2) {
        }

        private void a(sb_0<rc_0> object, boolean bl) {
            double d2;
            rB[][] rBArray = (rB[][])object;
            object = (ri_0)object.c();
            sb_0 sb_02 = object;
            sb_02 = this.c;
            double d3 = ((ri_0)object).e.f(((rh)sb_02).c);
            if (BY.w(d2) > 0.001) {
                sb_02 = rBArray;
                rBArray = ((ry_0)rBArray.b).b();
                if (d3 < 0.0 ^ bl) {
                    rB[][] rBArrayArray = new rB[rBArray.length][];
                    for (int i2 = 0; i2 < rBArray.length; ++i2) {
                        int n2;
                        rB[] rBArray2 = rBArray[i2];
                        rB[] rBArray3 = new rB[rBArray2.length];
                        if (rBArray2[0] == null) {
                            rBArray3[0] = null;
                            for (n2 = 1; n2 < rBArray2.length; ++n2) {
                                rBArray3[n2] = rBArray2[rBArray2.length - n2];
                            }
                        } else {
                            for (n2 = 0; n2 < rBArray2.length; ++n2) {
                                rBArray3[n2] = rBArray2[rBArray2.length - (n2 + 1)];
                            }
                        }
                        rBArrayArray[i2] = rBArray3;
                    }
                    rBArray = rBArrayArray;
                }
                ArrayList<sb_0<rv_0>> arrayList = new ArrayList<sb_0<rv_0>>();
                Object object2 = rBArray;
                int n3 = rBArray.length;
                for (int i3 = 0; i3 < n3; ++i3) {
                    rB[] rBArray4 = object2[i3];
                    boolean bl2 = rBArray4[0] != null;
                    int n4 = bl2 ? rBArray4.length - 1 : 1;
                    qO<rc_0> qO2 = ((ri_0)object).f(rBArray4[n4]);
                    int n5 = (n4 + 1) % rBArray4.length;
                    rh_0 rh_02 = this.c;
                    sb_02 = rh_02;
                    sb_02 = this.c;
                    qO2 = new rB(qO2.f((qO<rc_0>)((rh)rh_02).a), qO2.f((qO<rc_0>)((rh)sb_02).b));
                    while (n5 < rBArray4.length) {
                        double d4;
                        qO<rc_0> qO3 = ((ri_0)object).f(rBArray4[n5]);
                        rh_0 rh_03 = this.c;
                        sb_02 = rh_03;
                        sb_02 = this.c;
                        qO3 = new rB(qO3.f((qO<rc_0>)((rh)rh_03).a), qO3.f((qO<rc_0>)((rh)sb_02).b));
                        rw_0 rw_02 = new rw_0((rB)qO2, (rB)qO3, this.b);
                        sb_02 = rw_02.d();
                        if (bl2 || n4 != 1) {
                            d4 = rw_02.h() + 1.5707963267948966;
                            rw_0 rw_03 = new rw_0((rB)qO2, d4, this.b);
                            sb_02 = sb_02.a(rw_03);
                            sb_02 = ((sb_0.a)((Object)sb_02)).a;
                        }
                        if (bl2 || n5 != rBArray4.length - 1) {
                            d4 = rw_02.h() + 1.5707963267948966;
                            rw_0 rw_04 = new rw_0((rB)qO3, d4, this.b);
                            sb_02 = sb_02.a(rw_04);
                            sb_02 = ((sb_0.a)((Object)sb_02)).b;
                        }
                        arrayList.add(sb_02);
                        n4 = n5++;
                        qO2 = qO3;
                    }
                }
                object2 = new ry_0((Collection<sb_0<rv_0>>)arrayList, this.b);
                this.a = (ry_0)new rZ<rv_0>().a((rY<rv_0>)this.a, (rY<rv_0>)object2);
            }
        }

        public final ry_0 a() {
            return this.a;
        }
    }
}

