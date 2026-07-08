/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1297
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_26
 *  net.minecraft.class_2791
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3898
 *  net.minecraft.class_3898$class_3216
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.server.world;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_1297;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_26;
import net.minecraft.class_2791;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3898;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.MinecraftPlayer;

@Mixin(value={class_3898.class}, priority=1100)
public abstract class MixinChunkMap {
    @Shadow
    @Final
    class_3218 field_17214;
    @Shadow
    @Final
    private Supplier<class_26> field_17705;

    @Inject(method={"getPlayers"}, at={@At(value="RETURN")}, cancellable=true)
    private void postGetPlayersWatchingChunk(class_1923 chunkPos, boolean onlyOnWatchDistanceEdge, CallbackInfoReturnable<List<class_3222>> cir) {
        Iterator<VsiPlayer> playersWatchingShipChunk = VSGameUtilsKt.getShipObjectWorld(this.field_17214).getIPlayersWatchingShipChunk(chunkPos.field_9181, chunkPos.field_9180, VSGameUtilsKt.getDimensionId((class_1937)this.field_17214));
        if (!playersWatchingShipChunk.hasNext()) {
            return;
        }
        List oldReturnValue = (List)cir.getReturnValue();
        HashSet watchingPlayers = new HashSet(oldReturnValue);
        playersWatchingShipChunk.forEachRemaining(iPlayer -> {
            MinecraftPlayer minecraftPlayer = (MinecraftPlayer)iPlayer;
            class_3222 playerEntity = (class_3222)minecraftPlayer.getPlayerEntityReference().get();
            if (playerEntity != null) {
                watchingPlayers.add(playerEntity);
            }
        });
        cir.setReturnValue(new ArrayList(watchingPlayers));
    }

    @WrapOperation(method={"anyPlayerCloseEnoughForSpawning"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/level/ChunkMap$DistanceManager;hasPlayersNearby(J)Z")})
    private boolean onHasPlayersNearby(class_3898.class_3216 instance, long l2, Operation<Boolean> original, @Local(argsOnly=true) class_1923 arg) {
        return (Boolean)original.call(new Object[]{instance, new class_1923(class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates((class_1937)this.field_17214, arg.method_33943(63)))).method_8324()});
    }

    @WrapOperation(method={"playerIsCloseEnoughForSpawning"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/level/ChunkMap;euclideanDistanceSquared(Lnet/minecraft/world/level/ChunkPos;Lnet/minecraft/world/entity/Entity;)D")})
    private double onEuclideanDistanceSquared(class_1923 d0, class_1297 d1, Operation<Double> original) {
        return (Double)original.call(new Object[]{new class_1923(class_2338.method_49638((class_2374)VSGameUtilsKt.toWorldCoordinates((class_1937)this.field_17214, d0.method_33943(63)))), d1});
    }

    @Inject(method={"save"}, at={@At(value="HEAD")}, cancellable=true)
    private void preSave(class_2791 chunkAccess, CallbackInfoReturnable<Boolean> cir) {
        class_1923 pos = chunkAccess.method_12004();
        ServerShip ship = VSGameUtilsKt.getShipManagingPos(this.field_17214, pos);
        if (ship != null && !ship.getActiveChunksSet().contains(pos.field_9181, pos.field_9180)) {
            cir.setReturnValue((Object)false);
        }
    }
}

