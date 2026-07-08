/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.time.DateTimeException;
import java.time.OffsetDateTime;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.d
 */
public final class d_0
extends DateTimeException {
    private final int b;
    public final boolean a;
    private final OffsetDateTime c;

    public d_0(OffsetDateTime offsetDateTime, int n2, boolean bl) {
        super("Leap second detected in input");
        this.c = offsetDateTime;
        this.b = n2;
        this.a = bl;
    }

    private int b() {
        return this.b;
    }

    private OffsetDateTime c() {
        return this.c;
    }

    public final boolean a() {
        return this.a;
    }
}

