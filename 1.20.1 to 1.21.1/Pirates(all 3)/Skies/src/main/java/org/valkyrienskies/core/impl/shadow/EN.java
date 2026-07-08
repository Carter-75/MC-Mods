/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.ShipObjectClientWorld;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.EL;
import org.valkyrienskies.core.impl.shadow.EM;
import org.valkyrienskies.core.impl.shadow.eo_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.fi_0;

public final class EN
implements EL.b {
    private final EM a;

    private EN(EM eM) {
        this.a = eM;
    }

    @Override
    public final EL a(ShipObjectClientWorld object) {
        Object object2 = object;
        object = this.a;
        ShipObjectClientWorld shipObjectClientWorld = object2;
        fb_0 fb_02 = ((EM)object).c.get();
        SimplePacketNetworking simplePacketNetworking = ((EM)object).b.get();
        object2 = ((EM)object).a.get();
        object = shipObjectClientWorld;
        return new EL((ShipObjectClientWorld)object, (fi_0)object2, simplePacketNetworking, fb_02);
    }

    private static Provider<EL.b> b(EM eM) {
        return eo_2.a((Object)new EN(eM));
    }

    public static ew_2<EL.b> a(EM eM) {
        return eo_2.a((Object)new EN(eM));
    }
}

