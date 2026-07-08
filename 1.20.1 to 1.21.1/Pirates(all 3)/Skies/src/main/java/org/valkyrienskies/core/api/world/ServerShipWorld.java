/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Triple
 */
package org.valkyrienskies.core.api.world;

import java.util.List;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Triple;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.QueryableShipData;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.util.AerodynamicUtils;
import org.valkyrienskies.core.api.util.GameTickOnly;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.core.api.world.connectivity.DoubleAugmentation;
import org.valkyrienskies.core.api.world.connectivity.DoubleComponentAugmentation;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH'\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH'\u00a2\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b\u0015\u0010\rJ;\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b\u0016\u0010\u0017JM\u0010\u001c\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001b\u0012\u0004\u0012\u00020\u000b0\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'\u00a2\u0006\u0004\b\u001c\u0010\u001dJM\u0010\u001e\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001b\u0012\u0004\u0012\u00020\u000b0\u001a2\u0006\u0010\u0003\u001a\u00020\u00122\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'\u00a2\u0006\u0004\b\u001e\u0010\u001fJM\u0010 \u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001b\u0012\u0004\u0012\u00020\u000b0\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'\u00a2\u0006\u0004\b \u0010\u001dJM\u0010!\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001b\u0012\u0004\u0012\u00020\u000b0\u001a2\u0006\u0010\u0003\u001a\u00020\u00122\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'\u00a2\u0006\u0004\b!\u0010\u001fJ\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010#\u001a\u00020\"H'\u00a2\u0006\u0004\b&\u0010'J;\u0010(\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b(\u0010\rJ;\u0010)\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b)\u0010\u0017J;\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b+\u0010,J;\u0010-\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b-\u0010.J;\u0010/\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b/\u0010,J;\u00100\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH'\u00a2\u0006\u0004\b0\u0010.JC\u00102\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u00101\u001a\u00020\u000bH'\u00a2\u0006\u0004\b2\u00103JC\u00104\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u00101\u001a\u00020\u000bH'\u00a2\u0006\u0004\b4\u00105JC\u00106\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u00101\u001a\u00020\u000bH'\u00a2\u0006\u0004\b6\u00103JC\u00107\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u00101\u001a\u00020\u000bH'\u00a2\u0006\u0004\b7\u00105JC\u0010:\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u00109\u001a\u000208H'\u00a2\u0006\u0004\b:\u0010;JC\u0010<\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u00109\u001a\u000208H'\u00a2\u0006\u0004\b<\u0010;R\u001a\u0010B\u001a\u00020=8&X\u00a6\u0004\u00a2\u0006\f\u0012\u0004\b@\u0010A\u001a\u0004\b>\u0010?R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020D0C8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020%0C8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010FR \u0010L\u001a\b\u0012\u0004\u0012\u00020D0C8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bK\u0010A\u001a\u0004\bJ\u0010F\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006M\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "key", "", "x", "y", "z", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimension", "", "collectAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;)D", "collectSolidAugmentation", "modId", "createDoubleSumAugmentation", "(Ljava/lang/String;Ljava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;", "createDoubleSumComponentAugmentation", "(Ljava/lang/String;Ljava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;", "getAirAugmentation", "getAirComponentAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIILjava/lang/String;)D", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "", "Lkotlin/Triple;", "getFromEachAirComponent", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Map;", "getFromEachAirComponentRoot", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Map;", "getFromEachSolidComponent", "getFromEachSolidComponentRoot", "Lorg/joml/primitives/AABBdc;", "aabb", "", "Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "getShipObjectsIntersecting", "(Lorg/joml/primitives/AABBdc;)Ljava/util/List;", "getSolidAugmentation", "getSolidComponentAugmentation", "", "removeAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;)V", "removeAirComponentAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIILjava/lang/String;)V", "removeSolidAugmentation", "removeSolidComponentAugmentation", "value", "setAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;D)V", "setAirComponentAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIILjava/lang/String;D)V", "setSolidAugmentation", "setSolidComponentAugmentation", "Ljava/util/function/DoubleUnaryOperator;", "update", "updateAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;Ljava/util/function/DoubleUnaryOperator;)V", "updateSolidAugmentation", "Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "getAerodynamicUtils", "()Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "getAerodynamicUtils$annotations", "()V", "aerodynamicUtils", "Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "getAllShips", "()Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "allShips", "getLoadedShips", "loadedShips", "getQueryableShipData", "getQueryableShipData$annotations", "queryableShipData", "api"})
@GameTickOnly
public interface ServerShipWorld
extends ShipWorld {
    @NotNull
    public QueryableShipData<ServerShip> getAllShips();

    @NotNull
    public QueryableShipData<LoadedServerShip> getLoadedShips();

    @Deprecated(message="redundant", replaceWith=@ReplaceWith(expression="loadedShips.getIntersecting(dimensionId, aabb)", imports={}))
    @NotNull
    public List<LoadedServerShip> getShipObjectsIntersecting(@NotNull AABBdc var1);

    @NotNull
    default public QueryableShipData<ServerShip> getQueryableShipData() {
        return this.getAllShips();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="allShips", imports={}))
    public static /* synthetic */ void getQueryableShipData$annotations() {
    }

    @NotNull
    public AerodynamicUtils getAerodynamicUtils();

    public static /* synthetic */ void getAerodynamicUtils$annotations() {
    }

    @ApiStatus.Experimental
    @NotNull
    public DoubleAugmentation createDoubleSumAugmentation(@NotNull String var1, @NotNull String var2);

    @ApiStatus.Experimental
    @NotNull
    public DoubleComponentAugmentation createDoubleSumComponentAugmentation(@NotNull String var1, @NotNull String var2);

    @ApiStatus.Experimental
    public double getSolidAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    public void setSolidAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5, double var6);

    @ApiStatus.Experimental
    public void removeSolidAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    public void updateSolidAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5, @NotNull DoubleUnaryOperator var6);

    @ApiStatus.Experimental
    public double collectSolidAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    public void setSolidComponentAugmentation(@NotNull DoubleComponentAugmentation var1, int var2, int var3, int var4, @NotNull String var5, double var6);

    @ApiStatus.Experimental
    public double getSolidComponentAugmentation(@NotNull DoubleComponentAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    public void removeSolidComponentAugmentation(@NotNull DoubleComponentAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    @NotNull
    public Map<Triple<Integer, Integer, Integer>, Double> getFromEachSolidComponent(@NotNull DoubleAugmentation var1, @NotNull String var2, @Nullable ChunkClaim var3);

    public static /* synthetic */ Map getFromEachSolidComponent$default(ServerShipWorld serverShipWorld, DoubleAugmentation doubleAugmentation, String string, ChunkClaim chunkClaim, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFromEachSolidComponent");
        }
        if ((n2 & 4) != 0) {
            chunkClaim = null;
        }
        return serverShipWorld.getFromEachSolidComponent(doubleAugmentation, string, chunkClaim);
    }

    @ApiStatus.Experimental
    @NotNull
    public Map<Triple<Integer, Integer, Integer>, Double> getFromEachSolidComponentRoot(@NotNull DoubleComponentAugmentation var1, @NotNull String var2, @Nullable ChunkClaim var3);

    public static /* synthetic */ Map getFromEachSolidComponentRoot$default(ServerShipWorld serverShipWorld, DoubleComponentAugmentation doubleComponentAugmentation, String string, ChunkClaim chunkClaim, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFromEachSolidComponentRoot");
        }
        if ((n2 & 4) != 0) {
            chunkClaim = null;
        }
        return serverShipWorld.getFromEachSolidComponentRoot(doubleComponentAugmentation, string, chunkClaim);
    }

    @ApiStatus.Experimental
    public double getAirAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    public void setAirAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5, double var6);

    @ApiStatus.Experimental
    public void removeAirAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    public void updateAirAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5, @NotNull DoubleUnaryOperator var6);

    @ApiStatus.Experimental
    public double collectAirAugmentation(@NotNull DoubleAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    public void setAirComponentAugmentation(@NotNull DoubleComponentAugmentation var1, int var2, int var3, int var4, @NotNull String var5, double var6);

    @ApiStatus.Experimental
    public double getAirComponentAugmentation(@NotNull DoubleComponentAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    public void removeAirComponentAugmentation(@NotNull DoubleComponentAugmentation var1, int var2, int var3, int var4, @NotNull String var5);

    @ApiStatus.Experimental
    @NotNull
    public Map<Triple<Integer, Integer, Integer>, Double> getFromEachAirComponent(@NotNull DoubleAugmentation var1, @NotNull String var2, @Nullable ChunkClaim var3);

    public static /* synthetic */ Map getFromEachAirComponent$default(ServerShipWorld serverShipWorld, DoubleAugmentation doubleAugmentation, String string, ChunkClaim chunkClaim, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFromEachAirComponent");
        }
        if ((n2 & 4) != 0) {
            chunkClaim = null;
        }
        return serverShipWorld.getFromEachAirComponent(doubleAugmentation, string, chunkClaim);
    }

    @ApiStatus.Experimental
    @NotNull
    public Map<Triple<Integer, Integer, Integer>, Double> getFromEachAirComponentRoot(@NotNull DoubleComponentAugmentation var1, @NotNull String var2, @Nullable ChunkClaim var3);

    public static /* synthetic */ Map getFromEachAirComponentRoot$default(ServerShipWorld serverShipWorld, DoubleComponentAugmentation doubleComponentAugmentation, String string, ChunkClaim chunkClaim, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFromEachAirComponentRoot");
        }
        if ((n2 & 4) != 0) {
            chunkClaim = null;
        }
        return serverShipWorld.getFromEachAirComponentRoot(doubleComponentAugmentation, string, chunkClaim);
    }
}

