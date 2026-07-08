/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.Objects;
import java.util.Optional;
import org.valkyrienskies.core.impl.shadow.b_0;
import org.valkyrienskies.core.impl.shadow.h_0;
import org.valkyrienskies.core.impl.shadow.k_0;
import org.valkyrienskies.core.impl.shadow.m_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.a
 */
public final class a_0 {
    private final b_0 c;
    final int a;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    final h_0 b;
    private final int j;

    private a_0(b_0 b_02, int n2, int n3, int n4, int n5, int n6, int n7, int n8, h_0 h_02, int n9) {
        this.c = b_02;
        this.a = n2;
        this.d = a_0.a(n3, 1, 12, b_0.MONTH);
        this.e = a_0.a(n4, 1, 31, b_0.DAY);
        this.f = a_0.a(n5, 0, 23, b_0.HOUR);
        this.g = a_0.a(n6, 0, 59, b_0.MINUTE);
        this.h = a_0.a(n7, 0, 60, b_0.SECOND);
        this.i = a_0.a(n8, 0, 999999999, b_0.NANO);
        this.b = h_02;
        this.j = n9;
    }

    public static a_0 a(int n2, int n3, int n4, int n5, int n6, int n7, h_0 h_02) {
        return new a_0(b_0.SECOND, n2, n3, n4, n5, n6, n7, 0, h_02, 0);
    }

    public static a_0 a(int n2, int n3, int n4, int n5, int n6, int n7, int n8, h_0 h_02, int n9) {
        return new a_0(b_0.NANO, n2, n3, n4, n5, n6, n7, n8, h_02, n9);
    }

    public static a_0 a(int n2) {
        return new a_0(b_0.YEAR, n2, 0, 0, 0, 0, 0, 0, null, 0);
    }

    public static a_0 a(int n2, int n3) {
        return new a_0(b_0.MONTH, n2, n3, 0, 0, 0, 0, 0, null, 0);
    }

    public static a_0 a(int n2, int n3, int n4) {
        return new a_0(b_0.DAY, n2, n3, n4, 0, 0, 0, 0, null, 0);
    }

    public static a_0 a(int n2, int n3, int n4, int n5, int n6, h_0 h_02) {
        return new a_0(b_0.MINUTE, n2, n3, n4, n5, n6, 0, 0, h_02, 0);
    }

    private static a_0 a(OffsetDateTime offsetDateTime) {
        return a_0.a(offsetDateTime.getYear(), offsetDateTime.getMonthValue(), offsetDateTime.getDayOfMonth(), offsetDateTime.getHour(), offsetDateTime.getMinute(), offsetDateTime.getSecond(), offsetDateTime.getNano(), h_0.a(offsetDateTime.getOffset()), 9);
    }

    private static int a(int n2, int n3, int n4, b_0 b_02) {
        if (n2 > n4) {
            throw new DateTimeException("Field " + b_02.name() + " out of bounds. Expected " + n3 + "-" + n4 + ", got " + n2);
        }
        return n2;
    }

    public final boolean a(b_0 b_02) {
        return b_02.ordinal() <= this.c.ordinal();
    }

    public final int a() {
        return this.a;
    }

    private int g() {
        return this.d;
    }

    private int h() {
        return this.e;
    }

    private int i() {
        return this.f;
    }

    private int j() {
        return this.g;
    }

    private int k() {
        return this.h;
    }

    private int l() {
        return this.i;
    }

    public final Optional<h_0> b() {
        return Optional.ofNullable(this.b);
    }

    private Year m() {
        return Year.of(this.a);
    }

    public final YearMonth c() {
        this.b(b_0.MONTH);
        return YearMonth.of(this.a, this.d);
    }

    public final LocalDateTime d() {
        this.b(b_0.MINUTE);
        return LocalDateTime.of(this.a, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public final OffsetDateTime e() {
        this.b(b_0.MINUTE);
        if (this.b != null) {
            return OffsetDateTime.of(this.a, this.d, this.e, this.f, this.g, this.h, this.i, this.b.d());
        }
        throw new DateTimeException("No zone offset information found");
    }

    public final LocalDate f() {
        this.b(b_0.DAY);
        return LocalDate.of(this.a, this.d, this.e);
    }

    private b_0 n() {
        return this.c;
    }

    private void b(b_0 b_02) {
        if (!this.a(b_02)) {
            throw new DateTimeException("No " + b_02.name() + " field found");
        }
    }

    private String c(b_0 b_02) {
        return a_0.a(this, b_02, 0);
    }

    private String b(int n2) {
        return a_0.a(this, b_0.NANO, n2);
    }

    private static String a(a_0 a_02, b_0 b_02, int n2) {
        Object object = a_02;
        if (b_02.ordinal() > object.c.ordinal()) {
            object = a_02;
            throw new DateTimeException("Requested granularity was " + b_02.name() + ", but contains only granularity " + object.c.name());
        }
        object = a_02;
        h_0 h_02 = Optional.ofNullable(object.b).orElse(null);
        char[] cArray = new char[35];
        object = a_02;
        m_0.a(object.a, cArray, 0, 4);
        if (b_02 == b_0.YEAR) {
            object = b_0.YEAR;
            return k_0.a(cArray, ((b_0)((Object)object)).requiredLength, null);
        }
        if (b_02.ordinal() >= b_0.MONTH.ordinal()) {
            cArray[4] = 45;
            object = a_02;
            m_0.a(object.d, cArray, 5, 2);
        }
        if (b_02 == b_0.MONTH) {
            object = b_0.MONTH;
            return k_0.a(cArray, ((b_0)((Object)object)).requiredLength, null);
        }
        if (b_02.ordinal() >= b_0.DAY.ordinal()) {
            cArray[7] = 45;
            object = a_02;
            m_0.a(object.e, cArray, 8, 2);
        }
        if (b_02 == b_0.DAY) {
            object = b_0.DAY;
            return k_0.a(cArray, ((b_0)((Object)object)).requiredLength, null);
        }
        if (b_02.ordinal() >= b_0.HOUR.ordinal()) {
            cArray[10] = 84;
            object = a_02;
            m_0.a(object.f, cArray, 11, 2);
        }
        if (b_02 == b_0.HOUR) {
            object = b_0.HOUR;
            return k_0.a(cArray, ((b_0)((Object)object)).requiredLength, h_02);
        }
        if (b_02.ordinal() >= b_0.MINUTE.ordinal()) {
            cArray[13] = 58;
            object = a_02;
            m_0.a(object.g, cArray, 14, 2);
        }
        if (b_02 == b_0.MINUTE) {
            object = b_0.MINUTE;
            return k_0.a(cArray, ((b_0)((Object)object)).requiredLength, h_02);
        }
        if (b_02.ordinal() >= b_0.SECOND.ordinal()) {
            cArray[16] = 58;
            object = a_02;
            m_0.a(object.h, cArray, 17, 2);
        }
        if (b_02 == b_0.SECOND) {
            object = b_0.SECOND;
            return k_0.a(cArray, ((b_0)((Object)object)).requiredLength, h_02);
        }
        if (b_02.ordinal() >= b_0.NANO.ordinal()) {
            cArray[19] = 46;
            object = a_02;
            m_0.a(object.i, cArray, 20, n2);
        }
        return k_0.a(cArray, n2 + 20, h_02);
    }

    private int o() {
        return this.j;
    }

    public final String toString() {
        if (this.j > 0) {
            a_0 a_02 = this;
            int n2 = a_02.j;
            a_0 a_03 = a_02;
            return a_0.a(a_02, b_0.NANO, n2);
        }
        a_0 a_04 = this;
        b_0 b_02 = a_04.c;
        a_0 a_05 = a_04;
        return a_0.a(a_04, b_02, 0);
    }

    public final boolean equals(Object o) {
        a_0 a_02;
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        a_02 = a_02;
        return this.a == a_02.a && this.d == a_02.d && this.e == a_02.e && this.f == a_02.f && this.g == a_02.g && this.h == a_02.h && this.i == a_02.i && this.j == a_02.j && this.c == a_02.c && Objects.equals(this.b, a_02.b);
    }

    public final int hashCode() {
        return Objects.hash(this.c.ordinal(), this.a, this.d, this.e, this.f, this.g, this.h, this.i, this.b, this.j);
    }
}

