/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.joints;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.util.PhysTickOnly;
import org.valkyrienskies.core.internal.joints.VSD6Joint;
import org.valkyrienskies.core.internal.joints.VSDistanceJoint;
import org.valkyrienskies.core.internal.joints.VSFixedJoint;
import org.valkyrienskies.core.internal.joints.VSGearJoint;
import org.valkyrienskies.core.internal.joints.VSJointMaxForceTorque;
import org.valkyrienskies.core.internal.joints.VSJointPose;
import org.valkyrienskies.core.internal.joints.VSJointType;
import org.valkyrienskies.core.internal.joints.VSPrismaticJoint;
import org.valkyrienskies.core.internal.joints.VSRackAndPinionJoint;
import org.valkyrienskies.core.internal.joints.VSRevoluteJoint;
import org.valkyrienskies.core.internal.joints.VSSphericalJoint;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes(value={@JsonSubTypes.Type(value=VSFixedJoint.class, name="fixed"), @JsonSubTypes.Type(value=VSDistanceJoint.class, name="distance"), @JsonSubTypes.Type(value=VSPrismaticJoint.class, name="prismatic"), @JsonSubTypes.Type(value=VSSphericalJoint.class, name="spherical"), @JsonSubTypes.Type(value=VSRevoluteJoint.class, name="revolute"), @JsonSubTypes.Type(value=VSGearJoint.class, name="gear"), @JsonSubTypes.Type(value=VSRackAndPinionJoint.class, name="rack_and_pinion"), @JsonSubTypes.Type(value=VSD6Joint.class, name="d6")})
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 $2\u00020\u0001:\u0001$J\u001f\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010!\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010 \u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006%\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "Lorg/joml/Vector3dc;", "offset0", "offset1", "offsetLocalPositions", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "", "scale0", "scale1", "scaleLocalPositions", "(DD)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "getCompliance", "()D", "compliance", "Lorg/valkyrienskies/core/internal/joints/VSJointType;", "getJointType", "()Lorg/valkyrienskies/core/internal/joints/VSJointType;", "jointType", "Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "getMaxForceTorque", "()Lorg/valkyrienskies/core/internal/joints/VSJointMaxForceTorque;", "maxForceTorque", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "getPose0", "()Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "pose0", "getPose1", "pose1", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getShipId0", "()Ljava/lang/Long;", "shipId0", "getShipId1", "shipId1", "Companion", "internal"})
@PhysTickOnly
public interface VSJoint {
    @NotNull
    public static final Companion Companion = org.valkyrienskies.core.internal.joints.VSJoint$Companion.$$INSTANCE;
    public static final double DEFAULT_COMPLIANCE = 1.0E-10;

    @Nullable
    public Long getShipId0();

    @NotNull
    public VSJointPose getPose0();

    @Nullable
    public Long getShipId1();

    @NotNull
    public VSJointPose getPose1();

    @Nullable
    public VSJointMaxForceTorque getMaxForceTorque();

    @NotNull
    public VSJointType getJointType();

    public double getCompliance();

    @NotNull
    public VSJoint offsetLocalPositions(@NotNull Vector3dc var1, @NotNull Vector3dc var2);

    @NotNull
    public VSJoint scaleLocalPositions(double var1, double var3);

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSJoint$Companion;", "", "", "DEFAULT_COMPLIANCE", "D", "<init>", "()V", "internal"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        public static final double DEFAULT_COMPLIANCE = 1.0E-10;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

