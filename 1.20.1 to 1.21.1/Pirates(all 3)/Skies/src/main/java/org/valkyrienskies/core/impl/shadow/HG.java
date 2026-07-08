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

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u000e\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u000e\u0010\u0013\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\n\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J^\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000eH\u00c6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\"R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\rR\u001a\u0010\u0016\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u0010R\u001a\u0010(\u001a\u00020'8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010\u0012\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b.\u0010\bR\"\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010/\u001a\u0004\b0\u0010\u0005R\"\u0010\u0013\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010/\u001a\u0004\b1\u0010\u0005\u00a8\u00064"}, d2={"Lorg/valkyrienskies/physics_api/joints/FixedJoint;", "Lorg/valkyrienskies/physics_api/joints/JointData;", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "component1", "()Ljava/lang/Integer;", "Lorg/valkyrienskies/physics_api/Pose;", "component2", "()Lorg/valkyrienskies/physics_api/Pose;", "component3", "component4", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "component5", "()Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "", "component6", "()D", "physicsBodyId0", "localFrame0", "physicsBodyId1", "localFrame1", "breakForceTorque", "compliance", "copy", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;D)Lorg/valkyrienskies/physics_api/joints/FixedJoint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "getBreakForceTorque", "D", "getCompliance", "Lorg/valkyrienskies/physics_api/joints/JointType;", "constraintType", "Lorg/valkyrienskies/physics_api/joints/JointType;", "getConstraintType", "()Lorg/valkyrienskies/physics_api/joints/JointType;", "Lorg/valkyrienskies/physics_api/Pose;", "getLocalFrame0", "getLocalFrame1", "Ljava/lang/Integer;", "getPhysicsBodyId0", "getPhysicsBodyId1", "<init>", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;D)V", "physics_api"})
public final class HG
implements HJ {
    private final Integer b;
    private final hb_0 c;
    private final Integer d;
    private final hb_0 e;
    private final HL f;
    private final double g;
    private final HK h;

    public HG(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        this.b = n2;
        this.c = hb_02;
        this.d = n3;
        this.e = hb_03;
        this.f = hL;
        this.g = d2;
        this.h = HK.FIXED;
    }

    public /* synthetic */ HG(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, double d2, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 0x10) != 0) {
            hL = null;
        }
        if ((n4 & 0x20) != 0) {
            d2 = 1.0E-10;
        }
        this(n2, hb_02, n3, hb_03, hL, d2);
    }

    @Override
    @JvmName(name="a")
    public final Integer a() {
        return this.b;
    }

    @Override
    @JvmName(name="b")
    public final hb_0 b() {
        return this.c;
    }

    @Override
    @JvmName(name="c")
    public final Integer c() {
        return this.d;
    }

    @Override
    @JvmName(name="d")
    public final hb_0 d() {
        return this.e;
    }

    @Override
    @JvmName(name="e")
    public final HL e() {
        return this.f;
    }

    @Override
    @JvmName(name="o")
    public final double o() {
        return this.g;
    }

    @Override
    @JvmName(name="p")
    public final HK p() {
        return this.h;
    }

    private Integer f() {
        HG hG = this;
        return hG.b;
    }

    private hb_0 g() {
        HG hG = this;
        return hG.c;
    }

    private Integer h() {
        HG hG = this;
        return hG.d;
    }

    private hb_0 i() {
        HG hG = this;
        return hG.e;
    }

    private HL j() {
        HG hG = this;
        return hG.f;
    }

    private double k() {
        HG hG = this;
        return hG.g;
    }

    private static HG a(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        return new HG(n2, hb_02, n3, hb_03, hL, d2);
    }

    private static /* synthetic */ HG a$default(HG object, Integer object2, hb_0 object3, Integer object4, hb_0 object5, HL hL, double d2, int n2) {
        HG hG;
        if ((n2 & 1) != 0) {
            hG = object;
            object2 = hG.b;
        }
        if ((n2 & 2) != 0) {
            hG = object;
            object3 = hG.c;
        }
        if ((n2 & 4) != 0) {
            hG = object;
            object4 = hG.d;
        }
        if ((n2 & 8) != 0) {
            hG = object;
            object5 = hG.e;
        }
        if ((n2 & 0x10) != 0) {
            hG = object;
            hL = hG.f;
        }
        if ((n2 & 0x20) != 0) {
            hG = object;
            d2 = hG.g;
        }
        Integer n3 = object2;
        hb_0 hb_02 = object3;
        Integer n4 = object4;
        hb_0 hb_03 = object5;
        double d3 = d2;
        object5 = hL;
        object4 = hb_03;
        object3 = n4;
        object2 = hb_02;
        object = n3;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        return new HG((Integer)object, (hb_0)object2, (Integer)object3, (hb_0)object4, (HL)object5, d3);
    }

    public final String toString() {
        HG hG = this;
        HG hG2 = hG;
        HG hG3 = this;
        hG2 = hG3;
        HG hG4 = this;
        hG2 = hG4;
        HG hG5 = this;
        hG2 = hG5;
        HG hG6 = this;
        hG2 = hG6;
        hG2 = this;
        return "HG(f=" + hG.b + ", d=" + hG3.c + ", g=" + hG4.d + ", e=" + hG5.e + ", a=" + hG6.f + ", b=" + hG2.g + ')';
    }

    public final int hashCode() {
        int n2;
        int n3;
        int n4;
        HG hG = this;
        if (hG.b == null) {
            n4 = 0;
        } else {
            hG = this;
            n4 = ((Object)hG.b).hashCode();
        }
        int n5 = n4;
        HG hG2 = this;
        int n6 = n4 * 31 + hG2.c.hashCode();
        HG hG3 = this;
        if (hG3.d == null) {
            n3 = 0;
        } else {
            hG3 = this;
            n3 = ((Object)hG3.d).hashCode();
        }
        int n7 = n6 * 31 + n3;
        HG hG4 = this;
        int n8 = n7 * 31 + hG4.e.hashCode();
        HG hG5 = this;
        if (hG5.f == null) {
            n2 = 0;
        } else {
            hG5 = this;
            n2 = hG5.f.hashCode();
        }
        int n9 = n8 * 31 + n2;
        HG hG6 = this;
        int n10 = n9 * 31 + Double.hashCode(hG6.g);
        return n10;
    }

    public final boolean equals(Object other) {
        HG hG;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HG)) {
            return false;
        }
        hG = hG;
        HG hG2 = this;
        HG hG3 = hG2;
        hG3 = hG;
        if (!Intrinsics.areEqual((Object)hG2.b, (Object)hG3.b)) {
            return false;
        }
        HG hG4 = this;
        hG3 = hG4;
        hG3 = hG;
        if (!Intrinsics.areEqual((Object)hG4.c, (Object)hG3.c)) {
            return false;
        }
        HG hG5 = this;
        hG3 = hG5;
        hG3 = hG;
        if (!Intrinsics.areEqual((Object)hG5.d, (Object)hG3.d)) {
            return false;
        }
        HG hG6 = this;
        hG3 = hG6;
        hG3 = hG;
        if (!Intrinsics.areEqual((Object)hG6.e, (Object)hG3.e)) {
            return false;
        }
        HG hG7 = this;
        hG3 = hG7;
        hG3 = hG;
        if (!Intrinsics.areEqual((Object)hG7.f, (Object)hG3.f)) {
            return false;
        }
        HG hG8 = this;
        hG3 = hG8;
        hG3 = hG;
        return Intrinsics.areEqual((Object)hG8.g, (Object)hG3.g);
    }
}

