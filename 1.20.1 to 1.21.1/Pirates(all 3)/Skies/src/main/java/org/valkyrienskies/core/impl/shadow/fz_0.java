/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.ShipPhysicsListener;
import org.valkyrienskies.core.api.ships.WingManagerChanges;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.impl.game.ships.ShipPhysicsData;
import org.valkyrienskies.core.impl.shadow.ek_0;
import org.valkyrienskies.core.impl.shadow.hc_0;
import org.valkyrienskies.core.internal.physics.VSCollisionShapeData;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fz
 */
public final class fz_0 {
    final long a;
    final String b;
    final VSCollisionShapeData c;
    final double d;
    final ek_0 e;
    private final ShipPhysicsData q;
    final hc_0 f;
    final boolean g;
    final PhysPose h;
    final List<ShipPhysicsListener> i;
    final WingManagerChanges j;
    final int k;
    final int l;
    final double m;
    final double n;
    final double o;
    final boolean p;

    public fz_0(long l2, String string, VSCollisionShapeData vSCollisionShapeData, double d2, ek_0 ek_02, ShipPhysicsData shipPhysicsData, hc_0 hc_02, boolean bl, PhysPose physPose, List<? extends ShipPhysicsListener> list, WingManagerChanges wingManagerChanges, int n2, int n3, double d3, double d4, double d5, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)vSCollisionShapeData, (String)"");
        Intrinsics.checkNotNullParameter((Object)ek_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipPhysicsData, (String)"");
        Intrinsics.checkNotNullParameter((Object)hc_02, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        this.a = l2;
        this.b = string;
        this.c = vSCollisionShapeData;
        this.d = d2;
        this.e = ek_02;
        this.q = shipPhysicsData;
        this.f = hc_02;
        this.g = bl;
        this.h = physPose;
        this.i = list;
        this.j = wingManagerChanges;
        this.k = n2;
        this.l = n3;
        this.m = d3;
        this.n = d4;
        this.o = d5;
        this.p = bl2;
    }

    public final long a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final VSCollisionShapeData c() {
        return this.c;
    }

    public final double d() {
        return this.d;
    }

    public final ek_0 e() {
        return this.e;
    }

    private ShipPhysicsData q() {
        return this.q;
    }

    public final hc_0 f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final PhysPose h() {
        return this.h;
    }

    public final List<ShipPhysicsListener> i() {
        return this.i;
    }

    public final WingManagerChanges j() {
        return this.j;
    }

    public final int k() {
        return this.k;
    }

    public final int l() {
        return this.l;
    }

    public final double m() {
        return this.m;
    }

    public final double n() {
        return this.n;
    }

    public final double o() {
        return this.o;
    }

    public final boolean p() {
        return this.p;
    }

    private long r() {
        return this.a;
    }

    private String s() {
        return this.b;
    }

    private VSCollisionShapeData t() {
        return this.c;
    }

    private double u() {
        return this.d;
    }

    private ek_0 v() {
        return this.e;
    }

    private ShipPhysicsData w() {
        return this.q;
    }

    private hc_0 x() {
        return this.f;
    }

    private boolean y() {
        return this.g;
    }

    private PhysPose z() {
        return this.h;
    }

    private List<ShipPhysicsListener> A() {
        return this.i;
    }

    private WingManagerChanges B() {
        return this.j;
    }

    private int C() {
        return this.k;
    }

    private int D() {
        return this.l;
    }

    private double E() {
        return this.m;
    }

    private double F() {
        return this.n;
    }

    private double G() {
        return this.o;
    }

    private boolean H() {
        return this.p;
    }

    private static fz_0 a(long l2, String string, VSCollisionShapeData vSCollisionShapeData, double d2, ek_0 ek_02, ShipPhysicsData shipPhysicsData, hc_0 hc_02, boolean bl, PhysPose physPose, List<? extends ShipPhysicsListener> list, WingManagerChanges wingManagerChanges, int n2, int n3, double d3, double d4, double d5, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)vSCollisionShapeData, (String)"");
        Intrinsics.checkNotNullParameter((Object)ek_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipPhysicsData, (String)"");
        Intrinsics.checkNotNullParameter((Object)hc_02, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        return new fz_0(l2, string, vSCollisionShapeData, d2, ek_02, shipPhysicsData, hc_02, bl, physPose, list, wingManagerChanges, n2, n3, d3, d4, d5, bl2);
    }

    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ fz_0 a(fz_0 object, long l2, String object2, VSCollisionShapeData object3, double d2, ek_0 object4, ShipPhysicsData object5, hc_0 hc_02, boolean bl, PhysPose physPose, List list, WingManagerChanges wingManagerChanges, int n2, int n3, double d3, double d4, double d5, boolean bl2, int n4) {
        boolean bl3;
        double d6;
        double d7;
        double d8;
        int n5;
        int n6;
        WingManagerChanges wingManagerChanges2;
        List<ShipPhysicsListener> list2;
        PhysPose physPose2;
        boolean bl4;
        void var23_24;
        if ((var23_24 & 1) != 0) {
            l2 = ((fz_0)object).a;
        }
        if ((var23_24 & 2) != 0) {
            object2 = ((fz_0)object).b;
        }
        if ((var23_24 & 4) != 0) {
            object3 = ((fz_0)object).c;
        }
        if ((var23_24 & 8) != 0) {
            d2 = ((fz_0)object).d;
        }
        if ((var23_24 & 0x10) != 0) {
            object4 = ((fz_0)object).e;
        }
        if ((var23_24 & 0x20) != 0) {
            object5 = ((fz_0)object).q;
        }
        if ((var23_24 & 0x40) != 0) {
            hc_02 = ((fz_0)object).f;
        }
        if ((var23_24 & 0x80) != 0) {
            bl4 = ((fz_0)object).g;
        }
        if ((var23_24 & 0x100) != 0) {
            physPose2 = ((fz_0)object).h;
        }
        if ((var23_24 & 0x200) != 0) {
            list2 = ((fz_0)object).i;
        }
        if ((var23_24 & 0x400) != 0) {
            wingManagerChanges2 = ((fz_0)object).j;
        }
        if ((var23_24 & 0x800) != 0) {
            n6 = ((fz_0)object).k;
        }
        if ((var23_24 & 0x1000) != 0) {
            n5 = ((fz_0)object).l;
        }
        if ((var23_24 & 0x2000) != 0) {
            d8 = ((fz_0)object).m;
        }
        if ((var23_24 & 0x4000) != 0) {
            d7 = ((fz_0)object).n;
        }
        if ((var23_24 & 0x8000) != 0) {
            d6 = ((fz_0)object).o;
        }
        if ((var23_24 & 0x10000) != 0) {
            bl3 = ((fz_0)object).p;
        }
        Object object6 = object2;
        Object object7 = object3;
        List<ShipPhysicsListener> list3 = object4;
        Object object8 = object5;
        boolean bl5 = bl3;
        double d9 = d6;
        double d10 = d7;
        double d11 = d8;
        int n7 = n5;
        int n52 = n6;
        object5 = wingManagerChanges2;
        object4 = list2;
        PhysPose physPose3 = physPose2;
        boolean bl52 = bl4;
        object3 = hc_02;
        object2 = object8;
        List<ShipPhysicsListener> list4 = list3;
        double d12 = d2;
        Object vSCollisionShapeData2 = object7;
        object = object6;
        long l3 = l2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)vSCollisionShapeData2, (String)"");
        Intrinsics.checkNotNullParameter(list4, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object3, (String)"");
        Intrinsics.checkNotNullParameter(object4, (String)"");
        return new fz_0(l3, (String)object, (VSCollisionShapeData)vSCollisionShapeData2, d12, (ek_0)((Object)list4), (ShipPhysicsData)object2, (hc_0)object3, bl52, physPose3, (List<? extends ShipPhysicsListener>)object4, (WingManagerChanges)object5, n52, n7, d11, d10, d9, bl5);
    }

    public final String toString() {
        return "NewShipInGameFrameData(uuid=" + this.a + ", dimension=" + this.b + ", collisionShapeData=" + this.c + ", collisionShapeScaling=" + this.d + ", inertiaData=" + this.e + ", physicsData=" + this.q + ", poseVel=" + this.f + ", isStatic=" + this.g + ", kinematicTarget=" + this.h + ", physicsListeners=" + this.i + ", wingManagerChanges=" + this.j + ", shipTeleportId=" + this.k + ", collisionMask=" + this.l + ", staticFrictionCoefficient=" + this.m + ", dynamicFrictionCoefficient=" + this.n + ", restitutionCoefficient=" + this.o + ", isGround=" + this.p + ")";
    }

    public final int hashCode() {
        int n2 = Long.hashCode(this.a);
        n2 = n2 * 31 + this.b.hashCode();
        n2 = n2 * 31 + this.c.hashCode();
        n2 = n2 * 31 + Double.hashCode(this.d);
        n2 = n2 * 31 + this.e.hashCode();
        n2 = n2 * 31 + this.q.hashCode();
        n2 = n2 * 31 + this.f.hashCode();
        n2 = n2 * 31 + Boolean.hashCode(this.g);
        n2 = n2 * 31 + (this.h == null ? 0 : this.h.hashCode());
        n2 = n2 * 31 + ((Object)this.i).hashCode();
        n2 = n2 * 31 + (this.j == null ? 0 : this.j.hashCode());
        n2 = n2 * 31 + Integer.hashCode(this.k);
        n2 = n2 * 31 + Integer.hashCode(this.l);
        n2 = n2 * 31 + Double.hashCode(this.m);
        n2 = n2 * 31 + Double.hashCode(this.n);
        n2 = n2 * 31 + Double.hashCode(this.o);
        n2 = n2 * 31 + Boolean.hashCode(this.p);
        return n2;
    }

    public final boolean equals(Object other) {
        fz_0 fz_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof fz_0)) {
            return false;
        }
        fz_02 = fz_02;
        if (this.a != fz_02.a) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)fz_02.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)fz_02.c)) {
            return false;
        }
        if (Double.compare(this.d, fz_02.d) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.e, (Object)fz_02.e)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.q, (Object)fz_02.q)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.f, (Object)fz_02.f)) {
            return false;
        }
        if (this.g != fz_02.g) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.h, (Object)fz_02.h)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.i, fz_02.i)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.j, (Object)fz_02.j)) {
            return false;
        }
        if (this.k != fz_02.k) {
            return false;
        }
        if (this.l != fz_02.l) {
            return false;
        }
        if (Double.compare(this.m, fz_02.m) != 0) {
            return false;
        }
        if (Double.compare(this.n, fz_02.n) != 0) {
            return false;
        }
        if (Double.compare(this.o, fz_02.o) != 0) {
            return false;
        }
        return this.p == fz_02.p;
    }
}

