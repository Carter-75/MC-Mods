/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.bodies.properties;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\n\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/properties/BodyPose;", "", "Lorg/joml/Vector3dc;", "getPosition", "()Lorg/joml/Vector3dc;", "position", "Lorg/joml/Quaterniondc;", "getRotation", "()Lorg/joml/Quaterniondc;", "rotation", "api"})
public interface BodyPose {
    @NotNull
    public Vector3dc getPosition();

    @NotNull
    public Quaterniondc getRotation();
}

