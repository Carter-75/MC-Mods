/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3fc;

public final class HT {
    public final Vector3fc a;
    public final float b;

    public HT(Vector3fc vector3fc, float f2) {
        Intrinsics.checkNotNullParameter((Object)vector3fc, (String)"");
        this.a = vector3fc;
        this.b = f2;
    }

    public final Vector3fc a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    private Vector3fc c() {
        return this.a;
    }

    private float d() {
        return this.b;
    }

    private static HT a(Vector3fc vector3fc, float f2) {
        Intrinsics.checkNotNullParameter((Object)vector3fc, (String)"");
        return new HT(vector3fc, f2);
    }

    private static /* synthetic */ HT a(HT object, Vector3fc vector3fc, float f2, int n2) {
        if ((n2 & 1) != 0) {
            vector3fc = ((HT)object).a;
        }
        if ((n2 & 2) != 0) {
            f2 = ((HT)object).b;
        }
        float f3 = f2;
        object = vector3fc;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        return new HT((Vector3fc)object, f3);
    }

    public final String toString() {
        return "CollisionPoint(pos=" + this.a + ", radius=" + this.b + ')';
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + Float.hashCode(this.b);
        return n2;
    }

    public final boolean equals(Object other) {
        HT hT;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HT)) {
            return false;
        }
        hT = hT;
        if (!Intrinsics.areEqual((Object)this.a, (Object)hT.a)) {
            return false;
        }
        return Intrinsics.areEqual((Object)Float.valueOf(this.b), (Object)Float.valueOf(hT.b));
    }
}

