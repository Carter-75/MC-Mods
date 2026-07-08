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
import org.valkyrienskies.core.impl.shadow.HJ;
import org.valkyrienskies.core.impl.shadow.HK;
import org.valkyrienskies.core.impl.shadow.HL;
import org.valkyrienskies.core.impl.shadow.hb_0;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u000e\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u000e\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u00a2\u0006\u0004\bD\u0010EJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\fH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\bJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0017\u0010\bJ\u009a\u0001\u0010#\u001a\u00020\u00002\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0019\u001a\u00020\f2\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001b\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\"\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%H\u00d6\u0003\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,H\u00d6\u0001\u00a2\u0006\u0004\b-\u0010.R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u0010\u0013R\u001a\u0010\"\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b2\u0010\u000bR\u001a\u00104\u001a\u0002038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u0010!\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u00108\u001a\u0004\b9\u0010\bR\u001a\u0010\u0019\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010:\u001a\u0004\b;\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010:\u001a\u0004\b<\u0010\u000eR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00108\u001a\u0004\b=\u0010\bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b>\u0010\bR\"\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010?\u001a\u0004\b@\u0010\u0005R\"\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010?\u001a\u0004\bA\u0010\u0005R\u0019\u0010 \u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b \u00108\u001a\u0004\bB\u0010\bR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\bC\u0010\b\u00a8\u0006F"}, d2={"Lorg/valkyrienskies/physics_api/joints/DistanceJoint;", "Lorg/valkyrienskies/physics_api/joints/JointData;", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "component1", "()Ljava/lang/Integer;", "", "component10", "()Ljava/lang/Float;", "", "component11", "()D", "Lorg/valkyrienskies/physics_api/Pose;", "component2", "()Lorg/valkyrienskies/physics_api/Pose;", "component3", "component4", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "component5", "()Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "component6", "component7", "component8", "component9", "physicsBodyId0", "localFrame0", "physicsBodyId1", "localFrame1", "breakForceTorque", "minDistance", "maxDistance", "tolerance", "stiffness", "damping", "compliance", "copy", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;D)Lorg/valkyrienskies/physics_api/joints/DistanceJoint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "getBreakForceTorque", "D", "getCompliance", "Lorg/valkyrienskies/physics_api/joints/JointType;", "constraintType", "Lorg/valkyrienskies/physics_api/joints/JointType;", "getConstraintType", "()Lorg/valkyrienskies/physics_api/joints/JointType;", "Ljava/lang/Float;", "getDamping", "Lorg/valkyrienskies/physics_api/Pose;", "getLocalFrame0", "getLocalFrame1", "getMaxDistance", "getMinDistance", "Ljava/lang/Integer;", "getPhysicsBodyId0", "getPhysicsBodyId1", "getStiffness", "getTolerance", "<init>", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;D)V", "physics_api"})
public final class HF
implements HJ {
    private final Integer g;
    private final hb_0 h;
    private final Integer i;
    private final hb_0 j;
    private final HL l;
    public final Float b;
    public final Float c;
    public final Float d;
    public final Float e;
    public final Float f;
    private final double m;
    private final HK n;

    public HF(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, Float f2, Float f3, Float f4, Float f5, Float f6, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        this.g = n2;
        this.h = hb_02;
        this.i = n3;
        this.j = hb_03;
        this.l = hL;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        this.m = d2;
        this.n = HK.DISTANCE;
    }

    public /* synthetic */ HF(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, Float f2, Float f3, Float f4, Float f5, Float f6, double d2, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 0x10) != 0) {
            hL = null;
        }
        if ((n4 & 0x20) != 0) {
            f2 = null;
        }
        if ((n4 & 0x40) != 0) {
            f3 = null;
        }
        if ((n4 & 0x80) != 0) {
            f4 = null;
        }
        if ((n4 & 0x100) != 0) {
            f5 = null;
        }
        if ((n4 & 0x200) != 0) {
            f6 = null;
        }
        if ((n4 & 0x400) != 0) {
            d2 = 1.0E-10;
        }
        this(n2, hb_02, n3, hb_03, hL, f2, f3, f4, f5, f6, d2);
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
    public final Float f() {
        return this.b;
    }

    @JvmName(name="g")
    public final Float g() {
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
    public final Float j() {
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
        HF hF = this;
        return hF.g;
    }

    private hb_0 l() {
        HF hF = this;
        return hF.h;
    }

    private Integer m() {
        HF hF = this;
        return hF.i;
    }

    private hb_0 n() {
        HF hF = this;
        return hF.j;
    }

    private HL q() {
        HF hF = this;
        return hF.l;
    }

    private Float r() {
        return this.b;
    }

    private Float s() {
        return this.c;
    }

    private Float t() {
        return this.d;
    }

    private Float u() {
        return this.e;
    }

    private Float v() {
        return this.f;
    }

    private double w() {
        HF hF = this;
        return hF.m;
    }

    private static HF a(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, Float f2, Float f3, Float f4, Float f5, Float f6, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        return new HF(n2, hb_02, n3, hb_03, hL, f2, f3, f4, f5, f6, d2);
    }

    private static /* synthetic */ HF a$default(HF object, Integer object2, hb_0 object3, Integer object4, hb_0 object5, HL object6, Float f2, Float f3, Float f4, Float f5, Float f6, double d2, int n2) {
        HF hF;
        if ((n2 & 1) != 0) {
            hF = object;
            object2 = hF.g;
        }
        if ((n2 & 2) != 0) {
            hF = object;
            object3 = hF.h;
        }
        if ((n2 & 4) != 0) {
            hF = object;
            object4 = hF.i;
        }
        if ((n2 & 8) != 0) {
            hF = object;
            object5 = hF.j;
        }
        if ((n2 & 0x10) != 0) {
            hF = object;
            object6 = hF.l;
        }
        if ((n2 & 0x20) != 0) {
            f2 = ((HF)object).b;
        }
        if ((n2 & 0x40) != 0) {
            f3 = ((HF)object).c;
        }
        if ((n2 & 0x80) != 0) {
            f4 = ((HF)object).d;
        }
        if ((n2 & 0x100) != 0) {
            f5 = ((HF)object).e;
        }
        if ((n2 & 0x200) != 0) {
            f6 = ((HF)object).f;
        }
        if ((n2 & 0x400) != 0) {
            hF = object;
            d2 = hF.m;
        }
        Integer n3 = object2;
        hb_0 hb_02 = object3;
        Integer n4 = object4;
        hb_0 hb_03 = object5;
        HL hL = object6;
        Float f7 = f2;
        Float f8 = f3;
        Float f9 = f4;
        Float f10 = f5;
        double d3 = d2;
        f5 = f6;
        f4 = f10;
        f3 = f9;
        f2 = f8;
        object6 = f7;
        object5 = hL;
        object4 = hb_03;
        object3 = n4;
        object2 = hb_02;
        object = n3;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        return new HF((Integer)object, (hb_0)object2, (Integer)object3, (hb_0)object4, (HL)object5, (Float)object6, f2, f3, f4, f5, d3);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        HF hF = this;
        HF hF2 = hF;
        HF hF3 = this;
        hF2 = hF3;
        HF hF4 = this;
        hF2 = hF4;
        HF hF5 = this;
        hF2 = hF5;
        HF hF6 = this;
        hF2 = hF6;
        hF2 = this;
        stringBuilder.append("HF(i=").append(hF.g).append(", e=").append(hF3.h).append(", j=").append(hF4.i).append(", f=").append(hF5.j).append(", a=").append(hF6.l).append(", h=").append(this.b).append(", g=").append(this.c).append(", l=").append(this.d).append(", k=").append(this.e).append(", d=").append(this.f).append(", b=").append(hF2.m).append(')');
        return stringBuilder.toString();
    }

    public final int hashCode() {
        int n2;
        int n3;
        int n4;
        HF hF = this;
        if (hF.g == null) {
            n4 = 0;
        } else {
            hF = this;
            n4 = ((Object)hF.g).hashCode();
        }
        int n5 = n4;
        HF hF2 = this;
        int n6 = n4 * 31 + hF2.h.hashCode();
        HF hF3 = this;
        if (hF3.i == null) {
            n3 = 0;
        } else {
            hF3 = this;
            n3 = ((Object)hF3.i).hashCode();
        }
        int n7 = n6 * 31 + n3;
        HF hF4 = this;
        int n8 = n7 * 31 + hF4.j.hashCode();
        HF hF5 = this;
        if (hF5.l == null) {
            n2 = 0;
        } else {
            hF5 = this;
            n2 = hF5.l.hashCode();
        }
        int n9 = n8 * 31 + n2;
        n9 = n9 * 31 + (this.b == null ? 0 : ((Object)this.b).hashCode());
        n9 = n9 * 31 + (this.c == null ? 0 : ((Object)this.c).hashCode());
        n9 = n9 * 31 + (this.d == null ? 0 : ((Object)this.d).hashCode());
        n9 = n9 * 31 + (this.e == null ? 0 : ((Object)this.e).hashCode());
        n9 = n9 * 31 + (this.f == null ? 0 : ((Object)this.f).hashCode());
        HF hF6 = this;
        int n10 = n9 * 31 + Double.hashCode(hF6.m);
        return n10;
    }

    public final boolean equals(Object other) {
        HF hF;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HF)) {
            return false;
        }
        hF = hF;
        HF hF2 = this;
        HF hF3 = hF2;
        hF3 = hF;
        if (!Intrinsics.areEqual((Object)hF2.g, (Object)hF3.g)) {
            return false;
        }
        HF hF4 = this;
        hF3 = hF4;
        hF3 = hF;
        if (!Intrinsics.areEqual((Object)hF4.h, (Object)hF3.h)) {
            return false;
        }
        HF hF5 = this;
        hF3 = hF5;
        hF3 = hF;
        if (!Intrinsics.areEqual((Object)hF5.i, (Object)hF3.i)) {
            return false;
        }
        HF hF6 = this;
        hF3 = hF6;
        hF3 = hF;
        if (!Intrinsics.areEqual((Object)hF6.j, (Object)hF3.j)) {
            return false;
        }
        HF hF7 = this;
        hF3 = hF7;
        hF3 = hF;
        if (!Intrinsics.areEqual((Object)hF7.l, (Object)hF3.l)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)hF.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)hF.c)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.d, (Object)hF.d)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.e, (Object)hF.e)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.f, (Object)hF.f)) {
            return false;
        }
        HF hF8 = this;
        hF3 = hF8;
        hF3 = hF;
        return Intrinsics.areEqual((Object)hF8.m, (Object)hF3.m);
    }
}

