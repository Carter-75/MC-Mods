/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.OverlayTexture
 *  net.minecraft.client.render.entity.model.EntityModelLoader
 */
package backported.updates.content.client.level.entities.layer;

import backported.updates.content.client.level.entities.model.HappyGhastModel;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.EntityModelLoader;

@Environment(value=EnvType.CLIENT)
public class RopesLayer
extends FeatureRenderer<HappyGhast, HappyGhastModel> {
    private final RenderLayer ropes;
    private final HappyGhastModel model;

    public RopesLayer(FeatureRendererContext<HappyGhast, HappyGhastModel> renderer, EntityModelLoader modelSet, Identifier texture) {
        super(renderer);
        this.ropes = RenderLayer.getEntityCutoutNoCull(texture);
        this.model = new HappyGhastModel(modelSet.getModelPart(ModModelLayers.HAPPY_GHAST_ROPES));
    }

    public void render(MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight, HappyGhast entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.isLeashHolder() && entity.isHarnessed()) {
            this.model.setAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            this.model.render(poseStack, buffer.getBuffer(this.ropes), packedLight, OverlayTexture.DEFAULT_UV);
        }
    }
}

