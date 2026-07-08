/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.ry$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.qV;
import org.valkyrienskies.core.impl.shadow.qW;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rO;
import org.valkyrienskies.core.impl.shadow.rX;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;
import org.valkyrienskies.core.impl.shadow.ry;
import org.valkyrienskies.core.impl.shadow.ry_0;
import org.valkyrienskies.core.impl.shadow.rz_0;
import org.valkyrienskies.core.impl.shadow.sa_0;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ry
 */
public final class ry_0
extends rK<rv_0, qU> {
    private static final double b = 1.0E-10;
    private rB[][] c;

    public ry_0(double d2) {
        super(d2);
    }

    public ry_0(rM<rv_0> rM2, double d2) {
        super(rM2, d2);
    }

    public ry_0(Collection<sb_0<rv_0>> collection, double d2) {
        super(collection, d2);
    }

    private ry_0(double d2, double d3, double d4, double d5, double d6) {
        rw_0[] rw_0Array;
        double d7 = 1.0E-10;
        double d8 = d5;
        double d9 = d4;
        double d10 = d2;
        double d11 = d3;
        if (d10 >= d11 - d7 || d9 >= d8 - d7) {
            rw_0Array = null;
        } else {
            rB rB2 = new rB(d10, d9);
            rB rB3 = new rB(d10, d8);
            rB rB4 = new rB(d11, d9);
            rB rB5 = new rB(d11, d8);
            rw_0[] rw_0Array2 = new rw_0[4];
            rw_0Array2[0] = new rw_0(rB2, rB4, d7);
            rw_0Array2[1] = new rw_0(rB4, rB5, d7);
            rw_0Array2[2] = new rw_0(rB5, rB3, d7);
            rw_0Array = rw_0Array2;
            rw_0Array2[3] = new rw_0(rB3, rB2, d7);
        }
        super(rw_0Array, 1.0E-10);
    }

    public ry_0(double d2, rB ... rBArray) {
        super(ry_0.a(d2, rBArray), d2);
    }

    @Deprecated
    public ry_0() {
        this(1.0E-10);
    }

    @Deprecated
    private ry_0(rM<rv_0> rM2) {
        this(rM2, 1.0E-10);
    }

    @Deprecated
    private ry_0(Collection<sb_0<rv_0>> collection) {
        this(collection, 1.0E-10);
    }

    @Deprecated
    private ry_0(double d2, double d3, double d4, double d5) {
        this(d2, d3, d4, d5, 1.0E-10);
    }

    private static rw_0[] a(double d2, double d3, double d4, double d5, double d6) {
        if (d2 >= d3 - d6 || d4 >= d5 - d6) {
            return null;
        }
        rB rB2 = new rB(d2, d4);
        rB rB3 = new rB(d2, d5);
        rB rB4 = new rB(d3, d4);
        rB rB5 = new rB(d3, d5);
        return new rw_0[]{new rw_0(rB2, rB4, d6), new rw_0(rB4, rB5, d6), new rw_0(rB5, rB3, d6), new rw_0(rB3, rB2, d6)};
    }

    private static rM<rv_0> a(double d2, rB ... rBArray) {
        int n2 = rBArray.length;
        if (n2 == 0) {
            return new rM<rv_0>(Boolean.TRUE);
        }
        d[] dArray = new d[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = new d(rBArray[i2]);
        }
        ArrayList<b> arrayList = new ArrayList<b>(n2);
        for (int i3 = 0; i3 < n2; ++i3) {
            d d3;
            Object object;
            Object object3;
            d[] dArray2;
            d[] dArray3;
            d d32;
            block7: {
                d32 = dArray[i3];
                dArray2 = dArray3 = dArray[(i3 + 1) % n2];
                object3 = d32;
                object3 = ((d)object3).d.iterator();
                while (object3.hasNext()) {
                    rw_0 rw_02 = (rw_0)object3.next();
                    for (rw_0 rw_03 : dArray2.d) {
                        if (rw_02 != rw_03) continue;
                        object = rw_02;
                        break block7;
                    }
                }
                object = object3 = null;
            }
            if (object == null) {
                d d4 = d32;
                d3 = d4;
                d3 = dArray3;
                object3 = new rw_0(d4.a, dArray3.a, d2);
            }
            arrayList.add(new b(d32, (d)dArray3, (rw_0)object3));
            dArray2 = dArray;
            int n3 = dArray.length;
            for (int i4 = 0; i4 < n3; ++i4) {
                d d5;
                d d6 = dArray2[i4];
                if (d6 == d32 || d6 == dArray3) continue;
                d3 = d6;
                if (!(BY.w(((rw_0)object3).a((qM<rv_0>)d5.a)) <= d2)) continue;
                d6.a((rw_0)object3);
            }
        }
        rM<rv_0> rM2 = new rM<rv_0>();
        ry_0.a(d2, rM2, arrayList);
        return rM2;
    }

    private static void a(double d2, rM<rv_0> rM2, List<b> object) {
        rM<rv_0> rM3;
        Object object2;
        b b2;
        block17: {
            Object object3;
            block19: {
                block18: {
                    int n2 = 0;
                    b2 = null;
                    while (b2 == null && n2 < object.size()) {
                        b2 = object.get(n2++);
                        object3 = b2;
                        if (b2.d == null) {
                            object3 = b2;
                            if (rM2.a(((b)object3).c)) {
                                object2 = rM2;
                                object3 = b2;
                                b2.d = object2;
                                continue;
                            }
                            b2 = null;
                            continue;
                        }
                        b2 = null;
                    }
                    if (b2 != null) break block17;
                    object3 = rM2;
                    rM rM4 = ((rM)object3).d;
                    if (rM4 == null) break block18;
                    object3 = rM4;
                    if (rM2 != ((rM)object3).c) break block19;
                }
                object2 = Boolean.TRUE;
                object3 = rM2;
                rM2.e = object2;
                return;
            }
            object2 = Boolean.FALSE;
            object3 = rM2;
            rM2.e = object2;
            return;
        }
        ArrayList<b> arrayList = new ArrayList<b>();
        ArrayList<b> arrayList2 = new ArrayList<b>();
        object = object.iterator();
        block5: while (object.hasNext()) {
            int n3;
            object2 = (b)object.next();
            if (object2 == b2) continue;
            b b3 = b2;
            Object object4 = b3;
            object4 = object2;
            object4 = ((b)object4).a;
            double d3 = b3.c.a((qM<rv_0>)((d)object4).a);
            b b4 = b2;
            object4 = b4;
            object4 = object2;
            object4 = ((b)object4).b;
            double d4 = b4.c.a((qM<rv_0>)((d)object4).a);
            int n4 = BY.w(d3) <= d2 ? sa_0.HYPER$7c70dd6b : (n3 = d3 < 0.0 ? sa_0.MINUS$7c70dd6b : sa_0.PLUS$7c70dd6b);
            int n5 = BY.w(d4) <= d2 ? sa_0.HYPER$7c70dd6b : (d4 < 0.0 ? sa_0.MINUS$7c70dd6b : sa_0.PLUS$7c70dd6b);
            switch (1.a[n3 - 1]) {
                case 1: {
                    if (n5 == sa_0.MINUS$7c70dd6b) {
                        Object object5 = b2;
                        object5 = object2 = ((b)object2).a(((b)object5).c);
                        arrayList2.add(((d)object5).c);
                        object5 = object2;
                        arrayList.add(((d)object5).b);
                        continue block5;
                    }
                    arrayList.add((b)object2);
                    continue block5;
                }
                case 2: {
                    if (n5 == sa_0.PLUS$7c70dd6b) {
                        Object object6 = b2;
                        object6 = object2 = ((b)object2).a(((b)object6).c);
                        arrayList2.add(((d)object6).b);
                        object6 = object2;
                        arrayList.add(((d)object6).c);
                        continue block5;
                    }
                    arrayList2.add((b)object2);
                    continue block5;
                }
            }
            if (n5 == sa_0.PLUS$7c70dd6b) {
                arrayList.add((b)object2);
                continue;
            }
            if (n5 != sa_0.MINUS$7c70dd6b) continue;
            arrayList2.add((b)object2);
        }
        if (!arrayList.isEmpty()) {
            rM3 = rM2;
            ry_0.a(d2, rM3.b, arrayList);
        } else {
            rM3 = rM2;
            object2 = Boolean.FALSE;
            rM3 = rM3.b;
            rM3.b.e = object2;
        }
        if (!arrayList2.isEmpty()) {
            rM3 = rM2;
            ry_0.a(d2, rM3.c, arrayList2);
            return;
        }
        rM3 = rM2;
        object2 = Boolean.TRUE;
        rM3 = rM3.c;
        rM3.c.e = object2;
    }

    private ry_0 e(rM<rv_0> rM2) {
        return new ry_0(rM2, this.c());
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final void a() {
        rB[][] rBArray = this.b();
        if (rBArray.length == 0) {
            rM rM2;
            rM rM3 = rM2 = this.a(false);
            if (rM2.a == null) {
                rM3 = rM2;
                if (((Boolean)rM3.e).booleanValue()) {
                    this.a(Double.POSITIVE_INFINITY);
                    this.c(rB.b);
                    return;
                }
            }
            this.a(0.0);
            this.c(new rB(0.0, 0.0));
            return;
        }
        if (rBArray[0][0] == null) {
            this.a(Double.POSITIVE_INFINITY);
            this.c(rB.b);
            return;
        }
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        for (rB[] rBArray2 : rBArray) {
            double d5;
            double d6;
            double d7;
            rB rB2 = rBArray2[rBArray2.length - 1];
            double d8 = rB2.c;
            rB2 = rBArray2[rBArray2.length - 1];
            double d9 = rB2.d;
            int n2 = rBArray2.length;
            for (int i2 = 0; i2 < n2; d2 += d7, d3 += d7 * (d6 + d8), d4 += d7 * (d5 + d9), ++i2) {
                rB rB3 = rBArray2[i2];
                d6 = d8;
                d5 = d9;
                rB rB4 = rB3;
                d8 = rB4.c;
                rB4 = rB3;
                d9 = rB4.d;
                d7 = d6 * d9 - d5 * d8;
            }
        }
        if (d2 < 0.0) {
            this.a(Double.POSITIVE_INFINITY);
            this.c(rB.b);
            return;
        }
        this.a(d2 / 2.0);
        this.c(new rB(d3 / (d2 * 3.0), d4 / (d2 * 3.0)));
    }

    public final rB[][] b() {
        block15: {
            Object object;
            block16: {
                if (this.c != null) break block15;
                object = this.a(false);
                if (((rM)object).a != null) break block16;
                this.c = new rB[0][];
                break block15;
            }
            c object22 = new c(this.c());
            this.a(true).a(object22);
            object = object22;
            List<a_0> list = ((c)object).a;
            int n2 = list.size();
            if ((n2 -= ry_0.a(list)) > 0) {
                n2 -= ry_0.b(list);
            }
            if (n2 > 0) {
                this.c(list);
            }
            rB[] rBArray = new ArrayList<Object>();
            a_0 a_02 = ry_0.d(list);
            while (a_02 != null) {
                List<rz_0> list2 = this.a(a_02);
                if (list2 != null) {
                    object = list2.get(0);
                    if (((rz_0)object).g == null) {
                        rBArray.add(0, list2);
                    } else {
                        rBArray.add(list2);
                    }
                }
                a_02 = ry_0.d(list);
            }
            this.c = new rB[rBArray.size()][];
            int n3 = 0;
            for (List list3 : rBArray) {
                int n4;
                block18: {
                    block17: {
                        if (list3.size() < 2) break block17;
                        if (list3.size() != 2) break block18;
                        object = (rz_0)list3.get(0);
                        if (((rz_0)object).g != null) break block18;
                        object = (rz_0)list3.get(1);
                        if (((rz_0)object).h != null) break block18;
                    }
                    object = (rz_0)list3.get(0);
                    rBArray = ((rz_0)object).i;
                    this.c[n3++] = new rB[]{null, rBArray.f(new qZ(-3.4028234663852886E38)), rBArray.f(new qZ(3.4028234663852886E38))};
                    continue;
                }
                object = (rz_0)list3.get(0);
                if (((rz_0)object).g == null) {
                    rBArray = new rB[list3.size() + 2];
                    n4 = 0;
                    for (rz_0 rz_02 : list3) {
                        double d2;
                        if (n4 == 0) {
                            rz_0 rz_03 = rz_02;
                            object = rz_03;
                            object = rz_02;
                            object = rz_03.i.e((qM<rv_0>)((rz_0)object).h);
                            d2 = ((qZ)object).d;
                            d2 -= BY.e(1.0, BY.w(d2 / 2.0));
                            rBArray[n4++] = null;
                            int n5 = n4++;
                            object = rz_02;
                            rBArray[n5] = ((rz_0)object).i.f(new qZ(d2));
                        }
                        if (n4 < rBArray.length - 1) {
                            int n6 = n4++;
                            object = rz_02;
                            rBArray[n6] = ((rz_0)object).h;
                        }
                        if (n4 != rBArray.length - 1) continue;
                        rz_0 rz_04 = rz_02;
                        object = rz_04;
                        object = rz_02;
                        object = rz_04.i.e((qM<rv_0>)((rz_0)object).g);
                        d2 = ((qZ)object).d;
                        d2 += BY.e(1.0, BY.w(d2 / 2.0));
                        int n7 = n4++;
                        object = rz_02;
                        rBArray[n7] = ((rz_0)object).i.f(new qZ(d2));
                    }
                    this.c[n3++] = rBArray;
                    continue;
                }
                rBArray = new rB[list3.size()];
                n4 = 0;
                for (rz_0 rz_02 : list3) {
                    int n8 = n4++;
                    object = rz_02;
                    rBArray[n8] = ((rz_0)object).g;
                }
                this.c[n3++] = rBArray;
            }
        }
        return (rB[][])this.c.clone();
    }

    private static int a(List<a_0> list) {
        int n2 = 0;
        Iterator<a_0> iterator2 = list.iterator();
        block0: while (iterator2.hasNext()) {
            ry.a a2;
            ry.a a3 = a2 = (ry.a)iterator2.next();
            if (a2.e != null) continue;
            a3 = a2;
            rM rM2 = a3.a;
            a3 = a2;
            rM rM3 = a3.c;
            Iterator<a_0> iterator3 = list.iterator();
            while (iterator3.hasNext()) {
                ry.a a4;
                a3 = a4 = (ry.a)iterator3.next();
                if (a4.d != null) continue;
                a3 = a4;
                if (a3.a != rM3) continue;
                a3 = a4;
                if (a3.b != rM2) continue;
                rM2 = a4;
                a3 = a2;
                a2.e = rM2;
                rM2 = a2;
                a3 = a4;
                a4.d = rM2;
                ++n2;
                continue block0;
            }
        }
        return n2;
    }

    private static int b(List<a_0> list) {
        int n2 = 0;
        Iterator<a_0> iterator2 = list.iterator();
        block0: while (iterator2.hasNext()) {
            ry.a a2;
            Object object = a2 = (ry.a)iterator2.next();
            if (a2.e != null) continue;
            object = a2;
            object = object.a;
            ry.a a3 = object.a.c();
            object = a2;
            rM rM2 = object.c;
            Iterator<a_0> iterator3 = list.iterator();
            while (iterator3.hasNext()) {
                ry.a a4;
                object = a4 = (ry.a)iterator3.next();
                if (a4.d != null) continue;
                object = a4;
                object = object.a;
                if (object.a.c() != a3) continue;
                object = a4;
                if (object.b != rM2) continue;
                a3 = a4;
                object = a2;
                a2.e = a3;
                a3 = a2;
                object = a4;
                a4.d = a3;
                ++n2;
                continue block0;
            }
        }
        return n2;
    }

    private int c(List<a_0> list) {
        int n2 = 0;
        Iterator<a_0> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            ry.a a2;
            ry.a a3 = a2 = (ry.a)iterator2.next();
            if (a2.e != null) continue;
            a3 = a2;
            if (a3.h == null) continue;
            a3 = a2;
            rB rB2 = a3.h;
            ry.a a4 = null;
            double d2 = Double.POSITIVE_INFINITY;
            Iterator<a_0> iterator3 = list.iterator();
            while (iterator3.hasNext()) {
                double d3;
                ry.a a5;
                a3 = a5 = (ry.a)iterator3.next();
                if (a5.d != null) continue;
                a3 = a5;
                if (a3.g == null) continue;
                a3 = a5;
                double d4 = rB.c(rB2, a3.g);
                if (!(d3 < d2)) continue;
                a4 = a5;
                d2 = d4;
            }
            if (!(d2 <= this.c())) continue;
            rB2 = a4;
            a3 = a2;
            a2.e = rB2;
            rB2 = a2;
            a3 = a4;
            a4.d = rB2;
            ++n2;
        }
        return n2;
    }

    private static a_0 d(List<a_0> object) {
        object = object.iterator();
        while (object.hasNext()) {
            ry.a a2;
            ry.a a3 = a2 = (ry.a)object.next();
            if (a2.f) continue;
            return a2;
        }
        return null;
    }

    private List<rz_0> a(a_0 a_02) {
        ArrayList<rz_0> arrayList = new ArrayList<rz_0>();
        arrayList.add(a_02);
        boolean bl = true;
        rz_0 rz_02 = a_02;
        ((ry.a)a_02).f = true;
        rz_02 = a_02;
        a_0 a_03 = ((ry.a)rz_02).e;
        while (a_03 != a_02 && a_03 != null) {
            arrayList.add(a_03);
            boolean bl2 = true;
            rz_02 = a_03;
            ((ry.a)a_03).f = true;
            rz_02 = a_03;
            a_03 = ((ry.a)rz_02).e;
        }
        if (a_03 == null) {
            rz_02 = a_02;
            a_02 = ((ry.a)rz_02).d;
            while (a_02 != null) {
                arrayList.add(0, a_02);
                boolean bl3 = true;
                rz_02 = a_02;
                ((ry.a)a_02).f = true;
                rz_02 = a_02;
                a_02 = ((ry.a)rz_02).d;
            }
        }
        ry_0.e(arrayList);
        if (arrayList.size() == 2) {
            rz_02 = (rz_0)arrayList.get(0);
            if (rz_02.g != null) {
                return null;
            }
        }
        return arrayList;
    }

    private static void e(List<rz_0> list) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            rz_0 rz_02;
            rz_0 rz_03 = list.get(i2);
            int n2 = (i2 + 1) % list.size();
            rz_0 rz_04 = list.get(n2);
            if (rz_04 == null) continue;
            rz_0 rz_05 = rz_03;
            rz_05 = rz_04;
            if (!cq_0.b(rz_02.i.h(), rz_05.i.h(), cq_0.a)) continue;
            rz_0 rz_06 = rz_03;
            rz_05 = rz_06;
            rz_0 rz_07 = rz_04;
            rz_05 = rz_07;
            rz_05 = rz_03;
            list.set(n2, new rz_0(rz_06.g, rz_07.h, rz_05.i));
            list.remove(i2--);
        }
    }

    @Override
    public final /* synthetic */ rK a(rM rM2) {
        return this.e(rM2);
    }

    @Override
    public final /* synthetic */ rK b(rM rM2) {
        return this.e(rM2);
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[sa_0.values$65ac40a5().length];
            try {
                1.a[sa_0.PLUS$7c70dd6b - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[sa_0.MINUS$7c70dd6b - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class c
    implements rN<rv_0> {
        private final double b;
        final List<a_0> a;

        c(double d2) {
            this.b = d2;
            this.a = new ArrayList<a_0>();
        }

        @Override
        public final int a(rM<rv_0> rM2) {
            return rN.a.MINUS_SUB_PLUS$672d2271;
        }

        @Override
        public final void b(rM<rv_0> rM2) {
            Object object = rM2;
            rO rO2 = (rO)((rM)object).e;
            object = rO2;
            rX rX2 = rO2.c;
            object = rO2;
            if (((rO)object).a != null) {
                object = rO2;
                this.a(((rO)object).a, rM2, rX2, false);
            }
            object = rO2;
            if (((rO)object).b != null) {
                object = rO2;
                this.a(((rO)object).b, rM2, rX2, true);
            }
        }

        @Override
        public final void c(rM<rv_0> rM2) {
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        private void a(sb_0 object, rM rM2, rX rX2, boolean bl) {
            Iterator<qV> iterator2 = (rL)object;
            object = (rw_0)object.c();
            rM<rv_0> rM3 = iterator2;
            iterator2 = ((qW)((rL)((Object)rM3)).b).b();
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                rB rB2;
                rB rB3;
                qV qV2 = iterator2.next();
                rM3 = qV2;
                if (Double.isInfinite(qV2.a)) {
                    rB3 = null;
                } else {
                    rM3 = qV2;
                    rB3 = ((rw_0)object).f(new qZ(((qV)((Object)rM3)).a));
                }
                rB rB4 = rB3;
                rM3 = qV2;
                if (Double.isInfinite(((qV)((Object)rM3)).b)) {
                    rB2 = null;
                } else {
                    rM3 = qV2;
                    rB2 = ((rw_0)object).f(new qZ(((qV)((Object)rM3)).b));
                }
                qV2 = rB2;
                rM3 = this.a(rB4, rX2);
                rM<rv_0> rM4 = this.a((rB)((Object)qV2), rX2);
                if (bl) {
                    this.a.add((a_0)new ry.a((rB)((Object)qV2), rB4, ((rw_0)object).c(), rM2, rM4, rM3));
                    continue;
                }
                this.a.add((a_0)new ry.a(rB4, (rB)((Object)qV2), (rw_0)object, rM2, rM3, rM4));
            }
        }

        private rM<rv_0> a(rB rB2, Iterable<rM<rv_0>> object) {
            rM rM2 = null;
            double d2 = Double.POSITIVE_INFINITY;
            object = object.iterator();
            while (object.hasNext()) {
                double d3;
                rM rM3;
                rM rM4 = rM3 = (rM)object.next();
                double d4 = BY.w(rM3.a.c().a(rB2));
                if (!(d3 < d2)) continue;
                rM2 = rM3;
                d2 = d4;
            }
            if (d2 <= this.b) {
                return rM2;
            }
            return null;
        }

        public final List<a_0> a() {
            return this.a;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class b {
        final d a;
        final d b;
        final rw_0 c;
        rM<rv_0> d;

        b(d object, d d2, rw_0 object2) {
            this.a = object;
            this.b = d2;
            this.c = object2;
            this.d = null;
            v0.c = object2 = this;
            d d3 = object;
            object = object2;
            d3.a(((b)object).c);
            object2 = this;
            object = d2;
            d2.b = object2;
            Object object3 = object;
            object = object2;
            ((d)object3).a(((b)object).c);
        }

        public final d a() {
            return this.a;
        }

        public final d b() {
            return this.b;
        }

        public final rw_0 c() {
            return this.c;
        }

        public final void a(rM<rv_0> rM2) {
            this.d = rM2;
        }

        public final rM<rv_0> d() {
            return this.d;
        }

        public final d a(rw_0 object) {
            d d2 = new d(this.c.a((rw_0)object));
            d2.a((rw_0)object);
            object = new b(this.a, d2, this.c);
            b b2 = new b(d2, this.b, this.c);
            ((b)object).d = this.d;
            b2.d = this.d;
            return d2;
        }
    }

    static final class d {
        final rB a;
        b b;
        b c;
        final List<rw_0> d;

        d(rB rB2) {
            this.a = rB2;
            this.b = null;
            this.c = null;
            this.d = new ArrayList<rw_0>();
        }

        public final rB a() {
            return this.a;
        }

        public final void a(rw_0 rw_02) {
            this.d.add(rw_02);
        }

        public final rw_0 a(d d2) {
            for (rw_0 rw_02 : this.d) {
                for (rw_0 rw_03 : d2.d) {
                    if (rw_02 != rw_03) continue;
                    return rw_02;
                }
            }
            return null;
        }

        public final void a(b b2) {
            this.b = b2;
            this.a(b2.c);
        }

        public final b b() {
            return this.b;
        }

        public final void b(b b2) {
            this.c = b2;
            this.a(b2.c);
        }

        public final b c() {
            return this.c;
        }
    }
}

