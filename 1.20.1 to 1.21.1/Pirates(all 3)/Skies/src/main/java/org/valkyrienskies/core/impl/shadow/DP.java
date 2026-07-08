/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.world.LevelYRange;

public final class DP {
    public final String a;
    public final LevelYRange b;
    public Vector3dc c;

    public DP(String string, LevelYRange levelYRange, Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)levelYRange, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.a = string;
        this.b = levelYRange;
        this.c = vector3dc;
    }

    public final String a() {
        return this.a;
    }

    public final LevelYRange b() {
        return this.b;
    }

    public final Vector3dc c() {
        return this.c;
    }

    private void a(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.c = vector3dc;
    }

    private String d() {
        return this.a;
    }

    private LevelYRange e() {
        return this.b;
    }

    private Vector3dc f() {
        return this.c;
    }

    private static DP a(String string, LevelYRange levelYRange, Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)levelYRange, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        return new DP(string, levelYRange, vector3dc);
    }

    private static /* synthetic */ DP a(DP object, String object2, LevelYRange object3, Vector3dc vector3dc, int n2) {
        if ((n2 & 1) != 0) {
            object2 = ((DP)object).a;
        }
        if ((n2 & 2) != 0) {
            object3 = ((DP)object).b;
        }
        if ((n2 & 4) != 0) {
            vector3dc = ((DP)object).c;
        }
        String string = object2;
        LevelYRange levelYRange = object3;
        object3 = vector3dc;
        object2 = levelYRange;
        object = string;
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object3, (String)"");
        return new DP((String)object, (LevelYRange)object2, (Vector3dc)object3);
    }

    public final String toString() {
        return "DimensionInfo(id=" + this.a + ", yRange=" + this.b + ", gravity=" + this.c + ")";
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        n2 = n2 * 31 + this.c.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        DP dP;
        if (this == other) {
            return true;
        }
        if (!(other instanceof DP)) {
            return false;
        }
        dP = dP;
        if (!Intrinsics.areEqual((Object)this.a, (Object)dP.a)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)dP.b)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.c, (Object)dP.c);
    }
}

