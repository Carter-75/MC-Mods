/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.visual.BlockEntityVisual
 *  dev.engine_room.flywheel.api.visualization.BlockEntityVisualizer
 *  dev.engine_room.flywheel.api.visualization.VisualEmbedding
 *  dev.engine_room.flywheel.api.visualization.VisualizationContext
 *  net.minecraft.class_2586
 */
package org.valkyrienskies.mod.compat.flywheel;

import dev.engine_room.flywheel.api.visual.BlockEntityVisual;
import dev.engine_room.flywheel.api.visualization.BlockEntityVisualizer;
import dev.engine_room.flywheel.api.visualization.VisualEmbedding;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import net.minecraft.class_2586;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.compat.flywheel.ShipEmbeddingManager;

public class BlockEntityVisualizerDecorator<T extends class_2586>
implements BlockEntityVisualizer<T> {
    private BlockEntityVisualizer<? super T> inner;

    public BlockEntityVisualizerDecorator(BlockEntityVisualizer<? super T> visualizer) {
        this.inner = visualizer;
    }

    public BlockEntityVisual<? super T> createVisual(VisualizationContext ctx, T blockEntity, float partialTick) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(blockEntity.method_10997(), blockEntity.method_11016());
        if (ship instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            VisualEmbedding embedding = ShipEmbeddingManager.INSTANCE.getOrCreateEmbedding(ship2, ctx);
            BlockEntityVisual visual = this.inner.createVisual((VisualizationContext)embedding, blockEntity, partialTick);
            ShipEmbeddingManager.INSTANCE.register((class_2586)blockEntity, ship2);
            return visual;
        }
        return this.inner.createVisual(ctx, blockEntity, partialTick);
    }

    public boolean skipVanillaRender(T blockEntity) {
        return this.inner.skipVanillaRender(blockEntity);
    }
}

