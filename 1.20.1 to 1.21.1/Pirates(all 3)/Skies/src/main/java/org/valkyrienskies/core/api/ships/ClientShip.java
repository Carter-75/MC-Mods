/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.ClientShipTransformProvider;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.util.GameTickOnly;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0010\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lorg/valkyrienskies/core/api/ships/LoadedShip;", "Lorg/joml/primitives/AABBdc;", "getRenderAABB", "()Lorg/joml/primitives/AABBdc;", "renderAABB", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getRenderTransform", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "renderTransform", "Lorg/valkyrienskies/core/api/ships/ClientShipTransformProvider;", "getTransformProvider", "()Lorg/valkyrienskies/core/api/ships/ClientShipTransformProvider;", "setTransformProvider", "(Lorg/valkyrienskies/core/api/ships/ClientShipTransformProvider;)V", "transformProvider", "api"})
@GameTickOnly
public interface ClientShip
extends LoadedShip {
    @NotNull
    public ShipTransform getRenderTransform();

    @NotNull
    public AABBdc getRenderAABB();

    @Nullable
    public ClientShipTransformProvider getTransformProvider();

    public void setTransformProvider(@Nullable ClientShipTransformProvider var1);
}

