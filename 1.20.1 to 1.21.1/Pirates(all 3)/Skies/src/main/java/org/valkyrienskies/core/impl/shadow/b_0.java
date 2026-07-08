/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.Temporal;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.b
 */
public enum b_0 {
    YEAR(4),
    MONTH(7),
    DAY(10),
    HOUR(13),
    MINUTE(16),
    SECOND(19),
    NANO(20);

    public final int requiredLength;

    private b_0(int n3) {
        this.requiredLength = n3;
    }

    private static b_0 a(Class<? extends Temporal> clazz) {
        if (Year.class.equals(clazz)) {
            return YEAR;
        }
        if (YearMonth.class.equals(clazz)) {
            return MONTH;
        }
        if (LocalDate.class.equals(clazz)) {
            return DAY;
        }
        if (OffsetDateTime.class.equals(clazz)) {
            return SECOND;
        }
        throw new IllegalArgumentException("Type " + clazz.getSimpleName() + " is not supported");
    }

    public final int a() {
        return this.requiredLength;
    }
}

