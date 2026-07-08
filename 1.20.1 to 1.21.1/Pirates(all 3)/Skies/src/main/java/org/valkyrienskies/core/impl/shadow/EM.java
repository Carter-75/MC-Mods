/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.ShipObjectClientWorld;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.EL;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.fi_0;

public final class EM {
    final Provider<fi_0> a;
    final Provider<SimplePacketNetworking> b;
    final Provider<fb_0> c;

    private EM(Provider<fi_0> provider, Provider<SimplePacketNetworking> provider2, Provider<fb_0> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public final EL a(ShipObjectClientWorld shipObjectClientWorld) {
        fb_0 fb_02 = this.c.get();
        SimplePacketNetworking simplePacketNetworking = this.b.get();
        fi_0 fi_02 = this.a.get();
        return new EL(shipObjectClientWorld, fi_02, simplePacketNetworking, fb_02);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static EM a(ew_2 ew_22, ew_2 ew_23, ew_2 ew_24) {
        return new EM(ew_22, ew_23, ew_24);
    }

    private static EL a(ShipObjectClientWorld shipObjectClientWorld, fi_0 fi_02, SimplePacketNetworking simplePacketNetworking, fb_0 fb_02) {
        return new EL(shipObjectClientWorld, fi_02, simplePacketNetworking, fb_02);
    }
}

