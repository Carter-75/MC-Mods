/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.hi_0;
import org.valkyrienskies.core.impl.shadow.ig_0;
import org.valkyrienskies.core.impl.shadow.im_0;

public final class HA
implements ig_0 {
    private final GU a;
    private boolean b;
    private boolean c;

    public HA(GU gU) {
        Intrinsics.checkNotNullParameter((Object)gU, (String)"");
        this.a = gU;
        this.b = true;
    }

    @Override
    public final void a(im_0 im_02) {
        Intrinsics.checkNotNullParameter((Object)im_02, (String)"");
        this.b = false;
    }

    @Override
    public final void a(hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
        this.b = true;
    }

    @Override
    public final boolean a() {
        return this.b;
    }

    @Override
    public final boolean b() {
        return this.c;
    }

    @Override
    public final GU c() {
        return this.a;
    }

    @Override
    public final void close() {
        this.c = true;
    }
}

