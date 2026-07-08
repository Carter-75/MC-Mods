/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.rj
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.rA;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rO;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rZ;
import org.valkyrienskies.core.impl.shadow.rc_0;
import org.valkyrienskies.core.impl.shadow.rf_0;
import org.valkyrienskies.core.impl.shadow.ri_0;
import org.valkyrienskies.core.impl.shadow.rj;
import org.valkyrienskies.core.impl.shadow.rk_0;
import org.valkyrienskies.core.impl.shadow.rr_0;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;
import org.valkyrienskies.core.impl.shadow.ry_0;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sc_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.rj
 */
public final class rj_0
extends rK<rc_0, rv_0> {
    private static final double b = 1.0E-10;

    public rj_0(double d2) {
        super(d2);
    }

    private rj_0(rM<rc_0> rM2, double d2) {
        super(rM2, d2);
    }

    private rj_0(Collection<sb_0<rc_0>> collection, double d2) {
        super(collection, 1.0E-10);
    }

    private rj_0(List<rs_0> list, List<int[]> list2, double d2) {
        super(rj_0.a(list, list2, d2), d2);
    }

    private rj_0(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        rM rM2;
        double d9 = 1.0E-10;
        double d10 = d7;
        double d11 = d6;
        double d12 = d5;
        double d13 = d4;
        double d14 = d2;
        double d15 = d3;
        if (d14 >= d15 - d9 || d13 >= d12 - d9 || d11 >= d10 - d9) {
            rM2 = new rM(Boolean.FALSE);
        } else {
            Object object = new ri_0(new rs_0(d14, 0.0, 0.0), rs_0.c, d9);
            ri_0 ri_02 = new ri_0(new rs_0(d15, 0.0, 0.0), rs_0.b, d9);
            ri_0 ri_03 = new ri_0(new rs_0(0.0, d13, 0.0), rs_0.e, d9);
            ri_0 ri_04 = new ri_0(new rs_0(0.0, d12, 0.0), rs_0.d, d9);
            ri_0 ri_05 = new ri_0(new rs_0(0.0, 0.0, d11), rs_0.g, d9);
            ri_0 ri_06 = new ri_0(new rs_0(0.0, 0.0, d10), rs_0.f, d9);
            object = new rZ().a(new rV[]{object, ri_02, ri_03, ri_04, ri_05, ri_06});
            rM2 = object.a(false);
        }
        super(rM2, 1.0E-10);
    }

    @Deprecated
    public rj_0() {
        this(1.0E-10);
    }

    @Deprecated
    private rj_0(rM<rc_0> rM2) {
        this(rM2, 1.0E-10);
    }

    @Deprecated
    private rj_0(Collection<sb_0<rc_0>> collection) {
        this(collection, 1.0E-10);
    }

    @Deprecated
    private rj_0(double d2, double d3, double d4, double d5, double d6, double d7) {
        this(d2, d3, d4, d5, d6, d7, 1.0E-10);
    }

    private static rM<rc_0> a(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        if (d2 >= d3 - d8 || d4 >= d5 - d8 || d6 >= d7 - d8) {
            return new rM<rc_0>(Boolean.FALSE);
        }
        Object object = new ri_0(new rs_0(d2, 0.0, 0.0), rs_0.c, d8);
        ri_0 ri_02 = new ri_0(new rs_0(d3, 0.0, 0.0), rs_0.b, d8);
        ri_0 ri_03 = new ri_0(new rs_0(0.0, d4, 0.0), rs_0.e, d8);
        ri_0 ri_04 = new ri_0(new rs_0(0.0, d5, 0.0), rs_0.d, d8);
        ri_0 ri_05 = new ri_0(new rs_0(0.0, 0.0, d6), rs_0.g, d8);
        ri_0 ri_06 = new ri_0(new rs_0(0.0, 0.0, d7), rs_0.f, d8);
        object = new rZ().a(new rV[]{object, ri_02, ri_03, ri_04, ri_05, ri_06});
        return object.a(false);
    }

    private static List<sb_0<rc_0>> a(List<rs_0> list, List<int[]> object, double d2) {
        Object object2;
        int n2;
        int n32;
        int n4;
        Object object3;
        for (int i2 = 0; i2 < list.size() - 1; ++i2) {
            object3 = list.get(i2);
            for (int i3 = i2 + 1; i3 < list.size(); ++i3) {
                if (!(rs_0.d((rs_0)object3, list.get(i3)) <= d2)) continue;
                Object[] objectArray = new Object[3];
                object = object3;
                objectArray[0] = ((rs_0)object).i;
                object = object3;
                objectArray[1] = ((rs_0)object).j;
                object = object3;
                objectArray[2] = ((rs_0)object).k;
                throw new oV(px_0.CLOSE_VERTICES, objectArray);
            }
        }
        Object object4 = object;
        object3 = list;
        Object object5 = new int[object3.size()];
        int n5 = 0;
        Object object6 = object4.iterator();
        while (object6.hasNext()) {
            int[] nArray = object6.next();
            if (nArray.length < 3) {
                throw new pn_0((pw_0)px_0.WRONG_NUMBER_OF_POINTS, (Number)3, nArray.length, true);
            }
            int[] nArray2 = nArray;
            n4 = nArray.length;
            for (int i4 = 0; i4 < n4; ++i4) {
                int n6 = n32 = nArray2[i4];
                int n7 = object5[n6] + 1;
                object5[n6] = n7;
                n5 = BY.b(n5, n7);
            }
        }
        int[][] nArray = new int[object3.size()][n5];
        object6 = nArray;
        int[][] nArray3 = nArray;
        int n8 = nArray.length;
        for (n4 = 0; n4 < n8; ++n4) {
            int[] nArray4 = nArray3[n4];
            Arrays.fill(nArray4, -1);
        }
        for (n2 = 0; n2 < object4.size(); ++n2) {
            for (int n32 : object4.get(n2)) {
                for (int i5 = 0; i5 < n5 && object6[n32][i5] >= 0; ++i5) {
                }
                object6[n32][i5] = n2;
            }
        }
        object5 = object6;
        object4 = object;
        Object object7 = list;
        int[][] nArray5 = new int[object7.size()][((int)object5[0]).length];
        object6 = nArray5;
        n2 = nArray5.length;
        for (int i6 = 0; i6 < n2; ++i6) {
            Object object8 = object6[i6];
            Arrays.fill((int[])object8, -1);
        }
        for (int i7 = 0; i7 < object7.size(); ++i7) {
            for (n2 = 0; n2 < nArray5[i7].length && object5[i7][n2] >= 0; ++n2) {
                int n9;
                int[] nArray6 = (int[])object4.get((int)object5[i7][n2]);
                for (n9 = 0; n9 < nArray6.length && nArray6[n9] != i7; ++n9) {
                }
                nArray5[i7][n2] = nArray6[(n9 + 1) % nArray6.length];
                for (int i8 = 0; i8 < n2; ++i8) {
                    if (nArray5[i7][i8] != nArray5[i7][n2]) continue;
                    rs_0 rs_02 = (rs_0)object7.get(i7);
                    object7 = (rs_0)object7.get(nArray5[i7][n2]);
                    Object[] objectArray = new Object[6];
                    object = rs_02;
                    objectArray[0] = ((rs_0)object).i;
                    object = rs_02;
                    objectArray[1] = ((rs_0)object).j;
                    object = rs_02;
                    objectArray[2] = ((rs_0)object).k;
                    object = object7;
                    objectArray[3] = ((rs_0)object).i;
                    object = object7;
                    objectArray[4] = ((rs_0)object).j;
                    object = object7;
                    objectArray[5] = ((rs_0)object).k;
                    throw new oV(px_0.FACET_ORIENTATION_MISMATCH, objectArray);
                }
            }
        }
        object7 = nArray5;
        for (n2 = 0; n2 < list.size(); ++n2) {
            for (Object object9 : object7[n2]) {
                if (object9 < 0) continue;
                n32 = 0;
                object2 = object7[object9];
                int n10 = ((Object)object2).length;
                for (int i9 = 0; i9 < n10; ++i9) {
                    Object object10 = object2[i9];
                    n32 = n32 != 0 || object10 == n2 ? 1 : 0;
                }
                if (n32 != 0) continue;
                object2 = list.get(n2);
                rs_0 rs_03 = list.get((int)object9);
                Object[] objectArray = new Object[6];
                object = object2;
                objectArray[0] = ((rs_0)object).i;
                object = object2;
                objectArray[1] = ((rs_0)object).j;
                object = object2;
                objectArray[2] = ((rs_0)object).k;
                object = rs_03;
                objectArray[3] = ((rs_0)object).i;
                object = rs_03;
                objectArray[4] = ((rs_0)object).j;
                object = rs_03;
                objectArray[5] = ((rs_0)object).k;
                throw new oV(px_0.EDGE_CONNECTED_TO_ONE_FACET, objectArray);
            }
        }
        ArrayList<sb_0<rc_0>> arrayList = new ArrayList<sb_0<rc_0>>();
        Iterator iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            int[] nArray7 = (int[])iterator2.next();
            ri_0 ri_02 = new ri_0(list.get(nArray7[0]), list.get(nArray7[1]), list.get(nArray7[2]), d2);
            rB[] rBArray = new rB[nArray7.length];
            for (n32 = 0; n32 < nArray7.length; ++n32) {
                ri_0 ri_03;
                object4 = object2 = list.get(nArray7[n32]);
                object7 = ri_02;
                Object object11 = object4;
                object5 = object7;
                if (!(BY.w(ri_03.a((qM<rc_0>)object11)) < ((ri_0)object7).f)) {
                    Object[] objectArray = new Object[3];
                    object = object2;
                    objectArray[0] = ((rs_0)object).i;
                    object = object2;
                    objectArray[1] = ((rs_0)object).j;
                    object = object2;
                    objectArray[2] = ((rs_0)object).k;
                    throw new oV(px_0.OUT_OF_PLANE, objectArray);
                }
                object7 = object2;
                object = ri_02;
                rBArray[n32] = ((ri_0)object).e((qM<rc_0>)object7);
            }
            arrayList.add(new rr_0(ri_02, new ry_0(d2, rBArray)));
        }
        return arrayList;
    }

    private static int[][] a(List<rs_0> list, List<int[]> list2) {
        int n2;
        Object object2;
        int[] nArray = new int[list.size()];
        int n3 = 0;
        for (Object object2 : list2) {
            if (((int[])object2).length < 3) {
                throw new pn_0((pw_0)px_0.WRONG_NUMBER_OF_POINTS, (Number)3, ((int[])object2).length, true);
            }
            Object object3 = object2;
            n2 = ((int[])object2).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n4;
                int n5 = n4 = object3[i2];
                int n6 = nArray[n5] + 1;
                nArray[n5] = n6;
                n3 = BY.b(n3, n6);
            }
        }
        int[][] nArray2 = new int[list.size()][n3];
        Object object4 = nArray2;
        object2 = nArray2;
        int n7 = nArray2.length;
        for (n2 = 0; n2 < n7; ++n2) {
            int n8 = object2[n2];
            Arrays.fill((int[])n8, -1);
        }
        for (int i3 = 0; i3 < list2.size(); ++i3) {
            for (int n4 : list2.get(i3)) {
                for (int i4 = 0; i4 < n3 && object4[n4][i4] >= 0; ++i4) {
                }
                object4[n4][i4] = i3;
            }
        }
        return object4;
    }

    private static int[][] a(List<rs_0> object, List<int[]> object2, int[][] object3) {
        int n2;
        int[][] nArray;
        int[][] nArray2 = nArray = new int[object.size()][object3[0].length];
        int n3 = nArray.length;
        for (n2 = 0; n2 < n3; ++n2) {
            int[] nArray3 = nArray2[n2];
            Arrays.fill(nArray3, -1);
        }
        for (int i2 = 0; i2 < object.size(); ++i2) {
            for (n3 = 0; n3 < nArray[i2].length && object3[i2][n3] >= 0; ++n3) {
                int n4;
                int[] nArray4 = object2.get(object3[i2][n3]);
                for (n4 = 0; n4 < nArray4.length && nArray4[n4] != i2; ++n4) {
                }
                nArray[i2][n3] = nArray4[(n4 + 1) % nArray4.length];
                for (n2 = 0; n2 < n3; ++n2) {
                    if (nArray[i2][n2] != nArray[i2][n3]) continue;
                    object2 = object.get(i2);
                    object = object.get(nArray[i2][n3]);
                    Object[] objectArray = new Object[6];
                    Object object4 = object2;
                    object3 = object4;
                    objectArray[0] = ((rs_0)object4).i;
                    Object object5 = object2;
                    object3 = object5;
                    objectArray[1] = ((rs_0)object5).j;
                    Object object6 = object2;
                    object3 = object6;
                    objectArray[2] = ((rs_0)object6).k;
                    Object object7 = object;
                    object3 = object7;
                    objectArray[3] = ((rs_0)object7).i;
                    Object object8 = object;
                    object3 = object8;
                    objectArray[4] = ((rs_0)object8).j;
                    Object object9 = object;
                    object3 = object9;
                    objectArray[5] = ((rs_0)object9).k;
                    throw new oV(px_0.FACET_ORIENTATION_MISMATCH, objectArray);
                }
            }
        }
        return nArray;
    }

    private rj_0 e(rM<rc_0> rM2) {
        return new rj_0(rM2, this.c());
    }

    @Override
    public final void a() {
        this.a(true).a(new a(this));
        if (this.g() < 0.0) {
            this.a(Double.POSITIVE_INFINITY);
            this.c(rs_0.h);
            return;
        }
        rj_0 rj_02 = this;
        rj_02.a(rj_02.g() / 3.0);
        this.c(new rs_0(1.0 / (4.0 * this.g()), (rs_0)this.h()));
    }

    private sb_0<rc_0> a(rs_0 rs_02, rf_0 rf_02) {
        rj_0 rj_02 = this;
        return rj_02.a(rj_02.a(true), rs_02, rf_02);
    }

    private sb_0<rc_0> a(rM<rc_0> object, rs_0 rs_02, rf_0 rf_02) {
        while (true) {
            rM<rc_0> rM2;
            double d2;
            boolean bl;
            sb_0<rc_0> sb_02 = object;
            sb_0 sb_03 = ((rM)((Object)sb_02)).a;
            if (sb_03 == null) {
                return null;
            }
            sb_02 = object;
            rM<Object> rM3 = ((rM)((Object)sb_02)).c;
            sb_02 = object;
            sb_02 = ((rM)((Object)sb_02)).b;
            sb_03 = (ri_0)sb_03.c();
            double d3 = ((ri_0)((Object)sb_03)).a((qM<rc_0>)rs_02);
            boolean bl2 = bl = BY.w(d2) < this.c();
            if (d3 < 0.0) {
                rM2 = rM3;
                rM3 = sb_02;
            } else {
                rM2 = sb_02;
            }
            if (bl && (sb_02 = rj_0.a(rs_02, object)) != null) {
                return sb_02;
            }
            sb_02 = this.a(rM2, rs_02, rf_02);
            if (sb_02 != null) {
                return sb_02;
            }
            if (!bl && (sb_03 = ((ri_0)((Object)sb_03)).a(rf_02)) != null && rf_02.a((rs_0)((Object)sb_03)) > rf_02.a(rs_02) && (object = rj_0.a((rs_0)((Object)sb_03), object)) != null) {
                return object;
            }
            object = rM3;
        }
    }

    private static sb_0<rc_0> a(rs_0 qO2, rM<rc_0> object) {
        Object object2 = object;
        qO2 = ((ri_0)((rM)object2).a.c()).e((qM<rc_0>)qO2);
        object2 = object;
        object2 = object = (rO)((rM)object2).e;
        if (((rO)object).a != null) {
            object2 = object;
            object2 = (rr_0)((rO)object2).a;
            if (((rL)object2).b.b(qO2) == rY.a.INSIDE$3ad793e5) {
                object2 = object;
                return ((rO)object2).a;
            }
        }
        object2 = object;
        if (((rO)object2).b != null) {
            object2 = object;
            object2 = (rr_0)((rO)object2).b;
            if (((rL)object2).b.b(qO2) == rY.a.INSIDE$3ad793e5) {
                object2 = object;
                return ((rO)object2).b;
            }
        }
        return null;
    }

    private rj_0 a(rs_0 rs_02, rk_0 rk_02) {
        return (rj_0)this.a(new b(rs_02, rk_02));
    }

    private rj_0 a(rs_0 rs_02) {
        return (rj_0)this.a(new c(rs_02));
    }

    @Override
    public final /* synthetic */ rK a(rM rM2) {
        return this.e(rM2);
    }

    @Override
    public final /* synthetic */ rK b(rM rM2) {
        return this.e(rM2);
    }

    static /* synthetic */ void a(rj_0 rj_02, double d2) {
        rj_02.a(0.0);
    }

    static /* synthetic */ void a(rj_0 rj_02, rs_0 rs_02) {
        rj_02.c(rs_02);
    }

    static /* synthetic */ void b(rj_0 rj_02, double d2) {
        rj_02.a(Double.POSITIVE_INFINITY);
    }

    static /* synthetic */ void b(rj_0 rj_02, rs_0 rs_02) {
        rj_02.c(rs_02);
    }

    static /* synthetic */ void c(rj_0 rj_02, double d2) {
        rj_02.a(d2);
    }

    static /* synthetic */ void c(rj_0 rj_02, rs_0 rs_02) {
        rj_02.c(rs_02);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class c
    implements sc_0<rc_0, rv_0> {
        private rs_0 a;
        private ri_0 b;
        private sc_0<rv_0, qU> c;

        c(rs_0 rs_02) {
            this.a = rs_02;
        }

        private rs_0 b(qM<rc_0> qM2) {
            return new rs_0(1.0, (rs_0)qM2, 1.0, this.a);
        }

        private ri_0 b(rV<rc_0> ri_02) {
            Object object = this.a;
            ri_02 = ri_02;
            object = new ri_0(ri_02.b.g((qO<rc_0>)object), ri_02.e, ri_02.f);
            v0.c = ri_02.c;
            ((ri_0)object).d = ri_02.d;
            return object;
        }

        @Override
        public final sb_0<rv_0> a(sb_0<rv_0> sb_02, rV<rc_0> rV2, rV<rc_0> object) {
            if (rV2 != this.b) {
                Object object2 = (ri_0)rV2;
                object = (ri_0)object;
                object = ((ri_0)object).e((qM<rc_0>)this.b(((ri_0)object2).b));
                this.b = (ri_0)rV2;
                Object object3 = object;
                object2 = object3;
                object2 = object;
                this.c = rw_0.a((double)1.0, (double)0.0, (double)0.0, (double)1.0, (double)((rB)object3).c, (double)((rB)object2).d);
            }
            return ((rA)sb_02).a(this.c);
        }

        @Override
        public final /* synthetic */ rV a(rV object) {
            Object object2 = object;
            object = this;
            ri_0 ri_02 = (ri_0)object2;
            object2 = ((c)object).a;
            object = ri_02;
            object2 = new ri_0(((ri_0)object).b.g((qO<rc_0>)object2), ((ri_0)object).e, ((ri_0)object).f);
            v1.c = ((ri_0)object).c;
            ((ri_0)object2).d = ((ri_0)object).d;
            return object2;
        }

        @Override
        public final /* synthetic */ qM a(qM qM2) {
            return this.b(qM2);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class b
    implements sc_0<rc_0, rv_0> {
        private rs_0 a;
        private rk_0 b;
        private ri_0 c;
        private sc_0<rv_0, qU> d;

        b(rs_0 rs_02, rk_0 rk_02) {
            this.a = rs_02;
            this.b = rk_02;
        }

        private rs_0 b(qM<rc_0> rs_02) {
            rs_02 = ((rs_0)rs_02).h(this.a);
            return new rs_0(1.0, this.a, 1.0, this.b.a(rs_02));
        }

        private ri_0 b(rV<rc_0> ri_02) {
            rk_0 rk_02 = this.b;
            Object object = this.a;
            ri_02 = ri_02;
            rs_0 rs_02 = ri_02.b.h((qO<rc_0>)object);
            object = new ri_0(((rs_0)object).g(rk_02.a(rs_02)), rk_02.a(ri_02.e), ri_02.f);
            v0.c = rk_02.a(ri_02.c);
            ((ri_0)object).d = rk_02.a(ri_02.d);
            return object;
        }

        @Override
        public final sb_0<rv_0> a(sb_0<rv_0> sb_02, rV<rc_0> rV2, rV<rc_0> object) {
            if (rV2 != this.c) {
                Object object2 = (ri_0)rV2;
                object = (ri_0)object;
                Object object3 = object2;
                qO<rc_0> qO2 = ((ri_0)object3).b;
                qO<rc_0> qO3 = ((ri_0)object2).f(new rB(1.0, 0.0));
                object2 = ((ri_0)object2).f(new rB(0.0, 1.0));
                qO2 = ((ri_0)object).e((qM<rc_0>)this.b(qO2));
                qO3 = ((ri_0)object).e((qM<rc_0>)this.b(qO3));
                object = ((ri_0)object).e((qM<rc_0>)this.b((qM<rc_0>)object2));
                this.c = (ri_0)rV2;
                qO<rc_0> qO4 = qO3;
                object3 = qO4;
                qO<rc_0> qO5 = qO2;
                object3 = qO5;
                qO<rc_0> qO6 = qO3;
                object3 = qO6;
                qO<rc_0> qO7 = qO2;
                object3 = qO7;
                Object object4 = object;
                object3 = object4;
                qO<rc_0> qO8 = qO2;
                object3 = qO8;
                Object object5 = object;
                object3 = object5;
                qO<rc_0> qO9 = qO2;
                object3 = qO9;
                qO<rc_0> qO10 = qO2;
                object3 = qO10;
                object3 = qO2;
                this.d = rw_0.a((double)(((rB)qO4).c - ((rB)qO5).c), (double)(((rB)qO6).d - ((rB)qO7).d), (double)(((rB)object4).c - ((rB)qO8).c), (double)(((rB)object5).d - ((rB)qO9).d), (double)((rB)qO10).c, (double)((rB)object3).d);
            }
            return ((rA)sb_02).a(this.d);
        }

        @Override
        public final /* synthetic */ rV a(rV object) {
            Object object2 = object;
            object = this;
            ri_0 ri_02 = (ri_0)object2;
            rk_0 rk_02 = ((b)object).b;
            object2 = ((b)object).a;
            object = ri_02;
            rs_0 rs_02 = ri_02.b.h((qO<rc_0>)object2);
            object2 = new ri_0(((rs_0)object2).g(rk_02.a(rs_02)), rk_02.a(((ri_0)object).e), ((ri_0)object).f);
            v1.c = rk_02.a(((ri_0)object).c);
            ((ri_0)object2).d = rk_02.a(((ri_0)object).d);
            return object2;
        }

        @Override
        public final /* synthetic */ qM a(qM qM2) {
            return this.b(qM2);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class a
    implements rN<rc_0> {
        private /* synthetic */ rj_0 a;

        a(rj_0 rj_02) {
            this.a = rj_02;
            rj.a((rj_0)rj_02, (double)0.0);
            rj.a((rj_0)rj_02, (rs_0)new rs_0(0.0, 0.0, 0.0));
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
            rr_0 rr_02 = (rr_0)object;
            rY rY2 = rr_02.b;
            double d2 = rY2.g();
            if (Double.isInfinite(d2)) {
                rj.b((rj_0)this.a, (double)Double.POSITIVE_INFINITY);
                rj.b((rj_0)this.a, (rs_0)rs_0.h);
                return;
            }
            object = (ri_0)object.c();
            rY2 = ((ri_0)object).f(rY2.h());
            Object object2 = object;
            double d3 = d2 * ((rs_0)((Object)rY2)).f(((ri_0)object2).e);
            if (bl) {
                d3 = -d3;
            }
            rj.c((rj_0)this.a, (double)(this.a.g() + d3));
            rj.c((rj_0)this.a, (rs_0)new rs_0(1.0, (rs_0)this.a.h(), d3, (rs_0)((Object)rY2)));
        }
    }
}

