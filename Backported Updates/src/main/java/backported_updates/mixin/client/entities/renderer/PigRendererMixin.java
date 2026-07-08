/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.PigEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.EntityModel
 *  net.minecraft.client.render.entity.model.PigEntityModel
 *  net.minecraft.client.render.entity.PigEntityRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.client.api.renderer.PigVariantRenderer;
import backported.updates.content.client.api.renderer.RenderConditions;
import backported.updates.content.client.api.renderer.SpecialMobRenderer;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.client.render.entity.PigEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={PigEntityRenderer.class})
public abstract class PigRendererMixin
extends MobRendererMixin<PigEntity, PigEntityModel<PigEntity>> {
    @Unique
    private Optional<Supplier<PigVariantRenderer>> renderer;

    public PigRendererMixin(EntityRendererFactory.Context context, PigEntityModel<PigEntity> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void onInit(EntityRendererFactory.Context context, CallbackInfo ci) {
        this.renderer = SpecialMobRenderer.create(context, PigVariantRenderer::new, RenderConditions.FARM_ANIMALS);
    }

    @Inject(method={"getTexture"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getTextureLocation(PigEntity entity, CallbackInfoReturnable<Identifier> cir) {
        this.renderer.flatMap(renderer -> ((PigVariantRenderer)renderer.get()).getTexture(entity)).ifPresent(arg_0 -> cir.setReturnValue(arg_0));
    }

    public void render(PigEntity entity, float entityYaw, float partialTicks, MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight) {
        this.renderer.ifPresent(renderer -> {
            this.model = ((PigVariantRenderer)renderer.get()).getModel(entity).orElseGet(() -> (PigEntityModel)this.defaultModel);
        });
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}

