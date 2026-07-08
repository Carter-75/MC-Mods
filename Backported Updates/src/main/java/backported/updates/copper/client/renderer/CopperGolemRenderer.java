/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.EntityModel
 *  net.minecraft.client.render.entity.MobEntityRenderer
 *  net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer
 */
package backported.updates.copper.client.renderer;

import backported.updates.copper.client.model.CopperGolemModel;
import backported.updates.copper.client.renderer.layers.CopperGolemAntennaLayer;
import backported.updates.copper.client.renderer.layers.CopperGolemEyesLayer;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.entity.CopperGolemOxidationLevels;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;

public class CopperGolemRenderer
extends MobEntityRenderer<CopperGolemEntity, CopperGolemModel> {
    public CopperGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new CopperGolemModel(context.getPart(CopperGolemModel.LAYER_LOCATION)), 0.5f);
        this.addFeature(new CopperGolemEyesLayer((FeatureRendererContext<CopperGolemEntity, CopperGolemModel>)this));
        this.addFeature((FeatureRenderer)new HeldItemFeatureRenderer((FeatureRendererContext)this, context.getHeldItemRenderer()));
        this.addFeature(new CopperGolemAntennaLayer((FeatureRendererContext<CopperGolemEntity, CopperGolemModel>)this));
    }

    public Identifier getTexture(CopperGolemEntity entity) {
        return CopperGolemOxidationLevels.getOxidationLevel(entity.getWeatherState()).texture();
    }

    protected void scale(CopperGolemEntity entity, MatrixStack poseStack, float partialTick) {
        poseStack.translate(0.0, 1.5, 0.0);
    }
}

