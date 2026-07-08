/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  me.jellysquid.mods.sodium.client.render.chunk.ChunkUpdateType
 *  me.jellysquid.mods.sodium.client.render.chunk.RenderSection
 *  me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager
 *  me.jellysquid.mods.sodium.client.render.chunk.lists.SortedRenderLists
 *  me.jellysquid.mods.sodium.client.render.chunk.lists.VisibleChunkCollector
 *  me.jellysquid.mods.sodium.client.render.viewport.Viewport
 *  net.minecraft.class_2818
 *  net.minecraft.class_2826
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.sodium;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import me.jellysquid.mods.sodium.client.render.chunk.ChunkUpdateType;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSection;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager;
import me.jellysquid.mods.sodium.client.render.chunk.lists.SortedRenderLists;
import me.jellysquid.mods.sodium.client.render.chunk.lists.VisibleChunkCollector;
import me.jellysquid.mods.sodium.client.render.viewport.Viewport;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixinducks.mod_compat.sodium.RenderSectionManagerDuck;

@Mixin(value={RenderSectionManager.class}, remap=false)
public abstract class MixinRenderSectionManager
implements RenderSectionManagerDuck {
    @Unique
    private final WeakHashMap<ClientShip, SortedRenderLists> shipRenderLists = new WeakHashMap();
    @Shadow
    @Final
    private class_638 world;
    @Shadow
    private SortedRenderLists renderLists;
    @Shadow
    private Map<ChunkUpdateType, ArrayDeque<RenderSection>> rebuildLists;

    @Override
    public WeakHashMap<ClientShip, SortedRenderLists> vs_getShipRenderLists() {
        return this.shipRenderLists;
    }

    @Shadow
    protected abstract RenderSection getRenderSection(int var1, int var2, int var3);

    @Shadow
    public abstract void tickVisibleRenders();

    @Inject(at={@At(value="TAIL")}, method={"createTerrainRenderList"})
    private void afterIterateChunks(class_4184 camera, Viewport viewport, int frame, boolean spectator, CallbackInfo ci) {
        for (ClientShip ship : VSGameUtilsKt.getShipObjectWorld(class_310.method_1551()).getLoadedShips()) {
            VisibleChunkCollector collector2 = new VisibleChunkCollector(frame);
            ship.getActiveChunksSet().forEach((x, z) -> {
                class_2818 levelChunk = this.world.method_8497(x, z);
                for (int y = this.world.method_32891(); y < this.world.method_31597(); ++y) {
                    RenderSection section;
                    class_2826 levelChunkSection = levelChunk.method_38259(y - this.world.method_32891());
                    if (levelChunkSection.method_38292() || (section = this.getRenderSection(x, y, z)) == null) continue;
                    collector2.visit(section, true);
                }
            });
            this.shipRenderLists.put(ship, collector2.createRenderLists());
            for (Map.Entry entry : collector2.getRebuildLists().entrySet()) {
                this.rebuildLists.get(entry.getKey()).addAll((Collection)entry.getValue());
            }
        }
        this.rebuildLists.forEach((type, rebuildLists) -> {
            ArrayList<RenderSection> rebuildSorted = new ArrayList<RenderSection>((Collection<RenderSection>)rebuildLists);
            rebuildSorted.sort(Comparator.comparingDouble(section -> section.getSquaredDistance(camera.method_19328())));
            rebuildLists.clear();
            rebuildLists.addAll(rebuildSorted);
        });
    }

    @WrapMethod(method={"tickVisibleRenders"})
    private void tickVisibleShipRenders(Operation<Void> original) {
        original.call(new Object[0]);
        SortedRenderLists trueRenderLists = this.renderLists;
        Iterator<SortedRenderLists> iterator2 = this.shipRenderLists.values().iterator();
        while (iterator2.hasNext()) {
            SortedRenderLists currentShipRenderLists;
            this.renderLists = currentShipRenderLists = iterator2.next();
            original.call(new Object[0]);
        }
        this.renderLists = trueRenderLists;
    }

    @Inject(at={@At(value="TAIL")}, method={"resetRenderLists"})
    private void afterResetLists(CallbackInfo ci) {
        this.shipRenderLists.clear();
    }
}

