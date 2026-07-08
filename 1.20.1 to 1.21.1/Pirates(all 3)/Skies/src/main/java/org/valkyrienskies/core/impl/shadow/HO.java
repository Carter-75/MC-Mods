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

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001:\u0001NB\u0089\u0001\u0012\u000e\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\u000e\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010!\u001a\u00020\f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010(\u001a\u00020\t\u00a2\u0006\u0004\bL\u0010MJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\fH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001d\u0010\u001cJ\u009a\u0001\u0010)\u001a\u00020\u00002\u0010\b\u0002\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001f\u001a\u00020\f2\u0010\b\u0002\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010!\u001a\u00020\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010(\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u00d6\u0003\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u000201H\u00d6\u0001\u00a2\u0006\u0004\b2\u00103R\u0019\u0010#\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b#\u00104\u001a\u0004\b5\u0010\u0016R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b7\u0010\u0013R\u001a\u0010(\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b(\u00108\u001a\u0004\b9\u0010\u000bR\u001a\u0010;\u001a\u00020:8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b%\u0010?\u001a\u0004\b@\u0010\u001cR\u0019\u0010'\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b'\u0010A\u001a\u0004\bB\u0010\bR\u0019\u0010&\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b&\u0010?\u001a\u0004\bC\u0010\u001cR\u0019\u0010$\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b$\u0010D\u001a\u0004\bE\u0010\u0019R\u001a\u0010\u001f\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010F\u001a\u0004\bG\u0010\u000eR\u001a\u0010!\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b!\u0010F\u001a\u0004\bH\u0010\u000eR\"\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010I\u001a\u0004\bJ\u0010\u0005R\"\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010I\u001a\u0004\bK\u0010\u0005\u00a8\u0006O"}, d2={"Lorg/valkyrienskies/physics_api/joints/RevoluteJoint;", "Lorg/valkyrienskies/physics_api/joints/JointData;", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "component1", "()Ljava/lang/Integer;", "", "component10", "()Ljava/lang/Boolean;", "", "component11", "()D", "Lorg/valkyrienskies/physics_api/Pose;", "component2", "()Lorg/valkyrienskies/physics_api/Pose;", "component3", "component4", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "component5", "()Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "component6", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;", "component7", "()Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;", "", "component8", "()Ljava/lang/Float;", "component9", "physicsBodyId0", "localFrame0", "physicsBodyId1", "localFrame1", "breakForceTorque", "angularLimitPair", "driveVelocity", "driveForceLimit", "driveGearRatio", "driveFreeSpin", "compliance", "copy", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;D)Lorg/valkyrienskies/physics_api/joints/RevoluteJoint;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "getAngularLimitPair", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "getBreakForceTorque", "D", "getCompliance", "Lorg/valkyrienskies/physics_api/joints/JointType;", "constraintType", "Lorg/valkyrienskies/physics_api/joints/JointType;", "getConstraintType", "()Lorg/valkyrienskies/physics_api/joints/JointType;", "Ljava/lang/Float;", "getDriveForceLimit", "Ljava/lang/Boolean;", "getDriveFreeSpin", "getDriveGearRatio", "Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;", "getDriveVelocity", "Lorg/valkyrienskies/physics_api/Pose;", "getLocalFrame0", "getLocalFrame1", "Ljava/lang/Integer;", "getPhysicsBodyId0", "getPhysicsBodyId1", "<init>", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;D)V", "RevoluteDriveVelocity", "physics_api"})
public final class HO
implements HJ {
    private final Integer g;
    private final hb_0 h;
    private final Integer i;
    private final hb_0 j;
    private final HL l;
    public final HE.a b;
    public final a c;
    public final Float d;
    public final Float e;
    public final Boolean f;
    private final double m;
    private final HK n;

    public HO(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.a a2, a a3, Float f2, Float f3, Boolean bl, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        this.g = n2;
        this.h = hb_02;
        this.i = n3;
        this.j = hb_03;
        this.l = hL;
        this.b = a2;
        this.c = a3;
        this.d = f2;
        this.e = f3;
        this.f = bl;
        this.m = d2;
        this.n = HK.REVOLUTE;
    }

    public /* synthetic */ HO(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.a a2, a a3, Float f2, Float f3, Boolean bl, double d2, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 0x10) != 0) {
            hL = null;
        }
        if ((n4 & 0x20) != 0) {
            a2 = null;
        }
        if ((n4 & 0x40) != 0) {
            a3 = null;
        }
        if ((n4 & 0x80) != 0) {
            f2 = null;
        }
        if ((n4 & 0x100) != 0) {
            f3 = null;
        }
        if ((n4 & 0x200) != 0) {
            bl = null;
        }
        if ((n4 & 0x400) != 0) {
            d2 = 1.0E-10;
        }
        this(n2, hb_02, n3, hb_03, hL, a2, a3, f2, f3, bl, d2);
    }

    @Override
    @JvmName(name="a")
    public final Integer a() {
        return this.g;
    }

    @Override
    @JvmName(name="b")
    public final hb_0 b() {
        return this.h;
    }

    @Override
    @JvmName(name="c")
    public final Integer c() {
        return this.i;
    }

    @Override
    @JvmName(name="d")
    public final hb_0 d() {
        return this.j;
    }

    @Override
    @JvmName(name="e")
    public final HL e() {
        return this.l;
    }

    @JvmName(name="f")
    public final HE.a f() {
        return this.b;
    }

    @JvmName(name="g")
    public final a g() {
        return this.c;
    }

    @JvmName(name="h")
    public final Float h() {
        return this.d;
    }

    @JvmName(name="i")
    public final Float i() {
        return this.e;
    }

    @JvmName(name="j")
    public final Boolean j() {
        return this.f;
    }

    @Override
    @JvmName(name="o")
    public final double o() {
        return this.m;
    }

    @Override
    @JvmName(name="p")
    public final HK p() {
        return this.n;
    }

    private Integer k() {
        HO hO = this;
        return hO.g;
    }

    private hb_0 l() {
        HO hO = this;
        return hO.h;
    }

    private Integer m() {
        HO hO = this;
        return hO.i;
    }

    private hb_0 n() {
        HO hO = this;
        return hO.j;
    }

    private HL q() {
        HO hO = this;
        return hO.l;
    }

    private HE.a r() {
        return this.b;
    }

    private a s() {
        return this.c;
    }

    private Float t() {
        return this.d;
    }

    private Float u() {
        return this.e;
    }

    private Boolean v() {
        return this.f;
    }

    private double w() {
        HO hO = this;
        return hO.m;
    }

    private static HO a(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.a a2, a a3, Float f2, Float f3, Boolean bl, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        return new HO(n2, hb_02, n3, hb_03, hL, a2, a3, f2, f3, bl, d2);
    }

    private static /* synthetic */ HO a$default(HO object, Integer object2, hb_0 object3, Integer object4, hb_0 object5, HL object6, HE.a object7, a object8, Float f2, Float constable, Boolean bl, double d2, int n2) {
        HO hO;
        if ((n2 & 1) != 0) {
            hO = object;
            object2 = hO.g;
        }
        if ((n2 & 2) != 0) {
            hO = object;
            object3 = hO.h;
        }
        if ((n2 & 4) != 0) {
            hO = object;
            object4 = hO.i;
        }
        if ((n2 & 8) != 0) {
            hO = object;
            object5 = hO.j;
        }
        if ((n2 & 0x10) != 0) {
            hO = object;
            object6 = hO.l;
        }
        if ((n2 & 0x20) != 0) {
            object7 = ((HO)object).b;
        }
        if ((n2 & 0x40) != 0) {
            object8 = ((HO)object).c;
        }
        if ((n2 & 0x80) != 0) {
            f2 = ((HO)object).d;
        }
        if ((n2 & 0x100) != 0) {
            constable = ((HO)object).e;
        }
        if ((n2 & 0x200) != 0) {
            bl = ((HO)object).f;
        }
        if ((n2 & 0x400) != 0) {
            hO = object;
            d2 = hO.m;
        }
        Integer n3 = object2;
        hb_0 hb_02 = object3;
        Integer n4 = object4;
        hb_0 hb_03 = object5;
        HL hL = object6;
        HE.a a2 = object7;
        a a3 = object8;
        Float f3 = f2;
        Float f4 = constable;
        double d3 = d2;
        constable = bl;
        f2 = f4;
        object8 = f3;
        object7 = a3;
        object6 = a2;
        object5 = hL;
        object4 = hb_03;
        object3 = n4;
        object2 = hb_02;
        object = n3;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        return new HO((Integer)object, (hb_0)object2, (Integer)object3, (hb_0)object4, (HL)object5, (HE.a)object6, (a)object7, (Float)object8, f2, (Boolean)constable, d3);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        HO hO = this;
        HO hO2 = hO;
        HO hO3 = this;
        hO2 = hO3;
        HO hO4 = this;
        hO2 = hO4;
        HO hO5 = this;
        hO2 = hO5;
        HO hO6 = this;
        hO2 = hO6;
        hO2 = this;
        stringBuilder.append("HO(k=").append(hO.g).append(", i=").append(hO3.h).append(", l=").append(hO4.i).append(", j=").append(hO5.j).append(", b=").append(hO6.l).append(", a=").append(this.b).append(", h=").append(this.c).append(", e=").append(this.d).append(", g=").append(this.e).append(", f=").append(this.f).append(", c=").append(hO2.m).append(')');
        return stringBuilder.toString();
    }

    public final int hashCode() {
        int n2;
        int n3;
        int n4;
        HO hO = this;
        if (hO.g == null) {
            n4 = 0;
        } else {
            hO = this;
            n4 = ((Object)hO.g).hashCode();
        }
        int n5 = n4;
        HO hO2 = this;
        int n6 = n4 * 31 + hO2.h.hashCode();
        HO hO3 = this;
        if (hO3.i == null) {
            n3 = 0;
        } else {
            hO3 = this;
            n3 = ((Object)hO3.i).hashCode();
        }
        int n7 = n6 * 31 + n3;
        HO hO4 = this;
        int n8 = n7 * 31 + hO4.j.hashCode();
        HO hO5 = this;
        if (hO5.l == null) {
            n2 = 0;
        } else {
            hO5 = this;
            n2 = hO5.l.hashCode();
        }
        int n9 = n8 * 31 + n2;
        n9 = n9 * 31 + (this.b == null ? 0 : this.b.hashCode());
        n9 = n9 * 31 + (this.c == null ? 0 : this.c.hashCode());
        n9 = n9 * 31 + (this.d == null ? 0 : ((Object)this.d).hashCode());
        n9 = n9 * 31 + (this.e == null ? 0 : ((Object)this.e).hashCode());
        n9 = n9 * 31 + (this.f == null ? 0 : ((Object)this.f).hashCode());
        HO hO6 = this;
        int n10 = n9 * 31 + Double.hashCode(hO6.m);
        return n10;
    }

    public final boolean equals(Object other) {
        HO hO;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HO)) {
            return false;
        }
        hO = hO;
        HO hO2 = this;
        HO hO3 = hO2;
        hO3 = hO;
        if (!Intrinsics.areEqual((Object)hO2.g, (Object)hO3.g)) {
            return false;
        }
        HO hO4 = this;
        hO3 = hO4;
        hO3 = hO;
        if (!Intrinsics.areEqual((Object)hO4.h, (Object)hO3.h)) {
            return false;
        }
        HO hO5 = this;
        hO3 = hO5;
        hO3 = hO;
        if (!Intrinsics.areEqual((Object)hO5.i, (Object)hO3.i)) {
            return false;
        }
        HO hO6 = this;
        hO3 = hO6;
        hO3 = hO;
        if (!Intrinsics.areEqual((Object)hO6.j, (Object)hO3.j)) {
            return false;
        }
        HO hO7 = this;
        hO3 = hO7;
        hO3 = hO;
        if (!Intrinsics.areEqual((Object)hO7.l, (Object)hO3.l)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)hO.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)hO.c)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.d, (Object)hO.d)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.e, (Object)hO.e)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.f, (Object)hO.f)) {
            return false;
        }
        HO hO8 = this;
        hO3 = hO8;
        hO3 = hO;
        return Intrinsics.areEqual((Object)hO8.m, (Object)hO3.m);
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\u00020\u00058\u0007\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0014\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\n\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HO$a;", "", "", "c", "()F", "", "d", "()Z", "p0", "p1", "a", "(FZ)Lorg/valkyrienskies/core/impl/shadow/HO$a;", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "b", "Z", "F", "<init>", "(FZ)V"})
    public static final class a {
        public final float a;
        public final boolean b;

        public a(float f2, boolean bl) {
            this.a = f2;
            this.b = bl;
        }

        public /* synthetic */ a(float f2, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                bl = true;
            }
            this(f2, bl);
        }

        @JvmName(name="a")
        public final float a() {
            return this.a;
        }

        @JvmName(name="b")
        public final boolean b() {
            return this.b;
        }

        private float c() {
            return this.a;
        }

        private boolean d() {
            return this.b;
        }

        private static a a(float f2, boolean bl) {
            return new a(f2, bl);
        }

        private static /* synthetic */ a a$default(a a2, float f2, boolean bl, int n2) {
            if ((n2 & 1) != 0) {
                f2 = a2.a;
            }
            if ((n2 & 2) != 0) {
                bl = a2.b;
            }
            boolean bl2 = bl;
            float f3 = f2;
            return new a(f3, bl2);
        }

        public final String toString() {
            return "a(b=" + this.a + ", a=" + this.b + ')';
        }

        public final int hashCode() {
            int n2 = Float.hashCode(this.a);
            int n3 = this.b ? 1 : 0;
            if (n3 != 0) {
                n3 = 1;
            }
            n2 = n2 * 31 + n3;
            return n2;
        }

        public final boolean equals(Object other) {
            a a2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a2 = a2;
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.a), (Object)Float.valueOf(a2.a))) {
                return false;
            }
            return this.b == a2.b;
        }
    }
}

