/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shiptransform;

import kotlin.Metadata;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.dto.ShipTransformDataV0;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\b\u0010\t\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverter;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "model", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "convertToDto", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "data", "convertToModel", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;"})
public interface ShipTransformConverter {
    public ShipTransform convertToModel(ShipTransformDataV0 var1);

    public ShipTransformDataV0 convertToDto(ShipTransform var1);
}

