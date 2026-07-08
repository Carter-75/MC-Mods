/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.WolfEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.WolfEntityModel
 *  net.minecraft.client.render.entity.WolfEntityRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.common.level.entities.animal.WolfDataVariant;
import backported.updates.content.common.api.variant.VariantDataHolder;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.WolfEntityModel;
import net.minecraft.client.render.entity.WolfEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={WolfEntityRenderer.class})
public abstract class WolfRendererMixin
extends MobRendererMixin<WolfEntity, WolfEntityModel<WolfEntity>> {
    public WolfRendererMixin(EntityRendererFactory.Context context, WolfEntityModel<WolfEntity> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"getTexture"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getTextureLocation(WolfEntity entity, CallbackInfoReturnable<Identifier> cir) {
        VariantDataHolder.<WolfDataVariant>getHolder((LivingEntity)entity).getVariantData().ifPresent(variant -> {
            if (entity.isTamed()) {
                cir.setReturnValue(variant.assetInfo().tame().path());
            } else {
                cir.setReturnValue((entity.hasAngerTime() ? variant.assetInfo().angry().path() : variant.assetInfo().wild().path()));
            }
        });
    }
}

