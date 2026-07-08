/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.nZ;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oa_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class nX
implements kO<nX> {
    private static int f = 10000;
    private static int g = -32767;
    private static int h = 32768;
    private static int i = 32760;
    private static byte j = 0;
    private static byte k = 1;
    private static byte l = 2;
    private static byte m = 3;
    private static final String n = "NaN";
    private static final String o = "Infinity";
    private static final String p = "-Infinity";
    private static final String q = "add";
    private static final String r = "multiply";
    private static final String s = "divide";
    private static final String t = "sqrt";
    private static final String u = "align";
    private static final String v = "trunc";
    private static final String w = "nextAfter";
    private static final String x = "lessThan";
    private static final String y = "greaterThan";
    private static final String z = "newInstance";
    protected int[] a;
    protected byte b;
    protected int c;
    protected byte d;
    final nZ e;

    protected nX(nZ nZ2) {
        nZ nZ3 = nZ2;
        this.a = new int[nZ3.a];
        this.b = 1;
        this.c = 0;
        this.d = 0;
        this.e = nZ2;
    }

    protected nX(nZ nZ2, byte by) {
        this(nZ2, (long)by);
    }

    protected nX(nZ nZ2, int n2) {
        this(nZ2, (long)n2);
    }

    protected nX(nZ nZ2, long l2) {
        nZ nZ3 = nZ2;
        this.a = new int[nZ3.a];
        this.d = 0;
        this.e = nZ2;
        int n2 = 0;
        if (l2 == Long.MIN_VALUE) {
            n2 = 1;
            ++l2;
        }
        if (l2 < 0L) {
            this.b = (byte)-1;
            l2 = -l2;
        } else {
            this.b = 1;
        }
        this.c = 0;
        while (l2 != 0L) {
            System.arraycopy(this.a, this.a.length - this.c, this.a, this.a.length - 1 - this.c, this.c);
            this.a[this.a.length - 1] = (int)(l2 % 10000L);
            l2 /= 10000L;
            ++this.c;
        }
        if (n2 != 0) {
            for (n2 = 0; n2 < this.a.length - 1; ++n2) {
                if (this.a[n2] == 0) continue;
                int n3 = n2;
                this.a[n3] = this.a[n3] + 1;
                return;
            }
        }
    }

    protected nX(nZ nZ2, double d2) {
        nZ nZ3 = nZ2;
        this.a = new int[nZ3.a];
        this.b = 1;
        this.c = 0;
        this.d = 0;
        this.e = nZ2;
        long l2 = Double.doubleToLongBits(d2);
        long l3 = l2 & 0xFFFFFFFFFFFFFL;
        int n2 = (int)((l2 & 0x7FF0000000000000L) >> 52) - 1023;
        if (n2 == -1023) {
            if (d2 == 0.0) {
                if ((l2 & Long.MIN_VALUE) != 0L) {
                    this.b = (byte)-1;
                }
                return;
            }
            ++n2;
            while ((l3 & 0x10000000000000L) == 0L) {
                --n2;
                l3 <<= 1;
            }
            l3 &= 0xFFFFFFFFFFFFFL;
        }
        if (n2 == 1024) {
            double d3 = d2;
            if (d3 != d3) {
                this.b = 1;
                this.d = (byte)3;
                return;
            }
            if (d2 < 0.0) {
                this.b = (byte)-1;
                this.d = 1;
                return;
            }
            this.b = 1;
            this.d = 1;
            return;
        }
        nX nX2 = new nX(nZ2, l3);
        nZ nZ4 = nZ2;
        nX2 = nX2.i(new nX(nZ2, 0x10000000000000L)).f(nZ4.c);
        nZ4 = nZ2;
        nX2 = nX2.h(oa_0.a(nZ4.d, n2));
        if ((l2 & Long.MIN_VALUE) != 0L) {
            nX2 = nX2.P();
        }
        System.arraycopy(nX2.a, 0, this.a, 0, this.a.length);
        this.b = nX2.b;
        this.c = nX2.c;
        this.d = nX2.d;
    }

    public nX(nX nX2) {
        this.a = (int[])nX2.a.clone();
        this.b = nX2.b;
        this.c = nX2.c;
        this.d = nX2.d;
        this.e = nX2.e;
    }

    protected nX(nZ nZ2, String string) {
        int n2;
        int n3;
        String string2;
        Object object = nZ2;
        this.a = new int[((nZ)object).a];
        this.b = 1;
        this.c = 0;
        this.d = 0;
        this.e = nZ2;
        int n4 = 0;
        object = this;
        object = ((nX)object).e;
        object = new char[(((nZ)object).a << 2) + 8];
        if (string.equals(o)) {
            this.b = 1;
            this.d = 1;
            return;
        }
        if (string.equals(p)) {
            this.b = (byte)-1;
            this.d = 1;
            return;
        }
        if (string.equals(n)) {
            this.b = 1;
            this.d = (byte)3;
            return;
        }
        int n5 = string.indexOf("e");
        if (n5 == -1) {
            n5 = string.indexOf("E");
        }
        int n6 = 0;
        if (n5 != -1) {
            string2 = string.substring(0, n5);
            string = string.substring(n5 + 1);
            n3 = 0;
            for (n2 = 0; n2 < string.length(); ++n2) {
                if (string.charAt(n2) == '-') {
                    n3 = 1;
                    continue;
                }
                if (string.charAt(n2) < '0' || string.charAt(n2) > '9') continue;
                n6 = n6 * 10 + string.charAt(n2) - 48;
            }
            if (n3 != 0) {
                n6 = -n6;
            }
        } else {
            string2 = string;
        }
        if (string2.indexOf("-") != -1) {
            this.b = (byte)-1;
        }
        n5 = 0;
        int n7 = 0;
        while (string2.charAt(n5) < '1' || string2.charAt(n5) > '9') {
            if (n4 != 0 && string2.charAt(n5) == '0') {
                --n7;
            }
            if (string2.charAt(n5) == '.') {
                n4 = 1;
            }
            if (++n5 != string2.length()) continue;
        }
        n3 = 4;
        object[0] = 48;
        object[1] = 48;
        object[2] = 48;
        object[3] = 48;
        n2 = 0;
        while (n5 != string2.length() && n3 != (this.a.length << 2) + 4 + 1) {
            if (string2.charAt(n5) == '.') {
                n4 = 1;
                n7 = n2;
                ++n5;
                continue;
            }
            if (string2.charAt(n5) < '0' || string2.charAt(n5) > '9') {
                ++n5;
                continue;
            }
            object[n3] = string2.charAt(n5);
            ++n3;
            ++n5;
            ++n2;
        }
        if (n4 != 0 && n3 != 4) {
            while (--n3 != 4 && object[n3] == 48) {
                --n2;
            }
        }
        if (n4 != 0 && n2 == 0) {
            n7 = 0;
        }
        if (n4 == 0) {
            n7 = n3 - 4;
        }
        for (n5 = n2 - 1 + 4; n5 > 4 && object[n5] == 48; --n5) {
        }
        n4 = (400 - n7 - n6 % 4) % 4;
        n3 = 4 - n4;
        n7 += n4;
        while (n5 - n3 < this.a.length << 2) {
            for (n4 = 0; n4 < 4; ++n4) {
                object[++n5] = 48;
            }
        }
        for (n4 = this.a.length - 1; n4 >= 0; --n4) {
            this.a[n4] = (int)((object[n3] - 48) * 1000 + (object[n3 + 1] - 48) * 100 + (object[n3 + 2] - 48) * 10 + (object[n3 + 3] - 48));
            n3 += 4;
        }
        this.c = (n7 + n6) / 4;
        if (n3 < ((Object)object).length) {
            this.h((int)((object[n3] - 48) * 1000));
        }
    }

    protected nX(nZ nZ2, byte by, byte by2) {
        this.e = nZ2;
        this.a = new int[nZ2.a];
        this.b = by;
        this.c = 0;
        this.d = by2;
    }

    public nX C() {
        nX nX2 = this;
        return new nX(nX2.e);
    }

    @Override
    public nX a(byte by) {
        nX nX2 = this;
        return new nX(nX2.e, by);
    }

    @Override
    public nX e(int n2) {
        nX nX2 = this;
        return new nX(nX2.e, n2);
    }

    @Override
    public nX a(long l2) {
        nX nX2 = this;
        return new nX(nX2.e, 0x10000000000000L);
    }

    @Override
    public nX h(double d2) {
        nX nX2 = this;
        return new nX(nX2.e, d2);
    }

    @Override
    public nX a(nX nX2) {
        nZ nZ2 = this.e;
        Object object = nZ2;
        object = nX2.e;
        if (nZ2.a != ((nZ)object).a) {
            this.e.a(1);
            nX nX3 = this;
            object = nX3;
            object = nX3.e;
            object = nX3.a(((nZ)object).b);
            nX3.a(((nZ)object).b).d = (byte)3;
            return this.a(1, z, nX2, (nX)object);
        }
        return new nX(nX2);
    }

    @Override
    public nX a(String string) {
        return new nX(this.e, string);
    }

    public nX a(byte by, byte by2) {
        return this.e.a(by, by2);
    }

    public final nZ D() {
        return this.e;
    }

    public final int E() {
        nZ nZ2 = this.e;
        return nZ2.a;
    }

    public final nX F() {
        nZ nZ2 = this.e;
        return nZ2.b;
    }

    public final nX G() {
        nZ nZ2 = this.e;
        return nZ2.c;
    }

    public final nX H() {
        nZ nZ2 = this.e;
        return nZ2.d;
    }

    private void S() {
        for (int i2 = this.a.length - 1; i2 > 0; --i2) {
            this.a[i2] = this.a[i2 - 1];
        }
        this.a[0] = 0;
        --this.c;
    }

    protected final void I() {
        for (int i2 = 0; i2 < this.a.length - 1; ++i2) {
            this.a[i2] = this.a[i2 + 1];
        }
        this.a[this.a.length - 1] = 0;
        ++this.c;
    }

    private int k(int n2) {
        int n3;
        int n4 = 0;
        boolean bl = false;
        int n5 = n3 = this.c - n2;
        if (n3 < 0) {
            n5 = -n5;
        }
        if (n3 == 0) {
            return 0;
        }
        if (n5 > this.a.length + 1) {
            Arrays.fill(this.a, 0);
            this.c = n2;
            this.e.a(16);
            nX nX2 = this;
            this.a(16, u, nX2, nX2);
            return 0;
        }
        for (n2 = 0; n2 < n5; ++n2) {
            if (n3 < 0) {
                if (n4 != 0) {
                    bl = true;
                }
                n4 = this.a[0];
                this.I();
                continue;
            }
            this.S();
        }
        if (bl) {
            this.e.a(16);
            nX nX3 = this;
            this.a(16, u, nX3, nX3);
        }
        return n4;
    }

    @Override
    public final boolean b(nX nX2) {
        nZ nZ2 = this.e;
        Object object = nZ2;
        object = nX2.e;
        if (nZ2.a != ((nZ)object).a) {
            this.e.a(1);
            nX nX3 = this;
            object = nX3.a(nX3.F());
            nX3.a(nX3.F()).d = (byte)3;
            this.a(1, x, nX2, (nX)object);
            return false;
        }
        if (this.J() || nX2.J()) {
            this.e.a(1);
            nX nX4 = this;
            this.a(1, x, nX2, nX4.a(nX4.F()));
            return false;
        }
        return nX.b(this, nX2) < 0;
    }

    @Override
    public final boolean c(nX nX2) {
        nZ nZ2 = this.e;
        Object object = nZ2;
        object = nX2.e;
        if (nZ2.a != ((nZ)object).a) {
            this.e.a(1);
            nX nX3 = this;
            object = nX3.a(nX3.F());
            nX3.a(nX3.F()).d = (byte)3;
            this.a(1, y, nX2, (nX)object);
            return false;
        }
        if (this.J() || nX2.J()) {
            this.e.a(1);
            nX nX4 = this;
            this.a(1, y, nX2, nX4.a(nX4.F()));
            return false;
        }
        return nX.b(this, nX2) > 0;
    }

    private boolean T() {
        if (this.J()) {
            this.e.a(1);
            nX nX2 = this;
            this.a(1, x, nX2, nX2.a(this.F()));
            return false;
        }
        return this.b < 0 || this.a[this.a.length - 1] == 0 && !this.Y();
    }

    private boolean U() {
        if (this.J()) {
            this.e.a(1);
            nX nX2 = this;
            this.a(1, x, nX2, nX2.a(this.F()));
            return false;
        }
        return this.b < 0 && (this.a[this.a.length - 1] != 0 || this.Y());
    }

    private boolean V() {
        if (this.J()) {
            this.e.a(1);
            nX nX2 = this;
            this.a(1, x, nX2, nX2.a(this.F()));
            return false;
        }
        return this.b > 0 || this.a[this.a.length - 1] == 0 && !this.Y();
    }

    private boolean W() {
        if (this.J()) {
            this.e.a(1);
            nX nX2 = this;
            this.a(1, x, nX2, nX2.a(this.F()));
            return false;
        }
        return this.b > 0 && (this.a[this.a.length - 1] != 0 || this.Y());
    }

    private nX X() {
        nX nX2 = this;
        nX nX3 = nX2.a(nX2);
        nX2.a(nX2).b = 1;
        return nX3;
    }

    private boolean Y() {
        return this.d == 1;
    }

    public final boolean J() {
        return this.d == 3 || this.d == 2;
    }

    private boolean Z() {
        if (this.J()) {
            this.e.a(1);
            nX nX2 = this;
            this.a(1, x, nX2, nX2.a(this.F()));
            return false;
        }
        return this.a[this.a.length - 1] == 0 && !this.Y();
    }

    public boolean equals(Object other) {
        block2: {
            nX nX2;
            block4: {
                block3: {
                    if (!(other instanceof nX)) break block2;
                    nX2 = nX2;
                    if (this.J() || nX2.J()) break block3;
                    nZ nZ2 = this.e;
                    nZ nZ3 = nZ2;
                    nZ3 = nX2.e;
                    if (nZ2.a == nZ3.a) break block4;
                }
                return false;
            }
            return nX.b(this, nX2) == 0;
        }
        return false;
    }

    public int hashCode() {
        return 17 + (this.Z() ? 0 : this.b << 8) + (this.d << 16) + this.c + Arrays.hashCode(this.a);
    }

    @Override
    public final boolean d(nX nX2) {
        block3: {
            block2: {
                if (this.J() || nX2.J()) break block2;
                nZ nZ2 = this.e;
                nZ nZ3 = nZ2;
                nZ3 = nX2.e;
                if (nZ2.a == nZ3.a) break block3;
            }
            return false;
        }
        return this.c(nX2) || this.b(nX2);
    }

    private static int b(nX nX2, nX nX3) {
        if (nX2.a[nX2.a.length - 1] == 0 && nX3.a[nX3.a.length - 1] == 0 && nX2.d == 0 && nX3.d == 0) {
            return 0;
        }
        if (nX2.b != nX3.b) {
            if (nX2.b == -1) {
                return -1;
            }
            return 1;
        }
        if (nX2.d == 1 && nX3.d == 0) {
            return nX2.b;
        }
        if (nX2.d == 0 && nX3.d == 1) {
            return -nX3.b;
        }
        if (nX2.d == 1 && nX3.d == 1) {
            return 0;
        }
        if (nX3.a[nX3.a.length - 1] != 0 && nX2.a[nX3.a.length - 1] != 0) {
            if (nX2.c < nX3.c) {
                return -nX2.b;
            }
            if (nX2.c > nX3.c) {
                return nX2.b;
            }
        }
        for (int i2 = nX2.a.length - 1; i2 >= 0; --i2) {
            if (nX2.a[i2] > nX3.a[i2]) {
                return nX2.b;
            }
            if (nX2.a[i2] >= nX3.a[i2]) continue;
            return -nX2.b;
        }
        return 0;
    }

    public final nX K() {
        return this.l(nZ.a.ROUND_HALF_EVEN$7d08181e);
    }

    public final nX L() {
        return this.l(nZ.a.ROUND_FLOOR$7d08181e);
    }

    private nX aa() {
        return this.l(nZ.a.ROUND_CEIL$7d08181e);
    }

    @Override
    public final nX e(nX nX2) {
        nX nX3 = this;
        nX nX4 = nX3.i(nX2);
        nX2 = nX3.g(nX4.l(nZ.a.ROUND_HALF_EVEN$7d08181e).h(nX2));
        if (nX2.a[this.a.length - 1] == 0) {
            nX2.b = this.b;
        }
        return nX2;
    }

    private nX l(int n2) {
        boolean bl = false;
        if (this.J()) {
            nX nX2 = this;
            return nX2.a(nX2);
        }
        if (this.d == 1) {
            nX nX3 = this;
            return nX3.a(nX3);
        }
        if (this.a[this.a.length - 1] == 0) {
            nX nX4 = this;
            return nX4.a(nX4);
        }
        if (this.c < 0) {
            this.e.a(16);
            nX nX5 = this;
            nX nX6 = nX5.a(nX5.F());
            nX6 = this.a(16, v, this, nX6);
            return nX6;
        }
        if (this.c >= this.a.length) {
            nX nX7 = this;
            return nX7.a(nX7);
        }
        nX nX8 = this;
        nX nX9 = nX8.a(nX8);
        for (int i2 = 0; i2 < this.a.length - nX9.c; ++i2) {
            bl |= nX9.a[i2] != 0;
            nX9.a[i2] = 0;
        }
        if (bl) {
            switch (1.a[n2 - 1]) {
                case 1: {
                    if (nX9.b != -1) break;
                    nX9 = nX9.f(this.e(-1));
                    break;
                }
                case 2: {
                    if (nX9.b != 1) break;
                    nX9 = nX9.f(this.G());
                    break;
                }
                default: {
                    nX nX10 = this.a("0.5");
                    nX nX11 = this.g(nX9);
                    this.g(nX9).b = 1;
                    if (nX11.c(nX10)) {
                        nX nX12 = this;
                        nX11 = nX12.a(nX12.G());
                        nX12.a(nX12.G()).b = this.b;
                        nX9 = nX9.f(nX11);
                    }
                    if (!nX11.equals(nX10) || nX9.c <= 0 || (nX9.a[this.a.length - nX9.c] & 1) == 0) break;
                    nX nX13 = this;
                    nX11 = nX13.a(nX13.G());
                    nX13.a(nX13.G()).b = this.b;
                    nX9 = nX9.f(nX11);
                }
            }
            this.e.a(16);
            nX9 = this.a(16, v, this, nX9);
            return nX9;
        }
        return nX9;
    }

    public final int M() {
        int n2 = 0;
        nX nX2 = this;
        if ((nX2 = nX2.l(nZ.a.ROUND_HALF_EVEN$7d08181e)).c(this.e(Integer.MAX_VALUE))) {
            return Integer.MAX_VALUE;
        }
        if (nX2.b(this.e(Integer.MIN_VALUE))) {
            return Integer.MIN_VALUE;
        }
        for (int i2 = this.a.length - 1; i2 >= this.a.length - nX2.c; --i2) {
            n2 = n2 * 10000 + nX2.a[i2];
        }
        if (nX2.b == -1) {
            n2 = -n2;
        }
        return n2;
    }

    public final int N() {
        return this.c - 1;
    }

    @Override
    public final nX f(int n2) {
        nX nX2 = this;
        nX nX3 = nX2.a(nX2.G());
        nX2.a(nX2.G()).c = n2 + 1;
        return nX3;
    }

    public final int O() {
        if (this.a[this.a.length - 1] > 1000) {
            return (this.c << 2) - 1;
        }
        if (this.a[this.a.length - 1] > 100) {
            return (this.c << 2) - 2;
        }
        if (this.a[this.a.length - 1] > 10) {
            return (this.c << 2) - 3;
        }
        return (this.c << 2) - 4;
    }

    @Override
    public final nX g(int n2) {
        nX nX2 = this;
        nX nX3 = nX2.a(nX2.G());
        nX3.c = n2 >= 0 ? n2 / 4 + 1 : (n2 + 1) / 4;
        switch ((n2 % 4 + 4) % 4) {
            case 0: {
                break;
            }
            case 1: {
                nX3 = nX3.i(10);
                break;
            }
            case 2: {
                nX3 = nX3.i(100);
                break;
            }
            default: {
                nX3 = nX3.i(1000);
            }
        }
        return nX3;
    }

    private int m(int n2) {
        int n3;
        n2 = 10000 - n2;
        for (n3 = 0; n3 < this.a.length; ++n3) {
            this.a[n3] = 10000 - this.a[n3] - 1;
        }
        n3 = n2 / 10000;
        n2 -= n3 * 10000;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            int n4 = this.a[i2] + n3;
            n3 = n4 / 10000;
            this.a[i2] = n4 - n3 * 10000;
        }
        return n2;
    }

    @Override
    public final nX f(nX nX2) {
        int n2;
        int n3;
        nZ nZ2 = this.e;
        Object object = nZ2;
        object = nX2.e;
        if (nZ2.a != ((nZ)object).a) {
            this.e.a(1);
            nX nX3 = this;
            object = nX3.a(nX3.F());
            nX3.a(nX3.F()).d = (byte)3;
            return this.a(1, q, nX2, (nX)object);
        }
        if (this.d != 0 || nX2.d != 0) {
            if (this.J()) {
                return this;
            }
            if (nX2.J()) {
                return nX2;
            }
            if (this.d == 1 && nX2.d == 0) {
                return this;
            }
            if (nX2.d == 1 && this.d == 0) {
                return nX2;
            }
            if (nX2.d == 1 && this.d == 1 && this.b == nX2.b) {
                return nX2;
            }
            if (nX2.d == 1 && this.d == 1 && this.b != nX2.b) {
                this.e.a(1);
                nX nX4 = this;
                object = nX4.a(nX4.F());
                nX4.a(nX4.F()).d = (byte)3;
                object = this.a(1, q, nX2, (nX)object);
                return object;
            }
        }
        nX nX5 = this;
        object = nX5.a(nX5);
        nX nX6 = this.a(nX2);
        nX nX7 = this;
        nX nX8 = nX7.a(nX7.F());
        byte by = ((nX)object).b;
        byte by2 = nX6.b;
        ((nX)object).b = 1;
        nX6.b = 1;
        byte by3 = by2;
        if (nX.b((nX)object, nX6) > 0) {
            by3 = by;
        }
        if (nX6.a[this.a.length - 1] == 0) {
            nX6.c = ((nX)object).c;
        }
        if (((nX)object).a[this.a.length - 1] == 0) {
            ((nX)object).c = nX6.c;
        }
        int n4 = 0;
        int n5 = 0;
        if (((nX)object).c < nX6.c) {
            n4 = ((nX)object).k(nX6.c);
        } else {
            n5 = nX6.k(((nX)object).c);
        }
        if (by != by2) {
            if (by == by3) {
                n5 = nX6.m(n5);
            } else {
                n4 = ((nX)object).m(n4);
            }
        }
        int n6 = 0;
        for (n3 = 0; n3 < this.a.length; ++n3) {
            n2 = ((nX)object).a[n3] + nX6.a[n3] + n6;
            n6 = n2 / 10000;
            nX8.a[n3] = n2 - n6 * 10000;
        }
        nX8.c = ((nX)object).c;
        nX8.b = by3;
        if (n6 != 0 && by == by2) {
            n3 = nX8.a[0];
            nX8.I();
            nX8.a[this.a.length - 1] = n6;
            n2 = nX8.h(n3);
            if (n2 != 0) {
                nX8 = this.a(n2, q, nX2, nX8);
            }
        }
        for (n3 = 0; n3 < this.a.length && nX8.a[this.a.length - 1] == 0; ++n3) {
            nX8.S();
            if (n3 != 0) continue;
            nX8.a[0] = n4 + n5;
            n4 = 0;
            n5 = 0;
        }
        if (nX8.a[this.a.length - 1] == 0) {
            nX8.c = 0;
            if (by != by2) {
                nX8.b = 1;
            }
        }
        if ((n3 = nX8.h(n4 + n5)) != 0) {
            nX8 = this.a(n3, q, nX2, nX8);
        }
        return nX8;
    }

    public final nX P() {
        nX nX2 = this;
        nX nX3 = nX2.a(nX2);
        nX2.a(nX2).b = -nX3.b;
        return nX3;
    }

    @Override
    public final nX g(nX nX2) {
        return this.f(nX2.P());
    }

    @Override
    protected int h(int n2) {
        int n3;
        nZ nZ2 = this.e;
        switch (1.a[nZ2.g - 1]) {
            case 4: {
                int n4 = 0;
                break;
            }
            case 5: {
                n3 = n2 != 0 ? 1 : 0;
                break;
            }
            case 6: {
                n3 = n2 >= 5000 ? 1 : 0;
                break;
            }
            case 7: {
                n3 = n2 > 5000 ? 1 : 0;
                break;
            }
            case 3: {
                n3 = n2 > 5000 || n2 == 5000 && (this.a[0] & 1) == 1 ? 1 : 0;
                break;
            }
            case 8: {
                n3 = n2 > 5000 || n2 == 5000 && (this.a[0] & 1) == 0 ? 1 : 0;
                break;
            }
            case 2: {
                n3 = this.b == 1 && n2 != 0 ? 1 : 0;
                break;
            }
            default: {
                int n4 = n3 = this.b == -1 && n2 != 0 ? 1 : 0;
            }
        }
        if (n3 != 0) {
            n3 = 1;
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                int n5 = this.a[i2] + n3;
                n3 = n5 / 10000;
                this.a[i2] = n5 - n3 * 10000;
            }
            if (n3 != 0) {
                this.I();
                this.a[this.a.length - 1] = n3;
            }
        }
        if (this.c < -32767) {
            this.e.a(8);
            return 8;
        }
        if (this.c > 32768) {
            this.e.a(4);
            return 4;
        }
        if (n2 != 0) {
            this.e.a(16);
            return 16;
        }
        return 0;
    }

    @Override
    public final nX h(nX nX2) {
        int n2;
        int n3;
        nZ nZ2 = this.e;
        Object object = nZ2;
        object = nX2.e;
        if (nZ2.a != ((nZ)object).a) {
            this.e.a(1);
            nX nX3 = this;
            object = nX3.a(nX3.F());
            nX3.a(nX3.F()).d = (byte)3;
            return this.a(1, r, nX2, (nX)object);
        }
        nX nX4 = this;
        object = nX4.a(nX4.F());
        if (this.d != 0 || nX2.d != 0) {
            if (this.J()) {
                return this;
            }
            if (nX2.J()) {
                return nX2;
            }
            if (this.d == 1 && nX2.d == 0 && nX2.a[this.a.length - 1] != 0) {
                nX nX5 = this;
                object = nX5.a(nX5);
                nX5.a(nX5).b = (byte)(this.b * nX2.b);
                return object;
            }
            if (nX2.d == 1 && this.d == 0 && this.a[this.a.length - 1] != 0) {
                object = this.a(nX2);
                this.a(nX2).b = (byte)(this.b * nX2.b);
                return object;
            }
            if (nX2.d == 1 && this.d == 1) {
                nX nX6 = this;
                object = nX6.a(nX6);
                nX6.a(nX6).b = (byte)(this.b * nX2.b);
                return object;
            }
            if (nX2.d == 1 && this.d == 0 && this.a[this.a.length - 1] == 0 || this.d == 1 && nX2.d == 0 && nX2.a[this.a.length - 1] == 0) {
                this.e.a(1);
                nX nX7 = this;
                object = nX7.a(nX7.F());
                nX7.a(nX7.F()).d = (byte)3;
                object = this.a(1, r, nX2, (nX)object);
                return object;
            }
        }
        int[] nArray = new int[this.a.length << 1];
        for (n3 = 0; n3 < this.a.length; ++n3) {
            n2 = 0;
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                int n4 = this.a[n3] * nX2.a[i2];
                n2 = (n4 += nArray[n3 + i2] + n2) / 10000;
                nArray[n3 + i2] = n4 - n2 * 10000;
            }
            nArray[n3 + this.a.length] = n2;
        }
        n3 = (this.a.length << 1) - 1;
        for (n2 = (this.a.length << 1) - 1; n2 >= 0; --n2) {
            if (nArray[n2] == 0) continue;
            n3 = n2;
            break;
        }
        for (n2 = 0; n2 < this.a.length; ++n2) {
            ((nX)object).a[this.a.length - n2 - 1] = nArray[n3 - n2];
        }
        ((nX)object).c = this.c + nX2.c + n3 - 2 * this.a.length + 1;
        ((nX)object).b = (byte)(this.b == nX2.b ? 1 : -1);
        if (((nX)object).a[this.a.length - 1] == 0) {
            ((nX)object).c = 0;
        }
        if ((n2 = n3 > this.a.length - 1 ? ((nX)object).h(nArray[n3 - this.a.length]) : ((nX)object).h(0)) != 0) {
            object = this.a(n2, r, nX2, (nX)object);
        }
        return object;
    }

    public final nX i(int n2) {
        if (n2 >= 0 && n2 < 10000) {
            return this.n(n2);
        }
        nX nX2 = this;
        return nX2.h(nX2.e(n2));
    }

    private nX n(int n2) {
        int n3;
        int n4;
        nX nX2 = this;
        nX nX3 = nX2.a(nX2);
        if (this.d != 0) {
            if (this.J()) {
                return this;
            }
            if (this.d == 1 && n2 != 0) {
                nX nX4 = this;
                nX3 = nX4.a(nX4);
                return nX3;
            }
            if (this.d == 1 && n2 == 0) {
                this.e.a(1);
                nX nX5 = this;
                nX3 = nX5.a(nX5.F());
                nX5.a(nX5.F()).d = (byte)3;
                nX nX6 = this;
                nX3 = this.a(1, r, nX6.a(nX6.F()), nX3);
                return nX3;
            }
        }
        if (n2 < 0 || n2 >= 10000) {
            this.e.a(1);
            nX nX7 = this;
            nX3 = nX7.a(nX7.F());
            nX7.a(nX7.F()).d = (byte)3;
            nX nX8 = nX3;
            nX3 = this.a(1, r, nX8, nX8);
            return nX3;
        }
        int n5 = 0;
        for (n4 = 0; n4 < this.a.length; ++n4) {
            n3 = this.a[n4] * n2 + n5;
            n5 = n3 / 10000;
            nX3.a[n4] = n3 - n5 * 10000;
        }
        n4 = 0;
        if (n5 != 0) {
            n4 = nX3.a[0];
            nX3.I();
            nX3.a[this.a.length - 1] = n5;
        }
        if (nX3.a[this.a.length - 1] == 0) {
            nX3.c = 0;
        }
        if ((n3 = nX3.h(n4)) != 0) {
            nX nX9 = nX3;
            nX3 = this.a(n3, r, nX9, nX9);
        }
        return nX3;
    }

    public final nX i(nX nX2) {
        int n2;
        int n3;
        int n4 = 0;
        nZ nZ2 = this.e;
        nZ nZ3 = nZ2;
        nZ3 = nX2.e;
        if (nZ2.a != nZ3.a) {
            this.e.a(1);
            nX nX3 = this;
            nX nX4 = nX3.a(nX3.F());
            nX3.a(nX3.F()).d = (byte)3;
            return this.a(1, s, nX2, nX4);
        }
        nX nX5 = this;
        nX nX6 = nX5.a(nX5.F());
        if (this.d != 0 || nX2.d != 0) {
            if (this.J()) {
                return this;
            }
            if (nX2.J()) {
                return nX2;
            }
            if (this.d == 1 && nX2.d == 0) {
                nX nX7 = this;
                nX6 = nX7.a(nX7);
                nX7.a(nX7).b = (byte)(this.b * nX2.b);
                return nX6;
            }
            if (nX2.d == 1 && this.d == 0) {
                nX nX8 = this;
                nX6 = nX8.a(nX8.F());
                nX8.a(nX8.F()).b = (byte)(this.b * nX2.b);
                return nX6;
            }
            if (nX2.d == 1 && this.d == 1) {
                this.e.a(1);
                nX nX9 = this;
                nX6 = nX9.a(nX9.F());
                nX9.a(nX9.F()).d = (byte)3;
                nX6 = this.a(1, s, nX2, nX6);
                return nX6;
            }
        }
        if (nX2.a[this.a.length - 1] == 0) {
            this.e.a(2);
            nX nX10 = this;
            nX6 = nX10.a(nX10.F());
            nX10.a(nX10.F()).b = (byte)(this.b * nX2.b);
            nX6.d = 1;
            nX6 = this.a(2, s, nX2, nX6);
            return nX6;
        }
        int[] nArray = new int[this.a.length + 1];
        int[] nArray2 = new int[this.a.length + 2];
        int[] nArray3 = new int[this.a.length + 1];
        nArray[this.a.length] = 0;
        nArray2[this.a.length] = 0;
        nArray2[this.a.length + 1] = 0;
        nArray3[this.a.length] = 0;
        for (n3 = 0; n3 < this.a.length; ++n3) {
            nArray[n3] = this.a[n3];
            nArray2[n3] = 0;
            nArray3[n3] = 0;
        }
        int n5 = 0;
        for (int i2 = this.a.length + 1; i2 >= 0; --i2) {
            n3 = nArray[this.a.length] * 10000 + nArray[this.a.length - 1];
            int n6 = n3 / (nX2.a[this.a.length - 1] + 1);
            int n7 = (n3 + 1) / nX2.a[this.a.length - 1];
            boolean bl = false;
            while (!bl) {
                int n8;
                int n9;
                n4 = (n6 + n7) / 2;
                n3 = 0;
                for (n9 = 0; n9 < this.a.length + 1; ++n9) {
                    n8 = n9 < this.a.length ? nX2.a[n9] : 0;
                    n8 = n8 * n4 + n3;
                    n3 = n8 / 10000;
                    nArray3[n9] = n8 - n3 * 10000;
                }
                n3 = 1;
                for (n9 = 0; n9 < this.a.length + 1; ++n9) {
                    n8 = 9999 - nArray3[n9] + nArray[n9] + n3;
                    n3 = n8 / 10000;
                    nArray3[n9] = n8 - n3 * 10000;
                }
                if (n3 == 0) {
                    n7 = n4 - 1;
                    continue;
                }
                n3 = nArray3[this.a.length] * 10000 + nArray3[this.a.length - 1];
                if ((n3 /= nX2.a[this.a.length - 1] + 1) >= 2) {
                    n6 = n4 + n3;
                    continue;
                }
                bl = false;
                for (n9 = this.a.length - 1; n9 >= 0; --n9) {
                    if (nX2.a[n9] > nArray3[n9]) {
                        bl = true;
                    }
                    if (nX2.a[n9] < nArray3[n9]) break;
                }
                if (nArray3[this.a.length] != 0) {
                    bl = false;
                }
                if (bl) continue;
                n6 = n4 + 1;
            }
            nArray2[i2] = n4;
            if (n4 != 0 || n5 != 0) {
                ++n5;
            }
            nZ nZ4 = this.e;
            if (nZ4.g == nZ.a.ROUND_DOWN$7d08181e && n5 == this.a.length || n5 > this.a.length) break;
            nArray[0] = 0;
            for (n3 = 0; n3 < this.a.length; ++n3) {
                nArray[n3 + 1] = nArray3[n3];
            }
        }
        int n10 = this.a.length;
        for (n2 = this.a.length + 1; n2 >= 0; --n2) {
            if (nArray2[n2] == 0) continue;
            n10 = n2;
            break;
        }
        for (n2 = 0; n2 < this.a.length; ++n2) {
            nX6.a[this.a.length - n2 - 1] = nArray2[n10 - n2];
        }
        nX6.c = this.c - nX2.c + n10 - this.a.length;
        nX6.b = (byte)(this.b == nX2.b ? 1 : -1);
        if (nX6.a[this.a.length - 1] == 0) {
            nX6.c = 0;
        }
        if ((n10 = n10 > this.a.length - 1 ? nX6.h(nArray2[n10 - this.a.length]) : nX6.h(0)) != 0) {
            nX6 = this.a(n10, s, nX2, nX6);
        }
        return nX6;
    }

    public final nX j(int n2) {
        int n3;
        int n4;
        if (this.d != 0) {
            if (this.J()) {
                return this;
            }
            if (this.d == 1) {
                nX nX2 = this;
                return nX2.a(nX2);
            }
        }
        if (n2 == 0) {
            this.e.a(2);
            nX nX3 = this;
            nX nX4 = nX3.a(nX3.F());
            nX3.a(nX3.F()).b = this.b;
            nX4.d = 1;
            nX4 = this.a(2, s, this.F(), nX4);
            return nX4;
        }
        if (n2 < 0 || n2 >= 10000) {
            this.e.a(1);
            nX nX5 = this;
            nX nX6 = nX5.a(nX5.F());
            nX5.a(nX5.F()).d = (byte)3;
            nX nX7 = nX6;
            nX6 = this.a(1, s, nX7, nX7);
            return nX6;
        }
        nX nX8 = this;
        nX nX9 = nX8.a(nX8);
        int n5 = 0;
        for (n4 = this.a.length - 1; n4 >= 0; --n4) {
            n3 = n5 * 10000 + nX9.a[n4];
            int n6 = n3 / n2;
            n5 = n3 - n6 * n2;
            nX9.a[n4] = n6;
        }
        if (nX9.a[this.a.length - 1] == 0) {
            nX9.S();
            n4 = n5 * 10000;
            n3 = n4 / n2;
            n5 = n4 - n3 * n2;
            nX9.a[0] = n3;
        }
        if ((n4 = nX9.h(n5 * 10000 / n2)) != 0) {
            nX nX10 = nX9;
            nX9 = this.a(n4, s, nX10, nX10);
        }
        return nX9;
    }

    private nX ab() {
        nZ nZ2 = this.e;
        return nZ2.c.i(this);
    }

    public final nX Q() {
        if (this.d == 0 && this.a[this.a.length - 1] == 0) {
            nX nX2 = this;
            return nX2.a(nX2);
        }
        if (this.d != 0) {
            if (this.d == 1 && this.b == 1) {
                nX nX3 = this;
                return nX3.a(nX3);
            }
            if (this.d == 3) {
                nX nX4 = this;
                return nX4.a(nX4);
            }
            if (this.d == 2) {
                this.e.a(1);
                nX nX5 = this;
                nX nX6 = nX5.a(nX5);
                nX6 = this.a(1, t, null, nX6);
                return nX6;
            }
        }
        if (this.b == -1) {
            this.e.a(1);
            nX nX7 = this;
            nX nX8 = nX7.a(nX7);
            nX7.a(nX7).d = (byte)3;
            nX8 = this.a(1, t, null, nX8);
            return nX8;
        }
        nX nX9 = this;
        nX nX10 = nX9.a(nX9);
        if (nX10.c < -1 || nX10.c > 1) {
            nX10.c = this.c / 2;
        }
        switch (nX10.a[this.a.length - 1] / 2000) {
            case 0: {
                nX10.a[this.a.length - 1] = nX10.a[this.a.length - 1] / 2 + 1;
                break;
            }
            case 2: {
                nX10.a[this.a.length - 1] = 1500;
                break;
            }
            case 3: {
                nX10.a[this.a.length - 1] = 2200;
                break;
            }
            default: {
                nX10.a[this.a.length - 1] = 3000;
            }
        }
        this.a(nX10);
        nX nX11 = this.F();
        this.F();
        while (nX10.d(nX11)) {
            nX nX12 = this.a(nX10);
            this.a(nX10).b = (byte)-1;
            nX12 = nX12.f(this.i(nX10));
            nX12 = nX12.j(2);
            nX nX13 = nX11;
            nX11 = nX10;
            if (!(nX10 = nX10.f(nX12)).equals(nX13) && nX12.a[this.a.length - 1] != 0) continue;
        }
        return nX10;
    }

    public String toString() {
        if (this.d != 0) {
            if (this.d == 1) {
                if (this.b < 0) {
                    return p;
                }
                return o;
            }
            return n;
        }
        if (this.c > this.a.length || this.c < -1) {
            int n2;
            nX nX2 = this;
            char[] cArray = new char[nX2.a.length << 2];
            char[] cArray2 = new char[(nX2.a.length << 2) + 20];
            int n3 = 0;
            for (n2 = nX2.a.length - 1; n2 >= 0; --n2) {
                cArray[n3++] = (char)(nX2.a[n2] / 1000 + 48);
                cArray[n3++] = (char)(nX2.a[n2] / 100 % 10 + 48);
                cArray[n3++] = (char)(nX2.a[n2] / 10 % 10 + 48);
                cArray[n3++] = (char)(nX2.a[n2] % 10 + 48);
            }
            for (n3 = 0; n3 < cArray.length && cArray[n3] == '0'; ++n3) {
            }
            int n4 = n3;
            n2 = 0;
            if (nX2.b == -1) {
                ++n2;
                cArray2[0] = 45;
            }
            if (n3 != cArray.length) {
                cArray2[n2++] = cArray[n3++];
                cArray2[n2++] = 46;
                while (n3 < cArray.length) {
                    cArray2[n2++] = cArray[n3++];
                }
            } else {
                cArray2[n2++] = 48;
                cArray2[n2++] = 46;
                cArray2[n2++] = 48;
                cArray2[n2++] = 101;
                cArray2[n2] = 48;
                return new String(cArray2, 0, 5);
            }
            cArray2[n2++] = 101;
            int n5 = n4 = (nX2.c << 2) - n4 - 1;
            if (n4 < 0) {
                n5 = -n4;
            }
            for (n3 = 1000000000; n3 > n5; n3 /= 10) {
            }
            if (n4 < 0) {
                cArray2[n2++] = 45;
            }
            while (n3 > 0) {
                cArray2[n2++] = (char)(n5 / n3 + 48);
                n5 %= n3;
                n3 /= 10;
            }
            return new String(cArray2, 0, n2);
        }
        nX nX3 = this;
        char[] cArray = new char[(nX3.a.length << 2) + 20];
        int n6 = 1;
        int n7 = nX3.c;
        boolean bl = false;
        cArray[0] = 32;
        if (n7 <= 0) {
            ++n6;
            cArray[1] = 48;
            ++n6;
            cArray[2] = 46;
            bl = true;
        }
        while (n7 < 0) {
            cArray[n6++] = 48;
            cArray[n6++] = 48;
            cArray[n6++] = 48;
            cArray[n6++] = 48;
            ++n7;
        }
        for (int i2 = nX3.a.length - 1; i2 >= 0; --i2) {
            cArray[n6++] = (char)(nX3.a[i2] / 1000 + 48);
            cArray[n6++] = (char)(nX3.a[i2] / 100 % 10 + 48);
            cArray[n6++] = (char)(nX3.a[i2] / 10 % 10 + 48);
            cArray[n6++] = (char)(nX3.a[i2] % 10 + 48);
            if (--n7 != 0) continue;
            cArray[n6++] = 46;
            bl = true;
        }
        while (n7 > 0) {
            cArray[n6++] = 48;
            cArray[n6++] = 48;
            cArray[n6++] = 48;
            cArray[n6++] = 48;
            --n7;
        }
        if (!bl) {
            cArray[n6++] = 46;
        }
        int n8 = 1;
        while (cArray[n8] == '0') {
            ++n8;
        }
        if (cArray[n8] == '.') {
            --n8;
        }
        while (cArray[n6 - 1] == '0') {
            --n6;
        }
        if (nX3.b < 0) {
            cArray[--n8] = 45;
        }
        return new String(cArray, n8, n6 - n8);
    }

    private String ac() {
        int n2;
        int n3;
        char[] cArray = new char[this.a.length << 2];
        char[] cArray2 = new char[(this.a.length << 2) + 20];
        int n4 = 0;
        for (n3 = this.a.length - 1; n3 >= 0; --n3) {
            cArray[n4++] = (char)(this.a[n3] / 1000 + 48);
            cArray[n4++] = (char)(this.a[n3] / 100 % 10 + 48);
            cArray[n4++] = (char)(this.a[n3] / 10 % 10 + 48);
            cArray[n4++] = (char)(this.a[n3] % 10 + 48);
        }
        for (n4 = 0; n4 < cArray.length && cArray[n4] == '0'; ++n4) {
        }
        int n5 = n4;
        n3 = 0;
        if (this.b == -1) {
            ++n3;
            cArray2[0] = 45;
        }
        if (n4 != cArray.length) {
            cArray2[n3++] = cArray[n4++];
            cArray2[n3++] = 46;
            while (n4 < cArray.length) {
                cArray2[n3++] = cArray[n4++];
            }
        } else {
            cArray2[n3++] = 48;
            cArray2[n3++] = 46;
            cArray2[n3++] = 48;
            cArray2[n3++] = 101;
            cArray2[n3] = 48;
            return new String(cArray2, 0, 5);
        }
        cArray2[n3++] = 101;
        n5 = n2 = (this.c << 2) - n5 - 1;
        if (n2 < 0) {
            n5 = -n2;
        }
        for (n4 = 1000000000; n4 > n5; n4 /= 10) {
        }
        if (n2 < 0) {
            cArray2[n3++] = 45;
        }
        while (n4 > 0) {
            cArray2[n3++] = (char)(n5 / n4 + 48);
            n5 %= n4;
            n4 /= 10;
        }
        return new String(cArray2, 0, n3);
    }

    private String ad() {
        char[] cArray = new char[(this.a.length << 2) + 20];
        int n2 = 1;
        int n3 = this.c;
        boolean bl = false;
        cArray[0] = 32;
        if (n3 <= 0) {
            ++n2;
            cArray[1] = 48;
            ++n2;
            cArray[2] = 46;
            bl = true;
        }
        while (n3 < 0) {
            cArray[n2++] = 48;
            cArray[n2++] = 48;
            cArray[n2++] = 48;
            cArray[n2++] = 48;
            ++n3;
        }
        for (int i2 = this.a.length - 1; i2 >= 0; --i2) {
            cArray[n2++] = (char)(this.a[i2] / 1000 + 48);
            cArray[n2++] = (char)(this.a[i2] / 100 % 10 + 48);
            cArray[n2++] = (char)(this.a[i2] / 10 % 10 + 48);
            cArray[n2++] = (char)(this.a[i2] % 10 + 48);
            if (--n3 != 0) continue;
            cArray[n2++] = 46;
            bl = true;
        }
        while (n3 > 0) {
            cArray[n2++] = 48;
            cArray[n2++] = 48;
            cArray[n2++] = 48;
            cArray[n2++] = 48;
            --n3;
        }
        if (!bl) {
            cArray[n2++] = 46;
        }
        n3 = 1;
        while (cArray[n3] == '0') {
            ++n3;
        }
        if (cArray[n3] == '.') {
            --n3;
        }
        while (cArray[n2 - 1] == '0') {
            --n2;
        }
        if (this.b < 0) {
            cArray[--n3] = 45;
        }
        return new String(cArray, n3, n2 - n3);
    }

    @Override
    public final nX a(int n2, String object, nX nX2, nX nX3) {
        object = nX3;
        switch (n2) {
            case 1: {
                nX nX4 = this;
                object = nX4.a(nX4.F());
                nX4.a(nX4.F()).b = nX3.b;
                ((nX)object).d = (byte)3;
                break;
            }
            case 2: {
                if (this.d == 0 && this.a[this.a.length - 1] != 0) {
                    nX nX5 = this;
                    object = nX5.a(nX5.F());
                    nX5.a(nX5.F()).b = (byte)(this.b * nX2.b);
                    ((nX)object).d = 1;
                }
                if (this.d == 0 && this.a[this.a.length - 1] == 0) {
                    nX nX6 = this;
                    object = nX6.a(nX6.F());
                    nX6.a(nX6.F()).d = (byte)3;
                }
                if (this.d == 1 || this.d == 3) {
                    nX nX7 = this;
                    object = nX7.a(nX7.F());
                    nX7.a(nX7.F()).d = (byte)3;
                }
                if (this.d != 1 && this.d != 2) break;
                nX nX8 = this;
                object = nX8.a(nX8.F());
                nX8.a(nX8.F()).d = (byte)3;
                break;
            }
            case 8: {
                if (nX3.c + this.a.length < -32767) {
                    nX nX9 = this;
                    object = nX9.a(nX9.F());
                    nX9.a(nX9.F()).b = nX3.b;
                } else {
                    object = this.a(nX3);
                }
                nX3.c += 32760;
                break;
            }
            case 4: {
                nX3.c -= 32760;
                nX nX10 = this;
                object = nX10.a(nX10.F());
                nX10.a(nX10.F()).b = nX3.b;
                ((nX)object).d = 1;
                break;
            }
            default: {
                object = nX3;
            }
        }
        Object object2 = object;
        return object2;
    }

    private static nX k(nX nX2) {
        return nX2;
    }

    public final int R() {
        return this.d;
    }

    public static nX a(nX nX2, nX nX3) {
        nX nX4 = nX2;
        nX2 = nX4.a(nX4);
        nX4.a(nX4).b = nX3.b;
        return nX2;
    }

    public nX j(nX nX2) {
        nX nX3;
        nZ nZ2 = this.e;
        Object object = nZ2;
        object = nX2.e;
        if (nZ2.a != ((nZ)object).a) {
            this.e.a(1);
            nX nX4 = this;
            nX nX5 = nX4.a(nX4.F());
            nX4.a(nX4.F()).d = (byte)3;
            return this.a(1, w, nX2, nX5);
        }
        boolean bl = false;
        if (this.b(nX2)) {
            bl = true;
        }
        if (nX.b(this, nX2) == 0) {
            return this.a(nX2);
        }
        nX nX6 = this;
        if (nX6.b(nX6.F())) {
            boolean bl2 = bl = !bl;
        }
        if (bl) {
            nX nX7 = this;
            nX3 = nX7.a(nX7.G());
            nX7.a(nX7.G()).c = this.c - this.a.length + 1;
            nX3.b = this.b;
            nX nX8 = this;
            if (nX8.equals(nX8.F())) {
                nX3.c = -32767 - this.a.length;
            }
            nX3 = this.f(nX3);
        } else {
            nX nX9 = this;
            nX3 = nX9.a(nX9.G());
            nX9.a(nX9.G()).c = this.c;
            nX3.b = this.b;
            nX3.c = this.equals(nX3) ? this.c - this.a.length : this.c - this.a.length + 1;
            nX nX10 = this;
            if (nX10.equals(nX10.F())) {
                nX3.c = -32767 - this.a.length;
            }
            nX3 = this.g(nX3);
        }
        object = nX3;
        if (((nX)object).d == 1) {
            object = this;
            if (((nX)object).d != 1) {
                this.e.a(16);
                nX3 = this.a(16, w, nX2, nX3);
            }
        }
        if (nX3.equals(this.F())) {
            nX nX11 = this;
            if (!nX11.equals(nX11.F())) {
                this.e.a(16);
                nX3 = this.a(16, w, nX2, nX3);
            }
        }
        return nX3;
    }

    private double ae() {
        if (this.Y()) {
            nX nX2 = this;
            if (nX2.b(nX2.F())) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        if (this.J()) {
            return Double.NaN;
        }
        Object object = this;
        boolean bl = false;
        nX nX3 = this;
        int n2 = nX.b(nX3, nX3.F());
        if (n2 == 0) {
            if (this.b < 0) {
                return -0.0;
            }
            return 0.0;
        }
        if (n2 < 0) {
            object = this.P();
            bl = true;
        }
        if ((n2 = (int)((double)((nX)object).O() * 3.32)) < 0) {
            --n2;
        }
        nX nX4 = oa_0.a(this.H(), n2);
        while (nX4.b((nX)object) || nX4.equals(object)) {
            nX4 = nX4.i(2);
            ++n2;
        }
        object = ((nX)object).i(oa_0.a(this.H(), --n2));
        if (n2 > -1023) {
            object = ((nX)object).g(this.G());
        }
        if (n2 < -1074) {
            return 0.0;
        }
        if (n2 > 1023) {
            if (bl) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        object = ((nX)object).h(this.a(0x10000000000000L));
        object = ((nX)object).l(nZ.a.ROUND_HALF_EVEN$7d08181e);
        object = ((nX)object).toString();
        long l2 = Long.parseLong((String)(object = ((String)object).substring(0, ((String)object).length() - 1)));
        if (l2 == 0x10000000000000L) {
            l2 = 0L;
            ++n2;
        }
        if (n2 <= -1023) {
            --n2;
        }
        while (n2 < -1023) {
            ++n2;
            l2 >>>= 1;
        }
        long l3 = l2 | (long)n2 + 1023L << 52;
        double d2 = Double.longBitsToDouble(l3);
        if (bl) {
            d2 = -d2;
        }
        return d2;
    }

    private double[] af() {
        double[] dArray = new double[2];
        double[] dArray2 = dArray;
        dArray[0] = Double.longBitsToDouble(Double.doubleToLongBits(this.ae()) & 0xFFFFFFFFC0000000L);
        nX nX2 = this;
        dArray2[1] = nX2.g(nX2.h(dArray2[0])).ae();
        return dArray2;
    }

    @Override
    public final double d() {
        return this.ae();
    }

    private nX i(double d2) {
        nX nX2 = this;
        return nX2.f(nX2.h(d2));
    }

    private nX j(double d2) {
        nX nX2 = this;
        return nX2.g(nX2.h(d2));
    }

    private nX k(double d2) {
        nX nX2 = this;
        return nX2.h(nX2.h(d2));
    }

    private nX l(double d2) {
        nX nX2 = this;
        return nX2.i(nX2.h(d2));
    }

    private nX m(double d2) {
        nX nX2 = this;
        return nX2.e(nX2.h(d2));
    }

    @Override
    public final long i() {
        return BY.B(this.ae());
    }

    private nX ag() {
        if (this.J() || this.Z()) {
            return this;
        }
        nX nX2 = this;
        return nX2.e(nX2.b > 0 ? 1 : -1);
    }

    private nX l(nX nX2) {
        if (this.b >= 0 && nX2.b >= 0 || this.b < 0 && nX2.b < 0) {
            return this;
        }
        return this.P();
    }

    private nX n(double d2) {
        long l2 = Double.doubleToLongBits(d2);
        if (this.b >= 0 && l2 >= 0L || this.b < 0 && l2 < 0L) {
            return this;
        }
        return this.P();
    }

    private nX o(int n2) {
        nX nX2 = this;
        return nX2.h(oa_0.a(nX2.H(), n2));
    }

    private nX m(nX nX2) {
        nX nX3 = this;
        nX nX4 = nX2;
        return nX3.h(nX3).f(nX4.h(nX4)).Q();
    }

    private nX ah() {
        return this.p(3);
    }

    private nX p(int n2) {
        if (this.b >= 0) {
            nX nX2 = this;
            return oa_0.a(nX2, nX2.G().j(n2));
        }
        return oa_0.a(this.P(), this.G().j(n2)).P();
    }

    private nX o(double d2) {
        nX nX2 = this;
        return oa_0.a(nX2, nX2.h(d2));
    }

    private nX q(int n2) {
        return oa_0.a(this, n2);
    }

    private nX n(nX nX2) {
        return oa_0.a(this, nX2);
    }

    private nX ai() {
        return oa_0.a(this);
    }

    private nX aj() {
        return oa_0.a(this).g(this.G());
    }

    private nX ak() {
        return oa_0.b(this);
    }

    private nX al() {
        nX nX2 = this;
        return oa_0.b(nX2.f(nX2.G()));
    }

    @Deprecated
    private int am() {
        return this.O();
    }

    private nX an() {
        return oa_0.d(this);
    }

    private nX ao() {
        return oa_0.c(this);
    }

    private nX ap() {
        nX nX2 = this;
        return oa_0.c(nX2).i(oa_0.d(nX2));
    }

    private nX aq() {
        nX nX2 = this;
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

    private nX ar() {
        nX nX2;
        nX nX3 = nX2 = this;
        return oa_0.f(nX2.i(nX2.G().g(nX3.h(nX3)).Q()));
    }

    private nX as() {
        return oa_0.f(this);
    }

    private nX o(nX nX2) {
        nX nX3 = nX2;
        nX nX4 = this;
        nX nX5 = nX3.h(nX3).f(nX4.h(nX4)).Q();
        if (nX2.b >= 0) {
            nX2 = this.i(nX5.f(nX2));
            return this.H().h(oa_0.f(nX2));
        }
        nX2 = this.i(nX5.g(nX2));
        nX2 = this.H().h(oa_0.f(nX2));
        nX5 = this.h(nX2.b <= 0 ? -Math.PI : Math.PI);
        return nX5.g(nX2);
    }

    private nX at() {
        return oa_0.a(this).f(oa_0.a(this.P())).j(2);
    }

    private nX au() {
        return oa_0.a(this).g(oa_0.a(this.P())).j(2);
    }

    private nX av() {
        nX nX2 = oa_0.a(this);
        nX nX3 = oa_0.a(this.P());
        return nX2.g(nX3).i(nX2.f(nX3));
    }

    private nX aw() {
        nX nX2 = this;
        nX nX3 = nX2.h(nX2).g(this.G()).Q().f(this);
        return oa_0.b(nX3);
    }

    private nX ax() {
        nX nX2 = this;
        nX nX3 = nX2.h(nX2).f(this.G()).Q().f(this);
        return oa_0.b(nX3);
    }

    private nX ay() {
        nX nX2 = this.G().f(this).i(this.G().g(this));
        return oa_0.b(nX2).j(2);
    }

    private nX a(nX[] nXArray, nX[] nXArray2) {
        if (nXArray.length != nXArray2.length) {
            throw new oS(nXArray.length, nXArray2.length);
        }
        nX nX2 = this.F();
        for (int i2 = 0; i2 < nXArray.length; ++i2) {
            nX2 = nX2.f(nXArray[i2].h(nXArray2[i2]));
        }
        return nX2;
    }

    private nX a(double[] dArray, nX[] nXArray) {
        if (dArray.length != nXArray.length) {
            throw new oS(dArray.length, nXArray.length);
        }
        nX nX2 = this.F();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            nX2 = nX2.f(nXArray[i2].k(dArray[i2]));
        }
        return nX2;
    }

    private static nX a(nX nX2, nX nX3, nX nX4, nX nX5) {
        return nX2.h(nX3).f(nX4.h(nX5));
    }

    private static nX a(double d2, nX nX2, double d3, nX nX3) {
        return nX2.k(d2).f(nX3.k(d3));
    }

    private static nX a(nX nX2, nX nX3, nX nX4, nX nX5, nX nX6, nX nX7) {
        return nX2.h(nX3).f(nX4.h(nX5)).f(nX6.h(nX7));
    }

    private static nX a(double d2, nX nX2, double d3, nX nX3, double d4, nX nX4) {
        return nX2.k(d2).f(nX3.k(d3)).f(nX4.k(d4));
    }

    private static nX a(nX nX2, nX nX3, nX nX4, nX nX5, nX nX6, nX nX7, nX nX8, nX nX9) {
        return nX2.h(nX3).f(nX4.h(nX5)).f(nX6.h(nX7)).f(nX8.h(nX9));
    }

    private static nX a(double d2, nX nX2, double d3, nX nX3, double d4, nX nX4, double d5, nX nX5) {
        return nX2.k(d2).f(nX3.k(d3)).f(nX4.k(d4)).f(nX5.k(d5));
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3, double d4, kO kO4, double d5, kO kO5) {
        nX nX2 = (nX)kO2;
        nX nX3 = (nX)kO5;
        double d6 = d5;
        kO2 = (nX)kO4;
        double d7 = d4;
        nX nX4 = (nX)kO3;
        double d8 = d3;
        nX nX5 = nX2;
        double d9 = d2;
        return nX5.k(d9).f(nX4.k(d8)).f(((nX)kO2).k(d7)).f(nX3.k(d6));
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO kO3, kO kO4, kO kO5, kO kO6, kO kO7, kO kO8, kO kO9) {
        kO9 = (nX)kO9;
        kO8 = (nX)kO8;
        kO7 = (nX)kO7;
        kO6 = (nX)kO6;
        kO5 = (nX)kO5;
        kO4 = (nX)kO4;
        kO3 = (nX)kO3;
        kO2 = (nX)kO2;
        return ((nX)kO2).h((nX)kO3).f(((nX)kO4).h((nX)kO5)).f(((nX)kO6).h((nX)kO7)).f(((nX)kO8).h((nX)kO9));
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3, double d4, kO kO4) {
        nX nX2 = (nX)kO2;
        kO2 = (nX)kO4;
        double d5 = d4;
        nX nX3 = (nX)kO3;
        double d6 = d3;
        nX nX4 = nX2;
        double d7 = d2;
        return nX4.k(d7).f(nX3.k(d6)).f(((nX)kO2).k(d5));
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO kO3, kO kO4, kO kO5, kO kO6, kO kO7) {
        kO7 = (nX)kO7;
        kO6 = (nX)kO6;
        kO5 = (nX)kO5;
        kO4 = (nX)kO4;
        kO3 = (nX)kO3;
        kO2 = (nX)kO2;
        return ((nX)kO2).h((nX)kO3).f(((nX)kO4).h((nX)kO5)).f(((nX)kO6).h((nX)kO7));
    }

    @Override
    public final /* synthetic */ kO a(double d2, kO kO2, double d3, kO kO3) {
        nX nX2 = (nX)kO3;
        double d4 = d3;
        nX nX3 = (nX)kO2;
        double d5 = d2;
        return nX3.k(d5).f(nX2.k(d4));
    }

    @Override
    public final /* synthetic */ kO a(kO kO2, kO kO3, Object object, kO kO4) {
        kO4 = (nX)kO4;
        object = (nX)object;
        kO3 = (nX)kO3;
        kO2 = (nX)kO2;
        return ((nX)kO2).h((nX)kO3).f(((nX)object).h((nX)kO4));
    }

    @Override
    public final /* synthetic */ kO a(double[] object, Object[] objectArray) {
        nX[] nXArray = (nX[])objectArray;
        objectArray = (Object[])object;
        object = this;
        if (objectArray.length != nXArray.length) {
            throw new oS(objectArray.length, nXArray.length);
        }
        object = ((nX)object).F();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            object = ((nX)object).f(nXArray[i2].k((double)objectArray[i2]));
        }
        return object;
    }

    @Override
    public final /* synthetic */ kO a(Object[] object, Object[] objectArray) {
        nX[] nXArray = (nX[])objectArray;
        objectArray = (nX[])object;
        object = this;
        if (objectArray.length != nXArray.length) {
            throw new oS(objectArray.length, nXArray.length);
        }
        object = ((nX)object).F();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            object = ((nX)object).f(((nX)objectArray[i2]).h(nXArray[i2]));
        }
        return object;
    }

    @Override
    public final /* synthetic */ kO B() {
        nX nX2 = this;
        nX2 = nX2.G().f(nX2).i(nX2.G().g(nX2));
        return oa_0.b(nX2).j(2);
    }

    @Override
    public final /* synthetic */ kO A() {
        nX nX2 = this;
        nX2 = nX2.h(nX2).f(nX2.G()).Q().f(nX2);
        return oa_0.b(nX2);
    }

    @Override
    public final /* synthetic */ kO z() {
        nX nX2 = this;
        nX2 = nX2.h(nX2).g(nX2.G()).Q().f(nX2);
        return oa_0.b(nX2);
    }

    @Override
    public final /* synthetic */ kO y() {
        nX nX2 = this;
        nX nX3 = oa_0.a(nX2);
        nX2 = oa_0.a(nX2.P());
        return nX3.g(nX2).i(nX3.f(nX2));
    }

    @Override
    public final /* synthetic */ kO x() {
        nX nX2 = this;
        return oa_0.a(nX2).g(oa_0.a(nX2.P())).j(2);
    }

    @Override
    public final /* synthetic */ kO w() {
        nX nX2 = this;
        return oa_0.a(nX2).f(oa_0.a(nX2.P())).j(2);
    }

    @Override
    public final /* synthetic */ kO h(Object object) {
        nX nX2 = (nX)object;
        object = this;
        nX nX3 = nX2;
        Object object2 = object;
        nX nX4 = nX3.h(nX3).f(((nX)object2).h((nX)object2)).Q();
        if (nX2.b >= 0) {
            nX2 = ((nX)object).i(nX4.f(nX2));
            return ((nX)object).H().h(oa_0.f(nX2));
        }
        nX2 = ((nX)object).i(nX4.g(nX2));
        nX2 = ((nX)object).H().h(oa_0.f(nX2));
        object = ((nX)object).h(nX2.b <= 0 ? -Math.PI : Math.PI);
        return ((nX)object).g(nX2);
    }

    @Override
    public final /* synthetic */ kO v() {
        nX nX2 = this;
        return oa_0.f(nX2);
    }

    @Override
    public final /* synthetic */ kO u() {
        nX nX2 = this;
        nX nX3 = nX2;
        nX nX4 = nX3 = nX2;
        return oa_0.f(nX2.i(nX3.G().g(nX4.h(nX4)).Q()));
    }

    @Override
    public final /* synthetic */ kO t() {
        nX nX2 = this;
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

    @Override
    public final /* synthetic */ kO s() {
        nX nX2 = this;
        nX nX3 = nX2;
        nX3 = nX2;
        return oa_0.c(nX2).i(oa_0.d(nX3));
    }

    @Override
    public final /* synthetic */ kO r() {
        nX nX2 = this;
        return oa_0.c(nX2);
    }

    @Override
    public final /* synthetic */ kO q() {
        nX nX2 = this;
        return oa_0.d(nX2);
    }

    @Override
    public final /* synthetic */ kO p() {
        nX nX2 = this;
        return oa_0.b(nX2.f(nX2.G()));
    }

    @Override
    public final /* synthetic */ kO o() {
        nX nX2 = this;
        return oa_0.b(nX2);
    }

    @Override
    public final /* synthetic */ kO n() {
        nX nX2 = this;
        return oa_0.a(nX2).g(nX2.G());
    }

    @Override
    public final /* synthetic */ kO m() {
        nX nX2 = this;
        return oa_0.a(nX2);
    }

    @Override
    public final /* synthetic */ kO d(int n2) {
        int n3 = n2;
        nX nX2 = this;
        return oa_0.a(nX2, n3);
    }

    @Override
    public final /* synthetic */ kO g(double d2) {
        double d3 = d2;
        nX nX2 = this;
        return oa_0.a(nX2, nX2.h(d3));
    }

    @Override
    public final /* synthetic */ kO c(int n2) {
        return this.p(n2);
    }

    @Override
    public final /* synthetic */ kO l() {
        nX nX2 = this;
        return nX2.p(3);
    }

    @Override
    public final /* synthetic */ kO k() {
        return this.Q();
    }

    @Override
    public final /* synthetic */ kN b() {
        nX nX2 = this;
        nZ nZ2 = nX2.e;
        return nZ2.c.i(nX2);
    }

    @Override
    public final /* synthetic */ kO g(Object object) {
        nX nX2 = (nX)object;
        object = this;
        nX nX3 = nX2;
        return ((nX)object).h((nX)object).f(nX3.h(nX3)).Q();
    }

    @Override
    public final /* synthetic */ kO b(int n2) {
        int n3 = n2;
        nX nX2 = this;
        return nX2.h(oa_0.a(nX2.H(), n3));
    }

    @Override
    public final /* synthetic */ kO f(double d2) {
        double d3 = d2;
        nX nX2 = this;
        long l2 = Double.doubleToLongBits(d3);
        if (nX2.b >= 0 && l2 >= 0L || nX2.b < 0 && l2 < 0L) {
            return nX2;
        }
        return nX2.P();
    }

    @Override
    public final /* synthetic */ kO f(Object object) {
        nX nX2 = (nX)object;
        object = this;
        if (((nX)object).b >= 0 && nX2.b >= 0 || ((nX)object).b < 0 && nX2.b < 0) {
            return object;
        }
        return ((nX)object).P();
    }

    @Override
    public final /* synthetic */ kO j() {
        nX nX2 = this;
        if (nX2.J() || nX2.Z()) {
            return nX2;
        }
        nX nX3 = nX2;
        return nX3.e(nX3.b > 0 ? 1 : -1);
    }

    @Override
    public final /* synthetic */ kO h() {
        nX nX2 = this;
        return nX2.l(nZ.a.ROUND_HALF_EVEN$7d08181e);
    }

    @Override
    public final /* synthetic */ kO g() {
        nX nX2 = this;
        return nX2.l(nZ.a.ROUND_FLOOR$7d08181e);
    }

    @Override
    public final /* synthetic */ kO f() {
        nX nX2 = this;
        return nX2.l(nZ.a.ROUND_CEIL$7d08181e);
    }

    @Override
    public final /* synthetic */ kO e() {
        nX nX2 = this;
        nX2 = nX2.a(nX2);
        v0.b = 1;
        return nX2;
    }

    @Override
    public final /* synthetic */ kO e(double d2) {
        double d3 = d2;
        nX nX2 = this;
        return nX2.e(nX2.h(d3));
    }

    @Override
    public final /* synthetic */ kO d(double d2) {
        double d3 = d2;
        nX nX2 = this;
        return nX2.i(nX2.h(d3));
    }

    @Override
    public final /* synthetic */ kO c(double d2) {
        return this.k(d2);
    }

    @Override
    public final /* synthetic */ kO b(double d2) {
        double d3 = d2;
        nX nX2 = this;
        return nX2.g(nX2.h(d3));
    }

    @Override
    public final /* synthetic */ kO a(double d2) {
        double d3 = d2;
        nX nX2 = this;
        return nX2.f(nX2.h(d3));
    }

    @Override
    public final /* synthetic */ kN d(Object object) {
        return this.i((nX)object);
    }

    @Override
    public final /* synthetic */ kN c(Object object) {
        return this.h((nX)object);
    }

    @Override
    public final /* synthetic */ kN a(int n2) {
        return this.i(n2);
    }

    @Override
    public final /* synthetic */ kN a() {
        return this.P();
    }

    @Override
    public final /* synthetic */ kN b(Object object) {
        return this.g((nX)object);
    }

    @Override
    public final /* synthetic */ kN a(Object object) {
        return this.f((nX)object);
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[nZ.a.values$5a699a5c().length];
            try {
                1.a[nZ.a.ROUND_FLOOR$7d08181e - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_CEIL$7d08181e - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_HALF_EVEN$7d08181e - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_DOWN$7d08181e - 1] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_UP$7d08181e - 1] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_HALF_UP$7d08181e - 1] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_HALF_DOWN$7d08181e - 1] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_HALF_ODD$7d08181e - 1] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }
}

