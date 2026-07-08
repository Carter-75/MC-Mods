/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.ships;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.QueryableShipData;
import org.valkyrienskies.core.api.ships.Ship;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003J!\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\t\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "Lorg/valkyrienskies/core/api/ships/Ship;", "S", "Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "", "chunkX", "chunkZ", "getByChunkPos", "(II)Lorg/valkyrienskies/core/api/ships/Ship;", "internal"})
public interface VsiQueryableShipData<S extends Ship>
extends QueryableShipData<S> {
    @Nullable
    public S getByChunkPos(int var1, int var2);
}

