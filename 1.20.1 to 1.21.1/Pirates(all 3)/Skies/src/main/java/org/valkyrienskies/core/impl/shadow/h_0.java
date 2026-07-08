/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.time.DateTimeException;
import java.time.ZoneOffset;
import java.util.Objects;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.h
 */
public final class h_0 {
    public static final h_0 a = new h_0(0, 0);
    public final int b;
    public final int c;

    private h_0(int n2, int n3) {
        if (n2 > 0 && n3 < 0) {
            throw new DateTimeException("Zone offset minutes must be positive because hours is positive");
        }
        if (n2 < 0 && n3 > 0) {
            throw new DateTimeException("Zone offset minutes must be negative because hours is negative");
        }
        this.b = n2;
        this.c = n3;
    }

    public static h_0 a(int n2, int n3) {
        return new h_0(n2, n3);
    }

    public static h_0 a(ZoneOffset zoneOffset) {
        int n2 = zoneOffset.getTotalSeconds();
        int n3 = n2 / 3600;
        n2 %= 3600;
        return h_0.a(n3, n2 /= 60);
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.b * 60 * 60 + this.c * 60;
    }

    public final ZoneOffset d() {
        if (this.equals(a)) {
            return ZoneOffset.UTC;
        }
        return ZoneOffset.ofHoursMinutes(this.b, this.c);
    }

    public final boolean equals(Object o) {
        h_0 h_02;
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        h_02 = h_02;
        return this.b == h_02.b && this.c == h_02.c;
    }

    public final int hashCode() {
        return Objects.hash(this.b, this.c);
    }

    public final String toString() {
        return "TimezoneOffset{hours=" + this.b + ", minutes=" + this.c + '}';
    }
}

