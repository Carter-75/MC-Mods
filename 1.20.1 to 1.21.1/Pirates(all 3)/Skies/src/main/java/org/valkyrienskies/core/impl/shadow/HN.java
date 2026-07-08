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

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001:\u0001FBq\u0012\u000e\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u000e\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\"\u001a\u00020\u0017\u00a2\u0006\u0004\bD\u0010EJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\n\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0082\u0001\u0010#\u001a\u00020\u00002\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00062\u0010\b\u0002\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\"\u001a\u00020\u0017H\u00c6\u0001\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%H\u00d6\u0003\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,H\u00d6\u0001\u00a2\u0006\u0004\b-\u0010.R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b0\u0010\rR\u001a\u0010\"\u001a\u00020\u00178\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b2\u0010\u0019R\u001a\u00104\u001a\u0002038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u0010!\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b!\u00108\u001a\u0004\b9\u0010\u0016R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010:\u001a\u0004\b;\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010<\u001a\u0004\b=\u0010\bR\u001a\u0010\u001d\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010<\u001a\u0004\b>\u0010\bR\"\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010?\u001a\u0004\b@\u0010\u0005R\"\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010?\u001a\u0004\bA\u0010\u0005R\u0019\u0010 \u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b \u0010B\u001a\u0004\bC\u0010\u0013\u00a8\u0006G"}, d2={"Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint;", "Lorg/valkyrienskies/physics_api/joints/JointData;", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "component1", "()Ljava/lang/Integer;", "Lorg/valkyrienskies/physics_api/Pose;", "component2", "()Lorg/valkyrienskies/physics_api/Pose;", "component3", "component4", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "component5", "()Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "component6", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "", "component7", "()Ljava/lang/Float;", "Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;", "component8", "()Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;", "", "component9", "()D", "physicsBodyId0", "localFrame0", "physicsBodyId1", "localFrame1", "breakForceTorque", "hinges", "ratio", "data", "compliance", "copy", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;Ljava/lang/Float;Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;D)Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "getBreakForceTorque", "D", "getCompliance", "Lorg/valkyrienskies/physics_api/joints/JointType;", "constraintType", "Lorg/valkyrienskies/physics_api/joints/JointType;", "getConstraintType", "()Lorg/valkyrienskies/physics_api/joints/JointType;", "Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;", "getData", "Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "getHinges", "Lorg/valkyrienskies/physics_api/Pose;", "getLocalFrame0", "getLocalFrame1", "Ljava/lang/Integer;", "getPhysicsBodyId0", "getPhysicsBodyId1", "Ljava/lang/Float;", "getRatio", "<init>", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;Ljava/lang/Float;Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;D)V", "Data", "physics_api"})
public final class HN
implements HJ {
    private final Integer e;
    private final hb_0 f;
    private final Integer g;
    private final hb_0 h;
    private final HL i;
    public final HE.h b;
    public final Float c;
    public final a d;
    private final double j;
    private final HK l;

    public HN(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.h h2, Float f2, a a2, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        this.e = n2;
        this.f = hb_02;
        this.g = n3;
        this.h = hb_03;
        this.i = hL;
        this.b = h2;
        this.c = f2;
        this.d = a2;
        this.j = d2;
        this.l = HK.RACK_AND_PINION;
    }

    public /* synthetic */ HN(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.h h2, Float f2, a a2, double d2, int n4, DefaultConstructorMarker defaultConstructorMarker) {
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
            a2 = null;
        }
        if ((n4 & 0x100) != 0) {
            d2 = 1.0E-10;
        }
        this(n2, hb_02, n3, hb_03, hL, h2, f2, a2, d2);
    }

    @Override
    @JvmName(name="a")
    public final Integer a() {
        return this.e;
    }

    @Override
    @JvmName(name="b")
    public final hb_0 b() {
        return this.f;
    }

    @Override
    @JvmName(name="c")
    public final Integer c() {
        return this.g;
    }

    @Override
    @JvmName(name="d")
    public final hb_0 d() {
        return this.h;
    }

    @Override
    @JvmName(name="e")
    public final HL e() {
        return this.i;
    }

    @JvmName(name="f")
    public final HE.h f() {
        return this.b;
    }

    @JvmName(name="g")
    public final Float g() {
        return this.c;
    }

    @JvmName(name="h")
    public final a h() {
        return this.d;
    }

    @Override
    @JvmName(name="o")
    public final double o() {
        return this.j;
    }

    @Override
    @JvmName(name="p")
    public final HK p() {
        return this.l;
    }

    private Integer i() {
        HN hN = this;
        return hN.e;
    }

    private hb_0 j() {
        HN hN = this;
        return hN.f;
    }

    private Integer k() {
        HN hN = this;
        return hN.g;
    }

    private hb_0 l() {
        HN hN = this;
        return hN.h;
    }

    private HL m() {
        HN hN = this;
        return hN.i;
    }

    private HE.h n() {
        return this.b;
    }

    private Float q() {
        return this.c;
    }

    private a r() {
        return this.d;
    }

    private double s() {
        HN hN = this;
        return hN.j;
    }

    private static HN a(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, HE.h h2, Float f2, a a2, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        return new HN(n2, hb_02, n3, hb_03, hL, h2, f2, a2, d2);
    }

    private static /* synthetic */ HN a$default(HN object, Integer object2, hb_0 object3, Integer object4, hb_0 object5, HL object6, HE.h object7, Float object8, a a2, double d2, int n2) {
        HN hN;
        if ((n2 & 1) != 0) {
            hN = object;
            object2 = hN.e;
        }
        if ((n2 & 2) != 0) {
            hN = object;
            object3 = hN.f;
        }
        if ((n2 & 4) != 0) {
            hN = object;
            object4 = hN.g;
        }
        if ((n2 & 8) != 0) {
            hN = object;
            object5 = hN.h;
        }
        if ((n2 & 0x10) != 0) {
            hN = object;
            object6 = hN.i;
        }
        if ((n2 & 0x20) != 0) {
            object7 = ((HN)object).b;
        }
        if ((n2 & 0x40) != 0) {
            object8 = ((HN)object).c;
        }
        if ((n2 & 0x80) != 0) {
            a2 = ((HN)object).d;
        }
        if ((n2 & 0x100) != 0) {
            hN = object;
            d2 = hN.j;
        }
        Integer n3 = object2;
        hb_0 hb_02 = object3;
        Integer n4 = object4;
        hb_0 hb_03 = object5;
        HL hL = object6;
        HE.h h2 = object7;
        Float f2 = object8;
        double d3 = d2;
        object8 = a2;
        object7 = f2;
        object6 = h2;
        object5 = hL;
        object4 = hb_03;
        object3 = n4;
        object2 = hb_02;
        object = n3;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        return new HN((Integer)object, (hb_0)object2, (Integer)object3, (hb_0)object4, (HL)object5, (HE.h)object6, (Float)object7, (a)object8, d3);
    }

    public final String toString() {
        HN hN = this;
        HN hN2 = hN;
        HN hN3 = this;
        hN2 = hN3;
        HN hN4 = this;
        hN2 = hN4;
        HN hN5 = this;
        hN2 = hN5;
        HN hN6 = this;
        hN2 = hN6;
        hN2 = this;
        return "HN(h=" + hN.e + ", f=" + hN3.f + ", i=" + hN4.g + ", g=" + hN5.h + ", a=" + hN6.i + ", e=" + this.b + ", j=" + this.c + ", d=" + this.d + ", b=" + hN2.j + ')';
    }

    public final int hashCode() {
        int n2;
        int n3;
        int n4;
        HN hN = this;
        if (hN.e == null) {
            n4 = 0;
        } else {
            hN = this;
            n4 = ((Object)hN.e).hashCode();
        }
        int n5 = n4;
        HN hN2 = this;
        int n6 = n4 * 31 + hN2.f.hashCode();
        HN hN3 = this;
        if (hN3.g == null) {
            n3 = 0;
        } else {
            hN3 = this;
            n3 = ((Object)hN3.g).hashCode();
        }
        int n7 = n6 * 31 + n3;
        HN hN4 = this;
        int n8 = n7 * 31 + hN4.h.hashCode();
        HN hN5 = this;
        if (hN5.i == null) {
            n2 = 0;
        } else {
            hN5 = this;
            n2 = hN5.i.hashCode();
        }
        int n9 = n8 * 31 + n2;
        n9 = n9 * 31 + (this.b == null ? 0 : this.b.hashCode());
        n9 = n9 * 31 + (this.c == null ? 0 : ((Object)this.c).hashCode());
        n9 = n9 * 31 + (this.d == null ? 0 : this.d.hashCode());
        HN hN6 = this;
        int n10 = n9 * 31 + Double.hashCode(hN6.j);
        return n10;
    }

    public final boolean equals(Object other) {
        HN hN;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HN)) {
            return false;
        }
        hN = hN;
        HN hN2 = this;
        HN hN3 = hN2;
        hN3 = hN;
        if (!Intrinsics.areEqual((Object)hN2.e, (Object)hN3.e)) {
            return false;
        }
        HN hN4 = this;
        hN3 = hN4;
        hN3 = hN;
        if (!Intrinsics.areEqual((Object)hN4.f, (Object)hN3.f)) {
            return false;
        }
        HN hN5 = this;
        hN3 = hN5;
        hN3 = hN;
        if (!Intrinsics.areEqual((Object)hN5.g, (Object)hN3.g)) {
            return false;
        }
        HN hN6 = this;
        hN3 = hN6;
        hN3 = hN;
        if (!Intrinsics.areEqual((Object)hN6.h, (Object)hN3.h)) {
            return false;
        }
        HN hN7 = this;
        hN3 = hN7;
        hN3 = hN;
        if (!Intrinsics.areEqual((Object)hN7.i, (Object)hN3.i)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)hN.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)hN.c)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.d, (Object)hN.d)) {
            return false;
        }
        HN hN8 = this;
        hN3 = hN8;
        hN3 = hN;
        return Intrinsics.areEqual((Object)hN8.j, (Object)hN3.j);
    }

    public static final class a {
        public final int a;
        public final int b;
        public final float c;

        public a(int n2, int n3, float f2) {
            this.a = n2;
            this.b = n3;
            this.c = f2;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final float c() {
            return this.c;
        }

        private int d() {
            return this.a;
        }

        private int e() {
            return this.b;
        }

        private float f() {
            return this.c;
        }

        private static a a(int n2, int n3, float f2) {
            return new a(n2, n3, f2);
        }

        private static /* synthetic */ a a(a a2, int n2, int n3, float f2, int n4) {
            if ((n4 & 1) != 0) {
                n2 = a2.a;
            }
            if ((n4 & 2) != 0) {
                n3 = a2.b;
            }
            if ((n4 & 4) != 0) {
                f2 = a2.c;
            }
            int n5 = n2;
            float f3 = f2;
            n2 = n3;
            int n6 = n5;
            return new a(n6, n2, f3);
        }

        public final String toString() {
            return "Data(rackTeeth=" + this.a + ", pinionTeeth=" + this.b + ", rackLength=" + this.c + ')';
        }

        public final int hashCode() {
            int n2 = Integer.hashCode(this.a);
            n2 = n2 * 31 + Integer.hashCode(this.b);
            n2 = n2 * 31 + Float.hashCode(this.c);
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
            if (this.a != a2.a) {
                return false;
            }
            if (this.b != a2.b) {
                return false;
            }
            return Intrinsics.areEqual((Object)Float.valueOf(this.c), (Object)Float.valueOf(a2.c));
        }
    }
}

