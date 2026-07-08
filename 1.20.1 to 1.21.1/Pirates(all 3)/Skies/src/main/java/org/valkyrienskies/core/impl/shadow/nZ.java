/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.nX;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class nZ
implements kM<nX> {
    private static int h = 1;
    private static int i = 2;
    private static int j = 4;
    private static int k = 8;
    private static int l = 16;
    private static String m;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static String t;
    private static String u;
    final int a;
    final nX b;
    final nX c;
    final nX d;
    private final nX v;
    private final nX[] w;
    private final nX x;
    private final nX y;
    private final nX z;
    final nX e;
    private final nX[] A;
    private final nX B;
    private final nX[] C;
    final nX f;
    private final nX[] D;
    private final nX E;
    private final nX[] F;
    private final nX G;
    int g;
    private int H;

    private nZ(int n2) {
        this(n2, true);
    }

    private nZ(int n2, boolean bl) {
        this.a = n2 < 13 ? 4 : (n2 + 3) / 4;
        this.g = org.valkyrienskies.core.impl.shadow.nZ$a.ROUND_HALF_EVEN$7d08181e;
        this.H = 0;
        this.b = new nX(this, 0);
        this.c = new nX(this, 1);
        this.d = new nX(this, 2);
        if (bl) {
            Class<nZ> clazz = nZ.class;
            synchronized (nZ.class) {
                int n3 = n2 = n2 < 67 ? 200 : 3 * n2;
                if (m == null || m.length() < n2 - 3) {
                    nX nX2;
                    nZ nZ2 = new nZ(n2, false);
                    nX nX3 = new nX(nZ2, 1);
                    nX nX4 = new nX(nZ2, 2);
                    nX nX5 = new nX(nZ2, 3);
                    nX nX6 = nX4.Q();
                    m = nX6.toString();
                    n = nX3.i(nX6).toString();
                    nX6 = nX5.Q();
                    o = nX6.toString();
                    p = nX3.i(nX6).toString();
                    nX nX7 = nX5;
                    nX6 = nX4;
                    nX5 = nX3;
                    nX nX8 = nX6.Q();
                    nX nX9 = nX8.g(nX5);
                    nX nX10 = nX6;
                    nX nX11 = nX10.f(nX10);
                    nX nX12 = nX6;
                    nX nX13 = nX6.h(nX7.g(nX6.h(nX8)));
                    for (int i2 = 1; i2 < 20; ++i2) {
                        nX7 = nX9;
                        nX nX14 = nX9;
                        nX nX15 = nX8 = nX14.h(nX14);
                        nX8 = nX5.g(nX15.h(nX15));
                        nX8 = nX8.Q().Q();
                        nX9 = nX5.g(nX8).i(nX5.f(nX8));
                        nX12 = nX12.h(nX11);
                        nX8 = nX5.f(nX9);
                        nX nX16 = nX8 = nX8.h(nX8);
                        nX nX17 = nX9;
                        nX13 = nX13.h(nX16.h(nX16)).g(nX12.h(nX9).h(nX5.f(nX9).f(nX17.h(nX17))));
                        if (nX9.equals(nX7)) break;
                    }
                    q = nX5.i(nX13).toString();
                    nX5 = nX2 = nX3;
                    nX7 = new nX(nX2);
                    nX8 = new nX(nX2);
                    nX9 = new nX(nX2);
                    nX11 = new nX(nX2);
                    nX12 = new nX(nX2);
                    for (int i3 = 0; i3 < 10000; ++i3) {
                        nX12 = nX12.h(nX5);
                        nX7 = nX7.f(nX12.i(nX9));
                        nX11 = nX11.f(nX2);
                        nX9 = nX9.h(nX11);
                        if (nX7.equals(nX8)) break;
                        nX8 = new nX(nX7);
                    }
                    r = nX7.toString();
                    s = nZ.b(nX4, nX3, nX4).toString();
                    t = nZ.b(new nX(nZ2, 5), nX3, nX4).toString();
                    u = nZ.b(new nX(nZ2, 10), nX3, nX4).toString();
                }
                this.v = new nX(this, m);
                this.w = this.b(m);
                this.x = new nX(this, n);
                this.y = new nX(this, o);
                this.z = new nX(this, p);
                this.e = new nX(this, q);
                this.A = this.b(q);
                this.B = new nX(this, r);
                this.C = this.b(r);
                this.f = new nX(this, s);
                this.D = this.b(s);
                this.E = new nX(this, t);
                this.F = this.b(t);
                this.G = new nX(this, u);
                // ** MonitorExit[var2_5] (shouldn't be in output)
            }
        } else {
            this.v = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            this.e = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.f = null;
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
        }
    }

    public final int d() {
        return this.a;
    }

    private void b(int n2) {
        this.g = n2;
    }

    public final int e() {
        return this.g;
    }

    private int p() {
        return this.H;
    }

    private void q() {
        this.H = 0;
    }

    private void c(int n2) {
        this.H = n2 & 0x1F;
    }

    public final void a(int n2) {
        this.H |= n2 & 0x1F;
    }

    private nX r() {
        return new nX(this);
    }

    private nX a(byte by) {
        return new nX(this, by);
    }

    private nX d(int n2) {
        return new nX(this, n2);
    }

    private nX a(long l2) {
        return new nX(this, l2);
    }

    private nX a(double d2) {
        return new nX(this, d2);
    }

    private static nX a(nX nX2) {
        return new nX(nX2);
    }

    public final nX a(String string) {
        return new nX(this, string);
    }

    public final nX a(byte by, byte by2) {
        return new nX(this, by, by2);
    }

    public final nX f() {
        return this.b;
    }

    public final nX g() {
        return this.c;
    }

    @Override
    public final Class<? extends kN<nX>> c() {
        return nX.class;
    }

    public final nX h() {
        return this.d;
    }

    private nX s() {
        return this.v;
    }

    public final nX[] i() {
        return (nX[])this.w.clone();
    }

    private nX t() {
        return this.x;
    }

    private nX u() {
        return this.y;
    }

    private nX v() {
        return this.z;
    }

    public final nX j() {
        return this.e;
    }

    public final nX[] k() {
        return (nX[])this.A.clone();
    }

    private nX w() {
        return this.B;
    }

    public final nX[] l() {
        return (nX[])this.C.clone();
    }

    public final nX m() {
        return this.f;
    }

    public final nX[] n() {
        return (nX[])this.D.clone();
    }

    private nX x() {
        return this.E;
    }

    public final nX[] o() {
        return (nX[])this.F.clone();
    }

    private nX y() {
        return this.G;
    }

    private nX[] b(String string) {
        int n2;
        nX[] nXArray = new nX[2];
        boolean bl = true;
        int n3 = 0;
        int n4 = 0;
        char[] cArray = new char[string.length()];
        for (n2 = 0; n2 < cArray.length; ++n2) {
            cArray[n2] = string.charAt(n2);
            if (cArray[n2] >= '1' && cArray[n2] <= '9') {
                bl = false;
            }
            if (cArray[n2] == '.') {
                n4 += (400 - n4) % 4;
                bl = false;
            }
            if (n4 == this.a / 2 << 2) {
                n3 = n2;
                break;
            }
            if (cArray[n2] < '0' || cArray[n2] > '9' || bl) continue;
            ++n4;
        }
        nXArray[0] = new nX(this, new String(cArray, 0, n3));
        for (n2 = 0; n2 < cArray.length; ++n2) {
            cArray[n2] = string.charAt(n2);
            if (cArray[n2] < '0' || cArray[n2] > '9' || n2 >= n3) continue;
            cArray[n2] = 48;
        }
        nXArray[1] = new nX(this, new String(cArray));
        return nXArray;
    }

    private static void e(int n2) {
        if (m == null || m.length() < n2 - 3) {
            nZ nZ2 = new nZ(n2, false);
            nX nX2 = new nX(nZ2, 1);
            nX nX3 = new nX(nZ2, 2);
            nX nX4 = new nX(nZ2, 3);
            nX nX5 = nX3.Q();
            m = nX5.toString();
            n = nX2.i(nX5).toString();
            nX5 = nX4.Q();
            o = nX5.toString();
            p = nX2.i(nX5).toString();
            q = nZ.a(nX2, nX3, nX4).toString();
            nX nX6 = nX2;
            r = nZ.a(nX6, nX6).toString();
            s = nZ.b(nX3, nX2, nX3).toString();
            t = nZ.b(new nX(nZ2, 5), nX2, nX3).toString();
            u = nZ.b(new nX(nZ2, 10), nX2, nX3).toString();
        }
    }

    private static nX a(nX nX2, nX nX3, nX nX4) {
        nX nX5 = nX3.Q();
        nX nX6 = nX5.g(nX2);
        nX nX7 = nX3;
        nX nX8 = nX7.f(nX7);
        nX nX9 = nX3;
        nX3 = nX3.h(nX4.g(nX3.h(nX5)));
        for (int i2 = 1; i2 < 20; ++i2) {
            nX5 = nX6;
            nX nX10 = nX6;
            nX nX11 = nX6 = nX10.h(nX10);
            nX6 = nX2.g(nX11.h(nX11));
            nX6 = nX6.Q().Q();
            nX6 = nX2.g(nX6).i(nX2.f(nX6));
            nX9 = nX9.h(nX8);
            nX nX12 = nX2.f(nX6);
            nX nX13 = nX12 = nX12.h(nX12);
            nX nX14 = nX6;
            nX3 = nX3.h(nX13.h(nX13)).g(nX9.h(nX6).h(nX2.f(nX6).f(nX14.h(nX14))));
            if (nX6.equals(nX5)) break;
        }
        return nX2.i(nX3);
    }

    private static nX a(nX nX2, nX nX3) {
        nX nX4 = new nX(nX3);
        nX nX5 = new nX(nX3);
        nX nX6 = new nX(nX3);
        nX nX7 = new nX(nX3);
        nX nX8 = new nX(nX3);
        for (int i2 = 0; i2 < 10000; ++i2) {
            nX8 = nX8.h(nX2);
            nX4 = nX4.f(nX8.i(nX6));
            nX7 = nX7.f(nX3);
            nX6 = nX6.h(nX7);
            if (nX4.equals(nX5)) break;
            nX5 = new nX(nX4);
        }
        return nX4;
    }

    private static nX b(nX nX2, nX nX3, nX nX4) {
        int n2 = 1;
        nX nX5 = nX2;
        nX2 = nX2.f(new nX(nX5.e, -1)).i(nX2.f(nX3));
        nX3 = new nX(nX2);
        nX5 = new nX(nX2);
        nX nX6 = new nX(nX3);
        for (int i2 = 0; i2 < 10000; ++i2) {
            nX5 = nX5.h(nX2);
            nX nX7 = (nX5 = nX5.h(nX2)).j(n2 += 2);
            if ((nX3 = nX3.f(nX7)).equals(nX6)) break;
            nX6 = new nX(nX3);
        }
        return nX3.h(nX4);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a
    extends Enum<a> {
        public static final int ROUND_DOWN$7d08181e = 1;
        public static final int ROUND_UP$7d08181e = 2;
        public static final int ROUND_HALF_UP$7d08181e = 3;
        public static final int ROUND_HALF_DOWN$7d08181e = 4;
        public static final int ROUND_HALF_EVEN$7d08181e = 5;
        public static final int ROUND_HALF_ODD$7d08181e = 6;
        public static final int ROUND_CEIL$7d08181e = 7;
        public static final int ROUND_FLOOR$7d08181e = 8;
        private static final /* synthetic */ int[] $VALUES$492aff43;

        public static int[] values$5a699a5c() {
            return (int[])$VALUES$492aff43.clone();
        }

        private a() {
        }

        static {
            $VALUES$492aff43 = new int[]{ROUND_DOWN$7d08181e, ROUND_UP$7d08181e, ROUND_HALF_UP$7d08181e, ROUND_HALF_DOWN$7d08181e, ROUND_HALF_EVEN$7d08181e, ROUND_HALF_ODD$7d08181e, ROUND_CEIL$7d08181e, ROUND_FLOOR$7d08181e};
        }
    }
}

