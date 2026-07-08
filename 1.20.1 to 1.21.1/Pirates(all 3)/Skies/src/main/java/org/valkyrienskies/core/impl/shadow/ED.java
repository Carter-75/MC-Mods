/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.shadow.EC;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class ED
implements ek_2<ChunkAllocatorProvider> {
    private static ChunkAllocatorProvider b() {
        return ev_2.b(EC.a.a.a());
    }

    public static ED a() {
        return a.a;
    }

    private static ChunkAllocatorProvider c() {
        return ev_2.b(EC.a.a.a());
    }

    @Override
    public final /* synthetic */ Object get() {
        return ev_2.b(EC.a.a.a());
    }

    static final class a {
        static final ED a = new ED();

        private a() {
        }
    }
}

