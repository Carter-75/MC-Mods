/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.shadow.EO;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.ej_2;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.fb_0;

public final class EP
implements ek_2<EO> {
    private final Provider<er_0> a;
    private final Provider<EY> b;
    private final Provider<EY> c;
    private final Provider<SimplePacketNetworking> d;
    private final Provider<fb_0> e;

    private EP(Provider<er_0> provider, Provider<EY> provider2, Provider<EY> provider3, Provider<SimplePacketNetworking> provider4, Provider<fb_0> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    private EO a() {
        fb_0 fb_02 = this.e.get();
        SimplePacketNetworking simplePacketNetworking = this.d.get();
        EY eY = this.c.get();
        EY eY2 = this.b.get();
        dt_1<er_0> dt_12 = ej_2.a(this.a);
        return new EO(dt_12, eY2, eY, simplePacketNetworking, fb_02);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static EP a(ew_2 ew_22, ew_2 ew_23, ew_2 ew_24, ew_2 ew_25, ew_2 ew_26) {
        return new EP(ew_22, ew_23, ew_24, ew_25, ew_26);
    }

    private static EO a(dt_1<er_0> dt_12, EY eY, EY eY2, SimplePacketNetworking simplePacketNetworking, fb_0 fb_02) {
        return new EO(dt_12, eY, eY2, simplePacketNetworking, fb_02);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        fb_0 fb_02 = ((EP)object).e.get();
        SimplePacketNetworking simplePacketNetworking = ((EP)object).d.get();
        EY eY = ((EP)object).c.get();
        EY eY2 = ((EP)object).b.get();
        object = ej_2.a(((EP)object).a);
        return new EO((dt_1<er_0>)object, eY2, eY, simplePacketNetworking, fb_02);
    }
}

