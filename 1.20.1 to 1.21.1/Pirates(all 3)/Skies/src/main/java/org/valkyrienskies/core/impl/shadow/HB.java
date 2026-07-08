/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.HA;
import org.valkyrienskies.core.impl.shadow.ig_0;
import org.valkyrienskies.core.impl.shadow.ih_0;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HB;", "Lorg/valkyrienskies/core/impl/shadow/Ih;", "Lorg/valkyrienskies/core/impl/shadow/HA;", "Lorg/valkyrienskies/core/impl/shadow/GU;", "p0", "b", "(Lorg/valkyrienskies/core/impl/shadow/GU;)Lorg/valkyrienskies/core/impl/shadow/HA;", "<init>", "()V"})
public final class HB
implements ih_0<HA> {
    public static final HB INSTANCE = new HB();

    private HB() {
    }

    private static HA b(GU gU) {
        Intrinsics.checkNotNullParameter((Object)gU, (String)"");
        return new HA(gU);
    }

    @Override
    public final /* synthetic */ ig_0 a(GU gU) {
        Intrinsics.checkNotNullParameter((Object)gU, (String)"");
        return new HA(gU);
    }
}

