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

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u000e\u0010\u0017\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u000e\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0014\u00a2\u0006\u0004\b>\u0010?J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\n\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016Jv\u0010\u001f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00062\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u0014H\u00c6\u0001\u00a2\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u00d6\u0003\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(H\u00d6\u0001\u00a2\u0006\u0004\b)\u0010*R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010\rR\u001a\u0010\u001e\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b.\u0010\u0016R\u001a\u00100\u001a\u00020/8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u0010\u0013R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b7\u0010\u0010R\u001a\u0010\u0018\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u00108\u001a\u0004\b9\u0010\bR\u001a\u0010\u001a\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u00108\u001a\u0004\b:\u0010\bR\"\u0010\u0017\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010;\u001a\u0004\b<\u0010\u0005R\"\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010;\u001a\u0004\b=\u0010\u0005\u00a8\u0006@"}, d2={"Lorg/valkyrienskies/physics_api/joints/GearJoint;", "Lorg/valkyrienskies/physics_api/joints/JointData;", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "component1", "()Ljava/lang/Integer;", "Lorg/valkyrienskies/physics_api/Pose;", "component2", "()Lorg/valkyrienskies/physics_api/Pose;", "component3", "component4", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "component5", "()Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "component6", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "", "component7", "()Ljava/lang/Float;", "", "component8", "()D", "physicsBodyId0", "localFrame0", "physicsBodyId1", "localFrame1", "breakForceTorque", "hinges", "gearRatio", "compliance", "copy", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;Ljava/lang/Float;D)Lorg/valkyrienskies/physics_api/joints/GearJoint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "getBreakForceTorque", "D", "getCompliance", "Lorg/valkyrienskies/physics_api/joints/JointType;", "constraintType", "Lorg/valkyrienskies/physics_api/joints/JointType;", "getConstraintType", "()Lorg/valkyrienskies/physics_api/joints/JointType;", "Ljava/lang/Float;", "getGearRatio", "Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "getHinges", "Lorg/valkyrienskies/physics_api/Pose;", "getLocalFrame0", "getLocalFrame1", "Ljava/lang/Integer;", "getPhysicsBodyId0", "getPhysicsBodyId1", "<init>", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;Ljava/lang/Float;D)V", "physics_api"})
public final class HH
implements HJ {
    private final Integer d;
    private final hb_0 e;
    private final Integer f;
    private final hb_0 g;
    private final HL h;
    public final HE.h b;
    public final Float c;
    private final double i;
    private final HK j;

    public HH(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.h h2, Float f2, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        this.d = n2;
        this.e = hb_02;
        this.f = n3;
        this.g = hb_03;
        this.h = hL;
        this.b = h2;
        this.c = f2;
        this.i = d2;
        this.j = HK.GEAR;
    }

    public /* synthetic */ HH(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.h h2, Float f2, double d2, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 0x10) != 0) {
            hL = null;
        }
        if ((n4 & 0x20) != 0) {
            h2 = null;
        }
        if ((n4 & 0x40) != 0) {
            f2 = null;
        }
        if ((n4 & 0x80) != 0) {
            d2 = 1.0E-10;
        }
        this(n2, hb_02, n3, hb_03, hL, h2, f2, d2);
    }

    @Override
    @JvmName(name="a")
    public final Integer a() {
        return this.d;
    }

    @Override
    @JvmName(name="b")
    public final hb_0 b() {
        return this.e;
    }

    @Override
    @JvmName(name="c")
    public final Integer c() {
        return this.f;
    }

    @Override
    @JvmName(name="d")
    public final hb_0 d() {
        return this.g;
    }

    @Override
    @JvmName(name="e")
    public final HL e() {
        return this.h;
    }

    @JvmName(name="f")
    public final HE.h f() {
        return this.b;
    }

    @JvmName(name="g")
    public final Float g() {
        return this.c;
    }

    @Override
    @JvmName(name="o")
    public final double o() {
        return this.i;
    }

    @Override
    @JvmName(name="p")
    public final HK p() {
        return this.j;
    }

    private Integer h() {
        HH hH = this;
        return hH.d;
    }

    private hb_0 i() {
        HH hH = this;
        return hH.e;
    }

    private Integer j() {
        HH hH = this;
        return hH.f;
    }

    private hb_0 k() {
        HH hH = this;
        return hH.g;
    }

    private HL l() {
        HH hH = this;
        return hH.h;
    }

    private HE.h m() {
        return this.b;
    }

    private Float n() {
        return this.c;
    }

    private double q() {
        HH hH = this;
        return hH.i;
    }

    private static HH a(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.h h2, Float f2, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        return new HH(n2, hb_02, n3, hb_03, hL, h2, f2, d2);
    }

    private static /* synthetic */ HH a$default(HH object, Integer object2, hb_0 object3, Integer object4, hb_0 object5, HL object6, HE.h object7, Float f2, double d2, int n2) {
        HH hH;
        if ((n2 & 1) != 0) {
            hH = object;
            object2 = hH.d;
        }
        if ((n2 & 2) != 0) {
            hH = object;
            object3 = hH.e;
        }
        if ((n2 & 4) != 0) {
            hH = object;
            object4 = hH.f;
        }
        if ((n2 & 8) != 0) {
            hH = object;
            object5 = hH.g;
        }
        if ((n2 & 0x10) != 0) {
            hH = object;
            object6 = hH.h;
        }
        if ((n2 & 0x20) != 0) {
            object7 = ((HH)object).b;
        }
        if ((n2 & 0x40) != 0) {
            f2 = ((HH)object).c;
        }
        if ((n2 & 0x80) != 0) {
            hH = object;
            d2 = hH.i;
        }
        Integer n3 = object2;
        hb_0 hb_02 = object3;
        Integer n4 = object4;
        hb_0 hb_03 = object5;
        HL hL = object6;
        HE.h h2 = object7;
        double d3 = d2;
        object7 = f2;
        object6 = h2;
        object5 = hL;
        object4 = hb_03;
        object3 = n4;
        object2 = hb_02;
        object = n3;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        return new HH((Integer)object, (hb_0)object2, (Integer)object3, (hb_0)object4, (HL)object5, (HE.h)object6, (Float)object7, d3);
    }

    public final String toString() {
        HH hH = this;
        HH hH2 = hH;
        HH hH3 = this;
        hH2 = hH3;
        HH hH4 = this;
        hH2 = hH4;
        HH hH5 = this;
        hH2 = hH5;
        HH hH6 = this;
        hH2 = hH6;
        hH2 = this;
        return "HH(h=" + hH.d + ", f=" + hH3.e + ", i=" + hH4.f + ", g=" + hH5.g + ", a=" + hH6.h + ", e=" + this.b + ", d=" + this.c + ", b=" + hH2.i + ')';
    }

    public final int hashCode() {
        int n2;
        int n3;
        int n4;
        HH hH = this;
        if (hH.d == null) {
            n4 = 0;
        } else {
            hH = this;
            n4 = ((Object)hH.d).hashCode();
        }
        int n5 = n4;
        HH hH2 = this;
        int n6 = n4 * 31 + hH2.e.hashCode();
        HH hH3 = this;
        if (hH3.f == null) {
            n3 = 0;
        } else {
            hH3 = this;
            n3 = ((Object)hH3.f).hashCode();
        }
        int n7 = n6 * 31 + n3;
        HH hH4 = this;
        int n8 = n7 * 31 + hH4.g.hashCode();
        HH hH5 = this;
        if (hH5.h == null) {
            n2 = 0;
        } else {
            hH5 = this;
            n2 = hH5.h.hashCode();
        }
        int n9 = n8 * 31 + n2;
        n9 = n9 * 31 + (this.b == null ? 0 : this.b.hashCode());
        n9 = n9 * 31 + (this.c == null ? 0 : ((Object)this.c).hashCode());
        HH hH6 = this;
        int n10 = n9 * 31 + Double.hashCode(hH6.i);
        return n10;
    }

    public final boolean equals(Object other) {
        HH hH;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HH)) {
            return false;
        }
        hH = hH;
        HH hH2 = this;
        HH hH3 = hH2;
        hH3 = hH;
        if (!Intrinsics.areEqual((Object)hH2.d, (Object)hH3.d)) {
            return false;
        }
        HH hH4 = this;
        hH3 = hH4;
        hH3 = hH;
        if (!Intrinsics.areEqual((Object)hH4.e, (Object)hH3.e)) {
            return false;
        }
        HH hH5 = this;
        hH3 = hH5;
        hH3 = hH;
        if (!Intrinsics.areEqual((Object)hH5.f, (Object)hH3.f)) {
            return false;
        }
        HH hH6 = this;
        hH3 = hH6;
        hH3 = hH;
        if (!Intrinsics.areEqual((Object)hH6.g, (Object)hH3.g)) {
            return false;
        }
        HH hH7 = this;
        hH3 = hH7;
        hH3 = hH;
        if (!Intrinsics.areEqual((Object)hH7.h, (Object)hH3.h)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)hH.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)hH.c)) {
            return false;
        }
        HH hH8 = this;
        hH3 = hH8;
        hH3 = hH;
        return Intrinsics.areEqual((Object)hH8.i, (Object)hH3.i);
    }
}

