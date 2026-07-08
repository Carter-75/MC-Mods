/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3ic;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ef
 */
public final class ef_0 {
    final Vector3ic a;
    final VsiBlockState b;
    final boolean c;

    public ef_0(Vector3ic vector3ic, VsiBlockState vsiBlockState, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        this.a = vector3ic;
        this.b = vsiBlockState;
        this.c = bl;
    }

    public final Vector3ic a() {
        return this.a;
    }

    public final VsiBlockState b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final String toString() {
        return "AerodynamicBlockUpdateInfo(pos=" + this.a + ", shape=" + this.b + ", remove=" + this.c + ")";
    }

    private Vector3ic d() {
        return this.a;
    }

    private VsiBlockState e() {
        return this.b;
    }

    private boolean f() {
        return this.c;
    }

    private static ef_0 a(Vector3ic vector3ic, VsiBlockState vsiBlockState, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        return new ef_0(vector3ic, vsiBlockState, bl);
    }

    private static /* synthetic */ ef_0 a(ef_0 object, Vector3ic object2, VsiBlockState vsiBlockState, boolean bl, int n2) {
        if ((n2 & 1) != 0) {
            object2 = ((ef_0)object).a;
        }
        if ((n2 & 2) != 0) {
            vsiBlockState = ((ef_0)object).b;
        }
        if ((n2 & 4) != 0) {
            bl = ((ef_0)object).c;
        }
        Vector3ic vector3ic = object2;
        boolean bl2 = bl;
        object2 = vsiBlockState;
        object = vector3ic;
        Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        return new ef_0((Vector3ic)object, (VsiBlockState)object2, bl2);
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        n2 = n2 * 31 + Boolean.hashCode(this.c);
        return n2;
    }

    public final boolean equals(Object other) {
        ef_0 ef_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ef_0)) {
            return false;
        }
        ef_02 = ef_02;
        if (!Intrinsics.areEqual((Object)this.a, (Object)ef_02.a)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)ef_02.b)) {
            return false;
        }
        return this.c == ef_02.c;
    }
}

