/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.tu
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.text.FieldPosition;
import java.util.Arrays;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BS;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.tv_0;
import org.valkyrienskies.core.impl.shadow.tw_0;
import org.valkyrienskies.core.impl.shadow.tx_0;

public class sA
extends tu
implements Serializable {
    private static final long b = -1097961340710804027L;
    private static final tw_0 c;
    public double[] a;

    public sA() {
        this.a = new double[0];
    }

    public sA(int n2) {
        this.a = new double[n2];
    }

    private sA(int n2, double d2) {
        this.a = new double[n2];
        Arrays.fill(this.a, d2);
    }

    public sA(double[] dArray) {
        this.a = (double[])dArray.clone();
    }

    public sA(double[] dArray, boolean bl) {
        if (dArray == null) {
            throw new pl_0();
        }
        this.a = bl ? (double[])dArray.clone() : dArray;
    }

    private sA(double[] dArray, int n2, int n3) {
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray.length < n2 + n3) {
            throw new pm_0(n2 + n3, (Number)dArray.length, true);
        }
        this.a = new double[n3];
        System.arraycopy(dArray, n2, this.a, 0, n3);
    }

    private sA(Double[] doubleArray) {
        this.a = new double[doubleArray.length];
        for (int i2 = 0; i2 < doubleArray.length; ++i2) {
            this.a[i2] = doubleArray[i2];
        }
    }

    private sA(Double[] doubleArray, int n2, int n3) {
        if (doubleArray == null) {
            throw new pl_0();
        }
        if (doubleArray.length < n2 + n3) {
            throw new pm_0(n2 + n3, (Number)doubleArray.length, true);
        }
        this.a = new double[n3];
        for (int i2 = n2; i2 < n2 + n3; ++i2) {
            this.a[i2 - n2] = doubleArray[i2];
        }
    }

    public sA(tu_0 tu_02) {
        if (tu_02 == null) {
            throw new pl_0();
        }
        this.a = new double[tu_02.f()];
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = tu_02.a(i2);
        }
    }

    private sA(sA sA2) {
        this(sA2, true);
    }

    private sA(sA sA2, boolean bl) {
        this.a = (double[])sA2.a.clone();
    }

    private sA(sA sA2, sA sA3) {
        this.a = new double[sA2.a.length + sA3.a.length];
        System.arraycopy(sA2.a, 0, this.a, 0, sA2.a.length);
        System.arraycopy(sA3.a, 0, this.a, sA2.a.length, sA3.a.length);
    }

    private sA(sA sA2, tu_0 tu_02) {
        int n2 = sA2.a.length;
        int n3 = tu_02.f();
        this.a = new double[n2 + n3];
        System.arraycopy(sA2.a, 0, this.a, 0, n2);
        for (int i2 = 0; i2 < n3; ++i2) {
            this.a[n2 + i2] = tu_02.a(i2);
        }
    }

    private sA(tu_0 tu_02, sA sA2) {
        int n2 = tu_02.f();
        int n3 = sA2.a.length;
        this.a = new double[n2 + n3];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a[i2] = tu_02.a(i2);
        }
        System.arraycopy(sA2.a, 0, this.a, n2, n3);
    }

    private sA(sA sA2, double[] dArray) {
        sA sA3 = sA2;
        int n2 = sA3.a.length;
        int n3 = dArray.length;
        this.a = new double[n2 + n3];
        System.arraycopy(sA2.a, 0, this.a, 0, n2);
        System.arraycopy(dArray, 0, this.a, n2, n3);
    }

    private sA(double[] dArray, sA sA2) {
        int n2 = dArray.length;
        sA sA3 = sA2;
        int n3 = sA3.a.length;
        this.a = new double[n2 + n3];
        System.arraycopy(dArray, 0, this.a, 0, n2);
        System.arraycopy(sA2.a, 0, this.a, n2, n3);
    }

    private sA(double[] dArray, double[] dArray2) {
        int n2 = dArray.length;
        int n3 = dArray2.length;
        this.a = new double[n2 + n3];
        System.arraycopy(dArray, 0, this.a, 0, n2);
        System.arraycopy(dArray2, 0, this.a, n2, n3);
    }

    public final sA a() {
        return new sA(this, true);
    }

    private sA o(tu_0 object) {
        if (object instanceof sA) {
            double[] dArray = ((sA)object).a;
            int n2 = ((sA)object).a.length;
            this.b(n2);
            sA sA2 = new sA(n2);
            double[] dArray2 = sA2.a;
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray2[i2] = this.a[i2] + dArray[i2];
            }
            return sA2;
        }
        this.h((tu_0)object);
        double[] dArray = (double[])this.a.clone();
        object = object.l();
        while (object.hasNext()) {
            tu_0.a a2 = (tu_0.a)object.next();
            int n3 = a2.b();
            dArray[n3] = dArray[n3] + a2.a();
        }
        return new sA(dArray, false);
    }

    public final sA a(tu_0 object) {
        if (object instanceof sA) {
            double[] dArray = ((sA)object).a;
            int n2 = ((sA)object).a.length;
            this.b(n2);
            sA sA2 = new sA(n2);
            double[] dArray2 = sA2.a;
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray2[i2] = this.a[i2] - dArray[i2];
            }
            return sA2;
        }
        this.h((tu_0)object);
        double[] dArray = (double[])this.a.clone();
        object = object.l();
        while (object.hasNext()) {
            tu_0.a a2 = (tu_0.a)object.next();
            int n3 = a2.b();
            dArray[n3] = dArray[n3] - a2.a();
        }
        return new sA(dArray, false);
    }

    public final sA a(lc_0 lc_02) {
        return this.a().d(lc_02);
    }

    private sA d(lc_0 lc_02) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = lc_02.a(this.a[i2]);
        }
        return this;
    }

    public final tu_0 a(double d2) {
        int n2 = 0;
        while (n2 < this.a.length) {
            int n3 = n2++;
            this.a[n3] = this.a[n3] + d2;
        }
        return this;
    }

    public final tu_0 b(double d2) {
        int n2 = 0;
        while (n2 < this.a.length) {
            int n3 = n2++;
            this.a[n3] = this.a[n3] - d2;
        }
        return this;
    }

    public final tu_0 c(double d2) {
        int n2 = 0;
        while (n2 < this.a.length) {
            int n3 = n2++;
            this.a[n3] = this.a[n3] * d2;
        }
        return this;
    }

    public final tu_0 d(double d2) {
        int n2 = 0;
        while (n2 < this.a.length) {
            int n3 = n2++;
            this.a[n3] = this.a[n3] / d2;
        }
        return this;
    }

    private sA p(tu_0 object) {
        if (object instanceof sA) {
            double[] dArray = ((sA)object).a;
            int n2 = ((sA)object).a.length;
            this.b(n2);
            object = new sA(n2);
            double[] dArray2 = ((sA)object).a;
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray2[i2] = this.a[i2] * dArray[i2];
            }
            return object;
        }
        this.h((tu_0)object);
        double[] dArray = (double[])this.a.clone();
        for (int i3 = 0; i3 < this.a.length; ++i3) {
            int n3 = i3;
            dArray[n3] = dArray[n3] * object.a(i3);
        }
        return new sA(dArray, false);
    }

    private sA q(tu_0 object) {
        if (object instanceof sA) {
            double[] dArray = ((sA)object).a;
            int n2 = ((sA)object).a.length;
            this.b(n2);
            object = new sA(n2);
            double[] dArray2 = ((sA)object).a;
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray2[i2] = this.a[i2] / dArray[i2];
            }
            return object;
        }
        this.h((tu_0)object);
        double[] dArray = (double[])this.a.clone();
        for (int i3 = 0; i3 < this.a.length; ++i3) {
            int n3 = i3;
            dArray[n3] = dArray[n3] / object.a(i3);
        }
        return new sA(dArray, false);
    }

    public final double[] b() {
        return this.a;
    }

    public final double b(tu_0 object) {
        if (object instanceof sA) {
            object = ((sA)object).a;
            this.b(((Object)object).length);
            double d2 = 0.0;
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                d2 += this.a[i2] * object[i2];
            }
            return d2;
        }
        return super.b((tu_0)object);
    }

    public final double c() {
        double d2 = 0.0;
        double[] dArray = this.a;
        int n2 = this.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d3;
            double d4 = d3 = dArray[i2];
            d2 += d4 * d4;
        }
        return BY.a(d2);
    }

    public final double d() {
        double d2 = 0.0;
        double[] dArray = this.a;
        int n2 = this.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d3 = dArray[i2];
            d2 += BY.w(d3);
        }
        return d2;
    }

    public final double e() {
        double d2 = 0.0;
        double[] dArray = this.a;
        int n2 = this.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d3 = dArray[i2];
            d2 = BY.e(d2, BY.w(d3));
        }
        return d2;
    }

    public final double c(tu_0 tu_02) {
        if (tu_02 instanceof sA) {
            double[] dArray = ((sA)((Object)tu_02)).a;
            this.b(dArray.length);
            double d2 = 0.0;
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                double d3;
                double d4 = d3 = this.a[i2] - dArray[i2];
                d2 += d4 * d4;
            }
            return BY.a(d2);
        }
        this.h(tu_02);
        double d5 = 0.0;
        for (int i3 = 0; i3 < this.a.length; ++i3) {
            double d6;
            double d7 = d6 = this.a[i3] - tu_02.a(i3);
            d5 += d7 * d7;
        }
        return BY.a(d5);
    }

    public final double d(tu_0 tu_02) {
        if (tu_02 instanceof sA) {
            double[] dArray = ((sA)((Object)tu_02)).a;
            this.b(dArray.length);
            double d2 = 0.0;
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                double d3 = this.a[i2] - dArray[i2];
                d2 += BY.w(d3);
            }
            return d2;
        }
        this.h(tu_02);
        double d4 = 0.0;
        for (int i3 = 0; i3 < this.a.length; ++i3) {
            double d5 = this.a[i3] - tu_02.a(i3);
            d4 += BY.w(d5);
        }
        return d4;
    }

    public final double e(tu_0 tu_02) {
        if (tu_02 instanceof sA) {
            double[] dArray = ((sA)((Object)tu_02)).a;
            this.b(dArray.length);
            double d2 = 0.0;
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                double d3 = this.a[i2] - dArray[i2];
                d2 = BY.e(d2, BY.w(d3));
            }
            return d2;
        }
        this.h(tu_02);
        double d4 = 0.0;
        for (int i3 = 0; i3 < this.a.length; ++i3) {
            double d5 = this.a[i3] - tu_02.a(i3);
            d4 = BY.e(d4, BY.w(d5));
        }
        return d4;
    }

    public final tq_0 f(tu_0 tu_02) {
        if (tu_02 instanceof sA) {
            double[] dArray = ((sA)((Object)tu_02)).a;
            int n2 = this.a.length;
            int n3 = dArray.length;
            sv_0 sv_02 = td_0.a(n2, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                for (int i3 = 0; i3 < n3; ++i3) {
                    sv_02.c(i2, i3, this.a[i2] * dArray[i3]);
                }
            }
            return sv_02;
        }
        int n4 = this.a.length;
        int n5 = tu_02.f();
        sv_0 sv_03 = td_0.a(n4, n5);
        for (int i4 = 0; i4 < n4; ++i4) {
            for (int i5 = 0; i5 < n5; ++i5) {
                sv_03.c(i4, i5, this.a[i4] * tu_02.a(i5));
            }
        }
        return sv_03;
    }

    public final double a(int n2) {
        try {
            return this.a[n2];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            sA sA2 = this;
            throw new po_0(px_0.INDEX, (Number)n2, 0, sA2.a.length - 1);
        }
    }

    public final int f() {
        return this.a.length;
    }

    public final tu_0 g(tu_0 tu_02) {
        try {
            return new sA(this, (sA)((Object)tu_02));
        }
        catch (ClassCastException classCastException) {
            return new sA(this, tu_02);
        }
    }

    private sA a(sA sA2) {
        return new sA(this, sA2);
    }

    public final tu_0 e(double d2) {
        double[] dArray = new double[this.a.length + 1];
        System.arraycopy(this.a, 0, dArray, 0, this.a.length);
        dArray[this.a.length] = d2;
        return new sA(dArray, false);
    }

    public final tu_0 a(int n2, int n3) {
        if (n3 < 0) {
            throw new pj_0(px_0.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, n3);
        }
        sA sA2 = new sA(n3);
        try {
            System.arraycopy(this.a, n2, sA2.a, 0, n3);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.c(n2);
            this.c(n2 + n3 - 1);
        }
        return sA2;
    }

    public final void a(int n2, double d2) {
        try {
            this.a[n2] = d2;
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.c(n2);
            return;
        }
    }

    public final void b(int n2, double d2) {
        try {
            int n3 = n2;
            this.a[n3] = this.a[n3] + d2;
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new po_0(px_0.INDEX, (Number)n2, 0, this.a.length - 1);
        }
    }

    public final void a(int n2, tu_0 tu_02) {
        if (tu_02 instanceof sA) {
            double[] dArray = ((sA)((Object)tu_02)).a;
            int n3 = 0;
            sA sA2 = this;
            try {
                System.arraycopy(dArray, 0, sA2.a, n3, dArray.length);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                sA2.c(n3);
                sA2.c(n3 + dArray.length - 1);
                return;
            }
        } else {
            try {
                for (n2 = 0; n2 < 0 + tu_02.f(); ++n2) {
                    this.a[n2] = tu_02.a(n2);
                }
                return;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                this.c(0);
                this.c(0 + tu_02.f() - 1);
            }
        }
    }

    private void a(int n2, double[] dArray) {
        try {
            System.arraycopy(dArray, 0, this.a, n2, dArray.length);
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.c(n2);
            this.c(n2 + dArray.length - 1);
            return;
        }
    }

    public final void f(double d2) {
        Arrays.fill(this.a, 0.0);
    }

    public final double[] g() {
        return (double[])this.a.clone();
    }

    public String toString() {
        sA sA2 = this;
        tw_0 tw_02 = c;
        FieldPosition fieldPosition = new FieldPosition(0);
        StringBuffer stringBuffer = new StringBuffer();
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(tw_02.a);
        for (int i2 = 0; i2 < sA2.f(); ++i2) {
            if (i2 > 0) {
                stringBuffer.append(tw_02.c);
            }
            BS.a(sA2.a(i2), tw_02.d, stringBuffer, fieldPosition);
        }
        stringBuffer.append(tw_02.b);
        return stringBuffer.toString();
    }

    protected final void h(tu_0 tu_02) {
        this.b(tu_02.f());
    }

    protected final void b(int n2) {
        if (this.a.length != n2) {
            throw new oS(this.a.length, n2);
        }
    }

    public final boolean h() {
        double[] dArray = this.a;
        int n2 = this.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2 = dArray[i2];
            if (!Double.isNaN(d2)) continue;
            return true;
        }
        return false;
    }

    public final boolean i() {
        if (this.h()) {
            return false;
        }
        double[] dArray = this.a;
        int n2 = this.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2 = dArray[i2];
            if (!Double.isInfinite(d2)) continue;
            return true;
        }
        return false;
    }

    public boolean equals(Object other) {
        tu tu2;
        if (this == other) {
            return true;
        }
        if (!(other instanceof tu)) {
            return false;
        }
        if (this.a.length != (tu2 = (tu)tu2).f()) {
            return false;
        }
        if (tu2.h()) {
            return this.h();
        }
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] == tu2.a(i2)) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.h()) {
            return 9;
        }
        double[] dArray = this.a;
        return Arrays.hashCode(this.a);
    }

    private sA c(double d2, double d3, tu_0 tu_02) {
        return this.a().d(d2, d3, tu_02);
    }

    private sA d(double d2, double d3, tu_0 tu_02) {
        if (tu_02 instanceof sA) {
            double[] dArray = ((sA)((Object)tu_02)).a;
            this.b(dArray.length);
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                this.a[i2] = d2 * this.a[i2] + d3 * dArray[i2];
            }
        } else {
            this.h(tu_02);
            for (int i3 = 0; i3 < this.a.length; ++i3) {
                this.a[i3] = d2 * this.a[i3] + d3 * tu_02.a(i3);
            }
        }
        return this;
    }

    public final double a(tx_0 tx_02) {
        int cfr_ignored_0 = this.a.length;
        int cfr_ignored_1 = this.a.length;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            double cfr_ignored_2 = this.a[i2];
        }
        return tx_02.c();
    }

    public final double a(tx_0 tx_02, int n2, int n3) {
        this.b(n2, n3);
        int cfr_ignored_0 = this.a.length;
        while (n2 <= n3) {
            double cfr_ignored_1 = this.a[n2];
            ++n2;
        }
        return tx_02.c();
    }

    public final double b(tx_0 tx_02) {
        return this.a(tx_02);
    }

    public final double b(tx_0 tx_02, int n2, int n3) {
        return this.a(tx_02, n2, n3);
    }

    public final double a(tv_0 tv_02) {
        int cfr_ignored_0 = this.a.length;
        int cfr_ignored_1 = this.a.length;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            double cfr_ignored_2 = this.a[i2];
            this.a[i2] = tv_02.b();
        }
        return tv_02.c();
    }

    public final double a(tv_0 tv_02, int n2, int n3) {
        this.b(n2, n3);
        int cfr_ignored_0 = this.a.length;
        while (n2 <= n3) {
            double cfr_ignored_1 = this.a[n2];
            this.a[n2] = tv_02.b();
            ++n2;
        }
        return tv_02.c();
    }

    public final double b(tv_0 tv_02) {
        return this.a(tv_02);
    }

    public final double b(tv_0 tv_02, int n2, int n3) {
        return this.a(tv_02, n2, n3);
    }

    public final /* synthetic */ tu_0 a(double d2, double d3, tu_0 tu_02) {
        return this.d(d2, d3, tu_02);
    }

    public final /* synthetic */ tu_0 b(double d2, double d3, tu_0 tu_02) {
        tu_0 tu_03 = tu_02;
        double d4 = d3;
        double d5 = d2;
        sA sA2 = this;
        return sA2.a().d(d5, d4, tu_03);
    }

    public final /* synthetic */ tu_0 b(lc_0 lc_02) {
        return this.d(lc_02);
    }

    public final /* synthetic */ tu_0 c(lc_0 lc_02) {
        return this.a(lc_02);
    }

    public final /* synthetic */ tu_0 i(tu_0 object) {
        Object object2 = object;
        object = this;
        if (object2 instanceof sA) {
            double[] dArray = ((sA)object2).a;
            int n2 = ((sA)object2).a.length;
            ((sA)object).b(n2);
            object2 = new sA(n2);
            double[] dArray2 = ((sA)object2).a;
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray2[i2] = ((sA)object).a[i2] * dArray[i2];
            }
            return object2;
        }
        ((sA)object).h((tu_0)object2);
        double[] dArray = (double[])((sA)object).a.clone();
        for (int i3 = 0; i3 < ((sA)object).a.length; ++i3) {
            int n3 = i3;
            dArray[n3] = dArray[n3] * object2.a(i3);
        }
        return new sA(dArray, false);
    }

    public final /* synthetic */ tu_0 j(tu_0 object) {
        Object object2 = object;
        object = this;
        if (object2 instanceof sA) {
            double[] dArray = ((sA)object2).a;
            int n2 = ((sA)object2).a.length;
            ((sA)object).b(n2);
            object2 = new sA(n2);
            double[] dArray2 = ((sA)object2).a;
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray2[i2] = ((sA)object).a[i2] / dArray[i2];
            }
            return object2;
        }
        ((sA)object).h((tu_0)object2);
        double[] dArray = (double[])((sA)object).a.clone();
        for (int i3 = 0; i3 < ((sA)object).a.length; ++i3) {
            int n3 = i3;
            dArray[n3] = dArray[n3] / object2.a(i3);
        }
        return new sA(dArray, false);
    }

    public final /* synthetic */ tu_0 j() {
        return this.a();
    }

    public final /* synthetic */ tu_0 k(tu_0 tu_02) {
        return this.a(tu_02);
    }

    public final /* synthetic */ tu_0 l(tu_0 object) {
        Object object2 = object;
        object = this;
        if (object2 instanceof sA) {
            double[] dArray = ((sA)object2).a;
            int n2 = ((sA)object2).a.length;
            ((sA)object).b(n2);
            sA sA2 = new sA(n2);
            double[] dArray2 = sA2.a;
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray2[i2] = ((sA)object).a[i2] + dArray[i2];
            }
            return sA2;
        }
        ((sA)object).h((tu_0)object2);
        double[] dArray = (double[])((sA)object).a.clone();
        object2 = object2.l();
        while (object2.hasNext()) {
            tu_0.a a2 = (tu_0.a)object2.next();
            int n3 = a2.b();
            dArray[n3] = dArray[n3] + a2.a();
        }
        return new sA(dArray, false);
    }

    static {
        Locale locale = Locale.getDefault();
        c = new tw_0(BS.a(locale));
    }
}

