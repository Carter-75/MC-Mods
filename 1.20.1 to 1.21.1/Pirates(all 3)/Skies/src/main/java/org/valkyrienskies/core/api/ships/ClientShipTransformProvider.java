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
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u000b\u0010\f\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\r\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/ClientShipTransformProvider;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "prevShipTransform", "shipTransform", "", "partialTick", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "provideNextRenderTransform", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;D)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "latestNetworkTransform", "provideNextTransform", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "api"})
public interface ClientShipTransformProvider {
    @Nullable
    public BodyTransform provideNextTransform(@NotNull ShipTransform var1, @NotNull ShipTransform var2, @NotNull ShipTransform var3);

    @Nullable
    public BodyTransform provideNextRenderTransform(@NotNull ShipTransform var1, @NotNull ShipTransform var2, double var3);
}

