/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.shadow.EG;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.internal.ships.VsiMutableQueryableShipData;

public final class EH
implements ek_2<VsiMutableQueryableShipData<ShipData>> {
    private final EG a;

    private EH(EG eG) {
        this.a = eG;
    }

    private VsiMutableQueryableShipData<ShipData> a() {
        EG eG = this.a;
        EG eG2 = eG;
        eG2 = eG;
        return ev_2.b(eG.b);
    }

    public static EH a(EG eG) {
        return new EH(eG);
    }

    private static VsiMutableQueryableShipData<ShipData> b(EG eG) {
        return ev_2.b(eG.b);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        EG eG = ((EH)object).a;
        object = eG;
        object = eG;
        return ev_2.b(eG.b);
    }
}

