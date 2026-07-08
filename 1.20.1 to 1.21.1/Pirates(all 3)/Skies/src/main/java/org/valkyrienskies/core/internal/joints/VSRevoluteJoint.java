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

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001:\u0001XB\u0089\u0001\u0012\u000e\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\u000e\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010!\u001a\u00020\f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010#\u001a\u00020\u0014\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\bV\u0010WJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\fH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u001d\u0010\bJ\u009a\u0001\u0010)\u001a\u00020\u00002\u0010\b\u0002\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001f\u001a\u00020\f2\u0010\b\u0002\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010!\u001a\u00020\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010#\u001a\u00020\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010+H\u00d6\u0003\u00a2\u0006\u0004\b-\u0010.J\u0010\u00100\u001a\u00020/H\u00d6\u0001\u00a2\u0006\u0004\b0\u00101J\u001f\u00105\u001a\u00020\u00012\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000202H\u0016\u00a2\u0006\u0004\b5\u00106J\u001f\u00109\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010<\u001a\u00020;H\u00d6\u0001\u00a2\u0006\u0004\b<\u0010=R\u0019\u0010$\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b$\u0010>\u001a\u0004\b?\u0010\u0019R\u001a\u0010#\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u0010@\u001a\u0004\bA\u0010\u0016R\u0019\u0010&\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b&\u0010B\u001a\u0004\bC\u0010\bR\u0019\u0010(\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b(\u0010D\u001a\u0004\bE\u0010\u000bR\u0019\u0010'\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b'\u0010B\u001a\u0004\bF\u0010\bR\u0019\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b%\u0010G\u001a\u0004\bH\u0010\u001cR\u001a\u0010J\u001a\u00020I8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u0010N\u001a\u0004\bO\u0010\u0013R\u001a\u0010\u001f\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010P\u001a\u0004\bQ\u0010\u000eR\u001a\u0010!\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b!\u0010P\u001a\u0004\bR\u0010\u000eR\"\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010S\u001a\u0004\bT\u0010\u0005R\"\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010S\u001a\u0004\bU\u0010\u0005\u00a8\u0006Y"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint;", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()Ljava/lang/Long;", "", "component10", "()Ljava/lang/Float;", "", "component11", "()Ljava/lang/Boolean;", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component2", "()Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component3", "component4", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "component5", "()Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "", "component6", "()D", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;", "component7", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;", "Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint$VSRevoluteDriveVelocity;", "component8", "()Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint$VSRevoluteDriveVelocity;", "component9", "shipId0", "pose0", "shipId1", "pose1", "maxForceTorque", "compliance", "angularLimitPair", "driveVelocity", "driveForceLimit", "driveGearRatio", "driveFreeSpin", "copy", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint$VSRevoluteDriveVelocity;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;)Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lorg/joml/Vector3dc;", "offset0", "offset1", "offsetLocalPositions", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "scale0", "scale1", "scaleLocalPositions", "(DD)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;", "getAngularLimitPair", "D", "getCompliance", "Ljava/lang/Float;", "getDriveForceLimit", "Ljava/lang/Boolean;", "getDriveFreeSpin", "getDriveGearRatio", "Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint$VSRevoluteDriveVelocity;", "getDriveVelocity", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "jointType", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "getJointType", "()Lorg/valkyrienskies/core/internal/joints/VSJointType;", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "getMaxForceTorque", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "getPose0", "getPose1", "Ljava/lang/Long;", "getShipId0", "getShipId1", "<init>", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint$VSRevoluteDriveVelocity;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;)V", "VSRevoluteDriveVelocity", "internal"})
@PhysTickOnly
public final class VSRevoluteJoint
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
    private final VSD6Joint.AngularLimitPair angularLimitPair;
    @Nullable
    private final VSRevoluteDriveVelocity driveVelocity;
    @Nullable
    private final Float driveForceLimit;
    @Nullable
    private final Float driveGearRatio;
    @Nullable
    private final Boolean driveFreeSpin;
    @NotNull
    private final VSJointType jointType;

    public VSRevoluteJoint(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable VSD6Joint.AngularLimitPair angularLimitPair, @Nullable VSRevoluteDriveVelocity driveVelocity, @Nullable Float driveForceLimit, @Nullable Float driveGearRatio, @Nullable Boolean driveFreeSpin) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        this.shipId0 = shipId0;
        this.pose0 = pose0;
        this.shipId1 = shipId1;
        this.pose1 = pose1;
        this.maxForceTorque = maxForceTorque;
        this.compliance = compliance;
        this.angularLimitPair = angularLimitPair;
        this.driveVelocity = driveVelocity;
        this.driveForceLimit = driveForceLimit;
        this.driveGearRatio = driveGearRatio;
        this.driveFreeSpin = driveFreeSpin;
        this.jointType = VSJointType.REVOLUTE;
    }

    public /* synthetic */ VSRevoluteJoint(Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, VSD6Joint.AngularLimitPair angularLimitPair, VSRevoluteDriveVelocity vSRevoluteDriveVelocity, Float f2, Float f3, Boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = null;
        }
        if ((n2 & 0x20) != 0) {
            d2 = 1.0E-10;
        }
        if ((n2 & 0x40) != 0) {
            angularLimitPair = null;
        }
        if ((n2 & 0x80) != 0) {
            vSRevoluteDriveVelocity = null;
        }
        if ((n2 & 0x100) != 0) {
            f2 = null;
        }
        if ((n2 & 0x200) != 0) {
            f3 = null;
        }
        if ((n2 & 0x400) != 0) {
            bl = null;
        }
        this(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, angularLimitPair, vSRevoluteDriveVelocity, f2, f3, bl);
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
    public final VSD6Joint.AngularLimitPair getAngularLimitPair() {
        return this.angularLimitPair;
    }

    @Nullable
    public final VSRevoluteDriveVelocity getDriveVelocity() {
        return this.driveVelocity;
    }

    @Nullable
    public final Float getDriveForceLimit() {
        return this.driveForceLimit;
    }

    @Nullable
    public final Float getDriveGearRatio() {
        return this.driveGearRatio;
    }

    @Nullable
    public final Boolean getDriveFreeSpin() {
        return this.driveFreeSpin;
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
        return new VSRevoluteJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.angularLimitPair, this.driveVelocity, this.driveForceLimit, this.driveGearRatio, this.driveFreeSpin);
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
        return new VSRevoluteJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.angularLimitPair, this.driveVelocity, this.driveForceLimit, this.driveGearRatio, this.driveFreeSpin);
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
    public final VSD6Joint.AngularLimitPair component7() {
        return this.angularLimitPair;
    }

    @Nullable
    public final VSRevoluteDriveVelocity component8() {
        return this.driveVelocity;
    }

    @Nullable
    public final Float component9() {
        return this.driveForceLimit;
    }

    @Nullable
    public final Float component10() {
        return this.driveGearRatio;
    }

    @Nullable
    public final Boolean component11() {
        return this.driveFreeSpin;
    }

    @NotNull
    public final VSRevoluteJoint copy(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable VSD6Joint.AngularLimitPair angularLimitPair, @Nullable VSRevoluteDriveVelocity driveVelocity, @Nullable Float driveForceLimit, @Nullable Float driveGearRatio, @Nullable Boolean driveFreeSpin) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        return new VSRevoluteJoint(shipId0, pose0, shipId1, pose1, maxForceTorque, compliance, angularLimitPair, driveVelocity, driveForceLimit, driveGearRatio, driveFreeSpin);
    }

    public static /* synthetic */ VSRevoluteJoint copy$default(VSRevoluteJoint vSRevoluteJoint, Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, VSD6Joint.AngularLimitPair angularLimitPair, VSRevoluteDriveVelocity vSRevoluteDriveVelocity, Float f2, Float f3, Boolean bl, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = vSRevoluteJoint.shipId0;
        }
        if ((n2 & 2) != 0) {
            vSJointPose = vSRevoluteJoint.pose0;
        }
        if ((n2 & 4) != 0) {
            l3 = vSRevoluteJoint.shipId1;
        }
        if ((n2 & 8) != 0) {
            vSJointPose2 = vSRevoluteJoint.pose1;
        }
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = vSRevoluteJoint.maxForceTorque;
        }
        if ((n2 & 0x20) != 0) {
            d2 = vSRevoluteJoint.compliance;
        }
        if ((n2 & 0x40) != 0) {
            angularLimitPair = vSRevoluteJoint.angularLimitPair;
        }
        if ((n2 & 0x80) != 0) {
            vSRevoluteDriveVelocity = vSRevoluteJoint.driveVelocity;
        }
        if ((n2 & 0x100) != 0) {
            f2 = vSRevoluteJoint.driveForceLimit;
        }
        if ((n2 & 0x200) != 0) {
            f3 = vSRevoluteJoint.driveGearRatio;
        }
        if ((n2 & 0x400) != 0) {
            bl = vSRevoluteJoint.driveFreeSpin;
        }
        return vSRevoluteJoint.copy(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, angularLimitPair, vSRevoluteDriveVelocity, f2, f3, bl);
    }

    @NotNull
    public String toString() {
        return "VSRevoluteJoint(shipId0=" + this.shipId0 + ", pose0=" + this.pose0 + ", shipId1=" + this.shipId1 + ", pose1=" + this.pose1 + ", maxForceTorque=" + this.maxForceTorque + ", compliance=" + this.compliance + ", angularLimitPair=" + this.angularLimitPair + ", driveVelocity=" + this.driveVelocity + ", driveForceLimit=" + this.driveForceLimit + ", driveGearRatio=" + this.driveGearRatio + ", driveFreeSpin=" + this.driveFreeSpin + ")";
    }

    public int hashCode() {
        int result2 = this.shipId0 == null ? 0 : ((Object)this.shipId0).hashCode();
        result2 = result2 * 31 + this.pose0.hashCode();
        result2 = result2 * 31 + (this.shipId1 == null ? 0 : ((Object)this.shipId1).hashCode());
        result2 = result2 * 31 + this.pose1.hashCode();
        result2 = result2 * 31 + (this.maxForceTorque == null ? 0 : this.maxForceTorque.hashCode());
        result2 = result2 * 31 + Double.hashCode(this.compliance);
        result2 = result2 * 31 + (this.angularLimitPair == null ? 0 : this.angularLimitPair.hashCode());
        result2 = result2 * 31 + (this.driveVelocity == null ? 0 : this.driveVelocity.hashCode());
        result2 = result2 * 31 + (this.driveForceLimit == null ? 0 : ((Object)this.driveForceLimit).hashCode());
        result2 = result2 * 31 + (this.driveGearRatio == null ? 0 : ((Object)this.driveGearRatio).hashCode());
        result2 = result2 * 31 + (this.driveFreeSpin == null ? 0 : ((Object)this.driveFreeSpin).hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSRevoluteJoint)) {
            return false;
        }
        VSRevoluteJoint vSRevoluteJoint = (VSRevoluteJoint)other;
        if (!Intrinsics.areEqual((Object)this.shipId0, (Object)vSRevoluteJoint.shipId0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose0, (Object)vSRevoluteJoint.pose0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipId1, (Object)vSRevoluteJoint.shipId1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose1, (Object)vSRevoluteJoint.pose1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maxForceTorque, (Object)vSRevoluteJoint.maxForceTorque)) {
            return false;
        }
        if (Double.compare(this.compliance, vSRevoluteJoint.compliance) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.angularLimitPair, (Object)vSRevoluteJoint.angularLimitPair)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.driveVelocity, (Object)vSRevoluteJoint.driveVelocity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.driveForceLimit, (Object)vSRevoluteJoint.driveForceLimit)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.driveGearRatio, (Object)vSRevoluteJoint.driveGearRatio)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.driveFreeSpin, (Object)vSRevoluteJoint.driveFreeSpin);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\u00a8\u0006\u001b"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint$VSRevoluteDriveVelocity;", "", "", "component1", "()F", "", "component2", "()Z", "velocity", "autoWake", "copy", "(FZ)Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint$VSRevoluteDriveVelocity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getAutoWake", "F", "getVelocity", "<init>", "(FZ)V", "internal"})
    public static final class VSRevoluteDriveVelocity {
        private final float velocity;
        private final boolean autoWake;

        public VSRevoluteDriveVelocity(float velocity, boolean autoWake) {
            this.velocity = velocity;
            this.autoWake = autoWake;
        }

        public /* synthetic */ VSRevoluteDriveVelocity(float f2, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                bl = true;
            }
            this(f2, bl);
        }

        public final float getVelocity() {
            return this.velocity;
        }

        public final boolean getAutoWake() {
            return this.autoWake;
        }

        public final float component1() {
            return this.velocity;
        }

        public final boolean component2() {
            return this.autoWake;
        }

        @NotNull
        public final VSRevoluteDriveVelocity copy(float velocity, boolean autoWake) {
            return new VSRevoluteDriveVelocity(velocity, autoWake);
        }

        public static /* synthetic */ VSRevoluteDriveVelocity copy$default(VSRevoluteDriveVelocity vSRevoluteDriveVelocity, float f2, boolean bl, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = vSRevoluteDriveVelocity.velocity;
            }
            if ((n2 & 2) != 0) {
                bl = vSRevoluteDriveVelocity.autoWake;
            }
            return vSRevoluteDriveVelocity.copy(f2, bl);
        }

        @NotNull
        public String toString() {
            return "VSRevoluteDriveVelocity(velocity=" + this.velocity + ", autoWake=" + this.autoWake + ")";
        }

        public int hashCode() {
            int result2 = Float.hashCode(this.velocity);
            result2 = result2 * 31 + Boolean.hashCode(this.autoWake);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VSRevoluteDriveVelocity)) {
                return false;
            }
            VSRevoluteDriveVelocity vSRevoluteDriveVelocity = (VSRevoluteDriveVelocity)other;
            if (Float.compare(this.velocity, vSRevoluteDriveVelocity.velocity) != 0) {
                return false;
            }
            return this.autoWake == vSRevoluteDriveVelocity.autoWake;
        }
    }
}

