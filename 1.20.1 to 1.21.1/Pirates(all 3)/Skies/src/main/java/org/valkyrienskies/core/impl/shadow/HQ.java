/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.HR;

public final class HQ {
    public final HR a;
    public final Vector3dc b;
    public final Vector3dc c;
    public final float d;
    public final Vector3dc e;

    public HQ(HR hR, Vector3dc vector3dc, Vector3dc vector3dc2, float f2, Vector3dc vector3dc3) {
        Intrinsics.checkNotNullParameter((Object)((Object)hR), (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        this.a = hR;
        this.b = vector3dc;
        this.c = vector3dc2;
        this.d = f2;
        this.e = vector3dc3;
    }

    public final HR a() {
        return this.a;
    }

    public final Vector3dc b() {
        return this.b;
    }

    public final Vector3dc c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final Vector3dc e() {
        return this.e;
    }

    private HR f() {
        return this.a;
    }

    private Vector3dc g() {
        return this.b;
    }

    private Vector3dc h() {
        return this.c;
    }

    private float i() {
        return this.d;
    }

    private Vector3dc j() {
        return this.e;
    }

    private static HQ a(HR hR, Vector3dc vector3dc, Vector3dc vector3dc2, float f2, Vector3dc vector3dc3) {
        Intrinsics.checkNotNullParameter((Object)((Object)hR), (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        return new HQ(hR, vector3dc, vector3dc2, f2, vector3dc3);
    }

    private static /* synthetic */ HQ a(HQ object, HR object2, Vector3dc vector3dc, Vector3dc vector3dc2, float f2, Vector3dc vector3dc3, int n2) {
        if ((n2 & 1) != 0) {
            object2 = object.a;
        }
        if ((n2 & 2) != 0) {
            vector3dc = object.b;
        }
        if ((n2 & 4) != 0) {
            vector3dc2 = object.c;
        }
        if ((n2 & 8) != 0) {
            f2 = object.d;
        }
        if ((n2 & 0x10) != 0) {
            vector3dc3 = object.e;
        }
        HR hR = object2;
        Vector3dc vector3dc4 = vector3dc;
        Vector3dc vector3dc5 = vector3dc3;
        float f3 = f2;
        vector3dc = vector3dc2;
        object2 = vector3dc4;
        object = hR;
        Intrinsics.checkNotNullParameter((Object)((Object)hR), (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc5, (String)"");
        return new HQ((HR)((Object)object), (Vector3dc)object2, vector3dc, f3, vector3dc5);
    }

    public final String toString() {
        return "CollisionEventInfo(type=" + (Object)((Object)this.a) + ", point=" + this.b + ", normal=" + this.c + ", separation=" + this.d + ", relativeVelocity=" + this.e + ')';
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        n2 = n2 * 31 + this.c.hashCode();
        n2 = n2 * 31 + Float.hashCode(this.d);
        n2 = n2 * 31 + this.e.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        HQ hQ;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HQ)) {
            return false;
        }
        hQ = hQ;
        if (this.a != hQ.a) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)hQ.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)hQ.c)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)Float.valueOf(this.d), (Object)Float.valueOf(hQ.d))) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.e, (Object)hQ.e);
    }
}

