/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.shadow.EG;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class EI
implements ek_2<ChunkAllocator> {
    private final EG a;

    private EI(EG eG) {
        this.a = eG;
    }

    private ChunkAllocator a() {
        EG eG = this.a;
        EG eG2 = eG;
        eG2 = eG;
        return ev_2.b(eG.c);
    }

    public static EI a(EG eG) {
        return new EI(eG);
    }

    private static ChunkAllocator b(EG eG) {
        return ev_2.b(eG.c);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        EG eG = ((EI)object).a;
        object = eG;
        object = eG;
        return ev_2.b(eG.c);
    }
}

