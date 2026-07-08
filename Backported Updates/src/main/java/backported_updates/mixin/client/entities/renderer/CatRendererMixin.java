/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.CatEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.model.CatEntityModel
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.CatEntityRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.common.level.entities.animal.CatDataVariant;
import backported.updates.content.common.api.variant.VariantDataHolder;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.CatEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.CatEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={CatEntityRenderer.class})
public abstract class CatRendererMixin
extends MobRendererMixin<CatEntity, CatEntityModel<CatEntity>> {
    public CatRendererMixin(EntityRendererFactory.Context context, CatEntityModel<CatEntity> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"getTexture"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getTextureLocation(CatEntity entity, CallbackInfoReturnable<Identifier> cir) {
        VariantDataHolder.<CatDataVariant>getHolder((LivingEntity)entity).getVariantData().ifPresent(variant -> cir.setReturnValue(variant.assetInfo().path()));
    }
}

