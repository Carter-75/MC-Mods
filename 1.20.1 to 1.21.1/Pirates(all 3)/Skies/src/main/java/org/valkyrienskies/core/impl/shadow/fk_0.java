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
import org.valkyrienskies.core.impl.shadow.fi_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fk
 */
public final class fk_0
implements ek_2<fi_0> {
    private final Provider<EY> a;
    private final Provider<EY> b;
    private final Provider<fb_0> c;
    private final Provider<SimplePacketNetworking> d;

    private fk_0(Provider<EY> provider, Provider<EY> provider2, Provider<fb_0> provider3, Provider<SimplePacketNetworking> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    private fi_0 a() {
        SimplePacketNetworking simplePacketNetworking = this.d.get();
        fb_0 fb_02 = this.c.get();
        EY eY = this.b.get();
        EY eY2 = this.a.get();
        return new fi_0(eY2, eY, fb_02, simplePacketNetworking);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static fk_0 a(ew_2 ew_22, ew_2 ew_23, ew_2 ew_24, ew_2 ew_25) {
        return new fk_0(ew_22, ew_23, ew_24, ew_25);
    }

    private static fi_0 a(EY eY, EY eY2, fb_0 fb_02, SimplePacketNetworking simplePacketNetworking) {
        return new fi_0(eY, eY2, fb_02, simplePacketNetworking);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        SimplePacketNetworking simplePacketNetworking = ((fk_0)object).d.get();
        fb_0 fb_02 = ((fk_0)object).c.get();
        EY eY = ((fk_0)object).b.get();
        object = ((fk_0)object).a.get();
        return new fi_0((EY)object, eY, fb_02, simplePacketNetworking);
    }
}

