/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.ships;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.Ship;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\t\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/ships/VsiShip;", "Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "", "setFromTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "kinematics", "unsafeSetKinematics", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;)V", "internal"})
public interface VsiShip
extends Ship {
    public void setFromTransform(@NotNull BodyTransform var1);

    public void unsafeSetKinematics(@NotNull BodyKinematics var1);
}

