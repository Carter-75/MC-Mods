/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shiptransform;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.ShipTransformConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.dto.ShipTransformDataV0;
import org.valkyrienskies.core.impl.shadow.dy_1;
import org.valkyrienskies.core.impl.shadow.eu_0;

@dy_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverter;", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "model", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "convertToDto", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "data", "convertToModel", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "<init>", "()V"})
public final class ShipTransformConverterImpl
implements ShipTransformConverter {
    @Inject
    public ShipTransformConverterImpl() {
    }

    @Override
    public final ShipTransform convertToModel(ShipTransformDataV0 data) {
        Vector3dc vector3dc;
        Intrinsics.checkNotNullParameter((Object)data, (String)"");
        Vector3dc vector3dc2 = data.getShipPositionInShipCoordinates();
        Vector3dc vector3dc3 = data.getShipPositionInWorldCoordinates();
        Quaterniondc quaterniondc = data.getShipCoordinatesToWorldCoordinatesRotation();
        vector3dc = ((ShipTransformDataV0)((Object)vector3dc)).getShipCoordinatesToWorldCoordinatesScaling();
        return eu_0.a(vector3dc3, vector3dc2, quaterniondc, vector3dc);
    }

    @Override
    public final ShipTransformDataV0 convertToDto(ShipTransform model) {
        Vector3dc vector3dc;
        Intrinsics.checkNotNullParameter((Object)model, (String)"");
        Vector3dc vector3dc2 = model.getPositionInShip();
        Vector3dc vector3dc3 = model.getPositionInWorld();
        Quaterniondc quaterniondc = model.getShipToWorldRotation();
        vector3dc = vector3dc.getShipToWorldScaling();
        return new ShipTransformDataV0(vector3dc3, vector3dc2, quaterniondc, vector3dc);
    }
}

