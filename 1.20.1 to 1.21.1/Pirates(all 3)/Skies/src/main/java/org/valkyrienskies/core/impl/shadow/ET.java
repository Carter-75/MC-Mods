/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;

public final class ET
implements VsiTerrainUpdate {
    public final il_0 a;

    public ET(il_0 il_02) {
        Intrinsics.checkNotNullParameter((Object)il_02, (String)"");
        this.a = il_02;
    }

    public final il_0 a() {
        return this.a;
    }

    @Override
    public final int getChunkX() {
        return this.a.a();
    }

    @Override
    public final int getChunkY() {
        return this.a.b();
    }

    @Override
    public final int getChunkZ() {
        return this.a.c();
    }

    private il_0 b() {
        return this.a;
    }

    private static ET a(il_0 il_02) {
        Intrinsics.checkNotNullParameter((Object)il_02, (String)"");
        return new ET(il_02);
    }

    private static /* synthetic */ ET a(ET object, il_0 il_02, int n2) {
        if ((n2 & 1) != 0) {
            il_02 = ((ET)object).a;
        }
        object = il_02;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        return new ET((il_0)object);
    }

    public final String toString() {
        return "TerrainUpdateImpl(update=" + this.a + ")";
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean equals(Object other) {
        ET eT;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ET)) {
            return false;
        }
        eT = eT;
        return Intrinsics.areEqual((Object)this.a, (Object)eT.a);
    }
}

