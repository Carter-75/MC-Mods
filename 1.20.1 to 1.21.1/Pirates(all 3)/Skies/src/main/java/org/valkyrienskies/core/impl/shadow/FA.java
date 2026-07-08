/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.impl.shadow.GX;
import org.valkyrienskies.core.impl.shadow.hc_0;

public final class FA {
    private final long e;
    private final GX f;
    final hc_0 a;
    final Vector3dc b;
    final double c;
    private final AABBdc g;
    final int d;

    public FA(long l2, GX gX, hc_0 hc_02, Vector3dc vector3dc, double d2, AABBdc aABBdc, int n2) {
        Intrinsics.checkNotNullParameter((Object)gX, (String)"");
        Intrinsics.checkNotNullParameter((Object)hc_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)aABBdc, (String)"");
        this.e = l2;
        this.f = gX;
        this.a = hc_02;
        this.b = vector3dc;
        this.c = d2;
        this.g = aABBdc;
        this.d = n2;
    }

    private long e() {
        return this.e;
    }

    private GX f() {
        return this.f;
    }

    public final hc_0 a() {
        return this.a;
    }

    public final Vector3dc b() {
        return this.b;
    }

    public final double c() {
        return this.c;
    }

    private AABBdc g() {
        return this.g;
    }

    public final int d() {
        return this.d;
    }

    private long h() {
        return this.e;
    }

    private GX i() {
        return this.f;
    }

    private hc_0 j() {
        return this.a;
    }

    private Vector3dc k() {
        return this.b;
    }

    private double l() {
        return this.c;
    }

    private AABBdc m() {
        return this.g;
    }

    private int n() {
        return this.d;
    }

    private static FA a(long l2, GX gX, hc_0 hc_02, Vector3dc vector3dc, double d2, AABBdc aABBdc, int n2) {
        Intrinsics.checkNotNullParameter((Object)gX, (String)"");
        Intrinsics.checkNotNullParameter((Object)hc_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)aABBdc, (String)"");
        return new FA(l2, gX, hc_02, vector3dc, d2, aABBdc, n2);
    }

    private static /* synthetic */ FA a(FA object, long l2, GX object2, hc_0 hc_02, Vector3dc vector3dc, double d2, AABBdc aABBdc, int n2, int n3) {
        if ((n3 & 1) != 0) {
            l2 = ((FA)object).e;
        }
        if ((n3 & 2) != 0) {
            object2 = ((FA)object).f;
        }
        if ((n3 & 4) != 0) {
            hc_02 = ((FA)object).a;
        }
        if ((n3 & 8) != 0) {
            vector3dc = ((FA)object).b;
        }
        if ((n3 & 0x10) != 0) {
            d2 = ((FA)object).c;
        }
        if ((n3 & 0x20) != 0) {
            aABBdc = ((FA)object).g;
        }
        if ((n3 & 0x40) != 0) {
            n2 = ((FA)object).d;
        }
        GX gX = object2;
        int n4 = n2;
        object2 = aABBdc;
        double d3 = d2;
        Vector3dc vector3dc2 = vector3dc;
        hc_0 hc_03 = hc_02;
        object = gX;
        long l3 = l2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)hc_03, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        return new FA(l3, (GX)object, hc_03, vector3dc2, d3, (AABBdc)object2, n4);
    }

    public final String toString() {
        return "ShipInPhysicsFrameData(uuid=" + this.e + ", inertiaData=" + this.f + ", poseVel=" + this.a + ", shipVoxelOffset=" + this.b + ", scaling=" + this.c + ", aabb=" + this.g + ", lastShipTeleportId=" + this.d + ")";
    }

    public final int hashCode() {
        int n2 = Long.hashCode(this.e);
        n2 = n2 * 31 + this.f.hashCode();
        n2 = n2 * 31 + this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        n2 = n2 * 31 + Double.hashCode(this.c);
        n2 = n2 * 31 + this.g.hashCode();
        n2 = n2 * 31 + Integer.hashCode(this.d);
        return n2;
    }

    public final boolean equals(Object other) {
        FA fA;
        if (this == other) {
            return true;
        }
        if (!(other instanceof FA)) {
            return false;
        }
        fA = fA;
        if (this.e != fA.e) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.f, (Object)fA.f)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.a, (Object)fA.a)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)fA.b)) {
            return false;
        }
        if (Double.compare(this.c, fA.c) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.g, (Object)fA.g)) {
            return false;
        }
        return this.d == fA.d;
    }
}

