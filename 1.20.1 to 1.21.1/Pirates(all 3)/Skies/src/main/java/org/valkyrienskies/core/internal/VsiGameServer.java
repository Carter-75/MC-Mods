/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H&\u00a2\u0006\u0004\b\t\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/VsiGameServer;", "", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "shipChunks", "", "Lorg/valkyrienskies/core/internal/world/properties/DimensionId;", "srcDimension", "destDimension", "", "moveTerrainAcrossDimensions", "(Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;Ljava/lang/String;Ljava/lang/String;)V", "internal"})
public interface VsiGameServer {
    public void moveTerrainAcrossDimensions(@NotNull IShipActiveChunksSet var1, @NotNull String var2, @NotNull String var3);
}

