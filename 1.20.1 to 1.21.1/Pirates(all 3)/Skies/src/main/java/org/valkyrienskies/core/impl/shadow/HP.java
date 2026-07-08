/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.HE;
import org.valkyrienskies.core.impl.shadow.HJ;
import org.valkyrienskies.core.impl.shadow.HK;
import org.valkyrienskies.core.impl.shadow.HL;
import org.valkyrienskies.core.impl.shadow.hb_0;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u000e\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u000e\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u00a2\u0006\u0004\b8\u00109J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\n\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013Jj\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00062\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u0011H\u00c6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$H\u00d6\u0001\u00a2\u0006\u0004\b%\u0010&R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\rR\u001a\u0010\u001a\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010\u0013R\u001a\u0010,\u001a\u00020+8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\b3\u0010\bR\u001a\u0010\u0017\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u00102\u001a\u0004\b4\u0010\bR\"\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u00105\u001a\u0004\b6\u0010\u0005R\"\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u00105\u001a\u0004\b7\u0010\u0005\u00a8\u0006:"}, d2={"Lorg/valkyrienskies/physics_api/joints/SphericalJoint;", "Lorg/valkyrienskies/physics_api/joints/JointData;", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "component1", "()Ljava/lang/Integer;", "Lorg/valkyrienskies/physics_api/Pose;", "component2", "()Lorg/valkyrienskies/physics_api/Pose;", "component3", "component4", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "component5", "()Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "component6", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "", "component7", "()D", "physicsBodyId0", "localFrame0", "physicsBodyId1", "localFrame1", "breakForceTorque", "limitCone", "compliance", "copy", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;D)Lorg/valkyrienskies/physics_api/joints/SphericalJoint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "getBreakForceTorque", "D", "getCompliance", "Lorg/valkyrienskies/physics_api/joints/JointType;", "constraintType", "Lorg/valkyrienskies/physics_api/joints/JointType;", "getConstraintType", "()Lorg/valkyrienskies/physics_api/joints/JointType;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "getLimitCone", "Lorg/valkyrienskies/physics_api/Pose;", "getLocalFrame0", "getLocalFrame1", "Ljava/lang/Integer;", "getPhysicsBodyId0", "getPhysicsBodyId1", "<init>", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;D)V", "physics_api"})
public final class HP
implements HJ {
    private final Integer c;
    private final hb_0 d;
    private final Integer e;
    private final hb_0 f;
    private final HL g;
    public final HE.i b;
    private final double h;
    private final HK i;

    public HP(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.i i2, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        this.c = n2;
        this.d = hb_02;
        this.e = n3;
        this.f = hb_03;
        this.g = hL;
        this.b = i2;
        this.h = d2;
        this.i = HK.SPHERICAL;
    }

    public /* synthetic */ HP(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.i i2, double d2, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 0x10) != 0) {
            hL = null;
        }
        if ((n4 & 0x20) != 0) {
            i2 = null;
        }
        if ((n4 & 0x40) != 0) {
            d2 = 1.0E-10;
        }
        this(n2, hb_02, n3, hb_03, hL, i2, d2);
    }

    @Override
    @JvmName(name="a")
    public final Integer a() {
        return this.c;
    }

    @Override
    @JvmName(name="b")
    public final hb_0 b() {
        return this.d;
    }

    @Override
    @JvmName(name="c")
    public final Integer c() {
        return this.e;
    }

    @Override
    @JvmName(name="d")
    public final hb_0 d() {
        return this.f;
    }

    @Override
    @JvmName(name="e")
    public final HL e() {
        return this.g;
    }

    @JvmName(name="f")
    public final HE.i f() {
        return this.b;
    }

    @Override
    @JvmName(name="o")
    public final double o() {
        return this.h;
    }

    @Override
    @JvmName(name="p")
    public final HK p() {
        return this.i;
    }

    private Integer g() {
        HP hP = this;
        return hP.c;
    }

    private hb_0 h() {
        HP hP = this;
        return hP.d;
    }

    private Integer i() {
        HP hP = this;
        return hP.e;
    }

    private hb_0 j() {
        HP hP = this;
        return hP.f;
    }

    private HL k() {
        HP hP = this;
        return hP.g;
    }

    private HE.i l() {
        return this.b;
    }

    private double m() {
        HP hP = this;
        return hP.h;
    }

    private static HP a(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.i i2, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        return new HP(n2, hb_02, n3, hb_03, hL, i2, d2);
    }

    private static /* synthetic */ HP a$default(HP object, Integer object2, hb_0 object3, Integer object4, hb_0 object5, HL object6, HE.i i2, double d2, int n2) {
        HP hP;
        if ((n2 & 1) != 0) {
            hP = object;
            object2 = hP.c;
        }
        if ((n2 & 2) != 0) {
            hP = object;
            object3 = hP.d;
        }
        if ((n2 & 4) != 0) {
            hP = object;
            object4 = hP.e;
        }
        if ((n2 & 8) != 0) {
            hP = object;
            object5 = hP.f;
        }
        if ((n2 & 0x10) != 0) {
            hP = object;
            object6 = hP.g;
        }
        if ((n2 & 0x20) != 0) {
            i2 = ((HP)object).b;
        }
        if ((n2 & 0x40) != 0) {
            hP = object;
            d2 = hP.h;
        }
        Integer n3 = object2;
        hb_0 hb_02 = object3;
        Integer n4 = object4;
        hb_0 hb_03 = object5;
        HL hL = object6;
        double d3 = d2;
        object6 = i2;
        object5 = hL;
        object4 = hb_03;
        object3 = n4;
        object2 = hb_02;
        object = n3;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        return new HP((Integer)object, (hb_0)object2, (Integer)object3, (hb_0)object4, (HL)object5, (HE.i)object6, d3);
    }

    public final String toString() {
        HP hP = this;
        HP hP2 = hP;
        HP hP3 = this;
        hP2 = hP3;
        HP hP4 = this;
        hP2 = hP4;
        HP hP5 = this;
        hP2 = hP5;
        HP hP6 = this;
        hP2 = hP6;
        hP2 = this;
        return "HP(g=" + hP.c + ", e=" + hP3.d + ", h=" + hP4.e + ", f=" + hP5.f + ", a=" + hP6.g + ", d=" + this.b + ", b=" + hP2.h + ')';
    }

    public final int hashCode() {
        int n2;
        int n3;
        int n4;
        HP hP = this;
        if (hP.c == null) {
            n4 = 0;
        } else {
            hP = this;
            n4 = ((Object)hP.c).hashCode();
        }
        int n5 = n4;
        HP hP2 = this;
        int n6 = n4 * 31 + hP2.d.hashCode();
        HP hP3 = this;
        if (hP3.e == null) {
            n3 = 0;
        } else {
            hP3 = this;
            n3 = ((Object)hP3.e).hashCode();
        }
        int n7 = n6 * 31 + n3;
        HP hP4 = this;
        int n8 = n7 * 31 + hP4.f.hashCode();
        HP hP5 = this;
        if (hP5.g == null) {
            n2 = 0;
        } else {
            hP5 = this;
            n2 = hP5.g.hashCode();
        }
        int n9 = n8 * 31 + n2;
        n9 = n9 * 31 + (this.b == null ? 0 : this.b.hashCode());
        HP hP6 = this;
        int n10 = n9 * 31 + Double.hashCode(hP6.h);
        return n10;
    }

    public final boolean equals(Object other) {
        HP hP;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HP)) {
            return false;
        }
        hP = hP;
        HP hP2 = this;
        HP hP3 = hP2;
        hP3 = hP;
        if (!Intrinsics.areEqual((Object)hP2.c, (Object)hP3.c)) {
            return false;
        }
        HP hP4 = this;
        hP3 = hP4;
        hP3 = hP;
        if (!Intrinsics.areEqual((Object)hP4.d, (Object)hP3.d)) {
            return false;
        }
        HP hP5 = this;
        hP3 = hP5;
        hP3 = hP;
        if (!Intrinsics.areEqual((Object)hP5.e, (Object)hP3.e)) {
            return false;
        }
        HP hP6 = this;
        hP3 = hP6;
        hP3 = hP;
        if (!Intrinsics.areEqual((Object)hP6.f, (Object)hP3.f)) {
            return false;
        }
        HP hP7 = this;
        hP3 = hP7;
        hP3 = hP;
        if (!Intrinsics.areEqual((Object)hP7.g, (Object)hP3.g)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)hP.b)) {
            return false;
        }
        HP hP8 = this;
        hP3 = hP8;
        hP3 = hP;
        return Intrinsics.areEqual((Object)hP8.h, (Object)hP3.h);
    }
}

