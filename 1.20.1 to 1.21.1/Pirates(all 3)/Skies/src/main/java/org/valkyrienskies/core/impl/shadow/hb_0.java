/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hb
 */
public final class hb_0 {
    public final Vector3dc a;
    public final Quaterniondc b;

    public hb_0(Vector3dc vector3dc, Quaterniondc quaterniondc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)quaterniondc, (String)"");
        this.a = vector3dc;
        this.b = quaterniondc;
    }

    public final Vector3dc a() {
        return this.a;
    }

    public final Quaterniondc b() {
        return this.b;
    }

    private Vector3dc c() {
        return this.a;
    }

    private Quaterniondc d() {
        return this.b;
    }

    private static hb_0 a(Vector3dc vector3dc, Quaterniondc quaterniondc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)quaterniondc, (String)"");
        return new hb_0(vector3dc, quaterniondc);
    }

    private static /* synthetic */ hb_0 a(hb_0 object, Vector3dc object2, Quaterniondc quaterniondc, int n2) {
        if ((n2 & 1) != 0) {
            object2 = ((hb_0)object).a;
        }
        if ((n2 & 2) != 0) {
            quaterniondc = ((hb_0)object).b;
        }
        Vector3dc vector3dc = object2;
        object2 = quaterniondc;
        object = vector3dc;
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        return new hb_0((Vector3dc)object, (Quaterniondc)object2);
    }

    public final String toString() {
        return "Pose(pos=" + this.a + ", rot=" + this.b + ')';
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        hb_0 hb_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof hb_0)) {
            return false;
        }
        hb_02 = hb_02;
        if (!Intrinsics.areEqual((Object)this.a, (Object)hb_02.a)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.b, (Object)hb_02.b);
    }
}

