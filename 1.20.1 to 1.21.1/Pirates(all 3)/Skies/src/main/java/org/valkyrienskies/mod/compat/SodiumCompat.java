/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  me.jellysquid.mods.sodium.client.gl.device.CommandList
 *  me.jellysquid.mods.sodium.client.gl.device.RenderDevice
 *  me.jellysquid.mods.sodium.client.render.chunk.ChunkRenderMatrices
 *  me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager
 *  me.jellysquid.mods.sodium.client.render.chunk.lists.ChunkRenderListIterable
 *  me.jellysquid.mods.sodium.client.render.chunk.lists.SortedRenderLists
 *  me.jellysquid.mods.sodium.client.render.chunk.map.ChunkTrackerHolder
 *  me.jellysquid.mods.sodium.client.render.chunk.terrain.DefaultTerrainRenderPasses
 *  me.jellysquid.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  me.jellysquid.mods.sodium.client.render.viewport.CameraTransform
 *  net.minecraft.class_1921
 *  net.minecraft.class_638
 */
package org.valkyrienskies.mod.compat;

import com.mojang.blaze3d.systems.RenderSystem;
import me.jellysquid.mods.sodium.client.gl.device.CommandList;
import me.jellysquid.mods.sodium.client.gl.device.RenderDevice;
import me.jellysquid.mods.sodium.client.render.chunk.ChunkRenderMatrices;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager;
import me.jellysquid.mods.sodium.client.render.chunk.lists.ChunkRenderListIterable;
import me.jellysquid.mods.sodium.client.render.chunk.lists.SortedRenderLists;
import me.jellysquid.mods.sodium.client.render.chunk.map.ChunkTrackerHolder;
import me.jellysquid.mods.sodium.client.render.chunk.terrain.DefaultTerrainRenderPasses;
import me.jellysquid.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import me.jellysquid.mods.sodium.client.render.viewport.CameraTransform;
import net.minecraft.class_1921;
import net.minecraft.class_638;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;
import org.valkyrienskies.mod.compat.VSRenderer;
import org.valkyrienskies.mod.mixin.ValkyrienCommonMixinConfigPlugin;
import org.valkyrienskies.mod.mixin.mod_compat.sodium.RenderSectionManagerAccessor;
import org.valkyrienskies.mod.mixinducks.mod_compat.sodium.RenderSectionManagerDuck;

public class SodiumCompat {
    public static void onChunkAdded(class_638 level, int x, int z) {
        if (ValkyrienCommonMixinConfigPlugin.getVSRenderer() == VSRenderer.SODIUM) {
            ChunkTrackerHolder.get((class_638)level).onChunkStatusAdded(x, z, 1);
        }
    }

    public static void onChunkRemoved(class_638 level, int x, int z) {
        if (ValkyrienCommonMixinConfigPlugin.getVSRenderer() == VSRenderer.SODIUM) {
            ChunkTrackerHolder.get((class_638)level).onChunkStatusRemoved(x, z, 1);
        }
    }

    public static void vsRenderLayer(RenderSectionManager renderSectionManager, ChunkRenderMatrices matrices, TerrainRenderPass pass, double x, double y, double z, CommandList commandList) {
        VSGameEvents.INSTANCE.getShipsStartRenderingSodium().emit(new VSGameEvents.ShipStartRenderEventSodium(pass, matrices, x, y, z));
        ((RenderSectionManagerDuck)renderSectionManager).vs_getShipRenderLists().forEach((ship, renderList) -> {
            VSGameEvents.INSTANCE.getRenderShipSodium().emit(new VSGameEvents.ShipRenderEventSodium(pass, matrices, x, y, z, (ClientShip)ship, (SortedRenderLists)renderList));
            ShipTransform shipTransform = ship.getRenderTransform();
            float distanceScaling = 1.0f / (float)shipTransform.getShipToWorldScaling().x();
            float initialFogStart = RenderSystem.getShaderFogStart();
            float initialFogEnd = RenderSystem.getShaderFogEnd();
            if (distanceScaling != 1.0f) {
                RenderSystem.setShaderFogStart((float)(initialFogStart * distanceScaling));
                RenderSystem.setShaderFogEnd((float)(initialFogEnd * distanceScaling));
            }
            Vector3d cameraShipSpace = shipTransform.getWorldToShip().transformPosition(new Vector3d(x, y, z));
            Matrix4dc s = ship.getRenderTransform().getShipToWorld();
            Matrix4d newModelView = new Matrix4d(matrices.modelView()).translate(-x, -y, -z).mul(s).translate(cameraShipSpace);
            ChunkRenderMatrices newMatrices = new ChunkRenderMatrices(matrices.projection(), (Matrix4fc)new Matrix4f(newModelView));
            ((RenderSectionManagerAccessor)renderSectionManager).getChunkRenderer().render(newMatrices, commandList, (ChunkRenderListIterable)renderList, pass, new CameraTransform(cameraShipSpace.x(), cameraShipSpace.y(), cameraShipSpace.z()));
            commandList.close();
            if (distanceScaling != 1.0f) {
                RenderSystem.setShaderFogStart((float)initialFogStart);
                RenderSystem.setShaderFogEnd((float)initialFogEnd);
            }
            VSGameEvents.INSTANCE.getPostRenderShipSodium().emit(new VSGameEvents.ShipRenderEventSodium(pass, matrices, x, y, z, (ClientShip)ship, (SortedRenderLists)renderList));
        });
    }

    public static void renderShips(RenderSectionManager renderSectionManager, class_1921 renderLayer, ChunkRenderMatrices matrices, double x, double y, double z) {
        RenderDevice device = RenderDevice.INSTANCE;
        CommandList commandList = device.createCommandList();
        if (renderLayer == class_1921.method_23577()) {
            SodiumCompat.vsRenderLayer(renderSectionManager, matrices, DefaultTerrainRenderPasses.SOLID, x, y, z, commandList);
            SodiumCompat.vsRenderLayer(renderSectionManager, matrices, DefaultTerrainRenderPasses.CUTOUT, x, y, z, commandList);
        } else if (renderLayer == class_1921.method_23583()) {
            SodiumCompat.vsRenderLayer(renderSectionManager, matrices, DefaultTerrainRenderPasses.TRANSLUCENT, x, y, z, commandList);
        }
        commandList.close();
    }
}

