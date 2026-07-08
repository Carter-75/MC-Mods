/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zD;
import org.valkyrienskies.core.impl.shadow.zE;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zu_0;

public final class zO {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static int e = 4;
    private static int f = 5;
    private int g = 5;
    private URL h = null;
    private double i = 0.0;
    private double j = 0.0;
    private zu_0 k = null;
    private BufferedReader l = null;
    private final zD m;

    public zO() {
        this.m = new zD();
    }

    @Deprecated
    private zO(zE zE2) {
        this.m = zE2.a;
    }

    private zO(zF zF2) {
        this.m = new zD(zF2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private double a() {
        switch (this.g) {
            case 0: {
                zO zO2 = this;
                if (zO2.k == null) throw new oX(px_0.DIGEST_NOT_INITIALIZED, new Object[0]);
                zu_0 zu_02 = zO2.k;
                if (zu_02.b.size() == 0) {
                    throw new oX(px_0.DIGEST_NOT_INITIALIZED, new Object[0]);
                }
                zu_02 = zO2.k;
                if (zu_02.d) return zu_02.b();
                throw new oX(px_0.DISTRIBUTION_NOT_LOADED, new Object[0]);
            }
            case 1: {
                Object object;
                zO zO3 = this;
                if (zO3.l == null) {
                    zO3.f();
                }
                if ((object = zO3.l.readLine()) != null) return Double.parseDouble((String)object);
                object = zO3;
                if (((zO)object).l != null) {
                    ((zO)object).l.close();
                    ((zO)object).l = null;
                }
                zO3.f();
                object = zO3.l.readLine();
                if (object != null) return Double.parseDouble((String)object);
                throw new oX(px_0.URL_CONTAINS_NO_DATA, zO3.h);
            }
            case 2: {
                Object object = this;
                double d2 = 2.0 * ((zO)object).i;
                double d3 = 0.0;
                object = ((zO)object).m;
                return ((zD)object).a(d3, d2, false);
            }
            case 3: {
                zO zO4 = this;
                return zO4.m.b(zO4.i);
            }
            case 4: {
                zO zO5 = this;
                return zO5.m.a(zO5.i, zO5.j);
            }
            case 5: {
                return this.i;
            }
        }
        throw new oX(px_0.UNKNOWN_MODE, this.g, "DIGEST_MODE", 0, "REPLAY_MODE", 1, "UNIFORM_MODE", 2, "EXPONENTIAL_MODE", 3, "GAUSSIAN_MODE", 4, "CONSTANT_MODE", 5);
    }

    private void a(double[] dArray) {
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray[i2] = this.a();
        }
    }

    private double[] a(int n2) {
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.a();
        }
        return dArray;
    }

    private void b() {
        int n2 = 1000;
        zO zO2 = this;
        this.k = new zu_0(1000, zO2.m.c());
        zO2.k.a(zO2.h);
        zu_0 zu_02 = zO2.k;
        zO2.i = zu_02.c.b();
        zu_02 = zO2.k;
        zO2.j = zu_02.c.e();
    }

    private void b(int n2) {
        this.k = new zu_0(1000, this.m.c());
        this.k.a(this.h);
        zu_0 zu_02 = this.k;
        this.i = zu_02.c.b();
        zu_02 = this.k;
        this.j = zu_02.c.e();
    }

    private int c() {
        return this.g;
    }

    private void c(int n2) {
        this.g = n2;
    }

    private URL d() {
        return this.h;
    }

    private void a(String string) {
        this.h = new URL(string);
    }

    private void a(URL uRL) {
        this.h = uRL;
    }

    private zu_0 e() {
        return this.k;
    }

    private void f() {
        if (this.l != null) {
            try {
                this.l.close();
                this.l = null;
            }
            catch (IOException iOException) {}
        }
        this.l = new BufferedReader(new InputStreamReader(this.h.openStream(), "UTF-8"));
    }

    private void g() {
        if (this.l != null) {
            this.l.close();
            this.l = null;
        }
    }

    private double h() {
        return this.i;
    }

    private void a(double d2) {
        this.i = d2;
    }

    private double i() {
        return this.j;
    }

    private void b(double d2) {
        this.j = d2;
    }

    private void a(long l2) {
        this.m.a(l2);
    }

    private double j() {
        block3: {
            block2: {
                if (this.k == null) break block2;
                zu_0 zu_02 = this.k;
                if (zu_02.b.size() != 0) break block3;
            }
            throw new oX(px_0.DIGEST_NOT_INITIALIZED, new Object[0]);
        }
        return this.k.j();
    }

    private double k() {
        String string;
        if (this.l == null) {
            this.f();
        }
        if ((string = this.l.readLine()) == null) {
            this.g();
            this.f();
            string = this.l.readLine();
            if (string == null) {
                throw new oX(px_0.URL_CONTAINS_NO_DATA, this.h);
            }
        }
        return Double.parseDouble(string);
    }

    private double l() {
        double d2 = 2.0 * this.i;
        double d3 = 0.0;
        zD zD2 = this.m;
        return zD2.a(d3, d2, false);
    }

    private double m() {
        return this.m.b(this.i);
    }

    private double n() {
        return this.m.a(this.i, this.j);
    }
}

