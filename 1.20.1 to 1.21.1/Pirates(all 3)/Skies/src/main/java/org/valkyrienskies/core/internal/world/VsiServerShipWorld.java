/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.world;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.util.GameTickOnly;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiGameServer;
import org.valkyrienskies.core.internal.physics.PhysicsEntityData;
import org.valkyrienskies.core.internal.physics.PhysicsEntityServer;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.VsiShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTasks;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H&\u00a2\u0006\u0004\b\b\u0010\tJ5\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H&\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H&\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\n\u0010\u0018\u001a\u00060\u0006j\u0002`\u0007H&\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010H&\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&\u00a2\u0006\u0004\b \u0010!J1\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H&\u00a2\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00192\u0006\u0010)\u001a\u00020&H&\u00a2\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00150,H&\u00a2\u0006\u0004\b-\u0010.J+\u00104\u001a\u00020\u00192\f\u00101\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020/H&\u00a2\u0006\u0004\b4\u00105J\u0019\u00108\u001a\u00020\u00192\b\u00107\u001a\u0004\u0018\u000106H&\u00a2\u0006\u0004\b8\u00109J\u001f\u0010=\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u00152\u0006\u0010<\u001a\u00020;H&\u00a2\u0006\u0004\b=\u0010>J\u001f\u0010?\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010<\u001a\u00020;H&\u00a2\u0006\u0004\b?\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00100A8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010CR(\u0010F\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0006j\u0002`\u00070,8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010.R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020G0A8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010CR\"\u0010O\u001a\b\u0012\u0004\u0012\u00020&0J8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006P\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "Lorg/valkyrienskies/core/internal/world/VsiShipWorld;", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "allocateShipId", "(Ljava/lang/String;)J", "Lorg/joml/Vector3ic;", "blockPosInWorldCoordinates", "", "createShipObjectImmediately", "", "scaling", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "createNewShipAtBlock", "(Lorg/joml/Vector3ic;ZDLjava/lang/String;)Lorg/valkyrienskies/core/api/ships/ServerShip;", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "physicsEntityData", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "createPhysicsEntity", "(Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;Ljava/lang/String;)Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "id", "", "deletePhysicsEntity", "(J)V", "ship", "deleteShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;)V", "Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkWatchTasks;", "getChunkWatchTasks", "()Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkWatchTasks;", "", "chunkX", "chunkZ", "", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "getIPlayersWatchingShipChunk", "(IILjava/lang/String;)Ljava/util/Iterator;", "player", "onDisconnect", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "", "retrieveLoadedPhysicsEntities", "()Ljava/util/Map;", "", "Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkWatchTask;", "watchTasks", "Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkUnwatchTask;", "unwatchTasks", "setExecutedChunkWatchTasks", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)V", "Lorg/valkyrienskies/core/internal/VsiGameServer;", "gameServer", "setGameServer", "(Lorg/valkyrienskies/core/internal/VsiGameServer;)V", "physicsEntityServer", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "teleportData", "teleportPhysicsEntity", "(Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "teleportShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "getAllShips", "()Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "allShips", "getDimensionToGroundBodyIdImmutable", "dimensionToGroundBodyIdImmutable", "Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "getLoadedShips", "loadedShips", "", "getPlayers", "()Ljava/util/Set;", "setPlayers", "(Ljava/util/Set;)V", "players", "internal"})
@GameTickOnly
public interface VsiServerShipWorld
extends VsiShipWorld,
ServerShipWorld {
    @NotNull
    public VsiQueryableShipData<ServerShip> getAllShips();

    @NotNull
    public VsiQueryableShipData<LoadedServerShip> getLoadedShips();

    @NotNull
    public Set<VsiPlayer> getPlayers();

    public void setPlayers(@NotNull Set<? extends VsiPlayer> var1);

    public void setGameServer(@Nullable VsiGameServer var1);

    @NotNull
    public Iterator<VsiPlayer> getIPlayersWatchingShipChunk(int var1, int var2, @NotNull String var3);

    @NotNull
    public VsiChunkWatchTasks getChunkWatchTasks();

    public void setExecutedChunkWatchTasks(@NotNull Iterable<? extends VsiChunkWatchTask> var1, @NotNull Iterable<? extends VsiChunkUnwatchTask> var2);

    @NotNull
    public ServerShip createNewShipAtBlock(@NotNull Vector3ic var1, boolean var2, double var3, @NotNull String var5);

    public static /* synthetic */ ServerShip createNewShipAtBlock$default(VsiServerShipWorld vsiServerShipWorld, Vector3ic vector3ic, boolean bl, double d2, String string, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createNewShipAtBlock");
        }
        if ((n2 & 4) != 0) {
            d2 = 1.0;
        }
        return vsiServerShipWorld.createNewShipAtBlock(vector3ic, bl, d2, string);
    }

    @NotNull
    public PhysicsEntityServer createPhysicsEntity(@NotNull PhysicsEntityData var1, @NotNull String var2);

    public void deletePhysicsEntity(long var1);

    public long allocateShipId(@NotNull String var1);

    @NotNull
    public Map<Long, PhysicsEntityServer> retrieveLoadedPhysicsEntities();

    public void onDisconnect(@NotNull VsiPlayer var1);

    public void deleteShip(@NotNull ServerShip var1);

    public void teleportShip(@NotNull ServerShip var1, @NotNull ShipTeleportData var2);

    public void teleportPhysicsEntity(@NotNull PhysicsEntityServer var1, @NotNull ShipTeleportData var2);

    @NotNull
    public Map<String, Long> getDimensionToGroundBodyIdImmutable();
}

