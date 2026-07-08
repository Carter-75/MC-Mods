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

import java.util.EnumMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3fc;
import org.valkyrienskies.core.impl.shadow.HJ;
import org.valkyrienskies.core.impl.shadow.HK;
import org.valkyrienskies.core.impl.shadow.HL;
import org.valkyrienskies.core.impl.shadow.hb_0;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b)\b\u0086\b\u0018\u00002\u00020\u0001:\fijklmnopqrstB\u00dd\u0001\u0012\u000e\u0010-\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010.\u001a\u00020\u001a\u0012\u000e\u0010/\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u00100\u001a\u00020\u001a\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001f\u0012\u0016\b\u0002\u00102\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010\f\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010%\u0012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020(\u0018\u00010\f\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010;\u001a\u00020\u0017\u00a2\u0006\u0004\bg\u0010hJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001d\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u001d\u0010\u0005J\u0010\u0010\u001e\u001a\u00020\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001cJ\u0012\u0010 \u001a\u0004\u0018\u00010\u001fH\u00c6\u0003\u00a2\u0006\u0004\b \u0010!J\u001e\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0004\b$\u0010\u0010J\u0012\u0010&\u001a\u0004\u0018\u00010%H\u00c6\u0003\u00a2\u0006\u0004\b&\u0010'J\u001e\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020(\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0004\b)\u0010\u0010J\u0012\u0010+\u001a\u0004\u0018\u00010*H\u00c6\u0003\u00a2\u0006\u0004\b+\u0010,J\u00ee\u0001\u0010<\u001a\u00020\u00002\u0010\b\u0002\u0010-\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010.\u001a\u00020\u001a2\u0010\b\u0002\u0010/\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u00100\u001a\u00020\u001a2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001f2\u0016\b\u0002\u00102\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010\f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010%2\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020(\u0018\u00010\f2\n\b\u0002\u00105\u001a\u0004\u0018\u00010*2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010;\u001a\u00020\u0017H\u00c6\u0001\u00a2\u0006\u0004\b<\u0010=J\u001a\u0010A\u001a\u00020@2\b\u0010?\u001a\u0004\u0018\u00010>H\u00d6\u0003\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010F\u001a\u00020EH\u00d6\u0001\u00a2\u0006\u0004\bF\u0010GR\u001c\u00101\u001a\u0004\u0018\u00010\u001f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b1\u0010H\u001a\u0004\bI\u0010!R\u001a\u0010;\u001a\u00020\u00178\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b;\u0010J\u001a\u0004\bK\u0010\u0019R\u001a\u0010M\u001a\u00020L8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0019\u00103\u001a\u0004\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b3\u0010Q\u001a\u0004\bR\u0010'R\u0019\u00109\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b9\u0010S\u001a\u0004\bT\u0010\u0013R\u0019\u0010:\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b:\u0010U\u001a\u0004\bV\u0010\u0016R%\u00108\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b8\u0010W\u001a\u0004\bX\u0010\u0010R%\u00104\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020(\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b4\u0010W\u001a\u0004\bY\u0010\u0010R\u001a\u0010.\u001a\u00020\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010Z\u001a\u0004\b[\u0010\u001cR\u001a\u00100\u001a\u00020\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b0\u0010Z\u001a\u0004\b\\\u0010\u001cR%\u00102\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b2\u0010W\u001a\u0004\b]\u0010\u0010R\"\u0010-\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b-\u0010^\u001a\u0004\b_\u0010\u0005R\"\u0010/\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b/\u0010^\u001a\u0004\b`\u0010\u0005R\u0019\u00107\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b7\u0010a\u001a\u0004\bb\u0010\u000bR\u0019\u00106\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b6\u0010c\u001a\u0004\bd\u0010\bR\u0019\u00105\u001a\u0004\u0018\u00010*8\u0006\u00a2\u0006\f\n\u0004\b5\u0010e\u001a\u0004\bf\u0010,\u00a8\u0006u"}, d2={"Lorg/valkyrienskies/physics_api/joints/D6Joint;", "Lorg/valkyrienskies/physics_api/joints/JointData;", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "component1", "()Ljava/lang/Integer;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "component10", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;", "component11", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;", "Ljava/util/EnumMap;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$D6Drive;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$D6JointDrive;", "component12", "()Ljava/util/EnumMap;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;", "component13", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;", "component14", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;", "", "component15", "()D", "Lorg/valkyrienskies/physics_api/Pose;", "component2", "()Lorg/valkyrienskies/physics_api/Pose;", "component3", "component4", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "component5", "()Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$D6Axis;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$D6Motion;", "component6", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;", "component7", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimitPair;", "component8", "Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "component9", "()Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "physicsBodyId0", "localFrame0", "physicsBodyId1", "localFrame1", "breakForceTorque", "motions", "distanceLimit", "linearLimits", "twistLimit", "swingLimit", "pyramidSwingLimit", "drives", "drivePosition", "driveVelocity", "compliance", "copy", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Ljava/util/EnumMap;Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;Ljava/util/EnumMap;Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;Ljava/util/EnumMap;Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;D)Lorg/valkyrienskies/physics_api/joints/D6Joint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "getBreakForceTorque", "D", "getCompliance", "Lorg/valkyrienskies/physics_api/joints/JointType;", "constraintType", "Lorg/valkyrienskies/physics_api/joints/JointType;", "getConstraintType", "()Lorg/valkyrienskies/physics_api/joints/JointType;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;", "getDistanceLimit", "Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;", "getDrivePosition", "Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;", "getDriveVelocity", "Ljava/util/EnumMap;", "getDrives", "getLinearLimits", "Lorg/valkyrienskies/physics_api/Pose;", "getLocalFrame0", "getLocalFrame1", "getMotions", "Ljava/lang/Integer;", "getPhysicsBodyId0", "getPhysicsBodyId1", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;", "getPyramidSwingLimit", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "getSwingLimit", "Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "getTwistLimit", "<init>", "(Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Ljava/lang/Integer;Lorg/valkyrienskies/physics_api/Pose;Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;Ljava/util/EnumMap;Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;Ljava/util/EnumMap;Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;Ljava/util/EnumMap;Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;D)V", "AngularLimitPair", "D6Axis", "D6Drive", "D6JointDrive", "D6Motion", "DrivePosition", "DriveVelocity", "Hinges", "LimitCone", "LimitPyramid", "LinearLimit", "LinearLimitPair", "physics_api"})
public final class HE
implements HJ {
    private final Integer l;
    private final hb_0 m;
    private final Integer n;
    private final hb_0 o;
    private final HL p;
    public final EnumMap<b, e> b;
    public final k c;
    public final EnumMap<b, l> d;
    public final a e;
    public final i f;
    public final j g;
    public final EnumMap<c, d> h;
    public final f i;
    public final g j;
    private final double q;
    private final HK r;

    public HE(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, EnumMap<b, e> enumMap, k k2, EnumMap<b, l> enumMap2, a a2, i i2, j j2, EnumMap<c, d> enumMap3, f f2, g g2, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        this.l = n2;
        this.m = hb_02;
        this.n = n3;
        this.o = hb_03;
        this.p = hL;
        this.b = enumMap;
        this.c = k2;
        this.d = enumMap2;
        this.e = a2;
        this.f = i2;
        this.g = j2;
        this.h = enumMap3;
        this.i = f2;
        this.j = g2;
        this.q = d2;
        this.r = HK.D6;
    }

    public /* synthetic */ HE(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, EnumMap enumMap, k k2, EnumMap enumMap2, a a2, i i2, j j2, EnumMap enumMap3, f f2, g g2, double d2, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 0x10) != 0) {
            hL = null;
        }
        if ((n4 & 0x20) != 0) {
            enumMap = null;
        }
        if ((n4 & 0x40) != 0) {
            k2 = null;
        }
        if ((n4 & 0x80) != 0) {
            enumMap2 = null;
        }
        if ((n4 & 0x100) != 0) {
            a2 = null;
        }
        if ((n4 & 0x200) != 0) {
            i2 = null;
        }
        if ((n4 & 0x400) != 0) {
            j2 = null;
        }
        if ((n4 & 0x800) != 0) {
            enumMap3 = null;
        }
        if ((n4 & 0x1000) != 0) {
            f2 = null;
        }
        if ((n4 & 0x2000) != 0) {
            g2 = null;
        }
        if ((n4 & 0x4000) != 0) {
            d2 = 1.0E-10;
        }
        this(n2, hb_02, n3, hb_03, hL, enumMap, k2, enumMap2, a2, i2, j2, enumMap3, f2, g2, d2);
    }

    @Override
    @JvmName(name="a")
    public final Integer a() {
        return this.l;
    }

    @Override
    @JvmName(name="b")
    public final hb_0 b() {
        return this.m;
    }

    @Override
    @JvmName(name="c")
    public final Integer c() {
        return this.n;
    }

    @Override
    @JvmName(name="d")
    public final hb_0 d() {
        return this.o;
    }

    @Override
    @JvmName(name="e")
    public final HL e() {
        return this.p;
    }

    @JvmName(name="f")
    public final EnumMap<b, e> f() {
        return this.b;
    }

    @JvmName(name="g")
    public final k g() {
        return this.c;
    }

    @JvmName(name="h")
    public final EnumMap<b, l> h() {
        return this.d;
    }

    @JvmName(name="i")
    public final a i() {
        return this.e;
    }

    @JvmName(name="j")
    public final i j() {
        return this.f;
    }

    @JvmName(name="k")
    public final j k() {
        return this.g;
    }

    @JvmName(name="l")
    public final EnumMap<c, d> l() {
        return this.h;
    }

    @JvmName(name="m")
    public final f m() {
        return this.i;
    }

    @JvmName(name="n")
    public final g n() {
        return this.j;
    }

    @Override
    @JvmName(name="o")
    public final double o() {
        return this.q;
    }

    @Override
    @JvmName(name="p")
    public final HK p() {
        return this.r;
    }

    private Integer q() {
        HE hE = this;
        return hE.l;
    }

    private hb_0 r() {
        HE hE = this;
        return hE.m;
    }

    private Integer s() {
        HE hE = this;
        return hE.n;
    }

    private hb_0 t() {
        HE hE = this;
        return hE.o;
    }

    private HL u() {
        HE hE = this;
        return hE.p;
    }

    private EnumMap<b, e> v() {
        return this.b;
    }

    private k w() {
        return this.c;
    }

    private EnumMap<b, l> x() {
        return this.d;
    }

    private a y() {
        return this.e;
    }

    private i z() {
        return this.f;
    }

    private j A() {
        return this.g;
    }

    private EnumMap<c, d> B() {
        return this.h;
    }

    private f C() {
        return this.i;
    }

    private g D() {
        return this.j;
    }

    private double E() {
        HE hE = this;
        return hE.q;
    }

    private static HE a(Integer n2, hb_0 hb_02, Integer n3, hb_0 hb_03, HL hL, EnumMap<b, e> enumMap, k k2, EnumMap<b, l> enumMap2, a a2, i i2, j j2, EnumMap<c, d> enumMap3, f f2, g g2, double d2) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hb_03, (String)"");
        return new HE(n2, hb_02, n3, hb_03, hL, enumMap, k2, enumMap2, a2, i2, j2, enumMap3, f2, g2, d2);
    }

    private static /* synthetic */ HE a$default(HE object, Integer object2, hb_0 object3, Integer object4, hb_0 object5, HL object6, EnumMap object7, k object8, EnumMap object9, a object10, i object11, j object12, EnumMap object13, f object14, g g2, double d2, int n2) {
        HE hE;
        if ((n2 & 1) != 0) {
            hE = object;
            object2 = hE.l;
        }
        if ((n2 & 2) != 0) {
            hE = object;
            object3 = hE.m;
        }
        if ((n2 & 4) != 0) {
            hE = object;
            object4 = hE.n;
        }
        if ((n2 & 8) != 0) {
            hE = object;
            object5 = hE.o;
        }
        if ((n2 & 0x10) != 0) {
            hE = object;
            object6 = hE.p;
        }
        if ((n2 & 0x20) != 0) {
            object7 = ((HE)object).b;
        }
        if ((n2 & 0x40) != 0) {
            object8 = ((HE)object).c;
        }
        if ((n2 & 0x80) != 0) {
            object9 = ((HE)object).d;
        }
        if ((n2 & 0x100) != 0) {
            object10 = ((HE)object).e;
        }
        if ((n2 & 0x200) != 0) {
            object11 = ((HE)object).f;
        }
        if ((n2 & 0x400) != 0) {
            object12 = ((HE)object).g;
        }
        if ((n2 & 0x800) != 0) {
            object13 = ((HE)object).h;
        }
        if ((n2 & 0x1000) != 0) {
            object14 = ((HE)object).i;
        }
        if ((n2 & 0x2000) != 0) {
            g2 = ((HE)object).j;
        }
        if ((n2 & 0x4000) != 0) {
            hE = object;
            d2 = hE.q;
        }
        Integer n3 = object2;
        hb_0 hb_02 = object3;
        Integer n4 = object4;
        hb_0 hb_03 = object5;
        HL hL = object6;
        EnumMap<b, e> enumMap = object7;
        k k2 = object8;
        EnumMap<b, l> enumMap2 = object9;
        a a2 = object10;
        i i2 = object11;
        j j2 = object12;
        EnumMap<c, d> enumMap3 = object13;
        f f2 = object14;
        double d3 = d2;
        object14 = g2;
        object13 = f2;
        object12 = enumMap3;
        object11 = j2;
        object10 = i2;
        object9 = a2;
        object8 = enumMap2;
        object7 = k2;
        object6 = enumMap;
        object5 = hL;
        object4 = hb_03;
        object3 = n4;
        object2 = hb_02;
        object = n3;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        return new HE((Integer)object, (hb_0)object2, (Integer)object3, (hb_0)object4, (HL)object5, (EnumMap<b, e>)object6, (k)object7, (EnumMap<b, l>)object8, (a)object9, (i)object10, (j)object11, (EnumMap<c, d>)object12, (f)object13, (g)object14, d3);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        HE hE = this;
        HE hE2 = hE;
        HE hE3 = this;
        hE2 = hE3;
        HE hE4 = this;
        hE2 = hE4;
        HE hE5 = this;
        hE2 = hE5;
        hE2 = this;
        stringBuilder.append("HE(l=").append(hE.l).append(", i=").append(hE3.m).append(", m=").append(hE4.n).append(", j=").append(hE5.o).append(", a=").append(hE2.p).append(", k=").append(this.b).append(", d=").append(this.c).append(", h=").append(this.d).append(", p=").append(this.e).append(", o=").append(this.f).append(", n=").append(this.g).append(", g=");
        hE2 = this;
        stringBuilder.append(this.h).append(", e=").append(this.i).append(", f=").append(this.j).append(", b=").append(hE2.q).append(')');
        return stringBuilder.toString();
    }

    public final int hashCode() {
        int n2;
        int n3;
        int n4;
        HE hE = this;
        if (hE.l == null) {
            n4 = 0;
        } else {
            hE = this;
            n4 = ((Object)hE.l).hashCode();
        }
        int n5 = n4;
        HE hE2 = this;
        int n6 = n4 * 31 + hE2.m.hashCode();
        HE hE3 = this;
        if (hE3.n == null) {
            n3 = 0;
        } else {
            hE3 = this;
            n3 = ((Object)hE3.n).hashCode();
        }
        int n7 = n6 * 31 + n3;
        HE hE4 = this;
        int n8 = n7 * 31 + hE4.o.hashCode();
        HE hE5 = this;
        if (hE5.p == null) {
            n2 = 0;
        } else {
            hE5 = this;
            n2 = hE5.p.hashCode();
        }
        int n9 = n8 * 31 + n2;
        n9 = n9 * 31 + (this.b == null ? 0 : this.b.hashCode());
        n9 = n9 * 31 + (this.c == null ? 0 : this.c.hashCode());
        n9 = n9 * 31 + (this.d == null ? 0 : this.d.hashCode());
        n9 = n9 * 31 + (this.e == null ? 0 : this.e.hashCode());
        n9 = n9 * 31 + (this.f == null ? 0 : this.f.hashCode());
        n9 = n9 * 31 + (this.g == null ? 0 : this.g.hashCode());
        n9 = n9 * 31 + (this.h == null ? 0 : this.h.hashCode());
        n9 = n9 * 31 + (this.i == null ? 0 : this.i.hashCode());
        n9 = n9 * 31 + (this.j == null ? 0 : this.j.hashCode());
        HE hE6 = this;
        int n10 = n9 * 31 + Double.hashCode(hE6.q);
        return n10;
    }

    public final boolean equals(Object other) {
        HE hE;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HE)) {
            return false;
        }
        hE = hE;
        HE hE2 = this;
        HE hE3 = hE2;
        hE3 = hE;
        if (!Intrinsics.areEqual((Object)hE2.l, (Object)hE3.l)) {
            return false;
        }
        HE hE4 = this;
        hE3 = hE4;
        hE3 = hE;
        if (!Intrinsics.areEqual((Object)hE4.m, (Object)hE3.m)) {
            return false;
        }
        HE hE5 = this;
        hE3 = hE5;
        hE3 = hE;
        if (!Intrinsics.areEqual((Object)hE5.n, (Object)hE3.n)) {
            return false;
        }
        HE hE6 = this;
        hE3 = hE6;
        hE3 = hE;
        if (!Intrinsics.areEqual((Object)hE6.o, (Object)hE3.o)) {
            return false;
        }
        HE hE7 = this;
        hE3 = hE7;
        hE3 = hE;
        if (!Intrinsics.areEqual((Object)hE7.p, (Object)hE3.p)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.b, hE.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)hE.c)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.d, hE.d)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.e, (Object)hE.e)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.f, (Object)hE.f)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.g, (Object)hE.g)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.h, hE.h)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.i, (Object)hE.i)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.j, (Object)hE.j)) {
            return false;
        }
        HE hE8 = this;
        hE3 = hE8;
        hE3 = hE;
        return Intrinsics.areEqual((Object)hE8.q, (Object)hE3.q);
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$b;", "", "<init>", "(Ljava/lang/String;I)V", "X", "Y", "Z", "TWIST", "SWING1", "SWING2"})
    public static final class b
    extends Enum<b> {
        public static final /* enum */ b X = new b();
        public static final /* enum */ b Y = new b();
        public static final /* enum */ b Z = new b();
        public static final /* enum */ b TWIST = new b();
        public static final /* enum */ b SWING1 = new b();
        public static final /* enum */ b SWING2 = new b();
        private static final /* synthetic */ b[] $VALUES;

        public static b[] values() {
            return (b[])$VALUES.clone();
        }

        public static b valueOf(String value) {
            String string;
            return Enum.valueOf(b.class, string);
        }

        private static final /* synthetic */ b[] a() {
            b[] bArray = new b[6];
            b[] bArray2 = bArray;
            bArray[0] = X;
            bArray2[1] = Y;
            bArray2[2] = Z;
            bArray2[3] = TWIST;
            bArray2[4] = SWING1;
            bArray2[5] = SWING2;
            return bArray2;
        }

        static {
            b[] bArray = new b[6];
            b[] bArray2 = bArray;
            bArray[0] = X;
            bArray2[1] = Y;
            bArray2[2] = Z;
            bArray2[3] = TWIST;
            bArray2[4] = SWING1;
            bArray2[5] = SWING2;
            $VALUES = bArray2;
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$e;", "", "<init>", "(Ljava/lang/String;I)V", "LOCKED", "LIMITED", "FREE"})
    public static final class e
    extends Enum<e> {
        public static final /* enum */ e LOCKED = new e();
        public static final /* enum */ e LIMITED = new e();
        public static final /* enum */ e FREE = new e();
        private static final /* synthetic */ e[] $VALUES;

        public static e[] values() {
            return (e[])$VALUES.clone();
        }

        public static e valueOf(String value) {
            String string;
            return Enum.valueOf(e.class, string);
        }

        private static final /* synthetic */ e[] a() {
            e[] eArray = new e[3];
            e[] eArray2 = eArray;
            eArray[0] = LOCKED;
            eArray2[1] = LIMITED;
            eArray2[2] = FREE;
            return eArray2;
        }

        static {
            e[] eArray = new e[3];
            e[] eArray2 = eArray;
            eArray[0] = LOCKED;
            eArray2[1] = LIMITED;
            eArray2[2] = FREE;
            $VALUES = eArray2;
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\u0006J2\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0006R\u0017\u0010\u0019\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000b\u0010\u0004R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0019\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$k;", "", "", "d", "()F", "e", "()Ljava/lang/Float;", "f", "p0", "p1", "p2", "a", "(FLjava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/impl/shadow/HE$k;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "c", "Ljava/lang/Float;", "F", "b", "<init>", "(FLjava/lang/Float;Ljava/lang/Float;)V"})
    public static final class k {
        public final float a;
        public final Float b;
        public final Float c;

        public k(float f2, Float f3, Float f4) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
        }

        public /* synthetic */ k(float f2, Float f3, Float f4, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                f3 = null;
            }
            if ((n2 & 4) != 0) {
                f4 = null;
            }
            this(f2, f3, f4);
        }

        @JvmName(name="a")
        public final float a() {
            return this.a;
        }

        @JvmName(name="b")
        public final Float b() {
            return this.b;
        }

        @JvmName(name="c")
        public final Float c() {
            return this.c;
        }

        private float d() {
            return this.a;
        }

        private Float e() {
            return this.b;
        }

        private Float f() {
            return this.c;
        }

        private static k a(float f2, Float f3, Float f4) {
            return new k(f2, f3, f4);
        }

        private static /* synthetic */ k a$default(k k2, float f2, Float f3, Float f4, int n2) {
            if ((n2 & 1) != 0) {
                f2 = k2.a;
            }
            if ((n2 & 2) != 0) {
                f3 = k2.b;
            }
            if ((n2 & 4) != 0) {
                f4 = k2.c;
            }
            Float f5 = f3;
            f3 = f4;
            Float f6 = f5;
            float f7 = f2;
            return new k(f7, f6, f3);
        }

        public final String toString() {
            return "k(b=" + this.a + ", c=" + this.b + ", a=" + this.c + ')';
        }

        public final int hashCode() {
            int n2 = Float.hashCode(this.a);
            n2 = n2 * 31 + (this.b == null ? 0 : ((Object)this.b).hashCode());
            n2 = n2 * 31 + (this.c == null ? 0 : ((Object)this.c).hashCode());
            return n2;
        }

        public final boolean equals(Object other) {
            k k2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof k)) {
                return false;
            }
            k2 = k2;
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.a), (Object)Float.valueOf(k2.a))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.b, (Object)k2.b)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.c, (Object)k2.c);
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u0007JT\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0017\u0010!\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\u0011\u0010\u0004R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b!\u0010\u0007R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u0017\u0010\u001e\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$l;", "", "", "g", "()F", "h", "i", "()Ljava/lang/Float;", "j", "k", "l", "p0", "p1", "p2", "p3", "p4", "p5", "a", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/impl/shadow/HE$l;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "d", "Ljava/lang/Float;", "f", "b", "F", "c", "e", "<init>", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V"})
    public static final class l {
        public final float a;
        public final float b;
        public final Float c;
        public final Float d;
        public final Float e;
        public final Float f;

        public l(float f2, float f3, Float f4, Float f5, Float f6, Float f7) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
            this.e = f6;
            this.f = f7;
        }

        public /* synthetic */ l(float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                f4 = null;
            }
            if ((n2 & 8) != 0) {
                f5 = null;
            }
            if ((n2 & 0x10) != 0) {
                f6 = null;
            }
            if ((n2 & 0x20) != 0) {
                f7 = null;
            }
            this(f2, f3, f4, f5, f6, f7);
        }

        @JvmName(name="a")
        public final float a() {
            return this.a;
        }

        @JvmName(name="b")
        public final float b() {
            return this.b;
        }

        @JvmName(name="c")
        public final Float c() {
            return this.c;
        }

        @JvmName(name="d")
        public final Float d() {
            return this.d;
        }

        @JvmName(name="e")
        public final Float e() {
            return this.e;
        }

        @JvmName(name="f")
        public final Float f() {
            return this.f;
        }

        private float g() {
            return this.a;
        }

        private float h() {
            return this.b;
        }

        private Float i() {
            return this.c;
        }

        private Float j() {
            return this.d;
        }

        private Float k() {
            return this.e;
        }

        private Float l() {
            return this.f;
        }

        private static l a(float f2, float f3, Float f4, Float f5, Float f6, Float f7) {
            return new l(f2, f3, f4, f5, f6, f7);
        }

        private static /* synthetic */ l a$default(l l2, float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2) {
            if ((n2 & 1) != 0) {
                f2 = l2.a;
            }
            if ((n2 & 2) != 0) {
                f3 = l2.b;
            }
            if ((n2 & 4) != 0) {
                f4 = l2.c;
            }
            if ((n2 & 8) != 0) {
                f5 = l2.d;
            }
            if ((n2 & 0x10) != 0) {
                f6 = l2.e;
            }
            if ((n2 & 0x20) != 0) {
                f7 = l2.f;
            }
            float f8 = f2;
            Float f9 = f4;
            Float f10 = f5;
            Float f11 = f6;
            f6 = f7;
            f5 = f11;
            f4 = f10;
            Float f12 = f9;
            f2 = f3;
            float f13 = f8;
            return new l(f13, f2, f12, f4, f5, f6);
        }

        public final String toString() {
            return "l(c=" + this.a + ", f=" + this.b + ", d=" + this.c + ", a=" + this.d + ", e=" + this.e + ", b=" + this.f + ')';
        }

        public final int hashCode() {
            int n2 = Float.hashCode(this.a);
            n2 = n2 * 31 + Float.hashCode(this.b);
            n2 = n2 * 31 + (this.c == null ? 0 : ((Object)this.c).hashCode());
            n2 = n2 * 31 + (this.d == null ? 0 : ((Object)this.d).hashCode());
            n2 = n2 * 31 + (this.e == null ? 0 : ((Object)this.e).hashCode());
            n2 = n2 * 31 + (this.f == null ? 0 : ((Object)this.f).hashCode());
            return n2;
        }

        public final boolean equals(Object other) {
            l l2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof l)) {
                return false;
            }
            l2 = l2;
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.a), (Object)Float.valueOf(l2.a))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.b), (Object)Float.valueOf(l2.b))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.c, (Object)l2.c)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.d, (Object)l2.d)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.e, (Object)l2.e)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.f, (Object)l2.f);
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u0007JT\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0017\u0010!\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\u0011\u0010\u0004R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b!\u0010\u0007R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u0017\u0010\u001e\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$a;", "", "", "g", "()F", "h", "i", "()Ljava/lang/Float;", "j", "k", "l", "p0", "p1", "p2", "p3", "p4", "p5", "a", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/impl/shadow/HE$a;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "d", "Ljava/lang/Float;", "f", "b", "F", "c", "e", "<init>", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V"})
    public static final class a {
        public final float a;
        public final float b;
        public final Float c;
        public final Float d;
        public final Float e;
        public final Float f;

        public a(float f2, float f3, Float f4, Float f5, Float f6, Float f7) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
            this.e = f6;
            this.f = f7;
        }

        public /* synthetic */ a(float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                f4 = null;
            }
            if ((n2 & 8) != 0) {
                f5 = null;
            }
            if ((n2 & 0x10) != 0) {
                f6 = null;
            }
            if ((n2 & 0x20) != 0) {
                f7 = null;
            }
            this(f2, f3, f4, f5, f6, f7);
        }

        @JvmName(name="a")
        public final float a() {
            return this.a;
        }

        @JvmName(name="b")
        public final float b() {
            return this.b;
        }

        @JvmName(name="c")
        public final Float c() {
            return this.c;
        }

        @JvmName(name="d")
        public final Float d() {
            return this.d;
        }

        @JvmName(name="e")
        public final Float e() {
            return this.e;
        }

        @JvmName(name="f")
        public final Float f() {
            return this.f;
        }

        private float g() {
            return this.a;
        }

        private float h() {
            return this.b;
        }

        private Float i() {
            return this.c;
        }

        private Float j() {
            return this.d;
        }

        private Float k() {
            return this.e;
        }

        private Float l() {
            return this.f;
        }

        private static a a(float f2, float f3, Float f4, Float f5, Float f6, Float f7) {
            return new a(f2, f3, f4, f5, f6, f7);
        }

        private static /* synthetic */ a a$default(a a2, float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2) {
            if ((n2 & 1) != 0) {
                f2 = a2.a;
            }
            if ((n2 & 2) != 0) {
                f3 = a2.b;
            }
            if ((n2 & 4) != 0) {
                f4 = a2.c;
            }
            if ((n2 & 8) != 0) {
                f5 = a2.d;
            }
            if ((n2 & 0x10) != 0) {
                f6 = a2.e;
            }
            if ((n2 & 0x20) != 0) {
                f7 = a2.f;
            }
            float f8 = f2;
            Float f9 = f4;
            Float f10 = f5;
            Float f11 = f6;
            f6 = f7;
            f5 = f11;
            f4 = f10;
            Float f12 = f9;
            f2 = f3;
            float f13 = f8;
            return new a(f13, f2, f12, f4, f5, f6);
        }

        public final String toString() {
            return "a(c=" + this.a + ", f=" + this.b + ", d=" + this.c + ", a=" + this.d + ", e=" + this.e + ", b=" + this.f + ')';
        }

        public final int hashCode() {
            int n2 = Float.hashCode(this.a);
            n2 = n2 * 31 + Float.hashCode(this.b);
            n2 = n2 * 31 + (this.c == null ? 0 : ((Object)this.c).hashCode());
            n2 = n2 * 31 + (this.d == null ? 0 : ((Object)this.d).hashCode());
            n2 = n2 * 31 + (this.e == null ? 0 : ((Object)this.e).hashCode());
            n2 = n2 * 31 + (this.f == null ? 0 : ((Object)this.f).hashCode());
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
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.b), (Object)Float.valueOf(a2.b))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.c, (Object)a2.c)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.d, (Object)a2.d)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.e, (Object)a2.e)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.f, (Object)a2.f);
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u0007JT\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010 \u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b \u0010\u0007R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b!\u0010\u0007R\u0017\u0010!\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b\u0011\u0010\u0004R\u0017\u0010\u001e\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001f\u0010\"\u001a\u0004\b\u001f\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$i;", "", "", "g", "()F", "h", "i", "()Ljava/lang/Float;", "j", "k", "l", "p0", "p1", "p2", "p3", "p4", "p5", "a", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/impl/shadow/HE$i;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "d", "Ljava/lang/Float;", "f", "b", "c", "e", "F", "<init>", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V"})
    public static final class i {
        public final float a;
        public final float b;
        public final Float c;
        public final Float d;
        public final Float e;
        public final Float f;

        public i(float f2, float f3, Float f4, Float f5, Float f6, Float f7) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
            this.e = f6;
            this.f = f7;
        }

        public /* synthetic */ i(float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                f4 = null;
            }
            if ((n2 & 8) != 0) {
                f5 = null;
            }
            if ((n2 & 0x10) != 0) {
                f6 = null;
            }
            if ((n2 & 0x20) != 0) {
                f7 = null;
            }
            this(f2, f3, f4, f5, f6, f7);
        }

        @JvmName(name="a")
        public final float a() {
            return this.a;
        }

        @JvmName(name="b")
        public final float b() {
            return this.b;
        }

        @JvmName(name="c")
        public final Float c() {
            return this.c;
        }

        @JvmName(name="d")
        public final Float d() {
            return this.d;
        }

        @JvmName(name="e")
        public final Float e() {
            return this.e;
        }

        @JvmName(name="f")
        public final Float f() {
            return this.f;
        }

        private float g() {
            return this.a;
        }

        private float h() {
            return this.b;
        }

        private Float i() {
            return this.c;
        }

        private Float j() {
            return this.d;
        }

        private Float k() {
            return this.e;
        }

        private Float l() {
            return this.f;
        }

        private static i a(float f2, float f3, Float f4, Float f5, Float f6, Float f7) {
            return new i(f2, f3, f4, f5, f6, f7);
        }

        private static /* synthetic */ i a$default(i i2, float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2) {
            if ((n2 & 1) != 0) {
                f2 = i2.a;
            }
            if ((n2 & 2) != 0) {
                f3 = i2.b;
            }
            if ((n2 & 4) != 0) {
                f4 = i2.c;
            }
            if ((n2 & 8) != 0) {
                f5 = i2.d;
            }
            if ((n2 & 0x10) != 0) {
                f6 = i2.e;
            }
            if ((n2 & 0x20) != 0) {
                f7 = i2.f;
            }
            float f8 = f2;
            Float f9 = f4;
            Float f10 = f5;
            Float f11 = f6;
            f6 = f7;
            f5 = f11;
            f4 = f10;
            Float f12 = f9;
            f2 = f3;
            float f13 = f8;
            return new i(f13, f2, f12, f4, f5, f6);
        }

        public final String toString() {
            return "i(e=" + this.a + ", f=" + this.b + ", c=" + this.c + ", a=" + this.d + ", d=" + this.e + ", b=" + this.f + ')';
        }

        public final int hashCode() {
            int n2 = Float.hashCode(this.a);
            n2 = n2 * 31 + Float.hashCode(this.b);
            n2 = n2 * 31 + (this.c == null ? 0 : ((Object)this.c).hashCode());
            n2 = n2 * 31 + (this.d == null ? 0 : ((Object)this.d).hashCode());
            n2 = n2 * 31 + (this.e == null ? 0 : ((Object)this.e).hashCode());
            n2 = n2 * 31 + (this.f == null ? 0 : ((Object)this.f).hashCode());
            return n2;
        }

        public final boolean equals(Object other) {
            i i2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof i)) {
                return false;
            }
            i2 = i2;
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.a), (Object)Float.valueOf(i2.a))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.b), (Object)Float.valueOf(i2.b))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.c, (Object)i2.c)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.d, (Object)i2.d)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.e, (Object)i2.e)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.f, (Object)i2.f);
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\tJh\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH\u00d6\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\tR\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b\"\u0010!\u001a\u0004\b\"\u0010\tR\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b$\u0010\tR\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0007\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b&\u0010\tR\u0017\u0010$\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b#\u0010(\u001a\u0004\b#\u0010\u0004R\u0017\u0010 \u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b\u0015\u0010\u0004R\u0017\u0010&\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010\u0004R\u0017\u0010\"\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b%\u0010(\u001a\u0004\b%\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$j;", "", "", "i", "()F", "j", "k", "l", "m", "()Ljava/lang/Float;", "n", "o", "p", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "a", "(FFFFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/impl/shadow/HE$j;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "f", "Ljava/lang/Float;", "h", "b", "e", "c", "g", "d", "F", "<init>", "(FFFFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V"})
    public static final class j {
        public final float a;
        public final float b;
        public final float c;
        public final float d;
        public final Float e;
        public final Float f;
        public final Float g;
        public final Float h;

        public j(float f2, float f3, float f4, float f5, Float f6, Float f7, Float f8, Float f9) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
            this.e = f6;
            this.f = f7;
            this.g = f8;
            this.h = f9;
        }

        public /* synthetic */ j(float f2, float f3, float f4, float f5, Float f6, Float f7, Float f8, Float f9, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 0x10) != 0) {
                f6 = null;
            }
            if ((n2 & 0x20) != 0) {
                f7 = null;
            }
            if ((n2 & 0x40) != 0) {
                f8 = null;
            }
            if ((n2 & 0x80) != 0) {
                f9 = null;
            }
            this(f2, f3, f4, f5, f6, f7, f8, f9);
        }

        @JvmName(name="a")
        public final float a() {
            return this.a;
        }

        @JvmName(name="b")
        public final float b() {
            return this.b;
        }

        @JvmName(name="c")
        public final float c() {
            return this.c;
        }

        @JvmName(name="d")
        public final float d() {
            return this.d;
        }

        @JvmName(name="e")
        public final Float e() {
            return this.e;
        }

        @JvmName(name="f")
        public final Float f() {
            return this.f;
        }

        @JvmName(name="g")
        public final Float g() {
            return this.g;
        }

        @JvmName(name="h")
        public final Float h() {
            return this.h;
        }

        private float i() {
            return this.a;
        }

        private float j() {
            return this.b;
        }

        private float k() {
            return this.c;
        }

        private float l() {
            return this.d;
        }

        private Float m() {
            return this.e;
        }

        private Float n() {
            return this.f;
        }

        private Float o() {
            return this.g;
        }

        private Float p() {
            return this.h;
        }

        private static j a(float f2, float f3, float f4, float f5, Float f6, Float f7, Float f8, Float f9) {
            return new j(f2, f3, f4, f5, f6, f7, f8, f9);
        }

        private static /* synthetic */ j a$default(j j2, float f2, float f3, float f4, float f5, Float f6, Float f7, Float f8, Float f9, int n2) {
            if ((n2 & 1) != 0) {
                f2 = j2.a;
            }
            if ((n2 & 2) != 0) {
                f3 = j2.b;
            }
            if ((n2 & 4) != 0) {
                f4 = j2.c;
            }
            if ((n2 & 8) != 0) {
                f5 = j2.d;
            }
            if ((n2 & 0x10) != 0) {
                f6 = j2.e;
            }
            if ((n2 & 0x20) != 0) {
                f7 = j2.f;
            }
            if ((n2 & 0x40) != 0) {
                f8 = j2.g;
            }
            if ((n2 & 0x80) != 0) {
                f9 = j2.h;
            }
            float f10 = f2;
            float f11 = f3;
            float f12 = f4;
            Float f13 = f6;
            Float f14 = f7;
            Float f15 = f8;
            f8 = f9;
            f7 = f15;
            f6 = f14;
            Float f16 = f13;
            f4 = f5;
            f3 = f12;
            f2 = f11;
            float f17 = f10;
            return new j(f17, f2, f3, f4, f16, f6, f7, f8);
        }

        public final String toString() {
            return "j(f=" + this.a + ", e=" + this.b + ", h=" + this.c + ", g=" + this.d + ", c=" + this.e + ", a=" + this.f + ", d=" + this.g + ", b=" + this.h + ')';
        }

        public final int hashCode() {
            int n2 = Float.hashCode(this.a);
            n2 = n2 * 31 + Float.hashCode(this.b);
            n2 = n2 * 31 + Float.hashCode(this.c);
            n2 = n2 * 31 + Float.hashCode(this.d);
            n2 = n2 * 31 + (this.e == null ? 0 : ((Object)this.e).hashCode());
            n2 = n2 * 31 + (this.f == null ? 0 : ((Object)this.f).hashCode());
            n2 = n2 * 31 + (this.g == null ? 0 : ((Object)this.g).hashCode());
            n2 = n2 * 31 + (this.h == null ? 0 : ((Object)this.h).hashCode());
            return n2;
        }

        public final boolean equals(Object other) {
            j j2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof j)) {
                return false;
            }
            j2 = j2;
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.a), (Object)Float.valueOf(j2.a))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.b), (Object)Float.valueOf(j2.b))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.c), (Object)Float.valueOf(j2.c))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.d), (Object)Float.valueOf(j2.d))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.e, (Object)j2.e)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.f, (Object)j2.f)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.g, (Object)j2.g)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.h, (Object)j2.h);
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$c;", "", "<init>", "(Ljava/lang/String;I)V", "X", "Y", "Z", "SWING", "TWIST", "SLERP"})
    public static final class c
    extends Enum<c> {
        public static final /* enum */ c X = new c();
        public static final /* enum */ c Y = new c();
        public static final /* enum */ c Z = new c();
        public static final /* enum */ c SWING = new c();
        public static final /* enum */ c TWIST = new c();
        public static final /* enum */ c SLERP = new c();
        private static final /* synthetic */ c[] $VALUES;

        public static c[] values() {
            return (c[])$VALUES.clone();
        }

        public static c valueOf(String value) {
            String string;
            return Enum.valueOf(c.class, string);
        }

        private static final /* synthetic */ c[] a() {
            c[] cArray = new c[6];
            c[] cArray2 = cArray;
            cArray[0] = X;
            cArray2[1] = Y;
            cArray2[2] = Z;
            cArray2[3] = SWING;
            cArray2[4] = TWIST;
            cArray2[5] = SLERP;
            return cArray2;
        }

        static {
            c[] cArray = new c[6];
            c[] cArray2 = cArray;
            cArray[0] = X;
            cArray2[1] = Y;
            cArray2[2] = Z;
            cArray2[3] = SWING;
            cArray2[4] = TWIST;
            cArray2[5] = SLERP;
            $VALUES = cArray2;
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000e\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0017\u0010\u001a\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u001b\u001a\u00020\u00078\u0007\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$d;", "", "", "e", "()F", "f", "g", "", "h", "()Z", "p0", "p1", "p2", "p3", "a", "(FFFZ)Lorg/valkyrienskies/core/impl/shadow/HE$d;", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "b", "F", "c", "d", "Z", "<init>", "(FFFZ)V"})
    public static final class d {
        public final float a;
        public final float b;
        public final float c;
        public final boolean d;

        public d(float f2, float f3, float f4, boolean bl) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = bl;
        }

        public /* synthetic */ d(float f2, float f3, float f4, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 8) != 0) {
                bl = false;
            }
            this(f2, f3, f4, bl);
        }

        @JvmName(name="a")
        public final float a() {
            return this.a;
        }

        @JvmName(name="b")
        public final float b() {
            return this.b;
        }

        @JvmName(name="c")
        public final float c() {
            return this.c;
        }

        @JvmName(name="d")
        public final boolean d() {
            return this.d;
        }

        private float e() {
            return this.a;
        }

        private float f() {
            return this.b;
        }

        private float g() {
            return this.c;
        }

        private boolean h() {
            return this.d;
        }

        private static d a(float f2, float f3, float f4, boolean bl) {
            return new d(f2, f3, f4, bl);
        }

        private static /* synthetic */ d a$default(d d2, float f2, float f3, float f4, boolean bl, int n2) {
            if ((n2 & 1) != 0) {
                f2 = d2.a;
            }
            if ((n2 & 2) != 0) {
                f3 = d2.b;
            }
            if ((n2 & 4) != 0) {
                f4 = d2.c;
            }
            if ((n2 & 8) != 0) {
                bl = d2.d;
            }
            float f5 = f2;
            float f6 = f3;
            boolean bl2 = bl;
            f3 = f4;
            f2 = f6;
            float f7 = f5;
            return new d(f7, f2, f3, bl2);
        }

        public final String toString() {
            return "d(c=" + this.a + ", a=" + this.b + ", b=" + this.c + ", d=" + this.d + ')';
        }

        public final int hashCode() {
            int n2 = Float.hashCode(this.a);
            n2 = n2 * 31 + Float.hashCode(this.b);
            n2 = n2 * 31 + Float.hashCode(this.c);
            int n3 = this.d ? 1 : 0;
            if (n3 != 0) {
                n3 = 1;
            }
            n2 = n2 * 31 + n3;
            return n2;
        }

        public final boolean equals(Object other) {
            d d2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d2 = d2;
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.a), (Object)Float.valueOf(d2.a))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.b), (Object)Float.valueOf(d2.b))) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)Float.valueOf(this.c), (Object)Float.valueOf(d2.c))) {
                return false;
            }
            return this.d == d2.d;
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\u00020\u00058\u0007\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0014\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\n\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$f;", "", "Lorg/valkyrienskies/core/impl/shadow/Hb;", "c", "()Lorg/valkyrienskies/core/impl/shadow/Hb;", "", "d", "()Z", "p0", "p1", "a", "(Lorg/valkyrienskies/core/impl/shadow/Hb;Z)Lorg/valkyrienskies/core/impl/shadow/HE$f;", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "b", "Z", "Lorg/valkyrienskies/core/impl/shadow/Hb;", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/Hb;Z)V"})
    public static final class f {
        public final hb_0 a;
        public final boolean b;

        public f(hb_0 hb_02, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
            this.a = hb_02;
            this.b = bl;
        }

        public /* synthetic */ f(hb_0 hb_02, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                bl = true;
            }
            this(hb_02, bl);
        }

        @JvmName(name="a")
        public final hb_0 a() {
            return this.a;
        }

        @JvmName(name="b")
        public final boolean b() {
            return this.b;
        }

        private hb_0 c() {
            return this.a;
        }

        private boolean d() {
            return this.b;
        }

        private static f a(hb_0 hb_02, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
            return new f(hb_02, bl);
        }

        private static /* synthetic */ f a$default(f object, hb_0 hb_02, boolean bl, int n2) {
            if ((n2 & 1) != 0) {
                hb_02 = ((f)object).a;
            }
            if ((n2 & 2) != 0) {
                bl = ((f)object).b;
            }
            boolean bl2 = bl;
            object = hb_02;
            Intrinsics.checkNotNullParameter((Object)object, (String)"");
            return new f((hb_0)object, bl2);
        }

        public final String toString() {
            return "f(b=" + this.a + ", a=" + this.b + ')';
        }

        public final int hashCode() {
            int n2 = this.a.hashCode();
            int n3 = this.b ? 1 : 0;
            if (n3 != 0) {
                n3 = 1;
            }
            n2 = n2 * 31 + n3;
            return n2;
        }

        public final boolean equals(Object other) {
            f f2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof f)) {
                return false;
            }
            f2 = f2;
            if (!Intrinsics.areEqual((Object)this.a, (Object)f2.a)) {
                return false;
            }
            return this.b == f2.b;
        }
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\f\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0004R\u0017\u0010\u0016\u001a\u00020\u00068\u0007\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\f\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HE$g;", "", "Lorg/joml/Vector3fc;", "d", "()Lorg/joml/Vector3fc;", "e", "", "f", "()Z", "p0", "p1", "p2", "a", "(Lorg/joml/Vector3fc;Lorg/joml/Vector3fc;Z)Lorg/valkyrienskies/core/impl/shadow/HE$g;", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "b", "Lorg/joml/Vector3fc;", "c", "Z", "<init>", "(Lorg/joml/Vector3fc;Lorg/joml/Vector3fc;Z)V"})
    public static final class g {
        public final Vector3fc a;
        public final Vector3fc b;
        public final boolean c;

        public g(Vector3fc vector3fc, Vector3fc vector3fc2, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)vector3fc, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3fc2, (String)"");
            this.a = vector3fc;
            this.b = vector3fc2;
            this.c = bl;
        }

        public /* synthetic */ g(Vector3fc vector3fc, Vector3fc vector3fc2, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                bl = true;
            }
            this(vector3fc, vector3fc2, bl);
        }

        @JvmName(name="a")
        public final Vector3fc a() {
            return this.a;
        }

        @JvmName(name="b")
        public final Vector3fc b() {
            return this.b;
        }

        @JvmName(name="c")
        public final boolean c() {
            return this.c;
        }

        private Vector3fc d() {
            return this.a;
        }

        private Vector3fc e() {
            return this.b;
        }

        private boolean f() {
            return this.c;
        }

        private static g a(Vector3fc vector3fc, Vector3fc vector3fc2, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)vector3fc, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3fc2, (String)"");
            return new g(vector3fc, vector3fc2, bl);
        }

        private static /* synthetic */ g a$default(g object, Vector3fc vector3fc, Vector3fc vector3fc2, boolean bl, int n2) {
            if ((n2 & 1) != 0) {
                vector3fc = ((g)object).a;
            }
            if ((n2 & 2) != 0) {
                vector3fc2 = ((g)object).b;
            }
            if ((n2 & 4) != 0) {
                bl = ((g)object).c;
            }
            Vector3fc vector3fc3 = vector3fc;
            boolean bl2 = bl;
            vector3fc = vector3fc2;
            object = vector3fc3;
            Intrinsics.checkNotNullParameter((Object)vector3fc3, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3fc, (String)"");
            return new g((Vector3fc)object, vector3fc, bl2);
        }

        public final String toString() {
            return "g(c=" + this.a + ", a=" + this.b + ", b=" + this.c + ')';
        }

        public final int hashCode() {
            int n2 = this.a.hashCode();
            n2 = n2 * 31 + this.b.hashCode();
            int n3 = this.c ? 1 : 0;
            if (n3 != 0) {
                n3 = 1;
            }
            n2 = n2 * 31 + n3;
            return n2;
        }

        public final boolean equals(Object other) {
            g g2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof g)) {
                return false;
            }
            g2 = g2;
            if (!Intrinsics.areEqual((Object)this.a, (Object)g2.a)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.b, (Object)g2.b)) {
                return false;
            }
            return this.c == g2.c;
        }
    }

    public static final class h {
        public final int a;
        public final int b;

        public h(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        private int c() {
            return this.a;
        }

        private int d() {
            return this.b;
        }

        private static h a(int n2, int n3) {
            return new h(n2, n3);
        }

        private static /* synthetic */ h a(h h2, int n2, int n3, int n4) {
            if ((n4 & 1) != 0) {
                n2 = h2.a;
            }
            if ((n4 & 2) != 0) {
                n3 = h2.b;
            }
            int n5 = n2;
            n2 = n3;
            int n6 = n5;
            return new h(n6, n2);
        }

        public final String toString() {
            return "Hinges(hinge0=" + this.a + ", hinge1=" + this.b + ')';
        }

        public final int hashCode() {
            int n2 = Integer.hashCode(this.a);
            n2 = n2 * 31 + Integer.hashCode(this.b);
            return n2;
        }

        public final boolean equals(Object other) {
            h h2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof h)) {
                return false;
            }
            h2 = h2;
            if (this.a != h2.a) {
                return false;
            }
            return this.b == h2.b;
        }
    }
}

