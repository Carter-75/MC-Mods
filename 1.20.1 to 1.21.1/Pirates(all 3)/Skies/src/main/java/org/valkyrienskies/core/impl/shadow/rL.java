/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rO;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rX;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rZ;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sc_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class rL<S extends qN, T extends qN>
implements sb_0<S> {
    public final rV<S> a;
    public final rY<T> b;

    public rL(rV<S> rV2, rY<T> rY2) {
        this.a = rV2;
        this.b = rY2;
    }

    protected abstract rL<S, T> a(rV<S> var1, rY<T> var2);

    private rL<S, T> f() {
        rL rL2 = this;
        return rL2.a(rL2.a.g(), this.b);
    }

    @Override
    public final rV<S> c() {
        return this.a;
    }

    public final rY<T> d() {
        return this.b;
    }

    @Override
    public double a() {
        return this.b.g();
    }

    private rL<S, T> b(sb_0<S> rL2) {
        rL2 = rL2;
        rL rL3 = this;
        return rL3.a(rL3.a, new rZ<T>().a(this.b, rL2.b));
    }

    public final rL<S, T> a(sc_0<S, T> object) {
        rV<S> rV2 = object.a(this.a);
        HashMap<rM<T>, rM<T>> hashMap = new HashMap<rM<T>, rM<T>>();
        rL rL2 = this;
        object = rL2.a(rL2.b.a(false), rV2, (sc_0<S, T>)((Object)object), (Map<rM<T>, rM<T>>)hashMap);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object object2 = (rM)entry.getKey();
            if (((rM)object2).a == null) continue;
            object2 = (rM)entry.getKey();
            rO rO2 = (rO)((rM)object2).e;
            if (rO2 == null) continue;
            object2 = (rM)entry.getValue();
            rO rO3 = (rO)((rM)object2).e;
            object2 = rO2;
            for (rM rM2 : ((rO)object2).c) {
                object2 = rO3;
                ((rO)object2).c.a((rM)hashMap.get(rM2));
            }
        }
        return this.a(rV2, this.b.b(object));
    }

    private rM<T> a(rM<T> rM2, rV<S> rM3, sc_0<S, T> sc_02, Map<rM<T>, rM<T>> map2) {
        rM<T> rM4 = rM2;
        if (rM4.a == null) {
            rM4 = rM2;
            rM3 = new rM(rM4.e);
        } else {
            rM4 = rM2;
            rO<T> rO2 = (rO<T>)rM4.e;
            if (rO2 != null) {
                sb_0<T> sb_02;
                sb_0<T> sb_03;
                rM4 = rO2;
                if (((rO)((Object)rM4)).a == null) {
                    sb_03 = null;
                } else {
                    rM4 = rO2;
                    sb_03 = sc_02.a(((rO)((Object)rM4)).a, this.a, (rV<S>)((Object)rM3));
                }
                sb_0<T> sb_04 = sb_03;
                rM4 = rO2;
                if (((rO)((Object)rM4)).b == null) {
                    sb_02 = null;
                } else {
                    rM4 = rO2;
                    sb_02 = sc_02.a(((rO)((Object)rM4)).b, this.a, (rV<S>)((Object)rM3));
                }
                rO2 = sb_02;
                rO2 = new rO<T>(sb_04, rO2, new rX());
            }
            rM<T> rM5 = rM2;
            rM4 = rM5;
            rM<T> rM6 = rM2;
            rM4 = rM6;
            rM4 = rM2;
            rM3 = new rM<T>(sc_02.a(rM5.a, this.a, (rV<S>)((Object)rM3)), this.a(rM6.b, (rV<S>)((Object)rM3), sc_02, map2), this.a(rM4.c, (rV<S>)((Object)rM3), sc_02, map2), rO2);
        }
        map2.put(rM2, rM3);
        return rM3;
    }

    @Override
    @Deprecated
    public final int b(rV<S> rV2) {
        return this.a(rV2).c();
    }

    @Override
    public abstract sb_0.a<S> a(rV<S> var1);

    @Override
    public boolean b() {
        return this.b.d();
    }

    public final /* synthetic */ rL a(sb_0 sb_02) {
        sb_0 sb_03 = sb_02;
        sb_02 = this;
        sb_03 = (rL)sb_03;
        sb_0 sb_04 = sb_02;
        return ((rL)sb_04).a(((rL)sb_04).a, new rZ<T>().a(((rL)sb_02).b, ((rL)sb_03).b));
    }

    public final /* synthetic */ rL e() {
        rL rL2 = this;
        return rL2.a(rL2.a.g(), rL2.b);
    }
}

