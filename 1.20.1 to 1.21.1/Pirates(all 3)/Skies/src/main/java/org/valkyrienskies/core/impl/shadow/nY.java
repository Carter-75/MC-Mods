/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.nX;
import org.valkyrienskies.core.impl.shadow.nZ;

public final class nY
extends nX {
    private nY(nZ nZ2) {
        super(nZ2);
    }

    private nY(nZ nZ2, byte by) {
        super(nZ2, by);
    }

    private nY(nZ nZ2, int n2) {
        super(nZ2, n2);
    }

    private nY(nZ nZ2, long l2) {
        super(nZ2, l2);
    }

    private nY(nZ nZ2, double d2) {
        super(nZ2, d2);
        this.h(0);
    }

    private nY(nX nX2) {
        super(nX2);
        this.h(0);
    }

    private nY(nZ nZ2, String string) {
        super(nZ2, string);
        this.h(0);
    }

    private nY(nZ nZ2, byte by, byte by2) {
        super(nZ2, by, by2);
    }

    public final nX C() {
        return new nY(this.D());
    }

    public final nX a(byte by) {
        return new nY(this.D(), by);
    }

    public final nX e(int n2) {
        return new nY(this.D(), n2);
    }

    public final nX a(long l2) {
        return new nY(this.D(), 0x10000000000000L);
    }

    public final nX h(double d2) {
        return new nY(this.D(), d2);
    }

    public final nX a(nX nX2) {
        nZ nZ2 = this.D();
        Object object = nZ2;
        object = nX2.D();
        if (nZ2.a != ((nZ)object).a) {
            this.D().a(1);
            nY nY2 = this;
            object = ((nX)nY2).a(nY2.F());
            ((nX)nY2).a(nY2.F()).d = (byte)3;
            return this.a(1, "newInstance", nX2, (nX)object);
        }
        return new nY(nX2);
    }

    public final nX a(String string) {
        return new nY(this.D(), string);
    }

    public final nX a(byte by, byte by2) {
        return new nY(this.D(), by, by2);
    }

    private int S() {
        return (this.E() << 2) - 3;
    }

    protected final int h(int n2) {
        int n3;
        int n4;
        int n5 = this.a[this.a.length - 1];
        if (n5 == 0) {
            return 0;
        }
        int n6 = this.a.length << 2;
        int n7 = 1000;
        while (n7 > n5) {
            n7 /= 10;
            --n6;
        }
        n5 = this.S();
        int n8 = (n6 -= n5) / 4;
        n7 = 1;
        for (n4 = 0; n4 < n6 % 4; ++n4) {
            n7 *= 10;
        }
        n4 = this.a[n8];
        if (n7 <= 1 && n5 == 4 * this.a.length - 3) {
            return super.h(n2);
        }
        if (n7 == 1) {
            n5 = this.a[n8 - 1] / 1000 % 10;
            int n9 = n8 - 1;
            this.a[n9] = this.a[n9] % 1000;
            n2 |= this.a[n8 - 1];
        } else {
            n5 = n4 * 10 / n7 % 10;
            n2 |= n4 % (n7 / 10);
        }
        for (n6 = 0; n6 < n8; ++n6) {
            n2 |= this.a[n6];
            this.a[n6] = 0;
        }
        this.a[n8] = n4 / n7 * n7;
        nZ nZ2 = this.D();
        switch (1.a[nZ2.g - 1]) {
            case 1: {
                int n10 = 0;
                break;
            }
            case 2: {
                n3 = n5 != 0 || n2 != 0 ? 1 : 0;
                break;
            }
            case 3: {
                n3 = n5 >= 5 ? 1 : 0;
                break;
            }
            case 4: {
                n3 = n5 > 5 ? 1 : 0;
                break;
            }
            case 5: {
                n3 = n5 > 5 || n5 == 5 && n2 != 0 || n5 == 5 && n2 == 0 && (n4 / n7 & 1) == 1 ? 1 : 0;
                break;
            }
            case 6: {
                n3 = n5 > 5 || n5 == 5 && n2 != 0 || n5 == 5 && n2 == 0 && (n4 / n7 & 1) == 0 ? 1 : 0;
                break;
            }
            case 7: {
                n3 = this.b == 1 && (n5 != 0 || n2 != 0) ? 1 : 0;
                break;
            }
            default: {
                int n10 = n3 = this.b == -1 && (n5 != 0 || n2 != 0) ? 1 : 0;
            }
        }
        if (n3 != 0) {
            n3 = n7;
            for (n7 = n8; n7 < this.a.length; ++n7) {
                n8 = this.a[n7] + n3;
                n3 = n8 / 10000;
                this.a[n7] = n8 % 10000;
            }
            if (n3 != 0) {
                this.I();
                this.a[this.a.length - 1] = n3;
            }
        }
        if (this.c < -32767) {
            this.D().a(8);
            return 8;
        }
        if (this.c > 32768) {
            this.D().a(4);
            return 4;
        }
        if (n5 != 0 || n2 != 0) {
            this.D().a(16);
            return 16;
        }
        return 0;
    }

    public final nX j(nX nX2) {
        nX nX3;
        nZ nZ2 = this.D();
        Object object = nZ2;
        object = nX2.D();
        if (nZ2.a != ((nZ)object).a) {
            this.D().a(1);
            nY nY2 = this;
            object = ((nX)nY2).a(nY2.F());
            ((nX)nY2).a(nY2.F()).d = (byte)3;
            return this.a(1, "nextAfter", nX2, (nX)object);
        }
        boolean bl = false;
        if (this.b(nX2)) {
            bl = true;
        }
        if (this.equals(nX2)) {
            return ((nX)this).a(nX2);
        }
        nY nY3 = this;
        if (nY3.b(nY3.F())) {
            boolean bl2 = bl = !bl;
        }
        if (bl) {
            nY nY4 = this;
            nX3 = nY4.g(nY4.O() - this.S() + 1);
            nX3 = nY.a(nX3, this);
            nY nY5 = this;
            if (nY5.equals(nY5.F())) {
                nX3 = this.f(-32767 - this.a.length - 1);
            }
            if (nX3.equals(this.F())) {
                nY nY6 = this;
                nX3 = nY.a(((nX)nY6).a(nY6.F()), this);
            } else {
                nX3 = this.f(nX3);
            }
        } else {
            nY nY7 = this;
            nX3 = nY7.g(nY7.O());
            if (this.equals(nX3 = nY.a(nX3, this))) {
                nY nY8 = this;
                nX3 = nX3.i(nY8.g(nY8.S()));
            } else {
                nY nY9 = this;
                nX3 = nX3.i(nY9.g(nY9.S() - 1));
            }
            nY nY10 = this;
            if (nY10.equals(nY10.F())) {
                nX3 = this.f(-32767 - this.a.length - 1);
            }
            if (nX3.equals(this.F())) {
                nY nY11 = this;
                nX3 = nY.a(((nX)nY11).a(nY11.F()), this);
            } else {
                nX3 = this.g(nX3);
            }
        }
        if (nX3.R() == 1 && this.R() != 1) {
            this.D().a(16);
            nX3 = this.a(16, "nextAfter", nX2, nX3);
        }
        if (nX3.equals(this.F())) {
            nY nY12 = this;
            if (!nY12.equals(nY12.F())) {
                this.D().a(16);
                nX3 = this.a(16, "nextAfter", nX2, nX3);
            }
        }
        return nX3;
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[nZ.a.values$5a699a5c().length];
            try {
                1.a[nZ.a.ROUND_DOWN$7d08181e - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_UP$7d08181e - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_HALF_UP$7d08181e - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_HALF_DOWN$7d08181e - 1] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_HALF_EVEN$7d08181e - 1] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_HALF_ODD$7d08181e - 1] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_CEIL$7d08181e - 1] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nZ.a.ROUND_FLOOR$7d08181e - 1] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }
}

