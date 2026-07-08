/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.valkyrienskies.core.impl.shadow.GG;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class GI
implements ek_2<ObjectMapper> {
    private final GG a;

    private GI(GG gG) {
        this.a = gG;
    }

    private ObjectMapper a() {
        GG gG = this.a;
        return ev_2.b(GG.a());
    }

    public static GI a(GG gG) {
        return new GI(gG);
    }

    private static ObjectMapper b(GG gG) {
        return ev_2.b(GG.a());
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        object = ((GI)object).a;
        return ev_2.b(GG.a());
    }
}

