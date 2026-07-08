/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.valkyrienskies.core.impl.shadow.GG;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class GL
implements ek_2<ObjectMapper> {
    private final GG a;

    private GL(GG gG) {
        this.a = gG;
    }

    private ObjectMapper a() {
        GG gG = this.a;
        return ev_2.b(GG.e());
    }

    private static GL a(GG gG) {
        return new GL(gG);
    }

    private static ObjectMapper b(GG gG) {
        return ev_2.b(GG.e());
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        object = ((GL)object).a;
        return ev_2.b(GG.e());
    }
}

