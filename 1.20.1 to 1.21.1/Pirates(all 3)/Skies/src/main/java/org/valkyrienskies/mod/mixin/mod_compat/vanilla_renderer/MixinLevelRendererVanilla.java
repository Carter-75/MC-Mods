/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.mojang.blaze3d.systems.RenderSystem
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  it.unimi.dsi.fastutil.objects.ObjectList
 *  it.unimi.dsi.fastutil.objects.ObjectListIterator
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2818
 *  net.minecraft.class_2826
 *  net.minecraft.class_284
 *  net.minecraft.class_291
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4604
 *  net.minecraft.class_5944
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_761
 *  net.minecraft.class_761$class_762
 *  net.minecraft.class_769
 *  net.minecraft.class_846$class_851
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.vanilla_renderer;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_284;
import net.minecraft.class_291;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4604;
import net.minecraft.class_5944;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_761;
import net.minecraft.class_769;
import net.minecraft.class_846;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.util.datastructures.BlockPos2ByteOpenHashMap;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.ShipRenderer;
import org.valkyrienskies.mod.common.config.ShipRendererKt;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.compat.VSRenderer;
import org.valkyrienskies.mod.mixin.ValkyrienCommonMixinConfigPlugin;
import org.valkyrienskies.mod.mixin.accessors.client.render.ViewAreaAccessor;
import org.valkyrienskies.mod.mixin.mod_compat.optifine.RenderChunkInfoAccessorOptifine;
import org.valkyrienskies.mod.mixin.mod_compat.vanilla_renderer.RenderChunkInfoAccessor;
import org.valkyrienskies.mod.mixinducks.client.render.LevelRendererVanillaDuck;
import org.valkyrienskies.mod.mixinducks.mod_compat.vanilla_renderer.LevelRendererDuck;

@Mixin(value={class_761.class}, priority=999)
public abstract class MixinLevelRendererVanilla
implements LevelRendererDuck,
LevelRendererVanillaDuck {
    @Unique
    private final WeakHashMap<ClientShip, ObjectList<class_761.class_762>> shipRenderChunks = new WeakHashMap();
    @Shadow
    private class_638 field_4085;
    @Shadow
    @Final
    @Mutable
    private ObjectArrayList<class_761.class_762> field_34807;
    @Shadow
    @Nullable
    private class_769 field_4112;
    @Shadow
    @Final
    private class_310 field_4088;
    @Shadow
    @Final
    private AtomicBoolean field_34809;
    @Unique
    private BlockPos2ByteOpenHashMap vs$visibileShipChunks = new BlockPos2ByteOpenHashMap();
    @Unique
    private Long lastMountedShipId = null;
    @Unique
    private ShipTransform lastTransform = null;

    @Redirect(method={"compileChunks"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;distSqr(Lnet/minecraft/core/Vec3i;)D"), require=0)
    private double includeShipChunksInNearChunks(class_2338 b2, class_2382 v) {
        return VSGameUtilsKt.squaredDistanceBetweenInclShips((class_1937)this.field_4085, b2.method_10263(), b2.method_10264(), b2.method_10260(), v.method_10263(), v.method_10264(), v.method_10260());
    }

    @ModifyExpressionValue(at={@At(value="INVOKE", target="Ljava/util/concurrent/atomic/AtomicBoolean;compareAndSet(ZZ)Z")}, method={"setupRender"})
    private boolean getNeedsFrustumUpdate(boolean needsFrustumUpdate) {
        LoadedShip loadedShip;
        class_746 player = this.field_4088.field_1724;
        if (player == null || !((loadedShip = VSGameUtilsKt.getShipMountedTo((class_1297)player)) instanceof ClientShip)) {
            this.lastMountedShipId = null;
            return needsFrustumUpdate;
        }
        ClientShip ship = (ClientShip)loadedShip;
        ShipTransform transform2 = ship.getRenderTransform();
        if (this.lastMountedShipId == null || this.lastMountedShipId.longValue() != ship.getId() || this.lastTransform == null) {
            this.lastMountedShipId = ship.getId();
            this.lastTransform = transform2;
            return true;
        }
        boolean needUpdate = this.lastTransform != transform2 && !this.lastTransform.getShipToWorld().equals(transform2.getShipToWorld());
        this.lastTransform = transform2;
        return needUpdate;
    }

    @Override
    public void vs$setNeedsFrustumUpdate() {
        this.field_34809.set(true);
    }

    @Inject(method={"setupRender"}, at={@At(value="RETURN")})
    private void preSetupRender(class_4184 camera, class_4604 frustum, boolean bl, boolean bl2, CallbackInfo ci) {
        this.vs$addShipVisibleChunks(frustum);
    }

    @Override
    public void vs$addShipVisibleChunks(class_4604 frustum) {
        class_2338.class_2339 tempPos = new class_2338.class_2339();
        ViewAreaAccessor chunkStorageAccessor = (ViewAreaAccessor)this.field_4112;
        for (ClientShip shipObject : VSGameUtilsKt.getShipObjectWorld(this.field_4085).getLoadedShips()) {
            if (ShipRendererKt.getShipRenderer(shipObject) != ShipRenderer.VANILLA || !frustum.method_23093(VectorConversionsMCKt.toMinecraft(shipObject.getRenderAABB()))) continue;
            shipObject.getActiveChunksSet().forEach((x, z) -> {
                class_2818 levelChunk = this.field_4085.method_8497(x, z);
                for (int y = this.field_4085.method_32891(); y < this.field_4085.method_31597(); ++y) {
                    AABBd b2;
                    class_2826 levelChunkSection;
                    if (this.vs$visibileShipChunks.contains(x, y, z)) continue;
                    tempPos.method_10103(x << 4, y << 4, z << 4);
                    class_846.class_851 renderChunk = chunkStorageAccessor.callGetRenderChunkAt((class_2338)tempPos);
                    if (renderChunk == null || (levelChunkSection = levelChunk.method_38259(y - this.field_4085.method_32891())).method_38292() || !frustum.method_23093(VectorConversionsMCKt.toMinecraft(b2 = new AABBd((double)(x << 4) - 0.6, (double)(y << 4) - 0.6, (double)(z << 4) - 0.6, (double)(x << 4) + 15.6, (double)(y << 4) + 15.6, (double)(z << 4) + 15.6).transform(shipObject.getRenderTransform().getShipToWorld())))) continue;
                    class_761.class_762 newChunkInfo = ValkyrienCommonMixinConfigPlugin.getVSRenderer() == VSRenderer.OPTIFINE ? RenderChunkInfoAccessorOptifine.vs$new(renderChunk, null, 0) : RenderChunkInfoAccessor.vs$new(renderChunk, null, 0);
                    this.shipRenderChunks.computeIfAbsent(shipObject, k2 -> new ObjectArrayList()).add((Object)newChunkInfo);
                    this.vs$visibileShipChunks.put(x, y, z, (byte)1);
                    this.field_34807.add((Object)newChunkInfo);
                }
            });
        }
    }

    @WrapOperation(method={"*"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;distSqr(Lnet/minecraft/core/Vec3i;)D")})
    private double distToShips(class_2338 from, class_2382 to2, Operation<Double> distSqr) {
        return VSGameUtilsKt.squaredDistanceBetweenInclShips((class_1937)this.field_4085, from.method_46558(), class_243.method_24953((class_2382)to2), distSqr);
    }

    @Inject(method={"*"}, at={@At(value="INVOKE", target="Lit/unimi/dsi/fastutil/objects/ObjectArrayList;clear()V")})
    private void clearShipChunks(CallbackInfo ci) {
        this.shipRenderChunks.forEach((ship, chunks) -> chunks.clear());
        this.vs$visibileShipChunks = new BlockPos2ByteOpenHashMap();
    }

    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/LevelRenderer;renderChunkLayer(Lnet/minecraft/client/renderer/RenderType;Lcom/mojang/blaze3d/vertex/PoseStack;DDDLorg/joml/Matrix4f;)V")}, method={"renderLevel"})
    private void redirectRenderChunkLayer(class_761 receiver, class_1921 renderType, class_4587 poseStack, double camX, double camY, double camZ, Matrix4f matrix4f, Operation<Void> renderChunkLayer) {
        renderChunkLayer.call(new Object[]{receiver, renderType, poseStack, camX, camY, camZ, matrix4f});
        VSGameEvents.INSTANCE.getShipsStartRendering().emit(new VSGameEvents.ShipStartRenderEvent(receiver, renderType, poseStack, camX, camY, camZ, matrix4f));
        this.shipRenderChunks.forEach((ship, chunks) -> {
            poseStack.method_22903();
            ShipTransform shipTransform = ship.getRenderTransform();
            Vector3d cameraShipSpace = shipTransform.getWorldToShip().transformPosition(new Vector3d(camX, camY, camZ));
            VSClientGameUtils.transformRenderWithShip(ship.getRenderTransform(), poseStack, cameraShipSpace.x(), cameraShipSpace.y(), cameraShipSpace.z(), camX, camY, camZ);
            VSGameEvents.ShipRenderEvent event = new VSGameEvents.ShipRenderEvent(receiver, renderType, poseStack, camX, camY, camZ, matrix4f, (ClientShip)ship, (ObjectList<class_761.class_762>)chunks);
            VSGameEvents.INSTANCE.getRenderShip().emit(event);
            this.renderChunkLayer(renderType, poseStack, cameraShipSpace.x(), cameraShipSpace.y(), cameraShipSpace.z(), matrix4f, (ObjectList<class_761.class_762>)chunks);
            VSGameEvents.INSTANCE.getPostRenderShip().emit(event);
            poseStack.method_22909();
        });
    }

    @Unique
    private void renderChunkLayer(class_1921 renderType, class_4587 poseStack, double d2, double e2, double f2, Matrix4f matrix4f, ObjectList<class_761.class_762> chunksToRender) {
        RenderSystem.assertOnRenderThread();
        renderType.method_23516();
        this.field_4088.method_16011().method_15396("filterempty");
        this.field_4088.method_16011().method_15403(() -> "render_" + String.valueOf(renderType));
        boolean bl = renderType != class_1921.method_23583();
        ObjectListIterator objectListIterator = chunksToRender.listIterator(bl ? 0 : chunksToRender.size());
        class_5944 shaderInstance = RenderSystem.getShader();
        for (int k2 = 0; k2 < 12; ++k2) {
            int l2 = RenderSystem.getShaderTexture((int)k2);
            shaderInstance.method_34583("Sampler" + k2, (Object)l2);
        }
        if (shaderInstance.field_29470 != null) {
            shaderInstance.field_29470.method_1250(poseStack.method_23760().method_23761());
        }
        if (shaderInstance.field_29471 != null) {
            shaderInstance.field_29471.method_1250(matrix4f);
        }
        if (shaderInstance.field_29474 != null) {
            shaderInstance.field_29474.method_1253(RenderSystem.getShaderColor());
        }
        if (shaderInstance.field_29477 != null) {
            shaderInstance.field_29477.method_1251(RenderSystem.getShaderFogStart());
        }
        if (shaderInstance.field_29478 != null) {
            shaderInstance.field_29478.method_1251(RenderSystem.getShaderFogEnd());
        }
        if (shaderInstance.field_29479 != null) {
            shaderInstance.field_29479.method_1253(RenderSystem.getShaderFogColor());
        }
        if (shaderInstance.field_36373 != null) {
            shaderInstance.field_36373.method_35649(RenderSystem.getShaderFogShape().method_40036());
        }
        if (shaderInstance.field_29472 != null) {
            shaderInstance.field_29472.method_1250(RenderSystem.getTextureMatrix());
        }
        if (shaderInstance.field_29481 != null) {
            shaderInstance.field_29481.method_1251(RenderSystem.getShaderGameTime());
        }
        RenderSystem.setupShaderLights((class_5944)shaderInstance);
        shaderInstance.method_34586();
        class_284 uniform = shaderInstance.field_29482;
        while (!(!bl ? !objectListIterator.hasPrevious() : !objectListIterator.hasNext())) {
            class_761.class_762 renderChunkInfo2;
            class_761.class_762 class_7622 = renderChunkInfo2 = bl ? (class_761.class_762)objectListIterator.next() : (class_761.class_762)objectListIterator.previous();
            class_846.class_851 renderChunk = renderChunkInfo2.field_4124;
            if (renderChunk.method_3677().method_3641(renderType)) continue;
            class_291 vertexBuffer = renderChunk.method_3656(renderType);
            class_2338 blockPos = renderChunk.method_3670();
            if (uniform != null) {
                uniform.method_1249((float)((double)blockPos.method_10263() - d2), (float)((double)blockPos.method_10264() - e2), (float)((double)blockPos.method_10260() - f2));
                uniform.method_1300();
            }
            vertexBuffer.method_1353();
            vertexBuffer.method_35665();
        }
        if (uniform != null) {
            uniform.method_34413(new Vector3f());
        }
        shaderInstance.method_34585();
        class_291.method_1354();
        this.field_4088.method_16011().method_15407();
        renderType.method_23518();
    }
}

