/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.yX;
import org.valkyrienskies.core.impl.shadow.yY;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.zb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.zd
 */
@Deprecated
final class zd_0
implements Serializable {
    private static final String b = "x-";
    private static final int c = 10;
    private static final double d = 1.0E-12;
    private static final long e = -1369660067587938365L;
    private final yY f;
    private final List<yX> g;
    private final boolean h;
    private final List<String> i = new ArrayList<String>();
    private transient tq_0 j;
    private final int k;
    private final int l;
    int a;
    private final double m;
    private final int n;

    private zd_0(yY yY2, Collection<yX> collection, yf_0 yf_02, boolean bl, double d2) {
        this(yY2, collection, yf_02, bl, d2, 10);
    }

    zd_0(yY yY2, Collection<yX> object, yf_0 yf_02, boolean n2, double d2, int n3) {
        double d3;
        tu_0 tu_02;
        int n4;
        Object object2;
        Object object3;
        this.f = yY2;
        Object collection = object;
        object = this;
        ArrayList<yX> arrayList = new ArrayList<yX>(collection.size());
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            yX yX2;
            yX yX3;
            yX serializable2;
            yX n42 = serializable2 = (yX)iterator2.next();
            object3 = n42;
            if (yX3.c < 0.0) {
                zb_0 zb_02;
                object3 = n42;
                tu_0 tu_03 = ((yX)object3).a.h(-1.0);
                object3 = n42;
                object2 = ((yX)object3).b;
                switch (zb_0.1.a[((Enum)object2).ordinal()]) {
                    case 1: {
                        zb_02 = zb_0.GEQ;
                        break;
                    }
                    case 2: {
                        zb_02 = zb_0.LEQ;
                        break;
                    }
                    default: {
                        zb_02 = zb_0.EQ;
                    }
                }
                object3 = n42;
                yX2 = new yX(tu_03, zb_02, -1.0 * ((yX)object3).c);
            } else {
                yX yX4 = n42;
                object3 = yX4;
                yX yX5 = n42;
                object3 = yX5;
                object3 = n42;
                yX2 = new yX(yX4.a, yX5.b, ((yX)object3).c);
            }
            arrayList.add(yX2);
        }
        this.g = arrayList;
        this.h = n2;
        this.m = d2;
        this.n = n3;
        object3 = yY2;
        this.k = ((yY)object3).a.f() + (n2 != 0 ? 0 : 1);
        this.l = this.a(zb_0.LEQ) + this.a(zb_0.GEQ);
        this.a = this.a(zb_0.EQ) + this.a(zb_0.GEQ);
        int n5 = yf_02 == yf_0.MAXIMIZE ? 1 : 0;
        object = this;
        int n6 = ((zd_0)object).k + ((zd_0)object).l + ((zd_0)object).a + ((zd_0)object).a() + 1;
        int n7 = ((zd_0)object).g.size() + ((zd_0)object).a();
        sy_0 sy_02 = new sy_0(n7, n6);
        if (((zd_0)object).a() == 2) {
            ((sv_0)sy_02).c(0, 0, -1.0);
        }
        int n8 = n4 = ((zd_0)object).a() == 1 ? 0 : 1;
        ((sv_0)sy_02).c(n8, n8, n5 != 0 ? 1.0 : -1.0);
        if (n5 != 0) {
            object3 = ((zd_0)object).f;
            tu_02 = ((yY)object3).a.h(-1.0);
        } else {
            object3 = ((zd_0)object).f;
            tu_02 = ((yY)object3).a;
        }
        object2 = tu_02;
        object3 = sy_02;
        super.a(((tu_0)object2).g(), ((sy_0)object3).a[n4]);
        if (n5 != 0) {
            object3 = ((zd_0)object).f;
            d3 = ((yY)object3).b;
        } else {
            object3 = ((zd_0)object).f;
            d3 = -1.0 * ((yY)object3).b;
        }
        ((sv_0)sy_02).c(n4, n6 - 1, d3);
        if (!((zd_0)object).h) {
            ((sv_0)sy_02).c(n4, ((zd_0)object).k() - 1, zd_0.a((tu_0)object2));
        }
        int n9 = 0;
        int n10 = 0;
        for (n2 = 0; n2 < ((zd_0)object).g.size(); ++n2) {
            yX yX7 = ((zd_0)object).g.get(n2);
            int n11 = ((zd_0)object).a() + n2;
            yX yX6 = yX7;
            object3 = yX6;
            object3 = sy_02;
            super.a(yX6.a.g(), ((sy_0)object3).a[n11]);
            if (!((zd_0)object).h) {
                object3 = yX7;
                ((sv_0)sy_02).c(n11, ((zd_0)object).k() - 1, zd_0.a(((yX)object3).a));
            }
            object3 = yX7;
            ((sv_0)sy_02).c(n11, n6 - 1, ((yX)object3).c);
            object3 = yX7;
            if (((yX)object3).b == zb_0.LEQ) {
                ((sv_0)sy_02).c(n11, ((zd_0)object).k() + n9++, 1.0);
            } else {
                object3 = yX7;
                if (((yX)object3).b == zb_0.GEQ) {
                    ((sv_0)sy_02).c(n11, ((zd_0)object).k() + n9++, -1.0);
                }
            }
            object3 = yX7;
            if (((yX)object3).b != zb_0.EQ) {
                object3 = yX7;
                if (((yX)object3).b != zb_0.GEQ) continue;
            }
            ((sv_0)sy_02).c(0, ((zd_0)object).g() + n10, 1.0);
            ((sv_0)sy_02).c(n11, ((zd_0)object).g() + n10++, 1.0);
            sy_02.a(0, ((tu_0)((Object)sy_02.d(0))).k((tu_0)((Object)sy_02.d(n11))));
        }
        ((zd_0)object).j = sy_02;
        object = this;
        if (((zd_0)object).a() == 2) {
            ((zd_0)object).i.add("W");
        }
        ((zd_0)object).i.add("Z");
        for (n5 = 0; n5 < ((zd_0)object).m(); ++n5) {
            ((zd_0)object).i.add("x" + n5);
        }
        if (!((zd_0)object).h) {
            ((zd_0)object).i.add(b);
        }
        n5 = 0;
        while (true) {
            Object object4 = object;
            if (n5 >= ((zd_0)object4).l) break;
            ((zd_0)object).i.add("s" + n5);
            ++n5;
        }
        n5 = 0;
        while (true) {
            object3 = object;
            if (n5 >= ((zd_0)object3).a) break;
            ((zd_0)object).i.add("a" + n5);
            ++n5;
        }
        ((zd_0)object).i.add("RHS");
    }

    private void j() {
        zd_0 zd_02;
        int n2;
        if (this.a() == 2) {
            this.i.add("W");
        }
        this.i.add("Z");
        for (n2 = 0; n2 < this.m(); ++n2) {
            this.i.add("x" + n2);
        }
        if (!this.h) {
            this.i.add(b);
        }
        n2 = 0;
        while (true) {
            zd_02 = this;
            if (n2 >= zd_02.l) break;
            this.i.add("s" + n2);
            ++n2;
        }
        n2 = 0;
        while (true) {
            zd_02 = this;
            if (n2 >= zd_02.a) break;
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
        int n3 = this.k + this.l + this.a + this.a() + 1;
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
            ((sv_0)sy_02).c(n2, this.k() - 1, zd_0.a(tu_03));
        }
        bl = false;
        n2 = 0;
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            yX yX2 = this.g.get(i2);
            int n6 = this.a() + i2;
            yX yX3 = yX2;
            serializable = yX3;
            serializable = sy_02;
            this.a(yX3.a.g(), ((sy_0)serializable).a[n6]);
            if (!this.h) {
                serializable = yX2;
                ((sv_0)sy_02).c(n6, this.k() - 1, zd_0.a(((yX)serializable).a));
            }
            serializable = yX2;
            ((sv_0)sy_02).c(n6, n3 - 1, ((yX)serializable).c);
            serializable = yX2;
            if (((yX)serializable).b == zb_0.LEQ) {
                ((sv_0)sy_02).c(n6, this.k() + (int)(bl++ ? 1 : 0), 1.0);
            } else {
                serializable = yX2;
                if (((yX)serializable).b == zb_0.GEQ) {
                    ((sv_0)sy_02).c(n6, this.k() + (int)(bl++ ? 1 : 0), -1.0);
                }
            }
            serializable = yX2;
            if (((yX)serializable).b != zb_0.EQ) {
                serializable = yX2;
                if (((yX)serializable).b != zb_0.GEQ) continue;
            }
            ((sv_0)sy_02).c(0, this.g() + n2, 1.0);
            ((sv_0)sy_02).c(n6, this.g() + n2++, 1.0);
            sy_02.a(0, ((tu_0)((Object)sy_02.d(0))).k((tu_0)((Object)sy_02.d(n6))));
        }
        return sy_02;
    }

    private List<yX> a(Collection<yX> object) {
        ArrayList<yX> arrayList = new ArrayList<yX>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            yX yX2 = (yX)object.next();
            arrayList.add(zd_0.a(yX2));
        }
        return arrayList;
    }

    private static yX a(yX yX2) {
        yX yX3;
        yX yX4 = yX2;
        if (yX3.c < 0.0) {
            yX yX5 = yX2;
            yX4 = yX5;
            yX yX6 = yX2;
            yX4 = yX6;
            yX4 = yX2;
            return new yX(yX5.a.h(-1.0), yX6.b.a(), -1.0 * yX4.c);
        }
        yX yX7 = yX2;
        yX4 = yX7;
        yX yX8 = yX2;
        yX4 = yX8;
        yX4 = yX2;
        return new yX(yX7.a, yX8.b, yX4.c);
    }

    protected final int a() {
        if (this.a > 0) {
            return 2;
        }
        return 1;
    }

    private int a(zb_0 zb_02) {
        int n2 = 0;
        for (yX yX2 : this.g) {
            yX yX3 = yX2;
            yX3 = yX2;
            if (yX2.b != zb_02) continue;
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
        Integer n3 = null;
        for (int i2 = 0; i2 < this.f(); ++i2) {
            double d2 = this.a(i2, n2);
            if (cq_0.b(d2, 1.0, this.n) && n3 == null) {
                n3 = i2;
                continue;
            }
            if (cq_0.b(d2, 0.0, this.n)) continue;
            return null;
        }
        return n3;
    }

    protected final void b() {
        int n2;
        int n3;
        if (this.a() == 1) {
            return;
        }
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(0);
        for (n3 = this.a(); n3 < this.g(); ++n3) {
            double d2 = this.j.b(0, n3);
            if (cq_0.a(d2, 0.0, this.m) <= 0) continue;
            treeSet.add(n3);
        }
        n3 = 0;
        while (true) {
            zd_0 zd_02 = this;
            if (n3 >= zd_02.a) break;
            int n4 = n3 + this.g();
            if (this.a(n4) == null) {
                treeSet.add(n4);
            }
            ++n3;
        }
        double[][] dArray = new double[this.f() - 1][this.e() - treeSet.size()];
        for (int i2 = 1; i2 < this.f(); ++i2) {
            n2 = 0;
            for (int i3 = 0; i3 < this.e(); ++i3) {
                if (treeSet.contains(i3)) continue;
                dArray[i2 - 1][n2++] = this.j.b(i2, i3);
            }
        }
        TreeSet<Integer> treeSet2 = treeSet;
        Integer[] integerArray = treeSet2.toArray(new Integer[treeSet2.size()]);
        for (n2 = integerArray.length - 1; n2 >= 0; --n2) {
            this.i.remove(integerArray[n2]);
        }
        this.j = new sy_0(dArray);
        this.a = 0;
    }

    private void a(double[] dArray, double[] dArray2) {
        System.arraycopy(dArray, 0, dArray2, this.a(), dArray.length);
    }

    final boolean c() {
        for (int i2 = this.a(); i2 < this.e() - 1; ++i2) {
            double d2 = this.j.b(0, i2);
            if (cq_0.a(d2, 0.0, this.m) >= 0) continue;
            return false;
        }
        return true;
    }

    protected final yp_0 d() {
        double d2;
        int n2 = this.i.indexOf(b);
        Serializable serializable = n2 > 0 ? this.a(n2) : null;
        if (serializable == null) {
            d2 = 0.0;
        } else {
            zd_0 zd_02 = this;
            d2 = this.a(((Integer)serializable).intValue(), zd_02.e() - 1);
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
                serializable2 = this;
                d4 = this.a(n4, ((zd_0)serializable2).e() - 1);
            }
            dArray[i2] = d4 - (this.h ? 0.0 : d3);
        }
        double[] dArray2 = dArray;
        serializable = this.f;
        return new yp_0(dArray2, ((yY)serializable).a.b((tu_0)((Object)new sA(dArray, false))) + ((yY)serializable).b);
    }

    protected final void a(int n2, double d2) {
        for (int i2 = 0; i2 < this.e(); ++i2) {
            this.j.c(n2, i2, this.j.b(n2, i2) / d2);
        }
    }

    protected final void a(int n2, int n3, double d2) {
        for (int i2 = 0; i2 < this.e(); ++i2) {
            double d3;
            double d4 = this.j.b(n2, i2) - this.j.b(n3, i2) * d2;
            if (BY.w(d3) < 1.0E-12) {
                d4 = 0.0;
            }
            this.j.c(n2, i2, d4);
        }
    }

    protected final int e() {
        return this.j.g();
    }

    protected final int f() {
        return this.j.f();
    }

    protected final double a(int n2, int n3) {
        return this.j.b(n2, n3);
    }

    private void b(int n2, int n3, double d2) {
        this.j.c(n2, n3, d2);
    }

    private int k() {
        return this.a() + this.k;
    }

    protected final int g() {
        return this.a() + this.k + this.l;
    }

    protected final int h() {
        return this.e() - 1;
    }

    private int l() {
        return this.k;
    }

    private int m() {
        yY yY2 = this.f;
        return yY2.a.f();
    }

    private int n() {
        return this.l;
    }

    protected final int i() {
        return this.a;
    }

    private double[][] o() {
        return this.j.a();
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof zd_0) {
            zd_0 zd_02;
            zd_02 = zd_02;
            return this.h == zd_02.h && this.k == zd_02.k && this.l == zd_02.l && this.a == zd_02.a && this.m == zd_02.m && this.n == zd_02.n && this.f.equals(zd_02.f) && this.g.equals(zd_02.g) && this.j.equals(zd_02.j);
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.h).hashCode() ^ this.k ^ this.l ^ this.a ^ Double.valueOf(this.m).hashCode() ^ this.n ^ this.f.hashCode() ^ this.g.hashCode() ^ this.j.hashCode();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        td_0.a(this.j, objectOutputStream);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        td_0.b(this, "tableau", objectInputStream);
    }
}

