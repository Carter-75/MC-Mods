/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.sg
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rQ;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.sa_0;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sf_0;
import org.valkyrienskies.core.impl.shadow.sg;
import org.valkyrienskies.core.impl.shadow.sh_0;
import org.valkyrienskies.core.impl.shadow.si_0;
import org.valkyrienskies.core.impl.shadow.sj_0;
import org.valkyrienskies.core.impl.shadow.sk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sg
 */
public final class sg_0
extends rK<sj_0, sj_0>
implements Iterable<double[]> {
    public sg_0(double d2) {
        super(d2);
    }

    private sg_0(double d2, double d3, double d4) {
        rM<sj_0> rM2;
        double d5 = d4;
        double d6 = d2;
        double d7 = d3;
        if (cq_0.b(d6, d7, 0) || d7 - d6 >= Math.PI * 2) {
            rM2 = new rM<sj_0>(Boolean.TRUE);
        } else {
            if (d6 > d7) {
                throw new pm_0(px_0.ENDPOINTS_NOT_AN_INTERVAL, (Number)d6, d7, true);
            }
            double d8 = ci_0.b(d6, Math.PI);
            double d9 = d8 + (d7 - d6);
            sk_0 sk_02 = new sh_0(new si_0(d8), false, d5).c();
            if (d9 <= Math.PI * 2) {
                sk_0 sk_03 = new sh_0(new si_0(d9), true, d5).c();
                rM2 = new rM<sj_0>(sk_02, new rM(Boolean.FALSE), new rM<sj_0>(sk_03, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null), null);
            } else {
                sk_0 sk_04 = new sh_0(new si_0(d9 - Math.PI * 2), true, d5).c();
                rM2 = new rM<sj_0>(sk_02, new rM<sj_0>(sk_04, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null), new rM(Boolean.TRUE), null);
            }
        }
        super(rM2, d4);
    }

    private sg_0(rM<sj_0> rM2, double d2) {
        super(rM2, d2);
        this.j();
    }

    private sg_0(Collection<sb_0<sj_0>> collection, double d2) {
        super(collection, d2);
        this.j();
    }

    private static rM<sj_0> a(double d2, double d3, double d4) {
        if (cq_0.b(d2, d3, 0) || d3 - d2 >= Math.PI * 2) {
            return new rM<sj_0>(Boolean.TRUE);
        }
        if (d2 > d3) {
            throw new pm_0(px_0.ENDPOINTS_NOT_AN_INTERVAL, (Number)d2, d3, true);
        }
        double d5 = ci_0.b(d2, Math.PI);
        double d6 = d5 + (d3 - d2);
        sk_0 sk_02 = new sh_0(new si_0(d5), false, d4).c();
        if (d6 <= Math.PI * 2) {
            sk_0 sk_03 = new sh_0(new si_0(d6), true, d4).c();
            return new rM<sj_0>(sk_02, new rM(Boolean.FALSE), new rM<sj_0>(sk_03, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null), null);
        }
        sk_0 sk_04 = new sh_0(new si_0(d6 - Math.PI * 2), true, d4).c();
        return new rM<sj_0>(sk_02, new rM<sj_0>(sk_04, new rM(Boolean.FALSE), new rM(Boolean.TRUE), null), new rM(Boolean.TRUE), null);
    }

    private void j() {
        Object object = this.a(false);
        rM<sj_0> rM2 = object;
        if (((rM)object).a == null) {
            return;
        }
        rM2 = this.e((rM<sj_0>)object);
        Boolean bl = (Boolean)rM2.e;
        rM2 = this.f((rM<sj_0>)object);
        object = (Boolean)rM2.e;
        if (bl ^ (Boolean)object) {
            throw new a();
        }
    }

    private rM<sj_0> e(rM<sj_0> rM2) {
        rM<sj_0> rM3 = rM2;
        if (rM3.a == null) {
            return rM2;
        }
        rM3 = null;
        while (rM2 != null) {
            rM3 = rM2;
            rM2 = this.j(rM2);
        }
        return this.k(rM3);
    }

    private rM<sj_0> f(rM<sj_0> rM2) {
        rM<sj_0> rM3 = rM2;
        if (rM3.a == null) {
            return rM2;
        }
        rM3 = null;
        while (rM2 != null) {
            rM3 = rM2;
            rM2 = this.i(rM2);
        }
        return this.l(rM3);
    }

    private rM<sj_0> k() {
        rM<sj_0> rM2;
        rM<sj_0> rM3 = rM2 = this.a(false);
        if (rM2.a == null) {
            return null;
        }
        rM3 = this.e(rM2);
        rM2 = rM3.d;
        while (rM2 != null && !this.g(rM2)) {
            rM2 = this.i(rM2);
        }
        return rM2;
    }

    private boolean g(rM<sj_0> rM2) {
        rM<sj_0> rM3 = this.k(rM2);
        if (((Boolean)rM3.e).booleanValue()) {
            return false;
        }
        rM3 = this.l(rM2);
        return (Boolean)rM3.e != false;
    }

    private boolean h(rM<sj_0> rM2) {
        rM<sj_0> rM3 = this.k(rM2);
        if (!((Boolean)rM3.e).booleanValue()) {
            return false;
        }
        rM3 = this.l(rM2);
        return (Boolean)rM3.e == false;
    }

    private rM<sj_0> i(rM<sj_0> rM2) {
        rM<sj_0> rM3 = this.p(rM2);
        if (rM3.a != null) {
            rM3 = this.l(rM2);
            return rM3.d;
        }
        while (this.n(rM2)) {
            rM3 = rM2;
            rM2 = rM3.d;
        }
        rM3 = rM2;
        return rM3.d;
    }

    private rM<sj_0> j(rM<sj_0> rM2) {
        rM<sj_0> rM3 = this.o(rM2);
        if (rM3.a != null) {
            rM3 = this.k(rM2);
            return rM3.d;
        }
        while (this.m(rM2)) {
            rM3 = rM2;
            rM2 = rM3.d;
        }
        rM3 = rM2;
        return rM3.d;
    }

    private rM<sj_0> k(rM<sj_0> rM2) {
        rM2 = this.o(rM2);
        while (true) {
            rM<sj_0> rM3 = rM2;
            if (rM3.a == null) break;
            rM2 = this.p(rM2);
        }
        return rM2;
    }

    private rM<sj_0> l(rM<sj_0> rM2) {
        rM2 = this.p(rM2);
        while (true) {
            rM<sj_0> rM3 = rM2;
            if (rM3.a == null) break;
            rM2 = this.o(rM2);
        }
        return rM2;
    }

    private boolean m(rM<sj_0> rM2) {
        rM<sj_0> rM3 = rM2;
        rM3 = rM3.d;
        if (rM3 == null) {
            return false;
        }
        return rM2 == this.o(rM3);
    }

    private boolean n(rM<sj_0> rM2) {
        rM<sj_0> rM3 = rM2;
        rM3 = rM3.d;
        if (rM3 == null) {
            return false;
        }
        return rM2 == this.p(rM3);
    }

    private rM<sj_0> o(rM<sj_0> rM2) {
        if (sg_0.q(rM2)) {
            return rM2.c;
        }
        return rM2.b;
    }

    private rM<sj_0> p(rM<sj_0> rM2) {
        if (sg_0.q(rM2)) {
            return rM2.b;
        }
        return rM2.c;
    }

    private static boolean q(rM<sj_0> object) {
        object = (sh_0)((rM)object).a.c();
        return ((sh_0)object).b;
    }

    private static double r(rM<sj_0> object) {
        object = (sh_0)((rM)object).a.c();
        object = ((sh_0)object).a;
        return ((si_0)object).b;
    }

    private sg_0 s(rM<sj_0> rM2) {
        return new sg_0(rM2, this.c());
    }

    @Override
    public final void a() {
        rM rM2 = this.a(false);
        if (rM2.a == null) {
            this.c(si_0.a);
            sg_0 sg_02 = this;
            rM2 = sg_02.a(false);
            sg_02.a((Boolean)rM2.e != false ? Math.PI * 2 : 0.0);
            return;
        }
        double d2 = 0.0;
        double d3 = 0.0;
        Object object = this.iterator();
        while (object.hasNext()) {
            double[] dArray = object.next();
            double d4 = dArray[1] - dArray[0];
            d2 += d4;
            d3 += d4 * (dArray[0] + dArray[1]);
        }
        this.a(d2);
        if (cq_0.b(d2, Math.PI * 2, 0)) {
            this.c(si_0.a);
            return;
        }
        if (d2 >= cq_0.b) {
            this.c(new si_0(d3 / (d2 * 2.0)));
            return;
        }
        Object object2 = this.a(false);
        object2 = object = (sh_0)((rM)object2).a.c();
        this.c(((sh_0)object2).a);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final rQ<sj_0> a(qM<sj_0> qM2) {
        si_0 si_02 = (si_0)qM2;
        double d2 = si_02.b;
        boolean bl = false;
        double d3 = Double.NaN;
        double d4 = Double.NaN;
        for (double[] dArray : this) {
            block13: {
                if (Double.isNaN(d3)) {
                    d3 = dArray[0];
                }
                if (!bl) {
                    if (d2 < dArray[0]) {
                        if (Double.isNaN(d4)) {
                            bl = true;
                            break block13;
                        } else {
                            double d5 = d2 - d4;
                            double d6 = dArray[0] - d2;
                            if (d5 < d6) {
                                return new rQ<sj_0>(qM2, new si_0(d4), d5);
                            }
                            return new rQ<sj_0>(qM2, new si_0(dArray[0]), d6);
                        }
                    }
                    if (d2 <= dArray[1]) {
                        double d7 = dArray[0] - d2;
                        double d8 = d2 - dArray[1];
                        if (d7 < d8) {
                            return new rQ<sj_0>(qM2, new si_0(dArray[1]), d8);
                        }
                        return new rQ<sj_0>(qM2, new si_0(dArray[0]), d7);
                    }
                }
            }
            d4 = dArray[1];
        }
        if (Double.isNaN(d4)) {
            return new rQ<sj_0>(qM2, null, Math.PI * 2);
        }
        if (bl) {
            double d9 = d2 - (d4 - Math.PI * 2);
            double d10 = d3 - d2;
            if (d9 < d10) {
                return new rQ<sj_0>(qM2, new si_0(d4), d9);
            }
            return new rQ<sj_0>(qM2, new si_0(d3), d10);
        }
        double d11 = d2 - d4;
        double d12 = d3 + Math.PI * 2 - d2;
        if (d11 < d12) {
            return new rQ<sj_0>(qM2, new si_0(d4), d11);
        }
        return new rQ<sj_0>(qM2, new si_0(d3), d12);
    }

    public final List<sf_0> b() {
        ArrayList<sf_0> arrayList = new ArrayList<sf_0>();
        for (double[] dArray : this) {
            arrayList.add(new sf_0(dArray[0], dArray[1], this.c()));
        }
        return arrayList;
    }

    @Override
    public final Iterator<double[]> iterator() {
        return new c(this);
    }

    @Deprecated
    private int b(sf_0 object) {
        object = this.a((sf_0)object);
        if (((b)object).a != null) {
            if (((b)object).b != null) {
                return sa_0.BOTH$7c70dd6b;
            }
            return sa_0.PLUS$7c70dd6b;
        }
        if (((b)object).b != null) {
            return sa_0.MINUS$7c70dd6b;
        }
        return sa_0.HYPER$7c70dd6b;
    }

    public final b a(sf_0 sf_02) {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();
        sf_0 sf_03 = sf_02;
        double d2 = Math.PI + sf_03.a;
        sf_0 sf_04 = sf_02;
        sf_03 = sf_04;
        sf_03 = sf_02;
        double d3 = sf_04.b - sf_03.a;
        for (double[] dArray : this) {
            double d4;
            double d5;
            sf_03 = sf_02;
            double d6 = ci_0.b(dArray[0], d2) - sf_03.a;
            double d7 = dArray[0] - d6;
            double d8 = dArray[1] - d7;
            if (d6 < d3) {
                arrayList.add(dArray[0]);
                if (d8 > d3) {
                    d5 = d3 + d7;
                    arrayList.add(d5);
                    arrayList2.add(d5);
                    if (d8 > Math.PI * 2) {
                        d4 = d7 + Math.PI * 2;
                        arrayList2.add(d4);
                        arrayList.add(d4);
                        arrayList.add(dArray[1]);
                        continue;
                    }
                    arrayList2.add(dArray[1]);
                    continue;
                }
                arrayList.add(dArray[1]);
                continue;
            }
            arrayList2.add(dArray[0]);
            if (d8 > Math.PI * 2) {
                d5 = d7 + Math.PI * 2;
                arrayList2.add(d5);
                arrayList.add(d5);
                if (d8 > d3 + Math.PI * 2) {
                    d4 = d3 + Math.PI * 2 + d7;
                    arrayList.add(d4);
                    arrayList2.add(d4);
                    arrayList2.add(dArray[1]);
                    continue;
                }
                arrayList.add(dArray[1]);
                continue;
            }
            arrayList2.add(dArray[1]);
        }
        return new b(this.a(arrayList2), this.a(arrayList), 0);
    }

    private void a(rM<sj_0> rM2, double d2, boolean bl) {
        Object object = new sh_0(new si_0(d2), !bl, this.c());
        rM<sj_0> rM3 = object;
        rM3 = rM2 = rM2.a(((sh_0)((Object)rM3)).a, this.c());
        if (rM2.a != null) {
            throw new oY();
        }
        rM2.a((rV<sj_0>)object);
        object = null;
        rM3 = rM2;
        rM2.e = object;
        rM3 = rM2;
        object = Boolean.FALSE;
        rM3 = rM3.b;
        rM3.b.e = object;
        rM3 = rM2;
        object = Boolean.TRUE;
        rM3 = rM3.c;
        rM3.c.e = object;
    }

    private sg_0 a(List<Double> object) {
        int n2;
        if (object.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < object.size(); ++i2) {
            double d2;
            n2 = (i2 + 1) % object.size();
            double d3 = object.get(i2);
            double d4 = ci_0.b(object.get(n2), d3);
            if (!(BY.w(d2 - d3) <= this.c())) continue;
            if (n2 > 0) {
                object.remove(n2);
                object.remove(i2);
                --i2;
                continue;
            }
            Object object2 = object;
            double d5 = (Double)object2.remove(object2.size() - 1);
            double d6 = (Double)object.remove(0);
            if (object.isEmpty()) {
                if (d5 - d6 > Math.PI) {
                    return new sg_0(new rM<sj_0>(Boolean.TRUE), this.c());
                }
                return null;
            }
            Object object3 = object;
            object3.add((Double)object3.remove(0) + Math.PI * 2);
        }
        rM<sj_0> rM2 = new rM<sj_0>(Boolean.FALSE);
        for (n2 = 0; n2 < object.size() - 1; n2 += 2) {
            this.a(rM2, object.get(n2), true);
            this.a(rM2, (Double)object.get(n2 + 1), false);
        }
        object = rM2;
        if (((rM)object).a == null) {
            return null;
        }
        return new sg_0(rM2, this.c());
    }

    @Override
    public final /* synthetic */ rK a(rM rM2) {
        return this.s(rM2);
    }

    @Override
    public final /* synthetic */ rK b(rM rM2) {
        return this.s(rM2);
    }

    static /* synthetic */ rM a(sg_0 sg_02) {
        rM<sj_0> rM2;
        rM<sj_0> rM3 = rM2 = sg_02.a(false);
        if (rM2.a == null) {
            return null;
        }
        rM3 = sg_02.e(rM2);
        rM2 = rM3.d;
        while (rM2 != null && !sg_02.g(rM2)) {
            rM2 = sg_02.i(rM2);
        }
        return rM2;
    }

    static /* synthetic */ rM a(sg_0 sg_02, rM rM2) {
        return sg_02.e(rM2);
    }

    static /* synthetic */ boolean b(sg_0 sg_02, rM rM2) {
        return sg_02.g(rM2);
    }

    static /* synthetic */ rM c(sg_0 sg_02, rM rM2) {
        return sg_02.i(rM2);
    }

    static /* synthetic */ boolean d(sg_0 sg_02, rM rM2) {
        rM<sj_0> rM3 = sg_02.k(rM2);
        if (!((Boolean)rM3.e).booleanValue()) {
            return false;
        }
        rM3 = sg_02.l(rM2);
        return (Boolean)rM3.e == false;
    }

    static /* synthetic */ double e(sg_0 object, rM rM2) {
        rM rM3 = rM2;
        object = rM3;
        object = rM3;
        object = (sh_0)rM3.a.c();
        object = ((sh_0)object).a;
        return ((si_0)object).b;
    }

    static /* synthetic */ rM f(sg_0 sg_02, rM rM2) {
        return sg_02.j(rM2);
    }

    static final class 1 {
    }

    public static final class a
    extends oV {
        private static final long b = 20140107L;

        public a() {
            super(px_0.INCONSISTENT_STATE_AT_2_PI_WRAPPING, new Object[0]);
        }
    }

    public static final class b {
        public final sg_0 a;
        public final sg_0 b;

        private b(sg_0 sg_02, sg_0 sg_03) {
            this.a = sg_02;
            this.b = sg_03;
        }

        public final sg_0 a() {
            return this.a;
        }

        public final sg_0 b() {
            return this.b;
        }

        public final int c() {
            if (this.a != null) {
                if (this.b != null) {
                    return sa_0.BOTH$7c70dd6b;
                }
                return sa_0.PLUS$7c70dd6b;
            }
            if (this.b != null) {
                return sa_0.MINUS$7c70dd6b;
            }
            return sa_0.HYPER$7c70dd6b;
        }

        /* synthetic */ b(sg_0 sg_02, sg_0 sg_03, byte by) {
            this(sg_02, sg_03);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class c
    implements Iterator<double[]> {
        private final rM<sj_0> a;
        private rM<sj_0> b;
        private double[] c;
        private /* synthetic */ sg_0 d;

        c(sg_0 object) {
            this.d = object;
            this.a = sg.a((sg_0)object);
            this.b = this.a;
            if (this.a == null) {
                sg_0 sg_02 = object;
                object = sg.a((sg_0)sg_02, sg_02.a(false));
                if (((Boolean)((rM)object).e).booleanValue()) {
                    this.c = new double[]{0.0, Math.PI * 2};
                    return;
                }
                this.c = null;
                return;
            }
            this.a();
        }

        private void a() {
            rM rM2 = this.b;
            while (rM2 != null && !sg.b((sg_0)this.d, rM2)) {
                rM2 = sg.c((sg_0)this.d, rM2);
            }
            if (rM2 == null) {
                this.b = null;
                this.c = null;
                return;
            }
            rM rM3 = rM2;
            while (rM3 != null && !sg.d((sg_0)this.d, (rM)rM3)) {
                rM3 = sg.c((sg_0)this.d, rM3);
            }
            if (rM3 != null) {
                this.c = new double[]{sg.e((sg_0)this.d, (rM)rM2), sg.e((sg_0)this.d, (rM)rM3)};
                this.b = rM3;
                return;
            }
            rM3 = this.a;
            while (rM3 != null && !sg.d((sg_0)this.d, (rM)rM3)) {
                rM3 = sg.f((sg_0)this.d, (rM)rM3);
            }
            if (rM3 == null) {
                throw new oY();
            }
            this.c = new double[]{sg.e((sg_0)this.d, (rM)rM2), sg.e((sg_0)this.d, (rM)rM3) + Math.PI * 2};
            this.b = null;
        }

        @Override
        public final boolean hasNext() {
            return this.c != null;
        }

        private double[] b() {
            if (this.c == null) {
                throw new NoSuchElementException();
            }
            double[] dArray = this.c;
            this.a();
            return dArray;
        }

        @Override
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final /* synthetic */ Object next() {
            c c2 = this;
            if (c2.c == null) {
                throw new NoSuchElementException();
            }
            double[] dArray = c2.c;
            c2.a();
            return dArray;
        }
    }
}

