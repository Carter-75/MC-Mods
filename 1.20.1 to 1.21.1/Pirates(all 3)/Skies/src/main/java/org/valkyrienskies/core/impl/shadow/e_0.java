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
 * Renamed from org.valkyrienskies.core.impl.shadow.e
 */
public interface e_0 {
    default public void a(LocalDateTime localDateTime) {
        this.a((Temporal)localDateTime);
    }

    default public void a(LocalDate localDate) {
        this.a((Temporal)localDate);
    }

    default public void a(YearMonth yearMonth) {
        this.a((Temporal)yearMonth);
    }

    default public void a(Year year) {
        this.a((Temporal)year);
    }

    default public void a(OffsetDateTime offsetDateTime) {
        this.a((Temporal)offsetDateTime);
    }

    default public void a(Temporal temporal) {
        throw new UnsupportedOperationException("Unhandled type " + temporal.getClass());
    }
}

