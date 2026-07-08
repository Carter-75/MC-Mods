/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shiptransform;

import kotlin.Metadata;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.ShipTransformConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.ShipTransformConverterImpl;
import org.valkyrienskies.core.impl.shadow.dp_1;
import org.valkyrienskies.core.impl.shadow.dw_1;

@dw_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformModule;", "", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverterImpl;", "impl", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverter;", "converter", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverter;"})
public interface ShipTransformModule {
    @dp_1
    public ShipTransformConverter converter(ShipTransformConverterImpl var1);
}

