/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.ShipPhysicsListener;
import org.valkyrienskies.core.api.ships.WingManagerChanges;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.impl.game.ships.ShipPhysicsData;
import org.valkyrienskies.core.impl.shadow.ek_0;

public final class FB {
    private final long n;
    final double a;
    final ek_0 b;
    private final ShipPhysicsData o;
    final boolean c;
    final PhysPose d;
    final boolean e;
    final List<ShipPhysicsListener> f;
    final WingManagerChanges g;
    final int h;
    final Vector3dc i;
    final Quaterniondc j;
    final Vector3dc k;
    final Vector3dc l;
    final AABBic m;

    public FB(long l2, double d2, ek_0 ek_02, ShipPhysicsData shipPhysicsData, boolean bl, PhysPose physPose, boolean bl2, List<? extends ShipPhysicsListener> list, WingManagerChanges wingManagerChanges, int n2, Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2, Vector3dc vector3dc3, AABBic aABBic) {
        Intrinsics.checkNotNullParameter((Object)ek_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipPhysicsData, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)quaterniondc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        this.n = l2;
        this.a = d2;
        this.b = ek_02;
        this.o = shipPhysicsData;
        this.c = bl;
        this.d = physPose;
        this.e = bl2;
        this.f = list;
        this.g = wingManagerChanges;
        this.h = n2;
        this.i = vector3dc;
        this.j = quaterniondc;
        this.k = vector3dc2;
        this.l = vector3dc3;
        this.m = aABBic;
    }

    private long n() {
        return this.n;
    }

    public final double a() {
        return this.a;
    }

    public final ek_0 b() {
        return this.b;
    }

    private ShipPhysicsData o() {
        return this.o;
    }

    public final boolean c() {
        return this.c;
    }

    public final PhysPose d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public final List<ShipPhysicsListener> f() {
        return this.f;
    }

    public final WingManagerChanges g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public final Vector3dc i() {
        return this.i;
    }

    public final Quaterniondc j() {
        return this.j;
    }

    public final Vector3dc k() {
        return this.k;
    }

    public final Vector3dc l() {
        return this.l;
    }

    public final AABBic m() {
        return this.m;
    }

    private long p() {
        return this.n;
    }

    private double q() {
        return this.a;
    }

    private ek_0 r() {
        return this.b;
    }

    private ShipPhysicsData s() {
        return this.o;
    }

    private boolean t() {
        return this.c;
    }

    private PhysPose u() {
        return this.d;
    }

    private boolean v() {
        return this.e;
    }

    private List<ShipPhysicsListener> w() {
        return this.f;
    }

    private WingManagerChanges x() {
        return this.g;
    }

    private int y() {
        return this.h;
    }

    private Vector3dc z() {
        return this.i;
    }

    private Quaterniondc A() {
        return this.j;
    }

    private Vector3dc B() {
        return this.k;
    }

    private Vector3dc C() {
        return this.l;
    }

    private AABBic D() {
        return this.m;
    }

    private static FB a(long l2, double d2, ek_0 ek_02, ShipPhysicsData shipPhysicsData, boolean bl, PhysPose physPose, boolean bl2, List<? extends ShipPhysicsListener> list, WingManagerChanges wingManagerChanges, int n2, Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2, Vector3dc vector3dc3, AABBic aABBic) {
        Intrinsics.checkNotNullParameter((Object)ek_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipPhysicsData, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)quaterniondc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        return new FB(l2, d2, ek_02, shipPhysicsData, bl, physPose, bl2, list, wingManagerChanges, n2, vector3dc, quaterniondc, vector3dc2, vector3dc3, aABBic);
    }

    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ FB a(FB object, long l2, double d2, ek_0 object2, ShipPhysicsData object3, boolean bl, PhysPose object4, boolean bl2, List object5, WingManagerChanges object6, int n2, Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2, Vector3dc vector3dc3, AABBic aABBic, int n3) {
        AABBic aABBic2;
        Vector3dc vector3dc4;
        Vector3dc vector3dc5;
        Quaterniondc quaterniondc2;
        Vector3dc vector3dc6;
        int n4;
        Object object7;
        Object object8;
        boolean bl3;
        Object object9;
        boolean bl4;
        void var18_22;
        if ((var18_22 & 1) != 0) {
            l2 = ((FB)((Object)object)).n;
        }
        if ((var18_22 & 2) != 0) {
            d2 = ((FB)((Object)object)).a;
        }
        if ((var18_22 & 4) != 0) {
            object2 = ((FB)((Object)object)).b;
        }
        if ((var18_22 & 8) != 0) {
            object3 = ((FB)((Object)object)).o;
        }
        if ((var18_22 & 0x10) != 0) {
            bl4 = ((FB)((Object)object)).c;
        }
        if ((var18_22 & 0x20) != 0) {
            object9 = ((FB)((Object)object)).d;
        }
        if ((var18_22 & 0x40) != 0) {
            bl3 = ((FB)((Object)object)).e;
        }
        if ((var18_22 & 0x80) != 0) {
            object8 = ((FB)((Object)object)).f;
        }
        if ((var18_22 & 0x100) != 0) {
            object7 = ((FB)((Object)object)).g;
        }
        if ((var18_22 & 0x200) != 0) {
            n4 = ((FB)((Object)object)).h;
        }
        if ((var18_22 & 0x400) != 0) {
            vector3dc6 = ((FB)((Object)object)).i;
        }
        if ((var18_22 & 0x800) != 0) {
            quaterniondc2 = ((FB)((Object)object)).j;
        }
        if ((var18_22 & 0x1000) != 0) {
            vector3dc5 = ((FB)((Object)object)).k;
        }
        if ((var18_22 & 0x2000) != 0) {
            vector3dc4 = ((FB)((Object)object)).l;
        }
        if ((var18_22 & 0x4000) != 0) {
            aABBic2 = ((FB)((Object)object)).m;
        }
        List<ShipPhysicsListener> list = object2;
        Object object10 = object3;
        PhysPose physPose = object9;
        List<ShipPhysicsListener> list2 = object8;
        WingManagerChanges wingManagerChanges = object7;
        AABBic aABBic3 = aABBic2;
        object7 = vector3dc4;
        object8 = vector3dc5;
        Quaterniondc quaterniondc3 = quaterniondc2;
        object9 = vector3dc6;
        int n5 = n4;
        object3 = wingManagerChanges;
        object2 = list2;
        boolean bl5 = bl3;
        PhysPose physPose2 = physPose;
        boolean bl6 = bl4;
        Object shipPhysicsData2 = object10;
        object = list;
        double d3 = d2;
        long l3 = l2;
        Intrinsics.checkNotNullParameter(object, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipPhysicsData2, (String)"");
        Intrinsics.checkNotNullParameter(object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object9, (String)"");
        Intrinsics.checkNotNullParameter((Object)quaterniondc3, (String)"");
        Intrinsics.checkNotNullParameter((Object)object8, (String)"");
        Intrinsics.checkNotNullParameter((Object)object7, (String)"");
        return new FB(l3, d3, (ek_0)((Object)object), (ShipPhysicsData)shipPhysicsData2, bl6, physPose2, bl5, (List<? extends ShipPhysicsListener>)object2, (WingManagerChanges)object3, n5, (Vector3dc)object9, quaterniondc3, (Vector3dc)object8, (Vector3dc)object7, aABBic3);
    }

    public final String toString() {
        return "UpdateShipInGameFrameData(uuid=" + this.n + ", collisionShapeScaling=" + this.a + ", inertiaData=" + this.b + ", physicsData=" + this.o + ", isStatic=" + this.c + ", kinematicTarget=" + this.d + ", shipVoxelsFullyLoaded=" + this.e + ", physicsListeners=" + this.f + ", wingManagerChanges=" + this.g + ", shipTeleportId=" + this.h + ", currentShipPos=" + this.i + ", currentShipRot=" + this.j + ", currentShipVel=" + this.k + ", currentShipOmega=" + this.l + ", definedVoxelAABB=" + this.m + ")";
    }

    public final int hashCode() {
        int n2 = Long.hashCode(this.n);
        n2 = n2 * 31 + Double.hashCode(this.a);
        n2 = n2 * 31 + this.b.hashCode();
        n2 = n2 * 31 + this.o.hashCode();
        n2 = n2 * 31 + Boolean.hashCode(this.c);
        n2 = n2 * 31 + (this.d == null ? 0 : this.d.hashCode());
        n2 = n2 * 31 + Boolean.hashCode(this.e);
        n2 = n2 * 31 + ((Object)this.f).hashCode();
        n2 = n2 * 31 + (this.g == null ? 0 : this.g.hashCode());
        n2 = n2 * 31 + Integer.hashCode(this.h);
        n2 = n2 * 31 + this.i.hashCode();
        n2 = n2 * 31 + this.j.hashCode();
        n2 = n2 * 31 + this.k.hashCode();
        n2 = n2 * 31 + this.l.hashCode();
        n2 = n2 * 31 + (this.m == null ? 0 : this.m.hashCode());
        return n2;
    }

    public final boolean equals(Object other) {
        FB fB;
        if (this == other) {
            return true;
        }
        if (!(other instanceof FB)) {
            return false;
        }
        fB = fB;
        if (this.n != fB.n) {
            return false;
        }
        if (Double.compare(this.a, fB.a) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)fB.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.o, (Object)fB.o)) {
            return false;
        }
        if (this.c != fB.c) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.d, (Object)fB.d)) {
            return false;
        }
        if (this.e != fB.e) {
            return false;
        }
        if (!Intrinsics.areEqual(this.f, fB.f)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.g, (Object)fB.g)) {
            return false;
        }
        if (this.h != fB.h) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.i, (Object)fB.i)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.j, (Object)fB.j)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.k, (Object)fB.k)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.l, (Object)fB.l)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.m, (Object)fB.m);
    }
}

