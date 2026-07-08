/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pr_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cc
 */
public final class cc_0 {
    private cc_0() {
    }

    private static b a(int n2, int n3) {
        int n4 = n2;
        n2 = 1;
        n2 = n4;
        return new b(n2, n3, 1);
    }

    private static b a(int n2, int n3, int n4) {
        return new b(n2, n3, 1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class org.valkyrienskies.core.impl.shadow.Cc$a
    implements Iterator<Integer> {
        private static final 1 f = new a(){

            public final void a(int n2) {
                throw new pc_0(n2);
            }
        };
        final int a;
        public final int b;
        final int c;
        final a d;
        public int e = 0;

        org.valkyrienskies.core.impl.shadow.Cc$a(int n2, int n3, int n4, a a2) {
            if (a2 == null) {
                throw new pl_0();
            }
            this.a = n2;
            this.b = n3;
            this.c = n4;
            this.d = a2;
            this.e = n2;
        }

        public static org.valkyrienskies.core.impl.shadow.Cc$a a() {
            return new org.valkyrienskies.core.impl.shadow.Cc$a(0, 0, 1, f);
        }

        public final org.valkyrienskies.core.impl.shadow.Cc$a a(int n2) {
            return new org.valkyrienskies.core.impl.shadow.Cc$a(n2, this.b, this.c, this.d);
        }

        public final org.valkyrienskies.core.impl.shadow.Cc$a b(int n2) {
            return new org.valkyrienskies.core.impl.shadow.Cc$a(this.a, n2, this.c, this.d);
        }

        public final org.valkyrienskies.core.impl.shadow.Cc$a c(int n2) {
            if (n2 == 0) {
                throw new pr_0();
            }
            return new org.valkyrienskies.core.impl.shadow.Cc$a(this.a, this.b, n2, this.d);
        }

        public final org.valkyrienskies.core.impl.shadow.Cc$a a(a a2) {
            return new org.valkyrienskies.core.impl.shadow.Cc$a(this.a, this.b, this.c, a2);
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.e;
        }

        private boolean e() {
            return this.e(1);
        }

        private boolean e(int n2) {
            n2 = this.e + n2 * this.c;
            if (this.c < 0) {
                return n2 > this.b;
            }
            return n2 < this.b;
        }

        public final void d(int n2) {
            if (n2 <= 0) {
                throw new pk_0(n2);
            }
            if (!this.e(0)) {
                this.d.a(this.b);
            }
            this.e += n2 * this.c;
        }

        public final void d() {
            this.d(1);
        }

        @Override
        public final boolean hasNext() {
            return this.e(0);
        }

        private Integer f() {
            int n2 = this.e;
            org.valkyrienskies.core.impl.shadow.Cc$a a2 = this;
            a2.d(1);
            return n2;
        }

        @Override
        public final void remove() {
            throw new pb_0();
        }

        @Override
        public final /* synthetic */ Object next() {
            org.valkyrienskies.core.impl.shadow.Cc$a a2 = this;
            int n2 = a2.e;
            a2.d(1);
            return n2;
        }

        public static interface a {
            public void a(int var1);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class b
    implements Iterable<Integer> {
        private final int a;
        private final int b;
        private final int c;
        private final int d;

        public b(int n2, int n3, int n4) {
            this.b = n2;
            this.c = n3;
            this.d = n4;
            n2 = (n3 - n2) / n4 + 1;
            this.a = n2 < 0 ? 0 : n2;
        }

        private int a() {
            return this.a;
        }

        @Override
        public final Iterator<Integer> iterator() {
            int n2 = this.d;
            a a2 = org.valkyrienskies.core.impl.shadow.Cc$a.a().a(this.b).b(this.c + (this.d > 0 ? 1 : -1));
            if (n2 == 0) {
                throw new pr_0();
            }
            return new a(a2.a, a2.b, n2, a2.d);
        }
    }
}

