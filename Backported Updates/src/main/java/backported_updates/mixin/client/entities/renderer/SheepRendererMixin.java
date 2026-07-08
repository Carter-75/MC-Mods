/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.SheepEntity
 *  net.minecraft.client.render.entity.feature.FeatureRendererContext
 *  net.minecraft.client.render.entity.feature.FeatureRenderer
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.SheepEntityModel
 *  net.minecraft.client.render.entity.SheepEntityRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.client.api.renderer.RenderConditions;
import backported.updates.content.client.api.renderer.SpecialMobRenderer;
import backported.updates.content.client.level.entities.layer.SheepWoolUndercoatLayer;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.client.render.entity.SheepEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={SheepEntityRenderer.class})
public abstract class SheepRendererMixin
extends MobRendererMixin<SheepEntity, SheepEntityModel<SheepEntity>> {
    public SheepRendererMixin(EntityRendererFactory.Context context, SheepEntityModel<SheepEntity> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void onInit(EntityRendererFactory.Context context, CallbackInfo ci) {
        SpecialMobRenderer.create(context, ctx -> new SheepWoolUndercoatLayer((FeatureRendererContext<SheepEntity, SheepEntityModel<SheepEntity>>)this, ctx.getModelLoader()), RenderConditions.SHEEP_UNDERCOAT).ifPresent(layer -> this.addFeature((FeatureRenderer)layer.get()));
    }
}

