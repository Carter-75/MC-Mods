/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.class_1297
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_310
 *  net.minecraft.server.MinecraftServer
 */
package org.valkyrienskies.mod.api;

import kotlin.Metadata;
import net.minecraft.class_1297;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.VsCoreApi;
import org.valkyrienskies.core.api.event.ListenableEvent;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.world.ClientShipWorld;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.mod.api.events.PostRenderShipEvent;
import org.valkyrienskies.mod.api.events.PreRenderShipEvent;
import org.valkyrienskies.mod.api.events.RegisterBlockStateEvent;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\b\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a2\u0006\u0004\b\u0011\u0010\u0015J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0004\b!\u0010\"J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'\u00a2\u0006\u0004\b\u0019\u0010#J\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH'\u00a2\u0006\u0004\b\u001e\u0010$J)\u0010(\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H&\u00a2\u0006\u0004\b(\u0010)J%\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010*H&\u00a2\u0006\u0004\b,\u0010-J%\u0010/\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010.H&\u00a2\u0006\u0004\b/\u00100J+\u0010/\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H&\u00a2\u0006\u0004\b/\u00101J)\u00105\u001a\b\u0012\u0004\u0012\u00020\r042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u000102H&\u00a2\u0006\u0004\b5\u00106J7\u00105\u001a\b\u0012\u0004\u0012\u00020\r042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u0002072\u0006\u0010:\u001a\u000207H&\u00a2\u0006\u0004\b5\u0010;R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020=0<8gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020A0<8gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010?R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020D0<8gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010?\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006G\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/api/VsApi;", "Lorg/valkyrienskies/core/api/VsCoreApi;", "Lnet/minecraft/class_1297;", "entity", "", "isShipMountingEntity", "(Lnet/minecraft/class_1297;)Z", "Lnet/minecraft/class_1937;", "level", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getDimensionId", "(Lnet/minecraft/class_1937;)Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/Ship;", "getShipMountedTo", "(Lnet/minecraft/class_1297;)Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/Vector3dc;", "getMountPosInShip", "(Lnet/minecraft/class_1297;)Lorg/joml/Vector3dc;", "", "partialTicks", "(Lnet/minecraft/class_1297;F)Lorg/joml/Vector3dc;", "Lnet/minecraft/server/MinecraftServer;", "server", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "getServerShipWorld", "(Lnet/minecraft/server/MinecraftServer;)Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "Lnet/minecraft/class_310;", "client", "Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "getClientShipWorld", "(Lnet/minecraft/class_310;)Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "getShipWorld", "(Lnet/minecraft/class_1937;)Lorg/valkyrienskies/core/api/world/ShipWorld;", "()Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "()Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "", "chunkX", "chunkZ", "isChunkInShipyard", "(Lnet/minecraft/class_1937;II)Z", "Lnet/minecraft/class_2338;", "pos", "getShipManagingBlock", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;)Lorg/valkyrienskies/core/api/ships/Ship;", "Lnet/minecraft/class_1923;", "getShipManagingChunk", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1923;)Lorg/valkyrienskies/core/api/ships/Ship;", "(Lnet/minecraft/class_1937;II)Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/primitives/AABBdc;", "aabb", "", "getShipsIntersecting", "(Lnet/minecraft/class_1937;Lorg/joml/primitives/AABBdc;)Ljava/lang/Iterable;", "", "x", "y", "z", "(Lnet/minecraft/class_1937;DDD)Ljava/lang/Iterable;", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/mod/api/events/RegisterBlockStateEvent;", "getRegisterBlockStateEvent", "()Lorg/valkyrienskies/core/api/event/ListenableEvent;", "registerBlockStateEvent", "Lorg/valkyrienskies/mod/api/events/PreRenderShipEvent;", "getPreRenderShipEvent", "preRenderShipEvent", "Lorg/valkyrienskies/mod/api/events/PostRenderShipEvent;", "getPostRenderShipEvent", "postRenderShipEvent", "valkyrienskies-120"})
@ApiStatus.NonExtendable
public interface VsApi
extends VsCoreApi {
    @ApiStatus.Experimental
    @NotNull
    public ListenableEvent<RegisterBlockStateEvent> getRegisterBlockStateEvent();

    @ApiStatus.Experimental
    @NotNull
    public ListenableEvent<PreRenderShipEvent> getPreRenderShipEvent();

    @ApiStatus.Experimental
    @NotNull
    public ListenableEvent<PostRenderShipEvent> getPostRenderShipEvent();

    public boolean isShipMountingEntity(@NotNull class_1297 var1);

    @NotNull
    public String getDimensionId(@NotNull class_1937 var1);

    @Nullable
    public Ship getShipMountedTo(@Nullable class_1297 var1);

    @Nullable
    public Vector3dc getMountPosInShip(@Nullable class_1297 var1);

    @Nullable
    public Vector3dc getMountPosInShip(@Nullable class_1297 var1, float var2);

    @Nullable
    public ServerShipWorld getServerShipWorld(@Nullable MinecraftServer var1);

    @Nullable
    public ClientShipWorld getClientShipWorld(@Nullable class_310 var1);

    @Nullable
    public ShipWorld getShipWorld(@Nullable class_1937 var1);

    @ApiStatus.Experimental
    @Nullable
    public ServerShipWorld getServerShipWorld();

    @ApiStatus.Experimental
    @Nullable
    public ClientShipWorld getClientShipWorld();

    public boolean isChunkInShipyard(@Nullable class_1937 var1, int var2, int var3);

    @Nullable
    public Ship getShipManagingBlock(@Nullable class_1937 var1, @Nullable class_2338 var2);

    @Nullable
    public Ship getShipManagingChunk(@Nullable class_1937 var1, @Nullable class_1923 var2);

    @Nullable
    public Ship getShipManagingChunk(@Nullable class_1937 var1, int var2, int var3);

    @NotNull
    public Iterable<Ship> getShipsIntersecting(@Nullable class_1937 var1, @Nullable AABBdc var2);

    @NotNull
    public Iterable<Ship> getShipsIntersecting(@Nullable class_1937 var1, double var2, double var4, double var6);
}

