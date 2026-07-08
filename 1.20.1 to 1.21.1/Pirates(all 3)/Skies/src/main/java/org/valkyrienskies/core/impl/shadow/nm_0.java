/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.BR;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.qd_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.nm
 */
public final class nm_0 {
    private static final List<qd_0> a = new ArrayList<qd_0>();
    private static final List<qd_0> b;
    private static final List<qd_0> c;
    private static final List<qd_0> d;
    private static final Map<a, List<qd_0>> e;

    private nm_0() {
    }

    private static ni_0 a(int n2) {
        return nm_0.a(n2, a, new b(){
            private final qd_0[] a = new qd_0[]{qd_0.c, qd_0.a, qd_0.b};

            public final qd_0[] a(int n2) {
                return this.a;
            }
        });
    }

    private static ni_0 b(int n2) {
        return nm_0.a(n2, b, new b(){

            public final qd_0[] a(int n2) {
                return new qd_0[]{qd_0.c, qd_0.a, new qd_0(2 * n2)};
            }
        });
    }

    private static ni_0 c(int n2) {
        return nm_0.a(n2, c, new b(){

            public final qd_0[] a(int n2) {
                int n3 = n2 + 1;
                return new qd_0[]{new qd_0(2 * n2 + 1, n3), new qd_0(-1, n3), new qd_0(n2, n3)};
            }
        });
    }

    private static ni_0 d(int n2) {
        return nm_0.a(n2, d, new b(){

            public final qd_0[] a(int n2) {
                int n3 = n2 + 1;
                return new qd_0[]{qd_0.c, new qd_0(n2 + n3, n3), new qd_0(n2, n3)};
            }
        });
    }

    private static ni_0 a(int n2, int n3, int n4) {
        a a2 = new a(n3, n4);
        if (!e.containsKey(a2)) {
            ArrayList<qd_0> arrayList = new ArrayList<qd_0>();
            e.put(a2, arrayList);
            arrayList.add(qd_0.b);
            arrayList.add(new qd_0(n3 - n4, 2));
            arrayList.add(new qd_0(n3 + 2 + n4, 2));
        }
        return nm_0.a(n2, e.get(a2), new b(n3, n4){
            private /* synthetic */ int a;
            private /* synthetic */ int b;
            {
                this.a = n2;
                this.b = n3;
            }

            public final qd_0[] a(int n2) {
                int n3 = ++n2 + this.a + this.b;
                int n4 = n3 + n2;
                int n5 = n4 - 1;
                int n6 = n4 - 2;
                n3 = 2 * n2 * n3 * n6;
                return new qd_0[]{new qd_0(n5 * (this.a * this.a - this.b * this.b), n3), new qd_0(n5 * n4 * n6, n3), new qd_0(2 * (n2 + this.a - 1) * (n2 + this.b - 1) * n4, n3)};
            }
        });
    }

    private static double[] a(double[] dArray, double d2) {
        int n2;
        int n3;
        int n4 = dArray.length;
        double[] dArray2 = new double[n4];
        int n5 = n4;
        int[][] nArray = new int[n5][n5];
        for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 <= n3; ++n2) {
                nArray[n3][n2] = (int)BR.a(n3, n2);
            }
        }
        for (n3 = 0; n3 < n4; ++n3) {
            dArray2[0] = dArray2[0] + dArray[n3] * BY.a(d2, n3);
        }
        n3 = n4 - 1;
        for (n2 = 0; n2 < n3; ++n2) {
            for (n4 = n2; n4 < n3; ++n4) {
                int n6 = n2 + 1;
                dArray2[n6] = dArray2[n6] + (double)nArray[n4 + 1][n4 - n2] * dArray[n4 + 1] * BY.a(d2, n4 - n2);
            }
        }
        return dArray2;
    }

    private static ni_0 a(int n2, List<qd_0> list, b b2) {
        List<qd_0> list2 = list;
        synchronized (list2) {
            int n3 = (int)BY.y(BY.a((double)(2 * list.size()))) - 1;
            if (n2 > n3) {
                List<qd_0> list3 = list;
                b b3 = b2;
                int n4 = n2;
                int n5 = (n3 - 1) * n3 / 2;
                while (n3 < n4) {
                    int n6 = n5;
                    qd_0[] qd_0Array = b3.a(n3);
                    qd_0 qd_02 = list3.get(n5 += n3);
                    qd_0 qd_03 = list3.get(n6);
                    list3.add(qd_02.d(qd_0Array[0]).e(qd_03.d(qd_0Array[2])));
                    for (int i2 = 1; i2 < n3; ++i2) {
                        qd_0 qd_04 = qd_02;
                        qd_02 = list3.get(n5 + i2);
                        qd_03 = list3.get(n6 + i2);
                        list3.add(qd_02.d(qd_0Array[0]).a(qd_04.d(qd_0Array[1])).e(qd_03.d(qd_0Array[2])));
                    }
                    qd_0 qd_05 = qd_02;
                    qd_02 = list3.get(n5 + n3);
                    list3.add(qd_02.d(qd_0Array[0]).a(qd_05.d(qd_0Array[1])));
                    list3.add(qd_02.d(qd_0Array[1]));
                    ++n3;
                }
            }
        }
        int n7 = n2;
        int n8 = n7 * (n7 + 1) / 2;
        double[] dArray = new double[n2 + 1];
        for (int i3 = 0; i3 <= n2; ++i3) {
            dArray[i3] = list.get(n8 + i3).doubleValue();
        }
        return new ni_0(dArray);
    }

    private static void a(int n2, int n3, b b2, List<qd_0> list) {
        int n4 = (n3 - 1) * n3 / 2;
        while (n3 < n2) {
            int n5 = n4;
            qd_0[] qd_0Array = b2.a(n3);
            qd_0 qd_02 = list.get(n4 += n3);
            qd_0 qd_03 = list.get(n5);
            list.add(qd_02.d(qd_0Array[0]).e(qd_03.d(qd_0Array[2])));
            for (int i2 = 1; i2 < n3; ++i2) {
                qd_0 qd_04 = qd_02;
                qd_02 = list.get(n4 + i2);
                qd_03 = list.get(n5 + i2);
                list.add(qd_02.d(qd_0Array[0]).a(qd_04.d(qd_0Array[1])).e(qd_03.d(qd_0Array[2])));
            }
            qd_0 qd_05 = qd_02;
            qd_02 = list.get(n4 + n3);
            list.add(qd_02.d(qd_0Array[0]).a(qd_05.d(qd_0Array[1])));
            list.add(qd_02.d(qd_0Array[1]));
            ++n3;
        }
    }

    static {
        a.add(qd_0.b);
        a.add(qd_0.c);
        a.add(qd_0.b);
        b = new ArrayList<qd_0>();
        b.add(qd_0.b);
        b.add(qd_0.c);
        b.add(qd_0.a);
        c = new ArrayList<qd_0>();
        c.add(qd_0.b);
        c.add(qd_0.b);
        c.add(qd_0.d);
        d = new ArrayList<qd_0>();
        d.add(qd_0.b);
        d.add(qd_0.c);
        d.add(qd_0.b);
        e = new HashMap<a, List<qd_0>>();
    }

    static interface b {
        public qd_0[] a(int var1);
    }

    static final class a {
        private final int a;
        private final int b;

        a(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        public final int hashCode() {
            return this.a << 16 ^ this.b;
        }

        public final boolean equals(Object key) {
            a a2;
            if (key == null || !(key instanceof a)) {
                return false;
            }
            a2 = a2;
            return this.a == a2.a && this.b == a2.b;
        }
    }
}

