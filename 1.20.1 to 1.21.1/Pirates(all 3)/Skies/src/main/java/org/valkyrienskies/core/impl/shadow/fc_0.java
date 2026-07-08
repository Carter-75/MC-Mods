/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.fb_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fc
 */
public final class fc_0
implements ek_2<fb_0> {
    private final Provider<EY> a;
    private final Provider<EY> b;
    private final Provider<SimplePacketNetworking> c;

    private fc_0(Provider<EY> provider, Provider<EY> provider2, Provider<SimplePacketNetworking> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    private fb_0 a() {
        SimplePacketNetworking simplePacketNetworking = this.c.get();
        EY eY = this.b.get();
        EY eY2 = this.a.get();
        return new fb_0(eY2, eY, simplePacketNetworking);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static fc_0 a(ew_2 ew_22, ew_2 ew_23, ew_2 ew_24) {
        return new fc_0(ew_22, ew_23, ew_24);
    }

    private static fb_0 a(EY eY, EY eY2, SimplePacketNetworking simplePacketNetworking) {
        return new fb_0(eY, eY2, simplePacketNetworking);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        SimplePacketNetworking simplePacketNetworking = ((fc_0)object).c.get();
        EY eY = ((fc_0)object).b.get();
        object = ((fc_0)object).a.get();
        return new fb_0((EY)object, eY, simplePacketNetworking);
    }
}

