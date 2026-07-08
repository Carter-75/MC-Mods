/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.wW;
import org.valkyrienskies.core.impl.shadow.wY;
import org.valkyrienskies.core.impl.shadow.xd_0;
import org.valkyrienskies.core.impl.shadow.xi_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xf
 */
final class xf_0
implements Serializable {
    private static final String d = "x-";
    private static final long e = -1369660067587938365L;
    private final wY f;
    private final List<wW> g;
    private final boolean h;
    private final List<String> i = new ArrayList<String>();
    transient sy_0 a;
    private final int j;
    private final int k;
    int b;
    private final double l;
    private final int m;
    private int[] n;
    int[] c;

    private xf_0(wY wY2, Collection<wW> collection, xi_0 xi_02, boolean bl, double d2) {
        this(wY2, collection, xi_02, bl, d2, 10);
    }

    xf_0(wY wY2, Collection<wW> object, xi_0 xi_02, boolean n2, double d2, int n3) {
        double d3;
        tu_0 tu_02;
        int n4;
        Object object2;
        Object object3;
        this.f = wY2;
        Object collection = object;
        object = this;
        ArrayList<wW> arrayList = new ArrayList<wW>(collection.size());
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            wW wW2;
            wW wW3;
            wW serializable2;
            wW n42 = serializable2 = (wW)iterator2.next();
            object3 = n42;
            if (wW3.c < 0.0) {
                xd_0 xd_02;
                object3 = n42;
                tu_0 tu_03 = ((wW)object3).a.h(-1.0);
                object3 = n42;
                object2 = ((wW)object3).b;
                switch (xd_0.1.a[((Enum)object2).ordinal()]) {
                    case 1: {
                        xd_02 = xd_0.GEQ;
                        break;
                    }
                    case 2: {
                        xd_02 = xd_0.LEQ;
                        break;
                    }
                    default: {
                        xd_02 = xd_0.EQ;
                    }
                }
                object3 = n42;
                wW2 = new wW(tu_03, xd_02, -1.0 * ((wW)object3).c);
            } else {
                wW wW4 = n42;
                object3 = wW4;
                wW wW5 = n42;
                object3 = wW5;
                object3 = n42;
                wW2 = new wW(wW4.a, wW5.b, ((wW)object3).c);
            }
            arrayList.add(wW2);
        }
        this.g = arrayList;
        this.h = n2;
        this.l = d2;
        this.m = n3;
        object3 = wY2;
        this.j = ((wY)object3).a.f() + (n2 != 0 ? 0 : 1);
        this.k = this.a(xd_0.LEQ) + this.a(xd_0.GEQ);
        this.b = this.a(xd_0.EQ) + this.a(xd_0.GEQ);
        int n5 = xi_02 == xi_0.MAXIMIZE ? 1 : 0;
        object = this;
        int n6 = ((xf_0)object).j + ((xf_0)object).k + ((xf_0)object).b + ((xf_0)object).a() + 1;
        int n7 = ((xf_0)object).g.size() + ((xf_0)object).a();
        sy_0 sy_02 = new sy_0(n7, n6);
        if (((xf_0)object).a() == 2) {
            ((sv_0)sy_02).c(0, 0, -1.0);
        }
        int n8 = n4 = ((xf_0)object).a() == 1 ? 0 : 1;
        ((sv_0)sy_02).c(n8, n8, n5 != 0 ? 1.0 : -1.0);
        if (n5 != 0) {
            object3 = ((xf_0)object).f;
            tu_02 = ((wY)object3).a.h(-1.0);
        } else {
            object3 = ((xf_0)object).f;
            tu_02 = ((wY)object3).a;
        }
        object2 = tu_02;
        object3 = sy_02;
        super.a(((tu_0)object2).g(), ((sy_0)object3).a[n4]);
        if (n5 != 0) {
            object3 = ((xf_0)object).f;
            d3 = ((wY)object3).b;
        } else {
            object3 = ((xf_0)object).f;
            d3 = -1.0 * ((wY)object3).b;
        }
        ((sv_0)sy_02).c(n4, n6 - 1, d3);
        if (!((xf_0)object).h) {
            ((sv_0)sy_02).c(n4, ((xf_0)object).k() - 1, xf_0.a((tu_0)object2));
        }
        int n9 = 0;
        int n10 = 0;
        for (n2 = 0; n2 < ((xf_0)object).g.size(); ++n2) {
            wW wW7 = ((xf_0)object).g.get(n2);
            int n11 = ((xf_0)object).a() + n2;
            wW wW6 = wW7;
            object3 = wW6;
            object3 = sy_02;
            super.a(wW6.a.g(), ((sy_0)object3).a[n11]);
            if (!((xf_0)object).h) {
                object3 = wW7;
                ((sv_0)sy_02).c(n11, ((xf_0)object).k() - 1, xf_0.a(((wW)object3).a));
            }
            object3 = wW7;
            ((sv_0)sy_02).c(n11, n6 - 1, ((wW)object3).c);
            object3 = wW7;
            if (((wW)object3).b == xd_0.LEQ) {
                ((sv_0)sy_02).c(n11, ((xf_0)object).k() + n9++, 1.0);
            } else {
                object3 = wW7;
                if (((wW)object3).b == xd_0.GEQ) {
                    ((sv_0)sy_02).c(n11, ((xf_0)object).k() + n9++, -1.0);
                }
            }
            object3 = wW7;
            if (((wW)object3).b != xd_0.EQ) {
                object3 = wW7;
                if (((wW)object3).b != xd_0.GEQ) continue;
            }
            ((sv_0)sy_02).c(0, ((xf_0)object).g() + n10, 1.0);
            ((sv_0)sy_02).c(n11, ((xf_0)object).g() + n10++, 1.0);
            sy_02.a(0, ((tu_0)((Object)sy_02.d(0))).k((tu_0)((Object)sy_02.d(n11))));
        }
        ((xf_0)object).a = sy_02;
        xf_0 xf_02 = this;
        xf_02.c(xf_02.k());
        object = this;
        if (((xf_0)object).a() == 2) {
            ((xf_0)object).i.add("W");
        }
        ((xf_0)object).i.add("Z");
        for (n5 = 0; n5 < ((xf_0)object).m(); ++n5) {
            ((xf_0)object).i.add("x" + n5);
        }
        if (!((xf_0)object).h) {
            ((xf_0)object).i.add(d);
        }
        n5 = 0;
        while (true) {
            Object object4 = object;
            if (n5 >= ((xf_0)object4).k) break;
            ((xf_0)object).i.add("s" + n5);
            ++n5;
        }
        n5 = 0;
        while (true) {
            object3 = object;
            if (n5 >= ((xf_0)object3).b) break;
            ((xf_0)object).i.add("a" + n5);
            ++n5;
        }
        ((xf_0)object).i.add("RHS");
    }

    private void j() {
        xf_0 xf_02;
        int n2;
        if (this.a() == 2) {
            this.i.add("W");
        }
        this.i.add("Z");
        for (n2 = 0; n2 < this.m(); ++n2) {
            this.i.add("x" + n2);
        }
        if (!this.h) {
            this.i.add(d);
        }
        n2 = 0;
        while (true) {
            xf_02 = this;
            if (n2 >= xf_02.k) break;
            this.i.add("s" + n2);
            ++n2;
        }
        n2 = 0;
        while (true) {
            xf_02 = this;
            if (n2 >= xf_02.b) break;
            this.i.add("a" + n2);
            ++n2;
        }
        this.i.add("RHS");
    }

    private sy_0 a(boolean bl) {
        double d2;
        tu_0 tu_02;
        Serializable serializable;
        int n2;
        int n3 = this.j + this.k + this.b + this.a() + 1;
        int n4 = this.g.size() + this.a();
        sy_0 sy_02 = new sy_0(n4, n3);
        if (this.a() == 2) {
            ((sv_0)sy_02).c(0, 0, -1.0);
        }
        int n5 = n2 = this.a() == 1 ? 0 : 1;
        ((sv_0)sy_02).c(n5, n5, bl ? 1.0 : -1.0);
        if (bl) {
            serializable = this.f;
            tu_02 = serializable.a.h(-1.0);
        } else {
            serializable = this.f;
            tu_02 = serializable.a;
        }
        tu_0 tu_03 = tu_02;
        serializable = sy_02;
        this.a(tu_03.g(), ((sy_0)serializable).a[n2]);
        if (bl) {
            serializable = this.f;
            d2 = serializable.b;
        } else {
            serializable = this.f;
            d2 = -1.0 * serializable.b;
        }
        ((sv_0)sy_02).c(n2, n3 - 1, d2);
        if (!this.h) {
            ((sv_0)sy_02).c(n2, this.k() - 1, xf_0.a(tu_03));
        }
        bl = false;
        n2 = 0;
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            wW wW2 = this.g.get(i2);
            int n6 = this.a() + i2;
            wW wW3 = wW2;
            serializable = wW3;
            serializable = sy_02;
            this.a(wW3.a.g(), ((sy_0)serializable).a[n6]);
            if (!this.h) {
                serializable = wW2;
                ((sv_0)sy_02).c(n6, this.k() - 1, xf_0.a(((wW)serializable).a));
            }
            serializable = wW2;
            ((sv_0)sy_02).c(n6, n3 - 1, ((wW)serializable).c);
            serializable = wW2;
            if (((wW)serializable).b == xd_0.LEQ) {
                ((sv_0)sy_02).c(n6, this.k() + (int)(bl++ ? 1 : 0), 1.0);
            } else {
                serializable = wW2;
                if (((wW)serializable).b == xd_0.GEQ) {
                    ((sv_0)sy_02).c(n6, this.k() + (int)(bl++ ? 1 : 0), -1.0);
                }
            }
            serializable = wW2;
            if (((wW)serializable).b != xd_0.EQ) {
                serializable = wW2;
                if (((wW)serializable).b != xd_0.GEQ) continue;
            }
            ((sv_0)sy_02).c(0, this.g() + n2, 1.0);
            ((sv_0)sy_02).c(n6, this.g() + n2++, 1.0);
            sy_02.a(0, ((tu_0)((Object)sy_02.d(0))).k((tu_0)((Object)sy_02.d(n6))));
        }
        return sy_02;
    }

    private List<wW> a(Collection<wW> object) {
        ArrayList<wW> arrayList = new ArrayList<wW>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            wW wW2 = (wW)object.next();
            arrayList.add(xf_0.a(wW2));
        }
        return arrayList;
    }

    private static wW a(wW wW2) {
        wW wW3;
        wW wW4 = wW2;
        if (wW3.c < 0.0) {
            wW wW5 = wW2;
            wW4 = wW5;
            wW wW6 = wW2;
            wW4 = wW6;
            wW4 = wW2;
            return new wW(wW5.a.h(-1.0), wW6.b.a(), -1.0 * wW4.c);
        }
        wW wW7 = wW2;
        wW4 = wW7;
        wW wW8 = wW2;
        wW4 = wW8;
        wW4 = wW2;
        return new wW(wW7.a, wW8.b, wW4.c);
    }

    protected final int a() {
        if (this.b > 0) {
            return 2;
        }
        return 1;
    }

    private int a(xd_0 xd_02) {
        int n2 = 0;
        for (wW wW2 : this.g) {
            wW wW3 = wW2;
            wW3 = wW2;
            if (wW2.b != xd_02) continue;
            ++n2;
        }
        return n2;
    }

    private static double a(tu_0 object) {
        double d2 = 0.0;
        double[] dArray = ((tu_0)object).g();
        object = dArray;
        int n2 = dArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = object[i2];
            d2 -= object2;
        }
        return d2;
    }

    protected final Integer a(int n2) {
        if ((n2 = this.n[n2]) == -1) {
            return null;
        }
        return n2;
    }

    protected final int b(int n2) {
        return this.c[n2];
    }

    private void c(int n2) {
        Serializable serializable = this;
        ((xf_0)serializable).n = new int[((tp_0)((xf_0)serializable).a).g() - 1];
        serializable = this;
        ((xf_0)serializable).c = new int[((tp_0)((xf_0)serializable).a).f()];
        Arrays.fill(this.n, -1);
        while (true) {
            serializable = this;
            if (n2 >= ((tp_0)((xf_0)serializable).a).g() - 1) break;
            serializable = this.d(n2);
            if (serializable != null) {
                this.n[n2] = (Integer)serializable;
                this.c[((Integer)serializable).intValue()] = n2;
            }
            ++n2;
        }
    }

    private Integer d(int n2) {
        Integer n3 = null;
        int n4 = 0;
        while (true) {
            xf_0 xf_02 = this;
            if (n4 >= ((tp_0)xf_02.a).f()) break;
            double d2 = this.b(n4, n2);
            if (cq_0.b(d2, 1.0, this.m) && n3 == null) {
                n3 = n4;
            } else if (!cq_0.b(d2, 0.0, this.m)) {
                return null;
            }
            ++n4;
        }
        return n3;
    }

    protected final void b() {
        int n2;
        xf_0 xf_02;
        int n3;
        if (this.a() == 1) {
            return;
        }
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(0);
        for (n3 = this.a(); n3 < this.g(); ++n3) {
            double d2 = this.b(0, n3);
            if (cq_0.a(d2, 0.0, this.l) <= 0) continue;
            treeSet.add(n3);
        }
        n3 = 0;
        while (true) {
            xf_02 = this;
            if (n3 >= xf_02.b) break;
            int n4 = n3 + this.g();
            if (this.a(n4) == null) {
                treeSet.add(n4);
            }
            ++n3;
        }
        xf_0 xf_03 = this;
        xf_02 = xf_03;
        xf_02 = this;
        double[][] dArray = new double[((tp_0)xf_03.a).f() - 1][((tp_0)xf_02.a).g() - treeSet.size()];
        int n5 = 1;
        while (true) {
            xf_02 = this;
            if (n5 >= ((tp_0)xf_02.a).f()) break;
            n2 = 0;
            int n6 = 0;
            while (true) {
                xf_02 = this;
                if (n6 >= ((tp_0)xf_02.a).g()) break;
                if (!treeSet.contains(n6)) {
                    dArray[n5 - 1][n2++] = this.b(n5, n6);
                }
                ++n6;
            }
            ++n5;
        }
        TreeSet<Integer> treeSet2 = treeSet;
        Integer[] integerArray = treeSet2.toArray(new Integer[treeSet2.size()]);
        for (n2 = integerArray.length - 1; n2 >= 0; --n2) {
            this.i.remove(integerArray[n2]);
        }
        this.a = new sy_0(dArray);
        this.b = 0;
        xf_0 xf_04 = this;
        xf_04.c(xf_04.a());
    }

    private void a(double[] dArray, double[] dArray2) {
        System.arraycopy(dArray, 0, dArray2, this.a(), dArray.length);
    }

    final boolean c() {
        double[] dArray = this.e(0);
        xf_0 xf_02 = this;
        xf_0 xf_03 = xf_02;
        xf_03 = xf_02;
        int n2 = ((tp_0)xf_02.a).g() - 1;
        for (int i2 = this.a(); i2 < n2; ++i2) {
            double d2 = dArray[i2];
            if (cq_0.a(d2, 0.0, this.l) >= 0) continue;
            return false;
        }
        return true;
    }

    protected final wQ d() {
        double d2;
        int n2 = this.i.indexOf(d);
        Serializable serializable = n2 > 0 ? this.a(n2) : null;
        if (serializable == null) {
            d2 = 0.0;
        } else {
            xf_0 xf_02 = this;
            xf_0 xf_03 = xf_02;
            xf_03 = xf_02;
            d2 = this.b((Integer)serializable, ((tp_0)xf_02.a).g() - 1);
        }
        double d3 = d2;
        serializable = new HashSet();
        double[] dArray = new double[this.m()];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d4;
            int n3 = this.i.indexOf("x" + i2);
            if (n3 < 0) {
                dArray[i2] = 0.0;
                continue;
            }
            Serializable serializable2 = this.a(n3);
            if (serializable2 != null && serializable2 == 0) {
                dArray[i2] = 0.0;
                continue;
            }
            if (serializable.contains(serializable2)) {
                dArray[i2] = 0.0 - (this.h ? 0.0 : d3);
                continue;
            }
            serializable.add(serializable2);
            if (serializable2 == null) {
                d4 = 0.0;
            } else {
                int n4 = serializable2;
                xf_0 xf_04 = this;
                serializable2 = xf_04;
                serializable2 = xf_04;
                d4 = this.b(n4, ((tp_0)xf_04.a).g() - 1);
            }
            dArray[i2] = d4 - (this.h ? 0.0 : d3);
        }
        return new wQ(dArray, this.f.a(dArray));
    }

    protected final void a(int n2, int n3) {
        xf_0 xf_02;
        double d2;
        double d3 = d2 = this.b(n3, n2);
        int n4 = n3;
        xf_0 xf_03 = this;
        double[] dArray = xf_03.e(n4);
        n4 = 0;
        while (true) {
            xf_02 = xf_03;
            if (n4 >= ((tp_0)xf_02.a).g()) break;
            int n5 = n4++;
            dArray[n5] = dArray[n5] / d3;
        }
        int n6 = 0;
        while (true) {
            double d4;
            xf_02 = this;
            if (n6 >= ((tp_0)xf_02.a).f()) break;
            if (n6 != n3 && (d4 = this.b(n6, n2)) != 0.0) {
                double d5 = d4;
                int n7 = n3;
                n4 = n6;
                xf_03 = this;
                double[] dArray2 = xf_03.e(n4);
                double[] dArray3 = xf_03.e(n7);
                int n8 = 0;
                while (true) {
                    xf_02 = xf_03;
                    if (n8 >= ((tp_0)xf_02.a).g()) break;
                    int n9 = n8;
                    dArray2[n9] = dArray2[n9] - dArray3[n8] * d5;
                    ++n8;
                }
            }
            ++n6;
        }
        n6 = n3;
        xf_02 = this;
        n6 = xf_02.c[n6];
        this.n[n6] = -1;
        this.n[n2] = n3;
        this.c[n3] = n2;
    }

    private void a(int n2, double d2) {
        double[] dArray = this.e(n2);
        int n3 = 0;
        while (true) {
            xf_0 xf_02 = this;
            if (n3 >= ((tp_0)xf_02.a).g()) break;
            int n4 = n3++;
            dArray[n4] = dArray[n4] / d2;
        }
    }

    private void a(int n2, int n3, double d2) {
        double[] dArray = this.e(n2);
        double[] dArray2 = this.e(n3);
        int n4 = 0;
        while (true) {
            xf_0 xf_02 = this;
            if (n4 >= ((tp_0)xf_02.a).g()) break;
            int n5 = n4;
            dArray[n5] = dArray[n5] - dArray2[n4] * d2;
            ++n4;
        }
    }

    protected final int e() {
        return ((tp_0)this.a).g();
    }

    protected final int f() {
        return ((tp_0)this.a).f();
    }

    protected final double b(int n2, int n3) {
        return ((sv_0)this.a).b(n2, n3);
    }

    private void b(int n2, int n3, double d2) {
        ((sv_0)this.a).c(n2, n3, d2);
    }

    private int k() {
        return this.a() + this.j;
    }

    protected final int g() {
        return this.a() + this.j + this.k;
    }

    protected final int h() {
        xf_0 xf_02 = this;
        return ((tp_0)xf_02.a).g() - 1;
    }

    private int l() {
        return this.j;
    }

    private int m() {
        wY wY2 = this.f;
        return wY2.a.f();
    }

    private int n() {
        return this.k;
    }

    protected final int i() {
        return this.b;
    }

    private double[] e(int n2) {
        sy_0 sy_02 = this.a;
        return sy_02.a[n2];
    }

    private double[][] o() {
        sy_0 sy_02 = this.a;
        return sy_02.k();
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof xf_0) {
            xf_0 xf_02;
            xf_02 = xf_02;
            return this.h == xf_02.h && this.j == xf_02.j && this.k == xf_02.k && this.b == xf_02.b && this.l == xf_02.l && this.m == xf_02.m && this.f.equals(xf_02.f) && this.g.equals(xf_02.g) && this.a.equals(xf_02.a);
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.h).hashCode() ^ this.j ^ this.k ^ this.b ^ Double.valueOf(this.l).hashCode() ^ this.m ^ this.f.hashCode() ^ this.g.hashCode() ^ this.a.hashCode();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        td_0.a((tq_0)this.a, objectOutputStream);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        td_0.b(this, "tableau", objectInputStream);
    }
}

