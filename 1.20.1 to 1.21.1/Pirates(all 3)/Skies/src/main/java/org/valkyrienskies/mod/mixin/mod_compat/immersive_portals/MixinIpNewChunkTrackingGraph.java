/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  qouteall.imm_ptl.core.chunk_loading.ChunkLoader
 *  qouteall.imm_ptl.core.chunk_loading.ChunkLoader$ChunkPosConsumer
 *  qouteall.imm_ptl.core.chunk_loading.NewChunkTrackingGraph
 */
package org.valkyrienskies.mod.mixin.mod_compat.immersive_portals;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import qouteall.imm_ptl.core.chunk_loading.ChunkLoader;
import qouteall.imm_ptl.core.chunk_loading.NewChunkTrackingGraph;

@Mixin(value={NewChunkTrackingGraph.class})
public class MixinIpNewChunkTrackingGraph {
    @Redirect(method={"updateForPlayer"}, at=@At(value="INVOKE", target="Lqouteall/imm_ptl/core/chunk_loading/ChunkLoader;foreachChunkPos(Lqouteall/imm_ptl/core/chunk_loading/ChunkLoader$ChunkPosConsumer;)V"))
    private static void addShipChunks(ChunkLoader instance, ChunkLoader.ChunkPosConsumer func, @Local class_3218 world) {
        for (int dx = -instance.radius; dx <= instance.radius; ++dx) {
            for (int dz = -instance.radius; dz <= instance.radius; ++dz) {
                func.consume(instance.center.dimension, instance.center.x + dx, instance.center.z + dz, Math.max(Math.abs(dx), Math.abs(dz)));
            }
        }
        AABBd box = new AABBd(instance.center.x - instance.radius << 4, world.method_31607(), instance.center.z - instance.radius << 4, instance.center.x + instance.radius << 4, world.method_31600(), instance.center.z + instance.radius << 4);
        for (Ship ship : VSGameUtilsKt.getShipsIntersecting((class_1937)world, box)) {
            ship.getActiveChunksSet().forEach((x, z) -> func.consume(instance.center.dimension, x, z, 1));
        }
    }
}

