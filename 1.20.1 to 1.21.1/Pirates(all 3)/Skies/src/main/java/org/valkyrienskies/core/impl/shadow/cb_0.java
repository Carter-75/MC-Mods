/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cc_0;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pl_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cb
 */
@Deprecated
public class cb_0 {
    public int a;
    public int b = 0;
    private final a c;

    public cb_0() {
        this(0);
    }

    private cb_0(int n2) {
        this(0, new a(){

            public final void a(int n2) {
                throw new pc_0(n2);
            }
        });
    }

    public cb_0(int n2, a a2) {
        if (a2 == null) {
            throw new pl_0();
        }
        this.a = n2;
        this.c = a2;
    }

    public void a(int n2) {
        this.a = n2;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    private boolean e() {
        return this.b < this.a;
    }

    public final void b(int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            this.c();
        }
    }

    public void c() {
        if (++this.b > this.a) {
            this.c.a(this.a);
        }
    }

    public void d() {
        this.b = 0;
    }

    public static 2 a(cc_0.a a2) {
        return new cb_0(a2){
            private cc_0.a c;
            private /* synthetic */ cc_0.a d;
            {
                this.d = object;
                this.c = this.d;
                2 v0 = this;
                object = v0.c;
                super.a(((cc_0.a)object).b);
                2 v1 = this;
                object = v1.c;
                int n2 = ((cc_0.a)object).e;
                object = v1;
                for (int i2 = 0; i2 < n2; ++i2) {
                    ((cb_0)object).c();
                }
            }

            public final void a(int n2) {
                super.a(n2);
                this.c = this.c.b(n2);
            }

            public final void d() {
                super.d();
                this.c = this.c.a(0);
            }

            public final void c() {
                super.c();
                cc_0.a a2 = this.c;
                a2.d(1);
            }
        };
    }

    public static interface a {
        public void a(int var1);
    }
}

