/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.sa_0;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class rM<S extends qN> {
    public sb_0<S> a;
    public rM<S> b;
    public rM<S> c;
    public rM<S> d;
    public Object e;

    public rM() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public rM(Object object) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = object;
    }

    public rM(sb_0<S> sb_02, rM<S> rM2, rM<S> rM3, Object object) {
        this.a = sb_02;
        this.b = rM2;
        this.c = rM3;
        this.d = null;
        this.e = object;
        rM2.d = this;
        rM3.d = this;
    }

    public final boolean a(rV<S> object) {
        if (this.a != null) {
            this.b.d = null;
            this.c.d = null;
        }
        if ((object = this.b(object.f())) == null || object.b()) {
            this.a = null;
            this.b = null;
            this.c = null;
            return false;
        }
        this.a = object;
        this.b = new rM<S>();
        this.b.d = this;
        this.c = new rM<S>();
        this.c.d = this;
        return true;
    }

    public final rM<S> a() {
        if (this.a == null) {
            return new rM<S>(this.e);
        }
        return new rM<S>(this.a.e(), this.b.a(), this.c.a(), this.e);
    }

    public final sb_0<S> b() {
        return this.a;
    }

    public final rM<S> c() {
        return this.b;
    }

    public final rM<S> d() {
        return this.c;
    }

    public final rM<S> e() {
        return this.d;
    }

    public final void a(Object object) {
        this.e = object;
    }

    public final Object f() {
        return this.e;
    }

    public final void a(rN<S> rN2) {
        if (this.a == null) {
            rN2.c(this);
            return;
        }
        switch (2.a[rN2.a(this) - 1]) {
            case 1: {
                this.b.a(rN2);
                this.c.a(rN2);
                rN2.b(this);
                return;
            }
            case 2: {
                this.b.a(rN2);
                rN2.b(this);
                this.c.a(rN2);
                return;
            }
            case 3: {
                this.c.a(rN2);
                this.b.a(rN2);
                rN2.b(this);
                return;
            }
            case 4: {
                this.c.a(rN2);
                rN2.b(this);
                this.b.a(rN2);
                return;
            }
            case 5: {
                rN2.b(this);
                this.b.a(rN2);
                this.c.a(rN2);
                return;
            }
            case 6: {
                rN2.b(this);
                this.c.a(rN2);
                this.b.a(rN2);
                return;
            }
        }
        throw new oY();
    }

    private sb_0<S> b(sb_0<S> sb_02) {
        rM<S> rM2 = this;
        while (rM2.d != null && sb_02 != null) {
            rM<S> rM3 = rM2;
            if (rM3 == rM3.d.b) {
                sb_02 = sb_02.a(rM2.d.a.c());
                sb_02 = ((sb_0.a)((Object)sb_02)).a;
            } else {
                sb_02 = sb_02.a(rM2.d.a.c());
                sb_02 = ((sb_0.a)((Object)sb_02)).b;
            }
            rM2 = rM2.d;
        }
        return sb_02;
    }

    @Deprecated
    private rM<S> a(qO<S> qO2) {
        return this.a(qO2, 1.0E-10);
    }

    public final rM<S> a(qM<S> qM2, double d2) {
        while (rM2.a != null) {
            rM<S> rM2;
            double d3;
            double d4 = rM2.a.c().a(qM2);
            if (BY.w(d3) < d2) {
                return rM2;
            }
            if (d4 <= 0.0) {
                rM2 = rM2.c;
                continue;
            }
            rM2 = rM2.b;
        }
        return rM2;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final List a(sp_0 sp_02, double d2) {
        ArrayList<rM<S>> arrayList = new ArrayList<rM<S>>();
        this.a(sp_02, d2, arrayList);
        return arrayList;
    }

    public void a(qM<S> qM2, double d2, List<rM<S>> list) {
        while (rM2.a != null) {
            double d3;
            double d4 = rM2.a.c().a(qM2);
            if (d3 < -d2) {
                rM2.c.a(qM2, d2, list);
                return;
            }
            if (d4 > d2) {
                rM2.b.a(qM2, d2, list);
                return;
            }
            list.add(rM2);
            rM2.c.a(qM2, d2, list);
            rM<S> rM2 = rM2.b;
        }
    }

    private void g() {
        if (this.a != null && this.b.a == null && this.c.a == null && (this.b.e == null && this.c.e == null || this.b.e != null && this.b.e.equals(this.c.e))) {
            this.e = this.b.e == null ? this.c.e : this.b.e;
            this.a = null;
            this.b = null;
            this.c = null;
        }
    }

    public final rM<S> a(rM<S> rM2, a<S> a2) {
        return this.a(rM2, a2, null, false);
    }

    private rM<S> a(rM<S> rM2, a<S> a2, rM<S> rM3, boolean bl) {
        if (this.a == null) {
            return a2.a(this, rM2, rM3, bl, true);
        }
        if (rM2.a == null) {
            return a2.a(rM2, this, rM3, bl, false);
        }
        rM2 = rM2.a(this.a);
        if (rM3 != null) {
            rM2.d = rM3;
            if (bl) {
                rM3.b = rM2;
            } else {
                rM3.c = rM2;
            }
        }
        super.a(rM2.b, a2, rM2, true);
        super.a(rM2.c, a2, rM2, false);
        super.g();
        if (rM2.a != null) {
            rM2.a = super.b(rM2.a.c().f());
        }
        return rM2;
    }

    public final rM<S> a(sb_0<S> object) {
        if (this.a == null) {
            return new rM<S>(object, this.a(), new rM<S>(this.e), null);
        }
        rM<S> rM2 = this.a.c();
        Object object2 = object.c();
        sb_0.a a2 = object.a((rV)((Object)rM2));
        switch (2.b[a2.c() - 1]) {
            case 1: {
                rM2 = this.b.a((sb_0<S>)object);
                if (this.a.a((rV)object2).c() == sa_0.PLUS$7c70dd6b) {
                    rM2.b = new rM<S>(this.a.e(), rM2.b, this.c.a(), this.e);
                    super.g();
                    rM2.b.d = rM2;
                } else {
                    rM2.c = new rM<S>(this.a.e(), rM2.c, this.c.a(), this.e);
                    super.g();
                    rM2.c.d = rM2;
                }
                return rM2;
            }
            case 2: {
                rM2 = this.c.a((sb_0<S>)object);
                if (this.a.a((rV)object2).c() == sa_0.PLUS$7c70dd6b) {
                    rM2.b = new rM<S>(this.a.e(), this.b.a(), rM2.b, this.e);
                    super.g();
                    rM2.b.d = rM2;
                } else {
                    rM2.c = new rM<S>(this.a.e(), this.b.a(), rM2.c, this.e);
                    super.g();
                    rM2.c.d = rM2;
                }
                return rM2;
            }
            case 3: {
                rM2 = this.a.a((rV)object2);
                sb_0.a a3 = a2;
                object2 = a3;
                object2 = a2;
                object = new rM<S>(object, this.b.a(a3.a), this.c.a(((sb_0.a)object2).b), null);
                object2 = rM2;
                v1.b.a = ((sb_0.a)object2).a;
                object2 = rM2;
                ((rM)object).c.a = ((sb_0.a)object2).b;
                rM2 = ((rM)object).b.c;
                ((rM)object).b.c = ((rM)object).c.b;
                ((rM)object).b.c.d = ((rM)object).b;
                ((rM)object).c.b = rM2;
                ((rM)object).c.b.d = ((rM)object).c;
                super.g();
                super.g();
                return object;
            }
        }
        if (rM2.a((rV<S>)object2)) {
            return new rM<S>(object, this.b.a(), this.c.a(), this.e);
        }
        return new rM<S>(object, this.c.a(), this.b.a(), this.e);
    }

    @Deprecated
    private void a(rM<S> rM2, boolean bl) {
        this.a(rM2, bl, new b<S>(this){
            private /* synthetic */ rM a;
            {
                this.a = rM2;
            }

            @Override
            public final rM<S> a(rM<S> rM2) {
                throw new oX(px_0.NULL_NOT_ALLOWED, new Object[0]);
            }
        });
    }

    public final void a(rM<S> rM2, boolean bl, b<S> b2) {
        this.d = rM2;
        if (rM2 != null) {
            if (bl) {
                rM2.b = this;
            } else {
                rM2.c = this;
            }
        }
        if (this.a != null) {
            rM2 = this;
            while (rM2.d != null) {
                sb_0.a a2;
                Object object = rM2.d.a.c();
                rM<S> rM3 = rM2;
                if (rM3 == rM3.d.b) {
                    a2 = this.a.a((rV)object);
                    this.a = a2.a;
                    super.a((rV<S>)object, b2);
                    super.a((rV<S>)object, b2);
                } else {
                    a2 = this.a.a((rV)object);
                    this.a = a2.b;
                    super.b((rV<S>)object, b2);
                    super.b((rV<S>)object, b2);
                }
                if (this.a == null) {
                    object = b2.a(this);
                    this.a = ((rM)object).a;
                    this.b = ((rM)object).b;
                    this.c = ((rM)object).c;
                    this.e = ((rM)object).e;
                    if (this.a == null) break;
                }
                rM2 = rM2.d;
            }
            this.g();
        }
    }

    public final rM<S> a(Object rM2, Object object, Object rM3) {
        rM2 = new rM<S>(rM2);
        rM3 = this;
        while (rM3.d != null) {
            rL rL2 = rM3.d.a.e();
            rM<S> rM4 = new rM<S>(object);
            rM<S> rM5 = rM3;
            rM2 = rM5 == rM5.d.b ? new rM<S>(rL2, rM2, rM4, null) : new rM<S>(rL2, rM4, rM2, null);
            rM3 = rM3.d;
        }
        return rM2;
    }

    private void a(rV<S> object, b<S> b2) {
        if (this.a != null) {
            sb_0.a a2 = this.a.a((rV)object);
            this.a = a2.a;
            super.a((rV<S>)object, b2);
            super.a((rV<S>)object, b2);
            if (this.a == null) {
                object = b2.a(this);
                this.a = ((rM)object).a;
                this.b = ((rM)object).b;
                this.c = ((rM)object).c;
                this.e = ((rM)object).e;
            }
        }
    }

    private void b(rV<S> object, b<S> b2) {
        if (this.a != null) {
            sb_0.a a2 = this.a.a((rV)object);
            this.a = a2.b;
            super.b((rV<S>)object, b2);
            super.b((rV<S>)object, b2);
            if (this.a == null) {
                object = b2.a(this);
                this.a = ((rM)object).a;
                this.b = ((rM)object).b;
                this.c = ((rM)object).c;
                this.e = ((rM)object).e;
            }
        }
    }

    static final class 2 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            b = new int[sa_0.values$65ac40a5().length];
            try {
                2.b[sa_0.PLUS$7c70dd6b - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                2.b[sa_0.MINUS$7c70dd6b - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                2.b[sa_0.BOTH$7c70dd6b - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            a = new int[rN.a.values$5c9b7337().length];
            try {
                2.a[rN.a.PLUS_MINUS_SUB$672d2271 - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                2.a[rN.a.PLUS_SUB_MINUS$672d2271 - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                2.a[rN.a.MINUS_PLUS_SUB$672d2271 - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                2.a[rN.a.MINUS_SUB_PLUS$672d2271 - 1] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                2.a[rN.a.SUB_PLUS_MINUS$672d2271 - 1] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                2.a[rN.a.SUB_MINUS_PLUS$672d2271 - 1] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface b<S extends qN> {
        public rM<S> a(rM<S> var1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface a<S extends qN> {
        public rM<S> a(rM<S> var1, rM<S> var2, rM<S> var3, boolean var4, boolean var5);
    }
}

