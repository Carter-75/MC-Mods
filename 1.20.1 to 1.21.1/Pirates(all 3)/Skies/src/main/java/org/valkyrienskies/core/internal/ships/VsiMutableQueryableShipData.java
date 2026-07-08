/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableIterable
 */
package org.valkyrienskies.core.internal.ships;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterable;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001d\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0017\u00a2\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\n\u0010\bJ\u001b\u0010\n\u001a\u00028\u00002\n\u0010\r\u001a\u00060\u000bj\u0002`\fH&\u00a2\u0006\u0004\b\n\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0017\u00a2\u0006\u0004\b\u000f\u0010\bJ\u001b\u0010\u000f\u001a\u00028\u00002\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0017\u00a2\u0006\u0004\b\u000f\u0010\u000e\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0010\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/ships/VsiMutableQueryableShipData;", "Lorg/valkyrienskies/core/api/ships/Ship;", "ShipType", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "", "ship", "", "add", "(Lorg/valkyrienskies/core/api/ships/Ship;)V", "addShipData", "remove", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "(J)Lorg/valkyrienskies/core/api/ships/Ship;", "removeShipData", "internal"})
public interface VsiMutableQueryableShipData<ShipType extends Ship>
extends VsiQueryableShipData<ShipType>,
Iterable<ShipType>,
KMutableIterable {
    public void add(@NotNull ShipType var1);

    public void remove(@NotNull ShipType var1);

    @NotNull
    public ShipType remove(long var1);

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="add(ship)", imports={}))
    default public void addShipData(@NotNull ShipType ship) {
        Intrinsics.checkNotNullParameter(ship, (String)"ship");
        this.add(ship);
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="remove(ship)", imports={}))
    default public void removeShipData(@NotNull ShipType ship) {
        Intrinsics.checkNotNullParameter(ship, (String)"ship");
        this.remove(ship);
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="remove(id)", imports={}))
    @NotNull
    default public ShipType removeShipData(long id) {
        return this.remove(id);
    }
}

