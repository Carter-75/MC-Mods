/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.zu
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.aw_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oE;
import org.valkyrienskies.core.impl.shadow.oI;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.oj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zD;
import org.valkyrienskies.core.impl.shadow.zE;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zu;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.zu
 */
public final class zu_0
extends oe_0 {
    private static int e = 1000;
    private static final String f = "US-ASCII";
    private static final long g = 5729073523949762654L;
    private zD h;
    final List<aw_0> b;
    aw_0 c;
    private double i;
    private double j;
    private double k;
    private final int l;
    boolean d;
    private double[] m;

    public zu_0() {
        this(1000);
    }

    private zu_0(int n2) {
        this(1000, new zD());
    }

    public zu_0(int n2, zF zF2) {
        this(n2, new zD(zF2));
    }

    private zu_0(zF zF2) {
        this(1000, zF2);
    }

    @Deprecated
    private zu_0(int n2, zE zE2) {
        zE zE3 = zE2;
        this(1000, zE3.a);
    }

    @Deprecated
    private zu_0(zE zE2) {
        this(1000, zE2);
    }

    private zu_0(int n2, zD zD2) {
        super(zD2.c());
        this.c = null;
        this.i = Double.NEGATIVE_INFINITY;
        this.j = Double.POSITIVE_INFINITY;
        this.k = 0.0;
        this.d = false;
        this.m = null;
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.l = n2;
        this.h = zD2;
        this.b = new ArrayList<aw_0>();
    }

    private void a(double[] dArray) {
        a a2 = new a(this, dArray);
        try {
            ((b)a2).a();
            this.a(new a(this, dArray));
        }
        catch (IOException iOException) {
            throw new oY();
        }
        this.d = true;
    }

    public final void a(URL uRL) {
        ci_0.a(uRL);
        Charset charset = Charset.forName(f);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream(), charset));
        try {
            c c2 = new c(this, bufferedReader);
            ((b)c2).a();
            if (this.c.d() == 0L) {
                throw new pr_0(px_0.URL_CONTAINS_NO_DATA, uRL);
            }
            bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream(), charset));
            this.a(new c(this, bufferedReader));
            this.d = true;
        }
        catch (Throwable throwable) {
            try {
                bufferedReader.close();
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            bufferedReader.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    private void a(File file) {
        ci_0.a(file);
        Charset charset = Charset.forName(f);
        Object object = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)object, charset));
        try {
            object = new c(this, bufferedReader);
            ((b)object).a();
            object = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader((InputStream)object, charset));
            this.a(new c(this, bufferedReader));
            this.d = true;
        }
        catch (Throwable throwable) {
            try {
                bufferedReader.close();
            }
            catch (IOException iOException) {}
            throw throwable;
        }
        try {
            bufferedReader.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    private void a(b b2) {
        int n2;
        this.j = this.c.c();
        this.i = this.c.a();
        this.k = (this.i - this.j) / (double)this.l;
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        for (n2 = 0; n2 < this.l; ++n2) {
            aw_0 aw_02 = new aw_0();
            this.b.add(n2, aw_02);
        }
        b2.b();
        this.m = new double[this.l];
        this.m[0] = (double)this.b.get(0).d() / (double)this.c.d();
        for (n2 = 1; n2 < this.l - 1; ++n2) {
            this.m[n2] = this.m[n2 - 1] + (double)this.b.get(n2).d() / (double)this.c.d();
        }
        this.m[this.l - 1] = 1.0;
    }

    private int f(double d2) {
        return BY.a(BY.b((int)BY.z((d2 - this.j) / this.k) - 1, 0), this.l - 1);
    }

    public final double j() {
        if (!this.d) {
            throw new oX(px_0.DISTRIBUTION_NOT_LOADED, new Object[0]);
        }
        return this.b();
    }

    public final aw_0 k() {
        return this.c;
    }

    private int m() {
        return this.l;
    }

    public final List<aw_0> l() {
        return this.b;
    }

    private double[] n() {
        double[] dArray = new double[this.l];
        for (int i2 = 0; i2 < this.l - 1; ++i2) {
            dArray[i2] = this.j + this.k * (double)(i2 + 1);
        }
        dArray[this.l - 1] = this.i;
        return dArray;
    }

    private double[] o() {
        int n2 = this.m.length;
        double[] dArray = new double[n2];
        System.arraycopy(this.m, 0, dArray, 0, n2);
        return dArray;
    }

    private boolean p() {
        return this.d;
    }

    private void b(long l2) {
        this.h.a(l2);
    }

    @Override
    public final double b(double d2) {
        return 0.0;
    }

    @Override
    public final double d(double d2) {
        if (d2 < this.j || d2 > this.i) {
            return 0.0;
        }
        int n2 = this.f(d2);
        zu_0 zu_02 = this;
        oe_0 oe_02 = zu_02.a(zu_02.b.get(n2));
        return oe_02.d(d2) * this.b(n2) / this.d(n2);
    }

    @Override
    public final double e(double d2) {
        if (d2 < this.j) {
            return 0.0;
        }
        if (d2 >= this.i) {
            return 1.0;
        }
        int n2 = this.f(d2);
        double d3 = this.c(n2);
        double d4 = this.b(n2);
        double d5 = d2;
        oe_0 oe_02 = this;
        int n3 = ((zu_0)oe_02).f(d5);
        zu_0 zu_02 = oe_02;
        oe_02 = zu_02.a(zu_02.b.get(n3));
        if (oe_02 instanceof oj_0) {
            if (d2 < oe_02.c()) {
                return d3;
            }
            return d3 + d4;
        }
        double[] dArray = this.n();
        double d6 = this.d(n2);
        double d7 = n2 == 0 ? this.j : dArray[n2 - 1];
        double d8 = (oe_02.e(d2) - oe_02.e(d7)) / d6;
        return d3 + d4 * d8;
    }

    @Override
    public final double a(double d2) {
        double d3;
        oe_0 oe_02;
        int n2;
        zu_0 zu_02;
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        if (d2 == 0.0) {
            zu_0 zu_03 = this;
            return zu_03.j;
        }
        if (d2 == 1.0) {
            zu_0 zu_04 = this;
            return zu_04.i;
        }
        int n3 = 0;
        do {
            n2 = n3++;
            oe_02 = this;
        } while (zu_02.m[n2] < d2);
        zu_0 zu_05 = this;
        oe_02 = zu_05.a(zu_05.b.get(n3));
        double d4 = this.d(n3);
        double[] dArray = this.n();
        double d5 = n3 == 0 ? this.j : dArray[n3 - 1];
        double d6 = oe_02.e(d5);
        double d7 = this.b(n3);
        double d8 = this.c(n3);
        double d9 = d2 - d8;
        if (d3 <= 0.0) {
            return d5;
        }
        return oe_02.a(d6 + d9 * d4 / d7);
    }

    @Override
    public final double c() {
        return this.c.b();
    }

    @Override
    public final double d() {
        return this.c.g();
    }

    @Override
    public final double e() {
        return this.j;
    }

    @Override
    public final double f() {
        return this.i;
    }

    @Override
    public final boolean g() {
        return true;
    }

    @Override
    public final boolean h() {
        return true;
    }

    @Override
    public final boolean i() {
        return true;
    }

    @Override
    public final void a(long l2) {
        this.h.a(l2);
    }

    private double b(int n2) {
        if (n2 == 0) {
            return this.m[0];
        }
        return this.m[n2] - this.m[n2 - 1];
    }

    private double c(int n2) {
        if (n2 == 0) {
            return 0.0;
        }
        return this.m[n2 - 1];
    }

    private double d(int n2) {
        double[] dArray = this.n();
        zu_0 zu_02 = this;
        oe_0 oe_02 = zu_02.a(zu_02.b.get(n2));
        if (n2 == 0) {
            return oe_02.a(this.j, dArray[0]);
        }
        return oe_02.a(dArray[n2 - 1], dArray[n2]);
    }

    private oI g(double d2) {
        int n2 = this.f(d2);
        zu_0 zu_02 = this;
        return zu_02.a(zu_02.b.get(n2));
    }

    private double e(int n2) {
        return this.m[n2];
    }

    private oe_0 a(aw_0 aw_02) {
        if (aw_02.d() == 1L || aw_02.g() == 0.0) {
            return new oj_0(aw_02.b());
        }
        return new oE(this.h.c(), aw_02.b(), aw_02.e(), 1.0E-9);
    }

    static /* synthetic */ int a(zu_0 zu_02, double d2) {
        return zu_02.f(d2);
    }

    static /* synthetic */ List a(zu_0 zu_02) {
        return zu_02.b;
    }

    static /* synthetic */ aw_0 a(zu_0 zu_02, aw_0 aw_02) {
        zu_02.c = aw_02;
        return zu_02.c;
    }

    static /* synthetic */ aw_0 b(zu_0 zu_02) {
        return zu_02.c;
    }

    static final class 1 {
    }

    final class a
    extends b {
        private double[] a;
        private /* synthetic */ zu_0 b;

        a(zu_0 zu_02, double[] dArray) {
            this.b = zu_02;
            super(zu_02, (byte)0);
            ci_0.a((Object)dArray);
            this.a = dArray;
        }

        public final void a() {
            zu.a((zu_0)this.b, (aw_0)new aw_0());
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                zu.b((zu_0)this.b).a(this.a[i2]);
            }
        }

        public final void b() {
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                aw_0 aw_02 = (aw_0)zu.a((zu_0)this.b).get(zu.a((zu_0)this.b, (double)this.a[i2]));
                aw_02.a(this.a[i2]);
            }
        }
    }

    final class c
    extends b {
        private BufferedReader a;
        private /* synthetic */ zu_0 b;

        c(zu_0 zu_02, BufferedReader bufferedReader) {
            this.b = zu_02;
            super(zu_02, (byte)0);
            this.a = bufferedReader;
        }

        public final void b() {
            Object object;
            while ((object = this.a.readLine()) != null) {
                double d2 = Double.parseDouble((String)object);
                object = (aw_0)zu.a((zu_0)this.b).get(zu.a((zu_0)this.b, (double)d2));
                ((aw_0)object).a(d2);
            }
            this.a.close();
            this.a = null;
        }

        public final void a() {
            String string;
            zu.a((zu_0)this.b, (aw_0)new aw_0());
            while ((string = this.a.readLine()) != null) {
                double d2 = Double.parseDouble(string);
                zu.b((zu_0)this.b).a(d2);
            }
            this.a.close();
            this.a = null;
        }
    }

    abstract class b {
        private /* synthetic */ zu_0 a;

        private b(zu_0 zu_02) {
            this.a = zu_02;
        }

        public abstract void b();

        public abstract void a();

        /* synthetic */ b(zu_0 zu_02, byte by) {
            this(zu_02);
        }
    }
}

