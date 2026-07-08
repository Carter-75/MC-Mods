/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.internal.joints;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.util.PhysTickOnly;
import org.valkyrienskies.core.internal.joints.VSJoint;
import org.valkyrienskies.core.internal.joints.VSJointMaxForceTorque;
import org.valkyrienskies.core.internal.joints.VSJointPose;
import org.valkyrienskies.core.internal.joints.VSJointType;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u000e\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u000e\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\bN\u0010OJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\bJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0017\u0010\bJ\u009a\u0001\u0010#\u001a\u00020\u00002\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0019\u001a\u00020\n2\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001b\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%H\u00d6\u0003\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*H\u00d6\u0001\u00a2\u0006\u0004\b+\u0010,J\u001f\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-H\u0016\u00a2\u0006\u0004\b0\u00101J\u001f\u00104\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u000206H\u00d6\u0001\u00a2\u0006\u0004\b7\u00108R\u001a\u0010\u001d\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010\u0014R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\"\u0010;\u001a\u0004\b<\u0010\bR\u001a\u0010>\u001a\u00020=8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010;\u001a\u0004\bB\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010C\u001a\u0004\bD\u0010\u0011R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010;\u001a\u0004\bE\u0010\bR\u001a\u0010\u0019\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010F\u001a\u0004\bG\u0010\fR\u001a\u0010\u001b\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010F\u001a\u0004\bH\u0010\fR\"\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010I\u001a\u0004\bJ\u0010\u0005R\"\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010I\u001a\u0004\bK\u0010\u0005R\u0019\u0010!\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010;\u001a\u0004\bL\u0010\bR\u0019\u0010 \u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b \u0010;\u001a\u0004\bM\u0010\b\u00a8\u0006P"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSDistanceJoint;", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()Ljava/lang/Long;", "", "component10", "()Ljava/lang/Float;", "component11", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component2", "()Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component3", "component4", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "component5", "()Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "", "component6", "()D", "component7", "component8", "component9", "shipId0", "pose0", "shipId1", "pose1", "maxForceTorque", "compliance", "minDistance", "maxDistance", "tolerance", "stiffness", "damping", "copy", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/internal/joints/VSDistanceJoint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lorg/joml/Vector3dc;", "offset0", "offset1", "offsetLocalPositions", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "scale0", "scale1", "scaleLocalPositions", "(DD)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "toString", "()Ljava/lang/String;", "D", "getCompliance", "Ljava/lang/Float;", "getDamping", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "jointType", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "getJointType", "()Lorg/valkyrienskies/core/internal/joints/VSJointType;", "getMaxDistance", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "getMaxForceTorque", "getMinDistance", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "getPose0", "getPose1", "Ljava/lang/Long;", "getShipId0", "getShipId1", "getStiffness", "getTolerance", "<init>", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "internal"})
@PhysTickOnly
public final class VSDistanceJoint
implements VSJoint {
    @Nullable
    private final Long shipId0;
    @NotNull
    private final VSJointPose pose0;
    @Nullable
    private final Long shipId1;
    @NotNull
    private final VSJointPose pose1;
    @Nullable
    private final VSJointMaxForceTorque maxForceTorque;
    private final double compliance;
    @Nullable
    private final Float minDistance;
    @Nullable
    private final Float maxDistance;
    @Nullable
    private final Float tolerance;
    @Nullable
    private final Float stiffness;
    @Nullable
    private final Float damping;
    @NotNull
    private final VSJointType jointType;

    public VSDistanceJoint(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable Float minDistance, @Nullable Float maxDistance, @Nullable Float tolerance, @Nullable Float stiffness, @Nullable Float damping) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        this.shipId0 = shipId0;
        this.pose0 = pose0;
        this.shipId1 = shipId1;
        this.pose1 = pose1;
        this.maxForceTorque = maxForceTorque;
        this.compliance = compliance;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.tolerance = tolerance;
        this.stiffness = stiffness;
        this.damping = damping;
        this.jointType = VSJointType.DISTANCE;
    }

    public /* synthetic */ VSDistanceJoint(Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, Float f2, Float f3, Float f4, Float f5, Float f6, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = null;
        }
        if ((n2 & 0x20) != 0) {
            d2 = 1.0E-10;
        }
        if ((n2 & 0x40) != 0) {
            f2 = null;
        }
        if ((n2 & 0x80) != 0) {
            f3 = null;
        }
        if ((n2 & 0x100) != 0) {
            f4 = null;
        }
        if ((n2 & 0x200) != 0) {
            f5 = null;
        }
        if ((n2 & 0x400) != 0) {
            f6 = null;
        }
        this(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, f2, f3, f4, f5, f6);
    }

    @Override
    @Nullable
    public Long getShipId0() {
        return this.shipId0;
    }

    @Override
    @NotNull
    public VSJointPose getPose0() {
        return this.pose0;
    }

    @Override
    @Nullable
    public Long getShipId1() {
        return this.shipId1;
    }

    @Override
    @NotNull
    public VSJointPose getPose1() {
        return this.pose1;
    }

    @Override
    @Nullable
    public VSJointMaxForceTorque getMaxForceTorque() {
        return this.maxForceTorque;
    }

    @Override
    public double getCompliance() {
        return this.compliance;
    }

    @Nullable
    public final Float getMinDistance() {
        return this.minDistance;
    }

    @Nullable
    public final Float getMaxDistance() {
        return this.maxDistance;
    }

    @Nullable
    public final Float getTolerance() {
        return this.tolerance;
    }

    @Nullable
    public final Float getStiffness() {
        return this.stiffness;
    }

    @Nullable
    public final Float getDamping() {
        return this.damping;
    }

    @Override
    @NotNull
    public VSJointType getJointType() {
        return this.jointType;
    }

    @Override
    @NotNull
    public VSJoint offsetLocalPositions(@NotNull Vector3dc offset0, @NotNull Vector3dc offset1) {
        Intrinsics.checkNotNullParameter((Object)offset0, (String)"offset0");
        Intrinsics.checkNotNullParameter((Object)offset1, (String)"offset1");
        Long l2 = this.getShipId0();
        Vector3d vector3d = this.getPose0().getPos().add(offset0, new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"pose0.pos.add(offset0, Vector3d())");
        VSJointPose vSJointPose = new VSJointPose(vector3d, this.getPose0().getRot());
        Long l3 = this.getShipId1();
        Vector3d vector3d2 = this.getPose1().getPos().add(offset1, new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"pose1.pos.add(offset1, Vector3d())");
        return new VSDistanceJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.minDistance, this.maxDistance, this.tolerance, this.stiffness, this.damping);
    }

    @Override
    @NotNull
    public VSJoint scaleLocalPositions(double scale0, double scale1) {
        Long l2 = this.getShipId0();
        Vector3d vector3d = this.getPose0().getPos().mul(scale0, new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"pose0.pos.mul(scale0, Vector3d())");
        VSJointPose vSJointPose = new VSJointPose(vector3d, this.getPose0().getRot());
        Long l3 = this.getShipId1();
        Vector3d vector3d2 = this.getPose1().getPos().mul(scale1, new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"pose1.pos.mul(scale1, Vector3d())");
        return new VSDistanceJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.minDistance, this.maxDistance, this.tolerance, this.stiffness, this.damping);
    }

    @Nullable
    public final Long component1() {
        return this.shipId0;
    }

    @NotNull
    public final VSJointPose component2() {
        return this.pose0;
    }

    @Nullable
    public final Long component3() {
        return this.shipId1;
    }

    @NotNull
    public final VSJointPose component4() {
        return this.pose1;
    }

    @Nullable
    public final VSJointMaxForceTorque component5() {
        return this.maxForceTorque;
    }

    public final double component6() {
        return this.compliance;
    }

    @Nullable
    public final Float component7() {
        return this.minDistance;
    }

    @Nullable
    public final Float component8() {
        return this.maxDistance;
    }

    @Nullable
    public final Float component9() {
        return this.tolerance;
    }

    @Nullable
    public final Float component10() {
        return this.stiffness;
    }

    @Nullable
    public final Float component11() {
        return this.damping;
    }

    @NotNull
    public final VSDistanceJoint copy(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable Float minDistance, @Nullable Float maxDistance, @Nullable Float tolerance, @Nullable Float stiffness, @Nullable Float damping) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        return new VSDistanceJoint(shipId0, pose0, shipId1, pose1, maxForceTorque, compliance, minDistance, maxDistance, tolerance, stiffness, damping);
    }

    public static /* synthetic */ VSDistanceJoint copy$default(VSDistanceJoint vSDistanceJoint, Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, Float f2, Float f3, Float f4, Float f5, Float f6, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = vSDistanceJoint.shipId0;
        }
        if ((n2 & 2) != 0) {
            vSJointPose = vSDistanceJoint.pose0;
        }
        if ((n2 & 4) != 0) {
            l3 = vSDistanceJoint.shipId1;
        }
        if ((n2 & 8) != 0) {
            vSJointPose2 = vSDistanceJoint.pose1;
        }
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = vSDistanceJoint.maxForceTorque;
        }
        if ((n2 & 0x20) != 0) {
            d2 = vSDistanceJoint.compliance;
        }
        if ((n2 & 0x40) != 0) {
            f2 = vSDistanceJoint.minDistance;
        }
        if ((n2 & 0x80) != 0) {
            f3 = vSDistanceJoint.maxDistance;
        }
        if ((n2 & 0x100) != 0) {
            f4 = vSDistanceJoint.tolerance;
        }
        if ((n2 & 0x200) != 0) {
            f5 = vSDistanceJoint.stiffness;
        }
        if ((n2 & 0x400) != 0) {
            f6 = vSDistanceJoint.damping;
        }
        return vSDistanceJoint.copy(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, f2, f3, f4, f5, f6);
    }

    @NotNull
    public String toString() {
        return "VSDistanceJoint(shipId0=" + this.shipId0 + ", pose0=" + this.pose0 + ", shipId1=" + this.shipId1 + ", pose1=" + this.pose1 + ", maxForceTorque=" + this.maxForceTorque + ", compliance=" + this.compliance + ", minDistance=" + this.minDistance + ", maxDistance=" + this.maxDistance + ", tolerance=" + this.tolerance + ", stiffness=" + this.stiffness + ", damping=" + this.damping + ")";
    }

    public int hashCode() {
        int result2 = this.shipId0 == null ? 0 : ((Object)this.shipId0).hashCode();
        result2 = result2 * 31 + this.pose0.hashCode();
        result2 = result2 * 31 + (this.shipId1 == null ? 0 : ((Object)this.shipId1).hashCode());
        result2 = result2 * 31 + this.pose1.hashCode();
        result2 = result2 * 31 + (this.maxForceTorque == null ? 0 : this.maxForceTorque.hashCode());
        result2 = result2 * 31 + Double.hashCode(this.compliance);
        result2 = result2 * 31 + (this.minDistance == null ? 0 : ((Object)this.minDistance).hashCode());
        result2 = result2 * 31 + (this.maxDistance == null ? 0 : ((Object)this.maxDistance).hashCode());
        result2 = result2 * 31 + (this.tolerance == null ? 0 : ((Object)this.tolerance).hashCode());
        result2 = result2 * 31 + (this.stiffness == null ? 0 : ((Object)this.stiffness).hashCode());
        result2 = result2 * 31 + (this.damping == null ? 0 : ((Object)this.damping).hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSDistanceJoint)) {
            return false;
        }
        VSDistanceJoint vSDistanceJoint = (VSDistanceJoint)other;
        if (!Intrinsics.areEqual((Object)this.shipId0, (Object)vSDistanceJoint.shipId0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose0, (Object)vSDistanceJoint.pose0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipId1, (Object)vSDistanceJoint.shipId1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose1, (Object)vSDistanceJoint.pose1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maxForceTorque, (Object)vSDistanceJoint.maxForceTorque)) {
            return false;
        }
        if (Double.compare(this.compliance, vSDistanceJoint.compliance) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.minDistance, (Object)vSDistanceJoint.minDistance)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maxDistance, (Object)vSDistanceJoint.maxDistance)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.tolerance, (Object)vSDistanceJoint.tolerance)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.stiffness, (Object)vSDistanceJoint.stiffness)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.damping, (Object)vSDistanceJoint.damping);
    }
}

