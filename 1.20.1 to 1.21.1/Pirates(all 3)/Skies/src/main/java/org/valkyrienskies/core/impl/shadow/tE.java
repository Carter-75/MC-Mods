/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Cn
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.Cn;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cn_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sT;
import org.valkyrienskies.core.impl.shadow.sU;
import org.valkyrienskies.core.impl.shadow.sV;
import org.valkyrienskies.core.impl.shadow.su_0;
import org.valkyrienskies.core.impl.shadow.tD;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class tE<T extends kN<T>>
implements Serializable,
sT<T> {
    private static final long a = 7841233292190413362L;
    private final kM<T> b;
    private final cn_0<T> c;
    private final int d;

    private tE(kM<T> kM2) {
        this(kM2, 0);
    }

    private tE(kM<T> kM2, int n2) {
        this.b = kM2;
        this.d = n2;
        this.c = new Cn(kM2);
    }

    private tE(tE<T> tE2, int n2) {
        this.b = tE2.b;
        tE<T> tE3 = tE2;
        this.d = tE3.d + n2;
        this.c = new Cn(tE2.c);
    }

    private tE(kM<T> kM2, int n2, int n3) {
        this.b = kM2;
        this.d = n2;
        this.c = new Cn(kM2, n3);
    }

    private tE(kM<T> kM2, T[] TArray) {
        ci_0.a(TArray);
        this.b = kM2;
        this.d = TArray.length;
        this.c = new Cn(kM2);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            T t = TArray[i2];
            this.c.a(i2, (kN)t);
        }
    }

    private tE(tE<T> tE2) {
        this.b = tE2.b;
        tE<T> tE3 = tE2;
        this.d = tE3.d;
        tE3 = tE2;
        this.c = new Cn(tE3.c);
    }

    private cn_0<T> f() {
        return this.c;
    }

    @Override
    private sT<T> a(tE<T> object) {
        tE<T> tE2 = object;
        this.c(tE2.d);
        tE tE3 = (tE)this.b();
        tE2 = object;
        object = tE2.c.a();
        while (((cn_0.a)object).a()) {
            ((cn_0.a)object).d();
            int n2 = ((cn_0.a)object).b();
            Object t = ((cn_0.a)object).c();
            if (this.c.b(n2)) {
                tE3.a(n2, (kN)this.c.a(n2).a(t));
                continue;
            }
            tE3.a(n2, t);
        }
        return tE3;
    }

    @Override
    private sT<T> b(tE<T> object) {
        tE tE2 = object;
        tE2 = new tE<T>(this, tE2.d);
        object = ((tE)object).c.a();
        while (((cn_0.a)object).a()) {
            ((cn_0.a)object).d();
            tE2.a(((cn_0.a)object).b() + this.d, ((cn_0.a)object).c());
        }
        return tE2;
    }

    @Override
    public final sT<T> h(sT<T> sT2) {
        if (sT2 instanceof tE) {
            return this.b((tE)sT2);
        }
        int n2 = sT2.g();
        tE<T> tE2 = new tE<T>(this, n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            tE2.a(i2 + this.d, sT2.a(i2));
        }
        return tE2;
    }

    @Override
    public final sT<T> i(T t) {
        ci_0.a(t);
        tE<T> tE2 = new tE<T>(this, 1);
        tE2.a(this.d, t);
        return tE2;
    }

    @Override
    public final sT<T> b() {
        return new tE<T>(this);
    }

    @Override
    public final T e(sT<T> sT2) {
        this.c(sT2.g());
        kN kN2 = (kN)this.b.a();
        cn_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            kN2 = (kN)kN2.a(sT2.a(a2.b()).c(a2.c()));
        }
        return (T)kN2;
    }

    @Override
    public final sT<T> d(sT<T> sT2) {
        this.c(sT2.g());
        tE<kN> tE2 = new tE<kN>(this);
        cn_0.a a2 = tE2.c.a();
        while (a2.a()) {
            a2.d();
            tE2.a(a2.b(), (kN)a2.c().d(sT2.a(a2.b())));
        }
        return tE2;
    }

    @Override
    public final sT<T> c(sT<T> sT2) {
        this.c(sT2.g());
        tE<kN> tE2 = new tE<kN>(this);
        cn_0.a a2 = tE2.c.a();
        while (a2.a()) {
            a2.d();
            tE2.a(a2.b(), (kN)a2.c().c(sT2.a(a2.b())));
        }
        return tE2;
    }

    @Override
    @Deprecated
    public final T[] e() {
        return this.h();
    }

    @Override
    public final int g() {
        return this.d;
    }

    @Override
    public final T a(int n2) {
        this.b(n2);
        return (T)this.c.a(n2);
    }

    @Override
    public final kM<T> a() {
        return this.b;
    }

    @Override
    public final sT<T> a(int n2, int n3) {
        if (n3 < 0) {
            throw new pj_0(px_0.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, n3);
        }
        this.b(n2);
        this.b(n2 + n3 - 1);
        tE tE2 = new tE(this.b, n3);
        n3 = n2 + n3;
        cn_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            int n4 = a2.b();
            if (n4 < n2 || n4 >= n3) continue;
            tE2.a(n4 - n2, a2.c());
        }
        return tE2;
    }

    @Override
    public final sT<T> a(T t) {
        return this.b().b(t);
    }

    @Override
    public final sT<T> b(T t) {
        for (int i2 = 0; i2 < this.d; ++i2) {
            this.a(i2, (kN)this.a(i2).a(t));
        }
        return this;
    }

    @Override
    public final sT<T> g(T t) {
        return this.b().h(t);
    }

    @Override
    public final sT<T> h(T t) {
        cn_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            this.c.a(a2.b(), (kN)a2.c().d(t));
        }
        return this;
    }

    @Override
    public final sT<T> c() {
        return this.b().d();
    }

    @Override
    public final sT<T> d() {
        for (int i2 = 0; i2 < this.d; ++i2) {
            this.a(i2, (kN)((kN)this.b.b()).d(this.a(i2)));
        }
        return this;
    }

    @Override
    public final sT<T> e(T t) {
        return this.b().f(t);
    }

    @Override
    public final sT<T> f(T t) {
        cn_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            this.c.a(a2.b(), (kN)a2.c().c(t));
        }
        return this;
    }

    @Override
    public final sT<T> c(T t) {
        return this.b().d(t);
    }

    @Override
    public final sT<T> d(T t) {
        tE tE2 = this;
        return tE2.b((kN)((kN)tE2.b.a()).b(t));
    }

    @Override
    private sQ<T> c(tE<T> tE2) {
        tE<T> tE3 = tE2;
        int n2 = tE3.d;
        tD<kN> tD2 = new tD<kN>(this.b, this.d, n2);
        cn_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            cn_0.a a3 = tE2.c.a();
            while (a3.a()) {
                a3.d();
                ((su_0)tD2).a(a2.b(), a3.b(), (kN)a2.c().c(a3.c()));
            }
        }
        return tD2;
    }

    @Override
    public final sQ<T> g(sT<T> sT2) {
        if (sT2 instanceof tE) {
            return this.c((tE)sT2);
        }
        int n2 = sT2.g();
        tD<kN> tD2 = new tD<kN>(this.b, this.d, n2);
        cn_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            int n3 = a2.b();
            T t = a2.c();
            for (int i2 = 0; i2 < n2; ++i2) {
                tD2.a(n3, i2, (kN)t.c(sT2.a(i2)));
            }
        }
        return tD2;
    }

    @Override
    public final sT<T> f(sT<T> sT2) {
        this.c(sT2.g());
        sT<kN> sT3 = sT2;
        return sT2.e((kN)this.e(sT2).d(sT3.e(sT3)));
    }

    @Override
    public final void j(T t) {
        ci_0.a(t);
        for (int i2 = 0; i2 < this.d; ++i2) {
            this.a(i2, t);
        }
    }

    @Override
    public final void a(int n2, T t) {
        ci_0.a(t);
        this.b(n2);
        this.c.a(n2, (kN)t);
    }

    @Override
    public final void a(int n2, sT<T> sT2) {
        this.b(n2);
        this.b(n2 + sT2.g() - 1);
        int n3 = sT2.g();
        for (int i2 = 0; i2 < n3; ++i2) {
            this.a(i2 + n2, sT2.a(i2));
        }
    }

    @Override
    private tE<T> d(tE<T> object) {
        tE<T> tE2 = object;
        this.c(tE2.d);
        tE tE3 = (tE)this.b();
        tE2 = object;
        object = tE2.c.a();
        while (((cn_0.a)object).a()) {
            ((cn_0.a)object).d();
            int n2 = ((cn_0.a)object).b();
            if (this.c.b(n2)) {
                tE3.a(n2, (kN)this.c.a(n2).b(((cn_0.a)object).c()));
                continue;
            }
            tE3.a(n2, (kN)((kN)this.b.a()).b(((cn_0.a)object).c()));
        }
        return tE3;
    }

    @Override
    public final sT<T> b(sT<T> sT2) {
        if (sT2 instanceof tE) {
            return this.d((tE)sT2);
        }
        int n2 = sT2.g();
        this.c(n2);
        tE<kN> tE2 = new tE<kN>(this);
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.c.b(i2)) {
                tE2.a(i2, (kN)this.c.a(i2).b(sT2.a(i2)));
                continue;
            }
            tE2.a(i2, (kN)((kN)this.b.a()).b(sT2.a(i2)));
        }
        return tE2;
    }

    @Override
    public final T[] h() {
        kN[] kNArray = (kN[])ch_0.a(this.b, this.d);
        cn_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            kNArray[a2.b()] = a2.c();
        }
        return kNArray;
    }

    private void b(int n2) {
        block3: {
            tE tE2;
            block2: {
                if (n2 < 0) break block2;
                tE2 = this;
                if (n2 < tE2.d) break block3;
            }
            tE2 = this;
            throw new po_0(n2, (Number)0, tE2.d - 1);
        }
    }

    private void b(int n2, int n3) {
        tE tE2 = this;
        int n4 = tE2.d;
        if (n2 < 0 || n2 >= n4) {
            throw new po_0(px_0.INDEX, (Number)n2, 0, n4 - 1);
        }
        if (n3 < 0 || n3 >= n4) {
            throw new po_0(px_0.INDEX, (Number)n3, 0, n4 - 1);
        }
        if (n3 < n2) {
            throw new pn_0((pw_0)px_0.INITIAL_ROW_AFTER_FINAL_ROW, (Number)n3, n2, false);
        }
    }

    private void c(int n2) {
        tE tE2 = this;
        if (tE2.d != n2) {
            tE2 = this;
            throw new oS(tE2.d, n2);
        }
    }

    @Override
    public final sT<T> a(sT<T> sT2) {
        if (sT2 instanceof tE) {
            return this.a((tE)sT2);
        }
        int n2 = sT2.g();
        this.c(n2);
        tE<kN> tE2 = this;
        tE2 = new tE<kN>(this.b, tE2.d);
        for (int i2 = 0; i2 < n2; ++i2) {
            tE2.a(i2, (kN)sT2.a(i2).a(this.a(i2)));
        }
        return tE2;
    }

    private T a(sV<T> sV2) {
        tE tE2 = this;
        int n2 = tE2.d;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a(i2);
        }
        return sV2.c();
    }

    private T a(sV<T> sV2, int n2, int n3) {
        this.b(n2, n3);
        tE tE2 = this;
        int cfr_ignored_0 = tE2.d;
        while (n2 <= n3) {
            this.a(n2);
            ++n2;
        }
        return sV2.c();
    }

    private T b(sV<T> object) {
        sV<T> sV2 = object;
        object = this;
        tE tE2 = object;
        int n2 = ((tE)object).d;
        for (int i2 = 0; i2 < n2; ++i2) {
            ((tE)object).a(i2);
        }
        return sV2.c();
    }

    private T b(sV<T> object, int n2, int n3) {
        int n4 = n3;
        n3 = n2;
        sV<T> sV2 = object;
        object = this;
        ((tE)object).b(n3, n4);
        Object object2 = object;
        int cfr_ignored_0 = ((tE)object2).d;
        while (n3 <= n4) {
            ((tE)object).a(n3);
            ++n3;
        }
        return sV2.c();
    }

    private T a(sU<T> sU2) {
        tE tE2 = this;
        int n2 = tE2.d;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a(i2);
            this.a(i2, sU2.b());
        }
        return sU2.c();
    }

    private T a(sU<T> sU2, int n2, int n3) {
        this.b(n2, n3);
        tE tE2 = this;
        int cfr_ignored_0 = tE2.d;
        while (n2 <= n3) {
            this.a(n2);
            this.a(n2, sU2.b());
            ++n2;
        }
        return sU2.c();
    }

    private T b(sU<T> sU2) {
        return this.a(sU2);
    }

    private T b(sU<T> sU2, int n2, int n3) {
        return this.a(sU2, n2, n3);
    }

    public final int hashCode() {
        int n2 = 31 + (this.b == null ? 0 : this.b.hashCode());
        n2 = n2 * 31 + this.d;
        cn_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            int n3 = a2.c().hashCode();
            n2 = n2 * 31 + n3;
        }
        return n2;
    }

    public final boolean equals(Object obj) {
        T t;
        tE tE2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tE)) {
            return false;
        }
        tE2 = tE2;
        if (this.b == null ? tE2.b != null : !this.b.equals(tE2.b)) {
            return false;
        }
        if (this.d != tE2.d) {
            return false;
        }
        cn_0.a a2 = this.c.a();
        while (a2.a()) {
            a2.d();
            t = tE2.a(a2.b());
            if (t.equals(a2.c())) continue;
            return false;
        }
        a2 = tE2.c.a();
        while (a2.a()) {
            a2.d();
            t = a2.c();
            if (t.equals(this.a(a2.b()))) continue;
            return false;
        }
        return true;
    }
}

