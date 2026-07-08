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
import org.valkyrienskies.core.internal.joints.VSD6Joint;
import org.valkyrienskies.core.internal.joints.VSJoint;
import org.valkyrienskies.core.internal.joints.VSJointMaxForceTorque;
import org.valkyrienskies.core.internal.joints.VSJointPose;
import org.valkyrienskies.core.internal.joints.VSJointType;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u000e\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u000e\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\bB\u0010CJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\n\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013Jj\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00062\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u00c6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003\u00a2\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"H\u00d6\u0001\u00a2\u0006\u0004\b#\u0010$J\u001f\u0010(\u001a\u00020\u00012\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016\u00a2\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.H\u00d6\u0001\u00a2\u0006\u0004\b/\u00100R\u001a\u0010\u0019\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u0010R\u001a\u00104\u001a\u0002038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001a\u00108\u001a\u0004\b9\u0010\u0013R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010:\u001a\u0004\b;\u0010\rR\u001a\u0010\u0015\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010<\u001a\u0004\b=\u0010\bR\u001a\u0010\u0017\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010<\u001a\u0004\b>\u0010\bR\"\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010?\u001a\u0004\b@\u0010\u0005R\"\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010?\u001a\u0004\bA\u0010\u0005\u00a8\u0006D"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSPrismaticJoint;", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()Ljava/lang/Long;", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component2", "()Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component3", "component4", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "component5", "()Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "", "component6", "()D", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;", "component7", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;", "shipId0", "pose0", "shipId1", "pose1", "maxForceTorque", "compliance", "linearLimitPair", "copy", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;)Lorg/valkyrienskies/core/internal/joints/VSPrismaticJoint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lorg/joml/Vector3dc;", "offset0", "offset1", "offsetLocalPositions", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "scale0", "scale1", "scaleLocalPositions", "(DD)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "toString", "()Ljava/lang/String;", "D", "getCompliance", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "jointType", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "getJointType", "()Lorg/valkyrienskies/core/internal/joints/VSJointType;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;", "getLinearLimitPair", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "getMaxForceTorque", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "getPose0", "getPose1", "Ljava/lang/Long;", "getShipId0", "getShipId1", "<init>", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;)V", "internal"})
@PhysTickOnly
public final class VSPrismaticJoint
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
    private final VSD6Joint.LinearLimitPair linearLimitPair;
    @NotNull
    private final VSJointType jointType;

    public VSPrismaticJoint(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable VSD6Joint.LinearLimitPair linearLimitPair) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        this.shipId0 = shipId0;
        this.pose0 = pose0;
        this.shipId1 = shipId1;
        this.pose1 = pose1;
        this.maxForceTorque = maxForceTorque;
        this.compliance = compliance;
        this.linearLimitPair = linearLimitPair;
        this.jointType = VSJointType.PRISMATIC;
    }

    public /* synthetic */ VSPrismaticJoint(Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, VSD6Joint.LinearLimitPair linearLimitPair, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = null;
        }
        if ((n2 & 0x20) != 0) {
            d2 = 1.0E-10;
        }
        if ((n2 & 0x40) != 0) {
            linearLimitPair = null;
        }
        this(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, linearLimitPair);
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
    public final VSD6Joint.LinearLimitPair getLinearLimitPair() {
        return this.linearLimitPair;
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
        return new VSPrismaticJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.linearLimitPair);
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
        return new VSPrismaticJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.linearLimitPair);
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
    public final VSD6Joint.LinearLimitPair component7() {
        return this.linearLimitPair;
    }

    @NotNull
    public final VSPrismaticJoint copy(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable VSD6Joint.LinearLimitPair linearLimitPair) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        return new VSPrismaticJoint(shipId0, pose0, shipId1, pose1, maxForceTorque, compliance, linearLimitPair);
    }

    public static /* synthetic */ VSPrismaticJoint copy$default(VSPrismaticJoint vSPrismaticJoint, Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, VSD6Joint.LinearLimitPair linearLimitPair, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = vSPrismaticJoint.shipId0;
        }
        if ((n2 & 2) != 0) {
            vSJointPose = vSPrismaticJoint.pose0;
        }
        if ((n2 & 4) != 0) {
            l3 = vSPrismaticJoint.shipId1;
        }
        if ((n2 & 8) != 0) {
            vSJointPose2 = vSPrismaticJoint.pose1;
        }
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = vSPrismaticJoint.maxForceTorque;
        }
        if ((n2 & 0x20) != 0) {
            d2 = vSPrismaticJoint.compliance;
        }
        if ((n2 & 0x40) != 0) {
            linearLimitPair = vSPrismaticJoint.linearLimitPair;
        }
        return vSPrismaticJoint.copy(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, linearLimitPair);
    }

    @NotNull
    public String toString() {
        return "VSPrismaticJoint(shipId0=" + this.shipId0 + ", pose0=" + this.pose0 + ", shipId1=" + this.shipId1 + ", pose1=" + this.pose1 + ", maxForceTorque=" + this.maxForceTorque + ", compliance=" + this.compliance + ", linearLimitPair=" + this.linearLimitPair + ")";
    }

    public int hashCode() {
        int result2 = this.shipId0 == null ? 0 : ((Object)this.shipId0).hashCode();
        result2 = result2 * 31 + this.pose0.hashCode();
        result2 = result2 * 31 + (this.shipId1 == null ? 0 : ((Object)this.shipId1).hashCode());
        result2 = result2 * 31 + this.pose1.hashCode();
        result2 = result2 * 31 + (this.maxForceTorque == null ? 0 : this.maxForceTorque.hashCode());
        result2 = result2 * 31 + Double.hashCode(this.compliance);
        result2 = result2 * 31 + (this.linearLimitPair == null ? 0 : this.linearLimitPair.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSPrismaticJoint)) {
            return false;
        }
        VSPrismaticJoint vSPrismaticJoint = (VSPrismaticJoint)other;
        if (!Intrinsics.areEqual((Object)this.shipId0, (Object)vSPrismaticJoint.shipId0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose0, (Object)vSPrismaticJoint.pose0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipId1, (Object)vSPrismaticJoint.shipId1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose1, (Object)vSPrismaticJoint.pose1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maxForceTorque, (Object)vSPrismaticJoint.maxForceTorque)) {
            return false;
        }
        if (Double.compare(this.compliance, vSPrismaticJoint.compliance) != 0) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.linearLimitPair, (Object)vSPrismaticJoint.linearLimitPair);
    }
}

