/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.jellysquid.mods.sodium.client.render.SodiumWorldRenderer
 *  me.jellysquid.mods.sodium.client.render.chunk.ChunkRenderMatrices
 *  me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager
 *  net.minecraft.class_1921
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.fabric.mixin.compat.sodium;

import me.jellysquid.mods.sodium.client.render.SodiumWorldRenderer;
import me.jellysquid.mods.sodium.client.render.chunk.ChunkRenderMatrices;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager;
import net.minecraft.class_1921;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.compat.SodiumCompat;

@Mixin(value={SodiumWorldRenderer.class}, remap=false, priority=1100)
public abstract class MixinSodiumWorldRenderer {
    @Shadow
    private RenderSectionManager renderSectionManager;

    @Inject(method={"drawChunkLayer"}, at={@At(value="TAIL")})
    private void afterChunkLayer(class_1921 renderLayer, ChunkRenderMatrices matrices, double x, double y, double z, CallbackInfo ci) {
        SodiumCompat.renderShips(this.renderSectionManager, renderLayer, matrices, x, y, z);
    }
}

