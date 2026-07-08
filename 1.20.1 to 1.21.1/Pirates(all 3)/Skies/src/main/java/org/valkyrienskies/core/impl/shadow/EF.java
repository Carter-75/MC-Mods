/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.EC;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class EF
implements ek_2<Map<String, DP>> {
    private final EC a;

    private EF(EC eC) {
        this.a = eC;
    }

    private Map<String, DP> a() {
        EC eC = this.a;
        EC eC2 = eC;
        eC2 = eC;
        return ev_2.b(eC.a);
    }

    public static EF a(EC eC) {
        return new EF(eC);
    }

    private static Map<String, DP> b(EC eC) {
        return ev_2.b(eC.a);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        EC eC = ((EF)object).a;
        object = eC;
        object = eC;
        return ev_2.b(eC.a);
    }
}

