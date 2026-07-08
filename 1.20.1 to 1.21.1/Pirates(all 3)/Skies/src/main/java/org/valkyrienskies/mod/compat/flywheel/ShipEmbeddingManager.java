/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.visualization.VisualEmbedding
 *  dev.engine_room.flywheel.api.visualization.VisualizationContext
 *  dev.engine_room.flywheel.api.visualization.VisualizationManager
 *  net.minecraft.class_1297
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  net.minecraft.class_310
 *  net.minecraft.class_5572
 */
package org.valkyrienskies.mod.compat.flywheel;

import dev.engine_room.flywheel.api.visualization.VisualEmbedding;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.api.visualization.VisualizationManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import net.minecraft.class_1297;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import net.minecraft.class_310;
import net.minecraft.class_5572;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.impl.hooks.VSEvents;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

public class ShipEmbeddingManager {
    public static final ShipEmbeddingManager INSTANCE = new ShipEmbeddingManager();
    protected static ConcurrentHashMap<ClientShip, class_2382> vs$shipAnchor = new ConcurrentHashMap();
    protected static ConcurrentHashMap<ClientShip, class_2382> vs$EmbeddingOrigin = new ConcurrentHashMap();
    protected static ConcurrentHashMap<ClientShip, VisualEmbedding> vs$shipEmbedding = new ConcurrentHashMap();
    protected static ConcurrentHashMap<class_2586, ClientShip> vs$shipBEs = new ConcurrentHashMap();

    private ShipEmbeddingManager() {
        VSEvents.ShipUnloadEventClient.Companion.on((Consumer<? super VSEvents.ShipUnloadEventClient>)((Consumer<VSEvents.ShipUnloadEventClient>)event -> this.unloadShip(event.getShip())));
        VSGameEvents.INSTANCE.getShipsStartRendering().on(event -> this.updateAllShips());
        VSGameEvents.INSTANCE.getShipsStartRenderingSodium().on(event -> this.updateAllShips());
        VSGameEvents.INSTANCE.getEntitySectionSetShip().on(event -> this.updateEntitySection(event.getSection()));
    }

    private void updateEntitySection(class_5572<?> section) {
        VisualizationManager manager = VisualizationManager.get((class_1936)class_310.method_1551().field_1687);
        if (manager == null) {
            return;
        }
        section.method_31766().forEach(entity -> {
            manager.entities().queueRemove((Object)((class_1297)entity));
            manager.entities().queueAdd((Object)((class_1297)entity));
        });
    }

    public synchronized VisualEmbedding getOrCreateEmbedding(ClientShip ship, VisualizationContext ctx) {
        VisualEmbedding prevEmbedding = vs$shipEmbedding.get(ship);
        if (prevEmbedding != null && ctx.renderOrigin().equals((Object)vs$EmbeddingOrigin.get(ship))) {
            return prevEmbedding;
        }
        vs$shipBEs.entrySet().removeIf(entry -> {
            VisualizationManager manager = VisualizationManager.get((class_1936)((class_2586)entry.getKey()).method_10997());
            if (entry.getValue() == ship && manager != null) {
                manager.blockEntities().queueRemove((Object)((class_2586)entry.getKey()));
                manager.blockEntities().queueAdd((Object)((class_2586)entry.getKey()));
                return true;
            }
            return false;
        });
        if (prevEmbedding != null) {
            prevEmbedding.delete();
        }
        class_2338 anchor = class_2338.method_49638((class_2374)VectorConversionsMCKt.toMinecraft(ship.getRenderTransform().getPositionInShip()));
        class_2382 origin = ctx.renderOrigin();
        VisualEmbedding result2 = ctx.createEmbedding((class_2382)anchor);
        ShipEmbeddingManager.setEmbeddingTransform(result2, ship, (class_2382)anchor, origin);
        vs$shipAnchor.put(ship, (class_2382)anchor);
        vs$EmbeddingOrigin.put(ship, origin);
        vs$shipEmbedding.put(ship, result2);
        return result2;
    }

    public synchronized void updateAllShips() {
        for (ClientShip ship : vs$shipEmbedding.keySet()) {
            class_2382 anchor = vs$shipAnchor.get(ship);
            VisualEmbedding embedding = vs$shipEmbedding.get(ship);
            class_2382 origin = vs$EmbeddingOrigin.get(ship);
            ShipEmbeddingManager.setEmbeddingTransform(embedding, ship, anchor, origin);
        }
    }

    public synchronized void unloadShip(ClientShip ship) {
        VisualEmbedding embedding = vs$shipEmbedding.remove(ship);
        if (embedding != null) {
            embedding.delete();
        }
        vs$shipBEs.entrySet().removeIf(entry -> {
            if (entry.getValue() == ship) {
                VisualizationManager.get((class_1936)((class_2586)entry.getKey()).method_10997()).blockEntities().queueRemove((Object)((class_2586)entry.getKey()));
                return true;
            }
            return false;
        });
        vs$shipAnchor.remove(ship);
        vs$EmbeddingOrigin.remove(ship);
    }

    public synchronized void unloadAllShip() {
        vs$shipBEs.clear();
        vs$shipEmbedding.clear();
        vs$shipAnchor.clear();
        vs$EmbeddingOrigin.clear();
    }

    protected static void setEmbeddingTransform(VisualEmbedding embedding, ClientShip ship, class_2382 anchor, class_2382 origin) {
        Matrix4f poseMatrix = new Matrix4f();
        Matrix3f normalMatrix = new Matrix3f();
        poseMatrix.translate(new Vector3f(-origin.method_10263(), -origin.method_10264(), -origin.method_10260()));
        poseMatrix.translate(ship.getRenderTransform().getShipToWorld().transformPosition(anchor.method_10263(), anchor.method_10264(), anchor.method_10260(), new Vector3d()).get(new Vector3f()));
        poseMatrix.rotate(ship.getRenderTransform().getShipToWorldRotation().get(new Quaternionf()));
        poseMatrix.scale(ship.getRenderTransform().getShipToWorldScaling().get(new Vector3f()));
        normalMatrix.set(poseMatrix);
        embedding.transforms((Matrix4fc)poseMatrix, (Matrix3fc)normalMatrix);
    }

    public void register(class_2586 blockEntity, ClientShip ship) {
        vs$shipBEs.put(blockEntity, ship);
    }
}

