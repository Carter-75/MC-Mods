/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.at_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Au
 */
public final class au_0
implements Serializable,
at_0 {
    private static final long a = -5108854841843722536L;
    private final double b;
    private final double c;
    private final long d;
    private final double e;
    private final double f;
    private final double g;

    public au_0(double d2, double d3, long l2, double d4, double d5, double d6) {
        this.b = d2;
        this.c = d3;
        this.d = l2;
        this.e = d4;
        this.f = d5;
        this.g = d6;
    }

    public final double a() {
        return this.e;
    }

    public final double b() {
        return this.b;
    }

    public final double c() {
        return this.f;
    }

    public final long d() {
        return this.d;
    }

    public final double f() {
        return this.g;
    }

    public final double e() {
        return BY.a(this.c);
    }

    public final double g() {
        return this.c;
    }

    public final boolean equals(Object object) {
        au_0 au_02;
        if (object == this) {
            return true;
        }
        if (!(object instanceof au_0)) {
            return false;
        }
        return cq_0.b((au_02 = (au_0)au_02).a(), this.a()) && cq_0.b(au_02.b(), this.b()) && cq_0.b(au_02.c(), this.c()) && cq_0.b(au_02.d(), this.d()) && cq_0.b(au_02.f(), this.f()) && cq_0.b(au_02.g(), this.g());
    }

    public final int hashCode() {
        int n2 = 31 + ci_0.a(this.a());
        n2 = n2 * 31 + ci_0.a(this.b());
        n2 = n2 * 31 + ci_0.a(this.c());
        n2 = n2 * 31 + ci_0.a(this.d());
        n2 = n2 * 31 + ci_0.a(this.f());
        n2 = n2 * 31 + ci_0.a(this.g());
        return n2;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String string = "\n";
        stringBuffer.append("StatisticalSummaryValues:").append(string);
        stringBuffer.append("n: ").append(this.d()).append(string);
        stringBuffer.append("min: ").append(this.c()).append(string);
        stringBuffer.append("max: ").append(this.a()).append(string);
        stringBuffer.append("mean: ").append(this.b()).append(string);
        stringBuffer.append("std dev: ").append(this.e()).append(string);
        stringBuffer.append("variance: ").append(this.g()).append(string);
        stringBuffer.append("sum: ").append(this.f()).append(string);
        return stringBuffer.toString();
    }
}

