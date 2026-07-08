/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.OverlayTexture
 */
package backported.updates.copper.client.renderer.layers;

import backported.updates.copper.client.model.CopperGolemModel;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.entity.CopperGolemOxidationLevels;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OverlayTexture;

public class CopperGolemEyesLayer
extends FeatureRenderer<CopperGolemEntity, CopperGolemModel> {
    public CopperGolemEyesLayer(FeatureRendererContext<CopperGolemEntity, CopperGolemModel> renderer) {
        super(renderer);
    }

    public void render(MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight, CopperGolemEntity entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.isInvisible()) {
            return;
        }
        Identifier eyeTexture = CopperGolemOxidationLevels.getOxidationLevel(entity.getWeatherState()).eyeTexture();
        RenderLayer renderType = RenderLayer.getEyes(eyeTexture);
        VertexConsumer vertexConsumer = buffer.getBuffer(renderType);
        ((CopperGolemModel)this.getContextModel()).render(poseStack, vertexConsumer, 0xF000F0, OverlayTexture.DEFAULT_UV, -1);
    }
}

