/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipinertia;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix3d;
import org.joml.Matrix3dc;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.impl.game.ships.ShipInertiaDataImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.dto.ShipInertiaDataV0;
import org.valkyrienskies.core.impl.shadow.dy_1;

@dy_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\n"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/ShipInertiaConverter;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "model", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "convertToDto", "(Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "data", "Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;", "convertToModel", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;)Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;", "<init>", "()V"})
public final class ShipInertiaConverter {
    @Inject
    public ShipInertiaConverter() {
    }

    /*
     * WARNING - void declaration
     */
    public final ShipInertiaDataImpl convertToModel(ShipInertiaDataV0 data) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)data, (String)"");
        return new ShipInertiaDataImpl(data.getCenterOfMassInShipSpace(), data.getShipMass(), var1_1.getMomentOfInertiaTensor());
    }

    /*
     * WARNING - void declaration
     */
    public final ShipInertiaDataV0 convertToDto(ShipInertiaData model) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)model, (String)"");
        Matrix3dc matrix3dc = ((ShipInertiaDataImpl)model).getMomentOfInertiaTensorToSave();
        return new ShipInertiaDataV0(new Vector3d(model.getCenterOfMassInShip()), var1_1.getMass(), new Matrix3d(matrix3dc));
    }
}

