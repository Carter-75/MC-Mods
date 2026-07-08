/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.internal.joints;

import java.util.EnumMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.valkyrienskies.core.api.util.PhysTickOnly;
import org.valkyrienskies.core.internal.joints.UnavailableInKrunch;
import org.valkyrienskies.core.internal.joints.VSJoint;
import org.valkyrienskies.core.internal.joints.VSJointMaxForceTorque;
import org.valkyrienskies.core.internal.joints.VSJointPose;
import org.valkyrienskies.core.internal.joints.VSJointType;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001:\fstuvwxyz{|}~B\u00dd\u0001\u0012\u000e\u0010-\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010.\u001a\u00020\u001a\u0012\u000e\u0010/\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u00100\u001a\u00020\u001a\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u00102\u001a\u00020\"\u0012\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010\u000f\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010(\u0012\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020+\u0018\u00010\u000f\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0002\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\bq\u0010rJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001d\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u001d\u0010\u0005J\u0010\u0010\u001e\u001a\u00020\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001cJ\u0012\u0010 \u001a\u0004\u0018\u00010\u001fH\u00c6\u0003\u00a2\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"H\u00c6\u0003\u00a2\u0006\u0004\b#\u0010$J\u001e\u0010'\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0004\b'\u0010\u0013J\u0012\u0010)\u001a\u0004\u0018\u00010(H\u00c6\u0003\u00a2\u0006\u0004\b)\u0010*J\u001e\u0010,\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020+\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0004\b,\u0010\u0013J\u00ee\u0001\u0010<\u001a\u00020\u00002\u0010\b\u0002\u0010-\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010.\u001a\u00020\u001a2\u0010\b\u0002\u0010/\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u00100\u001a\u00020\u001a2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u00102\u001a\u00020\"2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010\u000f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010(2\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020+\u0018\u00010\u000f2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0017H\u00c6\u0001\u00a2\u0006\u0004\b<\u0010=J\u001a\u0010A\u001a\u00020@2\b\u0010?\u001a\u0004\u0018\u00010>H\u00d6\u0003\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010D\u001a\u00020CH\u00d6\u0001\u00a2\u0006\u0004\bD\u0010EJ\u001f\u0010I\u001a\u00020\u00012\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020FH\u0016\u00a2\u0006\u0004\bI\u0010JJ\u001f\u0010M\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u00020\"H\u0016\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010P\u001a\u00020OH\u00d6\u0001\u00a2\u0006\u0004\bP\u0010QR\u001a\u00102\u001a\u00020\"8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b2\u0010R\u001a\u0004\bS\u0010$R\u0019\u00104\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b4\u0010T\u001a\u0004\bU\u0010*R\u0019\u0010:\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b:\u0010V\u001a\u0004\bW\u0010\u0016R\u0019\u0010;\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b;\u0010X\u001a\u0004\bY\u0010\u0019R%\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b9\u0010Z\u001a\u0004\b[\u0010\u0013R\u001a\u0010]\u001a\u00020\\8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R%\u00105\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020+\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b5\u0010Z\u001a\u0004\ba\u0010\u0013R\u001c\u00101\u001a\u0004\u0018\u00010\u001f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b1\u0010b\u001a\u0004\bc\u0010!R%\u00103\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b3\u0010Z\u001a\u0004\bd\u0010\u0013R\u001a\u0010.\u001a\u00020\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010e\u001a\u0004\bf\u0010\u001cR\u001a\u00100\u001a\u00020\u001a8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b0\u0010e\u001a\u0004\bg\u0010\u001cR\u0019\u00108\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b8\u0010h\u001a\u0004\bi\u0010\u000eR\"\u0010-\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b-\u0010j\u001a\u0004\bk\u0010\u0005R\"\u0010/\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b/\u0010j\u001a\u0004\bl\u0010\u0005R\u0019\u00107\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b7\u0010m\u001a\u0004\bn\u0010\u000bR\u0019\u00106\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b6\u0010o\u001a\u0004\bp\u0010\b\u00a8\u0006\u007f"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint;", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()Ljava/lang/Long;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;", "component10", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitCone;", "component11", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitCone;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitPyramid;", "component12", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitPyramid;", "Ljava/util/EnumMap;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Drive;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6JointDrive;", "component13", "()Ljava/util/EnumMap;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DrivePosition;", "component14", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DrivePosition;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DriveVelocity;", "component15", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DriveVelocity;", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component2", "()Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component3", "component4", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "component5", "()Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "", "component6", "()D", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Axis;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Motion;", "component7", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimit;", "component8", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimit;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;", "component9", "shipId0", "pose0", "shipId1", "pose1", "maxForceTorque", "compliance", "motions", "distanceLimit", "linearLimits", "twistLimit", "swingLimit", "pyramidSwingLimit", "drives", "drivePosition", "driveVelocity", "copy", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLjava/util/EnumMap;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimit;Ljava/util/EnumMap;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitCone;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitPyramid;Ljava/util/EnumMap;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DrivePosition;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DriveVelocity;)Lorg/valkyrienskies/core/internal/joints/VSD6Joint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lorg/joml/Vector3dc;", "offset0", "offset1", "offsetLocalPositions", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "scale0", "scale1", "scaleLocalPositions", "(DD)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "toString", "()Ljava/lang/String;", "D", "getCompliance", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimit;", "getDistanceLimit", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DrivePosition;", "getDrivePosition", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DriveVelocity;", "getDriveVelocity", "Ljava/util/EnumMap;", "getDrives", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "jointType", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "getJointType", "()Lorg/valkyrienskies/core/internal/joints/VSJointType;", "getLinearLimits", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "getMaxForceTorque", "getMotions", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "getPose0", "getPose1", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitPyramid;", "getPyramidSwingLimit", "Ljava/lang/Long;", "getShipId0", "getShipId1", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitCone;", "getSwingLimit", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;", "getTwistLimit", "<init>", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLjava/util/EnumMap;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimit;Ljava/util/EnumMap;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitCone;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitPyramid;Ljava/util/EnumMap;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DrivePosition;Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DriveVelocity;)V", "AngularLimitPair", "D6Axis", "D6Drive", "D6JointDrive", "D6Motion", "DrivePosition", "DriveVelocity", "Hinges", "LimitCone", "LimitPyramid", "LinearLimit", "LinearLimitPair", "internal"})
@PhysTickOnly
@UnavailableInKrunch
public final class VSD6Joint
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
    private final EnumMap<D6Axis, D6Motion> motions;
    @Nullable
    private final LinearLimit distanceLimit;
    @Nullable
    private final EnumMap<D6Axis, LinearLimitPair> linearLimits;
    @Nullable
    private final AngularLimitPair twistLimit;
    @Nullable
    private final LimitCone swingLimit;
    @Nullable
    private final LimitPyramid pyramidSwingLimit;
    @Nullable
    private final EnumMap<D6Drive, D6JointDrive> drives;
    @Nullable
    private final DrivePosition drivePosition;
    @Nullable
    private final DriveVelocity driveVelocity;
    @NotNull
    private final VSJointType jointType;

    public VSD6Joint(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable EnumMap<D6Axis, D6Motion> motions, @Nullable LinearLimit distanceLimit, @Nullable EnumMap<D6Axis, LinearLimitPair> linearLimits, @Nullable AngularLimitPair twistLimit, @Nullable LimitCone swingLimit, @Nullable LimitPyramid pyramidSwingLimit, @Nullable EnumMap<D6Drive, D6JointDrive> drives, @Nullable DrivePosition drivePosition, @Nullable DriveVelocity driveVelocity) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        this.shipId0 = shipId0;
        this.pose0 = pose0;
        this.shipId1 = shipId1;
        this.pose1 = pose1;
        this.maxForceTorque = maxForceTorque;
        this.compliance = compliance;
        this.motions = motions;
        this.distanceLimit = distanceLimit;
        this.linearLimits = linearLimits;
        this.twistLimit = twistLimit;
        this.swingLimit = swingLimit;
        this.pyramidSwingLimit = pyramidSwingLimit;
        this.drives = drives;
        this.drivePosition = drivePosition;
        this.driveVelocity = driveVelocity;
        this.jointType = VSJointType.D6;
    }

    public /* synthetic */ VSD6Joint(Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, EnumMap enumMap, LinearLimit linearLimit, EnumMap enumMap2, AngularLimitPair angularLimitPair, LimitCone limitCone, LimitPyramid limitPyramid, EnumMap enumMap3, DrivePosition drivePosition, DriveVelocity driveVelocity, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = null;
        }
        if ((n2 & 0x20) != 0) {
            d2 = 1.0E-10;
        }
        if ((n2 & 0x40) != 0) {
            enumMap = null;
        }
        if ((n2 & 0x80) != 0) {
            linearLimit = null;
        }
        if ((n2 & 0x100) != 0) {
            enumMap2 = null;
        }
        if ((n2 & 0x200) != 0) {
            angularLimitPair = null;
        }
        if ((n2 & 0x400) != 0) {
            limitCone = null;
        }
        if ((n2 & 0x800) != 0) {
            limitPyramid = null;
        }
        if ((n2 & 0x1000) != 0) {
            enumMap3 = null;
        }
        if ((n2 & 0x2000) != 0) {
            drivePosition = null;
        }
        if ((n2 & 0x4000) != 0) {
            driveVelocity = null;
        }
        this(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, enumMap, linearLimit, enumMap2, angularLimitPair, limitCone, limitPyramid, enumMap3, drivePosition, driveVelocity);
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
    public final EnumMap<D6Axis, D6Motion> getMotions() {
        return this.motions;
    }

    @Nullable
    public final LinearLimit getDistanceLimit() {
        return this.distanceLimit;
    }

    @Nullable
    public final EnumMap<D6Axis, LinearLimitPair> getLinearLimits() {
        return this.linearLimits;
    }

    @Nullable
    public final AngularLimitPair getTwistLimit() {
        return this.twistLimit;
    }

    @Nullable
    public final LimitCone getSwingLimit() {
        return this.swingLimit;
    }

    @Nullable
    public final LimitPyramid getPyramidSwingLimit() {
        return this.pyramidSwingLimit;
    }

    @Nullable
    public final EnumMap<D6Drive, D6JointDrive> getDrives() {
        return this.drives;
    }

    @Nullable
    public final DrivePosition getDrivePosition() {
        return this.drivePosition;
    }

    @Nullable
    public final DriveVelocity getDriveVelocity() {
        return this.driveVelocity;
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
        return new VSD6Joint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.motions, this.distanceLimit, this.linearLimits, this.twistLimit, this.swingLimit, this.pyramidSwingLimit, this.drives, this.drivePosition, this.driveVelocity);
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
        return new VSD6Joint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.motions, this.distanceLimit, this.linearLimits, this.twistLimit, this.swingLimit, this.pyramidSwingLimit, this.drives, this.drivePosition, this.driveVelocity);
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
    public final EnumMap<D6Axis, D6Motion> component7() {
        return this.motions;
    }

    @Nullable
    public final LinearLimit component8() {
        return this.distanceLimit;
    }

    @Nullable
    public final EnumMap<D6Axis, LinearLimitPair> component9() {
        return this.linearLimits;
    }

    @Nullable
    public final AngularLimitPair component10() {
        return this.twistLimit;
    }

    @Nullable
    public final LimitCone component11() {
        return this.swingLimit;
    }

    @Nullable
    public final LimitPyramid component12() {
        return this.pyramidSwingLimit;
    }

    @Nullable
    public final EnumMap<D6Drive, D6JointDrive> component13() {
        return this.drives;
    }

    @Nullable
    public final DrivePosition component14() {
        return this.drivePosition;
    }

    @Nullable
    public final DriveVelocity component15() {
        return this.driveVelocity;
    }

    @NotNull
    public final VSD6Joint copy(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable EnumMap<D6Axis, D6Motion> motions, @Nullable LinearLimit distanceLimit, @Nullable EnumMap<D6Axis, LinearLimitPair> linearLimits, @Nullable AngularLimitPair twistLimit, @Nullable LimitCone swingLimit, @Nullable LimitPyramid pyramidSwingLimit, @Nullable EnumMap<D6Drive, D6JointDrive> drives, @Nullable DrivePosition drivePosition, @Nullable DriveVelocity driveVelocity) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        return new VSD6Joint(shipId0, pose0, shipId1, pose1, maxForceTorque, compliance, motions, distanceLimit, linearLimits, twistLimit, swingLimit, pyramidSwingLimit, drives, drivePosition, driveVelocity);
    }

    public static /* synthetic */ VSD6Joint copy$default(VSD6Joint vSD6Joint, Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, EnumMap enumMap, LinearLimit linearLimit, EnumMap enumMap2, AngularLimitPair angularLimitPair, LimitCone limitCone, LimitPyramid limitPyramid, EnumMap enumMap3, DrivePosition drivePosition, DriveVelocity driveVelocity, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = vSD6Joint.shipId0;
        }
        if ((n2 & 2) != 0) {
            vSJointPose = vSD6Joint.pose0;
        }
        if ((n2 & 4) != 0) {
            l3 = vSD6Joint.shipId1;
        }
        if ((n2 & 8) != 0) {
            vSJointPose2 = vSD6Joint.pose1;
        }
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = vSD6Joint.maxForceTorque;
        }
        if ((n2 & 0x20) != 0) {
            d2 = vSD6Joint.compliance;
        }
        if ((n2 & 0x40) != 0) {
            enumMap = vSD6Joint.motions;
        }
        if ((n2 & 0x80) != 0) {
            linearLimit = vSD6Joint.distanceLimit;
        }
        if ((n2 & 0x100) != 0) {
            enumMap2 = vSD6Joint.linearLimits;
        }
        if ((n2 & 0x200) != 0) {
            angularLimitPair = vSD6Joint.twistLimit;
        }
        if ((n2 & 0x400) != 0) {
            limitCone = vSD6Joint.swingLimit;
        }
        if ((n2 & 0x800) != 0) {
            limitPyramid = vSD6Joint.pyramidSwingLimit;
        }
        if ((n2 & 0x1000) != 0) {
            enumMap3 = vSD6Joint.drives;
        }
        if ((n2 & 0x2000) != 0) {
            drivePosition = vSD6Joint.drivePosition;
        }
        if ((n2 & 0x4000) != 0) {
            driveVelocity = vSD6Joint.driveVelocity;
        }
        return vSD6Joint.copy(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, enumMap, linearLimit, enumMap2, angularLimitPair, limitCone, limitPyramid, enumMap3, drivePosition, driveVelocity);
    }

    @NotNull
    public String toString() {
        return "VSD6Joint(shipId0=" + this.shipId0 + ", pose0=" + this.pose0 + ", shipId1=" + this.shipId1 + ", pose1=" + this.pose1 + ", maxForceTorque=" + this.maxForceTorque + ", compliance=" + this.compliance + ", motions=" + this.motions + ", distanceLimit=" + this.distanceLimit + ", linearLimits=" + this.linearLimits + ", twistLimit=" + this.twistLimit + ", swingLimit=" + this.swingLimit + ", pyramidSwingLimit=" + this.pyramidSwingLimit + ", drives=" + this.drives + ", drivePosition=" + this.drivePosition + ", driveVelocity=" + this.driveVelocity + ")";
    }

    public int hashCode() {
        int result2 = this.shipId0 == null ? 0 : ((Object)this.shipId0).hashCode();
        result2 = result2 * 31 + this.pose0.hashCode();
        result2 = result2 * 31 + (this.shipId1 == null ? 0 : ((Object)this.shipId1).hashCode());
        result2 = result2 * 31 + this.pose1.hashCode();
        result2 = result2 * 31 + (this.maxForceTorque == null ? 0 : this.maxForceTorque.hashCode());
        result2 = result2 * 31 + Double.hashCode(this.compliance);
        result2 = result2 * 31 + (this.motions == null ? 0 : this.motions.hashCode());
        result2 = result2 * 31 + (this.distanceLimit == null ? 0 : this.distanceLimit.hashCode());
        result2 = result2 * 31 + (this.linearLimits == null ? 0 : this.linearLimits.hashCode());
        result2 = result2 * 31 + (this.twistLimit == null ? 0 : this.twistLimit.hashCode());
        result2 = result2 * 31 + (this.swingLimit == null ? 0 : this.swingLimit.hashCode());
        result2 = result2 * 31 + (this.pyramidSwingLimit == null ? 0 : this.pyramidSwingLimit.hashCode());
        result2 = result2 * 31 + (this.drives == null ? 0 : this.drives.hashCode());
        result2 = result2 * 31 + (this.drivePosition == null ? 0 : this.drivePosition.hashCode());
        result2 = result2 * 31 + (this.driveVelocity == null ? 0 : this.driveVelocity.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSD6Joint)) {
            return false;
        }
        VSD6Joint vSD6Joint = (VSD6Joint)other;
        if (!Intrinsics.areEqual((Object)this.shipId0, (Object)vSD6Joint.shipId0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose0, (Object)vSD6Joint.pose0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipId1, (Object)vSD6Joint.shipId1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose1, (Object)vSD6Joint.pose1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maxForceTorque, (Object)vSD6Joint.maxForceTorque)) {
            return false;
        }
        if (Double.compare(this.compliance, vSD6Joint.compliance) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual(this.motions, vSD6Joint.motions)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.distanceLimit, (Object)vSD6Joint.distanceLimit)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.linearLimits, vSD6Joint.linearLimits)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.twistLimit, (Object)vSD6Joint.twistLimit)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.swingLimit, (Object)vSD6Joint.swingLimit)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pyramidSwingLimit, (Object)vSD6Joint.pyramidSwingLimit)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.drives, vSD6Joint.drives)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.drivePosition, (Object)vSD6Joint.drivePosition)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.driveVelocity, (Object)vSD6Joint.driveVelocity);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u0007JT\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b#\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b$\u0010\u0004\u00a8\u0006'"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;", "", "", "component1", "()F", "component2", "component3", "()Ljava/lang/Float;", "component4", "component5", "component6", "lowerLimit", "upperLimit", "restitution", "bounceThreshold", "stiffness", "damping", "copy", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Float;", "getBounceThreshold", "getDamping", "F", "getLowerLimit", "getRestitution", "getStiffness", "getUpperLimit", "<init>", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "internal"})
    public static final class AngularLimitPair {
        private final float lowerLimit;
        private final float upperLimit;
        @Nullable
        private final Float restitution;
        @Nullable
        private final Float bounceThreshold;
        @Nullable
        private final Float stiffness;
        @Nullable
        private final Float damping;

        public AngularLimitPair(float lowerLimit, float upperLimit, @Nullable Float restitution, @Nullable Float bounceThreshold, @Nullable Float stiffness, @Nullable Float damping) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
            this.restitution = restitution;
            this.bounceThreshold = bounceThreshold;
            this.stiffness = stiffness;
            this.damping = damping;
        }

        public /* synthetic */ AngularLimitPair(float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2, DefaultConstructorMarker defaultConstructorMarker) {
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

        public final float getLowerLimit() {
            return this.lowerLimit;
        }

        public final float getUpperLimit() {
            return this.upperLimit;
        }

        @Nullable
        public final Float getRestitution() {
            return this.restitution;
        }

        @Nullable
        public final Float getBounceThreshold() {
            return this.bounceThreshold;
        }

        @Nullable
        public final Float getStiffness() {
            return this.stiffness;
        }

        @Nullable
        public final Float getDamping() {
            return this.damping;
        }

        public final float component1() {
            return this.lowerLimit;
        }

        public final float component2() {
            return this.upperLimit;
        }

        @Nullable
        public final Float component3() {
            return this.restitution;
        }

        @Nullable
        public final Float component4() {
            return this.bounceThreshold;
        }

        @Nullable
        public final Float component5() {
            return this.stiffness;
        }

        @Nullable
        public final Float component6() {
            return this.damping;
        }

        @NotNull
        public final AngularLimitPair copy(float lowerLimit, float upperLimit, @Nullable Float restitution, @Nullable Float bounceThreshold, @Nullable Float stiffness, @Nullable Float damping) {
            return new AngularLimitPair(lowerLimit, upperLimit, restitution, bounceThreshold, stiffness, damping);
        }

        public static /* synthetic */ AngularLimitPair copy$default(AngularLimitPair angularLimitPair, float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = angularLimitPair.lowerLimit;
            }
            if ((n2 & 2) != 0) {
                f3 = angularLimitPair.upperLimit;
            }
            if ((n2 & 4) != 0) {
                f4 = angularLimitPair.restitution;
            }
            if ((n2 & 8) != 0) {
                f5 = angularLimitPair.bounceThreshold;
            }
            if ((n2 & 0x10) != 0) {
                f6 = angularLimitPair.stiffness;
            }
            if ((n2 & 0x20) != 0) {
                f7 = angularLimitPair.damping;
            }
            return angularLimitPair.copy(f2, f3, f4, f5, f6, f7);
        }

        @NotNull
        public String toString() {
            return "AngularLimitPair(lowerLimit=" + this.lowerLimit + ", upperLimit=" + this.upperLimit + ", restitution=" + this.restitution + ", bounceThreshold=" + this.bounceThreshold + ", stiffness=" + this.stiffness + ", damping=" + this.damping + ")";
        }

        public int hashCode() {
            int result2 = Float.hashCode(this.lowerLimit);
            result2 = result2 * 31 + Float.hashCode(this.upperLimit);
            result2 = result2 * 31 + (this.restitution == null ? 0 : ((Object)this.restitution).hashCode());
            result2 = result2 * 31 + (this.bounceThreshold == null ? 0 : ((Object)this.bounceThreshold).hashCode());
            result2 = result2 * 31 + (this.stiffness == null ? 0 : ((Object)this.stiffness).hashCode());
            result2 = result2 * 31 + (this.damping == null ? 0 : ((Object)this.damping).hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AngularLimitPair)) {
                return false;
            }
            AngularLimitPair angularLimitPair = (AngularLimitPair)other;
            if (Float.compare(this.lowerLimit, angularLimitPair.lowerLimit) != 0) {
                return false;
            }
            if (Float.compare(this.upperLimit, angularLimitPair.upperLimit) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.restitution, (Object)angularLimitPair.restitution)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.bounceThreshold, (Object)angularLimitPair.bounceThreshold)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.stiffness, (Object)angularLimitPair.stiffness)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.damping, (Object)angularLimitPair.damping);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Axis;", "", "<init>", "(Ljava/lang/String;I)V", "X", "Y", "Z", "TWIST", "SWING1", "SWING2", "internal"})
    public static final class D6Axis
    extends Enum<D6Axis> {
        public static final /* enum */ D6Axis X = new D6Axis();
        public static final /* enum */ D6Axis Y = new D6Axis();
        public static final /* enum */ D6Axis Z = new D6Axis();
        public static final /* enum */ D6Axis TWIST = new D6Axis();
        public static final /* enum */ D6Axis SWING1 = new D6Axis();
        public static final /* enum */ D6Axis SWING2 = new D6Axis();
        private static final /* synthetic */ D6Axis[] $VALUES;

        public static D6Axis[] values() {
            return (D6Axis[])$VALUES.clone();
        }

        public static D6Axis valueOf(String value) {
            return Enum.valueOf(D6Axis.class, value);
        }

        static {
            $VALUES = d6AxisArray = new D6Axis[]{D6Axis.X, D6Axis.Y, D6Axis.Z, D6Axis.TWIST, D6Axis.SWING1, D6Axis.SWING2};
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Drive;", "", "<init>", "(Ljava/lang/String;I)V", "X", "Y", "Z", "SWING", "TWIST", "SLERP", "internal"})
    public static final class D6Drive
    extends Enum<D6Drive> {
        public static final /* enum */ D6Drive X = new D6Drive();
        public static final /* enum */ D6Drive Y = new D6Drive();
        public static final /* enum */ D6Drive Z = new D6Drive();
        public static final /* enum */ D6Drive SWING = new D6Drive();
        public static final /* enum */ D6Drive TWIST = new D6Drive();
        public static final /* enum */ D6Drive SLERP = new D6Drive();
        private static final /* synthetic */ D6Drive[] $VALUES;

        public static D6Drive[] values() {
            return (D6Drive[])$VALUES.clone();
        }

        public static D6Drive valueOf(String value) {
            return Enum.valueOf(D6Drive.class, value);
        }

        static {
            $VALUES = d6DriveArray = new D6Drive[]{D6Drive.X, D6Drive.Y, D6Drive.Z, D6Drive.SWING, D6Drive.TWIST, D6Drive.SLERP};
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\r\u0010\t\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6JointDrive;", "", "", "component1", "()F", "component2", "component3", "", "component4", "()Z", "driveStiffness", "driveDamping", "driveForceLimit", "isAcceleration", "copy", "(FFFZ)Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6JointDrive;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "F", "getDriveDamping", "getDriveForceLimit", "getDriveStiffness", "Z", "<init>", "(FFFZ)V", "internal"})
    public static final class D6JointDrive {
        private final float driveStiffness;
        private final float driveDamping;
        private final float driveForceLimit;
        private final boolean isAcceleration;

        public D6JointDrive(float driveStiffness, float driveDamping, float driveForceLimit, boolean isAcceleration) {
            this.driveStiffness = driveStiffness;
            this.driveDamping = driveDamping;
            this.driveForceLimit = driveForceLimit;
            this.isAcceleration = isAcceleration;
        }

        public /* synthetic */ D6JointDrive(float f2, float f3, float f4, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 8) != 0) {
                bl = false;
            }
            this(f2, f3, f4, bl);
        }

        public final float getDriveStiffness() {
            return this.driveStiffness;
        }

        public final float getDriveDamping() {
            return this.driveDamping;
        }

        public final float getDriveForceLimit() {
            return this.driveForceLimit;
        }

        public final boolean isAcceleration() {
            return this.isAcceleration;
        }

        public final float component1() {
            return this.driveStiffness;
        }

        public final float component2() {
            return this.driveDamping;
        }

        public final float component3() {
            return this.driveForceLimit;
        }

        public final boolean component4() {
            return this.isAcceleration;
        }

        @NotNull
        public final D6JointDrive copy(float driveStiffness, float driveDamping, float driveForceLimit, boolean isAcceleration) {
            return new D6JointDrive(driveStiffness, driveDamping, driveForceLimit, isAcceleration);
        }

        public static /* synthetic */ D6JointDrive copy$default(D6JointDrive d6JointDrive, float f2, float f3, float f4, boolean bl, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = d6JointDrive.driveStiffness;
            }
            if ((n2 & 2) != 0) {
                f3 = d6JointDrive.driveDamping;
            }
            if ((n2 & 4) != 0) {
                f4 = d6JointDrive.driveForceLimit;
            }
            if ((n2 & 8) != 0) {
                bl = d6JointDrive.isAcceleration;
            }
            return d6JointDrive.copy(f2, f3, f4, bl);
        }

        @NotNull
        public String toString() {
            return "D6JointDrive(driveStiffness=" + this.driveStiffness + ", driveDamping=" + this.driveDamping + ", driveForceLimit=" + this.driveForceLimit + ", isAcceleration=" + this.isAcceleration + ")";
        }

        public int hashCode() {
            int result2 = Float.hashCode(this.driveStiffness);
            result2 = result2 * 31 + Float.hashCode(this.driveDamping);
            result2 = result2 * 31 + Float.hashCode(this.driveForceLimit);
            result2 = result2 * 31 + Boolean.hashCode(this.isAcceleration);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof D6JointDrive)) {
                return false;
            }
            D6JointDrive d6JointDrive = (D6JointDrive)other;
            if (Float.compare(this.driveStiffness, d6JointDrive.driveStiffness) != 0) {
                return false;
            }
            if (Float.compare(this.driveDamping, d6JointDrive.driveDamping) != 0) {
                return false;
            }
            if (Float.compare(this.driveForceLimit, d6JointDrive.driveForceLimit) != 0) {
                return false;
            }
            return this.isAcceleration == d6JointDrive.isAcceleration;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Motion;", "", "<init>", "(Ljava/lang/String;I)V", "LOCKED", "LIMITED", "FREE", "internal"})
    public static final class D6Motion
    extends Enum<D6Motion> {
        public static final /* enum */ D6Motion LOCKED = new D6Motion();
        public static final /* enum */ D6Motion LIMITED = new D6Motion();
        public static final /* enum */ D6Motion FREE = new D6Motion();
        private static final /* synthetic */ D6Motion[] $VALUES;

        public static D6Motion[] values() {
            return (D6Motion[])$VALUES.clone();
        }

        public static D6Motion valueOf(String value) {
            return Enum.valueOf(D6Motion.class, value);
        }

        static {
            $VALUES = d6MotionArray = new D6Motion[]{D6Motion.LOCKED, D6Motion.LIMITED, D6Motion.FREE};
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\u00a8\u0006\u001b"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DrivePosition;", "", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component1", "()Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "", "component2", "()Z", "pose", "autoWake", "copy", "(Lorg/valkyrienskies/core/internal/joints/VSJointPose;Z)Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DrivePosition;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getAutoWake", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "getPose", "<init>", "(Lorg/valkyrienskies/core/internal/joints/VSJointPose;Z)V", "internal"})
    public static final class DrivePosition {
        @NotNull
        private final VSJointPose pose;
        private final boolean autoWake;

        public DrivePosition(@NotNull VSJointPose pose, boolean autoWake) {
            Intrinsics.checkNotNullParameter((Object)pose, (String)"pose");
            this.pose = pose;
            this.autoWake = autoWake;
        }

        public /* synthetic */ DrivePosition(VSJointPose vSJointPose, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                bl = true;
            }
            this(vSJointPose, bl);
        }

        @NotNull
        public final VSJointPose getPose() {
            return this.pose;
        }

        public final boolean getAutoWake() {
            return this.autoWake;
        }

        @NotNull
        public final VSJointPose component1() {
            return this.pose;
        }

        public final boolean component2() {
            return this.autoWake;
        }

        @NotNull
        public final DrivePosition copy(@NotNull VSJointPose pose, boolean autoWake) {
            Intrinsics.checkNotNullParameter((Object)pose, (String)"pose");
            return new DrivePosition(pose, autoWake);
        }

        public static /* synthetic */ DrivePosition copy$default(DrivePosition drivePosition, VSJointPose vSJointPose, boolean bl, int n2, Object object) {
            if ((n2 & 1) != 0) {
                vSJointPose = drivePosition.pose;
            }
            if ((n2 & 2) != 0) {
                bl = drivePosition.autoWake;
            }
            return drivePosition.copy(vSJointPose, bl);
        }

        @NotNull
        public String toString() {
            return "DrivePosition(pose=" + this.pose + ", autoWake=" + this.autoWake + ")";
        }

        public int hashCode() {
            int result2 = this.pose.hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.autoWake);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DrivePosition)) {
                return false;
            }
            DrivePosition drivePosition = (DrivePosition)other;
            if (!Intrinsics.areEqual((Object)this.pose, (Object)drivePosition.pose)) {
                return false;
            }
            return this.autoWake == drivePosition.autoWake;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004\u00a8\u0006\u001e"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DriveVelocity;", "", "Lorg/joml/Vector3fc;", "component1", "()Lorg/joml/Vector3fc;", "component2", "", "component3", "()Z", "linear", "angular", "autoWake", "copy", "(Lorg/joml/Vector3fc;Lorg/joml/Vector3fc;Z)Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DriveVelocity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3fc;", "getAngular", "Z", "getAutoWake", "getLinear", "<init>", "(Lorg/joml/Vector3fc;Lorg/joml/Vector3fc;Z)V", "internal"})
    public static final class DriveVelocity {
        @NotNull
        private final Vector3fc linear;
        @NotNull
        private final Vector3fc angular;
        private final boolean autoWake;

        public DriveVelocity(@NotNull Vector3fc linear, @NotNull Vector3fc angular, boolean autoWake) {
            Intrinsics.checkNotNullParameter((Object)linear, (String)"linear");
            Intrinsics.checkNotNullParameter((Object)angular, (String)"angular");
            this.linear = linear;
            this.angular = angular;
            this.autoWake = autoWake;
        }

        public /* synthetic */ DriveVelocity(Vector3fc vector3fc, Vector3fc vector3fc2, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                bl = true;
            }
            this(vector3fc, vector3fc2, bl);
        }

        @NotNull
        public final Vector3fc getLinear() {
            return this.linear;
        }

        @NotNull
        public final Vector3fc getAngular() {
            return this.angular;
        }

        public final boolean getAutoWake() {
            return this.autoWake;
        }

        @NotNull
        public final Vector3fc component1() {
            return this.linear;
        }

        @NotNull
        public final Vector3fc component2() {
            return this.angular;
        }

        public final boolean component3() {
            return this.autoWake;
        }

        @NotNull
        public final DriveVelocity copy(@NotNull Vector3fc linear, @NotNull Vector3fc angular, boolean autoWake) {
            Intrinsics.checkNotNullParameter((Object)linear, (String)"linear");
            Intrinsics.checkNotNullParameter((Object)angular, (String)"angular");
            return new DriveVelocity(linear, angular, autoWake);
        }

        public static /* synthetic */ DriveVelocity copy$default(DriveVelocity driveVelocity, Vector3fc vector3fc, Vector3fc vector3fc2, boolean bl, int n2, Object object) {
            if ((n2 & 1) != 0) {
                vector3fc = driveVelocity.linear;
            }
            if ((n2 & 2) != 0) {
                vector3fc2 = driveVelocity.angular;
            }
            if ((n2 & 4) != 0) {
                bl = driveVelocity.autoWake;
            }
            return driveVelocity.copy(vector3fc, vector3fc2, bl);
        }

        @NotNull
        public String toString() {
            return "DriveVelocity(linear=" + this.linear + ", angular=" + this.angular + ", autoWake=" + this.autoWake + ")";
        }

        public int hashCode() {
            int result2 = this.linear.hashCode();
            result2 = result2 * 31 + this.angular.hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.autoWake);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DriveVelocity)) {
                return false;
            }
            DriveVelocity driveVelocity = (DriveVelocity)other;
            if (!Intrinsics.areEqual((Object)this.linear, (Object)driveVelocity.linear)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.angular, (Object)driveVelocity.angular)) {
                return false;
            }
            return this.autoWake == driveVelocity.autoWake;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0005J,\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005R\u001b\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0015\u0010\u0005\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;", "", "", "Lorg/valkyrienskies/core/internal/joints/VSJointId;", "component1", "()I", "component2", "hinge0", "hinge1", "copy", "(II)Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getHinge0", "getHinge1", "<init>", "(II)V", "internal"})
    public static final class Hinges {
        private final int hinge0;
        private final int hinge1;

        public Hinges(int hinge0, int hinge1) {
            this.hinge0 = hinge0;
            this.hinge1 = hinge1;
        }

        public final int getHinge0() {
            return this.hinge0;
        }

        public final int getHinge1() {
            return this.hinge1;
        }

        public final int component1() {
            return this.hinge0;
        }

        public final int component2() {
            return this.hinge1;
        }

        @NotNull
        public final Hinges copy(int hinge0, int hinge1) {
            return new Hinges(hinge0, hinge1);
        }

        public static /* synthetic */ Hinges copy$default(Hinges hinges, int n2, int n3, int n4, Object object) {
            if ((n4 & 1) != 0) {
                n2 = hinges.hinge0;
            }
            if ((n4 & 2) != 0) {
                n3 = hinges.hinge1;
            }
            return hinges.copy(n2, n3);
        }

        @NotNull
        public String toString() {
            return "Hinges(hinge0=" + this.hinge0 + ", hinge1=" + this.hinge1 + ")";
        }

        public int hashCode() {
            int result2 = Integer.hashCode(this.hinge0);
            result2 = result2 * 31 + Integer.hashCode(this.hinge1);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hinges)) {
                return false;
            }
            Hinges hinges = (Hinges)other;
            if (this.hinge0 != hinges.hinge0) {
                return false;
            }
            return this.hinge1 == hinges.hinge1;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u0007JT\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b \u0010\u0007R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b$\u0010\u0004\u00a8\u0006'"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitCone;", "", "", "component1", "()F", "component2", "component3", "()Ljava/lang/Float;", "component4", "component5", "component6", "yLimitAngle", "zLimitAngle", "restitution", "bounceThreshold", "stiffness", "damping", "copy", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitCone;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Float;", "getBounceThreshold", "getDamping", "getRestitution", "getStiffness", "F", "getYLimitAngle", "getZLimitAngle", "<init>", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "internal"})
    public static final class LimitCone {
        private final float yLimitAngle;
        private final float zLimitAngle;
        @Nullable
        private final Float restitution;
        @Nullable
        private final Float bounceThreshold;
        @Nullable
        private final Float stiffness;
        @Nullable
        private final Float damping;

        public LimitCone(float yLimitAngle, float zLimitAngle, @Nullable Float restitution, @Nullable Float bounceThreshold, @Nullable Float stiffness, @Nullable Float damping) {
            this.yLimitAngle = yLimitAngle;
            this.zLimitAngle = zLimitAngle;
            this.restitution = restitution;
            this.bounceThreshold = bounceThreshold;
            this.stiffness = stiffness;
            this.damping = damping;
        }

        public /* synthetic */ LimitCone(float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2, DefaultConstructorMarker defaultConstructorMarker) {
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

        public final float getYLimitAngle() {
            return this.yLimitAngle;
        }

        public final float getZLimitAngle() {
            return this.zLimitAngle;
        }

        @Nullable
        public final Float getRestitution() {
            return this.restitution;
        }

        @Nullable
        public final Float getBounceThreshold() {
            return this.bounceThreshold;
        }

        @Nullable
        public final Float getStiffness() {
            return this.stiffness;
        }

        @Nullable
        public final Float getDamping() {
            return this.damping;
        }

        public final float component1() {
            return this.yLimitAngle;
        }

        public final float component2() {
            return this.zLimitAngle;
        }

        @Nullable
        public final Float component3() {
            return this.restitution;
        }

        @Nullable
        public final Float component4() {
            return this.bounceThreshold;
        }

        @Nullable
        public final Float component5() {
            return this.stiffness;
        }

        @Nullable
        public final Float component6() {
            return this.damping;
        }

        @NotNull
        public final LimitCone copy(float yLimitAngle, float zLimitAngle, @Nullable Float restitution, @Nullable Float bounceThreshold, @Nullable Float stiffness, @Nullable Float damping) {
            return new LimitCone(yLimitAngle, zLimitAngle, restitution, bounceThreshold, stiffness, damping);
        }

        public static /* synthetic */ LimitCone copy$default(LimitCone limitCone, float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = limitCone.yLimitAngle;
            }
            if ((n2 & 2) != 0) {
                f3 = limitCone.zLimitAngle;
            }
            if ((n2 & 4) != 0) {
                f4 = limitCone.restitution;
            }
            if ((n2 & 8) != 0) {
                f5 = limitCone.bounceThreshold;
            }
            if ((n2 & 0x10) != 0) {
                f6 = limitCone.stiffness;
            }
            if ((n2 & 0x20) != 0) {
                f7 = limitCone.damping;
            }
            return limitCone.copy(f2, f3, f4, f5, f6, f7);
        }

        @NotNull
        public String toString() {
            return "LimitCone(yLimitAngle=" + this.yLimitAngle + ", zLimitAngle=" + this.zLimitAngle + ", restitution=" + this.restitution + ", bounceThreshold=" + this.bounceThreshold + ", stiffness=" + this.stiffness + ", damping=" + this.damping + ")";
        }

        public int hashCode() {
            int result2 = Float.hashCode(this.yLimitAngle);
            result2 = result2 * 31 + Float.hashCode(this.zLimitAngle);
            result2 = result2 * 31 + (this.restitution == null ? 0 : ((Object)this.restitution).hashCode());
            result2 = result2 * 31 + (this.bounceThreshold == null ? 0 : ((Object)this.bounceThreshold).hashCode());
            result2 = result2 * 31 + (this.stiffness == null ? 0 : ((Object)this.stiffness).hashCode());
            result2 = result2 * 31 + (this.damping == null ? 0 : ((Object)this.damping).hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LimitCone)) {
                return false;
            }
            LimitCone limitCone = (LimitCone)other;
            if (Float.compare(this.yLimitAngle, limitCone.yLimitAngle) != 0) {
                return false;
            }
            if (Float.compare(this.zLimitAngle, limitCone.zLimitAngle) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.restitution, (Object)limitCone.restitution)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.bounceThreshold, (Object)limitCone.bounceThreshold)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.stiffness, (Object)limitCone.stiffness)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.damping, (Object)limitCone.damping);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\tJh\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bH\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eH\u00d6\u0001\u00a2\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\tR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b#\u0010\tR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b$\u0010\tR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b%\u0010\tR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b(\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b)\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b*\u0010\u0004\u00a8\u0006-"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitPyramid;", "", "", "component1", "()F", "component2", "component3", "component4", "component5", "()Ljava/lang/Float;", "component6", "component7", "component8", "yLimitAngleMin", "yLimitAngleMax", "zLimitAngleMin", "zLimitAngleMax", "restitution", "bounceThreshold", "stiffness", "damping", "copy", "(FFFFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitPyramid;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Float;", "getBounceThreshold", "getDamping", "getRestitution", "getStiffness", "F", "getYLimitAngleMax", "getYLimitAngleMin", "getZLimitAngleMax", "getZLimitAngleMin", "<init>", "(FFFFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "internal"})
    public static final class LimitPyramid {
        private final float yLimitAngleMin;
        private final float yLimitAngleMax;
        private final float zLimitAngleMin;
        private final float zLimitAngleMax;
        @Nullable
        private final Float restitution;
        @Nullable
        private final Float bounceThreshold;
        @Nullable
        private final Float stiffness;
        @Nullable
        private final Float damping;

        public LimitPyramid(float yLimitAngleMin, float yLimitAngleMax, float zLimitAngleMin, float zLimitAngleMax, @Nullable Float restitution, @Nullable Float bounceThreshold, @Nullable Float stiffness, @Nullable Float damping) {
            this.yLimitAngleMin = yLimitAngleMin;
            this.yLimitAngleMax = yLimitAngleMax;
            this.zLimitAngleMin = zLimitAngleMin;
            this.zLimitAngleMax = zLimitAngleMax;
            this.restitution = restitution;
            this.bounceThreshold = bounceThreshold;
            this.stiffness = stiffness;
            this.damping = damping;
        }

        public /* synthetic */ LimitPyramid(float f2, float f3, float f4, float f5, Float f6, Float f7, Float f8, Float f9, int n2, DefaultConstructorMarker defaultConstructorMarker) {
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

        public final float getYLimitAngleMin() {
            return this.yLimitAngleMin;
        }

        public final float getYLimitAngleMax() {
            return this.yLimitAngleMax;
        }

        public final float getZLimitAngleMin() {
            return this.zLimitAngleMin;
        }

        public final float getZLimitAngleMax() {
            return this.zLimitAngleMax;
        }

        @Nullable
        public final Float getRestitution() {
            return this.restitution;
        }

        @Nullable
        public final Float getBounceThreshold() {
            return this.bounceThreshold;
        }

        @Nullable
        public final Float getStiffness() {
            return this.stiffness;
        }

        @Nullable
        public final Float getDamping() {
            return this.damping;
        }

        public final float component1() {
            return this.yLimitAngleMin;
        }

        public final float component2() {
            return this.yLimitAngleMax;
        }

        public final float component3() {
            return this.zLimitAngleMin;
        }

        public final float component4() {
            return this.zLimitAngleMax;
        }

        @Nullable
        public final Float component5() {
            return this.restitution;
        }

        @Nullable
        public final Float component6() {
            return this.bounceThreshold;
        }

        @Nullable
        public final Float component7() {
            return this.stiffness;
        }

        @Nullable
        public final Float component8() {
            return this.damping;
        }

        @NotNull
        public final LimitPyramid copy(float yLimitAngleMin, float yLimitAngleMax, float zLimitAngleMin, float zLimitAngleMax, @Nullable Float restitution, @Nullable Float bounceThreshold, @Nullable Float stiffness, @Nullable Float damping) {
            return new LimitPyramid(yLimitAngleMin, yLimitAngleMax, zLimitAngleMin, zLimitAngleMax, restitution, bounceThreshold, stiffness, damping);
        }

        public static /* synthetic */ LimitPyramid copy$default(LimitPyramid limitPyramid, float f2, float f3, float f4, float f5, Float f6, Float f7, Float f8, Float f9, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = limitPyramid.yLimitAngleMin;
            }
            if ((n2 & 2) != 0) {
                f3 = limitPyramid.yLimitAngleMax;
            }
            if ((n2 & 4) != 0) {
                f4 = limitPyramid.zLimitAngleMin;
            }
            if ((n2 & 8) != 0) {
                f5 = limitPyramid.zLimitAngleMax;
            }
            if ((n2 & 0x10) != 0) {
                f6 = limitPyramid.restitution;
            }
            if ((n2 & 0x20) != 0) {
                f7 = limitPyramid.bounceThreshold;
            }
            if ((n2 & 0x40) != 0) {
                f8 = limitPyramid.stiffness;
            }
            if ((n2 & 0x80) != 0) {
                f9 = limitPyramid.damping;
            }
            return limitPyramid.copy(f2, f3, f4, f5, f6, f7, f8, f9);
        }

        @NotNull
        public String toString() {
            return "LimitPyramid(yLimitAngleMin=" + this.yLimitAngleMin + ", yLimitAngleMax=" + this.yLimitAngleMax + ", zLimitAngleMin=" + this.zLimitAngleMin + ", zLimitAngleMax=" + this.zLimitAngleMax + ", restitution=" + this.restitution + ", bounceThreshold=" + this.bounceThreshold + ", stiffness=" + this.stiffness + ", damping=" + this.damping + ")";
        }

        public int hashCode() {
            int result2 = Float.hashCode(this.yLimitAngleMin);
            result2 = result2 * 31 + Float.hashCode(this.yLimitAngleMax);
            result2 = result2 * 31 + Float.hashCode(this.zLimitAngleMin);
            result2 = result2 * 31 + Float.hashCode(this.zLimitAngleMax);
            result2 = result2 * 31 + (this.restitution == null ? 0 : ((Object)this.restitution).hashCode());
            result2 = result2 * 31 + (this.bounceThreshold == null ? 0 : ((Object)this.bounceThreshold).hashCode());
            result2 = result2 * 31 + (this.stiffness == null ? 0 : ((Object)this.stiffness).hashCode());
            result2 = result2 * 31 + (this.damping == null ? 0 : ((Object)this.damping).hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LimitPyramid)) {
                return false;
            }
            LimitPyramid limitPyramid = (LimitPyramid)other;
            if (Float.compare(this.yLimitAngleMin, limitPyramid.yLimitAngleMin) != 0) {
                return false;
            }
            if (Float.compare(this.yLimitAngleMax, limitPyramid.yLimitAngleMax) != 0) {
                return false;
            }
            if (Float.compare(this.zLimitAngleMin, limitPyramid.zLimitAngleMin) != 0) {
                return false;
            }
            if (Float.compare(this.zLimitAngleMax, limitPyramid.zLimitAngleMax) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.restitution, (Object)limitPyramid.restitution)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.bounceThreshold, (Object)limitPyramid.bounceThreshold)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.stiffness, (Object)limitPyramid.stiffness)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.damping, (Object)limitPyramid.damping);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\u0006J2\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001b\u0010\u0006\u00a8\u0006\u001e"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimit;", "", "", "component1", "()F", "component2", "()Ljava/lang/Float;", "component3", "extent", "stiffness", "damping", "copy", "(FLjava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimit;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Float;", "getDamping", "F", "getExtent", "getStiffness", "<init>", "(FLjava/lang/Float;Ljava/lang/Float;)V", "internal"})
    public static final class LinearLimit {
        private final float extent;
        @Nullable
        private final Float stiffness;
        @Nullable
        private final Float damping;

        public LinearLimit(float extent, @Nullable Float stiffness, @Nullable Float damping) {
            this.extent = extent;
            this.stiffness = stiffness;
            this.damping = damping;
        }

        public /* synthetic */ LinearLimit(float f2, Float f3, Float f4, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                f3 = null;
            }
            if ((n2 & 4) != 0) {
                f4 = null;
            }
            this(f2, f3, f4);
        }

        public final float getExtent() {
            return this.extent;
        }

        @Nullable
        public final Float getStiffness() {
            return this.stiffness;
        }

        @Nullable
        public final Float getDamping() {
            return this.damping;
        }

        public final float component1() {
            return this.extent;
        }

        @Nullable
        public final Float component2() {
            return this.stiffness;
        }

        @Nullable
        public final Float component3() {
            return this.damping;
        }

        @NotNull
        public final LinearLimit copy(float extent, @Nullable Float stiffness, @Nullable Float damping) {
            return new LinearLimit(extent, stiffness, damping);
        }

        public static /* synthetic */ LinearLimit copy$default(LinearLimit linearLimit, float f2, Float f3, Float f4, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = linearLimit.extent;
            }
            if ((n2 & 2) != 0) {
                f3 = linearLimit.stiffness;
            }
            if ((n2 & 4) != 0) {
                f4 = linearLimit.damping;
            }
            return linearLimit.copy(f2, f3, f4);
        }

        @NotNull
        public String toString() {
            return "LinearLimit(extent=" + this.extent + ", stiffness=" + this.stiffness + ", damping=" + this.damping + ")";
        }

        public int hashCode() {
            int result2 = Float.hashCode(this.extent);
            result2 = result2 * 31 + (this.stiffness == null ? 0 : ((Object)this.stiffness).hashCode());
            result2 = result2 * 31 + (this.damping == null ? 0 : ((Object)this.damping).hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinearLimit)) {
                return false;
            }
            LinearLimit linearLimit = (LinearLimit)other;
            if (Float.compare(this.extent, linearLimit.extent) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.stiffness, (Object)linearLimit.stiffness)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.damping, (Object)linearLimit.damping);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u0007JT\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b#\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b$\u0010\u0004\u00a8\u0006'"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;", "", "", "component1", "()F", "component2", "component3", "()Ljava/lang/Float;", "component4", "component5", "component6", "lowerLimit", "upperLimit", "restitution", "bounceThreshold", "stiffness", "damping", "copy", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Float;", "getBounceThreshold", "getDamping", "F", "getLowerLimit", "getRestitution", "getStiffness", "getUpperLimit", "<init>", "(FFLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "internal"})
    public static final class LinearLimitPair {
        private final float lowerLimit;
        private final float upperLimit;
        @Nullable
        private final Float restitution;
        @Nullable
        private final Float bounceThreshold;
        @Nullable
        private final Float stiffness;
        @Nullable
        private final Float damping;

        public LinearLimitPair(float lowerLimit, float upperLimit, @Nullable Float restitution, @Nullable Float bounceThreshold, @Nullable Float stiffness, @Nullable Float damping) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
            this.restitution = restitution;
            this.bounceThreshold = bounceThreshold;
            this.stiffness = stiffness;
            this.damping = damping;
        }

        public /* synthetic */ LinearLimitPair(float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2, DefaultConstructorMarker defaultConstructorMarker) {
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

        public final float getLowerLimit() {
            return this.lowerLimit;
        }

        public final float getUpperLimit() {
            return this.upperLimit;
        }

        @Nullable
        public final Float getRestitution() {
            return this.restitution;
        }

        @Nullable
        public final Float getBounceThreshold() {
            return this.bounceThreshold;
        }

        @Nullable
        public final Float getStiffness() {
            return this.stiffness;
        }

        @Nullable
        public final Float getDamping() {
            return this.damping;
        }

        public final float component1() {
            return this.lowerLimit;
        }

        public final float component2() {
            return this.upperLimit;
        }

        @Nullable
        public final Float component3() {
            return this.restitution;
        }

        @Nullable
        public final Float component4() {
            return this.bounceThreshold;
        }

        @Nullable
        public final Float component5() {
            return this.stiffness;
        }

        @Nullable
        public final Float component6() {
            return this.damping;
        }

        @NotNull
        public final LinearLimitPair copy(float lowerLimit, float upperLimit, @Nullable Float restitution, @Nullable Float bounceThreshold, @Nullable Float stiffness, @Nullable Float damping) {
            return new LinearLimitPair(lowerLimit, upperLimit, restitution, bounceThreshold, stiffness, damping);
        }

        public static /* synthetic */ LinearLimitPair copy$default(LinearLimitPair linearLimitPair, float f2, float f3, Float f4, Float f5, Float f6, Float f7, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = linearLimitPair.lowerLimit;
            }
            if ((n2 & 2) != 0) {
                f3 = linearLimitPair.upperLimit;
            }
            if ((n2 & 4) != 0) {
                f4 = linearLimitPair.restitution;
            }
            if ((n2 & 8) != 0) {
                f5 = linearLimitPair.bounceThreshold;
            }
            if ((n2 & 0x10) != 0) {
                f6 = linearLimitPair.stiffness;
            }
            if ((n2 & 0x20) != 0) {
                f7 = linearLimitPair.damping;
            }
            return linearLimitPair.copy(f2, f3, f4, f5, f6, f7);
        }

        @NotNull
        public String toString() {
            return "LinearLimitPair(lowerLimit=" + this.lowerLimit + ", upperLimit=" + this.upperLimit + ", restitution=" + this.restitution + ", bounceThreshold=" + this.bounceThreshold + ", stiffness=" + this.stiffness + ", damping=" + this.damping + ")";
        }

        public int hashCode() {
            int result2 = Float.hashCode(this.lowerLimit);
            result2 = result2 * 31 + Float.hashCode(this.upperLimit);
            result2 = result2 * 31 + (this.restitution == null ? 0 : ((Object)this.restitution).hashCode());
            result2 = result2 * 31 + (this.bounceThreshold == null ? 0 : ((Object)this.bounceThreshold).hashCode());
            result2 = result2 * 31 + (this.stiffness == null ? 0 : ((Object)this.stiffness).hashCode());
            result2 = result2 * 31 + (this.damping == null ? 0 : ((Object)this.damping).hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinearLimitPair)) {
                return false;
            }
            LinearLimitPair linearLimitPair = (LinearLimitPair)other;
            if (Float.compare(this.lowerLimit, linearLimitPair.lowerLimit) != 0) {
                return false;
            }
            if (Float.compare(this.upperLimit, linearLimitPair.upperLimit) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.restitution, (Object)linearLimitPair.restitution)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.bounceThreshold, (Object)linearLimitPair.bounceThreshold)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.stiffness, (Object)linearLimitPair.stiffness)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.damping, (Object)linearLimitPair.damping);
        }
    }
}

