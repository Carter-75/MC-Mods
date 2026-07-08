/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BU;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class BV
implements kM<BU> {
    private static final BV a = new BV();

    private BV() {
    }

    public static final BV d() {
        return a;
    }

    private static BU e() {
        return BU.a;
    }

    private static BU f() {
        return BU.b;
    }

    @Override
    public final Class<? extends kN<BU>> c() {
        return BU.class;
    }
}

