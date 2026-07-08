/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.entity.passive.FrogEntity
 *  net.minecraft.client.render.entity.model.FrogEntityModel
 *  net.minecraft.client.render.entity.FrogEntityRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.common.level.entities.animal.FrogDataVariant;
import backported.updates.content.common.api.variant.VariantDataHolder;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.client.render.entity.model.FrogEntityModel;
import net.minecraft.client.render.entity.FrogEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={FrogEntityRenderer.class})
public abstract class FrogRendererMixin
extends MobRendererMixin<FrogEntity, FrogEntityModel<FrogEntity>> {
    public FrogRendererMixin(EntityRendererFactory.Context context, FrogEntityModel<FrogEntity> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"getTexture"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getTextureLocation(FrogEntity entity, CallbackInfoReturnable<Identifier> cir) {
        VariantDataHolder.<FrogDataVariant>getHolder((LivingEntity)entity).getVariantData().ifPresent(variant -> cir.setReturnValue(variant.assetInfo().path()));
    }
}

