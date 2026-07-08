/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cc_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.nB;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uH;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.uN;
import org.valkyrienskies.core.impl.shadow.uO;
import org.valkyrienskies.core.impl.shadow.uS;
import org.valkyrienskies.core.impl.shadow.vf_0;
import org.valkyrienskies.core.impl.shadow.vj_0;
import org.valkyrienskies.core.impl.shadow.vk_0;
import org.valkyrienskies.core.impl.shadow.wr_0;
import org.valkyrienskies.core.impl.shadow.wv_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.uz
 */
public abstract class uz_0<T extends kO<T>>
implements uO<T> {
    private static final double d = 1.0E-14;
    private static final double e = 1.0E-15;
    private Collection<wv_0<T>> f;
    uJ<T> a;
    T b;
    private boolean g;
    private boolean h;
    public final kM<T> c;
    private Collection<vk_0<T>> i;
    private boolean j;
    private final String k;
    private cc_0.a l;
    private transient uH<T> m;

    public uz_0(kM<T> kM2, String string) {
        this.c = kM2;
        this.k = string;
        this.f = new ArrayList<wv_0<T>>();
        this.a = null;
        this.b = null;
        this.i = new ArrayList<vk_0<T>>();
        this.j = false;
        this.l = cc_0.a.a().b(Integer.MAX_VALUE);
    }

    public final kM<T> a() {
        return this.c;
    }

    @Override
    public final String b() {
        return this.k;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final void a(uS.a a2) {
        this.f.add(a2);
    }

    @Override
    public final Collection<wv_0<T>> c() {
        return Collections.unmodifiableCollection(this.f);
    }

    @Override
    public final void d() {
        this.f.clear();
    }

    @Override
    public final void a(vj_0<T> object, double d2, double d3, int n2) {
        nB<kO> nB2 = new nB<kO>((kO)((kO)this.c.a()).a(1.0E-14), (kO)((kO)this.c.a()).a(d3), (kO)((kO)this.c.a()).a(1.0E-15), 5);
        int n3 = n2;
        double d4 = d3;
        double d5 = d2;
        vj_0<T> vj_02 = object;
        object = this;
        ((uz_0)object).i.add(new vk_0<kO>(vj_02, d5, (kO)((kO)((uz_0)object).c.a()).a(d4), n3, nB2));
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final void a(vj_0 vj_02, double d2, double d3, int n2, nB nB2) {
        this.i.add(new vk_0<kO>(vj_02, d2, (kO)((kO)this.c.a()).a(d3), n2, nB2));
    }

    @Override
    public final Collection<vj_0<T>> e() {
        ArrayList arrayList = new ArrayList(this.i.size());
        for (vk_0<T> vk_02 : this.i) {
            arrayList.add(vk_02.a);
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    @Override
    public final void f() {
        this.i.clear();
    }

    @Override
    public final uJ<T> g() {
        return this.a;
    }

    @Override
    public final T h() {
        return this.b;
    }

    @Override
    public final void a(int n2) {
        this.l = this.l.b(n2 < 0 ? Integer.MAX_VALUE : n2);
    }

    @Override
    public final int i() {
        cc_0.a a2 = this.l;
        return a2.b;
    }

    @Override
    public final int j() {
        cc_0.a a2 = this.l;
        return a2.e;
    }

    /*
     * WARNING - void declaration
     */
    protected final uJ<T> a(uH<T> object, T object2, T[] object32, T t) {
        Object object3;
        void var4_8;
        this.m = object;
        this.l = this.l.a(0);
        Object object4 = object;
        object = var4_8;
        object = object32;
        Object object5 = object2;
        object5 = object4;
        int n2 = 0;
        ((uH)object5).c.a(0, (kO[])object);
        uN cfr_ignored_0 = ((uH)object5).a;
        while (true) {
            object3 = ((uH)object5).c;
            if (++n2 >= ((uG)object3).a.length - 1) break;
            ((uH)object5).c.a(n2, (kO[])object);
            ((uH)object5).b.get(n2 - 1);
        }
        object = this.a((kO)object2, (kO[])object32);
        object = new uJ((kO)object2, (kO[])object32, (kO[])object);
        for (vk_0 vk_02 : this.i) {
            object3 = vk_02;
            vj_0 cfr_ignored_1 = vk_02.a;
        }
        for (wv_0 wv_02 : this.f) {
            wv_02.a(object, var4_8);
        }
        boolean bl = false;
        uz_0 uz_02 = this;
        this.j = false;
        return object;
    }

    private uH<T> s() {
        return this.m;
    }

    protected final cc_0.a k() {
        return this.l;
    }

    public final T[] a(T t, T[] TArray) {
        cc_0.a a2 = this.l;
        a2.d(1);
        return this.m.a((kO)t, (kO[])TArray);
    }

    private void b(boolean bl) {
        this.j = false;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    protected final uJ<T> a(wr_0<T> var1_1, T var2_2) {
        var12_3 = var1_1;
        var3_4 = var12_3.a;
        var9_5 = var1_1;
        var4_6 = var9_5.b;
        if (!this.j) {
            for (Object var6_12 : this.i) {
                var10_14 = var1_1;
                var9_5 = var6_12;
                var11_15 /* !! */  = var10_14.c();
                var12_3 = var11_15 /* !! */ ;
                var9_5.c = var12_3.a;
                var9_5.d = var9_5.a.b();
                if (var9_5.d.d() == 0.0) {
                    var19_10 = BY.e(var9_5.i.c().d(), BY.w(((kO)var9_5.i.d().c(var9_5.c)).d()));
                    var6_12 = (kO)var9_5.c.a((double)(var19_10 * 0.5));
                    v0 = var9_5.a;
                    var10_14.a(var6_12);
                    var9_5.d = v0.b();
                }
                var9_5.e = v1.d.d() >= 0.0;
            }
            this.j = true;
        }
        var12_3 = var1_1;
        var5_8 = var12_3.c != false ? 1 : -1;
        var6_12 = new TreeSet<E>(new Comparator<vk_0<T>>(this, var5_8){
            private /* synthetic */ int a;
            private /* synthetic */ uz_0 b;
            {
                this.b = uz_02;
                this.a = n2;
            }

            private int a(vk_0<T> vk_02, vk_0<T> vk_03) {
                return this.a * Double.compare(vk_02.b().d(), vk_03.b().d());
            }

            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                vk_0 vk_02 = (vk_0)object2;
                object2 = (vk_0)object;
                object = this;
                return object.a * Double.compare(((vk_0)object2).b().d(), vk_02.b().d());
            }
        });
        for (Object var7_16 : this.i) {
            if (!var7_16.b((wr_0)var1_1)) continue;
            var6_12.add(var7_16);
        }
        var5_9 /* !! */  = var1_1;
        while (!var6_12.isEmpty()) {
            var7_16 = var6_12.iterator();
            var1_1 = (vk_0)var7_16.next();
            var7_16.remove();
            var7_16 = var5_9 /* !! */ .a((wv_0<wv_0<T>>)var1_1.b());
            var5_9 /* !! */  = var5_9 /* !! */ .a((uJ<wv_0<wv_0<T>>>)var3_4, (uJ<wv_0<wv_0<T>>>)var7_16);
            for (Iterator<vk_0<T>> var8_17 : this.i) {
                var8_17.a(var7_16);
                this.g = this.g != false || var8_17.c() != false;
            }
            for (Iterator<vk_0<T>> var8_17 : this.f) {
                var8_17.a(var5_9 /* !! */ , this.g);
            }
            if (this.g) {
                return var7_16;
            }
            this.h = false;
            var8_17 = this.i.iterator();
            while (var8_17.hasNext()) {
                var3_4 = var8_17.next();
                var10_14 = var7_16;
                var9_5 = var3_4;
                if (!var3_4.f) ** GOTO lbl-1000
                var12_3 = var10_14;
                if (!(((kO)((kO)((kO)var9_5.g.b(var12_3.a)).e()).b(var9_5.b)).d() <= 0.0)) lbl-1000:
                // 2 sources

                {
                    v2 = null;
                } else {
                    var11_15 /* !! */  = var9_5.h == vf_0.RESET_STATE$3522afc3 ? var9_5.a.d() : (var9_5.h == vf_0.RESET_DERIVATIVES$3522afc3 ? var10_14 : null);
                    var9_5.f = false;
                    var9_5.g = null;
                    v2 = var3_4 = var11_15 /* !! */ ;
                }
                if (v2 == null) continue;
                var12_3 = this.m;
                var1_1 = var12_3.c.a((uI)var3_4);
                var12_3 = var3_4;
                var2_2 /* !! */  = this.a((kO)var3_4.a, var1_1);
                this.h = true;
                v3 = this.m;
                var12_3 = v3;
                var12_3 = var3_4;
                var19_11 /* !! */  = var2_2 /* !! */ ;
                var11_15 /* !! */  = var1_1;
                var10_14 = var3_4.a;
                var9_5 = v3.c;
                if (var11_15 /* !! */ .length != var9_5.b()) {
                    throw new oS(var11_15 /* !! */ .length, var9_5.b());
                }
                if (((T)var19_11 /* !! */ ).length != var9_5.b()) {
                    throw new oS(((T)var19_11 /* !! */ ).length, var9_5.b());
                }
                var12_3 = var9_5;
                var20_18 = var12_3.a.length - 1;
                var6_13 = 0;
                var1_1 = var9_5.a(0, var11_15 /* !! */ );
                var2_2 /* !! */  = var9_5.a(0, (kO[])var19_11 /* !! */ );
                if (var20_18 < 2) {
                    return new uJ((kO)var10_14, var1_1, var2_2 /* !! */ );
                }
                var3_4 = (kO[][])ch_0.a(var10_14.c(), var20_18 - 1, -1);
                var4_6 = (kO[][])ch_0.a(var10_14.c(), var20_18 - 1, -1);
                while (true) {
                    var12_3 = var9_5;
                    if (++var6_13 >= var12_3.a.length - 1) break;
                    var3_4[var6_13 - 1] = var9_5.a(var6_13, var11_15 /* !! */ );
                    var4_6[var6_13 - 1] = var9_5.a(var6_13, (kO[])var19_11 /* !! */ );
                }
                return new uJ((kO)var10_14, var1_1, var2_2 /* !! */ , var3_4, var4_6);
            }
            var3_4 = var7_16;
            if (!var1_1.b(var5_9 /* !! */  = var5_9 /* !! */ .a((uJ<wv_0<wv_0<T>>>)var7_16, (uJ<wv_0<wv_0<T>>>)var4_6))) continue;
            var6_12.add(var1_1);
        }
        for (kO[] var1_1 : this.i) {
            var1_1.a(var4_6);
            this.g = this.g != false || var1_1.c() != false;
        }
        if (this.g) ** GOTO lbl-1000
        var12_3 = var4_6;
        if (((kO)((kO)var4_6.a.b(var2_2 /* !! */ )).e()).d() <= BY.x(var2_2 /* !! */ .d())) lbl-1000:
        // 2 sources

        {
            v4 = true;
        } else {
            v4 = false;
        }
        this.g = v4;
        for (kO[] var1_1 : this.f) {
            var1_1.a(var5_9 /* !! */ , this.g);
        }
        return var4_6;
    }

    public void a(uI<T> uI2, T t) {
        double d2;
        uI<T> uI3 = uI2;
        double d3 = 1000.0 * BY.x(BY.e(BY.w(uI3.a.d()), BY.w(t.d())));
        uI3 = uI2;
        double d4 = ((kO)((kO)uI3.a.b(t)).e()).d();
        if (d2 <= d3) {
            throw new pn_0((pw_0)px_0.TOO_SMALL_INTEGRATION_INTERVAL, (Number)d4, d3, false);
        }
    }

    protected final boolean l() {
        return this.h;
    }

    protected final void a(T t) {
        this.b = t;
    }

    protected final T m() {
        return this.b;
    }

    protected final void a(uJ<T> uJ2) {
        this.a = uJ2;
    }

    protected final uJ<T> n() {
        return this.a;
    }

    protected final void a(boolean bl) {
        this.g = false;
    }

    protected final boolean o() {
        return this.g;
    }
}

