/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.game.ships;

import kotlin.Metadata;
import org.valkyrienskies.core.impl.game.ships.ShipObjectClientWorld;
import org.valkyrienskies.core.impl.shadow.EC;
import org.valkyrienskies.core.impl.shadow.dz_1;

@dz_1(a={EC.class, EC.a.class})
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorldComponent;", "", "Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorld;", "newWorld", "()Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorld;", "Factory"})
public interface ShipObjectClientWorldComponent {
    public ShipObjectClientWorld newWorld();

    @dz_1.b
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorldComponent$Factory;", "", "Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorldComponent;", "newShipObjectClientWorldComponent", "()Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorldComponent;"})
    public static interface Factory {
        public ShipObjectClientWorldComponent newShipObjectClientWorldComponent();
    }
}

