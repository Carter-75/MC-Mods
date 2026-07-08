/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import org.valkyrienskies.core.impl.shadow.fg_2;
import org.valkyrienskies.core.impl.shadow.gw_1;
import org.valkyrienskies.core.impl.shadow.kg_0;
import org.valkyrienskies.core.impl.shadow.ki_0;
import org.valkyrienskies.core.impl.shadow.kj_0;
import org.valkyrienskies.core.impl.shadow.kk_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kn
 */
public final class kn_0<T> {
    public final List<T> a;
    public final List<T> b;
    private final fg_2<? super T> c;
    private final int[] d;
    private final int[] e;

    private kn_0(List<T> list, List<T> list2) {
        this(list, list2, gw_1.a());
    }

    public kn_0(List<T> list, List<T> list2, fg_2<? super T> fg_22) {
        this.a = list;
        this.b = list2;
        this.c = fg_22;
        int n2 = list.size() + list2.size() + 2;
        this.d = new int[n2];
        this.e = new int[n2];
    }

    public final ki_0<T> a() {
        ki_0 ki_02 = new ki_0();
        this.a(0, this.a.size(), 0, this.b.size(), ki_02);
        return ki_02;
    }

    private a a(int n2, int n3, int n4, int n5) {
        int n6;
        for (n6 = n2; n6 - n3 < n5 && n6 < n4 && this.c.a(this.a.get(n6), this.b.get(n6 - n3)); ++n6) {
        }
        return new a(n2, n6, n3);
    }

    private a b(int n2, int n3, int n4, int n5) {
        int n6 = n3 - n2;
        int n7 = n5 - n4;
        if (n6 == 0 || n7 == 0) {
            return null;
        }
        int n8 = n6 - n7;
        n6 = ((n6 = n7 + n6) % 2 == 0 ? n6 : n6 + 1) / 2;
        this.d[n6 + 1] = n2;
        this.e[n6 + 1] = n3 + 1;
        for (n7 = 0; n7 <= n6; ++n7) {
            int n9;
            int n10;
            int n11;
            int n12;
            for (n12 = -n7; n12 <= n7; n12 += 2) {
                n11 = n12 + n6;
                this.d[n11] = n12 == -n7 || n12 != n7 && this.d[n11 - 1] < this.d[n11 + 1] ? this.d[n11 + 1] : this.d[n11 - 1] + 1;
                n10 = this.d[n11];
                for (n9 = n10 - n2 + n4 - n12; n10 < n3 && n9 < n5 && this.c.a(this.a.get(n10), this.b.get(n9)); ++n9) {
                    this.d[n11] = ++n10;
                }
                if (n8 % 2 == 0 || n8 - n7 > n12 || n12 > n8 + n7 || this.e[n11 - n8] > this.d[n11]) continue;
                kn_0 kn_02 = this;
                return kn_02.a(kn_02.e[n11 - n8], n12 + n2 - n4, n3, n5);
            }
            for (n12 = n8 - n7; n12 <= n8 + n7; n12 += 2) {
                n11 = n12 + n6 - n8;
                this.e[n11] = n12 == n8 - n7 || n12 != n8 + n7 && this.e[n11 + 1] <= this.e[n11 - 1] ? this.e[n11 + 1] - 1 : this.e[n11 - 1];
                n10 = this.e[n11] - 1;
                for (n9 = n10 - n2 + n4 - n12; n10 >= n2 && n9 >= n4 && this.c.a(this.a.get(n10), this.b.get(n9)); --n9) {
                    this.e[n11] = n10--;
                }
                if (n8 % 2 != 0 || -n7 > n12 || n12 > n7 || this.e[n11] > this.d[n11 + n8]) continue;
                kn_0 kn_03 = this;
                return kn_03.a(kn_03.e[n11], n12 + n2 - n4, n3, n5);
            }
        }
        throw new RuntimeException("Internal Error");
    }

    public void a(int n2, int n3, int n4, int n5, ki_0<T> ki_02) {
        while (true) {
            int n6;
            a a2;
            a a3;
            block10: {
                block8: {
                    block9: {
                        if ((a3 = this.b(n2, n3, n4, n5)) == null) break block8;
                        a2 = a3;
                        if (a2.a != n3) break block9;
                        a2 = a3;
                        if (a2.c == n3 - n5) break block8;
                    }
                    a2 = a3;
                    if (a2.b != n2) break block10;
                    a2 = a3;
                    if (a2.c != n2 - n4) break block10;
                }
                n6 = n2;
                int n7 = n4;
                while (n6 < n3 || n7 < n5) {
                    if (n6 < n3 && n7 < n5 && this.c.a(this.a.get(n6), this.b.get(n7))) {
                        ki_02.a(new kk_0<T>(this.a.get(n6)));
                        ++n6;
                        ++n7;
                        continue;
                    }
                    if (n3 - n2 > n5 - n4) {
                        ki_02.a(new kg_0<T>(this.a.get(n6)));
                        ++n6;
                        continue;
                    }
                    ki_02.a(new kj_0<T>(this.b.get(n7)));
                    ++n7;
                }
                return;
            }
            a a4 = a3;
            a2 = a4;
            a a5 = a3;
            a2 = a5;
            a2 = a3;
            this.a(n2, a4.a, n4, a5.a - a2.c, ki_02);
            a2 = a3;
            n6 = a2.a;
            while (true) {
                a2 = a3;
                if (n6 >= a2.b) break;
                ki_02.a(new kk_0<T>(this.a.get(n6)));
                ++n6;
            }
            a a6 = a3;
            a2 = a6;
            a a7 = a3;
            a2 = a7;
            a2 = a3;
            n4 = a7.b - a2.c;
            n2 = a6.b;
        }
    }

    static final class a {
        final int a;
        final int b;
        final int c;

        public a(int n2, int n3, int n4) {
            this.a = n2;
            this.b = n3;
            this.c = n4;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }
    }
}

