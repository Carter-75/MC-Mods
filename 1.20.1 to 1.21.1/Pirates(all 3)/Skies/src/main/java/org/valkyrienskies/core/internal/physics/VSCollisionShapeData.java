/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.physics;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.physics.VSBoxCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSCapsuleCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSCollisionShapes;
import org.valkyrienskies.core.internal.physics.VSSphereCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSVoxelCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSWheelCollisionShapeData;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes(value={@JsonSubTypes.Type(value=VSVoxelCollisionShapeData.class, name="voxel"), @JsonSubTypes.Type(value=VSSphereCollisionShapeData.class, name="sphere"), @JsonSubTypes.Type(value=VSWheelCollisionShapeData.class, name="wheel"), @JsonSubTypes.Type(value=VSBoxCollisionShapeData.class, name="box"), @JsonSubTypes.Type(value=VSCapsuleCollisionShapeData.class, name="capsule")})
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "getShapeType", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "shapeType", "internal"})
public interface VSCollisionShapeData {
    @NotNull
    public VSCollisionShapes getShapeType();
}

