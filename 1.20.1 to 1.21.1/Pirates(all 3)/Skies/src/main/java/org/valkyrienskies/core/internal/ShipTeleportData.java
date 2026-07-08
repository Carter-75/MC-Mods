/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u000e\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001e\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/ShipTeleportData;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "oldShipTransform", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "createNewShipTransform", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "", "Lorg/valkyrienskies/core/internal/world/properties/DimensionId;", "getNewDimension", "()Ljava/lang/String;", "newDimension", "Lorg/joml/Vector3dc;", "getNewOmega", "()Lorg/joml/Vector3dc;", "newOmega", "getNewPos", "newPos", "getNewPosInShip", "newPosInShip", "Lorg/joml/Quaterniondc;", "getNewRot", "()Lorg/joml/Quaterniondc;", "newRot", "", "getNewScale", "()Ljava/lang/Double;", "newScale", "getNewVel", "newVel", "internal"})
public interface ShipTeleportData {
    @NotNull
    public Vector3dc getNewPos();

    @Nullable
    public Vector3dc getNewPosInShip();

    @NotNull
    public Quaterniondc getNewRot();

    @NotNull
    public Vector3dc getNewVel();

    @NotNull
    public Vector3dc getNewOmega();

    @Nullable
    public String getNewDimension();

    @Nullable
    public Double getNewScale();

    @NotNull
    public BodyKinematics createNewShipTransform(@NotNull ShipTransform var1);
}

