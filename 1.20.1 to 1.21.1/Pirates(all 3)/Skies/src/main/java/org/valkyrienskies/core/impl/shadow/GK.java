/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.valkyrienskies.core.impl.shadow.GG;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class GK
implements ek_2<ObjectMapper> {
    private final GG a;

    private GK(GG gG) {
        this.a = gG;
    }

    private ObjectMapper a() {
        GG gG = this.a;
        return ev_2.b(GG.b());
    }

    public static GK a(GG gG) {
        return new GK(gG);
    }

    private static ObjectMapper b(GG gG) {
        return ev_2.b(GG.b());
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        object = ((GK)object).a;
        return ev_2.b(GG.b());
    }
}

