/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.DM;
import org.valkyrienskies.core.impl.shadow.ET;
import org.valkyrienskies.core.impl.shadow.in_0;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;

public final class ES
implements VsiTerrainUpdate.Builder {
    private final in_0 a;
    private boolean b;

    public ES(int n2, int n3, int n4) {
        this.a = new in_0(n2, n3, n4);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void addBlock(int x, int y, int z, VsiBlockType block) {
        void var3_4;
        void var2_3;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)block, (String)"");
        DM cfr_ignored_0 = (DM)block;
        DM dM = (DM)block;
        this.a.a((int)var1_1, (int)var2_3, (int)var3_4, dM.a);
    }

    @Override
    public final VsiTerrainUpdate build() {
        if (!(!this.b)) {
            String string = "This builder has already been used!";
            throw new IllegalArgumentException(string.toString());
        }
        this.b = true;
        return new ET(this.a);
    }
}

