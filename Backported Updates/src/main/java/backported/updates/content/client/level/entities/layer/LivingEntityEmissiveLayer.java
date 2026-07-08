/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.util.math.ColorHelper$Argb
 *  net.minecraft.client.render.entity.model.SinglePartEntityModel
 *  net.minecraft.client.render.entity.LivingEntityRenderer
 */
package backported.updates.content.client.level.entities.layer;

import java.util.function.Function;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.render.entity.LivingEntityRenderer;

@Environment(value=EnvType.CLIENT)
public class LivingEntityEmissiveLayer<T extends LivingEntity, M extends SinglePartEntityModel<T>>
extends FeatureRenderer<T, M> {
    private final Function<T, Identifier> textureProvider;
    private final AlphaFunction<T> alphaFunction;
    private final M model;
    private final Function<Identifier, RenderLayer> bufferProvider;
    private final boolean alwaysVisible;

    public LivingEntityEmissiveLayer(FeatureRendererContext<T, M> renderer, Function<T, Identifier> textureProvider, AlphaFunction<T> alphaFunction, M model, Function<Identifier, RenderLayer> bufferProvider, boolean alwaysVisible) {
        super(renderer);
        this.textureProvider = textureProvider;
        this.alphaFunction = alphaFunction;
        this.model = model;
        this.bufferProvider = bufferProvider;
        this.alwaysVisible = alwaysVisible;
    }

    public void render(MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        float alpha;
        if ((!entity.isInvisible() || this.alwaysVisible) && (alpha = this.alphaFunction.apply(entity, ageInTicks)) > 1.0E-5f) {
            RenderLayer renderType = this.bufferProvider.apply(this.textureProvider.apply(entity));
            int color = ColorHelper.Argb.getArgb((int)MathHelper.floor((float)(alpha * 255.0f)), (int)255, (int)255, (int)255);
            this.model.animateModel(entity, limbSwing, limbSwingAmount, partialTick);
            this.model.setAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            this.model.render(poseStack, buffer.getBuffer(renderType), packedLight, LivingEntityRenderer.getOverlay(entity, (float)0.0f), color);
            ((SinglePartEntityModel)this.getContextModel()).copyStateTo(this.model);
        }
    }

    @Environment(value=EnvType.CLIENT)
    public static interface AlphaFunction<T extends LivingEntity> {
        public float apply(T var1, float var2);
    }
}

