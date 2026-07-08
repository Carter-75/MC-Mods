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

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001:\u0001PBq\u0012\u000e\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u000e\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\bN\u0010OJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\n\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0082\u0001\u0010#\u001a\u00020\u00002\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00062\u0010\b\u0002\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0017H\u00c6\u0001\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%H\u00d6\u0003\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*H\u00d6\u0001\u00a2\u0006\u0004\b+\u0010,J\u001f\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-H\u0016\u00a2\u0006\u0004\b0\u00101J\u001f\u00104\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u000206H\u00d6\u0001\u00a2\u0006\u0004\b7\u00108R\u001a\u0010\u001f\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001f\u00109\u001a\u0004\b:\u0010\u0010R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\"\u0010;\u001a\u0004\b<\u0010\u0019R\u0019\u0010 \u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b \u0010=\u001a\u0004\b>\u0010\u0013R\u001a\u0010@\u001a\u00020?8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010D\u001a\u0004\bE\u0010\rR\u001a\u0010\u001b\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010F\u001a\u0004\bG\u0010\bR\u001a\u0010\u001d\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010F\u001a\u0004\bH\u0010\bR\u0019\u0010!\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b!\u0010I\u001a\u0004\bJ\u0010\u0016R\"\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010K\u001a\u0004\bL\u0010\u0005R\"\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010K\u001a\u0004\bM\u0010\u0005\u00a8\u0006Q"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint;", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()Ljava/lang/Long;", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component2", "()Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "component3", "component4", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "component5", "()Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "", "component6", "()D", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;", "component7", "()Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;", "", "component8", "()Ljava/lang/Float;", "Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint$VSRackAndPinionJointData;", "component9", "()Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint$VSRackAndPinionJointData;", "shipId0", "pose0", "shipId1", "pose1", "maxForceTorque", "compliance", "hinges", "ratio", "data", "copy", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;Ljava/lang/Float;Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint$VSRackAndPinionJointData;)Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lorg/joml/Vector3dc;", "offset0", "offset1", "offsetLocalPositions", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "scale0", "scale1", "scaleLocalPositions", "(DD)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "toString", "()Ljava/lang/String;", "D", "getCompliance", "Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint$VSRackAndPinionJointData;", "getData", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;", "getHinges", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "jointType", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "getJointType", "()Lorg/valkyrienskies/core/internal/joints/VSJointType;", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "getMaxForceTorque", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "getPose0", "getPose1", "Ljava/lang/Float;", "getRatio", "Ljava/lang/Long;", "getShipId0", "getShipId1", "<init>", "(Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Ljava/lang/Long;Lorg/valkyrienskies/core/internal/joints/VSJointPose;Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;DLorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;Ljava/lang/Float;Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint$VSRackAndPinionJointData;)V", "VSRackAndPinionJointData", "internal"})
@PhysTickOnly
@UnavailableInKrunch
public final class VSRackAndPinionJoint
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
    private final Float ratio;
    @Nullable
    private final VSRackAndPinionJointData data;
    @NotNull
    private final VSJointType jointType;

    public VSRackAndPinionJoint(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable VSD6Joint.Hinges hinges, @Nullable Float ratio, @Nullable VSRackAndPinionJointData data) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        this.shipId0 = shipId0;
        this.pose0 = pose0;
        this.shipId1 = shipId1;
        this.pose1 = pose1;
        this.maxForceTorque = maxForceTorque;
        this.compliance = compliance;
        this.hinges = hinges;
        this.ratio = ratio;
        this.data = data;
        this.jointType = VSJointType.RACK_AND_PINION;
    }

    public /* synthetic */ VSRackAndPinionJoint(Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, VSD6Joint.Hinges hinges, Float f2, VSRackAndPinionJointData vSRackAndPinionJointData, int n2, DefaultConstructorMarker defaultConstructorMarker) {
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
        if ((n2 & 0x100) != 0) {
            vSRackAndPinionJointData = null;
        }
        this(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, hinges, f2, vSRackAndPinionJointData);
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
    public final Float getRatio() {
        return this.ratio;
    }

    @Nullable
    public final VSRackAndPinionJointData getData() {
        return this.data;
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
        return new VSRackAndPinionJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.hinges, this.ratio, this.data);
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
        return new VSRackAndPinionJoint(l2, vSJointPose, l3, new VSJointPose(vector3d2, this.getPose1().getRot()), this.getMaxForceTorque(), this.getCompliance(), this.hinges, this.ratio, this.data);
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
        return this.ratio;
    }

    @Nullable
    public final VSRackAndPinionJointData component9() {
        return this.data;
    }

    @NotNull
    public final VSRackAndPinionJoint copy(@Nullable Long shipId0, @NotNull VSJointPose pose0, @Nullable Long shipId1, @NotNull VSJointPose pose1, @Nullable VSJointMaxForceTorque maxForceTorque, double compliance, @Nullable VSD6Joint.Hinges hinges, @Nullable Float ratio, @Nullable VSRackAndPinionJointData data) {
        Intrinsics.checkNotNullParameter((Object)pose0, (String)"pose0");
        Intrinsics.checkNotNullParameter((Object)pose1, (String)"pose1");
        return new VSRackAndPinionJoint(shipId0, pose0, shipId1, pose1, maxForceTorque, compliance, hinges, ratio, data);
    }

    public static /* synthetic */ VSRackAndPinionJoint copy$default(VSRackAndPinionJoint vSRackAndPinionJoint, Long l2, VSJointPose vSJointPose, Long l3, VSJointPose vSJointPose2, VSJointMaxForceTorque vSJointMaxForceTorque, double d2, VSD6Joint.Hinges hinges, Float f2, VSRackAndPinionJointData vSRackAndPinionJointData, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = vSRackAndPinionJoint.shipId0;
        }
        if ((n2 & 2) != 0) {
            vSJointPose = vSRackAndPinionJoint.pose0;
        }
        if ((n2 & 4) != 0) {
            l3 = vSRackAndPinionJoint.shipId1;
        }
        if ((n2 & 8) != 0) {
            vSJointPose2 = vSRackAndPinionJoint.pose1;
        }
        if ((n2 & 0x10) != 0) {
            vSJointMaxForceTorque = vSRackAndPinionJoint.maxForceTorque;
        }
        if ((n2 & 0x20) != 0) {
            d2 = vSRackAndPinionJoint.compliance;
        }
        if ((n2 & 0x40) != 0) {
            hinges = vSRackAndPinionJoint.hinges;
        }
        if ((n2 & 0x80) != 0) {
            f2 = vSRackAndPinionJoint.ratio;
        }
        if ((n2 & 0x100) != 0) {
            vSRackAndPinionJointData = vSRackAndPinionJoint.data;
        }
        return vSRackAndPinionJoint.copy(l2, vSJointPose, l3, vSJointPose2, vSJointMaxForceTorque, d2, hinges, f2, vSRackAndPinionJointData);
    }

    @NotNull
    public String toString() {
        return "VSRackAndPinionJoint(shipId0=" + this.shipId0 + ", pose0=" + this.pose0 + ", shipId1=" + this.shipId1 + ", pose1=" + this.pose1 + ", maxForceTorque=" + this.maxForceTorque + ", compliance=" + this.compliance + ", hinges=" + this.hinges + ", ratio=" + this.ratio + ", data=" + this.data + ")";
    }

    public int hashCode() {
        int result2 = this.shipId0 == null ? 0 : ((Object)this.shipId0).hashCode();
        result2 = result2 * 31 + this.pose0.hashCode();
        result2 = result2 * 31 + (this.shipId1 == null ? 0 : ((Object)this.shipId1).hashCode());
        result2 = result2 * 31 + this.pose1.hashCode();
        result2 = result2 * 31 + (this.maxForceTorque == null ? 0 : this.maxForceTorque.hashCode());
        result2 = result2 * 31 + Double.hashCode(this.compliance);
        result2 = result2 * 31 + (this.hinges == null ? 0 : this.hinges.hashCode());
        result2 = result2 * 31 + (this.ratio == null ? 0 : ((Object)this.ratio).hashCode());
        result2 = result2 * 31 + (this.data == null ? 0 : this.data.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSRackAndPinionJoint)) {
            return false;
        }
        VSRackAndPinionJoint vSRackAndPinionJoint = (VSRackAndPinionJoint)other;
        if (!Intrinsics.areEqual((Object)this.shipId0, (Object)vSRackAndPinionJoint.shipId0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose0, (Object)vSRackAndPinionJoint.pose0)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipId1, (Object)vSRackAndPinionJoint.shipId1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pose1, (Object)vSRackAndPinionJoint.pose1)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maxForceTorque, (Object)vSRackAndPinionJoint.maxForceTorque)) {
            return false;
        }
        if (Double.compare(this.compliance, vSRackAndPinionJoint.compliance) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.hinges, (Object)vSRackAndPinionJoint.hinges)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.ratio, (Object)vSRackAndPinionJoint.ratio)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.data, (Object)vSRackAndPinionJoint.data);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004\u00a8\u0006\u001d"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint$VSRackAndPinionJointData;", "", "", "component1", "()I", "component2", "", "component3", "()F", "rackTeeth", "pinionTeeth", "rackLength", "copy", "(IIF)Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint$VSRackAndPinionJointData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getPinionTeeth", "F", "getRackLength", "getRackTeeth", "<init>", "(IIF)V", "internal"})
    public static final class VSRackAndPinionJointData {
        private final int rackTeeth;
        private final int pinionTeeth;
        private final float rackLength;

        public VSRackAndPinionJointData(int rackTeeth, int pinionTeeth, float rackLength) {
            this.rackTeeth = rackTeeth;
            this.pinionTeeth = pinionTeeth;
            this.rackLength = rackLength;
        }

        public final int getRackTeeth() {
            return this.rackTeeth;
        }

        public final int getPinionTeeth() {
            return this.pinionTeeth;
        }

        public final float getRackLength() {
            return this.rackLength;
        }

        public final int component1() {
            return this.rackTeeth;
        }

        public final int component2() {
            return this.pinionTeeth;
        }

        public final float component3() {
            return this.rackLength;
        }

        @NotNull
        public final VSRackAndPinionJointData copy(int rackTeeth, int pinionTeeth, float rackLength) {
            return new VSRackAndPinionJointData(rackTeeth, pinionTeeth, rackLength);
        }

        public static /* synthetic */ VSRackAndPinionJointData copy$default(VSRackAndPinionJointData vSRackAndPinionJointData, int n2, int n3, float f2, int n4, Object object) {
            if ((n4 & 1) != 0) {
                n2 = vSRackAndPinionJointData.rackTeeth;
            }
            if ((n4 & 2) != 0) {
                n3 = vSRackAndPinionJointData.pinionTeeth;
            }
            if ((n4 & 4) != 0) {
                f2 = vSRackAndPinionJointData.rackLength;
            }
            return vSRackAndPinionJointData.copy(n2, n3, f2);
        }

        @NotNull
        public String toString() {
            return "VSRackAndPinionJointData(rackTeeth=" + this.rackTeeth + ", pinionTeeth=" + this.pinionTeeth + ", rackLength=" + this.rackLength + ")";
        }

        public int hashCode() {
            int result2 = Integer.hashCode(this.rackTeeth);
            result2 = result2 * 31 + Integer.hashCode(this.pinionTeeth);
            result2 = result2 * 31 + Float.hashCode(this.rackLength);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VSRackAndPinionJointData)) {
                return false;
            }
            VSRackAndPinionJointData vSRackAndPinionJointData = (VSRackAndPinionJointData)other;
            if (this.rackTeeth != vSRackAndPinionJointData.rackTeeth) {
                return false;
            }
            if (this.pinionTeeth != vSRackAndPinionJointData.pinionTeeth) {
                return false;
            }
            return Float.compare(this.rackLength, vSRackAndPinionJointData.rackLength) == 0;
        }
    }
}

