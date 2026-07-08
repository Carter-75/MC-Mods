/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  me.jellysquid.mods.sodium.client.render.SodiumWorldRenderer
 *  me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager
 *  me.jellysquid.mods.sodium.client.render.chunk.lists.SortedRenderLists
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  net.minecraft.class_3191
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4599
 *  net.minecraft.class_638
 *  net.minecraft.class_824
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.sodium;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.Iterator;
import java.util.SortedSet;
import me.jellysquid.mods.sodium.client.render.SodiumWorldRenderer;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager;
import me.jellysquid.mods.sodium.client.render.chunk.lists.SortedRenderLists;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import net.minecraft.class_3191;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4599;
import net.minecraft.class_638;
import net.minecraft.class_824;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixinducks.mod_compat.sodium.RenderSectionManagerDuck;

@Mixin(value={SodiumWorldRenderer.class})
public abstract class MixinSodiumWorldRenderer {
    @Shadow
    private class_638 world;
    @Shadow
    private RenderSectionManager renderSectionManager;
    @Unique
    private SortedRenderLists currentRenderLists;

    @Redirect(method={"renderBlockEntity"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V"))
    private static void renderShipBlockEntityInShipyard(class_4587 instance, double x, double y, double z, class_4587 ignore, class_4599 bufferBuilders, Long2ObjectMap<SortedSet<class_3191>> blockBreakingProgressions, float tickDelta, class_4597.class_4598 immediate, double camX, double camY, double camZ, class_824 dispatcher, class_2586 entity) {
        class_2338 pos = entity.method_11016();
        if (!(dispatcher.field_4348 instanceof class_638)) {
            return;
        }
        class_638 level = (class_638)dispatcher.field_4348;
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos(level, (class_2382)pos);
        if (ship == null) {
            instance.method_22904(x, y, z);
        } else {
            VSClientGameUtils.transformRenderWithShip(ship.getRenderTransform(), instance, pos, camX, camY, camZ);
        }
    }

    @Shadow
    protected abstract void renderBlockEntities(class_4587 var1, class_4599 var2, Long2ObjectMap<SortedSet<class_3191>> var3, float var4, class_4597.class_4598 var5, double var6, double var8, double var10, class_824 var12);

    @Redirect(method={"renderBlockEntities(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/RenderBuffers;Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;Lnet/minecraft/client/Camera;F)V"}, at=@At(value="INVOKE", target="Lme/jellysquid/mods/sodium/client/render/SodiumWorldRenderer;renderBlockEntities(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/RenderBuffers;Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;FLnet/minecraft/client/renderer/MultiBufferSource$BufferSource;DDDLnet/minecraft/client/renderer/blockentity/BlockEntityRenderDispatcher;)V"))
    public void renderShipBlockEntities(SodiumWorldRenderer instance, class_4587 matrices, class_4599 bufferBuilders, Long2ObjectMap<SortedSet<class_3191>> blockBreakingProgressions, float tickDelta, class_4597.class_4598 immediate, double x, double y, double z, class_824 blockEntityRenderer) {
        this.renderBlockEntities(matrices, bufferBuilders, blockBreakingProgressions, tickDelta, immediate, x, y, z, blockEntityRenderer);
        Iterator<SortedRenderLists> iterator2 = ((RenderSectionManagerDuck)this.renderSectionManager).vs_getShipRenderLists().values().iterator();
        while (iterator2.hasNext()) {
            SortedRenderLists renderLists;
            this.currentRenderLists = renderLists = iterator2.next();
            this.renderBlockEntities(matrices, bufferBuilders, blockBreakingProgressions, tickDelta, immediate, x, y, z, blockEntityRenderer);
        }
        this.currentRenderLists = null;
    }

    @ModifyExpressionValue(method={"renderBlockEntities(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/RenderBuffers;Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;FLnet/minecraft/client/renderer/MultiBufferSource$BufferSource;DDDLnet/minecraft/client/renderer/blockentity/BlockEntityRenderDispatcher;)V"}, at={@At(value="INVOKE", target="Lme/jellysquid/mods/sodium/client/render/chunk/RenderSectionManager;getRenderLists()Lme/jellysquid/mods/sodium/client/render/chunk/lists/SortedRenderLists;")})
    private SortedRenderLists redirectGetRenderLists(SortedRenderLists original) {
        if (this.currentRenderLists != null) {
            return this.currentRenderLists;
        }
        return original;
    }

    @Inject(method={"isEntityVisible"}, at={@At(value="HEAD")}, cancellable=true)
    private void isEntityVisible(class_1297 entity, CallbackInfoReturnable<Boolean> cir) {
        if (VSGameUtilsKt.isBlockInShipyard((class_1937)this.world, entity.method_19538())) {
            cir.setReturnValue((Object)true);
        }
    }
}

