/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.Temporal;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.f
 */
public interface f_0<T> {
    default public T a(LocalDateTime localDateTime) {
        return this.a((Temporal)localDateTime);
    }

    default public T a(LocalDate localDate) {
        return this.a((Temporal)localDate);
    }

    default public T a(YearMonth yearMonth) {
        return this.a((Temporal)yearMonth);
    }

    default public T a(Year year) {
        return this.a((Temporal)year);
    }

    default public T a(OffsetDateTime offsetDateTime) {
        return this.a((Temporal)offsetDateTime);
    }

    default public T a(Temporal temporal) {
        throw new UnsupportedOperationException("Unhandled type " + temporal.getClass());
    }
}

