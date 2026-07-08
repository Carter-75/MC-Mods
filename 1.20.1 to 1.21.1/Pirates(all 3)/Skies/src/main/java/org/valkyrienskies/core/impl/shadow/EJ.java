/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.EG;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class EJ
implements ek_2<Map<String, DP>> {
    private final EG a;

    private EJ(EG eG) {
        this.a = eG;
    }

    private Map<String, DP> a() {
        EG eG = this.a;
        EG eG2 = eG;
        eG2 = eG;
        return ev_2.b(eG.d);
    }

    public static EJ a(EG eG) {
        return new EJ(eG);
    }

    private static Map<String, DP> b(EG eG) {
        return ev_2.b(eG.d);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        EG eG = ((EJ)object).a;
        object = eG;
        object = eG;
        return ev_2.b(eG.d);
    }
}

