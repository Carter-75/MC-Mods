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
import org.valkyrienskies.core.internal.joints.UnavailableInKrunch;
import org.valkyrienskies.core.internal.joints.VSD6Joint;
import org.valkyrienskies.core.internal.joints.VSJoint;
import org.valkyrienskies.core.internal.joints.VSJointMaxForceTorque;
import org.valkyrienskies.core.internal.joints.VSJointPose;
import org.valkyrienskies.core.internal.joints.VSJointType;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u000e\u0010\u0017\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u000e\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\bH\u0010IJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\n\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016Jv\u0010\u001f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00062\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0014H\u00c6\u0001\u00a2\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u00d6\u0003\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&H\u00d6\u0001\u00a2\u0006\u0004\b'\u0010(J\u001f\u0010,\u001a\u00020\u00012\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\u0016\u00a2\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b0\u00101J\u0010\u00103\u001a\u000202H\u00d6\u0001\u00a2\u0006\u0004\b3\u00104R\u001a\u0010\u001c\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u0010\u0010R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b8\u0010\u0016R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010\u0013R\u001a\u0010<\u001a\u00020;8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010@\u001a\u0004\bA\u0010\rR\u001a\u0010\u0018\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010B\u001a\u0004\bC\u0010\bR\u001a\u0010\u001a\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010B\u001a\u0004\bD\u0010\bR\"\u0010\u0017\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010E\u001a\u0004\bF\u0010\u0005R\"\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010E\u001a\u0004\bG\u0010\u0005\u00a8\u0006J"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSGearJoint;", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()Ljava/lang/Long;", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component2", "()Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component3", "component4", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "component5", "()Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "", "component6", "()D", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;", "component7", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;", "", "component8", "()Ljava/lang/Float;", "shipId0", "pose0", "shipId1", "pose1", "maxForceTorque", "compliance", "hinges", "gearRatio", "copy", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;Ljava/lang/Float;)Lorg/valkyrienskies/core/internal/joints/VSGearJoint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lorg/joml/Vector3dc;", "offset0", "offset1", "offsetLocalPositions", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "scale0", "scale1", "scaleLocalPositions", "(DD)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "toString", "()Ljava/lang/String;", "D", "getCompliance", "Ljava/lang/Float;", "getGearRatio", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;", "getHinges", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "jointType", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "getJointType", "()Lorg/valkyrienskies/core/internal/joints/VSJointType;", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "getMaxForceTorque", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "getPose0", "getPose1", "Ljava/lang/Long;", "getShipId0", "getShipId1", "<init>", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;Ljava/lang/Float;)V", "internal"})
@PhysTickOnly
@UnavailableInKrunch
public final class VSGearJoint
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
    private final VSD6Joint.Hinges hinges;
    @Nullable
    private final Float gearRatio;
    @NotNull
    private final VSJointType jointType;

    public VSGearJoint(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable VSD6Joint.Hinges hinges, @Nullable Float gearRatio) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        this.shipId0 = shipId0;
        this.pose0 = pose0;
        this.shipId1 = shipId1;
        this.pose1 = pose1;
        this.maxForceTorque = maxForceTorque;
        this.compliance = compliance;
        this.hinges = hinges;
        this.gearRatio = gearRatio;
        this.jointType = VSJointType.GEAR;
    }

    public /* synthetic */ VSGearJoint(Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, VSD6Joint.Hinges hinges, Float f2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = null;
        }
        if ((n2 & 0x20) != 0) {
            d2 = 1.0E-10;
        }
        if ((n2 & 0x40) != 0) {
            hinges = null;
        }
        if ((n2 & 0x80) != 0) {
            f2 = null;
        }
        this(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, hinges, f2);
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
    public final VSD6Joint.Hinges getHinges() {
        return this.hinges;
    }

    @Nullable
    public final Float getGearRatio() {
        return this.gearRatio;
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
        return new VSGearJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.hinges, this.gearRatio);
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
        return new VSGearJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.hinges, this.gearRatio);
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
    public final VSD6Joint.Hinges component7() {
        return this.hinges;
    }

    @Nullable
    public final Float component8() {
        return this.gearRatio;
    }

    @NotNull
    public final VSGearJoint copy(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable VSD6Joint.Hinges hinges, @Nullable Float gearRatio) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        return new VSGearJoint(shipId0, pose0, shipId1, pose1, maxForceTorque, compliance, hinges, gearRatio);
    }

    public static /* synthetic */ VSGearJoint copy$default(VSGearJoint vSGearJoint, Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, VSD6Joint.Hinges hinges, Float f2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = vSGearJoint.shipId0;
        }
        if ((n2 & 2) != 0) {
            vSJointPose = vSGearJoint.pose0;
        }
        if ((n2 & 4) != 0) {
            l3 = vSGearJoint.shipId1;
        }
        if ((n2 & 8) != 0) {
            vSJointPose2 = vSGearJoint.pose1;
        }
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = vSGearJoint.maxForceTorque;
        }
        if ((n2 & 0x20) != 0) {
            d2 = vSGearJoint.compliance;
        }
        if ((n2 & 0x40) != 0) {
            hinges = vSGearJoint.hinges;
        }
        if ((n2 & 0x80) != 0) {
            f2 = vSGearJoint.gearRatio;
        }
        return vSGearJoint.copy(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, hinges, f2);
    }

    @NotNull
    public String toString() {
        return "VSGearJoint(shipId0=" + this.shipId0 + ", pose0=" + this.pose0 + ", shipId1=" + this.shipId1 + ", pose1=" + this.pose1 + ", maxForceTorque=" + this.maxForceTorque + ", compliance=" + this.compliance + ", hinges=" + this.hinges + ", gearRatio=" + this.gearRatio + ")";
    }

    public int hashCode() {
        int result2 = this.shipId0 == null ? 0 : ((Object)this.shipId0).hashCode();
        result2 = result2 * 31 + this.pose0.hashCode();
        result2 = result2 * 31 + (this.shipId1 == null ? 0 : ((Object)this.shipId1).hashCode());
        result2 = result2 * 31 + this.pose1.hashCode();
        result2 = result2 * 31 + (this.maxForceTorque == null ? 0 : this.maxForceTorque.hashCode());
        result2 = result2 * 31 + Double.hashCode(this.compliance);
        result2 = result2 * 31 + (this.hinges == null ? 0 : this.hinges.hashCode());
        result2 = result2 * 31 + (this.gearRatio == null ? 0 : ((Object)this.gearRatio).hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSGearJoint)) {
            return false;
        }
        VSGearJoint vSGearJoint = (VSGearJoint)other;
        if (!Intrinsics.areEqual((Object)this.shipId0, (Object)vSGearJoint.shipId0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose0, (Object)vSGearJoint.pose0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipId1, (Object)vSGearJoint.shipId1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose1, (Object)vSGearJoint.pose1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maxForceTorque, (Object)vSGearJoint.maxForceTorque)) {
            return false;
        }
        if (Double.compare(this.compliance, vSGearJoint.compliance) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.hinges, (Object)vSGearJoint.hinges)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.gearRatio, (Object)vSGearJoint.gearRatio);
    }
}

