/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.visual.EntityVisual
 *  dev.engine_room.flywheel.api.visualization.EntityVisualizer
 *  dev.engine_room.flywheel.api.visualization.VisualEmbedding
 *  dev.engine_room.flywheel.api.visualization.VisualizationContext
 *  net.minecraft.class_1297
 */
package org.valkyrienskies.mod.compat.flywheel;

import dev.engine_room.flywheel.api.visual.EntityVisual;
import dev.engine_room.flywheel.api.visualization.EntityVisualizer;
import dev.engine_room.flywheel.api.visualization.VisualEmbedding;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import net.minecraft.class_1297;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.compat.flywheel.ShipEmbeddingManager;

public class EntityVisualizerDecorator<T extends class_1297>
implements EntityVisualizer<T> {
    private final EntityVisualizer<? super T> inner;

    public EntityVisualizerDecorator(EntityVisualizer<? super T> visualizer) {
        this.inner = visualizer;
    }

    public EntityVisual<? super T> createVisual(VisualizationContext ctx, T entity, float partialTick) {
        Ship ship = VSGameUtilsKt.getShipManaging(entity);
        if (ship instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            VisualEmbedding embedding = ShipEmbeddingManager.INSTANCE.getOrCreateEmbedding(ship2, ctx);
            EntityVisual visual = this.inner.createVisual((VisualizationContext)embedding, entity, partialTick);
            return visual;
        }
        return this.inner.createVisual(ctx, entity, partialTick);
    }

    public boolean skipVanillaRender(T entity) {
        return this.inner.skipVanillaRender(entity);
    }
}

