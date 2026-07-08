/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.nX;
import org.valkyrienskies.core.impl.shadow.nZ;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.oa
 */
public final class oa_0 {
    private static final String a = "pow";

    private oa_0() {
    }

    private static nX[] a(nZ nZ2, String string) {
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
            nZ nZ3 = nZ2;
            if (n4 == nZ3.a / 2 << 2) {
                n3 = n2;
                break;
            }
            if (cArray[n2] < '0' || cArray[n2] > '9' || bl) continue;
            ++n4;
        }
        nXArray[0] = nZ2.a(new String(cArray, 0, n3));
        for (n2 = 0; n2 < cArray.length; ++n2) {
            cArray[n2] = string.charAt(n2);
            if (cArray[n2] < '0' || cArray[n2] > '9' || n2 >= n3) continue;
            cArray[n2] = 48;
        }
        nXArray[1] = nZ2.a(new String(cArray));
        return nXArray;
    }

    private static nX[] i(nX nX2) {
        nX[] nXArray = new nX[2];
        nX nX3 = nX2;
        nX nX4 = nX3.h(nX3.f(nX2.E() / 2));
        nXArray[0] = nX2.f(nX4).g(nX4);
        nXArray[1] = nX2.g(nXArray[0]);
        return nXArray;
    }

    private static nX[] a(nX[] nXArray, nX[] nXArray2) {
        nX[] nXArray3 = new nX[2];
        nX[] nXArray4 = nXArray3;
        nXArray3[1] = nXArray[0].F();
        nXArray4[0] = nXArray[0].h(nXArray2[0]);
        if (nXArray4[0].R() == 1 || nXArray4[0].equals(nXArray4[1])) {
            return nXArray4;
        }
        nXArray4[1] = nXArray[0].h(nXArray2[1]).f(nXArray[1].h(nXArray2[0])).f(nXArray[1].h(nXArray2[1]));
        return nXArray4;
    }

    private static nX[] b(nX[] nXArray, nX[] nXArray2) {
        nX[] nXArray3 = new nX[2];
        nX[] nXArray4 = nXArray3;
        nXArray3[0] = nXArray[0].i(nXArray2[0]);
        nXArray4[1] = nXArray[1].h(nXArray2[0]).g(nXArray[0].h(nXArray2[1]));
        nXArray4[1] = nXArray4[1].i(nXArray2[0].h(nXArray2[0]).f(nXArray2[0].h(nXArray2[1])));
        return nXArray4;
    }

    private static nX a(nX[] nXArray, int n2) {
        int n3;
        boolean bl = false;
        nX[] nXArray2 = new nX[2];
        nX[] nXArray3 = new nX[2];
        nX[] nXArray4 = nXArray3;
        nXArray3[0] = nXArray[0].G();
        nXArray4[1] = nXArray[0].F();
        if (n2 == 0) {
            return nXArray4[0].f(nXArray4[1]);
        }
        if (n2 < 0) {
            bl = true;
            n2 = -n2;
        }
        do {
            int n4;
            nXArray2[0] = new nX(nXArray[0]);
            nXArray2[1] = new nX(nXArray[1]);
            n3 = 1;
            while (true) {
                n4 = n3;
                if ((n3 <<= 1) > n2) break;
                nXArray2 = oa_0.a(nXArray2, nXArray2);
            }
            n3 = n4;
            nXArray4 = oa_0.a(nXArray4, nXArray2);
        } while ((n2 -= n3) > 0);
        nXArray4[0] = nXArray4[0].f(nXArray4[1]);
        if (bl) {
            nXArray4[0] = nXArray[0].G().i(nXArray4[0]);
        }
        return nXArray4[0];
    }

    public static nX a(nX nX2, int n2) {
        int n3;
        boolean bl = false;
        nX nX3 = nX2.G();
        if (n2 == 0) {
            return nX3;
        }
        if (n2 < 0) {
            bl = true;
            n2 = -n2;
        }
        do {
            int n4;
            nX nX4;
            nX nX5 = new nX(nX2);
            n3 = 1;
            do {
                nX4 = new nX(nX5);
                n4 = n3;
                nX nX6 = nX5;
                nX5 = nX6.h(nX6);
            } while (n2 > (n3 <<= 1));
            nX5 = nX4;
            n3 = n4;
            nX3 = nX3.h(nX5);
        } while ((n2 -= n3) > 0);
        if (bl) {
            nX3 = nX2.G().i(nX3);
        }
        return nX2.a(nX3);
    }

    public static nX a(nX nX2) {
        nX nX3 = nX2.K();
        nX nX4 = nX2.g(nX3);
        int n2 = nX3.M();
        if (n2 > 0x7FFFFFFE) {
            return nX2.a((byte)1, (byte)1);
        }
        if (n2 < -2147483646) {
            return nX2.C();
        }
        nX2 = oa_0.a(nX2.e.l(), n2);
        nX nX5 = nX4;
        nX4 = nX5.G();
        nX nX6 = nX5.G();
        nX nX7 = nX5.G();
        nX nX8 = new nX(nX4);
        for (int i2 = 1; i2 < 90 && !(nX4 = nX4.f((nX6 = nX6.h(nX5)).h(nX7 = nX7.j(i2)))).equals(nX8); ++i2) {
            nX8 = new nX(nX4);
        }
        nX5 = nX4;
        return nX2.h(nX5);
    }

    private static nX j(nX nX2) {
        nX nX3 = nX2.G();
        nX nX4 = nX2.G();
        nX nX5 = nX2.G();
        nX nX6 = new nX(nX3);
        for (int i2 = 1; i2 < 90 && !(nX3 = nX3.f((nX4 = nX4.h(nX2)).h(nX5 = nX5.j(i2)))).equals(nX6); ++i2) {
            nX6 = new nX(nX3);
        }
        return nX3;
    }

    public static nX b(nX nX2) {
        int n2;
        block8: {
            block7: {
                n2 = 0;
                nX nX3 = nX2;
                if (nX3.equals(nX3.F())) break block7;
                nX nX4 = nX2;
                if (!nX4.b(nX4.F()) && !nX2.J()) break block8;
            }
            nX nX5 = nX2;
            nX5.e.a(1);
            nX nX6 = nX2;
            return nX2.a(1, "ln", nX6, nX6.a((byte)1, (byte)3));
        }
        if (nX2.R() == 1) {
            return nX2;
        }
        nX[] nXArray = new nX(nX2);
        int n3 = nXArray.N();
        nXArray = nXArray.i(oa_0.a(nX2.e(10000), n3));
        int n4 = nXArray.L().M();
        while (n4 > 2) {
            n4 >>= 1;
            ++n2;
        }
        nXArray = oa_0.i((nX)nXArray);
        nX[] nXArray2 = new nX[2];
        Object object = nXArray2;
        nXArray2[0] = oa_0.a(nX2.H(), n2);
        nXArray[0] = nXArray[0].i(object[0]);
        nXArray[1] = nXArray[1].i(object[0]);
        object[0] = nX2.a("1.33333");
        while (nXArray[0].f(nXArray[1]).c(object[0])) {
            nXArray[0] = nXArray[0].j(2);
            nXArray[1] = nXArray[1].j(2);
            ++n2;
        }
        object = nXArray;
        Object object2 = nXArray[0].j(4).f(object[1].j(4));
        nX nX7 = object2.f(object[0].a("-0.25")).i(object2.f(object[0].a("0.25")));
        nX nX8 = new nX(nX7);
        nX nX9 = new nX(nX7);
        nX nX10 = new nX(nX8);
        int n5 = 1;
        for (int i2 = 0; i2 < 10000; ++i2) {
            nX9 = nX9.h(nX7);
            object2 = (nX9 = nX9.h(nX7)).j(n5 += 2);
            if ((nX8 = nX8.f((nX)object2)).equals(nX10)) break;
            nX10 = new nX(nX8);
        }
        nX8 = nX8.h(object[0].H());
        object2 = oa_0.i(nX8);
        nXArray[0] = nX2.a("" + (n2 + 4 * n3));
        nXArray[1] = nX2.F();
        object = nX2;
        object = oa_0.a(object.e.n(), nXArray);
        object2[0] = object2[0].f(object[0]);
        object2[1] = object2[1].f(object[1]);
        nXArray[0] = nX2.a("" + 4 * n3);
        nXArray[1] = nX2.F();
        object = nX2;
        object = oa_0.a(object.e.o(), nXArray);
        object2[0] = object2[0].f(object[0]);
        object2[1] = object2[1].f(object[1]);
        return nX2.a(object2[0].f(object2[1]));
    }

    private static nX[] a(nX[] nXArray) {
        nX nX2 = nXArray[0].j(4).f(nXArray[1].j(4));
        nX nX3 = nX2.f(nXArray[0].a("-0.25")).i(nX2.f(nXArray[0].a("0.25")));
        nX nX4 = new nX(nX3);
        nX nX5 = new nX(nX3);
        nX nX6 = new nX(nX4);
        int n2 = 1;
        for (int i2 = 0; i2 < 10000; ++i2) {
            nX5 = nX5.h(nX3);
            nX2 = (nX5 = nX5.h(nX3)).j(n2 += 2);
            if ((nX4 = nX4.f(nX2)).equals(nX6)) break;
            nX6 = new nX(nX4);
        }
        nX4 = nX4.h(nXArray[0].H());
        return oa_0.i(nX4);
    }

    public static nX a(nX nX2, nX nX3) {
        Object object = nX2;
        nZ nZ2 = ((nX)object).e;
        object = nZ2;
        object = nX3;
        object = ((nX)object).e;
        if (nZ2.a != ((nZ)object).a) {
            object = nX2;
            ((nX)object).e.a(1);
            nX nX4 = nX2;
            nX nX5 = nX4.a(nX4.F());
            nX4.a(nX4.F()).d = (byte)3;
            return nX2.a(1, a, nX2, nX5);
        }
        nX nX6 = nX2.F();
        nX nX7 = nX2.G();
        nX nX8 = nX2.H();
        boolean bl = false;
        if (nX3.equals(nX6)) {
            return nX2.a(nX7);
        }
        if (nX3.equals(nX7)) {
            if (nX2.J()) {
                object = nX2;
                ((nX)object).e.a(1);
                nX nX9 = nX2;
                return nX2.a(1, a, nX9, nX9);
            }
            return nX2;
        }
        if (nX2.J() || nX3.J()) {
            object = nX2;
            ((nX)object).e.a(1);
            nX nX10 = nX2;
            return nX2.a(1, a, nX10, nX10.a((byte)1, (byte)3));
        }
        if (nX2.equals(nX6)) {
            if (nX.a(nX7, nX2).c(nX6)) {
                if (nX3.c(nX6)) {
                    return nX2.a(nX6);
                }
                nX nX11 = nX2;
                return nX11.a(nX11.a((byte)1, (byte)1));
            }
            if (nX3.R() == 0 && nX3.K().equals(nX3) && !nX3.e(nX8).equals(nX6)) {
                if (nX3.c(nX6)) {
                    return nX2.a(nX6.P());
                }
                nX nX12 = nX2;
                return nX12.a(nX12.a((byte)-1, (byte)1));
            }
            if (nX3.c(nX6)) {
                return nX2.a(nX6);
            }
            nX nX13 = nX2;
            return nX13.a(nX13.a((byte)1, (byte)1));
        }
        if (nX2.b(nX6)) {
            nX2 = nX2.P();
            bl = true;
        }
        if (nX2.c(nX7) && nX3.R() == 1) {
            if (nX3.c(nX6)) {
                return nX3;
            }
            return nX2.a(nX6);
        }
        if (nX2.b(nX7) && nX3.R() == 1) {
            if (nX3.c(nX6)) {
                return nX2.a(nX6);
            }
            return nX2.a(nX.a(nX3, nX7));
        }
        if (nX2.equals(nX7) && nX3.R() == 1) {
            object = nX2;
            ((nX)object).e.a(1);
            nX nX14 = nX2;
            return nX2.a(1, a, nX14, nX14.a((byte)1, (byte)3));
        }
        if (nX2.R() == 1) {
            if (bl) {
                if (nX3.R() == 0 && nX3.K().equals(nX3) && !nX3.e(nX8).equals(nX6)) {
                    if (nX3.c(nX6)) {
                        nX nX15 = nX2;
                        return nX15.a(nX15.a((byte)-1, (byte)1));
                    }
                    return nX2.a(nX6.P());
                }
                if (nX3.c(nX6)) {
                    nX nX16 = nX2;
                    return nX16.a(nX16.a((byte)1, (byte)1));
                }
                return nX2.a(nX6);
            }
            if (nX3.c(nX6)) {
                return nX2;
            }
            return nX2.a(nX6);
        }
        if (bl && !nX3.K().equals(nX3)) {
            object = nX2;
            ((nX)object).e.a(1);
            nX nX17 = nX2;
            return nX2.a(1, a, nX17, nX17.a((byte)1, (byte)3));
        }
        if (nX3.b(nX2.e(100000000)) && nX3.c(nX2.e(-100000000))) {
            nX nX18 = nX3.K();
            int n2 = nX18.M();
            if ((nX18 = nX3.g(nX18)).d(nX6)) {
                nX18 = nX18.h(oa_0.b(nX2));
                object = nX2;
                object = ((nX)object).e;
                nX nX19 = nX18.i(((nZ)object).f).K();
                object = nX2;
                object = ((nX)object).e;
                nX18 = nX18.g(nX19.h(((nZ)object).f));
                nX7 = oa_0.a(oa_0.i(nX2), n2);
                nX7 = nX7.h(oa_0.a(nX8, nX19.M()));
                nX7 = nX7.h(oa_0.a(nX18));
            } else {
                nX7 = oa_0.a(oa_0.i(nX2), n2);
            }
        } else {
            nX7 = oa_0.a(oa_0.b(nX2).h(nX3));
        }
        if (bl && nX3.K().equals(nX3) && !nX3.e(nX8).equals(nX6)) {
            nX7 = nX7.P();
        }
        return nX2.a(nX7);
    }

    private static nX b(nX[] object) {
        nX nX2;
        nX nX3 = nX2 = object[0].f(object[1]);
        nX nX4 = nX2;
        nX2 = nX4.h(nX4);
        nX nX5 = nX3;
        object = object[0].G();
        nX nX6 = new nX(nX3);
        for (int i2 = 3; i2 < 90; i2 += 2) {
            nX5 = nX5.h(nX2);
            if ((nX3 = nX3.f((nX5 = nX5.P()).h((nX)(object = ((nX)object).j((i2 - 1) * i2))))).equals(nX6)) break;
            nX6 = new nX(nX3);
        }
        return nX3;
    }

    private static nX c(nX[] object) {
        nX nX2;
        nX nX3 = nX2 = object[0].G();
        nX nX4 = nX2;
        object = object[0].f(object[1]);
        object = object.h((nX)object);
        nX nX5 = new nX(nX4);
        for (int i2 = 2; i2 < 90; i2 += 2) {
            nX3 = nX3.h((nX)object);
            if ((nX4 = nX4.f((nX3 = nX3.P()).h(nX2 = nX2.j((i2 - 1) * i2)))).equals(nX5)) break;
            nX5 = new nX(nX4);
        }
        return nX4;
    }

    public static nX c(nX nX2) {
        nX[] nXArray = nX2;
        nXArray = nXArray.e;
        Object object = nXArray.e;
        nXArray = nX2;
        nXArray = nXArray.e;
        nXArray = nXArray.b;
        boolean bl = false;
        nX nX3 = nX2.e(((nX)object).i(2));
        if (nX3.b((nX)nXArray)) {
            nX3 = nX3.P();
            bl = true;
        }
        if (nX3.c(((nX)object).j(2))) {
            nX3 = ((nX)object).g(nX3);
        }
        if (nX3.b(((nX)object).j(4))) {
            object = oa_0.b(oa_0.i(nX3));
        } else {
            object = new nX[2];
            nXArray = nX2;
            nXArray = nXArray.e.k();
            object[0] = nXArray[0].j(2).g(nX3);
            object[1] = nXArray[1].j(2);
            object = oa_0.c((nX[])object);
        }
        if (bl) {
            object = ((nX)object).P();
        }
        return nX2.a((nX)object);
    }

    public static nX d(nX nX2) {
        nX[] nXArray = nX2;
        nXArray = nXArray.e;
        Object object = nXArray.e;
        nXArray = nX2;
        nXArray = nXArray.e;
        nXArray = nXArray.b;
        boolean bl = false;
        nX nX3 = nX2.e(((nX)object).i(2));
        if (nX3.b((nX)nXArray)) {
            nX3 = nX3.P();
        }
        if (nX3.c(((nX)object).j(2))) {
            nX3 = ((nX)object).g(nX3);
            bl = true;
        }
        if (nX3.b(((nX)object).j(4))) {
            nX[] nXArray2 = new nX[2];
            object = nXArray2;
            nXArray2[0] = nX3;
            object[1] = nXArray;
            object = oa_0.c((nX[])object);
        } else {
            object = new nX[2];
            nXArray = nX2;
            nXArray = nXArray.e.k();
            object[0] = nXArray[0].j(2).g(nX3);
            object[1] = nXArray[1].j(2);
            object = oa_0.b((nX[])object);
        }
        if (bl) {
            object = ((nX)object).P();
        }
        return nX2.a((nX)object);
    }

    public static nX e(nX nX2) {
        return oa_0.c(nX2).i(oa_0.d(nX2));
    }

    private static nX k(nX nX2) {
        nX nX3 = new nX(nX2);
        nX nX4 = new nX(nX3);
        nX nX5 = new nX(nX3);
        for (int i2 = 3; i2 < 90; i2 += 2) {
            nX4 = nX4.h(nX2);
            nX4 = nX4.h(nX2);
            if ((nX3 = nX3.f((nX4 = nX4.P()).j(i2))).equals(nX5)) break;
            nX5 = new nX(nX3);
        }
        return nX3;
    }

    public static nX f(nX nX2) {
        nX[] nXArray = nX2;
        nXArray = nXArray.e;
        Object object = nXArray.b;
        nXArray = nX2;
        nXArray = nXArray.e;
        Object object2 = nXArray.c;
        nXArray = nX2;
        Object object3 = nXArray.e.i();
        nXArray = nX2;
        nXArray = nXArray.e.k();
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        Object object4 = object3[0].g((nX)object2).f(object3[1]);
        nX nX3 = new nX(nX2);
        if (nX3.b((nX)object)) {
            bl2 = true;
            nX3 = nX3.P();
        }
        if (nX3.c((nX)object2)) {
            bl = true;
            nX3 = object2.i(nX3);
        }
        if (nX3.c((nX)object4)) {
            object = new nX[2];
            bl3 = true;
            object[0] = object3[0].g((nX)object2);
            object[1] = object3[1];
            object3 = oa_0.i(nX3);
            nX[] nXArray2 = oa_0.a((nX[])object3, (nX[])object);
            object4 = nXArray2;
            nXArray2[0] = object4[0].f((nX)object2);
            object3[0] = ((nX)object3[0]).g((nX)object[0]);
            object3[1] = ((nX)object3[1]).g((nX)object[1]);
            object2 = object4;
            object = object3;
            nX[] nXArray3 = new nX[2];
            object3 = nXArray3;
            nXArray3[0] = ((nX)object[0]).i(object2[0]);
            object3[1] = ((nX)object[1]).h(object2[0]).g(((nX)object[0]).h(object2[1]));
            object3[1] = ((nX)object3[1]).i(object2[0].h(object2[0]).f(object2[0].h(object2[1])));
            nX3 = ((nX)object3[0]).f((nX)object3[1]);
        }
        object = nX3;
        object2 = new nX((nX)object);
        object3 = new nX((nX)object2);
        object4 = new nX((nX)object2);
        for (int i2 = 3; i2 < 90; i2 += 2) {
            object3 = ((nX)object3).h((nX)object);
            object3 = ((nX)object3).h((nX)object);
            if ((object2 = object2.f(((nX)(object3 = ((nX)object3).P())).j(i2))).equals(object4)) break;
            object4 = new nX((nX)object2);
        }
        object = object2;
        if (bl3) {
            object = ((nX)object).f(nXArray[0].j(8)).f(nXArray[1].j(8));
        }
        if (bl) {
            object = nXArray[0].j(2).g((nX)object).f(nXArray[1].j(2));
        }
        if (bl2) {
            object = ((nX)object).P();
        }
        return nX2.a((nX)object);
    }

    public static nX g(nX nX2) {
        nX nX3 = nX2;
        nX nX4 = nX2;
        return oa_0.f(nX3.i(nX3.G().g(nX4.h(nX4)).Q()));
    }

    public static nX h(nX nX2) {
        boolean bl = false;
        nX nX3 = nX2;
        if (nX3.b(nX3.F())) {
            bl = true;
        }
        nX nX4 = nX2;
        nX nX5 = nX2 = nX.a(nX4, nX4.G());
        nX nX6 = oa_0.f(nX2.G().g(nX5.h(nX5)).Q().i(nX2));
        if (bl) {
            Object object = nX2;
            object = ((nX)object).e;
            nX6 = ((nZ)object).e.g(nX6);
        }
        return nX2.a(nX6);
    }
}

