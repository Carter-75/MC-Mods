/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.cc_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.nO;
import org.valkyrienskies.core.impl.shadow.ny_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.uM;
import org.valkyrienskies.core.impl.shadow.uP;
import org.valkyrienskies.core.impl.shadow.uT;
import org.valkyrienskies.core.impl.shadow.vh_0;
import org.valkyrienskies.core.impl.shadow.vi_0;
import org.valkyrienskies.core.impl.shadow.wA;
import org.valkyrienskies.core.impl.shadow.wB;
import org.valkyrienskies.core.impl.shadow.ws_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class uA
implements uP {
    private Collection<wA> f;
    protected double a;
    protected double b;
    protected boolean c;
    protected boolean d;
    private Collection<vi_0> g;
    private boolean h;
    private final String i;
    private cc_0.a j;
    transient uF e;

    public uA(String string) {
        this.i = string;
        this.f = new ArrayList<wA>();
        this.a = Double.NaN;
        this.b = Double.NaN;
        this.g = new ArrayList<vi_0>();
        this.h = false;
        this.j = cc_0.a.a().b(Integer.MAX_VALUE);
    }

    protected uA() {
        this(null);
    }

    @Override
    public final String a() {
        return this.i;
    }

    @Override
    public void a(wA wA2) {
        this.f.add(wA2);
    }

    @Override
    public final Collection<wA> b() {
        return Collections.unmodifiableCollection(this.f);
    }

    @Override
    public final void c() {
        this.f.clear();
    }

    @Override
    public final void a(vh_0 vh_02, double d2, double d3, int n2) {
        this.a(vh_02, d2, d3, n2, new ny_0(d3, 5));
    }

    @Override
    public void a(vh_0 vh_02, double d2, double d3, int n2, nO nO2) {
        this.g.add(new vi_0(vh_02, d2, d3, n2, nO2));
    }

    @Override
    public final Collection<vh_0> d() {
        ArrayList<vh_0> arrayList = new ArrayList<vh_0>(this.g.size());
        for (vi_0 vi_02 : this.g) {
            arrayList.add(vi_02.a);
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    @Override
    public final void e() {
        this.g.clear();
    }

    @Override
    public double f() {
        return this.a;
    }

    @Override
    public final double g() {
        return this.b;
    }

    @Override
    public final void a(int n2) {
        this.j = this.j.b(n2 < 0 ? Integer.MAX_VALUE : n2);
    }

    @Override
    public final int h() {
        cc_0.a a2 = this.j;
        return a2.b;
    }

    @Override
    public final int i() {
        cc_0.a a2 = this.j;
        return a2.e;
    }

    protected final void a(double d2, double[] dArray, double d3) {
        Object object;
        this.j = this.j.a(0);
        for (vi_0 vi_02 : this.g) {
            uF uF2 = this.e;
            object = vi_02;
            vi_02.c = uF2;
            vi_0 object2 = vi_02;
            object2.a.a(d2, dArray, d3);
        }
        for (wA wA2 : this.f) {
            wA2.a(d2, dArray, d3);
        }
        boolean bl = false;
        object = this;
        this.h = false;
    }

    protected final void a(uF uF2) {
        this.e = uF2;
    }

    protected final uF j() {
        return this.e;
    }

    @Deprecated
    private cb_0 l() {
        return cb_0.a(this.j);
    }

    protected final cc_0.a k() {
        return this.j;
    }

    @Override
    public final double a(uT.1 object, double d2, double[] dArray, double d3, double[] dArray2) {
        if (dArray.length != object.a()) {
            throw new oS(dArray.length, object.a());
        }
        if (dArray2.length != object.a()) {
            throw new oS(dArray2.length, object.a());
        }
        object = new uF((uM)object);
        double d4 = d2;
        Object object2 = object;
        ((uF)object).c = d4;
        double[] dArray3 = dArray;
        object2 = object;
        if (dArray3.length != ((uF)object2).d.length) {
            throw new oS(dArray3.length, ((uF)object2).d.length);
        }
        System.arraycopy(dArray3, 0, ((uF)object2).d, 0, dArray3.length);
        this.a((uF)object, d3);
        System.arraycopy(((uF)object).f(), 0, dArray2, 0, dArray2.length);
        object2 = object;
        return ((uF)object2).c;
    }

    public abstract void a(uF var1, double var2);

    public final void a(double d2, double[] dArray, double[] dArray2) {
        cc_0.a a2 = this.j;
        a2.d(1);
        this.e.a(d2, dArray, dArray2);
    }

    private void a(boolean bl) {
        this.h = false;
    }

    protected final double a(ws_0 ws_02, double[] dArray, double[] dArray2, double d2) {
        Object object2 = ws_02;
        double d3 = ((ws_0)object2).i;
        object2 = ws_02;
        double d4 = ((ws_0)object2).j;
        if (!this.h) {
            for (vi_0 object3 : this.g) {
                Object object;
                ws_0 d9 = ws_02;
                object2 = object3;
                object3.d = d9.g();
                d9.d(((vi_0)object2).d);
                ((vi_0)object2).e = ((vi_0)object2).a.a(((vi_0)object2).d, ((vi_0)object2).a((wB)d9));
                if (((vi_0)object2).e == 0.0) {
                    double d5 = BY.e(((vi_0)object2).j.g(), BY.w(((vi_0)object2).j.h() * ((vi_0)object2).d));
                    double d6 = ((vi_0)object2).d + d5 * 0.5;
                    d9.d(d6);
                    ((vi_0)object2).e = ((vi_0)object2).a.a(d6, ((vi_0)object2).a((wB)d9));
                }
                ((vi_0)object2).f = ((vi_0)object).e >= 0.0;
            }
            this.h = true;
        }
        object2 = ws_02;
        int n2 = ((ws_0)object2).m ? 1 : -1;
        TreeSet<vi_0> treeSet = new TreeSet<vi_0>(new Comparator<vi_0>(this, n2){
            private /* synthetic */ int a;
            private /* synthetic */ uA b;
            {
                this.b = uA2;
                this.a = n2;
            }

            private int a(vi_0 vi_02, vi_0 vi_03) {
                return this.a * Double.compare(vi_02.b(), vi_03.b());
            }

            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                vi_0 vi_02 = (vi_0)object2;
                object2 = (vi_0)object;
                object = this;
                return object.a * Double.compare(((vi_0)object2).b(), vi_02.b());
            }
        });
        for (vi_0 n4 : this.g) {
            if (!n4.b(ws_02)) continue;
            treeSet.add(n4);
        }
        while (!treeSet.isEmpty()) {
            boolean bl;
            vi_0 n4;
            uE[] uEArray = treeSet.iterator();
            n4 = (vi_0)uEArray.next();
            uEArray.remove();
            double d7 = n4.b();
            double d8 = d3;
            object2 = ws_02;
            ws_02.k = d8;
            d8 = d7;
            object2 = ws_02;
            ws_02.l = d8;
            ws_02.d(d7);
            double[] dArray3 = new double[dArray.length];
            object2 = this.e;
            ((uF)object2).b.b(ws_02.k(), dArray3);
            int n3 = 0;
            for (uE uE2 : this.e.d()) {
                uE2.b(ws_02.a(n3++), dArray3);
            }
            for (vi_0 vi_03 : this.g) {
                vi_03.a(d7, dArray3);
                this.c = this.c || vi_03.c();
            }
            for (wA wA2 : this.f) {
                wA2.a(ws_02, this.c);
            }
            if (this.c) {
                System.arraycopy(dArray3, 0, dArray, 0, dArray.length);
                return d7;
            }
            this.d = false;
            double[] dArray4 = dArray3;
            double d9 = d7;
            object2 = n4;
            if (!((vi_0)object2).g || !(BY.w(((vi_0)object2).h - d9) <= ((vi_0)object2).b)) {
                bl = false;
            } else {
                boolean bl2;
                if (((vi_0)object2).i == vh_0.a.RESET_STATE$534a8113) {
                    vh_0 cfr_ignored_0 = ((vi_0)object2).a;
                }
                ((vi_0)object2).g = false;
                ((vi_0)object2).h = Double.NaN;
                bl = bl2 = ((vi_0)object2).i == vh_0.a.RESET_STATE$534a8113 || ((vi_0)object2).i == vh_0.a.RESET_DERIVATIVES$534a8113;
            }
            if (bl) {
                ws_02.d(d7);
                System.arraycopy(dArray3, 0, dArray, 0, dArray.length);
                this.a(d7, dArray, dArray2);
                this.d = true;
                return d7;
            }
            d3 = d7;
            d8 = d7;
            object2 = ws_02;
            ws_02.k = d8;
            d8 = d4;
            object2 = ws_02;
            ws_02.l = d8;
            if (!n4.b(ws_02)) continue;
            treeSet.add(n4);
        }
        ws_02.d(d4);
        double[] dArray5 = new double[dArray.length];
        object2 = this.e;
        ((uF)object2).b.b(ws_02.k(), dArray5);
        int n4 = 0;
        for (uE uE3 : this.e.d()) {
            uE3.b(ws_02.a(n4++), dArray5);
        }
        for (vi_0 wA3 : this.g) {
            wA3.a(d4, dArray5);
            this.c = this.c || wA3.c();
        }
        this.c = this.c || cq_0.b(d4, d2, 1);
        for (wA wA2 : this.f) {
            wA2.a(ws_02, this.c);
        }
        return d4;
    }

    public void b(uF uF2, double d2) {
        double d3;
        uF uF3 = uF2;
        double d4 = 1000.0 * BY.x(BY.e(BY.w(uF3.c), BY.w(d2)));
        uF3 = uF2;
        double d5 = BY.w(uF3.c - d2);
        if (d3 <= d4) {
            throw new pn_0((pw_0)px_0.TOO_SMALL_INTEGRATION_INTERVAL, (Number)d5, d4, false);
        }
    }
}

