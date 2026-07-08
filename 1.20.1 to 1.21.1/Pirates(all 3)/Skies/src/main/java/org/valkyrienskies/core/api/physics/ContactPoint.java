/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.physics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.util.PhysTickOnly;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0004\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000e\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/physics/ContactPoint;", "", "Lorg/joml/Vector3dc;", "getNormal", "()Lorg/joml/Vector3dc;", "normal", "getPosition", "position", "", "getSeparation", "()F", "separation", "getVelocity", "velocity", "api"})
@PhysTickOnly
public interface ContactPoint {
    @NotNull
    public Vector3dc getPosition();

    @NotNull
    public Vector3dc getNormal();

    public float getSeparation();

    @NotNull
    public Vector3dc getVelocity();
}

