/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.world;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J?\u0010\r\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH&\u00a2\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0012\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&\u00a2\u0006\u0004\b\u0012\u0010\u0013JS\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH&\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&\u00a2\u0006\u0004\b \u0010!J;\u0010\"\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&\u00a2\u0006\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0$8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010'\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006,\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/world/VsiShipWorld;", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "yRange", "Lorg/joml/Vector3dc;", "gravity", "", "seaLevel", "maxY", "", "addDimension", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/world/LevelYRange;Lorg/joml/Vector3dc;DD)V", "", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "terrainUpdates", "addTerrainUpdates", "(Ljava/lang/String;Ljava/util/List;)V", "", "posX", "posY", "posZ", "Lorg/valkyrienskies/core/internal/world/properties/DimensionId;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "oldBlockType", "newBlockType", "oldBlockMass", "newBlockMass", "onSetBlock", "(IIILjava/lang/String;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;DD)V", "removeDimension", "(Ljava/lang/String;)V", "updateDimension", "(Ljava/lang/String;Lorg/joml/Vector3dc;Ljava/lang/Double;Ljava/lang/Double;)V", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "Lorg/valkyrienskies/core/api/ships/Ship;", "getAllShips", "()Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "allShips", "Lorg/valkyrienskies/core/api/ships/LoadedShip;", "getLoadedShips", "loadedShips", "internal"})
public interface VsiShipWorld
extends ShipWorld {
    @NotNull
    public VsiQueryableShipData<Ship> getAllShips();

    @NotNull
    public VsiQueryableShipData<LoadedShip> getLoadedShips();

    public void onSetBlock(int var1, int var2, int var3, @NotNull String var4, @NotNull VsiBlockType var5, @NotNull VsiBlockType var6, double var7, double var9);

    public void addTerrainUpdates(@NotNull String var1, @NotNull List<? extends VsiTerrainUpdate> var2);

    public void addDimension(@NotNull String var1, @NotNull LevelYRange var2, @NotNull Vector3dc var3, double var4, double var6);

    public static /* synthetic */ void addDimension$default(VsiShipWorld vsiShipWorld, String string, LevelYRange levelYRange, Vector3dc vector3dc, double d2, double d3, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addDimension");
        }
        if ((n2 & 8) != 0) {
            d2 = 62.0;
        }
        if ((n2 & 0x10) != 0) {
            d3 = 962.0;
        }
        vsiShipWorld.addDimension(string, levelYRange, vector3dc, d2, d3);
    }

    public void updateDimension(@NotNull String var1, @NotNull Vector3dc var2, @Nullable Double var3, @Nullable Double var4);

    public static /* synthetic */ void updateDimension$default(VsiShipWorld vsiShipWorld, String string, Vector3dc vector3dc, Double d2, Double d3, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateDimension");
        }
        if ((n2 & 4) != 0) {
            d2 = null;
        }
        if ((n2 & 8) != 0) {
            d3 = null;
        }
        vsiShipWorld.updateDimension(string, vector3dc, d2, d3);
    }

    public void removeDimension(@NotNull String var1);
}

